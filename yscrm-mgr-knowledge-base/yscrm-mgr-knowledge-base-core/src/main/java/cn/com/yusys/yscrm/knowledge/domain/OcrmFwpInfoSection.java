package cn.com.yusys.yscrm.knowledge.domain;

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
 * @项目名称: yscrm-mgr-knowledge-base-core模块
 * @类名称: OcrmFwpInfoSection
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-30 17:50:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_INFO_SECTION")
public class OcrmFwpInfoSection extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 栏目编号 **/
	@Id
	@Column(name = "SECTION_ID")
	@Generated(GenerationType.UUID)
	private String sectionId;
	
	/** 栏目名称 **/
	@Column(name = "SECTION_NAME", unique = false, nullable = true, length = 200)
	private String sectionName;
	
	/** 父类栏目编号 **/
	@Column(name = "PARENT_SECTION", unique = false, nullable = true, length = 100)
	private String parentSection;
	
	/** 序号 **/
	@Column(name = "SECTION_SORT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal sectionSort;
	
	/** 创建机构编号 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
	private String createOrg;
	
	/** 创建机构名称 **/
	@Column(name = "CREATE_ORG_NAME", unique = false, nullable = true, length = 100)
	private String createOrgName;
	
	/** 创建者 **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 32)
	private String creator;
	
	/** 创建人 **/
	@Column(name = "CREATOR_NAME", unique = false, nullable = true, length = 50)
	private String creatorName;
	
	/** 创建时间 **/
	@Transient
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	private Date createTime;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 是否删除 **/
	@Column(name = "IS_DELETE", unique = false, nullable = true, length = 2)
	private String isDelete;
	
	
	/**
	 * @param sectionId
	 */
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId == null ? null : sectionId.trim();
	}
	
    /**
     * @return SectionId
     */	
	public String getSectionId() {
		return this.sectionId;
	}
	
	/**
	 * @param sectionName
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName == null ? null : sectionName.trim();
	}
	
    /**
     * @return SectionName
     */	
	public String getSectionName() {
		return this.sectionName;
	}
	
	/**
	 * @param parentSection
	 */
	public void setParentSection(String parentSection) {
		this.parentSection = parentSection == null ? null : parentSection.trim();
	}
	
    /**
     * @return ParentSection
     */	
	public String getParentSection() {
		return this.parentSection;
	}
	
	/**
	 * @param sectionSort
	 */
	public void setSectionSort(java.math.BigDecimal sectionSort) {
		this.sectionSort = sectionSort;
	}
	
    /**
     * @return SectionSort
     */	
	public java.math.BigDecimal getSectionSort() {
		return this.sectionSort;
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
	 * @param createOrgName
	 */
	public void setCreateOrgName(String createOrgName) {
		this.createOrgName = createOrgName == null ? null : createOrgName.trim();
	}
	
    /**
     * @return CreateOrgName
     */	
	public String getCreateOrgName() {
		return this.createOrgName;
	}
	
	/**
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator == null ? null : creator.trim();
	}
	
    /**
     * @return Creator
     */	
	public String getCreator() {
		return this.creator;
	}
	
	/**
	 * @param creatorName
	 */
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName == null ? null : creatorName.trim();
	}
	
    /**
     * @return CreatorName
     */	
	public String getCreatorName() {
		return this.creatorName;
	}
	
	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
    /**
     * @return CreateTime
     */	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param isDelete
	 */
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}
	
    /**
     * @return IsDelete
     */	
	public String getIsDelete() {
		return this.isDelete;
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
        OcrmFwpInfoSection other = (OcrmFwpInfoSection) that;
		return (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
        	&& (this.getSectionName() == null ? other.getSectionName() == null : this.getSectionName().equals(other.getSectionName()))
        	&& (this.getParentSection() == null ? other.getParentSection() == null : this.getParentSection().equals(other.getParentSection()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getCreateOrgName() == null ? other.getCreateOrgName() == null : this.getCreateOrgName().equals(other.getCreateOrgName()))
        	&& (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
        	&& (this.getCreatorName() == null ? other.getCreatorName() == null : this.getCreatorName().equals(other.getCreatorName()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getSectionName() == null) ? 0 : getSectionName().hashCode());
        result = prime * result + ((getParentSection() == null) ? 0 : getParentSection().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getCreateOrgName() == null) ? 0 : getCreateOrgName().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorName() == null) ? 0 : getCreatorName().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", sectionId=").append(sectionId);
		sb.append(", sectionName=").append(sectionName);
		sb.append(", parentSection=").append(parentSection);
		sb.append(", sectionSort=").append(sectionSort);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", createOrgName=").append(createOrgName);
		sb.append(", creator=").append(creator);
		sb.append(", creatorName=").append(creatorName);
		sb.append(", createTime=").append(createTime);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}