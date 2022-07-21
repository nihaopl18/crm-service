package cn.com.yusys.climp.acct.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: LoyAcScoreAcctHis
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: ZZZ
 * @创建时间: 2019-01-04 14:02:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_AC_SCORE_ACCT_HIS")
public class LoyAcScoreAcctHis extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = false, nullable = false, length = 32)
	private String id;
	
	/** 账户编号 **/
	@Column(name = "ACCOUNT_NO", unique = false, nullable = true, length = 20)
	private String accountNo;
	
	/** 账户名称 **/
	@Column(name = "ACCOUNT_NAME", unique = false, nullable = true, length = 100)
	private String accountName;
	
	/** 账户类别ID **/
	@Column(name = "ACCT_TYPE_ID", unique = false, nullable = true, length = 32)
	private String acctTypeId;
	
	/** 修改内容 **/
	@Column(name = "UPDATE_CONTENT", unique = false, nullable = true, length = 100)
	private String updateContent;
	
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
	 * @param accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo == null ? null : accountNo.trim();
	}
	
    /**
     * @return AccountNo
     */	
	public String getAccountNo() {
		return this.accountNo;
	}
	
	/**
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName == null ? null : accountName.trim();
	}
	
    /**
     * @return AccountName
     */	
	public String getAccountName() {
		return this.accountName;
	}
	
	/**
	 * @param acctTypeId
	 */
	public void setAcctTypeId(String acctTypeId) {
		this.acctTypeId = acctTypeId == null ? null : acctTypeId.trim();
	}
	
    /**
     * @return AcctTypeId
     */	
	public String getAcctTypeId() {
		return this.acctTypeId;
	}
	
	/**
	 * @param updateContent
	 */
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent == null ? null : updateContent.trim();
	}
	
    /**
     * @return UpdateContent
     */	
	public String getUpdateContent() {
		return this.updateContent;
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
        LoyAcScoreAcctHis other = (LoyAcScoreAcctHis) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
        	&& (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
        	&& (this.getAcctTypeId() == null ? other.getAcctTypeId() == null : this.getAcctTypeId().equals(other.getAcctTypeId()))
        	&& (this.getUpdateContent() == null ? other.getUpdateContent() == null : this.getUpdateContent().equals(other.getUpdateContent()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getAcctTypeId() == null) ? 0 : getAcctTypeId().hashCode());
        result = prime * result + ((getUpdateContent() == null) ? 0 : getUpdateContent().hashCode());
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
		sb.append(", id=").append(id);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", accountName=").append(accountName);
		sb.append(", acctTypeId=").append(acctTypeId);
		sb.append(", updateContent=").append(updateContent);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
        sb.append("]");
        return sb.toString();
    }
}