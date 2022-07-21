package cn.com.yusys.yusp.cm.monitoring.entity;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/8 - 13:45
 */
@Entity
@Table(name="YSCIMC_ACTIVITY_TRAFFIC_STATISTICS")
public class YscimcActivityTrafficStatisticsPo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 活动ID
     */
    @Column(name="ACTIVITY_ID")
    private String activityId;
    /**
     * 记录日期
     */
    @Column(name="RECORD_DATE")
    private Date recordDate;
    /**
     * 记录时间
     */
    @Column(name="RECORD_TIME")
    private Date recordTime;
    /**
     *页面名称
     */
    @Column(name="PAGE_NAME")
    private String pageName;
    /**
     * 独立访客
     */
    @Column(name="UNIQUE_VISITOR")
    private String uniqueVisitor;
    /**
     * 平均访问时长
     */
    @Column(name="AVERAGE_VISIT_TIME")
    private String averageVisitTime;
    /**
     * 跳出率
     */
    @Column(name="BOUNCE_RATE")
    private String bounceRate;

    public YscimcActivityTrafficStatisticsPo(){}

    public static long getSerialVersionUID() {
        return 1L;
    }

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
