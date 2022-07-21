package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexSplit;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeIndexSplitMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-03-18 16:57:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFSchemeIndexSplitMapper extends CommonMapper<PmaFSchemeIndexSplit> {

	void deleteIndex(String schemeId);
	
}