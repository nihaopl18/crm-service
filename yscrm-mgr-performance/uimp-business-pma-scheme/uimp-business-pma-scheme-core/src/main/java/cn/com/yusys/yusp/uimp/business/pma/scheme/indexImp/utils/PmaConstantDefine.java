package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.utils;

import java.text.DecimalFormat;


/**
 * @author zh_haining
 *
 */
public class PmaConstantDefine {
	/**
	 * <pre>
	 * Title:PMA常量定义类
	 * 
	 * @author  zh_haining zhaohn3@yuchengtech.com
	 * 所在文件:com.yuchengtech.pma.common.PmaConstantDefine.java
	 * 修改时间:2014-5-21 下午01:34:43 修改人：          修改后版本:@version 1.00.00
	 *  </pre>
	 * */
	
	/** maxUploadFileSize:上传文件最大值（单位：KB） **/
	public static String MAX_UPLOAD_FILE_SIZE;
	static{
		/*float maxSize = Float.parseFloat(FileTypeConstance.getSystemProperty("maxUploadFileSize"));
		maxSize = maxSize/1024000;//换算单位将B（byte）换算为MB
		DecimalFormat decimalFormat=new DecimalFormat("##0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
		String maxSizeStr=decimalFormat.format(maxSize);//format 返回的是字符串
		MAX_UPLOAD_FILE_SIZE = maxSizeStr;*/
	}
	
	/** PARAM_DIR_TYPE: 参数目录类型 0：参数目录         1：参数类型 **/
	public static String PARAM_DIR_TYPE_DIR = "0";
	
	/** PARAM_DIR_TYPE: 参数目录类型 0：参数目录         1：参数类型 **/
	public static String PARAM_DIR_TYPE_PARAMTYPE = "1";
	
	/** STST_FLAG_EFFECT: 数据删除状态 ： 00：未删除             02：已删除**/
	public static String STST_FLAG_EFFECT = "00";
	
	/** STST_FLAG_EFFECT: 数据删除状态 ： 00：未删除             02：已删除**/
	public static String STST_FLAG_UNEFFECT = "02";
	
	/** PARAM_SVAE_TYPE:
	 * 		saveOnlyParamValue:只保存参数值 0
	 * 	  	saveParamValueAndConstraint:保存参数值和约束条件 1
	 * 	  	saveParamAndParamValue:保存参数（新增的）和参数值 2
	 * 	  	saveParamValueAndDeleteParam:保存参数值并删除参数 3
	 **/
	public static String PARAM_SVAE_TYPE_SAVEONLYPARAMVALUE = "0";
	/** PARAM_SVAE_TYPE:
	 * 		saveOnlyParamValue:只保存参数值 0
	 * 	  	saveParamValueAndConstraint:保存参数值和约束条件 1
	 * 	  	saveParamAndParamValue:保存参数（新增的）和参数值 2
	 * 	  	saveParamValueAndDeleteParam:保存参数值并删除参数 3
	 **/
	public static String PARAM_SVAE_TYPE_SAVEPARAMVALUEANDCONSTRAINT = "1";
	/** PARAM_SVAE_TYPE:
	 * 		saveOnlyParamValue:只保存参数值 0
	 * 	  	saveParamValueAndConstraint:保存参数值和约束条件 1
	 * 	  	saveParamAndParamValue:保存参数（新增的）和参数值 2
	 * 	  	saveParamValueAndDeleteParam:保存参数值并删除参数 3
	 **/
	public static String PARAM_SVAE_TYPE_SAVEPARAMANDPARAMVALUE = "2";
	/** PARAM_SVAE_TYPE:
	 * 		saveOnlyParamValue:只保存参数值 0
	 * 	  	saveParamValueAndConstraint:保存参数值和约束条件 1
	 * 	  	saveParamAndParamValue:保存参数（新增的）和参数值 2
	 * 	  	saveParamValueAndDeleteParam:保存参数值并删除参数 3
	 **/
	public static String PARAM_SVAE_TYPE_SAVEPARAMVALUEANDDELETEPARAM = "3";
	
	/** STRING_SPLIT_SIGN: 字符串拼接分隔符**/
	public static String STRING_SPLIT_SIGN = "@#@" ;
	
	/** EVL_OBJ_TYPE_EMPLOYEE: 考核对象类型 ：　01-员工      02-机构 **/
	public static String EVL_OBJ_TYPE_EMPLOYEE = "01";
	
	/** EVL_OBJ_TYPE_EMPLOYEE: 考核对象类型 ：　01-员工      02-机构 **/
	public static String EVL_OBJ_TYPE_ORG = "02";
	
	/** EVL_OBJ_TYPE_EMPLOYEE: 考核对象类型 ：　01-员工      02-机构  03-团队**/
	public static String EVL_OBJ_TYPE_TEAM = "03";
	
	/** DATA_ADTIONNAL_TYPE_INDEX: 数据补录类型(01-指标  02-目标  03-基数)**/
	public static String DATA_ADTIONNAL_TYPE_INDEX = "01";
	
	/** DATA_ADTIONNAL_TYPE_INDEX: 数据补录类型(01-指标  02-目标  03-基数)**/
	public static String DATA_ADTIONNAL_TYPE_TARGET = "02";
	
	/** DATA_ADTIONNAL_TYPE_INDEX: 数据补录类型(01-指标  02-目标  03-基数)**/
	public static String DATA_ADTIONNAL_TYPE_RADIX = "03";
	/**应用类型 APPLY_TYPE_INDEX 指标  INDEX_APPLY_TYPE 01-指标 02-基数 03-目标（月） 04-目标（季） 05-目标（年） ***/
	public static String APPLY_TYPE_INDEX = "01";
	
	/**应用类型  APPLY_TYPE_RADIX 基数  INDEX_APPLY_TYPE 01-指标 02-基数 03-目标（月） 04-目标（季） 05-目标（年） ***/
	public static String APPLY_TYPE_RADIX = "02";

	/**应用类型  APPLY_TYPE_TARGET_MONTH 目标（月）  INDEX_APPLY_TYPE 01-指标 02-基数 03-目标（月） 04-目标（季） 05-目标（年） ***/
	public static String APPLY_TYPE_TARGET_MONTH = "03";
	
	/**应用类型  APPLY_TYPE_TARGET_SEASON 目标（季）  INDEX_APPLY_TYPE 01-指标 02-基数 03-目标（月） 04-目标（季） 05-目标（年） ***/
	public static String APPLY_TYPE_TARGET_SEASON = "04";
	
	/**应用类型  APPLY_TYPE_TARGET_YEAR 目标（年）  INDEX_APPLY_TYPE 01-指标 02-基数 03-目标（月） 04-目标（季） 05-目标（年） ***/
	public static String APPLY_TYPE_TARGET_YEAR = "05";
	
	/** INDEX_TYPE_BASE_INDEX: 指标类型  （01-基础指标    02-派生指标）  **/
	public static String INDEX_TYPE_BASE_INDEX = "01";
	
	/** INDEX_TYPE_BASE_INDEX: 指标类型  （01-基础指标    02-派生指标）  **/
	public static String INDEX_TYPE_EVL_INDEX = "02";
	
	/** BASE_INDEX_LOGIC_TYPE: 基础指标逻辑类型：01-复杂类  02-配置类  03-补录类**/
	public static String BASE_INDEX_LOGIC_TYPE_COMPLEX = "01";
	
	/** BASE_INDEX_LOGIC_TYPE: 基础指标逻辑类型：01-复杂类  02-配置类  03-补录类**/
	public static String BASE_INDEX_LOGIC_TYPE_SET = "02";
	
	/** BASE_INDEX_LOGIC_TYPE: 基础指标逻辑类型：01-复杂类  02-配置类  03-补录类**/
	public static String BASE_INDEX_LOGIC_TYPE_IMP = "03";
	
	/** BASE_INDEX_IMP_TYPE: 补录类型 00-全适用   01-按方案       02-按对象**/
	public static String BASE_INDEX_IMP_TYPE_ALL = "00";
	
	/** BASE_INDEX_IMP_TYPE: 补录类型 00-全适用   01-按方案       02-按对象**/
	public static String BASE_INDEX_IMP_TYPE_SCHEME = "01";
	
	/** BASE_INDEX_IMP_TYPE: 补录类型 00-全适用   01-按方案       02-按对象**/
	public static String BASE_INDEX_IMP_TYPE_OBJ = "02";
	
	/** PMA_ADMIN_USER: 系统管理员用户 **/
	public static String PMA_ADMIN_USER = "admin";
	
	/** PMA_SUPERUNIT: 总行机构号 **/
	public static String PMA_SUPERUNIT_ORGID = "00011";
	
	/** 系统角色编码: 管理人员 **/
/*	public static String SYS_ROLE_CODE_ADMIN = "R00-001,R01-001,R02-001,R03-001,R00-002,R01-002,R02-002,R03-002,R00-004,R01-004,R02-004,R03-004," +
			"R00-004,R01-004,R02-004,R03-004,R00-005,R01-005,R02-005,R03-005,R00-007,R01-007,R02-007,R03-007,R00-008,R01-008,R02-008,R03-008,logicSystemManager ";
	*/
	public static String SYS_ROLE_CODE_ADMIN = "RH01,R00-003,RH02,R00-004,RH14,logicSystemManager ";
	/** 系统角色编码: 总行管理员:-001 **/
	public static String SYS_ROLE_CODE_TOTAL_ADMIN = "R00-001,R01-001,R02-001,R03-001,R04-001";
	
	/** 系统角色编码: 总行查询员:-002 **/
	public static String SYS_ROLE_CODE_TOTAL_QUERY = "R00-002,R01-002,R02-002,R03-002,R04-002";
	
	/** 系统角色编码: 分行管理员 :-004 **/
	public static String SYS_ROLE_CODE_BRANCH_ADMIN = "R00-004,R01-004,R02-004,R03-004,R04-004";
	
	/** 系统角色编码: 分行查询员 :-005 **/
	public static String SYS_ROLE_CODE_BRANCH_QUERY = "R00-005,R01-005,R02-005,R03-005,R04-005";
	
	/** 系统角色编码: 支行管理员 :-007 **/
	/*public static String SYS_ROLE_CODE_SUB_ADMIN = "R00-007,R01-007,R02-007,R03-007,R04-007";*/
	public static String SYS_ROLE_CODE_SUB_ADMIN = "R00-007,R01-007,R02-007,R03-007,R04-007,RH01,RH02,RH14";//加了RH01，RH02,RH14
	/** 系统角色编码: 支行查询员 :-008 **/
	public static String SYS_ROLE_CODE_SUB_QUERY = "R00-008,R01-008,R02-008,R03-008,R04-008";
	
	/** 系统角色编码: 一般人员 :-003  -006 -009 **/
	/*public static String SYS_ROLE_CODE_PUB = "R00-003,R01-003,R02-003,R03-003,R04-003,R00-006,R01-006,R02-006,R03-006,R04-006,R00-009,R01-009,R02-009,R03-009,R04-009";*/
	public static String SYS_ROLE_CODE_PUB = "M";//变成客户经理角色代码
	
	/** 系统角色编码: 团队长 :  R11**/
	/*public static String SYS_ROLE_CODE_TEAM = "R11";*/
	public static String SYS_ROLE_CODE_TEAM = "";
	/** 考核方案应用场景:评分-01 **/
	public static String SCHEME_APPLY_SCENE_SCORE = "01";
	
	/** 考核方案应用场景:工资-02 **/
	public static String SCHEME_APPLY_SCENE_SALARY = "02";
	
	/** 考核方案应用场景:指标值-03 **/
	public static String SCHEME_APPLY_SCENE_INDEX = "03";
	
	/** 指标业务类型标志: 贷款-02 **/
	public static String INDEX_BIZ_FLG_LOAN = "02";
	
	/** 指标业务类型标志: 存款-01 **/
	public static String INDEX_BIZ_FLG_SAVE = "01";
	
	/** 指标业务类型标志: 中间业务-03 **/
	public static String INDEX_BIZ_FLG_MID = "03";
	
	/** SCHEME_QUERY_FLAG_SALANDSCORE: 考核方案查询标志：评分和工资查询 01**/
	public static String SCHEME_QUERY_FLAG_SALANDSCORE = "01";
	
	/**客户经理升降级审批流流程编号**/
	public static String MGR_REG_APPLE_FLAG = "3";
	
	/**客户经理信息管理审批流流程编号**/
	public static String MGR_MANAGE_APPLE_FLAG = "5";
	
	/**中后台条线业务编号**/
	public static String MID_BUSS_SYS_NO = "00";
	
	/**业绩分配审批状态-已分配01**/
	public static String APPLIED = "01";
	
	/**业绩分配审批状态-已分配01**/
	public static String UN_APPLY = "02";
	
	/** SCHEME_PROCESS_STATUS_COMPLETE:考核方案加工状态：2-已完成 **/
	public static String SCHEME_PROCESS_STATUS_COMPLETE = "2";
	
	/** SCHEME_PROCESS_STATUS_COMPLETE:考核方案加工状态：1-正在运行**/
	public static String SCHEME_PROCESS_STATUS_COMPING = "1";
	
	/** SCHEME_PROCESS_STATUS_COMPLETE:考核方案加工状态：0-未加工**/
	public static String SCHEME_PROCESS_STATUS_UNDO = "0";
	
	/** SCHEME_CALCULATE_STATUS_COMPING: 方案测算状态**/
	public static String SCHEME_CALCULATE_STATUS_COMPING = "02";
	
	/** IF_FLAG_TRUE: 是否：1-是 **/
	public static String IF_FLAG_TRUE = "1";
	
	/** IF_FLAG_FALSE:是否：0-否  **/
	public static String IF_FLAG_FALSE = "0";
	
}
