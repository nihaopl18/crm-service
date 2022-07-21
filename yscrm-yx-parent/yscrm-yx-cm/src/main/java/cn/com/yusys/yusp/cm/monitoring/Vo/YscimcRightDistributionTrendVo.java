package cn.com.yusys.yusp.cm.monitoring.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/13 - 11:12
 */
public class YscimcRightDistributionTrendVo {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;
    /**
     * 发放数量
     */
    private String distributionNumber;


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

    public LocalDateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(LocalDateTime recordTime) {
        this.recordTime = recordTime;
    }

    public String getDistributionNumber() {
        return distributionNumber;
    }

    public void setDistributionNumber(String distributionNumber) {
        this.distributionNumber = distributionNumber;
    }
}
