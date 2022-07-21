package cn.com.yusys.yusp.uimp.base.constants;

import java.util.HashMap;
import java.util.Map;

public class DistributionConstants {
	
	public static String FUN_SUB_TYPE_INFO = "01";
	public static String FUN_SUB_TYPE_PERIOD = "02";
	public static String FUN_SUB_TYPE_DISTRIBUTE = "03";
	public static String FUN_SUB_TYPE_PERIOD_HIS = "04";
	public static String FUN_SUB_TYPE_DISTRIBUTE_HIS = "05";
	public static String FUN_SUB_TYPE_IMP_DTL = "06";
	public static String FUN_SUB_TYPE_IMP_CHECK = "07";
	public static String FUN_SUB_TYPE_PRI_KEY = "08";
	
	/**
	 * 字段类型
	 */
	public static String COLUMN_TYPE_STRING = "string";
	public static String COLUMN_TYPE_NUMBER = "number";
	public static String COLUMN_TYPE_DATE = "date";
	public static String COLUMN_TYPE_TIME = "time";
	
	public final static String YES = "1";
	public final static String NO = "0";
	
	public static final String DB_TYPE = "Oracle";
	
	
	/** period表建表字段配置_DB2 */
	public final static Map<String, String> PERIOD_CREATE_SQL_CFG_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = 8346507616357122418L;
		{
			put("ID", "INTEGER NOT NULL");
			put("EFFECT_DATE", "VARCHAR(10)");
			put("EXPIRATE_DATE", "VARCHAR(10)");
			put("DATA_SRC", "VARCHAR(2)");
			put("OPER_TIME", "VARCHAR(20)");
			put("OPER_USER_ID", "VARCHAR(20)");
			put("OPER_ORG_ID", "VARCHAR(20)");
		}
	};
	
	/** period表建表字段注释_DB2 */
	public final static Map<String, String> PERIOD_CREATE_SQL_COMMENT_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = 8346507616357122418L;
		{
			put("ID", "主键");
			put("EFFECT_DATE", "起始日期");
			put("EXPIRATE_DATE", "结束日期");
			put("DATA_SRC", "数据来源");
			put("OPER_TIME", "分配时间");
			put("OPER_USER_ID", "操作用户号");
			put("OPER_ORG_ID", "操作机构号");
		}
	};
	
	/** periodHis表建表字段配置_DB2 */
	public final static Map<String, String> PERIOD_HIS_CREATE_SQL_CFG_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -3489319329446249633L;
		{
			putAll(PERIOD_CREATE_SQL_CFG_DB2);
			put("APPLY_ID", "VARCHAR(32)");
			put("APPLY_TIME", "VARCHAR(20)");
			put("APPLY_STS", "VARCHAR(2)");
		}
	};
	
	/** periodHis表建表字段注释_DB2 */
	public final static Map<String, String> PERIOD_HIS_CREATE_SQL_COMMENT_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -3489319329446249633L;
		{
			putAll(PERIOD_CREATE_SQL_COMMENT_DB2);
			put("APPLY_ID", "审批编号");
			put("APPLY_TIME", "审批时间");
			put("APPLY_STS", "审批状态");
		}
	};
	
	/** distribute表建表字段配置_DB2 */
	public final static Map<String, String> DISTRIBUTE_CREATE_SQL_CFG_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847700L;
		{
			put("ID", "INTEGER NOT NULL");
			put("PERIOD_ID", "INTEGER");
			put("MANAGER_ID", "VARCHAR(20)");
			put("START_AMT", "DECIMAL(20,2)");
			put("END_AMT", "DECIMAL(20,2)");
			put("DISTR_RATE", "DECIMAL(10,4)");
			put("PERF_RATE", "DECIMAL(10,4)");
			put("ALLOT_TYPE", "VARCHAR(2)");
			put("HOST_CFG", "VARCHAR(2)");
		}
	};
	
	/** distribute表建表字段备注_DB2 */
	public final static Map<String, String> DISTRIBUTE_CREATE_SQL_COMMENT_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847700L;
		{
			put("ID", "主键");
			put("PERIOD_ID", "区间主键");
			put("MANAGER_ID", "客户经理编号");
			put("START_AMT", "起始金额");
			put("END_AMT", "结束金额");
			put("DISTR_RATE", "业绩比例");
			put("PERF_RATE", "");
			put("ALLOT_TYPE", "分配类型");
			put("HOST_CFG", "");
		}
	};
	
	/** period表建表字段配置_ORACLE */
	public final static Map<String, String> PERIOD_CREATE_SQL_CFG_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = 8346507616357122418L;
		{
			put("ID", "VARCHAR2(32) NOT NULL");
			put("EFFECT_DATE", "VARCHAR2(10)");
			put("EXPIRATE_DATE", "VARCHAR2(10)");
			put("DATA_SRC", "VARCHAR2(2)");
			put("OPER_TIME", "VARCHAR2(20)");
			put("OPER_USER_ID", "VARCHAR2(20)");
			put("OPER_ORG_ID", "VARCHAR2(20)");
		}
	};
	
	/** period表建表字段注释_ORACLE */
	public final static Map<String, String> PERIOD_CREATE_SQL_COMMENT_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = 8346507616357122418L;
		{
			put("ID", "主键");
			put("EFFECT_DATE", "起始日期");
			put("EXPIRATE_DATE", "结束日期");
			put("DATA_SRC", "数据来源");
			put("OPER_TIME", "分配时间");
			put("OPER_USER_ID", "操作用户号");
			put("OPER_ORG_ID", "操作机构号");
		}
	};
	
	/** periodHis表建表字段配置_ORACLE */
	public final static Map<String, String> PERIOD_HIS_CREATE_SQL_CFG_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -3489319329446249633L;
		{
			putAll(PERIOD_CREATE_SQL_CFG_ORACLE);
			put("APPLY_ID", "VARCHAR2(32)");
			put("APPLY_TIME", "VARCHAR2(20)");
			put("APPLY_STS", "VARCHAR2(2)");
		}
	};
	
	/** periodHis表建表字段注释_ORACLE */
	public final static Map<String, String> PERIOD_HIS_CREATE_SQL_COMMENT_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -3489319329446249633L;
		{
			putAll(PERIOD_CREATE_SQL_COMMENT_ORACLE);
			put("APPLY_ID", "审批编号");
			put("APPLY_TIME", "审批时间");
			put("APPLY_STS", "审批状态");
		}
	};
	
	/** distribute表建表字段配置_ORACLE */
	public final static Map<String, String> DISTRIBUTE_CREATE_SQL_CFG_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847700L;
		{
			put("ID", "VARCHAR2(32) NOT NULL");
			put("PERIOD_ID", "VARCHAR2(32)");
			put("MANAGER_ID", "VARCHAR2(20)");
			put("START_AMT", "NUMBER(20,2)");
			put("END_AMT", "NUMBER(20,2)");
			put("DISTR_RATE", "NUMBER(10,4)");
			put("ALLOT_TYPE", "VARCHAR2(2)");
			put("HOST_CFG", "VARCHAR2(2)");
		}
	};
	
	/** distribute表建表字段注释_ORACLE */
	public final static Map<String, String> DISTRIBUTE_CREATE_SQL_COMMENT_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847700L;
		{
			put("ID", "主键");
			put("PERIOD_ID", "区间主键");
			put("MANAGER_ID", "客户经理编号");
			put("START_AMT", "起始金额");
			put("END_AMT", "结束金额");
			put("DISTR_RATE", "业绩比例");
			put("ALLOT_TYPE", "分配类型");
			put("HOST_CFG", "");
		}
	};
	
	/** IMP_DTL表建表字段配置_ORACLE */
	public final static Map<String, String> IMP_DTL_CREATE_SQL_CFG_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "VARCHAR2(32) NOT NULL");
			put("BATCH_ID", "VARCHAR2(32) NOT NULL");
			put("OPER_ORG_ID", "VARCHAR2(100)");
			put("MANAGER_ID", "VARCHAR2(32)");
			put("MANAGER_NAME", "VARCHAR2(100)");
			put("EFFECT_DATE", "VARCHAR2(10)");
			put("EXPIRATE_DATE", "VARCHAR2(10)");
			put("START_AMT", "NUMBER(20,2)");
			put("END_AMT", "NUMBER(20,2)");
			put("DISTR_RATE", "NUMBER(10,4)");
		}
	};
	
	/** IMP_DTL表建表字段注释_ORACLE */
	public final static Map<String, String> IMP_DTL_CREATE_SQL_COMMENT_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "主键");
			put("BATCH_ID", "批次编号");
			put("OPER_ORG_ID", "客户归属机构");
			put("MANAGER_ID", "客户经理编号");
			put("MANAGER_NAME", "客户经理名称");
			put("EFFECT_DATE", "生效日期");
			put("EXPIRATE_DATE", "失效日期");
			put("START_AMT", "起始金额");
			put("END_AMT", "结束金额");
			put("DISTR_RATE", "业绩比例");
		}
	};
	
	/** IMP_CHECK表建表字段配置_ORACLE */
	public final static Map<String, String> IMP_CHECK_CREATE_SQL_CFG_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "VARCHAR2(32) NOT NULL");
			put("BATCH_ID", "VARCHAR2(32) NOT NULL");
			put("OPER_ORG_ID", "VARCHAR2(100)");
			put("MANAGER_ID", "VARCHAR2(32)");
			put("MANAGER_NAME", "VARCHAR2(100)");
			put("EFFECT_DATE", "VARCHAR2(10)");
			put("EXPIRATE_DATE", "VARCHAR2(10)");
			put("START_AMT", "NUMBER(20,2)");
			put("END_AMT", "NUMBER(20,2)");
			put("DISTR_RATE", "NUMBER(10,4)");
			put("CHECK_STATE", "VARCHAR2(10)");
			put("CHECK_MSG", "VARCHAR2(100)");
		}
	};
	
	/** IMP_CHECK表建表字段注释_ORACLE */
	public final static Map<String, String> IMP_CHECK_CREATE_SQL_COMMENT_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "主键");
			put("BATCH_ID", "批次编号");
			put("OPER_ORG_ID", "客户归属机构");
			put("MANAGER_ID", "客户经理编号");
			put("MANAGER_NAME", "客户经理名称");
			put("EFFECT_DATE", "生效日期");
			put("EXPIRATE_DATE", "失效日期");
			put("START_AMT", "起始金额");
			put("END_AMT", "结束金额");
			put("DISTR_RATE", "业绩比例");
			put("CHECK_STATE", "校验状态");
			put("CHECK_MSG", "校验信息");
		}
	};
	
	/** IMP_CHECK表建表字段配置_ORACLE */
	public final static Map<String, String> PRI_KEY_CREATE_SQL_CFG_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "VARCHAR2(32) NOT NULL");
			put("BATCH_ID", "VARCHAR2(32) NOT NULL");
			put("TYPE_CODE", "VARCHAR2(32)");
			put("CREATE_TIME", "DATE");
			put("CREATE_USER", "VARCHAR2(32)");
		}
	};
	
	/** IMP_CHECK表建表字段备注_ORACLE */
	public final static Map<String, String> PRI_KEY_CREATE_SQL_COMMENT_ORACLE = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "主键");
			put("BATCH_ID", "批次编号");
			put("TYPE_CODE", "类型标识");
			put("CREATE_TIME", "创建时间");
			put("CREATE_USER", "创建人");
		}
	};
	
	/** IMP_DTL表建表字段配置_DB2 */
	public final static Map<String, String> IMP_DTL_CREATE_SQL_CFG_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847702L;
		{
			put("ID", "VARCHAR(32) NOT NULL");
			put("BATCH_ID", "VARCHAR(32) NOT NULL");
			put("OPER_ORG_ID", "VARCHAR(100)");
			put("MANAGER_ID", "VARCHAR(32)");
			put("MANAGER_NAME", "VARCHAR(100)");
			put("EFFECT_DATE", "VARCHAR(10)");
			put("EXPIRATE_DATE", "VARCHAR(10)");
			put("START_AMT", "DECIMAL(20,2)");
			put("END_AMT", "DECIMAL(20,2)");
			put("DISTR_RATE", "DECIMAL(10,4)");
		}
	};
	
	/** IMP_DTL表建表字段备注_DB2 */
	public final static Map<String, String> IMP_DTL_CREATE_SQL_COMMENT_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847702L;
		{
			put("ID", "主键");
			put("BATCH_ID", "批次编号");
			put("OPER_ORG_ID", "客户归属机构");
			put("MANAGER_ID", "客户经理编号");
			put("MANAGER_NAME", "客户经理名称");
			put("EFFECT_DATE", "生效日期");
			put("EXPIRATE_DATE", "失效日期");
			put("START_AMT", "起始金额");
			put("END_AMT", "结束金额");
			put("DISTR_RATE", "业绩比例");
		}
	};
	
	/** IMP_CHECK表建表字段配置_DB2 */
	public final static Map<String, String> IMP_CHECK_CREATE_SQL_CFG_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847702L;
		{
			put("ID", "VARCHAR(32) NOT NULL");
			put("BATCH_ID", "VARCHAR(32) NOT NULL");
			put("OPER_ORG_ID", "VARCHAR(100)");
			put("MANAGER_ID", "VARCHAR(32)");
			put("MANAGER_NAME", "VARCHAR(100)");
			put("EFFECT_DATE", "VARCHAR(10)");
			put("EXPIRATE_DATE", "VARCHAR(10)");
			put("START_AMT", "DECIMAL(20,2)");
			put("END_AMT", "DECIMAL(20,2)");
			put("DISTR_RATE", "DECIMAL(10,4)");
			put("CHECK_STATE", "VARCHAR(10)");
			put("CHECK_MSG", "VARCHAR(100)");
		}
	};
	
	/** IMP_CHECK表建表字段备注_DB2 */
	public final static Map<String, String> IMP_CHECK_CREATE_SQL_COMMENT_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847702L;
		{
			put("ID", "主键");
			put("BATCH_ID", "批次编号");
			put("OPER_ORG_ID", "客户归属机构");
			put("MANAGER_ID", "客户经理编号");
			put("MANAGER_NAME", "客户经理名称");
			put("EFFECT_DATE", "生效日期");
			put("EXPIRATE_DATE", "失效日期");
			put("START_AMT", "起始金额");
			put("END_AMT", "结束金额");
			put("DISTR_RATE", "业绩比例");
			put("CHECK_STATE", "校验状态");
			put("CHECK_MSG", "校验信息");
		}
	};
	
	/** IMP_CHECK表建表字段配置_ORACLE */
	public final static Map<String, String> PRI_KEY_CREATE_SQL_CFG_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "VARCHAR(32) NOT NULL");
			put("BATCH_ID", "VARCHAR(32) NOT NULL");
			put("TYPE_CODE", "VARCHAR(32)");
			put("CREATE_TIME", "DATE");
			put("CREATE_USER", "VARCHAR(32)");
		}
	};
	
	/** IMP_CHECK表建表字段注释_ORACLE */
	public final static Map<String, String> PRI_KEY_CREATE_SQL_COMMENT_DB2 = new HashMap<String, String>(){
		private static final long serialVersionUID = -2447231996643847701L;
		{
			put("ID", "主键");
			put("BATCH_ID", "批次编号");
			put("TYPE_CODE", "类型标识");
			put("CREATE_TIME", "创建时间");
			put("CREATE_USER", "创建人");
		}
	};
	
}
