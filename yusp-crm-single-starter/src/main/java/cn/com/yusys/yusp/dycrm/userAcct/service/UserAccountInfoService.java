package cn.com.yusys.yusp.dycrm.userAcct.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.userAcct.domain.BaseInfo;
import cn.com.yusys.yusp.dycrm.userAcct.domain.TeamUserInfo;
import cn.com.yusys.yusp.dycrm.userAcct.repository.mapper.UserAccountInfoMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: dycrm-userAcct模块
 * @类名称: UserAccountInfoService
 * @类描述: #数据访问类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-25 11:29:11
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class UserAccountInfoService extends CommonService {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserAccountInfoMapper userAccountInfoMapper;

    @Override
    protected CommonMapper getMapper() {
        return userAccountInfoMapper;
    }

    public BaseInfo getBaseInfo(String userId) {
       BaseInfo baseinfo = userAccountInfoMapper.getBaseInfo(userId);
       baseinfo.setRoles(userAccountInfoMapper.getRoles(userId));
       return baseinfo;
    }

    public Map<String, Object> getTeamInfo(QueryModel model) {
        Map<String,Object> map = new HashMap<String,Object>();
        TeamUserInfo teamLeader =userAccountInfoMapper.getTeamLeader(model);
        String userId = (String) model.getCondition().get("userId");
        if (teamLeader!=null && !userId.equals(teamLeader.getUserId())){
            teamLeader.setRoles(userAccountInfoMapper.getRoles(teamLeader.getUserId()));
            model.getCondition().put("teamLeader",teamLeader.getUserId());
            map.put("teamLeader",teamLeader);
        }
        PageHelper.startPage(model.getPage(), model.getSize());
        List<TeamUserInfo> list = userAccountInfoMapper.getTeamUser(model);
        PageHelper.clearPage();
        for (TeamUserInfo teamUserInfo:list) {
            teamUserInfo.setRoles(userAccountInfoMapper.getRoles(teamUserInfo.getUserId()));
        }
        map.put("teamUser",list);
        return map;
    }

    public Map<String, Object> contactDetails(String loginCode) {
        return userAccountInfoMapper.contactDetails(loginCode);
    }

    public Integer saveDetails(BaseInfo baseInfo) {
        return userAccountInfoMapper.saveDetails(baseInfo);
    }

    public int checkUpName(String loginCode) {
        return userAccountInfoMapper.checkUpName(loginCode);
    }

    public int updateUserInfo(String loginCode) {
        return userAccountInfoMapper.updateUserInfo(loginCode);
    }

    public int checkUpNameName(String roleCode) {
        return userAccountInfoMapper.checkUpNameName(roleCode);
    }

    public int updateRoleInfo(String roleCode) {
        return userAccountInfoMapper.updateRoleInfo(roleCode);
    }
    /**
     *
     * @方法名称: findAllByParam
     * @方法描述: 分页查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findAllByParam(QueryModel param) {
        // 设置分页查询参数(设置到线程变量中了)
        PageHelper.startPage(param.getPage(), param.getSize());
        param.setSort("last_chg_dt desc");
        List<Map<String, Object>> result = this.userAccountInfoMapper.queryUserByPage(param);
        PageHelper.clearPage();
        return result;
    }

    public Map<String,Object>  selectOrg(String loginCode) {
        return userAccountInfoMapper.loginCode(loginCode);
    }
}
