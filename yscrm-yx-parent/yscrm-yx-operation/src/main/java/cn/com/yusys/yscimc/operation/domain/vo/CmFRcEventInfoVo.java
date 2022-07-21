package cn.com.yusys.yscimc.operation.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CmFRcEventInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //事件id
    private String eventId;
    //事件类别id
    private String eventTypeId;
    //事件名称
    private String eventName;
    //开始日期
    private String beginDate;
    //结束日期
    private String endDate;
    //优先级
    private BigDecimal eventPriority;
    //审批状态
    private String wfApprSts;
    //启停标志[其停用标示，0停用，1使用，数据字典定义]
    private String useFlag;
    //备注
    private String remark;
    //删除标识
    private String deleteSign;
    //创建人
    private String createUser;
    //创建日期
    private String createDate;
    //创建机构
    private String createOrg;
    //最近修改人
    private String updateUser;
    //最近修改时间
    private String updateDate;
    //最近修改机构
    private String updateOrg;
    //交易类型[代码]
    private String transactionCode;
    //比较条件(引擎解析的值)
    private String condition;
    //事件描述
    private String ruleDesc;
    //组件id
    private String assemblyId;
    //交易类型（批量、实时）
    private String transactionType;
    //策划活动id
    private String activityId;
    //id
    private long id;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(String eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getEventPriority() {
        return eventPriority;
    }

    public void setEventPriority(BigDecimal eventPriority) {
        this.eventPriority = eventPriority;
    }

    public String getWfApprSts() {
        return wfApprSts;
    }

    public void setWfApprSts(String wfApprSts) {
        this.wfApprSts = wfApprSts;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeleteSign() {
        return deleteSign;
    }

    public void setDeleteSign(String deleteSign) {
        this.deleteSign = deleteSign;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOrg() {
        return updateOrg;
    }

    public void setUpdateOrg(String updateOrg) {
        this.updateOrg = updateOrg;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(String assemblyId) {
        this.assemblyId = assemblyId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
