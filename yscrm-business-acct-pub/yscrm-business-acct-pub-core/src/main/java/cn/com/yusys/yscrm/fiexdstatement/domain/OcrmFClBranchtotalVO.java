package cn.com.yusys.yscrm.fiexdstatement.domain;


import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;

import javax.persistence.Entity;
import java.io.Serializable;


/**
 * 分行合计(管户机构合计)表
 */
@Entity
public class OcrmFClBranchtotalVO implements Serializable {

  private String dataDate;
  @ExportEntityMap(CnName="分行",EnName="branch")
  private String branch;
  @ExportEntityMap(CnName="编制",EnName="authorizedStrength")
  private String authorizedStrength;
  @ExportEntityMap(CnName="在职",EnName="onJob")
  private String onJob;
  @ExportEntityMap(CnName="有效及以上客户数",EnName="effCustnumber")
  private String effCustnumber;
  @ExportEntityMap(CnName="优慧客户数",EnName="youhuiCustnumber")
  private String youhuiCustnumber;
  @ExportEntityMap(CnName="优慧涉及民生",EnName="youhuiPeople")
  private String youhuiPeople;
  @ExportEntityMap(CnName="优慧upgrate",EnName="youhuiUpgrate")
  private String youhuiUpgrate;
  @ExportEntityMap(CnName="优慧WinBack",EnName="youhuiWinback")
  private String youhuiWinback;
  @ExportEntityMap(CnName="优慧MGM",EnName="youhuiMgm")
  private String youhuiMgm;
  @ExportEntityMap(CnName="显卓及以上客户数",EnName="xianzhuoCustnumber")
  private String xianzhuoCustnumber;
  @ExportEntityMap(CnName="显卓涉及民生",EnName="xianzhuoPeople")
  private String xianzhuoPeople;
  @ExportEntityMap(CnName="显卓upgrate",EnName="xianzhuoUpgrate")
  private String xianzhuoUpgrate;
  @ExportEntityMap(CnName="显卓WinBack",EnName="xianzhuoWinback")
  private String xianzhuoWinback;
  @ExportEntityMap(CnName="显卓MGM",EnName="xianzhuoMgm")
  private String xianzhuoMgm;
  @ExportEntityMap(CnName="[1000,10万)",EnName="aumBalanceavgTHt")
  private String aumBalanceavgTHt;
  @ExportEntityMap(CnName="[10万,50万)",EnName="aumBalanceavgHtFht")
  private String aumBalanceavgHtFht;
  @ExportEntityMap(CnName="[50万,300万)",EnName="aumBalanceavgFhtTm")
  private String aumBalanceavgFhtTm;
  @ExportEntityMap(CnName="[300万,600万)",EnName="aumBalanceavgTmSm")
  private String aumBalanceavgTmSm;
  @ExportEntityMap(CnName="600万以上",EnName="aumBalanceavgSmEndless")
  private String aumBalanceavgSmEndless;
  @ExportEntityMap(CnName="AUM余额",EnName="aumBalance")
  private String aumBalance;
  @ExportEntityMap(CnName="AUM余额(剔除MS)",EnName="aumBalanceDel")
  private String aumBalanceDel;
  @ExportEntityMap(CnName="存款",EnName="aumDeposit")
  private String aumDeposit;
  @ExportEntityMap(CnName="存款排名",EnName="aumDepositSort")
  private String aumDepositSort;
  @ExportEntityMap(CnName="存款(剔除MS)",EnName="aumDepositDel")
  private String aumDepositDel;
  @ExportEntityMap(CnName="存款剔除MS排名",EnName="aumDepositDelSort")
  private String aumDepositDelSort;
  @ExportEntityMap(CnName="汇率",EnName="aumRate")
  private String aumRate;
  @ExportEntityMap(CnName="汇率排名",EnName="aumRateSort")
  private String aumRateSort;
  @ExportEntityMap(CnName="汇率(剔除MS)",EnName="aumRateDel")
  private String aumRateDel;
  @ExportEntityMap(CnName="汇率剔除MS排名",EnName="aumRateDelSort")
  private String aumRateDelSort;
  @ExportEntityMap(CnName="非汇",EnName="aumNonrate")
  private String aumNonrate;
  @ExportEntityMap(CnName="非汇排名",EnName="aumNonrateSort")
  private String aumNonrateSort;
  @ExportEntityMap(CnName="非汇(剔除MS)",EnName="aumNonrateDel")
  private String aumNonrateDel;
  @ExportEntityMap(CnName="非汇剔除MS排名",EnName="aumNonrateDelSort")
  private String aumNonrateDelSort;
  @ExportEntityMap(CnName="代销信托",EnName="consignment")
  private String consignment;
  @ExportEntityMap(CnName="代销信托排名",EnName="consignmentSort")
  private String consignmentSort;
  @ExportEntityMap(CnName="代销信托(剔除MS)",EnName="consignmentDel")
  private String consignmentDel;
  @ExportEntityMap(CnName="代销信托剔除MS排名",EnName="consignmentDelSort")
  private String consignmentDelSort;
  @ExportEntityMap(CnName="资管",EnName="danaharta")
  private String danaharta;
  @ExportEntityMap(CnName="资管排名",EnName="danahartaSort")
  private String danahartaSort;
  @ExportEntityMap(CnName="资管(剔除MS)",EnName="danahartaDel")
  private String danahartaDel;
  @ExportEntityMap(CnName="资管剔除MS排名",EnName="danahartaDelSort")
  private String danahartaDelSort;
  @ExportEntityMap(CnName="QDII",EnName="qdii")
  private String qdii;
  @ExportEntityMap(CnName="QDII排名",EnName="qdiiSort")
  private String qdiiSort;
  @ExportEntityMap(CnName="QDII(剔除MS)",EnName="qdiiDel")
  private String qdiiDel;
  @ExportEntityMap(CnName="QDII(剔除MS)排名",EnName="qdiiDelSort")
  private String qdiiDelSort;
  @ExportEntityMap(CnName="人民币基金",EnName="rmbfund")
  private String rmbfund;
  @ExportEntityMap(CnName="人民币基金排名",EnName="rmbfundSort")
  private String rmbfundSort;
  @ExportEntityMap(CnName="人民币基金(剔除MS)",EnName="rmbfundDel")
  private String rmbfundDel;
  @ExportEntityMap(CnName="人民币基金剔除MS排名",EnName="rmbfundDelSort")
  private String rmbfundDelSort;
  @ExportEntityMap(CnName="保险",EnName="insurrance")
  private String insurrance;
  @ExportEntityMap(CnName="保险排名",EnName="insurranceSort")
  private String insurranceSort;
  @ExportEntityMap(CnName="保险(剔除MS)",EnName="insurranceDel")
  private String insurranceDel;
  @ExportEntityMap(CnName="保险(剔除MS)排名",EnName="insurranceDelSort")
  private String insurranceDelSort;
  @ExportEntityMap(CnName="PPOP",EnName="ppop")
  private String ppop;
  @ExportEntityMap(CnName="财富中收",EnName="wealthreap")
  private String wealthreap;
  @ExportEntityMap(CnName="ROA",EnName="roa")
  private String roa;
  @ExportEntityMap(CnName="财富中收(剔除MS)",EnName="wealthreapDel")
  private String wealthreapDel;
  @ExportEntityMap(CnName="ROA(剔除MS)",EnName="roaDel")
  private String roaDel;


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

  public String getAuthorizedStrength() {
    return authorizedStrength;
  }

  public void setAuthorizedStrength(String authorizedStrength) {
    this.authorizedStrength = authorizedStrength;
  }

  public String getOnJob() {
    return onJob;
  }

  public void setOnJob(String onJob) {
    this.onJob = onJob;
  }

  public String getEffCustnumber() {
    return effCustnumber;
  }

  public void setEffCustnumber(String effCustnumber) {
    this.effCustnumber = effCustnumber;
  }

  public String getYouhuiCustnumber() {
    return youhuiCustnumber;
  }

  public void setYouhuiCustnumber(String youhuiCustnumber) {
    this.youhuiCustnumber = youhuiCustnumber;
  }

  public String getYouhuiPeople() {
    return youhuiPeople;
  }

  public void setYouhuiPeople(String youhuiPeople) {
    this.youhuiPeople = youhuiPeople;
  }

  public String getYouhuiUpgrate() {
    return youhuiUpgrate;
  }

  public void setYouhuiUpgrate(String youhuiUpgrate) {
    this.youhuiUpgrate = youhuiUpgrate;
  }

  public String getYouhuiWinback() {
    return youhuiWinback;
  }

  public void setYouhuiWinback(String youhuiWinback) {
    this.youhuiWinback = youhuiWinback;
  }

  public String getYouhuiMgm() {
    return youhuiMgm;
  }

  public void setYouhuiMgm(String youhuiMgm) {
    this.youhuiMgm = youhuiMgm;
  }

  public String getXianzhuoCustnumber() {
    return xianzhuoCustnumber;
  }

  public void setXianzhuoCustnumber(String xianzhuoCustnumber) {
    this.xianzhuoCustnumber = xianzhuoCustnumber;
  }

  public String getXianzhuoPeople() {
    return xianzhuoPeople;
  }

  public void setXianzhuoPeople(String xianzhuoPeople) {
    this.xianzhuoPeople = xianzhuoPeople;
  }

  public String getXianzhuoUpgrate() {
    return xianzhuoUpgrate;
  }

  public void setXianzhuoUpgrate(String xianzhuoUpgrate) {
    this.xianzhuoUpgrate = xianzhuoUpgrate;
  }

  public String getXianzhuoWinback() {
    return xianzhuoWinback;
  }

  public void setXianzhuoWinback(String xianzhuoWinback) {
    this.xianzhuoWinback = xianzhuoWinback;
  }

  public String getXianzhuoMgm() {
    return xianzhuoMgm;
  }

  public void setXianzhuoMgm(String xianzhuoMgm) {
    this.xianzhuoMgm = xianzhuoMgm;
  }

  public String getAumBalanceavgTHt() {
    return aumBalanceavgTHt;
  }

  public void setAumBalanceavgTHt(String aumBalanceavgTHt) {
    this.aumBalanceavgTHt = aumBalanceavgTHt;
  }

  public String getAumBalanceavgHtFht() {
    return aumBalanceavgHtFht;
  }

  public void setAumBalanceavgHtFht(String aumBalanceavgHtFht) {
    this.aumBalanceavgHtFht = aumBalanceavgHtFht;
  }

  public String getAumBalanceavgFhtTm() {
    return aumBalanceavgFhtTm;
  }

  public void setAumBalanceavgFhtTm(String aumBalanceavgFhtTm) {
    this.aumBalanceavgFhtTm = aumBalanceavgFhtTm;
  }

  public String getAumBalanceavgTmSm() {
    return aumBalanceavgTmSm;
  }

  public void setAumBalanceavgTmSm(String aumBalanceavgTmSm) {
    this.aumBalanceavgTmSm = aumBalanceavgTmSm;
  }

  public String getAumBalanceavgSmEndless() {
    return aumBalanceavgSmEndless;
  }

  public void setAumBalanceavgSmEndless(String aumBalanceavgSmEndless) {
    this.aumBalanceavgSmEndless = aumBalanceavgSmEndless;
  }

  public String getAumBalance() {
    return aumBalance;
  }

  public void setAumBalance(String aumBalance) {
    this.aumBalance = aumBalance;
  }

  public String getAumBalanceDel() {
    return aumBalanceDel;
  }

  public void setAumBalanceDel(String aumBalanceDel) {
    this.aumBalanceDel = aumBalanceDel;
  }

  public String getAumDeposit() {
    return aumDeposit;
  }

  public void setAumDeposit(String aumDeposit) {
    this.aumDeposit = aumDeposit;
  }

  public String getAumDepositSort() {
    return aumDepositSort;
  }

  public void setAumDepositSort(String aumDepositSort) {
    this.aumDepositSort = aumDepositSort;
  }

  public String getAumDepositDel() {
    return aumDepositDel;
  }

  public void setAumDepositDel(String aumDepositDel) {
    this.aumDepositDel = aumDepositDel;
  }

  public String getAumDepositDelSort() {
    return aumDepositDelSort;
  }

  public void setAumDepositDelSort(String aumDepositDelSort) {
    this.aumDepositDelSort = aumDepositDelSort;
  }

  public String getAumRate() {
    return aumRate;
  }

  public void setAumRate(String aumRate) {
    this.aumRate = aumRate;
  }

  public String getAumRateSort() {
    return aumRateSort;
  }

  public void setAumRateSort(String aumRateSort) {
    this.aumRateSort = aumRateSort;
  }

  public String getAumRateDel() {
    return aumRateDel;
  }

  public void setAumRateDel(String aumRateDel) {
    this.aumRateDel = aumRateDel;
  }

  public String getAumRateDelSort() {
    return aumRateDelSort;
  }

  public void setAumRateDelSort(String aumRateDelSort) {
    this.aumRateDelSort = aumRateDelSort;
  }

  public String getAumNonrate() {
    return aumNonrate;
  }

  public void setAumNonrate(String aumNonrate) {
    this.aumNonrate = aumNonrate;
  }

  public String getAumNonrateSort() {
    return aumNonrateSort;
  }

  public void setAumNonrateSort(String aumNonrateSort) {
    this.aumNonrateSort = aumNonrateSort;
  }

  public String getAumNonrateDel() {
    return aumNonrateDel;
  }

  public void setAumNonrateDel(String aumNonrateDel) {
    this.aumNonrateDel = aumNonrateDel;
  }

  public String getAumNonrateDelSort() {
    return aumNonrateDelSort;
  }

  public void setAumNonrateDelSort(String aumNonrateDelSort) {
    this.aumNonrateDelSort = aumNonrateDelSort;
  }

  public String getConsignment() {
    return consignment;
  }

  public void setConsignment(String consignment) {
    this.consignment = consignment;
  }

  public String getConsignmentSort() {
    return consignmentSort;
  }

  public void setConsignmentSort(String consignmentSort) {
    this.consignmentSort = consignmentSort;
  }

  public String getConsignmentDel() {
    return consignmentDel;
  }

  public void setConsignmentDel(String consignmentDel) {
    this.consignmentDel = consignmentDel;
  }

  public String getConsignmentDelSort() {
    return consignmentDelSort;
  }

  public void setConsignmentDelSort(String consignmentDelSort) {
    this.consignmentDelSort = consignmentDelSort;
  }

  public String getDanaharta() {
    return danaharta;
  }

  public void setDanaharta(String danaharta) {
    this.danaharta = danaharta;
  }

  public String getDanahartaSort() {
    return danahartaSort;
  }

  public void setDanahartaSort(String danahartaSort) {
    this.danahartaSort = danahartaSort;
  }

  public String getDanahartaDel() {
    return danahartaDel;
  }

  public void setDanahartaDel(String danahartaDel) {
    this.danahartaDel = danahartaDel;
  }

  public String getDanahartaDelSort() {
    return danahartaDelSort;
  }

  public void setDanahartaDelSort(String danahartaDelSort) {
    this.danahartaDelSort = danahartaDelSort;
  }

  public String getQdii() {
    return qdii;
  }

  public void setQdii(String qdii) {
    this.qdii = qdii;
  }

  public String getQdiiSort() {
    return qdiiSort;
  }

  public void setQdiiSort(String qdiiSort) {
    this.qdiiSort = qdiiSort;
  }

  public String getQdiiDel() {
    return qdiiDel;
  }

  public void setQdiiDel(String qdiiDel) {
    this.qdiiDel = qdiiDel;
  }

  public String getQdiiDelSort() {
    return qdiiDelSort;
  }

  public void setQdiiDelSort(String qdiiDelSort) {
    this.qdiiDelSort = qdiiDelSort;
  }

  public String getRmbfund() {
    return rmbfund;
  }

  public void setRmbfund(String rmbfund) {
    this.rmbfund = rmbfund;
  }

  public String getRmbfundSort() {
    return rmbfundSort;
  }

  public void setRmbfundSort(String rmbfundSort) {
    this.rmbfundSort = rmbfundSort;
  }

  public String getRmbfundDel() {
    return rmbfundDel;
  }

  public void setRmbfundDel(String rmbfundDel) {
    this.rmbfundDel = rmbfundDel;
  }

  public String getRmbfundDelSort() {
    return rmbfundDelSort;
  }

  public void setRmbfundDelSort(String rmbfundDelSort) {
    this.rmbfundDelSort = rmbfundDelSort;
  }

  public String getInsurrance() {
    return insurrance;
  }

  public void setInsurrance(String insurrance) {
    this.insurrance = insurrance;
  }

  public String getInsurranceSort() {
    return insurranceSort;
  }

  public void setInsurranceSort(String insurranceSort) {
    this.insurranceSort = insurranceSort;
  }

  public String getInsurranceDel() {
    return insurranceDel;
  }

  public void setInsurranceDel(String insurranceDel) {
    this.insurranceDel = insurranceDel;
  }

  public String getInsurranceDelSort() {
    return insurranceDelSort;
  }

  public void setInsurranceDelSort(String insurranceDelSort) {
    this.insurranceDelSort = insurranceDelSort;
  }

  public String getPpop() {
    return ppop;
  }

  public void setPpop(String ppop) {
    this.ppop = ppop;
  }

  public String getWealthreap() {
    return wealthreap;
  }

  public void setWealthreap(String wealthreap) {
    this.wealthreap = wealthreap;
  }

  public String getRoa() {
    return roa;
  }

  public void setRoa(String roa) {
    this.roa = roa;
  }

  public String getWealthreapDel() {
    return wealthreapDel;
  }

  public void setWealthreapDel(String wealthreapDel) {
    this.wealthreapDel = wealthreapDel;
  }

  public String getRoaDel() {
    return roaDel;
  }

  public void setRoaDel(String roaDel) {
    this.roaDel = roaDel;
  }
}
