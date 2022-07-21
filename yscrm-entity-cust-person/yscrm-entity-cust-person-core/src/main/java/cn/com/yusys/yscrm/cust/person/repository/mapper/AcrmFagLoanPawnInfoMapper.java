package cn.com.yusys.yscrm.cust.person.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFagLoanPawnInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagLoanPawnInfoMapper
 * @类描述: #Dao类
 * @功能描述: 担保信息-抵押物信息
 * @创建人: 15104
 * @创建时间: 2019-02-11 14:12:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFagLoanPawnInfoMapper extends CommonMapper<AcrmFagLoanPawnInfo> {
	
	List<Map<Object, String>> querylist(Map<?, ?> param);
}