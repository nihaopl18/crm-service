package cn.com.yusys.yusp.cm.monitoring.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动效果推广信息表
 *
 * @author houyx3
 * @email
 * @date 2022-04-15 16:39:10
 */
public class YscimcActReExtensionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 活动ID
     */
    private String actId;
    /**
     * 渠道编号
     */
    private String extensionType;
    /**
     * 渠道名称
     */
    private String extensionName;
    /**
     * 费用成本
     */
    private Integer extensionCost;
    /**
     * 贡献率
     */
    private Integer contributionRate;
    /**
     * 投资回报率
     */
    private Integer roi;
    /**
     * 投放时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 记录日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date recordDate;
    /**
     * 记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;

    /**
     * 备注
     */
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getExtensionType() {
        return extensionType;
    }

    public void setExtensionType(String extensionType) {
        this.extensionType = extensionType;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public Integer getExtensionCost() {
        return extensionCost;
    }

    public void setExtensionCost(Integer extensionCost) {
        this.extensionCost = extensionCost;
    }

    public Integer getContributionRate() {
        return contributionRate;
    }

    public void setContributionRate(Integer contributionRate) {
        this.contributionRate = contributionRate;
    }

    public Integer getRoi() {
        return roi;
    }

    public void setRoi(Integer roi) {
        this.roi = roi;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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
}
