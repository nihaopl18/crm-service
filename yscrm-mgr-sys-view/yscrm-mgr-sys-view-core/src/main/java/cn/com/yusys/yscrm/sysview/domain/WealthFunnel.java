package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/16 18:04
 */
public class WealthFunnel {
    /**
     * 行为追踪信息
     */
    private List<BehaviorInfo> behaviorInfo;
    /**
     * 行为方式
     */
    private String behaviorType;

    public List<BehaviorInfo> getBehaviorInfo() {
        return behaviorInfo;
    }

    public void setBehaviorInfo(List<BehaviorInfo> behaviorInfo) {
        this.behaviorInfo = behaviorInfo;
    }

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }
}
