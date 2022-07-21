package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;



/**
 * @项目名称: 
 * @类名称: CimpCmMarketplan
 * @类描述: CIMP_CM_MARKETPLAN数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-06-10 19:21:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_CM_MARKETPLAN")
public class CimpCmMarketplan extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 策划编号 **/
	@Id
	@Column(name = "TEMP_ID", unique = false, nullable = false, length = 32)
	private String tempId;
	
	/** 引用模板编号 **/
	@Column(name = "MODEL_ID", unique = false, nullable = true, length = 32)
	private String modelId;
	
	/** 活动名称 **/
	@Column(name = "ACTIVITY_NAME", unique = false, nullable = true, length = 100)
	private String activityName;
	
	/** 活动策划机构 **/
	@Column(name = "ACTIVITY_ORG", unique = false, nullable = true, length = 32)
	private String activityOrg;
	
	/** 客户类型（零售客户/公司客户） **/
	@Column(name = "CUSTOMER_TYPE", unique = false, nullable = true, length = 10)
	private String customerType;
	
	/** 开始时间 **/
	@Column(name = "START_DATE", unique = false, nullable = true, length = 7)
	private Date startDate;
	
	/** 结束时间 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 7)
	private Date endDate;
	
	/** 营销策划说明 **/
	@Column(name = "ACTIVITY_DESC", unique = false, nullable = true, length = 1024)
	private String activityDesc;
	
	/** 最近更新人编号 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 最近更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 创建人编号 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 32)
	private String cratUsr;
	
	/** 创建时间 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 活动类型 **/
	@Column(name = "ACTIVITY_TYPE", unique = false, nullable = true, length = 10)
	private String activityType;
	
	/** 活动状态 **/
	@Column(name = "ACTIVITY_STS", unique = false, nullable = true, length = 10)
	private String activitySts;
	
	/** 活动场景 **/
	@Column(name = "ACTIVITY_SCENE", unique = false, nullable = true, length = 10)
	private String activityScene;
	
	/** 金融机构 **/
	@Column(name = "INSTU_ID", unique = false, nullable = true, length = 32)
	private String instuId;
	
	/** 审批状态 **/
	@Column(name = "WF_APP_STATUS", unique = false, nullable = true, length = 10)
	private String wfAppStatus;
	
	/** 最近更新人机构 **/
	@Column(name = "LAST_CHG_ORG", unique = false, nullable = true, length = 32)
	private String lastChgOrg;
	
	/** 创建人机构 **/
	@Column(name = "CRAT_ORG", unique = false, nullable = true, length = 32)
	private String cratOrg;
	
	/** 是否定时任务 **/
	@Column(name = "IF_TIME_TASK", unique = false, nullable = true, length = 10)
	private String ifTimeTask;
	
	/** 执行频率 **/
	@Column(name = "TASK_FREQ", unique = false, nullable = true, length = 10)
	private String taskFreq;
	
	
	/**
	 * @param tempId
	 */
	public void setTempId(String tempId) {
		this.tempId = tempId == null ? null : tempId.trim();
	}
	
    /**
     * @return TempId
     */	
	public String getTempId() {
		return this.tempId;
	}
	
	/**
	 * @param modelId
	 */
	public void setModelId(String modelId) {
		this.modelId = modelId == null ? null : modelId.trim();
	}
	
    /**
     * @return ModelId
     */	
	public String getModelId() {
		return this.modelId;
	}
	
	/**
	 * @param activityName
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}
	
    /**
     * @return ActivityName
     */	
	public String getActivityName() {
		return this.activityName;
	}
	
	/**
	 * @param activityOrg
	 */
	public void setActivityOrg(String activityOrg) {
		this.activityOrg = activityOrg == null ? null : activityOrg.trim();
	}
	
    /**
     * @return ActivityOrg
     */	
	public String getActivityOrg() {
		return this.activityOrg;
	}
	
	/**
	 * @param customerType
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType == null ? null : customerType.trim();
	}
	
    /**
     * @return CustomerType
     */	
	public String getCustomerType() {
		return this.customerType;
	}
	
	/**
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
    /**
     * @return StartDate
     */	
	public Date getStartDate() {
		return this.startDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
    /**
     * @return EndDate
     */	
	public Date getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @param activityDesc
	 */
	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc == null ? null : activityDesc.trim();
	}
	
    /**
     * @return ActivityDesc
     */	
	public String getActivityDesc() {
		return this.activityDesc;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param activityType
	 */
	public void setActivityType(String activityType) {
		this.activityType = activityType == null ? null : activityType.trim();
	}
	
    /**
     * @return ActivityType
     */	
	public String getActivityType() {
		return this.activityType;
	}
	
	/**
	 * @param activitySts
	 */
	public void setActivitySts(String activitySts) {
		this.activitySts = activitySts == null ? null : activitySts.trim();
	}
	
    /**
     * @return ActivitySts
     */	
	public String getActivitySts() {
		return this.activitySts;
	}
	
	/**
	 * @param activityScene
	 */
	public void setActivityScene(String activityScene) {
		this.activityScene = activityScene == null ? null : activityScene.trim();
	}
	
    /**
     * @return ActivityScene
     */	
	public String getActivityScene() {
		return this.activityScene;
	}
	
	/**
	 * @param instuId
	 */
	public void setInstuId(String instuId) {
		this.instuId = instuId == null ? null : instuId.trim();
	}
	
    /**
     * @return InstuId
     */	
	public String getInstuId() {
		return this.instuId;
	}
	
	/**
	 * @param wfAppStatus
	 */
	public void setWfAppStatus(String wfAppStatus) {
		this.wfAppStatus = wfAppStatus == null ? null : wfAppStatus.trim();
	}
	
    /**
     * @return WfAppStatus
     */	
	public String getWfAppStatus() {
		return this.wfAppStatus;
	}
	
	/**
	 * @param lastChgOrg
	 */
	public void setLastChgOrg(String lastChgOrg) {
		this.lastChgOrg = lastChgOrg == null ? null : lastChgOrg.trim();
	}
	
    /**
     * @return LastChgOrg
     */	
	public String getLastChgOrg() {
		return this.lastChgOrg;
	}
	
	/**
	 * @param cratOrg
	 */
	public void setCratOrg(String cratOrg) {
		this.cratOrg = cratOrg == null ? null : cratOrg.trim();
	}
	
    /**
     * @return CratOrg
     */	
	public String getCratOrg() {
		return this.cratOrg;
	}
	
	/**
	 * @param ifTimeTask
	 */
	public void setIfTimeTask(String ifTimeTask) {
		this.ifTimeTask = ifTimeTask == null ? null : ifTimeTask.trim();
	}
	
    /**
     * @return IfTimeTask
     */	
	public String getIfTimeTask() {
		return this.ifTimeTask;
	}
	
	/**
	 * @param taskFreq
	 */
	public void setTaskFreq(String taskFreq) {
		this.taskFreq = taskFreq == null ? null : taskFreq.trim();
	}
	
    /**
     * @return TaskFreq
     */	
	public String getTaskFreq() {
		return this.taskFreq;
	}

	@Override
	public String toString() {
		return "CimpCmMarketplan{" +
				"tempId='" + tempId + '\'' +
				", modelId='" + modelId + '\'' +
				", activityName='" + activityName + '\'' +
				", activityOrg='" + activityOrg + '\'' +
				", customerType='" + customerType + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", activityDesc='" + activityDesc + '\'' +
				", lastChgUsr='" + lastChgUsr + '\'' +
				", lastChgDt=" + lastChgDt +
				", cratUsr='" + cratUsr + '\'' +
				", cratDt=" + cratDt +
				", activityType='" + activityType + '\'' +
				", activitySts='" + activitySts + '\'' +
				", activityScene='" + activityScene + '\'' +
				", instuId='" + instuId + '\'' +
				", wfAppStatus='" + wfAppStatus + '\'' +
				", lastChgOrg='" + lastChgOrg + '\'' +
				", cratOrg='" + cratOrg + '\'' +
				", ifTimeTask='" + ifTimeTask + '\'' +
				", taskFreq='" + taskFreq + '\'' +
				'}';
	}
}