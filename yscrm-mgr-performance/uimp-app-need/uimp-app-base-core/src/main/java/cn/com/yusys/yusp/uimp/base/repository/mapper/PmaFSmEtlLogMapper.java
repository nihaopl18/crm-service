package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.domain.PmaFSmEtlLog;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFetlDateMapper
 * @类描述: #数据日期表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-09-21 16:49:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFSmEtlLogMapper extends CommonMapper<PmaFSmEtlLog> {
	
	/**
     * @函数名称:queryList
     * @函数描述:列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	List<Map<String, Object>> queryList(QueryModel model);
}