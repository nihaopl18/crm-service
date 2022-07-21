package cn.com.yusys.yscrm.sysview.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 信托、结构化理财、QDII、代收付和人民币基金产品持有详情
 *
 * @author: sxm
 * @time: 2021/8/13 9:50
 */
public class ProdHoldDeInfo {
    /**
     * 产品分类
     */
    @ExcelProperty({"产品分类"})
    private String prodCode;
    /**
     * 产品代码
     */
    @ExcelProperty({"产品代码"})
    private String srcProdCode;
    /**
     * 产品名称
     */
    @ExcelProperty({"产品名称"})
    private String prodName;
    /**
     * 初始认购金额
     */
    @ExcelProperty({"初始认购金额"})
    private String firstSubscribeAmt;
    /**
     * 托管账号
     */
    @ExcelProperty({"托管账号"})
    private String escrowAcctNo;
    /**
     * 托管手续费率
     */
    @ExcelProperty({"托管手续费率"})
    private String escrowFeeRate;
    /**
     * 状态
     */
    @ExcelProperty({"状态"})
    private String prodStatus;
    /**
     * 净值币种
     */
    @ExcelProperty({"净值币种"})
    private String priceCcy;
    /**
     * 最新净值
     */
    @ExcelProperty({"最新净值"})
    private String curNetValue;
    /**
     * 产品到期日
     */
    @ExcelProperty({"产品到期日"})
    private String prodExpiryDate;
    /**
     * 交易币种
     */
    @ExcelProperty({"交易币种"})
    private String transCcy;
    /**
     * 认购开始日
     */
    @ExcelProperty({"认购开始日"})
    private String subscribeStartDate;
    /**
     * 认购结束日
     */
    @ExcelProperty({"认购结束日"})
    private String subscribeEndDate;
    /**
     * 首次最低投资金额
     */
    @ExcelProperty({"首次最低投资金额"})
    private String firstMinInvestAmt;
    /**
     * 总额度
     */
    @ExcelProperty({"总额度"})
    private String totalAmt;
    /**
     * 剩余额度
     */
    @ExcelProperty({"剩余额度"})
    private String surplusAmt;
    /**
     * 收益特征
     */
    @ExcelProperty({"收益特征"})
    private String incomeFeatures;
    /**
     * 风险等级
     */
    @ExcelProperty({"风险等级"})
    private String riskLevel;
    /**
     * 预期收益率
     */
    @ExcelProperty({"预期收益率"})
    private String expectReturnRate;
    /**
     * 产品最新净值日期
     */
    @ExcelProperty({"产品最新净值日期"})
    private String prodNetUpdateTime;

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getSrcProdCode() {
        return srcProdCode;
    }

    public void setSrcProdCode(String srcProdCode) {
        this.srcProdCode = srcProdCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getFirstSubscribeAmt() {
        return firstSubscribeAmt;
    }

    public void setFirstSubscribeAmt(String firstSubscribeAmt) {
        this.firstSubscribeAmt = firstSubscribeAmt;
    }

    public String getEscrowAcctNo() {
        return escrowAcctNo;
    }

    public void setEscrowAcctNo(String escrowAcctNo) {
        this.escrowAcctNo = escrowAcctNo;
    }

    public String getEscrowFeeRate() {
        return escrowFeeRate;
    }

    public void setEscrowFeeRate(String escrowFeeRate) {
        this.escrowFeeRate = escrowFeeRate;
    }

    public String getProdStatus() {
        return prodStatus;
    }

    public void setProdStatus(String prodStatus) {
        this.prodStatus = prodStatus;
    }

    public String getPriceCcy() { return priceCcy; }

    public void setPriceCcy(String priceCcy) { this.priceCcy = priceCcy; }

    public String getCurNetValue() {
        return curNetValue;
    }

    public void setCurNetValue(String curNetValue) {
        this.curNetValue = curNetValue;
    }

    public String getProdExpiryDate() {
        return prodExpiryDate;
    }

    public void setProdExpiryDate(String prodExpiryDate) {
        this.prodExpiryDate = prodExpiryDate;
    }

    public String getTransCcy() {
        return transCcy;
    }

    public void setTransCcy(String transCcy) {
        this.transCcy = transCcy;
    }

    public String getSubscribeStartDate() {
        return subscribeStartDate;
    }

    public void setSubscribeStartDate(String subscribeStartDate) {
        this.subscribeStartDate = subscribeStartDate;
    }

    public String getSubscribeEndDate() {
        return subscribeEndDate;
    }

    public void setSubscribeEndDate(String subscribeEndDate) {
        this.subscribeEndDate = subscribeEndDate;
    }

    public String getFirstMinInvestAmt() {
        return firstMinInvestAmt;
    }

    public void setFirstMinInvestAmt(String firstMinInvestAmt) {
        this.firstMinInvestAmt = firstMinInvestAmt;
    }

    public String getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    public String getSurplusAmt() {
        return surplusAmt;
    }

    public void setSurplusAmt(String surplusAmt) {
        this.surplusAmt = surplusAmt;
    }

    public String getIncomeFeatures() {
        return incomeFeatures;
    }

    public void setIncomeFeatures(String incomeFeatures) {
        this.incomeFeatures = incomeFeatures;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getExpectReturnRate() {
        return expectReturnRate;
    }

    public void setExpectReturnRate(String expectReturnRate) {
        this.expectReturnRate = expectReturnRate;
    }

    public String getProdNetUpdateTime() { return prodNetUpdateTime; }

    public void setProdNetUpdateTime(String prodNetUpdateTime) { this.prodNetUpdateTime = prodNetUpdateTime; }
}
