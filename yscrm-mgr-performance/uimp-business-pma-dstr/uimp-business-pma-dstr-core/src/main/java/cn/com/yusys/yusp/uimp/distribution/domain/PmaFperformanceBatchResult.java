package cn.com.yusys.yusp.uimp.distribution.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceBatchResult
 * @类描述: PMA_F_PERFORMANCE_BATCH_RESULT业绩批量导入线程池生成工作流结果表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-15 09:27:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_PERFORMANCE_BATCH_RESULT")
public class PmaFperformanceBatchResult extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 批次编号 **/
	@Column(name = "BATCH_ID", unique = false, nullable = false, length = 100)
	private String batchId;
	
	/** 默认1表示工作流生成成功数 **/
	@Column(name = "WF_SUCC_NUM", unique = false, nullable = false, length = 10)
	private Integer wfSuccNum;
	
	/** 默认1表示工作流生成失败数 **/
	@Column(name = "WF_ERR_NUM", unique = false, nullable = false, length = 10)
	private Integer wfErrNum;
	
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
	 * @param batchId
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId == null ? null : batchId.trim();
	}
	
    /**
     * @return BatchId
     */	
	public String getBatchId() {
		return this.batchId;
	}
	
	/**
	 * @param wfSuccNum
	 */
	public void setWfSuccNum(Integer wfSuccNum) {
		this.wfSuccNum = wfSuccNum;
	}
	
    /**
     * @return WfSuccNum
     */	
	public Integer getWfSuccNum() {
		return this.wfSuccNum;
	}

	/**
	 * @param wfErrNum
	 */
	public void setWfErrNum(Integer wfErrNum) {
		this.wfErrNum = wfErrNum;
	}
	
    /**
     * @return wfErrNum
     */	
	public Integer getWfErrNum() {
		return this.wfErrNum;
	}

}