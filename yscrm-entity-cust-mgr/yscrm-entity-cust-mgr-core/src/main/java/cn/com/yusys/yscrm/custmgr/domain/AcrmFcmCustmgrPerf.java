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
import java.util.Date;


/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFcmCustmgrPerf
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-25 12:45:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CM_CUSTMGR_PERF")
public class AcrmFcmCustmgrPerf extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 法人 **/
	@Id
	@Column(name = "CORP_ORG_CODE")
	@Generated(GenerationType.UUID)
	private String corpOrgCode;
	/** 员工编号 **/
	@Id
	@Column(name = "EMP_ID")
	@Generated(GenerationType.UUID)
	private String empId;
	
	/** 数据日期 **/
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 8)
	private String dataDt;
	
	/** 员工姓名 **/
	@Column(name = "EMP_NAME", unique = false, nullable = true, length = 30)
	private String empName;
	
	/** 机构编号 **/
	@Column(name = "BRCH_ID", unique = false, nullable = true, length = 32)
	private String brchId;
	
	/** 机构名称 **/
	@Column(name = "BRCH_NAME", unique = false, nullable = true, length = 30)
	private String brchName;
	
	/** 业务类别ID **/
	@Column(name = "TARGET_TYPE_ID", unique = false, nullable = true, length = 32)
	private String targetTypeId;
	
	/** 业务类别名称 **/
	@Column(name = "TARGET_TYPE_NAME", unique = false, nullable = true, length = 200)
	private String targetTypeName;
	
	/** 指标编号 **/
	@Column(name = "TARGET_ID", unique = false, nullable = true, length = 32)
	private String targetId;
	
	/** 指标名称 **/
	@Column(name = "TARGET_NAME", unique = false, nullable = true, length = 200)
	private String targetName;
	
	/** 指标值 **/
	@Column(name = "TARGET_VALUE", unique = false, nullable = true, length = 19)
	private java.math.BigDecimal targetValue;
	
	/** 时段标识 **/
	@Column(name = "SDBS", unique = false, nullable = true, length = 1)
	private String sdbs;
	
	/** 币种 **/
	@Column(name = "CURR_CD", unique = false, nullable = true, length = 3)
	private String currCd;
	
	
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
	public void setDataDt(String dataDt) {
		this.dataDt = dataDt;
	}
	
    /**
     * @return DataDt
     */	
	public String getDataDt() {
		return this.dataDt;
	}
	
	/**
	 * @param empId
	 */
	public void setEmpId(String empId) {
		this.empId = empId == null ? null : empId.trim();
	}
	
    /**
     * @return EmpId
     */	
	public String getEmpId() {
		return this.empId;
	}
	
	/**
	 * @param empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName == null ? null : empName.trim();
	}
	
    /**
     * @return EmpName
     */	
	public String getEmpName() {
		return this.empName;
	}
	
	/**
	 * @param brchId
	 */
	public void setBrchId(String brchId) {
		this.brchId = brchId == null ? null : brchId.trim();
	}
	
    /**
     * @return BrchId
     */	
	public String getBrchId() {
		return this.brchId;
	}
	
	/**
	 * @param brchName
	 */
	public void setBrchName(String brchName) {
		this.brchName = brchName == null ? null : brchName.trim();
	}
	
    /**
     * @return BrchName
     */	
	public String getBrchName() {
		return this.brchName;
	}
	
	/**
	 * @param targetTypeId
	 */
	public void setTargetTypeId(String targetTypeId) {
		this.targetTypeId = targetTypeId == null ? null : targetTypeId.trim();
	}
	
    /**
     * @return TargetTypeId
     */	
	public String getTargetTypeId() {
		return this.targetTypeId;
	}
	
	/**
	 * @param targetTypeName
	 */
	public void setTargetTypeName(String targetTypeName) {
		this.targetTypeName = targetTypeName == null ? null : targetTypeName.trim();
	}
	
    /**
     * @return TargetTypeName
     */	
	public String getTargetTypeName() {
		return this.targetTypeName;
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
	 * @param targetName
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName == null ? null : targetName.trim();
	}
	
    /**
     * @return TargetName
     */	
	public String getTargetName() {
		return this.targetName;
	}
	
	/**
	 * @param targetValue
	 */
	public void setTargetValue(java.math.BigDecimal targetValue) {
		this.targetValue = targetValue;
	}
	
    /**
     * @return TargetValue
     */	
	public java.math.BigDecimal getTargetValue() {
		return this.targetValue;
	}
	
	/**
	 * @param sdbs
	 */
	public void setSdbs(String sdbs) {
		this.sdbs = sdbs == null ? null : sdbs.trim();
	}
	
    /**
     * @return Sdbs
     */	
	public String getSdbs() {
		return this.sdbs;
	}
	
	/**
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd == null ? null : currCd.trim();
	}
	
    /**
     * @return CurrCd
     */	
	public String getCurrCd() {
		return this.currCd;
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
        AcrmFcmCustmgrPerf other = (AcrmFcmCustmgrPerf) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getEmpId() == null ? other.getEmpId() == null : this.getEmpId().equals(other.getEmpId()))
        	&& (this.getEmpName() == null ? other.getEmpName() == null : this.getEmpName().equals(other.getEmpName()))
        	&& (this.getBrchId() == null ? other.getBrchId() == null : this.getBrchId().equals(other.getBrchId()))
        	&& (this.getBrchName() == null ? other.getBrchName() == null : this.getBrchName().equals(other.getBrchName()))
        	&& (this.getTargetTypeId() == null ? other.getTargetTypeId() == null : this.getTargetTypeId().equals(other.getTargetTypeId()))
        	&& (this.getTargetTypeName() == null ? other.getTargetTypeName() == null : this.getTargetTypeName().equals(other.getTargetTypeName()))
        	&& (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
        	&& (this.getTargetName() == null ? other.getTargetName() == null : this.getTargetName().equals(other.getTargetName()))
                	&& (this.getSdbs() == null ? other.getSdbs() == null : this.getSdbs().equals(other.getSdbs()))
        	&& (this.getCurrCd() == null ? other.getCurrCd() == null : this.getCurrCd().equals(other.getCurrCd()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getEmpId() == null) ? 0 : getEmpId().hashCode());
        result = prime * result + ((getEmpName() == null) ? 0 : getEmpName().hashCode());
        result = prime * result + ((getBrchId() == null) ? 0 : getBrchId().hashCode());
        result = prime * result + ((getBrchName() == null) ? 0 : getBrchName().hashCode());
        result = prime * result + ((getTargetTypeId() == null) ? 0 : getTargetTypeId().hashCode());
        result = prime * result + ((getTargetTypeName() == null) ? 0 : getTargetTypeName().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getTargetName() == null) ? 0 : getTargetName().hashCode());
        result = prime * result + ((getSdbs() == null) ? 0 : getSdbs().hashCode());
        result = prime * result + ((getCurrCd() == null) ? 0 : getCurrCd().hashCode());
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