package cn.com.yusys.yscrm.cust.person.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFevtLoanLnsacctlist;
import cn.com.yusys.yscrm.cust.person.domain.OcrmAciReportApply;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFevtLoanLnsacctListMapper
 * @类描述: #Dao类
 * @功能描述: 账户信息-贷款账户交易流水
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:41:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFevtLoanLnsacctListMapper extends CommonMapper<AcrmFevtLoanLnsacctlist> {
	
	List<Map<Object, String>> queryLoanLnsacctListByCustId(QueryModel model);
	List<OcrmAciReportApply> getParams(String bizseqno);
	
}