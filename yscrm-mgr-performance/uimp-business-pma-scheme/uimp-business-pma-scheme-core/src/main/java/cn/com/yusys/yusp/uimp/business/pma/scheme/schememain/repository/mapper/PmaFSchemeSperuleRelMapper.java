package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeSperuleRel;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeSperuleRelMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 19:18:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFSchemeSperuleRelMapper extends CommonMapper<PmaFSchemeSperuleRel> {

	List<Map<String, Object>> querySperule(QueryModel model);
	
	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案特殊规则表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	Integer copySchemeInf(@Param("schemeId") String schemeId, @Param("newSchemeId") String newSchemeId);
}