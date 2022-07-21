package cn.com.yusys.yusp.cm.monitoring.Vo;

import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/8 - 16:59
 */
public class YscimcActivityTrafficSourceVo {
    /**
     * 活动ID
     */
    private String activityId;
    /**
     * 记录日期
     */
    private Date recordDate;
    /**
     * 记录时间
     */
    private Date recordTime;
    /**
     * 搜索引流
     */

    private String searchImportFlow;

    /**
     * 站内引流
     */

    private String insideStationImportFlow;
    /**
     * 推广引流
     */

    private String promotionImportFlow;
    /**
     * 总访问量
     */
    private String totalVisitAmount;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getSearchImportFlow() {
        return searchImportFlow;
    }

    public void setSearchImportFlow(String searchImportFlow) {
        this.searchImportFlow = searchImportFlow;
    }

    public String getInsideStationImportFlow() {
        return insideStationImportFlow;
    }

    public void setInsideStationImportFlow(String insideStationImportFlow) {
        this.insideStationImportFlow = insideStationImportFlow;
    }

    public String getPromotionImportFlow() {
        return promotionImportFlow;
    }

    public void setPromotionImportFlow(String promotionImportFlow) {
        this.promotionImportFlow = promotionImportFlow;
    }

    public String getTotalVisitAmount() {
        return totalVisitAmount;
    }

    public void setTotalVisitAmount(String totalVisitAmount) {
        this.totalVisitAmount = totalVisitAmount;
    }
}
