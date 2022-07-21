package cn.com.yusys.climp.score.domain;

import cn.com.yusys.climp.qypool.domain.LoyAcOrderExAttr;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ScoreExch implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean isOnline = false;//是否联机
    private String systemId;//系统编号
    private String ndsCustId;//NDS客户号
    private String custId;//客户号
    private String orderCode;//订单号
    private String commodityCode;//商品编号
    private String commodityId;//商品id
    private String commodityName;//商品名称
    private String commodityDescTemp;//商品使用说明模板
    private String changeFeq;//同一客户可兑换频率
    private String modelId;//规格ID
    private Integer changeCount;//兑换数量
    private java.math.BigDecimal moneyNum;//兑换现金价值
    private java.math.BigDecimal deduScore;//兑换积分
    private java.math.BigDecimal scoreSum;//客户当前可用积分
    private String orderChannel;//兑换渠道
    private String oderDt;//兑换时间
    private String operatorOrg;//兑换用户机构编号
    private String operatorCode;//兑换用户编号
    private String appAccount;//审批用户编号
    private String orderDesc;//备注
    private List<LoyAcOrderExAttr> extendArr;//订单扩展属性
    private String scdId;//积分明细Id

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? "" : systemId.trim();
    }

    public String getNdsCustId() {
        return ndsCustId;
    }

    public void setNdsCustId(String ndsCustId) {
        this.ndsCustId = ndsCustId == null ? "" : ndsCustId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? "" : custId.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? "" : orderCode.trim();
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode == null ? "" : commodityCode.trim();
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId == null ? "" : commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? "" : commodityName;
    }

    public String getCommodityDescTemp() {
        return commodityDescTemp;
    }

    public void setCommodityDescTemp(String commodityDescTemp) {
        this.commodityDescTemp = commodityDescTemp == null ? "" : commodityDescTemp;
    }

    public String getChangeFeq() { return changeFeq;
    }

    public void setChangeFeq(String changeFeq) {
        this.changeFeq = changeFeq == null ? "" : changeFeq;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount == null ? 0 : changeCount;
    }

    public BigDecimal getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(BigDecimal moneyNum) {
        this.moneyNum = moneyNum == null ? BigDecimal.ZERO : moneyNum;
    }

    public String getOrderChannel() {
        return orderChannel;
    }

    public java.math.BigDecimal getDeduScore() {
        return deduScore;
    }

    public void setDeduScore(java.math.BigDecimal deduScore) {
        this.deduScore = deduScore == null ? null : deduScore;
    }

    public BigDecimal getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(BigDecimal scoreSum) {
        this.scoreSum = scoreSum == null ? null : scoreSum;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel == null ? "" : orderChannel.trim();
    }

    public String getOderDt() {
        return oderDt;
    }

    public void setOderDt(String oderDt) {
        this.oderDt = oderDt == null ? "" : oderDt.trim();
    }

    public String getOperatorOrg() {
        return operatorOrg;
    }

    public void setOperatorOrg(String operatorOrg) {
        this.operatorOrg = operatorOrg;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode == null ? "" : operatorCode.trim();
    }

    public String getAppAccount() {
        return appAccount;
    }

    public void setAppAccount(String appAccount) {
        this.appAccount = appAccount == null ? "" : appAccount.trim();
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc == null ? "" : orderDesc.trim();
    }

    public List<LoyAcOrderExAttr> getExtendArr() {
        return extendArr;
    }

    public void setExtendArr(List<LoyAcOrderExAttr> extendArr) {
        this.extendArr = extendArr;
    }

    public String getScdId() {
        return scdId;
    }

    public void setScdId(String scdId) {
        this.scdId = scdId == null ? "" : scdId;
    }
}
