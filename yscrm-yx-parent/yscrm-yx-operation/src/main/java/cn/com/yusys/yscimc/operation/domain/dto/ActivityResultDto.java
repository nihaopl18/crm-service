package cn.com.yusys.yscimc.operation.domain.dto;

/**
 * 名单类型活动结果汇总对象
 */
public class ActivityResultDto {

    private String activityName;

    /**
     * 0: {value: "名单制营销类", key: "01"}
     * 1: {value: "互联网场景营销类", key: "02"}
     * 2: {value: "实时事件/批量事件营销类", key: "03"}
     */
    private String activityType;

    /**
     * 1: {value: "已发布", key: "02"}
     * 2: {value: "已下架", key: "03"}
     * 3: {value: "执行中", key: "04"}
     */
    private String activitySts;

    // 客户个数
    private Integer customerNumber;

    // 成功率
    private String successRate;

    // 访问量
    private Integer visitVolume;

    // 成功匹配活动数量
    private Integer successNumber;

    // 栏位信息&活动类型
    private String fieldAndType;

    // 规则表 code
    private String tableCode;

    private String startTime;

    private String endTime;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivitySts() {
        return activitySts;
    }

    public void setActivitySts(String activitySts) {
        this.activitySts = activitySts;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(String successRate) {
        this.successRate = successRate;
    }

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

    public Integer getVisitVolume() {
        return visitVolume;
    }

    public void setVisitVolume(Integer visitVolume) {
        this.visitVolume = visitVolume;
    }

    public Integer getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(Integer successNumber) {
        this.successNumber = successNumber;
    }

    public String getFieldAndType() {
        return fieldAndType;
    }

    public void setFieldAndType(String fieldAndType) {
        this.fieldAndType = fieldAndType;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }
}
