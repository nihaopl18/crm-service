package cn.com.yusys.yscrm.custgrade.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmFciGradeScheme
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-18 11:14:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_GRADE_SCHEME")
public class OcrmFciGradeScheme extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/**   法人    **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 100)
	private String corpOrgCode;
	@Id
	/**   评级方案ID    **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String schemeId;
	
	/**   方案名称    **/
	@Column(name = "SCHEME_NAME", unique = false, nullable = true, length = 100)
	private String schemeName;
	
	/**   评级客户类型    **/
	@Column(name = "GRADE_TYPE", unique = false, nullable = true, length = 30)
	private String gradeType;
	
	/**   评级类型    **/
	@Column(name = "GRADE_USEAGE", unique = false, nullable = true, length = 20)
	private String gradeUseage;
	
	/**   是否启用    **/
	@Column(name = "IS_USED", unique = false, nullable = true, length = 30)
	private String isUsed;
	
	/**   评级频率    **/
	@Column(name = "GRADE_FREQUENCY", unique = false, nullable = true, length = 30)
	private String gradeFrequency;
	
	/**   评级起始日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "GRADE_BEGIN_DATE")
	private Date gradeBeginDate;
	
	/**   评级结束日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "GRADE_END_DATE")
	private Date gradeEndDate;
	
	/**   备注    **/
	@Column(name = "MEMO", unique = false, nullable = true, length = 200)
	private String memo;
	
	/**   创建日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "CRAT_DT")
	private Date cratDt;
	
	/**   创建人ID    **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/**   创建人名称    **/
	@Column(name = "CRAT_USER_NAME", unique = false, nullable = true, length = 80)
	private String cratUserName;
	
	/**   创建人所在机构ID    **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 10)
	private String cratOrgId;
	
	/**   创建人所在机构名称    **/
	@Column(name = "CRAT_ORG_NAME", unique = false, nullable = true, length = 200)
	private String cratOrgName;
	
	/**   最近更新日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_CHG_DT")
	private Date lastChgDt;
	
	/**   最近更新人ID    **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/**   最近更新人名称    **/
	@Column(name = "LAST_CHG_USR_NAME", unique = false, nullable = true, length = 80)
	private String lastChgUsrName;
	
	/**   最近更新人所在机构ID    **/
	@Column(name = "LAST_CHG_ORG_ID", unique = false, nullable = true, length = 20)
	private String lastChgOrgId;
	
	/**   最近更新人所在机构名称    **/
	@Column(name = "LAST_CHG_ORG_NAME", unique = false, nullable = true, length = 200)
	private String lastChgOrgName;
	
	
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
	 * @param schemeId
	 */
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId == null ? null : schemeId.trim();
	}
	
    /**
     * @return SchemeId
     */	
	public String getSchemeId() {
		return this.schemeId;
	}
	
	/**
	 * @param schemeName
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName == null ? null : schemeName.trim();
	}
	
    /**
     * @return SchemeName
     */	
	public String getSchemeName() {
		return this.schemeName;
	}
	
	/**
	 * @param gradeType
	 */
	public void setGradeType(String gradeType) {
		this.gradeType = gradeType == null ? null : gradeType.trim();
	}
	
    /**
     * @return GradeType
     */	
	public String getGradeType() {
		return this.gradeType;
	}
	
	/**
	 * @param gradeUseage
	 */
	public void setGradeUseage(String gradeUseage) {
		this.gradeUseage = gradeUseage == null ? null : gradeUseage.trim();
	}
	
    /**
     * @return GradeUseage
     */	
	public String getGradeUseage() {
		return this.gradeUseage;
	}
	
	/**
	 * @param isUsed
	 */
	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed == null ? null : isUsed.trim();
	}
	
    /**
     * @return IsUsed
     */	
	public String getIsUsed() {
		return this.isUsed;
	}
	
	/**
	 * @param gradeFrequency
	 */
	public void setGradeFrequency(String gradeFrequency) {
		this.gradeFrequency = gradeFrequency == null ? null : gradeFrequency.trim();
	}
	
    /**
     * @return GradeFrequency
     */	
	public String getGradeFrequency() {
		return this.gradeFrequency;
	}
	
	/**
	 * @param gradeBeginDate
	 */
	public void setGradeBeginDate(Date gradeBeginDate) {
		this.gradeBeginDate = gradeBeginDate;
	}
	
    /**
     * @return GradeBeginDate
     */	
	public Date getGradeBeginDate() {
		return this.gradeBeginDate;
	}
	
	/**
	 * @param gradeEndDate
	 */
	public void setGradeEndDate(Date gradeEndDate) {
		this.gradeEndDate = gradeEndDate;
	}
	
    /**
     * @return GradeEndDate
     */	
	public Date getGradeEndDate() {
		return this.gradeEndDate;
	}
	
	/**
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}
	
    /**
     * @return Memo
     */	
	public String getMemo() {
		return this.memo;
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
	 * @param cratUserName
	 */
	public void setCratUserName(String cratUserName) {
		this.cratUserName = cratUserName == null ? null : cratUserName.trim();
	}
	
    /**
     * @return CratUserName
     */	
	public String getCratUserName() {
		return this.cratUserName;
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
	 * @param cratOrgName
	 */
	public void setCratOrgName(String cratOrgName) {
		this.cratOrgName = cratOrgName == null ? null : cratOrgName.trim();
	}
	
    /**
     * @return CratOrgName
     */	
	public String getCratOrgName() {
		return this.cratOrgName;
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
	 * @param lastChgUsrName
	 */
	public void setLastChgUsrName(String lastChgUsrName) {
		this.lastChgUsrName = lastChgUsrName == null ? null : lastChgUsrName.trim();
	}
	
    /**
     * @return LastChgUsrName
     */	
	public String getLastChgUsrName() {
		return this.lastChgUsrName;
	}
	
	/**
	 * @param lastChgOrgId
	 */
	public void setLastChgOrgId(String lastChgOrgId) {
		this.lastChgOrgId = lastChgOrgId == null ? null : lastChgOrgId.trim();
	}
	
    /**
     * @return LastChgOrgId
     */	
	public String getLastChgOrgId() {
		return this.lastChgOrgId;
	}
	
	/**
	 * @param lastChgOrgName
	 */
	public void setLastChgOrgName(String lastChgOrgName) {
		this.lastChgOrgName = lastChgOrgName == null ? null : lastChgOrgName.trim();
	}
	
    /**
     * @return LastChgOrgName
     */	
	public String getLastChgOrgName() {
		return this.lastChgOrgName;
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
        OcrmFciGradeScheme other = (OcrmFciGradeScheme) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getSchemeId() == null ? other.getSchemeId() == null : this.getSchemeId().equals(other.getSchemeId()))
        	&& (this.getSchemeName() == null ? other.getSchemeName() == null : this.getSchemeName().equals(other.getSchemeName()))
        	&& (this.getGradeType() == null ? other.getGradeType() == null : this.getGradeType().equals(other.getGradeType()))
        	&& (this.getGradeUseage() == null ? other.getGradeUseage() == null : this.getGradeUseage().equals(other.getGradeUseage()))
        	&& (this.getIsUsed() == null ? other.getIsUsed() == null : this.getIsUsed().equals(other.getIsUsed()))
        	&& (this.getGradeFrequency() == null ? other.getGradeFrequency() == null : this.getGradeFrequency().equals(other.getGradeFrequency()))
                        	&& (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
                	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getCratUserName() == null ? other.getCratUserName() == null : this.getCratUserName().equals(other.getCratUserName()))
        	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratOrgName() == null ? other.getCratOrgName() == null : this.getCratOrgName().equals(other.getCratOrgName()))
                	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
        	&& (this.getLastChgUsrName() == null ? other.getLastChgUsrName() == null : this.getLastChgUsrName().equals(other.getLastChgUsrName()))
        	&& (this.getLastChgOrgId() == null ? other.getLastChgOrgId() == null : this.getLastChgOrgId().equals(other.getLastChgOrgId()))
        	&& (this.getLastChgOrgName() == null ? other.getLastChgOrgName() == null : this.getLastChgOrgName().equals(other.getLastChgOrgName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getSchemeId() == null) ? 0 : getSchemeId().hashCode());
        result = prime * result + ((getSchemeName() == null) ? 0 : getSchemeName().hashCode());
        result = prime * result + ((getGradeType() == null) ? 0 : getGradeType().hashCode());
        result = prime * result + ((getGradeUseage() == null) ? 0 : getGradeUseage().hashCode());
        result = prime * result + ((getIsUsed() == null) ? 0 : getIsUsed().hashCode());
        result = prime * result + ((getGradeFrequency() == null) ? 0 : getGradeFrequency().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getCratUserName() == null) ? 0 : getCratUserName().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratOrgName() == null) ? 0 : getCratOrgName().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getLastChgUsrName() == null) ? 0 : getLastChgUsrName().hashCode());
        result = prime * result + ((getLastChgOrgId() == null) ? 0 : getLastChgOrgId().hashCode());
        result = prime * result + ((getLastChgOrgName() == null) ? 0 : getLastChgOrgName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", schemeId=").append(schemeId);
		sb.append(", schemeName=").append(schemeName);
		sb.append(", gradeType=").append(gradeType);
		sb.append(", gradeUseage=").append(gradeUseage);
		sb.append(", isUsed=").append(isUsed);
		sb.append(", gradeFrequency=").append(gradeFrequency);
		sb.append(", gradeBeginDate=").append(gradeBeginDate);
		sb.append(", gradeEndDate=").append(gradeEndDate);
		sb.append(", memo=").append(memo);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", cratUserName=").append(cratUserName);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratOrgName=").append(cratOrgName);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgUsrName=").append(lastChgUsrName);
		sb.append(", lastChgOrgId=").append(lastChgOrgId);
		sb.append(", lastChgOrgName=").append(lastChgOrgName);
        sb.append("]");
        return sb.toString();
    }
}