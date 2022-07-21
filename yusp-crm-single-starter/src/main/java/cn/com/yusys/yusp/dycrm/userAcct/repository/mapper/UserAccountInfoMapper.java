package cn.com.yusys.yusp.dycrm.userAcct.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.AcrmFagTranDetail;
import cn.com.yusys.yusp.dycrm.userAcct.domain.BaseInfo;
import cn.com.yusys.yusp.dycrm.userAcct.domain.TeamUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: dycrm-userAcct模块
 * @类名称: UserAccountInfoMapper
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-25 11:35:50
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface UserAccountInfoMapper  extends CommonMapper<AcrmFagTranDetail> {
    BaseInfo getBaseInfo(@Param("userId") String userId);

    List<Map<String, Object>> getRoles(@Param("userId") String userId);

    TeamUserInfo getTeamLeader(QueryModel model);

    List<TeamUserInfo> getTeamUser(QueryModel model);

    Map<String, Object> contactDetails(@Param("loginCode") String loginCode);

    Integer saveDetails(BaseInfo baseInfo);

    int checkUpName(@Param("loginCode") String loginCode);

    int updateUserInfo(@Param("loginCode")  String loginCode);

    int checkUpNameName(@Param("roleCode") String roleCode);

    int updateRoleInfo(@Param("roleCode") String roleCode);

    List<Map<String, Object>> queryUserByPage(QueryModel param);

    Map<String,Object>  loginCode(@Param("loginCode") String loginCode);
}
