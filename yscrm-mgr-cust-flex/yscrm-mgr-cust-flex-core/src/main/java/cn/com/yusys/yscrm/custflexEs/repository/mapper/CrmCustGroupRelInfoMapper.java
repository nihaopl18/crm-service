/*
 * 代码生成器自动生成的
 * Since 2008 - 2020
 *
 */
package cn.com.yusys.yscrm.custflexEs.repository.mapper;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustGroupRelInfo;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustGroupRelInfoMapper
 * @类描述: #客户群成员信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-08 15:12:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CrmCustGroupRelInfoMapper {

	CrmCustGroupRelInfo selectByCustIdAndGroupId(@Param("groupId") String groupId, @Param("custId") String custId);

	Integer insertRelInfo(@Param("groupId") String groupId, @Param("custId") String custId, @Param("joinDate") Date joinDate);

	Integer deleteByGroupId(@Param("groupId") String groupId);

	List<Map<String, Object>> queryGroupMember(QueryModel model);

	Integer removeCustsFromCustGroup(@Param("groupId") String groupId, @Param("custIds") String[] custIds);

}