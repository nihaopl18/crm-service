package cn.com.yusys.yscrm.pcrm.common.remindInfo.domain;

public class EchainJoinWorkEndDTO {
    private String instanceId;
    private String mainInstanceId;
    private String wfId;
    private String wfName;
    private String wfSign;
    private String wfJobName;
    private String custId;
    private String custName;
    private String wfStartTime;
    private String wfEndTime;
    private String author;
    private String spStatus;
    private String lastUser;
    private String costTimes;
    private String bizSeqNo;
    private String userName;
    
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getMainInstanceId() {
        return mainInstanceId;
    }

    public void setMainInstanceId(String mainInstanceId) {
        this.mainInstanceId = mainInstanceId;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    public String getWfSign() {
        return wfSign;
    }

    public void setWfSign(String wfSign) {
        this.wfSign = wfSign;
    }

    public String getWfJobName() {
        return wfJobName;
    }

    public void setWfJobName(String wfJobName) {
        this.wfJobName = wfJobName;
    }

    public String getWfStartTime() {
        return wfStartTime;
    }

    public void setWfStartTime(String wfStartTime) {
        this.wfStartTime = wfStartTime;
    }

    public String getWfEndTime() {
        return wfEndTime;
    }

    public void setWfEndTime(String wfEndTime) {
        this.wfEndTime = wfEndTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSpStatus() {
        return spStatus;
    }

    public void setSpStatus(String spStatus) {
        this.spStatus = spStatus;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public String getCostTimes() {
        return costTimes;
    }

    public void setCostTimes(String costTimes) {
        this.costTimes = costTimes;
    }

    public String getBizSeqNo() {
        return bizSeqNo;
    }

    public void setBizSeqNo(String bizSeqNo) {
        this.bizSeqNo = bizSeqNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
