package cn.com.yusys.yscrm.cust.person.domain;



import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerOthbankDep
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-15 11:01:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_OTHBANK_DEP")
public class OcrmFciPerOthbankDep extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期 **/
	
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最新更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 开户机构名称 **/
	@Column(name = "OPEN_BRCH_NAME", unique = false, nullable = true, length = 200)
	private String openBrchName;
	
	/** 他行存款类型 **/
	@Column(name = "DEPT_TYPE", unique = false, nullable = true, length = 30)
	private String deptType;
	
	/** 他行定期到期日 **/
	@Column(name = "TDEP_DUE_DT", unique = false, nullable = true, length = 8)
	private String tdepDueDt;
	
	/** 账号 **/
	@Column(name = "ACCT_ID", unique = false, nullable = true, length = 32)
	private String acctId;
	
	/** 币种 **/
	@Column(name = "CURR_CD", unique = false, nullable = true, length = 20)
	private String currCd;
	
	/** 存款余额 **/
	@Column(name = "DEPT_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal deptBal;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String id;
	
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
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
	 * @param openBrchName
	 */
	public void setOpenBrchName(String openBrchName) {
		this.openBrchName = openBrchName == null ? null : openBrchName.trim();
	}
	
    /**
     * @return OpenBrchName
     */	
	public String getOpenBrchName() {
		return this.openBrchName;
	}
	
	/**
	 * @param deptType
	 */
	public void setDeptType(String deptType) {
		this.deptType = deptType == null ? null : deptType.trim();
	}
	
    /**
     * @return DeptType
     */	
	public String getDeptType() {
		return this.deptType;
	}
	
	/**
	 * @param tdepDueDt
	 */
	public void setTdepDueDt(String tdepDueDt) {
		this.tdepDueDt = tdepDueDt == null ? null : tdepDueDt.trim();
	}
	
    /**
     * @return TdepDueDt
     */	
	public String getTdepDueDt() {
		return this.tdepDueDt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd == null ? null : currCd.trim();
	}
	
    /**
     * @return CurrCd
     */	
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * @param deptBal
	 */
	public void setDeptBal(java.math.BigDecimal deptBal) {
		this.deptBal = deptBal;
	}
	
    /**
     * @return DeptBal
     */	
	public java.math.BigDecimal getDeptBal() {
		return this.deptBal;
	}
	
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
        OcrmFciPerOthbankDep other = (OcrmFciPerOthbankDep) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getOpenBrchName() == null ? other.getOpenBrchName() == null : this.getOpenBrchName().equals(other.getOpenBrchName()))
        	&& (this.getDeptType() == null ? other.getDeptType() == null : this.getDeptType().equals(other.getDeptType()))
        	&& (this.getTdepDueDt() == null ? other.getTdepDueDt() == null : this.getTdepDueDt().equals(other.getTdepDueDt()))
        	&& (this.getAcctId() == null ? other.getAcctId() == null : this.getAcctId().equals(other.getAcctId()))
        	&& (this.getCurrCd() == null ? other.getCurrCd() == null : this.getCurrCd().equals(other.getCurrCd()))
                	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getOpenBrchName() == null) ? 0 : getOpenBrchName().hashCode());
        result = prime * result + ((getDeptType() == null) ? 0 : getDeptType().hashCode());
        result = prime * result + ((getTdepDueDt() == null) ? 0 : getTdepDueDt().hashCode());
        result = prime * result + ((getAcctId() == null) ? 0 : getAcctId().hashCode());
        result = prime * result + ((getCurrCd() == null) ? 0 : getCurrCd().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", openBrchName=").append(openBrchName);
		sb.append(", deptType=").append(deptType);
		sb.append(", tdepDueDt=").append(tdepDueDt);
		sb.append(", acctId=").append(acctId);
		sb.append(", currCd=").append(currCd);
		sb.append(", deptBal=").append(deptBal);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}