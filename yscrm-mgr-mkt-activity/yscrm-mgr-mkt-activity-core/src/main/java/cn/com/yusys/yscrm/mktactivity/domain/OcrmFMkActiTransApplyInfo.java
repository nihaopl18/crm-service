package cn.com.yusys.yscrm.mktactivity.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name="OCRM_F_MK_ACTI_TRANS_APPLY")
public class OcrmFMkActiTransApplyInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RECORD_ID")
	private BigDecimal recordId;
	
	public BigDecimal getRecordId() { return recordId; }
	public void setRecordId(BigDecimal recordId) { this.recordId=recordId; }
	
	@Column(name="ACTI_ID")
	private BigDecimal actiId;
	
	public BigDecimal getActiId() { return actiId; }
	public void setActiId(BigDecimal actiId) { this.actiId=actiId; }

	@Column(name="ACTI_NAME")
	private String actiName;
	
	public String getActiName() { return actiName; }
	public void setActiName(String actiName) { this.actiName=actiName; }
	
	@Column(name="FROM_USER")
	private String fromUser;
	
	public String getFromUser() { return fromUser; }
	public void setFromUser(String fromUser) { this.fromUser=fromUser; }

	@Column(name="TO_USER")
	private String toUser;
	
	public String getToUser() { return toUser; }
	public void setToUser(String toUser) { this.toUser=toUser; }

	@Column(name="MOVE_DATE")
	private Date moveDate;
	
	public Date getMoveDate() { return moveDate; }
	public void setMoveDate(Date moveDate) { this.moveDate=moveDate; }

	@Column(name="REMARK")
	private String remark;
	
	public String getRemark() { return remark; }
	public void setRemark(String remark) { this.remark=remark; }
	
	@Column(name="CREATE_USER")
	private String createUser;
	
	public String getCreateUser() { return createUser; }
	public void setCreateUser(String createUser) { this.createUser=createUser; }
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	public Date getCreateDate() { return createDate; }
	public void setCreateDate(Date createDate) { this.createDate=createDate; }
	
	@Column(name="CREATE_ORG")
	private String createOrg;
	
	public String getCreateOrg() { return createOrg; }
	public void setCreateOrg(String createOrg) { this.createOrg=createOrg; }
	
	@Column(name="UPDATE_USER")
	private String updateUser;
	
	public String getUpdateUser() { return updateUser; }
	public void setUpdateUser(String updateUser) { this.updateUser=updateUser; }
	
	@Column(name="UPDATE_DATE")
	private Date updateDate;
	
	public Date getUpdateDate() { return updateDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate=updateDate; }
	
	@Column(name="UPDATE_ORG")
	private String updateOrg;
	
	public String getUpdateOrg() { return updateOrg; }
	public void setUpdateOrg(String updateOrg) { this.updateOrg=updateOrg; }
	
}
