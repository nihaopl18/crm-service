package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CISS_CG_BASE")
public class CrmFCissCgBase implements Serializable{

  private static final long serialVersionUID = 1821798978036440576L;

	/**
	 * 客户群id
	 */
    @ApiModelProperty(value = "客户群id")
  private String seqno;

	/**
	 * 客户经理编号
	 */
    @ApiModelProperty(value = "客户经理编号")
  private String samId;

	/**
	 * 机构编码
	 */
    @ApiModelProperty(value = "机构编码")
  private String orgId;

	/**
	 * 是否关注
	 */
    @ApiModelProperty(value = "是否关注")
  private String isFocus;

	/**
	 * 客户群编号
	 */
    @ApiModelProperty(value = "客户群编号")
  private String custGroupId;

	/**
	 * 客户群名称
	 */
    @ApiModelProperty(value = "客户群名称")
  private String custGroupName;

	/**
	 * 客户群描述
	 */
    @ApiModelProperty(value = "客户群描述")
  private String custGroupDescribe;

	/**
	 * 客户群规则
	 */
    @ApiModelProperty(value = "客户群规则")
  private String custGroupRule;

	/**
	 * 初始客户数
	 */
    @ApiModelProperty(value = "初始客户数")
  private String initialCout;

	/**
	 * 客群类型 : 01 动态客群 02 静态客群
	 */
    @ApiModelProperty(value = "客群类型 : 01 动态客群 02 静态客群")
  private String custGroupType;

	/**
	 * 客群标签集
	 */
    @ApiModelProperty(value = "客群标签集")
  private String custGroupLabel;

	/**
	 * 是否生效 01:存在 02 已删除
	 */
    @ApiModelProperty(value = "是否生效 01:存在 02 已删除")
  private String isFlag;

	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
  private Date createDate;

	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
  private String createUser;

	/**
	 * 更新时间
	 */
    @ApiModelProperty(value = "更新时间")
  private java.util.Date updateDate;

	/**
	 * 更新人
	 */
    @ApiModelProperty(value = "更新人")
  private String updateUser;


  public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


  public String getSamId() {
    return samId;
  }

  public void setSamId(String samId) {
    this.samId = samId;
  }


  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }


  public String getIsFocus() {
    return isFocus;
  }

  public void setIsFocus(String isFocus) {
    this.isFocus = isFocus;
  }


  public String getCustGroupId() {
    return custGroupId;
  }

  public void setCustGroupId(String custGroupId) {
    this.custGroupId = custGroupId;
  }


  public String getCustGroupName() {
    return custGroupName;
  }

  public void setCustGroupName(String custGroupName) {
    this.custGroupName = custGroupName;
  }


  public String getCustGroupDescribe() {
    return custGroupDescribe;
  }

  public void setCustGroupDescribe(String custGroupDescribe) {
    this.custGroupDescribe = custGroupDescribe;
  }


  public String getCustGroupRule() {
    return custGroupRule;
  }

  public void setCustGroupRule(String custGroupRule) {
    this.custGroupRule = custGroupRule;
  }


  public String getInitialCout() {
    return initialCout;
  }

  public void setInitialCout(String initialCout) {
    this.initialCout = initialCout;
  }


  public String getCustGroupType() {
    return custGroupType;
  }

  public void setCustGroupType(String custGroupType) {
    this.custGroupType = custGroupType;
  }


  public String getCustGroupLabel() {
    return custGroupLabel;
  }

  public void setCustGroupLabel(String custGroupLabel) {
    this.custGroupLabel = custGroupLabel;
  }


  public String getIsFlag() {
    return isFlag;
  }

  public void setIsFlag(String isFlag) {
    this.isFlag = isFlag;
  }


  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.util.Date createDate) {
    this.createDate = createDate;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public java.util.Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(java.util.Date updateDate) {
    this.updateDate = updateDate;
  }


  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

}
