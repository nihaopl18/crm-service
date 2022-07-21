package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcFieldEcName;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableEcName;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableType;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRulePropertyMapper
 * @类描述: 规则属性配置接口
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-15 14:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcRulePropertyMapper extends CommonMapper<CmFRcTableType>{
	
	/**查询表类别*/
	List<CmFRcTableType> getTableType(QueryModel model);
	/**
	 *  <!-- 删除表 类型-->
	 * @param typeId
	 * @return
	 */
	int updataTabTypeState(Map<String,String> map);
	/**
	 * 根据表类型查询表
	 * @param model
	 */
	List<CmFRcTableEcName> getTableByTypeId(QueryModel model);
	/**
	 * 查询所有表
	 * @param model
	 */
	List<CmFRcTableEcName> getAllTab();
	/**
	 * 根据表id查询表字段
	 * @param model
	 */
	List<CmFRcFieldEcName> getFieldByTableId(QueryModel model);
	/**
	 * 查询数据库表和视图
	 * @param model
	 */
	List<Map<String, Object>> searchtable(QueryModel model);
	/**
	 * <!-- 根据表名查询字段 -->
	 * @param tabName
	 * @param tabId
	 * @return
	 */
	List<CmFRcFieldEcName> searchFieldByTabName(@Param("tabName") String tabName,@Param("tabId") String tabId);
	/**
	 * 新增表字段
	 * @param map
	 */
	void insertNewDataToField(Map<?,?> map);
	/**
	 * <!-- 删除表-->
	 * @param tableId
	 * @return
	 */
	int updataTabState(Map<String,String> map);
	/**
	 * <!-- 删除字段 -->
	 * @param tableId
	 * @return
	 */
	int updateFieldState(Map<String,String> map);
	/**
	 * <!-- 根据表类型id查询表Id -->
	 * @param typeId
	 * @return
	 */
	List<CmFRcTableEcName> queryTableId(@Param("typeId") String typeId);
	/**
	 * 查询交易码
	 * @return
	 */
	List<Map<String, Object>> searchTransCode(@Param("transType") String transType);
	
	/**根据交易码删除交易类型*/
	int deleteTransCode(@Param("transCode") String transCode);
	/***根据表类型查询表是否 被实时事件所引用**/
	List<CmFRcEventInfo> getEventByType(@Param(value="typeId") String typeId);
}
