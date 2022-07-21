package cn.com.yusys.yscrm.sysview.domain;

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
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewAuth
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 19:08:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_VIEW_AUTH")
public class OcrmFsysViewAuth extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "AUTH_RECO_ID")
	@Generated(GenerationType.UUID)
	private String authRecoId;
	
	/** 逻辑系统记录编号 **/
	@Column(name = "SYS_ID", unique = false, nullable = false, length = 32)
	private String sysId;
	
	/** 授权对象类型（R-角色，U-用户，D-部门，G-机构，OU-对象组） **/
	@Column(name = "AUTHOBJ_TYPE", unique = false, nullable = false, length = 10)
	private String authobjType;
	
	/** 授权对象记录编号 **/
	@Column(name = "AUTHOBJ_ID", unique = false, nullable = false, length = 32)
	private String authobjId;
	
	/** 授权资源类型（M-视图项，C-控制点，D-数据权限） **/
	@Column(name = "AUTHRES_TYPE", unique = false, nullable = false, length = 10)
	private String authresType;
	
	/** 授权资源记录编号 **/
	@Column(name = "AUTHRES_ID", unique = false, nullable = false, length = 32)
	private String authresId;
	
	/** 最新变更用户 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = false, length = 32)
	private String lastChgUsr;
	
	/** 最新变更时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 20)
	private String lastChgDt;
	
	/** 视图项ID **/
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	
	/**
	 * @param authRecoId
	 */
	public void setAuthRecoId(String authRecoId) {
		this.authRecoId = authRecoId == null ? null : authRecoId.trim();
	}
	
    /**
     * @return AuthRecoId
     */	
	public String getAuthRecoId() {
		return this.authRecoId;
	}
	
	/**
	 * @param sysId
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId == null ? null : sysId.trim();
	}
	
    /**
     * @return SysId
     */	
	public String getSysId() {
		return this.sysId;
	}
	
	/**
	 * @param authobjType
	 */
	public void setAuthobjType(String authobjType) {
		this.authobjType = authobjType == null ? null : authobjType.trim();
	}
	
    /**
     * @return AuthobjType
     */	
	public String getAuthobjType() {
		return this.authobjType;
	}
	
	/**
	 * @param authobjId
	 */
	public void setAuthobjId(String authobjId) {
		this.authobjId = authobjId == null ? null : authobjId.trim();
	}
	
    /**
     * @return AuthobjId
     */	
	public String getAuthobjId() {
		return this.authobjId;
	}
	
	/**
	 * @param authresType
	 */
	public void setAuthresType(String authresType) {
		this.authresType = authresType == null ? null : authresType.trim();
	}
	
    /**
     * @return AuthresType
     */	
	public String getAuthresType() {
		return this.authresType;
	}
	
	/**
	 * @param authresId
	 */
	public void setAuthresId(String authresId) {
		this.authresId = authresId == null ? null : authresId.trim();
	}
	
    /**
     * @return AuthresId
     */	
	public String getAuthresId() {
		return this.authresId;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt == null ? null : lastChgDt.trim();
	}
	
    /**
     * @return LastChgDt
     */	
	public String getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param Id
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
        OcrmFsysViewAuth other = (OcrmFsysViewAuth) that;
		return (this.getAuthRecoId() == null ? other.getAuthRecoId() == null : this.getAuthRecoId().equals(other.getAuthRecoId()))
        	&& (this.getSysId() == null ? other.getSysId() == null : this.getSysId().equals(other.getSysId()))
        	&& (this.getAuthobjType() == null ? other.getAuthobjType() == null : this.getAuthobjType().equals(other.getAuthobjType()))
        	&& (this.getAuthobjId() == null ? other.getAuthobjId() == null : this.getAuthobjId().equals(other.getAuthobjId()))
        	&& (this.getAuthresType() == null ? other.getAuthresType() == null : this.getAuthresType().equals(other.getAuthresType()))
        	&& (this.getAuthresId() == null ? other.getAuthresId() == null : this.getAuthresId().equals(other.getAuthresId()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
        	&& (this.getLastChgDt() == null ? other.getLastChgDt() == null : this.getLastChgDt().equals(other.getLastChgDt()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAuthRecoId() == null) ? 0 : getAuthRecoId().hashCode());
        result = prime * result + ((getSysId() == null) ? 0 : getSysId().hashCode());
        result = prime * result + ((getAuthobjType() == null) ? 0 : getAuthobjType().hashCode());
        result = prime * result + ((getAuthobjId() == null) ? 0 : getAuthobjId().hashCode());
        result = prime * result + ((getAuthresType() == null) ? 0 : getAuthresType().hashCode());
        result = prime * result + ((getAuthresId() == null) ? 0 : getAuthresId().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getLastChgDt() == null) ? 0 : getLastChgDt().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", authRecoId=").append(authRecoId);
		sb.append(", sysId=").append(sysId);
		sb.append(", authobjType=").append(authobjType);
		sb.append(", authobjId=").append(authobjId);
		sb.append(", authresType=").append(authresType);
		sb.append(", authresId=").append(authresId);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", viewId=").append(id);
        sb.append("]");
        return sb.toString();
    }
}