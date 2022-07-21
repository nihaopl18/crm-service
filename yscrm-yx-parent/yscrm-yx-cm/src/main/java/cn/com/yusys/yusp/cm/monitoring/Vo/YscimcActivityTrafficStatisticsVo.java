package cn.com.yusys.yusp.cm.monitoring.Vo;

import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/8 - 14:23
 */
public class YscimcActivityTrafficStatisticsVo {
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
     *页面名称
     */
    private String pageName;
    /**
     * 独立访客
     */
    private String uniqueVisitor;
    /**
     * 平均访问时长
     */
    private String averageVisitTime;
    /**
     * 跳出率
     */
    private String bounceRate;

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

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getUniqueVisitor() {
        return uniqueVisitor;
    }

    public void setUniqueVisitor(String uniqueVisitor) {
        this.uniqueVisitor = uniqueVisitor;
    }

    public String getAverageVisitTime() {
        return averageVisitTime;
    }

    public void setAverageVisitTime(String averageVisitTime) {
        this.averageVisitTime = averageVisitTime;
    }

    public String getBounceRate() {
        return bounceRate;
    }

    public void setBounceRate(String bounceRate) {
        this.bounceRate = bounceRate;
    }
}
