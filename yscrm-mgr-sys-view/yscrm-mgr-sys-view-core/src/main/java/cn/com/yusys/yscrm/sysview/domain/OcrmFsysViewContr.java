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
 * @类名称: OcrmFsysViewContr
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_VIEW_CONTR")
public class OcrmFsysViewContr extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "CONTR_ID")
	@Generated(GenerationType.UUID)
	private String contrId;
	
	/** 视图项编号 **/
	@Column(name = "VIEW_ITEM_ID", unique = false, nullable = false, length = 32)
	private String viewItemId;
	
	/** 控制操作代码 **/
	@Column(name = "CONTR_CODE", unique = false, nullable = false, length = 100)
	private String contrCode;
	
	/** 控制操作名称 **/
	@Column(name = "CONTR_NAME", unique = false, nullable = false, length = 200)
	private String contrName;
	
	/** 控制操作URL(用于后台校验时使用) **/
	@Column(name = "CONTR_URL", unique = false, nullable = true, length = 100)
	private String contrUrl;
	
	/** 备注 **/
	@Column(name = "CONTR_REMARK", unique = false, nullable = true, length = 1000)
	private String contrRemark;
	
	/** 最新变更用户 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = false, length = 32)
	private String lastChgUsr;
	
	/** 最新变更时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 20)
	private String lastChgDt;
	
	/** 请求类型 **/
	@Column(name = "METHOD_TYPE", unique = false, nullable = true, length = 20)
	private String methodType;
	
	
	/**
	 * @param contrId
	 */
	public void setContrId(String contrId) {
		this.contrId = contrId == null ? null : contrId.trim();
	}
	
    /**
     * @return ContrId
     */	
	public String getContrId() {
		return this.contrId;
	}
	
	/**
	 * @param viewItemId
	 */
	public void setViewItemId(String viewItemId) {
		this.viewItemId = viewItemId == null ? null : viewItemId.trim();
	}
	
    /**
     * @return ViewId
     */	
	public String getViewItemId() {
		return this.viewItemId;
	}
	
	/**
	 * @param contrCode
	 */
	public void setContrCode(String contrCode) {
		this.contrCode = contrCode == null ? null : contrCode.trim();
	}
	
    /**
     * @return ContrCode
     */	
	public String getContrCode() {
		return this.contrCode;
	}
	
	/**
	 * @param contrName
	 */
	public void setContrName(String contrName) {
		this.contrName = contrName == null ? null : contrName.trim();
	}
	
    /**
     * @return ContrName
     */	
	public String getContrName() {
		return this.contrName;
	}
	
	/**
	 * @param contrUrl
	 */
	public void setContrUrl(String contrUrl) {
		this.contrUrl = contrUrl == null ? null : contrUrl.trim();
	}
	
    /**
     * @return ContrUrl
     */	
	public String getContrUrl() {
		return this.contrUrl;
	}
	
	/**
	 * @param contrRemark
	 */
	public void setContrRemark(String contrRemark) {
		this.contrRemark = contrRemark == null ? null : contrRemark.trim();
	}
	
    /**
     * @return ContrRemark
     */	
	public String getContrRemark() {
		return this.contrRemark;
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
	 * @param methodType
	 */
	public void setMethodType(String methodType) {
		this.methodType = methodType == null ? null : methodType.trim();
	}
	
    /**
     * @return MethodType
     */	
	public String getMethodType() {
		return this.methodType;
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
        OcrmFsysViewContr other = (OcrmFsysViewContr) that;
		return (this.getContrId() == null ? other.getContrId() == null : this.getContrId().equals(other.getContrId()))
        	&& (this.getViewItemId() == null ? other.getViewItemId() == null : this.getViewItemId().equals(other.getViewItemId()))
        	&& (this.getContrCode() == null ? other.getContrCode() == null : this.getContrCode().equals(other.getContrCode()))
        	&& (this.getContrName() == null ? other.getContrName() == null : this.getContrName().equals(other.getContrName()))
        	&& (this.getContrUrl() == null ? other.getContrUrl() == null : this.getContrUrl().equals(other.getContrUrl()))
        	&& (this.getContrRemark() == null ? other.getContrRemark() == null : this.getContrRemark().equals(other.getContrRemark()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
        	&& (this.getLastChgDt() == null ? other.getLastChgDt() == null : this.getLastChgDt().equals(other.getLastChgDt()))
        	&& (this.getMethodType() == null ? other.getMethodType() == null : this.getMethodType().equals(other.getMethodType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContrId() == null) ? 0 : getContrId().hashCode());
        result = prime * result + ((getViewItemId() == null) ? 0 : getViewItemId().hashCode());
        result = prime * result + ((getContrCode() == null) ? 0 : getContrCode().hashCode());
        result = prime * result + ((getContrName() == null) ? 0 : getContrName().hashCode());
        result = prime * result + ((getContrUrl() == null) ? 0 : getContrUrl().hashCode());
        result = prime * result + ((getContrRemark() == null) ? 0 : getContrRemark().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getLastChgDt() == null) ? 0 : getLastChgDt().hashCode());
        result = prime * result + ((getMethodType() == null) ? 0 : getMethodType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", contrId=").append(contrId);
		sb.append(", viewItemId=").append(viewItemId);
		sb.append(", contrCode=").append(contrCode);
		sb.append(", contrName=").append(contrName);
		sb.append(", contrUrl=").append(contrUrl);
		sb.append(", contrRemark=").append(contrRemark);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", methodType=").append(methodType);
        sb.append("]");
        return sb.toString();
    }
}