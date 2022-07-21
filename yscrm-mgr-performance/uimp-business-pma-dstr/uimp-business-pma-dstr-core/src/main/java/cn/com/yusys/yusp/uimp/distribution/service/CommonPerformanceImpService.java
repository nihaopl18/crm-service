package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.admin.domain.AdminFileUploadInfo;
import cn.com.yusys.yusp.admin.repository.mapper.AdminSmUserMapper;
import cn.com.yusys.yusp.admin.service.AdminSmLookupItemService;
import cn.com.yusys.yusp.admin.service.impl.FileProviderServiceImpl;
import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.util.SpringContextUtil;
import cn.com.yusys.yusp.commons.util.StringUtil;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunTable;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.base.utils.DateUtil;
import cn.com.yusys.yusp.uimp.distr.thread.PerformanceImpThreadManager;
import cn.com.yusys.yusp.uimp.distr.thread.pool.BatchFixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distr.thread.pool.FixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.DATA_AUTH_TYPE;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.DATA_SRC;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.DATA_TYPE;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.FUN_SUB_TYPE;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.SEARCH_TYPE;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFPerformanceBatchInfo;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceTobatchInf;
import cn.com.yusys.yusp.uimp.distribution.model.FImpCheckModel;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonPerformanceImpMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFPerformanceBatchInfoMapper;
import co.elastic.apm.shaded.stagemonitor.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceImpService
 * @类描述: # 业绩批量导入接口 服务类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2020-01-09 15:59:02
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CommonPerformanceImpService {

    private static final Logger log = LoggerFactory.getLogger(CommonPerformanceImpService.class);

    @Value("${info.excel.temp-file-dir}")
    private String excelTempFileDir;

    @Value("${info.file.local-disk-path}")
    private String localDiskPath;

//	@Value("${application.pma.performance-imp.syn-execute-max-size}")
//	private Integer synExecuteMaxSize;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CommonDistributionService commonDistributionService;

    @Autowired
    private AdminSmLookupItemService adminSmLookupItemService;

    @Autowired
    private MetaFunctionManagerService metaFunctionManagerService;

    @Autowired
    private FileProviderServiceImpl fileProviderServiceImpl;

    @Autowired
    private PmaFPerformanceBatchInfoMapper pmaFPerformanceBatchInfoMapper;

    @Autowired
    private CommonPerformanceImpMapper commonPerformanceImpMapper;

    @Autowired
    private AdminSmUserMapper adminSmUserMapper;

    @Autowired
    private PerformanceImpThreadManager performanceImpThreadManager;

    @Autowired
    private FixedThreadPoolManager fixedThreadPoolManager;

//	@Value("${application.pma.performance-exp.allow-exp-max-size}")
//	private Integer allowExpMaxSize;  //允许导出最大记录数

    /**
     * @throws Exception
     * @方法名称: queryList
     * @方法描述: 列表查询
     * @参数与返回说明:
     * @算法描述:
     */
    public List<Map<String, Object>> queryList(QueryModel queryModel) throws Exception {
//		log.info("查询开始...");
//		long startTime = System.currentTimeMillis();
        if (queryModel.getCondition().containsKey("funCode") && !StringUtils.isEmpty(queryModel.getCondition().get("funCode") + "")) {
            try {
                String funCode = queryModel.getCondition().get("funCode") + "";
                String dataAuth = queryModel.getCondition().get("dataAuth") != null ? queryModel.getCondition().get("dataAuth") + "" : "";
                String dataBussAuth = queryModel.getCondition().get("dataBussAuth") != null ? queryModel.getCondition().get("dataBussAuth") + "" : "";
                /** 获取功能信息缓存 */
                Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
//				long endTime = System.currentTimeMillis();
//				log.info("获取META耗时：" + (endTime-startTime)/1000 + "秒");
//				startTime = System.currentTimeMillis();
                StringBuffer sql = new StringBuffer(this.builderQuerySqlNew(funInfoMap, dataAuth, dataBussAuth, userInfoService.getGrantOrgCode()));

//				endTime = System.currentTimeMillis();
//				log.info("拼装SQL耗时：" + (endTime-startTime)/1000 + "秒");
//				log.info("SQL===>" + sql);
//				startTime = System.currentTimeMillis();

                sql.insert(0, "SELECT * FROM (");
                sql.append(") X WHERE 1=1 ");

                /** 配置查询条件 */
                Set<Map<String, Object>> searchFieldSet = this.getSearchFieldSet(funInfoMap);
                for (Map<String, Object> map : searchFieldSet) { // 查询条件细分
                    if (map.get("columnHiddenName") != null) {
                        if (queryModel.getCondition().containsKey(map.get("columnHiddenName") + "") &&
                                !StringUtils.isEmpty(queryModel.getCondition().get(map.get("columnHiddenName") + "") + "")) {
                            if ((map.get("subOrgQuery") != null) && (DistributionConstants.YES.equals(map.get("subOrgQuery")))) {
                                if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                                    sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X.ACCT_ORG_ID");
                                    sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
                                    sql.append(queryModel.getCondition().get(map.get("columnHiddenName"))).append(")($|,)') )");
                                } else {
                                    sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X." + map.get("columnName").toString());
                                    sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
                                    sql.append(queryModel.getCondition().get(map.get("columnHiddenName"))).append(")($|,)') )");
                                }
                            } else {
                                if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                                    sql.append(" and X.ACCT_ORG_ID" +
                                            "'" + queryModel.getCondition().get(map.get("columnHiddenName") + "") + "'");
                                } else {
                                    sql.append(" and X." + map.get("columnName") + map.get("compareChar") +
                                            "'" + queryModel.getCondition().get(map.get("columnHiddenName") + "") + "'");
                                }
                            }
                        }
                    } else if (map.get("dateSpan") != null) {
                        if (queryModel.getCondition().containsKey(map.get("dateSpan") + "1") &&
                                !StringUtils.isEmpty(queryModel.getCondition().get(map.get("dateSpan") + "1") + "") &&
                                !"".equals(queryModel.getCondition().get(map.get("dateSpan") + "1")) &&
                                queryModel.getCondition().get(map.get("dateSpan") + "1") != null) {
                            if (new Integer(2).equals(map.get("dataType"))) {    // 日期组件, 此处后续要考虑数据库的适配 TODO
                                String dateFormat = map.get("dateFormat") + "";
                                sql.append(" and X." + map.get("columnName") + ">=" + "to_date('" + queryModel.getCondition().get(map.get("dateSpan") + "1") + "', '" + dateFormat + "')");
                            } else {
                                sql.append(" and X." + map.get("columnName") + ">=" + "'" + queryModel.getCondition().get(map.get("dateSpan") + "1") + "'");
                            }
                        }
                        if (queryModel.getCondition().containsKey(map.get("dateSpan") + "2") &&
                                !StringUtils.isEmpty(queryModel.getCondition().get(map.get("dateSpan") + "2") + "") &&
                                !"".equals(queryModel.getCondition().get(map.get("dateSpan") + "2")) &&
                                queryModel.getCondition().get(map.get("dateSpan") + "2") != null) {
                            if (new Integer(2).equals(map.get("dataType"))) {    // 日期组件, 此处后续要考虑数据库的适配 TODO
                                String dateFormat = map.get("dateFormat") + "";
                                sql.append(" and X." + map.get("columnName") + "<=" + "to_date('" + queryModel.getCondition().get(map.get("dateSpan") + "2") + "', '" + dateFormat + "')");
                            } else {
                                sql.append(" and X." + map.get("columnName") + "<=" + "'" + queryModel.getCondition().get(map.get("dateSpan") + "2") + "'");
                            }
                        }
                    } else if (map.get("dateOnly") != null) {
                        if (queryModel.getCondition().containsKey(map.get("dateOnly") + "") &&
                                !StringUtils.isEmpty(queryModel.getCondition().get(map.get("dateOnly") + "") + "") &&
                                !"".equals(queryModel.getCondition().get(map.get("dateOnly") + "")) &&
                                queryModel.getCondition().get(map.get("dateOnly") + "") != null) {
                            if (new Integer(2).equals(map.get("dataType"))) {    // 日期组件, 此处后续要考虑数据库的适配 TODO
                                String dateFormat = map.get("dateFormat") + "";
                                sql.append(" and X." + map.get("columnName") + "=" + "to_date('" + queryModel.getCondition().get(map.get("dateOnly") + "") + "', '" + dateFormat + "')");
                            } else {
                                sql.append(" and to_date(X." + map.get("columnName") + ",'yyyy-mm-dd') =" + "to_date('" + queryModel.getCondition().get(map.get("dateOnly").toString()) + "','yyyy-mm-dd')");
                            }
                        }
                    } else if (map.get("moneySpan") != null) {
                        if (queryModel.getCondition().containsKey(map.get("moneySpan") + "1") &&
                                !StringUtils.isEmpty(queryModel.getCondition().get(map.get("moneySpan") + "1") + "") &&
                                !"".equals(queryModel.getCondition().get(map.get("moneySpan") + "1")) &&
                                queryModel.getCondition().get(map.get("moneySpan") + "1") != null) {
                            sql.append(" and to_number(X." + map.get("columnName") + ") >= to_number('" + queryModel.getCondition().get(map.get("moneySpan") + "1") + "')");
                        }
                        if (queryModel.getCondition().containsKey(map.get("moneySpan") + "2") &&
                                !StringUtils.isEmpty(queryModel.getCondition().get(map.get("moneySpan") + "2") + "") &&
                                !"".equals(queryModel.getCondition().get(map.get("moneySpan") + "2")) &&
                                queryModel.getCondition().get(map.get("moneySpan") + "2") != null) {
                            sql.append(" and to_number(X." + map.get("columnName") + ") <= to_number('" + queryModel.getCondition().get(map.get("moneySpan") + "2") + "')");
                        }
                    } else {
                        if (queryModel.getCondition().containsKey(map.get("columnName") + "") &&
                                !StringUtils.isEmpty(queryModel.getCondition().get(map.get("columnName") + "") + "")) {
                            sql.append(" and X." + map.get("columnName") + " " + map.get("compareChar") +
                                    ("like".equals(map.get("compareChar") + "") ? "'%" + queryModel.getCondition().get(map.get("columnName") + "") + "%'" : "'" + queryModel.getCondition().get(map.get("columnName") + "") + "'"));
                        }
                    }
                }
                if (queryModel.getCondition().containsKey("DSTR_STS") &&
                        !StringUtils.isEmpty(queryModel.getCondition().get("DSTR_STS") + "")) {
                    sql.append(" and X.DSTR_STS = '" + queryModel.getCondition().get("DSTR_STS") + "' ");
                }
                // 分页执行查询sql
                PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
                Page<Map<String, Object>> list = commonPerformanceImpMapper.queryList(sql.toString(), queryModel);
                PageHelper.clearPage();

//				endTime = System.currentTimeMillis();
//				log.info("执行SQL耗时：" + (endTime-startTime)/1000 + "秒");
//				startTime = System.currentTimeMillis();
                // 字段名-驼峰转下划线
                List<Map<String, Object>> destList = mapKeyToUnderline(list.getResult());

//				endTime = System.currentTimeMillis();
//				log.info("转驼峰耗时：" + (endTime-startTime)/1000 + "秒");
//				startTime = System.currentTimeMillis();
                list.clear();
                list.addAll(destList);
//				endTime = System.currentTimeMillis();
//				log.info("处理结束耗时：" + (endTime-startTime)/1000 + "秒");
                return list;
            } catch (Exception e) {
                log.error("performanceImp queryList error: ", e);
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
        for (Map<String, Object> map : list) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            for (String key : map.keySet()) {
                tempMap.put(CommonDistributionService.HumpToUnderline(key), map.get(key));
            }
            destList.add(tempMap);
        }
        return destList;
    }

    private String builderQuerySql(Map<String, Object> funInfoMap, String dataAuth, String dataBussAuth, String grantOrgCode) {
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
        sb.append(" SELECT ").append(this.getImpColumnStr(funInfoMap, "A"));


        if (!"1".equals(dstrPeriod)) sb.append(" ,P.EFFECT_DATE, P.EXPIRATE_DATE "); // 多区间

        if (showPerfRateCfg) sb.append(" ,D.PERF_RATE ");

        if ("1".equals(dstrType)) sb.append(" ,D.DISTR_RATE "); // 比例分配
        else if ("2".equals(dstrType)) sb.append(" ,D.DISTR_RATE ,D.START_AMT ,D.END_AMT "); // 比例+定额 分配

        sb.append(" ,D.MANAGER_ID, U.USERNAME AS MANAGER_NAME ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(",acci.ACCT_ORG_ID");
        }
        sb.append(" from ").append(infoTableName).append(" A ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
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
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" ACCT_ORG_ID , ");
        }
        sb.append("APPLY_STS,APPLY_ID,DATA_SRC FROM ");
        sb.append(periodHisTabName);
        sb.append(" WHERE APPLY_STS = '").append(DistributionConstants.UNDER_APPROVAL).append("' ");
        sb.append(" AND EXPIRATE_DATE>='").append(now).append("' "); // 验证历史表结束时间点
        sb.append(") C ON 1=1 ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
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
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" ACCT_ORG_ID , ");
        }
        sb.append("APPLY_STS FROM "); // ,APPLY_ID,DATA_SRC

        sb.append(periodHisTabName);
        sb.append(" WHERE APPLY_STS = '").append(DistributionConstants.APPLY_APPROVED).append("'");
        sb.append(" AND EXPIRATE_DATE>='").append(now).append("' "); //验证历史表结束时间点
        sb.append(") B ON 1=1 ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" AND B.CUST_ID = ACCI.CUST_ID AND B.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
        } else {
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
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" ACCT_ORG_ID , ");
        }
        sb.append("APPLY_STS FROM "); // ,APPLY_ID,DATA_SRC

        sb.append(periodHisTabName);
        sb.append(" WHERE APPLY_STS = '").append(DistributionConstants.AUTO_APPROVED).append("'");
        sb.append(" AND EXPIRATE_DATE>='").append(now).append("' "); //验证历史表结束时间点
        sb.append(") E ON 1=1 ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" AND E.CUST_ID = ACCI.CUST_ID AND E.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
        } else {
            for (String pk : pkList) {
                sb.append(" AND A.").append(pk).append("=E.").append(pk);
            }
        }
        //增加分配状态    left join 语句   by   mayan   end
        sb.append(" LEFT JOIN ");
        sb.append("( select * from  ").append(periodTableName).append(" where 1=1    ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" AND ACCT_ORG_ID = '").append(userInfoService.getGrantOrgCode()).append("' ");
        }
        sb.append(") P ON 1=1 ");

        for (String pk : pkList) {
            sb.append(" AND A.").append(pk).append("= P.").append(pk);
        }
        sb.append(" LEFT JOIN ").append(distributeTabName).append(" D ON P.ID = D.PERIOD_ID ");
//        sb.append(" AND  P.EXPIRATE_DATE = '20991231'  ");
        sb.append(" LEFT JOIN SYS_USERS U ON D.MANAGER_ID = U.USERID ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" WHERE 1=1");
        } else {
            sb.append(" WHERE 1=1 and a.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
        }
        sb.append(" AND  P.EXPIRATE_DATE = '20991231'  ");
        /** 添加数据权限 */
        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);
        try {
            if (DATA_AUTH_TYPE.CUR_ORG.toString().equals(dataAuth)) { // 当前机构权限
                if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                    sb.append(" AND ACCI.ACCT_ORG_ID");
                    sb.append("='").append(userInfoService.getGrantOrgCode()).append("'");
                } else {
                    sb.append(" AND A.").append(orgColumnMap.get("columnName"));
                    sb.append("='").append(userInfoService.getGrantOrgCode()).append("'");
                }
            } else if (DATA_AUTH_TYPE.SUB_ORG.toString().equals(dataAuth)) { // 辖内机构权限
                if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                    sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE ACCI.ACCT_ORG_ID");
                    sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
                    sb.append(userInfoService.getGrantOrgCode()).append(")($|,)') )");
                } else {
                    sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE A.");
                    sb.append(orgColumnMap.get("columnName"));
                    sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
                    sb.append(grantOrgCode).append(")($|,)') )");
                }
            }
        } catch (Exception e) {
            log.error("get orgColumn error: ", e);
            throw new YuspException("500", "业务信息表【" + infoTableName + "】机构字段未配置");
        }

        sb.append(" AND NOT EXISTS (SELECT 1 FROM ");
        sb.append(periodHisTabName);
        sb.append(" H WHERE H.APPLY_STS = '");
        sb.append(DistributionConstants.UNDER_APPROVAL + "' ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" AND ACCI.CUST_ID = H.CUST_ID AND H.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
        } else {
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

    private String builderQuerySqlNew(Map<String, Object> funInfoMap, String dataAuth, String dataBussAuth, String grantOrgCode) {
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
        sb.append(" SELECT ").append(this.getImpColumnStr(funInfoMap, "A"));


        if (!"1".equals(dstrPeriod)) sb.append(" ,P.EFFECT_DATE, P.EXPIRATE_DATE "); // 多区间

        if (showPerfRateCfg) sb.append(" ,D.PERF_RATE ");

        if ("1".equals(dstrType)) sb.append(" ,D.DISTR_RATE "); // 比例分配
        else if ("2".equals(dstrType)) sb.append(" ,D.DISTR_RATE ,D.START_AMT ,D.END_AMT "); // 比例+定额 分配

        sb.append(" ,D.MANAGER_ID, U.USERNAME AS MANAGER_NAME ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(",acci.ACCT_ORG_ID");
        }
        sb.append(" from ").append(infoTableName).append(" A ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" LEFT JOIN PMA_F_CUST_ACCT_INFO ACCI ON A.CUST_ID = ACCI.CUST_ID ");
        }
        sb.append(" INNER JOIN ");
        sb.append(periodTableName).append(" P ON 1=1 ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" AND P.CUST_ID = ACCI.CUST_ID AND P.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
        } else {
            for (String pk : pkList) {
                sb.append(" AND A.").append(pk).append("= P.").append(pk);
            }
        }

        sb.append(" AND P.EXPIRATE_DATE = '20991231' ");
        sb.append(" INNER JOIN ").append(distributeTabName).append(" D ON P.ID = D.PERIOD_ID ");
        sb.append(" INNER JOIN SYS_USERS U ON D.MANAGER_ID = U.USERID ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" WHERE 1=1 ");
        } else {
            sb.append(" WHERE 1=1 and a.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
        }
        /** 添加数据权限 */
        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);
        try {
            if (DATA_AUTH_TYPE.CUR_ORG.toString().equals(dataAuth)) { // 当前机构权限
                if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                    sb.append(" AND ACCI.ACCT_ORG_ID");
                    sb.append("='").append(userInfoService.getGrantOrgCode()).append("'");
                } else {
                    sb.append(" AND A.").append(orgColumnMap.get("columnName"));
                    sb.append("='").append(userInfoService.getGrantOrgCode()).append("'");
                }
            } else if (DATA_AUTH_TYPE.SUB_ORG.toString().equals(dataAuth)) { // 辖内机构权限
                if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                    sb.append(" AND ACCI.ACCT_ORG_ID");
                    sb.append(" IN (SELECT C.UNITID FROM SYS_UNITS C WHERE REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
                    sb.append(grantOrgCode).append(")($|,)') )");
                } else {
                    sb.append(" AND A.").append(orgColumnMap.get("columnName"));
                    sb.append(" IN (SELECT C.UNITID FROM SYS_UNITS C WHERE REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
                    sb.append(grantOrgCode).append(")($|,)') )");
                }
            }
        } catch (Exception e) {
            log.error("get orgColumn error: ", e);
            throw new YuspException("500", "业务信息表【" + infoTableName + "】机构字段未配置");
        }

        sb.append(" AND NOT EXISTS (SELECT 1 FROM ");
        sb.append(periodHisTabName);
        sb.append(" H WHERE H.APPLY_STS = '");
        sb.append(DistributionConstants.UNDER_APPROVAL + "' ");
        sb.append(" AND H.APPLY_VERSION = '0' ");
        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
            sb.append(" AND ACCI.CUST_ID = H.CUST_ID AND H.ACCT_ORG_ID = ACCI.ACCT_ORG_ID ");
        } else {
            for (String pk : pkList) {
                sb.append(" AND A.").append(pk).append("=H.").append(pk);
            }
        }
        sb.append(") ");

//        /** 增加排序字段 */
//        sb.append(" ORDER BY ");
//		for (String pk : pkList) {
//			sb.append(" A.").append(pk).append(",");
//		}
//        sb.append(" P.EFFECT_DATE ");

        return sb.toString();
    }

    /**
     * @方法名称: getImpColumnStr
     * @方法描述: 获取信息表中的导入字段，各字段以逗号分隔
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings("unchecked")
    public String getImpColumnStr(Map<String, Object> funInfoMap, String alias) {
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
            if ("DSTR_STS".equals(columnName)) {
                continue;
            }
            if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                if ("ACCT_ORG_ID".equals(columnName)) {
                    continue;
                }
            }
            Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
            if (cfgMap != null) {
                if (cfgMap.get("IMP_GRID_FIELD") != null && DistributionConstants.YES.equals(cfgMap.get("IMP_GRID_FIELD"))) {
                    columnStr.append(alias).append(".").append(columnName).append(",");
                } else if (cfgMap.get("IMP_SEARCH_FIELD") != null && DistributionConstants.YES.equals(cfgMap.get("IMP_SEARCH_FIELD"))) {    // 如果是查询项 也需要拼接sql的查询字段
                    columnStr.append(alias).append(".").append(columnName).append(",");
                }
            }
        }
        // mayan   增加分配状态展示列  end
        // mayan   增加分配状态展示列  start
//        columnStr.append("CASE WHEN C.APPLY_STS IS NOT NULL THEN '");
//        columnStr.append(DistributionConstants.TO_APPROVE);
//        columnStr.append("' ELSE (CASE WHEN B.APPLY_STS IS NOT NULL ");
//        columnStr.append(" THEN '");
//        columnStr.append(DistributionConstants.DISTRIBUTED);
//        columnStr.append("' ELSE (CASE WHEN E.APPLY_STS IS NOT NULL THEN '"
//				+ DistributionConstants.AUTO_APPROVE+"' ELSE '"
//						+DistributionConstants.UNDISTRIBUTED+ "' END) ");
//        columnStr.append(" END) END AS DSTR_STS,");
        if (null != columnStr && 0 < columnStr.length()) {// 删除最后的逗号
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
    @SuppressWarnings({"unchecked"})
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
                searchMap.put("dateFormat", StringUtils.isEmpty(columnCfgMap.get("IMP_DATE_FORMAT") + "") ? "yyyy-MM-dd" : columnCfgMap.get("IMP_DATE_FORMAT") + "");
            } else {
                searchMap.put("dataType", DATA_TYPE.String);
            }

            if (columnCfgMap != null && DistributionConstants.YES.equals(columnCfgMap.get("IMP_SEARCH_FIELD"))) {
                if (DistributionConstants.YES.equals(columnCfgMap.get("IMP_LIKE_SEARCH"))) {
                    searchMap.put("compareChar", "like");
                } else {
                    searchMap.put("compareChar", "=");
                }
                if (SEARCH_TYPE.ORG_CHOOSE.toString().equals(columnCfgMap.get("IMP_SEARCH_TYPE"))) {
                    searchMap.put("columnHiddenName", columnName);
                    if (!DistributionConstants.NO.equals(columnCfgMap.get("SUB_ORG"))) {
                        searchMap.put("subOrgQuery", DistributionConstants.YES);
                    }

                } else if (SEARCH_TYPE.DATE_SPAN.toString().equals(columnCfgMap.get("IMP_SEARCH_TYPE"))) {
                    searchMap.put("dateSpan", columnName + "_SPAN");
                } else if (SEARCH_TYPE.DATE_ONLY.toString().equals(columnCfgMap.get("IMP_SEARCH_TYPE"))) {
                    searchMap.put("dateOnly", columnName + "_ONLY");
                } else if (SEARCH_TYPE.MONEY_SPAN.toString().equals(columnCfgMap.get("IMP_SEARCH_TYPE"))) {
                    searchMap.put("moneySpan", columnName + "_MONEY_SPAN");
                }
            } else { // 没有配置查询项的字段,通过拖动到查询面板,亦可作为查询条件,默认精确匹配输入项查询
                searchMap.put("compareChar", "=");
            }
            searchFieldSet.add(searchMap);
        }
        return searchFieldSet;
    }

    /**
     * @函数名称:exportTemplete
     * @函数描述:导出接口
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings("unchecked")
    public File exportTemplete(String fileName, String funCode, String funName, String excelHeader,
                               String searchParams, String dataAuth, String dataBussAuth) {
        try {
            JSONArray excelHeaderArray = JSONArray.parseArray(excelHeader);
            Map<String, Object> searchParamsMap = (Map<String, Object>) JSONArray.parse(searchParams);
            /** 获取功能信息缓存 */
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);

            StringBuffer sql = new StringBuffer().append(this.builderQuerySqlNew(funInfoMap, dataAuth, dataBussAuth, userInfoService.getGrantOrgCode()));
            sql.insert(0, "SELECT  * FROM (");
            sql.append(") X WHERE 1=1 ");

            /** 配置查询条件 */
            Set<Map<String, Object>> searchFieldSet = this.getSearchFieldSet(funInfoMap);
            Object chm = null;
            Object dspan = null;
            Object dmoney = null;
            Object donly = null;
            Object cm = null;
            // 查询条件细分
            for (Map<String, Object> map : searchFieldSet) {
                chm = map.get("columnHiddenName");
                dspan = map.get("dateSpan");
                donly = map.get("dateOnly");
                dmoney = map.get("moneySpan");
                cm = map.get("columnName");
                if (chm != null && !StringUtils.isEmpty(searchParamsMap.get(chm) + "")) {
                    if ((map.get("subOrgQuery") != null) && (DistributionConstants.YES.equals(map.get("subOrgQuery")))) {
                        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                            //机构下辖
                            sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X.ACCT_ORG_ID");
                            sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
                            sql.append(searchParamsMap.get(chm)).append(")($|,)') )");
                        } else {
                            //机构下辖
                            sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X." + map.get("columnName").toString());
                            sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
                            sql.append(searchParamsMap.get(chm)).append(")($|,)') )");
                        }

                    } else {
                        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                            sql.append(" AND X.ACCT_ORG_ID");
                            if ("like".equals(map.get("compareChar")))
                                sql.append(" LIKE '%").append(searchParamsMap.get(chm)).append("%' ");
                            else
                                sql.append(" = '").append(searchParamsMap.get(chm)).append("' ");
                        } else {
                            sql.append(" AND X.").append(cm);
                            if ("like".equals(map.get("compareChar")))
                                sql.append(" LIKE '%").append(searchParamsMap.get(chm)).append("%' ");
                            else
                                sql.append(" = '").append(searchParamsMap.get(chm)).append("' ");
                        }

                    }
                } else if (dspan != null) {
                    if (null != searchParamsMap.get(dspan + "1") && !"".equals(searchParamsMap.get(dspan + "1"))) {
                        sql.append(" AND TO_DATE(X.");
                        sql.append(cm + ",'yyyy-mm-dd') >=");
                        sql.append("TO_DATE('" + searchParamsMap.get(dspan + "1") + "','yyyy-mm-dd') ");
                    }
                    if (null != searchParamsMap.get(dspan + "2") && !"".equals(searchParamsMap.get(dspan + "2"))) {
                        sql.append(" AND TO_DATE(X.");
                        sql.append(cm + ",'yyyy-mm-dd') <=");
                        sql.append("TO_DATE('" + searchParamsMap.get(dspan + "2") + "','yyyy-mm-dd') ");
                    }
                } else if (dmoney != null) {
                    if (null != searchParamsMap.get(dmoney + "1") && !"".equals(searchParamsMap.get(dmoney + "1"))) {
                        sql.append(" AND TO_NUMBER(X.");
                        sql.append(cm + ") >=");
                        sql.append("TO_NUMBER('" + searchParamsMap.get(dmoney + "1") + "') ");
                    }
                    if (null != searchParamsMap.get(dmoney + "2") && !"".equals(searchParamsMap.get(dmoney + "2"))) {
                        sql.append(" AND TO_NUMBER(X.");
                        sql.append(cm + ") <=");
                        sql.append("TO_NUMBER('" + searchParamsMap.get(dmoney + "2") + "') ");
                    }
                } else if (donly != null) {
                    if (null != searchParamsMap.get(donly + "") && !"".equals(searchParamsMap.get(donly + ""))) {
                        sql.append(" AND TO_DATE(X.");
                        sql.append(cm + ",'yyyy-mm-dd') =");
                        sql.append("TO_DATE('" + searchParamsMap.get(dspan + "") + "','yyyy-mm-dd') ");
                    }
                } else if (null != searchParamsMap.get(cm) && !"".equals(searchParamsMap.get(cm))) {
                    sql.append(" AND X.").append(cm);
                    if ("like".equals(map.get("compareChar"))) {
                        sql.append(" like '%");
                        sql.append(searchParamsMap.get(cm));
                        sql.append("%' ");
                    } else {
                        sql.append(" = '");
                        sql.append(searchParamsMap.get(cm));
                        sql.append("' ");
                    }
                }
            }
            return this.createExcel(fileName, excelHeaderArray, sql.toString(), funName, false);
        } catch (Exception e) {
            log.error("performanceImp exportTemplete error: ", e);
            throw new YuspException("500", "业绩批量导入功能,导出模板异常");
        }
    }

    /**
     * @函数名称:exportTempleteByManagerId
     * @函数描述:导出接口-客户经理
     * @参数与返回说明:
     * @算法描述: 根据客户经理编号，导出对应业绩的所有分配信息
     */
    public File exportTempleteByManagerId(String fileName, String funCode, String funName, String excelHeader, String managerId) {
        try {
            JSONArray excelHeaderArray = JSONArray.parseArray(excelHeader);
            /** 获取功能信息缓存 */
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
            StringBuffer sql = new StringBuffer().append(this.builderQuerySqlNew(funInfoMap, null, null, userInfoService.getGrantOrgCode()));
            sql.insert(0, "SELECT  * FROM (");
            sql.append(") X WHERE 1=1 ");
            // 获取分配区间表信息
            Map<String, String> periodTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
            String periodTableName = periodTableMap.get("tableName");
            // 获取分配明细表信息
            Map<String, String> distributeTableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
            String distributeTabName = distributeTableMap.get("tableName");
            // 获取分配主键list
            List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);

            // 拼接sql，查询managerId对应的业绩分配数据
            for (String pk : pkList) {
                sql.append(" and X." + pk + " in "
                        + "(select DISTINCT sub_p." + pk + " from " + periodTableName + " sub_p left join " + distributeTabName + " sub_d on sub_p.ID = sub_d.PERIOD_ID where sub_d.MANAGER_ID = '" + managerId + "')");
            }
            return this.createExcel(fileName, excelHeaderArray, sql.toString(), funName, false);
        } catch (Exception e) {
            log.error("performanceImp exportTempleteByManagerId error: ", e);
            throw new YuspException("500", "业绩批量导入功能,导出模板异常");
        }
    }

    /**
     * @param isErrExport 是否导出错误信息接口调用
     * @函数名称: createExcel
     * @函数描述: 创建导出文件
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings({"deprecation"})
    protected File createExcel(String fileName, JSONArray excelHeaderArray, String sql, String funName, boolean isErrExport) {
        File pathFile = null;
        FileOutputStream fileOut = null;
        XSSFWorkbook wb = null;
        // 创建单元格
        XSSFCell cell = null;
        try {
            /** 获取数据 */
            long startTime = System.currentTimeMillis();
            log.debug("【批量导出】执行SQL查询导出数据开始...");
            List<Map<String, Object>> dataList = commonPerformanceImpMapper.queryList(sql, null);
            long endTime = System.currentTimeMillis();
            log.debug("【批量导出】执行SQL查询导出数据结束,耗时{}秒", (endTime - startTime) / 1000);

            startTime = System.currentTimeMillis();
            log.debug("【批量导出】POI生成EXCEL开始...");
            updateProcess(fileName, "10");
            dataList = mapKeyToUnderline(dataList);
            int totalColumn = excelHeaderArray.size();

            /** 创建Excel */
            // 创建一个工作簿
            wb = new XSSFWorkbook();
            XSSFDataFormat format = wb.createDataFormat();
            // 创建一个sheet页
            XSSFSheet sheet = wb.createSheet();
            /** 准备三个样式及字体：标题样式|列头样式|一般样式 */
            // 标题样式
            XSSFCellStyle titleCellStyle = wb.createCellStyle();
            XSSFFont titleFont = wb.createFont();
            titleFont.setBold(true);// 字体加粗
            titleFont.setFontHeightInPoints((short) 20); // 字号为大号
            titleCellStyle.setFont(titleFont);
            // 默认都设置边框
            titleCellStyle.setBorderTop(BorderStyle.THIN);
            titleCellStyle.setBorderBottom(BorderStyle.THIN);
            titleCellStyle.setBorderLeft(BorderStyle.THIN);
            titleCellStyle.setBorderRight(BorderStyle.THIN);
            titleCellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
            titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
            titleCellStyle.setWrapText(true);// 自动换行
            titleCellStyle.setDataFormat(format.getFormat("@"));
            // Header
            XSSFCellStyle headerCellStyle = wb.createCellStyle();
            XSSFFont headerFont = wb.createFont();
            headerFont.setBold(true);// 字体加粗
            headerFont.setFontHeightInPoints((short) 10); // 字号为大号
            headerCellStyle.setFont(headerFont);
            // 默认都设置边框
            headerCellStyle.setBorderTop(BorderStyle.THIN);
            headerCellStyle.setBorderBottom(BorderStyle.THIN);
            headerCellStyle.setBorderLeft(BorderStyle.THIN);
            headerCellStyle.setBorderRight(BorderStyle.THIN);
            headerCellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
            headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
            headerCellStyle.setWrapText(true);// 自动换行
            headerCellStyle.setDataFormat(format.getFormat("@"));
            // 正常样式
            XSSFCellStyle normalCellStyle = wb.createCellStyle();
            XSSFFont normalFont = wb.createFont();
            normalFont.setBold(false);
            normalFont.setFontHeightInPoints((short) 10);
            normalCellStyle.setFont(normalFont);
            // 默认都设置边框
            normalCellStyle.setBorderTop(BorderStyle.THIN);
            normalCellStyle.setBorderBottom(BorderStyle.THIN);
            normalCellStyle.setBorderLeft(BorderStyle.THIN);
            normalCellStyle.setBorderRight(BorderStyle.THIN);
            normalCellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
            normalCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
            normalCellStyle.setWrapText(true);// 自动换行
            normalCellStyle.setDataFormat(format.getFormat("@"));
            // 错误信息样式
            XSSFCellStyle errCellStyle = wb.createCellStyle();
            XSSFFont errFont = wb.createFont();
            errFont.setBold(true);
            errFont.setColor(new XSSFColor(Color.RED));
            errFont.setFontHeightInPoints((short) 10);
            errCellStyle.setFont(errFont);
            // 默认都设置边框
            errCellStyle.setBorderTop(BorderStyle.THIN);
            errCellStyle.setBorderBottom(BorderStyle.THIN);
            errCellStyle.setBorderLeft(BorderStyle.THIN);
            errCellStyle.setBorderRight(BorderStyle.THIN);
            errCellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平居中
            errCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
            errCellStyle.setWrapText(true);// 自动换行
            errCellStyle.setDataFormat(format.getFormat("@"));

            // 生成Excel标题行
            XSSFRow row = sheet.createRow(0);
            row.setHeight((short) 600);
            // 合并第一行单元格 ,各参数(rowFrom, colFrom, rowTo, colTo)
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, totalColumn - 1));
            // 创建单元格
            cell = row.createCell(0, XSSFCell.CELL_TYPE_STRING);
            cell.setCellStyle(titleCellStyle);
            // 向单元格中写入值
            if (!StringUtils.isNotEmpty(funName)) {
                funName = "";
            }
            cell.setCellValue(funName + "批量导入");
            // 生成 Excel 表头。O(n)
            row = sheet.createRow(1);
            for (int i = 0; i < excelHeaderArray.size(); i++) {
                JSONObject jsonObject = excelHeaderArray.getJSONObject(i);
                cell = row.createCell(i, XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(headerCellStyle);
                cell.setCellValue(jsonObject.getString("label"));
                // 导出excel中，隐藏列 失效日期、起始金额、结束金额
                if ("失效日期".equals(jsonObject.getString("label")) ||
                        "起始金额".equals(jsonObject.getString("label")) ||
                        "结束金额".equals(jsonObject.getString("label"))) {
                    sheet.setColumnHidden(i, true);
                }
            }
            if (isErrExport) {    // 针对 错误信息导出功能，增加错误信息列，追加到列尾
                cell = row.createCell(excelHeaderArray.size(), XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(errCellStyle);
                cell.setCellValue("错误信息\n重新导入时要删除");
                sheet.setColumnWidth(excelHeaderArray.size(), 15 * 2 * 256);    // 设置错误信息列宽，默认15个字
            }

            //判断是否超过允许的最大导出条数
//			if(allowExpMaxSize < dataList.size()) {
//				throw new YuspException("500", "导出数据量超过最大限制【" + allowExpMaxSize + "】,当前数量为【"+dataList.size()+"】");
//			}

            // 生成数据区。O(m*n)
            if (null != dataList && 0 < dataList.size()) {
                // 获取导出的数据中，涉及的所有数据字典的内容，在遍历dataList时直接使用
                Map<String, Map<String, String>> lookupMap = new HashMap<String, Map<String, String>>();
                for (int colIndex = 0; colIndex < excelHeaderArray.size(); ++colIndex) {
                    JSONObject jo = excelHeaderArray.getJSONObject(colIndex);
                    if (jo.get("dataCode") != null) {
                        String lookupCode = jo.get("dataCode").toString();
                        // 根据lookupCode查询该数据字典内容
                        List<Map<String, String>> lookupInfoList = adminSmLookupItemService.getLookupInfoWithCache(lookupCode);
                        if (lookupInfoList != null && lookupInfoList.size() > 0) {
                            Map<String, String> lookupInfoMap = new HashMap<String, String>();
                            for (Map<String, String> map : lookupInfoList) {
                                lookupInfoMap.put(map.get("lookupItemCode"), map.get("lookupItemName"));    // 导出时，将LOOKUP_ITEM_CODE映射为LOOKUP_ITEM_NAME
                            }
                            lookupMap.put(lookupCode, lookupInfoMap);

                            //GC
                            lookupInfoMap.clear();
                            lookupInfoList.clear();
                        }
                    }
                }
                // 遍历dataList，并写入
                int x = dataList.size() / 100;
                int pre = 1;
                for (int i = 2; i < dataList.size() + 2; i++) { // 行
                    if (i == x * pre && pre <= 90) {
                        updateProcess(fileName, "" + (pre > 10 ? pre : 10));
                        pre++;
                    }
                    row = sheet.createRow(i);
                    for (int j = 0; j < excelHeaderArray.size(); j++) { // 列
                        cell = row.createCell(j, XSSFCell.CELL_TYPE_STRING);
                        cell.setCellStyle(normalCellStyle);
                        // 增加数据字典转换
                        JSONObject jo = excelHeaderArray.getJSONObject(j);
                        Object tt = jo.get("dataCode");
                        String lookupId = tt == null ? "" : tt.toString();
                        Object name = jo.get("ename");
                        String data = StringUtils.isEmpty(dataList.get(i - 2).get(name) + "") ? "" : dataList.get(i - 2).get(name) + "";
                        String value = "";
                        if (StringUtils.isEmpty(lookupId)) {
                            value = data;
                        } else {
                            value = lookupMap.get(lookupId) != null ? lookupMap.get(lookupId).get(data) != null ? lookupMap.get(lookupId).get(data) : "" : "";
                        }
                        cell.setCellValue("null".equals(value) ? "" : value);
                    }
                    if (isErrExport) {    // 针对 错误信息导出功能，增加错误信息列，追加到列尾
                        cell = row.createCell(excelHeaderArray.size(), XSSFCell.CELL_TYPE_STRING);
                        cell.setCellStyle(errCellStyle);
                        String checkState = StringUtils.isEmpty(dataList.get(i - 2).get("CHECK_STATE") + "") ? "" : dataList.get(i - 2).get("CHECK_STATE") + "";
                        String errMsg = "";
                        if (!StringUtils.isEmpty(checkState)) {
                            if ("1".equals(checkState.substring(0, 1))) {
                                errMsg += "账号不存在\n";
                            }
                            if ("1".equals(checkState.substring(1, 2))) {
                                errMsg += "客户经理编号不存在\n";
                            }
                            if ("1".equals(checkState.substring(2, 3))) {
                                errMsg += "比例和不为100\n";
                            }
                            if ("1".equals(checkState.substring(3, 4))) {
                                errMsg += "生效日期必须相同\n";
                            }
                        }
                        cell.setCellValue(errMsg.substring(0, errMsg.length() - 1));
                    }
                }
            }

            endTime = System.currentTimeMillis();
            log.debug("【批量导出】POI生成EXCEL结束,耗时{}秒", (endTime - startTime) / 1000);

            //主动清理调用GC
            dataList.clear();

            /** 在服务器端生成文件 */
            String filePath = this.excelTempFileDir;
            if (!filePath.endsWith(File.separator)) {
                filePath += File.separator;
            }
            filePath += File.separator;
            pathFile = new File(filePath + File.separator + "downLoad" + File.separator + fileName);
            if (!pathFile.exists()) {
                pathFile.getParentFile().mkdirs();
            }
            fileOut = new FileOutputStream(pathFile);
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            throw new YuspException("500", "业绩批量导入失败,没有找到读取文件");
        } catch (IOException e) {
            throw new YuspException("500", "业绩批量导入失败,读取文件读写异常");
        } catch (YuspException e) {
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            cell = null;
            wb = null;
            if (Objects.nonNull(fileOut)) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    log.error("close fileOut error: ", e);
                }
            }
            if (Objects.nonNull(wb)) {
                try {
                    wb.close();
                } catch (IOException e) {
                    log.error("close wb error: ", e);
                }
            }
        }
        return pathFile;
    }

    /**
     * @方法名称: checkBatch
     * @方法描述: 查询当前系统是否可以进行业绩分配 转移 导入等业绩操作
     * @参数与返回说明:
     * @算法描述:
     */
    public Boolean checkBatch() {
        String sql = "SELECT count(1) FROM PMA_F_ETL_DATE where etl_state != '1' AND ETL_TYPE = 'PMA'";
        return commonPerformanceImpMapper.checkBatch(sql) > 0;
    }

    /**
     * @方法名称: processImport
     * @方法描述: 导入入口方法
     * @参数与返回说明:
     * @算法描述: 1、生成标准excel头 中英文map： excelHeaderEnMap/excelHeaderCnMap
     * 2、excel格式基本校验（非空且符合标准excel头）
     * 3、excel字段校验
     * 4、生成数据dataList，保存 业绩批量导入主表数据，互斥表插入校验，如果主键重复，表示有在分配审批中的数据，则所有数据不允许导入
     * 5、所有校验成功，保存 业绩批量导入明细表数据
     * 6、生成 ADMIN_FILE_UPLOAD_INFO表数据，方便后续查问题
     * 7、调用 业务校验function
     */
    @SuppressWarnings({"unchecked"})
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public List<String> processImport(String funCode, String excelHeader, String fileRelatePath, MultipartFile mnultiFile, String fileName, String fileNameExt) throws Exception {
        FileInputStream inputStream = null;
        Workbook wb = null;
        try {
            Date currentDate = new Date();
            JSONArray excelHeaderArray = JSONArray.parseArray(excelHeader);
            // 1、生成标准excel头 中英文map： excelHeaderEnMap/excelHeaderCnMap
            // 存放列应在Excel中的第（i-1）列
            Map<String, Integer> excelHeaderEnMap = new HashMap<String, Integer>();// 列英文
            Map<String, Integer> excelHeaderCnMap = new HashMap<String, Integer>();// 列中文
            for (int i = 0; i < excelHeaderArray.size(); i++) {
                excelHeaderEnMap.put(excelHeaderArray.getJSONObject(i).getString("ename"), new Integer(i));
                excelHeaderCnMap.put(excelHeaderArray.getJSONObject(i).getString("label"), new Integer(i));
            }

            List<String> errMsgList = new ArrayList<String>();// 存储错误信息
            String filePath = this.localDiskPath + (this.localDiskPath.endsWith(File.separatorChar + "") ? "" : File.separatorChar) + fileRelatePath;
            File file = new File(filePath);
            if (!file.exists()) {
                throw new YuspException("500", "上传文件不存在");
            }
            inputStream = new FileInputStream(filePath);
            if ("xls".equals(fileNameExt)) {
                wb = new HSSFWorkbook(inputStream);
            } else if ("xlsx".equals(fileNameExt)) {
                wb = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = null;
            if (wb.getSheetAt(0) != null) {
                sheet = wb.getSheetAt(0);
            } else {
                errMsgList.add("excel文件不存在sheet页");
                return errMsgList;
            }
            // 2、 excel格式基本校验（非空且符合标准excel头）
            errMsgList = this.validateBaseInfo(sheet, excelHeaderCnMap);
            if (errMsgList.size() > 0)
                return errMsgList;

            // 获取功能信息缓存
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
            // 获取分配字段的数据字典
            Map<String, Object> columnLookupMap = commonDistributionService.getColumnLookupCfg(funInfoMap);
            // 获取分配主键list
            List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
//	        if("custDstr".equals(funCode)) {	// 客户分配  增加 客户归属机构 字段
//	        	pkList.add("OPER_ORG_ID");
//	        }
            /** 区间：1、单区间；2、多区间 */
            String dstrPeriod = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_PERIOD");
            /** 是否虚拟行员分配  1是  0否 **/
            Boolean virtualDstr = commonDistributionService.virtualDstr(funInfoMap);
            /** 业绩分配开始日期最早日期**/
            String disDateStr = this.getCurrentDstrTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date disDate = StringUtils.isEmpty(disDateStr) ? null : sdf.parse(disDateStr);
            /** 分配类型:1,比例分配; 2,比例+定额分配 */
            String dstrType = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_TYPE");
            /** 是否配置绩效比例 */
            boolean showPerfRateCfg = ("1".equals(commonDistributionService.getPageCfgValue(funInfoMap, "HAS_JXBL"))) ? true : false;

            // 3、excel字段校验
            this.validateColumnInfo(errMsgList, funCode, dstrPeriod, columnLookupMap, disDate, disDateStr,
                    dstrType, showPerfRateCfg, sheet, pkList, excelHeaderEnMap);
            if (errMsgList.size() > 0)
                return errMsgList;

            // 4、生成数据dataList，保存 业绩批量导入主表数据，
            //    互斥表插入校验，如果主键重复，表示有在分配审批中的数据，则所有数据不允许导入
            List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
            dataList = this.getDataListFromSheet(errMsgList, funCode, columnLookupMap, sheet, excelHeaderEnMap);
            PmaFPerformanceBatchInfo pmaFPerformanceBatchInfo = new PmaFPerformanceBatchInfo();
            pmaFPerformanceBatchInfo.setFunCode(funCode);
            pmaFPerformanceBatchInfo.setStatus("0");
            pmaFPerformanceBatchInfo.setCreateTime(currentDate);
            pmaFPerformanceBatchInfo.setCreateUser(userInfoService.getUserInfo().getLoginCode());
            pmaFPerformanceBatchInfo.setWfTotalCount(0);
            pmaFPerformanceBatchInfo.setWfSuccCount(0);
            pmaFPerformanceBatchInfo.setWfErrCount(0);
            pmaFPerformanceBatchInfoMapper.insert(pmaFPerformanceBatchInfo);    // 保存 业绩批量导入业务主表数据
            String batchId = pmaFPerformanceBatchInfo.getBatchId();
            boolean vioUniqueKeyFlag = false;    // 是否 违反唯一约束条件 标志
            Map<String, Object> distinctMap = new HashMap<String, Object>();
            String mutexTableName = "";
            try {
                AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");    // 获取  业绩批量导入互斥表表名
                if (mutexTableInfo != null)
                    mutexTableName = mutexTableInfo.getTableName();
                else {
                    throw new Exception("业绩批量导入业务互斥表表名名获取失败，请查询对应业务配置");
                }
                distinctMap = distinctListByPk(dataList, pkList);    // 过滤dataList中主键值重复的数据
                List<Map<String, Object>> distinctDataList = (List<Map<String, Object>>) distinctMap.get("destList");
                int index = distinctDataList.size() / 1000;
                int remainder = distinctDataList.size() % 1000;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertMutex(mutexTableName, pkList, distinctDataList.stream().skip(i * 1000).limit(1000).collect(Collectors.toList()),
                            "1", batchId, currentDate, userInfoService.getUserInfo().getLoginCode());
                }
            } catch (DataAccessException e) {
                log.error("batchinsert mutexTable error: ", e);
                if (e.getCause().getMessage() != null && e.getCause().getMessage().indexOf("ORA-00001") >= 0) {    // 判断是 违反唯一约束条件
                    vioUniqueKeyFlag = true;
                } else {
                    throw e;
                }
            }
            if (vioUniqueKeyFlag) {    // 导入的数据在去重表中已存在，不允许导入
                // 删除业绩批量导入业务主表和去重表中对应批次的数据
                // 如果此处报错，会在最外围的地方throw异常，本方法事务整体回滚，不影响数据的准确性
                pmaFPerformanceBatchInfoMapper.deleteByPrimaryKey(batchId);
                String mutexDeleteSql = "delete from " + mutexTableName + " where BATCH_ID = '" + batchId + "'";
                commonPerformanceImpMapper.executeDeleteSql(mutexDeleteSql);
                errMsgList.add("存在业绩分配审批中的数据，请在业绩分配完成后重新导入");
                return errMsgList;
            }

            // 5、所有校验成功，保存 业绩批量导入明细表数据
            AdminBaseMetaFunTable tableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
            String dtlTableName = "";
            if (tableInfo != null)
                dtlTableName = tableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入业务明细表名获取失败，请查询对应业务配置");
            }
            List<Map<String, Object>> vDataList = new ArrayList<Map<String, Object>>();    // 如果是  虚拟行员分配，保存分配给虚拟行员的明细数据
            for (Map<String, Object> item : dataList) {
                item.put("BATCH_ID", batchId);
                Map<String, Double> distrRateMap = (Map<String, Double>) distinctMap.get("distrRateMap");
                if (virtualDstr) {    // 是虚拟行员分配
                    String pkValue = "";
                    for (String pk : pkList) {
                        pkValue += item.get(pk) + "$";
                    }
                    if (distrRateMap.get(pkValue) < 100) {
                        Map<String, Object> subItem = new HashMap<String, Object>();
                        subItem.putAll(item);    // 深拷贝，防止subItem修改影响item
                        subItem.put("DISTR_RATE", 100 - distrRateMap.get(pkValue));
                        // 设置 客户经理编号MANAGER_ID字段值： V+机构号字段值
                        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);
                        subItem.put("MANAGER_ID", "V" + subItem.get(orgColumnMap.get("columnName")) + "9999");
                        subItem.put("EXPIRATE_DATE", "20991231");    // 虚拟行员分配，失效时间默认20991231，生效时间不变； 后续要根据现场实际情况修改
                        vDataList.add(subItem);
                        distrRateMap.put(pkValue, 100.0);
                    }
                }
            }
            if (virtualDstr && vDataList.size() > 0) {    // 是虚拟行员分配, 追加分配给虚拟行员的明细数据
                dataList.addAll(vDataList);
            }
            // 分批insert
            int index = dataList.size() / 1000;
            int remainder = dataList.size() % 1000;
            for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                commonPerformanceImpMapper.batchInsert(dtlTableName, dataList.get(0),
                        dataList.stream().skip(i * 1000).limit(1000).collect(Collectors.toList()));
            }

            // 6、生成 ADMIN_FILE_UPLOAD_INFO表数据，方便后续查问题
            AdminFileUploadInfo adminFileUploadInfo = new AdminFileUploadInfo();
            adminFileUploadInfo.setFileName(fileName);
            long size = mnultiFile.getSize() / 1024L;
            adminFileUploadInfo.setFileSize(new BigDecimal(size));
            adminFileUploadInfo.setExtName(fileName.substring(fileName.lastIndexOf(".") + 1));
            adminFileUploadInfo.setUploadTime(cn.com.yusys.yusp.commons.util.DateUtil.formatDateTimeByDef());
            adminFileUploadInfo.setFilePath(fileRelatePath);
            adminFileUploadInfo.setBusNo(batchId);
            fileProviderServiceImpl.insertSelective(adminFileUploadInfo);

            // 7、调用 业务校验function
            Map<String, String> checkTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.CHECK);
            String checkTableName = checkTableInfo.get("tableName");    // 分配关系历史表表名
            Map<String, String> infoTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
            String infoTableName = infoTableInfo.get("tableName");    // 信息表表名
            String vKeycolumnname = "";
            for (String item : pkList) {
                vKeycolumnname += item + "$";
            }
            vKeycolumnname = vKeycolumnname.substring(0, vKeycolumnname.length() - 1);
            FImpCheckModel fImpCheckModel = new FImpCheckModel();
            fImpCheckModel.setvBatchid(batchId);
            fImpCheckModel.setvKeycolumnname(vKeycolumnname);
            fImpCheckModel.setvDtltablename(dtlTableName);
            fImpCheckModel.setvChecktablename(checkTableName);
            fImpCheckModel.setvInfotablename(infoTableName);
            commonPerformanceImpMapper.callFImpCheckFunction(fImpCheckModel);
        } catch (Exception e) {
            log.error("performanceImp processImport error: ", e);
            throw e;
        } finally {
            if (Objects.nonNull(wb)) {
                wb.close();
            }
            if (Objects.nonNull(inputStream)) {
                inputStream.close();
            }
        }
        return null;
    }

    public String getCurrentDstrTime() {
        String sqlStr = "select subStr(MIN(a.DATA),1,4)||'-'||subStr(MIN(a.DATA),5,6)||'-01',MIN(a.DATA)" +
                "  from (select t.data, rownum as rown" +
                "          from PMA_F_TIME_STATE t" +
                "         where t.state = '02'" +
                "         order by t.data desc) a" +
                "  where a.rown = 1";
        return commonPerformanceImpMapper.getCurrentDstrTime(sqlStr);
    }

    /**
     * @方法名称: validateBaseInfo
     * @方法描述: 导入excel基本校验
     * @参数与返回说明:
     * @算法描述: 1、判断excel模板非空
     * 2、判断excel列格式是否满足标准模板列名
     */
    private List<String> validateBaseInfo(Sheet sheet, Map<String, Integer> excelHeaderCnMap) {
        List<String> errMsgList = new ArrayList<String>();
        // 获得总行数,该方法是获取的最后行数下标，所以实际数量应该+1
        int totalRowCount = sheet.getLastRowNum() + 1;
        int totalcoloumCount = sheet.getRow(1).getPhysicalNumberOfCells();// 获得总列数
        /** 校验是否为空模板 */
        if (3 > totalRowCount) {// 数据从第三行开始
            errMsgList.add("Excel模板为空或无数据");
        }
//		else if (excelHeaderCnMap.size() != totalcoloumCount) {	// 校验是否为标准模板
//			errMsgList.add("Excel模板不是标准模板，请检查");
//		}
        else {
            Row row = sheet.getRow(1);// 获取模板列头
            for (int i = 0; i < totalcoloumCount; i++) {
                if (!excelHeaderCnMap.containsKey(row.getCell(i).getStringCellValue())) {
                    errMsgList.add("Excel模板【第" + (i + 1) + "列】不是标准模板列头【" + row.getCell(i).getStringCellValue() + "】有误，请检查");
                    break;
                }
            }
        }
        return errMsgList;
    }

    /**
     * @方法名称: vlaidateColumnInfo
     * @方法描述: 导入excel 字段校验
     * @参数与返回说明:
     * @算法描述: 1、判断 主键字段非空，并做数据字典映射
     * 2、判断 客户经理ID字段MANAGER_ID非空
     * 3、多区间分配，生效日期、失效日期 字段非空、格式yyyy-MM-dd及大小判断
     * 单区间分配，生效日期为当前月前一个月的月初，失效日期为20991231
     * 4、比例分配，分配比例字段 非空/<100/数字判断
     * 定额分配，起始金额/结束金额 非空/数字判断
     * 比例+定额分配，以上两种都判断
     * 5、配置绩效比例，绩效比例 非空/<100/数字判断
     */
    @SuppressWarnings({"deprecation"})
    public void validateColumnInfo(List<String> errMsgList, String funCode, String dstrPeriod, Map<String, Object> pkLookupMap,
                                   Date disDate, String disDateStr, String dstrType, boolean showPerfRateCfg,
                                   Sheet sheet, List<String> pkList, Map<String, Integer> excelHeaderEnMap) {
//		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();// 存储数据信息
        int totalRowCount = sheet.getLastRowNum() + 1;
        Row row = null;
        Cell cell = null;
        int i = 0;
        try {
            for (i = 2; i < totalRowCount; i++) {// 读取行
                row = sheet.getRow(i);
                // 分配主键串、客户经理ID、生效日期、失效日期、起始金额、结束金额、分配比例、绩效比例
                //			Map<String, Object> map = new HashMap<String, Object>();
                for (String pk : pkList) {
                    if (!excelHeaderEnMap.containsKey(pk)) {
                        continue;
                    }
                    cell = row.getCell(excelHeaderEnMap.get(pk));
                    cell.setCellType(CellType.STRING);
                    if (cell == null || StringUtil.isEmpty(cell.getStringCellValue())) {
                        errMsgList.add("第【" + (i + 1) + "】行 ,第【" + excelHeaderEnMap.get(pk) + "】列：该单元格无数据，请查验。");
                        //				} else {
                        //					String cellValue = this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING) + "";
                        //					String cellValueKey = cellValue;
                        ////					if (!"custDstr".equals(funCode) && !pk.equals("OPER_ORG_ID")) {	// 数据字典映射
                        //						if(pkLookupMap.get(pk) != null) {
                        //							String lookupName = ((Map<String, Object>) (pkLookupMap.get(pk))).get("impLookupName") == null ?
                        //									"" : ((Map<String, Object>) (pkLookupMap.get(pk))).get("impLookupName") + "";
                        //							if (!StringUtils.isEmpty(lookupName)) {
                        //								QueryModel model = new QueryModel();
                        //								model.getCondition().put("lookupCode", lookupName);
                        //								model.getCondition().put("lookupItemName", cellValueKey);
                        //								List<Map<String, Object>> resultList = adminSmLookupItemService.selectByModel(model);
                        //								cellValueKey = !StringUtils.isEmpty(resultList.get(0).get("lookupItemCode") + "") ?
                        //										resultList.get(0).get("lookupItemCode") + "" : cellValue;
                        //							}
                        //						}
                        ////					}
                        //					map.put(pk, cellValueKey);
                    }
                }

                cell = row.getCell(excelHeaderEnMap.get("MANAGER_ID"));// 客户经理ID
                cell.setCellType(CellType.STRING);
                if (cell == null || StringUtil.isEmpty(cell.getStringCellValue())) {
                    errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("MANAGER_ID") + "】列：该单元格无数据，请查验。");
                    //			} else {
                    //				map.put("MANAGER_ID", this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING));
                }

                /** 区间：1、单区间；2多区间 */
                if (!"1".equals(dstrPeriod)) {
                    cell = row.getCell(excelHeaderEnMap.get("EFFECT_DATE"));// 生效日期
                    cell.setCellType(CellType.STRING);
                    if (cell == null || StringUtil.isEmpty(cell.getStringCellValue())) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("EFFECT_DATE") + "】列：该单元格无数据，请查验。");
                    } else {
                        String effectDateStr = this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING) + "";
                        if (this.beforeDate(effectDateStr, disDate)) {
                            errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("EXPIRATE_DATE")
                                    + "】列：该单元格不能小于" + disDateStr + "，请查验。");
                        }
                        //					map.put("EFFECT_DATE", effectDateStr);
                    }
                    //				cell = row.getCell(excelHeaderEnMap.get("EXPIRATE_DATE"));// 失效日期
                    //				if (cell == null) {
                    //					errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("EXPIRATE_DATE") + "】列：该单元格无数据，请查验。");
                    //				} else {
                    //					map.put("EXPIRATE_DATE", this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING));
                    //				}
                    //			} else {// 单区间默认生生效日期为当前月前一个月的月初，失效日期为20991231
                    //				map.put("EFFECT_DATE", DateUtil.getPeriousMonthFirst());
                    //				map.put("EXPIRATE_DATE", "20991231");
                }

                /** 分配类型:1,比例分配; 2,比例+定额分配 */
                if ("1".equals(dstrType)) {
                    cell = row.getCell(excelHeaderEnMap.get("DISTR_RATE"));// 分配比例
                    cell.setCellType(CellType.STRING);
                    if (cell == null || StringUtil.isEmpty(cell.getStringCellValue())) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("DISTR_RATE") + "】列：该单元格无数据，请查验。");
                    } else {
//						try {
                        String distrRateStr = this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING) + "";
                        //						int distrRate = Integer.parseInt(distrRateStr);
                        double distrRate = Double.parseDouble(distrRateStr);
                        if (distrRate > 100) {
                            errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("DISTR_RATE")
                                    + "】列：该单元格无效分配比例，不能大于100。");
                        }
//						} catch (NumberFormatException ex) {
//							errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("DISTR_RATE") + "】列：该单元格无效分配比例，请填入数字。");
//						}
                        //					map.put("DISTR_RATE", this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING));
                    }
                } else if ("2".equals(dstrType)) {
                    cell = row.getCell(excelHeaderEnMap.get("DISTR_RATE"));// 分配比例
                    cell.setCellType(CellType.STRING);
                    if (cell == null || StringUtil.isEmpty(cell.getStringCellValue())) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("DISTR_RATE") + "】列：该单元格无数据，请查验。");
                        //				} else {
                        //					map.put("DISTR_RATE", this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING));
                    }
                }
                if (showPerfRateCfg) {
                    cell = row.getCell(excelHeaderEnMap.get("PERF_RATE"));// 绩效比例
                    cell.setCellType(CellType.STRING);
                    if (cell == null || StringUtil.isEmpty(cell.getStringCellValue())) {
                        errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("PERF_RATE") + "】列：该单元格无数据，请查验。");
                    } else {
//						try {
                        //						int distrRate = Integer.parseInt(this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING).toString());
                        double distrRate = Double.parseDouble(this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING).toString());
                        if (distrRate > 100) {
                            errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("DISTR_RATE")
                                    + "】列：该单元格无效分配比例，不能大于100。");
                        }
//						} catch (NumberFormatException ex) {
//							errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("DISTR_RATE") + "】列：该单元格无效分配比例，请填入数字。");
//						}
                        //					map.put("PERF_RATE", this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING));
                    }
                }
                //			map.put("EXCEL_FALG", "true");
                //			dataList.add(map);
            }
        } catch (NumberFormatException ex) {
            errMsgList.add("第【" + (i + 1) + "】行,第【" + excelHeaderEnMap.get("DISTR_RATE") + "】列：该单元格无效分配比例，请填入数字。");
        }
    }

    /**
     * @方法名称: getDataListFromSheet
     * @方法描述: 遍历excel，生成dataList
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings({"unchecked", "deprecation"})
    public List<Map<String, Object>> getDataListFromSheet(List<String> errMsgList, String funCode, Map<String, Object> columnLookupMap,
                                                          Sheet sheet, Map<String, Integer> excelHeaderEnMap) {
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        // 获取选择的业绩类型，涉及的所有数据字典的内容，在遍历sheet页数据时直接使用
        Map<String, Map<String, String>> lookupMap = new HashMap<String, Map<String, String>>();
        for (String columnName : columnLookupMap.keySet()) {
            Map<String, String> columnMap = (Map<String, String>) columnLookupMap.get(columnName);
            String lookupCode = columnMap.get("impLookupName");
            if (StringUtil.isNotEmpty(lookupCode)) {
                // 根据lookupCode查询该数据字典内容
                List<Map<String, String>> lookupInfoList = adminSmLookupItemService.getLookupInfoWithCache(lookupCode);
                if (lookupInfoList != null && lookupInfoList.size() > 0) {
                    Map<String, String> lookupInfoMap = new HashMap<String, String>();
                    for (Map<String, String> map : lookupInfoList) {
                        lookupInfoMap.put(map.get("lookupItemName"), map.get("lookupItemCode"));    // 导入时，将LOOKUP_ITEM_NAME映射为LOOKUP_ITEM_CODE
                    }
                    lookupMap.put(lookupCode, lookupInfoMap);
                }
            }
        }
        // 获得总行数,该方法是获取的最后行数下标，所以实际数量应该+1
        int totalRowCount = sheet.getLastRowNum() + 1;
        Row row = null;
        Cell cell = null;
        for (int i = 2; i < totalRowCount; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            // 读取行
            row = sheet.getRow(i);
            for (String columnName : excelHeaderEnMap.keySet()) {
                cell = row.getCell(excelHeaderEnMap.get(columnName));
                String cellValue = cell == null ? "" : this.getCellValueByType(cell, errMsgList, XSSFCell.CELL_TYPE_STRING) + "";
                // 针对 失效日期、起始金额、结束金额字段，设置默认值
                if ("EXPIRATE_DATE".equals(columnName)) {
                    cellValue = "20991231";
                } else if ("START_AMT".equals(columnName)) {
                    cellValue = "0";
                } else if ("END_AMT".equals(columnName)) {
                    cellValue = "99999999999999";
                } else {    // 针对配置数据字典的字段，映射实际值
                    if (columnLookupMap.get(columnName) != null) {
                        String lookupCode = ((Map<String, Object>) (columnLookupMap.get(columnName))).get("impLookupName") == null ?
                                "" : ((Map<String, Object>) (columnLookupMap.get(columnName))).get("impLookupName") + "";
                        cellValue = lookupMap.get(lookupCode) != null ? lookupMap.get(lookupCode).get(cellValue) != null ? lookupMap.get(lookupCode).get(cellValue) : "" : "";
                    }
                }
                map.put(columnName, cellValue);
            }
            dataList.add(map);
        }
        return dataList;
    }

    /**
     * @方法名称: getCellValueByType
     * @方法描述: 获取单元格的值
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings("deprecation")
    private Object getCellValueByType(Cell cell, List<String> errMsgList, int cellType) {
        Object retObject = "";
        try {
            switch (cell.getCellType()) { // 读取单元格的数据类型,注意日期格式的话在这里识别为数值
                case Cell.CELL_TYPE_STRING:
                    retObject = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    retObject = "";
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    retObject = cell.getNumericCellValue();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            String msg = "该单元格信息格式有误，请检查";
            this.setMsg(cell, errMsgList, msg);
        }
        return retObject;
    }

    /**
     * @方法名称: setMsg
     * @方法描述: 设置错误信息
     * @参数与返回说明:
     * @算法描述:
     */
    private void setMsg(Cell cell, List<String> errMsgList, String msg) {
        if (null != cell) {
            msg = "第【" + (cell.getRowIndex() + 1) + "行】,第【" + (cell.getColumnIndex() + 1) + "】列：" + msg;
        }
        errMsgList.add(msg);
    }

    /**
     * @方法名称: beforeDate
     * @方法描述: 判断 effectDateStr disDate日期大小
     * @参数与返回说明:
     * @算法描述:
     */
    private boolean beforeDate(String effectDateStr, Date disDate) {
        if (disDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date effectDate = null;
            try {
                effectDate = sdf.parse(effectDateStr);
                if (effectDate.before(disDate)) {
                    return true;
                }
            } catch (ParseException e) {
                log.error("SimpleDateFormat parse error: ", e);
            }
        }
        return false;
    }

    /**
     * @方法名称: queryResultList
     * @方法描述: 批量导入结果页面-列表查询接口
     * @参数与返回说明:
     * @算法描述: 无
     */
    public List<Map<String, Object>> queryResultList(QueryModel model) {
        model.getCondition().put("loginCode", userInfoService.getUserInfo().getLoginCode());
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = commonPerformanceImpMapper.queryResultList(model);
        PageHelper.clearPage();
        for (Map<String, Object> item : list) {
            if (item.get("batchId") != null) {
                Map<String, Integer> batchResult = fixedThreadPoolManager.getFromBatchResultMap(item.get("batchId") + "");
                if (batchResult != null) {
                    item.put("wfSuccCount", batchResult.get(FixedThreadPoolManager.BATCH_RESULT_SUCCESS) +
                            (batchResult.get(FixedThreadPoolManager.DB_BATCH_RESULT_SUCCESS) != null ?
                                    batchResult.get(FixedThreadPoolManager.DB_BATCH_RESULT_SUCCESS) : 0));
                    item.put("wfErrCount", batchResult.get(FixedThreadPoolManager.BATCH_RESULT_ERROR));
                }
            }
        }
        return list;
    }

    /**
     * @函数名称:exportErrData
     * @函数描述:导出错误数据接口
     * @参数与返回说明:
     * @算法描述:
     */
    public File exportErrData(String fileName, String funCode, String funName, String excelHeader, String batchId) {
        try {
            JSONArray excelHeaderArray = JSONArray.parseArray(excelHeader);
            /** 获取功能信息缓存 */
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);

            AdminBaseMetaFunTable tableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
            String dtlTableName = "";
            if (tableInfo != null)
                dtlTableName = tableInfo.getTableName();

            StringBuffer sql = new StringBuffer();
            sql.append("select a.* from " + dtlTableName + " a where a.BATCH_ID = '" + batchId + "'");
            sql.insert(0, "SELECT DISTINCT X.*, rtn.CHECK_STATE FROM (");
            sql.append(") X ");

            List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
            // 关联 业绩批量导入校验表 构造sql, 查询校验失败的数据
            AdminBaseMetaFunTable checkTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "07");    // 获取  业绩批量导入校验表表名
            String checkTableName = "";
            if (checkTableInfo != null)
                checkTableName = checkTableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入校验表表名获取失败，请查询对应业务配置");
            }
            sql.append(" left join " + checkTableName + " rtn on ");
            for (String pkColName : pkList) {
                sql.append(" X." + pkColName + " = rtn." + pkColName + " and ");
            }
            sql.append(" X.BATCH_ID = rtn.BATCH_ID ");
            sql.append(" where rtn.CHECK_STATE != '0000' ");
            return this.createExcel(fileName, excelHeaderArray, sql.toString(), funName, true);
        } catch (Exception e) {
            log.error("performanceImp exportErrData error: ", e);
            throw new YuspException("500", "业绩批量导入功能,导出模板异常");
        }
    }

    /**
     * @方法名称: invokeBatchData
     * @方法描述: 批次撤销接口
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void invokeBatchData(String funCode, String batchId) throws Exception {
        try {
            // 根据funCode,获取明细表、校验表、互斥表表名
            AdminBaseMetaFunTable dtlTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
            String dtlTableName = "";
            if (dtlTableInfo != null)
                dtlTableName = dtlTableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入业务明细表名获取失败，请查询对应业务配置");
            }
            AdminBaseMetaFunTable checkTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "07");    // 获取  业绩批量导入校验表表名
            String checkTableName = "";
            if (checkTableInfo != null)
                checkTableName = checkTableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入校验表表名获取失败，请查询对应业务配置");
            }
            AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");    // 获取  业绩批量导入互斥表表名
            String mutexTableName = "";
            if (mutexTableInfo != null)
                mutexTableName = mutexTableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入互斥表表名获取失败，请查询对应业务配置");
            }
            // 构造删除sql
            String infoDeleteSql = "delete from PMA_F_PERFORMANCE_BATCH_INFO where BATCH_ID = '" + batchId + "'";
            String dtlDeleteSql = "delete from " + dtlTableName + " where BATCH_ID = '" + batchId + "'";
            String checkDeleteSql = "delete from " + checkTableName + " where BATCH_ID = '" + batchId + "'";
            String mutexDeleteSql = "delete from " + mutexTableName + " where BATCH_ID = '" + batchId + "'";
            commonPerformanceImpMapper.executeDeleteSql(infoDeleteSql);
            commonPerformanceImpMapper.executeDeleteSql(dtlDeleteSql);
            commonPerformanceImpMapper.executeDeleteSql(checkDeleteSql);
            commonPerformanceImpMapper.executeDeleteSql(mutexDeleteSql);
        } catch (Exception e) {
            log.error("invokeBatchData error, funCode:" + funCode + "; batchId:" + batchId, e);
            throw e;
        }
    }

    /**
     * @方法名称: processErrImport
     * @方法描述: 导入错误数据文件接口
     * @参数与返回说明:
     * @算法描述: 1、生成标准excel头 中英文map： excelHeaderEnMap/excelHeaderCnMap
     * 2、excel格式基本校验（非空且符合标准excel头）
     * 3、excel字段校验
     * 4、生成数据dataList，更新 业绩批量导入主表数据 执行状态为0待校验
     * 5、所有校验成功，删除 业绩批量导入互斥表中对应主键数据、明细表对应主键数据，之后新增明细表数据、互斥表数据
     * 6、调用业务校验function
     */
    @SuppressWarnings({"unchecked"})
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public List<String> processErrImport(String batchId, String funCode, String excelHeader, String fileRelatePath, MultipartFile mnultiFile, String fileName, String fileNameExt) throws Exception {
        FileInputStream inputStream = null;
        Workbook wb = null;
        try {
            Date currentDate = new Date();
            JSONArray excelHeaderArray = JSONArray.parseArray(excelHeader);
            // 1、生成标准excel头 中英文map： excelHeaderEnMap/excelHeaderCnMap
            // 存放列应在Excel中的第（i-1）列
            Map<String, Integer> excelHeaderEnMap = new HashMap<String, Integer>();// 列英文
            Map<String, Integer> excelHeaderCnMap = new HashMap<String, Integer>();// 列中文
            for (int i = 0; i < excelHeaderArray.size(); i++) {
                excelHeaderEnMap.put(excelHeaderArray.getJSONObject(i).getString("ename"), new Integer(i));
                excelHeaderCnMap.put(excelHeaderArray.getJSONObject(i).getString("label"), new Integer(i));
            }

            List<String> errMsgList = new ArrayList<String>();// 存储错误信息
            String filePath = this.localDiskPath + (this.localDiskPath.endsWith(File.separatorChar + "") ? "" : File.separatorChar) + fileRelatePath;
            File file = new File(filePath);
            if (!file.exists()) {
                throw new YuspException("500", "上传文件不存在");
            }
            inputStream = new FileInputStream(filePath);
            if ("xls".equals(fileNameExt)) {
                wb = new HSSFWorkbook(inputStream);
            } else if ("xlsx".equals(fileNameExt)) {
                wb = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = null;
            if (wb.getSheetAt(0) != null) {
                sheet = wb.getSheetAt(0);
            } else {
                errMsgList.add("excel文件不存在sheet页");
                return errMsgList;
            }
            // 2、 excel格式基本校验（非空且符合标准excel头）
            errMsgList = this.validateBaseInfo(sheet, excelHeaderCnMap);
            if (errMsgList.size() > 0)
                return errMsgList;
            // 获取功能信息缓存
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
            // 获取分配字段的数据字典
            Map<String, Object> columnLookupMap = commonDistributionService.getColumnLookupCfg(funInfoMap);
            // 获取分配主键list
            List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
//	        if("custDstr".equals(funCode)) {	// 客户分配  增加 客户归属机构 字段
//	        	pkList.add("OPER_ORG_ID");
//	        }
            /** 区间：1、单区间；2、多区间 */
            String dstrPeriod = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_PERIOD");
            /** 是否虚拟行员分配  1是  0否 **/
            Boolean virtualDstr = commonDistributionService.virtualDstr(funInfoMap);
            /** 业绩分配开始日期最早日期**/
            String disDateStr = this.getCurrentDstrTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date disDate = StringUtils.isEmpty(disDateStr) ? null : sdf.parse(disDateStr);
            /** 分配类型:1,比例分配; 2,比例+定额分配 */
            String dstrType = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_TYPE");
            /** 是否配置绩效比例 */
            boolean showPerfRateCfg = ("1".equals(commonDistributionService.getPageCfgValue(funInfoMap, "HAS_JXBL"))) ? true : false;

            // 3、excel字段校验
            this.validateColumnInfo(errMsgList, funCode, dstrPeriod, columnLookupMap, disDate, disDateStr,
                    dstrType, showPerfRateCfg, sheet, pkList, excelHeaderEnMap);
            if (errMsgList.size() > 0)
                return errMsgList;

            // 4、生成数据dataList，更新 业绩批量导入主表数据 执行状态为0待校验
            List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
            dataList = this.getDataListFromSheet(errMsgList, funCode, columnLookupMap, sheet, excelHeaderEnMap);
            pmaFPerformanceBatchInfoMapper.updateStatusByBatchIdAndFunCode(batchId, funCode, "0");

            // 5、所有校验成功，删除 业绩批量导入互斥表中对应主键数据、明细表对应主键数据，之后新增明细表数据、互斥表数据，删除校验表中对应批次号、业务主键数据
            for (Map<String, Object> item : dataList) {
                item.put("BATCH_ID", batchId);
            }
            // ***由于重新上传的数据中，主键字段值也会变化，所以在删除的时候根据 校验结果表中查出的主键数据进行删除
            AdminBaseMetaFunTable checkTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "07");    // 获取  业绩批量导入校验表表名
            String checkTableName = "";
            if (checkTableInfo != null)
                checkTableName = checkTableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入校验表表名获取失败，请查询对应业务配置");
            }
            String errDataListSql = "select * from " + checkTableName + " where BATCH_ID = '" + batchId + "' and CHECK_STATE != '0000' ";
            List<Map<String, Object>> errDataList = commonPerformanceImpMapper.executeQuerySql(errDataListSql);
            errDataList = mapKeyToUnderline(errDataList);    // 字段名驼峰转下划线

            AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");    // 获取  业绩批量导入互斥表表名
            String mutexTableName = mutexTableInfo.getTableName();    // 互斥表表名
            // 根据校验结果表的主键字段值，批量删除互斥表中对应数据
            commonPerformanceImpMapper.batchDelete(mutexTableName, batchId, pkList, errDataList);
            Map<String, Object> distinctMap = new HashMap<String, Object>();
            try {
                distinctMap = distinctListByPk(dataList, pkList);    // 过滤dataList中主键值重复的数据
                List<Map<String, Object>> distinctDataList = (List<Map<String, Object>>) distinctMap.get("destList");
                int index = distinctDataList.size() / 1000;
                int remainder = distinctDataList.size() % 1000;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertMutex(mutexTableName, pkList, distinctDataList.stream().skip(i * 1000).limit(1000).collect(Collectors.toList()),
                            "1", batchId, currentDate, userInfoService.getUserInfo().getLoginCode());
                }
            } catch (DataAccessException e) {
                log.error("batchinsert mutexTable error: ", e);
                throw e;
            }
            AdminBaseMetaFunTable tableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
            String dtlTableName = "";
            if (tableInfo != null)
                dtlTableName = tableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入业务明细表名获取失败，请查询对应业务配置");
            }
            // 根据校验结果表的主键字段值，批量删除明细表中对应数据
            commonPerformanceImpMapper.batchDelete(dtlTableName, batchId, pkList, errDataList);

            if (virtualDstr) {    // 是虚拟行员分配，增加分配给虚拟行员的明细数据
                List<Map<String, Object>> vDataList = new ArrayList<Map<String, Object>>();    // 如果是  虚拟行员分配，保存分配给虚拟行员的明细数据
                for (Map<String, Object> item : dataList) {
                    Map<String, Double> distrRateMap = (Map<String, Double>) distinctMap.get("distrRateMap");
                    String pkValue = "";
                    for (String pk : pkList) {
                        pkValue += item.get(pk) + "$";
                    }
                    if (distrRateMap.get(pkValue) < 100) {
                        Map<String, Object> subItem = new HashMap<String, Object>();
                        subItem.putAll(item);    // 深拷贝，防止subItem修改影响item
                        subItem.put("DISTR_RATE", 100 - distrRateMap.get(pkValue));
                        // 设置 客户经理编号MANAGER_ID字段值： V+机构号字段值
                        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);
                        subItem.put("MANAGER_ID", "V" + subItem.get(orgColumnMap.get("columnName")) + "9999");
                        subItem.put("EXPIRATE_DATE", "20991231");    // 虚拟行员分配，失效时间默认20991231，生效时间不变； 后续要根据现场实际情况修改
                        vDataList.add(subItem);
                        distrRateMap.put(pkValue, 100.0);
                    }
                }
                if (virtualDstr && vDataList.size() > 0) {    // 是虚拟行员分配, 追加分配给虚拟行员的明细数据
                    dataList.addAll(vDataList);
                }
            }
            // 分批insert
            int index = dataList.size() / 1000;
            int remainder = dataList.size() % 1000;
            for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                commonPerformanceImpMapper.batchInsert(dtlTableName, dataList.get(0),
                        dataList.stream().skip(i * 1000).limit(1000).collect(Collectors.toList()));
            }
            // 删除校验表中对应批次号、业务主键数据
            String dtlCheckDataSql = "delete from " + checkTableName + " where BATCH_ID = '" + batchId + "' and CHECK_STATE != '0000' ";
            commonPerformanceImpMapper.executeDeleteSql(dtlCheckDataSql);

            // 6、调用业务校验function
            Map<String, String> infoTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
            String infoTableName = infoTableInfo.get("tableName");    // 信息表表名
            String vKeycolumnname = "";
            for (String item : pkList) {
                vKeycolumnname += item + "$";
            }
            vKeycolumnname = vKeycolumnname.substring(0, vKeycolumnname.length() - 1);
            FImpCheckModel fImpCheckModel = new FImpCheckModel();
            fImpCheckModel.setvBatchid(batchId);
            fImpCheckModel.setvKeycolumnname(vKeycolumnname);
            fImpCheckModel.setvDtltablename(dtlTableName);
            fImpCheckModel.setvChecktablename(checkTableName);
            fImpCheckModel.setvInfotablename(infoTableName);
            commonPerformanceImpMapper.callFImpCheckFunction(fImpCheckModel);
        } catch (Exception e) {
            log.error("performanceImp processErrImport error: ", e);
            throw e;
        } finally {
            if (Objects.nonNull(wb)) {
                wb.close();
            }
            if (Objects.nonNull(inputStream)) {
                inputStream.close();
            }
        }
        return null;
    }

    /**
     * @方法名称: processWorkFlow
     * @方法描述: 执行/发起工作流接口
     * @参数与返回说明:
     * @算法描述: 1、准备必要参数数据
     * 2、调用 预处理数据接口
     * 3、删除 原分配关系表、分配区间表数据，更新信息表DSTR_STS审批状态字段值；生成 审批流 扩展参数数据
     * 4、新增 分配关系历史表、分配关系表数据
     * 5、新增 分配区间历史表、分配区间表数据
     * 6、根据是否审批，更新批量导入业务主表-执行状态字段数据
     * 7、发起审批流
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public Map<String, Object> processWorkFlow(String batchId, String funCode) throws Exception {
        try {
            Instant startInstant = Instant.now();    // TODO
            // 1、准备必要参数数据
            // 获取功能信息缓存
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
            // 获取分配主键list
            List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
            String pkColumnNames = pkList.get(0);    // 主键字段名

            AdminBaseMetaFunTable tableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
            String dtlTableName = "";
            if (tableInfo != null)
                dtlTableName = tableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入业务明细表名获取失败，请查询对应业务配置");
            }
            String dtlQuerySql = "select * from " + dtlTableName + " where BATCH_ID = '" + batchId + "'";
            List<Map<String, Object>> dtlDataList = commonPerformanceImpMapper.executeQuerySql(dtlQuerySql);    // 获取 批量导入明细表 数据
            dtlDataList = mapKeyToUnderline(dtlDataList);

            System.out.println("performance sync a:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO

            Map<String, String> infoTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
            String infoTableName = infoTableInfo.get("tableName");    // 信息表表名
            Map<String, String> periodTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
            String periodTableName = periodTableInfo.get("tableName");    // 分配区间表表名
            Map<String, String> distributeTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
            String distributeTableName = distributeTableInfo.get("tableName");    // 分配关系表表名
            Map<String, String> periodHisTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
            String periodHisTableName = periodHisTableInfo.get("tableName");    // 分配区间历史表表名
            Map<String, String> distributeHisTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE_HIS);
            String distributeHisTableName = distributeHisTableInfo.get("tableName");    // 分配关系历史表表名

            boolean needApply = commonDistributionService.needApply(funInfoMap);    // 是否需要审批
            Set<String> dataPkSet = new HashSet<String>();
            Map<Map<String, Object>, List<Map<String, Object>>> dataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
            // 工作流相关参数
            Map<String, Map<String, Object>> dataEchainMap = new HashMap<String, Map<String, Object>>();
            // 2、调用 预处理数据接口
            dataMetaMap = this.prepareData(funCode, dtlDataList, dataPkSet, dataMetaMap, pkColumnNames, dataEchainMap, funInfoMap,
                    periodTableName, distributeTableName, needApply);

            System.out.println("performance sync b:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
//	        StringBuffer pkColumnNames = new StringBuffer();
//			for (String pk : pkList) {
//				pkColumnNames.append(pk).append("&");
//			}
//			pkColumnNames.deleteCharAt(pkColumnNames.length() - 1);
            // 存放每个分配主键对应的工作流ID
            Map<String, String> pkInstanceIdMap = new HashMap<String, String>();
            List<Map<String, Object>> instanceList = new ArrayList<Map<String, Object>>();
            Integer wfTotalCount = 0;    // 待发起的工作流总数

            // 本期没有条线概念
//			String buss = ((Map) auth.getRolesInfo().get(0)).get("BUSS_SYS_NO").toString();
            String buss = "";
            // 当前登陆者角色号
            String role = userInfoService.getUserInfo().getRoles().get(0).getCode();
            // 根据分配主键（账号）获取其工作流相关参数
            Map<String, Object> metaEchainMap = null;
            // 生成审批流参数map
            String instanceId = null;
            Integer executingBactchCount = pmaFPerformanceBatchInfoMapper.getExecuteBatchCount();    // 查询执行状态为11正在生成工作流的批次数量
            Map<String, Object> instanceMap = null;
            Map<String, Object> paramMap = null;
            // 不需要审批的 主键、业务归属机构 list，用于后续统一批量删除: 分配关系表、分配区间表数据；批量更新: info表DSTR_STS字段值为已分配
            List<Map<String, String>> toDeleteKeyAndOrgIdList = new ArrayList<Map<String, String>>();
            Map<String, String> toDeleteKeyAndOrgIdMap = null;
            // 3、删除 原分配关系表、分配区间表数据，更新信息表DSTR_STS审批状态字段值；生成 审批流 扩展参数数据
            for (String key : dataPkSet) {
                if (key.split("_")[pkList.size()].equals("false")) {
                    needApply = false;
                } else {
                    needApply = true;
                }
//	        	needApply = false;	// for test TODO delete
                // *** 如果需要审批，此处限制-正在生成工作流-的批次数据个数
//	        	if(needApply) {
//	        		if(executingBactchCount >= synExecuteMaxSize) {
//	        			throw new Exception("over syn-execute-max-size");
//	        		}
//	        	}
                if (!needApply) {    // 不需要审批
                    // 临时存储-不需要审批的 主键、业务归属机构数据
                    toDeleteKeyAndOrgIdMap = new HashMap<String, String>();
                    toDeleteKeyAndOrgIdMap.put("pkValue", key.split("_")[0]);
                    if ("ComCustDstr".equals(funCode) || "PerCustDstr".equals(funCode)) {
                        // 根据分配主键（账号）获取其工作流相关参数
                        metaEchainMap = dataEchainMap.get(key);
                        toDeleteKeyAndOrgIdMap.put("orgId", metaEchainMap.get("ORG_ID") + "");
                    }
                    toDeleteKeyAndOrgIdList.add(toDeleteKeyAndOrgIdMap);
//	        		// 删除关系生效表
//	                StringBuilder deleteDistributeSql = new StringBuilder();
//	                deleteDistributeSql.append("DELETE FROM ");
//	                deleteDistributeSql.append(distributeTableName);
//	                deleteDistributeSql.append(" A WHERE EXISTS (SELECT 1 FROM ");
//	                deleteDistributeSql.append(periodTableName);
//	                deleteDistributeSql.append(" B WHERE A.PERIOD_ID=B.ID ");
//					for (int i = 0; i < pkList.size(); i++) {
//						if (pkList.get(i).equals("OPER_ORG_ID")) {
//							deleteDistributeSql.append("AND B.Org_Id");
//							deleteDistributeSql.append(" ='").append(key.split("_")[i]).append("' ");
//						} else {
//							deleteDistributeSql.append("AND B.").append(pkList.get(i));
//							deleteDistributeSql.append(" ='").append(key.split("_")[i]).append("' ");
//						}
//					}
//					deleteDistributeSql.append(")");
//					commonPerformanceImpMapper.executeDeleteSql(deleteDistributeSql.toString());
//
//					// 删除区间生效表
//	                StringBuilder deletePeriodSql = new StringBuilder();
//	                deletePeriodSql.append("DELETE FROM ");
//	                deletePeriodSql.append(periodTableName);
//	                deletePeriodSql.append(" A WHERE 1=1 ");
//					for (int i = 0; i < pkList.size(); i++) {
//						if (pkList.get(i).equals("OPER_ORG_ID")) {
//							deletePeriodSql.append("AND A.ORG_ID");
//							deletePeriodSql.append(" ='").append(key.split("_")[i]).append("' ");
//						} else {
//							deletePeriodSql.append("AND A.").append(pkList.get(i));
//							deletePeriodSql.append(" ='").append(key.split("_")[i]).append("' ");
//						}
//					}
//					commonPerformanceImpMapper.executeDeleteSql(deletePeriodSql.toString());
//
//					if (!"custDstr".equals(funCode)) {	// 如果不是客户分配，更新业务信息表的分配状态
//						StringBuilder updateInfo = new StringBuilder();
//						updateInfo.append("UPDATE ");
//						updateInfo.append(infoTableName);
//						updateInfo.append(" SET DSTR_STS = '");
//						updateInfo.append(DistributionConstants.DISTRIBUTED);
//						updateInfo.append("' WHERE 1=1 ");
//						for (int i = 0; i < pkList.size(); i++) {
//							updateInfo.append(" AND ").append(pkList.get(i));
//							updateInfo.append(" ='").append(key.split("_")[i]).append("' ");
//						}
//						// 分区表-ETL_DATE处理
//						if(!"ComCustDstr".equals(funCode) && !"PerCustDstr".equals(funCode)) {
//							updateInfo.append(" and etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA') ");
//						}
//						commonPerformanceImpMapper.executeUpdateSql(updateInfo.toString());
//					}
                } else {    // 需要审批，生成流程参数
                    // 根据分配主键（账号）获取其工作流相关参数
                    metaEchainMap = dataEchainMap.get(key);

                    // 生成审批流参数map
                    instanceId = UUID.randomUUID().toString().replaceAll("-", "");
                    pkInstanceIdMap.put(key, instanceId);

                    paramMap = new HashMap<String, Object>(); // 流程参数
                    paramMap.put("funCode", funCode);//业务功能编码
                    paramMap.put("unitlevel", userInfoService.getOrgLevel()); // 机构层级
                    paramMap.put("unitid", userInfoService.getUserInfo().getOrg().getCode()); // 机构号
                    paramMap.put("interBuss", metaEchainMap.get("interBuss")); // 跨条线
                    paramMap.put("interOrg", metaEchainMap.get("interOrg")); // 跨机构
                    paramMap.put("interBranch", metaEchainMap.get("interBranch")); // 是否跨分行
                    paramMap.put("virtualDstr", metaEchainMap.get("virtualDstr")); // 虚拟行员分配
//	                paramMap.put("pOrgId", metaEchainMap.get("pOrgId"));
//	                paramMap.put("org",  metaEchainMap.get("org"));
                    paramMap.put("role", role);
                    paramMap.put("buss", buss);
//	                paramMap.put("users", metaEchainMap.get("users"));
                    paramMap.put("bizSeqNo", instanceId);

                    // 保存流程信息,待发起
                    instanceMap = new HashMap<String, Object>();
                    instanceMap.put("applyId", instanceId);    // 审批编号
                    instanceMap.put("pkColumnValues", key);    // 业务主键值（多个_分隔）
                    instanceMap.put("pkColumnNames", pkColumnNames);    // 业务主键字段名（多个&分隔）
//	                instanceMap.put("operateTime", DateUtil.getFullDateNoMils());
                    paramMap.put("orgId", metaEchainMap.get("ORG_ID"));    // 工作流自定义参数  业绩归属机构
                    instanceMap.put("paramMap", paramMap);

                    // modify at 2020/10/22
                    instanceMap.put("funCode", funCode);//业务功能编码
                    instanceMap.put("unitlevel", userInfoService.getOrgLevel()); // 机构层级
                    instanceMap.put("unitid", userInfoService.getUserInfo().getOrg().getCode()); // 机构号
                    instanceMap.put("interBuss", metaEchainMap.get("interBuss")); // 跨条线
                    instanceMap.put("interOrg", metaEchainMap.get("interOrg")); // 跨机构
                    instanceMap.put("interBranch", metaEchainMap.get("interBranch")); // 是否跨分行
                    instanceMap.put("virtualDstr", metaEchainMap.get("virtualDstr")); // 虚拟行员分配
//	                instanceMap.put("pOrgId", metaEchainMap.get("pOrgId"));
//	                instanceMap.put("org",  metaEchainMap.get("org"));
                    instanceMap.put("role", role);
                    instanceMap.put("buss", buss);
//	                instanceMap.put("users", metaEchainMap.get("users"));
                    instanceMap.put("bizSeqNo", instanceId);

                    instanceList.add(instanceMap);
                    ++wfTotalCount;
                }
            }
            // 针对不需要审批的数据，批量删除: 分配关系表、分配区间表数据；批量更新: info表DSTR_STS字段值为已分配
            if (toDeleteKeyAndOrgIdList.size() > 0) {
                int batchSize = 100;
                // 分批次操作
                int index = toDeleteKeyAndOrgIdList.size() / batchSize;
                int remainder = toDeleteKeyAndOrgIdList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchDeleteDistributeTableData(funCode,
                            distributeTableName, periodTableName, pkList.get(0),
                            toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchDeletePeriodTableData(funCode, periodTableName, pkList.get(0),
                            toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    if (!"custDstr".equals(funCode)) {    // 如果不是客户分配，更新业务信息表的分配状态
                        commonPerformanceImpMapper.batchUpdateInfoTableDstrSts(funCode, infoTableName,
                                DistributionConstants.DISTRIBUTED, pkList.get(0),
                                toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                    }
                }
            }
            System.out.println("performance sync c:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
            /**
             * 数据结构说明： Map<Map<String, Object>,List<DstrImpModel>> dataMetaMap
             * 其中 key:Map<String, Object>
             *    【key ：[pkValueStr,effectDate,expirateDate] value:相应的值】
             * value:List<DstrImpModel>:存放分配关系
             * */
            // 4、新增 分配关系历史表、分配关系表数据
            // 审批状态值
            String applySts = DistributionConstants.APPLY_APPROVED; // 默认为通过
            if (needApply) {
                applySts = DistributionConstants.UNDER_APPROVAL;
            }
            // 生成分配区间表、分配关系表字段名list
            Map<String, List<String>> columnMap = this.makePeriodAndDistrColumnNameList(funInfoMap, pkList);
            List<String> periodColumnList = columnMap.get("periodColumnList");
            String insertPeriodColumnStr = commonDistributionService.listToString(periodColumnList);
            List<String> distributeColumnList = columnMap.get("distributeColumnList");
            List<Map<String, Object>> distributeDataList = null;
            StringBuilder tempBuilder = null;
            StringBuilder insertPeriodValue = null;
            // 批量新增 分配关系历史表数据
            List<Map<String, Object>> distributeHisTableDataList = new ArrayList<Map<String, Object>>();
            // 不审批的业务信息-批量新增 分配关系表数据
            List<Map<String, Object>> distributeTableDataList = new ArrayList<Map<String, Object>>();
            // 新增sql参数信息，用于批量新增： 分配区间历史表数据
            List<Map<String, String>> toBatchInsertParamsList = new ArrayList<Map<String, String>>();
            Map<String, String> toBatchInsertParamsMap = null;
            // 不审批的业务数据-sql参数信息，批量操作: 批量更新分配区间历史表-APPLY_VERSION字段值；批量新增-分配区间表数据
            List<Map<String, String>> noApplyParamsList = new ArrayList<Map<String, String>>();
            Map<String, String> noApplyParamsMap = null;
            Set<Map<String, Object>> mapKeySet = dataMetaMap.keySet();
            for (Map<String, Object> mapKey : mapKeySet) {// 第一层循环，处理区间段
                if (mapKey.get("needApply").toString().equals("false")) {
                    needApply = false;
                    applySts = DistributionConstants.APPLY_APPROVED;
                } else {
                    needApply = true;
                    applySts = DistributionConstants.UNDER_APPROVAL;
                }

//	        	needApply = false;	// for test TODO delete
//	        	applySts = DistributionConstants.APPLY_APPROVED;	// for test TODO delete

                StringBuffer pkValueStr = new StringBuffer();// 主键值串，中间以"_"分隔
                StringBuffer pkValueStrPk = new StringBuffer();// 主键值串，中间以"_"分隔
                String effectDate = mapKey.get("effectDate").toString().replaceAll("-", "");// 生效日期
                String expirateDate = mapKey.get("expirateDate").toString().replaceAll("-", "");// 失效日期
                String periodId = UUID.randomUUID().toString().replaceAll("-", "");    // 区间表主键
                for (String pk : pkList) {
                    pkValueStr.append(mapKey.get(pk)).append("_");
                    pkValueStrPk.append(mapKey.get(pk)).append("_");
                }
                if (mapKey.get("needApply").toString().equals("false")) {
                    pkValueStrPk.append("false");
                } else {
                    pkValueStrPk.append("true");
                }
                pkValueStr.deleteCharAt(pkValueStr.length() - 1);
                distributeDataList = dataMetaMap.get(mapKey);// 获取某一区间段的分配关系数据

                // 新增 分配关系历史表数据
//				commonPerformanceImpMapper.batchInsertDistributeHisTableData(distributeHisTableName, periodId, distributeColumnList, distributeDataList);
//				if(!needApply) {	// 如果不需要审批，直接新增 分配关系表数据
//					commonPerformanceImpMapper.batchInsertDistributeTableData(distributeTableName, periodId, distributeColumnList, distributeDataList);
//				}
                for (int i = 0, k = distributeDataList.size(); i < k; ++i) {
                    distributeDataList.get(i).put("PERIOD_ID", periodId);    // 将PERIOD_ID存入distributeDataList中，方便后续批量新增使用
                }
                distributeHisTableDataList.addAll(distributeDataList);
                if (!needApply) {    // 不审批的数据，放入distributeTableDataList表，方便后续批量新增使用
                    distributeTableDataList.addAll(distributeDataList);
                }

                // 5、新增 分配区间历史表、分配区间表数据
                String operateTime = DateUtil.getFullDateNoMils();
                tempBuilder = this.createInsertPeriodValues(operateTime, pkValueStr.toString(), effectDate,
                        expirateDate, periodId, funCode, null, null);
                insertPeriodValue = tempBuilder.deleteCharAt(tempBuilder.length() - 1);

                toBatchInsertParamsMap = new HashMap<String, String>();
                toBatchInsertParamsMap.put("insertPeriodValue", insertPeriodValue.toString());
                toBatchInsertParamsMap.put("applySts", applySts);
                toBatchInsertParamsMap.put("operateTime", operateTime);
                toBatchInsertParamsMap.put("applyId", pkInstanceIdMap.get(pkValueStrPk.toString()));
                toBatchInsertParamsList.add(toBatchInsertParamsMap);
//				// 新增 分配区间历史表数据
//				StringBuilder insertPeriodHisSql = new StringBuilder();
//				insertPeriodHisSql.append("INSERT INTO ");
//				insertPeriodHisSql.append(periodHisTableName);
//				insertPeriodHisSql.append("(");
////				if (!"custDstr".equals(funCode)) {
//					insertPeriodHisSql.append(insertPeriodColumnStr);
////					insertPeriodHisSql.append(",APPLY_STS,APPLY_TIME,APPLY_ID) VALUES(");
//					insertPeriodHisSql.append(",APPLY_STS,APPLY_TIME,APPLY_ID,APPLY_VERSION) VALUES(");
////				} else {
////					insertPeriodHisSql.append(insertPeriodColumnStr);
////					insertPeriodHisSql.append(",ORG_ID,APPLY_STS,APPLY_TIME,APPLY_ID) VALUES(");
////				}
//				insertPeriodHisSql.append(insertPeriodValue).append("");
//				insertPeriodHisSql.append(applySts);
//				insertPeriodHisSql.append("','");
//				insertPeriodHisSql.append(operateTime);
//				insertPeriodHisSql.append("','");
//				insertPeriodHisSql.append(pkInstanceIdMap.get(pkValueStrPk.toString()));
////				insertPeriodHisSql.append("')");
//				insertPeriodHisSql.append("','0')");
//				commonPerformanceImpMapper.executeInsertSql(insertPeriodHisSql.toString());
                // 不需要审批 直接新增 分配区间表数据
                if (!needApply) {
                    noApplyParamsMap = new HashMap<String, String>();
                    noApplyParamsMap.put("applySts", applySts);
                    noApplyParamsMap.put("applyId", pkInstanceIdMap.get(pkValueStrPk.toString()));
                    noApplyParamsMap.put("insertPeriodValue", insertPeriodValue.toString());
                    noApplyParamsList.add(noApplyParamsMap);
//					/** 插入periodHIs表的版本号 */
//					StringBuilder updatePeriodhisVersionSql = new StringBuilder();
//					updatePeriodhisVersionSql.append("UPDATE ");
//					updatePeriodhisVersionSql.append(periodHisTableName);
//					updatePeriodhisVersionSql.append(" SET APPLY_VERSION = '1' ");
//					updatePeriodhisVersionSql.append(" WHERE APPLY_VERSION = '0' AND APPLY_STS = '"+applySts+"' AND APPLY_ID <> '"+pkInstanceIdMap.get(pkValueStrPk.toString())+"'");
//					commonPerformanceImpMapper.executeInsertSql(updatePeriodhisVersionSql.toString());
//					StringBuilder insertPeriodSql = new StringBuilder();
//					insertPeriodSql.append("INSERT INTO ");
//					insertPeriodSql.append(periodTableName);
//					insertPeriodSql.append("(");
////					if (!"custDstr".equals(funCode)) {
//						insertPeriodSql.append(insertPeriodColumnStr);
//						insertPeriodSql.append(") VALUES(");
////					} else {
////						insertPeriodSql.append(insertPeriodColumnStr);
////						insertPeriodSql.append(",org_id) VALUES(");
////					}
//					insertPeriodSql.append(insertPeriodValue.deleteCharAt(insertPeriodValue.length() - 1));
//					insertPeriodSql.append(")");
//					commonPerformanceImpMapper.executeInsertSql(insertPeriodSql.toString());
                }
            }
            // 批量新增-分配关系历史表数据
            if (distributeHisTableDataList.size() > 0) {
                int batchSize = 1000;
                // 分批次操作
                int index = distributeHisTableDataList.size() / batchSize;
                int remainder = distributeHisTableDataList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertDistributeHisTableData(distributeHisTableName, "", distributeColumnList,
                            distributeHisTableDataList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            // 针对不需要审批的数据，批量新增-分配关系表数据
            if (distributeTableDataList.size() > 0) {
                int batchSize = 1000;
                // 分批次操作
                int index = distributeTableDataList.size() / batchSize;
                int remainder = distributeTableDataList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertDistributeTableData(distributeTableName, "", distributeColumnList,
                            distributeTableDataList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            // 批量新增-分配区间历史表数据
            if (toBatchInsertParamsList.size() > 0) {
                int batchSize = 1000;
                // 分批次操作
                int index = toBatchInsertParamsList.size() / batchSize;
                int remainder = toBatchInsertParamsList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertPeriodHisTableData(periodHisTableName, insertPeriodColumnStr,
                            toBatchInsertParamsList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            // 针对不需要审批的数据，批量操作: 批量更新分配区间历史表-APPLY_VERSION字段值；批量新增-分配区间表数据
            if (noApplyParamsList.size() > 0) {
                String currApplySts = noApplyParamsList.get(0).get("applySts");
                int batchSize = 1000;
                // 分批次操作
                int index = noApplyParamsList.size() / batchSize;
                int remainder = noApplyParamsList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchUpdatePeriodHisTableApplyVersion(periodHisTableName, currApplySts,
                            noApplyParamsList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                    commonPerformanceImpMapper.batchInsertPeriodTableData(periodTableName, insertPeriodColumnStr,
                            noApplyParamsList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            distributeHisTableDataList = null;
            distributeTableDataList = null;
            toBatchInsertParamsList = null;
            noApplyParamsList = null;
            System.out.println("performance sync d:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
            log.info("performance instanceList size: " + instanceList.size());
            // 6、根据是否审批，更新批量导入业务主表-执行状态字段数据
            if (instanceList.size() > 0) {
                // 需要审批，设置执行状态字段11正在生成工作流
                pmaFPerformanceBatchInfoMapper.updateStatusByBatchIdAndFunCode(batchId, funCode, "11");
                // 更新 WF_TOTAL_COUNT字段值
                pmaFPerformanceBatchInfoMapper.updateWfTotalCountByBatchIdAndFunCode(batchId, funCode, wfTotalCount + "");
                String workFlow = commonDistributionService.workFlow(funInfoMap);
                // 异步发起审批流， 由于此处调用异步操作时，同步新增phis表数据没有提交，导致数据不一致，需要将异步调用操作放在Resource中执行
//				performanceImpThreadManager.process(funCode, batchId, instanceList, pkList, periodHisTableName, dtlTableName, false,workFlow, null, null);

                // 针对 需要/不需要审批数据同时存在的情况，根据业务主键，删除去重表中数据
                if (toDeleteKeyAndOrgIdList.size() > 0) {
                    // 删除互斥表数据
                    AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");    // 获取  业绩批量导入互斥表表名
                    String mutexTableName = mutexTableInfo.getTableName();    // 互斥表表名
                    int batchSize = 100;
                    // 分批次操作
                    int index = toDeleteKeyAndOrgIdList.size() / batchSize;
                    int remainder = toDeleteKeyAndOrgIdList.size() % batchSize;
                    for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                        commonPerformanceImpMapper.deleteMutexTableDataByKeyColumn(mutexTableName, pkList.get(0),
                                toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                    }
                }

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("funCode", funCode);
                map.put("batchId", batchId);
                map.put("instanceList", instanceList);
                map.put("pkList", pkList);
                map.put("periodHisTableName", periodHisTableName);
                map.put("dtlTableName", dtlTableName);
                map.put("isReStartWf", false);
                map.put("workFlow", workFlow);
                map.put("batchFixedThreadPoolManager", null);
                map.put("userId", null);
                System.out.println("performance sync e:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
                return map;
            } else {
                // 不需要审批，设置执行状态字段20执行完成
                pmaFPerformanceBatchInfoMapper.updateStatusByBatchIdAndFunCode(batchId, funCode, "20");
                // 删除互斥表数据
                AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");    // 获取  业绩批量导入互斥表表名
                String mutexTableName = mutexTableInfo.getTableName();    // 互斥表表名
                commonPerformanceImpMapper.deleteMutexTableData(mutexTableName, batchId);
                System.out.println("performance sync e:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
                return null;
            }
        } catch (Exception e) {
            log.error("performanceImp processWorkFlow error: ", e);
            throw e;
        }
    }

    /**
     * @throws Exception
     * @方法名称: prepareData
     * @方法描述: 执行/发起工作流接口-预处理数据
     * @参数与返回说明:
     * @算法描述: 1、判断是否需要审批，需要审批则初始化工作流参数-dataEchainMap数据
     * 2、针对单区间、多区间分别处理
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Map<Map<String, Object>, List<Map<String, Object>>> prepareData(String funCode, List<Map<String, Object>> dataList, Set<String> dataPkSet,
                                                                           Map<Map<String, Object>, List<Map<String, Object>>> dataMetaMap, String pkColumnName,
                                                                           Map<String, Map<String, Object>> dataEchainMap, Map<String, Object> funInfoMap,
                                                                           String periodTableName, String distributeTableName, boolean needApply) throws Exception {
        Instant startInstant = Instant.now();    // TODO
        System.out.println("b-1:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
        List<String> amtList = commonDistributionService.getDstrAmtKey(funInfoMap);
        // 机构字段配置信息
        Map<String, Object> orgColumnMap = commonDistributionService.getOrgColumnInfo(funInfoMap);
        // 条线字段配置信息
        Map<String, Object> depColumnMap = commonDistributionService.getDepColumnInfo(funInfoMap);
        AdminBaseMetaFunTable tableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
        String dtlTableName = "";
        if (tableInfo != null)
            dtlTableName = tableInfo.getTableName();
        else {
            throw new Exception("业绩批量导入业务明细表名获取失败，请查询对应业务配置");
        }
        System.out.println("b-2:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
        // 1、判断是否需要审批，需要审批则初始化工作流参数-dataEchainMap数据
        if (needApply) {
            Map<String, Object> dataMap = null;
            Map<String, Object> echainParamMap = null;
            StringBuffer pkStr = new StringBuffer();
            for (int i = 0, k = dataList.size(); i < k; ++i) {
                dataMap = dataList.get(i);
//				for (String pk : pkList) {
//					pkStr.append(dataMap.get(pk)).append("_");
//				}
//				pkStr = pkStr.deleteCharAt(pkStr.length() - 1);
                pkStr.append(dataMap.get(pkColumnName));
                echainParamMap = dataEchainMap.get(pkStr.toString());
                if (null == echainParamMap || echainParamMap.isEmpty()) {
                    echainParamMap = new HashMap<String, Object>();
                    echainParamMap.put("interBuss", "false");
                    echainParamMap.put("interOrg", "false");
                    echainParamMap.put("interBranch", "false");
                    echainParamMap.put("virtualDstr", "false");
                    if (!echainParamMap.containsKey("users")) {
                        echainParamMap.put("users", "admin");
                    } else {
                        echainParamMap.put("users", echainParamMap.get("users"));
                    }
                }
                echainParamMap.put("virtualDstr", "true");
                // 客户经理所属机构
//				Map paramMap = new HashMap();
//			    paramMap.put("loginCode", (String) dataMap.get("MANAGER_ID"));
//			    List<Map<String, Object>> userList = adminSmUserMapper.findQueryUserByParam(paramMap);
//				String managerOrgId = userList.get(0).get("orgId") + "";
                // 分配主键（账号）所属机构
                String pkOrgId = this.getOrgAndBussInfo(dtlTableName, pkStr.toString(), pkColumnName, orgColumnMap, depColumnMap).get("orgId");
                echainParamMap.put("org", pkOrgId);
                echainParamMap.put("ORG_ID", dataMap.get("ORG_ID"));
                dataEchainMap.put(pkStr.toString() + "_true", echainParamMap);
                pkStr.delete(0, pkStr.length());
            }
        }
        System.out.println("b-3:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
        /** 区间：1、单区间；2、多区间 */
        String dstrPeriod = commonDistributionService.getPageCfgValue(funInfoMap, "DSTR_PERIOD");
        Map<Map<String, Object>, List<Map<String, Object>>> newDataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
        String effectDate = "";
        Map<String, Object> effectDateMap = new HashMap();
        String ned = String.valueOf(needApply);
        if (!"1".equals(dstrPeriod)) {// 多区间
            Map<String, Object> dataMap = null;
            Map<String, Object> metaKeyMap = null;
            List<Map<String, Object>> distributeList = null;
            StringBuffer pkValueStr = new StringBuffer();
            for (int i = 0, k = dataList.size(); i < k; ++i) {
                dataMap = dataList.get(i);
                metaKeyMap = new HashMap<String, Object>();
//				for (String pk : pkList) {
//					pkValueStr.append(dataMap.get(pk)).append("_");
//					metaKeyMap.put(pk, dataMap.get(pk));
//				}
                pkValueStr.append(dataMap.get(pkColumnName)).append("_");
                metaKeyMap.put(pkColumnName, dataMap.get(pkColumnName));

                //20210512根据总行管理员角色判断不走工作流
                //20210519新加两个角色号不走工作流
                String roleCode = userInfoService.getUserInfo().getRoles().get(0).getCode();
                if ("RC011".equals(roleCode) || "RC010".equals(roleCode) || "RC014".equals(roleCode)) {
                    ned = "false";
                    pkValueStr.append(ned).append("_");
                } else {
                    if (funCode.equals("DepPubDstr") || funCode.equals("ComLoanDstr") || funCode.equals("ComFncDstr")) {
                        BigDecimal amt = new BigDecimal(dataMap.get(amtList.get(0)).toString());
                        BigDecimal amtTwo = new BigDecimal(5000000);
                        if (amt.compareTo(amtTwo) == -1) {
                            ned = "false";
                            pkValueStr.append(ned).append("_");
                        } else {
                            ned = "true";
                            pkValueStr.append(ned).append("_");
                        }
                    } else if (funCode.equals("PerDepDstr") || funCode.equals("PerLoanDstr") || funCode.equals("PerFncDstr")) {
                        BigDecimal amt = new BigDecimal(dataMap.get(amtList.get(0)).toString());
                        BigDecimal amtTwo = new BigDecimal(1000000);
                        if (amt.compareTo(amtTwo) == -1) {
                            ned = "false";
                            pkValueStr.append(ned).append("_");
                        } else {
                            ned = "true";
                            pkValueStr.append(ned).append("_");
                        }
                    } else {
                        pkValueStr.append(ned).append("_");
                    }
                }
                pkValueStr.deleteCharAt(pkValueStr.length() - 1);
                dataPkSet.add(pkValueStr.toString());
                metaKeyMap.put("effectDate", dataMap.get("EFFECT_DATE"));
                metaKeyMap.put("expirateDate", dataMap.get("EXPIRATE_DATE"));
                metaKeyMap.put("needApply", ned);
                distributeList = dataMetaMap.get(metaKeyMap);
                if (null == distributeList) {
                    distributeList = new ArrayList<Map<String, Object>>();
                }
                distributeList.add(dataMap);
                dataMetaMap.put(metaKeyMap, distributeList);
                effectDateMap.put(pkValueStr.toString(), dataMap.get("EFFECT_DATE").toString());
                pkValueStr.delete(0, pkValueStr.length());
            }
            Map<Map<String, Object>, List<Map<String, Object>>> oldDataMetaMap = null;
            Map<String, Object> map = null;
            List<Map<String, Object>> oldDistributeList = null;
            for (String keyValue : dataPkSet) {
                String pkColumnValue = keyValue.split("_")[0];
                String currNeedApply = keyValue.split("_")[1];
                effectDate = effectDateMap.get(keyValue).toString();
                oldDataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
                map = new HashMap<String, Object>();
                Map<String, Object> oldDistributeMap = null;
                Map<String, Object> oldDataMetaMapKey = null;
                List<Map<String, Object>> distributeList1 = null;
                Set<Map<String, Object>> oldDataMetaMapKeySet = null;
//				for (int i = 0; i < pkList.size(); i++) {
//					map.put(pkList.get(i), keyValue.split("_")[i]);
//				}
                map.put(pkColumnName, pkColumnValue);
                // 根据分配主键查询分配区间及分配关系
                oldDistributeList = this.queryDistributeByPk(funInfoMap, map, pkColumnName, periodTableName, distributeTableName);
                for (int i = 0, k = oldDistributeList.size(); i < k; ++i) {
                    oldDistributeMap = oldDistributeList.get(i);
                    oldDataMetaMapKey = new HashMap<String, Object>();
                    oldDataMetaMapKey.put("effectDate", oldDistributeMap.get("EFFECT_DATE"));
                    oldDataMetaMapKey.put("expirateDate", oldDistributeMap.get("EXPIRATE_DATE"));
                    oldDataMetaMapKey.put("needApply", currNeedApply);    // 主键字段个数为1 此处取keyValue中第二个是否审批字段
                    distributeList1 = oldDataMetaMap.get(oldDataMetaMapKey);
                    if (null == distributeList1) {
                        distributeList1 = new ArrayList<Map<String, Object>>();
                    }
                    distributeList1.add(oldDistributeMap);
                    oldDataMetaMap.put(oldDataMetaMapKey, distributeList1);
                }
                Map<String, Object> newMetaMapKey = null;
                if (0 < oldDataMetaMap.size()) {// 有1个以上的区间需要拆分处理
                    oldDataMetaMapKeySet = oldDataMetaMap.keySet();
                    Map<String, Object> newMetaMapKeyTemp = null;
                    for (Map<String, Object> keyMap : oldDataMetaMapKeySet) {
                        String oldEffectDate = (String) keyMap.get("effectDate");
                        String oldExpirateDate = (String) keyMap.get("expirateDate");
                        if (DateUtil.getShortDateTime(effectDate).after(DateUtil.getShortDateTime(oldExpirateDate))) {
                            // 无需拆分，保留原有分配关系
                            newMetaMapKey = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKey.put(pkColumnName, pkColumnValue);
                            newMetaMapKey.put("effectDate", oldEffectDate);
                            newMetaMapKey.put("expirateDate", oldExpirateDate);
                            newMetaMapKey.put("needApply", currNeedApply);
                            newDataMetaMap.put(newMetaMapKey, oldDataMetaMap.get(keyMap));
                        } else if (effectDate.equals(oldEffectDate)) {
                            newMetaMapKey = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKey.put(pkColumnName, pkColumnValue);
                            newMetaMapKey.put("effectDate", oldEffectDate);
                            newMetaMapKey.put("expirateDate", "20991231");
                            newMetaMapKey.put("needApply", currNeedApply);
                            newDataMetaMap.put(newMetaMapKey, dataMetaMap.get(newMetaMapKey));
                        } else {
                            // 拆分的前半段
                            newMetaMapKey = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKey.put(pkColumnName, pkColumnValue);
                            newMetaMapKey.put("effectDate", oldEffectDate);
                            newMetaMapKey.put("expirateDate", DateUtil.getPreviousDateShort(effectDate));
                            newMetaMapKey.put("needApply", currNeedApply);
                            newDataMetaMap.put(newMetaMapKey, oldDataMetaMap.get(keyMap));

                            // 拆分的后半段
                            newMetaMapKeyTemp = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKeyTemp.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKeyTemp.put(pkColumnName, pkColumnValue);
                            newMetaMapKeyTemp.put("effectDate", effectDate);
                            newMetaMapKeyTemp.put("expirateDate", "20991231");
                            newMetaMapKeyTemp.put("needApply", currNeedApply);
                            newDataMetaMap.put(newMetaMapKeyTemp, dataMetaMap.get(newMetaMapKeyTemp));
                        }
                    }
                } else {// 如果只有一个区间则直接以Excel上的新数据为准
                    newMetaMapKey = new HashMap<String, Object>();
//					for (int i = 0; i < pkList.size(); i++) {
//						newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//					}
                    newMetaMapKey.put(pkColumnName, pkColumnValue);
                    newMetaMapKey.put("effectDate", null);
                    newMetaMapKey.put("expirateDate", null);
                    newMetaMapKey.put("needApply", currNeedApply);
                    newDataMetaMap.put(newMetaMapKey, dataMetaMap.get(newMetaMapKey));
                }
            }
            return newDataMetaMap;
        } else {// 单区间
            Map<String, Object> dataMap = null;
            Map<String, Object> metaKeyMap = null;
            List<Map<String, Object>> distributeList = null;
            StringBuffer pkValueStr = new StringBuffer();
            for (int i = 0, k = dataList.size(); i < k; ++i) {
                dataMap = dataList.get(i);
                metaKeyMap = new HashMap<String, Object>();
//				for (String pk : pkList) {
//					pkValueStr.append(dataMap.get(pk)).append("_");
//					metaKeyMap.put(pk, dataMap.get(pk));
//				}
//				pkValueStr.deleteCharAt(pkValueStr.length() - 1);
                pkValueStr.append(dataMap.get(pkColumnName));
                metaKeyMap.put(pkColumnName, dataMap.get(pkColumnName));
                dataPkSet.add(pkValueStr.toString());

                metaKeyMap.put("effectDate", dataMap.get("EFFECT_DATE"));
                metaKeyMap.put("expirateDate", dataMap.get("EXPIRATE_DATE"));
                distributeList = dataMetaMap.get(metaKeyMap);
                if (null == distributeList) {
                    distributeList = new ArrayList<Map<String, Object>>();
                }
                distributeList.add(dataMap);
                dataMetaMap.put(metaKeyMap, distributeList);
                pkValueStr.delete(0, pkValueStr.length());
            }

            // 当前月的上一个月月初
            String periviousMonthFirst = DateUtil.getPeriousMonthFirst();
            for (String keyValue : dataPkSet) {
                Map<Map<String, Object>, List<Map<String, Object>>> oldDataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
                Map<String, Object> map = new HashMap<String, Object>();
//				for (int i = 0; i < pkList.size(); i++) {
//					map.put(pkList.get(i), keyValue.split("_")[i]);
//				}
                map.put(pkColumnName, keyValue.split("_")[0]);
                // 根据分配主键查询分配区间及分配关系
                List<Map<String, Object>> oldDistributeList = this.queryDistributeByPk(funInfoMap, map, pkColumnName, periodTableName, distributeTableName);
                List<Map<String, Object>> distributeList2 = null;
                for (Map<String, Object> oldDistributeMap : oldDistributeList) {// 将同一主键，同一区间段数据存放在一起
                    Map<String, Object> oldDataMetaMapKey = new HashMap<String, Object>();
                    oldDataMetaMapKey.put("effectDate", oldDistributeMap.get("EFFECT_DATE"));
                    oldDataMetaMapKey.put("expirateDate", oldDistributeMap.get("EXPIRATE_DATE"));
                    distributeList2 = oldDataMetaMap.get(oldDataMetaMapKey);
                    if (null == distributeList2) {
                        distributeList2 = new ArrayList<Map<String, Object>>();
                    }
                    distributeList2.add(oldDistributeMap);
                    oldDataMetaMap.put(oldDataMetaMapKey, distributeList2);
                }
                Map<String, Object> newMetaMapKey = null;
                if (0 < oldDataMetaMap.size()) {// 有1个以上的区间需要拆分处理
                    Set<Map<String, Object>> oldDataMetaMapKeySet = oldDataMetaMap.keySet();
                    Map<String, Object> newMetaMapKeyTemp = null;
                    for (Map<String, Object> keyMap : oldDataMetaMapKeySet) {
                        String oldEffectDate = (String) keyMap.get("effectDate");
                        String oldExpirateDate = (String) keyMap.get("expirateDate");
                        if (DateUtil.getShortDate(periviousMonthFirst).after(DateUtil.getShortDate(oldExpirateDate))) {
                            // 无需拆分，保留原有分配关系
                            newMetaMapKey = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKey.put(pkColumnName, keyValue.split("_")[0]);
                            newMetaMapKey.put("effectDate", oldEffectDate);
                            newMetaMapKey.put("expirateDate", oldExpirateDate);
                            newDataMetaMap.put(newMetaMapKey, oldDataMetaMap.get(keyMap));
                        } else if (periviousMonthFirst.equals(oldEffectDate)) {
                            newMetaMapKey = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKey.put(pkColumnName, keyValue.split("_")[0]);
                            newMetaMapKey.put("effectDate", oldEffectDate);
                            newMetaMapKey.put("expirateDate", "20991231");
                            newDataMetaMap.put(newMetaMapKey, dataMetaMap.get(newMetaMapKey));
                        } else {
                            // 拆分的前半段
                            newMetaMapKey = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKey.put(pkColumnName, keyValue.split("_")[0]);
                            newMetaMapKey.put("effectDate", oldEffectDate);
                            newMetaMapKey.put("expirateDate", DateUtil.getPreviousDate(periviousMonthFirst));
                            newDataMetaMap.put(newMetaMapKey, oldDataMetaMap.get(keyMap));

                            // 拆分的后半段
                            newMetaMapKeyTemp = new HashMap<String, Object>();
//							for (int i = 0; i < pkList.size(); i++) {
//								newMetaMapKeyTemp.put(pkList.get(i), keyValue.split("_")[i]);
//							}
                            newMetaMapKeyTemp.put(pkColumnName, keyValue.split("_")[0]);
                            newMetaMapKeyTemp.put("effectDate", periviousMonthFirst);
                            newMetaMapKeyTemp.put("expirateDate", "20991231");
                            newDataMetaMap.put(newMetaMapKeyTemp, dataMetaMap.get(newMetaMapKeyTemp));
                        }
                    }
                } else {// 如果只有一个区间则直接以Excel上的新数据为准
                    newMetaMapKey = new HashMap<String, Object>();
//					for (int i = 0; i < pkList.size(); i++) {
//						newMetaMapKey.put(pkList.get(i), keyValue.split("_")[i]);
//					}
                    newMetaMapKey.put(pkColumnName, keyValue.split("_")[0]);
                    newMetaMapKey.put("effectDate", null);
                    newMetaMapKey.put("expirateDate", null);
                    newDataMetaMap.put(newMetaMapKey, dataMetaMap.get(newMetaMapKey));
                }
            }
        }
        System.out.println("b-4:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
        return newDataMetaMap;
    }

    /**
     * @throws Exception
     * @方法名称: getOrgAndBussInfo
     * @方法描述: 根据分配主键获取所属机构和条线
     * @参数与返回说明:
     * @算法描述:
     */
    public Map<String, String> getOrgAndBussInfo(String dtlTableName, String pkStr, String pkColumnName,
                                                 Map<String, Object> orgColumnMap, Map<String, Object> depColumnMap) throws Exception {
        Map<String, String> retMap = new HashMap<String, String>();
        if (null == orgColumnMap) {
            throw new Exception("未配置机构字段");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT ").append(orgColumnMap.get("columnName"));
        sql.append(depColumnMap == null ? "" : "," + depColumnMap.get("columnName"));
        sql.append(" FROM ").append(dtlTableName).append(" WHERE 1=1 ");
//		for (int i = 0; i < pkList.size(); i++) {
//			sql.append(" AND ").append(pkList.get(i)).append("='");
//			sql.append(pkStr.split("_")[i]).append("' ");
//		}
        sql.append(" and ").append(pkColumnName).append("='").append(pkStr).append("' ");
        List<Map<String, Object>> resultList = commonPerformanceImpMapper.executeQuerySql(sql.toString());
        if (resultList == null || resultList.size() == 0 || resultList.get(0) == null) {
            throw new Exception("分配主键相关机构和条线信息不正确");
        } else {
            resultList = mapKeyToUnderline(resultList);
            retMap.put("orgId", (String) resultList.get(0).get(orgColumnMap.get("columnName")));
            if (depColumnMap != null) {
                retMap.put("bussNo", (String) resultList.get(0).get(depColumnMap.get("columnName")));
            }
        }
        return retMap;
    }

    /**
     * @方法名称: getBussbyUserId
     * @方法描述: 根据loginCode 获取用户所属条线
     * @参数与返回说明: 本期暂不考虑条线问题
     * @算法描述:
     */
    public String getBussbyLoginCode(String loginCode) {
        return "";
    }

    /**
     * @方法名称: queryDistributeByPk
     * @方法描述: 获取原有所有分配关系
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> queryDistributeByPk(Map<String, Object> funInfoMap, Map<String, Object> pkMap, String pkColumnName,
                                                         String periodTableName, String distributeTableName) {

        StringBuffer sql = new StringBuffer();
        List<String> distributeColumnList = new ArrayList<String>();
        distributeColumnList.addAll(DistributionConstants.DISTRIBUTE_COLUMN_LIST);
        // 分配类型:1,比例分配; 2,比例+定额分配
        String dstrType = (String) (((Map<String, Object>) funInfoMap.get("pageCfgInfo")).get("DSTR_TYPE"));
        if ("1".equals(dstrType)) {// 比例分配
            distributeColumnList.remove("START_AMT");
            distributeColumnList.remove("END_AMT");
        }
        /** 是否配置绩效比例 */
        boolean showPerfRateCfg = ("1".equals(commonDistributionService.getPageCfgValue(funInfoMap, "HAS_JXBL"))) ? true : false;
        if (!showPerfRateCfg) {
            distributeColumnList.remove("PERF_RATE");
        }
        if (!DistributionConstants.YES.equals(commonDistributionService.getPageCfgValue(funInfoMap, "HOST_CFG"))) {
            distributeColumnList.remove("HOST_CFG");
        }
        String insertDistributeColumn = commonDistributionService.listToString(distributeColumnList);
//		sql.append(" SELECT distinct P.EFFECT_DATE,P.EXPIRATE_DATE, P.");	// 20211014增加 D.ID查询项，如果同客户经理分配比例相同的情况存在多条分配关系，防止去重后查询不出来的情况
        sql.append(" SELECT distinct P.EFFECT_DATE,P.EXPIRATE_DATE, D.ID AS DISTR_ID, P.");
        sql.append(insertDistributeColumn).append(",");
//		for (String pk : pkList) {
//			sql.append(pk).append(",");
//		}
        sql.append(pkColumnName);
//		sql.deleteCharAt(sql.length() - 1);
        sql.append(" FROM ").append(periodTableName);
        sql.append(" P INNER JOIN ");
        sql.append(distributeTableName);
        sql.append(" D ON P.ID = D.PERIOD_ID WHERE 1=1 ");
        Set<String> set = pkMap.keySet();
        for (String pk : set) {
            sql.append(" AND P.").append(pk).append("='");
            sql.append(pkMap.get(pk)).append("' ");
        }
        sql.append(" ORDER BY P.EFFECT_DATE ASC ");
        // 获取原有分配关系
        List<Map<String, Object>> distributeList = commonPerformanceImpMapper.executeQuerySql(sql.toString());
        distributeList = mapKeyToUnderline(distributeList);
        List<Map<String, Object>> retDstrImpVoList = new ArrayList<Map<String, Object>>();
        if (null != distributeList && 0 < distributeList.size()) {
            for (int i = 0; i < distributeList.size(); i++) {
                retDstrImpVoList.add(distributeList.get(i));
            }
        }
        return retDstrImpVoList;
    }

    /**
     * @方法名称: makePeriodAndDistrColumnNameList
     * @方法描述: 生成 分配区间表、分配关系表 字段名list
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings("unchecked")
    public Map<String, List<String>> makePeriodAndDistrColumnNameList(Map<String, Object> funInfoMap, List<String> pkList) {
        Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
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
        }
        if (!DistributionConstants.YES.equals(pageCfgMap.get("HOST_CFG"))) {
            distributeColumnList.remove(distributeColumnList.indexOf("HOST_CFG"));
        }
        resultMap.put("periodColumnList", periodColumnList);
        resultMap.put("distributeColumnList", distributeColumnList);
        return resultMap;
    }

    /**
     * @方法名称: createInsertPeriodValues
     * @方法描述: 生成 分配区间表 新增数据sql中值部分
     * @参数与返回说明:
     * @算法描述:
     */
    private StringBuilder createInsertPeriodValues(String operateTime, String pkValueStr, String effectDate,
                                                   String expirateDate, String id, String funCode, String userId, String grantOrgCode) {
        // 插入period表的值
        StringBuilder insertPeriodValue = new StringBuilder();
        insertPeriodValue.append("'").append(effectDate).append("',");
        insertPeriodValue.append("'").append(expirateDate).append("',");
        insertPeriodValue.append("'").append(operateTime).append("',");
        insertPeriodValue.append("'").append(grantOrgCode == null ? userInfoService.getGrantOrgCode() : grantOrgCode).append("',");
        insertPeriodValue.append("'").append(userId == null ? userInfoService.getUserInfo().getLoginCode() : userId).append("',");
        insertPeriodValue.append("'").append(DATA_SRC.IMPORT.toString()).append("',");
        // 逻辑主键（区间ID）
        insertPeriodValue.append("'" + id).append("',");
        for (int i = 0; i < pkValueStr.split("_").length; i++) {
            insertPeriodValue.append("'").append(pkValueStr.split("_")[i]).append("',");
        }
        return insertPeriodValue;
    }

    /**
     * @方法名称: reInitWorkFlow
     * @方法描述: 重新发起工作流接口
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void reInitWorkFlow(String batchId, String funCode) throws Exception {
        try {
            // 获取功能信息缓存
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
            // 获取分配主键list
            List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
//			if("custDstr".equals(funCode)) {	// 客户分配  增加 客户归属机构 字段
//				pkList.add("OPER_ORG_ID");
//			}
            AdminBaseMetaFunTable tableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
            String dtlTableName = "";
            if (tableInfo != null)
                dtlTableName = tableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入业务明细表名获取失败，请查询对应业务配置");
            }
            Map<String, String> periodHisTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
            String periodHisTableName = periodHisTableInfo.get("tableName");    // 分配区间历史表表名

            List<Map<String, String>> errApplyIdOrgIdList = commonPerformanceImpMapper.queryApplyIdAndOrgIdFromPeriodHisWorkFlowErr(batchId, dtlTableName, periodHisTableName, pkList);
            StringBuffer pkColumnNames = new StringBuffer();
            for (String pk : pkList) {
                pkColumnNames.append(pk).append("&");
            }
            pkColumnNames.deleteCharAt(pkColumnNames.length() - 1);

            Map<String, Object> paramMap = new HashMap<String, Object>(); // 流程参数
            paramMap.put("funCode", funCode);//业务功能编码
            List<Map<String, Object>> instanceList = new ArrayList<Map<String, Object>>();
            for (Map<String, String> item : errApplyIdOrgIdList) {
                // 保存流程信息,待发起
                Map<String, Object> instanceMap = new HashMap<String, Object>();
                instanceMap.put("applyId", item.get("applyId"));    // 审批编号
                instanceMap.put("pkColumnNames", pkColumnNames);    // 业务主键字段名（多个&分隔）
                paramMap.put("orgId", item.get("orgId"));    // 工作流 自定义参数  业绩归属机构
                paramMap.put("bizSeqNo", item.get("applyId"));
                instanceMap.put("paramMap", paramMap);

                // modify at 2020/10/22
                instanceMap.put("orgId", item.get("orgId"));    // 工作流 自定义参数  业绩归属机构

                instanceList.add(instanceMap);
            }
            // 异步发起审批流
            String workFlow = commonDistributionService.workFlow(funInfoMap);
            performanceImpThreadManager.process(funCode, batchId, instanceList, pkList, periodHisTableName, dtlTableName, true, workFlow, null, null);
        } catch (Exception e) {
            log.error("performanceImp reInitWorkFlow error: ", e);
            throw e;
        }
    }

    /**
     * @方法名称: distinctListByPk
     * @方法描述: 根据主键过滤dataList，在插入互斥表、插入明细表(针对虚拟行员分配情况)时使用
     * @参数与返回说明:
     * @算法描述:
     */
    public Map<String, Object> distinctListByPk(List<Map<String, Object>> srcList, List<String> pkList) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        List<Map<String, Object>> destList = new ArrayList<Map<String, Object>>();
        Map<String, Double> distrRateMap = new HashMap<String, Double>();    // distrRateMap分配比例合计值， KEY:主键值$分割， VALUE:分配比例合计
        Map<String, String> pkMap = new HashMap<String, String>();
        for (Map<String, Object> map : srcList) {
            Boolean isRepeat = true;
            String pkValue = "";
            for (String pk : pkList) {    // 由于可能存在的多主键形式，所以此处只有所有主键值都重复，isRepeat才是true
                if (pkMap.get(pk) == null || pkMap.get(pk).indexOf(map.get(pk) + "") < 0) {    // 主键不重复，将主键放入pkMap中
                    pkMap.put(pk, pkMap.get(pk) == null ? map.get(pk) + "$" : pkMap.get(pk) + map.get(pk) + "$");
                    isRepeat = false;
                } else if (isRepeat && pkMap.get(pk).indexOf(map.get(pk) + "") >= 0) {    // 主键重复，repeatCount+1
                    isRepeat = true;
                }
                pkValue += map.get(pk) + "$";
            }
            if (!isRepeat) {    // 不重复，则放入destList
                destList.add(map);
            }
            distrRateMap.put(pkValue,
                    distrRateMap.get(pkValue) == null ? Double.parseDouble(map.get("DISTR_RATE") + "") : distrRateMap.get(pkValue) + Double.parseDouble(map.get("DISTR_RATE") + ""));
        }
        retMap.put("destList", destList);    // 去除srcList中主键值重复的数据，插入互斥表时使用
        retMap.put("distrRateMap", distrRateMap);    // srcList中分配比例合计数据，插入明细表(针对虚拟行员分配情况)时使用
        return retMap;
    }

    public Integer flushprogress(String exportId) {
        StringRedisTemplate stringRedisTemplate = SpringContextUtil.getBean("stringRedisTemplate");
        int process = Integer.parseInt(stringRedisTemplate.opsForValue().get("EXCEL_EXPORTID_" + exportId));
        return process;
    }

    @Async("excelSyncTaskPool")
    public void exportTempleteAsync(String fileName, String funCode, String funName, String excelHeader,
                                    String searchParams, String dataAuth, String dataBussAuth, String grantOrgCode) {
        log.debug("【批量导出】异步生成EXCEL模板开始...");
        long startTime = System.currentTimeMillis();
        try {
            JSONArray excelHeaderArray = JSONArray.parseArray(excelHeader);
            Map<String, Object> searchParamsMap = (Map<String, Object>) JSONArray.parse(searchParams);
            /** 获取功能信息缓存 */
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
            long startTime1 = System.currentTimeMillis();
            log.debug("【批量导出】拼接SQL开始...");
            StringBuffer sql = new StringBuffer().append(this.builderQuerySqlNew(funInfoMap, dataAuth, dataBussAuth, grantOrgCode));
            long endTime1 = System.currentTimeMillis();
            log.debug("【批量导出】拼接SQL结束,耗时{}秒", (endTime1 - startTime1) / 1000);
            sql.insert(0, "SELECT  * FROM (");
            sql.append(") X WHERE 1=1 ");

            /** 配置查询条件 */
            Set<Map<String, Object>> searchFieldSet = this.getSearchFieldSet(funInfoMap);
            Object chm = null;
            Object dspan = null;
            Object dmoney = null;
            Object donly = null;
            Object cm = null;
            // 查询条件细分
            for (Map<String, Object> map : searchFieldSet) {
                chm = map.get("columnHiddenName");
                dspan = map.get("dateSpan");
                donly = map.get("dateOnly");
                dmoney = map.get("moneySpan");
                cm = map.get("columnName");
                if (chm != null && !StringUtils.isEmpty(searchParamsMap.get(chm) + "")) {
                    if ((map.get("subOrgQuery") != null) && (DistributionConstants.YES.equals(map.get("subOrgQuery")))) {
                        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                            //机构下辖
                            sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X.ACCT_ORG_ID");
                            sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
                            sql.append(searchParamsMap.get(chm)).append(")($|,)') )");
                        } else {
                            //机构下辖
                            sql.append(" AND EXISTS (SELECT 1 FROM SYS_ORG_VIEW C WHERE X." + map.get("columnName").toString());
                            sql.append("=C.ORG_ID AND REGEXP_LIKE (C.ORG_SEQ,'(^|,)(");
                            sql.append(searchParamsMap.get(chm)).append(")($|,)') )");
                        }

                    } else {
                        if (funCode.equals("ComCustDstr") || funCode.equals("PerCustDstr")) {
                            sql.append(" AND X.ACCT_ORG_ID");
                            if ("like".equals(map.get("compareChar")))
                                sql.append(" LIKE '%").append(searchParamsMap.get(chm)).append("%' ");
                            else
                                sql.append(" = '").append(searchParamsMap.get(chm)).append("' ");
                        } else {
                            sql.append(" AND X.").append(cm);
                            if ("like".equals(map.get("compareChar")))
                                sql.append(" LIKE '%").append(searchParamsMap.get(chm)).append("%' ");
                            else
                                sql.append(" = '").append(searchParamsMap.get(chm)).append("' ");
                        }

                    }
                } else if (dspan != null) {
                    if (null != searchParamsMap.get(dspan + "1") && !"".equals(searchParamsMap.get(dspan + "1"))) {
                        sql.append(" AND TO_DATE(X.");
                        sql.append(cm + ",'yyyy-mm-dd') >=");
                        sql.append("TO_DATE('" + searchParamsMap.get(dspan + "1") + "','yyyy-mm-dd') ");
                    }
                    if (null != searchParamsMap.get(dspan + "2") && !"".equals(searchParamsMap.get(dspan + "2"))) {
                        sql.append(" AND TO_DATE(X.");
                        sql.append(cm + ",'yyyy-mm-dd') <=");
                        sql.append("TO_DATE('" + searchParamsMap.get(dspan + "2") + "','yyyy-mm-dd') ");
                    }
                } else if (dmoney != null) {
                    if (null != searchParamsMap.get(dmoney + "1") && !"".equals(searchParamsMap.get(dmoney + "1"))) {
                        sql.append(" AND TO_NUMBER(X.");
                        sql.append(cm + ") >=");
                        sql.append("TO_NUMBER('" + searchParamsMap.get(dmoney + "1") + "') ");
                    }
                    if (null != searchParamsMap.get(dmoney + "2") && !"".equals(searchParamsMap.get(dmoney + "2"))) {
                        sql.append(" AND TO_NUMBER(X.");
                        sql.append(cm + ") <=");
                        sql.append("TO_NUMBER('" + searchParamsMap.get(dmoney + "2") + "') ");
                    }
                } else if (donly != null) {
                    if (null != searchParamsMap.get(donly + "") && !"".equals(searchParamsMap.get(donly + ""))) {
                        sql.append(" AND TO_DATE(X.");
                        sql.append(cm + ",'yyyy-mm-dd') =");
                        sql.append("TO_DATE('" + searchParamsMap.get(dspan + "") + "','yyyy-mm-dd') ");
                    }
                } else if (null != searchParamsMap.get(cm) && !"".equals(searchParamsMap.get(cm))) {
                    sql.append(" AND X.").append(cm);
                    if ("like".equals(map.get("compareChar"))) {
                        sql.append(" like '%");
                        sql.append(searchParamsMap.get(cm));
                        sql.append("%' ");
                    } else {
                        sql.append(" = '");
                        sql.append(searchParamsMap.get(cm));
                        sql.append("' ");
                    }
                }
            }
            updateProcess(fileName, "5");
            long startTime2 = System.currentTimeMillis();
            log.debug("【批量导出】创建EXCEL开始...");
            this.createExcel(fileName, excelHeaderArray, sql.toString(), funName, false);
            long endTime2 = System.currentTimeMillis();
            log.debug("【批量导出】创建EXCEL结束,耗时{}秒", (endTime2 - startTime2) / 1000);
            delayDelProcess(fileName, "100");
            long endTime = System.currentTimeMillis();
            log.debug("【批量导出】异步生成EXCEL模板结束,耗时{}秒", (endTime - startTime) / 1000);
        } catch (Exception e) {
            delayDelProcess(fileName, "");
            log.error("performanceImp exportTemplete error: ", e);
            throw new YuspException("500", "业绩批量导入功能,导出模板异常");
        }

    }

    public void updateProcess(String exportId, String process) {
        StringRedisTemplate stringRedisTemplate = SpringContextUtil.getBean("stringRedisTemplate");
        stringRedisTemplate.opsForValue().set("EXCEL_EXPORTID_" + exportId, process);
    }

    public void delayDelProcess(String exportId, String process) {
        StringRedisTemplate stringRedisTemplate = SpringContextUtil.getBean("stringRedisTemplate");
        stringRedisTemplate.opsForValue().set("EXCEL_EXPORTID_" + exportId, process, 30, TimeUnit.SECONDS);
    }

    /**
     * @方法名称: asynProcessWorkFlow
     * @方法描述: 异步-执行/发起工作流接口
     * @参数与返回说明:
     * @算法描述: 1、准备必要参数数据
     * 2、调用 预处理数据接口
     * 3、删除 原分配关系表、分配区间表数据，更新信息表DSTR_STS审批状态字段值；生成 审批流 扩展参数数据
     * 4、新增 分配关系历史表、分配关系表数据
     * 5、新增 分配区间历史表、分配区间表数据
     * 6、根据是否审批，更新批量导入业务主表-执行状态字段数据
     * 7、发起审批流
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void asynProcessWorkFlow(PmaFperformanceTobatchInf batchInf, BatchFixedThreadPoolManager batchFixedThreadPoolManager) throws Exception {
        try {
            Instant startInstant = Instant.now();    // TODO
            String batchId = batchInf.getBatchId();
            String funCode = batchInf.getFunCode();
            String userId = batchInf.getUserId();
            String role = batchInf.getRole();
            String unitLevel = batchInf.getUnitLevel();
            String unitId = batchInf.getUnitId();
            String grantOrgCode = batchInf.getGrantOrgCode();
            String buss = batchInf.getBuss();
            // 1、准备必要参数数据
            // 获取功能信息缓存
            Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
            // 获取分配主键list
            List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
            String pkColumnNames = pkList.get(0);    // 主键字段名

            AdminBaseMetaFunTable tableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "06");    // 获取  业绩批量导入业务明细表 表名
            String dtlTableName = "";
            if (tableInfo != null)
                dtlTableName = tableInfo.getTableName();
            else {
                throw new Exception("业绩批量导入业务明细表名获取失败，请查询对应业务配置");
            }
            String dtlQuerySql = "select * from " + dtlTableName + " where BATCH_ID = '" + batchId + "'";
            List<Map<String, Object>> dtlDataList = commonPerformanceImpMapper.executeQuerySql(dtlQuerySql);    // 获取 批量导入明细表 数据
            dtlDataList = mapKeyToUnderline(dtlDataList);

            System.out.println("performance asyn a:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO

            Map<String, String> infoTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
            String infoTableName = infoTableInfo.get("tableName");    // 信息表表名
            Map<String, String> periodTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
            String periodTableName = periodTableInfo.get("tableName");    // 分配区间表表名
            Map<String, String> distributeTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
            String distributeTableName = distributeTableInfo.get("tableName");    // 分配关系表表名
            Map<String, String> periodHisTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
            String periodHisTableName = periodHisTableInfo.get("tableName");    // 分配区间历史表表名
            Map<String, String> distributeHisTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE_HIS);
            String distributeHisTableName = distributeHisTableInfo.get("tableName");    // 分配关系历史表表名

            boolean needApply = commonDistributionService.needApply(funInfoMap);    // 是否需要审批
            Set<String> dataPkSet = new HashSet<String>();
            Map<Map<String, Object>, List<Map<String, Object>>> dataMetaMap = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
            // 工作流相关参数
            Map<String, Map<String, Object>> dataEchainMap = new HashMap<String, Map<String, Object>>();
            // 2、调用 预处理数据接口
            dataMetaMap = this.prepareData(funCode, dtlDataList, dataPkSet, dataMetaMap, pkColumnNames, dataEchainMap, funInfoMap,
                    periodTableName, distributeTableName, needApply);

            System.out.println("performance asyn b:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
//	        StringBuffer pkColumnNames = new StringBuffer();
//			for (String pk : pkList) {
//				pkColumnNames.append(pk).append("&");
//			}
//			pkColumnNames.deleteCharAt(pkColumnNames.length() - 1);
            // 存放每个分配主键对应的工作流ID
            Map<String, String> pkInstanceIdMap = new HashMap<String, String>();
            List<Map<String, Object>> instanceList = new ArrayList<Map<String, Object>>();
            Integer wfTotalCount = 0;    // 待发起的工作流总数

            // 根据分配主键（账号）获取其工作流相关参数
            Map<String, Object> metaEchainMap = null;
            // 生成审批流参数map
            String instanceId = null;
            Integer executingBactchCount = pmaFPerformanceBatchInfoMapper.getExecuteBatchCount();    // 查询执行状态为11正在生成工作流的批次数量
            Map<String, Object> instanceMap = null;
            Map<String, Object> paramMap = null;
            // 不需要审批的 主键、业务归属机构 list，用于后续统一批量删除: 分配关系表、分配区间表数据；批量更新: info表DSTR_STS字段值为已分配
            List<Map<String, String>> toDeleteKeyAndOrgIdList = new ArrayList<Map<String, String>>();
            Map<String, String> toDeleteKeyAndOrgIdMap = null;
            // 3、删除 原分配关系表、分配区间表数据，更新信息表DSTR_STS审批状态字段值；生成 审批流 扩展参数数据
            for (String key : dataPkSet) {
                if (key.split("_")[pkList.size()].equals("false")) {
                    needApply = false;
                } else {
                    needApply = true;
                }
//	        	needApply = false;	// for test TODO delete
                // *** 如果需要审批，此处限制-正在生成工作流-的批次数据个数
//	        	if(needApply) {
//	        		if(executingBactchCount >= synExecuteMaxSize) {
//	        			throw new Exception("over syn-execute-max-size");
//	        		}
//	        	}
                if (!needApply) {    // 不需要审批
                    // 临时存储-不需要审批的 主键、业务归属机构数据
                    toDeleteKeyAndOrgIdMap = new HashMap<String, String>();
                    toDeleteKeyAndOrgIdMap.put("pkValue", key.split("_")[0]);
                    if ("ComCustDstr".equals(funCode) || "PerCustDstr".equals(funCode)) {
                        // 根据分配主键（账号）获取其工作流相关参数
                        metaEchainMap = dataEchainMap.get(key);
                        toDeleteKeyAndOrgIdMap.put("orgId", metaEchainMap.get("ORG_ID") + "");
                    }
                    toDeleteKeyAndOrgIdList.add(toDeleteKeyAndOrgIdMap);
//	        		// 删除关系生效表
//	                StringBuilder deleteDistributeSql = new StringBuilder();
//	                deleteDistributeSql.append("DELETE FROM ");
//	                deleteDistributeSql.append(distributeTableName);
//	                deleteDistributeSql.append(" A WHERE EXISTS (SELECT 1 FROM ");
//	                deleteDistributeSql.append(periodTableName);
//	                deleteDistributeSql.append(" B WHERE A.PERIOD_ID=B.ID ");
//					for (int i = 0; i < pkList.size(); i++) {
//						if (pkList.get(i).equals("OPER_ORG_ID")) {
//							deleteDistributeSql.append("AND B.Org_Id");
//							deleteDistributeSql.append(" ='").append(key.split("_")[i]).append("' ");
//						} else {
//							deleteDistributeSql.append("AND B.").append(pkList.get(i));
//							deleteDistributeSql.append(" ='").append(key.split("_")[i]).append("' ");
//						}
//					}
//					deleteDistributeSql.append(")");
//					commonPerformanceImpMapper.executeDeleteSql(deleteDistributeSql.toString());
//
//					// 删除区间生效表
//	                StringBuilder deletePeriodSql = new StringBuilder();
//	                deletePeriodSql.append("DELETE FROM ");
//	                deletePeriodSql.append(periodTableName);
//	                deletePeriodSql.append(" A WHERE 1=1 ");
//					for (int i = 0; i < pkList.size(); i++) {
//						if (pkList.get(i).equals("OPER_ORG_ID")) {
//							deletePeriodSql.append("AND A.ORG_ID");
//							deletePeriodSql.append(" ='").append(key.split("_")[i]).append("' ");
//						} else {
//							deletePeriodSql.append("AND A.").append(pkList.get(i));
//							deletePeriodSql.append(" ='").append(key.split("_")[i]).append("' ");
//						}
//					}
//					commonPerformanceImpMapper.executeDeleteSql(deletePeriodSql.toString());
//
//					if (!"custDstr".equals(funCode)) {	// 如果不是客户分配，更新业务信息表的分配状态
//						StringBuilder updateInfo = new StringBuilder();
//						updateInfo.append("UPDATE ");
//						updateInfo.append(infoTableName);
//						updateInfo.append(" SET DSTR_STS = '");
//						updateInfo.append(DistributionConstants.DISTRIBUTED);
//						updateInfo.append("' WHERE 1=1 ");
//						for (int i = 0; i < pkList.size(); i++) {
//							updateInfo.append(" AND ").append(pkList.get(i));
//							updateInfo.append(" ='").append(key.split("_")[i]).append("' ");
//						}
//						// 分区表-ETL_DATE处理
//						if(!"ComCustDstr".equals(funCode) && !"PerCustDstr".equals(funCode)) {
//							updateInfo.append(" and etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA') ");
//						}
//						commonPerformanceImpMapper.executeUpdateSql(updateInfo.toString());
//					}
                } else {    // 需要审批，生成流程参数
                    // 根据分配主键（账号）获取其工作流相关参数
                    metaEchainMap = dataEchainMap.get(key);

                    // 生成审批流参数map
                    instanceId = UUID.randomUUID().toString().replaceAll("-", "");
                    pkInstanceIdMap.put(key, instanceId);

                    paramMap = new HashMap<String, Object>(); // 流程参数
                    paramMap.put("funCode", funCode);//业务功能编码
                    paramMap.put("unitlevel", unitLevel); // 机构层级
                    paramMap.put("unitid", unitId); // 机构号
                    paramMap.put("interBuss", metaEchainMap.get("interBuss")); // 跨条线
                    paramMap.put("interOrg", metaEchainMap.get("interOrg")); // 跨机构
                    paramMap.put("interBranch", metaEchainMap.get("interBranch")); // 是否跨分行
                    paramMap.put("virtualDstr", metaEchainMap.get("virtualDstr")); // 虚拟行员分配
//	                paramMap.put("pOrgId", metaEchainMap.get("pOrgId"));
//	                paramMap.put("org",  metaEchainMap.get("org"));
                    paramMap.put("role", role);
                    paramMap.put("buss", buss);
//	                paramMap.put("users", metaEchainMap.get("users"));
                    paramMap.put("bizSeqNo", instanceId);

                    // 保存流程信息,待发起
                    instanceMap = new HashMap<String, Object>();
                    instanceMap.put("applyId", instanceId);    // 审批编号
                    instanceMap.put("pkColumnValues", key);    // 业务主键值（多个_分隔）
                    instanceMap.put("pkColumnNames", pkColumnNames);    // 业务主键字段名（多个&分隔）
//	                instanceMap.put("operateTime", DateUtil.getFullDateNoMils());
                    paramMap.put("orgId", metaEchainMap.get("ORG_ID"));    // 工作流自定义参数  业绩归属机构
                    instanceMap.put("paramMap", paramMap);

                    // modify at 2020/10/22
                    instanceMap.put("funCode", funCode);//业务功能编码
                    instanceMap.put("unitlevel", unitLevel); // 机构层级
                    instanceMap.put("unitid", unitId); // 机构号
                    instanceMap.put("interBuss", metaEchainMap.get("interBuss")); // 跨条线
                    instanceMap.put("interOrg", metaEchainMap.get("interOrg")); // 跨机构
                    instanceMap.put("interBranch", metaEchainMap.get("interBranch")); // 是否跨分行
                    instanceMap.put("virtualDstr", metaEchainMap.get("virtualDstr")); // 虚拟行员分配
//	                instanceMap.put("pOrgId", metaEchainMap.get("pOrgId"));
//	                instanceMap.put("org",  metaEchainMap.get("org"));
                    instanceMap.put("role", role);
                    instanceMap.put("buss", buss);
//	                instanceMap.put("users", metaEchainMap.get("users"));
                    instanceMap.put("bizSeqNo", instanceId);

                    instanceList.add(instanceMap);
                    ++wfTotalCount;
                }
            }
            // 针对不需要审批的数据，批量删除: 分配关系表、分配区间表数据；批量更新: info表DSTR_STS字段值为已分配
            if (toDeleteKeyAndOrgIdList.size() > 0) {
                int batchSize = 100;
                // 分批次操作
                int index = toDeleteKeyAndOrgIdList.size() / batchSize;
                int remainder = toDeleteKeyAndOrgIdList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchDeleteDistributeTableData(funCode,
                            distributeTableName, periodTableName, pkList.get(0),
                            toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchDeletePeriodTableData(funCode, periodTableName, pkList.get(0),
                            toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    if (!"custDstr".equals(funCode)) {    // 如果不是客户分配，更新业务信息表的分配状态
                        commonPerformanceImpMapper.batchUpdateInfoTableDstrSts(funCode, infoTableName,
                                DistributionConstants.DISTRIBUTED, pkList.get(0),
                                toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                    }
                }
            }
            System.out.println("performance asyn c:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
            /**
             * 数据结构说明： Map<Map<String, Object>,List<DstrImpModel>> dataMetaMap
             * 其中 key:Map<String, Object>
             *    【key ：[pkValueStr,effectDate,expirateDate] value:相应的值】
             * value:List<DstrImpModel>:存放分配关系
             * */
            // 4、新增 分配关系历史表、分配关系表数据
            // 审批状态值
            String applySts = DistributionConstants.APPLY_APPROVED; // 默认为通过
            if (needApply) {
                applySts = DistributionConstants.UNDER_APPROVAL;
            }
            // 生成分配区间表、分配关系表字段名list
            Map<String, List<String>> columnMap = this.makePeriodAndDistrColumnNameList(funInfoMap, pkList);
            List<String> periodColumnList = columnMap.get("periodColumnList");
            String insertPeriodColumnStr = commonDistributionService.listToString(periodColumnList);
            List<String> distributeColumnList = columnMap.get("distributeColumnList");
            List<Map<String, Object>> distributeDataList = null;
            StringBuilder tempBuilder = null;
            StringBuilder insertPeriodValue = null;
            // 批量新增 分配关系历史表数据
            List<Map<String, Object>> distributeHisTableDataList = new ArrayList<Map<String, Object>>();
            // 不审批的业务信息-批量新增 分配关系表数据
            List<Map<String, Object>> distributeTableDataList = new ArrayList<Map<String, Object>>();
            // 新增sql参数信息，用于批量新增： 分配区间历史表数据
            List<Map<String, String>> toBatchInsertParamsList = new ArrayList<Map<String, String>>();
            Map<String, String> toBatchInsertParamsMap = null;
            // 不审批的业务数据-sql参数信息，批量操作: 批量更新分配区间历史表-APPLY_VERSION字段值；批量新增-分配区间表数据
            List<Map<String, String>> noApplyParamsList = new ArrayList<Map<String, String>>();
            Map<String, String> noApplyParamsMap = null;
            Set<Map<String, Object>> mapKeySet = dataMetaMap.keySet();
            for (Map<String, Object> mapKey : mapKeySet) {// 第一层循环，处理区间段
                if (mapKey.get("needApply").toString().equals("false")) {
                    needApply = false;
                    applySts = DistributionConstants.APPLY_APPROVED;
                } else {
                    needApply = true;
                    applySts = DistributionConstants.UNDER_APPROVAL;
                }

//	        	needApply = false;	// for test TODO delete
//	        	applySts = DistributionConstants.APPLY_APPROVED;	// for test TODO delete

                StringBuffer pkValueStr = new StringBuffer();// 主键值串，中间以"_"分隔
                StringBuffer pkValueStrPk = new StringBuffer();// 主键值串，中间以"_"分隔
                String effectDate = mapKey.get("effectDate").toString().replaceAll("-", "");// 生效日期
                String expirateDate = mapKey.get("expirateDate").toString().replaceAll("-", "");// 失效日期
                String periodId = UUID.randomUUID().toString().replaceAll("-", "");    // 区间表主键
                for (String pk : pkList) {
                    pkValueStr.append(mapKey.get(pk)).append("_");
                    pkValueStrPk.append(mapKey.get(pk)).append("_");
                }
                if (mapKey.get("needApply").toString().equals("false")) {
                    pkValueStrPk.append("false");
                } else {
                    pkValueStrPk.append("true");
                }
                pkValueStr.deleteCharAt(pkValueStr.length() - 1);
                distributeDataList = dataMetaMap.get(mapKey);// 获取某一区间段的分配关系数据

                // 新增 分配关系历史表数据
//				commonPerformanceImpMapper.batchInsertDistributeHisTableData(distributeHisTableName, periodId, distributeColumnList, distributeDataList);
//				if(!needApply) {	// 如果不需要审批，直接新增 分配关系表数据
//					commonPerformanceImpMapper.batchInsertDistributeTableData(distributeTableName, periodId, distributeColumnList, distributeDataList);
//				}
                for (int i = 0, k = distributeDataList.size(); i < k; ++i) {
                    distributeDataList.get(i).put("PERIOD_ID", periodId);    // 将PERIOD_ID存入distributeDataList中，方便后续批量新增使用
                }
                distributeHisTableDataList.addAll(distributeDataList);
                if (!needApply) {    // 不审批的数据，放入distributeTableDataList表，方便后续批量新增使用
                    distributeTableDataList.addAll(distributeDataList);
                }

                // 5、新增 分配区间历史表、分配区间表数据
                String operateTime = DateUtil.getFullDateNoMils();
                tempBuilder = this.createInsertPeriodValues(operateTime, pkValueStr.toString(), effectDate,
                        expirateDate, periodId, funCode, userId, grantOrgCode);
                insertPeriodValue = tempBuilder.deleteCharAt(tempBuilder.length() - 1);

                toBatchInsertParamsMap = new HashMap<String, String>();
                toBatchInsertParamsMap.put("insertPeriodValue", insertPeriodValue.toString());
                toBatchInsertParamsMap.put("applySts", applySts);
                toBatchInsertParamsMap.put("operateTime", operateTime);
                toBatchInsertParamsMap.put("applyId", pkInstanceIdMap.get(pkValueStrPk.toString()));
                toBatchInsertParamsList.add(toBatchInsertParamsMap);
//				// 新增 分配区间历史表数据
//				StringBuilder insertPeriodHisSql = new StringBuilder();
//				insertPeriodHisSql.append("INSERT INTO ");
//				insertPeriodHisSql.append(periodHisTableName);
//				insertPeriodHisSql.append("(");
////				if (!"custDstr".equals(funCode)) {
//					insertPeriodHisSql.append(insertPeriodColumnStr);
////					insertPeriodHisSql.append(",APPLY_STS,APPLY_TIME,APPLY_ID) VALUES(");
//					insertPeriodHisSql.append(",APPLY_STS,APPLY_TIME,APPLY_ID,APPLY_VERSION) VALUES(");
////				} else {
////					insertPeriodHisSql.append(insertPeriodColumnStr);
////					insertPeriodHisSql.append(",ORG_ID,APPLY_STS,APPLY_TIME,APPLY_ID) VALUES(");
////				}
//				insertPeriodHisSql.append(insertPeriodValue).append("");
//				insertPeriodHisSql.append(applySts);
//				insertPeriodHisSql.append("','");
//				insertPeriodHisSql.append(operateTime);
//				insertPeriodHisSql.append("','");
//				insertPeriodHisSql.append(pkInstanceIdMap.get(pkValueStrPk.toString()));
////				insertPeriodHisSql.append("')");
//				insertPeriodHisSql.append("','0')");
//				commonPerformanceImpMapper.executeInsertSql(insertPeriodHisSql.toString());
                // 不需要审批 直接新增 分配区间表数据
                if (!needApply) {
                    noApplyParamsMap = new HashMap<String, String>();
                    noApplyParamsMap.put("applySts", applySts);
                    noApplyParamsMap.put("applyId", pkInstanceIdMap.get(pkValueStrPk.toString()));
                    noApplyParamsMap.put("insertPeriodValue", insertPeriodValue.toString());
                    noApplyParamsList.add(noApplyParamsMap);
//					/** 插入periodHIs表的版本号 */
//					StringBuilder updatePeriodhisVersionSql = new StringBuilder();
//					updatePeriodhisVersionSql.append("UPDATE ");
//					updatePeriodhisVersionSql.append(periodHisTableName);
//					updatePeriodhisVersionSql.append(" SET APPLY_VERSION = '1' ");
//					updatePeriodhisVersionSql.append(" WHERE APPLY_VERSION = '0' AND APPLY_STS = '"+applySts+"' AND APPLY_ID <> '"+pkInstanceIdMap.get(pkValueStrPk.toString())+"'");
//					commonPerformanceImpMapper.executeInsertSql(updatePeriodhisVersionSql.toString());
//					StringBuilder insertPeriodSql = new StringBuilder();
//					insertPeriodSql.append("INSERT INTO ");
//					insertPeriodSql.append(periodTableName);
//					insertPeriodSql.append("(");
////					if (!"custDstr".equals(funCode)) {
//						insertPeriodSql.append(insertPeriodColumnStr);
//						insertPeriodSql.append(") VALUES(");
////					} else {
////						insertPeriodSql.append(insertPeriodColumnStr);
////						insertPeriodSql.append(",org_id) VALUES(");
////					}
//					insertPeriodSql.append(insertPeriodValue.deleteCharAt(insertPeriodValue.length() - 1));
//					insertPeriodSql.append(")");
//					commonPerformanceImpMapper.executeInsertSql(insertPeriodSql.toString());
                }
            }
            // 批量新增-分配关系历史表数据
            if (distributeHisTableDataList.size() > 0) {
                int batchSize = 1000;
                // 分批次操作
                int index = distributeHisTableDataList.size() / batchSize;
                int remainder = distributeHisTableDataList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertDistributeHisTableData(distributeHisTableName, "", distributeColumnList,
                            distributeHisTableDataList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            // 针对不需要审批的数据，批量新增-分配关系表数据
            if (distributeTableDataList.size() > 0) {
                int batchSize = 1000;
                // 分批次操作
                int index = distributeTableDataList.size() / batchSize;
                int remainder = distributeTableDataList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertDistributeTableData(distributeTableName, "", distributeColumnList,
                            distributeTableDataList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            // 批量新增-分配区间历史表数据
            if (toBatchInsertParamsList.size() > 0) {
                int batchSize = 1000;
                // 分批次操作
                int index = toBatchInsertParamsList.size() / batchSize;
                int remainder = toBatchInsertParamsList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertPeriodHisTableData(periodHisTableName, insertPeriodColumnStr,
                            toBatchInsertParamsList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            // 针对不需要审批的数据，批量操作: 批量更新分配区间历史表-APPLY_VERSION字段值；批量新增-分配区间表数据
            if (noApplyParamsList.size() > 0) {
                String currApplySts = noApplyParamsList.get(0).get("applySts");
                int batchSize = 1000;
                // 分批次操作
                int index = noApplyParamsList.size() / batchSize;
                int remainder = noApplyParamsList.size() % batchSize;
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchUpdatePeriodHisTableApplyVersion(periodHisTableName, currApplySts,
                            noApplyParamsList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
                for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                    commonPerformanceImpMapper.batchInsertPeriodTableData(periodTableName, insertPeriodColumnStr,
                            noApplyParamsList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                }
            }
            distributeHisTableDataList = null;
            distributeTableDataList = null;
            toBatchInsertParamsList = null;
            noApplyParamsList = null;
            System.out.println("performance asyn d:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
            log.info("performance instanceList size: " + instanceList.size());
            // 6、根据是否审批，更新批量导入业务主表-执行状态字段数据
            if (instanceList.size() > 0) {
                // 需要审批，设置执行状态字段11正在生成工作流
                pmaFPerformanceBatchInfoMapper.updateStatusByBatchIdAndFunCode(batchId, funCode, "11");
                // 更新 WF_TOTAL_COUNT字段值
                pmaFPerformanceBatchInfoMapper.updateWfTotalCountByBatchIdAndFunCode(batchId, funCode, wfTotalCount + "");
                String workFlow = commonDistributionService.workFlow(funInfoMap);
                // 异步发起审批流
                performanceImpThreadManager.process(funCode, batchId, instanceList, pkList, periodHisTableName,
                        dtlTableName, false, workFlow, batchFixedThreadPoolManager, userId);

                // 针对 需要/不需要审批数据同时存在的情况，根据业务主键，删除去重表中数据
                if (toDeleteKeyAndOrgIdList.size() > 0) {
                    // 删除互斥表数据
                    AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");    // 获取  业绩批量导入互斥表表名
                    String mutexTableName = mutexTableInfo.getTableName();    // 互斥表表名
                    int batchSize = 100;
                    // 分批次操作
                    int index = toDeleteKeyAndOrgIdList.size() / batchSize;
                    int remainder = toDeleteKeyAndOrgIdList.size() % batchSize;
                    for (int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
                        commonPerformanceImpMapper.deleteMutexTableDataByKeyColumn(mutexTableName, pkList.get(0),
                                toDeleteKeyAndOrgIdList.stream().skip(i * batchSize).limit(batchSize).collect(Collectors.toList()));
                    }
                }
            } else {
                // 不需要审批，设置执行状态字段20执行完成
                pmaFPerformanceBatchInfoMapper.updateStatusByBatchIdAndFunCode(batchId, funCode, "20");
                // 删除互斥表数据
                AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");    // 获取  业绩批量导入互斥表表名
                String mutexTableName = mutexTableInfo.getTableName();    // 互斥表表名
                commonPerformanceImpMapper.deleteMutexTableData(mutexTableName, batchId);
                if (instanceList.size() == 0) {    // 没有要发起工作流的数据，将batchFixedThreadPoolManager中batchId删除
                    batchFixedThreadPoolManager.removeBatchIdFromBatchIdsMap(batchId);
                }
            }
            System.out.println("performance asyn e:" + Duration.between(startInstant, Instant.now()).toMillis());    // TODO
        } catch (Exception e) {
            log.error("performanceImp asynProcessWorkFlow error: ", e);
            throw e;
        }
    }
}