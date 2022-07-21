package cn.com.yusys.yusp.admin.service.impl;

import cn.com.yusys.yusp.admin.repository.mapper.UaaMenuContrDataInfoMapper;
import cn.com.yusys.yusp.admin.service.UaaMenuContrDataInfoService;
import cn.com.yusys.yusp.uaa.client.dto.*;
import cn.com.yusys.yusp.uaa.domain.UaaMenuContrDataConfig;
import cn.com.yusys.yusp.uaa.domain.UaaOrg;
import cn.com.yusys.yusp.uaa.domain.UaaUser;
import cn.com.yusys.yusp.uaa.repository.mapper.*;
import cn.com.yusys.yusp.uaa.service.mapper.MenuContrDataConfigMapper;
import cn.com.yusys.yusp.uaa.service.mapper.UaaUserInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: yusp-uaa
 * @类名称: UaaUserServiceImpl
 * @类描述:   东亚银行CRM项目--角色切换后，需要根据切换的角色刷新用户信息缓存和对应角色的菜单和数据权限
 * @功能描述: 角色切换后，需要根据切换的角色刷新用户信息缓存和对应角色的菜单和数据权限
 * @创建人: geql@yusys.com.cn
 * @创建时间: 2018-02-02 15:01
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service("uaaUserInfoService")
@Transactional
public class UaaMenuCOntrDataInfoServiceImpl implements UaaMenuContrDataInfoService {
    private final Logger log = LoggerFactory.getLogger(UaaMenuCOntrDataInfoServiceImpl.class);

    @Autowired
    private UaaUserMapper uaaUserMapper;
    @Autowired
    private UaaDptMapper uaaDptMapper;
    @Autowired
    private UaaOrgMapper uaaOrgMapper;
    @Autowired
    private UaaLogicSysMapper uaaLogicSysMapper;
    @Autowired
    private UaaMenuContrDataInfoMapper uaaMenuContrDataConfigMapper;
    @Autowired
    private MenuContrDataConfigMapper menuMapper;
    @Autowired
    private UaaUserInfoMapper userInfoMapper;

    @Override
    public UserInfoDTO getUserInfo(String loginCode, String sysId, String roleId) {
        UaaUser user = uaaUserMapper.selectUserWithRoles(loginCode);
        UserInfoDTO userInfo = userInfoMapper.from(user);
        if (user == null) {
            log.debug("用户[{}]不存在", loginCode);
        } else {
            /*查询上级部门*/
            if (user.getDpt() != null && user.getDpt().getUpDptId() != null) {
                ObjBean updpt = Optional.ofNullable(uaaDptMapper.selectById(user.getDpt().getUpDptId()))
                        .map(dpt -> new ObjBean(dpt.getDptId(), dpt.getDptCde(), dpt.getDptName())).orElseGet(() -> {
                            log.debug("用户[{}]所属部门[{}]的上级部门不存在", loginCode, user.getDpt().getDptCde());
                            return new ObjBean();
                        });
                userInfo.setUpDpt(updpt);
            }


            /*查询上级机构和金融机构*/
            if (user.getOrg() != null) {
                UaaOrg uaaOrg = user.getOrg();
                if (uaaOrg.getUpOrgId() != null) {
                    ObjBean upOrg = Optional.ofNullable(uaaOrgMapper.selectById(uaaOrg.getUpOrgId()))
                            .map(org -> new ObjBean(org.getOrgId(), org.getOrgCode(), org.getOrgName())).orElseGet(() -> {
                                log.debug("用户[{}]所属机构[{}]的上级机构不存在", loginCode, uaaOrg.getOrgCode());
                                return new ObjBean();
                            });
                    userInfo.setUpOrg(upOrg);
                }
                if (uaaOrg.getInstuId() != null) {
                    ObjBean uaaInstu = Optional.ofNullable(uaaOrgMapper.selectInstuByIdAndSysId(uaaOrg.getInstuId(), sysId))
                            .map(instu -> new ObjBean(instu.getInstuId(), instu.getInstuCde(), instu.getInstuName())).orElseGet(() -> {
                                log.debug("用户[{}]所属机构[{}]的金融机构不存在", loginCode, uaaOrg.getOrgCode());
                                return new ObjBean();
                            });
                    userInfo.setInstu(uaaInstu);
                }
            }
            /*查询逻辑系统*/
            if (StringUtils.isNotBlank(sysId)) {
                ObjBean logicSys = Optional.ofNullable(uaaLogicSysMapper.selectById(sysId))
                        .map(sys -> new ObjBean(sysId, "", sys.getSysName())).orElseGet(() -> {
                            log.debug("逻辑系统[{}]查询信息为空，当前用户[{}]", sysId, loginCode);
                            return new ObjBean();
                        });
                userInfo.setLogicSys(logicSys);
            } else {
                log.debug("当前用户[{}]传入sysId为空", loginCode);
            }
        }
        if (StringUtils.isNotEmpty(userInfo.getOrg().getCode())) {
        if (userInfo.getOrg().getCode().endsWith("00") && userInfo.getOrg().getCode().length() > 3) {
            userInfo.getOrg().setCode(userInfo.getOrg().getCode().substring(0, 2));
        }
    }
        //角色切换后需要把切换的角色放入redis缓存
        //userInfo.getMap().put("selectRole",roleId);
        Map<String, Object> map =new HashMap<>();
        map.put("selectRole",roleId);
        userInfo.setMap(map);
        return userInfo;
    }

    @Override
    public MenuContrDTO getMenuandContr(UserInfoDTO userInfo,String roleId) {
        MenuContrDTO menuContrDTO = new MenuContrDTO();

        if(userInfo==null){
            log.error("传入用户信息参数为null,无法查询用户菜单控制点信息");
        }else {
            String sysId = userInfo.getLogicSys()!=null?userInfo.getLogicSys().getId():null;
            String loginCode= userInfo.getLoginCode();
           /*sysId为null，则查询所有的数据*/
            List<UaaMenuContrDataConfig> menuList = uaaMenuContrDataConfigMapper.selectMenuTree(loginCode, sysId,roleId);
            List<UaaMenuContrDataConfig> contrList = uaaMenuContrDataConfigMapper.selectContrList(loginCode, sysId,roleId);
            if (null != menuList) {
                List<MenuBean> menu = menuMapper.menuListFromMenuConfigList(menuList);
                menuContrDTO.setMenu(menu);
            } else {
                log.debug("用户{}没有被授权的菜单信息", loginCode);
            }

            if (null != contrList) {
                List<ContrBean> contr = menuMapper.contrListFromMenuConfigList(contrList);
                menuContrDTO.setContr(contr);
            } else {
                log.debug("用户{}没有被授权的控制点信息", loginCode);
            }
        }
        return menuContrDTO;
    }

    @Override
    public List<DataContrDTO> getDataContr(UserInfoDTO userInfo,String roleId) {
        List<DataContrDTO> dataContr=new ArrayList<>();
        if(userInfo==null){
            if(log.isDebugEnabled()){
                log.debug("传入参数为null,无法查询用户数据权限信息");
            }
        }else {
            String sysId = userInfo.getLogicSys()!=null?userInfo.getLogicSys().getId():null;
            String loginCode= userInfo.getLoginCode();
            List<UaaMenuContrDataConfig> dataContrList = uaaMenuContrDataConfigMapper.selectDataContrList(loginCode, sysId,roleId);
            dataContr = menuMapper.dataContrListFromMenuConfigList(dataContrList);

            if (null == dataContrList || dataContrList.size() == 0) {
                log.debug("用户{}没有被授权的数据权限信息", loginCode);
            }

        }

        return dataContr;
    }
}
