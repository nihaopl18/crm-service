package cn.com.yusys.yscimc.operation.domain.vo;

import java.io.Serializable;
import java.util.List;

public class EventActivityInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CmFRcRuleComparisonInfoVo> cmFRcRuleComparisonInfoVoList;
    private List<CmFRcRuleConComparisonInfoVo> cmFRcRuleConComparisonInfoVoList;
    private List<CmFRcCareActionInfoVo> cmFRcCareActionInfoVoList;
    private List<CmFRcProActionInfoVo> cmFRcProActionInfoVoList;
    private List<CmFRcRiskActionInfoVo> cmFRcRiskActionInfoVoList;
    private List<CmFRcEventInfoVo> cmFRcEventInfoVoList;

    public List<CmFRcEventInfoVo> getCmFRcEventInfoVoList() {
        return cmFRcEventInfoVoList;
    }

    public void setCmFRcEventInfoVoList(List<CmFRcEventInfoVo> cmFRcEventInfoVoList) {
        this.cmFRcEventInfoVoList = cmFRcEventInfoVoList;
    }

    public List<CmFRcRuleComparisonInfoVo> getCmFRcRuleComparisonInfoVoList() {
        return cmFRcRuleComparisonInfoVoList;
    }

    public void setCmFRcRuleComparisonInfoVoList(List<CmFRcRuleComparisonInfoVo> cmFRcRuleComparisonInfoVoList) {
        this.cmFRcRuleComparisonInfoVoList = cmFRcRuleComparisonInfoVoList;
    }

    public List<CmFRcCareActionInfoVo> getCmFRcCareActionInfoVoList() {
        return cmFRcCareActionInfoVoList;
    }

    public void setCmFRcCareActionInfoVoList(List<CmFRcCareActionInfoVo> cmFRcCareActionInfoVoList) {
        this.cmFRcCareActionInfoVoList = cmFRcCareActionInfoVoList;
    }

    public List<CmFRcProActionInfoVo> getCmFRcProActionInfoVoList() {
        return cmFRcProActionInfoVoList;
    }

    public void setCmFRcProActionInfoVoList(List<CmFRcProActionInfoVo> cmFRcProActionInfoVoList) {
        this.cmFRcProActionInfoVoList = cmFRcProActionInfoVoList;
    }

    public List<CmFRcRiskActionInfoVo> getCmFRcRiskActionInfoVoList() {
        return cmFRcRiskActionInfoVoList;
    }

    public void setCmFRcRiskActionInfoVoList(List<CmFRcRiskActionInfoVo> cmFRcRiskActionInfoVoList) {
        this.cmFRcRiskActionInfoVoList = cmFRcRiskActionInfoVoList;
    }

    public List<CmFRcRuleConComparisonInfoVo> getCmFRcRuleConComparisonInfoVoList() {
        return cmFRcRuleConComparisonInfoVoList;
    }

    public void setCmFRcRuleConComparisonInfoVoList(List<CmFRcRuleConComparisonInfoVo> cmFRcRuleConComparisonInfoVoList) {
        this.cmFRcRuleConComparisonInfoVoList = cmFRcRuleConComparisonInfoVoList;
    }
}
