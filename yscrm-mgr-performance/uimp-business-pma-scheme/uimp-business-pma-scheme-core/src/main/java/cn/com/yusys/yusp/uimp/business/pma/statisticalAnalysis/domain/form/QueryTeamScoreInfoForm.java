package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

/**
 * @author sandMan
 * @date 2022/5/16 - 9:54
 */
public class QueryTeamScoreInfoForm {
    private String schemeId;
    private String teamId;
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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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
