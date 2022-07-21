package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityInfo
 * @类描述: 商品信息数据实体类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:39:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_COMMODITY_INFO")
public class LoyQyCommodityInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	private String id;
	
	/** 商品编号 **/
	@Column(name = "COMMODITY_CODE", unique = false, nullable = false, length = 100)
	private String commodityCode;
	
	/** 商品名称 **/
	@Column(name = "COMMODITY_NAME", unique = false, nullable = true, length = 200)
	private String commodityName;
	
	/** 商品类目编码 **/
	@Column(name = "CATEGORY_CODE", unique = false, nullable = true, length = 50)
	private String categoryCode;
	
	/** 适用对象类型 **/
	@Column(name = "SUIT_OBJ_TYPE", unique = false, nullable = true, length = 4)
	private String suitObjType;
	
	/** 商品类型 **/
	@Column(name = "COMMODITY_TYPE", unique = false, nullable = true, length = 4)
	private String commodityType;
	
	/** 商品链接 **/
	@Column(name = "COMMODITY_LINK", unique = false, nullable = true, length = 200)
	private String commodityLink;
	
	/** 适用金融机构编号 **/
	@Column(name = "INSTU_CDE", unique = false, nullable = true, length = 50)
	private String instuCde;
	
	/** 商品状态 **/
	@Column(name = "UP_DOWN_STATE", unique = false, nullable = true, length = 4)
	private String upDownState;
	
	/** 生效开始日期 **/
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "ON_SHELF_BEGIN", unique = false, nullable = true, length = 20)
	private Date onShelfBegin;
	
	/** 生效结束日期 **/
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "ON_SHELF_END", unique = false, nullable = true, length = 20)
	private Date onShelfEnd;
	
	/** 商品库存数量 **/
	@Column(name = "COMMODITY_STG_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal commodityStgNum;
	
	/** 商品已售数量 **/
	@Column(name = "COMMODITY_SAL_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal commoditySalNum;
	
	/** 库存预警 **/
	@Column(name = "STG_ALARM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal stgAlarm;
	
	/** 商品现金价值 **/
	@Column(name = "COMMODITY_M_VALUE", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal commodityMValue;
	
	/** 商品积分价值 **/
	@Column(name = "COMMODITY_L_VALUE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal commodityLValue;
	
	/** 审批状态 **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = true, length = 4)
	private String wfApprSts;
	
	/** 商品兑换类型 **/
	@Column(name = "COMMODITY_V_FLAG", unique = false, nullable = true, length = 4)
	private String commodityVFlag;
	
	/** 商品说明 **/
	@Column(name = "COMMODITY_DESC", unique = false, nullable = true, length = 3000)
	private String commodityDesc;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 50)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 50)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 50)
	private String updateUser;
	
	/** 最近修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	private String updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 50)
	private String updateOrg;

	/** 所属商户 **/
	@Column(name = "BELONG_MERCHANT", unique = false, nullable = true, length = 50)
	private String belongMerchant;

	/** 适用机构 **/
	@Column(name="SUIT_ORG_ID", unique = false, nullable = true, length = 50)
	private String suitOrgId;

	/** 逻辑删除标志 **/
	@Column(name = "DEL_FLAG", unique = false, nullable = true, length = 4)
	private String delFlag;

	/** 适用对象 **/
	@Column(name = "SUIT_CUST_TYPE", unique = false, nullable = true, length = 100)
	private String suitCustType;

	/** 可供兑换渠道 **/
	@Column(name = "EXCG_CHANNEL", unique = false, nullable = true, length = 100)
	private String excgChannel;

	/** 同一客户单次可兑换数量 **/
	@Column(name = "CHANGE_TIMES", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal changeTimes;

	/** 同一客户可兑换频率 **/
	@Column(name = "CHANGE_FEQ", unique = false, nullable = true, length = 4)
	private String changeFeq;

	/** 商品使用说明模板 **/
	@Column(name = "COMMODITY_DESC_TEMP", unique = false, nullable = true, length = 3000)
	private String commodityDescTemp;

	/** 实物商品提取方式 **/
	@Column(name = "COMMODITY_R_GET_TYPE", unique = false, nullable = true, length = 4)
	private String commodityRGetType;

	/** 是否可退换货 **/
	@Column(name = "IF_CANCEL", unique = false, nullable = true, length = 4)
	private String ifCancel;

	/** 商品使用说明模板 **/
	@Column(name = "IF_RCD", unique = false, nullable = true, length = 3000)
	private String ifRcd;

	/** 商品备注 **/
	@Column(name = "COMMODITY_REMARK", unique = false, nullable = true, length = 200)
	private String commodityRemark;

	/** 限制内容 **/
	@Column(name = "LIMIT_CONTENT", unique = false, nullable = true, length = 200)
	private String limitContent;

	/** 封面简介 **/
	@Column(name = "COVER_SUMMARY", unique = false, nullable = true, length = 200)
	private String coverSummary;

	/**
	 * @param delFlag
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag == null ? null : delFlag.trim();
	}
	
    /**
     * @return Id
     */	
	public String getDelFlag() {
		return this.delFlag;
	}
	
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
	 * @param commodityCode
	 */
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode == null ? null : commodityCode.trim();
	}
	
    /**
     * @return CommodityCode
     */	
	public String getCommodityCode() {
		return this.commodityCode;
	}
	
	/**
	 * @param commodityName
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName == null ? null : commodityName.trim();
	}
	
    /**
     * @return CommodityName
     */	
	public String getCommodityName() {
		return this.commodityName;
	}
	
	/**
	 * @param categoryCode
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode == null ? null : categoryCode.trim();
	}
	
    /**
     * @return CategoryCode
     */	
	public String getCategoryCode() {
		return this.categoryCode;
	}
	
	/**
	 * @param suitObjType
	 */
	public void setSuitObjType(String suitObjType) {
		this.suitObjType = suitObjType == null ? null : suitObjType.trim();
	}
	
    /**
     * @return SuitObjType
     */	
	public String getSuitObjType() {
		return this.suitObjType;
	}
	
	/**
	 * @param commodityType
	 */
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType == null ? null : commodityType.trim();
	}
	
    /**
     * @return CommodityType
     */	
	public String getCommodityType() {
		return this.commodityType;
	}
	
	/**
	 * @param commodityLink
	 */
	public void setCommodityLink(String commodityLink) {
		this.commodityLink = commodityLink == null ? null : commodityLink.trim();
	}
	
    /**
     * @return CommodityLink
     */	
	public String getCommodityLink() {
		return this.commodityLink;
	}
	
	/**
	 * @param instuCde
	 */
	public void setInstuCde(String instuCde) {
		this.instuCde = instuCde == null ? null : instuCde.trim();
	}
	
    /**
     * @return InstuCde
     */	
	public String getInstuCde() {
		return this.instuCde;
	}
	
	/**
	 * @param upDownState
	 */
	public void setUpDownState(String upDownState) {
		this.upDownState = upDownState == null ? null : upDownState.trim();
	}
	
    /**
     * @return UpDownState
     */	
	public String getUpDownState() {
		return this.upDownState;
	}
	
	/**
	 * @param onShelfBegin
	 */
	public void setOnShelfBegin(Date onShelfBegin) {
		this.onShelfBegin = onShelfBegin == null ? null : onShelfBegin;
	}
	
    /**
     * @return OnShelfBegin
     */	
	public Date getOnShelfBegin() {
		return this.onShelfBegin;
	}
	
	/**
	 * @param onShelfEnd
	 */
	public void setOnShelfEnd(Date onShelfEnd) {
		this.onShelfEnd = onShelfEnd == null ? null : onShelfEnd;
	}
	
    /**
     * @return OnShelfEnd
     */	
	public Date getOnShelfEnd() {
		return this.onShelfEnd;
	}
	
	/**
	 * @param commodityStgNum
	 */
	public void setCommodityStgNum(BigDecimal commodityStgNum) {
		this.commodityStgNum = commodityStgNum == null ? BigDecimal.ZERO : commodityStgNum;
	}
	
    /**
     * @return CommodityStgNum
     */	
	public BigDecimal getCommodityStgNum() {
		return this.commodityStgNum;
	}
	
	/**
	 * @param commoditySalNum
	 */
	public void setCommoditySalNum(BigDecimal commoditySalNum) {
		this.commoditySalNum = commoditySalNum == null ? BigDecimal.ZERO : commoditySalNum;
	}
	
    /**
     * @return CommoditySalNum
     */	
	public BigDecimal getCommoditySalNum() {
		return this.commoditySalNum;
	}
	
	/**
	 * @param stgAlarm
	 */
	public void setStgAlarm(BigDecimal stgAlarm) {
		this.stgAlarm = stgAlarm == null ? BigDecimal.ZERO : stgAlarm;
	}
	
    /**
     * @return StgAlarm
     */	
	public java.math.BigDecimal getStgAlarm() {
		return this.stgAlarm;
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
	 * @param commodityDesc
	 */
	public void setCommodityDesc(String commodityDesc) {
		this.commodityDesc = commodityDesc == null ? null : commodityDesc.trim();
	}
	
    /**
     * @return CommodityDesc
     */	
	public String getCommodityDesc() {
		return this.commodityDesc;
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
	
	public String getBelongMerchant() { return this.belongMerchant;}
	public void setBelongMerchant(String belongMerchant) {this.belongMerchant = belongMerchant;}
	
	public String getSuitOrgId() {return this.suitOrgId;}
	public void setSuitOrgId(String suitOrgId) {this.suitOrgId = suitOrgId;}

	public String getSuitCustType() {
		return suitCustType;
	}

	public void setSuitCustType(String suitCustType) {
		this.suitCustType = suitCustType == null ? null : suitCustType;
	}

	public String getExcgChannel() {
		return excgChannel;
	}

	public void setExcgChannel(String excgChannel) {
		this.excgChannel = excgChannel == null ? null : excgChannel;
	}

	public BigDecimal getChangeTimes() {
		return changeTimes;
	}

	public void setChangeTimes(BigDecimal changeTimes) {
		this.changeTimes = changeTimes == null ? BigDecimal.ZERO : changeTimes;
	}

	public String getChangeFeq() {
		return changeFeq;
	}

	public void setChangeFeq(String changeFeq) {
		this.changeFeq = changeFeq;
	}

	public String getCommodityDescTemp() {
		return commodityDescTemp;
	}

	public void setCommodityDescTemp(String commodityDescTemp) {
		this.commodityDescTemp = commodityDescTemp == null ? "" : commodityDescTemp;
	}

	public BigDecimal getCommodityMValue() {
		return commodityMValue;
	}

	public void setCommodityMValue(BigDecimal commodityMValue) {
		this.commodityMValue = commodityMValue;
	}

	public BigDecimal getCommodityLValue() {
		return commodityLValue;
	}

	public void setCommodityLValue(BigDecimal commodityLValue) {
		this.commodityLValue = commodityLValue;
	}

	public String getCommodityVFlag() {
		return commodityVFlag;
	}

	public void setCommodityVFlag(String commodityVFlag) {
		this.commodityVFlag = commodityVFlag;
	}

	public String getCommodityRGetType() {
		return commodityRGetType;
	}

	public void setCommodityRGetType(String commodityRGetType) {
		this.commodityRGetType = commodityRGetType;
	}

	public String getIfCancel() {
		return ifCancel;
	}

	public void setIfCancel(String ifCancel) {
		this.ifCancel = ifCancel;
	}

	public String getIfRcd() {
		return ifRcd;
	}

	public void setIfRcd(String ifRcd) {
		this.ifRcd = ifRcd;
	}

	public String getCommodityRemark() {
		return commodityRemark;
	}

	public void setCommodityRemark(String commodityRemark) {
		this.commodityRemark = commodityRemark;
	}

	public String getLimitContent() {
		return limitContent;
	}

	public void setLimitContent(String limitContent) {
		this.limitContent = limitContent;
	}

	public String getCoverSummary() {
		return coverSummary;
	}

	public void setCoverSummary(String coverSummary) {
		this.coverSummary = coverSummary;
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
        LoyQyCommodityInfo other = (LoyQyCommodityInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCommodityCode() == null ? other.getCommodityCode() == null : this.getCommodityCode().equals(other.getCommodityCode()))
        	&& (this.getCommodityName() == null ? other.getCommodityName() == null : this.getCommodityName().equals(other.getCommodityName()))
        	&& (this.getCategoryCode() == null ? other.getCategoryCode() == null : this.getCategoryCode().equals(other.getCategoryCode()))
        	&& (this.getSuitObjType() == null ? other.getSuitObjType() == null : this.getSuitObjType().equals(other.getSuitObjType()))
        	&& (this.getCommodityType() == null ? other.getCommodityType() == null : this.getCommodityType().equals(other.getCommodityType()))
        	&& (this.getCommodityLink() == null ? other.getCommodityLink() == null : this.getCommodityLink().equals(other.getCommodityLink()))
        	&& (this.getInstuCde() == null ? other.getInstuCde() == null : this.getInstuCde().equals(other.getInstuCde()))
        	&& (this.getUpDownState() == null ? other.getUpDownState() == null : this.getUpDownState().equals(other.getUpDownState()))
			&& (this.getStgAlarm() == null ? other.getStgAlarm() == null : this.getStgAlarm().equals(other.getStgAlarm()))
            && (this.getWfApprSts() == null ? other.getWfApprSts() == null : this.getWfApprSts().equals(other.getWfApprSts()))
        	&& (this.getCommodityDesc() == null ? other.getCommodityDesc() == null : this.getCommodityDesc().equals(other.getCommodityDesc()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
        	&& (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
        	&& (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
        	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
			&& (this.getSuitCustType() == null ? other.getSuitCustType() == null : this.getSuitCustType().equals(other.getSuitCustType()))
			&& (this.getExcgChannel() == null ? other.getExcgChannel() == null : this.getExcgChannel().equals(other.getExcgChannel()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCommodityCode() == null) ? 0 : getCommodityCode().hashCode());
        result = prime * result + ((getCommodityName() == null) ? 0 : getCommodityName().hashCode());
        result = prime * result + ((getCategoryCode() == null) ? 0 : getCategoryCode().hashCode());
        result = prime * result + ((getSuitObjType() == null) ? 0 : getSuitObjType().hashCode());
        result = prime * result + ((getCommodityType() == null) ? 0 : getCommodityType().hashCode());
        result = prime * result + ((getCommodityLink() == null) ? 0 : getCommodityLink().hashCode());
        result = prime * result + ((getInstuCde() == null) ? 0 : getInstuCde().hashCode());
        result = prime * result + ((getUpDownState() == null) ? 0 : getUpDownState().hashCode());
        result = prime * result + ((getStgAlarm() == null) ? 0 : getStgAlarm().hashCode());
        result = prime * result + ((getWfApprSts() == null) ? 0 : getWfApprSts().hashCode());
        result = prime * result + ((getCommodityDesc() == null) ? 0 : getCommodityDesc().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
		result = prime * result + ((getSuitCustType() == null) ? 0 : getSuitCustType().hashCode());
		result = prime * result + ((getExcgChannel() == null) ? 0 : getExcgChannel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", commodityCode=").append(commodityCode);
		sb.append(", commodityName=").append(commodityName);
		sb.append(", categoryCode=").append(categoryCode);
		sb.append(", suitObjType=").append(suitObjType);
		sb.append(", commodityType=").append(commodityType);
		sb.append(", commodityLink=").append(commodityLink);
		sb.append(", instuCde=").append(instuCde);
		sb.append(", upDownState=").append(upDownState);
		sb.append(", stgAlarm=").append(stgAlarm);
		sb.append(", wfApprSts=").append(wfApprSts);
		sb.append(", commodityDesc=").append(commodityDesc);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", suitCustType=").append(suitCustType);
		sb.append(", excgChannel=").append(excgChannel);
        sb.append("]");
        return sb.toString();
    }
}