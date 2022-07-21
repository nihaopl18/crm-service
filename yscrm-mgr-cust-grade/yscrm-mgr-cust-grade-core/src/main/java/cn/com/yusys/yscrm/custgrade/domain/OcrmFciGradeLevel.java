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
 * @类名称: OcrmFciGradeLevel
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-18 11:15:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_GRADE_LEVEL")
public class OcrmFciGradeLevel extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 	法人	  **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 100)
	private String corpOrgCode;
	
	/** 	记录ID	  **/
	@Id
	@Column(name = "LEVEL_ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String levelId;
	
	/** 	评级方案ID	  **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 32)
	private String schemeId;
	
	/** 	评级标准ID	  **/
	@Column(name = "STANDARD_ID", unique = false, nullable = true, length = 32)
	private String standardId;
	
	/** 	价值等级	  **/
	@Column(name = "GRADE_LEVEL", unique = false, nullable = true, length = 20)
	private String gradeLevel;
	
	/** 	指标总分下限(包含)	  **/
	@Column(name = "LEVEL_LOWER", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal levelLower;
	
	/** 	指标总分上限(不包含)	  **/
	@Column(name = "LEVEL_UPPER", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal levelUpper;
	
	/** 	等级临界参数	  **/
	@Column(name = "LEVEL_CRITICAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal levelCritical;
	
	
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
	 * @param levelId
	 */
	public void setLevelId(String levelId) {
		this.levelId = levelId == null ? null : levelId.trim();
	}
	
    /**
     * @return LevelId
     */	
	public String getLevelId() {
		return this.levelId;
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
	 * @param gradeLevel
	 */
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel == null ? null : gradeLevel.trim();
	}
	
    /**
     * @return GradeLevel
     */	
	public String getGradeLevel() {
		return this.gradeLevel;
	}
	
	/**
	 * @param levelLower
	 */
	public void setLevelLower(java.math.BigDecimal levelLower) {
		this.levelLower = levelLower;
	}
	
    /**
     * @return LevelLower
     */	
	public java.math.BigDecimal getLevelLower() {
		return this.levelLower;
	}
	
	/**
	 * @param levelUpper
	 */
	public void setLevelUpper(java.math.BigDecimal levelUpper) {
		this.levelUpper = levelUpper;
	}
	
    /**
     * @return LevelUpper
     */	
	public java.math.BigDecimal getLevelUpper() {
		return this.levelUpper;
	}
	
	/**
	 * @param levelCritical
	 */
	public void setLevelCritical(java.math.BigDecimal levelCritical) {
		this.levelCritical = levelCritical;
	}
	
    /**
     * @return LevelCritical
     */	
	public java.math.BigDecimal getLevelCritical() {
		return this.levelCritical;
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
        OcrmFciGradeLevel other = (OcrmFciGradeLevel) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getLevelId() == null ? other.getLevelId() == null : this.getLevelId().equals(other.getLevelId()))
        	&& (this.getSchemeId() == null ? other.getSchemeId() == null : this.getSchemeId().equals(other.getSchemeId()))
        	&& (this.getStandardId() == null ? other.getStandardId() == null : this.getStandardId().equals(other.getStandardId()))
        	&& (this.getGradeLevel() == null ? other.getGradeLevel() == null : this.getGradeLevel().equals(other.getGradeLevel()))
                                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getLevelId() == null) ? 0 : getLevelId().hashCode());
        result = prime * result + ((getSchemeId() == null) ? 0 : getSchemeId().hashCode());
        result = prime * result + ((getStandardId() == null) ? 0 : getStandardId().hashCode());
        result = prime * result + ((getGradeLevel() == null) ? 0 : getGradeLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", levelId=").append(levelId);
		sb.append(", schemeId=").append(schemeId);
		sb.append(", standardId=").append(standardId);
		sb.append(", gradeLevel=").append(gradeLevel);
		sb.append(", levelLower=").append(levelLower);
		sb.append(", levelUpper=").append(levelUpper);
		sb.append(", levelCritical=").append(levelCritical);
        sb.append("]");
        return sb.toString();
    }
}