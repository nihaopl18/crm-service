package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyGiftInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-21 17:29:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_GIFT_INFO")
public class LoyQyGiftInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "GIFT_ID", unique = false, nullable = false, length = 32)
	private String giftId;
	
	/** 礼品编号 **/
	@Column(name = "GIFT_NO", unique = false, nullable = true, length = 50)
	private String giftNo;
	
	/** 礼品名称 **/
	@Column(name = "GIFT_NAME", unique = false, nullable = true, length = 200)
	private String giftName;
	
	/** 礼品来源（1-本行维护 2-认领3-礼品退货，如有扩展依序增加） **/
	@Column(name = "SOURCE", unique = false, nullable = true, length = 10)
	private String source;
	
	/** 礼品类别 **/
	@Column(name = "GIFT_TYPE_ID", unique = false, nullable = true, length = 10)
	private String giftTypeId;
	
	/** 礼品价格 **/
	@Column(name = "GIFT_PRICE", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal giftPrice;
	
	/** 礼品成本 **/
	@Column(name = "GIFT_COST", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal giftCost;
	
	/** 礼品库存 **/
	@Column(name = "GIFT_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal giftNum;
	
	/** 礼品状态（1草稿，2-审核中，3通过，4未通过） **/
	@Column(name = "GIFT_STATUS", unique = false, nullable = true, length = 20)
	private String giftStatus;
	
	/** 上下架标志（1上架，2下架） **/
	@Column(name = "UPPER_FLAG", unique = false, nullable = true, length = 10)
	private String upperFlag;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 256)
	private String remark;
	
	/** 删除标志（0或者空表示未删除，1表示删除） **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 礼品来源机构 **/
	@Column(name = "TARGET_ORG", unique = false, nullable = true, length = 100)
	private String targetOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	private String updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	
	/**
	 * @param giftId
	 */
	public void setGiftId(String giftId) {
		this.giftId = giftId == null ? null : giftId.trim();
	}
	
    /**
     * @return GiftId
     */	
	public String getGiftId() {
		return this.giftId;
	}
	
	/**
	 * @param giftNo
	 */
	public void setGiftNo(String giftNo) {
		this.giftNo = giftNo == null ? null : giftNo.trim();
	}
	
    /**
     * @return GiftNo
     */	
	public String getGiftNo() {
		return this.giftNo;
	}
	
	/**
	 * @param giftName
	 */
	public void setGiftName(String giftName) {
		this.giftName = giftName == null ? null : giftName.trim();
	}
	
    /**
     * @return GiftName
     */	
	public String getGiftName() {
		return this.giftName;
	}
	
	/**
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}
	
    /**
     * @return Source
     */	
	public String getSource() {
		return this.source;
	}
	
	/**
	 * @param giftTypeId
	 */
	public void setGiftTypeId(String giftTypeId) {
		this.giftTypeId = giftTypeId == null ? null : giftTypeId.trim();
	}
	
    /**
     * @return GiftTypeId
     */	
	public String getGiftTypeId() {
		return this.giftTypeId;
	}
	
	/**
	 * @param giftPrice
	 */
	public void setGiftPrice(java.math.BigDecimal giftPrice) {
		this.giftPrice = giftPrice;
	}
	
    /**
     * @return GiftPrice
     */	
	public java.math.BigDecimal getGiftPrice() {
		return this.giftPrice;
	}
	
	/**
	 * @param giftCost
	 */
	public void setGiftCost(java.math.BigDecimal giftCost) {
		this.giftCost = giftCost;
	}
	
    /**
     * @return GiftCost
     */	
	public java.math.BigDecimal getGiftCost() {
		return this.giftCost;
	}
	
	/**
	 * @param giftNum
	 */
	public void setGiftNum(java.math.BigDecimal giftNum) {
		this.giftNum = giftNum;
	}
	
    /**
     * @return GiftNum
     */	
	public java.math.BigDecimal getGiftNum() {
		return this.giftNum;
	}
	
	/**
	 * @param giftStatus
	 */
	public void setGiftStatus(String giftStatus) {
		this.giftStatus = giftStatus == null ? null : giftStatus.trim();
	}
	
    /**
     * @return GiftStatus
     */	
	public String getGiftStatus() {
		return this.giftStatus;
	}
	
	/**
	 * @param upperFlag
	 */
	public void setUpperFlag(String upperFlag) {
		this.upperFlag = upperFlag == null ? null : upperFlag.trim();
	}
	
    /**
     * @return UpperFlag
     */	
	public String getUpperFlag() {
		return this.upperFlag;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * @param deleteSign
	 */
	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign == null ? null : deleteSign.trim();
	}
	
    /**
     * @return DeleteSign
     */	
	public String getDeleteSign() {
		return this.deleteSign;
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
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}
	
    /**
     * @return CreateDate
     */	
	public String getCreateDate() {
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
	 * @param targetOrg
	 */
	public void setTargetOrg(String targetOrg) {
		this.targetOrg = targetOrg == null ? null : targetOrg.trim();
	}
	
    /**
     * @return TargetOrg
     */	
	public String getTargetOrg() {
		return this.targetOrg;
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
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate == null ? null : updateDate.trim();
	}
	
    /**
     * @return UpdateDate
     */	
	public String getUpdateDate() {
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
        LoyQyGiftInfo other = (LoyQyGiftInfo) that;
		return (this.getGiftId() == null ? other.getGiftId() == null : this.getGiftId().equals(other.getGiftId()))
        	&& (this.getGiftNo() == null ? other.getGiftNo() == null : this.getGiftNo().equals(other.getGiftNo()))
        	&& (this.getGiftName() == null ? other.getGiftName() == null : this.getGiftName().equals(other.getGiftName()))
        	&& (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
        	&& (this.getGiftTypeId() == null ? other.getGiftTypeId() == null : this.getGiftTypeId().equals(other.getGiftTypeId()))
                                	&& (this.getGiftStatus() == null ? other.getGiftStatus() == null : this.getGiftStatus().equals(other.getGiftStatus()))
        	&& (this.getUpperFlag() == null ? other.getUpperFlag() == null : this.getUpperFlag().equals(other.getUpperFlag()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
        	&& (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getTargetOrg() == null ? other.getTargetOrg() == null : this.getTargetOrg().equals(other.getTargetOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
        	&& (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
        	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGiftId() == null) ? 0 : getGiftId().hashCode());
        result = prime * result + ((getGiftNo() == null) ? 0 : getGiftNo().hashCode());
        result = prime * result + ((getGiftName() == null) ? 0 : getGiftName().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getGiftTypeId() == null) ? 0 : getGiftTypeId().hashCode());
        result = prime * result + ((getGiftStatus() == null) ? 0 : getGiftStatus().hashCode());
        result = prime * result + ((getUpperFlag() == null) ? 0 : getUpperFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getTargetOrg() == null) ? 0 : getTargetOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", giftId=").append(giftId);
		sb.append(", giftNo=").append(giftNo);
		sb.append(", giftName=").append(giftName);
		sb.append(", source=").append(source);
		sb.append(", giftTypeId=").append(giftTypeId);
		sb.append(", giftPrice=").append(giftPrice);
		sb.append(", giftCost=").append(giftCost);
		sb.append(", giftNum=").append(giftNum);
		sb.append(", giftStatus=").append(giftStatus);
		sb.append(", upperFlag=").append(upperFlag);
		sb.append(", remark=").append(remark);
		sb.append(", deleteSign=").append(deleteSign);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", targetOrg=").append(targetOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
        sb.append("]");
        return sb.toString();
    }
}