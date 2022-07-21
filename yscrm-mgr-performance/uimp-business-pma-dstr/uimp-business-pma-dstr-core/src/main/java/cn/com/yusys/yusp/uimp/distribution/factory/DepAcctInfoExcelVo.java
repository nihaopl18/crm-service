package cn.com.yusys.yusp.uimp.distribution.factory;

import javax.persistence.Column;

/**
 * @author:Mr.raop
 * @create:2022-06-07
 */
public class DepAcctInfoExcelVo {

    /** 客户号 **/
    @Column(name = "cust_number", unique = false, nullable = true, length = 64)
    private String	custNumber ;//客户号

    /** 客户名称 **/
    @Column(name = "cust_name", unique = false, nullable = true, length = 128)
    private String	custName   ;//客户名称

    /** 主账号 **/
    @Column(name = "acct_no", unique = false, nullable = true, length = 64)
    private String	acctNo     ;//主账号

    /** 子账号 **/
    @Column(name = "sub_acct_no", unique = false, nullable = true, length = 64)
    private String	subAcctNo ;//子账号

    /** 账户类型 **/
    @Column(name = "account_type", unique = false, nullable = true, length = 16)
    private String	accountType;//账户类型

    /** 开户机构号 **/
    @Column(name = "org_id", unique = false, nullable = true, length = 32)
    private String	orgId      ;//开户机构号

    /** 开户机构名称 **/
    @Column(name = "org_name", unique = false, nullable = true, length = 32)
    private String	orgName    ;//开户机构名称

    /** 开户日期 **/
    @Column(name = "open_date", unique = false, nullable = true, length = 32)
    private String	openDate   ;//开户日期

    /** 余额 **/
    @Column(name = "balance", unique = false, nullable = true, length = 24)
    private String	balance     ;//余额


    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    @Override
    public String toString() {
        return "DepAcctInfoExcelVo{" +
                "custNumber='" + custNumber + '\'' +
                ", custName='" + custName + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", subAcctNo='" + subAcctNo + '\'' +
                ", accountType='" + accountType + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", openDate='" + openDate + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
