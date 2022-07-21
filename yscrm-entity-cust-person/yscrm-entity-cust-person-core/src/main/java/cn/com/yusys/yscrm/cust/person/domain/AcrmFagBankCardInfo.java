package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagBankCardInfo
 * @类描述: #数据实体类
 * @功能描述: 账户信息-卡片信息
 * @创建人: 15104
 * @创建时间: 2019-01-29 10:16:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_BANK_CARD_INFO")
public class AcrmFagBankCardInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户编号
 **/
	@Id
	@Column(name = "CUST_NO")
	@Generated(GenerationType.UUID)
	private String custNo;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 卡片编号
 **/
	@Column(name = "CARD_NO", unique = false, nullable = true, length = 40)
	private String cardNo;
	
	/** 卡种类型代码
 **/
	@Column(name = "CARD_CATEG_TYPE_CD", unique = false, nullable = true, length = 1)
	private String cardCategTypeCd;
	
	/** 卡片级别代码
 **/
	@Column(name = "CARD_LVL_CD", unique = false, nullable = true, length = 1)
	private String cardLvlCd;
	
	/** 介质类型代码
 **/
	@Column(name = "MEDIUM_TYPE_CD", unique = false, nullable = true, length = 1)
	private String mediumTypeCd;
	
	/** 卡状态类型代码
 **/
	@Column(name = "CARD_STAT_TYPE_CD", unique = false, nullable = true, length = 1)
	private String cardStatTypeCd;
	
	/** 特殊渠道发卡类型代码
 **/
	@Column(name = "SPEC_CHA_SUE_CARD_TYPE_CD", unique = false, nullable = true, length = 1)
	private String specChaSueCardTypeCd;
	
	/** 员工卡标志
 **/
	@Column(name = "EMPL_CARD_IND", unique = false, nullable = true, length = 1)
	private String emplCardInd;
	
	/** 老卡标志
 **/
	@Column(name = "OLDCARD_FLAG", unique = false, nullable = true, length = 1)
	private String oldcardFlag;
	
	/** 发卡日期
 **/
	@Transient
	@Column(name = "SUE_CARD_DT", unique = false, nullable = true, length = 7)
	private Date sueCardDt;
	
	/** 发卡机构
 **/
	@Column(name = "SUE_CARD_ORG", unique = false, nullable = true, length = 20)
	private String sueCardOrg;
	
	/** 发卡柜员
 **/
	@Column(name = "SUE_CARD_TLR", unique = false, nullable = true, length = 20)
	private String sueCardTlr;
	
	/** 销卡日期
 **/
	@Transient
	@Column(name = "CANCEL_CARD_DT", unique = false, nullable = true, length = 7)
	private Date cancelCardDt;
	
	/** 销卡机构
 **/
	@Column(name = "CANCEL_CARD_ORG", unique = false, nullable = true, length = 20)
	private String cancelCardOrg;
	
	/** 销卡柜员
 **/
	@Column(name = "CANCEL_CARD_TLR", unique = false, nullable = true, length = 20)
	private String cancelCardTlr;
	
	/** 换卡日期
 **/
	@Transient
	@Column(name = "CHANGE_CARD_DT", unique = false, nullable = true, length = 7)
	private Date changeCardDt;
	
	/** 换卡机构
 **/
	@Column(name = "CHANGE_CARD_ORG", unique = false, nullable = true, length = 20)
	private String changeCardOrg;
	
	/** 换卡柜员
 **/
	@Column(name = "CHANGE_CARD_TLR", unique = false, nullable = true, length = 20)
	private String changeCardTlr;
	
	/** 归属机构
 **/
	@Column(name = "PROFIT_ORG", unique = false, nullable = true, length = 20)
	private String profitOrg;
	
	/** 卡片种类
 **/
	@Column(name = "CARD_KIND_CD", unique = false, nullable = true, length = 8)
	private String cardKindCd;
	
	
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
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return DataDt
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param cardNo
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo == null ? null : cardNo.trim();
	}
	
    /**
     * @return CardNo
     */	
	public String getCardNo() {
		return this.cardNo;
	}
	
	/**
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo == null ? null : custNo.trim();
	}
	
    /**
     * @return CustNo
     */	
	public String getCustNo() {
		return this.custNo;
	}
	
	/**
	 * @param cardCategTypeCd
	 */
	public void setCardCategTypeCd(String cardCategTypeCd) {
		this.cardCategTypeCd = cardCategTypeCd == null ? null : cardCategTypeCd.trim();
	}
	
    /**
     * @return CardCategTypeCd
     */	
	public String getCardCategTypeCd() {
		return this.cardCategTypeCd;
	}
	
	/**
	 * @param cardLvlCd
	 */
	public void setCardLvlCd(String cardLvlCd) {
		this.cardLvlCd = cardLvlCd == null ? null : cardLvlCd.trim();
	}
	
    /**
     * @return CardLvlCd
     */	
	public String getCardLvlCd() {
		return this.cardLvlCd;
	}
	
	/**
	 * @param mediumTypeCd
	 */
	public void setMediumTypeCd(String mediumTypeCd) {
		this.mediumTypeCd = mediumTypeCd == null ? null : mediumTypeCd.trim();
	}
	
    /**
     * @return MediumTypeCd
     */	
	public String getMediumTypeCd() {
		return this.mediumTypeCd;
	}
	
	/**
	 * @param cardStatTypeCd
	 */
	public void setCardStatTypeCd(String cardStatTypeCd) {
		this.cardStatTypeCd = cardStatTypeCd == null ? null : cardStatTypeCd.trim();
	}
	
    /**
     * @return CardStatTypeCd
     */	
	public String getCardStatTypeCd() {
		return this.cardStatTypeCd;
	}
	
	/**
	 * @param specChaSueCardTypeCd
	 */
	public void setSpecChaSueCardTypeCd(String specChaSueCardTypeCd) {
		this.specChaSueCardTypeCd = specChaSueCardTypeCd == null ? null : specChaSueCardTypeCd.trim();
	}
	
    /**
     * @return SpecChaSueCardTypeCd
     */	
	public String getSpecChaSueCardTypeCd() {
		return this.specChaSueCardTypeCd;
	}
	
	/**
	 * @param emplCardInd
	 */
	public void setEmplCardInd(String emplCardInd) {
		this.emplCardInd = emplCardInd == null ? null : emplCardInd.trim();
	}
	
    /**
     * @return EmplCardInd
     */	
	public String getEmplCardInd() {
		return this.emplCardInd;
	}
	
	/**
	 * @param oldcardFlag
	 */
	public void setOldcardFlag(String oldcardFlag) {
		this.oldcardFlag = oldcardFlag == null ? null : oldcardFlag.trim();
	}
	
    /**
     * @return OldcardFlag
     */	
	public String getOldcardFlag() {
		return this.oldcardFlag;
	}
	
	/**
	 * @param sueCardDt
	 */
	public void setSueCardDt(Date sueCardDt) {
		this.sueCardDt = sueCardDt;
	}
	
    /**
     * @return SueCardDt
     */	
	public Date getSueCardDt() {
		return this.sueCardDt;
	}
	
	/**
	 * @param sueCardOrg
	 */
	public void setSueCardOrg(String sueCardOrg) {
		this.sueCardOrg = sueCardOrg == null ? null : sueCardOrg.trim();
	}
	
    /**
     * @return SueCardOrg
     */	
	public String getSueCardOrg() {
		return this.sueCardOrg;
	}
	
	/**
	 * @param sueCardTlr
	 */
	public void setSueCardTlr(String sueCardTlr) {
		this.sueCardTlr = sueCardTlr == null ? null : sueCardTlr.trim();
	}
	
    /**
     * @return SueCardTlr
     */	
	public String getSueCardTlr() {
		return this.sueCardTlr;
	}
	
	/**
	 * @param cancelCardDt
	 */
	public void setCancelCardDt(Date cancelCardDt) {
		this.cancelCardDt = cancelCardDt;
	}
	
    /**
     * @return CancelCardDt
     */	
	public Date getCancelCardDt() {
		return this.cancelCardDt;
	}
	
	/**
	 * @param cancelCardOrg
	 */
	public void setCancelCardOrg(String cancelCardOrg) {
		this.cancelCardOrg = cancelCardOrg == null ? null : cancelCardOrg.trim();
	}
	
    /**
     * @return CancelCardOrg
     */	
	public String getCancelCardOrg() {
		return this.cancelCardOrg;
	}
	
	/**
	 * @param cancelCardTlr
	 */
	public void setCancelCardTlr(String cancelCardTlr) {
		this.cancelCardTlr = cancelCardTlr == null ? null : cancelCardTlr.trim();
	}
	
    /**
     * @return CancelCardTlr
     */	
	public String getCancelCardTlr() {
		return this.cancelCardTlr;
	}
	
	/**
	 * @param changeCardDt
	 */
	public void setChangeCardDt(Date changeCardDt) {
		this.changeCardDt = changeCardDt;
	}
	
    /**
     * @return ChangeCardDt
     */	
	public Date getChangeCardDt() {
		return this.changeCardDt;
	}
	
	/**
	 * @param changeCardOrg
	 */
	public void setChangeCardOrg(String changeCardOrg) {
		this.changeCardOrg = changeCardOrg == null ? null : changeCardOrg.trim();
	}
	
    /**
     * @return ChangeCardOrg
     */	
	public String getChangeCardOrg() {
		return this.changeCardOrg;
	}
	
	/**
	 * @param changeCardTlr
	 */
	public void setChangeCardTlr(String changeCardTlr) {
		this.changeCardTlr = changeCardTlr == null ? null : changeCardTlr.trim();
	}
	
    /**
     * @return ChangeCardTlr
     */	
	public String getChangeCardTlr() {
		return this.changeCardTlr;
	}
	
	/**
	 * @param profitOrg
	 */
	public void setProfitOrg(String profitOrg) {
		this.profitOrg = profitOrg == null ? null : profitOrg.trim();
	}
	
    /**
     * @return ProfitOrg
     */	
	public String getProfitOrg() {
		return this.profitOrg;
	}
	
	/**
	 * @param cardKindCd
	 */
	public void setCardKindCd(String cardKindCd) {
		this.cardKindCd = cardKindCd == null ? null : cardKindCd.trim();
	}
	
    /**
     * @return CardKindCd
     */	
	public String getCardKindCd() {
		return this.cardKindCd;
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
        AcrmFagBankCardInfo other = (AcrmFagBankCardInfo) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
        	&& (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
        	&& (this.getCardCategTypeCd() == null ? other.getCardCategTypeCd() == null : this.getCardCategTypeCd().equals(other.getCardCategTypeCd()))
        	&& (this.getCardLvlCd() == null ? other.getCardLvlCd() == null : this.getCardLvlCd().equals(other.getCardLvlCd()))
        	&& (this.getMediumTypeCd() == null ? other.getMediumTypeCd() == null : this.getMediumTypeCd().equals(other.getMediumTypeCd()))
        	&& (this.getCardStatTypeCd() == null ? other.getCardStatTypeCd() == null : this.getCardStatTypeCd().equals(other.getCardStatTypeCd()))
        	&& (this.getSpecChaSueCardTypeCd() == null ? other.getSpecChaSueCardTypeCd() == null : this.getSpecChaSueCardTypeCd().equals(other.getSpecChaSueCardTypeCd()))
        	&& (this.getEmplCardInd() == null ? other.getEmplCardInd() == null : this.getEmplCardInd().equals(other.getEmplCardInd()))
        	&& (this.getOldcardFlag() == null ? other.getOldcardFlag() == null : this.getOldcardFlag().equals(other.getOldcardFlag()))
                	&& (this.getSueCardOrg() == null ? other.getSueCardOrg() == null : this.getSueCardOrg().equals(other.getSueCardOrg()))
        	&& (this.getSueCardTlr() == null ? other.getSueCardTlr() == null : this.getSueCardTlr().equals(other.getSueCardTlr()))
                	&& (this.getCancelCardOrg() == null ? other.getCancelCardOrg() == null : this.getCancelCardOrg().equals(other.getCancelCardOrg()))
        	&& (this.getCancelCardTlr() == null ? other.getCancelCardTlr() == null : this.getCancelCardTlr().equals(other.getCancelCardTlr()))
                	&& (this.getChangeCardOrg() == null ? other.getChangeCardOrg() == null : this.getChangeCardOrg().equals(other.getChangeCardOrg()))
        	&& (this.getChangeCardTlr() == null ? other.getChangeCardTlr() == null : this.getChangeCardTlr().equals(other.getChangeCardTlr()))
        	&& (this.getProfitOrg() == null ? other.getProfitOrg() == null : this.getProfitOrg().equals(other.getProfitOrg()))
        	&& (this.getCardKindCd() == null ? other.getCardKindCd() == null : this.getCardKindCd().equals(other.getCardKindCd()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
        result = prime * result + ((getCardCategTypeCd() == null) ? 0 : getCardCategTypeCd().hashCode());
        result = prime * result + ((getCardLvlCd() == null) ? 0 : getCardLvlCd().hashCode());
        result = prime * result + ((getMediumTypeCd() == null) ? 0 : getMediumTypeCd().hashCode());
        result = prime * result + ((getCardStatTypeCd() == null) ? 0 : getCardStatTypeCd().hashCode());
        result = prime * result + ((getSpecChaSueCardTypeCd() == null) ? 0 : getSpecChaSueCardTypeCd().hashCode());
        result = prime * result + ((getEmplCardInd() == null) ? 0 : getEmplCardInd().hashCode());
        result = prime * result + ((getOldcardFlag() == null) ? 0 : getOldcardFlag().hashCode());
        result = prime * result + ((getSueCardOrg() == null) ? 0 : getSueCardOrg().hashCode());
        result = prime * result + ((getSueCardTlr() == null) ? 0 : getSueCardTlr().hashCode());
        result = prime * result + ((getCancelCardOrg() == null) ? 0 : getCancelCardOrg().hashCode());
        result = prime * result + ((getCancelCardTlr() == null) ? 0 : getCancelCardTlr().hashCode());
        result = prime * result + ((getChangeCardOrg() == null) ? 0 : getChangeCardOrg().hashCode());
        result = prime * result + ((getChangeCardTlr() == null) ? 0 : getChangeCardTlr().hashCode());
        result = prime * result + ((getProfitOrg() == null) ? 0 : getProfitOrg().hashCode());
        result = prime * result + ((getCardKindCd() == null) ? 0 : getCardKindCd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cardNo=").append(cardNo);
		sb.append(", custNo=").append(custNo);
		sb.append(", cardCategTypeCd=").append(cardCategTypeCd);
		sb.append(", cardLvlCd=").append(cardLvlCd);
		sb.append(", mediumTypeCd=").append(mediumTypeCd);
		sb.append(", cardStatTypeCd=").append(cardStatTypeCd);
		sb.append(", specChaSueCardTypeCd=").append(specChaSueCardTypeCd);
		sb.append(", emplCardInd=").append(emplCardInd);
		sb.append(", oldcardFlag=").append(oldcardFlag);
		sb.append(", sueCardDt=").append(sueCardDt);
		sb.append(", sueCardOrg=").append(sueCardOrg);
		sb.append(", sueCardTlr=").append(sueCardTlr);
		sb.append(", cancelCardDt=").append(cancelCardDt);
		sb.append(", cancelCardOrg=").append(cancelCardOrg);
		sb.append(", cancelCardTlr=").append(cancelCardTlr);
		sb.append(", changeCardDt=").append(changeCardDt);
		sb.append(", changeCardOrg=").append(changeCardOrg);
		sb.append(", changeCardTlr=").append(changeCardTlr);
		sb.append(", profitOrg=").append(profitOrg);
		sb.append(", cardKindCd=").append(cardKindCd);
        sb.append("]");
        return sb.toString();
    }
}