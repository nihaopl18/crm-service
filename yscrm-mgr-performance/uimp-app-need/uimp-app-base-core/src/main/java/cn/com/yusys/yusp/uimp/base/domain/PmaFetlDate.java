package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFetlDate
 * @类描述: PMA_F_ETL_DATE数据日期表 数据实体类
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
@Table(name = "PMA_F_ETL_DATE")
public class PmaFetlDate extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 
	 * PMA为日常跑批时间PMA_FTP为FTP跑批时间
	 **/
	@Column(name = "ETL_TYPE")
	private String etlType;
	
	/** 
	 * ETL时间
	 **/
	@Column(name = "ETL_DATE")
	private String etlDate;
	
	/** 
	 * 1跑批完成0跑批未完成
	 **/
	@Column(name = "ETL_STATE", unique = false, nullable = true, length = 2)
	private String etlState;
	
	
	/**
	 * @param etlType
	 */
	public void setEtlType(String etlType) {
		this.etlType = etlType == null ? null : etlType.trim();
	}
	
    /**
     * @return EtlType
     */	
	public String getEtlType() {
		return this.etlType;
	}
	
	/**
	 * @param etlDate
	 */
	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate == null ? null : etlDate.trim();
	}
	
    /**
     * @return EtlDate
     */	
	public String getEtlDate() {
		return this.etlDate;
	}
	
	/**
	 * @param etlState
	 */
	public void setEtlState(String etlState) {
		this.etlState = etlState == null ? null : etlState.trim();
	}
	
    /**
     * @return EtlState
     */	
	public String getEtlState() {
		return this.etlState;
	}


}