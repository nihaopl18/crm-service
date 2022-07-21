package cn.com.yusys.yscrm.pcrm.common.remindInfo.domain;

import java.io.Serializable;

public class EchainJoinWorkTodoDTO implements Serializable {
    private String instanceId;
    private String mainInstanceId;
    private String wfId;
    private String wfName;
    private String wfSign;
    private String wfJobName;
    private String custId;
    private String custName;
    private String wfStartTime;
    private String author;
    private String bizSeqNo;
    private String preNodeId;
    private String preNodeName;
    private String nodeId;
    private String nodeSign;
    private String nodeName;
    private String nodeStatus;
    private String nodeStartTime;
    private String nodeAcceptTime;
    private String nodePlanEndTime;
    private String currentNodeUser;
    private String currentNodeUsers;
    private String originalUsers;
    private String userName;
    private String wfAppId;//申请类型

    public String getNodeSign() {
        return nodeSign;
    }

    public void setNodeSign(String nodeSign) {
        this.nodeSign = nodeSign;
    }

    public String getWfAppId() {
        return wfAppId;
    }

    public void setWfAppId(String wfAppId) {
        this.wfAppId = wfAppId;
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

    public String getWfStartTime() {
        return wfStartTime;
    }

    public void setWfStartTime(String wfStartTime) {
        this.wfStartTime = wfStartTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBizSeqNo() {
        return bizSeqNo;
    }

    public void setBizSeqNo(String bizSeqNo) {
        this.bizSeqNo = bizSeqNo;
    }

    public String getPreNodeId() {
        return preNodeId;
    }

    public void setPreNodeId(String preNodeId) {
        this.preNodeId = preNodeId;
    }

    public String getPreNodeName() {
        return preNodeName;
    }

    public void setPreNodeName(String preNodeName) {
        this.preNodeName = preNodeName;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public String getNodeStartTime() {
        return nodeStartTime;
    }

    public void setNodeStartTime(String nodeStartTime) {
        this.nodeStartTime = nodeStartTime;
    }

    public String getNodeAcceptTime() {
        return nodeAcceptTime;
    }

    public void setNodeAcceptTime(String nodeAcceptTime) {
        this.nodeAcceptTime = nodeAcceptTime;
    }

    public String getNodePlanEndTime() {
        return nodePlanEndTime;
    }

    public void setNodePlanEndTime(String nodePlanEndTime) {
        this.nodePlanEndTime = nodePlanEndTime;
    }

    public String getCurrentNodeUser() {
        return currentNodeUser;
    }

    public void setCurrentNodeUser(String currentNodeUser) {
        this.currentNodeUser = currentNodeUser;
    }

    public String getCurrentNodeUsers() {
        return currentNodeUsers;
    }

    public void setCurrentNodeUsers(String currentNodeUsers) {
        this.currentNodeUsers = currentNodeUsers;
    }

    public String getOriginalUsers() {
        return originalUsers;
    }

    public void setOriginalUsers(String originalUsers) {
        this.originalUsers = originalUsers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
