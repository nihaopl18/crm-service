package cn.com.yusys.climp.trial.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yusp-climp-trial模块
 * @类名称: LoyEngTrialBatch
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-01-04 15:11:32
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_TRIAL_BATCH")
public class LoyEngTrialBatch extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 试算批次 **/
	@Column(name = "BNO", unique = true, nullable = true, length = 32)
	private String bno;
	
	/** 试算状态（排队中、计算中、计算完成） **/
	@Column(name = "STATUS", unique = true, nullable = true, length = 10)
	private String status;
	
	/** 试算总分 **/
	@Column(name = "SCORE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal score;
	
	/** 更新时间 **/
	@Column(name = "UPDATE_TIME", unique = false, nullable = true, length = 20)
	private String updateTime;
	
	/** 活动ID **/
	@Column(name = "ACTIVITY_ID", unique = true, nullable = true, length = 20)
	private String activityId;
	
	/** 活动名称 **/
	@Column(name = "ACTIVITY_NAME", unique = true, nullable = true, length = 100)
	private String activityName;
	
	/** 试算待积流水表 **/
	@Column(name = "TRIAL_WAIT_TABLE", unique = true, nullable = true, length = 100)
	private String trialWaitTable;
	
	/** 交易类型 **/
	@Column(name = "TRANSACTION_CODE", unique = true, nullable = true, length = 10)
	private String transactionCode;
	
	/** 总交易记录数 **/
	@Column(name = "ALL_DATA_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal allDataNum;
	
	/** 参与记录数 **/
	@Column(name = "HIT_DATA_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal hitDataNum;
	
	/** 参与客户数 **/
	@Column(name = "CUST_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal custNum;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param bno
	 */
	public void setBno(String bno) {
		this.bno = bno == null ? null : bno.trim();
	}
	
    /**
     * @return Bno
     */	
	public String getBno() {
		return this.bno;
	}
	
	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
	
    /**
     * @return Status
     */	
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * @param score
	 */
	public void setScore(java.math.BigDecimal score) {
		this.score = score;
	}
	
    /**
     * @return Score
     */	
	public java.math.BigDecimal getScore() {
		return this.score;
	}
	
	/**
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}
	
    /**
     * @return UpdateTime
     */	
	public String getUpdateTime() {
		return this.updateTime;
	}
	
	/**
	 * @param activityId
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId == null ? null : activityId.trim();
	}
	
    /**
     * @return ActivityId
     */	
	public String getActivityId() {
		return this.activityId;
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
	 * @param trialWaitTable
	 */
	public void setTrialWaitTable(String trialWaitTable) {
		this.trialWaitTable = trialWaitTable == null ? null : trialWaitTable.trim();
	}
	
    /**
     * @return TrialWaitTable
     */	
	public String getTrialWaitTable() {
		return this.trialWaitTable;
	}
	
	/**
	 * @param transactionCode
	 */
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode == null ? null : transactionCode.trim();
	}
	
    /**
     * @return TransactionCode
     */	
	public String getTransactionCode() {
		return this.transactionCode;
	}
	
	/**
	 * @param allDataNum
	 */
	public void setAllDataNum(java.math.BigDecimal allDataNum) {
		this.allDataNum = allDataNum;
	}
	
    /**
     * @return AllDataNum
     */	
	public java.math.BigDecimal getAllDataNum() {
		return this.allDataNum;
	}
	
	/**
	 * @param hitDataNum
	 */
	public void setHitDataNum(java.math.BigDecimal hitDataNum) {
		this.hitDataNum = hitDataNum;
	}
	
    /**
     * @return HitDataNum
     */	
	public java.math.BigDecimal getHitDataNum() {
		return this.hitDataNum;
	}
	
	/**
	 * @param custNum
	 */
	public void setCustNum(java.math.BigDecimal custNum) {
		this.custNum = custNum;
	}
	
    /**
     * @return CustNum
     */	
	public java.math.BigDecimal getCustNum() {
		return this.custNum;
	}


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LoyEngTrialBatch other = (LoyEngTrialBatch) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getBno() == null ? other.getBno() == null : this.getBno().equals(other.getBno()))
        	&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                	&& (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
        	&& (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
        	&& (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
        	&& (this.getTrialWaitTable() == null ? other.getTrialWaitTable() == null : this.getTrialWaitTable().equals(other.getTrialWaitTable()))
        	&& (this.getTransactionCode() == null ? other.getTransactionCode() == null : this.getTransactionCode().equals(other.getTransactionCode()))
                                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBno() == null) ? 0 : getBno().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getTrialWaitTable() == null) ? 0 : getTrialWaitTable().hashCode());
        result = prime * result + ((getTransactionCode() == null) ? 0 : getTransactionCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", bno=").append(bno);
		sb.append(", status=").append(status);
		sb.append(", score=").append(score);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", activityId=").append(activityId);
		sb.append(", activityName=").append(activityName);
		sb.append(", trialWaitTable=").append(trialWaitTable);
		sb.append(", transactionCode=").append(transactionCode);
		sb.append(", allDataNum=").append(allDataNum);
		sb.append(", hitDataNum=").append(hitDataNum);
		sb.append(", custNum=").append(custNum);
        sb.append("]");
        return sb.toString();
    }
}