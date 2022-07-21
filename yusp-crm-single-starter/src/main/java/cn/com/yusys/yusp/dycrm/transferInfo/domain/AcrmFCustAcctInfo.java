package cn.com.yusys.yusp.dycrm.transferInfo.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACRM_F_CUST_ACCT_INFO")
public class AcrmFCustAcctInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 代理主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;

	/** 客户号 **/
	@Column(name = "CUST_NO", unique = false, nullable = true, length = 50)
	private String custNo;

	/** 主帐户 **/
	@Column(name = "MAIN_ACCT", unique = false, nullable = true, length = 50)
	private String mainAcct;

	/** 子账号 **/
	@Column(name = "SUB_ACCT_NO", unique = false, nullable = true, length = 50)
	private String subAcctNo;

	/** 账号类型 **/
	@Column(name = "ACCT_TYPE", unique = false, nullable = true, length = 50)
	private String acctType;

	/**
	 * @return acctType
	 */
	public String getAcctType() {
		return acctType;
	}

	/**
	 * @param acctType
	 *            要设置的 acctType
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

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
		AcrmFCustAcctInfo other = (AcrmFCustAcctInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
				&& (this.getMainAcct() == null ? other.getMainAcct() == null
						: this.getMainAcct().equals(other.getMainAcct()))
				&& (this.getAcctType() == null ? other.getAcctType() == null
				: this.getAcctType().equals(other.getAcctType()))
				&& (this.getSubAcctNo() == null ? other.getSubAcctNo() == null
						: this.getSubAcctNo().equals(other.getSubAcctNo()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
		result = prime * result + ((getMainAcct() == null) ? 0 : getMainAcct().hashCode());
		result = prime * result + ((getAcctType() == null) ? 0 : getAcctType().hashCode());
		result = prime * result + ((getSubAcctNo() == null) ? 0 : getSubAcctNo().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", custNo=").append(custNo);
		sb.append(", mainAcct=").append(mainAcct);
		sb.append(", subAcctNo=").append(subAcctNo);
		sb.append(", acctType=").append(acctType);
		sb.append("]");
		return sb.toString();
	}
}