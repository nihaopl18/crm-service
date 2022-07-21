package cn.com.yusys.yusp.rai.engine.data.domain;

import lombok.Data;

import java.util.*;

/**
 * 规则信息对象
 * @author zhangchi
 * @date 2021年12月06日 15:00:00
 * @version 1.0.0
 */
@Data
public class RulePo implements Comparable<RulePo> {

    /**
     * 规则对应的活动信息
     */
    private String activityId;

    /**
     * 规则ID
     */
    private String ruleId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 条件表达式
     */
    private String conditionExpress;

    /**
     * 连续动作表达式
     */
    private String continueActExpress;

    /**
     * 变量列表
     */
    private Set<FieldPo> fieldList = new HashSet<>();

    /** 引用参数列表 */
    private Set<QuoteParamPo> quoteParamList = new HashSet<>();

    /**
     * 连续动作条件对象表达式
     */
    private ContinueExpressPo continueExpressPo;

    /**
     * 营销动作po
     */
    private List<ActionPo> actionPoList;

    /**
     * 连续命中动作介绍
     */
    private List<ActionPo> continueActionPoList;

    public RulePo() {

    }

    public RulePo(String activityId, String ruleId, String ruleName, Integer priority, String conditionExpress, String continueActExpress){
        this.activityId = activityId;
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.priority = priority;
        this.conditionExpress = conditionExpress;
        this.continueActExpress = continueActExpress;
    }

    @Override
    public int compareTo(RulePo o) {
        return priority.compareTo(o.getPriority());
    }
}
