package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyVirtBatch
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-02-22 16:09:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_VIRT_BATCH")
public class LoyQyVirtBatch extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** BATCH_ID **/
	@Id
	@Column(name = "BATCH_ID")
	@Generated(GenerationType.UUID)
	private String batchId;
	
	/** 票券编号 **/
	@Column(name = "TICKET_NO", unique = false, nullable = false, length = 40)
	private String ticketNo;
	
	/** 批次号 **/
	@Column(name = "BATCH_NO", unique = false, nullable = false, length = 30)
	private String batchNo;
	
	/** 票券来源类型 **/
	@Column(name = "SOURCE_TYPE", unique = false, nullable = false, length = 10)
	private String sourceType;
	
	/** 总数 **/
	@Column(name = "TICKET_ALL_NUM", unique = false, nullable = false, length = 10)
	private long ticketAllNum;
	
	/** 已使用数量 **/
	@Column(name = "USED_NUM", unique = false, nullable = false, length = 10)
	private long usedNum;
	
	/** 未使用数量 **/
	@Column(name = "UN_USED_NUM", unique = false, nullable = false, length = 10)
	private long unUsedNum;
	
	/** 生效开始日期 **/
	//@Transient
	@Column(name = "VALID_START_DATE", unique = false, nullable = false, length = 7)
	private Date validStartDate;
	
	/** 生效结束日期 **/
	//@Transient
	@Column(name = "VALID_END_DATE", unique = false, nullable = false, length = 7)
	private Date validEndDate;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	//@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改日期 **/
	//@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	/** 已发货数 **/
	@Column(name = "SHIPPED_NUM", unique = false, nullable = false, length = 10)
	private long shippedNum;
	
	/** 未发货数 **/
	@Column(name = "UN_SHIPPED_NUM", unique = false, nullable = false, length = 10)
	private long unShippedNum;
	
	/** 审批状态 **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = false, length = 20)
	private String wfApprSts;
	
	
	/**
	 * @param batchId
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId == null ? null : batchId.trim();
	}
	
    /**
     * @return BatchId
     */	
	public String getBatchId() {
		return this.batchId;
	}
	
	/**
	 * @param ticketNo
	 */
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo == null ? null : ticketNo.trim();
	}
	
    /**
     * @return TicketNo
     */	
	public String getTicketNo() {
		return this.ticketNo;
	}
	
	/**
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo == null ? null : batchNo.trim();
	}
	
    /**
     * @return BatchNo
     */	
	public String getBatchNo() {
		return this.batchNo;
	}
	
	/**
	 * @param sourceType
	 */
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType == null ? null : sourceType.trim();
	}
	
    /**
     * @return sourceType
     */	
	public String getSourceType() {
		return this.sourceType;
	}
	
	/**
	 * @param ticketAllNum
	 */
	public void setTicketAllNum(long ticketAllNum) {
		this.ticketAllNum = ticketAllNum;
	}
	
    /**
     * @return TicketAllNum
     */	
	public long getTicketAllNum() {
		return this.ticketAllNum;
	}
	
	/**
	 * @param usedNum
	 */
	public void setUsedNum(long usedNum) {
		this.usedNum = usedNum;
	}
	
    /**
     * @return UsedNum
     */	
	public long getUsedNum() {
		return this.usedNum;
	}
	
	/**
	 * @param unUsedNum
	 */
	public void setUnUsedNum(long unUsedNum) {
		this.unUsedNum = unUsedNum;
	}
	
    /**
     * @return UnUsedNum
     */	
	public long getUnUsedNum() {
		return this.unUsedNum;
	}
	
	/**
	 * @param validStartDate
	 */
	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}
	
    /**
     * @return ValidStartDate
     */	
	public Date getValidStartDate() {
		return this.validStartDate;
	}
	
	/**
	 * @param validEndDate
	 */
	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}
	
    /**
     * @return ValidEndDate
     */	
	public Date getValidEndDate() {
		return this.validEndDate;
	}
	
	/**
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * @return CreateDate
     */	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}
	
    /**
     * @return UpdateUser
     */	
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
    /**
     * @return UpdateDate
     */	
	public Date getUpdateDate() {
		return this.updateDate;
	}
	
	/**
	 * @param updateOrg
	 */
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}
	
    /**
     * @return UpdateOrg
     */	
	public String getUpdateOrg() {
		return this.updateOrg;
	}
	
	/**
	 * @param shippedNum
	 */
	public void setShippedNum(long shippedNum) {
		this.shippedNum = shippedNum;
	}
	
    /**
     * @return ShippedNum
     */	
	public long getShippedNum() {
		return this.shippedNum;
	}
	
	/**
	 * @param unShippedNum
	 */
	public void setUnShippedNum(long unShippedNum) {
		this.unShippedNum = unShippedNum;
	}
	
    /**
     * @return UnShippedNum
     */	
	public long getUnShippedNum() {
		return this.unShippedNum;
	}
	
	/**
	 * @param wfApprSts
	 */
	public void setWfApprSts(String wfApprSts) {
		this.wfApprSts = wfApprSts == null ? null : wfApprSts.trim();
	}
	
    /**
     * @return WfApprSts
     */	
	public String getWfApprSts() {
		return this.wfApprSts;
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
        LoyQyVirtBatch other = (LoyQyVirtBatch) that;
		return (this.getBatchId() == null ? other.getBatchId() == null : this.getBatchId().equals(other.getBatchId()))
        	&& (this.getTicketNo() == null ? other.getTicketNo() == null : this.getTicketNo().equals(other.getTicketNo()))
        	&& (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
        	&& (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
             && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
                        	&& (this.getWfApprSts() == null ? other.getWfApprSts() == null : this.getWfApprSts().equals(other.getWfApprSts()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBatchId() == null) ? 0 : getBatchId().hashCode());
        result = prime * result + ((getTicketNo() == null) ? 0 : getTicketNo().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getWfApprSts() == null) ? 0 : getWfApprSts().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", batchId=").append(batchId);
		sb.append(", ticketNo=").append(ticketNo);
		sb.append(", batchNo=").append(batchNo);
		sb.append(", sourceType=").append(sourceType);
		sb.append(", ticketAllNum=").append(ticketAllNum);
		sb.append(", usedNum=").append(usedNum);
		sb.append(", unUsedNum=").append(unUsedNum);
		sb.append(", validStartDate=").append(validStartDate);
		sb.append(", validEndDate=").append(validEndDate);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", shippedNum=").append(shippedNum);
		sb.append(", unShippedNum=").append(unShippedNum);
		sb.append(", wfApprSts=").append(wfApprSts);
        sb.append("]");
        return sb.toString();
    }
}