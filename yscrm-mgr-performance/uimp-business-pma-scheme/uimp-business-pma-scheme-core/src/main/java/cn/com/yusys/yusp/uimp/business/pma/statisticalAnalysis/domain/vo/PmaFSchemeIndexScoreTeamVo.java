package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo;

import java.math.BigDecimal;

/**
 * @author sandMan
 * @date 2022/5/13 - 17:08
 */
public class PmaFSchemeIndexScoreTeamVo {
    /**
     * ID
     */
    private String id;
    /**
     * 考核周期
     */
    private String schemeCycle;
    /**
     * 考核对象
     */
    private String teamId;
    /**
     * 考核对象名称
     */
    private String teamName;
    /**
     * 考核方案编号
     */
    private String schemeId;
    /**
     * 考核方案
     */
    private String schemeName;
    /**
     * 总评分
     */
    private BigDecimal totalScore;

    /**
     *
     * 总评分排名
     */
    private String totalScoreRank;

    public String getSchemeCycle() {
        return schemeCycle;
    }

    public void setSchemeCycle(String schemeCycle) {
        this.schemeCycle = schemeCycle;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public String getTotalScoreRank() {
        return totalScoreRank;
    }

    public void setTotalScoreRank(String totalScoreRank) {
        this.totalScoreRank = totalScoreRank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
