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
 * @类名称: OcrmCiGradePreferent
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 10:36:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_CI_GRADE_PREFERENT")
public class OcrmCiGradePreferent extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**   标识ID    **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 	法人	  **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 100)
	private String corpOrgCode;
	
	/**   优惠方案编号    **/
	@Column(name = "PREFERENT_ID", unique = false, nullable = true, length = 100)
	private String preferentId;
	
	/**   优惠方案内容    **/
	@Column(name = "PREFERENT_CONTENT", unique = false, nullable = true, length = 1000)
	private String preferentContent;
	
	/**   适用客户    **/
	@Column(name = "USE_CUST_TYPE", unique = false, nullable = true, length = 20)
	private String useCustType;
	
	/**   实施渠道    **/
	@Column(name = "USE_CHANNL", unique = false, nullable = true, length = 20)
	private String useChannl;
	
	/**   状态    **/
	@Column(name = "PREFERENT_STATUS", unique = false, nullable = true, length = 20)
	private String preferentStatus;
	
	/**   生效日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "PREFERENT_BEGIN_DATA")
	private Date preferentBeginData;
	
	/**   失效日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "PREFERENT_END_DATA")
	private Date preferentEndData;
	
	/**   所属部门    **/
	@Column(name = "PREFERENT_ORG", unique = false, nullable = true, length = 100)
	private String preferentOrg;
	
	/**   创建日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	/**   创建人ID    **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 20)
	private String createUserId;
	
	/**   创建人所在机构ID    **/
	@Column(name = "CREATE_ORG_ID", unique = false, nullable = true, length = 20)
	private String createOrgId;
	
	/**   最近更新日期    **/
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	/**   最近更新人ID    **/
	@Column(name = "LAST_UPDATE_USER_ID", unique = false, nullable = true, length = 20)
	private String lastUpdateUserId;
	
	/**   最近更新人所在机构ID    **/
	@Column(name = "LAST_UPDATE_ORG_ID", unique = false, nullable = true, length = 20)
	private String lastUpdateOrgId;
	
	/** 优惠方案说明 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 1000)
	private String remark;
	
	
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
	 * @param preferentContent
	 */
	public void setPreferentContent(String preferentContent) {
		this.preferentContent = preferentContent == null ? null : preferentContent.trim();
	}
	
    /**
     * @return PreferentContent
     */	
	public String getPreferentContent() {
		return this.preferentContent;
	}
	
	/**
	 * @param useCustType
	 */
	public void setUseCustType(String useCustType) {
		this.useCustType = useCustType == null ? null : useCustType.trim();
	}
	
    /**
     * @return UseCustType
     */	
	public String getUseCustType() {
		return this.useCustType;
	}
	
	/**
	 * @param useChannl
	 */
	public void setUseChannl(String useChannl) {
		this.useChannl = useChannl == null ? null : useChannl.trim();
	}
	
    /**
     * @return UseChannl
     */	
	public String getUseChannl() {
		return this.useChannl;
	}
	
	/**
	 * @param preferentStatus
	 */
	public void setPreferentStatus(String preferentStatus) {
		this.preferentStatus = preferentStatus == null ? null : preferentStatus.trim();
	}
	
    /**
     * @return PreferentStatus
     */	
	public String getPreferentStatus() {
		return this.preferentStatus;
	}
	
	/**
	 * @param preferentBeginData
	 */
	public void setPreferentBeginData(Date preferentBeginData) {
		this.preferentBeginData = preferentBeginData;
	}
	
    /**
     * @return PreferentBeginData
     */	
	public Date getPreferentBeginData() {
		return this.preferentBeginData;
	}
	
	/**
	 * @param preferentEndData
	 */
	public void setPreferentEndData(Date preferentEndData) {
		this.preferentEndData = preferentEndData;
	}
	
    /**
     * @return PreferentEndData
     */	
	public Date getPreferentEndData() {
		return this.preferentEndData;
	}
	
	/**
	 * @param preferentOrg
	 */
	public void setPreferentOrg(String preferentOrg) {
		this.preferentOrg = preferentOrg == null ? null : preferentOrg.trim();
	}
	
    /**
     * @return PreferentOrg
     */	
	public String getPreferentOrg() {
		return this.preferentOrg;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * @return CreateDate
     */	
	public Date getCreateDate() {
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
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
    /**
     * @return LastUpdateDate
     */	
	public Date getLastUpdateDate() {
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
        OcrmCiGradePreferent other = (OcrmCiGradePreferent) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getPreferentId() == null ? other.getPreferentId() == null : this.getPreferentId().equals(other.getPreferentId()))
        	&& (this.getPreferentContent() == null ? other.getPreferentContent() == null : this.getPreferentContent().equals(other.getPreferentContent()))
        	&& (this.getUseCustType() == null ? other.getUseCustType() == null : this.getUseCustType().equals(other.getUseCustType()))
        	&& (this.getUseChannl() == null ? other.getUseChannl() == null : this.getUseChannl().equals(other.getUseChannl()))
        	&& (this.getPreferentStatus() == null ? other.getPreferentStatus() == null : this.getPreferentStatus().equals(other.getPreferentStatus()))
                        	&& (this.getPreferentOrg() == null ? other.getPreferentOrg() == null : this.getPreferentOrg().equals(other.getPreferentOrg()))
                	&& (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
        	&& (this.getCreateOrgId() == null ? other.getCreateOrgId() == null : this.getCreateOrgId().equals(other.getCreateOrgId()))
                	&& (this.getLastUpdateUserId() == null ? other.getLastUpdateUserId() == null : this.getLastUpdateUserId().equals(other.getLastUpdateUserId()))
        	&& (this.getLastUpdateOrgId() == null ? other.getLastUpdateOrgId() == null : this.getLastUpdateOrgId().equals(other.getLastUpdateOrgId()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPreferentId() == null) ? 0 : getPreferentId().hashCode());
        result = prime * result + ((getPreferentContent() == null) ? 0 : getPreferentContent().hashCode());
        result = prime * result + ((getUseCustType() == null) ? 0 : getUseCustType().hashCode());
        result = prime * result + ((getUseChannl() == null) ? 0 : getUseChannl().hashCode());
        result = prime * result + ((getPreferentStatus() == null) ? 0 : getPreferentStatus().hashCode());
        result = prime * result + ((getPreferentOrg() == null) ? 0 : getPreferentOrg().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateOrgId() == null) ? 0 : getCreateOrgId().hashCode());
        result = prime * result + ((getLastUpdateUserId() == null) ? 0 : getLastUpdateUserId().hashCode());
        result = prime * result + ((getLastUpdateOrgId() == null) ? 0 : getLastUpdateOrgId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", preferentContent=").append(preferentContent);
		sb.append(", useCustType=").append(useCustType);
		sb.append(", useChannl=").append(useChannl);
		sb.append(", preferentStatus=").append(preferentStatus);
		sb.append(", preferentBeginData=").append(preferentBeginData);
		sb.append(", preferentEndData=").append(preferentEndData);
		sb.append(", preferentOrg=").append(preferentOrg);
		sb.append(", createDate=").append(createDate);
		sb.append(", createUserId=").append(createUserId);
		sb.append(", createOrgId=").append(createOrgId);
		sb.append(", lastUpdateDate=").append(lastUpdateDate);
		sb.append(", lastUpdateUserId=").append(lastUpdateUserId);
		sb.append(", lastUpdateOrgId=").append(lastUpdateOrgId);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}