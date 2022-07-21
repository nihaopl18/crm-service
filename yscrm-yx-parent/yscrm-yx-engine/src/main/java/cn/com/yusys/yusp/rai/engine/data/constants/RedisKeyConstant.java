package cn.com.yusys.yusp.rai.engine.data.constants;

/**
 * redis缓存key定义
 * @author zhangchi
 * @date 2021年12月06日 16:55:54
 * @version 1.0.0
 */
public class RedisKeyConstant {

    /**
     * 交易字段前缀
     */
    public static final String REDIS_RULE_FIELDS_PREFIX ="RAI:CONFIG:RULE:FIELDS:";

    /**
     * 引用参数
     */
    public static final String REDIS_ENG_QUOTE_PARAM = "RAI:CONFIG:RULE:QUOTE";

    /**
     * 活动key
     */
    public static final String  REDIS_RULE_ACTIVITY_PREFIX = "RAI:CONFIG:RULE:ACTIVITY:";
}
