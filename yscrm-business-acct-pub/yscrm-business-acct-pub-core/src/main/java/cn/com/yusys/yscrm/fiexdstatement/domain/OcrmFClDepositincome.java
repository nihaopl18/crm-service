package cn.com.yusys.yscrm.fiexdstatement.domain;


import java.math.BigDecimal;

/**
 *存款收入表
 */
public class OcrmFClDepositincome {

  private String dataDate;
  private String branch;
  private String branchNo;
  private String orgId;
  private String orgName;
  private String customerId;
  private String customerName;
  private BigDecimal exchangeSimulateProfit;
  private BigDecimal nonExchangeSimulateProfit;
  private BigDecimal depositProfit;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }


  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }


  public String getBranchNo() {
    return branchNo;
  }

  public void setBranchNo(String branchNo) {
    this.branchNo = branchNo;
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


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public BigDecimal getExchangeSimulateProfit() {
    return exchangeSimulateProfit;
  }

  public void setExchangeSimulateProfit(BigDecimal exchangeSimulateProfit) {
    this.exchangeSimulateProfit = exchangeSimulateProfit;
  }

  public BigDecimal getNonExchangeSimulateProfit() {
    return nonExchangeSimulateProfit;
  }

  public void setNonExchangeSimulateProfit(BigDecimal nonExchangeSimulateProfit) {
    this.nonExchangeSimulateProfit = nonExchangeSimulateProfit;
  }

  public BigDecimal getDepositProfit() {
    return depositProfit;
  }

  public void setDepositProfit(BigDecimal depositProfit) {
    this.depositProfit = depositProfit;
  }
}
