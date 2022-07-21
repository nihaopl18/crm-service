package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeIndexRelMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-20 10:36:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFSchemeIndexRelMapper extends CommonMapper<PmaFSchemeIndexRel> {
	List<Map<String, Object>> queryIndex(QueryModel model);
	void delIndex(Map<String, Object> map);
	List<String> queryNames(@Param("objId") String[] objId);
	List<Map<String, Object>> queryByMap(QueryModel model);
	List<Map<String, Object>> querySchemeIndex(QueryModel model);
	List<Map<String, Object>> querySchemeAndIndex(QueryModel model);
	List<Map<String, Object>> queryEvlIndex(@Param("indexId") String indexId);
	List<Map<String, Object>> queryImpIndex(QueryModel model);
	List<Map<String, Object>> queryIndexByDash(QueryModel model);
	List<String> queryNamesByDash(@Param("objId") String[] objId);
	List<PmaFSchemeIndexRel> selectDrawSchemeIndex(String schemeId);
	
	/**
     * @函数名称:deleteBySchemeId
     * @函数描述:根据考核方案ID，删除-考核方案与指标关系表数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer deleteBySchemeId(@Param("schemeId") String schemeId);
	
	/**
     * @函数名称:batchInsert
     * @函数描述:批量保存-考核方案与指标关系表数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer batchInsert(@Param("dataList") List<PmaFSchemeIndexRel> dataList);
	
	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案与指标关系表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	Integer copySchemeInf(@Param("schemeId") String schemeId, @Param("newSchemeId") String newSchemeId);
	List<Map<String, Object>> queryIndexRes(QueryModel model);

	/**
	 * 评分模型-查询指标信息
	 * @param schemeId
	 * @return
	 */
	List<Map<String, Object>> queryIndexForScore(QueryModel model);

	/**
	 * 统计考核方案先指标数量
	 * @param schemeId
	 */
	int countBySchemeId(String schemeId);


}