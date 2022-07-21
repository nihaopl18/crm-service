package cn.com.yusys.yusp.cm.ruleConfig.domain;

import java.util.List;

public class CmFRcMarketAction {
    private List<CmFRcProAction> proActionList;
    private List<CmFRcRiskAction> riskActionList;
    private List<CmFRcCareAction> careActionList;

    public List<CmFRcProAction> getProActionList() {
        return proActionList;
    }

    public void setProActionList(List<CmFRcProAction> proActionList) {
        this.proActionList = proActionList;
    }

    public List<CmFRcRiskAction> getRiskActionList() {
        return riskActionList;
    }

    public void setRiskActionList(List<CmFRcRiskAction> riskActionList) {
        this.riskActionList = riskActionList;
    }

    public List<CmFRcCareAction> getCareActionList() {
        return careActionList;
    }

    public void setCareActionList(List<CmFRcCareAction> careActionList) {
        this.careActionList = careActionList;
    }
}
