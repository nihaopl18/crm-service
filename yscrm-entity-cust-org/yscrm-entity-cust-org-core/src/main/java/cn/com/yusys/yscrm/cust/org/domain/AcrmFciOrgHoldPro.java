package cn.com.yusys.yscrm.cust.org.domain;

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
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgHoldPro
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-22 14:59:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_ORG_HOLD_PRO")
public class AcrmFciOrgHoldPro extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 基本户 **/
	@Column(name = "BASIC_HOU", unique = false, nullable = true, length = 2)
	private String basicHou;
	
	/** 定期存款 **/
	@Column(name = "REG_DEP", unique = false, nullable = true, length = 2)
	private String regDep;
	
	/** 代发工资 **/
	@Column(name = "ALT_PAYROLL", unique = false, nullable = true, length = 2)
	private String altPayroll;
	
	/** 一般贷款 **/
	@Column(name = "GEN_LOANS", unique = false, nullable = true, length = 2)
	private String genLoans;
	
	/** 银承 **/
	@Column(name = "BANK_ACC", unique = false, nullable = true, length = 2)
	private String bankAcc;
	
	/** 贴现 **/
	@Column(name = "DISCOUNT", unique = false, nullable = true, length = 2)
	private String discount;
	
	/** 保理 **/
	@Column(name = "FACTORING", unique = false, nullable = true, length = 2)
	private String factoring;
	
	/** 保函 **/
	@Column(name = "LET_OF_GUA", unique = false, nullable = true, length = 2)
	private String letOfGua;
	
	/** 信用证 **/
	@Column(name = "CRE_CER", unique = false, nullable = true, length = 2)
	private String creCer;
	
	/** 国结 **/
	@Column(name = "NAT_KNOT", unique = false, nullable = true, length = 2)
	private String natKnot;
	
	/** 理财 **/
	@Column(name = "FINANCIAL", unique = false, nullable = true, length = 2)
	private String financial;
	
	/** 保险 **/
	@Column(name = "INSURANCE", unique = false, nullable = true, length = 2)
	private String insurance;
	
	/** 基金 **/
	@Column(name = "FUND", unique = false, nullable = true, length = 2)
	private String fund;
	
	/** 贵金属 **/
	@Column(name = "PRE_MET", unique = false, nullable = true, length = 2)
	private String preMet;
	
	/** 网银 **/
	@Column(name = "ONL_BANK_SER", unique = false, nullable = true, length = 2)
	private String onlBankSer;
	
	/** 电话银行 **/
	@Column(name = "TELE_BANK", unique = false, nullable = true, length = 2)
	private String teleBank;
	
	/** 短信 **/
	@Column(name = "SMS", unique = false, nullable = true, length = 2)
	private String sms;
	
	/** POS机 **/
	@Column(name = "POS_MAC", unique = false, nullable = true, length = 2)
	private String posMac;
	
	/** 财智宝 **/
	@Column(name = "CAIZHI_BAO", unique = false, nullable = true, length = 2)
	private String caizhiBao;
	
	/** 大额存单 **/
	@Column(name = "LARGE_CER", unique = false, nullable = true, length = 2)
	private String largeCer;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	

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
	 * @param basicHou
	 */
	public void setBasicHou(String basicHou) {
		this.basicHou = basicHou == null ? null : basicHou.trim();
	}
	
    /**
     * @return BasicHou
     */	
	public String getBasicHou() {
		return this.basicHou;
	}
	
	/**
	 * @param regDep
	 */
	public void setRegDep(String regDep) {
		this.regDep = regDep == null ? null : regDep.trim();
	}
	
    /**
     * @return RegDep
     */	
	public String getRegDep() {
		return this.regDep;
	}
	
	/**
	 * @param altPayroll
	 */
	public void setAltPayroll(String altPayroll) {
		this.altPayroll = altPayroll == null ? null : altPayroll.trim();
	}
	
    /**
     * @return AltPayroll
     */	
	public String getAltPayroll() {
		return this.altPayroll;
	}
	
	/**
	 * @param genLoans
	 */
	public void setGenLoans(String genLoans) {
		this.genLoans = genLoans == null ? null : genLoans.trim();
	}
	
    /**
     * @return GenLoans
     */	
	public String getGenLoans() {
		return this.genLoans;
	}
	
	/**
	 * @param bankAcc
	 */
	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc == null ? null : bankAcc.trim();
	}
	
    /**
     * @return BankAcc
     */	
	public String getBankAcc() {
		return this.bankAcc;
	}
	
	/**
	 * @param discount
	 */
	public void setDiscount(String discount) {
		this.discount = discount == null ? null : discount.trim();
	}
	
    /**
     * @return Discount
     */	
	public String getDiscount() {
		return this.discount;
	}
	
	/**
	 * @param factoring
	 */
	public void setFactoring(String factoring) {
		this.factoring = factoring == null ? null : factoring.trim();
	}
	
    /**
     * @return Factoring
     */	
	public String getFactoring() {
		return this.factoring;
	}
	
	/**
	 * @param letOfGua
	 */
	public void setLetOfGua(String letOfGua) {
		this.letOfGua = letOfGua == null ? null : letOfGua.trim();
	}
	
    /**
     * @return LetOfGua
     */	
	public String getLetOfGua() {
		return this.letOfGua;
	}
	
	/**
	 * @param creCer
	 */
	public void setCreCer(String creCer) {
		this.creCer = creCer == null ? null : creCer.trim();
	}
	
    /**
     * @return CreCer
     */	
	public String getCreCer() {
		return this.creCer;
	}
	
	/**
	 * @param natKnot
	 */
	public void setNatKnot(String natKnot) {
		this.natKnot = natKnot == null ? null : natKnot.trim();
	}
	
    /**
     * @return NatKnot
     */	
	public String getNatKnot() {
		return this.natKnot;
	}
	
	/**
	 * @param financial
	 */
	public void setFinancial(String financial) {
		this.financial = financial == null ? null : financial.trim();
	}
	
    /**
     * @return Financial
     */	
	public String getFinancial() {
		return this.financial;
	}
	
	/**
	 * @param insurance
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance == null ? null : insurance.trim();
	}
	
    /**
     * @return Insurance
     */	
	public String getInsurance() {
		return this.insurance;
	}
	
	/**
	 * @param fund
	 */
	public void setFund(String fund) {
		this.fund = fund == null ? null : fund.trim();
	}
	
    /**
     * @return Fund
     */	
	public String getFund() {
		return this.fund;
	}
	
	/**
	 * @param preMet
	 */
	public void setPreMet(String preMet) {
		this.preMet = preMet == null ? null : preMet.trim();
	}
	
    /**
     * @return PreMet
     */	
	public String getPreMet() {
		return this.preMet;
	}
	
	/**
	 * @param onlBankSer
	 */
	public void setOnlBankSer(String onlBankSer) {
		this.onlBankSer = onlBankSer == null ? null : onlBankSer.trim();
	}
	
    /**
     * @return OnlBankSer
     */	
	public String getOnlBankSer() {
		return this.onlBankSer;
	}
	
	/**
	 * @param teleBank
	 */
	public void setTeleBank(String teleBank) {
		this.teleBank = teleBank == null ? null : teleBank.trim();
	}
	
    /**
     * @return TeleBank
     */	
	public String getTeleBank() {
		return this.teleBank;
	}
	
	/**
	 * @param sms
	 */
	public void setSms(String sms) {
		this.sms = sms == null ? null : sms.trim();
	}
	
    /**
     * @return Sms
     */	
	public String getSms() {
		return this.sms;
	}
	
	/**
	 * @param posMac
	 */
	public void setPosMac(String posMac) {
		this.posMac = posMac == null ? null : posMac.trim();
	}
	
    /**
     * @return PosMac
     */	
	public String getPosMac() {
		return this.posMac;
	}
	
	/**
	 * @param caizhiBao
	 */
	public void setCaizhiBao(String caizhiBao) {
		this.caizhiBao = caizhiBao == null ? null : caizhiBao.trim();
	}
	
    /**
     * @return CaizhiBao
     */	
	public String getCaizhiBao() {
		return this.caizhiBao;
	}
	
	/**
	 * @param largeCer
	 */
	public void setLargeCer(String largeCer) {
		this.largeCer = largeCer == null ? null : largeCer.trim();
	}
	
    /**
     * @return LargeCer
     */	
	public String getLargeCer() {
		return this.largeCer;
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
        AcrmFciOrgHoldPro other = (AcrmFciOrgHoldPro) that;
		return (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                	&& (this.getBasicHou() == null ? other.getBasicHou() == null : this.getBasicHou().equals(other.getBasicHou()))
        	&& (this.getRegDep() == null ? other.getRegDep() == null : this.getRegDep().equals(other.getRegDep()))
        	&& (this.getAltPayroll() == null ? other.getAltPayroll() == null : this.getAltPayroll().equals(other.getAltPayroll()))
        	&& (this.getGenLoans() == null ? other.getGenLoans() == null : this.getGenLoans().equals(other.getGenLoans()))
        	&& (this.getBankAcc() == null ? other.getBankAcc() == null : this.getBankAcc().equals(other.getBankAcc()))
        	&& (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
        	&& (this.getFactoring() == null ? other.getFactoring() == null : this.getFactoring().equals(other.getFactoring()))
        	&& (this.getLetOfGua() == null ? other.getLetOfGua() == null : this.getLetOfGua().equals(other.getLetOfGua()))
        	&& (this.getCreCer() == null ? other.getCreCer() == null : this.getCreCer().equals(other.getCreCer()))
        	&& (this.getNatKnot() == null ? other.getNatKnot() == null : this.getNatKnot().equals(other.getNatKnot()))
        	&& (this.getFinancial() == null ? other.getFinancial() == null : this.getFinancial().equals(other.getFinancial()))
        	&& (this.getInsurance() == null ? other.getInsurance() == null : this.getInsurance().equals(other.getInsurance()))
        	&& (this.getFund() == null ? other.getFund() == null : this.getFund().equals(other.getFund()))
        	&& (this.getPreMet() == null ? other.getPreMet() == null : this.getPreMet().equals(other.getPreMet()))
        	&& (this.getOnlBankSer() == null ? other.getOnlBankSer() == null : this.getOnlBankSer().equals(other.getOnlBankSer()))
        	&& (this.getTeleBank() == null ? other.getTeleBank() == null : this.getTeleBank().equals(other.getTeleBank()))
        	&& (this.getSms() == null ? other.getSms() == null : this.getSms().equals(other.getSms()))
        	&& (this.getPosMac() == null ? other.getPosMac() == null : this.getPosMac().equals(other.getPosMac()))
        	&& (this.getCaizhiBao() == null ? other.getCaizhiBao() == null : this.getCaizhiBao().equals(other.getCaizhiBao()))
        	&& (this.getLargeCer() == null ? other.getLargeCer() == null : this.getLargeCer().equals(other.getLargeCer()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getBasicHou() == null) ? 0 : getBasicHou().hashCode());
        result = prime * result + ((getRegDep() == null) ? 0 : getRegDep().hashCode());
        result = prime * result + ((getAltPayroll() == null) ? 0 : getAltPayroll().hashCode());
        result = prime * result + ((getGenLoans() == null) ? 0 : getGenLoans().hashCode());
        result = prime * result + ((getBankAcc() == null) ? 0 : getBankAcc().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getFactoring() == null) ? 0 : getFactoring().hashCode());
        result = prime * result + ((getLetOfGua() == null) ? 0 : getLetOfGua().hashCode());
        result = prime * result + ((getCreCer() == null) ? 0 : getCreCer().hashCode());
        result = prime * result + ((getNatKnot() == null) ? 0 : getNatKnot().hashCode());
        result = prime * result + ((getFinancial() == null) ? 0 : getFinancial().hashCode());
        result = prime * result + ((getInsurance() == null) ? 0 : getInsurance().hashCode());
        result = prime * result + ((getFund() == null) ? 0 : getFund().hashCode());
        result = prime * result + ((getPreMet() == null) ? 0 : getPreMet().hashCode());
        result = prime * result + ((getOnlBankSer() == null) ? 0 : getOnlBankSer().hashCode());
        result = prime * result + ((getTeleBank() == null) ? 0 : getTeleBank().hashCode());
        result = prime * result + ((getSms() == null) ? 0 : getSms().hashCode());
        result = prime * result + ((getPosMac() == null) ? 0 : getPosMac().hashCode());
        result = prime * result + ((getCaizhiBao() == null) ? 0 : getCaizhiBao().hashCode());
        result = prime * result + ((getLargeCer() == null) ? 0 : getLargeCer().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custId=").append(custId);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", basicHou=").append(basicHou);
		sb.append(", regDep=").append(regDep);
		sb.append(", altPayroll=").append(altPayroll);
		sb.append(", genLoans=").append(genLoans);
		sb.append(", bankAcc=").append(bankAcc);
		sb.append(", discount=").append(discount);
		sb.append(", factoring=").append(factoring);
		sb.append(", letOfGua=").append(letOfGua);
		sb.append(", creCer=").append(creCer);
		sb.append(", natKnot=").append(natKnot);
		sb.append(", financial=").append(financial);
		sb.append(", insurance=").append(insurance);
		sb.append(", fund=").append(fund);
		sb.append(", preMet=").append(preMet);
		sb.append(", onlBankSer=").append(onlBankSer);
		sb.append(", teleBank=").append(teleBank);
		sb.append(", sms=").append(sms);
		sb.append(", posMac=").append(posMac);
		sb.append(", caizhiBao=").append(caizhiBao);
		sb.append(", largeCer=").append(largeCer);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}