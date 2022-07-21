package cn.com.yusys.yscimc.operation.domain.vo;

import cn.com.yusys.yscimc.operation.annotation.Keyword;

import java.util.Date;

/**
 * 产品组件查询出的产品信息
 * @author zhangyt12
 * @date 2021/12/15 20:17
 */
public class ProductInfoVo {

    // 产品主键
    @Keyword(alias = "@PRODUCT_ID@")
    private String productId;

    // 产品名称
    @Keyword(alias = "@PROD_NAME@")
    private String prodName;

    // 大类产品标识
    @Keyword(alias = "@CATL_CODE@")
    private long catlCode;

    // 统计口径
    @Keyword(alias = "@TJKJ@")
    private String tjkj;

    // 产品类型代码
    @Keyword(alias = "@PROD_TYPE_ID@")
    private long prodTypeId;

    // 是否展示
    @Keyword(alias = "@DISPLAY_FLAG@")
    private String displayFlag;

    @Keyword(alias = "@PROD_START_DATE@")
    private Date prodStartDate;

    // 产品失效日期
    @Keyword(alias = "@PROD_END_DATE@")
    private Date prodEndDate;

    // 产品状态代码
    @Keyword(alias = "@PROD_STATE@")
    private String prodState;

    // 产品展示页面
    @Keyword(alias="@PROD_SHOW_URL@")
    private String prodShowUrl;

    // 产品查询页面
    @Keyword(alias="@PROD_QUERY_URL@")
    private String prodQueryUrl;

    // 产品序列
    @Keyword(alias="@PROD_SEQ@")
    private String prodSeq;

    // 产品归属部门
    @Keyword(alias="@PROD_DEPT@")
    private String prodDept;

    // 利率
    @Keyword(alias="@RATE@")
    private String rate;

    // 费率
    @Keyword(alias="@COST_RATE@")
    private String costRate;

    // 年限
    @Keyword(alias="@LIMIT_TIME@")
    private String limitTime;

    // 1-启用，2-未启动，参考码值：ENABLE_STATE
    @Keyword(alias="@PROD_SWITCH@")
    private String prodSwitch;

    // 风险等级
    @Keyword(alias="@RISK_LEVEL@")
    private String riskLevel;

    // 产品非业务主键，前台手工录入；
    @Keyword(alias="@PROD_BUS_ID@")
    private String prodBusId;

    // 产品客户类型
    @Keyword(alias="@TYPE_FIT_CUST@")
    private String typeFitCust;

    // 产品经理
    @Keyword(alias="@PROD_MAG@")
    private String prodMag;

    // 产品等级
    @Keyword(alias="@PROD_LEVEL@")
    private String prodLevel;

    // 办理渠道
    @Keyword(alias="@TRADE_CHN@")
    private String tradeChn;

    // 是否为组合产品（1-是、2-否）
    @Keyword(alias="@IS_COMBINATION@")
    private String isCombination;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public long getCatlCode() {
        return catlCode;
    }

    public void setCatlCode(long catlCode) {
        this.catlCode = catlCode;
    }

    public String getTjkj() {
        return tjkj;
    }

    public void setTjkj(String tjkj) {
        this.tjkj = tjkj;
    }

    public long getProdTypeId() {
        return prodTypeId;
    }

    public void setProdTypeId(long prodTypeId) {
        this.prodTypeId = prodTypeId;
    }

    public String getDisplayFlag() {
        return displayFlag;
    }

    public void setDisplayFlag(String displayFlag) {
        this.displayFlag = displayFlag;
    }

    public Date getProdEndDate() {
        return prodEndDate;
    }

    public void setProdEndDate(Date prodEndDate) {
        this.prodEndDate = prodEndDate;
    }

    public String getProdState() {
        return prodState;
    }

    public void setProdState(String prodState) {
        this.prodState = prodState;
    }

    public String getProdShowUrl() {
        return prodShowUrl;
    }

    public void setProdShowUrl(String prodShowUrl) {
        this.prodShowUrl = prodShowUrl;
    }

    public String getProdQueryUrl() {
        return prodQueryUrl;
    }

    public void setProdQueryUrl(String prodQueryUrl) {
        this.prodQueryUrl = prodQueryUrl;
    }

    public String getProdSeq() {
        return prodSeq;
    }

    public void setProdSeq(String prodSeq) {
        this.prodSeq = prodSeq;
    }

    public String getProdDept() {
        return prodDept;
    }

    public void setProdDept(String prodDept) {
        this.prodDept = prodDept;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCostRate() {
        return costRate;
    }

    public void setCostRate(String costRate) {
        this.costRate = costRate;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getProdSwitch() {
        return prodSwitch;
    }

    public void setProdSwitch(String prodSwitch) {
        this.prodSwitch = prodSwitch;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getProdBusId() {
        return prodBusId;
    }

    public void setProdBusId(String prodBusId) {
        this.prodBusId = prodBusId;
    }

    public String getTypeFitCust() {
        return typeFitCust;
    }

    public void setTypeFitCust(String typeFitCust) {
        this.typeFitCust = typeFitCust;
    }

    public String getProdMag() {
        return prodMag;
    }

    public void setProdMag(String prodMag) {
        this.prodMag = prodMag;
    }

    public String getProdLevel() {
        return prodLevel;
    }

    public void setProdLevel(String prodLevel) {
        this.prodLevel = prodLevel;
    }

    public String getTradeChn() {
        return tradeChn;
    }

    public void setTradeChn(String tradeChn) {
        this.tradeChn = tradeChn;
    }

    public String getIsCombination() {
        return isCombination;
    }

    public void setIsCombination(String isCombination) {
        this.isCombination = isCombination;
    }

    public Date getProdStartDate() {
        return prodStartDate;
    }

    public void setProdStartDate(Date prodStartDate) {
        this.prodStartDate = prodStartDate;
    }
}
