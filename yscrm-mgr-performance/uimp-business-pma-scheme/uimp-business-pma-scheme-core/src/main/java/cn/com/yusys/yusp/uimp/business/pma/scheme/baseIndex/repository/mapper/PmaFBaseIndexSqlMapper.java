package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexSql;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexSqlMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-06 15:54:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFBaseIndexSqlMapper extends CommonMapper<PmaFBaseIndexSql> {
	void deleteSql(String indexId);
}