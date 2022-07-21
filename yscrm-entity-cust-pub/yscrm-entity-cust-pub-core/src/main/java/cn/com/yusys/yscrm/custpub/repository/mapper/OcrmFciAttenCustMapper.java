package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciAttenCust;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciAttenCustMapper
 * @类描述: 关注客户Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-28 17:25:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciAttenCustMapper extends CommonMapper<OcrmFciAttenCust> {

	List<Map<String, String>> getListByModel(QueryModel model);

	List<AcrmFciCustAdmitAll> getCustsById(List<String> lists);

	int checkIsAttent(String custId);

	int deleteByCustIdAndUserId(@Param("custId") String custId,@Param("userId") String userId);
	
}