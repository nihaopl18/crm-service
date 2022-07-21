package cn.com.yusys.yscrm.fiexdstatement.domain;


import java.math.BigDecimal;
import java.util.Date;

/**
 *个人结构性存款明细表
 */
public class OcrmFClPersonalDetail {

  private String dataDate;
  private String productClass;
  private String acctNo;
  private String mgrId;
  private String mgrName;
  private String orgName;
  private String orgNo;
  private String line;
  private String custNo;
  private String ecifCustNo;
  private String prodCode;
  private String prodName;
  private String buyFinamt;
  private String custName;
  private BigDecimal balance;
  private BigDecimal monthAvgRegularBal;
  private BigDecimal quarterAvgRegularBal;
  private BigDecimal yearAvgRegularBal;
  private BigDecimal monthInterestPayable;
  private BigDecimal monthFtpInterestReceived;
  private BigDecimal quarterInterestPayable;
  private BigDecimal quarterFtpInterestReceived;
  private BigDecimal yearInterestPayable;
  private BigDecimal yearFtpInterestReceived;
  private BigDecimal dayFtpRate;
  private BigDecimal monthAvgFtpRate;
  private BigDecimal monthSimulateIncome;
  private BigDecimal quarterSimulateIncome;
  private BigDecimal yearSimulateIncome;
  private String changeBalanceLastYear;
  private Date valueDate;
  private Date expDate;
  private String executionEfficiency;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }

  public String getProductClass() {
    return productClass;
  }

  public void setProductClass(String productClass) {
    this.productClass = productClass;
  }

  public String getAcctNo() {
    return acctNo;
  }

  public void setAcctNo(String acctNo) {
    this.acctNo = acctNo;
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

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getOrgNo() {
    return orgNo;
  }

  public void setOrgNo(String orgNo) {
    this.orgNo = orgNo;
  }

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public String getCustNo() {
    return custNo;
  }

  public void setCustNo(String custNo) {
    this.custNo = custNo;
  }

  public String getEcifCustNo() {
    return ecifCustNo;
  }

  public void setEcifCustNo(String ecifCustNo) {
    this.ecifCustNo = ecifCustNo;
  }

  public String getProdCode() {
    return prodCode;
  }

  public void setProdCode(String prodCode) {
    this.prodCode = prodCode;
  }

  public String getProdName() {
    return prodName;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName;
  }

  public String getBuyFinamt() {
    return buyFinamt;
  }

  public void setBuyFinamt(String buyFinamt) {
    this.buyFinamt = buyFinamt;
  }

  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getMonthAvgRegularBal() {
    return monthAvgRegularBal;
  }

  public void setMonthAvgRegularBal(BigDecimal monthAvgRegularBal) {
    this.monthAvgRegularBal = monthAvgRegularBal;
  }

  public BigDecimal getQuarterAvgRegularBal() {
    return quarterAvgRegularBal;
  }

  public void setQuarterAvgRegularBal(BigDecimal quarterAvgRegularBal) {
    this.quarterAvgRegularBal = quarterAvgRegularBal;
  }

  public BigDecimal getYearAvgRegularBal() {
    return yearAvgRegularBal;
  }

  public void setYearAvgRegularBal(BigDecimal yearAvgRegularBal) {
    this.yearAvgRegularBal = yearAvgRegularBal;
  }

  public BigDecimal getMonthInterestPayable() {
    return monthInterestPayable;
  }

  public void setMonthInterestPayable(BigDecimal monthInterestPayable) {
    this.monthInterestPayable = monthInterestPayable;
  }

  public BigDecimal getMonthFtpInterestReceived() {
    return monthFtpInterestReceived;
  }

  public void setMonthFtpInterestReceived(BigDecimal monthFtpInterestReceived) {
    this.monthFtpInterestReceived = monthFtpInterestReceived;
  }

  public BigDecimal getQuarterInterestPayable() {
    return quarterInterestPayable;
  }

  public void setQuarterInterestPayable(BigDecimal quarterInterestPayable) {
    this.quarterInterestPayable = quarterInterestPayable;
  }

  public BigDecimal getQuarterFtpInterestReceived() {
    return quarterFtpInterestReceived;
  }

  public void setQuarterFtpInterestReceived(BigDecimal quarterFtpInterestReceived) {
    this.quarterFtpInterestReceived = quarterFtpInterestReceived;
  }

  public BigDecimal getYearInterestPayable() {
    return yearInterestPayable;
  }

  public void setYearInterestPayable(BigDecimal yearInterestPayable) {
    this.yearInterestPayable = yearInterestPayable;
  }

  public BigDecimal getYearFtpInterestReceived() {
    return yearFtpInterestReceived;
  }

  public void setYearFtpInterestReceived(BigDecimal yearFtpInterestReceived) {
    this.yearFtpInterestReceived = yearFtpInterestReceived;
  }

  public BigDecimal getDayFtpRate() {
    return dayFtpRate;
  }

  public void setDayFtpRate(BigDecimal dayFtpRate) {
    this.dayFtpRate = dayFtpRate;
  }

  public BigDecimal getMonthAvgFtpRate() {
    return monthAvgFtpRate;
  }

  public void setMonthAvgFtpRate(BigDecimal monthAvgFtpRate) {
    this.monthAvgFtpRate = monthAvgFtpRate;
  }

  public BigDecimal getMonthSimulateIncome() {
    return monthSimulateIncome;
  }

  public void setMonthSimulateIncome(BigDecimal monthSimulateIncome) {
    this.monthSimulateIncome = monthSimulateIncome;
  }

  public BigDecimal getQuarterSimulateIncome() {
    return quarterSimulateIncome;
  }

  public void setQuarterSimulateIncome(BigDecimal quarterSimulateIncome) {
    this.quarterSimulateIncome = quarterSimulateIncome;
  }

  public BigDecimal getYearSimulateIncome() {
    return yearSimulateIncome;
  }

  public void setYearSimulateIncome(BigDecimal yearSimulateIncome) {
    this.yearSimulateIncome = yearSimulateIncome;
  }

  public String getChangeBalanceLastYear() {
    return changeBalanceLastYear;
  }

  public void setChangeBalanceLastYear(String changeBalanceLastYear) {
    this.changeBalanceLastYear = changeBalanceLastYear;
  }

  public Date getValueDate() {
    return valueDate;
  }

  public void setValueDate(Date valueDate) {
    this.valueDate = valueDate;
  }

  public Date getExpDate() {
    return expDate;
  }

  public void setExpDate(Date expDate) {
    this.expDate = expDate;
  }

  public String getExecutionEfficiency() {
    return executionEfficiency;
  }

  public void setExecutionEfficiency(String executionEfficiency) {
    this.executionEfficiency = executionEfficiency;
  }
}
