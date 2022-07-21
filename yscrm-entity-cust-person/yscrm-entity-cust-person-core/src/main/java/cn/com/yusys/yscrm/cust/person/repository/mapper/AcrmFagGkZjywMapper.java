package cn.com.yusys.yscrm.cust.person.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFagGkZjyw;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagGkZjywMapper
 * @类描述: #Dao类
 * @功能描述: 概览-中间业务概览
 * @创建人: 15104
 * @创建时间: 2019-01-28 12:28:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFagGkZjywMapper extends CommonMapper<AcrmFagGkZjyw> {
	
	/**
	 * 中间业务概览信息查询
	 * @param param
	 * @return
	 */
	List<Map<Object, String>> queryZjywByCustId(Map<?, ?> param);
	
}