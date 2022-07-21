package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlScoreProject
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_RL_SCORE_PROJECT")
public class LoyRlScoreProject extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 项目ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "PROJECT_ID", unique = false, nullable = false, length = 32)
	private String projectId;
	
	/** 项目名称 **/
	@Column(name = "PROJECT_NAME", unique = false, nullable = true, length = 100)
	private String projectName;
	
	/** 启停标志[其停用标示，0停用，1使用，数据字典定义] **/
	@Column(name = "USE_FLAG", unique = false, nullable = true, length = 10)
	private String useFlag;
	
	/** 父项目ID **/
	@Column(name = "PARENT_PRO_ID", unique = false, nullable = true, length = 32)
	private String parentProId;
	
	/** 序号 **/
	@Column(name = "SEQ_NO", unique = false, nullable = true, length = 10)
	private String seqNo;
	
	/** 金融机构id **/
	@Column(name = "INSTITUTION_ID", unique = false, nullable = true, length = 50)
	private String institutionId;
	
	/** 金融机构名称 **/
	@Column(name = "INSTITUTION_NAME", unique = false, nullable = true, length = 500)
	private String institutionName;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 1024)
	private String remark;
	
	/** 删除标志(1为删除，在系统全局参数中定义) **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	
	/**
	 * @param projectId
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId == null ? null : projectId.trim();
	}
	
    /**
     * @return ProjectId
     */	
	public String getProjectId() {
		return this.projectId;
	}
	
	/**
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}
	
    /**
     * @return ProjectName
     */	
	public String getProjectName() {
		return this.projectName;
	}
	
	/**
	 * @param useFlag
	 */
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag == null ? null : useFlag.trim();
	}
	
    /**
     * @return UseFlag
     */	
	public String getUseFlag() {
		return this.useFlag;
	}
	
	/**
	 * @param parentProId
	 */
	public void setParentProId(String parentProId) {
		this.parentProId = parentProId == null ? null : parentProId.trim();
	}
	
    /**
     * @return ParentProId
     */	
	public String getParentProId() {
		return this.parentProId;
	}
	
	/**
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo == null ? null : seqNo.trim();
	}
	
    /**
     * @return SeqNo
     */	
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * @param institutionId
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId == null ? null : institutionId.trim();
	}
	
    /**
     * @return InstitutionId
     */	
	public String getInstitutionId() {
		return this.institutionId;
	}
	
	/**
	 * @param institutionName
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName == null ? null : institutionName.trim();
	}
	
    /**
     * @return InstitutionName
     */	
	public String getInstitutionName() {
		return this.institutionName;
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
	
	/**
	 * @param deleteSign
	 */
	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign == null ? null : deleteSign.trim();
	}
	
    /**
     * @return DeleteSign
     */	
	public String getDeleteSign() {
		return this.deleteSign;
	}
	
	/**
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
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
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}
	
    /**
     * @return UpdateUser
     */	
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
    /**
     * @return UpdateDate
     */	
	public Date getUpdateDate() {
		return this.updateDate;
	}
	
	/**
	 * @param updateOrg
	 */
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}
	
    /**
     * @return UpdateOrg
     */	
	public String getUpdateOrg() {
		return this.updateOrg;
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
        LoyRlScoreProject other = (LoyRlScoreProject) that;
		return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
        	&& (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
        	&& (this.getUseFlag() == null ? other.getUseFlag() == null : this.getUseFlag().equals(other.getUseFlag()))
        	&& (this.getParentProId() == null ? other.getParentProId() == null : this.getParentProId().equals(other.getParentProId()))
        	&& (this.getSeqNo() == null ? other.getSeqNo() == null : this.getSeqNo().equals(other.getSeqNo()))
        	&& (this.getInstitutionId() == null ? other.getInstitutionId() == null : this.getInstitutionId().equals(other.getInstitutionId()))
        	&& (this.getInstitutionName() == null ? other.getInstitutionName() == null : this.getInstitutionName().equals(other.getInstitutionName()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getUseFlag() == null) ? 0 : getUseFlag().hashCode());
        result = prime * result + ((getParentProId() == null) ? 0 : getParentProId().hashCode());
        result = prime * result + ((getSeqNo() == null) ? 0 : getSeqNo().hashCode());
        result = prime * result + ((getInstitutionId() == null) ? 0 : getInstitutionId().hashCode());
        result = prime * result + ((getInstitutionName() == null) ? 0 : getInstitutionName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", projectId=").append(projectId);
		sb.append(", projectName=").append(projectName);
		sb.append(", useFlag=").append(useFlag);
		sb.append(", parentProId=").append(parentProId);
		sb.append(", seqNo=").append(seqNo);
		sb.append(", institutionId=").append(institutionId);
		sb.append(", institutionName=").append(institutionName);
		sb.append(", remark=").append(remark);
		sb.append(", deleteSign=").append(deleteSign);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
        sb.append("]");
        return sb.toString();
    }
}