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
 * @类名称: LoyQyVirtTicket
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-02-22 16:07:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_VIRT_TICKET")
public class LoyQyVirtTicket extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "TICKET_ID")
	@Generated(GenerationType.UUID)
	private String ticketId;
	
	/** 票券名称 **/
	@Column(name = "TICKET_NAME", unique = false, nullable = false, length = 200)
	private String ticketName;
	
	/** 商户编号 **/
	@Column(name = "MERCHANT_NO", unique = false, nullable = false, length = 100)
	private String merchantNo;
	
	/** 票券类型 数据字典：1-红包，2-折扣券，3-抵扣券，4-积分倍数券，5-兑换券； **/
	@Column(name = "TICKET_TYPE", unique = false, nullable = false, length = 10)
	private String ticketType;
	
	/** 使用条件 **/
	@Column(name = "USE_CONDITION", unique = false, nullable = false, length = 1000)
	private String useCondition;
	
	/** 领取方式  数据字典：1-主动领取；2-被动领取； **/
	@Column(name = "RECEIVE_TYPE", unique = false, nullable = false, length = 10)
	private String receiveType;
	
	/** 使用说明 **/
	@Column(name = "USE_REMARK", unique = false, nullable = true, length = 2000)
	private String useRemark;
	
	/** 金融机构编号 **/
	@Column(name = "INSTU_ID", unique = false, nullable = false, length = 32)
	private String instuId;
	
	/** 审批状态 **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = false, length = 20)
	private String wfApprSts;
	
	/** 适用机构 **/
	@Column(name = "SUIT_ORG", unique = false, nullable = false, length = 100)
	private String suitOrg;
	
	/** 生效状态  数据字典：A-生效；I-失效；W-待生效 **/
	@Column(name = "TICKET_STATUS", unique = false, nullable = false, length = 10)
	private String ticketStatus;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
//	@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改日期 **/
//	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	/** 票圈编号 **/
	@Column(name = "TICKET_NO", unique = false, nullable = false, length = 40)
	private String ticketNo;
	
	/** 总库存 **/
	@Column(name = "TOTAL_NUM", unique = false, nullable = false, length = 10)
	private long totalNum;
	
	/** 票券类目 **/
	@Column(name = "KIND_ID", unique = false, nullable = false, length = 40)
	private String kindId;
	
	public String getKindId() {
		return kindId;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
	}

	/**
	 * @param ticketId
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId == null ? null : ticketId.trim();
	}
	
    /**
     * @return TicketId
     */	
	public String getTicketId() {
		return this.ticketId;
	}
	
	/**
	 * @param ticketName
	 */
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName == null ? null : ticketName.trim();
	}
	
    /**
     * @return TicketName
     */	
	public String getTicketName() {
		return this.ticketName;
	}
	
	/**
	 * @param merchantNo
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo == null ? null : merchantNo.trim();
	}
	
    /**
     * @return MerchantNo
     */	
	public String getMerchantNo() {
		return this.merchantNo;
	}
	
	/**
	 * @param ticketType
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType == null ? null : ticketType.trim();
	}
	
    /**
     * @return TicketType
     */	
	public String getTicketType() {
		return this.ticketType;
	}
	
	/**
	 * @param useCondition
	 */
	public void setUseCondition(String useCondition) {
		this.useCondition = useCondition == null ? null : useCondition.trim();
	}
	
    /**
     * @return UseCondition
     */	
	public String getUseCondition() {
		return this.useCondition;
	}
	
	/**
	 * @param receiveType
	 */
	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType == null ? null : receiveType.trim();
	}
	
    /**
     * @return ReceiveType
     */	
	public String getReceiveType() {
		return this.receiveType;
	}
	
	/**
	 * @param useRemark
	 */
	public void setUseRemark(String useRemark) {
		this.useRemark = useRemark == null ? null : useRemark.trim();
	}
	
    /**
     * @return UseRemark
     */	
	public String getUseRemark() {
		return this.useRemark;
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
	
	/**
	 * @param suitOrg
	 */
	public void setSuitOrg(String suitOrg) {
		this.suitOrg = suitOrg == null ? null : suitOrg.trim();
	}
	
    /**
     * @return SuitOrg
     */	
	public String getSuitOrg() {
		return this.suitOrg;
	}
	
	/**
	 * @param ticketStatus
	 */
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus == null ? null : ticketStatus.trim();
	}
	
    /**
     * @return TicketStatus
     */	
	public String getTicketStatus() {
		return this.ticketStatus;
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
	 * @param totalNum
	 */
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	
    /**
     * @return TotalNum
     */	
	public long getTotalNum() {
		return this.totalNum;
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
        LoyQyVirtTicket other = (LoyQyVirtTicket) that;
		return (this.getTicketId() == null ? other.getTicketId() == null : this.getTicketId().equals(other.getTicketId()))
        	&& (this.getTicketName() == null ? other.getTicketName() == null : this.getTicketName().equals(other.getTicketName()))
        	&& (this.getMerchantNo() == null ? other.getMerchantNo() == null : this.getMerchantNo().equals(other.getMerchantNo()))
        	&& (this.getTicketType() == null ? other.getTicketType() == null : this.getTicketType().equals(other.getTicketType()))
        	&& (this.getUseCondition() == null ? other.getUseCondition() == null : this.getUseCondition().equals(other.getUseCondition()))
        	&& (this.getReceiveType() == null ? other.getReceiveType() == null : this.getReceiveType().equals(other.getReceiveType()))
        	&& (this.getUseRemark() == null ? other.getUseRemark() == null : this.getUseRemark().equals(other.getUseRemark()))
        	&& (this.getInstuId() == null ? other.getInstuId() == null : this.getInstuId().equals(other.getInstuId()))
        	&& (this.getWfApprSts() == null ? other.getWfApprSts() == null : this.getWfApprSts().equals(other.getWfApprSts()))
        	&& (this.getSuitOrg() == null ? other.getSuitOrg() == null : this.getSuitOrg().equals(other.getSuitOrg()))
        	&& (this.getTicketStatus() == null ? other.getTicketStatus() == null : this.getTicketStatus().equals(other.getTicketStatus()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        	&& (this.getTicketNo() == null ? other.getTicketNo() == null : this.getTicketNo().equals(other.getTicketNo()))
        	&& (this.getKindId() == null ? other.getKindId() == null : this.getKindId().equals(other.getKindId()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTicketId() == null) ? 0 : getTicketId().hashCode());
        result = prime * result + ((getTicketName() == null) ? 0 : getTicketName().hashCode());
        result = prime * result + ((getMerchantNo() == null) ? 0 : getMerchantNo().hashCode());
        result = prime * result + ((getTicketType() == null) ? 0 : getTicketType().hashCode());
        result = prime * result + ((getUseCondition() == null) ? 0 : getUseCondition().hashCode());
        result = prime * result + ((getReceiveType() == null) ? 0 : getReceiveType().hashCode());
        result = prime * result + ((getUseRemark() == null) ? 0 : getUseRemark().hashCode());
        result = prime * result + ((getInstuId() == null) ? 0 : getInstuId().hashCode());
        result = prime * result + ((getWfApprSts() == null) ? 0 : getWfApprSts().hashCode());
        result = prime * result + ((getSuitOrg() == null) ? 0 : getSuitOrg().hashCode());
        result = prime * result + ((getTicketStatus() == null) ? 0 : getTicketStatus().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getTicketNo() == null) ? 0 : getTicketNo().hashCode());
        result = prime * result + ((getKindId() == null) ? 0 : getKindId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", ticketId=").append(ticketId);
		sb.append(", ticketName=").append(ticketName);
		sb.append(", merchantNo=").append(merchantNo);
		sb.append(", ticketType=").append(ticketType);
		sb.append(", useCondition=").append(useCondition);
		sb.append(", receiveType=").append(receiveType);
		sb.append(", useRemark=").append(useRemark);
		sb.append(", instuId=").append(instuId);
		sb.append(", wfApprSts=").append(wfApprSts);
		sb.append(", suitOrg=").append(suitOrg);
		sb.append(", ticketStatus=").append(ticketStatus);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", ticketNo=").append(ticketNo);
		sb.append(", totalNum=").append(totalNum);
		sb.append(", kindId=").append(kindId);
        sb.append("]");
        return sb.toString();
    }
}