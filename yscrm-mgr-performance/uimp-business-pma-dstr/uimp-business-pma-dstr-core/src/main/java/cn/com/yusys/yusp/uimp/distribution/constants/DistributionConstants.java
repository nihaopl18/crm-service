package cn.com.yusys.yusp.uimp.distribution.constants;

import java.util.Arrays;
import java.util.List;

public class DistributionConstants {
	
	public final static String YES = "1";
	public final static String NO = "0";
	
	public final static String QUERY_DB2_SEQUENCE = "select ID_SEQUENCE.nextval from SYSIBM.DUAL";
	public final static String QUERY_ORACLE_SEQUENCE = "select ID_SEQUENCE.nextval from DUAL";
	
	/**
	 * 业绩分配审批流程ID
	 */
	public static final String DR_APPLY_WF_ID = "10";
	
	/**
	 * 批量导入审批流程标识
	 */
	public static final String WF_SIGN = "dstrNew";
	
	/**
	 * 审批通过节点
	 */
	public static final String ADOPT_POINT = "38_e6";
	/**
	 * 审批驳回节点
	 */
	public static final String REJECT_POINT = "38_e8";
	
	/**
	 * 审批状态
	 */
	public static final String UNDER_APPROVAL = "11";	// 正在审批
	public static final String APPLY_APPROVED = "12";	// 审批通过
	public static final String APPLY_REJECTED = "13";	// 审批驳回
	public static final String APPLY_EXCEPTION = "21";	// 审批异常
	public static final String AUTO_APPROVED = "15";	// 自动分配
	
	
	/**
	 * 分配状态
	 */
	public static final String DISTRIBUTED = "01";	// 已分配
	public static final String UNDISTRIBUTED = "02";	// 未分配
	public static final String TO_APPROVE = "03";	// 待审批
	public static final String AUTO_APPROVE = "04";	// 自动分配
	public static final String APPROVING = "05";//审批中
	public static final String CROSS_ORG_UPDATE = "06";	// 跨机构审批中
	
	/** 分配区间表字段列表(不含主键列表pkList,不含三个审批字段) */
	public final static List<String> PERIOD_COLUMN_LIST = Arrays.asList(
			"EFFECT_DATE", "EXPIRATE_DATE", "OPER_TIME", "OPER_ORG_ID",
			"OPER_USER_ID", "DATA_SRC", "ID");
	
	/** 分配关系表字段列表(生效表与历史表字段一致) */
	public final static List<String> DISTRIBUTE_COLUMN_LIST = Arrays.asList(
			"ID", "PERIOD_ID", "DISTR_RATE", "MANAGER_ID", "ALLOT_TYPE",
			"START_AMT", "END_AMT", "PERF_RATE", "HOST_CFG");
	/** 分配关系表字段列表(生效表与历史表字段一致)(求和) */
	public final static List<String> DISTRIBUTE_COLUMN_LIST_SUM = Arrays.asList(
			"ID", "PERIOD_ID", "SUM(DISTR_RATE) AS DISTR_RATE", "MANAGER_ID", "ALLOT_TYPE",
			"START_AMT", "END_AMT", "PERF_RATE", "HOST_CFG");
	/** 分配关系表字段列表(生效表与历史表字段一致) */
	public final static List<String> DISTRIBUTE_COLUMN_LIST_NEW = Arrays.asList(
			"ID", "PERIOD_ID", "DISTR_RATE", "MANAGER_ID", "ALLOT_TYPE",
			"START_AMT", "END_AMT");
	/**
	 * 业务子类型
	 */
	public enum FUN_SUB_TYPE {
		INFO("01"), PERIOD("02"), DISTRIBUTE("03"), 
		PERIOD_HIS("04"),DISTRIBUTE_HIS("05"), BUSS_INFO("06"),
		CHECK("07"),PRI_KEY("08");
		
		private String type;

		FUN_SUB_TYPE(String type) { this.type = type; }

		@Override
		public String toString() { return type; }
	};
	
	/**
	 * 数据来源
	 */
	public enum DATA_SRC {
		DISTRIBUTE("01"), TRANSFER("02"), CLAIM("03"), 
		IMPORT("04"), SYSTEM("11");
		
		private String type;

		DATA_SRC(String type) { this.type = type; }

		@Override
		public String toString() { return type; }
	};
	
	/**
	 * 数据权限类型
	 * ALL_GOR:全部机构; SUB_ORG:辖内机构; CUR_ORG:当前机构; CUR_PAR:表示当前机构和上级机构; ALL_BUSS:全部条线; CUR_BUSS:当前条线;
	 */
	public enum DATA_AUTH_TYPE {
		ALL_ORG("ALL_ORG"), SUB_ORG("SUB_ORG"), CUR_ORG("CUR_ORG"), 
		CUR_PAR("CUR_PAR"), ALL_BUSS("ALL_BUSS") , CUR_BUSS("CUR_BUSS");
		private String type;

		DATA_AUTH_TYPE(String type) { this.type = type; }

		@Override
		public String toString() { return type; }
	};
	
	/**
	 * 字段 表单组件类型
	 */
	public enum SEARCH_TYPE {
		USER_CHOOSE("userchoose"), ORG_CHOOSE("orgchoose"), 
		DATE_SPAN("dateSpan"),DATE_ONLY("dateOnly"),MONEY_SPAN("moneySpan"), OTHER("other");
		private String type;

		SEARCH_TYPE(String type) { this.type = type; }

		@Override
		public String toString() { return type; }
	};
	
	public enum DATA_TYPE {
		Number(0), String(1), Date(2);
		private int type;
		DATA_TYPE(int type) { this.type = type; }
		
		@Override
		public String toString() { return type + ""; }
	}
	/**
	 * Description: 字段类型
	 * 
	 */
	public enum COLUMN_TYPE {
		STRING("string"), NUMBER("number"), DATE("date"), TIME("time");
		private String type;

		COLUMN_TYPE(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return type;
		}
	};

	/**
	 * description: 分配类型
	 * @author weixy6
	 * @date 2022/6/1
	 */
	public enum ALLOC_TYPE {

		AMOUNT("金额"), RATE("比例"), BOTH("金额比例");
		private final String type;

		ALLOC_TYPE(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return type;
		}
	}

	public static final String ACCT_BUSS_TYPE = "acct";

	public static final String[] ACCT_COLUMNS = {
			"ID",
			"客户号",
			"客户名称",
			"主账号",
			"子账号",
			"账户类型",
			"开户机构号",
			"开户机构名称",
			"开户日期",
			"销户日期",
			"余额",
			"分配状态",
			"起始日期",
			"结束日期",
			"起始金额",
			"结束金额",
			"客户经理编号",
			"客户经理名称",
			"业绩分配比例(%)"
	};

	public static final String[] ACCT_COLUMNS_EN = {
			"id",
			"custNumber",
			"custName",
			"acctNo",
			"subAcctNo",
			"accountType",
			"orgId",
			"orgName",
			"openDate",
			"closeDate",
			"balance",
			"dstrSts",
	};

	public static final String DEPT_BUSS_TYPE = "dept";

	public static final String[] DEPT_COLUMNS = {
			"ID",
			"借据号",
			"合同号",
			"客户号",
			"客户名称",
			"发放日期",
			"到期日期",
			"销户日期",
			"贷款金额",
			"贷款余额",
			"贷款类型",
			"贷款期限",
			"五级分类",
			"放款机构号",
			"放款机构名称",
			"起始日期",
			"结束日期",
			"客户经理编号",
			"客户经理名称",
			"业绩分配比例(%)"
	};

	public static final String[] DEPT_COLUMNS_EN = {
			"id",
			"billNo",
			"contractNo",
			"custId",
			"custName",
			"openDate",
			"dueDate",
			"cancelDate",
			"lAmt",
			"lBal",
			"loanType",
			"lPeriod",
			"claFive",
			"orgId",
			"orgName",
	};

	public static final String MID_BUSS_TYPE = "mid";

	public static final String[] MID_COLUMNS = {
			"ID",
			"交易流水号",
			"客户号",
			"客户名称",
			"交易日期",
			"业务类型",
			"产品代码",
			"产品名称",
			"交易金额",
			"手续费",
			"交易机构号",
			"交易机构名称",
			"分配状态",
			"客户经理编号",
			"客户经理名称",
			"业绩分配比例(%)"
	};

	public static final String[] MID_COLUMNS_EN = {
			"id",
			"transactionMark",
			"customerNumber",
			"customerName",
			"transactionDate",
			"bussType",
			"productNumber",
			"productName",
			"transactionAmount",
			"serviceCharge",
			"orgId",
			"orgName",
			"dstrSts",
	};

}

