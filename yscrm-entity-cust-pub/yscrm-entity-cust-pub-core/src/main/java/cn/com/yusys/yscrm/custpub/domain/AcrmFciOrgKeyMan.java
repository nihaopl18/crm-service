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
 * @类名称: AcrmFciOrgKeyMan
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-07 17:02:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_ORG_KEY_MAN")
public class AcrmFciOrgKeyMan extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期 **/
	@Transient
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
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 100)
	private String custName;
	
	/** 关键人类型 **/
	@Column(name = "RELA_TYPE", unique = false, nullable = true, length = 20)
	private String relaType;
	
	/** 关键人客户编号 **/
	@Column(name = "KEY_CUST_ID", unique = false, nullable = true, length = 32)
	private String keyCustId;
	
	/** 关键人称谓 **/
	@Column(name = "CUST_TITLE", unique = false, nullable = true, length = 30)
	private String custTitle;
	
	/** 关键人姓名 **/
	@Column(name = "CUST_NAME_REL", unique = false, nullable = true, length = 80)
	private String custNameRel;
	
	/** 职位 **/
	@Column(name = "JOB_POSI", unique = false, nullable = true, length = 30)
	private String jobPosi;
	
	/** 办公电话 **/
	@Column(name = "OFFI_TEL_NO", unique = false, nullable = true, length = 30)
	private String offiTelNo;
	
	/** 家庭电话 **/
	@Column(name = "HOME_TEL_NO", unique = false, nullable = true, length = 30)
	private String homeTelNo;
	
	/** 手机号码 **/
	@Column(name = "MOBILE_NO", unique = false, nullable = true, length = 30)
	private String mobileNo;
	
	/** 电子邮件 **/
	@Column(name = "EMAIL", unique = false, nullable = true, length = 30)
	private String email;
	
	/** 联系优先级 **/
	@Column(name = "CONT_PRIO", unique = false, nullable = true, length = 30)
	private String contPrio;
	
	/** 性别 **/
	@Column(name = "SEX", unique = false, nullable = true, length = 10)
	private String sex;
	
	/** 证件类型 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = true, length = 20)
	private String certType;
	
	/** 证件号码 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 50)
	private String certNo;
	
	/** 微信号 **/
	@Column(name = "WECHAT", unique = false, nullable = true, length = 30)
	private String wechat;
	
	/** QQ **/
	@Column(name = "QQ", unique = false, nullable = true, length = 30)
	private String qq;
	
	/** 微博 **/
	@Column(name = "WEIBO", unique = false, nullable = true, length = 30)
	private String weibo;
	
	/** 学历 **/
	@Column(name = "EDU_REC", unique = false, nullable = true, length = 30)
	private String eduRec;
	
	/** 婚姻状况 **/
	@Column(name = "MARRI_STAT", unique = false, nullable = true, length = 30)
	private String marriStat;
	
	/** 配偶姓名 **/
	@Column(name = "SPOUSE_NAME", unique = false, nullable = true, length = 80)
	private String spouseName;
	
	/** 配偶证件类型 **/
	@Column(name = "SPOUSE_CERT_TYPE", unique = false, nullable = true, length = 20)
	private String spouseCertType;
	
	/** 配偶证件号码 **/
	@Column(name = "SPOUSE_CERT_NO", unique = false, nullable = true, length = 50)
	private String spouseCertNo;
	
	/** 配偶联系电话 **/
	@Column(name = "SPOUSE_TEL_NO", unique = false, nullable = true, length = 30)
	private String spouseTelNo;
	
	/** 配偶职业 **/
	@Column(name = "SPOUSE_IND_OCC", unique = false, nullable = true, length = 20)
	private String spouseIndOcc;
	
	/** 价值等级 **/
	@Column(name = "VALUE_LEV", unique = false, nullable = true, length = 20)
	private String valueLev;
	
	/** 服务等级 **/
	@Column(name = "SERV_LEV", unique = false, nullable = true, length = 20)
	private String servLev;
	
	/** 是否有效 **/
	@Column(name = "VALID_FLG", unique = false, nullable = true, length = 10)
	private String validFlg;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	
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
	 * @param relaType
	 */
	public void setRelaType(String relaType) {
		this.relaType = relaType == null ? null : relaType.trim();
	}
	
    /**
     * @return RelaType
     */	
	public String getRelaType() {
		return this.relaType;
	}
	
	/**
	 * @param keyCustId
	 */
	public void setKeyCustId(String keyCustId) {
		this.keyCustId = keyCustId == null ? null : keyCustId.trim();
	}
	
    /**
     * @return KeyCustId
     */	
	public String getKeyCustId() {
		return this.keyCustId;
	}
	
	/**
	 * @param custTitle
	 */
	public void setCustTitle(String custTitle) {
		this.custTitle = custTitle == null ? null : custTitle.trim();
	}
	
    /**
     * @return CustTitle
     */	
	public String getCustTitle() {
		return this.custTitle;
	}
	
	/**
	 * @param custNameRel
	 */
	public void setCustNameRel(String custNameRel) {
		this.custNameRel = custNameRel == null ? null : custNameRel.trim();
	}
	
    /**
     * @return CustNameRel
     */	
	public String getCustNameRel() {
		return this.custNameRel;
	}
	
	/**
	 * @param jobPosi
	 */
	public void setJobPosi(String jobPosi) {
		this.jobPosi = jobPosi == null ? null : jobPosi.trim();
	}
	
    /**
     * @return JobPosi
     */	
	public String getJobPosi() {
		return this.jobPosi;
	}
	
	/**
	 * @param offiTelNo
	 */
	public void setOffiTelNo(String offiTelNo) {
		this.offiTelNo = offiTelNo == null ? null : offiTelNo.trim();
	}
	
    /**
     * @return OffiTelNo
     */	
	public String getOffiTelNo() {
		return this.offiTelNo;
	}
	
	/**
	 * @param homeTelNo
	 */
	public void setHomeTelNo(String homeTelNo) {
		this.homeTelNo = homeTelNo == null ? null : homeTelNo.trim();
	}
	
    /**
     * @return HomeTelNo
     */	
	public String getHomeTelNo() {
		return this.homeTelNo;
	}
	
	/**
	 * @param mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo == null ? null : mobileNo.trim();
	}
	
    /**
     * @return MobileNo
     */	
	public String getMobileNo() {
		return this.mobileNo;
	}
	
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
	
    /**
     * @return Email
     */	
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * @param contPrio
	 */
	public void setContPrio(String contPrio) {
		this.contPrio = contPrio == null ? null : contPrio.trim();
	}
	
    /**
     * @return ContPrio
     */	
	public String getContPrio() {
		return this.contPrio;
	}
	
	/**
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}
	
    /**
     * @return Sex
     */	
	public String getSex() {
		return this.sex;
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
	 * @param wechat
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat == null ? null : wechat.trim();
	}
	
    /**
     * @return Wechat
     */	
	public String getWechat() {
		return this.wechat;
	}
	
	/**
	 * @param qq
	 */
	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}
	
    /**
     * @return Qq
     */	
	public String getQq() {
		return this.qq;
	}
	
	/**
	 * @param weibo
	 */
	public void setWeibo(String weibo) {
		this.weibo = weibo == null ? null : weibo.trim();
	}
	
    /**
     * @return Weibo
     */	
	public String getWeibo() {
		return this.weibo;
	}
	
	/**
	 * @param eduRec
	 */
	public void setEduRec(String eduRec) {
		this.eduRec = eduRec == null ? null : eduRec.trim();
	}
	
    /**
     * @return EduRec
     */	
	public String getEduRec() {
		return this.eduRec;
	}
	
	/**
	 * @param marriStat
	 */
	public void setMarriStat(String marriStat) {
		this.marriStat = marriStat == null ? null : marriStat.trim();
	}
	
    /**
     * @return MarriStat
     */	
	public String getMarriStat() {
		return this.marriStat;
	}
	
	/**
	 * @param spouseName
	 */
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName == null ? null : spouseName.trim();
	}
	
    /**
     * @return SpouseName
     */	
	public String getSpouseName() {
		return this.spouseName;
	}
	
	/**
	 * @param spouseCertType
	 */
	public void setSpouseCertType(String spouseCertType) {
		this.spouseCertType = spouseCertType == null ? null : spouseCertType.trim();
	}
	
    /**
     * @return SpouseCertType
     */	
	public String getSpouseCertType() {
		return this.spouseCertType;
	}
	
	/**
	 * @param spouseCertNo
	 */
	public void setSpouseCertNo(String spouseCertNo) {
		this.spouseCertNo = spouseCertNo == null ? null : spouseCertNo.trim();
	}
	
    /**
     * @return SpouseCertNo
     */	
	public String getSpouseCertNo() {
		return this.spouseCertNo;
	}
	
	/**
	 * @param spouseTelNo
	 */
	public void setSpouseTelNo(String spouseTelNo) {
		this.spouseTelNo = spouseTelNo == null ? null : spouseTelNo.trim();
	}
	
    /**
     * @return SpouseTelNo
     */	
	public String getSpouseTelNo() {
		return this.spouseTelNo;
	}
	
	/**
	 * @param spouseIndOcc
	 */
	public void setSpouseIndOcc(String spouseIndOcc) {
		this.spouseIndOcc = spouseIndOcc == null ? null : spouseIndOcc.trim();
	}
	
    /**
     * @return SpouseIndOcc
     */	
	public String getSpouseIndOcc() {
		return this.spouseIndOcc;
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
	 * @param validFlg
	 */
	public void setValidFlg(String validFlg) {
		this.validFlg = validFlg == null ? null : validFlg.trim();
	}
	
    /**
     * @return ValidFlg
     */	
	public String getValidFlg() {
		return this.validFlg;
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
        AcrmFciOrgKeyMan other = (AcrmFciOrgKeyMan) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getRelaType() == null ? other.getRelaType() == null : this.getRelaType().equals(other.getRelaType()))
        	&& (this.getKeyCustId() == null ? other.getKeyCustId() == null : this.getKeyCustId().equals(other.getKeyCustId()))
        	&& (this.getCustTitle() == null ? other.getCustTitle() == null : this.getCustTitle().equals(other.getCustTitle()))
        	&& (this.getCustNameRel() == null ? other.getCustNameRel() == null : this.getCustNameRel().equals(other.getCustNameRel()))
        	&& (this.getJobPosi() == null ? other.getJobPosi() == null : this.getJobPosi().equals(other.getJobPosi()))
        	&& (this.getOffiTelNo() == null ? other.getOffiTelNo() == null : this.getOffiTelNo().equals(other.getOffiTelNo()))
        	&& (this.getHomeTelNo() == null ? other.getHomeTelNo() == null : this.getHomeTelNo().equals(other.getHomeTelNo()))
        	&& (this.getMobileNo() == null ? other.getMobileNo() == null : this.getMobileNo().equals(other.getMobileNo()))
        	&& (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
        	&& (this.getContPrio() == null ? other.getContPrio() == null : this.getContPrio().equals(other.getContPrio()))
        	&& (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getWechat() == null ? other.getWechat() == null : this.getWechat().equals(other.getWechat()))
        	&& (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
        	&& (this.getWeibo() == null ? other.getWeibo() == null : this.getWeibo().equals(other.getWeibo()))
        	&& (this.getEduRec() == null ? other.getEduRec() == null : this.getEduRec().equals(other.getEduRec()))
        	&& (this.getMarriStat() == null ? other.getMarriStat() == null : this.getMarriStat().equals(other.getMarriStat()))
        	&& (this.getSpouseName() == null ? other.getSpouseName() == null : this.getSpouseName().equals(other.getSpouseName()))
        	&& (this.getSpouseCertType() == null ? other.getSpouseCertType() == null : this.getSpouseCertType().equals(other.getSpouseCertType()))
        	&& (this.getSpouseCertNo() == null ? other.getSpouseCertNo() == null : this.getSpouseCertNo().equals(other.getSpouseCertNo()))
        	&& (this.getSpouseTelNo() == null ? other.getSpouseTelNo() == null : this.getSpouseTelNo().equals(other.getSpouseTelNo()))
        	&& (this.getSpouseIndOcc() == null ? other.getSpouseIndOcc() == null : this.getSpouseIndOcc().equals(other.getSpouseIndOcc()))
        	&& (this.getValueLev() == null ? other.getValueLev() == null : this.getValueLev().equals(other.getValueLev()))
        	&& (this.getServLev() == null ? other.getServLev() == null : this.getServLev().equals(other.getServLev()))
        	&& (this.getValidFlg() == null ? other.getValidFlg() == null : this.getValidFlg().equals(other.getValidFlg()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getRelaType() == null) ? 0 : getRelaType().hashCode());
        result = prime * result + ((getKeyCustId() == null) ? 0 : getKeyCustId().hashCode());
        result = prime * result + ((getCustTitle() == null) ? 0 : getCustTitle().hashCode());
        result = prime * result + ((getCustNameRel() == null) ? 0 : getCustNameRel().hashCode());
        result = prime * result + ((getJobPosi() == null) ? 0 : getJobPosi().hashCode());
        result = prime * result + ((getOffiTelNo() == null) ? 0 : getOffiTelNo().hashCode());
        result = prime * result + ((getHomeTelNo() == null) ? 0 : getHomeTelNo().hashCode());
        result = prime * result + ((getMobileNo() == null) ? 0 : getMobileNo().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getContPrio() == null) ? 0 : getContPrio().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getWechat() == null) ? 0 : getWechat().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWeibo() == null) ? 0 : getWeibo().hashCode());
        result = prime * result + ((getEduRec() == null) ? 0 : getEduRec().hashCode());
        result = prime * result + ((getMarriStat() == null) ? 0 : getMarriStat().hashCode());
        result = prime * result + ((getSpouseName() == null) ? 0 : getSpouseName().hashCode());
        result = prime * result + ((getSpouseCertType() == null) ? 0 : getSpouseCertType().hashCode());
        result = prime * result + ((getSpouseCertNo() == null) ? 0 : getSpouseCertNo().hashCode());
        result = prime * result + ((getSpouseTelNo() == null) ? 0 : getSpouseTelNo().hashCode());
        result = prime * result + ((getSpouseIndOcc() == null) ? 0 : getSpouseIndOcc().hashCode());
        result = prime * result + ((getValueLev() == null) ? 0 : getValueLev().hashCode());
        result = prime * result + ((getServLev() == null) ? 0 : getServLev().hashCode());
        result = prime * result + ((getValidFlg() == null) ? 0 : getValidFlg().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", custName=").append(custName);
		sb.append(", relaType=").append(relaType);
		sb.append(", keyCustId=").append(keyCustId);
		sb.append(", custTitle=").append(custTitle);
		sb.append(", custNameRel=").append(custNameRel);
		sb.append(", jobPosi=").append(jobPosi);
		sb.append(", offiTelNo=").append(offiTelNo);
		sb.append(", homeTelNo=").append(homeTelNo);
		sb.append(", mobileNo=").append(mobileNo);
		sb.append(", email=").append(email);
		sb.append(", contPrio=").append(contPrio);
		sb.append(", sex=").append(sex);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", wechat=").append(wechat);
		sb.append(", qq=").append(qq);
		sb.append(", weibo=").append(weibo);
		sb.append(", eduRec=").append(eduRec);
		sb.append(", marriStat=").append(marriStat);
		sb.append(", spouseName=").append(spouseName);
		sb.append(", spouseCertType=").append(spouseCertType);
		sb.append(", spouseCertNo=").append(spouseCertNo);
		sb.append(", spouseTelNo=").append(spouseTelNo);
		sb.append(", spouseIndOcc=").append(spouseIndOcc);
		sb.append(", valueLev=").append(valueLev);
		sb.append(", servLev=").append(servLev);
		sb.append(", validFlg=").append(validFlg);
		sb.append(", remark=").append(remark);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}