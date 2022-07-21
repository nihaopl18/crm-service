package cn.com.yusys.yscrm.fiexdstatement.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class BranchSalesVo implements Serializable {
    private String dataDate;
    @ExportEntityMap(CnName="分行",EnName="branch")
    private String branch;
    @ExportEntityMap(CnName="编制",EnName="authorizedStrength")
    private int authorizedStrength;
    @ExportEntityMap(CnName="在职",EnName="onJob")
    private int onJob;
    @ExportEntityMap(CnName="岗位",EnName="job")
    private String job;
    @ExportEntityMap(CnName="RM",EnName="rm")
    private String rm;
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
    @ExportEntityMap(CnName="ECIF客户号",EnName="ecifCustNo")
    private String ecifCustNo;
    @ExportEntityMap(CnName="NDS客户号",EnName="ndsCustNo")
    private String ndsCustNo;
    @ExportEntityMap(CnName="客户中文名称",EnName="custName")
    private String custName;
    @ExportEntityMap(CnName="客户英文名称",EnName="custEngName")
    private String custEngName;
    @ExportEntityMap(CnName="主办机构编号",EnName="belongBrchNO")
    private String belongBrchNO;
    @ExportEntityMap(CnName="主办机构名称",EnName="belongBrch")
    private String belongBrch;
    @ExportEntityMap(CnName="理财客户经理编号",EnName="manageMgrNo")
    private String manageMgrNo;
    @ExportEntityMap(CnName="理财客户经理名称",EnName="manageMgr")
    private String manageMgr;
    @ExportEntityMap(CnName="涉及民生",EnName="people")
    private int people;

    private int effCustnumber;
    private int effCustnumberPeople;
    private int youhuiCustnumber;
    private int youhuiPeople;
    private int youhuiUpgrate;
    private int youhuiUpgratePeople;
    private int youhuiWinback;
    private int youhuiWinbackPeople;
    private int xianzhuoCustnumber;
    private int xianzhuoPeople;
    private int xianzhuoUpgrate;
    private int xianzhuoUpgratePeople;
    private int xianzhuoWinback;
    private int xianzhuoWinbackPeople;
    private BigDecimal aumBalanceavgTHt;
    private BigDecimal aumBalanceavgTHtPeople;
    private BigDecimal aumBalanceavgHtFht;
    private BigDecimal aumBalanceavgHtFhtPeople;
    private BigDecimal aumBalanceavgFhtTm;
    private BigDecimal aumBalanceavgFhtTmPeople;
    private BigDecimal aumBalanceavgTmSm;
    private BigDecimal aumBalanceavgTmSmPeople;
    private BigDecimal aumBalanceavgSmEndless;
    private BigDecimal aumBalanceavgSmEndlessPeople;
    private BigDecimal aumBalance;
    private BigDecimal aumBalanceDel;
    private BigDecimal aumDeposit;
    private int aumDepositSort;
    private BigDecimal aumDepositDel;
    private int aumDepositDelSort;
    private BigDecimal aumRate;
    private int aumRateSort;
    private BigDecimal aumRateDel;
    private int aumRateDelSort;
    private BigDecimal aumNonrate;
    private int aumNonrateSort;
    private BigDecimal aumNonrateDel;
    private int aumNonrateDelSort;
    private BigDecimal consignment;
    private int consignmentSort;
    private BigDecimal consignmentDel;
    private int consignmentDelSort;
    private BigDecimal danaharta;
    private int danahartaSort;
    private BigDecimal danahartaDel;
    private int danahartaDelSort;
    private BigDecimal qdii;
    private int qdiiSort;
    private BigDecimal qdiiDel;
    private int qdiiDelSort;
    private BigDecimal rmbfund;
    private int rmbfundSort;
    private BigDecimal rmbfundDel;
    private int rmbfundDelSort;
    private BigDecimal insurrance;
    private int insurranceSort;
    private BigDecimal insurranceDel;
    private int insurranceDelSort;

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

    public int getAuthorizedStrength() {
        return authorizedStrength;
    }

    public void setAuthorizedStrength(int authorizedStrength) {
        this.authorizedStrength = authorizedStrength;
    }

    public int getOnJob() {
        return onJob;
    }

    public void setOnJob(int onJob) {
        this.onJob = onJob;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
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

    public String getBelongBrchNO() {
        return belongBrchNO;
    }

    public void setBelongBrchNO(String belongBrchNO) {
        this.belongBrchNO = belongBrchNO;
    }

    public String getBelongBrch() {
        return belongBrch;
    }

    public void setBelongBrch(String belongBrch) {
        this.belongBrch = belongBrch;
    }

    public String getManageMgrNo() {
        return manageMgrNo;
    }

    public void setManageMgrNo(String manageMgrNo) {
        this.manageMgrNo = manageMgrNo;
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

    public int getEffCustnumber() {
        return effCustnumber;
    }

    public void setEffCustnumber(int effCustnumber) {
        this.effCustnumber = effCustnumber;
    }

    public int getEffCustnumberPeople() {
        return effCustnumberPeople;
    }

    public void setEffCustnumberPeople(int effCustnumberPeople) {
        this.effCustnumberPeople = effCustnumberPeople;
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

    public int getYouhuiUpgratePeople() {
        return youhuiUpgratePeople;
    }

    public void setYouhuiUpgratePeople(int youhuiUpgratePeople) {
        this.youhuiUpgratePeople = youhuiUpgratePeople;
    }

    public int getYouhuiWinback() {
        return youhuiWinback;
    }

    public void setYouhuiWinback(int youhuiWinback) {
        this.youhuiWinback = youhuiWinback;
    }

    public int getYouhuiWinbackPeople() {
        return youhuiWinbackPeople;
    }

    public void setYouhuiWinbackPeople(int youhuiWinbackPeople) {
        this.youhuiWinbackPeople = youhuiWinbackPeople;
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

    public int getXianzhuoUpgratePeople() {
        return xianzhuoUpgratePeople;
    }

    public void setXianzhuoUpgratePeople(int xianzhuoUpgratePeople) {
        this.xianzhuoUpgratePeople = xianzhuoUpgratePeople;
    }

    public int getXianzhuoWinback() {
        return xianzhuoWinback;
    }

    public void setXianzhuoWinback(int xianzhuoWinback) {
        this.xianzhuoWinback = xianzhuoWinback;
    }

    public int getXianzhuoWinbackPeople() {
        return xianzhuoWinbackPeople;
    }

    public void setXianzhuoWinbackPeople(int xianzhuoWinbackPeople) {
        this.xianzhuoWinbackPeople = xianzhuoWinbackPeople;
    }

    public BigDecimal getAumBalanceavgTHt() {
        return aumBalanceavgTHt;
    }

    public void setAumBalanceavgTHt(BigDecimal aumBalanceavgTHt) {
        this.aumBalanceavgTHt = aumBalanceavgTHt;
    }

    public BigDecimal getAumBalanceavgTHtPeople() {
        return aumBalanceavgTHtPeople;
    }

    public void setAumBalanceavgTHtPeople(BigDecimal aumBalanceavgTHtPeople) {
        this.aumBalanceavgTHtPeople = aumBalanceavgTHtPeople;
    }

    public BigDecimal getAumBalanceavgHtFht() {
        return aumBalanceavgHtFht;
    }

    public void setAumBalanceavgHtFht(BigDecimal aumBalanceavgHtFht) {
        this.aumBalanceavgHtFht = aumBalanceavgHtFht;
    }

    public BigDecimal getAumBalanceavgHtFhtPeople() {
        return aumBalanceavgHtFhtPeople;
    }

    public void setAumBalanceavgHtFhtPeople(BigDecimal aumBalanceavgHtFhtPeople) {
        this.aumBalanceavgHtFhtPeople = aumBalanceavgHtFhtPeople;
    }

    public BigDecimal getAumBalanceavgFhtTm() {
        return aumBalanceavgFhtTm;
    }

    public void setAumBalanceavgFhtTm(BigDecimal aumBalanceavgFhtTm) {
        this.aumBalanceavgFhtTm = aumBalanceavgFhtTm;
    }

    public BigDecimal getAumBalanceavgFhtTmPeople() {
        return aumBalanceavgFhtTmPeople;
    }

    public void setAumBalanceavgFhtTmPeople(BigDecimal aumBalanceavgFhtTmPeople) {
        this.aumBalanceavgFhtTmPeople = aumBalanceavgFhtTmPeople;
    }

    public BigDecimal getAumBalanceavgTmSm() {
        return aumBalanceavgTmSm;
    }

    public void setAumBalanceavgTmSm(BigDecimal aumBalanceavgTmSm) {
        this.aumBalanceavgTmSm = aumBalanceavgTmSm;
    }

    public BigDecimal getAumBalanceavgTmSmPeople() {
        return aumBalanceavgTmSmPeople;
    }

    public void setAumBalanceavgTmSmPeople(BigDecimal aumBalanceavgTmSmPeople) {
        this.aumBalanceavgTmSmPeople = aumBalanceavgTmSmPeople;
    }

    public BigDecimal getAumBalanceavgSmEndless() {
        return aumBalanceavgSmEndless;
    }

    public void setAumBalanceavgSmEndless(BigDecimal aumBalanceavgSmEndless) {
        this.aumBalanceavgSmEndless = aumBalanceavgSmEndless;
    }

    public BigDecimal getAumBalanceavgSmEndlessPeople() {
        return aumBalanceavgSmEndlessPeople;
    }

    public void setAumBalanceavgSmEndlessPeople(BigDecimal aumBalanceavgSmEndlessPeople) {
        this.aumBalanceavgSmEndlessPeople = aumBalanceavgSmEndlessPeople;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
