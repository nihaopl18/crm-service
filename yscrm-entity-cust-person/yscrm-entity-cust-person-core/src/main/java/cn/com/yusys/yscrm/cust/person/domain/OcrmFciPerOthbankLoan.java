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
 * @类名称: OcrmFciPerOthbankLoan
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 21:16:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_OTHBANK_LOAN")
public class OcrmFciPerOthbankLoan extends BaseDomain implements Serializable{
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
	
	/** 业务品种 **/
	@Column(name = "BUSS_CD", unique = false, nullable = true, length = 20)
	private String bussCd;
	
	/** 开户机构名称 **/
	@Column(name = "OPEN_BRCH_NAME", unique = false, nullable = true, length = 200)
	private String openBrchName;
	
	/** 币种 **/
	@Column(name = "CURR_CD", unique = false, nullable = true, length = 20)
	private String currCd;
	
	/** 合同编号 **/
	@Column(name = "CONT_NO", unique = false, nullable = true, length = 60)
	private String contNo;
	
	/** 借据号 **/
	@Column(name = "LOAN_NO", unique = false, nullable = true, length = 60)
	private String loanNo;
	
	/** 合同金额 **/
	@Column(name = "CONT_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal contAmt;
	
	/** 利率 **/
	@Column(name = "EXEC_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal execRate;
	
	/** 余额 **/
	@Column(name = "LOAN_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal loanBal;
	
	/** 首付\保证金比例 **/
	@Column(name = "MARGIN_RATIO", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal marginRatio;
	
	/** 主要担保方式 **/
	@Column(name = "MAIN_GUAR_CD", unique = false, nullable = true, length = 30)
	private String mainGuarCd;
	
	/** 抵押物 **/
	@Column(name = "MORTGAGE_NO", unique = false, nullable = true, length = 30)
	private String mortgageNo;
	
	/** 质押物 **/
	@Column(name = "PLEDGE_NO", unique = false, nullable = true, length = 30)
	private String pledgeNo;
	
	/** 还款方式 **/
	@Column(name = "REPAY_WAY", unique = false, nullable = true, length = 30)
	private String repayWay;
	
	/** 起始日期 **/
	@Column(name = "START_DATE", unique = false, nullable = true, length = 8)
	private String startDate;
	
	/** 到期日期 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 8)
	private String endDate;
	
	/** 是否有展期 **/
	@Column(name = "EXTEND_FLG", unique = false, nullable = true, length = 20)
	private String extendFlg;
	
	/** 是否借新还旧 **/
	@Column(name = "REFINANCE_FLG", unique = false, nullable = true, length = 20)
	private String refinanceFlg;
	
	/** 诉讼状态 **/
	@Column(name = "LAWSUIT_FLG", unique = false, nullable = true, length = 30)
	private String lawsuitFlg;
	
	/** 有效标志 **/
	@Column(name = "VALID_FLG", unique = false, nullable = true, length = 20)
	private String validFlg;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
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
	 * @param bussCd
	 */
	public void setBussCd(String bussCd) {
		this.bussCd = bussCd == null ? null : bussCd.trim();
	}
	
    /**
     * @return BussCd
     */	
	public String getBussCd() {
		return this.bussCd;
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
	 * @param contNo
	 */
	public void setContNo(String contNo) {
		this.contNo = contNo == null ? null : contNo.trim();
	}
	
    /**
     * @return ContNo
     */	
	public String getContNo() {
		return this.contNo;
	}
	
	/**
	 * @param loanNo
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo == null ? null : loanNo.trim();
	}
	
    /**
     * @return LoanNo
     */	
	public String getLoanNo() {
		return this.loanNo;
	}
	
	/**
	 * @param contAmt
	 */
	public void setContAmt(java.math.BigDecimal contAmt) {
		this.contAmt = contAmt;
	}
	
    /**
     * @return ContAmt
     */	
	public java.math.BigDecimal getContAmt() {
		return this.contAmt;
	}
	
	/**
	 * @param execRate
	 */
	public void setExecRate(java.math.BigDecimal execRate) {
		this.execRate = execRate;
	}
	
    /**
     * @return ExecRate
     */	
	public java.math.BigDecimal getExecRate() {
		return this.execRate;
	}
	
	/**
	 * @param loanBal
	 */
	public void setLoanBal(java.math.BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	
    /**
     * @return LoanBal
     */	
	public java.math.BigDecimal getLoanBal() {
		return this.loanBal;
	}
	
	/**
	 * @param marginRatio
	 */
	public void setMarginRatio(java.math.BigDecimal marginRatio) {
		this.marginRatio = marginRatio;
	}
	
    /**
     * @return MarginRatio
     */	
	public java.math.BigDecimal getMarginRatio() {
		return this.marginRatio;
	}
	
	/**
	 * @param mainGuarCd
	 */
	public void setMainGuarCd(String mainGuarCd) {
		this.mainGuarCd = mainGuarCd == null ? null : mainGuarCd.trim();
	}
	
    /**
     * @return MainGuarCd
     */	
	public String getMainGuarCd() {
		return this.mainGuarCd;
	}
	
	/**
	 * @param mortgageNo
	 */
	public void setMortgageNo(String mortgageNo) {
		this.mortgageNo = mortgageNo == null ? null : mortgageNo.trim();
	}
	
    /**
     * @return MortgageNo
     */	
	public String getMortgageNo() {
		return this.mortgageNo;
	}
	
	/**
	 * @param pledgeNo
	 */
	public void setPledgeNo(String pledgeNo) {
		this.pledgeNo = pledgeNo == null ? null : pledgeNo.trim();
	}
	
    /**
     * @return PledgeNo
     */	
	public String getPledgeNo() {
		return this.pledgeNo;
	}
	
	/**
	 * @param repayWay
	 */
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay == null ? null : repayWay.trim();
	}
	
    /**
     * @return RepayWay
     */	
	public String getRepayWay() {
		return this.repayWay;
	}
	
	/**
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}
	
    /**
     * @return StartDate
     */	
	public String getStartDate() {
		return this.startDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}
	
    /**
     * @return EndDate
     */	
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @param extendFlg
	 */
	public void setExtendFlg(String extendFlg) {
		this.extendFlg = extendFlg == null ? null : extendFlg.trim();
	}
	
    /**
     * @return ExtendFlg
     */	
	public String getExtendFlg() {
		return this.extendFlg;
	}
	
	/**
	 * @param refinanceFlg
	 */
	public void setRefinanceFlg(String refinanceFlg) {
		this.refinanceFlg = refinanceFlg == null ? null : refinanceFlg.trim();
	}
	
    /**
     * @return RefinanceFlg
     */	
	public String getRefinanceFlg() {
		return this.refinanceFlg;
	}
	
	/**
	 * @param lawsuitFlg
	 */
	public void setLawsuitFlg(String lawsuitFlg) {
		this.lawsuitFlg = lawsuitFlg == null ? null : lawsuitFlg.trim();
	}
	
    /**
     * @return LawsuitFlg
     */	
	public String getLawsuitFlg() {
		return this.lawsuitFlg;
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
        OcrmFciPerOthbankLoan other = (OcrmFciPerOthbankLoan) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getBussCd() == null ? other.getBussCd() == null : this.getBussCd().equals(other.getBussCd()))
        	&& (this.getOpenBrchName() == null ? other.getOpenBrchName() == null : this.getOpenBrchName().equals(other.getOpenBrchName()))
        	&& (this.getCurrCd() == null ? other.getCurrCd() == null : this.getCurrCd().equals(other.getCurrCd()))
        	&& (this.getContNo() == null ? other.getContNo() == null : this.getContNo().equals(other.getContNo()))
        	&& (this.getLoanNo() == null ? other.getLoanNo() == null : this.getLoanNo().equals(other.getLoanNo()))
                                        	&& (this.getMainGuarCd() == null ? other.getMainGuarCd() == null : this.getMainGuarCd().equals(other.getMainGuarCd()))
        	&& (this.getMortgageNo() == null ? other.getMortgageNo() == null : this.getMortgageNo().equals(other.getMortgageNo()))
        	&& (this.getPledgeNo() == null ? other.getPledgeNo() == null : this.getPledgeNo().equals(other.getPledgeNo()))
        	&& (this.getRepayWay() == null ? other.getRepayWay() == null : this.getRepayWay().equals(other.getRepayWay()))
        	&& (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
        	&& (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
        	&& (this.getExtendFlg() == null ? other.getExtendFlg() == null : this.getExtendFlg().equals(other.getExtendFlg()))
        	&& (this.getRefinanceFlg() == null ? other.getRefinanceFlg() == null : this.getRefinanceFlg().equals(other.getRefinanceFlg()))
        	&& (this.getLawsuitFlg() == null ? other.getLawsuitFlg() == null : this.getLawsuitFlg().equals(other.getLawsuitFlg()))
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
        result = prime * result + ((getBussCd() == null) ? 0 : getBussCd().hashCode());
        result = prime * result + ((getOpenBrchName() == null) ? 0 : getOpenBrchName().hashCode());
        result = prime * result + ((getCurrCd() == null) ? 0 : getCurrCd().hashCode());
        result = prime * result + ((getContNo() == null) ? 0 : getContNo().hashCode());
        result = prime * result + ((getLoanNo() == null) ? 0 : getLoanNo().hashCode());
        result = prime * result + ((getMainGuarCd() == null) ? 0 : getMainGuarCd().hashCode());
        result = prime * result + ((getMortgageNo() == null) ? 0 : getMortgageNo().hashCode());
        result = prime * result + ((getPledgeNo() == null) ? 0 : getPledgeNo().hashCode());
        result = prime * result + ((getRepayWay() == null) ? 0 : getRepayWay().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getExtendFlg() == null) ? 0 : getExtendFlg().hashCode());
        result = prime * result + ((getRefinanceFlg() == null) ? 0 : getRefinanceFlg().hashCode());
        result = prime * result + ((getLawsuitFlg() == null) ? 0 : getLawsuitFlg().hashCode());
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
		sb.append(", bussCd=").append(bussCd);
		sb.append(", openBrchName=").append(openBrchName);
		sb.append(", currCd=").append(currCd);
		sb.append(", contNo=").append(contNo);
		sb.append(", loanNo=").append(loanNo);
		sb.append(", contAmt=").append(contAmt);
		sb.append(", execRate=").append(execRate);
		sb.append(", loanBal=").append(loanBal);
		sb.append(", marginRatio=").append(marginRatio);
		sb.append(", mainGuarCd=").append(mainGuarCd);
		sb.append(", mortgageNo=").append(mortgageNo);
		sb.append(", pledgeNo=").append(pledgeNo);
		sb.append(", repayWay=").append(repayWay);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", extendFlg=").append(extendFlg);
		sb.append(", refinanceFlg=").append(refinanceFlg);
		sb.append(", lawsuitFlg=").append(lawsuitFlg);
		sb.append(", validFlg=").append(validFlg);
		sb.append(", remark=").append(remark);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}