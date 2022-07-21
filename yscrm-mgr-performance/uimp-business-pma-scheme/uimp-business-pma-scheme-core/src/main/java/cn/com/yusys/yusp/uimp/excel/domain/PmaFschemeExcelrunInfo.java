package cn.com.yusys.yusp.uimp.excel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelrunInfo
 * @类描述: PMA_F_SCHEME_EXCELRUN_INFO考核方案报表运行信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-25 14:49:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELRUN_INFO")
public class PmaFschemeExcelrunInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = false, length = 50)
	private String schemeId;
	
	/** 数据日期 **/
	@Column(name = "ETL_DATE", unique = false, nullable = false, length = 8)
	private String etlDate;
	
	/** 运行开始时间 **/
	@Column(name = "RUN_START_TIME", unique = false, nullable = true, length = 7)
	private Date runStartTime;
	
	/** 运行结束时间 **/
	@Column(name = "RUN_END_TIME", unique = false, nullable = true, length = 7)
	private Date runEndTime;
	
	/** 运行状态 **/
	@Column(name = "RUN_STATUS", unique = false, nullable = true, length = 2)
	private String runStatus;
	
	/** 发布状态 **/
	@Column(name = "PUB_STATUS", unique = false, nullable = true, length = 2)
	private String pubStatus;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
	private String createUser;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	private Date createTime;
	
	/** 错误信息 **/
	@Column(name = "ERR_MSG", unique = false, nullable = true, length = 100)
	private String errMsg;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param schemeId
	 */
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId == null ? null : schemeId.trim();
	}
	
    /**
     * @return SchemeId
     */	
	public String getSchemeId() {
		return this.schemeId;
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
	 * @param runStartTime
	 */
	public void setRunStartTime(Date runStartTime) {
		this.runStartTime = runStartTime;
	}
	
    /**
     * @return RunStartTime
     */	
	public Date getRunStartTime() {
		return this.runStartTime;
	}
	
	/**
	 * @param runEndTime
	 */
	public void setRunEndTime(Date runEndTime) {
		this.runEndTime = runEndTime;
	}
	
    /**
     * @return RunEndTime
     */	
	public Date getRunEndTime() {
		return this.runEndTime;
	}
	
	/**
	 * @param runStatus
	 */
	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus == null ? null : runStatus.trim();
	}
	
    /**
     * @return RunStatus
     */	
	public String getRunStatus() {
		return this.runStatus;
	}
	
	/**
	 * @param pubStatus
	 */
	public void setPubStatus(String pubStatus) {
		this.pubStatus = pubStatus == null ? null : pubStatus.trim();
	}
	
    /**
     * @return PubStatus
     */	
	public String getPubStatus() {
		return this.pubStatus;
	}
	
	/**
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
	}
	
	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
    /**
     * @return CreateTime
     */	
	public Date getCreateTime() {
		return this.createTime;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}