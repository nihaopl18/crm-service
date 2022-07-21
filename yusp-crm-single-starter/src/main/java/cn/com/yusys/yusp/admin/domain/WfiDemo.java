package cn.com.yusys.yusp.admin.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "WFI_DEMO")
public class WfiDemo extends BaseDomain implements Serializable {
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

    @Column(name = "SEX")
    private String sex;

    @Column(name = "HIGHEST_EDU")
    private String highestEdu;

    @Column(name = "MONEY")
    private String money;

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
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * @return HIGHEST_EDU
     */
    public String getHighestEdu() {
        return highestEdu;
    }

    /**
     * @param highestEdu
     */
    public void setHighestEdu(String highestEdu) {
        this.highestEdu = highestEdu == null ? null : highestEdu.trim();
    }

    /**
     * @return MONEY
     */
    public String getMoney() {
        return money;
    }

    /**
     * @param money
     */
    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
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
        WfiDemo other = (WfiDemo) that;
        return (this.getLogicSeq() == null ? other.getLogicSeq() == null : this.getLogicSeq().equals(other.getLogicSeq()))
            && (this.getCurrentAction() == null ? other.getCurrentAction() == null : this.getCurrentAction().equals(other.getCurrentAction()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
            && (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
            && (this.getNodeId() == null ? other.getNodeId() == null : this.getNodeId().equals(other.getNodeId()))
            && (this.getNodeUser() == null ? other.getNodeUser() == null : this.getNodeUser().equals(other.getNodeUser()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getHighestEdu() == null ? other.getHighestEdu() == null : this.getHighestEdu().equals(other.getHighestEdu()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()));
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
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getHighestEdu() == null) ? 0 : getHighestEdu().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
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
        sb.append(", sex=").append(sex);
        sb.append(", highestEdu=").append(highestEdu);
        sb.append(", money=").append(money);
        sb.append("]");
        return sb.toString();
    }
}