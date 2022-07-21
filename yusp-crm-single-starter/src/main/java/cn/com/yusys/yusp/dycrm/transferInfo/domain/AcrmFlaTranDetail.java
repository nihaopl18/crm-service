package cn.com.yusys.yusp.dycrm.transferInfo.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACRM_F_LA_TRAN_DETAIL")
public class AcrmFlaTranDetail extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 50)
	private String dataDate;

	/** 流水号 **/
	@Column(name = "TRANS_SERIAL_NO", unique = false, nullable = true, length = 50)
	private String transSerialNo;

	/** ECIF客户号 **/
	@Column(name = "ECIF_CUST_NO", unique = false, nullable = true, length = 50)
	private String ecifCustNo;

	/** 源系统客户号 **/
	@Column(name = "SRC_CUST_NO", unique = false, nullable = true, length = 50)
	private String srcCustNo;

	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 50)
	private String custType;

	/** 合同号 **/
	@Column(name = "CONTRACT_NO", unique = false, nullable = true, length = 50)
	private String contractNo;

	/** 借据号 **/
	@Column(name = "LOAN_BILL_NO", unique = false, nullable = true, length = 50)
	private String loanBillNo;

	/** 贷款产品类别代码 **/
	@Column(name = "PROD_CODE", unique = false, nullable = true, length = 50)
	private String prodCode;

	/** 产品代码 **/
	@Column(name = "SRC_PROD_CODE", unique = false, nullable = true, length = 50)
	private String srcProdCode;

	/** 业务币种 **/
	@Column(name = "BUSINESS_CCY", unique = false, nullable = true, length = 50)
	private String businessCcy;

	/** 放款金额（原币） **/
	@Column(name = "LOAN_AMT", unique = false, nullable = true, length = 50)
	private String loanAmt;

	/** 发放日期 **/
	@Column(name = "PUBLISH_DATE", unique = false, nullable = true, length = 50)
	private Date publishDate;

	/** 本金到期日期 **/
	@Column(name = "PRINCIPAL_EXPIRY_DATE", unique = false, nullable = true, length = 50)
	private Date principalExpiryDate;

	/** 利息到期日期 **/
	@Column(name = "INT_EXPIRY_DATE", unique = false, nullable = true, length = 50)
	private Date intExpiryDate;

	/** 入账机构 **/
	@Column(name = "ENTRY_ORG", unique = false, nullable = true, length = 50)
	private String entryOrg;

	/** 跨行标志 **/
	@Column(name = "INTER_BANK_FLAG", unique = false, nullable = true, length = 50)
	private String interBankFlag;

	/** 经办机构 **/
	@Column(name = "DEAL_ORG", unique = false, nullable = true, length = 50)
	private String dealOrg;

	/** 经办人 **/
	@Column(name = "DEAL_USER", unique = false, nullable = true, length = 50)
	private String dealUser;

	/** 经办日期 **/
	@Column(name = "DEAL_DATE", unique = false, nullable = true, length = 50)
	private Date dealDate;

	/** 登记机构 **/
	@Column(name = "REGISTER_ORG", unique = false, nullable = true, length = 50)
	private String registerOrg;

	/** 登记人 **/
	@Column(name = "REGISTRANT", unique = false, nullable = true, length = 50)
	private String registrant;

	/** 放款账户开户行 **/
	@Column(name = "LOAN_ACCT_OPEN_ORG", unique = false, nullable = true, length = 50)
	private String loanAcctOpenOrg;

	/** 放款账户/卡号 **/
	@Column(name = "LOAN_ACCT", unique = false, nullable = true, length = 50)
	private String loanAcct;

	/** 支付系统 **/
	@Column(name = "PAY_SYSTEM", unique = false, nullable = true, length = 50)
	private String paySystem;

	/** 在线划款标识 **/
	@Column(name = "ONLINE_TRANSFER_FLAG", unique = false, nullable = true, length = 50)
	private String onlineTransferFlag;

	/** 收款人地址 **/
	@Column(name = "PAYEE_ADDR", unique = false, nullable = true, length = 50)
	private String payeeAddr;

	/** 收款方账户开户行 **/
	@Column(name = "PAYEE_ACCT_OPEN_ORG", unique = false, nullable = true, length = 50)
	private String payeeAcctOpenOrg;

	/** 收款方账户币种 **/
	@Column(name = "PAYEE_ACCT_CCY", unique = false, nullable = true, length = 50)
	private String payeeAcctCcy;

	/** 收款方账户号 **/
	@Column(name = "PAYEE_ACCT_NO", unique = false, nullable = true, length = 50)
	private String payeeAcctNo;

	/** 收款方账户标识 **/
	@Column(name = "PAYEE_ACCT_FLAG", unique = false, nullable = true, length = 50)
	private String payeeAcctFlag;

	/** 还款账户开户行 **/
	@Column(name = "REPAY_ACCT_OPEN_ORG", unique = false, nullable = true, length = 50)
	private String repayAcctOpenOrg;

	/** 还款账户号 **/
	@Column(name = "REPAY_ACCT", unique = false, nullable = true, length = 50)
	private String repayAcct;

	/** 源系统代码 **/
	@Column(name = "SRC_SYSTEM_NO", unique = false, nullable = true, length = 50)
	private String srcSystemNo;

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}

	public String getEcifCustNo() {
		return ecifCustNo;
	}

	public void setEcifCustNo(String ecifCustNo) {
		this.ecifCustNo = ecifCustNo == null ? null : ecifCustNo.trim();
	}

	public String getSrcCustNo() {
		return srcCustNo;
	}

	public void setSrcCustNo(String srcCustNo) {
		this.srcCustNo = srcCustNo == null ? null : srcCustNo.trim();
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo == null ? null : contractNo.trim();
	}

	public String getLoanBillNo() {
		return loanBillNo;
	}

	public void setLoanBillNo(String loanBillNo) {
		this.loanBillNo = loanBillNo == null ? null : loanBillNo.trim();
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode == null ? null : prodCode.trim();
	}

	public String getBusinessCcy() {
		return businessCcy;
	}

	public void setBusinessCcy(String businessCcy) {
		this.businessCcy = businessCcy == null ? null : businessCcy.trim();
	}

	public String getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(String loanAmt) {
		this.loanAmt = loanAmt == null ? null : loanAmt.trim();
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getPrincipalExpiryDate() {
		return principalExpiryDate;
	}

	public void setPrincipalExpiryDate(Date principalExpiryDate) {
		this.principalExpiryDate = principalExpiryDate;
	}

	public Date getIntExpiryDate() {
		return intExpiryDate;
	}

	public void setIntExpiryDate(Date intExpiryDate) {
		this.intExpiryDate = intExpiryDate;
	}

	public String getEntryOrg() {
		return entryOrg;
	}

	public void setEntryOrg(String entryOrg) {
		this.entryOrg = entryOrg == null ? null : entryOrg.trim();
	}

	public String getDealOrg() {
		return dealOrg;
	}

	public void setDealOrg(String dealOrg) {
		this.dealOrg = dealOrg == null ? null : dealOrg.trim();
	}

	public String getDealUser() {
		return dealUser;
	}

	public void setDealUser(String dealUser) {
		this.dealUser = dealUser == null ? null : dealUser.trim();
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	public String getRegisterOrg() {
		return registerOrg;
	}

	public void setRegisterOrg(String registerOrg) {
		this.registerOrg = registerOrg == null ? null : registerOrg.trim();
	}

	public String getRegistrant() {
		return registrant;
	}

	public void setRegistrant(String registrant) {
		this.registrant = registrant == null ? null : registrant.trim();
	}

	public String getLoanAcctOpenOrg() {
		return loanAcctOpenOrg;
	}

	public void setLoanAcctOpenOrg(String loanAcctOpenOrg) {
		this.loanAcctOpenOrg = loanAcctOpenOrg == null ? null : loanAcctOpenOrg.trim();
	}

	public String getLoanAcct() {
		return loanAcct;
	}

	public void setLoanAcct(String loanAcct) {
		this.loanAcct = loanAcct == null ? null : loanAcct.trim();
	}

	public String getPaySystem() {
		return paySystem;
	}

	public void setPaySystem(String paySystem) {
		this.paySystem = paySystem == null ? null : paySystem.trim();
	}

	public String getOnlineTransferFlag() {
		return onlineTransferFlag;
	}

	public void setOnlineTransferFlag(String onlineTransferFlag) {
		this.onlineTransferFlag = onlineTransferFlag == null ? null : onlineTransferFlag.trim();
	}

	public String getPayeeAddr() {
		return payeeAddr;
	}

	public void setPayeeAddr(String payeeAddr) {
		this.payeeAddr = payeeAddr == null ? null : payeeAddr.trim();
	}

	public String getPayeeAcctOpenOrg() {
		return payeeAcctOpenOrg;
	}

	public void setPayeeAcctOpenOrg(String payeeAcctOpenOrg) {
		this.payeeAcctOpenOrg = payeeAcctOpenOrg == null ? null : payeeAcctOpenOrg.trim();
	}

	public String getPayeeAcctCcy() {
		return payeeAcctCcy;
	}

	public void setPayeeAcctCcy(String payeeAcctCcy) {
		this.payeeAcctCcy = payeeAcctCcy == null ? null : payeeAcctCcy.trim();
	}

	public String getPayeeAcctNo() {
		return payeeAcctNo;
	}

	public void setPayeeAcctNo(String payeeAcctNo) {
		this.payeeAcctNo = payeeAcctNo == null ? null : payeeAcctNo.trim();
	}

	public String getPayeeAcctFlag() {
		return payeeAcctFlag;
	}

	public void setPayeeAcctFlag(String payeeAcctFlag) {
		this.payeeAcctFlag = payeeAcctFlag == null ? null : payeeAcctFlag.trim();
	}

	public String getRepayAcctOpenOrg() {
		return repayAcctOpenOrg;
	}

	public void setRepayAcctOpenOrg(String repayAcctOpenOrg) {
		this.repayAcctOpenOrg = repayAcctOpenOrg == null ? null : repayAcctOpenOrg.trim();
	}

	public String getRepayAcct() {
		return repayAcct;
	}

	public void setRepayAcct(String repayAcct) {
		this.repayAcct = repayAcct == null ? null : repayAcct.trim();
	}

	public String getSrcSystemNo() {
		return srcSystemNo;
	}

	public void setSrcSystemNo(String srcSystemNo) {
		this.srcSystemNo = srcSystemNo == null ? null : srcSystemNo.trim();
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
		AcrmFlaTranDetail other = (AcrmFlaTranDetail) that;
		return ((this.getTransSerialNo() == null ? other.getTransSerialNo() == null
				: this.getTransSerialNo().equals(other.getTransSerialNo()))
				&& (this.getInterBankFlag() == null ? other.getInterBankFlag() == null
						: this.getInterBankFlag().equals(other.getInterBankFlag()))
				&& (this.getSrcProdCode() == null ? other.getSrcProdCode() == null
						: this.getSrcProdCode().equals(other.getSrcProdCode()))
				&& (this.getBusinessCcy() == null ? other.getBusinessCcy() == null
						: this.getBusinessCcy().equals(other.getBusinessCcy()))
				&& (this.getContractNo() == null ? other.getContractNo() == null
						: this.getContractNo().equals(other.getContractNo()))
				&& (this.getCustType() == null ? other.getCustType() == null
						: this.getCustType().equals(other.getCustType()))
				&& (this.getDataDate() == null ? other.getDataDate() == null
						: this.getDataDate().equals(other.getDataDate()))
				&& (this.getDealOrg() == null ? other.getDealOrg() == null
						: this.getDealOrg().equals(other.getDealOrg()))
				&& (this.getDealUser() == null ? other.getDealUser() == null
						: this.getDealUser().equals(other.getDealUser()))
				&& (this.getEcifCustNo() == null ? other.getEcifCustNo() == null
						: this.getEcifCustNo().equals(other.getEcifCustNo()))
				&& (this.getEntryOrg() == null ? other.getEntryOrg() == null
						: this.getEntryOrg().equals(other.getEntryOrg()))
				&& (this.getLoanAcct() == null ? other.getLoanAcct() == null
						: this.getLoanAcct().equals(other.getLoanAcct()))
				&& (this.getLoanAcctOpenOrg() == null ? other.getLoanAcctOpenOrg() == null
						: this.getLoanAcctOpenOrg().equals(other.getLoanAcctOpenOrg()))
				&& (this.getLoanAmt() == null ? other.getLoanAmt() == null
						: this.getLoanAmt().equals(other.getLoanAmt()))
				&& (this.getLoanBillNo() == null ? other.getLoanBillNo() == null
						: this.getLoanBillNo().equals(other.getLoanBillNo()))
				&& (this.getOnlineTransferFlag() == null ? other.getOnlineTransferFlag() == null
						: this.getOnlineTransferFlag().equals(other.getOnlineTransferFlag()))
				&& (this.getPayeeAcctCcy() == null ? other.getPayeeAcctCcy() == null
						: this.getPayeeAcctCcy().equals(other.getPayeeAcctCcy()))
				&& (this.getPayeeAcctFlag() == null ? other.getPayeeAcctFlag() == null
						: this.getPayeeAcctFlag().equals(other.getPayeeAcctFlag()))
				&& (this.getPayeeAcctNo() == null ? other.getPayeeAcctNo() == null
						: this.getPayeeAcctNo().equals(other.getPayeeAcctNo()))
				&& (this.getPayeeAcctOpenOrg() == null ? other.getPayeeAcctOpenOrg() == null
						: this.getPayeeAcctOpenOrg().equals(other.getPayeeAcctOpenOrg()))
				&& (this.getPayeeAddr() == null ? other.getPayeeAddr() == null
						: this.getPayeeAddr().equals(other.getPayeeAddr()))
				&& (this.getPaySystem() == null ? other.getPaySystem() == null
						: this.getPaySystem().equals(other.getPaySystem()))
				&& (this.getProdCode() == null ? other.getProdCode() == null
						: this.getProdCode().equals(other.getProdCode())));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getInterBankFlag() == null) ? 0 : getInterBankFlag().hashCode());
		result = prime * result + ((getTransSerialNo() == null) ? 0 : getTransSerialNo().hashCode());
		result = prime * result + ((getSrcProdCode() == null) ? 0 : getSrcProdCode().hashCode());

		result = prime * result + ((getBusinessCcy() == null) ? 0 : getBusinessCcy().hashCode());
		result = prime * result + ((getContractNo() == null) ? 0 : getContractNo().hashCode());
		result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
		result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
		result = prime * result + ((getDealOrg() == null) ? 0 : getDealOrg().hashCode());
		result = prime * result + ((getDealUser() == null) ? 0 : getDealUser().hashCode());
		result = prime * result + ((getEcifCustNo() == null) ? 0 : getEcifCustNo().hashCode());
		result = prime * result + ((getEntryOrg() == null) ? 0 : getEntryOrg().hashCode());
		result = prime * result + ((getLoanAcct() == null) ? 0 : getLoanAcct().hashCode());
		result = prime * result + ((getLoanAcctOpenOrg() == null) ? 0 : getLoanAcctOpenOrg().hashCode());
		result = prime * result + ((getLoanAmt() == null) ? 0 : getLoanAmt().hashCode());
		result = prime * result + ((getLoanBillNo() == null) ? 0 : getLoanBillNo().hashCode());
		result = prime * result + ((getOnlineTransferFlag() == null) ? 0 : getOnlineTransferFlag().hashCode());
		result = prime * result + ((getPayeeAcctCcy() == null) ? 0 : getPayeeAcctCcy().hashCode());
		result = prime * result + ((getPayeeAcctFlag() == null) ? 0 : getPayeeAcctFlag().hashCode());
		result = prime * result + ((getPayeeAcctNo() == null) ? 0 : getPayeeAcctNo().hashCode());
		result = prime * result + ((getPayeeAcctOpenOrg() == null) ? 0 : getPayeeAcctOpenOrg().hashCode());
		result = prime * result + ((getPayeeAddr() == null) ? 0 : getPayeeAddr().hashCode());
		result = prime * result + ((getPaySystem() == null) ? 0 : getPaySystem().hashCode());
		result = prime * result + ((getProdCode() == null) ? 0 : getProdCode().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", interBankFlag=").append(interBankFlag);
		sb.append(", transSerialNo=").append(transSerialNo);
		
		sb.append(", businessCcy=").append(businessCcy);
		sb.append(", contractNo=").append(contractNo);
		sb.append(", custType=").append(custType);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", dealOrg=").append(dealOrg);
		sb.append(", dealUser=").append(dealUser);
		sb.append(", ecifCustNo=").append(ecifCustNo);
		sb.append(", entryOrg=").append(entryOrg);
		sb.append(", loanAcct=").append(loanAcct);
		sb.append(", loanAcctOpenOrg=").append(loanAcctOpenOrg);
		sb.append(", loanAmt=").append(loanAmt);
		sb.append(", loanBillNo=").append(loanBillNo);
		sb.append(", onlineTransferFlag=").append(onlineTransferFlag);
		sb.append(", payeeAcctCcy=").append(payeeAcctCcy);
		sb.append(", payeeAcctFlag=").append(payeeAcctFlag);
		sb.append(", payeeAcctNo=").append(payeeAcctNo);
		sb.append(", payeeAcctOpenOrg=").append(payeeAcctOpenOrg);
		sb.append(", payeeAddr=").append(payeeAddr);
		sb.append(", paySystem=").append(paySystem);
		sb.append(", prodCode=").append(prodCode);
		sb.append(", srcProdCode=").append(srcProdCode);
		sb.append("]");
		return sb.toString();
	}
}