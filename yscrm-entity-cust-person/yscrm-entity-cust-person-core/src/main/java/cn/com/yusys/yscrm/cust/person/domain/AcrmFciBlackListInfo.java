package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciBlackListInfo
 * @类描述: #数据实体类
 * @功能描述: 黑名单信息
 * @创建人: 15104
 * @创建时间: 2019-02-13 09:43:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_BLACK_LIST_INFO")
public class AcrmFciBlackListInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 7)
	private Date dataDate;
	
	/** 最新更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间
 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = false, length = 10)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = false, length = 40)
	private String custId;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 账号
 **/
	@Column(name = "ACCT_ID", unique = false, nullable = true, length = 32)
	private String acctId;
	
	/** 黑名单类型
 **/
	@Column(name = "BLACK_TYPE", unique = false, nullable = true, length = 20)
	private String blackType;
	
	/** 黑名单描述
 **/
	@Column(name = "BLACK_DESC", unique = false, nullable = true, length = 400)
	private String blackDesc;
	
	/** 发布机构
 **/
	@Column(name = "ISSUE_INST", unique = false, nullable = true, length = 20)
	private String issueInst;
	
	/** 进入黑名单日期
 **/
	@Column(name = "ENTR_DATE", unique = false, nullable = true, length = 7)
	private Date entrDate;
	
	/** 解除黑名单日期
 **/
	@Column(name = "REMV_DATE", unique = false, nullable = true, length = 7)
	private Date remvDate;
	
	/** 登记人
 **/
	@Column(name = "INPUT_ID", unique = false, nullable = true, length = 20)
	private String inputId;
	
	/** 登记日期
 **/
	@Column(name = "INPUT_DATE", unique = false, nullable = true, length = 7)
	private Date inputDate;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return DataDate
     */	
	public Date getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param acctId
	 */
	public void setAcctId(String acctId) {
		this.acctId = acctId == null ? null : acctId.trim();
	}
	
    /**
     * @return AcctId
     */	
	public String getAcctId() {
		return this.acctId;
	}
	
	/**
	 * @param blackType
	 */
	public void setBlackType(String blackType) {
		this.blackType = blackType == null ? null : blackType.trim();
	}
	
    /**
     * @return BlackType
     */	
	public String getBlackType() {
		return this.blackType;
	}
	
	/**
	 * @param blackDesc
	 */
	public void setBlackDesc(String blackDesc) {
		this.blackDesc = blackDesc == null ? null : blackDesc.trim();
	}
	
    /**
     * @return BlackDesc
     */	
	public String getBlackDesc() {
		return this.blackDesc;
	}
	
	/**
	 * @param issueInst
	 */
	public void setIssueInst(String issueInst) {
		this.issueInst = issueInst == null ? null : issueInst.trim();
	}
	
    /**
     * @return IssueInst
     */	
	public String getIssueInst() {
		return this.issueInst;
	}
	
	/**
	 * @param entrDate
	 */
	public void setEntrDate(Date entrDate) {
		this.entrDate = entrDate;
	}
	
    /**
     * @return EntrDate
     */	
	public Date getEntrDate() {
		return this.entrDate;
	}
	
	/**
	 * @param remvDate
	 */
	public void setRemvDate(Date remvDate) {
		this.remvDate = remvDate;
	}
	
    /**
     * @return RemvDate
     */	
	public Date getRemvDate() {
		return this.remvDate;
	}
	
	/**
	 * @param inputId
	 */
	public void setInputId(String inputId) {
		this.inputId = inputId == null ? null : inputId.trim();
	}
	
    /**
     * @return InputId
     */	
	public String getInputId() {
		return this.inputId;
	}
	
	/**
	 * @param inputDate
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
    /**
     * @return InputDate
     */	
	public Date getInputDate() {
		return this.inputDate;
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
        AcrmFciBlackListInfo other = (AcrmFciBlackListInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getAcctId() == null ? other.getAcctId() == null : this.getAcctId().equals(other.getAcctId()))
        	&& (this.getBlackType() == null ? other.getBlackType() == null : this.getBlackType().equals(other.getBlackType()))
        	&& (this.getBlackDesc() == null ? other.getBlackDesc() == null : this.getBlackDesc().equals(other.getBlackDesc()))
        	&& (this.getIssueInst() == null ? other.getIssueInst() == null : this.getIssueInst().equals(other.getIssueInst()))
                        	&& (this.getInputId() == null ? other.getInputId() == null : this.getInputId().equals(other.getInputId()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getAcctId() == null) ? 0 : getAcctId().hashCode());
        result = prime * result + ((getBlackType() == null) ? 0 : getBlackType().hashCode());
        result = prime * result + ((getBlackDesc() == null) ? 0 : getBlackDesc().hashCode());
        result = prime * result + ((getIssueInst() == null) ? 0 : getIssueInst().hashCode());
        result = prime * result + ((getInputId() == null) ? 0 : getInputId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", acctId=").append(acctId);
		sb.append(", blackType=").append(blackType);
		sb.append(", blackDesc=").append(blackDesc);
		sb.append(", issueInst=").append(issueInst);
		sb.append(", entrDate=").append(entrDate);
		sb.append(", remvDate=").append(remvDate);
		sb.append(", inputId=").append(inputId);
		sb.append(", inputDate=").append(inputDate);
        sb.append("]");
        return sb.toString();
    }
}