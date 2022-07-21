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
 * @类名称: OcrmFwpShareReplyInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-26 22:11:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_SHARE_REPLY_INFO")
public class OcrmFwpShareReplyInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "REPLY_ID")
	@Generated(GenerationType.UUID)
	private String replyId;
	
	/** 回复主题ID **/
	@Column(name = "SHARE_ID", unique = false, nullable = true, length = 600)
	private String shareId;
	
	/** 回复人ID **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 30)
	private String createUserId;
	
	/** 回复人名称 **/
	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, length = 60)
	private String createUserName;
	
	/** 回复人机构 **/
	@Column(name = "CREATE_ORG_ID", unique = false, nullable = true, length = 30)
	private String createOrgId;
	
	/** 回复人机构名称 **/
	@Column(name = "CREATE_ORG_NAME", unique = false, nullable = true, length = 30)
	private String createOrgName;
	
	/** 回复时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date createTime;
	
	/** 回复内容 **/
	@Column(name = "REPLY_CONTENT", unique = false, nullable = true, length = 4000)
	private String replyContent;
	
	/** 上一级回复主键ID **/
	@Column(name = "UP_REPLY_ID", unique = false, nullable = true, length = 32)
	private String upReplyId;
	
	/** 上一级回复人名称 **/
	@Column(name = "UP_CREATE_USER_NAME", unique = false, nullable = true, length = 60)
	private String upCreateUserName;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	private String rowno;
	
	private Integer replyCount;
	
	public String getRowno() {
		return rowno;
	}

	public void setRowno(String rowno) {
		this.rowno = rowno;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	/**
	 * @param replyId
	 */
	public void setReplyId(String replyId) {
		this.replyId = replyId == null ? null : replyId.trim();
	}
	
    /**
     * @return ReplyId
     */	
	public String getReplyId() {
		return this.replyId;
	}
	
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
	 * @param replyContent
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
    /**
     * @return ReplyContent
     */	
	public String getReplyContent() {
		return this.replyContent;
	}
	
	/**
	 * @param upReplyId
	 */
	public void setUpReplyId(String upReplyId) {
		this.upReplyId = upReplyId == null ? null : upReplyId.trim();
	}
	
    /**
     * @return UpReplyId
     */	
	public String getUpReplyId() {
		return this.upReplyId;
	}
	
	/**
	 * @param upCreateUserName
	 */
	public void setUpCreateUserName(String upCreateUserName) {
		this.upCreateUserName = upCreateUserName == null ? null : upCreateUserName.trim();
	}
	
    /**
     * @return UpCreateUserName
     */	
	public String getUpCreateUserName() {
		return this.upCreateUserName;
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
        OcrmFwpShareReplyInfo other = (OcrmFwpShareReplyInfo) that;
		return (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
        	&& (this.getShareId() == null ? other.getShareId() == null : this.getShareId().equals(other.getShareId()))
        	&& (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
        	&& (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
        	&& (this.getCreateOrgId() == null ? other.getCreateOrgId() == null : this.getCreateOrgId().equals(other.getCreateOrgId()))
        	&& (this.getCreateOrgName() == null ? other.getCreateOrgName() == null : this.getCreateOrgName().equals(other.getCreateOrgName()))
                        	&& (this.getUpReplyId() == null ? other.getUpReplyId() == null : this.getUpReplyId().equals(other.getUpReplyId()))
        	&& (this.getUpCreateUserName() == null ? other.getUpCreateUserName() == null : this.getUpCreateUserName().equals(other.getUpCreateUserName()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getShareId() == null) ? 0 : getShareId().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getCreateOrgId() == null) ? 0 : getCreateOrgId().hashCode());
        result = prime * result + ((getCreateOrgName() == null) ? 0 : getCreateOrgName().hashCode());
        result = prime * result + ((getUpReplyId() == null) ? 0 : getUpReplyId().hashCode());
        result = prime * result + ((getUpCreateUserName() == null) ? 0 : getUpCreateUserName().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", replyId=").append(replyId);
		sb.append(", shareId=").append(shareId);
		sb.append(", createUserId=").append(createUserId);
		sb.append(", createUserName=").append(createUserName);
		sb.append(", createOrgId=").append(createOrgId);
		sb.append(", createOrgName=").append(createOrgName);
		sb.append(", createTime=").append(createTime);
		sb.append(", replyContent=").append(replyContent);
		sb.append(", upReplyId=").append(upReplyId);
		sb.append(", upCreateUserName=").append(upCreateUserName);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}