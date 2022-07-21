package cn.com.yusys.yscrm.custmgr.domain;

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
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmLevelRate
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 09:58:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_A_CM_LEVEL_RATE")
public class AcrmAcmLevelRate extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 法人 **/
	@Id
	@Column(name = "CORP_ORG_CODE")
	@Generated(GenerationType.UUID)
	private String corpOrgCode;
	/** 数据日期 **/
	@Id
	@Column(name = "DATA_DT")
	@Generated(GenerationType.UUID)
	private Date dataDt;
	/** 统计对象编号 **/
	@Id
	@Column(name = "TARGET_ID")
	@Generated(GenerationType.UUID)
	private String targetId;
	/** 汇总维度 **/
	@Id
	@Column(name = "TARGET_TYPE")
	@Generated(GenerationType.UUID)
	private String targetType;
	/** 归属条线 **/
	@Id
	@Column(name = "BEL_TYPE")
	@Generated(GenerationType.UUID)
	private String belType;
	/** 客户星级 **/
	@Id
	@Column(name = "CUST_LEVEL")
	@Generated(GenerationType.UUID)
	private String custLevel;
	
	/** 客户数量 **/
	@Column(name = "CUST_COUNT", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal custCount;
	
	/** 星级占比 **/
	@Column(name = "LEVEL_RATE", unique = false, nullable = true, length = 10)
	private java.math.BigDecimal levelRate;
	
	
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
	 * @param dataDt
	 */
	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
	}
	
    /**
     * @return DataDt
     */	
	public Date getDataDt() {
		return this.dataDt;
	}
	
	/**
	 * @param targetId
	 */
	public void setTargetId(String targetId) {
		this.targetId = targetId == null ? null : targetId.trim();
	}
	
    /**
     * @return TargetId
     */	
	public String getTargetId() {
		return this.targetId;
	}
	
	/**
	 * @param targetType
	 */
	public void setTargetType(String targetType) {
		this.targetType = targetType == null ? null : targetType.trim();
	}
	
    /**
     * @return TargetType
     */	
	public String getTargetType() {
		return this.targetType;
	}
	
	/**
	 * @param belType
	 */
	public void setBelType(String belType) {
		this.belType = belType == null ? null : belType.trim();
	}
	
    /**
     * @return BelType
     */	
	public String getBelType() {
		return this.belType;
	}
	
	/**
	 * @param custLevel
	 */
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel == null ? null : custLevel.trim();
	}
	
    /**
     * @return CustLevel
     */	
	public String getCustLevel() {
		return this.custLevel;
	}
	
	/**
	 * @param custCount
	 */
	public void setCustCount(java.math.BigDecimal custCount) {
		this.custCount = custCount;
	}
	
    /**
     * @return CustCount
     */	
	public java.math.BigDecimal getCustCount() {
		return this.custCount;
	}
	
	/**
	 * @param levelRate
	 */
	public void setLevelRate(java.math.BigDecimal levelRate) {
		this.levelRate = levelRate;
	}
	
    /**
     * @return LevelRate
     */	
	public java.math.BigDecimal getLevelRate() {
		return this.levelRate;
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
        AcrmAcmLevelRate other = (AcrmAcmLevelRate) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
        	&& (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
        	&& (this.getBelType() == null ? other.getBelType() == null : this.getBelType().equals(other.getBelType()))
        	&& (this.getCustLevel() == null ? other.getCustLevel() == null : this.getCustLevel().equals(other.getCustLevel()))
                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getBelType() == null) ? 0 : getBelType().hashCode());
        result = prime * result + ((getCustLevel() == null) ? 0 : getCustLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append("]");
        return sb.toString();
    }
}