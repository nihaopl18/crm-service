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
 * @类名称: LoyQyVirtStock
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-02-22 16:08:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_VIRT_STOCK")
public class LoyQyVirtStock extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** STOCK_ID **/
	@Id
	@Column(name = "STOCK_ID")
	@Generated(GenerationType.UUID)
	private String stockId;
	
	/** 票券编号 **/
	@Column(name = "TICKET_NO", unique = false, nullable = true, length = 40)
	private String ticketNo;
	
	/** 虚拟识别码 **/
	@Column(name = "VIRT_NO", unique = false, nullable = true, length = 100)
	private String virtNo;
	
	/** 使用密码 **/
	@Column(name = "VIRT_PWD", unique = false, nullable = true, length = 100)
	private String virtPwd;
	
	/** 批次号 **/
	@Column(name = "BATCH_NO", unique = false, nullable = true, length = 30)
	private String batchNo;
	
	/** 使用状态 数据字典：0-未发货，1-已发货，2-已使用；3-未使用； **/
	@Column(name = "USED_STS", unique = false, nullable = true, length = 10)
	private String usedSts;
	
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
	
	
	/**
	 * @param stockId
	 */
	public void setStockId(String stockId) {
		this.stockId = stockId == null ? null : stockId.trim();
	}
	
    /**
     * @return StockId
     */	
	public String getStockId() {
		return this.stockId;
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
	 * @param virtNo
	 */
	public void setVirtNo(String virtNo) {
		this.virtNo = virtNo == null ? null : virtNo.trim();
	}
	
    /**
     * @return VirtNo
     */	
	public String getVirtNo() {
		return this.virtNo;
	}
	
	/**
	 * @param virtPwd
	 */
	public void setVirtPwd(String virtPwd) {
		this.virtPwd = virtPwd == null ? null : virtPwd.trim();
	}
	
    /**
     * @return VirtPwd
     */	
	public String getVirtPwd() {
		return this.virtPwd;
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
	 * @param usedSts
	 */
	public void setUsedSts(String usedSts) {
		this.usedSts = usedSts == null ? null : usedSts.trim();
	}
	
    /**
     * @return UsedSts
     */	
	public String getUsedSts() {
		return this.usedSts;
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
        LoyQyVirtStock other = (LoyQyVirtStock) that;
		return (this.getStockId() == null ? other.getStockId() == null : this.getStockId().equals(other.getStockId()))
        	&& (this.getTicketNo() == null ? other.getTicketNo() == null : this.getTicketNo().equals(other.getTicketNo()))
        	&& (this.getVirtNo() == null ? other.getVirtNo() == null : this.getVirtNo().equals(other.getVirtNo()))
        	&& (this.getVirtPwd() == null ? other.getVirtPwd() == null : this.getVirtPwd().equals(other.getVirtPwd()))
        	&& (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
        	&& (this.getUsedSts() == null ? other.getUsedSts() == null : this.getUsedSts().equals(other.getUsedSts()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStockId() == null) ? 0 : getStockId().hashCode());
        result = prime * result + ((getTicketNo() == null) ? 0 : getTicketNo().hashCode());
        result = prime * result + ((getVirtNo() == null) ? 0 : getVirtNo().hashCode());
        result = prime * result + ((getVirtPwd() == null) ? 0 : getVirtPwd().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        result = prime * result + ((getUsedSts() == null) ? 0 : getUsedSts().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", stockId=").append(stockId);
		sb.append(", ticketNo=").append(ticketNo);
		sb.append(", virtNo=").append(virtNo);
		sb.append(", virtPwd=").append(virtPwd);
		sb.append(", batchNo=").append(batchNo);
		sb.append(", usedSts=").append(usedSts);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
        sb.append("]");
        return sb.toString();
    }
}