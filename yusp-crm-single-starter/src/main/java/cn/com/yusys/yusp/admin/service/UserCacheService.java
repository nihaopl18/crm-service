package cn.com.yusys.yusp.admin.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import cn.com.yusys.yusp.uaa.client.dto.ContrBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.DataContrDTO;
import cn.com.yusys.yusp.uaa.client.dto.MenuContrDTO;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @version 1.0.0
 * @项目名称: yusp-gateway
 * @类名称: TestService
 * @类描述:
 * @功能描述:
 * @创建人: geql@yusys.com.cn
 * @创建时间: 2017-12-2017/12/21 14:54
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class UserCacheService {
    private final Logger log = LoggerFactory.getLogger(UserCacheService.class);

	@Resource UaaClient uaaClient;
    /**
     * @方法名称: getUserInfo
     * @方法描述: 获取缓存中的用户信息
     * @参数与返回说明:
     * @算法描述: 从缓存中获取不到时，调用uaa方法重新查询,避免出现null
     */
    @Cacheable(value = "sessionInfo", key = "#accessToken")
    public UserInfoDTO getUserInfo(String accessToken, String loginCode) {
        UserInfoDTO userInfo = new UserInfoDTO();
        ResponseEntity<UserInfoDTO> result = uaaClient.getUserSessionInfo("Bearer"+" "+accessToken);
        if(result==null){
            log.error("从缓存获取用户[{}]会话信息失败", loginCode);
        }else {
            userInfo=result.getBody();
        }
        return userInfo;
    }

    /**
     * @方法名称: findAllOfContrUrl
     * @方法描述: 从缓存中获取所有控制点URL
     * @参数与返回说明:
     * @算法描述:
     */
    @Cacheable(value = "contrurl", key = "#root.methodName")
    public List<ContrBean> findAllOfContrUrl(String accessToken) {
        List<ContrBean> allContrUrl = new ArrayList<>();
        ResponseEntity<List<ContrBean>> result = uaaClient.getAllContrUrl("Bearer"+" "+accessToken);
        if(result==null){
            log.error("从缓存获取所有需要控制点URL失败");
        }else{
            allContrUrl=result.getBody();
        }
        return allContrUrl;
    }

    /**
     * @方法名称: getMenuandContr
     * @方法描述: 从缓存中获取用户被授权的菜单和控制点
     * @参数与返回说明:
     * @算法描述: 从缓存中获取不到时，调用uaa方法重新查询,避免出现null
     */
    @Cacheable(value = "sessionInfo", key = "'menuandContr_'+#accessToken")
    public MenuContrDTO getMenuandContr(String accessToken, String loginCode) {
        MenuContrDTO menuContr = new MenuContrDTO();
        ResponseEntity<MenuContrDTO> result = uaaClient.getUserMenuandContr("Bearer"+" "+accessToken);
        if(result==null){
            log.error("从缓存获取用户[{}]菜单和控制点信息失败", loginCode);
        }else{
            menuContr=result.getBody();
        }
        return menuContr;
    }

    /**
     * @方法名称: getDataContr
     * @方法描述: 获取用户数据权限信息，放入缓存
     * @参数与返回说明: 用户放入session中的信息；
     * @算法描述:
     */
    @Cacheable(value = "sessionInfo", key = "'dataContr_'+#accessToken")
    public List<DataContrDTO> getDataContr(String accessToken, String loginCode) {
        List<DataContrDTO> dataContr = new ArrayList<>();
        ResponseEntity<List<DataContrDTO>> result = uaaClient.getUserDataContr("Bearer"+" "+accessToken);
        if(result==null){
            log.error("从缓存获取用户[{}]数据权限信息失败", loginCode);
        }else{
            dataContr=result.getBody();
        }
        return dataContr;
    }

}
