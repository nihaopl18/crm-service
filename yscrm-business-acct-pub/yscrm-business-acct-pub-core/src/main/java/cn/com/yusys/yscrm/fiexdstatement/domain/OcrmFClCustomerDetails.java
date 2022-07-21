package cn.com.yusys.yscrm.fiexdstatement.domain;


import java.math.BigDecimal;

/**
 * 客户明细表
 */
public class OcrmFClCustomerDetails {

  private String dataDate;
  private String ecifCustNo;
  private String ndsCustNo;
  private String custName;
  private String custEngName;
  private String belongBrch;
  private String manageMgr;
  private int people;
  private BigDecimal aumBalance;
  private BigDecimal depositBalance;
  private BigDecimal balanceAssetsProportion;
  private BigDecimal rate;
  private BigDecimal rateAssetsProportion;
  private BigDecimal nonrate;
  private BigDecimal nonrateAssetsProportion;
  private BigDecimal consignment;
  private BigDecimal consignmentAssetsProportion;
  private BigDecimal danaharta;
  private BigDecimal danahartaAssetsProportion;
  private BigDecimal qdii;
  private BigDecimal qdiiAssetsProportion;
  private BigDecimal rmbfund;
  private BigDecimal rmbfundAssetsProportion;
  private BigDecimal insurrance;
  private BigDecimal insurranceAssetsProportion;
  private BigDecimal ppopYtd;
  private BigDecimal ppopMtd;
  private BigDecimal wealthreapYtd;
  private BigDecimal wealthreapMtd;
  private String roa;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }

  public String getEcifCustNo() {
    return ecifCustNo;
  }

  public void setEcifCustNo(String ecifCustNo) {
    this.ecifCustNo = ecifCustNo;
  }

  public String getNdsCustNo() {
    return ndsCustNo;
  }

  public void setNdsCustNo(String ndsCustNo) {
    this.ndsCustNo = ndsCustNo;
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

  public String getBelongBrch() {
    return belongBrch;
  }

  public void setBelongBrch(String belongBrch) {
    this.belongBrch = belongBrch;
  }

  public String getManageMgr() {
    return manageMgr;
  }

  public void setManageMgr(String manageMgr) {
    this.manageMgr = manageMgr;
  }

  public int getPeople() {
    return people;
  }

  public void setPeople(int people) {
    this.people = people;
  }

  public BigDecimal getAumBalance() {
    return aumBalance;
  }

  public void setAumBalance(BigDecimal aumBalance) {
    this.aumBalance = aumBalance;
  }

  public BigDecimal getDepositBalance() {
    return depositBalance;
  }

  public void setDepositBalance(BigDecimal depositBalance) {
    this.depositBalance = depositBalance;
  }

  public BigDecimal getBalanceAssetsProportion() {
    return balanceAssetsProportion;
  }

  public void setBalanceAssetsProportion(BigDecimal balanceAssetsProportion) {
    this.balanceAssetsProportion = balanceAssetsProportion;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public BigDecimal getRateAssetsProportion() {
    return rateAssetsProportion;
  }

  public void setRateAssetsProportion(BigDecimal rateAssetsProportion) {
    this.rateAssetsProportion = rateAssetsProportion;
  }

  public BigDecimal getNonrate() {
    return nonrate;
  }

  public void setNonrate(BigDecimal nonrate) {
    this.nonrate = nonrate;
  }

  public BigDecimal getNonrateAssetsProportion() {
    return nonrateAssetsProportion;
  }

  public void setNonrateAssetsProportion(BigDecimal nonrateAssetsProportion) {
    this.nonrateAssetsProportion = nonrateAssetsProportion;
  }

  public BigDecimal getConsignment() {
    return consignment;
  }

  public void setConsignment(BigDecimal consignment) {
    this.consignment = consignment;
  }

  public BigDecimal getConsignmentAssetsProportion() {
    return consignmentAssetsProportion;
  }

  public void setConsignmentAssetsProportion(BigDecimal consignmentAssetsProportion) {
    this.consignmentAssetsProportion = consignmentAssetsProportion;
  }

  public BigDecimal getDanaharta() {
    return danaharta;
  }

  public void setDanaharta(BigDecimal danaharta) {
    this.danaharta = danaharta;
  }

  public BigDecimal getDanahartaAssetsProportion() {
    return danahartaAssetsProportion;
  }

  public void setDanahartaAssetsProportion(BigDecimal danahartaAssetsProportion) {
    this.danahartaAssetsProportion = danahartaAssetsProportion;
  }

  public BigDecimal getQdii() {
    return qdii;
  }

  public void setQdii(BigDecimal qdii) {
    this.qdii = qdii;
  }

  public BigDecimal getQdiiAssetsProportion() {
    return qdiiAssetsProportion;
  }

  public void setQdiiAssetsProportion(BigDecimal qdiiAssetsProportion) {
    this.qdiiAssetsProportion = qdiiAssetsProportion;
  }

  public BigDecimal getRmbfund() {
    return rmbfund;
  }

  public void setRmbfund(BigDecimal rmbfund) {
    this.rmbfund = rmbfund;
  }

  public BigDecimal getRmbfundAssetsProportion() {
    return rmbfundAssetsProportion;
  }

  public void setRmbfundAssetsProportion(BigDecimal rmbfundAssetsProportion) {
    this.rmbfundAssetsProportion = rmbfundAssetsProportion;
  }

  public BigDecimal getInsurrance() {
    return insurrance;
  }

  public void setInsurrance(BigDecimal insurrance) {
    this.insurrance = insurrance;
  }

  public BigDecimal getInsurranceAssetsProportion() {
    return insurranceAssetsProportion;
  }

  public void setInsurranceAssetsProportion(BigDecimal insurranceAssetsProportion) {
    this.insurranceAssetsProportion = insurranceAssetsProportion;
  }

  public BigDecimal getPpopYtd() {
    return ppopYtd;
  }

  public void setPpopYtd(BigDecimal ppopYtd) {
    this.ppopYtd = ppopYtd;
  }

  public BigDecimal getPpopMtd() {
    return ppopMtd;
  }

  public void setPpopMtd(BigDecimal ppopMtd) {
    this.ppopMtd = ppopMtd;
  }

  public BigDecimal getWealthreapYtd() {
    return wealthreapYtd;
  }

  public void setWealthreapYtd(BigDecimal wealthreapYtd) {
    this.wealthreapYtd = wealthreapYtd;
  }

  public BigDecimal getWealthreapMtd() {
    return wealthreapMtd;
  }

  public void setWealthreapMtd(BigDecimal wealthreapMtd) {
    this.wealthreapMtd = wealthreapMtd;
  }

  public String getRoa() {
    return roa;
  }

  public void setRoa(String roa) {
    this.roa = roa;
  }
}
