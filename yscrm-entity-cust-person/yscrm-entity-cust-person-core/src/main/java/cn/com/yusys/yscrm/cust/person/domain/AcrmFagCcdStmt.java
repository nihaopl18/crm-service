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
 * @类名称: AcrmFagCcdStmt
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 12:13:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_CCD_STMT")
public class AcrmFagCcdStmt extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 账户编号 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 20)
	private String acctNo;
	
	/** 账单日期 **/
	@Transient
	@Column(name = "BILL_DATE", unique = false, nullable = true, length = 7)
	private Date billDate;
	
	/** 卡号 **/
	@Column(name = "CARD_NO", unique = false, nullable = true, length = 30)
	private String cardNo;
	
	/** 期初积分余额 **/
	@Column(name = "FRIST_POINTS_BAL", unique = false, nullable = true, length = 13)
	private long fristPointsBal;
	
	/** 当期新增积分 **/
	@Column(name = "PRES_ADD_POINTS", unique = false, nullable = true, length = 13)
	private long presAddPoints;
	
	/** 当期调整积分 **/
	@Column(name = "PRES_ADJ_POINTS", unique = false, nullable = true, length = 13)
	private long presAdjPoints;
	
	/** 当期兑换积分 **/
	@Column(name = "PRES_EXCHG_POINTS", unique = false, nullable = true, length = 13)
	private long presExchgPoints;
	
	/** 积分余额 **/
	@Column(name = "POINTS_BAL", unique = false, nullable = true, length = 13)
	private long pointsBal;
	
	/** 本期账单金额 **/
	@Column(name = "PRES_BILL_AMT", unique = false, nullable = true, length = 15)
	private java.math.BigDecimal presBillAmt;
	
	/** 本期调整金额 **/
	@Column(name = "PRES_ADJ_AMT", unique = false, nullable = true, length = 15)
	private java.math.BigDecimal presAdjAmt;
	
	/** 本期奖励积分 **/
	@Column(name = "PRES_AWARD_POINTS", unique = false, nullable = true, length = 13)
	private long presAwardPoints;
	
	
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
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo == null ? null : acctNo.trim();
	}
	
    /**
     * @return AcctNo
     */	
	public String getAcctNo() {
		return this.acctNo;
	}
	
	/**
	 * @param billDate
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
    /**
     * @return BillDate
     */	
	public Date getBillDate() {
		return this.billDate;
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
	 * @param fristPointsBal
	 */
	public void setFristPointsBal(long fristPointsBal) {
		this.fristPointsBal = fristPointsBal;
	}
	
    /**
     * @return FristPointsBal
     */	
	public long getFristPointsBal() {
		return this.fristPointsBal;
	}
	
	/**
	 * @param presAddPoints
	 */
	public void setPresAddPoints(long presAddPoints) {
		this.presAddPoints = presAddPoints;
	}
	
    /**
     * @return PresAddPoints
     */	
	public long getPresAddPoints() {
		return this.presAddPoints;
	}
	
	/**
	 * @param presAdjPoints
	 */
	public void setPresAdjPoints(long presAdjPoints) {
		this.presAdjPoints = presAdjPoints;
	}
	
    /**
     * @return PresAdjPoints
     */	
	public long getPresAdjPoints() {
		return this.presAdjPoints;
	}
	
	/**
	 * @param presExchgPoints
	 */
	public void setPresExchgPoints(long presExchgPoints) {
		this.presExchgPoints = presExchgPoints;
	}
	
    /**
     * @return PresExchgPoints
     */	
	public long getPresExchgPoints() {
		return this.presExchgPoints;
	}
	
	/**
	 * @param pointsBal
	 */
	public void setPointsBal(long pointsBal) {
		this.pointsBal = pointsBal;
	}
	
    /**
     * @return PointsBal
     */	
	public long getPointsBal() {
		return this.pointsBal;
	}
	
	/**
	 * @param presBillAmt
	 */
	public void setPresBillAmt(java.math.BigDecimal presBillAmt) {
		this.presBillAmt = presBillAmt;
	}
	
    /**
     * @return PresBillAmt
     */	
	public java.math.BigDecimal getPresBillAmt() {
		return this.presBillAmt;
	}
	
	/**
	 * @param presAdjAmt
	 */
	public void setPresAdjAmt(java.math.BigDecimal presAdjAmt) {
		this.presAdjAmt = presAdjAmt;
	}
	
    /**
     * @return PresAdjAmt
     */	
	public java.math.BigDecimal getPresAdjAmt() {
		return this.presAdjAmt;
	}
	
	/**
	 * @param presAwardPoints
	 */
	public void setPresAwardPoints(long presAwardPoints) {
		this.presAwardPoints = presAwardPoints;
	}
	
    /**
     * @return PresAwardPoints
     */	
	public long getPresAwardPoints() {
		return this.presAwardPoints;
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
        AcrmFagCcdStmt other = (AcrmFagCcdStmt) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
                	&& (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
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
		sb.append(", acctNo=").append(acctNo);
		sb.append(", billDate=").append(billDate);
		sb.append(", cardNo=").append(cardNo);
		sb.append(", fristPointsBal=").append(fristPointsBal);
		sb.append(", presAddPoints=").append(presAddPoints);
		sb.append(", presAdjPoints=").append(presAdjPoints);
		sb.append(", presExchgPoints=").append(presExchgPoints);
		sb.append(", pointsBal=").append(pointsBal);
		sb.append(", presBillAmt=").append(presBillAmt);
		sb.append(", presAdjAmt=").append(presAdjAmt);
		sb.append(", presAwardPoints=").append(presAwardPoints);
        sb.append("]");
        return sb.toString();
    }
}