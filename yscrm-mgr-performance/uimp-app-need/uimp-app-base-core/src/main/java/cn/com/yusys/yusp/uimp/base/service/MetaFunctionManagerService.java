package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.exception.Message;
import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunTable;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseMetaFunRegMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: MetaFunctionManagerService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-27 15:10:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class MetaFunctionManagerService extends CommonService {
	
	@Autowired
	private AdminBaseMetaFunRegService adminBaseMetaFunRegService;
	
	@Autowired
	private AdminBaseMetaFunPageCfgService adminBaseMetaFunPageCfgService;
	
	@Autowired
	private AdminBaseMetaFunRegMapper adminBaseMetaFunRegMapper;
	
	@Autowired
	private AdminBaseMetaFunTableService adminBaseMetaFunTableService;
	
	@Autowired
	private AdminBaseMetaFunColumnService adminBaseMetaFunColumnService;
	
	@Autowired
	private AdminBaseMetaFunColumnCfgService adminBaseMetaFunColumnCfgService;

	@SuppressWarnings("rawtypes")
	@Override
	protected CommonMapper getMapper() {
		return adminBaseMetaFunRegMapper;
	}
	
	
	/**
	 * @方法名称: getFunInfoByCfg
	 * @方法描述: 根据指定配置项返回指定结果的业务功能注册信息列表
	 * @参数与返回说明:
	 * 	@param cfgName
	 *	@param cfgValue
	 * @算法描述:
	 */
	public List<AdminBaseMetaFunReg> getFunInfoByCfg(String cfgName, String cfgValue) throws Exception {
		List<AdminBaseMetaFunReg> funCodeList = new ArrayList<AdminBaseMetaFunReg>();
		Map<String, AdminBaseMetaFunReg> funRegInfo = adminBaseMetaFunRegService.getFunRegInfo();
		if (funRegInfo != null) {
			Set<String> funCodeSet = funRegInfo.keySet();
			for (String funCode : funCodeSet) {
				Map<String, String> pageCfgMap = adminBaseMetaFunPageCfgService.getFunPageCfg(funCode);
				if (pageCfgMap != null && cfgValue.equals(pageCfgMap.get(cfgName))) {
					funCodeList.add(funRegInfo.get(funCode));
				}
			}
		}
		return funCodeList;
	}
	
	
	/**
	 * @方法名称: getmetafuninfo
	 * @方法描述: 获取业务功能缓存信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@Cacheable(value = "AdminBaseMetaFunTable", key = "#funCode")
	public Map<String, Object> getMetaFunInfo(String funCode) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		Map<String, AdminBaseMetaFunReg> funRegInfo = adminBaseMetaFunRegService.getFunRegInfo();
		AdminBaseMetaFunReg regMap = funRegInfo.get(funCode);
		if(regMap == null) {
			Message message = new Message();
			message.setMessage("业务编码:[" + funCode + "]未注册");
			message.setCode("500");
			throw new YuspException(message);
		}
		json.put("regInfo", regMap);
		Map<String, ?> pageCfgMap = adminBaseMetaFunPageCfgService.getFunPageCfg(funCode);
		if (pageCfgMap == null) {
			Message message = new Message();
			message.setMessage("业务编码:[" + funCode + "]配置信息缺失");
			message.setCode("500");
			throw new YuspException(message);
		}
		json.put("pageCfgInfo", pageCfgMap);
		Map<String, ?> tableMap = adminBaseMetaFunTableService.getFunTable(funCode);
		if (tableMap == null) {
			Message message = new Message();
			message.setMessage("业务编码:[" + funCode + "]模型信息缺失");
			message.setCode("500");
			throw new YuspException(message);
		} else {
			json.put("tableInfo", tableMap);
			Map<String, Object> columnMaps = new HashMap<String, Object>();
			Map<String, Object> columnCfgMaps = new HashMap<String, Object>();
			Set<String> tableCodeKey = tableMap.keySet();
			for (String tableCode : tableCodeKey) {
				Map<String, ?> columnMap = adminBaseMetaFunColumnService.getFunColumn(tableCode);
				columnMaps.put(tableCode, columnMap);
				if (columnMap == null) {
					continue;
				}
				Set<String> columnCodeKey = columnMap.keySet();
				for (String columnCode : columnCodeKey) {
					Map<String, ?> columnCfgMap = adminBaseMetaFunColumnCfgService.getFunColumnCfg(columnCode);
					columnCfgMaps.put(columnCode, columnCfgMap);
				}
			}
			json.put("columnInfo", columnMaps);
			json.put("columnCfgInfo", columnCfgMaps);
		}
		return json;
	}
	
	/**
	 * @方法名称: refreshMetaFunInfo
	 * @方法描述: 刷新业务功能缓存信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@CachePut(value = "AdminBaseMetaFunTable", key = "#funCode")
	public Map<String, Object> refreshMetaFunInfo(String funCode) throws Exception {
		Map<String, Object> json = new HashMap<String, Object>();
		Map<String, AdminBaseMetaFunReg> funRegInfo = adminBaseMetaFunRegService.getFunRegInfo();
		AdminBaseMetaFunReg regMap = funRegInfo.get(funCode);
		if(regMap == null) {
			Message message = new Message();
			message.setMessage("业务编码:[" + funCode + "]未注册");
			message.setCode("500");
			throw new YuspException(message);
		}
		json.put("regInfo", regMap);
		Map<String, ?> pageCfgMap = adminBaseMetaFunPageCfgService.getFunPageCfg(funCode);
		if (pageCfgMap == null) {
			Message message = new Message();
			message.setMessage("业务编码:[" + funCode + "]配置信息缺失");
			message.setCode("500");
			throw new YuspException(message);
		}
		json.put("pageCfgInfo", pageCfgMap);
		Map<String, ?> tableMap = adminBaseMetaFunTableService.getFunTable(funCode);
		if (tableMap == null) {
			Message message = new Message();
			message.setMessage("业务编码:[" + funCode + "]模型信息缺失");
			message.setCode("500");
			throw new YuspException(message);
		} else {
			json.put("tableInfo", tableMap);
			Map<String, Object> columnMaps = new HashMap<String, Object>();
			Map<String, Object> columnCfgMaps = new HashMap<String, Object>();
			Set<String> tableCodeKey = tableMap.keySet();
			for (String tableCode : tableCodeKey) {
				Map<String, ?> columnMap = adminBaseMetaFunColumnService.getFunColumn(tableCode);
				columnMaps.put(tableCode, columnMap);
				if (columnMap == null) {
					continue;
				}
				Set<String> columnCodeKey = columnMap.keySet();
				for (String columnCode : columnCodeKey) {
					Map<String, ?> columnCfgMap = adminBaseMetaFunColumnCfgService.getFunColumnCfg(columnCode);
					columnCfgMaps.put(columnCode, columnCfgMap);
				}
			}
			json.put("columnInfo", columnMaps);
			json.put("columnCfgInfo", columnCfgMaps);
		}
		return json;
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: getCreateTableSQL
	 * @方法描述: 生成分配表的建表语句
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public Map<String, Object> getCreateTableSQL(String funCode) throws Exception {
		Map<String, Object> funInfo = this.getMetaFunInfo(funCode);
		Map<String, Object> returnMap = getDistributionCreateTabelSQL(funInfo);
		return returnMap;
	}
	
	
	/**
	 * @throws Exception 
	 * @方法名称: getDistributionCreateTabelSQL
	 * @方法描述: 返回业绩分配功能中period,period_his,distribute,distribute_his四张表的建表语句
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getDistributionCreateTabelSQL(Map<String, Object> funInfo) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<String> pkList = getInfoPrimaryKey(funInfo, DistributionConstants.FUN_SUB_TYPE_INFO);
		Map<String, String> periodCfg = new HashMap<String, String>();
		Map<String, String> periodHisCfg = new HashMap<String, String>();
		Map<String, String> distributeCfg = new HashMap<String, String>();
		Map<String, String> impDTLCfg = new HashMap<String, String>();
		Map<String, String> impCheckCfg = new HashMap<String, String>();
		Map<String, String> priKeyCfg = new HashMap<String, String>();
		Map<String, String> periodComment = new HashMap<String, String>();
		Map<String, String> periodHisComment = new HashMap<String, String>();
		Map<String, String> distributeComment = new HashMap<String, String>();
		Map<String, String> impDTLComment = new HashMap<String, String>();
		Map<String, String> impCheckComment = new HashMap<String, String>();
		Map<String, String> priKeyComment = new HashMap<String, String>();
		StringBuilder pkStr = new StringBuilder();
		if ("DB2".equals(DistributionConstants.DB_TYPE)) {
			periodCfg.putAll(DistributionConstants.PERIOD_CREATE_SQL_CFG_DB2);
			periodHisCfg.putAll(DistributionConstants.PERIOD_HIS_CREATE_SQL_CFG_DB2);
			distributeCfg.putAll(DistributionConstants.DISTRIBUTE_CREATE_SQL_CFG_DB2);
			impDTLCfg.putAll(DistributionConstants.IMP_DTL_CREATE_SQL_CFG_DB2);
			impCheckCfg.putAll(DistributionConstants.IMP_CHECK_CREATE_SQL_CFG_DB2);
			priKeyCfg.putAll(DistributionConstants.PRI_KEY_CREATE_SQL_CFG_DB2);
			for (String pk : pkList) {
				periodCfg.put(pk, "VARCHAR(32)");
				periodHisCfg.put(pk, "VARCHAR(32)");
				priKeyCfg.put(pk, "VARCHAR(32)");
				impDTLCfg.put(pk, "VARCHAR(32)");
				impCheckCfg.put(pk, "VARCHAR(32)");
				pkStr.append(pk).append(",");
			}
			periodComment.putAll(DistributionConstants.PERIOD_CREATE_SQL_COMMENT_DB2);
			periodHisComment.putAll(DistributionConstants.PERIOD_HIS_CREATE_SQL_COMMENT_DB2);
			distributeComment.putAll(DistributionConstants.DISTRIBUTE_CREATE_SQL_COMMENT_DB2);
			impDTLComment.putAll(DistributionConstants.IMP_DTL_CREATE_SQL_COMMENT_DB2);
			impCheckComment.putAll(DistributionConstants.IMP_CHECK_CREATE_SQL_COMMENT_DB2);
			priKeyComment.putAll(DistributionConstants.PRI_KEY_CREATE_SQL_COMMENT_DB2);
			for (String pk : pkList) {
				periodComment.put(pk, "信息表主键");
				periodHisComment.put(pk, "信息表主键");
				priKeyComment.put(pk, "信息表主键");
				impDTLComment.put(pk, "信息表主键");
				impCheckComment.put(pk, "信息表主键");
			}
		} else if ("Oracle".equals(DistributionConstants.DB_TYPE)) {
			periodCfg.putAll(DistributionConstants.PERIOD_CREATE_SQL_CFG_ORACLE);
			periodHisCfg.putAll(DistributionConstants.PERIOD_HIS_CREATE_SQL_CFG_ORACLE);
			distributeCfg.putAll(DistributionConstants.DISTRIBUTE_CREATE_SQL_CFG_ORACLE);
			impDTLCfg.putAll(DistributionConstants.IMP_DTL_CREATE_SQL_CFG_ORACLE);
			impCheckCfg.putAll(DistributionConstants.IMP_CHECK_CREATE_SQL_CFG_ORACLE);
			priKeyCfg.putAll(DistributionConstants.PRI_KEY_CREATE_SQL_CFG_ORACLE);
			for (String pk : pkList) {
				periodCfg.put(pk, "VARCHAR2(32)");
				periodHisCfg.put(pk, "VARCHAR2(32)");
				priKeyCfg.put(pk, "VARCHAR2(32)");
				impDTLCfg.put(pk, "VARCHAR2(32)");
				impCheckCfg.put(pk, "VARCHAR2(32)");
				pkStr.append(pk).append(",");
			}
			periodComment.putAll(DistributionConstants.PERIOD_CREATE_SQL_COMMENT_ORACLE);
			periodHisComment.putAll(DistributionConstants.PERIOD_HIS_CREATE_SQL_COMMENT_ORACLE);
			distributeComment.putAll(DistributionConstants.DISTRIBUTE_CREATE_SQL_COMMENT_ORACLE);
			impDTLComment.putAll(DistributionConstants.IMP_DTL_CREATE_SQL_COMMENT_ORACLE);
			impCheckComment.putAll(DistributionConstants.IMP_CHECK_CREATE_SQL_COMMENT_ORACLE);
			priKeyComment.putAll(DistributionConstants.PRI_KEY_CREATE_SQL_COMMENT_ORACLE);
			for (String pk : pkList) {
				periodComment.put(pk, "信息表主键");
				periodHisComment.put(pk, "信息表主键");
				priKeyComment.put(pk, "信息表主键");
				impDTLComment.put(pk, "信息表主键");
				impCheckComment.put(pk, "信息表主键");
			}
		}
		pkStr.deleteCharAt(pkStr.length() - 1);
		
		Map<String, String> pageCfgMap = (Map<String, String>) funInfo.get("pageCfgInfo");
		if (!"2".equals(pageCfgMap.get("DSTR_TYPE"))) { // 分配类型:1,比例分配; 2,比例+定额
			distributeCfg.remove("START_AMT");
			distributeCfg.remove("END_AMT");
			distributeComment.remove("START_AMT");
			distributeComment.remove("END_AMT");
		}
		StringBuilder sb = new StringBuilder();
		Map<String, String> periodMap = getTableMap(funInfo,DistributionConstants.FUN_SUB_TYPE_PERIOD);
		Map<String, String> periodHisMap = getTableMap(funInfo, DistributionConstants.FUN_SUB_TYPE_PERIOD_HIS);
		Map<String, String> distributeMap = getTableMap(funInfo, DistributionConstants.FUN_SUB_TYPE_DISTRIBUTE);
		Map<String, String> distributeHisMap = getTableMap(funInfo, DistributionConstants.FUN_SUB_TYPE_DISTRIBUTE_HIS);
		Map<String, String> impDTLMap = getTableMap(funInfo, DistributionConstants.FUN_SUB_TYPE_IMP_DTL);
		Map<String, String> impCheckMap = getTableMap(funInfo, DistributionConstants.FUN_SUB_TYPE_IMP_CHECK);
		Map<String, String> priKeyMap = getTableMap(funInfo, DistributionConstants.FUN_SUB_TYPE_PRI_KEY);
		List<String> distriIndexList = new ArrayList<String>(); // 分配关系表的索引列表
		distriIndexList.add("PERIOD_ID");
		List<String> periodIndexList = new ArrayList<String>(); // 分配区间表的索引列表
		List<String> periodHisIndexList = new ArrayList<String>(); // 分配区间历史表的索引列表
		List<String> impDTLIndexList = new ArrayList<String>(); // 分配区间表的索引列表
		List<String> impCheckndexList = new ArrayList<String>(); // 分配区间表的索引列表
		List<String> priKeyIndexList = new ArrayList<String>(); // 分配区间表的索引列表
		periodIndexList.add(pkStr.toString());
		periodIndexList.add("DATA_SRC");
		periodHisIndexList.add(pkStr.toString());
		periodHisIndexList.add("APPLY_STS");
		periodHisIndexList.add("APPLY_ID");
		impDTLIndexList.add(pkStr.toString());
		impCheckndexList.add(pkStr.toString());
		priKeyIndexList.add(pkStr.toString());
		sb.append(generateSomeCreateTableSql(funInfo, DistributionConstants.FUN_SUB_TYPE_INFO)).append("<br>");
		List<String> logicIdList = new ArrayList<String>();
		logicIdList.add("ID");
		sb.append(generateCreateTableSql(periodMap, periodCfg, periodComment, periodIndexList,logicIdList)).append("<br>");
		sb.append(generateCreateTableSql(periodHisMap, periodHisCfg, periodHisComment, periodHisIndexList, logicIdList)).append("<br>");
		sb.append(generateCreateTableSql(distributeMap, distributeCfg, distributeComment, distriIndexList, logicIdList)).append("<br>");
		sb.append(generateCreateTableSql(distributeHisMap, distributeCfg, distributeComment, distriIndexList, logicIdList)).append("<br>");
		Map<String, String> infoMap = getInfoMap(funInfo, DistributionConstants.FUN_SUB_TYPE_INFO);
		Map<String, String> commentMap = getInfoCommentMap(funInfo, DistributionConstants.FUN_SUB_TYPE_INFO);
		impDTLCfg.putAll(infoMap);
		impCheckCfg.putAll(infoMap);
		impDTLComment.putAll(commentMap);
		impCheckComment.putAll(commentMap);
		sb.append(generateCreateTableSql(impDTLMap, impDTLCfg, impDTLComment, impDTLIndexList, logicIdList)).append("<br>");
		sb.append(generateCreateTableSql(impCheckMap, impCheckCfg, impCheckComment, impCheckndexList, logicIdList)).append("<br>");
		sb.append(generateCreateTableSqlWithUnitIndex(priKeyMap, priKeyCfg, priKeyComment, priKeyIndexList, logicIdList)).append("<br>");
		returnMap.put("SQL", sb.toString());
		return returnMap;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getInfoMap(Map<String, Object> funInfo, String type) {
		Map<String, String> infoTableMap = getTableMap(funInfo, type);
		String infoTableCode = infoTableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfo.get("columnInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
		Map<String, String> columnCfg = new HashMap<String, String>();
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfo.get("columnCfgInfo");
		
		for (String columnCode : columnMap.keySet()) {
			Map<String, Object> columnCfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			Map<String, Object> columnInfo = columnMap.get(columnCode);
			if(columnCfgMap!=null && "1".equals(columnCfgMap.get("IMP_GRID_FIELD"))) {
				String columnName = (String) columnInfo.get("columnName");
				String columnType = (String) columnInfo.get("columnType");
				Integer columnLength = Integer.valueOf((String) columnInfo.get("columnLength"));
				if (columnLength <= 0) {
					columnLength = 20;
				}
				if ("DB2".equals(DistributionConstants.DB_TYPE)) {
					if (DistributionConstants.COLUMN_TYPE_DATE.equals(columnType)) {
						columnCfg.put(columnName, "DATE");
					} else if (DistributionConstants.COLUMN_TYPE_NUMBER.equals(columnType)) {
						columnCfg.put(columnName, "DECIMAL("+columnLength+",2)");
					} else {
						columnCfg.put(columnName, "VARCHAR("+columnLength+")");
					}
				} else { // oracle
					if (DistributionConstants.COLUMN_TYPE_DATE.equals(columnType)) {
						columnCfg.put(columnName, "DATE");
					} else if (DistributionConstants.COLUMN_TYPE_NUMBER.equals(columnType)) {
						columnCfg.put(columnName, "NUMBER("+columnLength+",2)");
					} else {
						columnCfg.put(columnName, "VARCHAR2("+columnLength+")");
					}
				}
			}
		}
		return columnCfg;
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getInfoCommentMap(Map<String, Object> funInfo, String type) {
		Map<String, String> infoTableMap = getTableMap(funInfo, type);
		String infoTableCode = infoTableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfo.get("columnInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
		Map<String, String> columnComment = new HashMap<String, String>();
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfo.get("columnCfgInfo");
		
		for (String columnCode : columnMap.keySet()) {
			Map<String, Object> columnCfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			Map<String, Object> columnInfo = columnMap.get(columnCode);
			if(columnCfgMap!=null && "1".equals(columnCfgMap.get("IMP_GRID_FIELD"))) {
				String columnName = (String) columnInfo.get("columnName");
				String columnCnName = (String) columnInfo.get("columnCnName");
				columnComment.put(columnName, columnCnName);
			}
		}
		return columnComment;
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: generateSomeCreateTableSql
	 * @方法描述: 生成创建指定FUN_SUB_TYPE类型的表的sql语句
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@SuppressWarnings("unchecked")
	private String generateSomeCreateTableSql(Map<String, Object> funInfo, String type) {
		Map<String, String> infoTableMap = getTableMap(funInfo, type);
		String infoTableCode = infoTableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfo.get("columnInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
		Map<String, String> columnCfg = new HashMap<String, String>();
		Map<String, String> columnComment = new HashMap<String, String>();
		for (String columnCode : columnMap.keySet()) {
			Map<String, Object> columnInfo = columnMap.get(columnCode);
			String columnName = (String) columnInfo.get("columnName");
			String columnType = (String) columnInfo.get("columnType");
			String columnCnName = (String) columnInfo.get("columnCnName");
			Integer columnLength = Integer.valueOf((String) columnInfo.get("columnLength"));
			if (columnLength <= 0) {
				columnLength = 20;
			}
			if ("DB2".equals(DistributionConstants.DB_TYPE)) {
				if (DistributionConstants.COLUMN_TYPE_DATE.equals(columnType)) {
					columnCfg.put(columnName, "DATE");
				} else if (DistributionConstants.COLUMN_TYPE_NUMBER.equals(columnType)) {
					columnCfg.put(columnName, "DECIMAL("+columnLength+",2)");
				} else {
					columnCfg.put(columnName, "VARCHAR("+columnLength+")");
				}
			} else { // oracle
				if (DistributionConstants.COLUMN_TYPE_DATE.equals(columnType)) {
					columnCfg.put(columnName, "DATE");
				} else if (DistributionConstants.COLUMN_TYPE_NUMBER.equals(columnType)) {
					columnCfg.put(columnName, "NUMBER("+columnLength+",2)");
				} else {
					columnCfg.put(columnName, "VARCHAR2("+columnLength+")");
				}
			}
			columnComment.put(columnName, columnCnName);
		}
		StringBuilder returnStr = new StringBuilder();
		returnStr.append("--业务信息表的建表语句,请根据实际情况【修改】建表配置<br>");
		List<String> pkList = getInfoPrimaryKey(funInfo, type);
		if (DistributionConstants.FUN_SUB_TYPE_INFO.equals(type)) {
			List<String> infoIndexList = new ArrayList<String>(); // 业务信息表的索引列表
			StringBuilder pkStr = new StringBuilder();
			for (String pk : pkList) {
				pkStr.append(pk).append(",");
			}
			pkStr.deleteCharAt(pkStr.length() - 1);
			infoIndexList.add(pkStr.toString());
			returnStr.append(generateCreateTableSql(infoTableMap, columnCfg, columnComment, infoIndexList, null));
		} else {
			returnStr.append(generateCreateTableSql(infoTableMap, columnCfg, columnComment, null, pkList));
		}
		return returnStr.toString();
	}
	
	/**
	 * @throws 
	 * @方法名称: generateCreateTableSql
	 * @方法描述: 获取分配主键字段名称
	 * @参数与返回说明:
	 * @param tableMap 表信息map
	 * @param tableCfg 表数据库配置map
	 * @param columnIndexList 需要建立索引的字段列表
	 * @param pkList 需要建立主键索引的字段列表
	 * @算法描述:
	 */
	private String generateCreateTableSql(Map<String, String> tableMap, Map<String, String> tableCfg , Map<String, String> tableCnCfg, List<String> columnIndexList, List<String> pkList) {
		StringBuilder sb = new StringBuilder();
		sb.append("--【").append(tableMap.get("tableCnName")).append("】建表语句<br>");
		sb.append("CREATE TABLE \"");
		sb.append(tableMap.get("tableName"));
		sb.append("\" (");
		for (String key : tableCfg.keySet()) {
			sb.append("\"").append(key).append("\"	").append(tableCfg.get(key)).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("); ");
		String indexPrefix = tableMap.get("tableName").replace("PMA_F_", "");
		if (pkList != null && pkList.size() > 0) {
			sb.append("<br>ALTER TABLE \"");
			sb.append(tableMap.get("tableName"));
			sb.append("\" ADD CONSTRAINT \"XPK_");
			sb.append(indexPrefix);
			sb.append("\" PRIMARY KEY  (");
			sb.append(listToString(pkList));
			sb.append(");");
		}
		int indexSeq = 1;
		if (columnIndexList != null) {
			for (String colIndex : columnIndexList) {
				sb.append("<br>CREATE INDEX ");
				sb.append(indexPrefix);
				sb.append("_IX_");
				sb.append(indexSeq++);
				sb.append(" ON ");
				sb.append(tableMap.get("tableName"));
				sb.append("(");
				sb.append(colIndex);
				sb.append(");");
			}
		}
		sb.append("<br>COMMENT ON TABLE ");
		sb.append(tableMap.get("tableName")).append(" IS \'");
		sb.append(tableMap.get("tableCnName")).append("\';<br>");
		for (String key : tableCnCfg.keySet()) {
			sb.append("COMMENT ON COLUMN ").append(tableMap.get("tableName")).append(".");
			sb.append(key).append(" IS \'").append(tableCnCfg.get(key)).append("\';<br>");
		}
		return sb.toString();
	}
	
	/**
	 * @throws 
	 * @方法名称: generateCreateTableSql
	 * @方法描述: 获取分配主键字段名称
	 * @参数与返回说明:
	 * @param tableMap 表信息map
	 * @param tableCfg 表数据库配置map
	 * @param columnIndexList 需要建立索引的字段列表
	 * @param pkList 需要建立主键索引的字段列表
	 * @算法描述:
	 */
	private String generateCreateTableSqlWithUnitIndex(Map<String, String> tableMap, Map<String, String> tableCfg, Map<String, String> tableCnCfg, List<String> columnIndexList, List<String> pkList) {
		StringBuilder sb = new StringBuilder();
		sb.append("--【").append(tableMap.get("tableCnName")).append("】建表语句<br>");
		sb.append("CREATE TABLE \"");
		sb.append(tableMap.get("tableName"));
		sb.append("\" (");
		for (String key : tableCfg.keySet()) {
			sb.append("\"").append(key).append("\"	").append(tableCfg.get(key)).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("); ");
		String indexPrefix = tableMap.get("tableName").replace("PMA_F_", "");
		if (pkList != null && pkList.size() > 0) {
			sb.append("<br>ALTER TABLE \"");
			sb.append(tableMap.get("tableName"));
			sb.append("\" ADD CONSTRAINT \"XPK_");
			sb.append(indexPrefix);
			sb.append("\" PRIMARY KEY  (");
			sb.append(listToString(pkList));
			sb.append(");");
		}
		int indexSeq = 1;
		if (columnIndexList != null) {
			for (String colIndex : columnIndexList) {
				sb.append("<br>CREATE UNIQUE INDEX ");
				sb.append(indexPrefix);
				sb.append("_IX_");
				sb.append(indexSeq++);
				sb.append(" ON ");
				sb.append(tableMap.get("tableName"));
				sb.append("(");
				sb.append(colIndex);
				sb.append(");");
			}
		}
		sb.append("<br>COMMENT ON TABLE ");
		sb.append(tableMap.get("tableName")).append(" IS \'");
		sb.append(tableMap.get("tableCnName")).append("\';<br>");
		for (String key : tableCnCfg.keySet()) {
			sb.append("COMMENT ON COLUMN ").append(tableMap.get("tableName")).append(".");
			sb.append(key).append(" IS \'").append(tableCnCfg.get(key)).append("\';<br>");
		}
		return sb.toString();
	}
	
	/** 
	 * @Title listToString 
	 * @Description list -> String; [a,b,c]->"a,b,c"
	 * @param list
	 */ 
	public String listToString(List<?> list) {
		StringBuilder s = new StringBuilder();
		for (Object object : list) {
			s.append(object).append(",");
		}
		return s.substring(0, s.length() - 1);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: getInfoPrimaryKey
	 * @方法描述: 获取分配主键字段名称
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@SuppressWarnings("unchecked")
	public List<String> getInfoPrimaryKey(Map<String, Object> funInfoMap,String type) {
		List<String> pkList = new ArrayList<String>();
		Map<String, String> tableMap = getTableMap(funInfoMap, type);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
		String funCode = ((AdminBaseMetaFunReg) funInfoMap.get("regInfo")).getFunCode();
		if (columnMap == null) {
			Message message = new Message();
			message.setCode("500");
			message.setMessage("业务编码:[" + funCode + "]字段信息缺失");
			throw new YuspException(message);
		}
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && DistributionConstants.YES.equals(cfgMap.get("IS_PK"))) {
				pkList.add(columnMap.get(columnCode).get("columnName").toString());
			}
		}
		if (pkList.size() == 0) {
			Message message = new Message();
			message.setCode("500");
			message.setMessage("业务编码:[" + funCode + "]业务信息表未设置【主键】项,请检查");
			throw new YuspException(message);
		}
		return pkList;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getTableMap(Map<String, Object> funInfoMap, String subType) {
		Map<String, Object> tableInfoMap = (Map<String, Object>) funInfoMap.get("tableInfo");
		Set<String> tableCodeSet = tableInfoMap.keySet();
		for (String tableCode : tableCodeSet) {
			Map<String, String> map = (Map<String, String>) tableInfoMap.get(tableCode);
			if (subType.equals(map.get("funSubType"))) {
				return map;
			}
		}
		return null;
	}
	
	
	/**
	 * @方法名称: createbusifunc
	 * @方法描述: 生成功能点
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public ResultDto<Object> createbusifunc(String funCode) {
		ResultDto<Object> resultDto = new ResultDto<>();
    	try {
    		AdminBaseMetaFunReg adminBaseMetaFunReg = this.adminBaseMetaFunRegService.getAdminBaseMetaFunReg(funCode);
    		String funcNameDstr = adminBaseMetaFunReg.getFunName() + "_业绩分配";
    		String funcDescDstr = adminBaseMetaFunReg.getFunName() + "_业绩分配";
    		String funcUrlDstr = "pages/content/bussiness/distributionmanage/commonDstr/commonDstr?funCode=" + adminBaseMetaFunReg.getFunCode();
    		this.adminBaseMetaFunRegMapper.deletebusifunc(funcUrlDstr);
    		this.adminBaseMetaFunRegMapper.createbusifunc(funcNameDstr, funcDescDstr, funcUrlDstr);
    		
    		String funcNameVet = adminBaseMetaFunReg.getFunName() + "_业绩审批";
    		String funcDescVet = adminBaseMetaFunReg.getFunName() + "_业绩审批";
    		String funcUrlVet = "pages/content/bussiness/distributionmanage/commonDstrVet/commonDstrVet?funCode=" + adminBaseMetaFunReg.getFunCode();
    		this.adminBaseMetaFunRegMapper.deletebusifunc(funcUrlVet);
    		this.adminBaseMetaFunRegMapper.createbusifunc(funcNameVet, funcDescVet, funcUrlVet);
    		
    		String funcNameDstrHis = adminBaseMetaFunReg.getFunName() + "_业绩审批历史";
    		String funcDescDstrHis = adminBaseMetaFunReg.getFunName() + "_业绩审批历史";
    		String funcUrlDstrHis = "pages/content/bussiness/distributionmanage/commonDstrHis/commonDstrHis?funCode=" + adminBaseMetaFunReg.getFunCode();
    		this.adminBaseMetaFunRegMapper.deletebusifunc(funcUrlDstrHis);
    		this.adminBaseMetaFunRegMapper.createbusifunc(funcNameDstrHis, funcDescDstrHis, funcUrlDstrHis);
			resultDto.setCode(0);
			resultDto.setMessage("生成功能点成功");
		} catch (Exception e) {
			e.printStackTrace();
			resultDto.setCode(500);
		    resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}
	
	
	/**
	 * @throws Exception 
	 * @方法名称: queryFunColumnInfo
	 * @方法描述:查询列信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public AdminBaseMetaFunTable queryFunTableInfo(String funCode,String funSubType) {
		return adminBaseMetaFunTableService.queryFunTableInfo(funCode,funSubType);
	}
	
}
