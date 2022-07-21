package cn.com.yusys.yusp.cm.taskcenter.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(
        name = "CIMP_TC_TASKPOOL_INFO"
)
public class CimFTcTaskPool extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Generated("UUID")
    @Column(
            name = "TASK_ID"
    )
    private String taskId;
    @Column(
            name = "ACTIVITY_ID"
    )
    private String activityId;
    @Column(
            name = "TASK_NAME"
    )
    private String taskName;
    @Column(
            name = "TASK_TYPE"
    )
    private String taskType;
    @Column(
            name = "TASK_STATE"
    )
    private String taskState;
    @Column(
            name = "START_TIME"
    )
    private Date startTime;
    @Column(
            name = "END_TIME"
    )
    private Date endTime;
    @Column(
            name = "TASK_CONTENT"
    )
    private String taskContent;
    @Column(
            name = "LAST_UPDATE_DT"
    )
    private Date lastUpdateDt;
    @Column(
            name = "LAST_UPDATE_USER"
    )
    private String lastUpdateUser;
    @Column(
            name = "CREATE_TIME"
    )
    private Date createTime;
    @Column(
            name = "ALLOT_USER"
    )
    private String allotUser;
    @Column(
            name = "DUTY_USER"
    )
    private String dutyUser;
    @Column(
            name = "ALLOT_TIME"
    )
    private Date allotTime;

    @Column(
            name = "BELONG_MGR"
    )
    private String belongMgr;

    @Column(
            name = "BELONG_ORG"
    )
    private String belongOrg;
    @Column(
            name = "CUST_ID"
    )
    private String custId;

    @Column(
            name = "CUST_NAME"
    )
    private String custName;
    @Column(
            name = "MGR_NAME"
    )
    private String mgrName;
    @Column(
            name = "ORG_NAME"
    )
    private String orgName;

    @Column(
            name = "ACTIVITY_NAME"
    )
    private String activityName;
    @Column(
            name = "PRODUCT_ID"
    )
    private String productId;

    @Column(
            name = "PRODUCT_NAME"
    )
    private String productName;

    public CimFTcTaskPool() {
    }
    public String getAllotUser() {
        return allotUser;
    }

    public void setAllotUser(String allotUser) {
        this.allotUser = allotUser;
    }

    public String getDutyUser() {
        return dutyUser;
    }

    public void setDutyUser(String dutyUser) {
        this.dutyUser = dutyUser;
    }

    public Date getAllotTime() {
        return allotTime;
    }

    public void setAllotTime(Date allotTime) {
        this.allotTime = allotTime;
    }

    public String getBelongMgr() {
        return belongMgr;
    }

    public void setBelongMgr(String belongMgr) {
        this.belongMgr = belongMgr;
    }

    public String getBelongOrg() {
        return belongOrg;
    }

    public void setBelongOrg(String belongOrg) {
        this.belongOrg = belongOrg;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public static long getSerialVersionUID() {
        return 1L;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskState() {
        return this.taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTaskContent() {
        return this.taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public Date getLastUpdateDt() {
        return this.lastUpdateDt;
    }

    public void setLastUpdateDt(Date lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    public String getLastUpdateUser() {
        return this.lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}