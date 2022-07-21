package cn.com.yusys.yusp.uimp.base.app.uaa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-base-core模块
 * @类名称: PmaFappPassword
 * @类描述: # APP登录密码表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-13 15:43:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_APP_PASSWORD")
public class PmaFappPassword extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 用户编号 **/
	@Column(name = "USER_ID", unique = false, nullable = false, length = 32)
	private String userId;
	
	/** 登录密码 **/
	@Column(name = "PASSWORD", unique = false, nullable = true, length = 100)
	private String password;
	
	/** 手势密码 **/
	@Column(name = "PATTERN_LOCK", unique = false, nullable = true, length = 100)
	private String patternLock;
	
	/** 指纹密码 **/
	@Column(name = "FINGER_LOCK", unique = false, nullable = true, length = 100)
	private String fingerLock;
	
	/** 人脸密码 **/
	@Column(name = "FACE_LOCK", unique = false, nullable = true, length = 100)
	private String faceLock;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	private Date createTime;
	
	/** 更新时间 **/
	@Column(name = "UPDATE_TIME", unique = false, nullable = true, length = 7)
	private Date updateTime;
	
	
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return UserId
     */	
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	
    /**
     * @return Password
     */	
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * @param patternLock
	 */
	public void setPatternLock(String patternLock) {
		this.patternLock = patternLock == null ? null : patternLock.trim();
	}
	
    /**
     * @return PatternLock
     */	
	public String getPatternLock() {
		return this.patternLock;
	}
	
	/**
	 * @param fingerLock
	 */
	public void setFingerLock(String fingerLock) {
		this.fingerLock = fingerLock == null ? null : fingerLock.trim();
	}
	
    /**
     * @return FingerLock
     */	
	public String getFingerLock() {
		return this.fingerLock;
	}
	
	/**
	 * @param faceLock
	 */
	public void setFaceLock(String faceLock) {
		this.faceLock = faceLock == null ? null : faceLock.trim();
	}
	
    /**
     * @return FaceLock
     */	
	public String getFaceLock() {
		return this.faceLock;
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
        PmaFappPassword other = (PmaFappPassword) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
        	&& (this.getPatternLock() == null ? other.getPatternLock() == null : this.getPatternLock().equals(other.getPatternLock()))
        	&& (this.getFingerLock() == null ? other.getFingerLock() == null : this.getFingerLock().equals(other.getFingerLock()))
        	&& (this.getFaceLock() == null ? other.getFaceLock() == null : this.getFaceLock().equals(other.getFaceLock()))
                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPatternLock() == null) ? 0 : getPatternLock().hashCode());
        result = prime * result + ((getFingerLock() == null) ? 0 : getFingerLock().hashCode());
        result = prime * result + ((getFaceLock() == null) ? 0 : getFaceLock().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", password=").append(password);
		sb.append(", patternLock=").append(patternLock);
		sb.append(", fingerLock=").append(fingerLock);
		sb.append(", faceLock=").append(faceLock);
		sb.append(", createTime=").append(createTime);
		sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}