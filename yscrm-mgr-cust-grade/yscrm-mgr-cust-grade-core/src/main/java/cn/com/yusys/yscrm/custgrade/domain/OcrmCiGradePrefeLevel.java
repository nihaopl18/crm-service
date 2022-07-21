package cn.com.yusys.yscrm.custgrade.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmCiGradePrefeLevel
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 10:37:53
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_CI_GRADE_PREFE_LEVEL")
public class OcrmCiGradePrefeLevel extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 	法人	  **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 32)
	private String corpOrgCode;
	
	/** 	优惠方案编号	  **/
	@Column(name = "PREFERENT_ID", unique = false, nullable = true, length = 30)
	private String preferentId;
	
	/** 	对应服务等级	  **/
	@Column(name = "GRADE_LEVEL", unique = false, nullable = true, length = 1)
	private String gradeLevel;
	
	/** 	优惠内容	  **/
	@Column(name = "PREFERENT_STR", unique = false, nullable = true, length = 100)
	private String preferentStr;
	
	/** 	创建时间	  **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 10)
	private String createDate;
	
	/** 	创建人ID	  **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 30)
	private String createUserId;
	
	/** 	创建人所在机构ID	  **/
	@Column(name = "CREATE_ORG_ID", unique = false, nullable = true, length = 30)
	private String createOrgId;
	
	/** 	最近更新人时间	  **/
	@Column(name = "LAST_UPDATE_DATE", unique = false, nullable = true, length = 30)
	private String lastUpdateDate;
	
	/** 	最近更新人ID	  **/
	@Column(name = "LAST_UPDATE_USER_ID", unique = false, nullable = true, length = 30)
	private String lastUpdateUserId;
	
	/** 	最近更新人所在机构ID	  **/
	@Column(name = "LAST_UPDATE_ORG_ID", unique = false, nullable = true, length = 30)
	private String lastUpdateOrgId;
	
	
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
	 * @param preferentId
	 */
	public void setPreferentId(String preferentId) {
		this.preferentId = preferentId == null ? null : preferentId.trim();
	}
	
    /**
     * @return PreferentId
     */	
	public String getPreferentId() {
		return this.preferentId;
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
	 * @param preferentStr
	 */
	public void setPreferentStr(String preferentStr) {
		this.preferentStr = preferentStr == null ? null : preferentStr.trim();
	}
	
    /**
     * @return PreferentStr
     */	
	public String getPreferentStr() {
		return this.preferentStr;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}
	
    /**
     * @return CreateDate
     */	
	public String getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId == null ? null : createUserId.trim();
	}
	
    /**
     * @return CreateUserId
     */	
	public String getCreateUserId() {
		return this.createUserId;
	}
	
	/**
	 * @param createOrgId
	 */
	public void setCreateOrgId(String createOrgId) {
		this.createOrgId = createOrgId == null ? null : createOrgId.trim();
	}
	
    /**
     * @return CreateOrgId
     */	
	public String getCreateOrgId() {
		return this.createOrgId;
	}
	
	/**
	 * @param lastUpdateDate
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate == null ? null : lastUpdateDate.trim();
	}
	
    /**
     * @return LastUpdateDate
     */	
	public String getLastUpdateDate() {
		return this.lastUpdateDate;
	}
	
	/**
	 * @param lastUpdateUserId
	 */
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId == null ? null : lastUpdateUserId.trim();
	}
	
    /**
     * @return LastUpdateUserId
     */	
	public String getLastUpdateUserId() {
		return this.lastUpdateUserId;
	}
	
	/**
	 * @param lastUpdateOrgId
	 */
	public void setLastUpdateOrgId(String lastUpdateOrgId) {
		this.lastUpdateOrgId = lastUpdateOrgId == null ? null : lastUpdateOrgId.trim();
	}
	
    /**
     * @return LastUpdateOrgId
     */	
	public String getLastUpdateOrgId() {
		return this.lastUpdateOrgId;
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
        OcrmCiGradePrefeLevel other = (OcrmCiGradePrefeLevel) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getPreferentId() == null ? other.getPreferentId() == null : this.getPreferentId().equals(other.getPreferentId()))
        	&& (this.getGradeLevel() == null ? other.getGradeLevel() == null : this.getGradeLevel().equals(other.getGradeLevel()))
        	&& (this.getPreferentStr() == null ? other.getPreferentStr() == null : this.getPreferentStr().equals(other.getPreferentStr()))
        	&& (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
        	&& (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
        	&& (this.getCreateOrgId() == null ? other.getCreateOrgId() == null : this.getCreateOrgId().equals(other.getCreateOrgId()))
        	&& (this.getLastUpdateDate() == null ? other.getLastUpdateDate() == null : this.getLastUpdateDate().equals(other.getLastUpdateDate()))
        	&& (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()))
        	&& (this.getLastUpdateOrgId() == null ? other.getLastUpdateOrgId() == null : this.getLastUpdateOrgId().equals(other.getLastUpdateOrgId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPreferentId() == null) ? 0 : getPreferentId().hashCode());
        result = prime * result + ((getGradeLevel() == null) ? 0 : getGradeLevel().hashCode());
        result = prime * result + ((getPreferentStr() == null) ? 0 : getPreferentStr().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateOrgId() == null) ? 0 : getCreateOrgId().hashCode());
        result = prime * result + ((getLastUpdateDate() == null) ? 0 : getLastUpdateDate().hashCode());
        result = prime * result + ((getLastUpdateUserId() == null) ? 0 : getLastUpdateUserId().hashCode());
        result = prime * result + ((getLastUpdateOrgId() == null) ? 0 : getLastUpdateOrgId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", id=").append(id);
		sb.append(", preferentId=").append(preferentId);
		sb.append(", gradeLevel=").append(gradeLevel);
		sb.append(", preferentStr=").append(preferentStr);
		sb.append(", createDate=").append(createDate);
		sb.append(", createUserId=").append(createUserId);
		sb.append(", createOrgId=").append(createOrgId);
		sb.append(", lastUpdateDate=").append(lastUpdateDate);
		sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
		sb.append(", lastUpdateOrgId=").append(lastUpdateOrgId);
        sb.append("]");
        return sb.toString();
    }
}