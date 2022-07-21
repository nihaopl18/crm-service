package cn.com.yusys.yscrm.info.workreport.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OCRM_F_WP_CUSTOMER_CONTACT")
public class OcrmFwpCustomerContact extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 接触编号
	 **/
	@Id
	@Column(name = "CUSTOMER_CONTACT_ID")
	@Generated(GenerationType.UUID)
	private String customerContactId;

	@Column(name = "WORK_REPORT_ID", unique = false, nullable = true, length = 30)
	private String workReportId;

	@Column(name = "CONTACT_TYPE", unique = false, nullable = true, length = 30)
	private String contactType;

	@Column(name = "CONTACT_GOAL", unique = false, nullable = true, length = 30)
	private String contactGoal;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "CONTACT_DATE", unique = false, nullable = true, length = 7)
	private Date contactDate;

	@Column(name = "CONTACT_CUST_ID", unique = false, nullable = true, length = 30)
	private String contactCustId;

	@Column(name = "CONTACT_CUST_NAME", unique = false, nullable = true, length = 30)
	private String contactCustName;

	@Column(name = "CREATOR_ID", unique = false, nullable = true, length = 30)
	private String creatorId;

	@Column(name = "CREATOR_NAME", unique = false, nullable = true, length = 30)
	private String creatorName;

	@Column(name = "CREATOR_ORG_ID", unique = false, nullable = true, length = 30)
	private String creatorOrgId;

	@Column(name = "CREATOR_ORG_NAME", unique = false, nullable = true, length = 30)
	private String creatorOrgName;

	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;

	@Column(name = "NEXT_CONTACT_DATE", unique = false, nullable = true, length = 7)
	private Date nextContactDate;

	@Column(name = "PRODUCT", unique = false, nullable = true, length = 30)
	private String product;

	@Column(name = "CONTACT_BACK", unique = false, nullable = true, length = 800)
	private String contactBack;

	@Column(name = "LAST_CHG_USR_ID", unique = false, nullable = true, length = 30)
	private String lastChgUsrId;

	@Column(name = "LAST_CHG_USR_NAME", unique = false, nullable = true, length = 30)
	private String lastChgUsrName;

	@Column(name = "LAST_CHG_USR_ORG_ID", unique = false, nullable = true, length = 30)
	private String lastChgUsrOrgId;

	@Column(name = "LAST_CHG_USR_ORG_NAME", unique = false, nullable = true, length = 30)
	private String lastChgUsrOrgName;

	@Column(name = "LAST_CHG_DATE", unique = false, nullable = true, length = 7)
	private Date lastChgDate;

	@Column(name = "IS_DELETE", unique = false, nullable = true, length = 2)
	private String isDelete;

	@Column(name = "IS_DRAFT", unique = false, nullable = true, length = 2)
	private String isDraft;

	@Column(name = "SOURCE_TABLE", unique = false, nullable = true, length = 4)
	private String sourceTable;

	public String getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(String customerContactId) {
		this.customerContactId = customerContactId == null ? null : customerContactId.trim();
	}

	public String getWorkReportId() {
		return workReportId;
	}

	public void setWorkReportId(String workReportId) {
		this.workReportId = workReportId == null ? null : workReportId.trim();
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType == null ? null : contactType.trim();
	}

	public String getContactGoal() {
		return contactGoal;
	}

	public void setContactGoal(String contactGoal) {
		this.contactGoal = contactGoal == null ? null : contactGoal.trim();
	}

	public Date getContactDate() {
		return contactDate;
	}

	public void setContactDate(Date contactDate) {
		this.contactDate = contactDate;
	}

	public String getContactCustId() {
		return contactCustId;
	}

	public void setContactCustId(String contactCustId) {
		this.contactCustId = contactCustId == null ? null : contactCustId.trim();
	}

	public String getContactCustName() {
		return contactCustName;
	}

	public void setContactCustName(String contactCustName) {
		this.contactCustName = contactCustName == null ? null : contactCustName.trim();
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId == null ? null : creatorId.trim();
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName == null ? null : creatorName.trim();
	}

	public String getCreatorOrgId() {
		return creatorOrgId;
	}

	public void setCreatorOrgId(String creatorOrgId) {
		this.creatorOrgId = creatorOrgId == null ? null : creatorOrgId.trim();
	}

	public String getCreatorOrgName() {
		return creatorOrgName;
	}

	public void setCreatorOrgName(String creatorOrgName) {
		this.creatorOrgName = creatorOrgName == null ? null : creatorOrgName.trim();
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product == null ? null : product.trim();
	}

	public String getContactBack() {
		return contactBack;
	}

	public void setContactBack(String contactBack) {
		this.contactBack = contactBack == null ? null : contactBack.trim();
	}

	public String getLastChgUsrId() {
		return lastChgUsrId;
	}

	public void setLastChgUsrId(String lastChgUsrId) {
		this.lastChgUsrId = lastChgUsrId == null ? null : lastChgUsrId.trim();
	}

	public String getLastChgUsrName() {
		return lastChgUsrName;
	}

	public void setLastChgUsrName(String lastChgUsrName) {
		this.lastChgUsrName = lastChgUsrName == null ? null : lastChgUsrName.trim();
	}

	public String getLastChgUsrOrgId() {
		return lastChgUsrOrgId;
	}

	public void setLastChgUsrOrgId(String lastChgUsrOrgId) {
		this.lastChgUsrOrgId = lastChgUsrOrgId == null ? null : lastChgUsrOrgId.trim();
	}

	public String getLastChgUsrOrgName() {
		return lastChgUsrOrgName;
	}

	public void setLastChgUsrOrgName(String lastChgUsrOrgName) {
		this.lastChgUsrOrgName = lastChgUsrOrgName == null ? null : lastChgUsrOrgName.trim();
	}

	public Date getLastChgDate() {
		return lastChgDate;
	}

	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}

	/**
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            要设置的 createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return nextContactDate
	 */
	public Date getNextContactDate() {
		return nextContactDate;
	}

	/**
	 * @param nextContactDate
	 *            要设置的 nextContactDate
	 */
	public void setNextContactDate(Date nextContactDate) {
		this.nextContactDate = nextContactDate;
	}

	public String getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(String isDraft) {
		this.isDraft = isDraft==null ? null : isDraft.trim();
	}

	public String getSourceTable() { return sourceTable; }

	public void setSourceTable(String sourceTable) { this.sourceTable = sourceTable == null ? null : sourceTable.trim(); }

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
		OcrmFwpCustomerContact other = (OcrmFwpCustomerContact) that;
		return (this.getCustomerContactId() == null ? other.getCustomerContactId() == null
				: this.getCustomerContactId().equals(other.getCustomerContactId()))
				&& (this.getContactBack() == null ? other.getContactBack() == null
						: this.getContactBack().equals(other.getContactBack()))
				&& (this.getContactCustId() == null ? other.getContactCustId() == null
						: this.getContactCustId().equals(other.getContactCustId()))
				&& (this.getContactCustName() == null ? other.getContactCustName() == null
						: this.getContactCustName().equals(other.getContactCustName()))
				&& (this.getContactGoal() == null ? other.getContactGoal() == null
						: this.getContactGoal().equals(other.getContactGoal()))
				&& (this.getContactType() == null ? other.getContactType() == null
						: this.getContactType().equals(other.getContactType()))
				&& (this.getWorkReportId() == null ? other.getWorkReportId() == null
						: this.getWorkReportId().equals(other.getWorkReportId()))
				&& (this.getProduct() == null ? other.getProduct() == null
						: this.getProduct().equals(other.getProduct()))
				&& (this.getIsDelete() == null ? other.getIsDelete() == null
						: this.getIsDelete().equals(other.getIsDelete()))
				&& (this.getLastChgUsrOrgName() == null ? other.getLastChgUsrOrgName() == null
						: this.getLastChgUsrOrgName().equals(other.getLastChgUsrOrgName()))
				&& (this.getLastChgUsrOrgId() == null ? other.getLastChgUsrOrgId() == null
						: this.getLastChgUsrOrgId().equals(other.getLastChgUsrOrgId()))
				&& (this.getLastChgUsrName() == null ? other.getLastChgUsrName() == null
						: this.getLastChgUsrName().equals(other.getLastChgUsrName()))
				&& (this.getLastChgUsrId() == null ? other.getLastChgUsrId() == null
						: this.getLastChgUsrId().equals(other.getLastChgUsrId()))
				&& (this.getCreatorOrgName() == null ? other.getCreatorOrgName() == null
						: this.getCreatorOrgName().equals(other.getCreatorOrgName()))
				&& (this.getCreatorOrgId() == null ? other.getCreatorOrgId() == null
						: this.getCreatorOrgId().equals(other.getCreatorOrgId()))
				&& (this.getCreatorName() == null ? other.getCreatorName() == null
						: this.getCreatorName().equals(other.getCreatorName()))
				&& (this.getCreatorId() == null ? other.getCreatorId() == null
						: this.getCreatorId().equals(other.getCreatorId()))
				&& (this.getIsDraft() == null ? other.getIsDraft() == null
				: this.getIsDraft().equals(other.getIsDraft()))
				&& (this.getSourceTable() == null ? other.getSourceTable() == null
				: this.getSourceTable().equals(other.getSourceTable()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
		result = prime * result + ((getCreatorName() == null) ? 0 : getCreatorName().hashCode());
		result = prime * result + ((getCreatorOrgId() == null) ? 0 : getCreatorOrgId().hashCode());
		result = prime * result + ((getCreatorOrgName() == null) ? 0 : getCreatorOrgName().hashCode());
		result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
		result = prime * result + ((getLastChgUsrId() == null) ? 0 : getLastChgUsrId().hashCode());
		result = prime * result + ((getLastChgUsrName() == null) ? 0 : getLastChgUsrName().hashCode());
		result = prime * result + ((getLastChgUsrOrgId() == null) ? 0 : getLastChgUsrOrgId().hashCode());
		result = prime * result + ((getLastChgUsrOrgName() == null) ? 0 : getLastChgUsrOrgName().hashCode());
		result = prime * result + ((getContactType() == null) ? 0 : getContactType().hashCode());
		result = prime * result + ((getContactGoal() == null) ? 0 : getContactGoal().hashCode());
		result = prime * result + ((getContactCustName() == null) ? 0 : getContactCustName().hashCode());
		result = prime * result + ((getContactCustId() == null) ? 0 : getContactCustId().hashCode());
		result = prime * result + ((getContactBack() == null) ? 0 : getContactBack().hashCode());
		result = prime * result + ((getCustomerContactId() == null) ? 0 : getCustomerContactId().hashCode());
		result = prime * result + ((getWorkReportId() == null) ? 0 : getWorkReportId().hashCode());
		result = prime * result + ((getProduct() == null) ? 0 : getProduct().hashCode());
		result = prime * result + ((getIsDraft() == null) ? 0 : getIsDraft().hashCode());
		result = prime * result + ((getSourceTable() == null) ? 0 : getSourceTable().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", creatorId=").append(creatorId);
		sb.append(", creatorName=").append(creatorName);
		sb.append(", creatorOrgId=").append(creatorOrgId);
		sb.append(", creatorOrgName=").append(creatorOrgName);
		sb.append(", isDelete=").append(isDelete);
		sb.append(", lastChgUsrId=").append(lastChgUsrId);
		sb.append(", lastChgUsrName=").append(lastChgUsrName);
		sb.append(", lastChgUsrOrgId=").append(lastChgUsrOrgId);
		sb.append(", lastChgUsrOrgName=").append(lastChgUsrOrgName);
		sb.append(", contactCustId=").append(contactCustId);
		sb.append(", contactBack=").append(contactBack);
		sb.append(", contactCustName=").append(contactCustName);
		sb.append(", contactGoal=").append(contactGoal);
		sb.append(", contactType=").append(contactType);
		sb.append(", workReportId=").append(workReportId);
		sb.append(", product=").append(product);
		sb.append(", workReportId=").append(workReportId);
		sb.append(", isDraft=").append(isDraft);
		sb.append(", sourceTable=").append(sourceTable);
		sb.append("]");
		return sb.toString();
	}
}
