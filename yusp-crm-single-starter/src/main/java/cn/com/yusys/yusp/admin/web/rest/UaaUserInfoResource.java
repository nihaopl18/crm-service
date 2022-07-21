package cn.com.yusys.yusp.admin.web.rest;

import cn.com.yusys.yusp.admin.service.UserCacheInfoService;
import cn.com.yusys.yusp.uaa.client.dto.*;
import cn.com.yusys.yusp.uaa.security.SecurityUtils;
import com.codahale.metrics.annotation.Timed;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0.0
 * @项目名称: yusp-uaa
 * @类名称: AdminSmUserResource
 * @类描述: 用户信息相关的资源  --东亚银行CRM项目--角色角色切换
 * @功能描述:
 * @创建人: geql@yusys.com.cn
 * @创建时间: 2017-12-2017/12/13 15:06
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/session")
public class UaaUserInfoResource {
    private final Logger log = LoggerFactory.getLogger(UaaUserInfoResource.class);

    @Resource
    private UserCacheInfoService userCacheInfoService;
    /**
     * @方法名称: getUserSessionInfo
     * @方法描述: 获取用户基本信息
     * @param roleId 选择角色
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping(value = "/userinfo")
    @Timed
    public ResponseEntity<UserInfoDTO> getUserSessionInfo(@RequestParam("roleId") String roleId) {
        String accessToken = SecurityUtils.getCurrentUserToken();
        if (StringUtils.isEmpty(accessToken)) {
            log.debug("用户授权信息获取失败:", accessToken);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }else {
            String loginCode = SecurityUtils.getCurrentUserLogin();
            String sysId = SecurityUtils.getCurrentUserLoginSYS();
            return new ResponseEntity<UserInfoDTO>(userCacheInfoService.getUserInfo(loginCode, sysId, accessToken,roleId), HttpStatus.OK);
        }

    }

    /**
     * @方法名称: getUserMenuandContr
     * @方法描述: 获取用户菜单和控制点
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/menuandcontr")
    @Timed
    public ResponseEntity<MenuContrDTO> getUserMenuAndContr(@RequestParam("roleId") String roleId) {
        String accessToken = SecurityUtils.getCurrentUserToken();
        if (StringUtils.isEmpty(accessToken)) {
            log.debug("用户授权信息获取失败:", accessToken);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }else {
            String loginCode = SecurityUtils.getCurrentUserLogin();
            String sysId = SecurityUtils.getCurrentUserLoginSYS();
            UserInfoDTO user = new UserInfoDTO();
            ObjBean logicSys = new ObjBean(sysId, "", "");
            user.setLoginCode(loginCode);
            user.setLogicSys(logicSys);
            return new ResponseEntity<>(userCacheInfoService.getMenuandContr(user, accessToken,roleId), HttpStatus.OK);
        }
    }

    /**
     * @方法名称: getUserDataContr
     * @方法描述: 获取用户数据控制权限
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/datacontr")
    @Timed
    public ResponseEntity<List<DataContrDTO>> getUserDataContr(@RequestParam("roleId") String roleId) {
        String accessToken = SecurityUtils.getCurrentUserToken();
        if (StringUtils.isEmpty(accessToken)) {
            log.debug("用户授权信息获取失败:", accessToken);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }else {
            String loginCode = SecurityUtils.getCurrentUserLogin();
            String sysId = SecurityUtils.getCurrentUserLoginSYS();
            UserInfoDTO user = new UserInfoDTO();
            ObjBean logicSys = new ObjBean(sysId, "", "");
            user.setLoginCode(loginCode);
            user.setLogicSys(logicSys);
            return new ResponseEntity<>(userCacheInfoService.getDataContr(user, accessToken,roleId), HttpStatus.OK);
        }
    }

}
