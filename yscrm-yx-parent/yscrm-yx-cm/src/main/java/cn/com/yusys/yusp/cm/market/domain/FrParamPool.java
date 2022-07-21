package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FR_RULE_PARAM_POOL")
public class FrParamPool extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PARAM_ID")
	private String paramId;

	@Column(name = "PARAM_NAME")
	private String paramName;

	@Column(name = "PARAM_TYPE")
	private String paramType;

	@Column(name = "FIELD_TYPE")
	private String fieldType;

	@Column(name = "PARAM_ENUM")
	private String paramEnum;

	@Column(name = "FILED_LENGTH")
	private String filedLength;

	@Column(name = "BAK")
	private String bak;

	@Column(name = "OP_TIME")
	private String opTime;

	@Column(name = "LOGIN_NO")
	private String loginNo;

	@Column(name = "OP_ORG")
	private String opOrg;

	@Column(name = "PARAM_DESC")
	private String paramDesc;

	@Column(name = "DEFAULT_VALUE")
	private String defaultValue;

	@Column(name = "PUB_FLAG")
	private String pubFlag;
	
	public String getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(String pubFlag) {
		this.pubFlag = pubFlag;
	}

	
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getParamDesc() {
		return paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}


	public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getOpOrg() {
		return opOrg;
	}

	public void setOpOrg(String opOrg) {
		this.opOrg = opOrg;
	}

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getParamEnum() {
		return paramEnum;
	}

	public void setParamEnum(String paramEnum) {
		this.paramEnum = paramEnum;
	}

	public String getFiledLength() {
		return filedLength;
	}

	public void setFiledLength(String filedLength) {
		this.filedLength = filedLength;
	}

	public String getBak() {
		return bak;
	}

	public void setBak(String bak) {
		this.bak = bak;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
