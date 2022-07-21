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
 * @类名称: AcrmFciPerFamilyMember
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-29 16:09:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_PER_FAMILY_MEMBER")
public class AcrmFciPerFamilyMember extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键
 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private Date dataDate;
	
	/** 创建日期
 **/
	@Transient
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号
 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人
 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间
 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 成员客户编号
 **/
	@Column(name = "FAM_CUST_ID", unique = false, nullable = true, length = 32)
	private String famCustId;
	
	/** 家庭成员关系
 **/
	@Column(name = "FAM_MEM_REL", unique = false, nullable = true, length = 30)
	private String famMemRel;
	
	/** 成员客户状态
 **/
	@Column(name = "FAM_CUST_STATUS", unique = false, nullable = true, length = 30)
	private String famCustStatus;
	
	/** 成员名称
 **/
	@Column(name = "MEM_NAME", unique = false, nullable = true, length = 200)
	private String memName;
	
	/** 成员证件类型
 **/
	@Column(name = "MEM_CERT_TYPE", unique = false, nullable = true, length = 30)
	private String memCertType;
	
	/** 成员证件号码
 **/
	@Column(name = "MEM_CERT_NO", unique = false, nullable = true, length = 50)
	private String memCertNo;
	
	/** 成员职业
 **/
	@Column(name = "MEM_OCC", unique = false, nullable = true, length = 30)
	private String memOcc;
	
	/** 成员工作单位或学校
 **/
	@Column(name = "MEM_COM_SCH", unique = false, nullable = true, length = 200)
	private String memComSch;
	
	/** 电话
 **/
	@Column(name = "TEL_NO", unique = false, nullable = true, length = 20)
	private String telNo;
	
	/** 手机号码
 **/
	@Column(name = "MOBI_NO", unique = false, nullable = true, length = 20)
	private String mobiNo;
	
	/** 是否家庭经济支柱
 **/
	@Column(name = "FAM_PROP_FLG", unique = false, nullable = true, length = 20)
	private String famPropFlg;
	
	/** 最高学位
 **/
	@Column(name = "HIG_EDU_DGR", unique = false, nullable = true, length = 60)
	private String higEduDgr;
	
	/** 备注
 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	
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
	

	
	public Date getDataDate() {
		return dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
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
	 * @param famCustId
	 */
	public void setFamCustId(String famCustId) {
		this.famCustId = famCustId == null ? null : famCustId.trim();
	}
	
    /**
     * @return FamCustId
     */	
	public String getFamCustId() {
		return this.famCustId;
	}
	
	/**
	 * @param famMemRel
	 */
	public void setFamMemRel(String famMemRel) {
		this.famMemRel = famMemRel == null ? null : famMemRel.trim();
	}
	
    /**
     * @return FamMemRel
     */	
	public String getFamMemRel() {
		return this.famMemRel;
	}
	
	/**
	 * @param famCustStatus
	 */
	public void setFamCustStatus(String famCustStatus) {
		this.famCustStatus = famCustStatus == null ? null : famCustStatus.trim();
	}
	
    /**
     * @return FamCustStatus
     */	
	public String getFamCustStatus() {
		return this.famCustStatus;
	}
	
	/**
	 * @param memName
	 */
	public void setMemName(String memName) {
		this.memName = memName == null ? null : memName.trim();
	}
	
    /**
     * @return MemName
     */	
	public String getMemName() {
		return this.memName;
	}
	
	/**
	 * @param memCertType
	 */
	public void setMemCertType(String memCertType) {
		this.memCertType = memCertType == null ? null : memCertType.trim();
	}
	
    /**
     * @return MemCertType
     */	
	public String getMemCertType() {
		return this.memCertType;
	}
	
	/**
	 * @param memCertNo
	 */
	public void setMemCertNo(String memCertNo) {
		this.memCertNo = memCertNo == null ? null : memCertNo.trim();
	}
	
    /**
     * @return MemCertNo
     */	
	public String getMemCertNo() {
		return this.memCertNo;
	}
	
	/**
	 * @param memOcc
	 */
	public void setMemOcc(String memOcc) {
		this.memOcc = memOcc == null ? null : memOcc.trim();
	}
	
    /**
     * @return MemOcc
     */	
	public String getMemOcc() {
		return this.memOcc;
	}
	
	/**
	 * @param memComSch
	 */
	public void setMemComSch(String memComSch) {
		this.memComSch = memComSch == null ? null : memComSch.trim();
	}
	
    /**
     * @return MemComSch
     */	
	public String getMemComSch() {
		return this.memComSch;
	}
	
	/**
	 * @param telNo
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo == null ? null : telNo.trim();
	}
	
    /**
     * @return TelNo
     */	
	public String getTelNo() {
		return this.telNo;
	}
	
	/**
	 * @param mobiNo
	 */
	public void setMobiNo(String mobiNo) {
		this.mobiNo = mobiNo == null ? null : mobiNo.trim();
	}
	
    /**
     * @return MobiNo
     */	
	public String getMobiNo() {
		return this.mobiNo;
	}
	
	/**
	 * @param famPropFlg
	 */
	public void setFamPropFlg(String famPropFlg) {
		this.famPropFlg = famPropFlg == null ? null : famPropFlg.trim();
	}
	
    /**
     * @return FamPropFlg
     */	
	public String getFamPropFlg() {
		return this.famPropFlg;
	}
	
	/**
	 * @param higEduDgr
	 */
	public void setHigEduDgr(String higEduDgr) {
		this.higEduDgr = higEduDgr == null ? null : higEduDgr.trim();
	}
	
    /**
     * @return HigEduDgr
     */	
	public String getHigEduDgr() {
		return this.higEduDgr;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
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
        AcrmFciPerFamilyMember other = (AcrmFciPerFamilyMember) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getFamCustId() == null ? other.getFamCustId() == null : this.getFamCustId().equals(other.getFamCustId()))
        	&& (this.getFamMemRel() == null ? other.getFamMemRel() == null : this.getFamMemRel().equals(other.getFamMemRel()))
        	&& (this.getFamCustStatus() == null ? other.getFamCustStatus() == null : this.getFamCustStatus().equals(other.getFamCustStatus()))
        	&& (this.getMemName() == null ? other.getMemName() == null : this.getMemName().equals(other.getMemName()))
        	&& (this.getMemCertType() == null ? other.getMemCertType() == null : this.getMemCertType().equals(other.getMemCertType()))
        	&& (this.getMemCertNo() == null ? other.getMemCertNo() == null : this.getMemCertNo().equals(other.getMemCertNo()))
        	&& (this.getMemOcc() == null ? other.getMemOcc() == null : this.getMemOcc().equals(other.getMemOcc()))
        	&& (this.getMemComSch() == null ? other.getMemComSch() == null : this.getMemComSch().equals(other.getMemComSch()))
        	&& (this.getTelNo() == null ? other.getTelNo() == null : this.getTelNo().equals(other.getTelNo()))
        	&& (this.getMobiNo() == null ? other.getMobiNo() == null : this.getMobiNo().equals(other.getMobiNo()))
        	&& (this.getFamPropFlg() == null ? other.getFamPropFlg() == null : this.getFamPropFlg().equals(other.getFamPropFlg()))
        	&& (this.getHigEduDgr() == null ? other.getHigEduDgr() == null : this.getHigEduDgr().equals(other.getHigEduDgr()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getFamCustId() == null) ? 0 : getFamCustId().hashCode());
        result = prime * result + ((getFamMemRel() == null) ? 0 : getFamMemRel().hashCode());
        result = prime * result + ((getFamCustStatus() == null) ? 0 : getFamCustStatus().hashCode());
        result = prime * result + ((getMemName() == null) ? 0 : getMemName().hashCode());
        result = prime * result + ((getMemCertType() == null) ? 0 : getMemCertType().hashCode());
        result = prime * result + ((getMemCertNo() == null) ? 0 : getMemCertNo().hashCode());
        result = prime * result + ((getMemOcc() == null) ? 0 : getMemOcc().hashCode());
        result = prime * result + ((getMemComSch() == null) ? 0 : getMemComSch().hashCode());
        result = prime * result + ((getTelNo() == null) ? 0 : getTelNo().hashCode());
        result = prime * result + ((getMobiNo() == null) ? 0 : getMobiNo().hashCode());
        result = prime * result + ((getFamPropFlg() == null) ? 0 : getFamPropFlg().hashCode());
        result = prime * result + ((getHigEduDgr() == null) ? 0 : getHigEduDgr().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", famCustId=").append(famCustId);
		sb.append(", famMemRel=").append(famMemRel);
		sb.append(", famCustStatus=").append(famCustStatus);
		sb.append(", memName=").append(memName);
		sb.append(", memCertType=").append(memCertType);
		sb.append(", memCertNo=").append(memCertNo);
		sb.append(", memOcc=").append(memOcc);
		sb.append(", memComSch=").append(memComSch);
		sb.append(", telNo=").append(telNo);
		sb.append(", mobiNo=").append(mobiNo);
		sb.append(", famPropFlg=").append(famPropFlg);
		sb.append(", higEduDgr=").append(higEduDgr);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}