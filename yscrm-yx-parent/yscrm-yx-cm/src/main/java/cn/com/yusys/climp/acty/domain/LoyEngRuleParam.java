package cn.com.yusys.climp.acty.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
/**
 * 
 * @项目名称：yusp-climp-acty-core
 * @类名称：LoyEngRuleParam
 * @类描述：引用参数实体
 * @功能描述:
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2018-12-28 10:28
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_RULE_PARAM")
public class LoyEngRuleParam extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="PARAM_CODE")
	private String paramCode;

	@Column(name="PARAM_LAYOUT")
	private String paramLayout;

	@Column(name="PARAM_MAPPING")
	private String paramMapping;

	@Column(name="PARAM_NAME")
	private String paramName;

	@Column(name="PARAM_PROPERTY")
	private String paramProperty;

	@Column(name="PARAM_TYPE")
	private String paramType;
	
	@Column(name="STATEMENT")
	private String statement;
	
	@Column(name="STATEMENT_NAME")
	private String statementName;
	
	@Column(name="FORMULA")
	private String formula;
	
	@Column(name="MAGNIFIER")
	private String magnifier;
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "CREATE_ORG")
	private String createOrg;
	
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Column(name = "UPDATE_ORG")
	private String updateOrg;

	public LoyEngRuleParam() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamLayout() {
		return paramLayout;
	}

	public void setParamLayout(String paramLayout) {
		this.paramLayout = paramLayout;
	}

	public String getParamMapping() {
		return paramMapping;
	}

	public void setParamMapping(String paramMapping) {
		this.paramMapping = paramMapping;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamProperty() {
		return paramProperty;
	}

	public void setParamProperty(String paramProperty) {
		this.paramProperty = paramProperty;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getStatementName() {
		return statementName;
	}

	public void setStatementName(String statementName) {
		this.statementName = statementName;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getMagnifier() {
		return magnifier;
	}

	public void setMagnifier(String magnifier) {
		this.magnifier = magnifier;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}

	public String getUpdateOrg() {
		return this.updateOrg;
	}
	
	
}
