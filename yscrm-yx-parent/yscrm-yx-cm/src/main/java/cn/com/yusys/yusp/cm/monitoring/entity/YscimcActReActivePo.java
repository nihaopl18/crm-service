package cn.com.yusys.yusp.cm.monitoring.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/4/6 11:22
 */
@Table(name="YSCIMC_ACT_RE_ACTIVE")
public class YscimcActReActivePo {

    /**
     * 活动ID
     */
    @ApiModelProperty(value = "活动ID")
    private String actId;

    /**
     * 记录日期
     */
    @ApiModelProperty(value = "记录日期")
    private Date recordDate;
    /**
     * 记录时间
     */
    @ApiModelProperty(value = "记录时间")
    private Date recordTime;

    /**
     * 活跃人数
     */
    @ApiModelProperty(value = "活跃人数")
    private String activeNum;

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
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

    public String getActiveNum() {
        return activeNum;
    }

    public void setActiveNum(String activeNum) {
        this.activeNum = activeNum;
    }
}
