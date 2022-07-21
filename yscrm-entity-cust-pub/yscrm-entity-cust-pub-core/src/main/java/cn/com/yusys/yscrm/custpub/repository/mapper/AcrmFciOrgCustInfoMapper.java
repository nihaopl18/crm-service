package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yscrm-entity-cust-pub模块
 * @类名称: AcrmFciOrgCustInfoMapper
 * @类描述: 对公客户基本信息（准入非准入）
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-29 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciOrgCustInfoMapper extends CommonMapper<AcrmFciOrgCustInfo> {

	int updateBelong(Map<String, String> record);

	Map<String, Object> getCustByCustId(String custId);
	
}
