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
 * @类名称: AcrmFciPerResumeInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 18:57:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_PER_RESUME_INFO")
public class AcrmFciPerResumeInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键
	 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String id;
		
	

	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期
 **/

	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号
 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人
 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间
 **/
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 11)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 开始日期
 **/
	@Column(name = "START_DATE", unique = false, nullable = true, length = 8)
	private String startDate;
	
	/** 结束日期
 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 8)
	private String endDate;
	
	/** 职务
 **/
	@Column(name = "DUTY", unique = false, nullable = true, length = 30)
	private String duty;
	
	/** 全职兼职标识
 **/
	@Column(name = "FULL_PART_FLG", unique = false, nullable = true, length = 30)
	private String fullPartFlg;
	
	/** 所在部门
 **/
	@Column(name = "DEPT", unique = false, nullable = true, length = 100)
	private String dept;
	
	/** 单位_学校
 **/
	@Column(name = "COM_SCH", unique = false, nullable = true, length = 100)
	private String comSch;
	
	/** 所在系院
 **/
	@Column(name = "SCH_DEPT", unique = false, nullable = true, length = 100)
	private String schDept;
	
	/** 专业
 **/
	@Column(name = "SCH_MAJOR", unique = false, nullable = true, length = 100)
	private String schMajor;
	
	/** 学制
 **/
	@Column(name = "SCH_LENGTH", unique = false, nullable = true, length = 30)
	private String schLength;
	
	/** 城市
 **/
	@Column(name = "CITY", unique = false, nullable = true, length = 30)
	private String city;
	
	/** 国家
 **/
	@Column(name = "COUNTRY", unique = false, nullable = true, length = 30)
	private String country;
	
	/** 备注
 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 200)
	private String remarks;
	
	
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
	}
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
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
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}
	
    /**
     * @return StartDate
     */	
	public String getStartDate() {
		return this.startDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}
	
    /**
     * @return EndDate
     */	
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @param duty
	 */
	public void setDuty(String duty) {
		this.duty = duty == null ? null : duty.trim();
	}
	
    /**
     * @return Duty
     */	
	public String getDuty() {
		return this.duty;
	}
	
	/**
	 * @param fullPartFlg
	 */
	public void setFullPartFlg(String fullPartFlg) {
		this.fullPartFlg = fullPartFlg == null ? null : fullPartFlg.trim();
	}
	
    /**
     * @return FullPartFlg
     */	
	public String getFullPartFlg() {
		return this.fullPartFlg;
	}
	
	/**
	 * @param dept
	 */
	public void setDept(String dept) {
		this.dept = dept == null ? null : dept.trim();
	}
	
    /**
     * @return Dept
     */	
	public String getDept() {
		return this.dept;
	}
	
	/**
	 * @param comSch
	 */
	public void setComSch(String comSch) {
		this.comSch = comSch == null ? null : comSch.trim();
	}
	
    /**
     * @return ComSch
     */	
	public String getComSch() {
		return this.comSch;
	}
	
	/**
	 * @param schDept
	 */
	public void setSchDept(String schDept) {
		this.schDept = schDept == null ? null : schDept.trim();
	}
	
    /**
     * @return SchDept
     */	
	public String getSchDept() {
		return this.schDept;
	}
	
	/**
	 * @param schMajor
	 */
	public void setSchMajor(String schMajor) {
		this.schMajor = schMajor == null ? null : schMajor.trim();
	}
	
    /**
     * @return SchMajor
     */	
	public String getSchMajor() {
		return this.schMajor;
	}
	
	/**
	 * @param schLength
	 */
	public void setSchLength(String schLength) {
		this.schLength = schLength == null ? null : schLength.trim();
	}
	
    /**
     * @return SchLength
     */	
	public String getSchLength() {
		return this.schLength;
	}
	
	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}
	
    /**
     * @return City
     */	
	public String getCity() {
		return this.city;
	}
	
	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}
	
    /**
     * @return Country
     */	
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}
	
    /**
     * @return Remarks
     */	
	public String getRemarks() {
		return this.remarks;
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
        AcrmFciPerResumeInfo other = (AcrmFciPerResumeInfo) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
        	&& (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
        	&& (this.getDuty() == null ? other.getDuty() == null : this.getDuty().equals(other.getDuty()))
        	&& (this.getFullPartFlg() == null ? other.getFullPartFlg() == null : this.getFullPartFlg().equals(other.getFullPartFlg()))
        	&& (this.getDept() == null ? other.getDept() == null : this.getDept().equals(other.getDept()))
        	&& (this.getComSch() == null ? other.getComSch() == null : this.getComSch().equals(other.getComSch()))
        	&& (this.getSchDept() == null ? other.getSchDept() == null : this.getSchDept().equals(other.getSchDept()))
        	&& (this.getSchMajor() == null ? other.getSchMajor() == null : this.getSchMajor().equals(other.getSchMajor()))
        	&& (this.getSchLength() == null ? other.getSchLength() == null : this.getSchLength().equals(other.getSchLength()))
        	&& (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
        	&& (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
        	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getDuty() == null) ? 0 : getDuty().hashCode());
        result = prime * result + ((getFullPartFlg() == null) ? 0 : getFullPartFlg().hashCode());
        result = prime * result + ((getDept() == null) ? 0 : getDept().hashCode());
        result = prime * result + ((getComSch() == null) ? 0 : getComSch().hashCode());
        result = prime * result + ((getSchDept() == null) ? 0 : getSchDept().hashCode());
        result = prime * result + ((getSchMajor() == null) ? 0 : getSchMajor().hashCode());
        result = prime * result + ((getSchLength() == null) ? 0 : getSchLength().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", duty=").append(duty);
		sb.append(", fullPartFlg=").append(fullPartFlg);
		sb.append(", dept=").append(dept);
		sb.append(", comSch=").append(comSch);
		sb.append(", schDept=").append(schDept);
		sb.append(", schMajor=").append(schMajor);
		sb.append(", schLength=").append(schLength);
		sb.append(", city=").append(city);
		sb.append(", country=").append(country);
		sb.append(", remarks=").append(remarks);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}