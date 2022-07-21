package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

/**
 * @author sandMan
 * @date 2022/5/17 - 11:18
 */
public class QueryOrgScoreInfoForm {
    private String schemeId;
    private String orgId;
    private String schemeCycle;
    private String indexId;
    private String scoreRankMethod;
    private String compRateRankMethod;

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSchemeCycle() {
        return schemeCycle;
    }

    public void setSchemeCycle(String schemeCycle) {
        this.schemeCycle = schemeCycle;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getScoreRankMethod() {
        return scoreRankMethod;
    }

    public void setScoreRankMethod(String scoreRankMethod) {
        this.scoreRankMethod = scoreRankMethod;
    }

    public String getCompRateRankMethod() {
        return compRateRankMethod;
    }

    public void setCompRateRankMethod(String compRateRankMethod) {
        this.compRateRankMethod = compRateRankMethod;
    }
}
