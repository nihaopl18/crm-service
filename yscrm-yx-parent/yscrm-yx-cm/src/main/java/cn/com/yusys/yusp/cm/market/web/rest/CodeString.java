package cn.com.yusys.yusp.cm.market.web.rest;

public class CodeString {

	
	public static final String DATA_TYPE_DATE="4"; //日期类型G=""; 
	public static final String DATA_TYPE_DATESTAMP="2";
	public static final String DATA_TYPE_INTEGER="5"; //日期类型
	public static final String DATA_TYPE_NUMBER="3";//数据类型
	public static final String DATA_TYPE_STRING="1";
	public static final String DATE_FORMAT_YYYYMMDD="yyyyMMdd";
	public static final String DATE_FORMAT_YYYYMMDDHHMMSS="yyyyMMddHHmmss";
	public static final String DATE_FORMAT18_YYYYMMDDHHMMSS="yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT10_YYYYMMDD="yyyy-MM-dd";
	public static final String DATE_FORMAT16_YYYYMMDDHHMMSS="yyyy-MM-ddHHmmss";
	
	/*警告类预警*/
	public static final String RULE_CLASS_WARNING="1";
	/*提醒类预警**/
	public static final String RULE_CLASS_ALERT="2";
	
	//实时
	public static final String RULE_TYPE_DOING="";
	
	/*事后*/
	public static final String RULE_TYPE_DONE="";
	
	/*事中*/
	public static final String RULE_TYPE_TODO="";
	
	public static final String ALARM_STAT_UNDO="1";
	
	/************kafka发送的交易公共字段信息 begin***************/
	
	/**kafka接收的流水号字段名称*/
	public static final String TRANS_HEADER_FIELD_TRNO ="PU_TRNO";
	/**kafka里面接收的交易码字段*/
	public static final String TRANS_HEADER_FIELD_TRCD = "PU_TRCD";
	/**交易日期*/
	public static final String TRANS_HEADER_FIELD_TRDT = "PU_TRDT";
	/**交易时间*/
	public static final String TRANS_HEADER_FIELD_TRTM = "PU_TRTM";
	/**交易柜员*/
	public static final String TRANS_HEADER_FIELD_TRUS = "PU_TRUS";
	/**交易系统*/
	public static final String TRANS_HEADER_FIELD_RSYS ="PU_RSYS";
	/**返回码*/
	public static final String TRANS_HEADER_FIELD_RSCD = "PU_RSCD";
	/**交易机构*/
	public static final String TRANS_HEADER_FIELD_TRBR="PU_TRBR"; 
	
	/**分行号*/
	public static final String TRANS_HEADER_FIELD_BRNO="PU_BRNO";
	
	public static final String TRANS_HEADER_FIELD_NOSQLDATE="TRANS_TIME"; 
	
	public static final String TRANS_HEADER_FIELD_NOSQLBUSIKEY="BIZ_ID"; 
	
	/************kafka发送的交易公共字段信息  end***************/
	
	
	public static final String RULE_ID_SEQUENCE = "SEQ_RULE_ID";
	public static final String RULE_NO_SEQ = "SEQ_RULE_NO";
	
	public static final int RULE_NO_FIX_LENGTH=5;
	
	public static final String MACHINE_NAME = "machine_no";
	public static final String MACHINE_START_IDX = "machine_start_idx";
	
 /*	public static final String  TRANS_HEADER_FIELD_BRANCH_ID = "branch_id";
	public static final String  TRANS_HEADER_FIELD_LOG_NO = "BIZ_ID";
	public static final String  TRANS_HEADER_FIELD_ORG_ID = "ORG_ID";
	public static final String  TRANS_HEADER_FIELD_TELLER_ID = "TELLER_ID";
	public static final String  TRANS_HEADER_FIELD_TX_DT = "TX_DT";
	public static final String  TRANS_HEADER_FIELD_TX_TM="TX_TM"; */
	public static final String  RULE_MATCH_SIGN_CONFIG_OR="‖";
	public static final String  RULE_MATCH_SIGN_REPLCAE_OR="\\|\\|";
	
	public static final String REF_PARAM_DATASOURCE_TABLE="B"; 
	public static final String REF_PARAM_DATASOURCE_TRANS="A"; 
	
	public static final String  ARITH_OPR_GT =">>";   
	public static final String  ARITH_OPR_EGT =">=";   
	public static final String  ARITH_OPR_LT ="<<";  
	public static final String  ARITH_OPR_ELT ="<=";  
	public static final String  ARITH_RELOPR_GT =">";    
	public static final char  ARITH_RELOPR_CHAR_GT ='>';    
	public static final String  ARITH_RELOPR_LT ="<";  
	public static final char  ARITH_RELOPR_CHAR_LT ='<';  
	public static final String  ARITH_RELOPR_EQ ="==";  
	public static final String  ARITH_RELOPR_OR ="||";  
	public static final String ARITH_RELOPR_RL_EQ = "=";
	
	public static final String ES_TYPE_FIELD = "TABLE_NAME";
	 
	
	public static final int ES_MAX_RET_LINES = 100;
	
 
	
	
	
	
	
	
	 
	 
	
	
	
	
	

}
