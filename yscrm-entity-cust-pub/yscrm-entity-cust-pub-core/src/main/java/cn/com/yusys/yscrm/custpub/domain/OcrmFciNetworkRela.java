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
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNetworkRela
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:23:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_NETWORK_RELA")
public class OcrmFciNetworkRela extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 网络关系编号 **/
	@Id
	@Column(name = "NETWORK_RELA_ID")
	@Generated(GenerationType.UUID)
	private String networkRelaId;
	
	/** 网络关系名称 **/
	@Column(name = "NETWORK_RELA_NAME", unique = false, nullable = false, length = 100)
	private String networkRelaName;
	
	/** 网络关系描述 **/
	@Column(name = "REMARK", unique = false, nullable = false, length = 200)
	private String remark;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER", unique = false, nullable = false, length = 20)
	private String createUser;
	
	/** 创建日期 **/
	//@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = false, length = 7)
	private Date createDate;
	
	/** 创建机构ID **/
	@Column(name = "CREATE_ORG", unique = false, nullable = false, length = 20)
	private String createOrg;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = false, length = 20)
	private String updateUser;
	
	/** 最近更新时间 **/
	//@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = false, length = 7)
	private Date updateDate;
	
	
	/**
	 * @param networkRelaId
	 */
	public void setNetworkRelaId(String networkRelaId) {
		this.networkRelaId = networkRelaId == null ? null : networkRelaId.trim();
	}
	
    /**
     * @return NetworkRelaId
     */	
	public String getNetworkRelaId() {
		return this.networkRelaId;
	}
	
	/**
	 * @param networkRelaName
	 */
	public void setNetworkRelaName(String networkRelaName) {
		this.networkRelaName = networkRelaName == null ? null : networkRelaName.trim();
	}
	
    /**
     * @return NetworkRelaName
     */	
	public String getNetworkRelaName() {
		return this.networkRelaName;
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
        OcrmFciNetworkRela other = (OcrmFciNetworkRela) that;
		return (this.getNetworkRelaId() == null ? other.getNetworkRelaId() == null : this.getNetworkRelaId().equals(other.getNetworkRelaId()))
        	&& (this.getNetworkRelaName() == null ? other.getNetworkRelaName() == null : this.getNetworkRelaName().equals(other.getNetworkRelaName()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNetworkRelaId() == null) ? 0 : getNetworkRelaId().hashCode());
        result = prime * result + ((getNetworkRelaName() == null) ? 0 : getNetworkRelaName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", networkRelaId=").append(networkRelaId);
		sb.append(", networkRelaName=").append(networkRelaName);
		sb.append(", remark=").append(remark);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}