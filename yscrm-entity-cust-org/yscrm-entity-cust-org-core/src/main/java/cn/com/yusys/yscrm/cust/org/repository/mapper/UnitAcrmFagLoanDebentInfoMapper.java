package cn.com.yusys.yscrm.cust.org.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFagLoanDebentInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagLoanDebentInfoMapper
 * @类描述: #Dao类
 * @功能描述: 账户信息-对公贷款账户信息
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:32:25
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface UnitAcrmFagLoanDebentInfoMapper extends CommonMapper<AcrmFagLoanDebentInfo> {
	
	List<Map<Object, String>> querylist(Map<?, ?> param);

	Map<String, String> getMgrType(Map<String, String> map);
	
}