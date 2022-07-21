package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeAuth;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeAuthMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-26 15:05:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFSchemeAuthMapper extends CommonMapper<PmaFSchemeAuth> {
	int deleteByScheme(String schemeId);
	int deleteBySchemeIds(String[] schemeIds);
	List<Map<String,Object>> listByModel(QueryModel model);
	int checkData(PmaFSchemeAuth record);
	Integer deleteData(@Param("ids") String[] split);
}