package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityCategory
 * @类描述: 商品类目数据实体类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:39:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_COMMODITY_CATEGORY")
public class LoyQyCommodityCategory extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "DATA_ID", unique = true, nullable = false, length = 50)
	private String dataId;
	
	/** 类目编号 **/
	@Column(name = "CATEGORY_CODE", unique = false, nullable = false, length = 100)
	private String categoryCode;
	
	/** 类目名称 **/
	@Column(name = "CATEGORY_NAME", unique = false, nullable = true, length = 100)
	private String categoryName;
	
	/** 类目顺序号 **/
	@Column(name = "CATEGORY_SEQ", unique = false, nullable = true, length = 100)
	private String categorySeq;
	
	/** 层级 **/
	@Column(name = "CATEGORY_LEVEL", unique = false, nullable = true, length = 10)
	private String categoryLevel;
	
	/** 类目类型 **/
	@Column(name = "CATEGORY_TYPE", unique = false, nullable = true, length = 100)
	private String categoryType;
	
	/** 金融机构编号 **/
	@Column(name = "INSTU_CDE", unique = false, nullable = true, length = 30)
	private String instuCde;
	
	/** 上级类目编号 **/
	@Column(name = "PARENT_CATEGORY_CODE", unique = false, nullable = true, length = 100)
	private String parentCategoryCode;
	
	/** 上级类目名称 **/
	@Column(name = "PARENT_CATEGORY_NAME", unique = false, nullable = true, length = 20)
	private String parentCategoryName;
	
	/** 类目状态 **/
	@Column(name = "CATEGORY_STATUS", unique = false, nullable = true, length = 20)
	private String categoryStatus;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
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
	 * @param dataId
	 */
	public void setDataId(String dataId) {
		this.dataId = dataId == null ? null : dataId.trim();
	}
	
    /**
     * @return Id
     */	
	public String getDataId() {
		return this.dataId;
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
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}
	
    /**
     * @return CategoryName
     */	
	public String getCategoryName() {
		return this.categoryName;
	}
	
	/**
	 * @param categorySeq
	 */
	public void setCategorySeq(String categorySeq) {
		this.categorySeq = categorySeq == null ? null : categorySeq.trim();
	}
	
    /**
     * @return CategorySeq
     */	
	public String getCategorySeq() {
		return this.categorySeq;
	}
	
	/**
	 * @param categoryLevel
	 */
	public void setCategoryLevel(String categoryLevel) {
		this.categoryLevel = categoryLevel == null ? null : categoryLevel.trim();
	}
	
    /**
     * @return CategoryLevel
     */	
	public String getCategoryLevel() {
		return this.categoryLevel;
	}
	
	/**
	 * @param categoryType
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType == null ? null : categoryType.trim();
	}
	
    /**
     * @return CategoryType
     */	
	public String getCategoryType() {
		return this.categoryType;
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
	 * @param parentCategoryCode
	 */
	public void setParentCategoryCode(String parentCategoryCode) {
		this.parentCategoryCode = parentCategoryCode == null ? null : parentCategoryCode.trim();
	}
	
    /**
     * @return ParentCategoryCode
     */	
	public String getParentCategoryCode() {
		return this.parentCategoryCode;
	}
	
	/**
	 * @param parentCategoryName
	 */
	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName == null ? null : parentCategoryName.trim();
	}
	
    /**
     * @return ParentCategoryName
     */	
	public String getParentCategoryName() {
		return this.parentCategoryName;
	}
	
	/**
	 * @param categoryStatus
	 */
	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus == null ? null : categoryStatus.trim();
	}
	
    /**
     * @return CategoryStatus
     */	
	public String getCategoryStatus() {
		return this.categoryStatus;
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
        LoyQyCommodityCategory other = (LoyQyCommodityCategory) that;
		return (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
        	&& (this.getCategoryCode() == null ? other.getCategoryCode() == null : this.getCategoryCode().equals(other.getCategoryCode()))
        	&& (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
        	&& (this.getCategorySeq() == null ? other.getCategorySeq() == null : this.getCategorySeq().equals(other.getCategorySeq()))
        	&& (this.getCategoryLevel() == null ? other.getCategoryLevel() == null : this.getCategoryLevel().equals(other.getCategoryLevel()))
        	&& (this.getCategoryType() == null ? other.getCategoryType() == null : this.getCategoryType().equals(other.getCategoryType()))
        	&& (this.getInstuCde() == null ? other.getInstuCde() == null : this.getInstuCde().equals(other.getInstuCde()))
        	&& (this.getParentCategoryCode() == null ? other.getParentCategoryCode() == null : this.getParentCategoryCode().equals(other.getParentCategoryCode()))
        	&& (this.getParentCategoryName() == null ? other.getParentCategoryName() == null : this.getParentCategoryName().equals(other.getParentCategoryName()))
        	&& (this.getCategoryStatus() == null ? other.getCategoryStatus() == null : this.getCategoryStatus().equals(other.getCategoryStatus()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
        	&& (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
        	&& (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
        	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getCategoryCode() == null) ? 0 : getCategoryCode().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getCategorySeq() == null) ? 0 : getCategorySeq().hashCode());
        result = prime * result + ((getCategoryLevel() == null) ? 0 : getCategoryLevel().hashCode());
        result = prime * result + ((getCategoryType() == null) ? 0 : getCategoryType().hashCode());
        result = prime * result + ((getInstuCde() == null) ? 0 : getInstuCde().hashCode());
        result = prime * result + ((getParentCategoryCode() == null) ? 0 : getParentCategoryCode().hashCode());
        result = prime * result + ((getParentCategoryName() == null) ? 0 : getParentCategoryName().hashCode());
        result = prime * result + ((getCategoryStatus() == null) ? 0 : getCategoryStatus().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
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
		sb.append(", dataId=").append(dataId);
		sb.append(", categoryCode=").append(categoryCode);
		sb.append(", categoryName=").append(categoryName);
		sb.append(", categorySeq=").append(categorySeq);
		sb.append(", categoryLevel=").append(categoryLevel);
		sb.append(", categoryType=").append(categoryType);
		sb.append(", instuCde=").append(instuCde);
		sb.append(", parentCategoryCode=").append(parentCategoryCode);
		sb.append(", parentCategoryName=").append(parentCategoryName);
		sb.append(", categoryStatus=").append(categoryStatus);
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