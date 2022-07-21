package cn.com.yusys.yscrm.cust.group.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

;

@Entity
public class CrmFCissCgDTO implements Serializable{

  private static final long serialVersionUID = 1821798978036440576L;

  //客户号
  @ApiModelProperty(value = "客户号")
  private String custId;

  //客户中文信息
  @ApiModelProperty(value = "客户中文信息")
  private String custidName;
  //客户英文信息
  @ApiModelProperty(value = "客户英文信息")
  private String custidEngname;

  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
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
}

