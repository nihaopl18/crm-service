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
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdLikeness
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 10:26:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_PD_PROD_LIKENESS")
public class OcrmFpdProdLikeness extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "LIKENESS_ID")
	@Generated(GenerationType.UUID)
	private String likenessId;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 产品标识 **/
	@Column(name = "PROD_ID", unique = false, nullable = true, length = 30)
	private String prodId;
	
	/** 类似产品编号 **/
	@Column(name = "LIKE_PROD_ID", unique = false, nullable = true, length = 30)
	private String likeProdId;
	
	/** 类似产品名称 **/
	@Column(name = "LIKE_PROD_NAME", unique = false, nullable = true, length = 128)
	private String likeProdName;
	
	/** 说明 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 1000)
	private String remark;
	
	
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
	 * @param likenessId
	 */
	public void setLikenessId(String likenessId) {
		this.likenessId = likenessId == null ? null : likenessId.trim();
	}
	
    /**
     * @return LikenessId
     */	
	public String getLikenessId() {
		return this.likenessId;
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
	 * @param likeProdId
	 */
	public void setLikeProdId(String likeProdId) {
		this.likeProdId = likeProdId == null ? null : likeProdId.trim();
	}
	
    /**
     * @return LikeProdId
     */	
	public String getLikeProdId() {
		return this.likeProdId;
	}
	
	/**
	 * @param likeProdName
	 */
	public void setLikeProdName(String likeProdName) {
		this.likeProdName = likeProdName == null ? null : likeProdName.trim();
	}
	
    /**
     * @return LikeProdName
     */	
	public String getLikeProdName() {
		return this.likeProdName;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
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
        OcrmFpdProdLikeness other = (OcrmFpdProdLikeness) that;
		return (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getLikenessId() == null ? other.getLikenessId() == null : this.getLikenessId().equals(other.getLikenessId()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
        	&& (this.getLikeProdId() == null ? other.getLikeProdId() == null : this.getLikeProdId().equals(other.getLikeProdId()))
        	&& (this.getLikeProdName() == null ? other.getLikeProdName() == null : this.getLikeProdName().equals(other.getLikeProdName()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getLikenessId() == null) ? 0 : getLikenessId().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getLikeProdId() == null) ? 0 : getLikeProdId().hashCode());
        result = prime * result + ((getLikeProdName() == null) ? 0 : getLikeProdName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", likenessId=").append(likenessId);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", prodId=").append(prodId);
		sb.append(", likeProdId=").append(likeProdId);
		sb.append(", likeProdName=").append(likeProdName);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}