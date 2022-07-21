package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CG_JOURNAL")
public class CrmFCgJournal implements Serializable{

  private static final long serialVersionUID = 1351405328940413440L;

	/**
	 * 日志id
	 */
    @ApiModelProperty(value = "日志id")
  private String seqno;

	/**
	 * 机构编码
	 */
    @ApiModelProperty(value = "机构编码")
  private String orgId;

	/**
	 * 客户经理编号
	 */
    @ApiModelProperty(value = "客户经理编号")
  private String samId;

	/**
	 * 客户群名称
	 */
    @ApiModelProperty(value = "客户群名称")
  private String custGroupName;

	/**
	 * 客户群编号
	 */
    @ApiModelProperty(value = "客户群编号")
  private String custGroupNo;

	/**
	 * 客户号集
	 */
    @ApiModelProperty(value = "客户号集")
  private String custidCollect;

	/**
	 * 变动类型:01 人员添加 02 人员移除 03 系统录入
	 */
    @ApiModelProperty(value = "变动类型:01 人员添加 02 人员移除 03 系统录入")
  private String changeType;

	/**
	 * 变动条数
	 */
    @ApiModelProperty(value = "变动条数")
  private String changeCount;

	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
  private String createUser;

	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
  private java.util.Date createDate;


  public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }


  public String getSamId() {
    return samId;
  }

  public void setSamId(String samId) {
    this.samId = samId;
  }


  public String getCustGroupName() {
    return custGroupName;
  }

  public void setCustGroupName(String custGroupName) {
    this.custGroupName = custGroupName;
  }


  public String getCustGroupNo() {
    return custGroupNo;
  }

  public void setCustGroupNo(String custGroupNo) {
    this.custGroupNo = custGroupNo;
  }


  public String getCustidCollect() {
    return custidCollect;
  }

  public void setCustidCollect(String custidCollect) {
    this.custidCollect = custidCollect;
  }


  public String getChangeType() {
    return changeType;
  }

  public void setChangeType(String changeType) {
    this.changeType = changeType;
  }


  public String getChangeCount() {
    return changeCount;
  }

  public void setChangeCount(String changeCount) {
    this.changeCount = changeCount;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.util.Date createDate) {
    this.createDate = createDate;
  }

}
