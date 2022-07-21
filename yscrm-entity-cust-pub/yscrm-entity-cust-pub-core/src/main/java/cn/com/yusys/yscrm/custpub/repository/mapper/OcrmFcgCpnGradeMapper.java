package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.OcrmFcgCpnGrade;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFcgCpnGradeMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 11:10:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFcgCpnGradeMapper extends CommonMapper<OcrmFcgCpnGrade> {
	List<Map<String, Object>> queryGradeList(Map<?, ?> param);
}