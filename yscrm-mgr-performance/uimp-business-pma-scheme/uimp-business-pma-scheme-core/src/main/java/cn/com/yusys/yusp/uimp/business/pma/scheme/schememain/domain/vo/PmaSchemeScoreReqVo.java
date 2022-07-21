package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo;

import java.util.Map;


/**
 * @description: 考核评分请求实体类
 * @author: Zhan YongQiang
 * @date: 2022/4/7 16:13
 */
public class PmaSchemeScoreReqVo {

    /**
     * 考核方案ID
     */
    private String schemeId;

    /**
     * 指标ID
     */
    private String indexId;

    /**
     * 应用类型
     */
    private String applyType;

    /**
     * 币种
     */
    private String currency;

    /**
     * 余额类型
     */
    private String balType;

    /**
     * 评分模型ID
     */
    private String scoreModelId;

    /**
     * 计算公式
     */
    private String scoreFormula;

    /**
     * 考核对象类型
     */
    private String evlObjType;

    /**
     * 权重
     */
    private String scoreWeight;

    /**
     * 参数信息
     */
    private Map<String,String> paramMap;

    /**
     * 参数中文名，前端使用
     */
    private Map<String,String> cnNameMap;

    /**
     * 权重之和
     */
    private String totalWeight;

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getScoreModelId() {
        return scoreModelId;
    }

    public void setScoreModelId(String scoreModelId) {
        this.scoreModelId = scoreModelId;
    }

    public String getScoreFormula() {
        return scoreFormula;
    }

    public void setScoreFormula(String scoreFormula) {
        this.scoreFormula = scoreFormula;
    }

    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, String> getCnNameMap() {
        return cnNameMap;
    }

    public void setCnNameMap(Map<String, String> cnNameMap) {
        this.cnNameMap = cnNameMap;
    }

    public String getEvlObjType() {
        return evlObjType;
    }

    public void setEvlObjType(String evlObjType) {
        this.evlObjType = evlObjType;
    }

    public String getScoreWeight() {
        return scoreWeight;
    }

    public void setScoreWeight(String scoreWeight) {
        this.scoreWeight = scoreWeight;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getBalType() {
        return balType;
    }

    public void setBalType(String balType) {
        this.balType = balType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
