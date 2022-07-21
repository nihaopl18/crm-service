package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CG_CUSTOMER_PREPARATION")
public class CrmFCgCustomerPreparation implements Serializable{

  private static final long serialVersionUID = 1650298374946631168L;

	/**
	 * id
	 */
    @ApiModelProperty(value = "id")
  private String seqno;

	/**
	 * 客群编码
	 */
    @ApiModelProperty(value = "客群编码")
  private String custGroupId;

	/**
	 * AUM余额
	 */
    @ApiModelProperty(value = "AUM余额")
  private String aumBalance;

	/**
	 * 客户等级
	 */
    @ApiModelProperty(value = "客户等级")
  private String custgrade;

	/**
	 * 地区
	 */
    @ApiModelProperty(value = "地区")
  private String countareacd;

	/**
	 * 年龄区间
	 */
    @ApiModelProperty(value = "年龄区间")
  private String agegroup;

	/**
	 * 近一月到期
	 */
    @ApiModelProperty(value = "近一月到期")
  private String expireno;

	/**
	 * 标签
	 */
    @ApiModelProperty(value = "标签")
  private String tagname;

	/**
	 * 持有产品
	 */
    @ApiModelProperty(value = "持有产品")
  private String prodname;

	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间")
  private java.util.Date createDate;
    @ApiModelProperty(value = "创建人")
  private String createUser;


  public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


  public String getCustGroupId() {
    return custGroupId;
  }

  public void setCustGroupId(String custGroupId) {
    this.custGroupId = custGroupId;
  }


  public String getAumBalance() {
    return aumBalance;
  }

  public void setAumBalance(String aumBalance) {
    this.aumBalance = aumBalance;
  }


  public String getCustgrade() {
    return custgrade;
  }

  public void setCustgrade(String custgrade) {
    this.custgrade = custgrade;
  }


  public String getCountareacd() {
    return countareacd;
  }

  public void setCountareacd(String countareacd) {
    this.countareacd = countareacd;
  }


  public String getAgegroup() {
    return agegroup;
  }

  public void setAgegroup(String agegroup) {
    this.agegroup = agegroup;
  }


  public String getExpireno() {
    return expireno;
  }

  public void setExpireno(String expireno) {
    this.expireno = expireno;
  }


  public String getTagname() {
    return tagname;
  }

  public void setTagname(String tagname) {
    this.tagname = tagname;
  }


  public String getProdname() {
    return prodname;
  }

  public void setProdname(String prodname) {
    this.prodname = prodname;
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

}
