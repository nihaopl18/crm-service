package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamListInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamListInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 17:02:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFParamListInfoMapper extends CommonMapper<PmaFParamListInfo> {
	List<Map<String, Object>> querylist(String paramId);
	int  deldetail(String paramId);
}