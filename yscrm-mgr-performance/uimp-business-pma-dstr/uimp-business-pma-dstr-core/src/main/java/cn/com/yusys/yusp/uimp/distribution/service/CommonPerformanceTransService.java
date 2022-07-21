package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.base.utils.DateUtil;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.DATA_AUTH_TYPE;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.DATA_SRC;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.FUN_SUB_TYPE;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonPerformanceTransMapper;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceTransService
 * @类描述: # 业绩转移接口 服务类
 * @功能描述: 
 * @创建人: xujiawei
 * @创建时间: 2020-02-17 15:03:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CommonPerformanceTransService extends CommonService{

	@Autowired
	private MetaFunctionManagerService metaFunctionManagerService;
	
	public static final String DEF_SHORT = "yyyyMMdd";
	
	private final static Object obj = new Object();	
	
	@Autowired
	private CommonDistributionService commonDistributionService;
	
    @Autowired
    private CommonPerformanceTransMapper commonPerformanceTransMapper;
    
	@Autowired
	private UserInfoService userInfoService;
	
    /** 业务注册信息 */
    @SuppressWarnings("unused")
    private AdminBaseMetaFunReg regInfo;

    /** 分配区间生效表信息 */
    private Map<String, String> periodTableInfo;

    /** 分配关系生效表信息 */
    private Map<String, String> distributeTableInfo;

    /** 分配区间生效表名 */
    private String periodTableName;

    /** 分配关系生效表名 */
    private String distributeTableName;

    /** 分配主键list */
    protected List<String> pkList;

    /** 插入分配区间表的字段字符串,以逗号分隔 */
    protected String insertPeriodColumn;

    /** 插入分配关系表的字段字符串,以逗号分隔 */
    protected String insertDistributeColumn;
    
    protected String insertDistributeSumColumn;
    
	@SuppressWarnings("rawtypes")
	protected CommonMapper getMapper() {
		return commonPerformanceTransMapper;
	}

	public Map<String, Object> getMetaFunInfo(String funCodeJs) throws Exception {
		return metaFunctionManagerService.getMetaFunInfo(funCodeJs);
	}
	
	/**
	 * @方法名称: getTableMap
	 * @方法描述: 获取指定表的信息map
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> getTableMap(Map<String, Object> funInfoMap, FUN_SUB_TYPE subType) {
		Map<String, Object> tableInfoMap = (Map<String, Object>) funInfoMap.get("tableInfo");
		Set<String> tableCodeSet = tableInfoMap.keySet();
		for (String tableCode : tableCodeSet) {
			Map<String, String> map = (Map<String, String>) tableInfoMap.get(tableCode);
			if (subType.toString().equals(map.get("funSubType"))) {
				return map;
			}
		}
		return null;
	}
	
	/** 
	 * @Title getInfoPrimaryKey 
	 * @Description 获取分配主键字段名称
	 * @param funInfoMap
	 * @param type
	 * @return List<String>
	 */ 
	@SuppressWarnings("unchecked")
	public List<String> getInfoPrimaryKey(Map<String, Object> funInfoMap, FUN_SUB_TYPE type) {
		List<String> pkList = new ArrayList<String>();
		Map<String, String> tableMap = getTableMap(funInfoMap, type);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
		AdminBaseMetaFunReg regInfoMap = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
		String funCode = regInfoMap.getFunCode();
		if (columnMap == null) {
			throw new YuspException("500", "业务编码:[" + funCode + "]字段信息缺失");
		}
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap
					.get(columnCode);
			if (cfgMap != null
					&& DistributionConstants.YES.equals(cfgMap.get("IS_PK"))) {
				pkList.add(columnMap.get(columnCode).get("columnName")
						.toString());
			}
		}
		if (pkList.size() == 0) {
			throw new YuspException("500", "业务编码:[" + funCode + "]业务信息表未设置【主键】项,请检查");
		}
		return pkList;
	}
	@Transactional(readOnly = true)
	public List<Map<String, Object>> querylist(QueryModel model) throws Exception {

        String managerId = model.getCondition().get("managerId").toString()!= null ? model.getCondition().get("managerId") + "" : "";
//        String orgId = model.getCondition().get("orgId").toString();
        String dataAuth = model.getCondition().get("dataAuth") != null ? model.getCondition().get("dataAuth") + "" : "";
//        String dataBussAuth = model.getCondition().get("dataBussAuth").toString(); // 条线权限
        String funCodeJs = model.getCondition().get("funCode").toString();
        if(managerId.indexOf(",")>=0){
        	managerId=managerId.replaceAll(",", "','");
        }
        /** 获取功能信息缓存 */
        Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);

        /** 获取业务功能信息主表 */
        Map<String, String> infoTableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
        String infoTableName = infoTableMap.get("tableName");// 获取业务功能信息主表表名
        List<String> pkList = getInfoPrimaryKey(funInfoMap, FUN_SUB_TYPE.INFO);

        /** 获取分配区间段主表 */
        Map<String, String> periodTableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
        String periodTableName = periodTableMap.get("tableName");// 获取区间段信息表表名

        /** 获取分配明细主表 */
        Map<String, String> distributeTableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
        String distributeTableName = distributeTableMap.get("tableName");// 获取分配明细信息表表名

        /** 获取分配历史信息主表 */
        Map<String, String> periodHisTableMap = getTableMap( funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
        String periodHisTableName = periodHisTableMap.get("tableName");// 获取分配历史信息表表名
        
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT K.USERID AS MANAGER_ID, K.USERNAME AS MANAGER_NAME ");
        sqlBuilder.append("FROM SYS_USERS K ");
        sqlBuilder.append("INNER JOIN ");
        sqlBuilder.append(" (SELECT distinct X.MANAGER_ID FROM  ");
        sqlBuilder.append(distributeTableName).append(" X ");
        sqlBuilder.append(" INNER JOIN ");
        sqlBuilder.append(" (SELECT B.ID, D.OPEN_DATE");
        sqlBuilder.append(" FROM ").append(periodTableName);
        sqlBuilder.append(" B ");
        sqlBuilder.append(" left join  ");
        sqlBuilder.append(periodHisTableName).append(" C");
        sqlBuilder.append(" ON ");
        for (int i = 0; i < pkList.size(); i++) {
            sqlBuilder.append(" B.").append(pkList.get(i));
            sqlBuilder.append(" = C.").append(pkList.get(i));
            if(i!=pkList.size()-1) {
            	sqlBuilder.append(" AND");
            }
        }
		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
			sqlBuilder.append("AND B.ACCT_ORG_ID = C.ACCT_ORG_ID");
		}
        sqlBuilder.append(" AND C.APPLY_STS <>'");
        sqlBuilder.append(DistributionConstants.UNDER_APPROVAL).append("' ");
        sqlBuilder.append(" left join  ").append(infoTableName).append(" D ON ");
        for (int i = 0; i < pkList.size(); i++) {
            sqlBuilder.append(" B.").append(pkList.get(i));
            sqlBuilder.append(" = D.").append(pkList.get(i));
            if(i!=pkList.size()-1) {
            	sqlBuilder.append(" AND");
            }
        }
    	// 增加-数据日期过滤：即当前跑批日期前一天的数据
        if(!"ComCustDstr".equals(funCodeJs) && !"PerCustDstr".equals(funCodeJs)) {
        	sqlBuilder.append(" and D.ETL_DATE in (SELECT TO_CHAR(TRUNC(to_date(etl_date, 'YYYYMMDD')-1), 'YYYYMMDD') AS etl_date FROM PMA_F_ETL_DATE WHERE etl_type = 'PMA' AND etl_state = '1') ");
        }
//        sqlBuilder.append(" AND EXISTS (SELECT 1 FROM ").append(infoTableName);
		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
			sqlBuilder.append(" LEFT JOIN PMA_F_CUST_ACCT_INFO E ON D.CUST_ID = E.CUST_ID");
			sqlBuilder.append(" AND E.ACCT_ORG_ID = B.ACCT_ORG_ID ");
		}
//        for (int i = 0; i < pkList.size(); i++) {
//            sqlBuilder.append(" AND B.").append(pkList.get(i));
//            sqlBuilder.append(" = D.").append(pkList.get(i));
//        }

//		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
//			
//		}
        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);

        try {
            if (DATA_AUTH_TYPE.CUR_ORG.toString().equals(dataAuth)) { // 当前机构权限
        		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
                    sqlBuilder.append(" AND E.ACCT_ORG_ID");
                    sqlBuilder.append("='").append(userInfoService.getGrantOrgCode()).append("'");
                    if(model.getCondition().containsKey("orgId")){
                    	String orgId =model.getCondition().get("orgId").toString();
                        if(orgId!=null&&!"".equals(orgId)){
                        	sqlBuilder.append(" AND E.ACCT_ORG_ID='"+orgId+"' ");
                        }
                   }
        		}else {
                    sqlBuilder.append(" AND D.").append(orgColumnMap.get("columnName"));
                    sqlBuilder.append("='").append(userInfoService.getGrantOrgCode()).append("'");
                    if(model.getCondition().containsKey("orgId")){
                    	String orgId =model.getCondition().get("orgId").toString();
                        if(orgId!=null&&!"".equals(orgId)){
                        	sqlBuilder.append(" AND D.").append(orgColumnMap.get("columnName"));
                        	sqlBuilder.append("='").append(orgId).append("'");
                        }
                   }
        		}
            } else if (DATA_AUTH_TYPE.SUB_ORG.toString().equals(dataAuth)&&!"custDstr".equals(funCodeJs)) { // 辖内机构权限
        		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
        			sqlBuilder.append(" LEFT JOIN SYS_UNITS CX ON E.ACCT_ORG_ID = CX.UNITID AND REGEXP_LIKE (CX.UNITSEQ,'(^|,)(");
                    sqlBuilder.append(userInfoService.getGrantOrgCode()).append(")($|,)')");
                    if(model.getCondition().containsKey("orgId")){
                    	String orgId =model.getCondition().get("orgId").toString();
                        if(orgId!=null&&!"".equals(orgId)){
                        	sqlBuilder.append("AND REGEXP_LIKE (CX.UNITSEQ,'(^|,)(");
                        	sqlBuilder.append(orgId).append(")($|,)')");
                        }
                   }
        		}else {
        			sqlBuilder.append(" LEFT JOIN SYS_UNITS CX ON D.");
                    sqlBuilder.append(orgColumnMap.get("columnName"));
                    sqlBuilder.append("=CX.UNITID AND REGEXP_LIKE (CX.UNITSEQ,'(^|,)(");
                    sqlBuilder.append(userInfoService.getGrantOrgCode()).append(")($|,)')");
                    if(model.getCondition().containsKey("orgId")){
                    	String orgId =model.getCondition().get("orgId").toString();
                        if(orgId!=null&&!"".equals(orgId)){
                        	sqlBuilder.append("AND REGEXP_LIKE (CX.UNITSEQ,'(^|,)(");
                        	sqlBuilder.append(orgId).append(")($|,)')");
                        }
                   }
        		}
            }
        } catch (Exception e) {
        	throw new YuspException("500", "业务信息表【" + infoTableName + "】机构字段未配置");
        }
        sqlBuilder.append("  WHERE B.Expirate_Date >= to_char(sysdate, 'YYYYMMDD')");
        //新增开户日期开始，开户日期结束查询     start
        if(model.getCondition().containsKey("openDateStart")){
        	String openDateStart =model.getCondition().get("openDateStart").toString();
            if(openDateStart!=null&&!"".equals(openDateStart)){
            	sqlBuilder.append(" AND d.OPEN_DATE >='"+openDateStart.replace("-", "")+"' ");
            }
       }
        if(model.getCondition().containsKey("openDateEnd")){
        	String openDateEnd =model.getCondition().get("openDateEnd").toString();
            if(openDateEnd!=null&&!"".equals(openDateEnd)){
            	sqlBuilder.append(" AND  D.OPEN_DATE <='"+openDateEnd.replace("-", "")+"'");
            }
        }
        sqlBuilder.append(") Y ");
        sqlBuilder.append(" ON X.PERIOD_ID = Y.ID AND X.MANAGER_ID in ('");
        sqlBuilder.append(managerId).append("') ");
        sqlBuilder.append(" )A ON A.MANAGER_ID = K.USERID ");

		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = commonPerformanceTransMapper.listByModel(sqlBuilder.toString());
		PageHelper.clearPage();
		return list;
    }
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryPerformance(QueryModel model) throws Exception {
        String managerId = model.getCondition().get("managerId").toString();
        String dataAuth = model.getCondition().get("dataAuth").toString();
        String orgId = model.getCondition().get("orgId").toString();
//        String dataBussAuth = model.getCondition().get("dataBussAuth").toString();
        String openDateStart=model.getCondition().get("openDateStart").toString();
        String openDateEnd=model.getCondition().get("openDateEnd").toString();
        String funCodeJs = model.getCondition().get("funCode").toString();

        /** 获取功能信息缓存 */
        Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
        /** 区间： 1、单区间；2、多区间 */
        String dstrPeriod = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_PERIOD");
        String  strbuf="";
        if (!"1".equals(dstrPeriod)) {// 多区间
        	strbuf = queryPerformanceByManager(managerId, dataAuth,orgId,openDateStart,openDateEnd,funCodeJs);
        } else {// 单区间
        	strbuf = queryLastPeriodPerformanceByManager(managerId, dataAuth,orgId,openDateStart,openDateEnd,funCodeJs);
        }
		List<Map<String, Object>> list = commonPerformanceTransMapper.queryPerformance(strbuf);
        
		return list;
    }

    /** 
     * <pre>
     * 功能描述: 根据客户经理ID查询客户经理的业绩（明细）
     * @Title: queryPerformanceByManager 
     * @author: xujiawei
     * @param managerId 客户经理id
     * @param dataAuth 数据机构权限
     * @param dataBussAuth 数据条线权限
     * </pre>
     * @throws Exception 
     */ 
	@Transactional(readOnly = true)
    public String  queryPerformanceByManager(String managerId, 
            String dataAuth,String orgId,String openDateStart,String openDateEnd,String funCodeJs) throws Exception {

        StringBuilder sql = this.buildQuerySql(managerId, dataAuth,orgId,openDateStart,openDateEnd,funCodeJs);
        return sql.toString();
    }
    /** 
     * <pre>
     * 功能描述: 根据客户经理ID查询最后一个区间(20991231)的客户经理的业绩（明细）
     * @Title: queryLastPeriodPerformanceByManager 
     * @author: xujiawei
     * </pre>
     * @throws Exception 
     */ 
    @Transactional(readOnly = true)
    public String queryLastPeriodPerformanceByManager(String managerId,
            String dataAuth,String orgId,String openDateStart,String openDateEnd,String funCodeJs) throws Exception {
        StringBuilder sql = buildQuerySql(managerId, dataAuth,orgId,openDateStart,openDateEnd,funCodeJs);
        return sql.toString();
    }
    /** 
     * <pre>
     * 功能描述: 查询客户经理业绩获取sql
     * @Title: buildQuerySql 
     * @author: xujiawei
     * @return: StringBuilder   
     * </pre>
     * @throws Exception 
     */ 
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    private StringBuilder buildQuerySql(String managerId, String dataAuth,String orgId,String openDateStart,String openDateEnd,String funCodeJs) throws Exception {

        /** 获取功能信息缓存 */
        Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);

        /** 区间： 1、单区间；2、多区间 */
        String dstrPeriod = commonDistributionService.getPageCfgValue(funInfoMap,"DSTR_PERIOD");

        /** 获取业务功能信息主表 */
        Map<String, String> infoTableMap = commonDistributionService.getTableMap(funInfoMap,
                FUN_SUB_TYPE.INFO);
        String infoTableName = infoTableMap.get("tableName");// 获取业务功能信息主表表名
        String infoTableCode = infoTableMap.get("tableCode");// 获取业务功能信息主表编码
        List<String> pkList = getInfoPrimaryKey(funInfoMap, FUN_SUB_TYPE.INFO);

        /** 获取分配区间段主表 */
        Map<String, String> periodTableMap
            = getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
        String periodTableName = periodTableMap.get("tableName");// 获取区间段信息表表名

        /** 获取分配明细主表 */
        Map<String, String> distributeTableMap
            = getTableMap( funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
        String distributeTableName = distributeTableMap.get("tableName");// 获取分配明细信息表表名

        /** 获取分配历史信息主表 */
        Map<String, String> periodHisTableMap
            = getTableMap( funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
        String periodHisTableName = periodHisTableMap.get("tableName");// 获取分配历史信息表表名
        AdminBaseMetaFunReg regInfoMap = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
        String funCode = regInfoMap.getFunCode();
        
        StringBuilder queryColumn = new StringBuilder();
        // 字段信息
        Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap .get("columnInfo"); 
        Map<String, Map<String, Object>> columnMap
            = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
        
        Set<String> columnSet = columnMap.keySet();
        for (String columnCode : columnSet) { // 遍历信息表字段
            queryColumn.append("D.");
            queryColumn.append(columnMap.get(columnCode).get("columnName"));
            queryColumn.append(",");
        }
        
        queryColumn.deleteCharAt(queryColumn.length() - 1);
        StringBuilder sqlBuilder = new StringBuilder();
        /**
         * 修改内容: 业绩转移中业绩明细功能查询的数据应以某个分配的用户分组作为一条数据
         *      这里同一个用户下有多少分配区间就重复展示了多少条数据,所以sql加了DISTINCT去除重复
         * 修改人 : xujiawei1 2016.5.13
         */
        sqlBuilder.append(" SELECT DISTINCT Z.*,X.MANAGER_ID,U.USERNAME AS MANAGER_NAME FROM ");
        sqlBuilder.append(" (SELECT A.MANAGER_ID, A.PERIOD_ID FROM ");
        sqlBuilder.append(distributeTableName).append(" A WHERE A.MANAGER_ID ='");
        sqlBuilder.append(managerId).append("')X ");
        sqlBuilder.append(" INNER JOIN (SELECT B.ID ");
        for (String pk : pkList) {
            sqlBuilder.append(", B." + pk);
        }
        sqlBuilder.append(" from ").append(periodTableName).append(" B WHERE 1=1 and B.Expirate_Date >=to_char(sysdate,'YYYYMMDD') ");
        if ("1".equals(dstrPeriod)) {// 如果是单区间
            sqlBuilder.append(" AND B.EXPIRATE_DATE = '20991231' ");
        }
        
        sqlBuilder.append(") Y ON X.PERIOD_ID = Y.ID ");
        sqlBuilder.append(" INNER JOIN (SELECT ").append(queryColumn);
		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
			sqlBuilder.append(" ,ACCI.ACCT_ORG_ID ");
		}
        sqlBuilder.append(" FROM  ").append(infoTableName).append(" D");
        

        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);

        try {
            if (DATA_AUTH_TYPE.CUR_ORG.toString().equals(dataAuth)) { // 当前机构权限
        		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
                    sqlBuilder.append(" AND ACCI.ACCT_ORG_ID");
                    sqlBuilder.append("='").append(userInfoService.getGrantOrgCode()).append("'");
        		}else {
                    sqlBuilder.append(" AND D.").append(orgColumnMap.get("columnName"));
                    sqlBuilder.append("='").append(userInfoService.getGrantOrgCode()).append("'");
        		}
            } else if (DATA_AUTH_TYPE.SUB_ORG.toString().equals(dataAuth)&&!"custDstr".equals(funCode)) { // 辖内机构权限
        		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
        			sqlBuilder.append(" left join SYS_UNITS CX on ACCI.ACCT_ORG_ID=CX.UNITID AND REGEXP_LIKE (CX.UNITSEQ,'(^|,)(");
                    sqlBuilder.append(userInfoService.getGrantOrgCode()).append(")($|,)') ");
                    if(orgId!=null&&!"".equals(orgId)){
                    	sqlBuilder.append(" AND ACCI.ACCT_ORG_ID");
                        sqlBuilder.append("= '"+orgId+"'");
                    }
                    sqlBuilder.append(" LEFT JOIN PMA_F_CUST_ACCT_INFO ACCI ON D.CUST_ID = ACCI.CUST_ID "
        					+ " WHERE 1=1 and d.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA') ");
        		}else {
        			sqlBuilder.append(" left join SYS_UNITS CX on D.");
                    sqlBuilder.append(orgColumnMap.get("columnName"));
                    sqlBuilder.append("=CX.UNITID AND REGEXP_LIKE (CX.UNITSEQ,'(^|,)(");
                    sqlBuilder.append(userInfoService.getOrgCode()).append(")($|,)') ");
                    if(orgId!=null&&!"".equals(orgId)){
                    	sqlBuilder.append(" AND D.");
                        sqlBuilder.append(orgColumnMap.get("columnName"));
                        sqlBuilder.append("= '"+orgId+"'");
                    }
                    sqlBuilder.append(" WHERE 1=1 and d.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");

        		}

            }
        } catch (Exception e) {
        	throw new YuspException("500", "业务信息表【" + infoTableName + "】机构字段未配置");
        }
        //新增开户日期开始，开户日期结束查询     start
        if(openDateStart!=null&&!"".equals(openDateStart)){
        	sqlBuilder.append(" AND  D.OPEN_DATE >='"+openDateStart.replace("-", "")+"' ");
        }
        if(openDateEnd!=null&&!"".equals(openDateEnd)){
        	sqlBuilder.append(" AND  D.OPEN_DATE <='"+openDateEnd.replace("-", "")+"'");
        }
        sqlBuilder.append(") Z ON 1=1 ");
        for (String pk : pkList) {
            sqlBuilder.append(" AND Y.").append(pk).append("= Z.").append(pk);
        }
        
        sqlBuilder.append(" inner join SYS_USERS U on X.MANAGER_ID = U.USERID");
        sqlBuilder.append(" left join ");
        sqlBuilder.append(periodHisTableName).append(" C on ");
        for (int i = 0; i < pkList.size(); i++) {
            sqlBuilder.append("  Y.").append(pkList.get(i)).append("= C.").append(pkList.get(i));
            if(i!=pkList.size()-1) {
            	sqlBuilder.append(" AND");
            }
        }
        sqlBuilder.append(" and c.apply_sts <> '");
        sqlBuilder.append(DistributionConstants.UNDER_APPROVAL).append("' ");
        return sqlBuilder;
    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> trans(Map<String, Object> map) throws Exception {

            String toManagerId = map.get("toManagerId").toString();
            String funCodeJs = map.get("funCode").toString();
        	String effectDate = map.get("effectDate").toString();
        	String mainRecordsdata = (String) map.get("mainRecordsdata");
        	Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);// 获取业务配置信息
    		JSONArray mainRecordsJsonArray = JSONArray.fromObject(mainRecordsdata);
    		Map<String, Object> mapn = transNext(funInfoMap, toManagerId, effectDate, mainRecordsJsonArray,"",funCodeJs);
    		Boolean flag = (Boolean) mapn.get("flag");
        	ResultDto<String> result = new ResultDto<String>();
        	if(flag) {
            	result.setMessage("业绩转移失败，业绩正被操作中！");
                result.setCode(1);
        	}else {
            	result.setMessage("业绩转移成功");
                result.setCode(0);
        	}

			return result;

    }
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	private Map<String, Object> transNext(Map<String, Object> funInfoMap, String toManagerId, String effectDate,
			JSONArray mainRecordsJsonArray, String orgId, String funCodeJs) {
        String toManagerOrgId = commonPerformanceTransMapper.queryUserOrgId(toManagerId);// 转移到客户经理所属机构
        /** 工作流辅助变量 */
        Map<String, Object> returnMap = new HashMap<String, Object>();// 工作流提示辅助变量
        this.initTableInfo(funInfoMap);
        StringBuffer msg = new StringBuffer();
        Map<String, Object> routeMap = new HashMap<String, Object>();
        String operTime = DateUtil.getFullDateNoMils();
        for (int i = 0; i < mainRecordsJsonArray.size(); i++) {
        	Long s = new Date().getTime();
            JSONArray newPeriodJsonArray = new JSONArray();// 构建保存数据
            JSONObject distributeDataJson = new JSONObject();// 构建保存数据
            JSONObject mainRecordsJsonObject = mainRecordsJsonArray.getJSONObject(i);
            Map<String, Object> map = new HashMap<String, Object>();
            for (String pk : pkList) {
                map.put(pk, mainRecordsJsonObject.get(commonDistributionService.lineToHump(pk)));
            }
    		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
    			map.put("ACCT_ORG_ID", mainRecordsJsonObject.get("acctOrgId"));
    		}
            String orgIdNew = "";
            if(orgId.equals("")) {
        		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
                	orgIdNew = mainRecordsJsonObject.getString("acctOrgId");
        		}else {
                	orgIdNew = mainRecordsJsonObject.getString("orgId");
        		}
            }else {
            	orgIdNew = orgId;
            }
            String managerId = mainRecordsJsonObject.getString("managerId");
            List<Map<String, Object>> canTransPeriodList  = this.queryPeriodByPk(funInfoMap, map, managerId, effectDate);
            // 查询转移未涉及到分配区间
            List<Map<String, Object>> canNoTransPeriodList = this.queryNoPeriodByPk(funInfoMap, map, managerId, effectDate);
            // 原有分配关系
            List<Map<String, Object>> oldDistributeList = this.queryDistributeByPk(funInfoMap, map);
            //如果没有可以转移的分配区间（即没有可以转移的业绩），则记录该条信息，直接跳转至循环下一条
            if (null == canTransPeriodList || 1 > canTransPeriodList.size()) {
                // 无业绩可转移,记录信息返回前台
                msg.append((i + 1)).append("、").append(managerId).append(" [");
                for (String pk : pkList) {
                    msg.append(pk).append(":").append(mainRecordsJsonObject.get(pk)).append(" | ");
                }
                msg.deleteCharAt(msg.length() - 1);
                msg.append("] 有效期从").append(effectDate).append("开始没有可以转移的业绩");
                msg.append("</br>");
            } else {// 如果存在可以转移的分配区间
            	s = new Date().getTime();
            	Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);
            	System.out.println("业绩转移批量等待时间（0）"+(new Date().getTime()-s));
                s = new Date().getTime();
                // 循环处理分配区间和分配关系
                int count = 0;
                Map<String, Object> distributeMap = new HashMap<String, Object>();
                List<Map<String, Object>> distributeList = new ArrayList<Map<String, Object>>();
                System.out.println("业绩转移批量等待时间（1）"+(new Date().getTime()-s));
                s = new Date().getTime();
                for (Map<String, Object> canPeriodMap : canTransPeriodList) {// 处理转移涉及到的分配区间
                    /**
                     * oldDistributeList会查出符合分配区间的所有的分配关系，因此要对分配关系进行判断：
                     * 1）分配关系中的客户经理与要转出的客户经理是同一人时，更改分配关系；
                     * 2）分配关系中的客户经理与要转出的客户经理不是同一人时，分配关系不变；
                     */
                    /**
                     * 修改内容 : distributeList为临时存储变量,在每次存储后未初始化
                     * 修改时间: 2016.5.11 xujiawei1
                     */
                	List<Map<String, Object>> oldDistributeList1 = this.queryDistributeByPk(funInfoMap, map);
                    distributeList = new ArrayList<Map<String, Object>>();
                    if (effectDate.equals(canPeriodMap.get("effectDate"))
                            || !getShortDate(effectDate).after(
                                    getShortDate((String) canPeriodMap.get("effectDate")))) {
                        
                        // 无需拆分区间,只改变客户经理ID
                        for (Map<String, Object> tempMap1 : oldDistributeList1) {
                            // 客户经理id要等于转出客户经理id
                            if (canPeriodMap.get("id").equals(tempMap1.get("periodId"))
                                    && managerId.equals(tempMap1.get("managerId"))
                                    && (effectDate.equals(tempMap1.get("effectDate"))
                                            || !getShortDate(effectDate).after(
                                                   getShortDate(
                                                            (String) canPeriodMap.get("effectDate"))))) {
                            	tempMap1.put("managerId", toManagerId);// 改变客户经理ID
                            	tempMap1.put("allotType", "");
//                                canPeriodMap.put("list", tempMap);
//                                newPeriodJsonArray.add(canPeriodMap);
                            	if(distributeList.size()>0) {
                            		for (int j = 0; j < distributeList.size(); j++) {
                            			Map<String, Object> map1 = distributeList.get(j);
										if(map1.get("managerId").equals(tempMap1.get("managerId"))&&map1.get("periodId").equals(tempMap1.get("periodId"))) {
											String num1  = map1.get("distrRate").toString();
											String num2  = tempMap1.get("distrRate").toString();
											int num11 = Integer.valueOf(num1);
											int num21 = Integer.valueOf(num2);
											int newsum = num11+num21;
											map1.replace("distrRate", newsum);
											distributeList.set(j, map1);
											break;
										}else {
                            				distributeList.add(tempMap1);
                            				break;
                            			}
									}
                            	}else {
                                    distributeList.add(tempMap1);
                            	}
                            } else if(canPeriodMap.get("id").equals(tempMap1.get("periodId"))) { 
                              //客户经理id不等于转出客户经理id
//                            	canPeriodMap.put("list", tempMap);
//                                newPeriodJsonArray.add(canPeriodMap);
                            	if(distributeList.size()>0) {
                            		for (int j = 0; j < distributeList.size(); j++) {
                            			Map<String, Object> map1 = distributeList.get(j);
										if(map1.get("managerId").equals(tempMap1.get("managerId"))&&map1.get("periodId").equals(tempMap1.get("periodId"))) {
											String num1  = map1.get("distrRate").toString();
											String num2  = tempMap1.get("distrRate").toString();
											int num11 = Integer.valueOf(num1);
											int num21 = Integer.valueOf(num2);
											int newsum = num11+num21;
											map1.replace("distrRate", newsum);
											distributeList.set(j, map1);
											break;
										}else {
                            				distributeList.add(tempMap1);
                            				break;
                            			}
									}
                            	}else {
                                    distributeList.add(tempMap1);
                            	}

                            }
                        }
                        canPeriodMap.put("list", distributeList);
                        newPeriodJsonArray.add(canPeriodMap);
                        distributeMap.put((String) canPeriodMap.get("id"), distributeList);
                    } else {
                        // 获取所选日期的前一天
                        String newEndDate = getPreviousDate(effectDate);
                        Map<String, Object> metaPeriodMap = new HashMap<String, Object>();
                        Set<String> set = canPeriodMap.keySet();
                        for (String key : set) {// 复制一份未拆分的区间
                            // String value = (String) canPeriodMap.get(key);
                            String value = canPeriodMap.get(key).toString();
                            metaPeriodMap.put(key, value);
                        }
                        // 处理拆分区间的前半段
                        canPeriodMap.put("expirateDate", newEndDate);
                        canPeriodMap.put("operTime", operTime);
//                        newPeriodJsonArray.add(canPeriodMap);
                        List<Map<String, Object>> oldDistributeList2 = this.queryDistributeByPk(funInfoMap, map);
                        for (Map<String, Object> tempMap2 : oldDistributeList2) {
                            if (canPeriodMap.get("id").equals(tempMap2.get("periodId"))) {
                            	tempMap2.put("allotType", "");
                                    
                                    canPeriodMap.put("list", tempMap2);
                                	if(distributeList.size()>0) {
                                		for (int j = 0; j < distributeList.size(); j++) {
                                			Map<String, Object> map1 = distributeList.get(j);
    										if(map1.get("managerId").equals(tempMap2.get("managerId"))&&map1.get("periodId").equals(tempMap2.get("periodId"))) {
    											String num1  = map1.get("distrRate").toString();
    											String num2  = tempMap2.get("distrRate").toString();
    											int num11 = Integer.valueOf(num1);
    											int num21 = Integer.valueOf(num2);
    											int newsum = num11+num21;
    											map1.replace("distrRate", newsum);
    											distributeList.set(j, map1);
    											break;
    										}else {
                                				distributeList.add(tempMap2);
                                				break;
                                			}
    									}
                                	}else {
                                        distributeList.add(tempMap2);
                                	}
                            }
                        }
                        canPeriodMap.put("list", distributeList);
                        newPeriodJsonArray.add(canPeriodMap);
                        distributeMap.put((String) canPeriodMap.get("id"), distributeList);
                        distributeList = new ArrayList<Map<String, Object>>();
                        // 处理拆分区间的后半段
                        metaPeriodMap.put("effectDate", effectDate);
                        metaPeriodMap.put("id", "" + (count++));
                        metaPeriodMap.put("operTime", operTime);
//                        newPeriodJsonArray.add(metaPeriodMap);
                        List<Map<String, Object>> oldDistributeList3 = this.queryDistributeByPk(funInfoMap, map);
                        for (Map<String, Object> tempMap3 : oldDistributeList3) {
                        	System.out.println(oldDistributeList);
                            if (canPeriodMap.get("id").equals(tempMap3.get("periodId"))) {
                            	tempMap3.put("periodId",metaPeriodMap.get("id"));// 拆分后新的区间
                                if (tempMap3.get("managerId").equals(managerId)) {
                                    Map<String, Object> metaMap = new HashMap<String, Object>();
                                    Set<String> _set = tempMap3.keySet();
                                    for (String key : _set) {// 复制一份原有的分配关系
                                        String value = tempMap3.get(key).toString();
                                        metaMap.put(key, value);
                                        
                                    }
                                    metaMap.put("managerId", toManagerId);// 改变客户经理
                                    metaMap.put("allotType", "");
//                                    metaPeriodMap.put("list", metaMap);
                                	if(distributeList.size()>0) {
                                		for (int j = 0; j < distributeList.size(); j++) {
                                			Map<String, Object> map1 = distributeList.get(j);
                                			if(map1.get("managerId").equals(metaMap.get("managerId"))&&map1.get("periodId").equals(metaMap.get("periodId"))) {
                                				String num1  = map1.get("distrRate").toString();
                                				String num2  = metaMap.get("distrRate").toString();
                                				int num11 = Integer.valueOf(num1);
                                				int num21 = Integer.valueOf(num2);
                                				int newsum = num11+num21;
                                				map1.replace("distrRate", newsum);
                                				distributeList.set(j, map1);
                                				break;
                                			}else {
                                				distributeList.add(metaMap);
                                				break;
                                				
                                			}
                                		}
                                	}else {
                                		distributeList.add(metaMap);
                                	}
                                } else {
                                	tempMap3.put("allotType", "");
                                	if(distributeList.size()>0) {
                                		for (int j = 0; j < distributeList.size(); j++) {
                                			Map<String, Object> map1 = distributeList.get(j);
                                			if(map1.get("managerId").equals(tempMap3.get("managerId"))&&map1.get("periodId").equals(tempMap3.get("periodId"))) {
                                				String num1  = map1.get("distrRate").toString();
                                				String num2  = tempMap3.get("distrRate").toString();
                                				int num11 = Integer.valueOf(num1);
                                				int num21 = Integer.valueOf(num2);
                                				int newsum = num11+num21;
                                				map1.replace("distrRate", newsum);
                                				distributeList.set(j, map1);
                                				break;
                                				
                                			}else {
                                				distributeList.add(tempMap3);
                                				break;
                                				
                                			}
                                		}
                                	}else {
                                		distributeList.add(tempMap3);
                                	}
                                }
                            }
                        }
                        metaPeriodMap.put("list", distributeList);
                        newPeriodJsonArray.add(metaPeriodMap);
                        distributeMap.put((String) metaPeriodMap.get("id"), distributeList);
                    }
                }
                System.out.println("业绩转移批量等待时间（2）"+(new Date().getTime()-s));
                s = new Date().getTime();
                for (Map<String, Object> canNoPeriodMap : canNoTransPeriodList) {// 处理转移未涉及到的分配区间
                    distributeList = new ArrayList<Map<String, Object>>();
                    List<Map<String, Object>> oldDistributeList4 = this.queryDistributeByPk(funInfoMap, map);
                    for (Map<String, Object> tempMap4 : oldDistributeList4) {
                        if (canNoPeriodMap.get("id").equals(tempMap4.get("periodId"))) {
                        	tempMap4.put("allotType", "");
                        	if(distributeList.size()>0) {
                        		for (int j = 0; j < distributeList.size(); j++) {
                        			Map<String, Object> map1 = distributeList.get(j);
                        			if(map1.get("managerId").equals(tempMap4.get("managerId"))&&map1.get("periodId").equals(tempMap4.get("periodId"))) {
                        				String num1  = map1.get("distrRate").toString();
                        				String num2  = tempMap4.get("distrRate").toString();
                        				int num11 = Integer.valueOf(num1);
                        				int num21 = Integer.valueOf(num2);
                        				int newsum = num11+num21;
                        				map1.replace("distrRate", newsum);
                        				distributeList.set(j, map1);
                        				break;
                        			}else {
                        				distributeList.add(tempMap4);
                        				break;
                        				
                        			}
                        		}
                        	}else {
                        		distributeList.add(tempMap4);
                        	}
                        }
                    }
                    canNoPeriodMap.put("list", distributeList);
                    newPeriodJsonArray.add(canNoPeriodMap);
                    distributeMap.put((String) canNoPeriodMap.get("id"), distributeList);
                }
                System.out.println("业绩转移批量等待时间（3）"+(new Date().getTime()-s));
                s = new Date().getTime();
                // 格式化数据为JSON
                distributeDataJson = JSONObject.fromObject(distributeMap);

                JSONArray primaryValueArray = new JSONArray();// 构建保存数据

                Map<String, Object> primaryValueMap = new HashMap<String, Object>();
                primaryValueMap.put("interDept", false);
                if (null != orgColumnMap && 0 < orgColumnMap.size() && toManagerOrgId.equals(mainRecordsJsonObject.getString(commonDistributionService.lineToHump(orgColumnMap.get("columnName").toString()) ))) {
                    primaryValueMap.put("interOrg", false);// 判断是否跨机构
                } else {
                    primaryValueMap.put("interOrg", true);
                    // 判断是否跨分行
                    if (null != orgColumnMap && 0 < orgColumnMap.size() && this.interBranch(mainRecordsJsonObject.getString(commonDistributionService.lineToHump(orgColumnMap.get("columnName").toString()) ), toManagerOrgId)) {
                        primaryValueMap.put("interDept", true);
                    } else {
                        primaryValueMap.put("interDept", false);
                    }

                }
                if (toManagerId.indexOf("V") == 0) {
                    primaryValueMap.put("virtualDstr", false);// 判断是否分配有虚拟行员
                } else {
                    primaryValueMap.put("virtualDstr", true);
                }
                System.out.println("业绩转移批量等待时间（4）"+(new Date().getTime()-s));
                s = new Date().getTime();
                /** 当前账号所机构和条线 */
                primaryValueMap.put("org", mainRecordsJsonObject.getString(commonDistributionService.lineToHump(orgColumnMap.get("columnName").toString()) ));
                primaryValueMap.put("buss", mainRecordsJsonObject.getString(commonDistributionService.lineToHump(orgColumnMap.get("columnName").toString()) ));
                primaryValueMap.put(commonDistributionService.lineToHump(orgColumnMap.get("columnName").toString()) , mainRecordsJsonObject.getString(commonDistributionService.lineToHump(orgColumnMap.get("columnName").toString()) ));
                for (String pk : pkList) {
                    primaryValueMap.put(commonDistributionService.lineToHump(pk), mainRecordsJsonObject.get(commonDistributionService.lineToHump(pk)));
                }
                if(funCodeJs.equals("DepPubDstr")||funCodeJs.equals("ComLoanDstr")||funCodeJs.equals("ComFncDstr")
                		||funCodeJs.equals("PerDepDstr")||funCodeJs.equals("PerLoanDstr")||funCodeJs.equals("PerFncDstr")) {
                    List<String> amtList = commonDistributionService.getDstrAmtKey(funInfoMap);
                    primaryValueMap.put(commonDistributionService.lineToHump(amtList.get(0).toString()) , mainRecordsJsonObject.getString(commonDistributionService.lineToHump(amtList.get(0).toString()) ));

                }
                primaryValueArray = JSONArray.fromObject(primaryValueMap);
                System.out.println("业绩转移批量等待时间（5）"+(new Date().getTime()-s));
                /** 调用业绩分配保存逻辑完成后续操作 */
                try {
                	s = new Date().getTime();
                    routeMap = commonDistributionService.saveDataTransEchain4(funInfoMap,primaryValueArray, newPeriodJsonArray,distributeDataJson, false, DATA_SRC.TRANSFER,orgIdNew,funCodeJs);
                    System.out.println("业绩转移批量执行时间"+(new Date().getTime()-s));
                } catch (Exception e) {
                	throw new YuspException("500", "绩效分配保存失败！");
                }
            }
        }
        returnMap.put("msg", msg.toString());
		returnMap.put("flag",routeMap.get("flag"));
        return returnMap;
    }
	/** 
     * <pre>
     * 功能描述: 获取原有所有分配关系
     * @Title: queryDistributeByPk 
     * @author: xujiawei
     * @param funInfoMap
     * @param pkMap
     * @return: List<Map<String,Object>>   
     * </pre>
     */ 
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> queryDistributeByPk(
            Map<String, Object> funInfoMap, Map<String, Object> pkMap) {
        StringBuffer querySql = new StringBuffer();
        List<String> distributeColumnList = new ArrayList<String>();
        distributeColumnList.addAll(DistributionConstants.DISTRIBUTE_COLUMN_LIST);
        List<String> distributeColumnListSum = new ArrayList<String>();
        distributeColumnListSum.addAll(DistributionConstants.DISTRIBUTE_COLUMN_LIST_SUM);
        distributeColumnListSum.remove("ID");
        distributeColumnList.remove("ID");
        // 分配类型:1,比例分配; 2,定额分配; 3,比例+定额分配
        String dstrType
            = (String) (((Map<String, Object>) funInfoMap.get("pageCfgInfo")).get("DSTR_TYPE"));
        // "START_AMT", "END_AMT", "PERF_RATE"
        if ("1".equals(dstrType)) {// 比例分配
            distributeColumnList.remove("START_AMT");
            distributeColumnList.remove("END_AMT");
            
            distributeColumnListSum.remove("START_AMT");
            distributeColumnListSum.remove("END_AMT");
        } else {// 比例+定额分配
            /**
             * 修改内容: 如果是比例加定额,应保留起始、结束金额以及比例
             * 修改人 : xujiawei1 2016.5.13
             */
            //distributeColumnList.remove("START_AMT");
            //distributeColumnList.remove("END_AMT");
        }
        
        /** 是否配置绩效比例 */
        boolean showPerfRateCfg
            = ("1".equals(commonDistributionService.getPageCfgValue(funInfoMap, "HAS_JXBL"))) ? true : false;
        
        if (!showPerfRateCfg) {
            distributeColumnList.remove("PERF_RATE");
            distributeColumnListSum.remove("PERF_RATE");
        }
        if (!DistributionConstants.YES.equals(commonDistributionService.getPageCfgValue(funInfoMap, "HOST_CFG"))) {
            distributeColumnList.remove("HOST_CFG");
            distributeColumnListSum.remove("HOST_CFG");
        }
        
        insertDistributeColumn = commonDistributionService.listToString(distributeColumnList);
        insertDistributeSumColumn  = commonDistributionService.listToString(distributeColumnListSum);
        distributeColumnListSum.remove("SUM(DISTR_RATE) AS DISTR_RATE");
        String groupDistributeColumn = commonDistributionService.listToString(distributeColumnListSum);
        String colum = "P.EFFECT_DATE, P."+insertDistributeColumn+",";
        querySql.append(" SELECT P.EFFECT_DATE, D.");
        querySql.append(insertDistributeColumn).append(",");
        for (String pk : pkList) {
        	colum += pk + ",";
            querySql.append(pk).append(",");
        }
        colum = colum.substring(0, colum.length()-1);
        querySql.deleteCharAt(querySql.length() - 1);
        querySql.append(" FROM ").append(periodTableName).append(" P INNER JOIN ");
        querySql.append(" (SELECT "+insertDistributeSumColumn + " FROM ");
        querySql.append(distributeTableName);
        querySql.append(" group by "+groupDistributeColumn+" ) ");
        querySql.append(" D ON P.ID = D.PERIOD_ID WHERE 1=1 ");
        Set<String> set = pkMap.keySet();
        for (String pk : set) {
            querySql.append(" AND P.").append(pk).append("='");
            querySql.append(pkMap.get(pk)).append("' ");
        }
        querySql.append(" ORDER BY P.EFFECT_DATE ASC ");
        List<Map<String, Object>> distributeList = commonPerformanceTransMapper.excuteQuery(querySql.toString());
        return distributeList;
    }
    /** 
     * <pre>
     * 功能描述: 转移某客户经理下所有业绩
     * @Title: transByManager 
     * @author: xujiawei    
     * </pre>
     */ 
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<String> transByManager(Map<String, Object> map) {
        try {
            String toManagerId = map.get("toManagerId").toString();// 转移至客户经理
            String funCodeJs = map.get("funCode").toString();
        	String effectDate = map.get("effectDate").toString();// 生效日期
        	Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);// 获取业务配置信息
        	String orgId = map.get("orgId").toString();// 机构查询条件
        	String openDateStart=map.get("openDateStart").toString();//开户日期开始
            String openDateEnd=map.get("openDateEnd").toString();//开户日期结束
        	String managerId = map.get("managerId").toString();
        	String dataAuth = map.get("dataAuth").toString();// 数据机构权限
        	String strbuf = queryPerformanceByManager(managerId, dataAuth,orgId,openDateStart,openDateEnd,funCodeJs);// 将数据放入Json中
        	List<Map<String, Object>> list = commonPerformanceTransMapper.queryPerformance(strbuf);
        	JSONArray mainRecordsJsonArray  = JSONArray.fromObject(list);// 格式化数据
        	Map<String, Object> routeMap = transNext(funInfoMap, toManagerId, effectDate, mainRecordsJsonArray,orgId,funCodeJs);
        	ResultDto<String> result = new ResultDto<String>();
        	Boolean flag= (Boolean) routeMap.get("flag");
        	if(flag) {
            	result.setMessage("业绩转移失败。业绩正被操作中！");
                result.setCode(1);
        	}else {
            	result.setMessage("业绩转移成功");
                result.setCode(0);
        	}
    		return result;
        } catch (Exception e) {
        	ResultDto<String> result = new ResultDto<String>();
        	result.setMessage("业绩转移失败");
            result.setCode(1);
            return result;
        }
    }
	 /** 
     * <pre>
     * 功能描述: 根据分配主键+客户经理+生效日期（effectDate界面上选的）查询转移未涉及到的区间
     * @Title: queryNoPeriodByPk 
     * @author: xujiawei
     * @param funInfoMap
     * @param pkMap
     * @param managerId 客户经理ID
     * @param effectDate 所选生效日期
     * @return: List<Map<String,Object>>   
     * </pre>
     */ 
    public List<Map<String, Object>> queryNoPeriodByPk(
            Map<String, Object> funInfoMap, Map<String, Object> pkMap,
            String managerId, String effectDate) {
        Set<String> set = pkMap.keySet();
        StringBuffer querySql = new StringBuffer();
        querySql.append("SELECT * FROM ").append(periodTableName).append(" P WHERE 1=1 ");
        for (String pk : set) {
            querySql.append(" AND P.").append(pk).append("='");
            querySql.append(pkMap.get(pk)).append("' ");
        }
        
        
        querySql.append(" AND ID NOT IN ( SELECT P.ID  FROM ");
        querySql.append(periodTableName).append(" P INNER JOIN ");
        querySql.append(distributeTableName);
        querySql.append(" D ON P.ID = D.PERIOD_ID WHERE 1=1 ");
        for (String pk : set) {
            querySql.append(" AND P.").append(pk).append("='");
            querySql.append(pkMap.get(pk)).append("' ");
        }

        querySql.append(" AND D.MANAGER_ID ='").append(managerId).append("' ");
        querySql.append(" AND to_date(P.EXPIRATE_DATE,'yyyy-mm-dd') > to_date('");
        querySql.append(effectDate).append("','yyyy-mm-dd') ");
        querySql.append(") ORDER BY EFFECT_DATE ASC ");
        // 转移未涉及到的分配区间
        List<Map<String, Object>> transPeriodList = commonPerformanceTransMapper.excuteQuery(querySql.toString());
        return transPeriodList;
    }
	   /** 
     * <pre>
     * 功能描述: 根据分配主键+客户经理+生效日期（effectDate界面上选的）查询可转移的分配区间
     * @Title: queryPeriodByPk 
     * @author: xujiawei
     * @param funInfoMap
     * @param pkMap
     * @param managerId 客户经理ID
     * @param effectDate 所选生效日期
     * @return: List<Map<String,Object>>   
     * </pre>
     */ 
    public List<Map<String, Object>> queryPeriodByPk(
            Map<String, Object> funInfoMap, Map<String, Object> pkMap,
            String managerId, String effectDate) {
        StringBuffer querySql = new StringBuffer();
        AdminBaseMetaFunReg regInfoMap = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
        querySql.append(" SELECT distinct P.* FROM ");
        querySql.append(periodTableName);
        querySql.append(" P INNER JOIN ");
        querySql.append(distributeTableName);
        querySql.append(" D ON P.ID = D.PERIOD_ID WHERE 1=1 ");
        Set<String> set = pkMap.keySet();
        for (String pk : set) {
        	querySql.append(" AND P.").append(pk).append("='");
        	querySql.append(pkMap.get(pk)).append("' ");
        }
        
        querySql.append(" AND D.MANAGER_ID ='").append(managerId).append("' ");
        querySql.append(" AND TO_DATE(P.EXPIRATE_DATE,'yyyy-mm-dd') > to_date('");
        querySql.append(effectDate).append("','yyyy-mm-dd') ");
        querySql.append(" ORDER BY P.EFFECT_DATE ASC ");
        // 可转移的分配区间
        List<Map<String, Object>> transPeriodList = commonPerformanceTransMapper.excuteQuery(querySql.toString());
        return transPeriodList;
    }
    /**
     * <pre>
     * 功能描述: 获取该笔业绩分配业务的相关表信息
     * @Title: initTableInfo 
     * @author: xujiawei
     * @param funInfoMap
     * </pre>
     */
    public void initTableInfo(Map<String, Object> funInfoMap) {
        // 业务注册信息
    	regInfo = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
        periodTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
        distributeTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
        periodTableName = periodTableInfo.get("tableName");
        distributeTableName = distributeTableInfo.get("tableName");
        pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
    }
	public static String getPreviousDate(String dateStr){
		Date date = parseDate(dateStr,"yyyyMMdd");
		Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.DATE, -1);
	    return formatDate(c.getTime());
	}
	public static Date parseDate(String dateS,String format){
		DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
    	try {
			return df.parse(dateS);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
	public static String formatDate(Date date){
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		df.setLenient(false);
		return df.format(date);
	}
	public static Date getShortDate(String date){
		return parse(DEF_SHORT, date);
	}
	private static Date parse(String pattern, String date){
		synchronized(obj){
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			try {
				return df.parse(date);
			} catch (ParseException e) {
				return new Date(System.currentTimeMillis());
			}
		}
	}
    /** 
     * <pre>
     * 功能描述: 判断两个机构是否在不同分行（及其所有子行）下(即是否跨分行).
     * @Title: interBranch 
     * @author: xujiawei
     * @param orgId 机构id
     * @param theOrgId 机构id
     * @param auth 当前登陆人信息
     * @return: boolean   
     * </pre>
     */ 
    @SuppressWarnings("rawtypes")
    public boolean interBranch(String orgId, String theOrgId) {
        List<?> branchOrgIdGrou = userInfoService.getOrgBranchGroup();
        if (null == branchOrgIdGrou || 1 > branchOrgIdGrou.size()) {
            return false;
        }
        if (null != branchOrgIdGrou && 0 < branchOrgIdGrou.size()) {
            for (int i = 0; i < branchOrgIdGrou.size(); i++) {
                if (((List) branchOrgIdGrou.get(i)).contains(orgId)
                        && ((List) branchOrgIdGrou.get(i)).contains(theOrgId)) {
                    // 在同一分行下
                    return false;
                }
            }
        }
        return true;
    }


}
