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
 * @类名称: PmaFappUserCaptcha
 * @类描述: # APP用户短信验证码表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-13 15:43:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_APP_USER_CAPTCHA")
public class PmaFappUserCaptcha extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 用户编号 **/
	@Column(name = "USER_ID", unique = false, nullable = false, length = 32)
	private String userId;
	
	/** 验证码 **/
	@Column(name = "CAPTCHA", unique = false, nullable = false, length = 50)
	private String captcha;
	
	/** 发送时间 **/
	@Column(name = "SEND_TIME", unique = false, nullable = false, length = 7)
	private Date sendTime;
	
	
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
	 * @param captcha
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha == null ? null : captcha.trim();
	}
	
    /**
     * @return Captcha
     */	
	public String getCaptcha() {
		return this.captcha;
	}
	
	/**
	 * @param sendTime
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
    /**
     * @return SendTime
     */	
	public Date getSendTime() {
		return this.sendTime;
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
        PmaFappUserCaptcha other = (PmaFappUserCaptcha) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getCaptcha() == null ? other.getCaptcha() == null : this.getCaptcha().equals(other.getCaptcha()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCaptcha() == null) ? 0 : getCaptcha().hashCode());
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
		sb.append(", captcha=").append(captcha);
		sb.append(", sendTime=").append(sendTime);
        sb.append("]");
        return sb.toString();
    }
}