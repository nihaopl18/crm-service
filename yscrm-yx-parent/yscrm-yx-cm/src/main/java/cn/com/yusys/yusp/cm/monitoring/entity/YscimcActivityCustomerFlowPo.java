package cn.com.yusys.yusp.cm.monitoring.entity;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/11 - 10:24
 */
@Entity
@Table(name="YSCIMC_ACTIVITY_CUSTOMER_FLOW")
public class YscimcActivityCustomerFlowPo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 活动ID
     */
    @Column(name="ACTIVITY_ID")
    private String activityId;
    /**
     * 记录日期
     */
    @Column(name="RECORD_DATE")
    private Date recordDate;
    /**
     * 记录时间
     */
    @Column(name="RECORD_TIME")
    private Date recordTime;
    /**
     * 星级一
     */
    @Column(name="GRADE_ONE")
    private Date gradeOne;
    /**
     * 星级二
     */
    @Column(name="GRADE_TWO")
    private Date gradeTwo;
    /**
     * 星级三
     */
    @Column(name="GRADE_THREE")
    private Date gradeThree;
    /**
     * 星级四
     */
    @Column(name="GRADE_FOUR")
    private Date gradeFour;
    /**
     * 星级五
     */
    @Column(name="GRADE_FIVE")
    private Date gradeFive;
    public YscimcActivityCustomerFlowPo() {
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

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

    public Date getGradeOne() {
        return gradeOne;
    }

    public void setGradeOne(Date gradeOne) {
        this.gradeOne = gradeOne;
    }

    public Date getGradeTwo() {
        return gradeTwo;
    }

    public void setGradeTwo(Date gradeTwo) {
        this.gradeTwo = gradeTwo;
    }

    public Date getGradeThree() {
        return gradeThree;
    }

    public void setGradeThree(Date gradeThree) {
        this.gradeThree = gradeThree;
    }

    public Date getGradeFour() {
        return gradeFour;
    }

    public void setGradeFour(Date gradeFour) {
        this.gradeFour = gradeFour;
    }

    public Date getGradeFive() {
        return gradeFive;
    }

    public void setGradeFive(Date gradeFive) {
        this.gradeFive = gradeFive;
    }
}
