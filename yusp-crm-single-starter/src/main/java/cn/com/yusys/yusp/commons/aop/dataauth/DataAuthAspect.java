package cn.com.yusys.yusp.commons.aop.dataauth;

import cn.com.yusys.yusp.commons.aop.dataauth.excepton.DataAuthException;
import cn.com.yusys.yusp.commons.aop.dataauth.handler.DataAuthParamHander;
import cn.com.yusys.yusp.commons.mapper.interceptor.DataAuthHandler;
import cn.com.yusys.yusp.dataauth.service.DataRightCacheService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.DataContrDTO;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uaa.security.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @项目名称: npam
 * @类名称: DataAuthAspect
 * @类描述: 数据权限AOP
 * @功能描述: 过滤所有的请求，将对应的数据权限相关信息绑定到线程变量
 * @创建人:
 * @创建时间: 2018-01-17 09:41
 * @修改备注: 修改时间    修改人员    修改原因 <br/>
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Aspect
@Component
public class DataAuthAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(DataAuthAspect.class);

    public static final String POINTCUT_EXPRESS = "within(cn.com.yusys..*.web.rest..*) && "
        + "(@target(org.springframework.web.bind.annotation.RestController) || @target(org.springframework.stereotype.Controller))";

    @Autowired
    private DataRightCacheService dataRightCacheService;

    @Resource
    UaaClient uaaClient;

    private DataAuthParamHander dataAuthParamHander;

    public DataAuthAspect(DataAuthParamHander dataAuthParamHander) {
        super();
        this.dataAuthParamHander = dataAuthParamHander;
    }


    @Pointcut(POINTCUT_EXPRESS)
    public void pointcut() {
    }

    /**
     * @方法名称: before
     * @方法描述: 在Controller方法执行前从请求头中获取数据权限相关信息，
     *            并绑定到线程变量中。
     * @参数与返回说明: 
     * @算法描述: 无
     */
    @Before("pointcut()")
    public void before(JoinPoint point) {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes(); 
            if (requestAttributes != null) {
                String loginCode = SecurityUtils.getCurrentUserLogin();
                String accessToken = SecurityUtils.getCurrentUserToken();
                        accessToken = "Bearer"+" "+accessToken;
                HttpServletRequest request = requestAttributes.getRequest();
                String requestUri = request.getRequestURI();
                String selectRole = request.getHeader("selectRole");
                // 截取url(去掉server名)
				requestUri = requestUri.substring(requestUri.indexOf("/", 2), requestUri.length());
                ResponseEntity<UserInfoDTO> result = uaaClient.getUserSessionInfo("Bearer"+" "+accessToken);
                UserInfoDTO userInfo =  result.getBody();
                DataContrDTO dataContrDTO = dataRightCacheService.getDataContrl(loginCode,accessToken,requestUri,selectRole);
                if(dataContrDTO==null){
                    LOGGER.debug("数据权限模板或者参数不存在,不进行数据权限处理");
                }else{
                    if(!StringUtils.isEmpty(dataContrDTO.getSqlString())){
                        DataAuthHandler.dataAuthTemplate.set(dataContrDTO.getSqlString());
                        DataAuthHandler.dataAuthParams.set(getAuthParams(userInfo));
                    }
                }

            } else {
                LOGGER.debug("无法获取http请求,不进行数据权限处理");
            }
        } catch (Exception e) {
            throw new DataAuthException(e);
        }
    }

    /**
     * @方法名称: after
     * @方法描述: 在Controller方法执行结束后清除线程变量信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
    @After("pointcut()")
    public void after(JoinPoint point) {
        DataAuthHandler.dataAuthTemplate.remove();
        DataAuthHandler.dataAuthParams.remove();
    }



    private Map<String, Object> getAuthParams(UserInfoDTO userInfo) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            dataMap.put("_userCode", userInfo.getLoginCode());
            dataMap.put("_orgCode", userInfo.getOrg().getCode());
            LOGGER.debug("用户[{}]使用数据模板参数为: {}", userInfo.getLoginCode(), dataMap);
        } catch (Exception e) {
            LOGGER.error("数据权限模板参数获取异常", e);
        }
        return dataMap;
    }

}
