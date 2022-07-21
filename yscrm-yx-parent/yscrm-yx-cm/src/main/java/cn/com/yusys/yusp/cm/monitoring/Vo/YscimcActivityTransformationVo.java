package cn.com.yusys.yusp.cm.monitoring.Vo;

import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/13 - 9:57
 */
public class YscimcActivityTransformationVo {
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
     *访问用户数
     */
    private String userVisitNumber;
    /**
     *高质量用户数
     */
    private String highQualityUserNumber;
    /**
     * 参与用户数
     */
    private String participateUserNumber;
    /**
     * 找回客户数
     */
    private String getbackUserNumber;
    /**
     * 产品交易量
     */
    private String productTradeNumber;
    /**
     * 新用户数
     */
    private String newCustomerNumber;
    /**
     * 活跃用户数
     */
    private String activeCustomerNumber;
    /**
     * 转发量
     */
    private String transmitNumber;
    /**
     * 二次转发量
     */
    private String twiceTransmitNumber;

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

    public String getUserVisitNumber() {
        return userVisitNumber;
    }

    public void setUserVisitNumber(String userVisitNumber) {
        this.userVisitNumber = userVisitNumber;
    }

    public String getHighQualityUserNumber() {
        return highQualityUserNumber;
    }

    public void setHighQualityUserNumber(String highQualityUserNumber) {
        this.highQualityUserNumber = highQualityUserNumber;
    }

    public String getParticipateUserNumber() {
        return participateUserNumber;
    }

    public void setParticipateUserNumber(String participateUserNumber) {
        this.participateUserNumber = participateUserNumber;
    }

    public String getGetbackUserNumber() {
        return getbackUserNumber;
    }

    public void setGetbackUserNumber(String getbackUserNumber) {
        this.getbackUserNumber = getbackUserNumber;
    }

    public String getProductTradeNumber() {
        return productTradeNumber;
    }

    public void setProductTradeNumber(String productTradeNumber) {
        this.productTradeNumber = productTradeNumber;
    }

    public String getNewCustomerNumber() {
        return newCustomerNumber;
    }

    public void setNewCustomerNumber(String newCustomerNumber) {
        this.newCustomerNumber = newCustomerNumber;
    }

    public String getActiveCustomerNumber() {
        return activeCustomerNumber;
    }

    public void setActiveCustomerNumber(String activeCustomerNumber) {
        this.activeCustomerNumber = activeCustomerNumber;
    }

    public String getTransmitNumber() {
        return transmitNumber;
    }

    public void setTransmitNumber(String transmitNumber) {
        this.transmitNumber = transmitNumber;
    }

    public String getTwiceTransmitNumber() {
        return twiceTransmitNumber;
    }

    public void setTwiceTransmitNumber(String twiceTransmitNumber) {
        this.twiceTransmitNumber = twiceTransmitNumber;
    }
}
