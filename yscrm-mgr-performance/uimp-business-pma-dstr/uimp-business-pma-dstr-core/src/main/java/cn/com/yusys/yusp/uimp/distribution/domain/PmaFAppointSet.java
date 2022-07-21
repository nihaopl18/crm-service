package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFAppointSet
 * @类描述: PMA_F_APPOINT_SET数据实体类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-29 13:44:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_APPOINT_SET")
public class PmaFAppointSet extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 业务类型 **/
	@Column(name = "BUS_TYPE", unique = false, nullable = true, length = 2)
	private String busType;
	
	/** 字段英文名称 **/
	@Column(name = "FIELD_EN_NAME", unique = false, nullable = true, length = 100)
	private String fieldEnName;
	
	/** 字段中文名称 **/
	@Column(name = "FIELD_CN_NAME", unique = false, nullable = true, length = 200)
	private String fieldCnName;
	
	/** 字段是否展示 **/
	@Column(name = "IF_SHOW", unique = false, nullable = true, length = 2)
	private String ifShow;
	
	/** 展示顺序 **/
	@Column(name = "SHOW_SORT", unique = false, nullable = true, length = 10)
	private Integer showSort;
	
	/** 字段类型 **/
	@Column(name = "COLUMN_TYPE", unique = false, nullable = true, length = 10)
	private String columnType;
	
	/** 字段是否必输 **/
	@Column(name = "ALLOW_BLANK", unique = false, nullable = true, length = 2)
	private String allowBlank;
	
	/** 数据字典 **/
	@Column(name = "IF_LOOK_UP", unique = false, nullable = true, length = 200)
	private String ifLookUp;
	
	/** 日期结束范围 **/
	@Column(name = "END_RANK", unique = false, nullable = true, length = 10)
	private String endRank;
	
	/** 金额上下浮动范围 **/
	@Column(name = "AMT_RANK", unique = false, nullable = true, length = 10)
	private String amtRank;
	
	/** 金额上下浮动范围 **/
	@Column(name = "AMT_RANK_TYPE", unique = false, nullable = true, length = 10)
	private String amtRankType;
	
	public String getAmtRankType() {
		return amtRankType;
	}

	public void setAmtRankType(String amtRankType) {
		this.amtRankType = amtRankType;
	}

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
	 * @param busType
	 */
	public void setBusType(String busType) {
		this.busType = busType == null ? null : busType.trim();
	}
	
    /**
     * @return BusType
     */	
	public String getBusType() {
		return this.busType;
	}
	
	/**
	 * @param fieldEnName
	 */
	public void setFieldEnName(String fieldEnName) {
		this.fieldEnName = fieldEnName == null ? null : fieldEnName.trim();
	}
	
    /**
     * @return FieldEnName
     */	
	public String getFieldEnName() {
		return this.fieldEnName;
	}
	
	/**
	 * @param fieldCnName
	 */
	public void setFieldCnName(String fieldCnName) {
		this.fieldCnName = fieldCnName == null ? null : fieldCnName.trim();
	}
	
    /**
     * @return FieldCnName
     */	
	public String getFieldCnName() {
		return this.fieldCnName;
	}
	
	/**
	 * @param ifShow
	 */
	public void setIfShow(String ifShow) {
		this.ifShow = ifShow == null ? null : ifShow.trim();
	}
	
    /**
     * @return IfShow
     */	
	public String getIfShow() {
		return this.ifShow;
	}
	
	public Integer getShowSort() {
		return showSort;
	}

	public void setShowSort(Integer showSort) {
		this.showSort = showSort;
	}

	/**
	 * @param columnType
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType == null ? null : columnType.trim();
	}
	
    /**
     * @return ColumnType
     */	
	public String getColumnType() {
		return this.columnType;
	}
	
	/**
	 * @param allowBlank
	 */
	public void setAllowBlank(String allowBlank) {
		this.allowBlank = allowBlank == null ? null : allowBlank.trim();
	}
	
    /**
     * @return AllowBlank
     */	
	public String getAllowBlank() {
		return this.allowBlank;
	}
	
	/**
	 * @param ifLookUp
	 */
	public void setIfLookUp(String ifLookUp) {
		this.ifLookUp = ifLookUp == null ? null : ifLookUp.trim();
	}
	
    /**
     * @return IfLookUp
     */	
	public String getIfLookUp() {
		return this.ifLookUp;
	}
	
	/**
	 * @param endRank
	 */
	public void setEndRank(String endRank) {
		this.endRank = endRank == null ? null : endRank.trim();
	}
	
    /**
     * @return EndRank
     */	
	public String getEndRank() {
		return this.endRank;
	}
	
	/**
	 * @param amtRank
	 */
	public void setAmtRank(String amtRank) {
		this.amtRank = amtRank == null ? null : amtRank.trim();
	}
	
    /**
     * @return AmtRank
     */	
	public String getAmtRank() {
		return this.amtRank;
	}


}