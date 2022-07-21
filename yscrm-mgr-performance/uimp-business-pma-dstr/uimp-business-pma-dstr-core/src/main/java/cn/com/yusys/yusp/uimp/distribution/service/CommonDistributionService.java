package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.exception.YuspException;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.echain.server.service.EchainJoinCoreService;
import cn.com.yusys.yusp.echain.server.web.rest.dto.joincore.WfInitDTO;
import cn.com.yusys.yusp.flow.domain.NWfInstance;
import cn.com.yusys.yusp.flow.dto.*;
import cn.com.yusys.yusp.flow.dto.result.ResultCommentDto;
import cn.com.yusys.yusp.flow.dto.result.ResultInstanceDto;
import cn.com.yusys.yusp.flow.dto.result.ResultMessageDto;
import cn.com.yusys.yusp.flow.dto.result.ResultNodeDto;
import cn.com.yusys.yusp.flow.ext.StudioNodeScriptInterface;
import cn.com.yusys.yusp.flow.other.engine.NodeInfo;
import cn.com.yusys.yusp.flow.other.engine.RouteInfo;
import cn.com.yusys.yusp.flow.other.engine.init.EngineInterface;
import cn.com.yusys.yusp.flow.other.groovy.OelFactory;
import cn.com.yusys.yusp.flow.service.NWfInstanceService;
import cn.com.yusys.yusp.flow.service.core.WorkflowEngineExtInterface;
import cn.com.yusys.yusp.flow.service.core.WorkflowEngineInterface;
import cn.com.yusys.yusp.flow.service.core.WorkflowRouteInterface;
import cn.com.yusys.yusp.flow.service.core.impl.WorkflowEngineImpl;
import cn.com.yusys.yusp.flow.util.ApplicationContextUtil;
import cn.com.yusys.yusp.flow.util.WorkFlowUtil;
import cn.com.yusys.yusp.repository.mapper.DataType;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunTable;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.*;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonDistributionMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonPerformanceImpMapper;
import co.elastic.apm.shaded.stagemonitor.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.ecc.echain.util.UNIDProducer;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonDistributionService
 * @类描述: # 业绩公共接口 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-07 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CommonDistributionService extends CommonService{
    private static final Log log = LogFactory.getLog(WorkflowEngineImpl.class);
	@Autowired
	private EchainJoinCoreService joinCoreService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private NWfInstanceService instanceService;
	@Autowired
	private EngineInterface engineInfo;
	@Autowired
	private WorkflowRouteInterface routeService;
	@Autowired
	private WorkflowEngineInterface workflowEngineService;
	@Autowired
	private WorkflowEngineExtInterface workflowEngineExtService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static Pattern linePattern = Pattern.compile("_(\\w)");
	
//	@Autowired
//	private EchainFeignClient client;


    @Autowired
    private CommonDistributionMapper commonDistributionMapper;
    
    @Autowired
    private CommonPerformanceImpMapper commonPerformanceImpMapper;
    
	@Autowired
	private MetaFunctionManagerService metaFunctionManagerService;
	
    protected CommonMapper<?> getMapper() {
        return commonDistributionMapper;
    }

	/** 业务注册信息 */
	private ThreadLocal<AdminBaseMetaFunReg> regInfo = new ThreadLocal<AdminBaseMetaFunReg>();

	/** 分配业务信息表信息 */
	private ThreadLocal<Map<String, String>> infoTableInfo = new ThreadLocal<Map<String, String>>();

	/** 分配区间历史表信息 */
	private ThreadLocal<Map<String, String>> periodHisTableInfo = new ThreadLocal<Map<String, String>>();

	/** 分配关系历史表信息 */
	private ThreadLocal<Map<String, String>> distributeHisTableInfo = new ThreadLocal<Map<String, String>>();

	/** 分配区间生效表信息 */
	private ThreadLocal<Map<String, String>> periodTableInfo = new ThreadLocal<Map<String, String>>();

	/** 分配关系生效表信息 */
	private ThreadLocal<Map<String, String>> distributeTableInfo = new ThreadLocal<Map<String, String>>();

	/** 分配业务信息表名 */
	private ThreadLocal<String> infoTableName = new ThreadLocal<String>();

	/** 分配区间历史表名 */
	private ThreadLocal<String> periodHisTableName = new ThreadLocal<String>();

	/** 分配关系历史表名 */
	private ThreadLocal<String> distributeHisTableName = new ThreadLocal<String>();

	/** 分配区间生效表名 */
	private ThreadLocal<String> periodTableName = new ThreadLocal<String>();

	/** 分配关系生效表名 */
	private ThreadLocal<String> distributeTableName = new ThreadLocal<String>();

	/** 是否需要审批 */
	private ThreadLocal<Boolean> needApply = new ThreadLocal<Boolean>() {
		@Override
		protected Boolean initialValue() {
			return false;
		}
	};

	/** 发起流程的实例信息列表 */
	private ThreadLocal<List<Map<String, Object>>> instanceList = new ThreadLocal<List<Map<String, Object>>>() {
		@Override
		protected List<Map<String, Object>> initialValue() {
			return new ArrayList<Map<String, Object>>();
		}
	};

	/** 分配主键list */
	private ThreadLocal<List<String>> pkList = new ThreadLocal<List<String>>();
	
	/** 金额list */
	private ThreadLocal<List<String>> amtList = new ThreadLocal<List<String>>();
	
	/** 审批流程额外参数list */
	private ThreadLocal<List<String>> echainParamList = new ThreadLocal<List<String>>();

	/** 分配区间表字段列表(不含主键列表pkList,不含三个审批字段) */
	private ThreadLocal<List<String>> periodColumnList = new ThreadLocal<List<String>>();

	/** 分配关系表字段列表(生效表与历史表字段一致) */
	private ThreadLocal<List<String>> distributeColumnList = new ThreadLocal<List<String>>();

	/** 插入分配区间表的字段字符串,以逗号分隔 */
	private ThreadLocal<String> insertPeriodColumn = new ThreadLocal<String>();

	/** 插入分配关系表的字段字符串,以逗号分隔 */
	private ThreadLocal<String> insertDistributeColumn = new ThreadLocal<String>();

	/** 查询ID_SEQUENCE的sql */
	private ThreadLocal<String> queryIdSequenceSQL = new ThreadLocal<String>();
	


	public AdminBaseMetaFunReg getRegInfo() {
		return regInfo.get();
	}

	public void setRegInfo(AdminBaseMetaFunReg regInfo) {
		this.regInfo.set(regInfo);
	}

	public Map<String, String> getInfoTableInfo() {
		return infoTableInfo.get();
	}

	public void setInfoTableInfo(Map<String, String> infoTableInfo) {
		this.infoTableInfo.set(infoTableInfo);
		;
	}

	public Map<String, String> getPeriodHisTableInfo() {
		return periodHisTableInfo.get();
	}

	public void setPeriodHisTableInfo(Map<String, String> periodHisTableInfo) {
		this.periodHisTableInfo.set(periodHisTableInfo);
	}

	public Map<String, String> getDistributeHisTableInfo() {
		return distributeHisTableInfo.get();
	}

	public void setDistributeHisTableInfo(Map<String, String> distributeHisTableInfo) {
		this.distributeHisTableInfo.set(distributeHisTableInfo);
		;
	}

	public Map<String, String> getPeriodTableInfo() {
		return periodTableInfo.get();
	}

	public void setPeriodTableInfo(Map<String, String> periodTableInfo) {
		this.periodTableInfo.set(periodTableInfo);
	}

	public Map<String, String> getDistributeTableInfo() {
		return distributeTableInfo.get();
	}

	public void setDistributeTableInfo(Map<String, String> distributeTableInfo) {
		this.distributeTableInfo.set(distributeTableInfo);
		;
	}

	public String getInfoTableName() {
		return infoTableName.get();
	}

	public void setInfoTableName(String infoTableName) {
		this.infoTableName.set(infoTableName);
		;
	}

	public String getPeriodHisTableName() {
		return periodHisTableName.get();
	}

	public void setPeriodHisTableName(String periodHisTableName) {
		this.periodHisTableName.set(periodHisTableName);
		;
	}

	public String getDistributeHisTableName() {
		return distributeHisTableName.get();
	}

	public void setDistributeHisTableName(String distributeHisTableName) {
		this.distributeHisTableName.set(distributeHisTableName);
		;
	}

	public String getPeriodTableName() {
		return periodTableName.get();
	}

	public void setPeriodTableName(String periodTableName) {
		this.periodTableName.set(periodTableName);
	}

	public String getDistributeTableName() {
		return distributeTableName.get();
	}

	public void setDistributeTableName(String distributeTableName) {
		this.distributeTableName.set(distributeTableName);
	}

	public boolean isNeedApply() {
		return needApply.get();
	}

	public void setNeedApply(boolean needApply) {
		this.needApply.set(needApply);
	}

	public List<Map<String, Object>> getInstanceList() {
		return instanceList.get();
	}

	public void setInstanceList(List<Map<String, Object>> instanceList) {
		this.instanceList.set(instanceList);
	}
	
	public List<String> getAmtList() {
		return amtList.get();
	}
	
	public void setAmtList(List<String> amtList) {
		this.amtList.set(amtList);
	}
	
	public List<String> getPkList() {
		return pkList.get();
	}

	public void setPkList(List<String> pkList) {
		this.pkList.set(pkList);
	}

	public List<String> getEchainParamList() {
		return echainParamList.get();
	}

	public void setEchainParamList(List<String> echainParamList) {
		this.echainParamList.set(echainParamList);
	}

	public List<String> getPeriodColumnList() {
		return periodColumnList.get();
	}

	public void setPeriodColumnList(List<String> periodColumnList) {
		this.periodColumnList.set(periodColumnList);
	}

	public List<String> getDistributeColumnList() {
		return distributeColumnList.get();
	}

	public void setDistributeColumnList(List<String> distributeColumnList) {
		this.distributeColumnList.set(distributeColumnList);
	}

	public String getInsertPeriodColumn() {
		return insertPeriodColumn.get();
	}

	public void setInsertPeriodColumn(String insertPeriodColumn) {
		this.insertPeriodColumn.set(insertPeriodColumn);
		;
	}

	public String getInsertDistributeColumn() {
		return insertDistributeColumn.get();
	}

	public void setInsertDistributeColumn(String insertDistributeColumn) {
		this.insertDistributeColumn.set(insertDistributeColumn);
		;
	}

	public String getQueryIdSequenceSQL() {
		return queryIdSequenceSQL.get();
	}

	public void setQueryIdSequenceSQL(String queryIdSequenceSQL) {
		this.queryIdSequenceSQL.set(queryIdSequenceSQL);
		;
	}
    /**
     * 查询
     * @param model
     * @return
     * @throws Exception
     */
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) throws Exception {
    	String funCodeJs = model.getCondition().get("funCode").toString();
    	String isPc = model.getCondition().get("isPc").toString();
		Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
		Map<String, String> infoTableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableName = infoTableMap.get("tableName");
		String infoTableCode = infoTableMap.get("tableCode");
		boolean needApply = needApply(funInfoMap);
		List<String> pkList = getDstrPrimaryKey(funInfoMap);
		Map<String, String> periodHisTableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
		String periodHisTableName = periodHisTableMap.get("tableName");
		StringBuilder queryColumn = new StringBuilder();
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Set<Map<String, Object>> searchFieldSet = new HashSet<Map<String, Object>>();
		List<Object[]> orderbyList = new ArrayList<Object[]>();
		StringBuilder orderbyStr = new StringBuilder();
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			String columnName = columnMap.get(columnCode).get("columnName").toString();
			if ("DSTR_STS".equals(columnName)) { 
				continue;
			}
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				if ("ACCT_ORG_ID".equals(columnName)) { 
					continue;
				}
			}
			queryColumn.append("t.");
			queryColumn.append(columnName);
			queryColumn.append(",");
			Map<String, String> columnCfgMap = (Map<String, String>) columnCfgInfoMap.get(columnCode);
			Map<String, Object> searchMap = new HashMap<String, Object>();
			searchMap.put("columnName", columnName);
			if (COLUMN_TYPE.NUMBER.toString().equals(columnMap.get(columnCode).get("COLUMN_TYPE"))) {
				searchMap.put("dataType", DataType.Number);
			} else if (COLUMN_TYPE.DATE.toString().equals(columnMap.get(columnCode).get("COLUMN_TYPE"))) {
				searchMap.put("dataType", DataType.Date);
			} else {
				searchMap.put("dataType", DataType.String);
			}
			if (columnCfgMap != null && DistributionConstants.YES.equals(columnCfgMap.get("SEARCH_FIELD"))) {

				if (DistributionConstants.YES.equals(columnCfgMap.get("LIKE_SEARCH"))) {
					searchMap.put("compareChar", "like");
				} else {
					searchMap.put("compareChar", "=");
				}
				if (SEARCH_TYPE.ORG_CHOOSE.toString().equals(columnCfgMap.get("SEARCH_TYPE"))) {
					searchMap.put("columnHiddenName", columnName);
					if (!DistributionConstants.NO.equals(columnCfgMap.get("SUB_ORG"))) {
						searchMap.put("subOrgQuery", DistributionConstants.YES);
					}

				} else if (SEARCH_TYPE.DATE_SPAN.toString().equals(columnCfgMap.get("SEARCH_TYPE"))) {
					searchMap.put("dateSpan", columnName + "_SPAN");
				} else if (SEARCH_TYPE.DATE_ONLY.toString().equals(columnCfgMap.get("SEARCH_TYPE"))) {
					searchMap.put("dateOnly", columnName + "_ONLY");
				} else if (SEARCH_TYPE.MONEY_SPAN.toString().equals(columnCfgMap.get("SEARCH_TYPE"))) {
					searchMap.put("moneySpan", columnName + "_MONEY_SPAN");
				}
			} else {
				searchMap.put("compareChar", "=");
			}
			searchFieldSet.add(searchMap);
			/** 鎺掑簭鏉′欢閰嶇疆 */
			if (columnCfgMap != null && columnCfgMap.get("ORDERBY") != null) {
				int orderbySort = 0;
				if (columnCfgMap.get("ORDERBY_SORT") != null) {
					orderbySort = Integer.parseInt(columnCfgMap.get("ORDERBY_SORT"));
				}
				Object[] orderInfo = { columnName + " " + columnCfgMap.get("ORDERBY"), orderbySort };
				if (orderbyList.size() == 0) {
					orderbyList.add(orderInfo);
				} else {
					for (int i = 0; i < orderbyList.size(); i++) {
						Object[] o = orderbyList.get(i);
						if ((Integer) orderInfo[1] <= (Integer) o[1]) {
							orderbyList.add(i, orderInfo);
							break;
						} else if (i == orderbyList.size() - 1) {
							orderbyList.add(orderInfo);
							break;
						}
					}
				}
			}
		}
		for (Object[] o : orderbyList) {
			orderbyStr.append(o[0]);
			orderbyStr.append(",");
		}
		if (orderbyStr.length() > 0) {
			orderbyStr.deleteCharAt(orderbyStr.length() - 1);
		}
		String vet = model.getCondition().get("vet") != null ? model.getCondition().get("vet") + "" : "";
		queryColumn.deleteCharAt(queryColumn.length() - 1);
		String pkSe = "";
		String pkSe2 = "";
		for (String pk : pkList) {
			pkSe = "t."+pk+",";
			pkSe2 = pk+",";
		}
		if(!pkSe.equals("")) {
			pkSe=pkSe.substring(0, pkSe.length()-1);
			pkSe2=pkSe2.substring(0, pkSe2.length()-1);
		}
		StringBuilder sb = new StringBuilder();
		if (needApply && DistributionConstants.YES.equals(vet)) {
			sb.append(" SELECT * FROM (");
			sb.append(" SELECT ");
			sb.append(queryColumn);
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(",acci.ACCT_ORG_ID");
			}
			sb.append(",a.APPLY_ID,'03' as DSTR_STS");
			sb.append(",NODE.NODE_ID,WF.INSTANCE_ID,TODO.USER_ID,WF.BIZ_ID,WF.START_TIME,'"+funCodeJs+"' as FUN_CODE");
			sb.append(" FROM ");
			sb.append(infoTableName);
			sb.append(" T ");
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" LEFT JOIN PMA_F_CUST_ACCT_INFO ACCI ON T.CUST_ID = ACCI.CUST_ID ");
			}
		
			sb.append(" INNER JOIN ");
			sb.append(periodHisTableName);
			sb.append(" A ON APPLY_STS = '").append(DistributionConstants.UNDER_APPROVAL).append("' ");
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" AND A.CUST_ID = acci.CUST_ID AND A.ACCT_ORG_ID = acci.ACCT_ORG_ID ");
			}else {
				for (String pk : pkList) {
					sb.append(" AND T.").append(pk).append("=A.").append(pk);
				}
			}
			sb.append(" AND A.EXPIRATE_DATE = '20991231'");

			if (needApply && DistributionConstants.YES.equals(vet)) {
				sb.append(" INNER JOIN N_WF_INSTANCE WF ON A.APPLY_ID = WF.BIZ_ID");
				sb.append(" INNER JOIN N_WF_USER_TODO TODO ON TODO.INSTANCE_ID = WF.INSTANCE_ID");
				sb.append(" INNER JOIN N_WF_NODE NODE ON NODE.INSTANCE_ID = WF.INSTANCE_ID AND TODO.NODE_ID = NODE.NODE_ID");
			}
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" WHERE 1=1 ");
			}else {
				sb.append(" WHERE 1=1 and t.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
			}

			if (model != null && model.getCondition().get("dataSrc") != null) {
				String dataSrc = model.getCondition().get("dataSrc").toString();
				sb.append(" AND a.DATA_SRC = '").append(dataSrc).append("' ");
			}
	
				sb.append(" and todo.user_id = '"+userInfoService.getUserInfo().getLoginCode()+"'");
		for (Map<String, Object> map : searchFieldSet) { 
			if (map.get("columnHiddenName") != null) {
				if (DistributionConstants.YES.equals(map.get("subOrgQuery"))&& model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))) != null
						&& !"".equals(model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))).toString())&&!StringUtils.isEmpty(model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))).toString())) { // 鏈烘瀯鏀惧ぇ闀滄煡璇㈣緰鍐呴厤缃�
					if (!DistributionConstants.YES.equals(vet)) {
						if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
							sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE ACCI.ACCT_ORG_ID");
							sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
							sb.append(model.getCondition().get(lineToHump((String) map.get("columnHiddenName")))).append(")($|,)') )");
						}else {
							sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE t."+map.get("columnName").toString());
							sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
							sb.append(model.getCondition().get(lineToHump((String) map.get("columnHiddenName")))).append(")($|,)') )");
						}

					} else {
						if(!model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))).equals(userInfoService.getGrantOrgCode())){
                            sb.append(" AND EXISTS (SELECT 1 FROM N_WF_INSTANCE ZO WHERE ZO.BIZ_ID=a.APPLY_ID");
                            sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE ZO.ORG_ID");
							sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
							sb.append(model.getCondition().get(lineToHump((String) map.get("columnHiddenName")))).append(")($|,)') )");
							sb.append(")");
						}
						
					}
				} else {
					if("".equals(map.get("columnName").toString())||map.get("columnName").toString()==null) {
						
					}else {
						if(model.getCondition().get(lineToHump((String) map.get("columnName"))) == null
								||"".equals(model.getCondition().get(lineToHump((String) map.get("columnName"))).toString())
								||StringUtils.isEmpty(model.getCondition().get(lineToHump((String) map.get("columnName"))).toString())) {
							
						}else {
							sb.append(" AND t."+map.get("columnName").toString()+map.get("compareChar").toString()+"'"+model.getCondition().get(lineToHump((String) map.get("columnName"))).toString()+"'");

						}
					}
				}
			} else if (map.get("dateSpan") != null) {					
                if(model.getCondition().containsKey(lineToHump(map.get("dateSpan") + "1")) && 
                        !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) + "")&&  
                        !"".equals(model.getCondition().get(lineToHump(map.get("dateSpan") + "1")))&& 
                        model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) != null) {
                    if(2 == (Integer) map.get("dataType")) {    // 日期组件, 此处后续要考虑数据库的适配 
                        String dateFormat = map.get("dateFormat") + "";
                        sb.append(" and t." + map.get("columnName") + ">=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) + "', '" + dateFormat + "')");
                    } else {
                        sb.append(" and to_date(t." + map.get("columnName") + ",'yyyy-mm-dd') >=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) + "','yyyy-mm-dd')");
                    }
                }
                    if(model.getCondition().containsKey(lineToHump(map.get("dateSpan") + "2")) && 
                            !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) + "")&& 
                            !"".equals(model.getCondition().get(lineToHump(map.get("dateSpan") + "2")))&& 
                            model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) != null) {
                        if(2 == (Integer) map.get("dataType")) {    // 日期组件, 此处后续要考虑数据库的适配 
                            String dateFormat = map.get("dateFormat") + "";
                            sb.append(" and t." + map.get("columnName") + "<=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) + "', '" + dateFormat + "')");
                        } else {
                            sb.append(" and to_date(t." + map.get("columnName") + ",'yyyy-mm-dd') <=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) + "','yyyy-mm-dd')");
                        }
                    }
			} else if (map.get("dateOnly") != null) {					
                if(model.getCondition().containsKey(lineToHump(map.get("dateOnly").toString())) && 
                        !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("dateOnly").toString())) + "")&&  
                        !"".equals(model.getCondition().get(lineToHump(map.get("dateOnly").toString())))&& 
                        model.getCondition().get(lineToHump(map.get("dateOnly").toString())) != null){
                    if(2 == (Integer) map.get("dataType")) {    // 日期组件, 此处后续要考虑数据库的适配 
                        String dateFormat = map.get("dateFormat") + "";
                        sb.append(" and t." + map.get("columnName") + "=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateOnly").toString())) + "', '" + dateFormat + "')");
                    } else {
                        sb.append(" and to_date(t." + map.get("columnName") + ",'yyyy-mm-dd') =" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateOnly").toString())) + "','yyyy-mm-dd')");
                    }
                }
			} else if (map.get("moneySpan") != null) {					
                if(model.getCondition().containsKey(lineToHump(map.get("moneySpan") + "1")) && 
                        !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("moneySpan") + "1")) + "")&&  
                        !"".equals(model.getCondition().get(lineToHump(map.get("moneySpan") + "1")))&& 
                        model.getCondition().get(lineToHump(map.get("moneySpan") + "1")) != null) {
                        sb.append(" and to_number(t." + map.get("columnName") + ") >= to_number('" + model.getCondition().get(lineToHump(map.get("moneySpan") + "1"))+ "')");

                }
                    if(model.getCondition().containsKey(lineToHump(map.get("moneySpan") + "2")) && 
                            !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("moneySpan") + "2")) + "")&& 
                            !"".equals(model.getCondition().get(lineToHump(map.get("moneySpan") + "2")))&& 
                            model.getCondition().get(lineToHump(map.get("moneySpan") + "2")) != null) {
                            sb.append(" and to_number(t." + map.get("columnName") + ")<= to_number('" + model.getCondition().get(lineToHump(map.get("moneySpan") + "2")) + "')");

                    }
			} else {
				if(model.getCondition().containsKey(lineToHump(map.get("columnName") + "")) && 
						!StringUtils.isEmpty((String) model.getCondition().get(lineToHump((String) map.get("columnName"))))) {
					sb.append(" and t." + map.get("columnName") + " " + map.get("compareChar") +
							("like".equals(map.get("compareChar")) ? "'%" + model.getCondition().get(lineToHump((String) map.get("columnName"))) + "%'" : "'" + model.getCondition().get(lineToHump((String) map.get("columnName")))+"'"));
				}
			}
		}
		if (orderbyStr.length() > 0) {
			sb.append("ORDER BY " + orderbyStr.toString());
		}
		sb.append(")X WHERE 1=1 " );
		if (model != null && model.getCondition().get("dstrSts") != null&& model.getCondition().get("dstrSts") != ""||!"".equals(model.getCondition().get("dstrSts"))) {
			String dstrSts = model.getCondition().get("dstrSts").toString();
			sb.append("  AND X.DSTR_STS='").append(dstrSts).append("'");
		}
		if(model != null && model.getCondition().get("applySts") != null && !"".equals(model.getCondition().get("applySts"))) {
			String applySts = model.getCondition().get("applySts").toString();
			sb.append("  AND X.APPLY_STS='").append(applySts).append("'");
		}
		if (DistributionConstants.YES.equals(vet)&&isPc.equals("0")) {
			if (model.getCondition().containsKey("applyTimeEnd") && model.getCondition().get("applyTimeEnd") != null&& model.getCondition().get("applyTimeEnd") != ""||!"".equals(model.getCondition().get("applyTimeEnd"))) {
				String date1 = model.getCondition().get("applyTimeEnd").toString();
				sb.append(" and to_date(SUBSTR(X.START_TIME,0, 10),'yyyy-mm-dd') <=to_date('").append(date1).append("','yyyy-mm-dd')");
			}
			if (model.getCondition().containsKey("applyTimeStart") && model.getCondition().get("applyTimeStart") != null&& model.getCondition().get("applyTimeStart") != ""||!"".equals(model.getCondition().get("applyTimeStart"))) {
				String date2 = model.getCondition().get("applyTimeStart").toString();
				sb.append(" and to_date(SUBSTR(X.START_TIME,0, 10),'yyyy-mm-dd') >=to_date('").append(date2).append("','yyyy-mm-dd')");
			}
		}
		}else {
			/**优化sql*/
			sb.append(" SELECT * FROM (");
			sb.append(" SELECT ");
			sb.append(queryColumn);
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(",acci.ACCT_ORG_ID");
			}
//			if (needApply && DistributionConstants.YES.equals(vet)) {
//				sb.append(",a.APPLY_ID");
//			}
			sb.append(",DECODE(A.DSTS,11,'03',12,'01','02') AS DSTR_STS,");
			sb.append("NVL(B.ASTS,'12') AS APPLY_STS");
//			if (needApply && DistributionConstants.YES.equals(vet)) {
//	            sb.append(",NODE.NODE_ID,WF.INSTANCE_ID,TODO.USER_ID,WF.BIZ_ID,WF.START_TIME,'"+funCodeJs+"' as FUN_CODE");
//			}
			sb.append(" FROM ");
			sb.append(infoTableName);
			sb.append(" T ");
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" LEFT JOIN PMA_F_CUST_ACCT_INFO ACCI ON T.CUST_ID = ACCI.CUST_ID ");
			}
			sb.append(" LEFT JOIN ");
			sb.append("(SELECT  ");
			sb.append(pkSe2);
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" ,ACCT_ORG_ID ");
			}
			sb.append(",MIN(TO_NUMBER(APPLY_STS)) AS DSTS  FROM ");
			sb.append(periodHisTableName);
			sb.append(" WHERE APPLY_STS in ('11','12')");
			sb.append(" AND APPLY_VERSION = '0'");
			sb.append(" GROUP BY ");
			sb.append(pkSe2);
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" ,ACCT_ORG_ID ");
			}
			sb.append(")A ON 1=1");
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" AND A.CUST_ID = acci.CUST_ID AND A.ACCT_ORG_ID = acci.ACCT_ORG_ID ");
			}else {
				for (String pk : pkList) {
					sb.append(" AND T.").append(pk).append("=A.").append(pk);
				}
			}
			
			sb.append(" LEFT JOIN ");
			sb.append("(SELECT  ");
			sb.append(pkSe2);
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" ,ACCT_ORG_ID ");
			}
			sb.append(",TO_CHAR(MIN(TO_NUMBER(APPLY_STS))) AS ASTS   FROM ");
			sb.append(periodHisTableName);
			sb.append(" WHERE APPLY_STS in ('11','13')");
			sb.append(" AND APPLY_VERSION = '0'");
			sb.append(" GROUP BY ");
			sb.append(pkSe2);
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" ,ACCT_ORG_ID ");
			}
			sb.append(")B ON 1=1");
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" AND A.CUST_ID = acci.CUST_ID AND A.ACCT_ORG_ID = acci.ACCT_ORG_ID ");
			}else {
				for (String pk : pkList) {
					sb.append(" AND T.").append(pk).append("=B.").append(pk);
				}
			}
			if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
				sb.append(" WHERE 1=1 ");
			}else {
				sb.append(" WHERE 1=1 and t.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
			}
			Map<String, Object> orgColumnMap = getOrgColumnInfo(funInfoMap);
			String dataAuth = model.getCondition().get("dataAuth") != null ? model.getCondition().get("dataAuth") + "" : "";
			String orgNo=userInfoService.getGrantOrgCode();
			try {

				if (DATA_AUTH_TYPE.CUR_ORG.toString().equals(dataAuth)) {
					if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
						sb.append(" and ACCI.ACCT_ORG_ID");
						sb.append("='").append(orgNo).append("'");
					}else {
						sb.append(" and t.").append(orgColumnMap.get("columnName"));
						sb.append("='").append(orgNo).append("'");
					}

				} else if (DATA_AUTH_TYPE.SUB_ORG.toString().equals(dataAuth)) {
					sb.append(" and t.").append(orgColumnMap.get("columnName"));
					sb.append(" IN (SELECT ORG_ID FROM SYS_ORG_VIEW  WHERE REGEXP_LIKE(ORG_SEQ, '(^|,)("+orgNo+")($|,)') )");
				}
				
			} catch (Exception e) {
				throw new YuspException("500", "业务信息表【" + infoTableName + "】机构字段未配置");
			}
			for (Map<String, Object> map : searchFieldSet) { 
				if (map.get("columnHiddenName") != null) {
					if (DistributionConstants.YES.equals(map.get("subOrgQuery"))&& model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))) != null
							&& !"".equals(model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))).toString())&&!StringUtils.isEmpty(model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))).toString())) { // 鏈烘瀯鏀惧ぇ闀滄煡璇㈣緰鍐呴厤缃�
						if (!DistributionConstants.YES.equals(vet)) {
							if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
								sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE ACCI.ACCT_ORG_ID");
								sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
								sb.append(model.getCondition().get(lineToHump((String) map.get("columnHiddenName")))).append(")($|,)') )");
							}else {
								sb.append(" AND  t."+map.get("columnName").toString());
								sb.append(" IN ( SELECT ORG_ID  FROM SYS_ORG_VIEW  WHERE REGEXP_LIKE(ORG_SEQ, '(^|,)("+model.getCondition().get(lineToHump((String) map.get("columnHiddenName")))+")($|,)')   )");
							}

						} else {
							if(!model.getCondition().get(lineToHump((String) map.get("columnHiddenName"))).equals(userInfoService.getGrantOrgCode())){
	                            sb.append(" AND EXISTS (SELECT 1 FROM N_WF_INSTANCE ZO WHERE ZO.BIZ_ID=a.APPLY_ID");
	                            sb.append(" AND EXISTS (SELECT 1 FROM SYS_UNITS C WHERE ZO.ORG_ID");
								sb.append("=C.UNITID AND REGEXP_LIKE (C.UNITSEQ,'(^|,)(");
								sb.append(model.getCondition().get(lineToHump((String) map.get("columnHiddenName")))).append(")($|,)') )");
								sb.append(")");
							}
							
						}
					} else {
						if("".equals(map.get("columnName").toString())||map.get("columnName").toString()==null) {
							
						}else {
							if(model.getCondition().get(lineToHump((String) map.get("columnName"))) == null
									||"".equals(model.getCondition().get(lineToHump((String) map.get("columnName"))).toString())
									||StringUtils.isEmpty(model.getCondition().get(lineToHump((String) map.get("columnName"))).toString())) {
								
							}else {
								sb.append(" AND t."+map.get("columnName").toString()+map.get("compareChar").toString()+"'"+model.getCondition().get(lineToHump((String) map.get("columnName"))).toString()+"'");

							}
						}
					}
				} else if (map.get("dateSpan") != null) {					
	                if(model.getCondition().containsKey(lineToHump(map.get("dateSpan") + "1")) && 
	                        !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) + "")&&  
	                        !"".equals(model.getCondition().get(lineToHump(map.get("dateSpan") + "1")))&& 
	                        model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) != null) {
	                    if(2 == (Integer) map.get("dataType")) {    // 日期组件, 此处后续要考虑数据库的适配 
	                        String dateFormat = map.get("dateFormat") + "";
	                        sb.append(" and t." + map.get("columnName") + ">=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) + "', '" + dateFormat + "')");
	                    } else {
	                        sb.append(" and to_date(t." + map.get("columnName") + ",'yyyy-mm-dd') >=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "1")) + "','yyyy-mm-dd')");
	                    }
	                }
	                    if(model.getCondition().containsKey(lineToHump(map.get("dateSpan") + "2")) && 
	                            !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) + "")&& 
	                            !"".equals(model.getCondition().get(lineToHump(map.get("dateSpan") + "2")))&& 
	                            model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) != null) {
	                        if(2 == (Integer) map.get("dataType")) {    // 日期组件, 此处后续要考虑数据库的适配 
	                            String dateFormat = map.get("dateFormat") + "";
	                            sb.append(" and t." + map.get("columnName") + "<=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) + "', '" + dateFormat + "')");
	                        } else {
	                            sb.append(" and to_date(t." + map.get("columnName") + ",'yyyy-mm-dd') <=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateSpan") + "2")) + "','yyyy-mm-dd')");
	                        }
	                    }
				} else if (map.get("dateOnly") != null) {					
	                if(model.getCondition().containsKey(lineToHump(map.get("dateOnly").toString())) && 
	                        !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("dateOnly").toString())) + "")&&  
	                        !"".equals(model.getCondition().get(lineToHump(map.get("dateOnly").toString())))&& 
	                        model.getCondition().get(lineToHump(map.get("dateOnly").toString())) != null){
	                    if(2 == (Integer) map.get("dataType")) {    // 日期组件, 此处后续要考虑数据库的适配 
	                        String dateFormat = map.get("dateFormat") + "";
	                        sb.append(" and t." + map.get("columnName") + "=" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateOnly").toString())) + "', '" + dateFormat + "')");
	                    } else {
	                        sb.append(" and to_date(t." + map.get("columnName") + ",'yyyy-mm-dd') =" + "to_date('" + model.getCondition().get(lineToHump(map.get("dateOnly").toString())) + "','yyyy-mm-dd')");
	                    }
	                }
				} else if (map.get("moneySpan") != null) {					
	                if(model.getCondition().containsKey(lineToHump(map.get("moneySpan") + "1")) && 
	                        !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("moneySpan") + "1")) + "")&&  
	                        !"".equals(model.getCondition().get(lineToHump(map.get("moneySpan") + "1")))&& 
	                        model.getCondition().get(lineToHump(map.get("moneySpan") + "1")) != null) {
	                        sb.append(" and to_number(t." + map.get("columnName") + ") >= to_number('" + model.getCondition().get(lineToHump(map.get("moneySpan") + "1"))+ "')");

	                }
	                    if(model.getCondition().containsKey(lineToHump(map.get("moneySpan") + "2")) && 
	                            !StringUtils.isEmpty(model.getCondition().get(lineToHump(map.get("moneySpan") + "2")) + "")&& 
	                            !"".equals(model.getCondition().get(lineToHump(map.get("moneySpan") + "2")))&& 
	                            model.getCondition().get(lineToHump(map.get("moneySpan") + "2")) != null) {
	                            sb.append(" and to_number(t." + map.get("columnName") + ")<= to_number('" + model.getCondition().get(lineToHump(map.get("moneySpan") + "2")) + "')");

	                    }
				} else {
					if(model.getCondition().containsKey(lineToHump(map.get("columnName") + "")) && 
							!StringUtils.isEmpty((String) model.getCondition().get(lineToHump((String) map.get("columnName"))))) {
						sb.append(" and t." + map.get("columnName") + " " + map.get("compareChar") +
								("like".equals(map.get("compareChar")) ? "'%" + model.getCondition().get(lineToHump((String) map.get("columnName"))) + "%'" : "'" + model.getCondition().get(lineToHump((String) map.get("columnName")))+"'"));
					}
				}
			}
			if (orderbyStr.length() > 0) {
				sb.append("ORDER BY " + orderbyStr.toString());
			}
			sb.append(")X WHERE 1=1 " );
			if (model != null && model.getCondition().get("dstrSts") != null&& model.getCondition().get("dstrSts") != ""||!"".equals(model.getCondition().get("dstrSts"))) {
				String dstrSts = model.getCondition().get("dstrSts").toString();
				sb.append("  AND X.DSTR_STS='").append(dstrSts).append("'");
			}
			if(model != null && model.getCondition().get("applySts") != null && !"".equals(model.getCondition().get("applySts"))) {
				String applySts = model.getCondition().get("applySts").toString();
				sb.append("  AND X.APPLY_STS='").append(applySts).append("'");
			}
		}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = commonDistributionMapper.listByModel(sb.toString());
		PageHelper.clearPage();
		return list;
	}

    /**
     * 查询分配区间表数据
     * @param model
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Map<String, Object>> queryPeriodTable(QueryModel model) throws Exception {
    	String funCodeJs = model.getCondition().get("funCode").toString();
		Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD);
		String tableName = tableMap.get("tableName");
		String periodTableCode = tableMap.get("tableCode");
		StringBuilder queryColumn = new StringBuilder();
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(periodTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			queryColumn.append("T.");
			queryColumn.append(columnMap.get(columnCode).get("columnName"));
			queryColumn.append(",");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(queryColumn);
		sb.append("K.USERNAME AS OPER_USER_NAME,U.UNITNAME AS OPER_ORG_NAME FROM ");
		sb.append(tableName);
		sb.append(" T LEFT JOIN SYS_USERS K ON T.OPER_USER_ID = K.USERID LEFT JOIN SYS_UNITS U ON T.OPER_ORG_ID=U.UNITID WHERE 1=1");
		List<String> pkList = getDstrPrimaryKey(funInfoMap);
		for (String pk : pkList) {
			sb.append(" AND T." + pk + "=" + "'" + model.getCondition().get(lineToHump(pk)) + "'");
		}
		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
			sb.append("AND T.ACCT_ORG_ID='" + model.getCondition().get("acctOrgId") + "'");
		}
		sb.append(" ORDER BY T.EXPIRATE_DATE ");
		List<Map<String, Object>> list = commonDistributionMapper.queryPeriodTable(sb.toString());
		return list;
	}
	/**
	 * 查询分配关系表数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Map<String, Object>> queryDistributeTable(QueryModel model) throws Exception {
    	String funCodeJs = model.getCondition().get("funCode").toString();
		Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE);
		String tableName = tableMap.get("tableName");
		String dstrTableCode = tableMap.get("tableCode");
		StringBuilder queryColumn = new StringBuilder();
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(dstrTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			queryColumn.append("t.");
			queryColumn.append(columnMap.get(columnCode).get("columnName"));
			queryColumn.append(",");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(queryColumn);
		sb.append("K.USERNAME AS MANAGER_NAME,K.UNITID AS MANAGER_ORG,");
		sb.append("K.BUSSSYSNO AS MANAGER_BUSS FROM ");
		sb.append(tableName);
		sb.append(" T LEFT JOIN SYS_USERS K ON T.MANAGER_ID = K.USERID WHERE 1=1");
		sb.append(" AND T.PERIOD_ID = '"+model.getCondition().get("periodId")+"'");
		List<Map<String, Object>> list = commonDistributionMapper.queryDistributeTable(sb.toString());
		return list;
	}
    
	/**
	 * <pre>
	 * 功能描述: 查询业绩分配记录历史表中待审批的记录
	 * &#64;Title: queryPeriodHisTableForVet 
	 * &#64;author: XUJW
	 * </pre>
	 * @throws Exception 
	 */
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Map<String, Object>> queryPeriodHisTableForVet(QueryModel model) throws Exception {
    	String funCodeJs = model.getCondition().get("funCode").toString();
		Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
		String tableName = tableMap.get("tableName");
		String periodTableCode = tableMap.get("tableCode");
		StringBuilder queryColumn = new StringBuilder();
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Map<String, Object>>   columnMap  = (Map<String, Map<String, Object>>) columnInfoMap
				.get(periodTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			queryColumn.append("T.");
			queryColumn.append(columnMap.get(columnCode).get("columnName"));
			queryColumn.append(",");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(queryColumn);
		// sb.append("T.EMLOY_RATE,");
		sb.append("K.USERNAME AS OPER_USER_NAME,O.ORG_NAME AS OPER_ORG_NAME FROM ");
		sb.append(tableName);
		sb.append(" T LEFT JOIN SYS_USERS K ON T.OPER_USER_ID = K.USERID "
				+ " LEFT JOIN ADMIN_SM_ORG O ON T.OPER_ORG_ID = O.ORG_CODE WHERE 1=1");
		sb.append(" AND T.APPLY_STS = '");
		sb.append(DistributionConstants.UNDER_APPROVAL);
		sb.append("'");
		List<String> pkList = getDstrPrimaryKey(funInfoMap);
		for (String pk : pkList) {
			sb.append(" AND T." + pk + "=" + "'" + model.getCondition().get(lineToHump(pk)) + "'");
		}
		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
			sb.append("AND T.ACCT_ORG_ID='" + model.getCondition().get("acctOrgId") + "'");
		}
		sb.append(" ORDER BY T.EXPIRATE_DATE ");
		List<Map<String, Object>> list = commonDistributionMapper.queryPeriodHisTableForVet(sb.toString());
		return list;
	}
	/**
	 * <pre>
	 * 功能描述: 查询业绩分配历史记录表
	 * &#64;Title: queryPeriodHisTable 
	 * &#64;author: XUJW
	 * </pre>
	 * @throws Exception 
	 */
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Map<String, Object>> queryPeriodHisTable(QueryModel model) throws Exception {
    	String funCodeJs = model.getCondition().get("funCode").toString();
		Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
		String tableName = tableMap.get("tableName");
		String periodTableCode = tableMap.get("tableCode");
		StringBuilder queryColumn = new StringBuilder();
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(periodTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			queryColumn.append("T.");
			queryColumn.append(columnMap.get(columnCode).get("columnName"));
			queryColumn.append(",");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(queryColumn);
		// sb.append("T.EMLOY_RATE,");
		sb.append("K.USERNAME AS OPER_USER_NAME FROM ");
		sb.append(tableName);
		sb.append(" T LEFT JOIN SYS_USERS K ON T.OPER_USER_ID = K.USERID WHERE 1=1 ");
		List<String> pkList = getDstrPrimaryKey(funInfoMap);
		for (String pk : pkList) {
			sb.append(" AND T." + pk + "=" + "'" + model.getCondition().get(lineToHump(pk)) + "'");
		}
		if(funCodeJs.equals("ComCustDstr")||funCodeJs.equals("PerCustDstr")) {
			sb.append("AND T.ACCT_ORG_ID='" + model.getCondition().get("acctOrgId") + "'");
		}
		sb.append(" ORDER BY T.APPLY_TIME DESC,T.EXPIRATE_DATE ");
		List<Map<String, Object>> list = commonDistributionMapper.queryPeriodHisTable(sb.toString());
		return list;
	}
	/**
	 * <pre>
	 * 功能描述: 查询业绩分配关系历史表
	 * &#64;Title: queryDistributeHisTable 
	 * &#64;author: xujiawei
	 * </pre>
	 * @throws Exception 
	 */
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Map<String, Object>> queryDistributeHisTable(QueryModel model) throws Exception {
    	String funCodeJs = model.getCondition().get("funCode").toString();
		Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE_HIS);
		String tableName = tableMap.get("tableName");
		String dstrTableCode = tableMap.get("tableCode");
		StringBuilder queryColumn = new StringBuilder();
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(dstrTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			queryColumn.append("t.");
			queryColumn.append(columnMap.get(columnCode).get("columnName"));
			queryColumn.append(",");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(queryColumn);
		// sb.append("T.EMLOY_RATE,");
		sb.append("K.USERNAME AS MANAGER_NAME,K.UNITID AS MANAGER_ORG,");
		sb.append("K.BUSSSYSNO AS MANAGER_BUSS FROM ");
		sb.append(tableName);
		sb.append(" T LEFT JOIN SYS_USERS K ON T.MANAGER_ID = K.USERID WHERE 1=1");
		sb.append(" AND T.PERIOD_ID = '"+model.getCondition().get("periodId")+"'");
		List<Map<String, Object>> list = commonDistributionMapper.queryDistributeTable(sb.toString());
		return list;
	}
    /**
     * 业绩分配保存
     * @param map
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String, Object> saveDataEchain4(Map<String,Object> map) throws Exception {
    	String funCodeJs =(String) map.get("funCode");
		Map<String, Object> funInfoMap = getMetaFunInfo(funCodeJs);
		String primaryValue = (String) map.get("primaryValue");
		String periodData = (String) map.get("periodData");
		String distributeData = (String) map.get("distributeData");
		String quickPanel = (String) map.get("quickPanel");
		String dataSrc = (String) map.get("dataSrc");
		String orgId = (String) map.get("orgId");
		DATA_SRC dataSrcType = DATA_SRC.DISTRIBUTE;
		if (DATA_SRC.TRANSFER.toString().equals(dataSrc)) {
			dataSrcType = DATA_SRC.TRANSFER;
		} else if (DATA_SRC.CLAIM.toString().equals(dataSrc)) {
			dataSrcType = DATA_SRC.CLAIM;
		} else if (DATA_SRC.IMPORT.toString().equals(dataSrc)) {
			dataSrcType = DATA_SRC.IMPORT;
		}
		boolean isQuick = "true".equals(quickPanel);
		JSONArray primaryValueArray = JSONArray.fromObject(primaryValue);
		JSONArray periodDataArray = JSONArray.fromObject(periodData);
		JSONObject distributeDataJson = JSONObject.fromObject(distributeData);
		Boolean flag = saveDataSer(funInfoMap, primaryValueArray, periodDataArray, distributeDataJson, isQuick,
					dataSrcType,orgId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		WFStratDto stratDto = new WFStratDto();
		for (Map<String, Object> instanceMap : getInstanceList()) {
			Map<String, Object> paramMap = (Map<String, Object>) instanceMap.get("paramMap");
			String bizSeqNo = (String) instanceMap.get("instanceId");
			resultMap.put("paramMap", paramMap);
			resultMap.put("bizSeqNo", bizSeqNo);
			resultMap.put("applType", DistributionConstants.WF_SIGN);
			stratDto.setBizId(bizSeqNo);
			stratDto.setBizType(this.workFlow(funInfoMap));
			stratDto.setSystemId("yusp");
			stratDto.setOrgId(orgId);
			stratDto.setUserId(userInfoService.getUserInfo().getLoginCode());
			stratDto.setParam(paramMap);
			stratDto.setBizParam1(funCodeJs);
			runEchain4(stratDto);
		}
		
		resultMap.put("flag", flag);
		return resultMap;

	}
	/**
	 * @函数名称:runEchain4
	 * @函数描述:线程执行方法
	 * @参数与返回说明:
	 * @算法描述:
	 * 1、流程发起，原接口/api/core/start
	 */
	@SuppressWarnings("unused")
	public void runEchain4(WFStratDto stratDto) {
		//1、流程发起，原接口/api/core/start
		ResultInstanceDto instanceInfo = workflowEngineService.start(stratDto);
	}
    /**
     * 数据保存控制
     * @param map
     * @param primaryValueArray2
     * @param newPeriodJsonArray
     * @param distributeDataJson2
     * @param b
     * @param transfer
     * @param orgId 
     * @param funCodeJs 
     * @return
     * @throws Exception
     */
	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> saveDataTransEchain4(Map<String,Object> map, JSONArray primaryValueArray2, JSONArray newPeriodJsonArray, 
			JSONObject distributeDataJson2, boolean b, DATA_SRC transfer, String orgId, String funCodeJs) throws Exception {
		Boolean flag = saveDataSer(map, primaryValueArray2, newPeriodJsonArray, distributeDataJson2, b,
				transfer,orgId);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		WFStratDto stratDto = new WFStratDto();
		for (Map<String, Object> instanceMap : getInstanceList()) {
			Map<String, Object> paramMap = (Map<String, Object>) instanceMap.get("paramMap");
			String bizSeqNo = (String) instanceMap.get("instanceId");
			resultMap.put("paramMap", paramMap);
			resultMap.put("bizSeqNo", bizSeqNo);
			resultMap.put("applType", DistributionConstants.WF_SIGN);
			stratDto.setBizId(bizSeqNo);
			stratDto.setBizType(this.workFlow(map));
			stratDto.setSystemId("yusp");
			stratDto.setOrgId(orgId);
			stratDto.setUserId(userInfoService.getUserInfo().getLoginCode());
			stratDto.setParam(paramMap);
			stratDto.setBizParam1(funCodeJs);
			runEchain4(stratDto);
		}
		resultMap.put("flag", flag);
		return resultMap;

	}
	/**
	 * @函数名称:checkApplType
	 * @函数描述:校验申请类型是否配置正确
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public ResultDto<?> checkApplType(WfInitDTO dto) {
		String wfSign = joinCoreService.queryWfSignByBiz(dto.getApplType(), dto.getSessionOrgCode(), dto.getSessionInstuCde());
		if (wfSign == null) {
			ResultDto<?> resultDTO = new ResultDto<Object>();
			resultDTO.setCode(1);
			resultDTO.setMessage("当前申请类型[" + dto.getApplType() + "]未配置适用业务，或者配置了多条业务但与机构[" + dto.getSessionOrgCode() + "]未关联");
			return resultDTO;
		} else {
			ResultDto<?> resultDTO = new ResultDto<Object>();
			resultDTO.setCode(0);
			resultDTO.setMessage(wfSign);
			return resultDTO;
		}
	}
	/**
	 * 保存业绩分配
	 * 个人客户新增开户机构
	 * @param funInfoMap
	 * @param primaryValueArray
	 * @param periodDataArray
	 * @param distributeDataJson
	 * @param isQuick 是否快速/单区间 分配面板
	 * @param dataSrc 
	 * @param orgId 
	 * @param openOrgId 开户机构
	 * @throws Exception
	 * @return resultMap
	 */
	@SuppressWarnings("unchecked")
	public Boolean saveDataSer(Map<String, Object> funInfoMap,
		JSONArray primaryValueArray, JSONArray periodDataArray,JSONObject distributeDataJson,
		boolean isQuick, DATA_SRC dataSrc, String orgId) throws Exception {
		Map<String, Object> resultMap = prepareSaveData(funInfoMap, primaryValueArray,
				periodDataArray, distributeDataJson, isQuick, dataSrc,orgId);
		// 待执行的sql列表
		List<String> sqlList = (List<String>) resultMap.get("sqlList");
		List<String> insertSqlList = (List<String>) resultMap.get("insertSqlList");
		List<String> updateSqlList = (List<String>) resultMap.get("updateSqlList");
		List<String> deleteSqlList = (List<String>) resultMap.get("deleteSqlList");
		Boolean flag = (Boolean) resultMap.get("vioUniqueKeyFlag");
		if(!flag) {
//			for (String sql : sqlList) {
//				jdbcTemplate.batchUpdate(sql);
//			}
			for (String sql : deleteSqlList) {	// 此处针对不需要审批的数据，先删除P、D表数据，之后在insert中在新增P、D表数据
				commonPerformanceImpMapper.executeDeleteSql(sql);
			}
			for (String sql : insertSqlList) {
				commonPerformanceImpMapper.executeInsertSql(sql);
			}
			for (String sql : updateSqlList) {
				commonPerformanceImpMapper.executeUpdateSql(sql);
			}
		}
		return  flag;
	}
	/**
	 * 生成入库的SQL列表,并返回结果集; 单线程执行确保initTableInfo查询到的信息缓存不错乱
	 * @param funInfoMap
	 * @param primaryValueArray
	 * @param periodDataArray
	 * @param distributeDataJson
	 * @param isQuick
	 * @param dataSrc
	 * @param orgId 
	 * @return
	 * @throws Exception
	 */
	private synchronized Map<String, Object> prepareSaveData(Map<String, Object> funInfoMap,
			JSONArray primaryValueArray, JSONArray periodDataArray,JSONObject distributeDataJson, 
			boolean isQuick, DATA_SRC dataSrc, String orgId) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		AdminBaseMetaFunReg regInfoMap = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
		String funCode = regInfoMap.getFunCode();
		initTableInfo(funInfoMap);
		boolean ned =isNeedApply();
		Boolean vioUniqueKeyFlag = false;  //IS_AMT
		resultMap.put("needApply", ned);
		// 审批状态值
		String applySts = DistributionConstants.APPLY_APPROVED;
		if (ned) {
			applySts = DistributionConstants.UNDER_APPROVAL;
			getInstanceList().clear();
		}
		// 待执行的sql列表
		List<String> sqlList = new ArrayList<String>();
		List<String> insertSqlList = new ArrayList<String>();
		List<String> updateSqlList = new ArrayList<String>();
		List<String> deleteSqlList = new ArrayList<String>();
		/** 第一层循环:分配客户/账号/流水号等 */
		for (int i = 0; i < primaryValueArray.size(); i++) {
			JSONObject primaryValueJson = primaryValueArray.getJSONObject(i);
			// 分配主键值
			StringBuilder pkValue = new StringBuilder();
			for (String pkString : getPkList()) {
				pkValue.append(",'");
				pkValue.append(primaryValueJson.getString(lineToHump(pkString)));
				pkValue.append("'");
			}
			if (ned) {
				//20210512根据总行管理员角色判断不走工作流
				//20210519新加两个角色号不走工作流
				String roleCode = userInfoService.getUserInfo().getRoles().get(0).getCode();
				if("RC011".equals(roleCode)||"RC010".equals(roleCode)||"RC014".equals(roleCode)) {
					ned = false;
					applySts = DistributionConstants.APPLY_APPROVED;
				} else {
					List<String> amtList = getDstrAmtKey(funInfoMap);
					if(funCode.equals("DepPubDstr")||funCode.equals("ComLoanDstr")||funCode.equals("ComFncDstr")) {
						System.out.println("金额字段："+amtList.get(0)+"  值："+primaryValueJson.getString(lineToHump(amtList.get(0))));
						BigDecimal amt = new BigDecimal(primaryValueJson.getString(lineToHump(amtList.get(0))));
						BigDecimal amtTwo = new BigDecimal(5000000);
						if(amt.compareTo(amtTwo)==-1) {
							ned = false;
							applySts = DistributionConstants.APPLY_APPROVED;
						}else{
							ned = true;
							applySts = DistributionConstants.UNDER_APPROVAL;
						}
					}
					if(funCode.equals("PerDepDstr")||funCode.equals("PerLoanDstr")||funCode.equals("PerFncDstr")) {
						System.out.println("金额字段："+amtList.get(0)+"  值："+primaryValueJson.getString(lineToHump(amtList.get(0))));
						BigDecimal amt = new BigDecimal(primaryValueJson.getString(lineToHump(amtList.get(0))));
						BigDecimal amtTwo = new BigDecimal(1000000);
						if(amt.compareTo(amtTwo)==-1) {
							ned = false;
							applySts = DistributionConstants.APPLY_APPROVED;
						}else{
							ned = true;
							applySts = DistributionConstants.UNDER_APPROVAL;
						}
					}
				}
			}
			
			if (ned) {
			/**
			 * 插入互斥表
			 */
			 AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");	// 获取  业绩批量导入互斥表表名
				String mutexTableName = "";
				StringBuilder insertmutex = new StringBuilder(); 
				String pkSe = "";
				for (String pk : getPkList()) {
					pkSe = ","+pk;
				}
				
		        if(mutexTableInfo != null) {
			        try {
						UNIDProducer uuid = new UNIDProducer(); // 生成唯一的流程实例号
						String uuidStr = uuid.getUNID();// 工作流ID
			        	mutexTableName = mutexTableInfo.getTableName();
				        insertmutex.append("INSERT INTO ");
				        insertmutex.append(mutexTableName);
				        insertmutex.append("(ID,TYPE_CODE,CREATE_TIME,BATCH_ID,CREATE_USER");
				        insertmutex.append(pkSe);
						if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
							insertmutex.append(",ACCT_ORG_ID)VALUES(");
						}else {
							insertmutex.append(")VALUES(");
						}
				        
				        insertmutex.append("'"+uuidStr+"','2',sysDate,'"+uuidStr+"','"+userInfoService.getUserInfo().getLoginCode()+"'");
				        insertmutex.append(pkValue);
						if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
							insertmutex.append(",'"+orgId+"')");
						}else {
							insertmutex.append(")");
						}
				        this.commonDistributionMapper.executeInsertSql(insertmutex.toString());
			        } 
			        catch (DataAccessException e) {
			        	e.printStackTrace();
			        	if(e.getCause().getMessage() != null && e.getCause().getMessage().indexOf("ORA-00001") >= 0) {	// 判断是 违反唯一约束条件
			        		vioUniqueKeyFlag = true;
			        	} else {
			        		throw e;
			        	}
			        }
			        
		        }else {
		        	throw new Exception("业绩业务互斥表表名名获取失败，请查询对应业务配置");
		        }
			}
			if (!ned) {
				/** 删除关系生效表 */
				StringBuilder deleteDistribute = new StringBuilder();
				deleteDistribute.append("DELETE FROM ");
				deleteDistribute.append(getDistributeTableName());
				deleteDistribute.append(" A WHERE EXISTS (SELECT 1 FROM ");
				deleteDistribute.append(getPeriodTableName());
				deleteDistribute.append(" B WHERE A.PERIOD_ID=B.ID ");
				for (String pkString : getPkList()) {
					deleteDistribute.append("and ");
					deleteDistribute.append(pkString);
					deleteDistribute.append(" = '");
					deleteDistribute.append(primaryValueJson.getString(lineToHump(pkString)));
					deleteDistribute.append("' ");
				}
				if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
					deleteDistribute.append(" AND   B.ACCT_ORG_ID='"+orgId+"'");
				}
				deleteDistribute.append(")");
				/** 加入执行队列 */
//				sqlList.add(deleteDistribute.toString());
				deleteSqlList.add(deleteDistribute.toString());
				/** 删除区间生效表 */
				StringBuilder deletePeriod = new StringBuilder();
				deletePeriod.append("DELETE FROM ");
				deletePeriod.append(getPeriodTableName());
				deletePeriod.append(" WHERE 1=1 ");
				for (String pkString : getPkList()) {
					deletePeriod.append("AND ");
					deletePeriod.append(pkString);
					deletePeriod.append(" = '");
					deletePeriod.append(primaryValueJson.getString(lineToHump(pkString)));
					deletePeriod.append("' ");
				}
				if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
					deletePeriod.append(" AND   ACCT_ORG_ID='"+orgId+"'");
				}
				/** 加入执行队列 */
//				sqlList.add(deletePeriod.toString());
				deleteSqlList.add(deletePeriod.toString());
			}
			String instanceId = "";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 操作时间戳
			String operateTime = format.format(new Date(System.currentTimeMillis()));
			if (ned) { // 发起流程
				// 当前登陆角色编码
//				String role = user.getRoles().get(0).getCode().toString();
				Map<String, Object> paramMap = new HashMap<String, Object>(); // 流程参数
				paramMap.put("funCode", getRegInfo().getFunCode());// 
				paramMap.put("unitid", userInfoService.getGrantOrgCode()); // 机构号
				String interOrg = primaryValueJson.getString("interOrg"); // 跨机构
				String interBranch = primaryValueJson.getString("interDept"); // 是否跨分行
				String virtualDstr = primaryValueJson.getString("virtualDstr"); // 虚拟行员分配
				paramMap.put("interOrg", interOrg); // 跨机构
				paramMap.put("interBranch", interBranch); // 是否跨分行
				paramMap.put("virtualDstr", virtualDstr); // 虚拟行员分配
				paramMap.put("orgId", orgId);//业绩归属机构
				/** 放入额外参数 */
				for (String echainParam : getEchainParamList()) {
					paramMap.put(echainParam, primaryValueJson.getString(this.lineToHump(echainParam)));
				}
				UNIDProducer unid = new UNIDProducer(); // 生成唯一的流程实例号
				instanceId = unid.getUNID();// 工作流ID
				paramMap.put("bizSeqNo", instanceId); // 虚拟行员分配
				// 保存流程信息,待发起
				Map<String, Object> instanceMap = new HashMap<String, Object>();
				instanceMap.put("pkValue", pkValue.toString());
				instanceMap.put("operateTime", operateTime);
				instanceMap.put("paramMap", paramMap);
				instanceMap.put("instanceId", instanceId);
				getInstanceList().add(instanceMap);
			}
			/** 单区间分配时,查询period表,将原有区间拼到periodDataArray中 */
			JSONArray periodDataArrayCopy = new JSONArray();
			periodDataArrayCopy.addAll(periodDataArray);
			/** 第二层循环:分配区间遍历 */
			for (int j = 0; j < periodDataArrayCopy.size(); j++) {
				JSONObject periodDataJson = periodDataArrayCopy.getJSONObject(j);
				// 插入period表的值
				StringBuilder insertPeriodValue = new StringBuilder();
				insertPeriodValue.append("'");
				insertPeriodValue.append(periodDataJson.get("effectDate").toString().replace("-", "")).append("',");
				insertPeriodValue.append("'");
				insertPeriodValue.append(periodDataJson.get("expirateDate").toString().replace("-", "")).append("',");
				insertPeriodValue.append("'").append(operateTime).append("',");
				insertPeriodValue.append("'").append(userInfoService.getGrantOrgCode()).append("',");
				insertPeriodValue.append("'").append(userInfoService.getUserInfo().getLoginCode()).append("',");
				insertPeriodValue.append("'").append(dataSrc.toString()).append("','");
				// 主键序列
				UNIDProducer unid = new UNIDProducer(); // 生成唯一的流程实例号
				String nextSeq = unid.getUNID();
				insertPeriodValue.append(nextSeq);
				insertPeriodValue.append("'");
				insertPeriodValue.append(pkValue);
				JSONArray distributeDataJsonNew =  JSONArray.fromObject(periodDataJson.get("list"));
						/** 第三层循环:该分配区间下的分配关系 */
						for (int k = 0; k < distributeDataJsonNew.size(); k++) {
							JSONObject distributeJson = distributeDataJsonNew.getJSONObject(k);
							// 插入distribute表的值
							StringBuilder insertDistributeValue = new StringBuilder();
							insertDistributeValue.append("sys_guid(),'");
							insertDistributeValue.append(nextSeq).append("',");
							try {
								insertDistributeValue.append(distributeJson.getString("distrRate"));
								insertDistributeValue.append(",");
							} catch (Exception e) {
								insertDistributeValue.append("null").append(",");
							}
							insertDistributeValue.append("'");
							insertDistributeValue.append(distributeJson.getString("managerId"));
							insertDistributeValue.append("',");
							insertDistributeValue.append("'");
							try {
								/**
								 * 修改内容 : 由于allotType可能会出现null, 但出现null会把null当成字符串处理, 导致数据库2个长度装不下null的4个长度,所以报错
								 * 修改人: xujiawei1 2016.5.13
								 */
								String allotType = "01";
								if (null == allotType || "null".equals(allotType)) {
									throw new Exception();
								}
								insertDistributeValue.append(allotType);
								insertDistributeValue.append("'");
							} catch (Exception e) {
								insertDistributeValue.append("'");
							}
							if (getDistributeColumnList().indexOf("START_AMT") > -1) {
								try {
									insertDistributeValue.append(",");
									insertDistributeValue.append(distributeJson.getString("startAmt"));
									insertDistributeValue.append(",");
								} catch (Exception e) {
									insertDistributeValue.append("null").append(",");
								}
								try {
									insertDistributeValue.append(distributeJson.getString("endAmt"));
								} catch (Exception e) {
									insertDistributeValue.append("null");
								}
							}
							if (getDistributeColumnList().indexOf("PERF_RATE") > -1) {
								insertDistributeValue.append(",");
								try {
									insertDistributeValue.append(distributeJson.getString("perfRate"));
								} catch (Exception e) {
									insertDistributeValue.append("null");
								}
							}
							if (getDistributeColumnList().indexOf("HOST_CFG") > -1) {
								insertDistributeValue.append(",'");
								try {
									insertDistributeValue.append(distributeJson.getString("hostCfg"));
								} catch (Exception e) {
								}
								insertDistributeValue.append("'");
							}
							/** 插入distributeHis表的sql */
							StringBuilder insertDistributeHisSql = new StringBuilder();
							insertDistributeHisSql.append("insert into ");
							insertDistributeHisSql.append(getDistributeHisTableName());
							insertDistributeHisSql.append("(");
							insertDistributeHisSql.append(getInsertDistributeColumn());
							insertDistributeHisSql.append(") VALUES(");
							insertDistributeHisSql.append(insertDistributeValue);
							insertDistributeHisSql.append(")");
							/** 加入执行队列 */
//							sqlList.add(insertDistributeHisSql.toString());
							insertSqlList.add(insertDistributeHisSql.toString());
							/** 不需审批则插入distribute表 */
							if (!ned) {
								/** 插入distribute表的sql */
								StringBuilder insertDistributeSql = new StringBuilder();
								insertDistributeSql.append("insert into ");
								insertDistributeSql.append(getDistributeTableName());
								insertDistributeSql.append("(");
								insertDistributeSql.append(getInsertDistributeColumn());
								insertDistributeSql.append(") VALUES(");
								insertDistributeSql.append(insertDistributeValue);
								insertDistributeSql.append(")");
								/** 加入执行队列 */
//								sqlList.add(insertDistributeSql.toString());
								insertSqlList.add(insertDistributeSql.toString());
							}
						}
				/** 判断该区间下是否有分配关系 */
				/** 插入periodHis表的sql */
				StringBuilder insertPeriodHisSql = new StringBuilder();
				insertPeriodHisSql.append("INSERT INTO ");
				insertPeriodHisSql.append(getPeriodHisTableName());
				insertPeriodHisSql.append("(");
				insertPeriodHisSql.append(getInsertPeriodColumn());
				if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
					insertPeriodHisSql.append(",APPLY_STS,APPLY_TIME,APPLY_ID,ACCT_ORG_ID,APPLY_VERSION) VALUES(");
				}else {
					insertPeriodHisSql.append(",APPLY_STS,APPLY_TIME,APPLY_ID,APPLY_VERSION) VALUES(");
				}
				insertPeriodHisSql.append(insertPeriodValue);
				insertPeriodHisSql.append(",'");
				insertPeriodHisSql.append(applySts);
				insertPeriodHisSql.append("','");
				insertPeriodHisSql.append(operateTime);
				insertPeriodHisSql.append("','");
				insertPeriodHisSql.append(instanceId);
				if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
					insertPeriodHisSql.append("','"+orgId+"','0')");
				}else {
					insertPeriodHisSql.append("','0')");
				}
				
				/** 加入执行队列 */
//				sqlList.add(insertPeriodHisSql.toString());
				insertSqlList.add(insertPeriodHisSql.toString());
				
				/** 不需审批则插入period表 */
				if (!ned) {
					/** 插入periodHIs表的版本号 */
					StringBuilder updatePeriodhisVersionSql = new StringBuilder();
					updatePeriodhisVersionSql.append("UPDATE ");
					updatePeriodhisVersionSql.append(getPeriodHisTableName());
					updatePeriodhisVersionSql.append(" SET APPLY_VERSION = '1' ");
					updatePeriodhisVersionSql.append(" WHERE APPLY_VERSION = '0'AND APPLY_STS = '"+applySts+"' AND APPLY_ID <> '"+instanceId+"'");
//					sqlList.add(updatePeriodhisVersionSql.toString());
					updateSqlList.add(updatePeriodhisVersionSql.toString());
					/** 插入period表的sql */
					StringBuilder insertPeriodSql = new StringBuilder();
					insertPeriodSql.append("INSERT INTO ");
					insertPeriodSql.append(getPeriodTableName());
					insertPeriodSql.append("(");
					insertPeriodSql.append(getInsertPeriodColumn());
					if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
						insertPeriodSql.append(",ACCT_ORG_ID) VALUES(");
					}else {
						insertPeriodSql.append(") VALUES(");
						
					}
					insertPeriodSql.append(insertPeriodValue);
					if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")){
						insertPeriodSql.append(",'"+orgId+"')");
					}else {
						insertPeriodSql.append(")");
					}
					/** 加入执行队列 */
//					sqlList.add(insertPeriodSql.toString());
					insertSqlList.add(insertPeriodSql.toString());
				}
			}
		}
		resultMap.put("sqlList", sqlList);
		resultMap.put("insertSqlList", insertSqlList);
		resultMap.put("updateSqlList", updateSqlList);
		resultMap.put("deleteSqlList", deleteSqlList);
		resultMap.put("vioUniqueKeyFlag", vioUniqueKeyFlag);
		return resultMap;
	}
    /**
     * 获取业务功能注册中的配置信息
     * @param funCodeJs
     * @return
     * @throws Exception
     */
	public Map<String, Object> getMetaFunInfo(String funCodeJs) throws Exception {
		return metaFunctionManagerService.getMetaFunInfo(funCodeJs);
	}
	/**
	 * <pre>
	 * 功能描述: 获取该笔业绩分配业务的相关表信息
	 * Title: initTableInfo 
	 * author: xujiawei
	 * param funInfoMap
	 * </pre>
	 */
	public synchronized void initTableInfo(Map<String, Object> funInfoMap) {
		// 业务注册信息
		setRegInfo((AdminBaseMetaFunReg) funInfoMap.get("regInfo"));
		// 业务子类型
		setInfoTableInfo(getTableMap(funInfoMap, FUN_SUB_TYPE.INFO));
		setPeriodHisTableInfo(getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS));
		setDistributeHisTableInfo(getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE_HIS));
		setPeriodTableInfo(getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD));
		setDistributeTableInfo(getTableMap(funInfoMap, FUN_SUB_TYPE.DISTRIBUTE));
		setInfoTableName(getInfoTableInfo().get("tableName"));
		setPeriodHisTableName(getPeriodHisTableInfo().get("tableName"));
		setDistributeHisTableName(getDistributeHisTableInfo().get("tableName"));
		setPeriodTableName(getPeriodTableInfo().get("tableName"));
		setDistributeTableName(getDistributeTableInfo().get("tableName"));
		setNeedApply(needApply(funInfoMap));
		setPkList(getDstrPrimaryKey(funInfoMap));
		setEchainParamList(getEchainParam(funInfoMap));
		initTableColumn(funInfoMap);
	}
	/**
	 * <pre>
	 * 功能描述: 初始化区间表和关系表的字段
	 * &#64;Title: initTableColumn 
	 * &#64;author: xujiawei
	 * &#64;param funInfoMap
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public void initTableColumn(Map<String, Object> funInfoMap) {
		Map<String, String> pageCfgMap = (Map<String, String>) funInfoMap.get("pageCfgInfo");
		setPeriodColumnList(new ArrayList<String>());
		
		setDistributeColumnList(new ArrayList<String>());
		getPeriodColumnList().addAll(DistributionConstants.PERIOD_COLUMN_LIST);
		getPeriodColumnList().addAll(getPkList());
		getDistributeColumnList().addAll(DistributionConstants.DISTRIBUTE_COLUMN_LIST);
		if (!DistributionConstants.YES.equals(pageCfgMap.get("HAS_JXBL"))) {
			getDistributeColumnList().remove(getDistributeColumnList().indexOf("PERF_RATE"));
		}
		if (!"2".equals(pageCfgMap.get("DSTR_TYPE"))) { // 分配类型:1,比例分配; 3,比例+定额
			getDistributeColumnList().remove(getDistributeColumnList().indexOf("START_AMT"));
			getDistributeColumnList().remove(getDistributeColumnList().indexOf("END_AMT"));
		}
		if (!DistributionConstants.YES.equals(pageCfgMap.get("HOST_CFG"))) {
			getDistributeColumnList().remove(getDistributeColumnList().indexOf("HOST_CFG"));
		}
		setInsertPeriodColumn(listToString(getPeriodColumnList()));
		setInsertDistributeColumn(listToString(getDistributeColumnList()));
	}
	/**
	 * <pre>
	 * 功能描述: 分配流程审批驳回回调方法
	 * &#64;Title: reject 
	 * &#64;author: xujiawei
	 * &#64;param vo
	 * &#64;throws Exception    
	 * &#64;return: void
	 * </pre>
	 * @return 
	 */
	public ResultDto<String> reject(Map<String, Object> map) throws Exception {
//		/** 待执行的sql列表 */
//		List<String> sqlList = prepareReject(map);
//		// 批量执行sql
//		for (String sql : sqlList) {
//			jdbcTemplate.batchUpdate(sql);
//		}
//		 ResultDto<String> result = new ResultDto<String>();
//         result.setMessage("处理成功");
//         result.setCode(0);
//         return result;
 		Map<String, List<String>> resultMap = prepareReject(map);
 		List<String> updateSqlList = resultMap.get("updateSqlList");
 		List<String> deleteSqlList = resultMap.get("deleteSqlList");
 		// 批量执行sql
 		for (String sql : updateSqlList) {
 			commonPerformanceImpMapper.executeUpdateSql(sql);
 		}
 		for (String sql : deleteSqlList) {
 			commonPerformanceImpMapper.executeDeleteSql(sql);
 		}
 		ResultDto<String> result = new ResultDto<String>();
 		result.setMessage("处理成功");
 		result.setCode(0);
        return result;
	}
	/**
	 * <pre>
	 * 功能描述: 审批通过
	 * &#64;Title: pass 
	 * &#64;author: xujiawei
	 * &#64;param vo
	 * </pre>
	 */
	public void pass(Map<String, Object> map) throws Exception {
		/** 待执行的sql列表 */
		List<String> sqlList = preparePass(map);
		for (String sql : sqlList) {
			jdbcTemplate.batchUpdate(sql);
		}
	}
	/**
	 * <pre>
	 * 功能描述:分配流程审批通过回调方法, 单线程防止缓存错乱
	 * &#64;Title: preparePass 
	 * &#64;author: xujiawei
	 * &#64;param vo
	 * &#64;return: List<String>
	 * </pre>
	 * @throws Exception 
	 */
	private synchronized List<String> preparePass(Map<String, Object> map) throws Exception {
		// 业务功能编码
		String funCode = (String) map.get("funCode");
		Map<String, Object> funInfoMap = getMetaFunInfo(funCode);
		initTableInfo(funInfoMap);
		String instanceId = (String) map.get("bizSeqNo");
		/** 待执行的sql列表 */
		List<String> sqlList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder("");
		/** 删除生效的区间period记录和有改动的关系distribute记录 */
		sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(getDistributeTableName());
		sb.append(" C WHERE EXISTS (SELECT 1 FROM " + getPeriodTableName());
		sb.append(" A WHERE EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
		sb.append(" B WHERE B.APPLY_ID = '" + instanceId + "'");
		for (String pkCol : getPkList()) {
			sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
		}
		if("custDstr".equals(funCode)){
			sb.append(" AND  A.OPER_ORG_ID=B.Oper_Org_Id");
		}
		sb.append(") AND C.PERIOD_ID=A.ID)");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		sb = new StringBuilder();
		sb.append("delete from " + getPeriodTableName());
		sb.append(" A WHERE EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
		sb.append(" B WHERE B.APPLY_ID = '" + instanceId + "'");
		for (String pkCol : getPkList()) {
			sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
		}
		if("custDstr".equals(funCode)){
			sb.append(" AND  A.OPER_ORG_ID=B.Oper_Org_Id");
		}
		sb.append(")");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		/** 从操作历史表将记录写入到生效表 */
		sb = new StringBuilder();
		sb.append("INSERT INTO " + getPeriodTableName() + "(" + getInsertPeriodColumn());
		sb.append(") SELECT " + getInsertPeriodColumn());
		sb.append(" FROM " + getPeriodHisTableName());
		sb.append(" WHERE APPLY_ID = '" + instanceId + "'");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		sb = new StringBuilder();
		sb.append("INSERT INTO " + getDistributeTableName() + "(");
		sb.append(getInsertDistributeColumn() + ") SELECT " + getInsertDistributeColumn());
		sb.append(" FROM " + getDistributeHisTableName());
		sb.append(" WHERE PERIOD_ID IN (SELECT ID ");
		sb.append(" FROM " + getPeriodHisTableName());
		sb.append(" WHERE APPLY_ID = '");
		sb.append(instanceId + "')");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		/** 更新申请表(历史表)中对应实例的审批状态字段 */
		sb = new StringBuilder("");
		sb.append("UPDATE ").append(getPeriodHisTableName());
		sb.append(" SET APPLY_STS = '");
		sb.append(DistributionConstants.APPLY_APPROVED);
		sb.append("' WHERE APPLY_ID = '").append(instanceId).append("'");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		/** 更新申请表(历史表)中对应实例的APPLY_VERSION字段 */
		sb = new StringBuilder("");
		sb.append("UPDATE ").append(getPeriodHisTableName());
		sb.append(" SET APPLY_VERSION = '1'");
//		sb.append(" WHERE APPLY_VERSION = '0' AND APPLY_STS = '"+DistributionConstants.APPLY_APPROVED+"' AND APPLY_ID <> '").append(instanceId).append("'");
		sb.append(" WHERE APPLY_VERSION = '0' AND APPLY_ID <> '").append(instanceId).append("'");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		/** 更新业务信息表中分配状态字段 */
		sb = new StringBuilder();
		sb.append("UPDATE ").append(getInfoTableName()).append(" A SET A.DSTR_STS = '");
		sb.append(DistributionConstants.DISTRIBUTED);
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append("' WHERE 1=1 ");
		}else {
			sb.append("' WHERE 1=1 and A.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
		}
		sb.append(" AND EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
		sb.append(" B WHERE B.APPLY_ID = '" + instanceId + "'");
		for (String pkCol : getPkList()) {
			sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
		}
		sb.append(")");
		sqlList.add(sb.toString());
		/**
		 * 插入互斥表
		 */
		AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");	// 获取  业绩批量导入互斥表表名
		String mutexTableName = "";
	    if(mutexTableInfo != null) {
		    mutexTableName = mutexTableInfo.getTableName();
		    sb = new StringBuilder();
		    sb.append("DELETE FROM ");
		    sb.append(mutexTableName);
		    sb.append(" A WHERE EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
		    sb.append(" B WHERE B.APPLY_ID = '" + instanceId + "'");
		    for (String pkCol : getPkList()) {
		    		sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
		    	}
		    sb.append(") ");
		    /** 加入执行队列 */
		    sqlList.add(sb.toString());
	     }else {
	        throw new Exception("业绩业务互斥表表名名获取失败，请查询对应业务配置");
	     }
		/** 加入执行队列 */
		return sqlList;
	}
	/**
	 * <pre>
	 * 功能描述: 分配流程审批驳回回调方法,单线程防止缓存错乱
	 * &#64;Title: prepareReject 
	 * &#64;author: xujiawei
	 * &#64;param vo
	 * &#64;return: List<String>
	 * </pre>
	 * @throws Exception 
	 */
	private synchronized Map<String, List<String>> prepareReject(Map<String, Object> map) throws Exception {
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		// 业务功能编码
		JSONArray mapList =  JSONArray.fromObject(map.get("list"));
		String funCode = mapList.getJSONObject(0).getString("funCode");
		Map<String, Object> funInfoMap = getMetaFunInfo(funCode);
		initTableInfo(funInfoMap);
		List<String> sqlList = new ArrayList<String>();
		List<String> updateSqlList = new ArrayList<String>();
		List<String> deleteSqlList = new ArrayList<String>();
		for (int i = 0; i < mapList.size(); i++) {
            String instanceId = mapList.getJSONObject(i).getString("instanceId");
    		String bizId = mapList.getJSONObject(i).getString("bizId");
    		/**删除工作流实例*/
    		this.delInstance(instanceId);
    		/** 待执行的sql列表 */
    		
    		/** 更新申请表(历史表)中对应实例的审批状态字段 */
    		StringBuilder sb = new StringBuilder("");
    		sb.append("UPDATE ").append(getPeriodHisTableName());
    		sb.append(" SET APPLY_STS = '");
    		sb.append(DistributionConstants.APPLY_REJECTED);
    		sb.append("' WHERE APPLY_ID = '").append(bizId).append("'");
    		/** 加入执行队列 */
//    		sqlList.add(sb.toString());
    		updateSqlList.add(sb.toString());
    		/** 更新申请表(历史表)中对应实例的APPLY_VERSION字段 */
    		sb = new StringBuilder("");
    		sb.append("UPDATE ").append(getPeriodHisTableName());
    		sb.append(" SET APPLY_VERSION = '1'");
    		sb.append(" WHERE APPLY_VERSION = '0' AND APPLY_STS = '"+DistributionConstants.APPLY_REJECTED+"' AND APPLY_ID <> '").append(bizId).append("'");
    		/** 加入执行队列 */
//    		sqlList.add(sb.toString());
    		updateSqlList.add(sb.toString());
    		/** 更新业务信息表中分配状态字段 */
    		sb = new StringBuilder();
    		sb.append("UPDATE ").append(getInfoTableName()).append(" A SET A.DSTR_STS = '");
    		sb.append(DistributionConstants.UNDISTRIBUTED);
    		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
    			sb.append("' WHERE 1=1 ");
    		}else {
    			sb.append("' WHERE 1=1 and A.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
    		}
    		sb.append(" AND EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
    		sb.append(" B WHERE B.APPLY_ID = '" + bizId + "'");
    		for (String pkCol : getPkList()) {
    			sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
    		}
    		sb.append(")");
//    		sqlList.add(sb.toString());
    		updateSqlList.add(sb.toString());
    		/**
    		 * 插入互斥表
    		 */
    		AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");	// 获取  业绩批量导入互斥表表名
    		String mutexTableName = "";
    	    if(mutexTableInfo != null) {
    		    mutexTableName = mutexTableInfo.getTableName();
    		    sb = new StringBuilder();
    		    sb.append("DELETE FROM ");
    		    sb.append(mutexTableName);
    		    sb.append(" A WHERE EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
    		    sb.append(" B WHERE B.APPLY_ID = '" + bizId + "'");
    		    for (String pkCol : getPkList()) {
    		    		sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
    		    	}
    		    sb.append(") ");
    		    /** 加入执行队列 */
//    		    sqlList.add(sb.toString());
    		    deleteSqlList.add(sb.toString());
    	     }else {
    	        throw new Exception("业绩业务互斥表表名名获取失败，请查询对应业务配置");
    	     }
		}
		
		resultMap.put("updateSqlList", updateSqlList);
		resultMap.put("deleteSqlList", deleteSqlList);
		return resultMap;
	}
	/**
	 * 功能描述: 删除工作流实例
	 * &#64;Title: delInstance 
	 * &#64;author: xujiawei
	 * &#64;param instanceId
	 */
	public void delInstance(String instanceId) {
		workflowEngineExtService.delete(instanceId);
	}
	/**
	 * <pre>
	 * 功能描述: 分配流程审批驳回回调方法,单线程防止缓存错乱
	 * &#64;Title: prepareReject 
	 * &#64;author: xujiawei
	 * &#64;param vo
	 * &#64;return: List<String>
	 * </pre>
	 * @throws Exception 
	 */
	private synchronized List<String> rejectDel(String funCode , String instanceId) throws Exception {
		// 业务功能编码
//		String funCode = (String) vo.paramMap.get("funCode");
		Map<String, Object> funInfoMap = getMetaFunInfo(funCode);
		initTableInfo(funInfoMap);
		this.delInstance(instanceId);
//		String instanceId = (String) vo.paramMap.get("bizSeqNo");
		/** 待执行的sql列表 */
		List<String> sqlList = new ArrayList<String>();
		/** 更新申请表(历史表)中对应实例的审批状态字段 */
		StringBuilder sb = new StringBuilder("");
		sb.append("UPDATE ").append(getPeriodHisTableName());
		sb.append(" SET APPLY_STS = '");
		sb.append(DistributionConstants.APPLY_REJECTED);
		sb.append("' WHERE APPLY_ID = '").append(instanceId).append("'");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		/** 更新申请表(历史表)中对应实例的APPLY_VERSION字段 */
		sb = new StringBuilder("");
		sb.append("UPDATE ").append(getPeriodHisTableName());
		sb.append(" SET APPLY_VERSION = '1'");
		sb.append(" WHERE APPLY_VERSION = '0' AND APPLY_STS = '"+DistributionConstants.APPLY_REJECTED+"' AND APPLY_ID <> '").append(instanceId).append("'");
		/** 加入执行队列 */
		sqlList.add(sb.toString());
		/** 更新业务信息表中分配状态字段 */
		sb = new StringBuilder();
		sb.append("UPDATE ").append(getInfoTableName()).append(" A SET A.DSTR_STS = '");
		sb.append(DistributionConstants.UNDISTRIBUTED);
		if(funCode.equals("ComCustDstr")||funCode.equals("PerCustDstr")) {
			sb.append("' WHERE 1=1 ");
		}else {
			sb.append("' WHERE 1=1 and A.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA')");
		}
		sb.append(" AND EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
		sb.append(" B WHERE B.APPLY_ID = '" + instanceId + "'");
		for (String pkCol : getPkList()) {
			sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
		}
		sb.append(")");
		sqlList.add(sb.toString());
		/**
		 * 插入互斥表
		 */
		AdminBaseMetaFunTable mutexTableInfo = metaFunctionManagerService.queryFunTableInfo(funCode, "08");	// 获取  业绩批量导入互斥表表名
		String mutexTableName = "";
	    if(mutexTableInfo != null) {
		    mutexTableName = mutexTableInfo.getTableName();
		    sb = new StringBuilder();
		    sb.append("DELETE FROM ");
		    sb.append(mutexTableName);
		    sb.append(" A WHERE EXISTS (SELECT 1 FROM " + getPeriodHisTableName());
		    sb.append(" B WHERE B.APPLY_ID = '" + instanceId + "'");
		    for (String pkCol : getPkList()) {
		    		sb.append(" AND A.").append(pkCol).append("=B.").append(pkCol);
		    	}
		    sb.append(") ");
		    /** 加入执行队列 */
		    sqlList.add(sb.toString());
	     }else {
	        throw new Exception("业绩业务互斥表表名名获取失败，请查询对应业务配置");
	     }
		return sqlList;
	}
	/**
	 * <pre>
	 * 功能描述: 解析集合 list -> String; [a,b,c]->"a,b,c"
	 * &#64;Title: listToString 
	 * &#64;author: xujiawei
	 * &#64;param list 
	 * &#64;return: String
	 * </pre>
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
	 * @方法名称: getImportFunInfo
	 * @方法描述: 获取业绩批量导入的业务类型列表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public List<AdminBaseMetaFunReg> getImportFunInfo() throws Exception {
		List<AdminBaseMetaFunReg> list = metaFunctionManagerService.getFunInfoByCfg("DO_IMORT", DistributionConstants.YES);
		return sortFunInfoList(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: getImportFunInfo
	 * @方法描述: 获取业绩批量导入的业务类型列表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public List<AdminBaseMetaFunReg> getClaimFunInfo() throws Exception {
		List<AdminBaseMetaFunReg> list = metaFunctionManagerService.getFunInfoByCfg("DO_CLAIM", DistributionConstants.YES);
		return sortFunInfoList(list);
	}
	/**
	 * @方法名称: sortFunInfoList
	 * @方法描述: 业务编码列表  数据排序
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	private List<AdminBaseMetaFunReg> sortFunInfoList(List<AdminBaseMetaFunReg> list) {
		final String[] sortStr = { "对公存款规模分配", "对公存款绩效分配", "个人存款规模分配", "个人存款绩效分配", "对公贷款规模分配", "对公贷款利润分配", "个人贷款规模分配",
				"个人贷款利润分配", "企业网银分配", "个人网银分配", "手机银行分配", "短信银行分配", "普通商户分配", "助农取款点分配", "ATM自助设备分配", "第三方支付分配",
				"聚合支付分配", "银行卡分配" }; // "客户"要的顺序列
		Map<String, AdminBaseMetaFunReg> data = new HashMap<String, AdminBaseMetaFunReg>();

		for (AdminBaseMetaFunReg map : list) {
			if (map == null)
				continue;
			data.put(map.getFunName(), map);
		}
		List<AdminBaseMetaFunReg> tempL = new ArrayList<AdminBaseMetaFunReg>();
		for (String str : sortStr) {
			AdminBaseMetaFunReg tem = data.remove(str);
			list.remove(tem);
			if(tem != null)
				tempL.add(tem);
		}
		for (AdminBaseMetaFunReg map : list) {
			if(map != null)
				tempL.add(map);
		}
		//  查询当前业绩分配最小分配日期（即业绩分配可以选择的最早日期,即查询最后跑批结束时间）， 后续增加代码
//		Map<String, String> distribtionTime=new Map<String, String>();
//		distribtionTime.put("distribtionTime", dstrService.getCurrentDstrTime());
//		tempL.add(distribtionTime);
		return tempL;
	}
	
	/**
	 * @方法名称: getDstrPrimaryKey
	 * @方法描述: 获取分配主键字段名称
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public List<String> getDstrPrimaryKey(Map<String, Object> funInfoMap) {
		List<String> pkList = new ArrayList<String>();
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(infoTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && DistributionConstants.YES.equals(cfgMap.get("IS_PK"))) {
				pkList.add(columnMap.get(columnCode).get("columnName").toString());
			}
		}
		return pkList;
	}
	/**
	 * @方法名称: getDstrPrimaryKey
	 * @方法描述: 获取分配主键字段名称
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public List<String> getDstrAmtKey(Map<String, Object> funInfoMap) {
		List<String> pkList = new ArrayList<String>();
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(infoTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && DistributionConstants.YES.equals(cfgMap.get("IS_AMT"))) {
				pkList.add(columnMap.get(columnCode).get("columnName").toString());
			}
		}
		return pkList;
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
	 * @方法名称: getPageCfgValue
	 * @方法描述: 获取指定配置项的值
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public String getPageCfgValue(Map<String, Object> funInfoMap, String cfgName) {
		Map<String, String> pageCfgMap = (Map<String, String>) funInfoMap.get("pageCfgInfo");
		return pageCfgMap.get(cfgName);
	}
	
	/**
	 * @方法名称: getOrgColumnInfo
	 * @方法描述: 获取机构字段的信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOrgColumnInfo(Map<String, Object> funInfoMap) {
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(infoTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && DistributionConstants.YES.equals(cfgMap.get("IS_ORG"))) {
				return columnMap.get(columnCode);
			}
		}
		return null;
	}
	
	/**
	 * @方法名称: getDepColumnInfo
	 * @方法描述: 获取条线字段的信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDepColumnInfo(Map<String, Object> funInfoMap) {
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(infoTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && DistributionConstants.YES.equals(cfgMap.get("IS_DEP"))) {
				return columnMap.get(columnCode);
			}
		}
		return null;
	}
	
	/**
	 * @方法名称: getPkLookupCfg
	 * @方法描述: 获取分配主键的分配数据字典和导入数据字典
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPkLookupCfg(Map<String, Object> funInfoMap) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(infoTableCode);
		// 业务功能编码
		String funCode = ((AdminBaseMetaFunReg) funInfoMap.get("regInfo")).getFunCode();
		if (columnMap == null) {
			throw new YuspException("500", "业务编码:[" + funCode + "]字段信息缺失");
		}
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			String columnName = columnMap.get(columnCode).get("columnName") + "";
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && DistributionConstants.YES.equals(cfgMap.get("IS_PK"))) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("dstrLookupName", cfgMap.get("LOOKUP_ID"));
				map.put("impLookupName", cfgMap.get("IMP_LOOKUP_ID"));
				retMap.put(columnName, map);
			}
		}
		return retMap;
	}
	
	/**
	 * @方法名称: getColumnLookupCfg
	 * @方法描述: 获取分配字段的分配数据字典和导入数据字典
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getColumnLookupCfg(Map<String, Object> funInfoMap) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(infoTableCode);
		// 业务功能编码
		String funCode = ((AdminBaseMetaFunReg) funInfoMap.get("regInfo")).getFunCode();
		if (columnMap == null) {
			throw new YuspException("500", "业务编码:[" + funCode + "]字段信息缺失");
		}
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			String columnName = columnMap.get(columnCode).get("columnName") + "";
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && 
					((cfgMap.get("LOOKUP_ID") != null && StringUtil.isNotEmpty(cfgMap.get("LOOKUP_ID") + "")) || 
					 (cfgMap.get("IMP_LOOKUP_ID") != null && StringUtil.isNotEmpty(cfgMap.get("IMP_LOOKUP_ID") + "")
					)
				)) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("dstrLookupName", cfgMap.get("LOOKUP_ID"));
				map.put("impLookupName", cfgMap.get("IMP_LOOKUP_ID"));
				retMap.put(columnName, map);
			}
		}
		return retMap;
	}
	
	/**
	 * <pre>
	 * 功能描述: 判断是否需要审批
	 * &#64;Title: needApply 
	 * &#64;author: xujiawei
	 * &#64;param funInfoMap
	 * &#64;return: boolean
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public boolean needApply(Map<String, Object> funInfoMap) {
		Map<String, String> pageCfgInfo = (Map<String, String>) funInfoMap.get("pageCfgInfo");
		if (DistributionConstants.YES.equals(pageCfgInfo.get("NEED_APPLY"))) {
			return true;
		}
		return false;
	}
	/**
	 * <pre>
	 * 功能描述: 判断是否需要审批
	 * &#64;Title: needApply 
	 * &#64;author: xujiawei
	 * &#64;param funInfoMap
	 * &#64;return: boolean
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public String workFlow(Map<String, Object> funInfoMap) {
		Map<String, String> pageCfgInfo = (Map<String, String>) funInfoMap.get("pageCfgInfo");
		if (DistributionConstants.YES.equals(pageCfgInfo.get("NEED_APPLY"))) {
			return pageCfgInfo.get("WORKFLOW");
		}
		return null;
	}
	/**
	 * <pre>
	 * 功能描述: 判断是否虚拟行员分配
	 * &#64;Title: virtualDstr  
	 * &#64;param funInfoMap
	 * &#64;return: boolean
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public Boolean virtualDstr(Map<String, Object> funInfoMap) {
		Map<String, String> pageCfgInfo = (Map<String, String>) funInfoMap.get("pageCfgInfo");
		if (DistributionConstants.YES.equals(pageCfgInfo.get("VIRTUAL_DSTR"))) {
			return true;
		}
		return false;
	}
	
	/**
	 * <pre>
	 * 功能描述: 获取工作流额外参数字段名称
	 * &#64;Title: getEchainParam 
	 * &#64;author: xujiawei
	 * &#64;param funInfoMap
	 * &#64;return: List<String>
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public List<String> getEchainParam(Map<String, Object> funInfoMap) {
		List<String> echainParamList = new ArrayList<String>();
		Map<String, String> tableMap = getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap
				.get(infoTableCode);
		// 业务功能编码
		AdminBaseMetaFunReg regInfoMap = (AdminBaseMetaFunReg) funInfoMap.get("regInfo");
		String funCode = regInfoMap.getFunCode();
		if (columnMap == null) {
			throw new YuspException("500", "业务编码:[" + funCode + "]字段信息缺失");
		}
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && DistributionConstants.YES.equals(cfgMap.get("ECHAIN_PARAM"))) {
				echainParamList.add(columnMap.get(columnCode).get("columnName").toString());
			}
		}
		return echainParamList;
	}
	/**
	 * 下划线转驼峰
	 * @param str
	 * @return
	 */
    public  String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    
    /**
	 * @方法名称: HumpToUnderline
	 * @方法描述: 驼峰转下划线(大写)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    public static String HumpToUnderline(String para) {
		StringBuilder sb = new StringBuilder(para);
		int temp = 0;// 定位
		if (!para.contains("_")) {
			for (int i = 0; i < para.length(); i++) {
				if (Character.isUpperCase(para.charAt(i))) {
					sb.insert(i + temp, "_");
					temp += 1;
				}
			}
		}
		return sb.toString().toUpperCase();
	}
    /**
	 * @方法名称: queryEtlState
	 * @方法描述: 查询跑批状态表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public Map<String, Object> queryEtlState() {
		Map<String, Object> map = commonDistributionMapper.queryEtlState();
		return map;
	}
    /**
	 * @方法名称: queryTimeState
	 * @方法描述: 查询定版日
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public Map<String, Object> queryTimeState() {
		Map<String, Object> map =  commonDistributionMapper.queryTimeState();
		return map;
	}
	  /**
     * @throws Exception 
     * @方法名称: approve
     * @方法描述: 审批接口
     * @参数与返回说明: 
     * @算法描述: String instanceId,String nodeId,String userId, String commentSign,String userComment
     */
    public ResultDto<String> approveEchain4(Map<String, Object> map) throws Exception {
        String instanceId = "";
        String nodeId = "";
        String userId = "";
        String commentSign = (String) map.get("commentSign");
        String userComment = (String) map.get("commentContent");
        String list = (String) map.get("list");
        Boolean userExist = false;
        JSONArray primaryListArray = JSONArray.fromObject(list);
        for (int i = 0; i < primaryListArray.size(); i++) {
            JSONObject primaryValueJson = primaryListArray.getJSONObject(i);
            nodeId = primaryValueJson.getString("nodeId");
            instanceId = primaryValueJson.getString("instanceId");
            userId = primaryValueJson.getString("userId");
            this.runEchain4Next(instanceId, nodeId, userId, commentSign, userComment);
        }
        ResultDto<String> result = new ResultDto<String>();
        if(userExist) {
            result.setMessage("未查询到下一节点审批人！");
            result.setCode(1);
        }else {
            result.setMessage("处理成功");
            result.setCode(0);
        }

        return result;

    }
	  /**
     * @throws Exception 
     * @方法名称: approve
     * @方法描述: 审批接口
     * @参数与返回说明: 
     * @算法描述: String instanceId,String nodeId,String userId, String commentSign,String userComment
     */
    public ResultDto<String> refuseEchain4(Map<String, Object> map) throws Exception {
        String instanceId = "";
        String nodeId = "";
        String userId = "";
        String commentSign = (String) map.get("commentSign");
        String userComment = (String) map.get("commentContent");
        String list = (String) map.get("list");
        Boolean userExist = false;
        JSONArray primaryListArray = JSONArray.fromObject(list);
        for (int i = 0; i < primaryListArray.size(); i++) {
            JSONObject primaryValueJson = primaryListArray.getJSONObject(i);
            nodeId = primaryValueJson.getString("nodeId");
            instanceId = primaryValueJson.getString("instanceId");
            userId = primaryValueJson.getString("userId");
            this.runEchain4RefuseNext(instanceId, nodeId, commentSign, userComment);
        }
        ResultDto<String> result = new ResultDto<String>();
        if(userExist) {
            result.setMessage("未查询到下一节点审批人！");
            result.setCode(1);
        }else {
            result.setMessage("处理成功");
            result.setCode(0);
        }

        return result;

    }
    /**
     * @函数名称:runEchain4Next
     * @函数描述:线程执行方法
     * @参数与返回说明:
     * @算法描述:
     * 1、流程发起，原接口/api/core/start
     * 2、获取实例信息，原接口/api/core/instanceInfo
     * 3、保存流程意见，原接口/api/core/saveComment
     * 4、获取下一节点，原接口/api/core/getNextNodeInfos
     * 5、获取下一节点审批人，原接口/api/core/getNodeUsers
     * 6、提交，原接口/api/core/submit
     * *** TODO 事务存在不一致性，即 当4/5发生异常，123不会回滚；考虑到4/5很少会出现问题，所以本次不修改
     * *** 由于 4/5中，处理了同一批量导入主表，所以使用同步代码块synchronized
     */
    @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
    public void runEchain4Next(String instanceId,String nodeId,String userId, String commentSign,String userComment) {
        //2、获取实例信息，原接口/api/core/instanceInfo
        ResultInstanceDto instanceInfo = workflowEngineService.getInstanceInfo(instanceId,nodeId,userId);
        //3、保存流程意见，原接口/api/core/saveComment
        WFCommentDto wfCommentDto = new WFCommentDto();
        wfCommentDto.setCommentSign(commentSign);
        wfCommentDto.setUserComment(userComment);
        wfCommentDto.setUserId(userId);
        wfCommentDto.setInstanceId(instanceInfo.getInstanceId());
        wfCommentDto.setNodeId(instanceInfo.getNodeId());
        ResultCommentDto resultCommentDto = workflowEngineService.saveComment(wfCommentDto);
        //4、获取下一节点，原接口/api/core/wfGetNextNodes
        List<ResultNodeDto> resultNodeDto = workflowEngineService.getNextNodeInfos(instanceInfo.getInstanceId(), instanceInfo.getNodeId());
        List<NextNodeInfoDto> nextNodes = getWFNextNodeInfos(instanceInfo, instanceInfo.getNodeId());
        //5、获取下一节点审批人，原接口/api/core/getNodeUsers
        NWfInstance nWfInstance = instanceService.selectByPrimaryKey(instanceInfo.getInstanceId());
        List<WFUserDto> wfUserDto = workflowEngineService.getNodeUsers(nWfInstance.getInstanceId(), instanceInfo.getNodeId(),instanceInfo.getOrgId(),instanceInfo.getSystemId());
        //6、提交，原接口/api/core/submit
        Map maps = (Map)JSON.parse(instanceInfo.getFlowParam());  
        WFSubmitDto wfSubmitDto = new WFSubmitDto();
        wfSubmitDto.setComment(wfCommentDto);
        wfSubmitDto.setParam(maps);
        wfSubmitDto.setOrgId(instanceInfo.getOrgId());
        wfSubmitDto.setNextNodeInfos(nextNodes);
        List<ResultMessageDto>  resultMessageDto = workflowEngineService.submit(wfSubmitDto);
    }
    /**
     * @函数名称:runEchain4RefuseNext
     * @函数描述:线程执行方法
     * @参数与返回说明:
     * @算法描述:
     * 1、退回，原接口/api/core/returnBack
     */
    public void runEchain4RefuseNext(String instanceId,String nodeId, String commentSign,String userComment) {
//    	WFReturnDto paramDto = new WFReturnDto();
//    	paramDto.setOrgId(userInfoService.getGrantOrgCode());
//    	WFCommentDto commentDto = new WFCommentDto();
//    	commentDto.setCommentSign(commentSign);
//    	commentDto.setInstanceId(instanceId);
//    	commentDto.setUserId(userInfoService.getUserInfo().getLoginCode());
//    	commentDto.setNodeId(nodeId);
//    	paramDto.setComment(commentDto);
//    	workflowEngineExtService.returnBack(paramDto);
    	/**
    	 * 删除流程实例
    	 */
    	workflowEngineExtService.delete(instanceId);
    	
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private List<NextNodeInfoDto> getWFNextNodeInfos(ResultInstanceDto instanceInfo, String nodeId)
      {
        NodeInfo nodeInfo = engineInfo.getNodeInfo(nodeId);
        String nodeScript = nodeInfo.getNodeScript();
        if ((!WorkFlowUtil.isNullOrEmpty(nodeScript)) && (!nodeScript.equals("0"))) {
          if (nodeScript.equals("NodeScriptTxtImpl"))
          {
            try
            {
              OelFactory.getInstance().getJavaScriptInstance(nodeInfo.getNodeScriptTxt()).execute(instanceInfo);
            }
            catch (Exception e)
            {
              log.debug("执行节点脚本异常 :" + instanceInfo);
              e.printStackTrace();
            }
          }
          else
          {
            StudioNodeScriptInterface nodeScriptBean = (StudioNodeScriptInterface)ApplicationContextUtil.getBean(nodeScript);
            nodeScriptBean.run(instanceInfo);
          }
        }
        List<NodeInfo> nodeInfos = new ArrayList();
        String nodeIdT;
        for (Iterator localIterator = nodeInfo.getNextNodes().iterator(); localIterator.hasNext();)
        {
          nodeIdT = (String)localIterator.next();
          NodeInfo nodeInfoT = engineInfo.getNodeInfo(nodeIdT);
          nodeInfos.add(nodeInfoT);
        }
        
        if (log.isDebugEnabled()) {
          log.debug("获取节点条数:" + nodeInfos.size());
        }
        List<RouteInfo> routes = nodeInfo.getRouteInfos();
        if (null != routes) {
          for (RouteInfo route : routes) {
            if (!WorkFlowUtil.isNullOrEmpty(route.getIsContinueBeanId()))
            {
              String nextNodeId = route.getNextNodeId();
              if (!runRoute(instanceInfo, nextNodeId, route.getIsContinueBeanId(), route.getRouteScriptTxt()))
              {
                NodeInfo nodeInfoT = engineInfo.getNodeInfo(nextNodeId);
                nodeInfos.remove(nodeInfoT);
                if (log.isDebugEnabled()) {
                  log.debug("节点路由返回false,去除此节点:" + nextNodeId);
                }
              }
            }
          }
        }
        if (log.isDebugEnabled()) {
          log.debug("过滤剩余条数:" + nodeInfos.size());
        }
        List<NextNodeInfoDto> data = new ArrayList();
        for (NodeInfo nextNodeInfo : nodeInfos)
        {
          NextNodeInfoDto nextNodeInfoDto = new NextNodeInfoDto();
          nextNodeInfoDto.setNextNodeId(nextNodeInfo.getNodeId());
          nextNodeInfoDto.setNextNodeUserIds(WorkFlowUtil.splitNodeUser(nextNodeInfo.getNodeUser()));
          data.add(nextNodeInfoDto);
        }
        return data;
      }
    private boolean runRoute(ResultInstanceDto instanceInfo, String nextNodeId, String isContinueBeanId, String scriptText)
    {
      return routeService.run(instanceInfo, nextNodeId, isContinueBeanId, scriptText);
    }
}
