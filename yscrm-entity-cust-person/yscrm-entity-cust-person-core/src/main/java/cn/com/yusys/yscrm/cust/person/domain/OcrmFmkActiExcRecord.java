package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFmkActiExcRecord
 * @类描述: #数据实体类
 * @功能描述: 客户营销活动执行明细列表
 * @创建人: 15104
 * @创建时间: 2019-02-14 17:31:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_MK_ACTI_EXC_RECORD")
public class OcrmFmkActiExcRecord extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键
 **/
	@Column(name = "RECORD_ID", unique = false, nullable = false, length = 0)
	private java.math.BigDecimal recordId;
	
	/** 营销活动编号
 **/
	@Column(name = "ACTI_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal actiId;
	
	/** 客户编号
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 100)
	private String custId;
	
	/** 客户名称
 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 400)
	private String custName;
	
	/** 主办客户经理
 **/
	@Column(name = "MAJOR_MANGER", unique = false, nullable = true, length = 100)
	private String majorManger;
	
	/** 主办机构
 **/
	@Column(name = "MAJOR_ORG", unique = false, nullable = true, length = 200)
	private String majorOrg;
	
	/** 进展阶段
 **/
	@Column(name = "PROGRESS_STAGE", unique = false, nullable = true, length = 30)
	private String progressStage;
	
	/** 是否已经联系客户
 **/
	@Column(name = "RELATION_CUSTOMER", unique = false, nullable = true, length = 30)
	private String relationCustomer;
	
	/** 目标产品编号
 **/
	@Column(name = "PRODUCT_ID", unique = false, nullable = true, length = 30)
	private String productId;
	
	/** 目标产品名称
 **/
	@Column(name = "PRODUCT_NAME", unique = false, nullable = true, length = 100)
	private String productName;
	
	/** 执行人编号
 **/
	@Column(name = "EXECUTOR_ID", unique = false, nullable = true, length = 100)
	private String executorId;
	
	/** 执行人姓名
 **/
	@Column(name = "EXECUTOR_NAME", unique = false, nullable = true, length = 30)
	private String executorName;
	
	/** 执行日期
 **/
	@Column(name = "EXECUTOR_DATE", unique = false, nullable = true, length = 7)
	private Date executorDate;
	
	/** 执行渠道
 **/
	@Column(name = "EXECUTOR_CANAL", unique = false, nullable = true, length = 100)
	private String executorCanal;
	
	/** 执行结果
 **/
	@Column(name = "EXECUTOR_RESULT", unique = false, nullable = true, length = 100)
	private String executorResult;
	
	/** 待跟进事项
 **/
	@Column(name = "PREP_EVENT", unique = false, nullable = true, length = 200)
	private String prepEvent;
	
	/** 备注
 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 500)
	private String remark;
	
	/** 创建人
 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 50)
	private String createUser;
	
	/** 创建时间
 **/
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
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}
	
    /**
     * @return CustName
     */	
	public String getCustName() {
		return this.custName;
	}
	
	/**
	 * @param majorManger
	 */
	public void setMajorManger(String majorManger) {
		this.majorManger = majorManger == null ? null : majorManger.trim();
	}
	
    /**
     * @return MajorManger
     */	
	public String getMajorManger() {
		return this.majorManger;
	}
	
	/**
	 * @param majorOrg
	 */
	public void setMajorOrg(String majorOrg) {
		this.majorOrg = majorOrg == null ? null : majorOrg.trim();
	}
	
    /**
     * @return MajorOrg
     */	
	public String getMajorOrg() {
		return this.majorOrg;
	}
	
	/**
	 * @param progressStage
	 */
	public void setProgressStage(String progressStage) {
		this.progressStage = progressStage == null ? null : progressStage.trim();
	}
	
    /**
     * @return ProgressStage
     */	
	public String getProgressStage() {
		return this.progressStage;
	}
	
	/**
	 * @param relationCustomer
	 */
	public void setRelationCustomer(String relationCustomer) {
		this.relationCustomer = relationCustomer == null ? null : relationCustomer.trim();
	}
	
    /**
     * @return RelationCustomer
     */	
	public String getRelationCustomer() {
		return this.relationCustomer;
	}
	
	/**
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId == null ? null : productId.trim();
	}
	
    /**
     * @return ProductId
     */	
	public String getProductId() {
		return this.productId;
	}
	
	/**
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}
	
    /**
     * @return ProductName
     */	
	public String getProductName() {
		return this.productName;
	}
	
	/**
	 * @param executorId
	 */
	public void setExecutorId(String executorId) {
		this.executorId = executorId == null ? null : executorId.trim();
	}
	
    /**
     * @return ExecutorId
     */	
	public String getExecutorId() {
		return this.executorId;
	}
	
	/**
	 * @param executorName
	 */
	public void setExecutorName(String executorName) {
		this.executorName = executorName == null ? null : executorName.trim();
	}
	
    /**
     * @return ExecutorName
     */	
	public String getExecutorName() {
		return this.executorName;
	}
	
	/**
	 * @param executorDate
	 */
	public void setExecutorDate(Date executorDate) {
		this.executorDate = executorDate;
	}
	
    /**
     * @return ExecutorDate
     */	
	public Date getExecutorDate() {
		return this.executorDate;
	}
	
	/**
	 * @param executorCanal
	 */
	public void setExecutorCanal(String executorCanal) {
		this.executorCanal = executorCanal == null ? null : executorCanal.trim();
	}
	
    /**
     * @return ExecutorCanal
     */	
	public String getExecutorCanal() {
		return this.executorCanal;
	}
	
	/**
	 * @param executorResult
	 */
	public void setExecutorResult(String executorResult) {
		this.executorResult = executorResult == null ? null : executorResult.trim();
	}
	
    /**
     * @return ExecutorResult
     */	
	public String getExecutorResult() {
		return this.executorResult;
	}
	
	/**
	 * @param prepEvent
	 */
	public void setPrepEvent(String prepEvent) {
		this.prepEvent = prepEvent == null ? null : prepEvent.trim();
	}
	
    /**
     * @return PrepEvent
     */	
	public String getPrepEvent() {
		return this.prepEvent;
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
        OcrmFmkActiExcRecord other = (OcrmFmkActiExcRecord) that;
                		return (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getMajorManger() == null ? other.getMajorManger() == null : this.getMajorManger().equals(other.getMajorManger()))
        	&& (this.getMajorOrg() == null ? other.getMajorOrg() == null : this.getMajorOrg().equals(other.getMajorOrg()))
        	&& (this.getProgressStage() == null ? other.getProgressStage() == null : this.getProgressStage().equals(other.getProgressStage()))
        	&& (this.getRelationCustomer() == null ? other.getRelationCustomer() == null : this.getRelationCustomer().equals(other.getRelationCustomer()))
        	&& (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
        	&& (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
        	&& (this.getExecutorId() == null ? other.getExecutorId() == null : this.getExecutorId().equals(other.getExecutorId()))
        	&& (this.getExecutorName() == null ? other.getExecutorName() == null : this.getExecutorName().equals(other.getExecutorName()))
                	&& (this.getExecutorCanal() == null ? other.getExecutorCanal() == null : this.getExecutorCanal().equals(other.getExecutorCanal()))
        	&& (this.getExecutorResult() == null ? other.getExecutorResult() == null : this.getExecutorResult().equals(other.getExecutorResult()))
        	&& (this.getPrepEvent() == null ? other.getPrepEvent() == null : this.getPrepEvent().equals(other.getPrepEvent()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getMajorManger() == null) ? 0 : getMajorManger().hashCode());
        result = prime * result + ((getMajorOrg() == null) ? 0 : getMajorOrg().hashCode());
        result = prime * result + ((getProgressStage() == null) ? 0 : getProgressStage().hashCode());
        result = prime * result + ((getRelationCustomer() == null) ? 0 : getRelationCustomer().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getExecutorId() == null) ? 0 : getExecutorId().hashCode());
        result = prime * result + ((getExecutorName() == null) ? 0 : getExecutorName().hashCode());
        result = prime * result + ((getExecutorCanal() == null) ? 0 : getExecutorCanal().hashCode());
        result = prime * result + ((getExecutorResult() == null) ? 0 : getExecutorResult().hashCode());
        result = prime * result + ((getPrepEvent() == null) ? 0 : getPrepEvent().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", majorManger=").append(majorManger);
		sb.append(", majorOrg=").append(majorOrg);
		sb.append(", progressStage=").append(progressStage);
		sb.append(", relationCustomer=").append(relationCustomer);
		sb.append(", productId=").append(productId);
		sb.append(", productName=").append(productName);
		sb.append(", executorId=").append(executorId);
		sb.append(", executorName=").append(executorName);
		sb.append(", executorDate=").append(executorDate);
		sb.append(", executorCanal=").append(executorCanal);
		sb.append(", executorResult=").append(executorResult);
		sb.append(", prepEvent=").append(prepEvent);
		sb.append(", remark=").append(remark);
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