package cn.com.yusys.yscrm.custflexEs.repository.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustGroupInfo;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustGroupInfoMapper
 * @类描述: #客户群信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-08 11:13:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CrmCustGroupInfoMapper extends CommonMapper<CrmCustGroupInfo> {

	List<Map<String, Object>> queryList(QueryModel model);

	Integer updateActivityExpiryDate(@Param("groupId") String groupId, @Param("newActivityExpiryDate") Date newActivityExpiryDate);
	
	List<Map<String, Object>> queryToJoinCustGroupList(QueryModel model);
}