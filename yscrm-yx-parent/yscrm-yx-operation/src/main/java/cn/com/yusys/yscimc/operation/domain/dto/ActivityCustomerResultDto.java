package cn.com.yusys.yscimc.operation.domain.dto;

/**
 * @Author Lenovo
 * @Data 2022/3/8 10:02
 */
public class ActivityCustomerResultDto {

    private String activityId;

    private String customerId;

    private String customerName;

    // 发送的短信
    private String marketMessage;

    private String productId;

    private String productName;

    // 话术 ID
    private String applyId;

    // 使用的话术名称
    private String applyName;

    // 动作类型： 风险 | 商机 | 关怀
    private String actionType;

    private String channelId;

    private String channelName;

    private String sendTime;

    // 已发送:send | 发送成功:success | 发送失败:failure
    private String resultType;

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
