package cn.com.yusys.yscrm.custgrade.domain;

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
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmFciGradeStandard
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-18 11:15:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_GRADE_STANDARD")
public class OcrmFciGradeStandard extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/**   法人    **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/**   标识ID    **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "STANDARD_ID", unique = false, nullable = true, length = 32)
	private String standardId;
	
	/**   评级方案ID    **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 32)
	private String schemeId;
	
	/**   标准名称    **/
	@Column(name = "STANDARD_NAME", unique = false, nullable = true, length = 50)
	private String standardName;
	
	/**   是否启用    **/
	@Column(name = "MINUS_LEVEL", unique = false, nullable = true, length = 20)
	private String minusLevel;
	
	/**   评级公式解释    **/
	@Column(name = "GRADE_FORMULA_EXPLAIN", unique = false, nullable = true, length = 2000)
	private String gradeFormulaExplain;
	
	/**   评级公式    **/
	@Column(name = "GRADE_FORMULA", unique = false, nullable = true, length = 800)
	private String gradeFormula;
	
	/**   备注    **/
	@Column(name = "DEMO", unique = false, nullable = true, length = 1000)
	private String demo;
	
	/**   创建日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "CRAT_DT")
	private Date cratDt;
	
	/**   创建人ID    **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/**   创建人所在机构ID    **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/**   最近更新日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_CHG_DT")
	private Date lastChgDt;
	
	/**   最近更新人ID    **/
	@Column(name = "LAST_CHG_USR_ID", unique = false, nullable = true, length = 20)
	private String lastChgUsrId;
	
	/**   最近更新人所在机构ID    **/
	@Column(name = "LAST_CHG_ORG_ID", unique = false, nullable = true, length = 20)
	private String lastChgOrgId;
	
	/** 标准类型 **/
	@Column(name = "STANDARD_TYPE", unique = false, nullable = true, length = 20)
	private String standardType;
	
	
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
	 * @param standardId
	 */
	public void setStandardId(String standardId) {
		this.standardId = standardId == null ? null : standardId.trim();
	}
	
    /**
     * @return StandardId
     */	
	public String getStandardId() {
		return this.standardId;
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
	 * @param standardName
	 */
	public void setStandardName(String standardName) {
		this.standardName = standardName == null ? null : standardName.trim();
	}
	
    /**
     * @return StandardName
     */	
	public String getStandardName() {
		return this.standardName;
	}
	
	/**
	 * @param minusLevel
	 */
	public void setMinusLevel(String minusLevel) {
		this.minusLevel = minusLevel == null ? null : minusLevel.trim();
	}
	
    /**
     * @return MinusLevel
     */	
	public String getMinusLevel() {
		return this.minusLevel;
	}
	
	/**
	 * @param gradeFormulaExplain
	 */
	public void setGradeFormulaExplain(String gradeFormulaExplain) {
		this.gradeFormulaExplain = gradeFormulaExplain == null ? null : gradeFormulaExplain.trim();
	}
	
    /**
     * @return GradeFormulaExplain
     */	
	public String getGradeFormulaExplain() {
		return this.gradeFormulaExplain;
	}
	
	/**
	 * @param gradeFormula
	 */
	public void setGradeFormula(String gradeFormula) {
		this.gradeFormula = gradeFormula == null ? null : gradeFormula.trim();
	}
	
    /**
     * @return GradeFormula
     */	
	public String getGradeFormula() {
		return this.gradeFormula;
	}
	
	/**
	 * @param demo
	 */
	public void setDemo(String demo) {
		this.demo = demo == null ? null : demo.trim();
	}
	
    /**
     * @return Demo
     */	
	public String getDemo() {
		return this.demo;
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
	 * @param lastChgUsrId
	 */
	public void setLastChgUsrId(String lastChgUsrId) {
		this.lastChgUsrId = lastChgUsrId == null ? null : lastChgUsrId.trim();
	}
	
    /**
     * @return LastChgUsrId
     */	
	public String getLastChgUsrId() {
		return this.lastChgUsrId;
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
	 * @param standardType
	 */
	public void setStandardType(String standardType) {
		this.standardType = standardType == null ? null : standardType.trim();
	}
	
    /**
     * @return StandardType
     */	
	public String getStandardType() {
		return this.standardType;
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
        OcrmFciGradeStandard other = (OcrmFciGradeStandard) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getStandardId() == null ? other.getStandardId() == null : this.getStandardId().equals(other.getStandardId()))
        	&& (this.getSchemeId() == null ? other.getSchemeId() == null : this.getSchemeId().equals(other.getSchemeId()))
        	&& (this.getStandardName() == null ? other.getStandardName() == null : this.getStandardName().equals(other.getStandardName()))
        	&& (this.getMinusLevel() == null ? other.getMinusLevel() == null : this.getMinusLevel().equals(other.getMinusLevel()))
        	&& (this.getGradeFormulaExplain() == null ? other.getGradeFormulaExplain() == null : this.getGradeFormulaExplain().equals(other.getGradeFormulaExplain()))
        	&& (this.getGradeFormula() == null ? other.getGradeFormula() == null : this.getGradeFormula().equals(other.getGradeFormula()))
        	&& (this.getDemo() == null ? other.getDemo() == null : this.getDemo().equals(other.getDemo()))
                	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
                	&& (this.getLastChgUsrId() == null ? other.getLastChgUsrId() == null : this.getLastChgUsrId().equals(other.getLastChgUsrId()))
        	&& (this.getLastChgOrgId() == null ? other.getLastChgOrgId() == null : this.getLastChgOrgId().equals(other.getLastChgOrgId()))
        	&& (this.getStandardType() == null ? other.getStandardType() == null : this.getStandardType().equals(other.getStandardType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getStandardId() == null) ? 0 : getStandardId().hashCode());
        result = prime * result + ((getSchemeId() == null) ? 0 : getSchemeId().hashCode());
        result = prime * result + ((getStandardName() == null) ? 0 : getStandardName().hashCode());
        result = prime * result + ((getMinusLevel() == null) ? 0 : getMinusLevel().hashCode());
        result = prime * result + ((getGradeFormulaExplain() == null) ? 0 : getGradeFormulaExplain().hashCode());
        result = prime * result + ((getGradeFormula() == null) ? 0 : getGradeFormula().hashCode());
        result = prime * result + ((getDemo() == null) ? 0 : getDemo().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getLastChgUsrId() == null) ? 0 : getLastChgUsrId().hashCode());
        result = prime * result + ((getLastChgOrgId() == null) ? 0 : getLastChgOrgId().hashCode());
        result = prime * result + ((getStandardType() == null) ? 0 : getStandardType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", standardId=").append(standardId);
		sb.append(", schemeId=").append(schemeId);
		sb.append(", standardName=").append(standardName);
		sb.append(", minusLevel=").append(minusLevel);
		sb.append(", gradeFormulaExplain=").append(gradeFormulaExplain);
		sb.append(", gradeFormula=").append(gradeFormula);
		sb.append(", demo=").append(demo);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", lastChgUsrId=").append(lastChgUsrId);
		sb.append(", lastChgOrgId=").append(lastChgOrgId);
		sb.append(", standardType=").append(standardType);
        sb.append("]");
        return sb.toString();
    }
}