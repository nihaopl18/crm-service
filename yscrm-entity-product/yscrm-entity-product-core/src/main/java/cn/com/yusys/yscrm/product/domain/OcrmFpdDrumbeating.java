package cn.com.yusys.yscrm.product.domain;

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
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFpdDrumbeating
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-19 17:00:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_PD_DRUMBEATING")
public class OcrmFpdDrumbeating extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键标识 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 100)
	private String corpOrgCode;
	
	/** 产品编号 **/
	@Column(name = "PROD_ID", unique = false, nullable = true, length = 32)
	private String prodId;
	
	/** 附件编号 **/
	@Column(name = "ATTACH_ID", unique = false, nullable = true, length = 32)
	private String attachId;
	
	/** 附件类型 **/
	@Column(name = "RELA_TYPE", unique = false, nullable = true, length = 20)
	private String relaType;
	
	/** 资料类型 **/
	@Column(name = "DATA_TYPE", unique = false, nullable = true, length = 20)
	private String dataType;
	
	
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
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
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
	 * @param prodId
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}
	
    /**
     * @return ProdId
     */	
	public String getProdId() {
		return this.prodId;
	}
	
	/**
	 * @param attachId
	 */
	public void setAttachId(String attachId) {
		this.attachId = attachId == null ? null : attachId.trim();
	}
	
    /**
     * @return AttachId
     */	
	public String getAttachId() {
		return this.attachId;
	}
	
	/**
	 * @param relaType
	 */
	public void setRelaType(String relaType) {
		this.relaType = relaType == null ? null : relaType.trim();
	}
	
    /**
     * @return RelaType
     */	
	public String getRelaType() {
		return this.relaType;
	}
	
	/**
	 * @param dataType
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType == null ? null : dataType.trim();
	}
	
    /**
     * @return DataType
     */	
	public String getDataType() {
		return this.dataType;
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
        OcrmFpdDrumbeating other = (OcrmFpdDrumbeating) that;
		return (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
        	&& (this.getAttachId() == null ? other.getAttachId() == null : this.getAttachId().equals(other.getAttachId()))
        	&& (this.getRelaType() == null ? other.getRelaType() == null : this.getRelaType().equals(other.getRelaType()))
        	&& (this.getDataType() == null ? other.getDataType() == null : this.getDataType().equals(other.getDataType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getAttachId() == null) ? 0 : getAttachId().hashCode());
        result = prime * result + ((getRelaType() == null) ? 0 : getRelaType().hashCode());
        result = prime * result + ((getDataType() == null) ? 0 : getDataType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", id=").append(id);
		sb.append(", prodId=").append(prodId);
		sb.append(", attachId=").append(attachId);
		sb.append(", relaType=").append(relaType);
		sb.append(", dataType=").append(dataType);
        sb.append("]");
        return sb.toString();
    }
}