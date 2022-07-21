package cn.com.yusys.yusp.cm.monitoring.entity;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/12 - 17:53
 */
@Entity
@Table(name="YSCIMC_ACTIVITY_TRANSFORMATION")
public class YscimcActivityTransformationPo extends BaseDomain implements Serializable {
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
     *访问用户数
     */
    @Column(name="USER_VISIT_NUMBER")
    private String userVisitNumber;
    /**
     *高质量用户数
     */
    @Column(name="HIGH_QUALITY_USER_NUMBER")
    private String highQualityUserNumber;
    /**
     * 参与用户数
     */
    @Column(name="PARTICIPATE_USER_NUMBER")
    private String participateUserNumber;
    /**
     * 找回客户数
     */
    @Column(name="GETBACK_USER_NUMBER")
    private String getbackUserNumber;
    /**
     * 产品交易量
     */
    @Column(name="PRODUCT_TRADE_NUMBER")
    private String productTradeNumber;
    /**
     * 新用户数
     */
    @Column(name="NEW_CUSTOMER_NUMBER")
    private String newCustomerNumber;
    /**
     * 活跃用户数
     */
    @Column(name="ACTIVE_CUSTOMER_NUMBER")
    private String activeCustomerNumber;
    /**
     * 转发量
     */
    @Column(name="TRANSMIT_NUMBER")
    private String transmitNumber;
    /**
     * 二次转发量
     */
    @Column(name="TWICE_TRANSMIT_NUMBER")
    private String twiceTransmitNumber;

    public YscimcActivityTransformationPo() {
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
