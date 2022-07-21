package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo;

import java.math.BigDecimal;

/**
 * @author sandMan
 * @date 2022/5/15 - 15:05
 */
public class PmaFSchemeIndexScoreOrgVo {
    /**
     * id
     */
    private String id;
    /**
     * 考核周期
     */
    private String schemeCycle;
    /**
     * 考核对象
     */
    private String orgCode;
    /**
     * 考核对象名称
     */
    private String orgName;
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
