package cn.com.yusys.yscrm.custflexEs.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustFoucsInfo
 * @类描述: CRM_CUST_FOUCS_INFO数据实体类
 * @功能描述: 
 * @创建人: sawyerwei
 * @创建时间: 2020-12-07 12:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "CRM_CUST_FOUCS_INFO")
public class CrmCustFoucsInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** id **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 客户号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 关注标志(1-关注 0-不关注) **/
	@Column(name = "IS_FOUCS", unique = false, nullable = true, length = 10)
	private String isFoucs;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
	private String createUser;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
	private String createOrg;
	
	/** 创建时间 **/
	@Column(name = "CREATE_DT", unique = false, nullable = true, length = 7)
	private Date createDt;
	
	
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
	 * @param isFoucs
	 */
	public void setIsFoucs(String isFoucs) {
		this.isFoucs = isFoucs == null ? null : isFoucs.trim();
	}
	
    /**
     * @return IsFoucs
     */	
	public String getIsFoucs() {
		return this.isFoucs;
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
	 * @param createDt
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
    /**
     * @return CreateDt
     */	
	public Date getCreateDt() {
		return this.createDt;
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


}