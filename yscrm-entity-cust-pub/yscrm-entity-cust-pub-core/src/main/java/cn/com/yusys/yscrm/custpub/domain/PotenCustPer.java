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
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: PotenCustPer
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-15 16:22:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "POTEN_CUST_PER")
public class PotenCustPer extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = false, length = 20)
	private String custName;
	
	/** 客户状态 **/
	@Column(name = "CUST_STATUS", unique = false, nullable = false, length = 2)
	private String custStatus;
	
	/** 证件类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = false, length = 2)
	private String custType;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = false, length = 32)
	private String corpOrgCode;
	
	/** 条线 **/
	@Column(name = "BUSI_TYPE", unique = false, nullable = false, length = 10)
	private String busiType;
	
	/** 证件类型 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = false, length = 2)
	private String certType;
	
	/** 证件号 **/
	@Column(name = "CERT_NO", unique = false, nullable = false, length = 50)
	private String certNo;
	
	/** 联系手机 **/
	@Column(name = "PHONE_NO", unique = false, nullable = true, length = 12)
	private String phoneNo;
	
	/** 联系地址 **/
	@Column(name = "CONT_ADDR", unique = false, nullable = true, length = 150)
	private String contAddr;
	
	/** 归属客户经理 **/
	@Column(name = "BELONG_MGR", unique = false, nullable = false, length = 32)
	private String belongMgr;
	
	/** 归属机构 **/
	@Column(name = "BELONG_BRCH", unique = false, nullable = false, length = 32)
	private String belongBrch;
	
	/** 职业 **/
	@Column(name = "INDIV_OCC", unique = false, nullable = true, length = 32)
	private String indivOcc;
	
	/** 工作单位 **/
	@Column(name = "WORK_UNIT", unique = false, nullable = true, length = 100)
	private String workUnit;
	
	/** 证件信息表ID **/
	@Column(name = "IDENT_ID", unique = false, nullable = false, length = 32)
	private String identId;
	
	/** 地址信息表ID **/
	@Column(name = "ADDR_ID", unique = false, nullable = false, length = 32)
	private String addrId;
	
	/** 客户联系表ID **/
	@Column(name = "CONT_ID", unique = false, nullable = false, length = 32)
	private String contId;
	
	/** 客户来源渠道 **/
	@Column(name = "SOURCE_CHANNEL", unique = false, nullable = false, length = 2)
	private String sourceChannel;
	
	/** 机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = false, length = 50)
	private String orgName;
	
	/** 客户经理名称 **/
	@Column(name = "MGR_NAME", unique = false, nullable = false, length = 50)
	private String mgrName;
	
	/** 归属编号 **/
	@Column(name = "BELONG_ID", unique = false, nullable = false, length = 32)
	private String belongId;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = false, length = 32)
	private String custId;
	
	/** 更新人 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 32)
	private String lastUpdateUser;
	
	/** 更新时间 **/
	@Transient
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 7)
	private Date lastUpdateTm;
	
	/** 更新机构 **/
	@Column(name = "LAST_UPDATE_ORG", unique = false, nullable = true, length = 32)
	private String lastUpdateOrg;
	
	/** 更新系统 **/
	@Column(name = "LAST_UPDATE_SYS", unique = false, nullable = true, length = 32)
	private String lastUpdateSys;
	
	
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
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo == null ? null : phoneNo.trim();
	}
	
    /**
     * @return PhoneNo
     */	
	public String getPhoneNo() {
		return this.phoneNo;
	}
	
	/**
	 * @param contAddr
	 */
	public void setContAddr(String contAddr) {
		this.contAddr = contAddr == null ? null : contAddr.trim();
	}
	
    /**
     * @return ContAddr
     */	
	public String getContAddr() {
		return this.contAddr;
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
	 * @param indivOcc
	 */
	public void setIndivOcc(String indivOcc) {
		this.indivOcc = indivOcc == null ? null : indivOcc.trim();
	}
	
    /**
     * @return IndivOcc
     */	
	public String getIndivOcc() {
		return this.indivOcc;
	}
	
	/**
	 * @param workUnit
	 */
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit == null ? null : workUnit.trim();
	}
	
    /**
     * @return WorkUnit
     */	
	public String getWorkUnit() {
		return this.workUnit;
	}
	
	/**
	 * @param identId
	 */
	public void setIdentId(String identId) {
		this.identId = identId == null ? null : identId.trim();
	}
	
    /**
     * @return IdentId
     */	
	public String getIdentId() {
		return this.identId;
	}
	
	/**
	 * @param addrId
	 */
	public void setAddrId(String addrId) {
		this.addrId = addrId == null ? null : addrId.trim();
	}
	
    /**
     * @return AddrId
     */	
	public String getAddrId() {
		return this.addrId;
	}
	
	/**
	 * @param contId
	 */
	public void setContId(String contId) {
		this.contId = contId == null ? null : contId.trim();
	}
	
    /**
     * @return ContId
     */	
	public String getContId() {
		return this.contId;
	}
	
	/**
	 * @param sourceChannel
	 */
	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel == null ? null : sourceChannel.trim();
	}
	
    /**
     * @return SourceChannel
     */	
	public String getSourceChannel() {
		return this.sourceChannel;
	}
	
	/**
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}
	
    /**
     * @return OrgName
     */	
	public String getOrgName() {
		return this.orgName;
	}
	
	/**
	 * @param mgrName
	 */
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName == null ? null : mgrName.trim();
	}
	
    /**
     * @return MgrName
     */	
	public String getMgrName() {
		return this.mgrName;
	}
	
	/**
	 * @param belongId
	 */
	public void setBelongId(String belongId) {
		this.belongId = belongId == null ? null : belongId.trim();
	}
	
    /**
     * @return BelongId
     */	
	public String getBelongId() {
		return this.belongId;
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
	 * @param lastUpdateOrg
	 */
	public void setLastUpdateOrg(String lastUpdateOrg) {
		this.lastUpdateOrg = lastUpdateOrg == null ? null : lastUpdateOrg.trim();
	}
	
    /**
     * @return LastUpdateOrg
     */	
	public String getLastUpdateOrg() {
		return this.lastUpdateOrg;
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
        PotenCustPer other = (PotenCustPer) that;
		return (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getBusiType() == null ? other.getBusiType() == null : this.getBusiType().equals(other.getBusiType()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getPhoneNo() == null ? other.getPhoneNo() == null : this.getPhoneNo().equals(other.getPhoneNo()))
        	&& (this.getContAddr() == null ? other.getContAddr() == null : this.getContAddr().equals(other.getContAddr()))
        	&& (this.getBelongMgr() == null ? other.getBelongMgr() == null : this.getBelongMgr().equals(other.getBelongMgr()))
        	&& (this.getBelongBrch() == null ? other.getBelongBrch() == null : this.getBelongBrch().equals(other.getBelongBrch()))
        	&& (this.getIndivOcc() == null ? other.getIndivOcc() == null : this.getIndivOcc().equals(other.getIndivOcc()))
        	&& (this.getWorkUnit() == null ? other.getWorkUnit() == null : this.getWorkUnit().equals(other.getWorkUnit()))
        	&& (this.getIdentId() == null ? other.getIdentId() == null : this.getIdentId().equals(other.getIdentId()))
        	&& (this.getAddrId() == null ? other.getAddrId() == null : this.getAddrId().equals(other.getAddrId()))
        	&& (this.getContId() == null ? other.getContId() == null : this.getContId().equals(other.getContId()))
        	&& (this.getSourceChannel() == null ? other.getSourceChannel() == null : this.getSourceChannel().equals(other.getSourceChannel()))
        	&& (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getBelongId() == null ? other.getBelongId() == null : this.getBelongId().equals(other.getBelongId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getLastUpdateOrg() == null ? other.getLastUpdateOrg() == null : this.getLastUpdateOrg().equals(other.getLastUpdateOrg()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getBusiType() == null) ? 0 : getBusiType().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getPhoneNo() == null) ? 0 : getPhoneNo().hashCode());
        result = prime * result + ((getContAddr() == null) ? 0 : getContAddr().hashCode());
        result = prime * result + ((getBelongMgr() == null) ? 0 : getBelongMgr().hashCode());
        result = prime * result + ((getBelongBrch() == null) ? 0 : getBelongBrch().hashCode());
        result = prime * result + ((getIndivOcc() == null) ? 0 : getIndivOcc().hashCode());
        result = prime * result + ((getWorkUnit() == null) ? 0 : getWorkUnit().hashCode());
        result = prime * result + ((getIdentId() == null) ? 0 : getIdentId().hashCode());
        result = prime * result + ((getAddrId() == null) ? 0 : getAddrId().hashCode());
        result = prime * result + ((getContId() == null) ? 0 : getContId().hashCode());
        result = prime * result + ((getSourceChannel() == null) ? 0 : getSourceChannel().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getBelongId() == null) ? 0 : getBelongId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateOrg() == null) ? 0 : getLastUpdateOrg().hashCode());
        result = prime * result + ((getLastUpdateSys() == null) ? 0 : getLastUpdateSys().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custName=").append(custName);
		sb.append(", custStatus=").append(custStatus);
		sb.append(", custType=").append(custType);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", busiType=").append(busiType);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", phoneNo=").append(phoneNo);
		sb.append(", contAddr=").append(contAddr);
		sb.append(", belongMgr=").append(belongMgr);
		sb.append(", belongBrch=").append(belongBrch);
		sb.append(", indivOcc=").append(indivOcc);
		sb.append(", workUnit=").append(workUnit);
		sb.append(", identId=").append(identId);
		sb.append(", addrId=").append(addrId);
		sb.append(", contId=").append(contId);
		sb.append(", sourceChannel=").append(sourceChannel);
		sb.append(", orgName=").append(orgName);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", belongId=").append(belongId);
		sb.append(", custId=").append(custId);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", lastUpdateOrg=").append(lastUpdateOrg);
		sb.append(", lastUpdateSys=").append(lastUpdateSys);
        sb.append("]");
        return sb.toString();
    }
}