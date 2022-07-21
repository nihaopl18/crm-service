package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CG_CUSTOMER_TAG")
public class CrmFCgCustomerTag implements Serializable{

  private static final long serialVersionUID = 1652213783488586496L;

	/**
	 * 数据日期
	 */
    @ApiModelProperty(value = "数据日期")
  private String dataDate;

	/**
	 * 代理主键
	 */
    @ApiModelProperty(value = "代理主键")
  private String id;

  @ApiModelProperty(value = "机构号")
  private String custGroupNo;

  @ApiModelProperty(value = "标签编码")
  private String tagNo;

  @ApiModelProperty(value = "标签名称")
  private String tagName;

  @ApiModelProperty(value = "客户数")
  private String custNumber;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getCustGroupNo() {
    return custGroupNo;
  }

  public void setCustGroupNo(String custGroupNo) {
    this.custGroupNo = custGroupNo;
  }


  public String getTagNo() {
    return tagNo;
  }

  public void setTagNo(String tagNo) {
    this.tagNo = tagNo;
  }


  public String getTagName() {
    return tagName;
  }

  public void setTagName(String tagName) {
    this.tagName = tagName;
  }


  public String getCustNumber() {
    return custNumber;
  }

  public void setCustNumber(String custNumber) {
    this.custNumber = custNumber;
  }

}
