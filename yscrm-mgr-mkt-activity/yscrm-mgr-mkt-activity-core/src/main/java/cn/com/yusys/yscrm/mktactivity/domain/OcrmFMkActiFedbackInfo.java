package cn.com.yusys.yscrm.mktactivity.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name="OCRM_F_MK_ACTI_FEDBACK")
public class OcrmFMkActiFedbackInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	/** 主键
 **/
	@Id
	@Column(name = "RECORD_ID", unique = false, nullable = false, length = 0)
	private java.math.BigDecimal recordId;
	
	/** 营销活动编号
 **/
	@Column(name = "ACTI_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal actiId;
	
	/** 活动名称
 **/
	@Column(name = "ACTI_NAME", unique = false, nullable = true, length = 100)
	private String actiName;
	
	/** 活动受众人数
 **/
	@Column(name = "ACCE_HUMAN_NUM", unique = false, nullable = true, length = 100)
	private String acceHumanNum;
	
	/** 派发宣传单张数量
 **/
	@Column(name = "ADV_PAPER_NUM", unique = false, nullable = true, length = 100)
	private String advPaperNum;
	
	/** 实际费用支出
 **/
	@Column(name = "COST_IN_ACTION", unique = false, nullable = true, length = 100)
	private String costInAction;
	
	/** 活动经验总结
 **/
	@Column(name = "OUTCOME_IN_ACTION", unique = false, nullable = true, length = 500)
	private String outcomeInAction;
	
	/** 客户评价
 **/
	@Column(name = "REVIEW_IN_COUSTOMER", unique = false, nullable = true, length = 500)
	private String reviewInCoustomer;
	
	/** 反馈人
 **/
	@Column(name = "FD_USER", unique = false, nullable = true, length = 30)
	private String fdUser;
	
	/** 反馈时间
 **/
	//@Transient
	@Column(name = "FD_DATE", unique = false, nullable = true, length = 7)
	private Date fdDate;
	
	/** 创建人
 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 50)
	private String createUser;
	
	/** 创建时间
 **/
	//@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构
 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 50)
	private String createOrg;
	
	/** 最近更新人
 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 50)
	private String updateUser;
	
	/** 最近更新时间
 **/
	//@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近更新机构
 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 50)
	private String updateOrg;
	
	
	/**
	 * @param recordId
	 */
	public void setRecordId(java.math.BigDecimal recordId) {
		this.recordId = recordId;
	}
	
    /**
     * @return RecordId
     */	
	public java.math.BigDecimal getRecordId() {
		return this.recordId;
	}
	
	/**
	 * @param actiId
	 */
	public void setActiId(java.math.BigDecimal actiId) {
		this.actiId = actiId;
	}
	
    /**
     * @return ActiId
     */	
	public java.math.BigDecimal getActiId() {
		return this.actiId;
	}
	
	/**
	 * @param actiName
	 */
	public void setActiName(String actiName) {
		this.actiName = actiName == null ? null : actiName.trim();
	}
	
    /**
     * @return ActiName
     */	
	public String getActiName() {
		return this.actiName;
	}
	
	/**
	 * @param acceHumanNum
	 */
	public void setAcceHumanNum(String acceHumanNum) {
		this.acceHumanNum = acceHumanNum == null ? null : acceHumanNum.trim();
	}
	
    /**
     * @return AcceHumanNum
     */	
	public String getAcceHumanNum() {
		return this.acceHumanNum;
	}
	
	/**
	 * @param advPaperNum
	 */
	public void setAdvPaperNum(String advPaperNum) {
		this.advPaperNum = advPaperNum == null ? null : advPaperNum.trim();
	}
	
    /**
     * @return AdvPaperNum
     */	
	public String getAdvPaperNum() {
		return this.advPaperNum;
	}
	
	/**
	 * @param costInAction
	 */
	public void setCostInAction(String costInAction) {
		this.costInAction = costInAction == null ? null : costInAction.trim();
	}
	
    /**
     * @return CostInAction
     */	
	public String getCostInAction() {
		return this.costInAction;
	}
	
	/**
	 * @param outcomeInAction
	 */
	public void setOutcomeInAction(String outcomeInAction) {
		this.outcomeInAction = outcomeInAction == null ? null : outcomeInAction.trim();
	}
	
    /**
     * @return OutcomeInAction
     */	
	public String getOutcomeInAction() {
		return this.outcomeInAction;
	}
	
	/**
	 * @param reviewInCoustomer
	 */
	public void setReviewInCoustomer(String reviewInCoustomer) {
		this.reviewInCoustomer = reviewInCoustomer == null ? null : reviewInCoustomer.trim();
	}
	
    /**
     * @return ReviewInCoustomer
     */	
	public String getReviewInCoustomer() {
		return this.reviewInCoustomer;
	}
	
	/**
	 * @param fdUser
	 */
	public void setFdUser(String fdUser) {
		this.fdUser = fdUser == null ? null : fdUser.trim();
	}
	
    /**
     * @return FdUser
     */	
	public String getFdUser() {
		return this.fdUser;
	}
	
	/**
	 * @param fdDate
	 */
	public void setFdDate(Date fdDate) {
		this.fdDate = fdDate;
	}
	
    /**
     * @return FdDate
     */	
	public Date getFdDate() {
		return this.fdDate;
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
        OcrmFMkActiFedbackInfo other = (OcrmFMkActiFedbackInfo) that;
                		return (this.getActiName() == null ? other.getActiName() == null : this.getActiName().equals(other.getActiName()))
        	&& (this.getAcceHumanNum() == null ? other.getAcceHumanNum() == null : this.getAcceHumanNum().equals(other.getAcceHumanNum()))
        	&& (this.getAdvPaperNum() == null ? other.getAdvPaperNum() == null : this.getAdvPaperNum().equals(other.getAdvPaperNum()))
        	&& (this.getCostInAction() == null ? other.getCostInAction() == null : this.getCostInAction().equals(other.getCostInAction()))
        	&& (this.getOutcomeInAction() == null ? other.getOutcomeInAction() == null : this.getOutcomeInAction().equals(other.getOutcomeInAction()))
        	&& (this.getReviewInCoustomer() == null ? other.getReviewInCoustomer() == null : this.getReviewInCoustomer().equals(other.getReviewInCoustomer()))
        	&& (this.getFdUser() == null ? other.getFdUser() == null : this.getFdUser().equals(other.getFdUser()))
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
        result = prime * result + ((getActiName() == null) ? 0 : getActiName().hashCode());
        result = prime * result + ((getAcceHumanNum() == null) ? 0 : getAcceHumanNum().hashCode());
        result = prime * result + ((getAdvPaperNum() == null) ? 0 : getAdvPaperNum().hashCode());
        result = prime * result + ((getCostInAction() == null) ? 0 : getCostInAction().hashCode());
        result = prime * result + ((getOutcomeInAction() == null) ? 0 : getOutcomeInAction().hashCode());
        result = prime * result + ((getReviewInCoustomer() == null) ? 0 : getReviewInCoustomer().hashCode());
        result = prime * result + ((getFdUser() == null) ? 0 : getFdUser().hashCode());
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
		sb.append(", recordId=").append(recordId);
		sb.append(", actiId=").append(actiId);
		sb.append(", actiName=").append(actiName);
		sb.append(", acceHumanNum=").append(acceHumanNum);
		sb.append(", advPaperNum=").append(advPaperNum);
		sb.append(", costInAction=").append(costInAction);
		sb.append(", outcomeInAction=").append(outcomeInAction);
		sb.append(", reviewInCoustomer=").append(reviewInCoustomer);
		sb.append(", fdUser=").append(fdUser);
		sb.append(", fdDate=").append(fdDate);
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