package cn.com.yusys.yusp.cm.monitoring.entity;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 传播趋势表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-16 14:15:48
 */
@Table(name = "YSCIMC_SPREAD_TENDENCY")
public class YscimcSpreadTendencyPo implements Serializable {
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
     * 参与人数
     */
    private Integer participatePeopleNumber;
    /**
     * 分享好友次数
     */
    private Integer shareFriendTimes;
    /**
     * 分享朋友圈次数
     */
    private Integer shareWechatMoment;
    /**
     * 参与人次
     */
    private Integer participatePeopleTimes;

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

    public Integer getParticipatePeopleNumber() {
        return participatePeopleNumber;
    }

    public void setParticipatePeopleNumber(Integer participatePeopleNumber) {
        this.participatePeopleNumber = participatePeopleNumber;
    }

    public Integer getShareFriendTimes() {
        return shareFriendTimes;
    }

    public void setShareFriendTimes(Integer shareFriendTimes) {
        this.shareFriendTimes = shareFriendTimes;
    }

    public Integer getShareWechatMoment() {
        return shareWechatMoment;
    }

    public void setShareWechatMoment(Integer shareWechatMoment) {
        this.shareWechatMoment = shareWechatMoment;
    }

    public Integer getParticipatePeopleTimes() {
        return participatePeopleTimes;
    }

    public void setParticipatePeopleTimes(Integer participatePeopleTimes) {
        this.participatePeopleTimes = participatePeopleTimes;
    }
}
