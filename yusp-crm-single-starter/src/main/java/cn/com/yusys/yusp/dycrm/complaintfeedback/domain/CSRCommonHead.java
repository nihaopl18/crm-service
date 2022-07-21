package cn.com.yusys.yusp.dycrm.complaintfeedback.domain;

public class CSRCommonHead {
    /**
     * 报文头节点
     */
    private String serviceCode = ""; //交易代码
    private String updatedSystemId = ""; //更新系统号
    private String SrcCreateTs = "";//源系统创建时间
    private String srcUpdatedTs = ""; //交易处理时间
    private String updatedUser = ""; //操作客户经理编号
    private String updatedUnit =""; //操作分行
    private String flowId = ""; //流水号
    private String errorCode = "000000"; //返回码
    private String errorMsg = "CRM查询成功"; //返回信息

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getUpdatedSystemId() {
        return updatedSystemId;
    }

    public void setUpdatedSystemId(String updatedSystemId) {
        this.updatedSystemId = updatedSystemId;
    }

    public String getSrcCreateTs() {
        return SrcCreateTs;
    }

    public void setSrcCreateTs(String srcCreateTs) {
        SrcCreateTs = srcCreateTs;
    }

    public String getSrcUpdatedTs() {
        return srcUpdatedTs;
    }

    public void setSrcUpdatedTs(String srcUpdatedTs) {
        this.srcUpdatedTs = srcUpdatedTs;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public String getUpdatedUnit() {
        return updatedUnit;
    }

    public void setUpdatedUnit(String updatedUnit) {
        this.updatedUnit = updatedUnit;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
