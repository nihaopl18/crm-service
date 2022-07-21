package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CG_TAGCOUNT_TAG")
public class CrmFCgTagcountTag implements Serializable{

  private static final long serialVersionUID = 1960162372705150208L;

	/**
	 * 序号
	 */
    @ApiModelProperty(value = "序号")
  private String seqno;

	/**
	 * 机构号
	 */
    @ApiModelProperty(value = "机构号")
  private String orgId;

	/**
	 * 客户经理编号
	 */
    @ApiModelProperty(value = "客户经理编号")
  private String samId;

	/**
	 * 标签编码
	 */
    @ApiModelProperty(value = "标签编码")
  private String tagId;

	/**
	 * 标签名称
	 */
    @ApiModelProperty(value = "标签名称")
  private String tagName;

	/**
	 * 创建日期
	 */
    @ApiModelProperty(value = "创建日期")
  private java.util.Date createDate;

	/**
	 * 数据日期
	 */
    @ApiModelProperty(value = "数据日期")
  private java.util.Date dataDate;

	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人")
  private String createUser;


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


  public String getTagId() {
    return tagId;
  }

  public void setTagId(String tagId) {
    this.tagId = tagId;
  }


  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }


  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.util.Date createDate) {
    this.createDate = createDate;
  }


  public java.util.Date getDataDate() {
    return dataDate;
  }

  public void setDataDate(java.util.Date dataDate) {
    this.dataDate = dataDate;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

}
