package cn.com.yusys.yscrm.exchange.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-exchange-core模块
 * @类名称: OcrmFwpShareInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-26 22:10:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_SHARE_INFO")
public class OcrmFwpShareInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "SHARE_ID")
	@Generated(GenerationType.UUID)
	private String shareId;
	
	/** 主题名称 **/
	@Column(name = "SHARE_NAME", unique = false, nullable = true, length = 600)
	private String shareName;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 30)
	private String createUserId;
	
	/** 创建人名称 **/
	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, length = 60)
	private String createUserName;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG_ID", unique = false, nullable = true, length = 30)
	private String createOrgId;
	
	/** 创建机构名称 **/
	@Column(name = "CREATE_ORG_NAME", unique = false, nullable = true, length = 30)
	private String createOrgName;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTime;
	
	/** 更新时间 **/
	@Column(name = "UPDATE_TIME", unique = false, nullable = true, length = 7)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date updateTime;
	
	/** 主题内容 **/
	@Column(name = "SHARE_CONTENT", unique = false, nullable = true, length = 4000)
	private String shareContent;
	
	/** 是否删除 **/
	@Column(name = "IS_DELETE", unique = false, nullable = true, length = 2)
	private String isDelete;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
	/**
	 * @param shareId
	 */
	public void setShareId(String shareId) {
		this.shareId = shareId == null ? null : shareId.trim();
	}
	
    /**
     * @return ShareId
     */	
	public String getShareId() {
		return this.shareId;
	}
	
	/**
	 * @param shareName
	 */
	public void setShareName(String shareName) {
		this.shareName = shareName == null ? null : shareName.trim();
	}
	
    /**
     * @return ShareName
     */	
	public String getShareName() {
		return this.shareName;
	}
	
	/**
	 * @param createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId == null ? null : createUserId.trim();
	}
	
    /**
     * @return CreateUserId
     */	
	public String getCreateUserId() {
		return this.createUserId;
	}
	
	/**
	 * @param createUserName
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}
	
    /**
     * @return CreateUserName
     */	
	public String getCreateUserName() {
		return this.createUserName;
	}
	
	/**
	 * @param createOrgId
	 */
	public void setCreateOrgId(String createOrgId) {
		this.createOrgId = createOrgId == null ? null : createOrgId.trim();
	}
	
    /**
     * @return CreateOrgId
     */	
	public String getCreateOrgId() {
		return this.createOrgId;
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
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
    /**
     * @return UpdateTime
     */	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	/**
	 * @param shareContent
	 */
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
	
    /**
     * @return ShareContent
     */	
	public String getShareContent() {
		return this.shareContent;
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
        OcrmFwpShareInfo other = (OcrmFwpShareInfo) that;
		return (this.getShareId() == null ? other.getShareId() == null : this.getShareId().equals(other.getShareId()))
        	&& (this.getShareName() == null ? other.getShareName() == null : this.getShareName().equals(other.getShareName()))
        	&& (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
        	&& (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
        	&& (this.getCreateOrgId() == null ? other.getCreateOrgId() == null : this.getCreateOrgId().equals(other.getCreateOrgId()))
        	&& (this.getCreateOrgName() == null ? other.getCreateOrgName() == null : this.getCreateOrgName().equals(other.getCreateOrgName()))
                                	&& (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getShareId() == null) ? 0 : getShareId().hashCode());
        result = prime * result + ((getShareName() == null) ? 0 : getShareName().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getCreateOrgId() == null) ? 0 : getCreateOrgId().hashCode());
        result = prime * result + ((getCreateOrgName() == null) ? 0 : getCreateOrgName().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", shareId=").append(shareId);
		sb.append(", shareName=").append(shareName);
		sb.append(", createUserId=").append(createUserId);
		sb.append(", createUserName=").append(createUserName);
		sb.append(", createOrgId=").append(createOrgId);
		sb.append(", createOrgName=").append(createOrgName);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", shareContent=").append(shareContent);
		sb.append(", isDelete=").append(isDelete);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}