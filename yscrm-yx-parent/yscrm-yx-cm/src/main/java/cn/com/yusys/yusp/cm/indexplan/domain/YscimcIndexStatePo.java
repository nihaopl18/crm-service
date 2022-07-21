package cn.com.yusys.yusp.cm.indexplan.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author sandMan
 * @date 2022/4/15 - 16:37
 */
@Entity
@Table(name="YSCIMC_INDEX_STATE")
public class YscimcIndexStatePo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Generated(GenerationType.UUID)
    @Column(name="ID")
    private String id;

    @Column(name="ACTIVITY_ID")
    private String activityId;


    @Column(name="ACTIVITY_NAME")
    private String activityName;

    @Column(name="ORG_ID")
    private String orgId;

    @Column(name="INDEX_STATE")
    private String indexState;

    public YscimcIndexStatePo() {
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getIndexState() {
        return indexState;
    }

    public void setIndexState(String indexState) {
        this.indexState = indexState;
    }
}
