package cn.com.yusys.yscrm.sysview.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 存款产品持有详情
 *
 * @author: sxm
 * @time: 2021/8/16 9:51
 */
public class DepositProdHoldDel {
    /**
     * 账户类型
     */
    @ExcelProperty({"账户类型"})
    private String acctType;
    /**
     * 账户号
     */
    @ExcelProperty({"账户号"})
    private String acctNo;
    /**
     * 存期类型
     */
    @ExcelProperty({"存期类型"})
    private String termType;
    /**
     * 存款类型
     */
    @ExcelProperty({"存款类型"})
    private String prodType;
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
     * 产品中文名称
     */
    @ExcelProperty({"产品中文名称"})
    private String prodName;
    /**
     * 存期
     */
    @ExcelProperty({"存期"})
    private String term;
    /**
     * 利率
     */
    @ExcelProperty({"利率"})
    private String rate;
    /**
     * 利率类型
     */
    @ExcelProperty({"利率类型"})
    private String rateType;
    /**
     * 币种
     */
    @ExcelProperty({"币种"})
    private String ccy;
    /**
     * 原币金额
     */
    @ExcelProperty({"原币金额"})
    private String amt;

    /**
     * 折人民币金额金额
     */
    @ExcelProperty({"折人民币金额金额"})
    private String amtRmb;

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
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

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSrcProdCode() {
        return srcProdCode;
    }

    public void setSrcProdCode(String srcProdCode) {
        this.srcProdCode = srcProdCode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getAmtRmb() {
        return amtRmb;
    }

    public void setAmtRmb(String amtRmb) {
        this.amtRmb = amtRmb;
    }
}
