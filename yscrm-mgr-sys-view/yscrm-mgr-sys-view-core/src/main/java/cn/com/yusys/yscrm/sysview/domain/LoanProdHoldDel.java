package cn.com.yusys.yscrm.sysview.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 贷款产品持有详情
 *
 * @author: sxm
 * @time: 2021/8/16 9:58
 */
public class LoanProdHoldDel {
    /**
     * 贷款类型
     */
    @ExcelProperty({"贷款类型"})
    private String loanType;
    /**
     * 产品分类
     */
    @ExcelProperty({"产品分类"})
    private String prodType;
    /**
     * 产品代码
     */
    @ExcelProperty({"产品代码"})
    private String prodCode;
    /**
     * 源产品代码
     */
    @ExcelProperty({"源产品代码"})
    private String srcProdCode;
    /**
     * 产品中文名称
     */
    @ExcelProperty({"产品中文名称"})
    private String prodName;
    /**
     * 已还期数
     */
    @ExcelProperty({"已还期数"})
    private String repayedPeriod;
    /**
     * 贷款用途
     */
    @ExcelProperty({"贷款用途"})
    private String loanPurpose;
    /**
     * 币种
     */
    @ExcelProperty({"币种"})
    private String ccy;
    /**
     * 期限
     */
    @ExcelProperty({"期限"})
    private String term;
    /**
     * 实际利率
     */
    @ExcelProperty({"实际利率"})
    private String actualRate;
    /**
     * 贷款本金
     */
    @ExcelProperty({"贷款本金"})
    private String loanPrincipal;
    /**
     * 利息余额
     */
    @ExcelProperty({"利息余额"})
    private String intBalance;
    /**
     * 累计还款金额
     */
    @ExcelProperty({"累计还款金额"})
    private String totalRepayAmt;
    /**
     * 累计实收利息
     */
    @ExcelProperty({"累计实收利息"})
    private String totalPaidInt;
    /**
     * 上年余额
     */
    @ExcelProperty({"上年余额"})
    private String lastYearLoanBalance;
    /**
     * 本期余额
     */
    @ExcelProperty({"本期余额"})
    private String currentLoanBalance;
    /**
     * 数据日期
     */
    @ExcelProperty({"数据日期"})
    private String dataDate;
    /**
     * 起息日
     */
    @ExcelProperty({"起息日"})
    private String valueDate;
    /**
     * 本金到期日
     */
    @ExcelProperty({"本金到期日"})
    private String principalExpiryDate;
    /**
     * 利息到期日
     */
    @ExcelProperty({"利息到期日"})
    private String intExpiryDate;
    /**
     * 基准利率
     */
    @ExcelProperty({"基准利率"})
    private String baseRate;
    /**
     * 担保方式
     */
    @ExcelProperty({"担保方式"})
    private String guaranteeType;
    /**
     * 是否需要抵押物
     */
    @ExcelProperty({"是否需要抵押物"})
    private String isNeedCollateral;
    /**
     * 五级分类
     */
    @ExcelProperty({"五级分类"})
    private String fiveTireClass;
    /**
     * 放款日期
     */
    @ExcelProperty({"放款日期"})
    private String loanDate;
    /**
     * 借据编号
     */
    @ExcelProperty({"借据编号"})
    private String loanNo;
    /**
     * 当期应还本金
     */
    @ExcelProperty({"当期应还本金"})
    private String currentShouldRepayPrinciple;
    /**
     * 当期应还利息
     */
    @ExcelProperty({"当期应还利息"})
    private String currentShouldRepayInterest;

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getSrcProdCode() { return srcProdCode; }

    public void setSrcProdCode(String srcProdCode) { this.srcProdCode = srcProdCode; }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getRepayedPeriod() {
        return repayedPeriod;
    }

    public void setRepayedPeriod(String repayedPeriod) {
        this.repayedPeriod = repayedPeriod;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getActualRate() {
        return actualRate;
    }

    public void setActualRate(String actualRate) {
        this.actualRate = actualRate;
    }

    public String getLoanPrincipal() {
        return loanPrincipal;
    }

    public void setLoanPrincipal(String loanPrincipal) {
        this.loanPrincipal = loanPrincipal;
    }

    public String getIntBalance() {
        return intBalance;
    }

    public void setIntBalance(String intBalance) {
        this.intBalance = intBalance;
    }

    public String getTotalRepayAmt() {
        return totalRepayAmt;
    }

    public void setTotalRepayAmt(String totalRepayAmt) {
        this.totalRepayAmt = totalRepayAmt;
    }

    public String getTotalPaidInt() {
        return totalPaidInt;
    }

    public void setTotalPaidInt(String totalPaidInt) {
        this.totalPaidInt = totalPaidInt;
    }

    public String getLastYearLoanBalance() {
        return lastYearLoanBalance;
    }

    public void setLastYearLoanBalance(String lastYearLoanBalance) {
        this.lastYearLoanBalance = lastYearLoanBalance;
    }

    public String getCurrentLoanBalance() {
        return currentLoanBalance;
    }

    public void setCurrentLoanBalance(String currentLoanBalance) {
        this.currentLoanBalance = currentLoanBalance;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getPrincipalExpiryDate() {
        return principalExpiryDate;
    }

    public void setPrincipalExpiryDate(String principalExpiryDate) {
        this.principalExpiryDate = principalExpiryDate;
    }

    public String getIntExpiryDate() {
        return intExpiryDate;
    }

    public void setIntExpiryDate(String intExpiryDate) {
        this.intExpiryDate = intExpiryDate;
    }

    public String getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(String baseRate) {
        this.baseRate = baseRate;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getIsNeedCollateral() {
        return isNeedCollateral;
    }

    public void setIsNeedCollateral(String isNeedCollateral) {
        this.isNeedCollateral = isNeedCollateral;
    }

    public String getFiveTireClass() {
        return fiveTireClass;
    }

    public void setFiveTireClass(String fiveTireClass) {
        this.fiveTireClass = fiveTireClass;
    }

    public String getLoanDate() { return loanDate; }

    public void setLoanDate(String loanDate) { this.loanDate = loanDate; }

    public String getLoanNo() { return loanNo; }

    public void setLoanNo(String loanNo) { this.loanNo = loanNo; }

   public String getCurrentShouldRepayPrinciple() { return currentShouldRepayPrinciple; }

    public void setCurrentShouldRepayPrinciple(String currentShouldRepayPrinciple) { this.currentShouldRepayPrinciple = currentShouldRepayPrinciple; }

    public String getCurrentShouldRepayInterest() { return currentShouldRepayInterest; }

    public void setCurrentShouldRepayInterest(String currentShouldRepayInterest) { this.currentShouldRepayInterest = currentShouldRepayInterest; }
}
