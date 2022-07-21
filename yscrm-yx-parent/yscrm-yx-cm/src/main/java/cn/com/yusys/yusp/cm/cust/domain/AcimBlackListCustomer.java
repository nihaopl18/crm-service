package cn.com.yusys.yusp.cm.cust.domain;

/**
 * 黑名单客户信息
 */
public class AcimBlackListCustomer {
    //客户编号
    private String custId;
    //客户类型
    private String custType;
    //证件号码
    private String identNo;
    //客户名称
    private String custName;
    //联系方式
    private String contactNumber;
    //归属机构
    private String belongOrg;
    //归属客户经理
    private String belongMgr;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getIdentNo() {
        return identNo;
    }

    public void setIdentNo(String identNo) {
        this.identNo = identNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBelongOrg() {
        return belongOrg;
    }

    public void setBelongOrg(String belongOrg) {
        this.belongOrg = belongOrg;
    }

    public String getBelongMgr() {
        return belongMgr;
    }

    public void setBelongMgr(String belongMgr) {
        this.belongMgr = belongMgr;
    }
}
