package cn.com.yusys.yscimc.operation.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author Lenovo
 * @Data 2022/3/8 11:30
 */
@Table(name = "ACTIVITY_CUSTOMER_RESULT")
public class ActivityCustomerResultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "RESULT_ID")
    private String resultId;

    @Column(name = "ACTIVITY_ID")
    private String activityId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    // 发送的短信
    @Column(name = "MARKET_MESSAGE")
    private String marketMessage;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    // 话术 ID
    @Column(name = "APPLY_ID")
    private String applyId;

    // 使用的话术名称
    @Column(name = "APPLY_NAME")
    private String applyName;

    // 动作类型： 风险 | 商机 | 关怀
    @Column(name = "ACTION_TYPE")
    private String actionType;

    @Column(name = "CHANNEL_ID")
    private String channelId;

    @Column(name = "CHANNEL_NAME")
    private String channelName;

    @Column(name = "SEND_TIME")
    private String sendTime;

    // 已发送:send | 发送成功:success | 发送失败:failure
    @Column(name = "RESULT_TYPE")
    private String resultType;

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMarketMessage() {
        return marketMessage;
    }

    public void setMarketMessage(String marketMessage) {
        this.marketMessage = marketMessage;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
