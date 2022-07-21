package cn.com.yusys.yscrm.product.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.OcrmFsysRicheditInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysRicheditInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 17:43:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysRicheditInfoMapper extends CommonMapper<OcrmFsysRicheditInfo> {
	
	/**
	 * @方法名称: queryList
	 * @方法描述: 条件列表查询
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<OcrmFsysRicheditInfo> richTextInformationQuery(QueryModel model);
}