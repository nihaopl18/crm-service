package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo;

import java.math.BigDecimal;

/**
 * @author sandMan
 * @date 2022/5/11 - 11:20
 */
public class SchemeScoreInfoVo {
    /**
     * 考核指标编号
     */
    private String indexId;
    /**
     * 考核指标名称
     */
    private String indexName;
    /**
     *考核指标计划值
     */
    private BigDecimal indexTargetValue;
    /**
     * 考核指标结果值
     */
    private BigDecimal indexRes;
    /**
     * 考核指标完成率(%)
     */
    private BigDecimal compRate;
    /**
     * 考核评分算法
     */
    private String scoreFormula;
    /**
     * 权重
     */
    private BigDecimal scoreWeight;
    /**
     * 考核指标得分
     */
    private BigDecimal score;

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public BigDecimal getIndexTargetValue() {
        return indexTargetValue;
    }

    public void setIndexTargetValue(BigDecimal indexTargetValue) {
        this.indexTargetValue = indexTargetValue;
    }

    public BigDecimal getIndexRes() {
        return indexRes;
    }

    public void setIndexRes(BigDecimal indexRes) {
        this.indexRes = indexRes;
    }

    public BigDecimal getCompRate() {
        return compRate;
    }

    public void setCompRate(BigDecimal compRate) {
        this.compRate = compRate;
    }

    public String getScoreFormula() {
        return scoreFormula;
    }

    public void setScoreFormula(String scoreFormula) {
        this.scoreFormula = scoreFormula;
    }

    public BigDecimal getScoreWeight() {
        return scoreWeight;
    }

    public void setScoreWeight(BigDecimal scoreWeight) {
        this.scoreWeight = scoreWeight;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
