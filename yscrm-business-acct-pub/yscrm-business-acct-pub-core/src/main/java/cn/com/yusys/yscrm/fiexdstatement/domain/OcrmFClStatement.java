package cn.com.yusys.yscrm.fiexdstatement.domain;


import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 *RM明细报表
 */
@Entity
public class OcrmFClStatement {

  private String dataDate;
  @ExportEntityMap(CnName="RM",EnName="rm")
  private String rm;
  @ExportEntityMap(CnName="岗位",EnName="job")
  private String job;
  @ExportEntityMap(CnName="入职年限",EnName="employeeYears")
  private BigDecimal employeeYears;
  @ExportEntityMap(CnName="职级",EnName="rank")
  private String rank;
  @ExportEntityMap(CnName="工号",EnName="userId")
  private String userId;
  @ExportEntityMap(CnName="主管",EnName="superintend")
  private String superintend;
  @ExportEntityMap(CnName="主管编号",EnName="superintendNo")
  private String superintendNo;
  @ExportEntityMap(CnName="分行",EnName="branch")
  private String branch;
  @ExportEntityMap(CnName="分行编号",EnName="branchNo")
  private String branchNo;
  @ExportEntityMap(CnName="有效及以上客户数",EnName="effCustnumber")
  private int effCustnumber;
  @ExportEntityMap(CnName="优慧客户数",EnName="youhuiCustnumber")
  private int youhuiCustnumber;
  @ExportEntityMap(CnName="优慧涉及民生",EnName="youhuiPeople")
  private int youhuiPeople;
  @ExportEntityMap(CnName="优慧upgrate",EnName="youhuiUpgrate")
  private int youhuiUpgrate;
  @ExportEntityMap(CnName="优慧WinBack",EnName="youhuiWinback")
  private int youhuiWinback;
  @ExportEntityMap(CnName="优慧MGM",EnName="youhuiMgm")
  private int youhuiMgm;
  @ExportEntityMap(CnName="显卓及以上客户数",EnName="xianzhuoCustnumber")
  private int xianzhuoCustnumber;
  @ExportEntityMap(CnName="显卓涉及民生",EnName="xianzhuoPeople")
  private int xianzhuoPeople;
  @ExportEntityMap(CnName="显卓upgrate",EnName="xianzhuoUpgrate")
  private int xianzhuoUpgrate;
  @ExportEntityMap(CnName="显卓WinBack",EnName="xianzhuoWinback")
  private int xianzhuoWinback;
  @ExportEntityMap(CnName="显卓MGM",EnName="xianzhuoMgm")
  private int xianzhuoMgm;
  @ExportEntityMap(CnName="[1000,10万)",EnName="aumBalanceavgTHt")
  private BigDecimal aumBalanceavgTHt;
  @ExportEntityMap(CnName="[10万,50万)",EnName="aumBalanceavgHtFht")
  private BigDecimal aumBalanceavgHtFht;
  @ExportEntityMap(CnName="[50万,300万)",EnName="aumBalanceavgFhtTm")
  private BigDecimal aumBalanceavgFhtTm;
  @ExportEntityMap(CnName="[300万,600万)",EnName="aumBalanceavgTmSm")
  private BigDecimal aumBalanceavgTmSm;
  @ExportEntityMap(CnName="600万以上",EnName="aumBalanceavgSmEndless")
  private BigDecimal aumBalanceavgSmEndless;
  @ExportEntityMap(CnName="AUM余额",EnName="aumBalance")
  private BigDecimal aumBalance;
  @ExportEntityMap(CnName="AUM余额(剔除MS)",EnName="aumBalanceDel")
  private BigDecimal aumBalanceDel;
  @ExportEntityMap(CnName="存款",EnName="aumDeposit")
  private BigDecimal aumDeposit;
  @ExportEntityMap(CnName="存款排名",EnName="aumDepositSort")
  private int aumDepositSort;
  @ExportEntityMap(CnName="存款(剔除MS)",EnName="aumDepositDel")
  private BigDecimal aumDepositDel;
  @ExportEntityMap(CnName="存款(剔除MS)排名",EnName="aumDepositDelSort")
  private int aumDepositDelSort;
  @ExportEntityMap(CnName="汇率",EnName="aumRate")
  private BigDecimal aumRate;
  @ExportEntityMap(CnName="汇率排名",EnName="aumRateSort")
  private int aumRateSort;
  @ExportEntityMap(CnName="汇率(剔除MS)",EnName="aumRateDel")
  private BigDecimal aumRateDel;
  @ExportEntityMap(CnName="汇率(剔除MS)排名",EnName="aumRateDelSort")
  private int aumRateDelSort;
  @ExportEntityMap(CnName="非汇",EnName="aumNonrate")
  private BigDecimal aumNonrate;
  @ExportEntityMap(CnName="非汇排名",EnName="aumNonrateSort")
  private int aumNonrateSort;
  @ExportEntityMap(CnName="非汇(剔除MS)",EnName="aumNonrateDel")
  private BigDecimal aumNonrateDel;
  @ExportEntityMap(CnName="非汇(剔除MS)排名",EnName="aumNonrateDelSort")
  private int aumNonrateDelSort;
  @ExportEntityMap(CnName="代销信托",EnName="consignment")
  private BigDecimal consignment;
  @ExportEntityMap(CnName="代销信托排名",EnName="consignmentSort")
  private int consignmentSort;
  @ExportEntityMap(CnName="代销信托(剔除MS)",EnName="consignmentDel")
  private BigDecimal consignmentDel;
  @ExportEntityMap(CnName="代销信托(剔除MS)排名",EnName="consignmentDelSort")
  private int consignmentDelSort;
  @ExportEntityMap(CnName="资管",EnName="danaharta")
  private BigDecimal danaharta;
  @ExportEntityMap(CnName="资管排名",EnName="danahartaSort")
  private int danahartaSort;
  @ExportEntityMap(CnName="资管(剔除MS)",EnName="danahartaDel")
  private BigDecimal danahartaDel;
  @ExportEntityMap(CnName="资管(剔除MS)排名",EnName="danahartaDelSort")
  private int danahartaDelSort;
  @ExportEntityMap(CnName="QDII",EnName="qdii")
  private BigDecimal qdii;
  @ExportEntityMap(CnName="QDII排名",EnName="qdiiSort")
  private int qdiiSort;
  @ExportEntityMap(CnName="QDII(剔除MS)",EnName="qdiiDel")
  private BigDecimal qdiiDel;
  @ExportEntityMap(CnName="QDII(剔除MS)排名",EnName="qdiiDelSort")
  private int qdiiDelSort;
  @ExportEntityMap(CnName="人民币基金",EnName="rmbfund")
  private BigDecimal rmbfund;
  @ExportEntityMap(CnName="人民币基金排名",EnName="rmbfundSort")
  private int rmbfundSort;
  @ExportEntityMap(CnName="人民币基金(剔除MS)",EnName="rmbfundDel")
  private BigDecimal rmbfundDel;
  @ExportEntityMap(CnName="人民币基金(剔除MS)排名",EnName="rmbfundDelSort")
  private int rmbfundDelSort;
  @ExportEntityMap(CnName="保险",EnName="insurrance")
  private BigDecimal insurrance;
  @ExportEntityMap(CnName="保险排名",EnName="insurranceSort")
  private int insurranceSort;
  @ExportEntityMap(CnName="保险(剔除MS)",EnName="insurranceDel")
  private BigDecimal insurranceDel;
  @ExportEntityMap(CnName="保险(剔除MS)排名",EnName="insurranceDelSort")
  private int insurranceDelSort;
  @ExportEntityMap(CnName="PPOP",EnName="ppop")
  private BigDecimal ppop;
  @ExportEntityMap(CnName="财富中收",EnName="wealthreap")
  private BigDecimal wealthreap;
  @ExportEntityMap(CnName="ROA",EnName="roa")
  private String roa;
  @ExportEntityMap(CnName="财富中收(剔除MS)",EnName="wealthreapDel")
  private BigDecimal wealthreapDel;
  @ExportEntityMap(CnName="ROA(剔除MS)",EnName="roaDel")
  private String roaDel;



  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }

  public String getRm() {
    return rm;
  }

  public void setRm(String rm) {
    this.rm = rm;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public BigDecimal getEmployeeYears() {
    return employeeYears;
  }

  public void setEmployeeYears(BigDecimal employeeYears) {
    this.employeeYears = employeeYears;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getSuperintend() {
    return superintend;
  }

  public void setSuperintend(String superintend) {
    this.superintend = superintend;
  }

  public String getSuperintendNo() {
    return superintendNo;
  }

  public void setSuperintendNo(String superintendNo) {
    this.superintendNo = superintendNo;
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

  public int getEffCustnumber() {
    return effCustnumber;
  }

  public void setEffCustnumber(int effCustnumber) {
    this.effCustnumber = effCustnumber;
  }

  public int getYouhuiCustnumber() {
    return youhuiCustnumber;
  }

  public void setYouhuiCustnumber(int youhuiCustnumber) {
    this.youhuiCustnumber = youhuiCustnumber;
  }

  public int getYouhuiPeople() {
    return youhuiPeople;
  }

  public void setYouhuiPeople(int youhuiPeople) {
    this.youhuiPeople = youhuiPeople;
  }

  public int getYouhuiUpgrate() {
    return youhuiUpgrate;
  }

  public void setYouhuiUpgrate(int youhuiUpgrate) {
    this.youhuiUpgrate = youhuiUpgrate;
  }

  public int getYouhuiWinback() {
    return youhuiWinback;
  }

  public void setYouhuiWinback(int youhuiWinback) {
    this.youhuiWinback = youhuiWinback;
  }

  public int getYouhuiMgm() {
    return youhuiMgm;
  }

  public void setYouhuiMgm(int youhuiMgm) {
    this.youhuiMgm = youhuiMgm;
  }

  public int getXianzhuoCustnumber() {
    return xianzhuoCustnumber;
  }

  public void setXianzhuoCustnumber(int xianzhuoCustnumber) {
    this.xianzhuoCustnumber = xianzhuoCustnumber;
  }

  public int getXianzhuoPeople() {
    return xianzhuoPeople;
  }

  public void setXianzhuoPeople(int xianzhuoPeople) {
    this.xianzhuoPeople = xianzhuoPeople;
  }

  public int getXianzhuoUpgrate() {
    return xianzhuoUpgrate;
  }

  public void setXianzhuoUpgrate(int xianzhuoUpgrate) {
    this.xianzhuoUpgrate = xianzhuoUpgrate;
  }

  public int getXianzhuoWinback() {
    return xianzhuoWinback;
  }

  public void setXianzhuoWinback(int xianzhuoWinback) {
    this.xianzhuoWinback = xianzhuoWinback;
  }

  public int getXianzhuoMgm() {
    return xianzhuoMgm;
  }

  public void setXianzhuoMgm(int xianzhuoMgm) {
    this.xianzhuoMgm = xianzhuoMgm;
  }

  public BigDecimal getAumBalanceavgTHt() {
    return aumBalanceavgTHt;
  }

  public void setAumBalanceavgTHt(BigDecimal aumBalanceavgTHt) {
    this.aumBalanceavgTHt = aumBalanceavgTHt;
  }

  public BigDecimal getAumBalanceavgHtFht() {
    return aumBalanceavgHtFht;
  }

  public void setAumBalanceavgHtFht(BigDecimal aumBalanceavgHtFht) {
    this.aumBalanceavgHtFht = aumBalanceavgHtFht;
  }

  public BigDecimal getAumBalanceavgFhtTm() {
    return aumBalanceavgFhtTm;
  }

  public void setAumBalanceavgFhtTm(BigDecimal aumBalanceavgFhtTm) {
    this.aumBalanceavgFhtTm = aumBalanceavgFhtTm;
  }

  public BigDecimal getAumBalanceavgTmSm() {
    return aumBalanceavgTmSm;
  }

  public void setAumBalanceavgTmSm(BigDecimal aumBalanceavgTmSm) {
    this.aumBalanceavgTmSm = aumBalanceavgTmSm;
  }

  public BigDecimal getAumBalanceavgSmEndless() {
    return aumBalanceavgSmEndless;
  }

  public void setAumBalanceavgSmEndless(BigDecimal aumBalanceavgSmEndless) {
    this.aumBalanceavgSmEndless = aumBalanceavgSmEndless;
  }

  public BigDecimal getAumBalance() {
    return aumBalance;
  }

  public void setAumBalance(BigDecimal aumBalance) {
    this.aumBalance = aumBalance;
  }

  public BigDecimal getAumBalanceDel() {
    return aumBalanceDel;
  }

  public void setAumBalanceDel(BigDecimal aumBalanceDel) {
    this.aumBalanceDel = aumBalanceDel;
  }

  public BigDecimal getAumDeposit() {
    return aumDeposit;
  }

  public void setAumDeposit(BigDecimal aumDeposit) {
    this.aumDeposit = aumDeposit;
  }

  public int getAumDepositSort() {
    return aumDepositSort;
  }

  public void setAumDepositSort(int aumDepositSort) {
    this.aumDepositSort = aumDepositSort;
  }

  public BigDecimal getAumDepositDel() {
    return aumDepositDel;
  }

  public void setAumDepositDel(BigDecimal aumDepositDel) {
    this.aumDepositDel = aumDepositDel;
  }

  public int getAumDepositDelSort() {
    return aumDepositDelSort;
  }

  public void setAumDepositDelSort(int aumDepositDelSort) {
    this.aumDepositDelSort = aumDepositDelSort;
  }

  public BigDecimal getAumRate() {
    return aumRate;
  }

  public void setAumRate(BigDecimal aumRate) {
    this.aumRate = aumRate;
  }

  public int getAumRateSort() {
    return aumRateSort;
  }

  public void setAumRateSort(int aumRateSort) {
    this.aumRateSort = aumRateSort;
  }

  public BigDecimal getAumRateDel() {
    return aumRateDel;
  }

  public void setAumRateDel(BigDecimal aumRateDel) {
    this.aumRateDel = aumRateDel;
  }

  public int getAumRateDelSort() {
    return aumRateDelSort;
  }

  public void setAumRateDelSort(int aumRateDelSort) {
    this.aumRateDelSort = aumRateDelSort;
  }

  public BigDecimal getAumNonrate() {
    return aumNonrate;
  }

  public void setAumNonrate(BigDecimal aumNonrate) {
    this.aumNonrate = aumNonrate;
  }

  public int getAumNonrateSort() {
    return aumNonrateSort;
  }

  public void setAumNonrateSort(int aumNonrateSort) {
    this.aumNonrateSort = aumNonrateSort;
  }

  public BigDecimal getAumNonrateDel() {
    return aumNonrateDel;
  }

  public void setAumNonrateDel(BigDecimal aumNonrateDel) {
    this.aumNonrateDel = aumNonrateDel;
  }

  public int getAumNonrateDelSort() {
    return aumNonrateDelSort;
  }

  public void setAumNonrateDelSort(int aumNonrateDelSort) {
    this.aumNonrateDelSort = aumNonrateDelSort;
  }

  public BigDecimal getConsignment() {
    return consignment;
  }

  public void setConsignment(BigDecimal consignment) {
    this.consignment = consignment;
  }

  public int getConsignmentSort() {
    return consignmentSort;
  }

  public void setConsignmentSort(int consignmentSort) {
    this.consignmentSort = consignmentSort;
  }

  public BigDecimal getConsignmentDel() {
    return consignmentDel;
  }

  public void setConsignmentDel(BigDecimal consignmentDel) {
    this.consignmentDel = consignmentDel;
  }

  public int getConsignmentDelSort() {
    return consignmentDelSort;
  }

  public void setConsignmentDelSort(int consignmentDelSort) {
    this.consignmentDelSort = consignmentDelSort;
  }

  public BigDecimal getDanaharta() {
    return danaharta;
  }

  public void setDanaharta(BigDecimal danaharta) {
    this.danaharta = danaharta;
  }

  public int getDanahartaSort() {
    return danahartaSort;
  }

  public void setDanahartaSort(int danahartaSort) {
    this.danahartaSort = danahartaSort;
  }

  public BigDecimal getDanahartaDel() {
    return danahartaDel;
  }

  public void setDanahartaDel(BigDecimal danahartaDel) {
    this.danahartaDel = danahartaDel;
  }

  public int getDanahartaDelSort() {
    return danahartaDelSort;
  }

  public void setDanahartaDelSort(int danahartaDelSort) {
    this.danahartaDelSort = danahartaDelSort;
  }

  public BigDecimal getQdii() {
    return qdii;
  }

  public void setQdii(BigDecimal qdii) {
    this.qdii = qdii;
  }

  public int getQdiiSort() {
    return qdiiSort;
  }

  public void setQdiiSort(int qdiiSort) {
    this.qdiiSort = qdiiSort;
  }

  public BigDecimal getQdiiDel() {
    return qdiiDel;
  }

  public void setQdiiDel(BigDecimal qdiiDel) {
    this.qdiiDel = qdiiDel;
  }

  public int getQdiiDelSort() {
    return qdiiDelSort;
  }

  public void setQdiiDelSort(int qdiiDelSort) {
    this.qdiiDelSort = qdiiDelSort;
  }

  public BigDecimal getRmbfund() {
    return rmbfund;
  }

  public void setRmbfund(BigDecimal rmbfund) {
    this.rmbfund = rmbfund;
  }

  public int getRmbfundSort() {
    return rmbfundSort;
  }

  public void setRmbfundSort(int rmbfundSort) {
    this.rmbfundSort = rmbfundSort;
  }

  public BigDecimal getRmbfundDel() {
    return rmbfundDel;
  }

  public void setRmbfundDel(BigDecimal rmbfundDel) {
    this.rmbfundDel = rmbfundDel;
  }

  public int getRmbfundDelSort() {
    return rmbfundDelSort;
  }

  public void setRmbfundDelSort(int rmbfundDelSort) {
    this.rmbfundDelSort = rmbfundDelSort;
  }

  public BigDecimal getInsurrance() {
    return insurrance;
  }

  public void setInsurrance(BigDecimal insurrance) {
    this.insurrance = insurrance;
  }

  public int getInsurranceSort() {
    return insurranceSort;
  }

  public void setInsurranceSort(int insurranceSort) {
    this.insurranceSort = insurranceSort;
  }

  public BigDecimal getInsurranceDel() {
    return insurranceDel;
  }

  public void setInsurranceDel(BigDecimal insurranceDel) {
    this.insurranceDel = insurranceDel;
  }

  public int getInsurranceDelSort() {
    return insurranceDelSort;
  }

  public void setInsurranceDelSort(int insurranceDelSort) {
    this.insurranceDelSort = insurranceDelSort;
  }

  public BigDecimal getPpop() {
    return ppop;
  }

  public void setPpop(BigDecimal ppop) {
    this.ppop = ppop;
  }

  public BigDecimal getWealthreap() {
    return wealthreap;
  }

  public void setWealthreap(BigDecimal wealthreap) {
    this.wealthreap = wealthreap;
  }

  public String getRoa() {
    return roa;
  }

  public void setRoa(String roa) {
    this.roa = roa;
  }

  public BigDecimal getWealthreapDel() {
    return wealthreapDel;
  }

  public void setWealthreapDel(BigDecimal wealthreapDel) {
    this.wealthreapDel = wealthreapDel;
  }

  public String getRoaDel() {
    return roaDel;
  }

  public void setRoaDel(String roaDel) {
    this.roaDel = roaDel;
  }
}
