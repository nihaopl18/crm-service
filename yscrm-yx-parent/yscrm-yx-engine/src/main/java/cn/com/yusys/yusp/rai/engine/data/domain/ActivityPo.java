package cn.com.yusys.yusp.rai.engine.data.domain;

import lombok.Data;

import java.util.List;

/**
 * 营销活动类 实体对象
 * @author zhangchi
 * @date 2021年12月06日 15:42:38
 * @version 1.0.0
 */
@Data
public class ActivityPo implements Comparable<ActivityPo> {

    /**
     * 活动Id
     */
    private String activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 生效日期
     */
    private String effectDate;

    /**
     * 失效日期
     */
    private String expireDate;

    /**
     * 交易码
     */
    private String transCode;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 活动类型，默认营销活动，为 2
     */
    private String eventType = "2";

    private List<RulePo> rulePos;

    @Override
    public int compareTo(ActivityPo activityPo) {
        if (priority == null) {
            return -1;
        }
        if (activityPo.getPriority() == null) {
            return 1;
        }
        return priority.compareTo(activityPo.getPriority());
    }


}
