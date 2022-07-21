package cn.com.yusys.yusp.admin.service.impl;

import cn.com.yusys.yusp.admin.service.AccessService;
import cn.com.yusys.yusp.admin.service.UserCacheService;
import cn.com.yusys.yusp.uaa.client.dto.ContrBean;
import cn.com.yusys.yusp.uaa.client.dto.MenuContrDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0.0
 * @项目名称: yusp-gateway-core
 * @类名称: AccessServiceImpl
 * @类描述:
 * @功能描述:
 * @创建人: geql@yusys.com.cn
 * @创建时间: 2018-02-11 10:37
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service("accessService")
public class AccessServiceImpl implements AccessService {
	
    private final Logger log = LoggerFactory.getLogger(AccessServiceImpl.class);

    @Resource
    private UserCacheService userCacheService;
    
    private AntPathMatcher matcher = new AntPathMatcher();
    
    /**
    * @属性名称:needAuthUrls
    * @属性描述:本地存储
    * @since 1.0.0
    */
    private List<ContrBean> needAuthUrls=null;
    /**
    * @属性名称:lastRefresh
    * @属性描述:上次刷新时间
    * @since 1.0.0
    */
    private long lastRefresh=System.currentTimeMillis();

    @Override
    public boolean isAuthorizedContrUrl(String loginCode, String requestUri, Object token) {
        boolean isAuthorized = false;
        if (token == null) {
            log.debug("用户[{}]授权信息未获得:", loginCode, requestUri);
        }else{
            String accessToken = token.toString();
            // TODO:控制点需要加上服务名，大大减少比较次数
		/* 判断用户是否获得uri访问授权 */
//            MenuContrDTO menucontr = userCacheService.getMenuandContr(accessToken, loginCode);
//            List<ContrBean> contrList = menucontr.getContr();
//            if (contrList != null && contrList.size() > 0) {
//                isAuthorized = contrList.stream().filter(ctrl -> {
//                    AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(
//                        serviceName + ctrl.getContrUrl(), ctrl.getMethodType());
//                    return antPathRequestMatcher.matches(request);
//                }).count() > 0;
//            }
//
//		/* 判断uri是否是需要授权 */
//            if (!isAuthorized) {
//                List<ContrBean> needAuthUrls = userCacheService.findAllOfContrUrl(accessToken);// uri访问需要授权的控制点
//                boolean requestUriNeedAuth = needAuthUrls.stream().filter(ctrl -> {
//                    AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(
//                        serviceName + ctrl.getContrUrl(), ctrl.getMethodType());
//                    return antPathRequestMatcher.matches(request);
//                }).count() > 0;
//                if (!requestUriNeedAuth) {
//                    isAuthorized = true;
//                }
//            }
            
            
            
            /*2018-05-28,性能调整
             * 前提:不是所有的URL都需要控制，不是所有的用户都配置了访问授权。没有配置的占绝大多数
             * 1.调整控制策略，先判断URL是否需要授权,如果没配，直接通过
             * 2.使用AntPathMatcher 简化匹配
             * 3.URL控制点使用内存存储，不需要每次请求缓存,每格1分钟再重缓存中获取新的
             */
            /* 判断uri是否是需要授权 */
            if(needAuthUrls==null || System.currentTimeMillis()-lastRefresh>60000) {
            	needAuthUrls = userCacheService.findAllOfContrUrl(accessToken);// uri访问需要授权的控制点
            	lastRefresh=System.currentTimeMillis();
            }
            boolean requestUriNeedAuth = needAuthUrls.stream().anyMatch(ctrl -> {
                return matcher.match(ctrl.getContrUrl(), requestUri);
            });

            /* 判断用户是否获得uri访问授权 */
            if (requestUriNeedAuth) {
            	 MenuContrDTO menucontr = userCacheService.getMenuandContr(accessToken, loginCode);
                 List<ContrBean> contrList = menucontr.getContr();
                 if (contrList != null && contrList.size() > 0) {
                     isAuthorized = contrList.stream().anyMatch(ctrl -> {
                    	 return Objects.nonNull(ctrl.getContrUrl()) && matcher.match(ctrl.getContrUrl(), requestUri);
                     });
                 }
            }else {
            	isAuthorized = true;
            }
        }

        return isAuthorized;
    }
}
