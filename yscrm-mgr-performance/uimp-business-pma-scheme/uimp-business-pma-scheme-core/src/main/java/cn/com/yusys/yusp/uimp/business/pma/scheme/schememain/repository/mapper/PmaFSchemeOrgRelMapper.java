package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeOrgRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeOrgRelMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 18:13:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFSchemeOrgRelMapper extends CommonMapper<PmaFSchemeOrgRel> {

	List<Map<String, Object>> queryOrg(QueryModel model);

	PmaFSchemeOrgRel selectDrawSchemeOrgRel(String schemeId);

	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案机构关系表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	Integer copySchemeInf(@Param("schemeId") String schemeId, @Param("newSchemeId") String newSchemeId);

	/**
	 * 批量插入
	 * @param list
	 */
    void batchInsert(List<PmaFSchemeOrgRel> list);

	/**
	 *
	 * @param model
	 * @return
	 */
	List<Map<String, Object>> queryOrgList(QueryModel model);
}