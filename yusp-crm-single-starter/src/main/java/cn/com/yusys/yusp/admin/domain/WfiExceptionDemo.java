package cn.com.yusys.yusp.admin.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "WFI_EXCEPTION_DEMO")
public class WfiExceptionDemo extends BaseDomain implements Serializable {
    @Id
    @Column(name = "LOGIC_SEQ")
    private String logicSeq;

    @Column(name = "CURRENT_ACTION")
    private String currentAction;

    @Column(name = "CUST_ID")
    private String custId;

    @Column(name = "CUST_NAME")
    private String custName;

    @Column(name = "INSTANCE_ID")
    private String instanceId;

    @Column(name = "NODE_ID")
    private String nodeId;

    @Column(name = "NODE_USER")
    private String nodeUser;

    @Column(name = "WF_SIGN")
    private String wfSign;

    @Column(name = "WF_NAME")
    private String wfName;

    @Column(name = "PRE_NODE_NAME")
    private String preNodeName;

    @Column(name = "PRE_USER")
    private String preUser;

    @Column(name = "NODE_START_TIME")
    private String nodeStartTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return LOGIC_SEQ
     */
    public String getLogicSeq() {
        return logicSeq;
    }

    /**
     * @param logicSeq
     */
    public void setLogicSeq(String logicSeq) {
        this.logicSeq = logicSeq == null ? null : logicSeq.trim();
    }

    /**
     * @return CURRENT_ACTION
     */
    public String getCurrentAction() {
        return currentAction;
    }

    /**
     * @param currentAction
     */
    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction == null ? null : currentAction.trim();
    }

    /**
     * @return CUST_ID
     */
    public String getCustId() {
        return custId;
    }

    /**
     * @param custId
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * @return CUST_NAME
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * @return INSTANCE_ID
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * @param instanceId
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId == null ? null : instanceId.trim();
    }

    /**
     * @return NODE_ID
     */
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    /**
     * @return NODE_USER
     */
    public String getNodeUser() {
        return nodeUser;
    }

    /**
     * @param nodeUser
     */
    public void setNodeUser(String nodeUser) {
        this.nodeUser = nodeUser == null ? null : nodeUser.trim();
    }

    /**
     * @return WF_SIGN
     */
    public String getWfSign() {
        return wfSign;
    }

    /**
     * @param wfSign
     */
    public void setWfSign(String wfSign) {
        this.wfSign = wfSign == null ? null : wfSign.trim();
    }

    /**
     * @return WF_NAME
     */
    public String getWfName() {
        return wfName;
    }

    /**
     * @param wfName
     */
    public void setWfName(String wfName) {
        this.wfName = wfName == null ? null : wfName.trim();
    }

    /**
     * @return PRE_NODE_NAME
     */
    public String getPreNodeName() {
        return preNodeName;
    }

    /**
     * @param preNodeName
     */
    public void setPreNodeName(String preNodeName) {
        this.preNodeName = preNodeName == null ? null : preNodeName.trim();
    }

    /**
     * @return PRE_USER
     */
    public String getPreUser() {
        return preUser;
    }

    /**
     * @param preUser
     */
    public void setPreUser(String preUser) {
        this.preUser = preUser == null ? null : preUser.trim();
    }

    /**
     * @return NODE_START_TIME
     */
    public String getNodeStartTime() {
        return nodeStartTime;
    }

    /**
     * @param nodeStartTime
     */
    public void setNodeStartTime(String nodeStartTime) {
        this.nodeStartTime = nodeStartTime == null ? null : nodeStartTime.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WfiExceptionDemo other = (WfiExceptionDemo) that;
        return (this.getLogicSeq() == null ? other.getLogicSeq() == null : this.getLogicSeq().equals(other.getLogicSeq()))
            && (this.getCurrentAction() == null ? other.getCurrentAction() == null : this.getCurrentAction().equals(other.getCurrentAction()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
            && (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
            && (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getNodeUser() == null ? other.getNodeUser() == null : this.getNodeUser().equals(other.getNodeUser()))
            && (this.getWfSign() == null ? other.getWfSign() == null : this.getWfSign().equals(other.getWfSign()))
            && (this.getWfName() == null ? other.getWfName() == null : this.getWfName().equals(other.getWfName()))
            && (this.getPreNodeName() == null ? other.getPreNodeName() == null : this.getPreNodeName().equals(other.getPreNodeName()))
            && (this.getPreUser() == null ? other.getPreUser() == null : this.getPreUser().equals(other.getPreUser()))
            && (this.getNodeStartTime() == null ? other.getNodeStartTime() == null : this.getNodeStartTime().equals(other.getNodeStartTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogicSeq() == null) ? 0 : getLogicSeq().hashCode());
        result = prime * result + ((getCurrentAction() == null) ? 0 : getCurrentAction().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
        result = prime * result + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
        result = prime * result + ((getNodeUser() == null) ? 0 : getNodeUser().hashCode());
        result = prime * result + ((getWfSign() == null) ? 0 : getWfSign().hashCode());
        result = prime * result + ((getWfName() == null) ? 0 : getWfName().hashCode());
        result = prime * result + ((getPreNodeName() == null) ? 0 : getPreNodeName().hashCode());
        result = prime * result + ((getPreUser() == null) ? 0 : getPreUser().hashCode());
        result = prime * result + ((getNodeStartTime() == null) ? 0 : getNodeStartTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logicSeq=").append(logicSeq);
        sb.append(", currentAction=").append(currentAction);
        sb.append(", custId=").append(custId);
        sb.append(", custName=").append(custName);
        sb.append(", instanceId=").append(instanceId);
        sb.append(", nodeId=").append(nodeId);
        sb.append(", nodeUser=").append(nodeUser);
        sb.append(", wfSign=").append(wfSign);
        sb.append(", wfName=").append(wfName);
        sb.append(", preNodeName=").append(preNodeName);
        sb.append(", preUser=").append(preUser);
        sb.append(", nodeStartTime=").append(nodeStartTime);
        sb.append("]");
        return sb.toString();
    }
}