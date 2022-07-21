package cn.com.yusys.yusp.cm.monitoring.entity;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/8 - 16:53
 */
@Entity
@Table(name="YSCIMC_ACTIVITY_TRAFFIC_SOURCE")
public class YscimcActivityTrafficSourcePo extends BaseDomain implements Serializable {
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
     * 搜索引流
     */
    @Column(name="SEARCH_IMPORT_FLOW")
    private String searchImportFlow;

    /**
     * 站内引流
     */
    @Column(name="INSIDE_STATION_IMPORT_FLOW")
    private String insideStationImportFlow;
    /**
     * 推广引流
     */
    @Column(name="PROMOTION_IMPORT_FLOW")
    private String promotionImportFlow;
    /**
     * 总访问量
     */
    @Column(name="TOTAL_VISIT_AMOUNT")
    private String totalVisitAmount;

    public YscimcActivityTrafficSourcePo() {
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

    public String getSearchImportFlow() {
        return searchImportFlow;
    }

    public void setSearchImportFlow(String searchImportFlow) {
        this.searchImportFlow = searchImportFlow;
    }

    public String getInsideStationImportFlow() {
        return insideStationImportFlow;
    }

    public void setInsideStationImportFlow(String insideStationImportFlow) {
        this.insideStationImportFlow = insideStationImportFlow;
    }

    public String getPromotionImportFlow() {
        return promotionImportFlow;
    }

    public void setPromotionImportFlow(String promotionImportFlow) {
        this.promotionImportFlow = promotionImportFlow;
    }

    public String getTotalVisitAmount() {
        return totalVisitAmount;
    }

    public void setTotalVisitAmount(String totalVisitAmount) {
        this.totalVisitAmount = totalVisitAmount;
    }
}
