package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author:Mr.raop
 * @create:2022-05-13
 * 贷款业绩分配信息表
 */
@Entity
@Table(name = "PMA_F_COM_DEP_LOANS_INFO")
public class PmaFComDepLoansInfo extends BaseDomain implements Serializable {

    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    private String id          ;

    /** 借据号 **/
    @Column(name = "bill_no", unique = false, nullable = true, length = 32)
    private String billNo      ;

    /** 合同号 **/
    @Column(name = "contract_no", unique = false, nullable = true, length = 100)
    private String contractNo  ;

    /** 客户号 **/
    @Column(name = "cust_id", unique = false, nullable = true, length = 100)
    private String custId      ;

    /** 客户名称 **/
    @Column(name = "cust_name", unique = false, nullable = true, length = 100)
    private String custName    ;

    /** 发放日期 **/
    @Column(name = "open_date", unique = false, nullable = true, length = 100)
    private String openDate    ;

    /** 到期日期 **/
    @Column(name = "due_date", unique = false, nullable = true, length = 20)
    private String dueDate     ;

    /** 销户日期 **/
    @Column(name = "cancel_date", unique = false, nullable = true, length = 20)
    private String cancelDate  ;

    /** 贷款金额 **/
    @Column(name = "l_amt", unique = false, nullable = true, length = 200)
    private String lAmt        ;

    /** 贷款余额 **/
    @Column(name = "l_bal", unique = false, nullable = true, length = 200)
    private String lBal        ;

    /** 贷款类型 **/
    @Column(name = "loan_type", unique = false, nullable = true, length = 100)
    private String loanType    ;

    /** 贷款期限 **/
    @Column(name = "l_period", unique = false, nullable = true, length = 100)
    private String lPeriod     ;

    /** 五级分类 **/
    @Column(name = "cla_five", unique = false, nullable = true, length = 100)
    private String claFive     ;

    /** 放款机构号 **/
    @Column(name = "org_id", unique = false, nullable = true, length = 100)
    private String orgId       ;

    /** 放款机构名称 **/
    @Column(name = "org_name", unique = false, nullable = true, length = 100)
    private String orgName     ;

    /** 分配状态 **/
    @Column(name = "dstr_sts", unique = false, nullable = true, length = 2)
    private String dstrSts     ;

    /** 审批状态 **/
    @Column(name = "apply_sts", unique = false, nullable = true, length = 10)
    private String	applySts    ;

    /** 创建者ID **/
    @Column(name = "creator", unique = false, nullable = true, length = 32)
    private String creator     ;

    /** 创建日期 **/
    @Column(name = "create_date", unique = false, nullable = true, length = 20)
    private String createDate  ;

    /** 创建机构 **/
    @Column(name = "create_org", unique = false, nullable = true, length = 32)
    private String createOrg   ;

    /** 修改者ID **/
    @Column(name = "updater_id", unique = false, nullable = true, length = 32)
    private String updaterId   ;

    /** 修改日期 **/
    @Column(name = "update_date", unique = false, nullable = true, length = 20)
    private String updateDate  ;

    /** 修改机构 **/
    @Column(name = "update_org", unique = false, nullable = true, length = 32)
    private String updateOrg   ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getlAmt() {
        return lAmt;
    }

    public void setlAmt(String lAmt) {
        this.lAmt = lAmt;
    }

    public String getlBal() {
        return lBal;
    }

    public void setlBal(String lBal) {
        this.lBal = lBal;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getlPeriod() {
        return lPeriod;
    }

    public void setlPeriod(String lPeriod) {
        this.lPeriod = lPeriod;
    }

    public String getClaFive() {
        return claFive;
    }

    public void setClaFive(String claFive) {
        this.claFive = claFive;
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

    public String getDstrSts() {
        return dstrSts;
    }

    public void setDstrSts(String dstrSts) {
        this.dstrSts = dstrSts;
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
}
