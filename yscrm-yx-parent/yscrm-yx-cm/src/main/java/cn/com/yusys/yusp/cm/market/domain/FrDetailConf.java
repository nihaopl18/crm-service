package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FR_ENG_DETAIL_CONF database table.
 * 
 */
@Entity
@Table(name="FR_ENG_DETAIL_CONF")
@NamedQuery(name="FrDetailConf.findAll", query="SELECT f FROM FrDetailConf f")
public class FrDetailConf extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUB_ID")
	private String subId;

	@Column(name="PARAM_ID")
	private String paramId;

	@Column(name="LOGIN_NO")
	private String loginNo;

	@Column(name="OP_ORG")
	private String opOrg;

	@Temporal(TemporalType.DATE)
	@Column(name="OP_TIME")
	private Date opTime;

	@Column(name="PARAM_NAME")
	private String paramName;

	@Column(name="SHOW_ORDER")
	private BigDecimal showOrder;

	private String visible;

	@Column(name="ORG_ID")
	private String orgId;
	
	@Column(name="TARGET_TAB")
	private String targetTab;
	
	@Column(name="TARGET_FIELD")
	private String targetField;
	
	@Column(name="TARGET_FIELD_NAME")
	private String targetFieldName;
	
	@Column(name="FIELD_WIDTH")
	private String fieldWidth;
	
	
	public FrDetailConf() {
	}


	
	public String getFieldWidth() {
		return fieldWidth;
	}



	public void setFieldWidth(String fieldWidth) {
		this.fieldWidth = fieldWidth;
	}



	public String getTargetTab() {
		return targetTab;
	}



	public void setTargetTab(String targetTab) {
		this.targetTab = targetTab;
	}



	public String getTargetField() {
		return targetField;
	}



	public void setTargetField(String targetField) {
		this.targetField = targetField;
	}



	public String getTargetFieldName() {
		return targetFieldName;
	}



	public void setTargetFieldName(String targetFieldName) {
		this.targetFieldName = targetFieldName;
	}



	public String getOrgId() {
		return orgId;
	}



	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}



	public String getSubId() {
		return subId;
	}



	public void setSubId(String subId) {
		this.subId = subId;
	}



	public String getParamId() {
		return paramId;
	}


	public void setParamId(String paramId) {
		this.paramId = paramId;
	}


	public String getLoginNo() {
		return this.loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getOpOrg() {
		return this.opOrg;
	}

	public void setOpOrg(String opOrg) {
		this.opOrg = opOrg;
	}

	public Date getOpTime() {
		return this.opTime;
	}

	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public BigDecimal getShowOrder() {
		return this.showOrder;
	}

	public void setShowOrder(BigDecimal showOrder) {
		this.showOrder = showOrder;
	}

	public String getVisible() {
		return this.visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

}