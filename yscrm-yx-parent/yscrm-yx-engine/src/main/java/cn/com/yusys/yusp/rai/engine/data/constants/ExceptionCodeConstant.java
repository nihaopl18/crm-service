package cn.com.yusys.yusp.rai.engine.data.constants;

/**
 * 异常编码
 * @author zhangchi
 * @date 2021年12月06日 13:49:15
 * @version 1.0.0
 */
public class ExceptionCodeConstant {
    
    /** 规则化字段类型错误 */
    public static final String FILED_TYPE_ERROR = "20001001";

    /** 连续动作统计类型错误 */
    public static final String COUNT_TYPE_ERROR = "20001002";

    /** 连续动作统计周期类型错误 */
    public static final String COUNT_CYCLE_TYPE_ERROR = "20001003";

    /** 连续动作比较符类型错误 */
    public static final String COUNT_ACTION_STORE_TYPE_ERROR = "20001004";

    /** 连续规则表达式错误 */
    public static final String CONT_RULE_EXP_ERROR = "20001005";

    /** 动作表达式计算类型错误 */
    public static final String CALC_TYPE_ERROR = "20001006";

    /** 动作表达式区间计算类型错误 */
    public static final String SCORE_GEN_TYPE_ERROR = "20001007";

    /** 权益类型错误 */
    public static final String RAI_TYPE_ERROR = "20001008";

    /** 权益类型错误 */
    public static final String RULE_EXPR_ERROR = "20001009";

    /** 请求数据中未包含交易类型字段错误 */
    public static final String NOT_HAVE_TRANS_CODE_ERROR = "20002001";

    /** 请求数据中未包含交易类型字段错误 */
    public static final String NOT_HAVE_OUT_TRADER_NO_ERROR = "20002002";

    /** 请求数据中未包含客户id字段错误 */
    public static final String NOT_HAVE_CUST_ID_ERROR = "20002003";


    /** 规则匹配错误 */
    public static final String RULE_MATCH_ERROR = "30001000";

    /** 动作计算错误 */
    public static final String ACTION_CALC_ERROR = "30002000";

    /** 试算异常 */
    public static final String TRIAL_ERROR = "40001000";

    /** 试算 - 任务分发调用异常 */
    public static final String TRIAL_CALL_EXECUTE_ERROR = "40001001";

}
