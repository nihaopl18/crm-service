package cn.com.yusys.yscrm.sysview.domain;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 保险产品持有详情
 *
 * @author: sxm
 * @time: 2021/8/16 10:52
 */
public class InsuranceProdHoldDel {
    /**
     * 保单号
     */
    @ExcelProperty({"保单号"})
    private String insuranceAcct;
    /**
     * 产品中文名称
     */
    @ExcelProperty({"产品中文名称"})
    private String prodName;
    /**
     * 产品类别
     */
    @ExcelProperty({"产品类别"})
    private String prodType;

    /**
     * 保险产品类别
     */
    @ExcelProperty({"保险产品类别"})
    private String prodKind;
    /**
     * 币种
     */
    @ExcelProperty({"币种"})
    private String ccy;
    /**
     * 产品保费额
     */
    @ExcelProperty({"产品保费额"})
    private String insuranceAmt;
    /**
     * 缴费方式
     */
    @ExcelProperty({"缴费方式"})
    private String payType;
    /**
     * 缴费期限类型
     */
    @ExcelProperty({"缴费期限类型"})
    private String payTermType;
    /**
     * 缴费期限
     */
    @ExcelProperty({"缴费期限"})
    private String payYearTerm;
    /**
     * 保单到期日
     */
    @ExcelProperty({"保单到期日"})
    private String insuranceExpiryDate;

    public String getInsuranceAcct() {
        return insuranceAcct;
    }

    public void setInsuranceAcct(String insuranceAcct) {
        this.insuranceAcct = insuranceAcct;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
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

    public String getInsuranceAmt() {
        return insuranceAmt;
    }

    public void setInsuranceAmt(String insuranceAmt) {
        this.insuranceAmt = insuranceAmt;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayTermType() {
        return payTermType;
    }

    public void setPayTermType(String payTermType) {
        this.payTermType = payTermType;
    }

    public String getPayYearTerm() {
        return payYearTerm;
    }

    public void setPayYearTerm(String payYearTerm) {
        this.payYearTerm = payYearTerm;
    }

    public String getInsuranceExpiryDate() {
        return insuranceExpiryDate;
    }

    public void setInsuranceExpiryDate(String insuranceExpiryDate) {
        this.insuranceExpiryDate = insuranceExpiryDate;
    }

    public String getProdKind() {
        return prodKind;
    }
}
