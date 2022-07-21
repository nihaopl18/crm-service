package cn.com.yusys.yusp.cm.monitoring.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 传播关系表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-16 14:15:48
 */
@Table(name = "YSCIMC_SPREAD_PATH")
public class YscimcSpreadPathPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;
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
     * 推荐人ID
     */
    private String recommenderId;
    /**
     * 推荐人名字
     */
    private String recommenderName;
    /**
     * 推荐人头像地址
     */
    private String recommenderImageUrl;
    /**
     * 上级推荐人ID
     */
    private String upRecommenderId;
    /**
     * 上级推荐人名字
     */
    private String upRecommenderName;
    /**
     * 上级推荐人头像地址
     */
    private String upRecommenderImageUrl;
    /**
     * 关系
     */
    private String relationship;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRecommenderId() {
        return recommenderId;
    }

    public void setRecommenderId(String recommenderId) {
        this.recommenderId = recommenderId;
    }

    public String getRecommenderName() {
        return recommenderName;
    }

    public void setRecommenderName(String recommenderName) {
        this.recommenderName = recommenderName;
    }

    public String getRecommenderImageUrl() {
        return recommenderImageUrl;
    }

    public void setRecommenderImageUrl(String recommenderImageUrl) {
        this.recommenderImageUrl = recommenderImageUrl;
    }

    public String getUpRecommenderId() {
        return upRecommenderId;
    }

    public void setUpRecommenderId(String upRecommenderId) {
        this.upRecommenderId = upRecommenderId;
    }

    public String getUpRecommenderName() {
        return upRecommenderName;
    }

    public void setUpRecommenderName(String upRecommenderName) {
        this.upRecommenderName = upRecommenderName;
    }

    public String getUpRecommenderImageUrl() {
        return upRecommenderImageUrl;
    }

    public void setUpRecommenderImageUrl(String upRecommenderImageUrl) {
        this.upRecommenderImageUrl = upRecommenderImageUrl;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
