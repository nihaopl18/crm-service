package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/17 16:40
 */
public class TodoWorkExcel implements Serializable,Comparable<TodoWorkExcel> {
    private static final long serialVersionUID = -8197475590197154057L;
    /**
     * 状态
     * 1-待跟进
     * 2-已跟进
     */
    private String todoWorkState;

    private Integer countOfState1 = 0;

    private Double countOfState1Proportion = 0.0;

    private Integer countOfState2 = 0;

    private Double countOfState2Proportion = 0.0;

    private Integer countOfStateTotal = 0;
    /**
     * 类别
     * 1-商机
     * 2-外访
     * 3-培训\会议
     * 4-材料整理
     * 5-客户跟进
     */
    private String todoWorkType;

    private Double countOfType1Proportion = 0.0;
    private Double countOfType2Proportion = 0.0;
    private Double countOfType3Proportion = 0.0;
    private Double countOfType4Proportion = 0.0;
    private Double countOfType5Proportion = 0.0;
    private Double countOfType6Proportion = 0.0;
    private Double countOfType7Proportion = 0.0;
    private Double countOfType8Proportion = 0.0;
    private Double countOfType9Proportion = 0.0;
    private Double countOfType10Proportion = 0.0;

    private Integer countOfType1Total = 0;
    private Integer countOfType2Total = 0;
    private Integer countOfType3Total = 0;
    private Integer countOfType4Total = 0;
    private Integer countOfType5Total = 0;

    private Integer countOfType1 = 0;
    private Integer countOfType2 = 0;
    private Integer countOfType3 = 0;
    private Integer countOfType4 = 0;
    private Integer countOfType5 = 0;

    private Integer countOfType6 = 0;
    private Integer countOfType7 = 0;
    private Integer countOfType8 = 0;
    private Integer countOfType9 = 0;
    private Integer countOfType10 = 0;

    /**
     * 数量
     */
    private Integer count=0;

    /**
     *下发跟进率
     */
    private Double taskRate = 0.0;
    /**
     *跟进率
     */
    private Double rate = 0.0;
    private Integer rank = 0;

    private String upOrgId;
    private String upOrgName;
    private String orgId;
    private String orgName;
    private String creatorName;

    @Override
    public int compareTo(TodoWorkExcel o) {
        return o.getRate().compareTo(this.rate);
    }

    public String getUpOrgId() {
        return upOrgId;
    }

    public void setUpOrgId(String upOrgId) {
        this.upOrgId = upOrgId;
    }

    public String getUpOrgName() {
        return upOrgName;
    }

    public void setUpOrgName(String upOrgName) {
        this.upOrgName = upOrgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getTodoWorkState() {
        return todoWorkState;
    }

    public void setTodoWorkState(String todoWorkState) {
        this.todoWorkState = todoWorkState;
    }

    public String getTodoWorkType() {
        return todoWorkType;
    }

    public void setTodoWorkType(String todoWorkType) {
        this.todoWorkType = todoWorkType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCountOfState1() {
        return countOfState1;
    }

    public void setCountOfState1(Integer countOfState1) {
        this.countOfState1 = countOfState1;
    }

    public Integer getCountOfState2() {
        return countOfState2;
    }

    public void setCountOfState2(Integer countOfState2) {
        this.countOfState2 = countOfState2;
    }

    public Integer getCountOfType1() {
        return countOfType1;
    }

    public void setCountOfType1(Integer countOfType1) {
        this.countOfType1 = countOfType1;
    }

    public Integer getCountOfType2() {
        return countOfType2;
    }

    public void setCountOfType2(Integer countOfType2) {
        this.countOfType2 = countOfType2;
    }

    public Integer getCountOfType3() {
        return countOfType3;
    }

    public void setCountOfType3(Integer countOfType3) {
        this.countOfType3 = countOfType3;
    }

    public Integer getCountOfType4() {
        return countOfType4;
    }

    public void setCountOfType4(Integer countOfType4) {
        this.countOfType4 = countOfType4;
    }

    public Integer getCountOfType5() {
        return countOfType5;
    }

    public void setCountOfType5(Integer countOfType5) {
        this.countOfType5 = countOfType5;
    }

    public Integer getCountOfType6() {
        return countOfType6;
    }

    public void setCountOfType6(Integer countOfType6) {
        this.countOfType6 = countOfType6;
    }

    public Integer getCountOfType7() {
        return countOfType7;
    }

    public void setCountOfType7(Integer countOfType7) {
        this.countOfType7 = countOfType7;
    }

    public Integer getCountOfType8() {
        return countOfType8;
    }

    public void setCountOfType8(Integer countOfType8) {
        this.countOfType8 = countOfType8;
    }

    public Integer getCountOfType9() {
        return countOfType9;
    }

    public void setCountOfType9(Integer countOfType9) {
        this.countOfType9 = countOfType9;
    }

    public Integer getCountOfType10() {
        return countOfType10;
    }

    public void setCountOfType10(Integer countOfType10) {
        this.countOfType10 = countOfType10;
    }

    public Integer getCountOfStateTotal() {
        return countOfStateTotal;
    }

    public void setCountOfStateTotal(Integer countOfStateTotal) {
        this.countOfStateTotal = countOfStateTotal;
    }

    public Double getCountOfState1Proportion() {
        return countOfState1Proportion;
    }

    public void setCountOfState1Proportion(Double countOfState1Proportion) {
        this.countOfState1Proportion = countOfState1Proportion;
    }

    public Double getCountOfState2Proportion() {
        return countOfState2Proportion;
    }

    public void setCountOfState2Proportion(Double countOfState2Proportion) {
        this.countOfState2Proportion = countOfState2Proportion;
    }

    public Integer getCountOfType1Total() {
        return countOfType1Total;
    }

    public void setCountOfType1Total(Integer countOfType1Total) {
        this.countOfType1Total = countOfType1Total;
    }

    public Integer getCountOfType2Total() {
        return countOfType2Total;
    }

    public void setCountOfType2Total(Integer countOfType2Total) {
        this.countOfType2Total = countOfType2Total;
    }

    public Integer getCountOfType3Total() {
        return countOfType3Total;
    }

    public void setCountOfType3Total(Integer countOfType3Total) {
        this.countOfType3Total = countOfType3Total;
    }

    public Integer getCountOfType4Total() {
        return countOfType4Total;
    }

    public void setCountOfType4Total(Integer countOfType4Total) {
        this.countOfType4Total = countOfType4Total;
    }

    public Integer getCountOfType5Total() {
        return countOfType5Total;
    }

    public void setCountOfType5Total(Integer countOfType5Total) {
        this.countOfType5Total = countOfType5Total;
    }

    public Double getCountOfType1Proportion() {
        return countOfType1Proportion;
    }

    public void setCountOfType1Proportion(Double countOfType1Proportion) {
        this.countOfType1Proportion = countOfType1Proportion;
    }

    public Double getCountOfType2Proportion() {
        return countOfType2Proportion;
    }

    public void setCountOfType2Proportion(Double countOfType2Proportion) {
        this.countOfType2Proportion = countOfType2Proportion;
    }

    public Double getCountOfType3Proportion() {
        return countOfType3Proportion;
    }

    public void setCountOfType3Proportion(Double countOfType3Proportion) {
        this.countOfType3Proportion = countOfType3Proportion;
    }

    public Double getCountOfType4Proportion() {
        return countOfType4Proportion;
    }

    public void setCountOfType4Proportion(Double countOfType4Proportion) {
        this.countOfType4Proportion = countOfType4Proportion;
    }

    public Double getCountOfType5Proportion() {
        return countOfType5Proportion;
    }

    public void setCountOfType5Proportion(Double countOfType5Proportion) {
        this.countOfType5Proportion = countOfType5Proportion;
    }

    public Double getCountOfType6Proportion() {
        return countOfType6Proportion;
    }

    public void setCountOfType6Proportion(Double countOfType6Proportion) {
        this.countOfType6Proportion = countOfType6Proportion;
    }

    public Double getCountOfType7Proportion() {
        return countOfType7Proportion;
    }

    public void setCountOfType7Proportion(Double countOfType7Proportion) {
        this.countOfType7Proportion = countOfType7Proportion;
    }

    public Double getCountOfType8Proportion() {
        return countOfType8Proportion;
    }

    public void setCountOfType8Proportion(Double countOfType8Proportion) {
        this.countOfType8Proportion = countOfType8Proportion;
    }

    public Double getCountOfType9Proportion() {
        return countOfType9Proportion;
    }

    public void setCountOfType9Proportion(Double countOfType9Proportion) {
        this.countOfType9Proportion = countOfType9Proportion;
    }

    public Double getCountOfType10Proportion() {
        return countOfType10Proportion;
    }

    public void setCountOfType10Proportion(Double countOfType10Proportion) {
        this.countOfType10Proportion = countOfType10Proportion;
    }

    public Double getTaskRate() {
        return taskRate;
    }

    public void setTaskRate(Double taskRate) {
        this.taskRate = taskRate;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
