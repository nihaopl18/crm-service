package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFetlDate
 * @类描述: PMA_F_SM_ETL_LOG数据加工日志表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-09-21 16:49:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SM_ETL_LOG")
public class PmaFSmEtlLog extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 
	 * 统计日期
	 **/
	@Column(name = "ETL_DATE")
	private String etlDate;
	
	/** 
	 * 存储过程名称
	 **/
	@Column(name = "SP_NAME")
	private String spName;
	
	/** 
	 *操作顺序
	 **/
	@Column(name = "STEP")
	private String step;
	
	/** 
	 * 操作内容信息
	 **/
	@Column(name = "STEP_MSG")
	private String stepMsg;
	
	/** 
	 * 操作返回码
	 **/
	@Column(name = "SQL_CODE")
	private String sqlCode;
	
	/** 
	 * 返回信息
	 **/
	@Column(name = "SQL_MSG")
	private String sqlMsg;
	
	/** 
	 * 开始时间
	 **/
	@Column(name = "START_TIME")
	private String startTime;
	
	/** 
	 * 结束时间
	 **/
	@Column(name = "END_TIME")
	private String endTime;
	
	/** 
	 * 操作记录条数
	 **/
	@Column(name = "LIST_NUM")
	private String listNum;
	
	/** 
	 * 操作耗时
	 **/
	@Column(name = "COST_TIME")
	private String costTime;

	
	public String getCostTime() {
		return this.costTime;
	}

	public void setCostTime(String costTime) {
		this.costTime = costTime == null ? null : costTime.trim();
	}

	public String getEtlDate() {
		return this.etlDate;
	}

	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate == null ? null : etlDate.trim();
	}

	public String getSpName() {
		return this.spName;
	}

	public void setSpName(String spName) {
		this.spName = spName == null ? null : spName.trim();
	}

	public String getStep() {
		return this.step;
	}

	public void setStep(String step) {
		this.step = step == null ? null : step.trim();
	}

	public String getStepMsg() {
		return this.stepMsg;
	}

	public void setStepMsg(String stepMsg) {
		this.stepMsg = stepMsg == null ? null : stepMsg.trim();
	}

	public String getSqlCode() {
		return this.sqlCode;
	}

	public void setSqlCode(String sqlCode) {
		this.sqlCode = sqlCode == null ? null : sqlCode.trim();
	}

	public String getSqlMsg() {
		return this.sqlMsg;
	}

	public void setSqlMsg(String sqlMsg) {
		this.sqlMsg = sqlMsg == null ? null : sqlMsg.trim();
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime == null ? null : startTime.trim();
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime == null ? null : endTime.trim();
	}

	public String getListNum() {
		return this.listNum;
	}

	public void setListNum(String listNum) {
		this.listNum = listNum == null ? null : listNum.trim();
	}
}