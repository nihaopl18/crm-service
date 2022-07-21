package cn.com.yusys.yscimc.operation.domain.vo;

import java.io.Serializable;

public class CmFRcRuleActionInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键ID
    private String id;
    //事件id
    private String eventId;
    //规则动作类型(单次动作、连续动作)
    private String actionType;
    //动态调用类
    private String className;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
