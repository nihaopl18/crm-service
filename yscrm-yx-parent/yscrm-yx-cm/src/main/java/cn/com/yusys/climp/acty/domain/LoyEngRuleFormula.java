package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Entity;
import java.io.Serializable;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
public class LoyEngRuleFormula extends BaseDomain implements Serializable{
	
	/**
	* @属性名称:serialVersionUID
	* @属性描述:
	* @since 1.0.0
	*/
	private static final long serialVersionUID = -4442352860552114644L;
	private String formulaWay;
//	private String maxScore;
	private String perdayScore;
	private String perMonthScore;
	private String formulaValue;
	private String formulaField;
	private String scoreType;
	
	private String accountNo;
	private String poolNo;
	private String modelId;
	private String validDate;
	private String ceiling;
	private String ceilingType;
	private String actionType;
	
	
	public String getFormulaWay() {
		return formulaWay;
	}
	public void setFormulaWay(String formulaWay) {
		this.formulaWay = formulaWay;
	}
//	public String getMaxScore() {
//		return maxScore;
//	}
//	public void setMaxScore(String maxScore) {
//		this.maxScore = maxScore;
//	}
	public String getPerdayScore() {
		return perdayScore;
	}
	public void setPerdayScore(String perdayScore) {
		this.perdayScore = perdayScore;
	}
	public String getPerMonthScore() {
		return perMonthScore;
	}
	public void setPerMonthScore(String perMonthScore) {
		this.perMonthScore = perMonthScore;
	}
	public String getFormulaValue() {
		return formulaValue;
	}
	public void setFormulaValue(String formulaValue) {
		this.formulaValue = formulaValue;
	}
	public String getFormulaField() {
		return formulaField;
	}
	public void setFormulaField(String formulaField) {
		this.formulaField = formulaField;
	}
	public String getScoreType() {
		return scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPoolNo() {
		return poolNo;
	}
	public void setPoolNo(String poolNo) {
		this.poolNo = poolNo;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getCeiling() {
		return ceiling;
	}
	public void setCeiling(String ceiling) {
		this.ceiling = ceiling;
	}
	public String getCeilingType() {
		return ceilingType;
	}
	public void setCeilingType(String ceilingType) {
		this.ceilingType = ceilingType;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	
}