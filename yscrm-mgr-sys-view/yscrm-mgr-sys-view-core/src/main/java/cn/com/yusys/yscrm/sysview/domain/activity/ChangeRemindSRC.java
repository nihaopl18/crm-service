package cn.com.yusys.yscrm.sysview.domain.activity;

public class ChangeRemindSRC {

    /**
     * 数量
     */
    private Integer count;
    /**
     * 类型
     */
    private String typeId;
    /**
     * 平均处理时效
     */
    private Integer aging;
    /**
     * 客户Id
     */
    private String custId;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 理财客户经理
     */
    private String finaningMgrUserName;
    /**
     * 个贷客户经理
     */
    private String loanMgrUserName;
    /**
     * 状态
     */
    private String state;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getAging() {
        return aging;
    }

    public void setAging(Integer aging) {
        this.aging = aging;
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

    public String getFinaningMgrUserName() {
        return finaningMgrUserName;
    }

    public void setFinaningMgrUserName(String finaningMgrUserName) {
        this.finaningMgrUserName = finaningMgrUserName;
    }

    public String getLoanMgrUserName() {
        return loanMgrUserName;
    }

    public void setLoanMgrUserName(String loanMgrUserName) {
        this.loanMgrUserName = loanMgrUserName;
    }
}
