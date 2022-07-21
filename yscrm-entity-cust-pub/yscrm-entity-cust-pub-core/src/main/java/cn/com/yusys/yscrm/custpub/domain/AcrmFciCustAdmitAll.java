package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciCustAdmitAll
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-28 10:20:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_CUST_ALL")
public class AcrmFciCustAdmitAll extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 最新更新系统 **/
	@Column(name = "LAST_UPDATE_SYS", unique = false, nullable = true, length = 20)
	private String lastUpdateSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 20)
	private String lastUpdateUser;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 7)
	private Date lastUpdateTm;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** ECIF客户标识 **/
	@Column(name = "ECIF_CUST_ID", unique = false, nullable = true, length = 40)
	private String ecifCustId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 1)
	private String custType;
	
	/** 客户状态 **/
	@Column(name = "CUST_STATUS", unique = false, nullable = true, length = 2)
	private String custStatus;
	@Column(name = "IS_ADMIT_ENTER", unique = false, nullable = true, length = 30)
	private String isAdmitEnter;
	public String getIsAdmitEnter() {
		return isAdmitEnter;
	}

	public void setIsAdmitEnter(String isAdmitEnter) {
		this.isAdmitEnter = isAdmitEnter;
	}
	/** 证件类型 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = true, length = 30)
	private String certType;
	
	/** 证件号码 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 50)
	private String certNo;
	
	/** 客户服务等级 **/
	@Column(name = "SERV_LEV", unique = false, nullable = true, length = 20)
	private String servLev;
	
	/** 客户价值等级 **/
	@Column(name = "VALUE_LEV", unique = false, nullable = true, length = 20)
	private String valueLev;
	
	/** 主办客户经理编号 **/
	@Column(name = "BELONG_MGR", unique = false, nullable = true, length = 40)
	private String belongMgr;
	
	/** 主办客户机构编号 **/
	@Column(name = "BELONG_BRCH", unique = false, nullable = true, length = 30)
	private String belongBrch;
	
	/** 业务条线 **/
	@Column(name = "BUSI_TYPE", unique = false, nullable = true, length = 30)
	private String busiType;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 8)
	private String createDate;
	
	/** 创建机构编号 **/
	@Column(name = "CREATE_BRCH_NO", unique = false, nullable = true, length = 20)
	private String createBrchNo;
	
	/** 创建人 **/
	@Column(name = "CREATE_TELLER_NO", unique = false, nullable = true, length = 20)
	private String createTellerNo;
	
	
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
	 * @param lastUpdateSys
	 */
	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys == null ? null : lastUpdateSys.trim();
	}
	
    /**
     * @return LastUpdateSys
     */	
	public String getLastUpdateSys() {
		return this.lastUpdateSys;
	}
	
	/**
	 * @param lastUpdateUser
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
	}
	
    /**
     * @return LastUpdateUser
     */	
	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}
	
	/**
	 * @param lastUpdateTm
	 */
	public void setLastUpdateTm(Date lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}
	
    /**
     * @return LastUpdateTm
     */	
	public Date getLastUpdateTm() {
		return this.lastUpdateTm;
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
	 * @param ecifCustId
	 */
	public void setEcifCustId(String ecifCustId) {
		this.ecifCustId = ecifCustId == null ? null : ecifCustId.trim();
	}
	
    /**
     * @return EcifCustId
     */	
	public String getEcifCustId() {
		return this.ecifCustId;
	}
	
	/**
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}
	
    /**
     * @return CustName
     */	
	public String getCustName() {
		return this.custName;
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
	 * @param custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus == null ? null : custStatus.trim();
	}
	
    /**
     * @return CustStatus
     */	
	public String getCustStatus() {
		return this.custStatus;
	}
	
	/**
	 * @param certType
	 */
	public void setCertType(String certType) {
		this.certType = certType == null ? null : certType.trim();
	}
	
    /**
     * @return CertType
     */	
	public String getCertType() {
		return this.certType;
	}
	
	/**
	 * @param certNo
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo == null ? null : certNo.trim();
	}
	
    /**
     * @return CertNo
     */	
	public String getCertNo() {
		return this.certNo;
	}
	
	/**
	 * @param servLev
	 */
	public void setServLev(String servLev) {
		this.servLev = servLev == null ? null : servLev.trim();
	}
	
    /**
     * @return ServLev
     */	
	public String getServLev() {
		return this.servLev;
	}
	
	/**
	 * @param valueLev
	 */
	public void setValueLev(String valueLev) {
		this.valueLev = valueLev == null ? null : valueLev.trim();
	}
	
    /**
     * @return ValueLev
     */	
	public String getValueLev() {
		return this.valueLev;
	}
	
	/**
	 * @param belongMgr
	 */
	public void setBelongMgr(String belongMgr) {
		this.belongMgr = belongMgr == null ? null : belongMgr.trim();
	}
	
    /**
     * @return BelongMgr
     */	
	public String getBelongMgr() {
		return this.belongMgr;
	}
	
	/**
	 * @param belongBrch
	 */
	public void setBelongBrch(String belongBrch) {
		this.belongBrch = belongBrch == null ? null : belongBrch.trim();
	}
	
    /**
     * @return BelongBrch
     */	
	public String getBelongBrch() {
		return this.belongBrch;
	}
	
	/**
	 * @param busiType
	 */
	public void setBusiType(String busiType) {
		this.busiType = busiType == null ? null : busiType.trim();
	}
	
    /**
     * @return BusiType
     */	
	public String getBusiType() {
		return this.busiType;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}
	
    /**
     * @return CreateDate
     */	
	public String getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createBrchNo
	 */
	public void setCreateBrchNo(String createBrchNo) {
		this.createBrchNo = createBrchNo == null ? null : createBrchNo.trim();
	}
	
    /**
     * @return CreateBrchNo
     */	
	public String getCreateBrchNo() {
		return this.createBrchNo;
	}
	
	/**
	 * @param createTellerNo
	 */
	public void setCreateTellerNo(String createTellerNo) {
		this.createTellerNo = createTellerNo == null ? null : createTellerNo.trim();
	}
	
    /**
     * @return CreateTellerNo
     */	
	public String getCreateTellerNo() {
		return this.createTellerNo;
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
        AcrmFciCustAdmitAll other = (AcrmFciCustAdmitAll) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getEcifCustId() == null ? other.getEcifCustId() == null : this.getEcifCustId().equals(other.getEcifCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getServLev() == null ? other.getServLev() == null : this.getServLev().equals(other.getServLev()))
        	&& (this.getValueLev() == null ? other.getValueLev() == null : this.getValueLev().equals(other.getValueLev()))
        	&& (this.getBelongMgr() == null ? other.getBelongMgr() == null : this.getBelongMgr().equals(other.getBelongMgr()))
        	&& (this.getBelongBrch() == null ? other.getBelongBrch() == null : this.getBelongBrch().equals(other.getBelongBrch()))
        	&& (this.getBusiType() == null ? other.getBusiType() == null : this.getBusiType().equals(other.getBusiType()))
        	&& (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        	&& (this.getCreateBrchNo() == null ? other.getCreateBrchNo() == null : this.getCreateBrchNo().equals(other.getCreateBrchNo()))
        	&& (this.getCreateTellerNo() == null ? other.getCreateTellerNo() == null : this.getCreateTellerNo().equals(other.getCreateTellerNo()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastUpdateSys() == null) ? 0 : getLastUpdateSys().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getEcifCustId() == null) ? 0 : getEcifCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getServLev() == null) ? 0 : getServLev().hashCode());
        result = prime * result + ((getValueLev() == null) ? 0 : getValueLev().hashCode());
        result = prime * result + ((getBelongMgr() == null) ? 0 : getBelongMgr().hashCode());
        result = prime * result + ((getBelongBrch() == null) ? 0 : getBelongBrch().hashCode());
        result = prime * result + ((getBusiType() == null) ? 0 : getBusiType().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBrchNo() == null) ? 0 : getCreateBrchNo().hashCode());
        result = prime * result + ((getCreateTellerNo() == null) ? 0 : getCreateTellerNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastUpdateSys=").append(lastUpdateSys);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", ecifCustId=").append(ecifCustId);
		sb.append(", custName=").append(custName);
		sb.append(", custType=").append(custType);
		sb.append(", custStatus=").append(custStatus);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", servLev=").append(servLev);
		sb.append(", valueLev=").append(valueLev);
		sb.append(", belongMgr=").append(belongMgr);
		sb.append(", belongBrch=").append(belongBrch);
		sb.append(", busiType=").append(busiType);
		sb.append(", createDate=").append(createDate);
		sb.append(", createBrchNo=").append(createBrchNo);
		sb.append(", createTellerNo=").append(createTellerNo);
        sb.append("]");
        return sb.toString();
    }
}