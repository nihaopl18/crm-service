package cn.com.yusys.yscrm.cust.org.domain;

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
 * @类名称: OcrmFciOrgHolderInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-16 22:50:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_ORG_HOLDER_INFO")
public class OcrmFciOrgHolderInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String  dataDate;
	
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
	/** 最新更新时间
	 **/
		
		@Column(name = "SPONSOR_DATE", unique = false, nullable = true, length = 7)
		private Date sponsorDate;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 股东客户号
 **/
	@Column(name = "HOLDER_CUST_ID", unique = false, nullable = true, length = 40)
	private String holderCustId;
	
	/** 股东类型
 **/
	@Column(name = "HOLDER_TYPE", unique = false, nullable = true, length = 30)
	private String holderType;
	
	/** 股东名称
 **/
	@Column(name = "HOLDER_NAME", unique = false, nullable = true, length = 200)
	private String holderName;
	
	/** 股东证件类型
 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = true, length = 30)
	private String certType;
	
	/** 股东证件号码
 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 50)
	private String certNo;
	
	/** 法人代表客户号
 **/
	@Column(name = "LEGAL_CUST_ID", unique = false, nullable = true, length = 40)
	private String legalCustId;
	
	/** 法人代表名称
 **/
	@Column(name = "LEGAL_NAME", unique = false, nullable = true, length = 200)
	private String legalName;
	
	/** 法人代表证件类型
 **/
	@Column(name = "LEGAL_CERT_TYPE", unique = false, nullable = true, length = 30)
	private String legalCertType;
	
	/** 法人代表证件号码
 **/
	@Column(name = "LEGAL_CERT_NO", unique = false, nullable = true, length = 50)
	private String legalCertNo;
	
	/** 出资方式
 **/
	@Column(name = "INV_TYPE", unique = false, nullable = true, length = 300)
	private String invType;
	
	/** 出资币种
 **/
	@Column(name = "INV_CURR_CD", unique = false, nullable = true, length = 30)
	private String invCurrCd;
	
	/** 持股比例
 **/
	@Column(name = "STOCK_PERC", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal stockPerc;
	
	/** 出资金额
 **/
	@Column(name = "INV_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal invAmt;
	
	/** 实际持股金额(元)
 **/
	@Column(name = "ACT_STOCK_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal actStockAmt;
	
	/** 最近更新人机构ID **/
	@Column(name = "LAST_CHG_ORG_ID", unique = false, nullable = true, length = 20)
	private String lastChgOrgId;
	
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
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
	 * @param sponsorDate
	 */
	public void setSponsorDate(Date sponsorDate) {
		this.sponsorDate = sponsorDate;
	}
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	/**
     * @return SponsorDate
     */	
	public Date getSponsorDate() {
		return this.sponsorDate;
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
	 * @param holderCustId
	 */
	public void setHolderCustId(String holderCustId) {
		this.holderCustId = holderCustId == null ? null : holderCustId.trim();
	}
	
    /**
     * @return HolderCustId
     */	
	public String getHolderCustId() {
		return this.holderCustId;
	}
	
	/**
	 * @param holderType
	 */
	public void setHolderType(String holderType) {
		this.holderType = holderType == null ? null : holderType.trim();
	}
	
    /**
     * @return HolderType
     */	
	public String getHolderType() {
		return this.holderType;
	}
	
	/**
	 * @param holderName
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName == null ? null : holderName.trim();
	}
	
    /**
     * @return HolderName
     */	
	public String getHolderName() {
		return this.holderName;
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
	 * @param legalCustId
	 */
	public void setLegalCustId(String legalCustId) {
		this.legalCustId = legalCustId == null ? null : legalCustId.trim();
	}
	
    /**
     * @return LegalCustId
     */	
	public String getLegalCustId() {
		return this.legalCustId;
	}
	
	/**
	 * @param legalName
	 */
	public void setLegalName(String legalName) {
		this.legalName = legalName == null ? null : legalName.trim();
	}
	
    /**
     * @return LegalName
     */	
	public String getLegalName() {
		return this.legalName;
	}
	
	/**
	 * @param legalCertType
	 */
	public void setLegalCertType(String legalCertType) {
		this.legalCertType = legalCertType == null ? null : legalCertType.trim();
	}
	
    /**
     * @return LegalCertType
     */	
	public String getLegalCertType() {
		return this.legalCertType;
	}
	
	/**
	 * @param legalCertNo
	 */
	public void setLegalCertNo(String legalCertNo) {
		this.legalCertNo = legalCertNo == null ? null : legalCertNo.trim();
	}
	
    /**
     * @return LegalCertNo
     */	
	public String getLegalCertNo() {
		return this.legalCertNo;
	}
	
	/**
	 * @param invType
	 */
	public void setInvType(String invType) {
		this.invType = invType == null ? null : invType.trim();
	}
	
    /**
     * @return InvType
     */	
	public String getInvType() {
		return this.invType;
	}
	
	/**
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd == null ? null : invCurrCd.trim();
	}
	
    /**
     * @return InvCurrCd
     */	
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * @param stockPerc
	 */
	public void setStockPerc(java.math.BigDecimal stockPerc) {
		this.stockPerc = stockPerc;
	}
	
    /**
     * @return StockPerc
     */	
	public java.math.BigDecimal getStockPerc() {
		return this.stockPerc;
	}
	
	/**
	 * @param invAmt
	 */
	public void setInvAmt(java.math.BigDecimal invAmt) {
		this.invAmt = invAmt;
	}
	
    /**
     * @return InvAmt
     */	
	public java.math.BigDecimal getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * @param actStockAmt
	 */
	public void setActStockAmt(java.math.BigDecimal actStockAmt) {
		this.actStockAmt = actStockAmt;
	}
	
    /**
     * @return ActStockAmt
     */	
	public java.math.BigDecimal getActStockAmt() {
		return this.actStockAmt;
	}
	
	/**
	 * @param lastChgOrgId
	 */
	public void setLastChgOrgId(String lastChgOrgId) {
		this.lastChgOrgId = lastChgOrgId == null ? null : lastChgOrgId.trim();
	}
	
    /**
     * @return LastChgOrgId
     */	
	public String getLastChgOrgId() {
		return this.lastChgOrgId;
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
        OcrmFciOrgHolderInfo other = (OcrmFciOrgHolderInfo) that;
                		return (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getHolderCustId() == null ? other.getHolderCustId() == null : this.getHolderCustId().equals(other.getHolderCustId()))
        	&& (this.getHolderType() == null ? other.getHolderType() == null : this.getHolderType().equals(other.getHolderType()))
        	&& (this.getHolderName() == null ? other.getHolderName() == null : this.getHolderName().equals(other.getHolderName()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getLegalCustId() == null ? other.getLegalCustId() == null : this.getLegalCustId().equals(other.getLegalCustId()))
        	&& (this.getLegalName() == null ? other.getLegalName() == null : this.getLegalName().equals(other.getLegalName()))
        	&& (this.getLegalCertType() == null ? other.getLegalCertType() == null : this.getLegalCertType().equals(other.getLegalCertType()))
        	&& (this.getLegalCertNo() == null ? other.getLegalCertNo() == null : this.getLegalCertNo().equals(other.getLegalCertNo()))
        	&& (this.getInvType() == null ? other.getInvType() == null : this.getInvType().equals(other.getInvType()))
        	&& (this.getInvCurrCd() == null ? other.getInvCurrCd() == null : this.getInvCurrCd().equals(other.getInvCurrCd()))
                                	&& (this.getLastChgOrgId() == null ? other.getLastChgOrgId() == null : this.getLastChgOrgId().equals(other.getLastChgOrgId()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getHolderCustId() == null) ? 0 : getHolderCustId().hashCode());
        result = prime * result + ((getHolderType() == null) ? 0 : getHolderType().hashCode());
        result = prime * result + ((getHolderName() == null) ? 0 : getHolderName().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getLegalCustId() == null) ? 0 : getLegalCustId().hashCode());
        result = prime * result + ((getLegalName() == null) ? 0 : getLegalName().hashCode());
        result = prime * result + ((getLegalCertType() == null) ? 0 : getLegalCertType().hashCode());
        result = prime * result + ((getLegalCertNo() == null) ? 0 : getLegalCertNo().hashCode());
        result = prime * result + ((getInvType() == null) ? 0 : getInvType().hashCode());
        result = prime * result + ((getInvCurrCd() == null) ? 0 : getInvCurrCd().hashCode());
        result = prime * result + ((getLastChgOrgId() == null) ? 0 : getLastChgOrgId().hashCode());
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
		sb.append(", sponsorDate=").append(sponsorDate);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", holderCustId=").append(holderCustId);
		sb.append(", holderType=").append(holderType);
		sb.append(", holderName=").append(holderName);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", legalCustId=").append(legalCustId);
		sb.append(", legalName=").append(legalName);
		sb.append(", legalCertType=").append(legalCertType);
		sb.append(", legalCertNo=").append(legalCertNo);
		sb.append(", invType=").append(invType);
		sb.append(", invCurrCd=").append(invCurrCd);
		sb.append(", stockPerc=").append(stockPerc);
		sb.append(", invAmt=").append(invAmt);
		sb.append(", actStockAmt=").append(actStockAmt);
		sb.append(", lastChgOrgId=").append(lastChgOrgId);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}