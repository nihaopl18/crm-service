package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yscrm.custpub.annotation.ColumnConfig;
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
 * @类名称: AcrmFciCustIdentInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-27 17:34:34
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_CUST_IDENT_INFO")
public class AcrmFciCustIdentInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键
 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 8)
	private Date dataDt;
	
	/** 创建日期
 **/
	
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
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 证件类型
 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = true, length = 30)
	@ColumnConfig(description = "证件类型", lookup = "CD0011", key = true)
	private String certType;
	
	/** 证件号码
 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 50)
	@ColumnConfig(description = "证件号码", lookup = "", key = true)
	private String certNo;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 30)
	private String custType;
	
	/** 客户名称
 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 是否年检
 **/
	@Column(name = "CHECK_FLG", unique = false, nullable = true, length = 30)
	private String checkFlg;
	
	/** 年检到期日
 **/
	@Column(name = "CHK_DUE_DATE", unique = false, nullable = true, length = 8)
	private String chkDueDate;
	
	/** 证件生效日期
 **/
	@Column(name = "EFFECT_DATE", unique = false, nullable = true, length = 8)
	private String effectDate;
	
	/** 证件失效日期
 **/
	@Column(name = "EXPIRED_DATE", unique = false, nullable = true, length = 8)
	private String expiredDate;
	
	/** 发证机关名称
 **/
	@Column(name = "ORGAN_NAME", unique = false, nullable = true, length = 200)
	private String organName;
	
	/** 证件登记地址
 **/
	@Column(name = "IDENT_REG_ADDR", unique = false, nullable = true, length = 200)
	private String identRegAddr;
	
	/** 有效标志
 **/
	@Column(name = "EFFECT_FLG", unique = false, nullable = true, length = 30)
	private String effectFlg;
	
	/** 主证件标志
 **/
	@Column(name = "MAIN_IDENT_FLG", unique = false, nullable = true, length = 30)
	@ColumnConfig(description = "主证件标志", lookup = "CD0255", key = true)
	private String mainIdentFlg;
	
	/** 主证件标志设置系统
 **/
	@Column(name = "FLG_SET_SYS", unique = false, nullable = true, length = 30)
	private String flgSetSys;
	
	/** 证件扫描文件标识
 **/
	@Column(name = "IDENT_SCAN_ID", unique = false, nullable = true, length = 30)
	private String identScanId;
	
	
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
	

	


	public Date getDataDt() {
		return dataDt;
	}

	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
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
	 * @param checkFlg
	 */
	public void setCheckFlg(String checkFlg) {
		this.checkFlg = checkFlg == null ? null : checkFlg.trim();
	}
	
    /**
     * @return CheckFlg
     */	
	public String getCheckFlg() {
		return this.checkFlg;
	}
	
	/**
	 * @param chkDueDate
	 */
	public void setChkDueDate(String chkDueDate) {
		this.chkDueDate = chkDueDate == null ? null : chkDueDate.trim();
	}
	
    /**
     * @return ChkDueDate
     */	
	public String getChkDueDate() {
		return this.chkDueDate;
	}
	
	/**
	 * @param effectDate
	 */
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate == null ? null : effectDate.trim();
	}
	
    /**
     * @return EffectDate
     */	
	public String getEffectDate() {
		return this.effectDate;
	}
	
	/**
	 * @param expiredDate
	 */
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate == null ? null : expiredDate.trim();
	}
	
    /**
     * @return ExpiredDate
     */	
	public String getExpiredDate() {
		return this.expiredDate;
	}
	
	/**
	 * @param organName
	 */
	public void setOrganName(String organName) {
		this.organName = organName == null ? null : organName.trim();
	}
	
    /**
     * @return OrganName
     */	
	public String getOrganName() {
		return this.organName;
	}
	
	/**
	 * @param identRegAddr
	 */
	public void setIdentRegAddr(String identRegAddr) {
		this.identRegAddr = identRegAddr == null ? null : identRegAddr.trim();
	}
	
    /**
     * @return IdentRegAddr
     */	
	public String getIdentRegAddr() {
		return this.identRegAddr;
	}
	
	/**
	 * @param effectFlg
	 */
	public void setEffectFlg(String effectFlg) {
		this.effectFlg = effectFlg == null ? null : effectFlg.trim();
	}
	
    /**
     * @return EffectFlg
     */	
	public String getEffectFlg() {
		return this.effectFlg;
	}
	
	/**
	 * @param mainIdentFlg
	 */
	public void setMainIdentFlg(String mainIdentFlg) {
		this.mainIdentFlg = mainIdentFlg == null ? null : mainIdentFlg.trim();
	}
	
    /**
     * @return MainIdentFlg
     */	
	public String getMainIdentFlg() {
		return this.mainIdentFlg;
	}
	
	/**
	 * @param flgSetSys
	 */
	public void setFlgSetSys(String flgSetSys) {
		this.flgSetSys = flgSetSys == null ? null : flgSetSys.trim();
	}
	
    /**
     * @return FlgSetSys
     */	
	public String getFlgSetSys() {
		return this.flgSetSys;
	}
	
	/**
	 * @param identScanId
	 */
	public void setIdentScanId(String identScanId) {
		this.identScanId = identScanId == null ? null : identScanId.trim();
	}
	
    /**
     * @return IdentScanId
     */	
	public String getIdentScanId() {
		return this.identScanId;
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
        AcrmFciCustIdentInfo other = (AcrmFciCustIdentInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDt() == null ? other.dataDt== null : this.dataDt.equals(other.dataDt))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCheckFlg() == null ? other.getCheckFlg() == null : this.getCheckFlg().equals(other.getCheckFlg()))
        	&& (this.getChkDueDate() == null ? other.getChkDueDate() == null : this.getChkDueDate().equals(other.getChkDueDate()))
        	&& (this.getEffectDate() == null ? other.getEffectDate() == null : this.getEffectDate().equals(other.getEffectDate()))
        	&& (this.getExpiredDate() == null ? other.getExpiredDate() == null : this.getExpiredDate().equals(other.getExpiredDate()))
        	&& (this.getOrganName() == null ? other.getOrganName() == null : this.getOrganName().equals(other.getOrganName()))
        	&& (this.getIdentRegAddr() == null ? other.getIdentRegAddr() == null : this.getIdentRegAddr().equals(other.getIdentRegAddr()))
        	&& (this.getEffectFlg() == null ? other.getEffectFlg() == null : this.getEffectFlg().equals(other.getEffectFlg()))
        	&& (this.getMainIdentFlg() == null ? other.getMainIdentFlg() == null : this.getMainIdentFlg().equals(other.getMainIdentFlg()))
        	&& (this.getFlgSetSys() == null ? other.getFlgSetSys() == null : this.getFlgSetSys().equals(other.getFlgSetSys()))
        	&& (this.getIdentScanId() == null ? other.getIdentScanId() == null : this.getIdentScanId().equals(other.getIdentScanId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataDt() == null) ? 0 : getDataDt().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCheckFlg() == null) ? 0 : getCheckFlg().hashCode());
        result = prime * result + ((getChkDueDate() == null) ? 0 : getChkDueDate().hashCode());
        result = prime * result + ((getEffectDate() == null) ? 0 : getEffectDate().hashCode());
        result = prime * result + ((getExpiredDate() == null) ? 0 : getExpiredDate().hashCode());
        result = prime * result + ((getOrganName() == null) ? 0 : getOrganName().hashCode());
        result = prime * result + ((getIdentRegAddr() == null) ? 0 : getIdentRegAddr().hashCode());
        result = prime * result + ((getEffectFlg() == null) ? 0 : getEffectFlg().hashCode());
        result = prime * result + ((getMainIdentFlg() == null) ? 0 : getMainIdentFlg().hashCode());
        result = prime * result + ((getFlgSetSys() == null) ? 0 : getFlgSetSys().hashCode());
        result = prime * result + ((getIdentScanId() == null) ? 0 : getIdentScanId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDt=").append(dataDt);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", custType=").append(custType);
		sb.append(", custName=").append(custName);
		sb.append(", checkFlg=").append(checkFlg);
		sb.append(", chkDueDate=").append(chkDueDate);
		sb.append(", effectDate=").append(effectDate);
		sb.append(", expiredDate=").append(expiredDate);
		sb.append(", organName=").append(organName);
		sb.append(", identRegAddr=").append(identRegAddr);
		sb.append(", effectFlg=").append(effectFlg);
		sb.append(", mainIdentFlg=").append(mainIdentFlg);
		sb.append(", flgSetSys=").append(flgSetSys);
		sb.append(", identScanId=").append(identScanId);
        sb.append("]");
        return sb.toString();
    }
}