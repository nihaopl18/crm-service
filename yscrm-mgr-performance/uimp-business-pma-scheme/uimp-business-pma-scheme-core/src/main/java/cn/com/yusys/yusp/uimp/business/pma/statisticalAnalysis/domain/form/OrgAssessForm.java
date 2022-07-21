package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/17 - 10:53
 */
public class OrgAssessForm {
    //开始日期
    private String startTime;
    //结束日期
    private String endTime;
    //机构Id
    private String orgId;
    //机构IdList
    private List<String> orgIdList;
    //考核方案Id
    private String schemeId;
    //排序方法
    private String rankMethod;
    /**
     * 数据ID列表
     */
    private String[] dataIds;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<String> getOrgIdList() {
        return orgIdList;
    }

    public void setOrgIdList(List<String> orgIdList) {
        this.orgIdList = orgIdList;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getRankMethod() {
        return rankMethod;
    }

    public void setRankMethod(String rankMethod) {
        this.rankMethod = rankMethod;
    }

    public String[] getDataIds() {
        return dataIds;
    }

    public void setDataIds(String[] dataIds) {
        this.dataIds = dataIds;
    }
}
