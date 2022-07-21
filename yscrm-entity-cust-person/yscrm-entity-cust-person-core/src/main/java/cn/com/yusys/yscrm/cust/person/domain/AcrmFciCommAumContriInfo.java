package cn.com.yusys.yscrm.cust.person.domain;

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
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciCommAumContriInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-20 13:59:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_COMM_AUM_CONTRI_INFO")
public class AcrmFciCommAumContriInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键
 **/
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	/** 客户号
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 机构号
 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 32)
	private String orgId;
	
	/** 数据日期
 **/
	@Transient
	@Column(name = "ETL_DATE", unique = false, nullable = true, length = 7)
	private Date etlDate;
	
	/** 时点余额/金额
 **/
	@Column(name = "TIME_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal timeBal;
	
	/** 口径
 **/
	@Column(name = "CALIBER", unique = false, nullable = true, length = 2)
	private String caliber;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 32)
	private String corpOrgCode;
	
	
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
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param orgId
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}
	
    /**
     * @return OrgId
     */	
	public String getOrgId() {
		return this.orgId;
	}
	
	/**
	 * @param etlDate
	 */
	public void setEtlDate(Date etlDate) {
		this.etlDate = etlDate;
	}
	
    /**
     * @return EtlDate
     */	
	public Date getEtlDate() {
		return this.etlDate;
	}
	
	/**
	 * @param timeBal
	 */
	public void setTimeBal(java.math.BigDecimal timeBal) {
		this.timeBal = timeBal;
	}
	
    /**
     * @return TimeBal
     */	
	public java.math.BigDecimal getTimeBal() {
		return this.timeBal;
	}
	
	/**
	 * @param caliber
	 */
	public void setCaliber(String caliber) {
		this.caliber = caliber == null ? null : caliber.trim();
	}
	
    /**
     * @return Caliber
     */	
	public String getCaliber() {
		return this.caliber;
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
        AcrmFciCommAumContriInfo other = (AcrmFciCommAumContriInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
                        	&& (this.getCaliber() == null ? other.getCaliber() == null : this.getCaliber().equals(other.getCaliber()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getCaliber() == null) ? 0 : getCaliber().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", custId=").append(custId);
		sb.append(", orgId=").append(orgId);
		sb.append(", etlDate=").append(etlDate);
		sb.append(", timeBal=").append(timeBal);
		sb.append(", caliber=").append(caliber);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}