package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description:
 * @author: Zhan YongQiang
 * @date: 2022/4/7 16:16
 */
public class PmaScoreIndexVo {

    private String id;

    @NotBlank
    private String indexId;

    @NotBlank
    private String scoreModelId;

    @NotBlank
    private String scoreWeight;

    @NotBlank
    private String scoreFormula;

    @NotNull
    private List<PamScoreParamVo> scoreParamList;

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

    public String getScoreWeight() {
        return scoreWeight;
    }

    public void setScoreWeight(String scoreWeight) {
        this.scoreWeight = scoreWeight;
    }

    public String getScoreFormula() {
        return scoreFormula;
    }

    public void setScoreFormula(String scoreFormula) {
        this.scoreFormula = scoreFormula;
    }

    public List<PamScoreParamVo> getScoreParamList() {
        return scoreParamList;
    }

    public void setScoreParamList(List<PamScoreParamVo> scoreParamList) {
        this.scoreParamList = scoreParamList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
