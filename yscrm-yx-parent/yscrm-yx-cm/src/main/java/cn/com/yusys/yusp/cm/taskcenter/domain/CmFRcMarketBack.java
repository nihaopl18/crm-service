package cn.com.yusys.yusp.cm.taskcenter.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the CM_F_RC_MARKET_BACK database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_MARKET_BACK")
public class CmFRcMarketBack extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CATL_CODE")
	private Long catlCode;

	@Column(name="CHANNEL_ID")
	private String channelId;

	@Column(name="CUST_ID")
	private String custId;

	@Column(name="EXECUTE_RESULT")
	private String executeResult;

	@Column(name="EXECUTE_USER")
	private String executeUser;

	@Column(name="MARKET_AMOUNT")
	private String marketAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="MARKET_DATE")
	private Date marketDate;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="MARKET_ID")
	private String marketId;

	@Column(name="PRODUCT_ID")
	private String productId;

	@Temporal(TemporalType.DATE)
	@Column(name="PUSH_DATE")
	private Date pushDate;

	@Column(name="TASK_ID")
	private String taskId;

	@Column(name="TOUCH_STATE")
	private String touchState;

	public CmFRcMarketBack() {
	}

	public Long getCatlCode() {
		return this.catlCode;
	}

	public void setCatlCode(Long catlCode) {
		this.catlCode = catlCode;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getExecuteResult() {
		return this.executeResult;
	}

	public void setExecuteResult(String executeResult) {
		this.executeResult = executeResult;
	}

	public String getExecuteUser() {
		return this.executeUser;
	}

	public void setExecuteUser(String executeUser) {
		this.executeUser = executeUser;
	}

	public String getMarketAmount() {
		return this.marketAmount;
	}

	public void setMarketAmount(String marketAmount) {
		this.marketAmount = marketAmount;
	}

	public Date getMarketDate() {
		return this.marketDate;
	}

	public void setMarketDate(Date marketDate) {
		this.marketDate = marketDate;
	}

	public String getMarketId() {
		return this.marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Date getPushDate() {
		return this.pushDate;
	}

	public void setPushDate(Date pushDate) {
		this.pushDate = pushDate;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTouchState() {
		return this.touchState;
	}

	public void setTouchState(String touchState) {
		this.touchState = touchState;
	}

}