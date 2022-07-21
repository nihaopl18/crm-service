package cn.com.yusys.yscimc.operation.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用于统计事件类型活动
 * @Author Lenovo
 * @Data 2022/3/17 14:14
 */
@Table(name = "ACTIVITY_EVENT_RESULT")
public class ActivityEventResultEntity {

    //主键id
    @Id
    @Column(name = "ID")
    private String id;

    //引擎事务id
    @Column(name = "OUT_TRADE_NO")
    private String outTradeNo;

    //来源渠道
    @Column(name = "CHANNEL_CODE")
    private String channelCode;

    //事件对应表（有该值表示：批量事件，没有该值表示：实时事件）
    @Column(name = "TRANS_CODE")
    private String transCode;

    //关联活动id
    @Column(name = "ACTIVITY_ID")
    private String activityId;

    //客户id
    @Column(name = "CUSTOMER_ID")
    private String customerId;

    //法人号
    @Column(name = "CORP_NO")
    private String corpNo;

    //请求时间
    @Column(name = "REQ_TIME")
    private String reqTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
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

    public String getCorpNo() {
        return corpNo;
    }

    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }
}
