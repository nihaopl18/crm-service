package cn.com.yusys.yusp.cm.monitoring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/12 - 14:44
 */
@Entity
@Table(name="YSCIMC_RIGHT_DISTRIBUTION_TREND")
public class YscimcRightDistributionTrendPo {
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
     * 发放数量
     */
    @Column(name="DISTRIBUTION_NUMBER")
    private String distributionNumber;

    public YscimcRightDistributionTrendPo() {
    }

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

    public String getDistributionNumber() {
        return distributionNumber;
    }

    public void setDistributionNumber(String distributionNumber) {
        this.distributionNumber = distributionNumber;
    }
}
