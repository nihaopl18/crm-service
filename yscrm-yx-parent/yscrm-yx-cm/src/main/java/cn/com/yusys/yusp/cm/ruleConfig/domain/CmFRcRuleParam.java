package cn.com.yusys.yusp.cm.ruleConfig.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CM_F_RC_RULE_PARAM")
public class CmFRcRuleParam extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

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
	
	private String magnifier;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	
}
