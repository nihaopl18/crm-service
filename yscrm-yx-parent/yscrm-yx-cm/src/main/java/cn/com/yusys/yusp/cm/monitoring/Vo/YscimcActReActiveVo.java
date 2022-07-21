package cn.com.yusys.yusp.cm.monitoring.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/4/6 11:22
 */
public class YscimcActReActiveVo {
    /**
     * 活动ID
     */
    @ApiModelProperty(value = "活动ID")
    private String actId;

    /**
     * 记录日期
     */
    @ApiModelProperty(value = "记录日期")
    private LocalDate recordDate;

    /**
     * 记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "记录时间")
    private LocalDateTime recordTime;

    /**
     * 活跃人数
     */
    @ApiModelProperty(value = "活跃人数")
    private long activeNum;

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public LocalDateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(LocalDateTime recordTime) {
        this.recordTime = recordTime;
    }

    public long getActiveNum() {
        return activeNum;
    }

    public void setActiveNum(long activeNum) {
        this.activeNum = activeNum;
    }
}
