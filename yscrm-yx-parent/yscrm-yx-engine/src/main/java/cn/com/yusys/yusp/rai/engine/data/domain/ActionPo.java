package cn.com.yusys.yusp.rai.engine.data.domain;

import cn.com.yusys.yusp.rai.engine.data.enums.CalcTypeEnum;
import cn.com.yusys.yusp.rai.engine.data.enums.ScoreGenTypeEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 营销动作
 * @author zhangchi
 * @date 2021年12月06日 14:38:50
 * @version 1.0.0
 */
@Data
public class ActionPo {

    /**
     * 动作ID
     */
    private String actionId;
    /**
     * 游戏编号
     */
    private String actId;
    /**
     * 规则ID
     */
    private String ruleId;
    /**
     * 权益账户
     */
    private String raiAcctNo;
    /**
     * 积分池引用额度
     */
    private String scorePoolAmount;
    /**
     * 上限模式
     */
    private String limitMode;
    /**
     * 卡券
     */
    private String couponId;
    /**
     * 卡券子库存
     */
    private String couponStock;
    /**
     * 游戏类型
     */
    private String gameType;
    /**
     * 游戏ID
     */
    private String raiActId;
    /**
     * 有效期类型
     */
    private String validType;
    /**
     * 有效期
     */
    private String validDate;
    /**
     * 计算方式
     */
    private String calcWay;
    /**
     * 计算公式
     */
    private String calcExpr;
    /**
     * 计算公式解释
     */
    private String calcExprDesc;
    /**
     * 封顶值
     */
    private String topValue;
    /**
     * 封顶类型
     */
    private String topType;
    /**
     * 权益类型
     */
    private String raiType;
    /**
     * 动作类型
     */
    private String actionType;

    /** 礼品id */
    private String giftId;
    
    /** 积分池id */
    private String poolId;

    /** 礼品规格 */
    private String modelId;
    
    /** 成本id */
    private String costId;

    /** 计算方式 */
    private CalcTypeEnum calcTypeEnum;

    /**
     * 变量列表
     */
    private Set<FieldPo> fieldList = new HashSet<>();

    /** 引用参数列表 */
    private Set<QuoteParamPo> quoteParamList = new HashSet<>();

    /** 区间计算方式 */
    private ScoreGenTypeEnum scoreGenType;

    /** 区间表达式和计算值 表达式-计算值-区间值 */
    private List<String[]> sections = new ArrayList<>();

}
