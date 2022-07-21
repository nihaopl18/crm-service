package cn.com.yusys.yscrm.custpub.domain;

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
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciGrantApply
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-15 11:56:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_GRANT_APPLY")
public class OcrmFciGrantApply extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "APPLY_ID")
	@Generated(GenerationType.UUID)
	private java.math.BigDecimal applyId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 授权有效期 **/
	@Column(name = "DEAD_LINE", unique = false, nullable = true, length = 10)
	private Date deadLine;
	
	/** 客户经理编号 **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 20)
	private String mgrId;
	
	/** 客户经理姓名 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 200)
	private String mgrName;
	
	/** 授权客户经理编号 **/
	@Column(name = "GRANT_MGR_ID", unique = false, nullable = true, length = 20)
	private String grantMgrId;
	
	/** 授权客户经理姓名 **/
	@Column(name = "GRANT_MGR_NAME", unique = false, nullable = true, length = 200)
	private String grantMgrName;
	
	/** 设置人ID **/
	@Column(name = "SET_USER_ID", unique = false, nullable = true, length = 30)
	private String setUserId;
	
	/** 设置人 **/
	@Column(name = "SET_USER_NAME", unique = false, nullable = true, length = 200)
	private String setUserName;
	
	/** 授权时间 **/
	@Column(name = "SET_DATE", unique = false, nullable = true, length = 10)
	private Date setDate;
	
	/** 授权理由 **/
	@Column(name = "GRANT_REASON", unique = false, nullable = true, length = 800)
	private String grantReason;
	
	/** 授权状态 **/
	@Column(name = "GRANT_STAT", unique = false, nullable = true, length = 30)
	private String grantStat;
	
	/** 授权视图类型 **/
	@Column(name = "GRANT_VIEW_TYPE", unique = false, nullable = true, length = 20)
	private String grantViewType;
	
	/** 授权状视图项**/
	@Column(name = "GRANT_VIEW_ITEM", unique = false, nullable = true, length = 100)
	private String grantViewItem;
	
	/** 授权客户数 **/
	@Transient
	private int custNum;
	
	/** 授权客户编号 **/
	@Transient
	private String[] custId;
	
	/** 授权客户名称 **/
	@Transient
	private String[] custName;
	
	/**
	 * @param applyId
	 */
	public void setApplyId(java.math.BigDecimal applyId) {
		this.applyId = applyId;
	}
	
    /**
     * @return ApplyId
     */	
	public java.math.BigDecimal getApplyId() {
		return this.applyId;
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
	 * @param deadLine
	 */
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
    /**
     * @return DeadLine
     */	
	public Date getDeadLine() {
		return this.deadLine;
	}
	
	/**
	 * @param mgrId
	 */
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId == null ? null : mgrId.trim();
	}
	
    /**
     * @return MgrId
     */	
	public String getMgrId() {
		return this.mgrId;
	}
	
	/**
	 * @param mgrName
	 */
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName == null ? null : mgrName.trim();
	}
	
    /**
     * @return MgrName
     */	
	public String getMgrName() {
		return this.mgrName;
	}
	
	/**
	 * @param grantMgrId
	 */
	public void setGrantMgrId(String grantMgrId) {
		this.grantMgrId = grantMgrId == null ? null : grantMgrId.trim();
	}
	
    /**
     * @return GrantMgrId
     */	
	public String getGrantMgrId() {
		return this.grantMgrId;
	}
	
	/**
	 * @param grantMgrName
	 */
	public void setGrantMgrName(String grantMgrName) {
		this.grantMgrName = grantMgrName == null ? null : grantMgrName.trim();
	}
	
    /**
     * @return GrantMgrName
     */	
	public String getGrantMgrName() {
		return this.grantMgrName;
	}
	
	/**
	 * @param setUserId
	 */
	public void setSetUserId(String setUserId) {
		this.setUserId = setUserId == null ? null : setUserId.trim();
	}
	
    /**
     * @return SetUserId
     */	
	public String getSetUserId() {
		return this.setUserId;
	}
	
	/**
	 * @param setUserName
	 */
	public void setSetUserName(String setUserName) {
		this.setUserName = setUserName == null ? null : setUserName.trim();
	}
	
    /**
     * @return SetUserName
     */	
	public String getSetUserName() {
		return this.setUserName;
	}
	
	/**
	 * @param setDate
	 */
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	
    /**
     * @return SetDate
     */	
	public Date getSetDate() {
		return this.setDate;
	}
	
	/**
	 * @param grantReason
	 */
	public void setGrantReason(String grantReason) {
		this.grantReason = grantReason == null ? null : grantReason.trim();
	}
	
    /**
     * @return GrantReason
     */	
	public String getGrantReason() {
		return this.grantReason;
	}
	
	/**
	 * @param grantStat
	 */
	public void setGrantStat(String grantStat) {
		this.grantStat = grantStat == null ? null : grantStat.trim();
	}
	
    /**
     * @return GrantStat
     */	
	public String getGrantStat() {
		return this.grantStat;
	}
	
	/**
	 * @param custNum
	 */
	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}
	
    /**
     * @return custNum
     */	
	public int getCustNum() {
		return this.custNum;
	}
	
	/**
	 * @param custId
	 */
	public void setCustNum(String[] custId) {
		this.custId = custId;
	}
	
    /**
     * @return custId
     */	
	public String[] getCustId() {
		return this.custId;
	}
	
	/**
	 * @param custName
	 */
	public void setCustName(String[] custName) {
		this.custName = custName;
	}
	
    /**
     * @return custName
     */	
	public String[] getCustName() {
		return this.custName;
	}
	
	/**
	 * @param grantViewType
	 */
	public void setGrantViewType(String grantViewType) {
		this.grantViewType = grantViewType;
	}
	
    /**
     * @return grantViewType
     */	
	public String getGrantViewType() {
		return this.grantViewType;
	}
	
	/**
	 * @param grantViewItem
	 */
	public void setGrantViewItem(String grantViewItem) {
		this.grantViewItem = grantViewItem;
	}
	
    /**
     * @return grantViewItem
     */	
	public String getGrantViewItem() {
		return this.grantViewItem;
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
        OcrmFciGrantApply other = (OcrmFciGrantApply) that;
        		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getGrantMgrId() == null ? other.getGrantMgrId() == null : this.getGrantMgrId().equals(other.getGrantMgrId()))
        	&& (this.getGrantMgrName() == null ? other.getGrantMgrName() == null : this.getGrantMgrName().equals(other.getGrantMgrName()))
        	&& (this.getSetUserId() == null ? other.getSetUserId() == null : this.getSetUserId().equals(other.getSetUserId()))
        	&& (this.getSetUserName() == null ? other.getSetUserName() == null : this.getSetUserName().equals(other.getSetUserName()))
                	&& (this.getGrantReason() == null ? other.getGrantReason() == null : this.getGrantReason().equals(other.getGrantReason()))
        	&& (this.getGrantStat() == null ? other.getGrantStat() == null : this.getGrantStat().equals(other.getGrantStat()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getGrantMgrId() == null) ? 0 : getGrantMgrId().hashCode());
        result = prime * result + ((getGrantMgrName() == null) ? 0 : getGrantMgrName().hashCode());
        result = prime * result + ((getSetUserId() == null) ? 0 : getSetUserId().hashCode());
        result = prime * result + ((getSetUserName() == null) ? 0 : getSetUserName().hashCode());
        result = prime * result + ((getGrantReason() == null) ? 0 : getGrantReason().hashCode());
        result = prime * result + ((getGrantStat() == null) ? 0 : getGrantStat().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", applyId=").append(applyId);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", deadLine=").append(deadLine);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", grantMgrId=").append(grantMgrId);
		sb.append(", grantMgrName=").append(grantMgrName);
		sb.append(", setUserId=").append(setUserId);
		sb.append(", setUserName=").append(setUserName);
		sb.append(", setDate=").append(setDate);
		sb.append(", grantReason=").append(grantReason);
		sb.append(", grantStat=").append(grantStat);
        sb.append("]");
        return sb.toString();
    }
}