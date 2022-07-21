package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/9 - 15:15
 */
public class CustomerAssessForm {
    //开始日期
    private String startTime;
    //结束日期
    private String endTime;
    //客户经理Id
    private String managerId;
    //考核方案Id
    private String schemeId;
    //排序方法
    private String rankMethod;
    private String condition;
    //用户Id
    private String userId;
    //机构Id
    private String orgId;
    private List<String> customerIdString;
    private int page;
    private int size;

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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<String> getCustomerIdString() {
        return customerIdString;
    }

    public void setCustomerIdString(List<String> customerIdString) {
        this.customerIdString = customerIdString;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
