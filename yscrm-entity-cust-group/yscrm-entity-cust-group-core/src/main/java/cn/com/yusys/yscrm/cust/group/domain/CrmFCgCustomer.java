package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class CrmFCgCustomer implements Serializable{

  private static final long serialVersionUID = 1613148922215118848L;

	/**
	 * 关系id
	 */
    @ApiModelProperty(value = "关系id")
  private String seqno;

	/**
	 * 客群编码
	 */
    @ApiModelProperty(value = "客群编码")
  private String custGroupId;

	/**
	 * 客户号
	 */
    @ApiModelProperty(value = "客户号")
  private String custid;

	/**
	 * 客户中文姓名
	 */
    @ApiModelProperty(value = "客户中文姓名")
  private String custidName;

	/**
	 * 客户英文姓名
	 */
    @ApiModelProperty(value = "客户英文姓名")
  private String custidEngname;

	/**
	 * 创建日期
	 */
    @ApiModelProperty(value = "创建日期")
  private java.util.Date createDate;


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


  public String getCustid() {
    return custid;
  }

  public void setCustid(String custid) {
    this.custid = custid;
  }


  public String getCustidName() {
    return custidName;
  }

  public void setCustidName(String custidName) {
    this.custidName = custidName;
  }


  public String getCustidEngname() {
    return custidEngname;
  }

  public void setCustidEngname(String custidEngname) {
    this.custidEngname = custidEngname;
  }


  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.util.Date createDate) {
    this.createDate = createDate;
  }

}
