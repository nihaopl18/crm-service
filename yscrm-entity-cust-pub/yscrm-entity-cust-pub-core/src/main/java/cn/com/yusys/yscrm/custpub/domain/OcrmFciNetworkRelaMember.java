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
 * @类名称: OcrmFciNetworkRelaMember
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:23:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_NETWORK_RELA_MEMBER")
public class OcrmFciNetworkRelaMember extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	@Id
	@Column(name = "RELA_MEMBER_ID")
	@Generated(GenerationType.UUID)
	private String relaMemberId;
	
	/** 网络关系编号 **/
	@Column(name = "NETWORK_RELA_ID", unique = false, nullable = false, length = 32)
	private String networkRelaId;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = false, length = 40)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = false, length = 200)
	private String custName;
	
	/** x坐标 **/
	@Column(name = "OFFSET_X", unique = false, nullable = true, length = 32)
	private Long offsetX;
	
	/** Y坐标 **/
	@Column(name = "OFFSET_Y", unique = false, nullable = true, length = 32)
	private Long offsetY;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER", unique = false, nullable = false, length = 20)
	private String createUser;
	
	/** 创建日期 **/
	//@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = false, length = 7)
	private Date createDate;
	
	
	/**
	 * @param relaMemberId
	 */
	public void setRelaMemberId(String relaMemberId) {
		this.relaMemberId = relaMemberId == null ? null : relaMemberId.trim();
	}
	
    /**
     * @return RelaMemberId
     */	
	public String getRelaMemberId() {
		return this.relaMemberId;
	}
	
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
	 * @return offsetX
	 */
	public Long getOffsetX() {
		return offsetX;
	}

	/**
	 * @param offsetX 要设置的 offsetX
	 */
	public void setOffsetX(Long offsetX) {
		this.offsetX = offsetX == null ? null : offsetX;
	}

	/**
	 * @return offsetY
	 */
	public Long getOffsetY() {
		return offsetY;
	}

	/**
	 * @param offsetY 要设置的 offsetY
	 */
	public void setOffsetY(Long offsetY) {
		this.offsetY = offsetY == null ? null : offsetY;
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
        OcrmFciNetworkRelaMember other = (OcrmFciNetworkRelaMember) that;
		return (this.getRelaMemberId() == null ? other.getRelaMemberId() == null : this.getRelaMemberId().equals(other.getRelaMemberId()))
        	&& (this.getNetworkRelaId() == null ? other.getNetworkRelaId() == null : this.getNetworkRelaId().equals(other.getNetworkRelaId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelaMemberId() == null) ? 0 : getRelaMemberId().hashCode());
        result = prime * result + ((getNetworkRelaId() == null) ? 0 : getNetworkRelaId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", relaMemberId=").append(relaMemberId);
		sb.append(", networkRelaId=").append(networkRelaId);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
        sb.append("]");
        return sb.toString();
    }
}