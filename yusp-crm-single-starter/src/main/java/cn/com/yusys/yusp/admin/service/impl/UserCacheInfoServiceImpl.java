package cn.com.yusys.yusp.admin.service.impl;

import cn.com.yusys.yusp.admin.service.UaaMenuContrDataInfoService;
import cn.com.yusys.yusp.admin.service.UserCacheInfoService;
import cn.com.yusys.yusp.uaa.client.dto.DataContrDTO;
import cn.com.yusys.yusp.uaa.client.dto.MenuContrDTO;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hujun3
 * @version 1.0.0
 * @项目名称: yusp-uaa
 * @类名称: CacheServiceImpl
 * @类描述:  东亚银行CRM项目
 * @功能描述:
 * @创建人: geql@yusys.com.cn
 * @创建时间: 2018-01-31 14:18
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
@Transactional
public class UserCacheInfoServiceImpl implements UserCacheInfoService {
    private final Logger log = LoggerFactory.getLogger(UserCacheInfoServiceImpl.class);

    @Autowired
    private UaaMenuContrDataInfoService uaaMenuContrDataInfoService;

    @Override
    @CachePut(value = "sessionInfo", key = "#accessToken")
    public UserInfoDTO getUserInfo(String loginCode, String sysId, String accessToken, String roleId) {
        return uaaMenuContrDataInfoService.getUserInfo(loginCode, sysId, roleId);
    }


    @Override
    @CachePut(value = "sessionInfo", key = "'menuandContr_'+#accessToken")
    public MenuContrDTO getMenuandContr(UserInfoDTO userInfo, String accessToken,String roleId) {
        return uaaMenuContrDataInfoService.getMenuandContr(userInfo,roleId);
    }

    @Override
    @CachePut(value = "sessionInfo", key = "'dataContr_'+#accessToken")
    public List<DataContrDTO> getDataContr(UserInfoDTO userInfo, String accessToken,String roleId) {
        return uaaMenuContrDataInfoService.getDataContr(userInfo,roleId);
    }

}
