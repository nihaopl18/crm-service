package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @author:Mr.raop
 * @create:2022-05-07
 * 存款业绩分配信息表
 */
@Entity
@Table(name = "PMA_F_COM_DEP_ACCT_INFO")
public class PmaFComDepAcctInfo extends BaseDomain implements Serializable {

    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    private String	id			;

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

    /** 销户日期 **/
    @Column(name = "close_date", unique = false, nullable = true, length = 32)
    private String	closeDate  ;//销户日期

    /** 分配状态 **/
    @Column(name = "dstr_sts", unique = false, nullable = true, length = 16)
    private String	dstrSts    ;//分配状态

    /** 余额 **/
    @Column(name = "balance", unique = false, nullable = true, length = 24)
    private String	balance     ;//余额

    /** 审批状态 **/
    @Column(name = "apply_sts", unique = false, nullable = true, length = 10)
    private String	applySts    ;

    /** 创建者ID **/
    @Column(name = "creator", unique = false, nullable = true, length = 32)
    private String creator      ;

    /** 创建日期 **/
    @Column(name = "create_date", unique = false, nullable = true, length = 32)
    private String createDate  ;

    /** 创建机构 **/
    @Column(name = "create_org", unique = false, nullable = true, length = 32)
    private String createOrg   ;

    /** 修改者ID **/
    @Column(name = "updater_id", unique = false, nullable = true, length = 32)
    private String updaterId   ;

    /** 修改日期 **/
    @Column(name = "update_date", unique = false, nullable = true, length = 32)
    private String updateDate  ;

    /** 修改机构 **/
    @Column(name = "update_org", unique = false, nullable = true, length = 32)
    private String updateOrg   ;

    private List<PmaFComDepPeriod> pmaFComDepPeriodList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getDstrSts() {
        return dstrSts;
    }

    public void setDstrSts(String dstrSts) {
        this.dstrSts = dstrSts;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getApplySts() {
        return applySts;
    }

    public void setApplySts(String applySts) {
        this.applySts = applySts;
    }


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
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

    public List<PmaFComDepPeriod> getPmaFComDepPeriodList() {
        return pmaFComDepPeriodList;
    }

    public void setPmaFComDepPeriodList(List<PmaFComDepPeriod> pmaFComDepPeriodList) {
        this.pmaFComDepPeriodList = pmaFComDepPeriodList;
    }
}
