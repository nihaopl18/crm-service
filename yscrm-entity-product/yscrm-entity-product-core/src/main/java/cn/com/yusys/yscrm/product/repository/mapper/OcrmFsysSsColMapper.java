package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.product.domain.OcrmFsysSsCol;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysSsColMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-03-06 10:00:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysSsColMapper extends CommonMapper<OcrmFsysSsCol> {
	List<Map<String, Object>> getScol(QueryModel param);
	
	int delerteCol(String prodId);
	
	int delerteCustCol(String prodId);
	
	List<Map<String, Object>> getColQuery(QueryModel param);
	
	List<Map<String, Object>> prepare(String SQL);
	
	List<Map<String, Object>> showcoltype(QueryModel model);
	
	List<Map<String, Object>> getCustScol(QueryModel param);
}