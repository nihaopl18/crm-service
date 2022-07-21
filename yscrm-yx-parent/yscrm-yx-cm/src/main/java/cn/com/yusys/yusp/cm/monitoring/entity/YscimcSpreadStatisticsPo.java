package cn.com.yusys.yusp.cm.monitoring.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 传播统计表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-16 14:15:48
 */
@Table(name = "YSCIMC_SPREAD_STATISTICS")
public class YscimcSpreadStatisticsPo implements Serializable {
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
     * 性别
     */
    private String sex;
    /**
     * 地区
     */
    private String region;
    /**
     * 分享次数
     */
    private String shareNum;
    /**
     * 累计带来参与人次
     */
    private String cumulativeNum;
    /**
     * 直接带来参与人次
     */
    private String directNum;
    /**
     * 累计分享次数（朋友圈）
     */
    private String shareWechatMomentNum;
    /**
     * 累计分享次数（好友）
     */
    private String shareFriendTimes;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShareNum() {
        return shareNum;
    }

    public void setShareNum(String shareNum) {
        this.shareNum = shareNum;
    }

    public String getCumulativeNum() {
        return cumulativeNum;
    }

    public void setCumulativeNum(String cumulativeNum) {
        this.cumulativeNum = cumulativeNum;
    }

    public String getDirectNum() {
        return directNum;
    }

    public void setDirectNum(String directNum) {
        this.directNum = directNum;
    }

    public String getShareWechatMomentNum() {
        return shareWechatMomentNum;
    }

    public void setShareWechatMomentNum(String shareWechatMomentNum) {
        this.shareWechatMomentNum = shareWechatMomentNum;
    }

    public String getShareFriendTimes() {
        return shareFriendTimes;
    }

    public void setShareFriendTimes(String shareFriendTimes) {
        this.shareFriendTimes = shareFriendTimes;
    }
}
