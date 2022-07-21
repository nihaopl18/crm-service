package cn.com.yusys.yscrm.custpub.domain;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CI_BELONG_HIS_DATA")
public class CrmFCiBelongHisData implements Serializable{

  private static final long serialVersionUID = 1900432243191951104L;

	/**
	 * id
	 */
  private String seqno;

	/**
	 * 客户号
	 */
  private String custId;

	/**
	 * 原机构号
	 */
  private String orgIdPre;

	/**
	 * 原机构名称
	 */
  private String orgNamePre;

	/**
	 * 原客户经理编号
	 */
  private String mgrIdPre;

	/**
	 * 原客户经理名称
	 */
  private String mgrNamePre;

	/**
	 * 原客户经理类型（1 理财 2个贷）
	 */
  private String mgrTypePre;

	/**
	 * 现机构号
	 */
  private String orgId;

	/**
	 * 现机构名称
	 */
  private String orgName;

	/**
	 * 现客户经理类型（1 理财 2个贷）
	 */
  private String mgrType;

	/**
	 * 现客户经理编号
	 */
  private String mgrId;

	/**
	 * 现客户经理名称
	 */
  private String mgrName;

	/**
	 * 修改人名称
	 */
  private String assignUserName;
    /**
     * 修改人编号
     */
    private String assignUserId;

	/**
	 * 修改时间
	 */
  private java.util.Date assignDate;

	/**
	 * 类型（01分配 02调整）
	 */
  private String assignType;
    /**
     * 状态（01草稿 02审批中 03 退回 04 生效）
     */
  private String assignStatus;
    /**
     * 变更原因
     */
  private String changeReason;
    /**
     * 流程id
     */
  private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public String getAssignStatus() {
        return assignStatus;
    }

    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }

    public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }


  public String getOrgIdPre() {
    return orgIdPre;
  }

  public void setOrgIdPre(String orgIdPre) {
    this.orgIdPre = orgIdPre;
  }


  public String getOrgNamePre() {
    return orgNamePre;
  }

  public void setOrgNamePre(String orgNamePre) {
    this.orgNamePre = orgNamePre;
  }


  public String getMgrIdPre() {
    return mgrIdPre;
  }

  public void setMgrIdPre(String mgrIdPre) {
    this.mgrIdPre = mgrIdPre;
  }


  public String getMgrNamePre() {
    return mgrNamePre;
  }

  public void setMgrNamePre(String mgrNamePre) {
    this.mgrNamePre = mgrNamePre;
  }


  public String getMgrTypePre() {
    return mgrTypePre;
  }

  public void setMgrTypePre(String mgrTypePre) {
    this.mgrTypePre = mgrTypePre;
  }


  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }


  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }


  public String getMgrType() {
    return mgrType;
  }

  public void setMgrType(String mgrType) {
    this.mgrType = mgrType;
  }


  public String getMgrId() {
    return mgrId;
  }

  public void setMgrId(String mgrId) {
    this.mgrId = mgrId;
  }


  public String getMgrName() {
    return mgrName;
  }

  public void setMgrName(String mgrName) {
    this.mgrName = mgrName;
  }


    public String getAssignUserName() {
        return assignUserName;
    }

    public void setAssignUserName(String assignUserName) {
        this.assignUserName = assignUserName;
    }

    public String getAssignUserId() {
        return assignUserId;
    }

    public void setAssignUserId(String assignUserId) {
        this.assignUserId = assignUserId;
    }

    public java.util.Date getAssignDate() {
    return assignDate;
  }

  public void setAssignDate(java.util.Date assignDate) {
    this.assignDate = assignDate;
  }


  public String getAssignType() {
    return assignType;
  }

  public void setAssignType(String assignType) {
    this.assignType = assignType;
  }

}
