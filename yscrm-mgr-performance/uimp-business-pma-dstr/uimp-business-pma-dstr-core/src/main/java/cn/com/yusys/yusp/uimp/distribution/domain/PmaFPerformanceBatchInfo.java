package cn.com.yusys.yusp.uimp.distribution.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFPerformanceBatchInfo
 * @类描述: PMA_F_PERFORMANCE_BATCH_INFO 业绩批量导入业务主表实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-15 10:46:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFPerformanceBatchInfo", description = "业绩批量导入业务主表")
@Entity
@Table(name = "PMA_F_PERFORMANCE_BATCH_INFO")
public class PmaFPerformanceBatchInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** BATCH_ID **/
	@Id
	@Generated(GenerationType.UUID)
	@ApiModelProperty(value = "批次编号", name = "BATCH_ID", required = false)
	@Column(name = "BATCH_ID")
	private String batchId;
	
	/** 业绩类型 **/
	@Column(name = "FUN_CODE", unique = false, nullable = false, length = 100)
	@ApiModelProperty(value = "业绩类型", name = "funCode", required = false)
	private String funCode;
	
	/** 状态 **/
	@Column(name = "STATUS", unique = false, nullable = false, length = 10)
	@ApiModelProperty(value = "状态", name = "status", required = false)
	private String status;
	
	/** 校验结果 **/
	@Column(name = "CHECK_RESULT", unique = false, nullable = false, length = 1000)
	@ApiModelProperty(value = "校验结果", name = "checkResult", required = false)
	private String checkResult;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date createTime;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = false, length = 100)
	@ApiModelProperty(value = "创建人", name = "createUser", required = false)
	private String createUser;
	
	/** 工作流总数 **/
	@Column(name = "WF_TOTAL_COUNT", unique = false, nullable = false, length = 10)
	@ApiModelProperty(value = "工作流总数", name = "wfTotalCount", required = false)
	private Integer wfTotalCount;
	
	/** 工作流发起成功数 **/
	@Column(name = "WF_SUCC_COUNT", unique = false, nullable = false, length = 10)
	@ApiModelProperty(value = "工作流发起成功数", name = "wfSuccCount", required = false)
	private Integer wfSuccCount;
	
	/** 工作流发起失败数 **/
	@Column(name = "WF_ERR_COUNT", unique = false, nullable = false, length = 10)
	@ApiModelProperty(value = "工作流发起失败数", name = "wfErrCount", required = false)
	private Integer wfErrCount;

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getWfTotalCount() {
		return wfTotalCount;
	}

	public void setWfTotalCount(Integer wfTotalCount) {
		this.wfTotalCount = wfTotalCount;
	}

	public Integer getWfSuccCount() {
		return wfSuccCount;
	}

	public void setWfSuccCount(Integer wfSuccCount) {
		this.wfSuccCount = wfSuccCount;
	}

	public Integer getWfErrCount() {
		return wfErrCount;
	}

	public void setWfErrCount(Integer wfErrCount) {
		this.wfErrCount = wfErrCount;
	}

}