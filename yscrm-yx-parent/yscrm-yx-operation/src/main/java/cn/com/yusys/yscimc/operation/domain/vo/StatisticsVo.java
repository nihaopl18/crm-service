package cn.com.yusys.yscimc.operation.domain.vo;

import javax.validation.constraints.NotEmpty;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/1/13 16:08
 */
public class StatisticsVo {

    @NotEmpty
    private String nodeId;

    @NotEmpty
    private String assemblyType;

    private String invitee;

    private String receiver;

    private String phoneNum;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAssemblyType() {
        return assemblyType;
    }

    public void setAssemblyType(String assemblyType) {
        this.assemblyType = assemblyType;
    }

    public String getInvitee() {
        return invitee;
    }

    public void setInvitee(String invitee) {
        this.invitee = invitee;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "StatisticsVo{" +
                "nodeId='" + nodeId + '\'' +
                ", assemblyType='" + assemblyType + '\'' +
                ", invitee='" + invitee + '\'' +
                ", receiver='" + receiver + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
