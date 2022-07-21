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
 * @类名称: OcrmFciLawsuitInfo
 * @类描述: #数据实体类
 * @功能描述: 诉讼信息
 * @创建人: 15104
 * @创建时间: 2019-02-13 13:13:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_LAWSUIT_INFO")
public class OcrmFciLawsuitInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
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
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = false, length = 40)
	private String custId;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 登记日期
 **/
	@Column(name = "REG_DATE", unique = false, nullable = true, length = 7)
	private Date regDate;
	
	/** 结欠金额(元)
 **/
	@Column(name = "UNPD_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal unpdAmt;
	
	/** 诉讼阶段
 **/
	@Column(name = "LAWSUIT_STAT", unique = false, nullable = true, length = 300)
	private String lawsuitStat;
	
	/** 原借款金额
 **/
	@Column(name = "LOAN_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal loanAmt;
	
	/** 其他被起诉人
 **/
	@Column(name = "OTHER_LAWSUITER", unique = false, nullable = true, length = 100)
	private String otherLawsuiter;
	
	/** 来源系统
 **/
	@Column(name = "SRC_SYS_CD", unique = false, nullable = true, length = 20)
	private String srcSysCd;
	
	/** 登记人
 **/
	@Column(name = "INPUT_ID", unique = false, nullable = true, length = 20)
	private String inputId;
	
	/** 备注
 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 300)
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
	 * @param regDate
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
    /**
     * @return RegDate
     */	
	public Date getRegDate() {
		return this.regDate;
	}
	
	/**
	 * @param unpdAmt
	 */
	public void setUnpdAmt(java.math.BigDecimal unpdAmt) {
		this.unpdAmt = unpdAmt;
	}
	
    /**
     * @return UnpdAmt
     */	
	public java.math.BigDecimal getUnpdAmt() {
		return this.unpdAmt;
	}
	
	/**
	 * @param lawsuitStat
	 */
	public void setLawsuitStat(String lawsuitStat) {
		this.lawsuitStat = lawsuitStat == null ? null : lawsuitStat.trim();
	}
	
    /**
     * @return LawsuitStat
     */	
	public String getLawsuitStat() {
		return this.lawsuitStat;
	}
	
	/**
	 * @param loanAmt
	 */
	public void setLoanAmt(java.math.BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}
	
    /**
     * @return LoanAmt
     */	
	public java.math.BigDecimal getLoanAmt() {
		return this.loanAmt;
	}
	
	/**
	 * @param otherLawsuiter
	 */
	public void setOtherLawsuiter(String otherLawsuiter) {
		this.otherLawsuiter = otherLawsuiter == null ? null : otherLawsuiter.trim();
	}
	
    /**
     * @return OtherLawsuiter
     */	
	public String getOtherLawsuiter() {
		return this.otherLawsuiter;
	}
	
	/**
	 * @param srcSysCd
	 */
	public void setSrcSysCd(String srcSysCd) {
		this.srcSysCd = srcSysCd == null ? null : srcSysCd.trim();
	}
	
    /**
     * @return SrcSysCd
     */	
	public String getSrcSysCd() {
		return this.srcSysCd;
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
        OcrmFciLawsuitInfo other = (OcrmFciLawsuitInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                        	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
                        	&& (this.getLawsuitStat() == null ? other.getLawsuitStat() == null : this.getLawsuitStat().equals(other.getLawsuitStat()))
                	&& (this.getOtherLawsuiter() == null ? other.getOtherLawsuiter() == null : this.getOtherLawsuiter().equals(other.getOtherLawsuiter()))
        	&& (this.getSrcSysCd() == null ? other.getSrcSysCd() == null : this.getSrcSysCd().equals(other.getSrcSysCd()))
        	&& (this.getInputId() == null ? other.getInputId() == null : this.getInputId().equals(other.getInputId()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getLawsuitStat() == null) ? 0 : getLawsuitStat().hashCode());
        result = prime * result + ((getOtherLawsuiter() == null) ? 0 : getOtherLawsuiter().hashCode());
        result = prime * result + ((getSrcSysCd() == null) ? 0 : getSrcSysCd().hashCode());
        result = prime * result + ((getInputId() == null) ? 0 : getInputId().hashCode());
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
		sb.append(", custType=").append(custType);
		sb.append(", regDate=").append(regDate);
		sb.append(", unpdAmt=").append(unpdAmt);
		sb.append(", lawsuitStat=").append(lawsuitStat);
		sb.append(", loanAmt=").append(loanAmt);
		sb.append(", otherLawsuiter=").append(otherLawsuiter);
		sb.append(", srcSysCd=").append(srcSysCd);
		sb.append(", inputId=").append(inputId);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}