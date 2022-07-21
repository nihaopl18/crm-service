package cn.com.yusys.yusp.dycrm.transferInfo.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACRM_F_FA_TRAN_DETAIL")
public class AcrmFfaTranDetail extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 客户号 **/
	@Column(name = "CUST_NO", unique = false, nullable = true, length = 50)
	private String custNo;

	/** 银行帐户 **/
	@Column(name = "BANK_ACCT", unique = false, nullable = true, length = 50)
	private String bankAcct;

	/** 理财账号 **/
	@Column(name = "FINANCE_ACCT_NO", unique = false, nullable = true, length = 50)
	private String financeAcctNo;

	/** 交易流水号 **/
	@Column(name = "TRANS_SERIAL_NO", unique = false, nullable = true, length = 50)
	private String transSerialNo;

	/** 交易币种 **/
	@Column(name = "TRANS_CCY", unique = false, nullable = true, length = 50)
	private String transCcy;

	/** 交易金额 **/
	@Column(name = "TRANS_AMT", unique = false, nullable = true, length = 7)
	private String transAmt;

	/** 交易日期 **/
	@Column(name = "TRANS_DATE", unique = false, nullable = true, length = 50)
	private Date transDate;

	/** 交易时间（时分秒） **/
	@Column(name = "TRANS_TIME", unique = false, nullable = true, length = 7)
	private Date transTime;

	/** 交易机构 **/
	@Column(name = "TRANS_ORG", unique = false, nullable = true, length = 50)
	private String transOrg;

	/** 交易渠道 **/
	@Column(name = "TRANS_CHANNEL", unique = false, nullable = true, length = 50)
	private String transChannel;

	/** 跨行标志 **/
	@Column(name = "INTER_BANK_FLAG", unique = false, nullable = true, length = 50)
	private String interBankFlag;

	/** 交易柜员 **/
	@Column(name = "TRANS_TELLER", unique = false, nullable = true, length = 50)
	private String transTeller;

	/** 交易名称 **/
	@Column(name = "TRANS_NAME", unique = false, nullable = true, length = 50)
	private String transName;

	/** 理财业务分类 **/
	@Column(name = "FINANCE_BUSSINESS_TYPE", unique = false, nullable = true, length = 50)
	private String financeBussinesssType;

	/** 交易状态 **/
	@Column(name = "TRANS_STATUS", unique = false, nullable = true, length = 50)
	private String transStatus;

	/** 原产品编号 **/
	@Column(name = "SRC_PROD_CODE", unique = false, nullable = true, length = 50)
	private String srcProdCode;

	/** 产品名称 **/
	@Column(name = "PROD_NAME", unique = false, nullable = true, length = 50)
	private String prodName;

	/** 产品币种 **/
	@Column(name = "PROD_CCY", unique = false, nullable = true, length = 50)
	private String prodCcy;

	/** 交易份额 **/
	@Column(name = "TRANS_SHARE", unique = false, nullable = true, length = 50)
	private String transShare;

	/** 确认日期 **/
	@Column(name = "CONFIRM_DATE", unique = false, nullable = true, length = 7)
	private Date confirmDate;

	/** 确认金额 **/
	@Column(name = "CONFIRM_AMT", unique = false, nullable = true, length = 50)
	private String confirmAmt;

	/** 确认份额 **/
	@Column(name = "CONFIRM_SHARE", unique = false, nullable = true, length = 50)
	private String confirmShare;

	/** 手续费 **/
	@Column(name = "FEE_AMT", unique = false, nullable = true, length = 50)
	private String feeAmt;

	/** 数据状态 **/
	@Column(name = "DATA_STATUS", unique = false, nullable = true, length = 50)
	private String dataStatus;

	/** 业务类型 **/
	@Column(name = "BUSSINESS_TYPE", unique = false, nullable = true, length = 50)
	private String businessType;

	/** QD产品类别 **/
	@Column(name = "QD_PROD_CLASS", unique = false, nullable = true, length = 50)
	private String qdProdClass;

	/** 收费类别 **/
	@Column(name = "FEE_TYPE", unique = false, nullable = true, length = 50)
	private String feeType;

	/** 费用币种 **/
	@Column(name = "FEE_CCY", unique = false, nullable = true, length = 50)
	private String feeCcy;

	/** 对方网点号 **/
	@Column(name = "OPPONENT_ORG", unique = false, nullable = true, length = 50)
	private String opponentOrg;

	/** 对方理财账号 **/
	@Column(name = "OPPONENT_FINACE_ACCT", unique = false, nullable = true, length = 50)
	private String opponentFinaceAcct;

	/** 分红方式 **/
	@Column(name = "BOUNS_TYPE", unique = false, nullable = true, length = 50)
	private String bounsType;

	/** 分红比例（%） **/
	@Column(name = "BONUS_RATE", unique = false, nullable = true, length = 50)
	private String bonusRate;

	/** TA确认流水号 **/
	@Column(name = "TA_CONFIRM_SERIAL_NO", unique = false, nullable = true, length = 50)
	private String taConfirmSerialNo;

	/**
	 * @return custNo
	 */
	public String getCustNo() {
		return custNo;
	}

	/**
	 * @param custNo
	 *            要设置的 custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo == null ? null : custNo.trim();
	}

	/**
	 * @return transSerialNo
	 */
	public String getTransSerialNo() {
		return transSerialNo;
	}

	/**
	 * @param transSerialNo
	 *            要设置的 transSerialNo
	 */
	public void setTransSerialNo(String transSerialNo) {
		this.transSerialNo = transSerialNo == null ? null : transSerialNo.trim();
	}

	/**
	 * @return transCcy
	 */
	public String getTransCcy() {
		return transCcy;
	}

	/**
	 * @param transCcy
	 *            要设置的 transCcy
	 */
	public void setTransCcy(String transCcy) {
		this.transCcy = transCcy == null ? null : transCcy.trim();
	}

	/**
	 * @return transAmt
	 */
	public String getTransAmt() {
		return transAmt;
	}

	/**
	 * @param transAmt
	 *            要设置的 transAmt
	 */
	public void setTransAmt(String transAmt) {
		this.transAmt = transAmt == null ? null : transAmt.trim();
	}

	/**
	 * @return transDate
	 */
	public Date getTransDate() {
		return transDate;
	}

	/**
	 * @param transDate
	 *            要设置的 transDate
	 */
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	/**
	 * @return transTime
	 */
	public Date getTransTime() {
		return transTime;
	}

	/**
	 * @param transTime
	 *            要设置的 transTime
	 */
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}

	/**
	 * @return transOrg
	 */
	public String getTransOrg() {
		return transOrg;
	}

	/**
	 * @param transOrg
	 *            要设置的 transOrg
	 */
	public void setTransOrg(String transOrg) {
		this.transOrg = transOrg == null ? null : transOrg.trim();
	}

	/**
	 * @return transChannel
	 */
	public String getTransChannel() {
		return transChannel;
	}

	/**
	 * @param transChannel
	 *            要设置的 transChannel
	 */
	public void setTransChannel(String transChannel) {
		this.transChannel = transChannel == null ? null : transChannel.trim();
	}

	/**
	 * @return interBankFlag
	 */
	public String getInterBankFlag() {
		return interBankFlag;
	}

	/**
	 * @param interBankFlag
	 *            要设置的 interBankFlag
	 */
	public void setInterBankFlag(String interBankFlag) {
		this.interBankFlag = interBankFlag == null ? null : interBankFlag.trim();
	}

	/**
	 * @return transTeller
	 */
	public String getTransTeller() {
		return transTeller;
	}

	/**
	 * @param transTeller
	 *            要设置的 transTeller
	 */
	public void setTransTeller(String transTeller) {
		this.transTeller = transTeller == null ? null : transTeller.trim();
	}

	/**
	 * @return bankAcct
	 */
	public String getBankAcct() {
		return bankAcct;
	}

	/**
	 * @param bankAcct
	 *            要设置的 bankAcct
	 */
	public void setBankAcct(String bankAcct) {
		this.bankAcct = bankAcct == null ? null : bankAcct.trim();
	}

	/**
	 * @return financeAcctNo
	 */
	public String getFinanceAcctNo() {
		return financeAcctNo;
	}

	/**
	 * @param financeAcctNo
	 *            要设置的 financeAcctNo
	 */
	public void setFinanceAcctNo(String financeAcctNo) {
		this.financeAcctNo = financeAcctNo == null ? null : financeAcctNo.trim();
	}

	/**
	 * @return transName
	 */
	public String getTransName() {
		return transName;
	}

	/**
	 * @param transName
	 *            要设置的 transName
	 */
	public void setTransName(String transName) {
		this.transName = transName == null ? null : transName.trim();
	}

	/**
	 * @return financeBussinesssType
	 */
	public String getFinanceBussinesssType() {
		return financeBussinesssType;
	}

	/**
	 * @param financeBussinesssType
	 *            要设置的 financeBussinesssType
	 */
	public void setFinanceBussinesssType(String financeBussinesssType) {
		this.financeBussinesssType = financeBussinesssType == null ? null : financeBussinesssType.trim();
	}

	/**
	 * @return transStatus
	 */
	public String getTransStatus() {
		return transStatus;
	}

	/**
	 * @param transStatus
	 *            要设置的 transStatus
	 */
	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus == null ? null : transStatus.trim();
	}

	/**
	 * @return srcProdCode
	 */
	public String getSrcProdCode() {
		return srcProdCode;
	}

	/**
	 * @param srcProdCode
	 *            要设置的 srcProdCode
	 */
	public void setSrcProdCode(String srcProdCode) {
		this.srcProdCode = srcProdCode == null ? null : srcProdCode.trim();
	}

	/**
	 * @return prodName
	 */
	public String getProdName() {
		return prodName;
	}

	/**
	 * @param prodName
	 *            要设置的 prodName
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName == null ? null : prodName.trim();
	}

	/**
	 * @return prodCcy
	 */
	public String getProdCcy() {
		return prodCcy;
	}

	/**
	 * @param prodCcy
	 *            要设置的 prodCcy
	 */
	public void setProdCcy(String prodCcy) {
		this.prodCcy = prodCcy == null ? null : prodCcy.trim();
	}

	/**
	 * @return transShare
	 */
	public String getTransShare() {
		return transShare;
	}

	/**
	 * @param transShare
	 *            要设置的 transShare
	 */
	public void setTransShare(String transShare) {
		this.transShare = transShare == null ? null : transShare.trim();
	}

	/**
	 * @return confirmDate
	 */
	public Date getConfirmDate() {
		return confirmDate;
	}

	/**
	 * @param confirmDate
	 *            要设置的 confirmDate
	 */
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	/**
	 * @return confirmAmt
	 */
	public String getConfirmAmt() {
		return confirmAmt;
	}

	/**
	 * @param confirmAmt
	 *            要设置的 confirmAmt
	 */
	public void setConfirmAmt(String confirmAmt) {
		this.confirmAmt = confirmAmt == null ? null : confirmAmt.trim();
	}

	/**
	 * @return confirmShare
	 */
	public String getConfirmShare() {
		return confirmShare;
	}

	/**
	 * @param confirmShare
	 *            要设置的 confirmShare
	 */
	public void setConfirmShare(String confirmShare) {
		this.confirmShare = confirmShare == null ? null : confirmShare.trim();
	}

	/**
	 * @return feeAmt
	 */
	public String getFeeAmt() {
		return feeAmt;
	}

	/**
	 * @param feeAmt
	 *            要设置的 feeAmt
	 */
	public void setFeeAmt(String feeAmt) {
		this.feeAmt = feeAmt == null ? null : feeAmt.trim();
	}

	/**
	 * @return dataStatus
	 */
	public String getDataStatus() {
		return dataStatus;
	}

	/**
	 * @param dataStatus
	 *            要设置的 dataStatus
	 */
	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus == null ? null : dataStatus.trim();
	}

	/**
	 * @return businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType
	 *            要设置的 businessType
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType == null ? null : businessType.trim();
	}

	/**
	 * @return qdProdClass
	 */
	public String getQdProdClass() {
		return qdProdClass;
	}

	/**
	 * @param qdProdClass
	 *            要设置的 qdProdClass
	 */
	public void setQdProdClass(String qdProdClass) {
		this.qdProdClass = qdProdClass == null ? null : qdProdClass.trim();
	}

	/**
	 * @return feeType
	 */
	public String getFeeType() {
		return feeType;
	}

	/**
	 * @param feeType
	 *            要设置的 feeType
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType == null ? null : feeType.trim();
	}

	/**
	 * @return feeCcy
	 */
	public String getFeeCcy() {
		return feeCcy;
	}

	/**
	 * @param feeCcy
	 *            要设置的 feeCcy
	 */
	public void setFeeCcy(String feeCcy) {
		this.feeCcy = feeCcy == null ? null : feeCcy.trim();
	}

	/**
	 * @return opponentOrg
	 */
	public String getOpponentOrg() {
		return opponentOrg;
	}

	/**
	 * @param opponentOrg
	 *            要设置的 opponentOrg
	 */
	public void setOpponentOrg(String opponentOrg) {
		this.opponentOrg = opponentOrg == null ? null : opponentOrg.trim();
	}

	/**
	 * @return opponentFinaceAcct
	 */
	public String getOpponentFinaceAcct() {
		return opponentFinaceAcct;
	}

	/**
	 * @param opponentFinaceAcct
	 *            要设置的 opponentFinaceAcct
	 */
	public void setOpponentFinaceAcct(String opponentFinaceAcct) {
		this.opponentFinaceAcct = opponentFinaceAcct == null ? null : opponentFinaceAcct.trim();
	}

	/**
	 * @return bounsType
	 */
	public String getBounsType() {
		return bounsType;
	}

	/**
	 * @param bounsType
	 *            要设置的 bounsType
	 */
	public void setBounsType(String bounsType) {
		this.bounsType = bounsType == null ? null : bounsType.trim();
	}

	/**
	 * @return bonusRate
	 */
	public String getBonusRate() {
		return bonusRate;
	}

	/**
	 * @param bonusRate
	 *            要设置的 bonusRate
	 */
	public void setBonusRate(String bonusRate) {
		this.bonusRate = bonusRate == null ? null : bonusRate.trim();
	}

	/**
	 * @return taConfirmSerialNo
	 */
	public String getTaConfirmSerialNo() {
		return taConfirmSerialNo;
	}

	/**
	 * @param taConfirmSerialNo
	 *            要设置的 taConfirmSerialNo
	 */
	public void setTaConfirmSerialNo(String taConfirmSerialNo) {
		this.taConfirmSerialNo = taConfirmSerialNo == null ? null : taConfirmSerialNo.trim();
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
		AcrmFfaTranDetail other = (AcrmFfaTranDetail) that;
		return (this.getTransAmt() == null ? other.getTransAmt() == null
				: this.getTransAmt().equals(other.getTransAmt()))
				&& (this.getTransCcy() == null ? other.getTransCcy() == null
						: this.getTransCcy().equals(other.getTransCcy()))
				&& (this.getTransChannel() == null ? other.getTransChannel() == null
						: this.getTransChannel().equals(other.getTransChannel()))
				&& (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
				&& (this.getTransOrg() == null ? other.getTransOrg() == null
						: this.getTransOrg().equals(other.getTransOrg()))
				&& (this.getTransSerialNo() == null ? other.getTransSerialNo() == null
						: this.getTransSerialNo().equals(other.getTransSerialNo()))
				&& (this.getTransTeller() == null ? other.getTransTeller() == null
						: this.getTransTeller().equals(other.getTransTeller()))
				&& (this.getTransAmt() == null ? other.getTransAmt() == null
						: this.getTransAmt().equals(other.getTransAmt()))
				&& (this.getInterBankFlag() == null ? other.getInterBankFlag() == null
						: this.getInterBankFlag().equals(other.getInterBankFlag()))
				&& (this.getTransName() == null ? other.getTransName() == null
						: this.getTransName().equals(other.getTransName()))
				&& (this.getFinanceBussinesssType() == null ? other.getFinanceBussinesssType() == null
						: this.getFinanceBussinesssType().equals(other.getFinanceBussinesssType()))
				&& (this.getTransStatus() == null ? other.getTransStatus() == null
						: this.getTransStatus().equals(other.getTransStatus()))
				&& (this.getSrcProdCode() == null ? other.getSrcProdCode() == null
						: this.getSrcProdCode().equals(other.getSrcProdCode()))
				&& (this.getProdName() == null ? other.getProdName() == null
						: this.getProdName().equals(other.getProdName()))
				&& (this.getProdCcy() == null ? other.getProdCcy() == null
						: this.getProdCcy().equals(other.getProdCcy()))
				&& (this.getTransShare() == null ? other.getTransShare() == null
						: this.getTransShare().equals(other.getTransShare()))
				&& (this.getConfirmAmt() == null ? other.getConfirmAmt() == null
						: this.getConfirmAmt().equals(other.getConfirmAmt()))
				&& (this.getConfirmShare() == null ? other.getConfirmShare() == null
						: this.getConfirmShare().equals(other.getConfirmShare()))
				&& (this.getFeeAmt() == null ? other.getFeeAmt() == null : this.getFeeAmt().equals(other.getFeeAmt()))
				&& (this.getDataStatus() == null ? other.getDataStatus() == null
						: this.getDataStatus().equals(other.getDataStatus()))
				&& (this.getBusinessType() == null ? other.getBusinessType() == null
						: this.getBusinessType().equals(other.getBusinessType()))
				&& (this.getQdProdClass() == null ? other.getQdProdClass() == null
						: this.getQdProdClass().equals(other.getQdProdClass()))
				&& (this.getFeeType() == null ? other.getFeeType() == null
						: this.getFeeType().equals(other.getFeeType()))
				&& (this.getFeeCcy() == null ? other.getFeeCcy() == null : this.getFeeCcy().equals(other.getFeeCcy()))
				&& (this.getOpponentFinaceAcct() == null ? other.getOpponentFinaceAcct() == null
						: this.getOpponentFinaceAcct().equals(other.getOpponentFinaceAcct()))
				&& (this.getOpponentOrg() == null ? other.getOpponentOrg() == null
						: this.getOpponentOrg().equals(other.getOpponentOrg()))
				&& (this.getBonusRate() == null ? other.getBonusRate() == null
						: this.getBonusRate().equals(other.getBonusRate()))
				&& (this.getBankAcct() == null ? other.getBankAcct() == null
						: this.getBankAcct().equals(other.getBankAcct()))
				&& (this.getBounsType() == null ? other.getBounsType() == null
						: this.getBounsType().equals(other.getBounsType()))
				&& (this.getFinanceAcctNo() == null ? other.getFinanceAcctNo() == null
						: this.getFinanceAcctNo().equals(other.getFinanceAcctNo()))
				&& (this.getTaConfirmSerialNo() == null ? other.getTaConfirmSerialNo() == null
						: this.getTaConfirmSerialNo().equals(other.getTaConfirmSerialNo()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getInterBankFlag() == null) ? 0 : getInterBankFlag().hashCode());
		result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
		result = prime * result + ((getTransAmt() == null) ? 0 : getTransAmt().hashCode());
		result = prime * result + ((getTransCcy() == null) ? 0 : getTransCcy().hashCode());
		result = prime * result + ((getTransChannel() == null) ? 0 : getTransChannel().hashCode());
		result = prime * result + ((getTransOrg() == null) ? 0 : getTransOrg().hashCode());
		result = prime * result + ((getTransSerialNo() == null) ? 0 : getTransSerialNo().hashCode());
		result = prime * result + ((getTransTeller() == null) ? 0 : getTransTeller().hashCode());
		result = prime * result + ((getTransName() == null) ? 0 : getTransName().hashCode());
		result = prime * result + ((getBankAcct() == null) ? 0 : getBankAcct().hashCode());
		result = prime * result + ((getFinanceAcctNo() == null) ? 0 : getFinanceAcctNo().hashCode());
		result = prime * result + ((getFinanceBussinesssType() == null) ? 0 : getFinanceBussinesssType().hashCode());
		result = prime * result + ((getTransStatus() == null) ? 0 : getTransStatus().hashCode());
		result = prime * result + ((getSrcProdCode() == null) ? 0 : getSrcProdCode().hashCode());
		result = prime * result + ((getProdCcy() == null) ? 0 : getProdCcy().hashCode());
		result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
		result = prime * result + ((getTransShare() == null) ? 0 : getTransShare().hashCode());
		result = prime * result + ((getConfirmAmt() == null) ? 0 : getConfirmAmt().hashCode());
		result = prime * result + ((getConfirmShare() == null) ? 0 : getConfirmShare().hashCode());
		result = prime * result + ((getFeeAmt() == null) ? 0 : getFeeAmt().hashCode());
		result = prime * result + ((getDataStatus() == null) ? 0 : getDataStatus().hashCode());
		result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
		result = prime * result + ((getQdProdClass() == null) ? 0 : getQdProdClass().hashCode());
		result = prime * result + ((getFeeType() == null) ? 0 : getFeeType().hashCode());
		result = prime * result + ((getFeeCcy() == null) ? 0 : getFeeCcy().hashCode());
		result = prime * result + ((getOpponentFinaceAcct() == null) ? 0 : getOpponentFinaceAcct().hashCode());
		result = prime * result + ((getOpponentOrg() == null) ? 0 : getOpponentOrg().hashCode());
		result = prime * result + ((getBonusRate() == null) ? 0 : getBonusRate().hashCode());
		result = prime * result + ((getBounsType() == null) ? 0 : getBounsType().hashCode());
		result = prime * result + ((getTaConfirmSerialNo() == null) ? 0 : getTaConfirmSerialNo().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", interBankFlag=").append(interBankFlag);
		sb.append(", custNo=").append(custNo);
		sb.append(", transAmt=").append(transAmt);
		sb.append(", transCcy=").append(transCcy);
		sb.append(", transChannel=").append(transChannel);
		sb.append(", transOrg=").append(transOrg);
		sb.append(", transSerialNo=").append(transSerialNo);
		sb.append(", transTeller=").append(transTeller);
		sb.append(", transName=").append(transName);
		sb.append(", financeBussinesssType=").append(financeBussinesssType);
		sb.append(", bankAcct=").append(bankAcct);
		sb.append(", financeAcctNo=").append(financeAcctNo);
		sb.append(", transStatus=").append(transStatus);
		sb.append(", srcProdCode=").append(srcProdCode);
		sb.append(", prodName=").append(prodName);
		sb.append(", prodCcy=").append(prodCcy);
		sb.append(", transShare=").append(transShare);
		sb.append(", confirmAmt=").append(confirmAmt);
		sb.append(", confirmShare=").append(confirmShare);
		sb.append(", feeAmt=").append(feeAmt);
		sb.append(", dataStatus=").append(dataStatus);
		sb.append(", businessType=").append(businessType);
		sb.append(", qdProdClass=").append(qdProdClass);
		sb.append(", feeType=").append(feeType);
		sb.append(", feeCcy=").append(feeCcy);
		sb.append(", opponentFinaceAcct=").append(opponentFinaceAcct);
		sb.append(", opponentOrg=").append(opponentOrg);
		sb.append(", bonusRate=").append(bonusRate);
		sb.append(", bounsType=").append(bounsType);
		sb.append(", taConfirmSerialNo=").append(taConfirmSerialNo);
		sb.append("]");
		return sb.toString();
	}
}