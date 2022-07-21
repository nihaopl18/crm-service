package cn.com.yusys.yscrm.sysview.domain;


import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "CIM_F_MM_TAG_AUTH")
public class CimFMmTagAuthInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "AUTH_TYPE")
	private String authType;
	
	@Column(name = "AUTH_NAME")
	private String authName;
	
	@Column(name = "AUTH_OBJ")
	private String authObj;
	
	@Column(name = "OPERATE_TYPE")
	private String operateType;
	
	@Column(name = "AVAILABLE_DATE")
	private Date availableDate;
	
	@Column(name = "DISABLE_DATE")
	private Date disableDate;
	
	@Column(name = "AUTH_USER")
	private String authUser;
	
	@Column(name = "AUTH_DATE")
	private Date authDate;
	
	@Column(name = "TAG_NO")
	private String tagNo;

	@Transient 
	private String authNames;
	
	@Transient 
	private long[] ids;
	
	//********************************************************
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAuthType() {
		return authType;
	}
	
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
	public String getAuthObj() {
		return authObj;
	}
	
	public void setAuthObj(String authObj) {
		this.authObj = authObj;
	}
	
	public String getOperateType() {
		return operateType;
	}
	
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	public Date getAvailableDate() {
		return availableDate;
	}
	
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	
	public Date getDisableDate() {
		return disableDate;
	}
	
	public void setDisableDate(Date disableDate) {
		this.disableDate = disableDate;
	}
	
	public String getAuthUser() {
		return authUser;
	}
	
	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}
	
	public Date getAuthDate() {
		return authDate;
	}
	
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}
	
	public String getTagNo() {
		return tagNo;
	}
	
	public void setTagNo(String tagNo) {
		this.tagNo = tagNo;
	}
	
	public String getAuthName() {
		return authName;
	}
	
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	public String getAuthNames() {
		return authNames;
	}
	
	public void setAuthNames(String authNames) {
		this.authNames = authNames;
	}
	
	public long[] getIds() {
		return ids;
	}
	
	public void setIds(long[] ids) {
		this.ids = ids;
	}
}
