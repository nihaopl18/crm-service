package cn.com.yusys.yscrm.knowledge.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-knowledge-base-core模块
 * @类名称: OcrmFwpInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-30 17:48:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_INFO")
public class OcrmFwpInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 知识编号 **/
	@Id
	@Column(name = "MESSAGE_ID")
	@Generated(GenerationType.UUID)
	private String messageId;
	
	/** 栏目编号 **/
	@Column(name = "SECTION_ID", unique = false, nullable = true, length = 32)
	private String sectionId;
	
	/** 文档名称 **/
	@Column(name = "MESSAGE_TITLE", unique = false, nullable = true, length = 1000)
	private String messageTitle;
	
	/** 文档描述 **/
	@Column(name = "MESSAGE_INTRODUCE", unique = false, nullable = true, length = 2000)
	private String messageIntroduce;
	
	/** 共享范围 **/
	@Column(name = "PUBLIC_TYPE", unique = false, nullable = true, length = 10)
	private String publicType;
	
	/** 发布状态 **/
	@Column(name = "PUBLISH_TYPE", unique = false, nullable = true, length = 10)
	private String publishType;
	
	/** 发布日期 **/
	@Column(name = "PUBLISH_DATE", unique = false, nullable = true, length = 20)
	private String publishDate;
	
	/** 发布者 **/
	@Column(name = "PUBLISH_USER", unique = false, nullable = true, length = 30)
	private String publishUser;
	
	/** 发布者名称 **/
	@Column(name = "PUBLISH_USER_NAME", unique = false, nullable = true, length = 80)
	private String publishUserName;
	
	/** 发布机构 **/
	@Column(name = "PUBLISH_ORG", unique = false, nullable = true, length = 30)
	private String publishOrg;
	
	/** 发布机构名称 **/
	@Column(name = "PUBLISH_ORG_NAME", unique = false, nullable = true, length = 100)
	private String publishOrgName;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 是否删除 **/
	@Column(name = "IS_DELETE", unique = false, nullable = true, length = 2)
	private String isDelete;

	/** 流程Id **/
	@Column(name = "INSTANCE_ID", unique = false, nullable = true, length = 40)
	private String instanceId;
	
	
	/**
	 * @param messageId
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId == null ? null : messageId.trim();
	}
	
    /**
     * @return MessageId
     */	
	public String getMessageId() {
		return this.messageId;
	}
	
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
	 * @param messageTitle
	 */
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle == null ? null : messageTitle.trim();
	}
	
    /**
     * @return MessageTitle
     */	
	public String getMessageTitle() {
		return this.messageTitle;
	}
	
	/**
	 * @param messageIntroduce
	 */
	public void setMessageIntroduce(String messageIntroduce) {
		this.messageIntroduce = messageIntroduce == null ? null : messageIntroduce.trim();
	}
	
    /**
     * @return MessageIntroduce
     */	
	public String getMessageIntroduce() {
		return this.messageIntroduce;
	}
	
	/**
	 * @param publicType
	 */
	public void setPublicType(String publicType) {
		this.publicType = publicType == null ? null : publicType.trim();
	}
	
    /**
     * @return PublicType
     */	
	public String getPublicType() {
		return this.publicType;
	}
	
	/**
	 * @param publishType
	 */
	public void setPublishType(String publishType) {
		this.publishType = publishType == null ? null : publishType.trim();
	}
	
    /**
     * @return PublishType
     */	
	public String getPublishType() {
		return this.publishType;
	}
	
	/**
	 * @param publishDate
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
    /**
     * @return PublishDate
     */	
	public String getPublishDate() {
		return this.publishDate;
	}
	
	/**
	 * @param publishUser
	 */
	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser == null ? null : publishUser.trim();
	}
	
    /**
     * @return PublishUser
     */	
	public String getPublishUser() {
		return this.publishUser;
	}
	
	/**
	 * @param publishUserName
	 */
	public void setPublishUserName(String publishUserName) {
		this.publishUserName = publishUserName == null ? null : publishUserName.trim();
	}
	
    /**
     * @return PublishUserName
     */	
	public String getPublishUserName() {
		return this.publishUserName;
	}
	
	/**
	 * @param publishOrg
	 */
	public void setPublishOrg(String publishOrg) {
		this.publishOrg = publishOrg == null ? null : publishOrg.trim();
	}
	
    /**
     * @return PublishOrg
     */	
	public String getPublishOrg() {
		return this.publishOrg;
	}
	
	/**
	 * @param publishOrgName
	 */
	public void setPublishOrgName(String publishOrgName) {
		this.publishOrgName = publishOrgName == null ? null : publishOrgName.trim();
	}
	
    /**
     * @return PublishOrgName
     */	
	public String getPublishOrgName() {
		return this.publishOrgName;
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

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId == null ? null : instanceId;
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
        OcrmFwpInfo other = (OcrmFwpInfo) that;
		return (this.getMessageId() == null ? other.getMessageId() == null : this.getMessageId().equals(other.getMessageId()))
        	&& (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
        	&& (this.getMessageTitle() == null ? other.getMessageTitle() == null : this.getMessageTitle().equals(other.getMessageTitle()))
        	&& (this.getMessageIntroduce() == null ? other.getMessageIntroduce() == null : this.getMessageIntroduce().equals(other.getMessageIntroduce()))
        	&& (this.getPublicType() == null ? other.getPublicType() == null : this.getPublicType().equals(other.getPublicType()))
        	&& (this.getPublishType() == null ? other.getPublishType() == null : this.getPublishType().equals(other.getPublishType()))
                	&& (this.getPublishUser() == null ? other.getPublishUser() == null : this.getPublishUser().equals(other.getPublishUser()))
        	&& (this.getPublishUserName() == null ? other.getPublishUserName() == null : this.getPublishUserName().equals(other.getPublishUserName()))
        	&& (this.getPublishOrg() == null ? other.getPublishOrg() == null : this.getPublishOrg().equals(other.getPublishOrg()))
        	&& (this.getPublishOrgName() == null ? other.getPublishOrgName() == null : this.getPublishOrgName().equals(other.getPublishOrgName()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
			&& (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getIsDelete()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageId() == null) ? 0 : getMessageId().hashCode());
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getMessageTitle() == null) ? 0 : getMessageTitle().hashCode());
        result = prime * result + ((getMessageIntroduce() == null) ? 0 : getMessageIntroduce().hashCode());
        result = prime * result + ((getPublicType() == null) ? 0 : getPublicType().hashCode());
        result = prime * result + ((getPublishType() == null) ? 0 : getPublishType().hashCode());
        result = prime * result + ((getPublishUser() == null) ? 0 : getPublishUser().hashCode());
        result = prime * result + ((getPublishUserName() == null) ? 0 : getPublishUserName().hashCode());
        result = prime * result + ((getPublishOrg() == null) ? 0 : getPublishOrg().hashCode());
        result = prime * result + ((getPublishOrgName() == null) ? 0 : getPublishOrgName().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
		result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", messageId=").append(messageId);
		sb.append(", sectionId=").append(sectionId);
		sb.append(", messageTitle=").append(messageTitle);
		sb.append(", messageIntroduce=").append(messageIntroduce);
		sb.append(", publicType=").append(publicType);
		sb.append(", publishType=").append(publishType);
		sb.append(", publishDate=").append(publishDate);
		sb.append(", publishUser=").append(publishUser);
		sb.append(", publishUserName=").append(publishUserName);
		sb.append(", publishOrg=").append(publishOrg);
		sb.append(", publishOrgName=").append(publishOrgName);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", isDelete=").append(isDelete);
		sb.append(", instanceId=").append(instanceId);
        sb.append("]");
        return sb.toString();
    }
}