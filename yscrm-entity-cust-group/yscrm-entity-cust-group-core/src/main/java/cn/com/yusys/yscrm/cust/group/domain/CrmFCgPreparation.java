package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CG_PREPARATION")
public class CrmFCgPreparation implements Serializable{

  private static final long serialVersionUID = 1350382040939802624L;

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

	/**
	 * 客户号
	 */
    @ApiModelProperty(value = "客户号")
  private String custNo;

	/**
	 * 客户中文姓名
	 */
    @ApiModelProperty(value = "客户中文姓名")
  private String custName;

	/**
	 * 客户英文姓名
	 */
    @ApiModelProperty(value = "客户英文姓名")
  private String custEngName;

	/**
	 * NDS号
	 */
    @ApiModelProperty(value = "NDS号")
  private String ndsCustNo;

	/**
	 * 地区
	 */
    @ApiModelProperty(value = "地区")
  private String nationality;

	/**
	 * AUM余额
	 */
    @ApiModelProperty(value = "AUM余额")
  private String aumBalance;

	/**
	 * AUM月日均
	 */
    @ApiModelProperty(value = "AUM月日均")
  private String aumBalanceAvgRmb;

	/**
	 * 非汇理财余额
	 */
    @ApiModelProperty(value = "非汇理财余额")
  private String nonExchangeFinBalance;

	/**
	 * 汇率理财余额
	 */
    @ApiModelProperty(value = "汇率理财余额")
  private String exchangeFinBalance;

	/**
	 * 信托余额
	 */
    @ApiModelProperty(value = "信托余额")
  private String trustBalanceRmb;

	/**
	 * 人名币基金余额
	 */
    @ApiModelProperty(value = "人名币基金余额")
  private String rmbFundBalance;

	/**
	 * QDII净值余额
	 */
    @ApiModelProperty(value = "QDII净值余额")
  private String qdiiBalanceRmb;

	/**
	 * 资管余额
	 */
    @ApiModelProperty(value = "资管余额")
  private String assestManageBalance;

	/**
	 * 保险余额
	 */
    @ApiModelProperty(value = "保险余额")
  private String insurranceBalance;

	/**
	 * 存款余额
	 */
    @ApiModelProperty(value = "存款余额")
  private String depositBalanceRmb;


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


  public String getCustNo() {
    return custNo;
  }

  public void setCustNo(String custNo) {
    this.custNo = custNo;
  }


  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }


  public String getCustEngName() {
    return custEngName;
  }

  public void setCustEngName(String custEngName) {
    this.custEngName = custEngName;
  }


  public String getNdsCustNo() {
    return ndsCustNo;
  }

  public void setNdsCustNo(String ndsCustNo) {
    this.ndsCustNo = ndsCustNo;
  }


  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }


  public String getAumBalance() {
    return aumBalance;
  }

  public void setAumBalance(String aumBalance) {
    this.aumBalance = aumBalance;
  }


  public String getAumBalanceAvgRmb() {
    return aumBalanceAvgRmb;
  }

  public void setAumBalanceAvgRmb(String aumBalanceAvgRmb) {
    this.aumBalanceAvgRmb = aumBalanceAvgRmb;
  }


  public String getNonExchangeFinBalance() {
    return nonExchangeFinBalance;
  }

  public void setNonExchangeFinBalance(String nonExchangeFinBalance) {
    this.nonExchangeFinBalance = nonExchangeFinBalance;
  }


  public String getExchangeFinBalance() {
    return exchangeFinBalance;
  }

  public void setExchangeFinBalance(String exchangeFinBalance) {
    this.exchangeFinBalance = exchangeFinBalance;
  }


  public String getTrustBalanceRmb() {
    return trustBalanceRmb;
  }

  public void setTrustBalanceRmb(String trustBalanceRmb) {
    this.trustBalanceRmb = trustBalanceRmb;
  }


  public String getRmbFundBalance() {
    return rmbFundBalance;
  }

  public void setRmbFundBalance(String rmbFundBalance) {
    this.rmbFundBalance = rmbFundBalance;
  }


  public String getQdiiBalanceRmb() {
    return qdiiBalanceRmb;
  }

  public void setQdiiBalanceRmb(String qdiiBalanceRmb) {
    this.qdiiBalanceRmb = qdiiBalanceRmb;
  }


  public String getAssestManageBalance() {
    return assestManageBalance;
  }

  public void setAssestManageBalance(String assestManageBalance) {
    this.assestManageBalance = assestManageBalance;
  }


  public String getInsurranceBalance() {
    return insurranceBalance;
  }

  public void setInsurranceBalance(String insurranceBalance) {
    this.insurranceBalance = insurranceBalance;
  }


  public String getDepositBalanceRmb() {
    return depositBalanceRmb;
  }

  public void setDepositBalanceRmb(String depositBalanceRmb) {
    this.depositBalanceRmb = depositBalanceRmb;
  }

}
