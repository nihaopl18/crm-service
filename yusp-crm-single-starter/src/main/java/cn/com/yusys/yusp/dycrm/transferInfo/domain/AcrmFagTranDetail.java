package cn.com.yusys.yusp.dycrm.transferInfo.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACRM_F_AG_TRAN_DETAIL")
public class AcrmFagTranDetail extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 代理主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;

	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 50)
	private String dataDate;

	/** 数据创建时间 **/
	@Column(name = "INSERT_TIMESTAMP", unique = false, nullable = true, length = 7)
	private Date insertTimestamp;

	/** 数据创建人 **/
	@Column(name = "INSERT_BY", unique = false, nullable = true, length = 50)
	private String insertBy;

	/** 数据更新时间 **/
	@Column(name = "UPDATED_TIMESTAMP", unique = false, nullable = true, length = 7)
	private Date updatedTimestamp;

	/** 数据更新人 **/
	@Column(name = "UPDATED_BY", unique = false, nullable = true, length = 50)
	private String updatedBy;

	/** 来源系统代码 **/
	@Column(name = "SOURCE_SYSTEM_CODE", unique = false, nullable = true, length = 50)
	private String sourceSystemCode;

	/** 逻辑删除标记 **/
	@Column(name = "DELETE_FLAG", unique = false, nullable = true, length = 50)
	private String deleteFlag;

	/** 客户号 **/
	@Column(name = "CUST_NO", unique = false, nullable = true, length = 50)
	private String custNo;

	/** 主帐户 **/
	@Column(name = "MAIN_ACCT", unique = false, nullable = true, length = 50)
	private String mainAcct;

	/** 子账号 **/
	@Column(name = "SUB_ACCT_NO", unique = false, nullable = true, length = 50)
	private String subAcctNo;

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

	/** 交易分类 **/
	@Column(name = "TRANS_CLASS", unique = false, nullable = true, length = 50)
	private String transClass;

	/** 交易类型 **/
	@Column(name = "TRANS_TYPE", unique = false, nullable = true, length = 50)
	private String transType;

	/** 交易渠道 **/
	@Column(name = "TRANS_CHANNEL", unique = false, nullable = true, length = 50)
	private String transChannel;

	/** 借贷方向 **/
	@Column(name = "DEBIT_OR_CREDIT", unique = false, nullable = true, length = 50)
	private String debitOrCredit;

	/** 现金转账标识 **/
	@Column(name = "CASH_TRANSFER_FLAG", unique = false, nullable = true, length = 50)
	private String cashTransferFlag;

	/** 跨行标志 **/
	@Column(name = "INTER_BANK_FLAG", unique = false, nullable = true, length = 50)
	private String interBankFlag;

	/** 交易对手主账号 **/
	@Column(name = "OPPONENT_MAIN_ACCT_NO", unique = false, nullable = true, length = 50)
	private String opponentMainAcctNo;

	/** 交易对手子账号 **/
	@Column(name = "OPPONENT_SUB_ACCT_NO", unique = false, nullable = true, length = 50)
	private String opponentSubAcctNo;

	/** 交易柜员 **/
	@Column(name = "TRANS_TELLER", unique = false, nullable = true, length = 50)
	private String transTeller;

	/** 代办人姓名 **/
	@Column(name = "AGENT_NAME", unique = false, nullable = true, length = 50)
	private String agentName;

	/** 代办人证件类型 **/
	@Column(name = "AGENT_CERT_TYPE", unique = false, nullable = true, length = 50)
	private String agentCertType;

	/** 代办人证件号 **/
	@Column(name = "AGENT_CERT_NO", unique = false, nullable = true, length = 50)
	private String agentCertNo;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**
	 * @return dataDate
	 */
	public String getDataDate() {
		return dataDate;
	}

	/**
	 * @param dataDate
	 *            要设置的 dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}

	/**
	 * @return insertTimestamp
	 */
	public Date getInsertTimestamp() {
		return insertTimestamp;
	}

	/**
	 * @param insertTimestamp
	 *            要设置的 insertTimestamp
	 */
	public void setInsertTimestamp(Date insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}

	/**
	 * @return insertBy
	 */
	public String getInsertBy() {
		return insertBy;
	}

	/**
	 * @param insertBy
	 *            要设置的 insertBy
	 */
	public void setInsertBy(String insertBy) {
		this.insertBy = insertBy == null ? null : insertBy.trim();
	}

	/**
	 * @return updatedTimestamp
	 */
	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	/**
	 * @param updatedTimestamp
	 *            要设置的 updatedTimestamp
	 */
	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	/**
	 * @return updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            要设置的 updatedBy
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy == null ? null : updatedBy.trim();
	}

	/**
	 * @return sourceSystemCode
	 */
	public String getSourceSystemCode() {
		return sourceSystemCode;
	}

	/**
	 * @param sourceSystemCode
	 *            要设置的 sourceSystemCode
	 */
	public void setSourceSystemCode(String sourceSystemCode) {
		this.sourceSystemCode = sourceSystemCode == null ? null : sourceSystemCode.trim();
	}

	/**
	 * @return deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag
	 *            要设置的 deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
	}

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
	 * @return mainAcct
	 */
	public String getMainAcct() {
		return mainAcct;
	}

	/**
	 * @param mainAcct
	 *            要设置的 mainAcct
	 */
	public void setMainAcct(String mainAcct) {
		this.mainAcct = mainAcct == null ? null : mainAcct.trim();
	}

	/**
	 * @return subAcctNo
	 */
	public String getSubAcctNo() {
		return subAcctNo;
	}

	/**
	 * @param subAcctNo
	 *            要设置的 subAcctNo
	 */
	public void setSubAcctNo(String subAcctNo) {
		this.subAcctNo = subAcctNo == null ? null : subAcctNo.trim();
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
	 * @return transClass
	 */
	public String getTransClass() {
		return transClass;
	}

	/**
	 * @param transClass
	 *            要设置的 transClass
	 */
	public void setTransClass(String transClass) {
		this.transClass = transClass == null ? null : transClass.trim();
	}

	/**
	 * @return transType
	 */
	public String getTransType() {
		return transType;
	}

	/**
	 * @param transType
	 *            要设置的 transType
	 */
	public void setTransType(String transType) {
		this.transType = transType == null ? null : transType.trim();
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
	 * @return debitOrCredit
	 */
	public String getDebitOrCredit() {
		return debitOrCredit;
	}

	/**
	 * @param debitOrCredit
	 *            要设置的 debitOrCredit
	 */
	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit == null ? null : debitOrCredit.trim();
	}

	/**
	 * @return cashTransferFlag
	 */
	public String getCashTransferFlag() {
		return cashTransferFlag;
	}

	/**
	 * @param cashTransferFlag
	 *            要设置的 cashTransferFlag
	 */
	public void setCashTransferFlag(String cashTransferFlag) {
		this.cashTransferFlag = cashTransferFlag == null ? null : cashTransferFlag.trim();
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
	 * @return opponentMainAcctNo
	 */
	public String getOpponentMainAcctNo() {
		return opponentMainAcctNo;
	}

	/**
	 * @param opponentMainAcctNo
	 *            要设置的 opponentMainAcctNo
	 */
	public void setOpponentMainAcctNo(String opponentMainAcctNo) {
		this.opponentMainAcctNo = opponentMainAcctNo == null ? null : opponentMainAcctNo.trim();
	}

	/**
	 * @return opponentSubAcctNo
	 */
	public String getOpponentSubAcctNo() {
		return opponentSubAcctNo;
	}

	/**
	 * @param opponentSubAcctNo
	 *            要设置的 opponentSubAcctNo
	 */
	public void setOpponentSubAcctNo(String opponentSubAcctNo) {
		this.opponentSubAcctNo = opponentSubAcctNo == null ? null : opponentSubAcctNo.trim();
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
	 * @return agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @param agentName
	 *            要设置的 agentName
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName == null ? null : agentName.trim();
	}

	/**
	 * @return agentCertType
	 */
	public String getAgentCertType() {
		return agentCertType;
	}

	/**
	 * @param agentCertType
	 *            要设置的 agentCertType
	 */
	public void setAgentCertType(String agentCertType) {
		this.agentCertType = agentCertType == null ? null : agentCertType.trim();
	}

	/**
	 * @return agentCertNo
	 */
	public String getAgentCertNo() {
		return agentCertNo;
	}

	/**
	 * @param agentCertNo
	 *            要设置的 agentCertNo
	 */
	public void setAgentCertNo(String agentCertNo) {
		this.agentCertNo = agentCertNo == null ? null : agentCertNo.trim();
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
		AcrmFagTranDetail other = (AcrmFagTranDetail) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getTransAmt() == null ? other.getTransAmt() == null
						: this.getTransAmt().equals(other.getTransAmt()))
				&& (this.getTransCcy() == null ? other.getTransCcy() == null
						: this.getTransCcy().equals(other.getTransCcy()))
				&& (this.getTransChannel() == null ? other.getTransChannel() == null
						: this.getTransChannel().equals(other.getTransChannel()))
				&& (this.getTransClass() == null ? other.getTransClass() == null
						: this.getTransClass().equals(other.getTransClass()))
				&& (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
				&& (this.getTransOrg() == null ? other.getTransOrg() == null
						: this.getTransOrg().equals(other.getTransOrg()))
				&& (this.getTransSerialNo() == null ? other.getTransSerialNo() == null
						: this.getTransSerialNo().equals(other.getTransSerialNo()))
				&& (this.getTransTeller() == null ? other.getTransTeller() == null
						: this.getTransTeller().equals(other.getTransTeller()))
				&& (this.getTransAmt() == null ? other.getTransAmt() == null
						: this.getTransAmt().equals(other.getTransAmt()))
				&& (this.getUpdatedBy() == null ? other.getUpdatedBy() == null
						: this.getUpdatedBy().equals(other.getUpdatedBy()))
				&& (this.getAgentCertNo() == null ? other.getAgentCertNo() == null
						: this.getAgentCertNo().equals(other.getAgentCertNo()))
				&& (this.getAgentCertType() == null ? other.getAgentCertType() == null
						: this.getAgentCertType().equals(other.getAgentCertType()))
				&& (this.getAgentName() == null ? other.getAgentName() == null
						: this.getAgentName().equals(other.getAgentName()))
				&& (this.getCashTransferFlag() == null ? other.getCashTransferFlag() == null
						: this.getCashTransferFlag().equals(other.getCashTransferFlag()))
				&& (this.getDataDate() == null ? other.getDataDate() == null
						: this.getDataDate().equals(other.getDataDate()))
				&& (this.getDebitOrCredit() == null ? other.getDebitOrCredit() == null
						: this.getDebitOrCredit().equals(other.getDebitOrCredit()))
				&& (this.getDeleteFlag() == null ? other.getDeleteFlag() == null
						: this.getDeleteFlag().equals(other.getDeleteFlag()))
				&& (this.getInsertBy() == null ? other.getInsertBy() == null
						: this.getInsertBy().equals(other.getInsertBy()))
				&& (this.getInterBankFlag() == null ? other.getInterBankFlag() == null
						: this.getInterBankFlag().equals(other.getInterBankFlag()))
				&& (this.getMainAcct() == null ? other.getMainAcct() == null
						: this.getMainAcct().equals(other.getMainAcct()))
				&& (this.getOpponentMainAcctNo() == null ? other.getOpponentMainAcctNo() == null
						: this.getOpponentMainAcctNo().equals(other.getOpponentMainAcctNo()))
				&& (this.getOpponentSubAcctNo() == null ? other.getOpponentSubAcctNo() == null
						: this.getOpponentSubAcctNo().equals(other.getOpponentSubAcctNo()))
				&& (this.getSourceSystemCode() == null ? other.getSourceSystemCode() == null
						: this.getSourceSystemCode().equals(other.getSourceSystemCode()))
				&& (this.getSubAcctNo() == null ? other.getSubAcctNo() == null
						: this.getSubAcctNo().equals(other.getSubAcctNo()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getInsertBy() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getInterBankFlag() == null) ? 0 : getInterBankFlag().hashCode());
		result = prime * result + ((getAgentCertNo() == null) ? 0 : getAgentCertNo().hashCode());
		result = prime * result + ((getAgentCertType() == null) ? 0 : getAgentCertType().hashCode());
		result = prime * result + ((getAgentName() == null) ? 0 : getAgentName().hashCode());
		result = prime * result + ((getCashTransferFlag() == null) ? 0 : getCashTransferFlag().hashCode());
		result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
		result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
		result = prime * result + ((getDebitOrCredit() == null) ? 0 : getDebitOrCredit().hashCode());
		result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
		result = prime * result + ((getMainAcct() == null) ? 0 : getMainAcct().hashCode());
		result = prime * result + ((getOpponentMainAcctNo() == null) ? 0 : getOpponentMainAcctNo().hashCode());
		result = prime * result + ((getOpponentSubAcctNo() == null) ? 0 : getOpponentSubAcctNo().hashCode());
		result = prime * result + ((getSourceSystemCode() == null) ? 0 : getSourceSystemCode().hashCode());
		result = prime * result + ((getSubAcctNo() == null) ? 0 : getSubAcctNo().hashCode());
		result = prime * result + ((getTransAmt() == null) ? 0 : getTransAmt().hashCode());
		result = prime * result + ((getTransCcy() == null) ? 0 : getTransCcy().hashCode());
		result = prime * result + ((getTransChannel() == null) ? 0 : getTransChannel().hashCode());
		result = prime * result + ((getTransClass() == null) ? 0 : getTransClass().hashCode());
		result = prime * result + ((getTransOrg() == null) ? 0 : getTransOrg().hashCode());
		result = prime * result + ((getTransSerialNo() == null) ? 0 : getTransSerialNo().hashCode());
		result = prime * result + ((getTransTeller() == null) ? 0 : getTransTeller().hashCode());
		result = prime * result + ((getTransType() == null) ? 0 : getTransType().hashCode());
		result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", insertBy=").append(insertBy);
		sb.append(", interBankFlag=").append(interBankFlag);
		sb.append(", agentCertNo=").append(agentCertNo);
		sb.append(", agentCertType=").append(agentCertType);
		sb.append(", agentName=").append(agentName);
		sb.append(", cashTransferFlag=").append(cashTransferFlag);
		sb.append(", custNo=").append(custNo);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", debitOrCredit=").append(debitOrCredit);
		sb.append(", deleteFlag=").append(deleteFlag);
		sb.append(", mainAcct=").append(mainAcct);
		sb.append(", opponentMainAcctNo=").append(opponentMainAcctNo);
		sb.append(", opponentSubAcctNo=").append(opponentSubAcctNo);
		sb.append(", sourceSystemCode=").append(sourceSystemCode);
		sb.append(", subAcctNo=").append(subAcctNo);
		sb.append(", transAmt=").append(transAmt);
		sb.append(", transCcy=").append(transCcy);
		sb.append(", transChannel=").append(transChannel);
		sb.append(", transClass=").append(transClass);
		sb.append(", transOrg=").append(transOrg);
		sb.append(", transSerialNo=").append(transSerialNo);
		sb.append(", transTeller=").append(transTeller);
		sb.append(", transType=").append(transType);
		sb.append(", updatedBy=").append(updatedBy);
		sb.append("]");
		return sb.toString();
	}
}