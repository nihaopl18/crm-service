package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/13 - 17:14
 */
public class TeamAssessForm {
    //开始日期
    private String startTime;
    //结束日期
    private String endTime;
    //团队Id
    private String teamId;
    //团队IdList
    private List<String> teamIdList;
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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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

    public List<String> getTeamIdList() {
        return teamIdList;
    }

    public void setTeamIdList(List<String> teamIdList) {
        this.teamIdList = teamIdList;
    }

    public String[] getDataIds() {
        return dataIds;
    }

    public void setDataIds(String[] dataIds) {
        this.dataIds = dataIds;
    }
}
