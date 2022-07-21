package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFIndexCdtInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexConditionMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-07 11:29:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFBaseIndexConditionMapper extends CommonMapper<PmaFIndexCdtInfo> {
	List<Map<String, Object>> querylist(String indexId);
	int  delCondition(String id);
	int  delcon(String indexId);
}