package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeEvlobjRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeEvlobjRelMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 19:28:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFSchemeEvlobjRelMapper extends CommonMapper<PmaFSchemeEvlobjRel> {
	List<Map<String, Object>> listByModel(QueryModel model);
	List<String> queryNames(@Param("objId") String[] objId);
	
	/**
     * @函数名称:getEvlObjBySchemeId
     * @函数描述:根据考核方案ID，查询该考核方案所有考核对象数据
     * @参数与返回说明:
     * {
     *   id: '',  考核对象编号
     *   pId: '03',	默认值03，表示上级节点id
     *   name: '',  考核对象名称
     *   type: '1'  默认值1，表示叶子节点
     * }
     * @算法描述:
     */
	List<Map<String, Object>> getEvlObjBySchemeId(@Param("schemeId") String schemeId);
	
	/**
     * @函数名称:deleteBackupTableDataBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，删除考核方案评价对象备份表数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer deleteBackupTableDataBySchemeIdAndEtlDate(@Param("schemeId") String schemeId, @Param("etlDate") String etlDate);
	
	/**
     * @函数名称:insertBackupTableData
     * @函数描述:根据考核方案ID、数据日期，新增考核方案评价对象备份表数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer insertBackupTableData(@Param("schemeId") String schemeId, @Param("etlDate") String etlDate);
	
	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案评价对象表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	Integer copySchemeInf(@Param("schemeId") String schemeId, @Param("newSchemeId") String newSchemeId);

	/**
	 * 批量插入
	 * @param list
	 * @return
	 */
	int batchInsert(List<PmaFSchemeEvlobjRel> list);

	/**
	 * 统计考核方案绑定考核对象数量
	 * @param schemeId
	 * @return
	 */
	int countBySchemeId(String schemeId);
}