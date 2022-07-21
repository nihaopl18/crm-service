package cn.com.yusys.yscrm.custmgrgroup.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmMktTeam;

/**
 * @项目名称: yscrm-entity-cust-mgr-group-core模块
 * @类名称: OcrmFcmMktTeamMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 09:58:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFcmMktTeamMapper extends CommonMapper<OcrmFcmMktTeam> {
	List<Map<String, Object>> queryList(QueryModel queryModel);
	List<Map<String, Object>> queryInfo(@Param("mktTeamId") String mktTeamId);
	List<Map<String, Object>> queryCustList(QueryModel queryModel);

    String selectMaxmktTeamId();
}