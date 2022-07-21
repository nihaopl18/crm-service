package cn.com.yusys.climp.cust.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * 
 * @项目名称：yusp-climp-cust-core
 * @类名称：LoyCmCustInfo
 * @类描述：
 * @功能描述:客户信息实体
 * @创建人：hujun3@yusys.com.cn
 * @创建时间：2018年12月28日
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 2.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Entity
@Table(name="loy_cm_cust_info")
public class LoyCmCustInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	
	@Column(name="CUST_ID" , unique = true, nullable = false, length = 32)
	private String custId;

	@Column(name="CUST_TYPE" , unique = true, nullable = false, length = 10)
	private String custType;

	@Column(name="IDENT_TYPE" , unique = false, nullable = false, length = 10)
	private String identType;

	@Column(name="IDENT_NO" , unique = true, nullable = false, length = 40)
	private String identNo;

	@Column(name="CUST_NAME" , unique = true, nullable = false, length = 100)
	private String custName;

	@Column(name="LINKMAN_NAME", unique = false, nullable = true, length = 50)
	private String linkmanName;

	@Column(name="LINKMAN_TEL", unique = false, nullable = true, length = 20)
	private String linkmanTel;

	@Column(name="LAST_UPDATE_SYS" , unique = false, nullable = true, length = 30)
	private String lastUpdateSys;

	@Column(name="LAST_UPDATE_USER" , unique = false, nullable = true, length = 100)
	private String lastUpdateUser;

	@Column(name="LAST_UPDATE_TM" , unique = false, nullable = true, length = 20)
	private String lastUpdateTm;

	@Column(name="BIRTH_DATE"  , unique = false, nullable = true, length = 20)
	private String birthDate;

	@Column(name="PROFESS_TYPE"  , unique = false, nullable = true, length = 10)
	private String professType;

	@Column(name="POST_INFO" , unique = false, nullable = true, length = 20)
	private String postInfo;

	@Column(name="WORK_UNIT" , unique = false, nullable = true, length = 200)
	private String workUnit;

	@Column(name="POST_CODE" , unique = false, nullable = true, length = 10)
	private String postCode;

	@Column(name="HANDPHONE" , unique = false, nullable = true, length = 20)
	private String handphone;

	@Column(name="ADDRESS_INFO" , unique = false, nullable = true, length = 200)
	private String addressInfo;

	@Column(name="FAX_CODE" , unique = false, nullable = true, length = 20)
	private String faxCode;

	@Column(name="EMAIL" , unique = false, nullable = true, length = 30)
	private String email;

	@Column(name="SEX" , unique = false, nullable = true, length = 10)
	private String sex;




	public LoyCmCustInfo() {
	}




	public String getCustId() {
		return custId;
	}




	public void setCustId(String custId) {
		this.custId = custId;
	}




	public String getCustType() {
		return custType;
	}




	public void setCustType(String custType) {
		this.custType = custType;
	}




	public String getIdentType() {
		return identType;
	}




	public void setIdentType(String identType) {
		this.identType = identType;
	}




	public String getIdentNo() {
		return identNo;
	}




	public void setIdentNo(String identNo) {
		this.identNo = identNo;
	}




	public String getCustName() {
		return custName;
	}




	public void setCustName(String custName) {
		this.custName = custName;
	}




	public String getLinkmanName() {
		return linkmanName;
	}




	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}




	public String getLinkmanTel() {
		return linkmanTel;
	}




	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}




	public String getLastUpdateSys() {
		return lastUpdateSys;
	}




	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys;
	}




	public String getLastUpdateUser() {
		return lastUpdateUser;
	}




	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}




	public String getLastUpdateTm() {
		return lastUpdateTm;
	}




	public void setLastUpdateTm(String lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}




	public String getBirthDate() {
		return birthDate;
	}




	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}




	public String getProfessType() {
		return professType;
	}




	public void setProfessType(String professType) {
		this.professType = professType;
	}




	public String getPostInfo() {
		return postInfo;
	}




	public void setPostInfo(String postInfo) {
		this.postInfo = postInfo;
	}




	public String getWorkUnit() {
		return workUnit;
	}




	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}




	public String getPostCode() {
		return postCode;
	}




	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}




	public String getHandphone() {
		return handphone;
	}




	public void setHandphone(String handphone) {
		this.handphone = handphone;
	}




	public String getAddressInfo() {
		return addressInfo;
	}




	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}




	public String getFaxCode() {
		return faxCode;
	}




	public void setFaxCode(String faxCode) {
		this.faxCode = faxCode;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getSex() {
		return sex;
	}




	public void setSex(String sex) {
		this.sex = sex;
	}

	
}