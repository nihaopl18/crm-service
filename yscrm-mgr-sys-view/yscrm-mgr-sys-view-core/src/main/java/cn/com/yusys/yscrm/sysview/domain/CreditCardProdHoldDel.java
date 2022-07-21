package cn.com.yusys.yscrm.sysview.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 信用卡产品持有详情
 *
 * @author: sxm
 * @time: 2021/8/16 10:06
 */
public class CreditCardProdHoldDel {
    /**
     * 银行号
     */
    @ExcelProperty({"银行号"})
    private String bankNo;
    /**
     * 账号
     */
    @ExcelProperty({"账号"})
    private String acctNo;
    /**
     * 产品分类
     */
    @ExcelProperty({"产品分类"})
    private String prodType;
    /**
     * 币种
     */
    @ExcelProperty({"币种"})
    private String ccy;
    /**
     * 总额度
     */
    @ExcelProperty({"总额度"})
    private String totalAmt;
    /**
     * 已使用额度
     */
    @ExcelProperty({"已使用额度"})
    private String usedAmt;
    /**
     * 积分余额
     */
    @ExcelProperty({"积分余额"})
    private String pointsBalance;
    /**
     * 总分期月数
     */
    @ExcelProperty({"总分期月数"})
    private String totalInstalmentMonth;
    /**
     * 当前期数
     */
    @ExcelProperty({"当前期数"})
    private String currentPeriod;
    /**
     * 总产品金额
     */
    @ExcelProperty({"总产品金额"})
    private String totalProdAmt;
    /**
     * 剩余未还本金
     */
    @ExcelProperty({"剩余未还本金"})
    private String surplusNopayAmt;
    /**
     * 总利息金额
     */
    @ExcelProperty({"总利息金额"})
    private String totalIntAmt;
    /**
     * 剩余未还利息
     */
    @ExcelProperty({"剩余未还利息"})
    private String surplusNopayInt;
    /**
     * 还款日
     */
    @ExcelProperty({"还款日"})
    private String repayDate;
    /**
     * 账单日
     */
    @ExcelProperty({"账单日"})
    private String billDate;
    /**
     * 贷款余额
     */
    @ExcelProperty({"贷款余额"})
    private String loanBalance;
    /**
     * 利息余额
     */
    @ExcelProperty({"利息余额"})
    private String intBalance;
    /**
     * 费用余额
     */
    @ExcelProperty({"费用余额"})
    private String feeBalance;
    /**
     * 分期付款贷款余额
     */
    @ExcelProperty({"分期付款贷款余额"})
    private String installmentBalance;
    /**
     * 当期应还金额
     */
    @ExcelProperty({"当期应还金额"})
    private String currentShouldRepayAmt;
    /**
     * 当期已还金额
     */
    @ExcelProperty({"当期已还金额"})
    private String currentRepayAmt;
    /**
     * 产品代码
     */
    @ExcelProperty({"产品代码"})
    private String prodCode;

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getUsedAmt() {
        return usedAmt;
    }

    public void setUsedAmt(String usedAmt) {
        this.usedAmt = usedAmt;
    }

    public String getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(String pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public String getTotalInstalmentMonth() {
        return totalInstalmentMonth;
    }

    public void setTotalInstalmentMonth(String totalInstalmentMonth) {
        this.totalInstalmentMonth = totalInstalmentMonth;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getTotalProdAmt() {
        return totalProdAmt;
    }

    public void setTotalProdAmt(String totalProdAmt) {
        this.totalProdAmt = totalProdAmt;
    }

    public String getSurplusNopayAmt() {
        return surplusNopayAmt;
    }

    public void setSurplusNopayAmt(String surplusNopayAmt) {
        this.surplusNopayAmt = surplusNopayAmt;
    }

    public String getTotalIntAmt() {
        return totalIntAmt;
    }

    public void setTotalIntAmt(String totalIntAmt) {
        this.totalIntAmt = totalIntAmt;
    }

    public String getSurplusNopayInt() {
        return surplusNopayInt;
    }

    public void setSurplusNopayInt(String surplusNopayInt) {
        this.surplusNopayInt = surplusNopayInt;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(String loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getIntBalance() {
        return intBalance;
    }

    public void setIntBalance(String intBalance) {
        this.intBalance = intBalance;
    }

    public String getFeeBalance() {
        return feeBalance;
    }

    public void setFeeBalance(String feeBalance) {
        this.feeBalance = feeBalance;
    }

    public String getInstallmentBalance() {
        return installmentBalance;
    }

    public void setInstallmentBalance(String installmentBalance) {
        this.installmentBalance = installmentBalance;
    }

    public String getCurrentShouldRepayAmt() {
        return currentShouldRepayAmt;
    }

    public void setCurrentShouldRepayAmt(String currentShouldRepayAmt) { this.currentShouldRepayAmt = currentShouldRepayAmt; }

    public String getCurrentRepayAmt() {
        return currentRepayAmt;
    }

    public void setCurrentRepayAmt(String currentRepayAmt) {
        this.currentRepayAmt = currentRepayAmt;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }
}
