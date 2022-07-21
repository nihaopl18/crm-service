package cn.com.yusys.yscrm.entity.cust.org.group.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroupMember;

/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupMemberMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:12:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciGroupMemberMapper extends CommonMapper<OcrmFciGroupMember> {

	List<Map<String, String>> getListByModel(QueryModel model);

	Map<String, String> getGroupInfoByGroupNo(String groupNo);
	
}