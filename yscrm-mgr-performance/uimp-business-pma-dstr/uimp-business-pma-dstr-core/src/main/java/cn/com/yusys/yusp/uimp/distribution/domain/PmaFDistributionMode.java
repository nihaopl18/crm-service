package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDistributionMode
 * @类描述: PMA_F_DISTRIBUTION_MODE数据实体类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-23 10:35:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_DISTRIBUTION_MODE")
public class PmaFDistributionMode extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 机构号 **/
	@Column(name = "BRCH_NO", unique = false, nullable = true, length = 50)
	private String brchNo;
	
	/** 机构名称 **/
	@Column(name = "BRCH_NA", unique = false, nullable = true, length = 100)
	private String brchNa;
	
	/** 生效日期 **/
	@Column(name = "EFFECT_DATE", unique = false, nullable = true, length = 8)
	private String effectDate;
	
	/** 失效日期 **/
	@Column(name = "EXPIRATE_DATE", unique = false, nullable = true, length = 8)
	private String expirateDate;
	
	/** 创建人编号 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 20)
	private String createUser;
	
	/** 创建人名称 **/
	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, length = 50)
	private String createUserName;
	
	/** 创建人时间 **/
	@Column(name = "CREATE_DT", unique = false, nullable = true, length = 10)
	private String createDt;
	
	
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
	 * @param brchNo
	 */
	public void setBrchNo(String brchNo) {
		this.brchNo = brchNo == null ? null : brchNo.trim();
	}
	
    /**
     * @return BrchNo
     */	
	public String getBrchNo() {
		return this.brchNo;
	}
	
	/**
	 * @param brchNa
	 */
	public void setBrchNa(String brchNa) {
		this.brchNa = brchNa == null ? null : brchNa.trim();
	}
	
    /**
     * @return BrchNa
     */	
	public String getBrchNa() {
		return this.brchNa;
	}
	
	/**
	 * @param effectDate
	 */
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate == null ? null : effectDate.trim();
	}
	
    /**
     * @return EffectDate
     */	
	public String getEffectDate() {
		return this.effectDate;
	}
	
	/**
	 * @param expirateDate
	 */
	public void setExpirateDate(String expirateDate) {
		this.expirateDate = expirateDate == null ? null : expirateDate.trim();
	}
	
    /**
     * @return ExpirateDate
     */	
	public String getExpirateDate() {
		return this.expirateDate;
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
	 * @param createUserName
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}
	
    /**
     * @return CreateUserName
     */	
	public String getCreateUserName() {
		return this.createUserName;
	}
	
	/**
	 * @param createDt
	 */
	public void setCreateDt(String createDt) {
		this.createDt = createDt == null ? null : createDt.trim();
	}
	
    /**
     * @return CreateDt
     */	
	public String getCreateDt() {
		return this.createDt;
	}


}