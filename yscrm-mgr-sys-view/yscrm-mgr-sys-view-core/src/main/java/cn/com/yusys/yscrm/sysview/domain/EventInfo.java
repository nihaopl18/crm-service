package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/11 15:52
 */
public class EventInfo {
    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 事件名称
     */
    private String eventName;
    /**
     * 事件内容
     */
    private String eventDesc;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
}
