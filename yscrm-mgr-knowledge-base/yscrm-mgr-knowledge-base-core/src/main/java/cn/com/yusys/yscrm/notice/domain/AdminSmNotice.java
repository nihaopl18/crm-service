package cn.com.yusys.yscrm.notice.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "ADMIN_SM_NOTICE"
)
public class AdminSmNotice extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Generated("UUID")
    @Column(
            name = "NOTICE_ID"
    )
    private String noticeId;
    @Column(
            name = "ACTIVE_DATE"
    )
    private String activeDate;
    @Column(
            name = "CREATOR_ID"
    )
    private String creatorId;
    @Column(
            name = "CREATOR_NAME"
    )
    private String creatorName;
    @Column(
            name = "CREATOR_TIME"
    )
    private String creatorTime;
    @Column(
            name = "IS_TOP"
    )
    private String isTop;
    @Column(
            name = "NOTICE_CONTENT"
    )
    private String noticeContent;
    @Column(
            name = "NOTICE_LEVEL"
    )
    private String noticeLevel;
    @Column(
            name = "NOTICE_TITLE"
    )
    private String noticeTitle;
    @Column(
            name = "PUB_ORG_ID"
    )
    private String pubOrgId;
    @Column(
            name = "PUB_ORG_NAME"
    )
    private String pubOrgName;
    @Column(
            name = "PUB_STS"
    )
    private String pubSts;
    @Column(
            name = "PUB_TIME"
    )
    private String pubTime;
    @Column(
            name = "PUB_USER_ID"
    )
    private String pubUserId;
    @Column(
            name = "PUB_USER_NAME"
    )
    private String pubUserName;
    @Column(
            name = "TOP_ACTIVE_DATE"
    )
    private String topActiveDate;

    public AdminSmNotice() {
    }

    public String getNoticeId() {
        return this.noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getActiveDate() {
        return this.activeDate;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public String getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorTime() {
        return this.creatorTime;
    }

    public void setCreatorTime(String creatorTime) {
        this.creatorTime = creatorTime;
    }

    public String getIsTop() {
        return this.isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getNoticeContent() {
        return this.noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeLevel() {
        return this.noticeLevel;
    }

    public void setNoticeLevel(String noticeLevel) {
        this.noticeLevel = noticeLevel;
    }

    public String getNoticeTitle() {
        return this.noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getPubOrgId() {
        return this.pubOrgId;
    }

    public void setPubOrgId(String pubOrgId) {
        this.pubOrgId = pubOrgId;
    }

    public String getPubOrgName() {
        return this.pubOrgName;
    }

    public void setPubOrgName(String pubOrgName) {
        this.pubOrgName = pubOrgName;
    }

    public String getPubSts() {
        return this.pubSts;
    }

    public void setPubSts(String pubSts) {
        this.pubSts = pubSts;
    }

    public String getPubTime() {
        return this.pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getPubUserId() {
        return this.pubUserId;
    }

    public void setPubUserId(String pubUserId) {
        this.pubUserId = pubUserId;
    }

    public String getPubUserName() {
        return this.pubUserName;
    }

    public void setPubUserName(String pubUserName) {
        this.pubUserName = pubUserName;
    }

    public String getTopActiveDate() {
        return this.topActiveDate;
    }

    public void setTopActiveDate(String topActiveDate) {
        this.topActiveDate = topActiveDate;
    }
}
