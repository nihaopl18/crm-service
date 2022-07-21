package cn.com.yusys.yusp.cm.monitoring.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 活动效果ROI
 *
 * @author danyb1
 * @email danyb1@yusys.com.cn
 * @date 2022-04-08 17:10:44
 */

public class YscimcActReRoiVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 活动ID
     */
    private String actId;
    /**
     * 总收入
     */
    private Integer revenue;
    /**
     * 总支出
     */
    private Integer expenditure;
    /**
     * 参与人数
     */
    private Integer partakeNum;
    /**
     * 购买人数
     */
    private Integer purchaseNum;
    /**
     * 活跃人数
     */
    private Integer activeNum;
    /**
     * 记录日期
     */
    private LocalDateTime recordDate;
    /**
     * 记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;
    /**
     * 平均获客成本（参与）
     */
    private Integer partakeAvg;
    /**
     * 历史平均获客成本（参与）
     */
    private Integer partakeAvgHis;
    /**
     * 历史最优获客成本（参与）
     */
    private Integer partakeOptimalHis;
    /**
     * 平均获客成本（购买）
     */
    private Integer purchaseAvg;
    /**
     * 历史平均获客成本（购买）
     */
    private Integer purchaseAvgHis;
    /**
     * 历史最优获客成本（购买）
     */
    private Integer purchaseOptimalHis;
    /**
     * 平均获客成本（活跃）
     */
    private Integer activeAvg;
    /**
     * 历史平均获客成本（活跃）
     */
    private Integer activeAvgHis;
    /**
     * 历史最优获客成本（活跃）
     */
    private Integer activeOptimalHis;

    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(Integer expenditure) {
        this.expenditure = expenditure;
    }

    public Integer getPartakeNum() {
        return partakeNum;
    }

    public void setPartakeNum(Integer partakeNum) {
        this.partakeNum = partakeNum;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public Integer getActiveNum() {
        return activeNum;
    }

    public void setActiveNum(Integer activeNum) {
        this.activeNum = activeNum;
    }

    public LocalDateTime getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate) {
        this.recordDate = recordDate;
    }

    public LocalDateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(LocalDateTime recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getPartakeAvg() {
        return partakeAvg;
    }

    public void setPartakeAvg(Integer partakeAvg) {
        this.partakeAvg = partakeAvg;
    }

    public Integer getPartakeAvgHis() {
        return partakeAvgHis;
    }

    public void setPartakeAvgHis(Integer partakeAvgHis) {
        this.partakeAvgHis = partakeAvgHis;
    }

    public Integer getPartakeOptimalHis() {
        return partakeOptimalHis;
    }

    public void setPartakeOptimalHis(Integer partakeOptimalHis) {
        this.partakeOptimalHis = partakeOptimalHis;
    }

    public Integer getPurchaseAvg() {
        return purchaseAvg;
    }

    public void setPurchaseAvg(Integer purchaseAvg) {
        this.purchaseAvg = purchaseAvg;
    }

    public Integer getPurchaseAvgHis() {
        return purchaseAvgHis;
    }

    public void setPurchaseAvgHis(Integer purchaseAvgHis) {
        this.purchaseAvgHis = purchaseAvgHis;
    }

    public Integer getPurchaseOptimalHis() {
        return purchaseOptimalHis;
    }

    public void setPurchaseOptimalHis(Integer purchaseOptimalHis) {
        this.purchaseOptimalHis = purchaseOptimalHis;
    }

    public Integer getActiveAvg() {
        return activeAvg;
    }

    public void setActiveAvg(Integer activeAvg) {
        this.activeAvg = activeAvg;
    }

    public Integer getActiveAvgHis() {
        return activeAvgHis;
    }

    public void setActiveAvgHis(Integer activeAvgHis) {
        this.activeAvgHis = activeAvgHis;
    }

    public Integer getActiveOptimalHis() {
        return activeOptimalHis;
    }

    public void setActiveOptimalHis(Integer activeOptimalHis) {
        this.activeOptimalHis = activeOptimalHis;
    }
}
