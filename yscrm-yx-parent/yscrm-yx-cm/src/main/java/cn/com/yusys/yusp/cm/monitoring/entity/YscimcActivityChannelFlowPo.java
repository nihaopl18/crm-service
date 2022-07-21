package cn.com.yusys.yusp.cm.monitoring.entity;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/11 - 15:58
 */
@Entity
@Table(name="YSCIMC_ACTIVITY_CHANNEL_FLOW")
public class YscimcActivityChannelFlowPo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 活动ID
     */
    @Column(name="ACTIVITY_ID")
    private String activityId;
    /**
     * 渠道ID
     */
    @Column(name="CHANNEL_ID")
    private String channelId;
    /**
     * 渠道名称
     */
    @Column(name="CHANNEL_NAME")
    private String channelName;
    /**
     * 总曝光量
     */
    @Column(name="EXPOSURE_AMOUNT")
    private String exposureAmount;
    /**
     * 点击量
     */
    @Column(name="HIT_AMOUNT")
    private String hitAmount;
    /**
     * 转化率
     */
    @Column(name="CONVERSION_RATE")
    private String conversionRate;
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

    public YscimcActivityChannelFlowPo() {
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

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getExposureAmount() {
        return exposureAmount;
    }

    public void setExposureAmount(String exposureAmount) {
        this.exposureAmount = exposureAmount;
    }

    public String getHitAmount() {
        return hitAmount;
    }

    public void setHitAmount(String hitAmount) {
        this.hitAmount = hitAmount;
    }

    public String getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
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
}
