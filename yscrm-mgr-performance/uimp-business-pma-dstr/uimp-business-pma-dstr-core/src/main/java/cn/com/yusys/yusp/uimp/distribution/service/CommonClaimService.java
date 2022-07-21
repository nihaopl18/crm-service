package cn.com.yusys.yusp.uimp.distribution.service;


import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.flow.dto.WFStratDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.base.utils.DateUtil;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.DATA_AUTH_TYPE;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.DATA_TYPE;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.FUN_SUB_TYPE;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.SEARCH_TYPE;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonClaimMapper;
import co.elastic.apm.shaded.stagemonitor.util.StringUtils;
import com.ecc.echain.util.UNIDProducer;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceImpService
 * @类描述: # 业绩批量导入接口 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-09 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CommonClaimService {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private CommonDistributionService commonDistributionService;
	
	
	@Autowired
	private MetaFunctionManagerService metaFunctionManagerService;

	
	@Autowired
	private CommonClaimMapper commonClaimMapper;
	/**
	 * @方法名称: queryList
	 * @方法描述: 列表查询
	 * @参数与返回说明: 
	 * @算法描述: 
	 * @throws Exception 
	 */
	public List<Map<String, Object>> queryList(QueryModel queryModel) throws Exception {
		if(queryModel.getCondition().containsKey("funCode") && !StringUtils.isEmpty(queryModel.getCondition().get("funCode") + "")) {
			String funCode = queryModel.getCondition().get("funCode") + "";
			String dataAuth = queryModel.getCondition().get("dataAuth") != null ? queryModel.getCondition().get("dataAuth") + "" : "";
			String dataBussAuth = queryModel.getCondition().get("dataBussAuth") != null ? queryModel.getCondition().get("dataBussAuth") + "" : "";
			/** 获取功能信息缓存 */
			Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
			
			StringBuffer sql = new StringBuffer(this.builderQuerySql(funInfoMap, dataAuth, dataBussAuth));
			
			sql.insert(0, "SELECT * FROM (");
			sql.append(") X WHERE 1=1 ");

			/** 配置查询条件 */
			Set<Map<String, Object>> searchFieldSet = this.getSearchFieldSet(funInfoMap);
			for (Map<String, Object> map : searchFieldSet) { // 查询条件细分
				if (map.get("columnHiddenName") != null) {
					if ((map.get("subOrgQuery") != null)&& (DistributionConstants.YES.equals(map.get("subOrgQuery")))){
						if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
							sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X.ACCT_ORG_ID");
							sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
							sql.append(queryModel.getCondition().get(map.get("columnHiddenName"))).append(")($|,)') )");
						}else {
							sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X."+map.get("columnName").toString());
							sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
							sql.append(queryModel.getCondition().get(map.get("columnHiddenName"))).append(")($|,)') )");
						}
					}else {
						if(queryModel.getCondition().containsKey(map.get("columnHiddenName") + "") && 
								!StringUtils.isEmpty(queryModel.getCondition().get(map.get("columnHiddenName") + "") + "")) {
							if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
								sql.append(" and X.ACCT_ORG_ID"+ 
										"'" + queryModel.getCondition().get(map.get("columnHiddenName") + "") + "'");
							}else {
								sql.append(" and X." + map.get("columnName") + map.get("compareChar") + 
										"'" + queryModel.getCondition().get(map.get("columnHiddenName") + "") + "'");
							}

						}
					}
				} else if (map.get("dateSpan") != null) {
					if(queryModel.getCondition().containsKey(map.get("dateSpan") + "1") && 
							!StringUtils.isEmpty(queryModel.getCondition().get(map.get("dateSpan") + "1") + "")&&  
	                        !"".equals(queryModel.getCondition().get(map.get("dateSpan") + "1"))&& 
	                        queryModel.getCondition().get(map.get("dateSpan") + "1")!= null) {
						if(new Integer(2).equals(map.get("dataType"))) {	// 日期组件, 此处后续要考虑数据库的适配 TODO
							String dateFormat = map.get("dateFormat") + "";
							sql.append(" and X." + map.get("columnName") + ">=" + "to_date('" + queryModel.getCondition().get(map.get("dateSpan") + "1") + "', '" + dateFormat + "')");
						} else {
							sql.append(" and X." + map.get("columnName") + ">=" + "'" + queryModel.getCondition().get(map.get("dateSpan") + "1") + "'");
						}
					}
					if(queryModel.getCondition().containsKey(map.get("dateSpan") + "2") && 
							!StringUtils.isEmpty(queryModel.getCondition().get(map.get("dateSpan") + "2") + "")&&  
	                        !"".equals(queryModel.getCondition().get(map.get("dateSpan") + "2"))&& 
	                        queryModel.getCondition().get(map.get("dateSpan") + "2")!= null){
						if(new Integer(2).equals(map.get("dataType"))) {	// 日期组件, 此处后续要考虑数据库的适配 TODO
							String dateFormat = map.get("dateFormat") + "";
							sql.append(" and X." + map.get("columnName") + "<=" + "to_date('" + queryModel.getCondition().get(map.get("dateSpan") + "2") + "', '" + dateFormat + "')");
						} else {
							sql.append(" and X." + map.get("columnName") + "<=" + "'" + queryModel.getCondition().get(map.get("dateSpan") + "2") + "'");
						}
					}
				} else if (map.get("dateOnly") != null) {
					if(queryModel.getCondition().containsKey(map.get("dateOnly") + "") && 
							!StringUtils.isEmpty(queryModel.getCondition().get(map.get("dateOnly") + "") + "")&&  
	                        !"".equals(queryModel.getCondition().get(map.get("dateOnly") + ""))&& 
	                        queryModel.getCondition().get(map.get("dateOnly") + "")!= null){
						if(new Integer(2).equals(map.get("dataType"))) {	// 日期组件, 此处后续要考虑数据库的适配 TODO
							String dateFormat = map.get("dateFormat") + "";
							sql.append(" and X." + map.get("columnName") + "=" + "to_date('" + queryModel.getCondition().get(map.get("dateOnly") + "") + "', '" + dateFormat + "')");
						} else {
							sql.append(" and to_date(X." + map.get("columnName") + ",'yyyy-mm-dd') =" + "to_date('" + queryModel.getCondition().get(map.get("dateOnly").toString()) + "','yyyy-mm-dd')");
						}
					}
				} else if (map.get("moneySpan") != null) {
					if(queryModel.getCondition().containsKey(map.get("moneySpan") + "1") && 
							!StringUtils.isEmpty(queryModel.getCondition().get(map.get("moneySpan") + "1") + "")&&  
	                        !"".equals(queryModel.getCondition().get(map.get("moneySpan") + "1"))&& 
	                        queryModel.getCondition().get(map.get("moneySpan") + "1")!= null) {
							sql.append(" and to_number(X." + map.get("columnName") + ") >= to_number('" + queryModel.getCondition().get(map.get("moneySpan") + "1") + "')");
					}
					if(queryModel.getCondition().containsKey(map.get("moneySpan") + "2") && 
							!StringUtils.isEmpty(queryModel.getCondition().get(map.get("moneySpan") + "2") + "")&&  
	                        !"".equals(queryModel.getCondition().get(map.get("moneySpan") + "2"))&& 
	                        queryModel.getCondition().get(map.get("moneySpan") + "2")!= null){
							sql.append(" and to_number(X." + map.get("columnName") + ") <= to_number('" + queryModel.getCondition().get(map.get("moneySpan") + "2") + "')");
					}
				} else {
					if(queryModel.getCondition().containsKey(map.get("columnName") + "") && 
							!StringUtils.isEmpty(queryModel.getCondition().get(map.get("columnName") + "") + "")) {
						sql.append(" and X." + map.get("columnName") + " " +map.get("compareChar") + 
								("like".equals(map.get("compareChar") + "") ? "'%" + queryModel.getCondition().get(map.get("columnName") + "") + "%'" : "'" + queryModel.getCondition().get(map.get("columnName") + "") + "'"));
					}
				}
			}
			if(queryModel.getCondition().containsKey("DSTR_STS") && 
					!StringUtils.isEmpty(queryModel.getCondition().get("DSTR_STS") + "")) {
				sql.append(" and X.DSTR_STS = '" + queryModel.getCondition().get("DSTR_STS") + "' ");
			}

			try {
				PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
				Page<Map<String, Object>> list = commonClaimMapper.queryList(sql.toString(), queryModel);
				PageHelper.clearPage();
				List<Map<String, Object>> destList = mapKeyToUnderline(list.getResult());
				list.clear();
				list.addAll(destList);
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				throw new YuspException("500", "该业务功能字段配置有误");
			}
		} else {
			throw new YuspException("500", "业务编码funCode字段缺失");
		}
	}
	
	/**
	 * @方法名称: mapKeyToUnderline
	 * @方法描述: map的key转化为下划线
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	private static List<Map<String, Object>> mapKeyToUnderline(List<Map<String, Object>> list) {
		List<Map<String, Object>> destList = new ArrayList<Map<String, Object>>();
		for(Map<String, Object> map : list) {
			Map<String, Object> tempMap = new HashMap<String, Object>();
			for(String key : map.keySet()) {
				tempMap.put(CommonDistributionService.HumpToUnderline(key), map.get(key));
			}
			destList.add(tempMap);
		}
		return destList;
	}

	private String builderQuerySql(Map<String, Object> funInfoMap, String dataAuth, String dataBussAuth) {
		AdminBaseMetaFunReg adminBaseMetaFunReg = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
		String funCode = adminBaseMetaFunReg.getFunCode();
        
        // 获取分配主键list
        List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
        // 获取分配信息表信息
        Map<String, String> infoTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
        String infoTableName = infoTableMap.get("tableName");
        // 获取分配区间表信息
        Map<String, String> periodTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
        String periodTableName = periodTableMap.get("tableName");
        // 获取分配明细表信息
        Map<String, String> distributeTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
        String distributeTabName = distributeTableMap.get("tableName");
        // 获取区间历史表信息
        Map<String, String> periodHisTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
        String periodHisTabName = periodHisTableMap.get("tableName");
        
        /** 是否配置绩效比例 */
        boolean showPerfRateCfg = ("1".equals(commonDistributionService.getPageCfgValue(funInfoMap, "HAS_JXBL"))) ? true : false;
        /** 分配类型:1,比例分配; 2,比例+定额分配 */
        String dstrType = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_TYPE");
        String dstrPeriod = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_PERIOD");
        
        StringBuffer sb = new StringBuffer("");
        // 构建查询列
        sb.append(" SELECT ").append(this.getClaimColumnStr(funInfoMap, "A"));
        

        if(!"1".equals(dstrPeriod)) sb.append(" ,P.EFFECT_DATE, P.EXPIRATE_DATE "); // 多区间
        
        if(showPerfRateCfg) sb.append(" ,D.PERF_RATE ");

        if("1".equals(dstrType)) sb.append(" ,D.DISTR_RATE "); // 比例分配
        else if("2".equals(dstrType)) sb.append(" ,D.DISTR_RATE ,D.START_AMT ,D.END_AMT "); // 比例+定额 分配
        
        sb.append(" ,D.MANAGER_ID, U.USERNAME AS MANAGER_NAME ");
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(",acci.ACCT_ORG_ID");
		}
        sb.append(" from ").append(infoTableName).append(" A ");
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" LEFT JOIN PMA_F_CUST_ACCT_INFO ACCI ON A.CUST_ID = ACCI.CUST_ID ");
		}
        sb.append(" LEFT JOIN ");
		// 子查询,表a,关联查出是否正在审批
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String now = format.format(new Date()); // 审批结束时间点验证
		sb.append("(SELECT DISTINCT ");
		for (String pk : pkList) {
			sb.append(pk).append(",");
		}
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" ACCT_ORG_ID , ");
		}
		sb.append("APPLY_STS,APPLY_ID,DATA_SRC FROM ");
		sb.append(periodHisTabName);
		sb.append(" WHERE APPLY_STS = '").append(DistributionConstants.UNDER_APPROVAL).append("' ");
		sb.append(" AND EXPIRATE_DATE>='").append(now).append("' "); // 验证历史表结束时间点
		sb.append(") C ON 1=1 ");
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" AND C.CUST_ID = ACCI.CUST_ID AND C.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
		} else {
			for (String pk : pkList) {
				sb.append(" AND A.").append(pk).append("=C.").append(pk);
			}
		}
		// 历史表中有审批通过的一条数据就应为已分配数据
		sb.append(" LEFT JOIN ");
		// 子查询,表a,关联查出是否正在审批
		sb.append("(SELECT DISTINCT ");
		for (String pk : pkList) {
			sb.append(pk).append(",");
		}
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" ACCT_ORG_ID , ");
		}
		sb.append("APPLY_STS FROM "); // ,APPLY_ID,DATA_SRC

		sb.append(periodHisTabName);
		sb.append(" WHERE APPLY_STS = '").append(DistributionConstants.APPLY_APPROVED).append("'");
		sb.append(" AND EXPIRATE_DATE>='").append(now).append("' "); //验证历史表结束时间点
		sb.append(") B ON 1=1 ");
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" AND B.CUST_ID = ACCI.CUST_ID AND B.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
		}else {
			for (String pk : pkList) {
				sb.append(" AND A.").append(pk).append("=B.").append(pk);
			}
		}
		// 历史表中有审批通过的一条数据就应为已分配数据
		sb.append(" LEFT JOIN ");
		// 子查询,表a,关联查出是否正在审批
		sb.append("(SELECT DISTINCT ");
		for (String pk : pkList) {
			sb.append(pk).append(",");
		}
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" ACCT_ORG_ID , ");
		}
		sb.append("APPLY_STS FROM "); // ,APPLY_ID,DATA_SRC

		sb.append(periodHisTabName);
		sb.append(" WHERE APPLY_STS = '").append(DistributionConstants.AUTO_APPROVED).append("'");
		sb.append(" AND EXPIRATE_DATE>='").append(now).append("' "); //验证历史表结束时间点
		sb.append(") E ON 1=1 ");
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" AND E.CUST_ID = ACCI.CUST_ID AND E.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
		}else {
			for (String pk : pkList) {
				sb.append(" AND A.").append(pk).append("=E.").append(pk);
			}
		}
        //增加分配状态    left join 语句   by   mayan   end
        sb.append(" LEFT JOIN ");
        sb.append("( select * from  ").append(periodTableName).append(" where 1=1    ");
        if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
        	sb.append(" AND ACCT_ORG_ID = '").append(userInfoService.getGrantOrgCode()).append("' ");
        }
        sb.append(") P ON 1=1 ");
        
        for (String pk : pkList)
        {
            sb.append(" AND A.").append(pk).append("= P.").append(pk);
        }
        sb.append(" LEFT JOIN ").append(distributeTabName).append(" D ON P.ID = D.PERIOD_ID ");
        sb.append(" AND  P.EXPIRATE_DATE = '20991231'  ");
        sb.append(" LEFT JOIN SYS_USERS U ON D.MANAGER_ID = U.USERID ");
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
	        sb.append(" WHERE 1=1");
		}else {        
			sb.append(" WHERE 1=1 and a.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
		}
        /** 添加数据权限 */
        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);
		try {
			if (DATA_AUTH_TYPE.CUR_ORG.toString().equals(dataAuth)) { // 当前机构权限
				if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
					sb.append(" AND ACCI.ACCT_ORG_ID");
					sb.append("='").append(userInfoService.getGrantOrgCode()).append("'");
				}else {
					sb.append(" AND A.").append(orgColumnMap.get("columnName"));
					sb.append("='").append(userInfoService.getGrantOrgCode()).append("'");
				}

			} else if (DATA_AUTH_TYPE.SUB_ORG.toString().equals(dataAuth)) { // 辖内机构权限
				if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
					sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE ACCI.ACCT_ORG_ID");
					sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
					sb.append(userInfoService.getGrantOrgCode()).append(")($|,)') )");
				}else {
					sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE A.");
					sb.append(orgColumnMap.get("columnName"));
					sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
					sb.append(userInfoService.getGrantOrgCode()).append(")($|,)') )");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new YuspException("500", "业务信息表【" + infoTableName + "】机构字段未配置");
		}
        
        sb.append(" AND NOT EXISTS (SELECT 1 FROM ");
        sb.append(periodHisTabName);
        sb.append(" H WHERE H.APPLY_STS = '");
        sb.append(DistributionConstants.UNDER_APPROVAL + "' ");
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append(" AND ACCI.CUST_ID = H.CUST_ID AND H.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
		}else {
	        for (String pk : pkList) {
	            sb.append(" AND A.").append(pk).append("=H.").append(pk);
	        }
		}
        sb.append(") ");
        
        /** 增加排序字段 */
        sb.append(" ORDER BY ");
		for (String pk : pkList) {
			sb.append(" A.").append(pk).append(",");
		}
        sb.append(" P.EFFECT_DATE ");
        
        return sb.toString();
	}
	
	/**
	 * @方法名称: getImpColumnStr
	 * @方法描述: 获取信息表中的导入字段，各字段以逗号分隔
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public String getClaimColumnStr(Map<String, Object> funInfoMap, String alias) {
		AdminBaseMetaFunReg adminBaseMetaFunReg = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
		String funCode = adminBaseMetaFunReg.getFunCode();
        StringBuffer columnStr = new StringBuffer();
        // 获取信息表Map
        Map<String, String> tableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
        String infoTableCode = tableMap.get("tableCode");
        // 获取字段信息
        Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
        // 获取信息表字段配置
        Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
        // 获取信息表的字段信息
        Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
        Set<String> columnSet = columnMap.keySet();
        for (String columnCode : columnSet) {
            String columnName = columnMap.get(columnCode).get("columnName") + "";
            if("DSTR_STS".equals(columnName)) {
        		continue;
        	}
			if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
				if ("ACCT_ORG_ID".equals(columnName)) { 
					continue;
				}
			}
            Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
            if(cfgMap != null) {
            	if(cfgMap.get("CLM_GRID_FIELD") != null && DistributionConstants.YES.equals(cfgMap.get("CLM_GRID_FIELD"))) {
                    columnStr.append(alias).append(".").append(columnName).append(",");
            	} else if(cfgMap.get("CLM_SEARCH_FIELD") != null && DistributionConstants.YES.equals(cfgMap.get("CLM_SEARCH_FIELD"))) {	// 如果是查询项 也需要拼接sql的查询字段
                    columnStr.append(alias).append(".").append(columnName).append(",");
            	}
            }
        }
     // mayan   增加分配状态展示列  end
        // mayan   增加分配状态展示列  start
        columnStr.append("CASE WHEN C.APPLY_STS IS NOT NULL THEN '");
        columnStr.append(DistributionConstants.TO_APPROVE);
        columnStr.append("' ELSE (CASE WHEN B.APPLY_STS IS NOT NULL ");
        columnStr.append(" THEN '");
        columnStr.append(DistributionConstants.DISTRIBUTED);
        columnStr.append("' ELSE (CASE WHEN E.APPLY_STS IS NOT NULL THEN '"
				+ DistributionConstants.AUTO_APPROVE+"' ELSE '"
						+DistributionConstants.UNDISTRIBUTED+ "' END) ");
        columnStr.append(" END) END AS DSTR_STS,");
        if(null != columnStr && 0 < columnStr.length()) {// 删除最后的逗号
            columnStr.deleteCharAt(columnStr.length() - 1);
        }

        return columnStr.toString();
    }
	
	/**
	 * @方法名称: getSearchFieldSet
	 * @方法描述: 构建查询条件信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @SuppressWarnings({ "unchecked" })
	public Set<Map<String, Object>> getSearchFieldSet(Map<String, Object> funInfoMap) {
		// 查询条件信息集合
		Set<Map<String, Object>> searchFieldSet = new HashSet<Map<String, Object>>();
		// 获取信息表Map
		Map<String, String> tableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		// 获取字段信息
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		// 获取信息表字段配置
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		// 获取信息表的字段信息
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);

		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {// 遍历信息表字段
			String columnName = columnMap.get(columnCode).get("columnName") + "";
			Map<String, String> columnCfgMap = (Map<String, String>) columnCfgInfoMap.get(columnCode);
			/** 查询条件配置 */
			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("columnName", columnName);
			if ("number".equals(columnMap.get(columnCode).get("columnType"))) {
				searchMap.put("dataType", DATA_TYPE.Number);
			} else if ("date".equals(columnMap.get(columnCode).get("columnType"))) {
				searchMap.put("dataType", DATA_TYPE.Date);
				searchMap.put("dateFormat", StringUtils.isEmpty(columnCfgMap.get("CLM_DATE_FORMAT") + "") ? "yyyy-MM-dd" : columnCfgMap.get("CLM_DATE_FORMAT") + "");
			} else {
				searchMap.put("dataType", DATA_TYPE.String);
			}

			if (columnCfgMap != null && DistributionConstants.YES.equals(columnCfgMap.get("CLM_SEARCH_FIELD"))) {
				if (DistributionConstants.YES.equals(columnCfgMap.get("CLM_LIKE_SEARCH"))) {
					searchMap.put("compareChar", "like");
				} else {
					searchMap.put("compareChar", "=");
				}
				if (SEARCH_TYPE.ORG_CHOOSE.toString().equals(columnCfgMap.get("CLM_SEARCH_TYPE"))) {
					searchMap.put("columnHiddenName", columnName);
					if (!DistributionConstants.NO.equals(columnCfgMap.get("SUB_ORG"))) {
						searchMap.put("subOrgQuery", DistributionConstants.YES);
					}

				} else if (SEARCH_TYPE.DATE_SPAN.toString().equals(columnCfgMap.get("CLM_SEARCH_TYPE"))) {
					searchMap.put("dateSpan", columnName + "_SPAN");
				} else if (SEARCH_TYPE.DATE_ONLY.toString().equals(columnCfgMap.get("CLM_SEARCH_TYPE"))) {
					searchMap.put("dateOnly", columnName + "_ONLY");
				} else if (SEARCH_TYPE.MONEY_SPAN.toString().equals(columnCfgMap.get("CLM_SEARCH_TYPE"))) {
					searchMap.put("moneySpan", columnName + "_MONEY_SPAN");
				}
			} else { // 没有配置查询项的字段,通过拖动到查询面板,亦可作为查询条件,默认精确匹配输入项查询
				searchMap.put("compareChar", "=");
			}
			searchFieldSet.add(searchMap);
		}
		return searchFieldSet;
	}

	public ResultDto<String> claim(Map<String, Object> map) throws Exception {
		
		ResultDto<String> result = new ResultDto<String>();
		String bizType = "claimDstr";
    	String funCodeJs =(String) map.get("funCode");
		Map<String, Object> funInfoMap = commonDistributionService.getMetaFunInfo(funCodeJs);
        List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
        String pk =  pkList.get(0);
        // 获取分配明细表信息
        Map<String, String> priKeyTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PRI_KEY);
        String priKeyTabName = priKeyTableMap.get("tableName");
		String primaryValue = (String) map.get("primaryValue");
		String orgId = (String) map.get("orgId");
		JSONObject primaryValueArray = JSONObject.fromObject(primaryValue);
		String pkId = "";
		JSONObject primaryValueJson = primaryValueArray;
		pkId = primaryValueJson.getString(pk);
		String managerId = "V"+userInfoService.getGrantOrgCode()+"9999";
		String distrRate = primaryValueJson.getString("distrRate");
		String effectDateNew = primaryValueJson.getString("effectDate").replace("-", "").substring(0, 8);
		Map<Map<String, Object>, List<Map<String, Object>>> dataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
		Map<String ,Object> mapNew = this.insertPkTable(pkId,priKeyTabName,pk);
		Boolean vioUniqueKeyFlag = (Boolean) mapNew.get("vioUniqueKeyFlag");
		if(vioUniqueKeyFlag) {
	    	result.setMessage("认领失败！当前业绩正在被操作!");
	        result.setCode(1);
	    	return result;
		}
		String branchId = mapNew.get("branchId").toString();
		dataMetaMap = this.prapareClaim(orgId,managerId,distrRate,effectDateNew,pkId,dataMetaMap,branchId,funInfoMap,pk);
        
        // 获取区间历史表信息
        Map<String, String> periodHisTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
        String periodHisTabName = periodHisTableMap.get("tableName");
        // 获取区间历史表信息
        Map<String, String> distributeHisTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE_HIS);
        String distributeHisTabName = distributeHisTableMap.get("tableName");
        String instanceId = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 操作时间戳
		String operateTime = format.format(new Date(System.currentTimeMillis()));
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 流程参数
		paramMap.put("funCode", funCodeJs);// 业务功能编码
		paramMap.put("orgId", orgId);//业绩归属机构
		UNIDProducer unid = new UNIDProducer(); // 生成唯一的流程实例号
		instanceId = unid.getUNID();// 工作流ID
		paramMap.put("bizSeqNo", instanceId); // 虚拟行员分配

		//20210512根据总行管理员角色判断不走工作流
		//20210519新加两个角色号不走工作流
		String roleCode = userInfoService.getUserInfo().getRoles().get(0).getCode();
		if("RC011".equals(roleCode)||"RC010".equals(roleCode)||"RC014".equals(roleCode)) {
			paramMap.put("ned", false);
		} else {
			if(funCodeJs.equals("DepPubDstr")||funCodeJs.equals("ComLoanDstr")||funCodeJs.equals("ComFncDstr")) {
				List<String> amtList = commonDistributionService.getDstrAmtKey(funInfoMap);
				BigDecimal amt = new BigDecimal(primaryValueJson.getString(amtList.get(0)));
				BigDecimal amtTwo = new BigDecimal(5000000);
				if(amt.compareTo(amtTwo)==-1) {
					paramMap.put("ned", false);
					
				}else{
					paramMap.put("ned", true);
					bizType = "claimDstrTwo";
				}
			}
			if(funCodeJs.equals("PerDepDstr")||funCodeJs.equals("PerLoanDstr")||funCodeJs.equals("PerFncDstr")) {
				List<String> amtList = commonDistributionService.getDstrAmtKey(funInfoMap);
				BigDecimal amt = new BigDecimal(primaryValueJson.getString(amtList.get(0)));
				BigDecimal amtTwo = new BigDecimal(1000000);
				if(amt.compareTo(amtTwo)==-1) {
					paramMap.put("ned", false);
				}else{
					paramMap.put("ned", true);
					bizType = "claimDstrTwo";
				}
			}
		}
		
			// 保存流程信息,待发起
		Map<String, Object> instanceMap = new HashMap<String, Object>();
		instanceMap.put("pkValue", pkId);
		instanceMap.put("operateTime", operateTime);
		instanceMap.put("paramMap", paramMap);
		instanceMap.put("instanceId", instanceId);
		

        Map<String, Object> columnMap = periodDistrColumnNameList(funInfoMap, pkList);
        String flag = columnMap.get("flag").toString();
        String periodColumnList = columnMap.get("periodColumnList").toString();
        String distributeColumnList =  columnMap.get("distributeColumnList").toString();
		// 4、新增 分配关系历史表、分配关系表数据
        // 审批状态值
        String applySts = DistributionConstants.UNDER_APPROVAL; 
        Set<Map<String, Object>> mapKeySet = dataMetaMap.keySet();
        Integer wfTotalCount = 0;	// 分配区间表 该批次数据量  = 待发起的工作流总数
		for (Map<String, Object> mapKey : mapKeySet) {// 第一层循环，处理区间段
			++wfTotalCount;
			String effectDate =  mapKey.get("effectDate").toString().replaceAll("-","");// 生效日期
			String expirateDate =  mapKey.get("expirateDate").toString().replaceAll("-","");// 失效日期
			UNIDProducer pId = new UNIDProducer(); // 生成唯一的流程实例号
			String nextSeq = pId.getUNID();
			List<Map<String, Object>> distributeList = dataMetaMap.get(mapKey);
			for (int i = 0; i < distributeList.size(); i++) {
				Map<String, Object> distrMap = distributeList.get(i);
				StringBuilder insertDistributeHisSql = new StringBuilder();
				insertDistributeHisSql.append("insert into ");
				insertDistributeHisSql.append(distributeHisTabName);
				insertDistributeHisSql.append("(");
				insertDistributeHisSql.append(distributeColumnList);
				insertDistributeHisSql.append(") VALUES(");
				if(flag.equals("true")) {
					insertDistributeHisSql.append(" sys_guid(),'"+nextSeq+"','"+distrMap.get("DISTR_RATE")+"','"+distrMap.get("MANAGER_ID")+"','03'");
				}else {
					insertDistributeHisSql.append(" sys_guid(),'"+nextSeq+"','"+distrMap.get("DISTR_RATE")+"','"+distrMap.get("MANAGER_ID")+"','03','"+distrMap.get("START_AMT")+"','"+distrMap.get("END_AMT")+"'");
				}

				insertDistributeHisSql.append(")");
	        	this.commonClaimMapper.executeInsertSql(insertDistributeHisSql.toString());
			}
    		StringBuilder insertPeriodHisSql = new StringBuilder();
    		insertPeriodHisSql.append("INSERT INTO ");
    		insertPeriodHisSql.append(periodHisTabName);
    		insertPeriodHisSql.append("(");
    		insertPeriodHisSql.append(periodColumnList);
    		insertPeriodHisSql.append(",APPLY_STS,APPLY_TIME,APPLY_ID) VALUES(");
    		insertPeriodHisSql.append(" '"+effectDate+"','"+expirateDate+"','"+operateTime+"','"+userInfoService.getGrantOrgCode()+"','"+userInfoService.getUserInfo().getLoginCode()+"','03','"+nextSeq+"','"+pkId+"'");
    		insertPeriodHisSql.append(",'"+applySts+"','"+operateTime+"','"+instanceId+"')");
    		this.commonClaimMapper.executeInsertSql(insertPeriodHisSql.toString());
		}
		WFStratDto stratDto = new WFStratDto();
		String bizSeqNo = (String) instanceMap.get("instanceId");
		stratDto.setBizId(bizSeqNo);
		stratDto.setBizType(bizType);
		stratDto.setSystemId("yusp");
		stratDto.setOrgId(orgId);
		stratDto.setUserId(userInfoService.getUserInfo().getLoginCode());
		stratDto.setParam(paramMap);
		stratDto.setBizParam1(funCodeJs);
		commonDistributionService.runEchain4(stratDto);
    	result.setMessage("认领成功！");
        result.setCode(0);
    	return result;

	}
	
	 @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
		private Map<Map<String, Object>, List<Map<String, Object>>> prapareClaim(String orgId, String managerId, String distrRate, String effectDate,
				String cdpId, Map<Map<String, Object>, List<Map<String, Object>>> dataMetaMap, String branchId, Map<String, Object> funInfoMap, String pk) {
	        // 获取分配区间表信息
	        Map<String, String> periodTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
	        String periodTableName = periodTableMap.get("tableName");
	        // 获取分配明细表信息
	        Map<String, String> distributeTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
	        String distributeTabName = distributeTableMap.get("tableName");

	        /**
	         * 插入DHIS表
	         */	
			List<Map<String,Object>> dataList = new ArrayList<Map<String, Object>>();
			if(Integer.valueOf(distrRate)<100) {
				int oldRate = 100-Integer.valueOf(distrRate);
				String oldManagerId = "V"+orgId+"9999";
				Map<String, Object> dataMap = new HashMap<>();
				Map<String, Object> dataMap2 = new HashMap<>();
				dataMap.put(pk, cdpId);
				dataMap.put("EXPIRATE_DATE", "20991231");
				dataMap.put("EFFECT_DATE", effectDate);
				dataMap.put("DISTR_RATE", distrRate);
				dataMap.put("ORG_ID", orgId);
				dataMap.put("MANAGER_ID", managerId);
				dataMap.put("BATCH_ID", branchId);
				dataMap.put("END_AMT", "99999999999999");
				dataMap.put("START_AMT", "0");
				dataMap.put("ALLOT_TYPE", "03");
				dataList.add(dataMap);
				dataMap2.put(pk, cdpId);
				dataMap2.put("EXPIRATE_DATE", "20991231");
				dataMap2.put("EFFECT_DATE", effectDate);
				dataMap2.put("DISTR_RATE", oldRate);
				dataMap2.put("ORG_ID", orgId);
				dataMap2.put("MANAGER_ID", oldManagerId);
				dataMap2.put("BATCH_ID", branchId);
				dataMap2.put("END_AMT", "99999999999999");
				dataMap2.put("START_AMT", "0");
				dataMap2.put("ALLOT_TYPE", "03");
				dataList.add(dataMap2);
			}else {
				Map<String, Object> dataMap = new HashMap<>();
				dataMap.put(pk, cdpId);
				dataMap.put("EXPIRATE_DATE", "20991231");
				dataMap.put("EFFECT_DATE", effectDate);
				dataMap.put("DISTR_RATE", distrRate);
				dataMap.put("ORG_ID", orgId);
				dataMap.put("MANAGER_ID", managerId);
				dataMap.put("BATCH_ID", branchId);
				dataMap.put("END_AMT", "99999999999999");
				dataMap.put("START_AMT", "0");
				dataMap.put("ALLOT_TYPE", "03");
				dataList.add(dataMap);
			}
			for (Map<String, Object> dataMap : dataList) {
				Map<String, Object> metaKeyMap = new HashMap<String, Object>();
				metaKeyMap.put(pk, cdpId);
				metaKeyMap.put("effectDate", dataMap.get("EFFECT_DATE"));
				metaKeyMap.put("expirateDate", dataMap.get("EXPIRATE_DATE"));
				List<Map<String, Object>> distributeList = dataMetaMap.get(metaKeyMap);
				if (null == distributeList) {
					distributeList = new ArrayList<Map<String, Object>>();
				}
				distributeList.add(dataMap);
				dataMetaMap.put(metaKeyMap, distributeList);
			}
			Map<Map<String, Object>, List<Map<String, Object>>> oldDataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
			Map<Map<String, Object>, List<Map<String, Object>>> newDataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
			List<Map<String, Object>> oldDistributeList = this.queryDistributeByPk(cdpId,periodTableName,distributeTabName,pk);
			for (Map<String, Object> oldDistributeMap : oldDistributeList) {// 将同一主键，同一区间段数据存放在一起
				Map<String, Object> oldDataMetaMapKey = new HashMap<String, Object>();
				oldDataMetaMapKey.put("effectDate", oldDistributeMap.get("EFFECT_DATE"));
				oldDataMetaMapKey.put("expirateDate", oldDistributeMap.get("EXPIRATE_DATE"));
				List<Map<String, Object>> distributeList1 = oldDataMetaMap.get(oldDataMetaMapKey);
				if (null == distributeList1) {
					distributeList1 = new ArrayList<Map<String, Object>>();
				}
				distributeList1.add(oldDistributeMap);
				oldDataMetaMap.put(oldDataMetaMapKey, distributeList1);
			}
			if (0 < oldDataMetaMap.size()) {// 有1个以上的区间需要拆分处理
				Set<Map<String, Object>> oldDataMetaMapKeySet = oldDataMetaMap.keySet();
				for (Map<String, Object> keyMap : oldDataMetaMapKeySet) {
					String oldEffectDate = (String) keyMap.get("effectDate");
					String oldExpirateDate = (String) keyMap.get("expirateDate");
					if (DateUtil.getShortDateTime(effectDate).after(DateUtil.getShortDateTime(oldExpirateDate))) {
						// 无需拆分，保留原有分配关系
						Map<String, Object> newMetaMapKey = new HashMap<String, Object>();
						newMetaMapKey.put(pk, cdpId);
						newMetaMapKey.put("effectDate", oldEffectDate);
						newMetaMapKey.put("expirateDate", oldExpirateDate);
						newDataMetaMap.put(newMetaMapKey, oldDataMetaMap.get(keyMap));
					} else if (effectDate.equals(oldEffectDate)) {
						Map<String, Object> newMetaMapKey = new HashMap<String, Object>();
						newMetaMapKey.put(pk, cdpId);
						newMetaMapKey.put("effectDate", oldEffectDate);
						newMetaMapKey.put("expirateDate", "20991231");
						newDataMetaMap.put(newMetaMapKey, dataMetaMap.get(newMetaMapKey));
					} else {
						// 拆分的前半段
						Map<String, Object> newMetaMapKey = new HashMap<String, Object>();
						newMetaMapKey.put(pk, cdpId);
						newMetaMapKey.put("effectDate", oldEffectDate);
						newMetaMapKey.put("expirateDate", DateUtil.getPreviousDateShort(effectDate));
						newDataMetaMap.put(newMetaMapKey, oldDataMetaMap.get(keyMap));

						// 拆分的后半段
						Map<String, Object> newMetaMapKeyTemp = new HashMap<String, Object>();
						newMetaMapKeyTemp.put(pk, cdpId);
						newMetaMapKeyTemp.put("effectDate", effectDate);
						newMetaMapKeyTemp.put("expirateDate", "20991231");
						newDataMetaMap.put(newMetaMapKeyTemp, dataMetaMap.get(newMetaMapKeyTemp));
					}
				}
			} else {// 如果只有一个区间则直接以Excel上的新数据为准
				Map<String, Object> newMetaMapKey = new HashMap<String, Object>();
				newMetaMapKey.put(pk, cdpId);
				newMetaMapKey.put("effectDate", effectDate);
				newMetaMapKey.put("expirateDate", "20991231");
				newDataMetaMap.put(newMetaMapKey, dataMetaMap.get(newMetaMapKey));
			}
			return newDataMetaMap;
		}
		/**
		 * @param periodTableName 
		 * @param distributeTabName 
		 * @param pk 
		 * @方法名称: queryDistributeByPk
		 * @方法描述: 获取原有所有分配关系
		 * @参数与返回说明:
		 * @算法描述:
		 */
		public List<Map<String, Object>> queryDistributeByPk(String cdpId, String periodTableName, String distributeTabName, String pk) {
			StringBuffer sql = new StringBuffer();
			List<String> distributeColumnList = new ArrayList<String>();
			distributeColumnList.addAll(DistributionConstants.DISTRIBUTE_COLUMN_LIST_NEW);

			String insertDistributeColumn = commonDistributionService.listToString(distributeColumnList);
			sql.append(" SELECT distinct P.EFFECT_DATE,P.EXPIRATE_DATE, P.");
			sql.append(insertDistributeColumn).append(","+pk);
			sql.append(" FROM ");
			sql.append(periodTableName);
			sql.append(" P INNER JOIN ");
			sql.append(distributeTabName);
			sql.append(" D ON P.ID = D.PERIOD_ID WHERE 1=1 ");
			sql.append(" AND P."+pk+" = '"+cdpId+"'");

			sql.append(" ORDER BY P.EFFECT_DATE ASC ");
			// 获取原有分配关系
			List<Map<String, Object>> distributeList = commonClaimMapper.executeQuerySql(sql.toString());
			distributeList = mapKeyToUnderline(distributeList);
			List<Map<String, Object>> retDstrImpVoList = new ArrayList<Map<String, Object>>();
			if (null != distributeList && 0 < distributeList.size()) {
				for (int i = 0; i < distributeList.size(); i++) {
					retDstrImpVoList.add(distributeList.get(i));
				}
			}
			return retDstrImpVoList;
		}
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	private Map<String,Object> insertPkTable(String cdpId, String priKeyTabName, String pk) {
		Boolean vioUniqueKeyFlag = false;
		StringBuilder insertmutex = new StringBuilder(); 
		String branchId = "";
    	try {
    		UNIDProducer uuid = new UNIDProducer(); // 生成唯一的流程实例号
    		String uuidStr = uuid.getUNID();// 工作流ID
			branchId = uuidStr;
        	insertmutex.append("INSERT INTO ");
        	insertmutex.append(priKeyTabName);
        	insertmutex.append("(ID,TYPE_CODE,CREATE_TIME,BATCH_ID,CREATE_USER,"+pk);
        	insertmutex.append(")VALUES(");
        	insertmutex.append("'"+uuidStr+"','2',sysDate,'"+uuidStr+"','"+userInfoService.getUserInfo().getLoginCode()+"','"+cdpId+"'");
        	insertmutex.append(")");
        	this.commonClaimMapper.executeInsertSql(insertmutex.toString());
    	} 
    	catch (DataAccessException e) {
    		e.printStackTrace();
    		if(e.getCause().getMessage() != null && e.getCause().getMessage().indexOf("ORA-00001") >= 0) {	// 判断是 违反唯一约束条件
    			vioUniqueKeyFlag = true;
    		} else {
    			throw e;
    		}
    	}
    	Map<String,Object> map = new HashMap<>();
    	map.put("vioUniqueKeyFlag", vioUniqueKeyFlag);
    	map.put("branchId", branchId);
    	return map;
    	}
	/**
	 * @方法名称: makePeriodAndDistrColumnNameList
	 * @方法描述: 生成 分配区间表、分配关系表 字段名list
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> periodDistrColumnNameList(Map<String, Object> funInfoMap, List<String> pkList) {
		Map<String, Object> resultMap = new HashMap<String,Object>();
		Map<String, String> pageCfgMap = (Map<String, String>) funInfoMap.get("pageCfgInfo");
        List<String> periodColumnList = new ArrayList<String>();
        List<String> distributeColumnList = new ArrayList<String>();
        // 分配区间表字段列表(不含主键列表pkList,不含三个审批字段)
        periodColumnList.addAll(DistributionConstants.PERIOD_COLUMN_LIST);
        periodColumnList.addAll(pkList);
        // 分配关系表字段列表(生效表与历史表字段一致)
        distributeColumnList.addAll(DistributionConstants.DISTRIBUTE_COLUMN_LIST);
		if (!DistributionConstants.YES.equals(pageCfgMap.get("HAS_JXBL"))) {
			distributeColumnList.remove(distributeColumnList.indexOf("PERF_RATE"));
		}
		if (!"2".equals(pageCfgMap.get("DSTR_TYPE"))) { // 分配类型:1,比例分配; 2,比例+定额
			distributeColumnList.remove(distributeColumnList.indexOf("START_AMT"));
			distributeColumnList.remove(distributeColumnList.indexOf("END_AMT"));
			resultMap.put("flag", "true");
		}else {
			resultMap.put("flag", "false");
		}
		if (!DistributionConstants.YES.equals(pageCfgMap.get("HOST_CFG"))) {
			distributeColumnList.remove(distributeColumnList.indexOf("HOST_CFG"));
		}
		String distributeColumn = "";
		for (int j = 0; j < distributeColumnList.size(); j++) {
			distributeColumn = distributeColumn + distributeColumnList.get(j) + ",";
		}
		if(!distributeColumn.equals("")) {
			distributeColumn = distributeColumn.substring(0,distributeColumn.length()-1);
		}
		String periodColumn = "";
		for (int j = 0; j < periodColumnList.size(); j++) {
			periodColumn = periodColumn + periodColumnList.get(j) + ",";
		}
		if(!periodColumn.equals("")) {
			periodColumn = periodColumn.substring(0,periodColumn.length()-1);
		}
		resultMap.put("periodColumnList", periodColumn);
		resultMap.put("distributeColumnList", distributeColumn);
		return resultMap;
	}
}