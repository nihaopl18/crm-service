package cn.com.yusys.yusp.cm.monitoring.Vo;


import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/11 - 10:30
 */
public class YscimcActivityCustomerFlowVo {
    /**
     * 活动ID
     */
    private String activityId;

    /**
     * 记录日期
     */
    private Date recordDate;
    /**
     * 记录时间
     */
    private Date recordTime;
    /**
     * 星级一
     */
    private String gradeOne;
    /**
     * 星级二
     */
    private String gradeTwo;
    /**
     * 星级三
     */
    private String gradeThree;
    /**
     * 星级四
     */
    private String gradeFour;
    /**
     * 星级五
     */
    private String gradeFive;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getGradeOne() {
        return gradeOne;
    }

    public void setGradeOne(String gradeOne) {
        this.gradeOne = gradeOne;
    }

    public String getGradeTwo() {
        return gradeTwo;
    }

    public void setGradeTwo(String gradeTwo) {
        this.gradeTwo = gradeTwo;
    }

    public String getGradeThree() {
        return gradeThree;
    }

    public void setGradeThree(String gradeThree) {
        this.gradeThree = gradeThree;
    }

    public String getGradeFour() {
        return gradeFour;
    }

    public void setGradeFour(String gradeFour) {
        this.gradeFour = gradeFour;
    }

    public String getGradeFive() {
        return gradeFive;
    }

    public void setGradeFive(String gradeFive) {
        this.gradeFive = gradeFive;
    }
}
