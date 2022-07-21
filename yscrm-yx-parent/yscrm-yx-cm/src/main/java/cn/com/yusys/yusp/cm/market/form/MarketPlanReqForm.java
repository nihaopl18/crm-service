package cn.com.yusys.yusp.cm.market.form;

import java.io.Serializable;

/**
 * @Author Lenovo
 * @Data 2022/3/7 15:07
 */
public class MarketPlanReqForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tempId;

    private String activityName;

    private String activityType;

    private String keyword;

    public String getTempId() {
        return tempId;
    }
    
    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
