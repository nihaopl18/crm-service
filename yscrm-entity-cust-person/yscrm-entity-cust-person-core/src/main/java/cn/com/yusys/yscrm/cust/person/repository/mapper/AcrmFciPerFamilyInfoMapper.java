package cn.com.yusys.yscrm.cust.person.repository.mapper;



import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerFamilyInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;


/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerFamilyInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-29 10:39:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciPerFamilyInfoMapper extends CommonMapper<AcrmFciPerFamilyInfo> {
	List<Map<Object, String>> getFamilyList(Map<?, ?> param);
	
	
	
}