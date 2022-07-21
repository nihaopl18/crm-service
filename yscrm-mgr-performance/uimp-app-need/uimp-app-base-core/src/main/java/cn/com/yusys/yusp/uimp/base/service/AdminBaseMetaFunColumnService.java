package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.admin.service.MessageProviderService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import cn.com.yusys.yusp.uimp.base.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunColumn;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunColumnCfg;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseMetaFunColumnCfgMapper;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseMetaFunColumnMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunColumnService
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
public class AdminBaseMetaFunColumnService extends CommonService {
    @Autowired
    private AdminBaseMetaFunColumnMapper adminBaseMetaFunColumnMapper;
    
    @Autowired
    private AdminBaseMetaFunPageCfgService adminBaseMetaFunPageCfgService;
    
    @Autowired
    private AdminBaseMetaFunColumnCfgMapper  adminBaseMetaFunColumnCfgMapper;
    
    @Autowired
    private MessageProviderService messageProviderService;

    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseMetaFunColumnMapper;
    }
    
    
    /**
	 * @方法名称: initPeriodColumn
	 * @方法描述: 初始化区间表字段
	 * @参数与返回说明:
	 * 	@param tableCode
	 *	@param isHis 是否是历史表
	 * @算法描述:
	 */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public List<AdminBaseMetaFunColumn> initPeriodColumn(String tableCode, boolean isHis) throws Exception {
    	List<AdminBaseMetaFunColumn> cList = new ArrayList<AdminBaseMetaFunColumn>();
    	//删除column
    	this.adminBaseMetaFunColumnMapper.delFunColumnByTableCode(tableCode);
    	int columnSequnce = 1;
    	cList.add(new AdminBaseMetaFunColumn("主键", "ID", DistributionConstants.COLUMN_TYPE_STRING,32,tableCode,generateColumnCode(tableCode, columnSequnce++),0));
    	cList.add(new AdminBaseMetaFunColumn("起始日期", "EFFECT_DATE", DistributionConstants.COLUMN_TYPE_STRING, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),1));
    	cList.add(new AdminBaseMetaFunColumn("结束日期", "EXPIRATE_DATE", DistributionConstants.COLUMN_TYPE_STRING, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),2));
    	cList.add(new AdminBaseMetaFunColumn("操作用户号", "OPER_USER_ID", DistributionConstants.COLUMN_TYPE_STRING, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),3));
		cList.add(new AdminBaseMetaFunColumn("操作机构号", "OPER_ORG_ID", DistributionConstants.COLUMN_TYPE_STRING, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),4));
		cList.add(new AdminBaseMetaFunColumn("分配时间", "OPER_TIME", DistributionConstants.COLUMN_TYPE_STRING, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),6));
		cList.add(new AdminBaseMetaFunColumn("数据来源", "DATA_SRC", DistributionConstants.COLUMN_TYPE_STRING, 2, tableCode, generateColumnCode(tableCode, columnSequnce++),7));
		if (isHis) {
			cList.add(new AdminBaseMetaFunColumn("审批编号", "APPLY_ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),8));
			cList.add(new AdminBaseMetaFunColumn("审批状态", "APPLY_STS", DistributionConstants.COLUMN_TYPE_STRING, 2, tableCode, generateColumnCode(tableCode, columnSequnce++),9));
			cList.add(new AdminBaseMetaFunColumn("审批时间", "APPLY_TIME", DistributionConstants.COLUMN_TYPE_STRING, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),10));
		}
		return cList;
    }
    
    /**
	 * @方法名称: initDistributeColumn
	 * @方法描述: 初始化关系表字段
	 * @参数与返回说明:
	 * 	@param tableCode
	 *	@param isHis isHis是否是历史表,暂未使用
	 * @算法描述:
	 */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public List<AdminBaseMetaFunColumn> initDistributeColumn(String tableCode,boolean isHis, String funCode) throws Exception {
    	Map<String, Object> pageCfgMap = adminBaseMetaFunPageCfgService.queryPageCfg(funCode);
    	if (pageCfgMap == null || pageCfgMap.size()==0) {
    		throw new YuspException(messageProviderService.getMessage("300001"));
    	}
    	List<AdminBaseMetaFunColumn> cList = new ArrayList<AdminBaseMetaFunColumn>();
    	//删除column
    	this.adminBaseMetaFunColumnMapper.delFunColumnByTableCode(tableCode);
    	int columnSequnce = 1;
    	cList.add(new AdminBaseMetaFunColumn("主键", "ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),0));
    	cList.add(new AdminBaseMetaFunColumn("区间主键", "PERIOD_ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),1));
		cList.add(new AdminBaseMetaFunColumn("客户经理编号", "MANAGER_ID", DistributionConstants.COLUMN_TYPE_STRING, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),2));
		cList.add(new AdminBaseMetaFunColumn("分配类型", "ALLOT_TYPE", DistributionConstants.COLUMN_TYPE_STRING, 2, tableCode, generateColumnCode(tableCode, columnSequnce++),3));
		cList.add(new AdminBaseMetaFunColumn("业绩比例", "DISTR_RATE", DistributionConstants.COLUMN_TYPE_NUMBER, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),4));
		if ("2".equals(pageCfgMap.get("DSTR_TYPE"))) { // 分配类型:1,比例分配; 3,比例+定额
			cList.add(new AdminBaseMetaFunColumn("起始金额", "START_AMT", DistributionConstants.COLUMN_TYPE_NUMBER, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),5));
			cList.add(new AdminBaseMetaFunColumn("结束金额", "END_AMT", DistributionConstants.COLUMN_TYPE_NUMBER, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),6));
		}
    	return cList;
    }
    
    private String generateColumnCode(String tableCode, int seq) {
		StringBuffer sb = new StringBuffer();
		sb.append(tableCode).append("_");
		if (seq < 10) {
			sb.append("00");
		} else if (seq < 100) {
			sb.append("0");
		}
		sb.append(seq);
		return sb.toString();
	}
    
    /**
	 * @方法名称: initTable
	 * @方法描述: 初始化表信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void initTable(String tableCode, String funSubType, String funCode) throws Exception{
		List<AdminBaseMetaFunColumn> columnList = new ArrayList<AdminBaseMetaFunColumn>();
		if (DistributionConstants.FUN_SUB_TYPE_PERIOD.equals(funSubType)) {
			columnList = this.initPeriodColumn(tableCode, false);
		} else if (DistributionConstants.FUN_SUB_TYPE_PERIOD_HIS.equals(funSubType)) {
			columnList = this.initPeriodColumn(tableCode, true);
		} else if (DistributionConstants.FUN_SUB_TYPE_DISTRIBUTE.equals(funSubType)) {
			columnList = this.initDistributeColumn(tableCode, false, funCode);
		} else if (DistributionConstants.FUN_SUB_TYPE_DISTRIBUTE_HIS.equals(funSubType)) {
			columnList = this.initDistributeColumn(tableCode, true, funCode);
		} else if (DistributionConstants.FUN_SUB_TYPE_INFO.equals(funSubType)) {
			columnList = initInfoColumn(tableCode);
		} else if (DistributionConstants.FUN_SUB_TYPE_IMP_DTL.equals(funSubType)) {
			columnList = this.initImpDTLColumn(tableCode, funCode);
		} else if (DistributionConstants.FUN_SUB_TYPE_IMP_CHECK.equals(funSubType)) {
			columnList = this.initImpCheckColumn(tableCode, funCode);
		} else if (DistributionConstants.FUN_SUB_TYPE_PRI_KEY.equals(funSubType)) {
			columnList = this.initPriKeyColumn(tableCode, funCode);
		}
		saveFunColumn(columnList);
	}
    
    /**
	 * @方法名称: initImpDTLColumn
	 * @方法描述: 初始化关系表字段
	 * @参数与返回说明:
	 * 	@param tableCode
	 *	@param funCode
	 * @算法描述:
	 */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public List<AdminBaseMetaFunColumn> initImpDTLColumn(String tableCode, String funCode) throws Exception {
    	Map<String, Object> pageCfgMap = adminBaseMetaFunPageCfgService.queryPageCfg(funCode);
    	if (pageCfgMap == null || pageCfgMap.size()==0) {
    		throw new YuspException(messageProviderService.getMessage("300001"));
    	}
    	List<AdminBaseMetaFunColumn> cList = new ArrayList<AdminBaseMetaFunColumn>();
		//删除column
    	this.adminBaseMetaFunColumnMapper.delFunColumnByTableCode(tableCode);
    	int columnSequnce = 1;
    	cList.add(new AdminBaseMetaFunColumn("主键", "ID", DistributionConstants.COLUMN_TYPE_STRING,32,tableCode,generateColumnCode(tableCode, columnSequnce++),0));
    	cList.add(new AdminBaseMetaFunColumn("批次编号", "BATCH_ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),1));
    	cList.add(new AdminBaseMetaFunColumn("客户归属机构", "OPER_ORG_ID", DistributionConstants.COLUMN_TYPE_STRING, 100, tableCode, generateColumnCode(tableCode, columnSequnce++),2));
		cList.add(new AdminBaseMetaFunColumn("客户经理编号", "MANAGER_ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),3));
		cList.add(new AdminBaseMetaFunColumn("客户经理名称", "MANAGER_NAME", DistributionConstants.COLUMN_TYPE_STRING, 100, tableCode, generateColumnCode(tableCode, columnSequnce++),4));
		cList.add(new AdminBaseMetaFunColumn("生效日期", "EFFECT_DATE", DistributionConstants.COLUMN_TYPE_STRING, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),5));
		cList.add(new AdminBaseMetaFunColumn("失效日期", "EXPIRATE_DATE", DistributionConstants.COLUMN_TYPE_STRING, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),6));
		cList.add(new AdminBaseMetaFunColumn("起始金额", "START_AMT", DistributionConstants.COLUMN_TYPE_NUMBER, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),7));
		cList.add(new AdminBaseMetaFunColumn("结束金额", "END_AMT", DistributionConstants.COLUMN_TYPE_NUMBER, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),8));
		cList.add(new AdminBaseMetaFunColumn("业绩分配比例", "DISTR_RATE", DistributionConstants.COLUMN_TYPE_NUMBER, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),9));
    	return cList;
    }
    
    /**
	 * @方法名称: initImpCheckColumn
	 * @方法描述: 初始化批量导入校验表字段
	 * @参数与返回说明:
	 * 	@param tableCode
	 *	@param funCode
	 * @算法描述:
	 */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public List<AdminBaseMetaFunColumn> initImpCheckColumn(String tableCode, String funCode) throws Exception {
    	Map<String, Object> pageCfgMap = adminBaseMetaFunPageCfgService.queryPageCfg(funCode);
    	if (pageCfgMap == null || pageCfgMap.size()==0) {
    		throw new YuspException(messageProviderService.getMessage("300001"));
    	}
    	List<AdminBaseMetaFunColumn> cList = new ArrayList<AdminBaseMetaFunColumn>();
		//删除column
    	this.adminBaseMetaFunColumnMapper.delFunColumnByTableCode(tableCode);
    	int columnSequnce = 1;
    	cList.add(new AdminBaseMetaFunColumn("主键", "ID", DistributionConstants.COLUMN_TYPE_STRING,32,tableCode,generateColumnCode(tableCode, columnSequnce++),0));
    	cList.add(new AdminBaseMetaFunColumn("批次编号", "BATCH_ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),1));
    	cList.add(new AdminBaseMetaFunColumn("客户归属机构", "OPER_ORG_ID", DistributionConstants.COLUMN_TYPE_STRING, 100, tableCode, generateColumnCode(tableCode, columnSequnce++),2));
		cList.add(new AdminBaseMetaFunColumn("客户经理编号", "MANAGER_ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),3));
		cList.add(new AdminBaseMetaFunColumn("客户经理名称", "MANAGER_NAME", DistributionConstants.COLUMN_TYPE_STRING, 100, tableCode, generateColumnCode(tableCode, columnSequnce++),4));
		cList.add(new AdminBaseMetaFunColumn("生效日期", "EFFECT_DATE", DistributionConstants.COLUMN_TYPE_STRING, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),5));
		cList.add(new AdminBaseMetaFunColumn("失效日期", "EXPIRATE_DATE", DistributionConstants.COLUMN_TYPE_STRING, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),6));
		cList.add(new AdminBaseMetaFunColumn("起始金额", "START_AMT", DistributionConstants.COLUMN_TYPE_NUMBER, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),7));
		cList.add(new AdminBaseMetaFunColumn("结束金额", "END_AMT", DistributionConstants.COLUMN_TYPE_NUMBER, 20, tableCode, generateColumnCode(tableCode, columnSequnce++),8));
		cList.add(new AdminBaseMetaFunColumn("业绩分配比例", "DISTR_RATE", DistributionConstants.COLUMN_TYPE_NUMBER, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),9));
    	cList.add(new AdminBaseMetaFunColumn("校验状态", "CHECK_STATE", DistributionConstants.COLUMN_TYPE_STRING, 10, tableCode, generateColumnCode(tableCode, columnSequnce++),10));
    	cList.add(new AdminBaseMetaFunColumn("校验信息", "CHECK_MSG", DistributionConstants.COLUMN_TYPE_STRING, 100, tableCode, generateColumnCode(tableCode, columnSequnce++),11));
    	return cList;
    }
    
    /**
	 * @方法名称: initPriKeyColumn
	 * @方法描述: 初始化分配业务去重表字段
	 * @参数与返回说明:
	 * 	@param tableCode
	 *	@param funCode
	 * @算法描述:
	 */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public List<AdminBaseMetaFunColumn> initPriKeyColumn(String tableCode, String funCode) throws Exception {
    	Map<String, Object> pageCfgMap = adminBaseMetaFunPageCfgService.queryPageCfg(funCode);
    	if (pageCfgMap == null || pageCfgMap.size()==0) {
    		throw new YuspException(messageProviderService.getMessage("300001"));
    	}
    	List<AdminBaseMetaFunColumn> cList = new ArrayList<AdminBaseMetaFunColumn>();
		//删除column
    	this.adminBaseMetaFunColumnMapper.delFunColumnByTableCode(tableCode);
    	int columnSequnce = 1;
    	cList.add(new AdminBaseMetaFunColumn("主键", "ID", DistributionConstants.COLUMN_TYPE_STRING,32,tableCode,generateColumnCode(tableCode, columnSequnce++),0));
    	cList.add(new AdminBaseMetaFunColumn("批次编号", "BATCH_ID", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),1));
    	cList.add(new AdminBaseMetaFunColumn("类型标识", "TYPE_CODE", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),2));
		cList.add(new AdminBaseMetaFunColumn("创建时间", "CREATE_TIME", DistributionConstants.COLUMN_TYPE_DATE, 6, tableCode, generateColumnCode(tableCode, columnSequnce++),3));
		cList.add(new AdminBaseMetaFunColumn("创建人", "CREATE_USER", DistributionConstants.COLUMN_TYPE_STRING, 32, tableCode, generateColumnCode(tableCode, columnSequnce++),4));
    	return cList;
    }
	
	
	/**
	 * @方法名称: saveFunColumn
	 * @方法描述: 保存字段信息和相关配置
	 * @参数与返回说明:
	 * @算法描述:
	 */
	private void saveFunColumn(List<AdminBaseMetaFunColumn> colList) {
		for (AdminBaseMetaFunColumn adminBaseMetaFunColumn : colList) {
			this.adminBaseMetaFunColumnMapper.insertSelective(adminBaseMetaFunColumn);
		}
	}
	
	/**
	 * @方法名称: initInfoColumn
	 * @方法描述: 初始化信息表字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	private List<AdminBaseMetaFunColumn> initInfoColumn(String tableCode) {
		List<AdminBaseMetaFunColumn> cList = new ArrayList<AdminBaseMetaFunColumn>();
		AdminBaseMetaFunColumn column = this.adminBaseMetaFunColumnMapper.queryMetaFunColumn(tableCode, "DSTR_STS");
		if (column == null) {
			int columnSequnce = 1;
			column = new AdminBaseMetaFunColumn("分配状态", "DSTR_STS", DistributionConstants.COLUMN_TYPE_STRING, 2, tableCode, generateColumnCode(tableCode, columnSequnce++), 0);
		}
		cList.add(column);
		//机构号固定列
		AdminBaseMetaFunColumn columnOrg = this.adminBaseMetaFunColumnMapper.queryMetaFunColumn(tableCode, "ORG_ID");
		if (columnOrg == null) {
			int columnSequnce = 2;
			columnOrg = new AdminBaseMetaFunColumn("机构号", "ORG_ID", DistributionConstants.COLUMN_TYPE_STRING, 50, tableCode, generateColumnCode(tableCode, columnSequnce++), 1);
			List<AdminBaseMetaFunColumnCfg> list = new ArrayList<AdminBaseMetaFunColumnCfg>();
			AdminBaseMetaFunColumnCfg cfgObject = new AdminBaseMetaFunColumnCfg();
			cfgObject.setColumnCode(columnOrg.getColumnCode());
			cfgObject.setConfigName("IS_ORG");
			cfgObject.setConfigValue("1");
			list.add(cfgObject);
			AdminBaseMetaFunColumnCfg cfgObject1 = new AdminBaseMetaFunColumnCfg();
			cfgObject1.setColumnCode(columnOrg.getColumnCode());
			cfgObject1.setConfigName("SEARCH_FIELD");
			cfgObject1.setConfigValue("1");
			list.add(cfgObject1);
			AdminBaseMetaFunColumnCfg cfgObject2 = new AdminBaseMetaFunColumnCfg();
			cfgObject2.setColumnCode(columnOrg.getColumnCode());
			cfgObject2.setConfigName("SUB_ORG");
			cfgObject2.setConfigValue("1");
			list.add(cfgObject2);
			AdminBaseMetaFunColumnCfg cfgObject3 = new AdminBaseMetaFunColumnCfg();
			cfgObject3.setColumnCode(columnOrg.getColumnCode());
			cfgObject3.setConfigName("GRID_FIELD");
			cfgObject3.setConfigValue("1");
			list.add(cfgObject3);
			AdminBaseMetaFunColumnCfg cfgObject4 = new AdminBaseMetaFunColumnCfg();
			cfgObject4.setColumnCode(columnOrg.getColumnCode());
			cfgObject4.setConfigName("IMP_GRID_FIELD");
			cfgObject4.setConfigValue("1");
			list.add(cfgObject4);
			AdminBaseMetaFunColumnCfg cfgObject5 = new AdminBaseMetaFunColumnCfg();
			cfgObject5.setColumnCode(columnOrg.getColumnCode());
			cfgObject5.setConfigName("LIKE_SEARCH");
			cfgObject5.setConfigValue("0");
			list.add(cfgObject5);
			AdminBaseMetaFunColumnCfg cfgObject6 = new AdminBaseMetaFunColumnCfg();
			cfgObject6.setColumnCode(columnOrg.getColumnCode());
			cfgObject6.setConfigName("ALLOW_BLANK");
			cfgObject6.setConfigValue("0");
			list.add(cfgObject6);
			AdminBaseMetaFunColumnCfg cfgObject7 = new AdminBaseMetaFunColumnCfg();
			cfgObject7.setColumnCode(columnOrg.getColumnCode());
			cfgObject7.setConfigName("ECHAIN_PARAM");
			cfgObject7.setConfigValue("0");
			list.add(cfgObject7);
			AdminBaseMetaFunColumnCfg cfgObject8 = new AdminBaseMetaFunColumnCfg();
			cfgObject8.setColumnCode(columnOrg.getColumnCode());
			cfgObject8.setConfigName("SEARCH_TYPE");
			cfgObject8.setConfigValue("orgchoose");
			list.add(cfgObject8);
			AdminBaseMetaFunColumnCfg cfgObject9 = new AdminBaseMetaFunColumnCfg();
			cfgObject9.setColumnCode(columnOrg.getColumnCode());
			cfgObject9.setConfigName("RESULT_WIDTH");
			cfgObject9.setConfigValue("120");
			list.add(cfgObject9);
			AdminBaseMetaFunColumnCfg cfgObject10 = new AdminBaseMetaFunColumnCfg();
			cfgObject10.setColumnCode(columnOrg.getColumnCode());
			cfgObject10.setConfigName("IMP_RESULT_WIDTH");
			cfgObject10.setConfigValue("120");
			list.add(cfgObject10);
			AdminBaseMetaFunColumnCfg cfgObject11 = new AdminBaseMetaFunColumnCfg();
			cfgObject11.setColumnCode(columnOrg.getColumnCode());
			cfgObject11.setConfigName("IMP_LIKE_SEARCH");
			cfgObject11.setConfigValue("0");
			list.add(cfgObject11);
			AdminBaseMetaFunColumnCfg cfgObject12 = new AdminBaseMetaFunColumnCfg();
			cfgObject12.setColumnCode(columnOrg.getColumnCode());
			cfgObject12.setConfigName("IMP_ALLOW_BLANK");
			cfgObject12.setConfigValue("1");
			list.add(cfgObject12);
			AdminBaseMetaFunColumnCfg cfgObject13 = new AdminBaseMetaFunColumnCfg();
			cfgObject13.setColumnCode(columnOrg.getColumnCode());
			cfgObject13.setConfigName("IMP_SEARCH_TYPE");
			cfgObject13.setConfigValue("orgchoose");
			list.add(cfgObject13);
			AdminBaseMetaFunColumnCfg cfgObject14 = new AdminBaseMetaFunColumnCfg();
			cfgObject14.setColumnCode(columnOrg.getColumnCode());
			cfgObject14.setConfigName("IMP_SUB_ORG");
			cfgObject14.setConfigValue("1");
			list.add(cfgObject14);
			AdminBaseMetaFunColumnCfg cfgObject15 = new AdminBaseMetaFunColumnCfg();
			cfgObject15.setColumnCode(columnOrg.getColumnCode());
			cfgObject15.setConfigName("CLM_SEARCH_FIELD");
			cfgObject15.setConfigValue("1");
			list.add(cfgObject15);
			AdminBaseMetaFunColumnCfg cfgObject16 = new AdminBaseMetaFunColumnCfg();
			cfgObject16.setColumnCode(columnOrg.getColumnCode());
			cfgObject16.setConfigName("CLM_LIKE_SEARCH");
			cfgObject16.setConfigValue("0");
			list.add(cfgObject16);
			AdminBaseMetaFunColumnCfg cfgObject17 = new AdminBaseMetaFunColumnCfg();
			cfgObject17.setColumnCode(columnOrg.getColumnCode());
			cfgObject17.setConfigName("CLM_ALLOW_BLANK");
			cfgObject17.setConfigValue("1");
			list.add(cfgObject17);
			AdminBaseMetaFunColumnCfg cfgObject18 = new AdminBaseMetaFunColumnCfg();
			cfgObject18.setColumnCode(columnOrg.getColumnCode());
			cfgObject18.setConfigName("CLM_SEARCH_TYPE");
			cfgObject18.setConfigValue("orgchoose");
			list.add(cfgObject18);
			AdminBaseMetaFunColumnCfg cfgObject19 = new AdminBaseMetaFunColumnCfg();
			cfgObject19.setColumnCode(columnOrg.getColumnCode());
			cfgObject19.setConfigName("CLM_SUB_ORG");
			cfgObject19.setConfigValue("1");
			list.add(cfgObject19);
			AdminBaseMetaFunColumnCfg cfgObject20 = new AdminBaseMetaFunColumnCfg();
			cfgObject20.setColumnCode(columnOrg.getColumnCode());
			cfgObject20.setConfigName("IMP_SEARCH_FIELD");
			cfgObject20.setConfigValue("1");
			list.add(cfgObject20);
			AdminBaseMetaFunColumnCfg cfgObject21 = new AdminBaseMetaFunColumnCfg();
			cfgObject21.setColumnCode(columnOrg.getColumnCode());
			cfgObject21.setConfigName("APP_GRID_FIELD");
			cfgObject21.setConfigValue("1");
			list.add(cfgObject21);
			saveFunColumnCfg(list);
		}
		cList.add(columnOrg);
		return cList;
	}
	
	private void saveFunColumnCfg(List<AdminBaseMetaFunColumnCfg> colList) {
		for (AdminBaseMetaFunColumnCfg adminBaseMetaFunColumnCfg : colList) {
			this.adminBaseMetaFunColumnCfgMapper.insertSelective(adminBaseMetaFunColumnCfg);
		}
	}
	
	@Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(String tableCode) {
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnMapper.querylist(tableCode);
		PageHelper.clearPage();
		return list;
	}
	
//	@Cacheable(value = "AdminBaseMetaFunColumn", key = "#tableCode")
	public ConcurrentHashMap<String, Object> getFunColumn(String tableCode) {
		ConcurrentHashMap<String, Object> funColumn = new ConcurrentHashMap<String, Object>();
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnMapper.querylist(tableCode);
		for(Map<String,Object> map : list) {
			ConcurrentHashMap<String, String> columnInfo = new ConcurrentHashMap<String, String>();
			String columnName = String.valueOf(map.get("columnName"));
			String columnCode = String.valueOf(map.get("columnCode"));
			String columnType = String.valueOf(map.get("columnType"));
			String columnCnName = String.valueOf(map.get("columnCnName"));
			String columnLength = String.valueOf(map.get("columnLength"));
			String sort = String.valueOf(map.get("sort"));
			columnInfo.put("columnName", columnName);
			columnInfo.put("columnCode", columnCode);
			columnInfo.put("columnType", columnType);
			columnInfo.put("tableCode", tableCode);
			columnInfo.put("columnCnName", columnCnName);
			columnInfo.put("columnLength", columnLength);
			columnInfo.put("sort", sort);
			funColumn.put(columnCode, columnInfo);
		}
		return funColumn;
	}
	
//	@CachePut(value = "AdminBaseMetaFunColumn", key = "#tableCode")
	public ConcurrentHashMap<String, Object> refreshFunColumn(String tableCode) {
		ConcurrentHashMap<String, Object> funColumn = new ConcurrentHashMap<String, Object>();
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnMapper.querylist(tableCode);
		for(Map<String,Object> map : list) {
			ConcurrentHashMap<String, String> columnInfo = new ConcurrentHashMap<String, String>();
			String columnName = String.valueOf(map.get("columnName"));
			String columnCode = String.valueOf(map.get("columnCode"));
			String columnType = String.valueOf(map.get("columnType"));
			String columnCnName = String.valueOf(map.get("columnCnName"));
			String columnLength = String.valueOf(map.get("columnLength"));
			String sort = String.valueOf(map.get("sort"));
			columnInfo.put("columnName", columnName);
			columnInfo.put("columnCode", columnCode);
			columnInfo.put("columnType", columnType);
			columnInfo.put("tableCode", tableCode);
			columnInfo.put("columnCnName", columnCnName);
			columnInfo.put("columnLength", columnLength);
			columnInfo.put("sort", sort);
			funColumn.put(columnCode, columnInfo);
		}
		return funColumn;
	}
	
}
