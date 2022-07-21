package cn.com.yusys.yusp.cm.monitoring.Vo;

import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/11 - 16:05
 */
public class YscimcActivityChannelFlowVo {
    /**
     * 活动ID
     */
    private String activityId;
    /**
     * 渠道ID
     */
    private String channelId;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 总曝光量
     */
    private String exposureAmount;
    /**
     * 点击量
     */
    private String hitAmount;
    /**
     * 转化率
     */
    private String conversionRate;
    /**
     * 记录日期
     */
    private Date recordDate;
    /**
     * 记录时间
     */
    private Date recordTime;

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
