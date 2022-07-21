package cn.com.yusys.yscrm.mgr.sys.pdplan.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdColumn
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 18:13:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_PD_PROD_COLUMN")
public class OcrmFpdProdColumn extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 属性定义ID **/
	@Id
	@Column(name = "COLUMN_ID")
	@Generated(GenerationType.UUID)
	private String columnId;
	
	/** 表定义ID **/
	@Column(name = "TABLE_ID", unique = false, nullable = true, length = 40)
	private String tableId;
	
	/** 表名 **/
	@Column(name = "TABLE_NAME", unique = false, nullable = true, length = 40)
	private String tableName;
	
	/** 中文表名 **/
	@Column(name = "TABLE_CH_NAME", unique = false, nullable = true, length = 100)
	private String tableChName;
	
	/** 表别名 **/
	@Column(name = "TABLE_OTH_NAME", unique = false, nullable = true, length = 10)
	private String tableOthName;
	
	/** 字段 **/
	@Column(name = "COLUMN_NAME", unique = false, nullable = true, length = 40)
	private String columnName;
	
	/** 字段中文名 **/
	@Column(name = "COLUMN_OTH_NAME", unique = false, nullable = true, length = 100)
	private String columnOthName;
	
	/** 字段类型 **/
	@Column(name = "COLUMN_TYPE", unique = false, nullable = true, length = 10)
	private String columnType;
	
	/** 对齐方式 **/
	@Column(name = "ALIGN_TYPE", unique = false, nullable = true, length = 10)
	private String alignType;
	
	/** 引用字典 **/
	@Column(name = "DIC_NAME", unique = false, nullable = true, length = 40)
	private String dicName;
	
	/** 宽度 **/
	@Column(name = "SHOW_WIDTH", unique = false, nullable = true, length = 3)
	private short showWidth;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 20)
	private String updateUser;
	
	/** 最近更新时间 **/
	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	
	/**
	 * @param columnId
	 */
	public void setColumnId(String columnId) {
		this.columnId = columnId == null ? null : columnId.trim();
	}
	
    /**
     * @return ColumnId
     */	
	public String getColumnId() {
		return this.columnId;
	}
	
	/**
	 * @param tableId
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId == null ? null : tableId.trim();
	}
	
    /**
     * @return TableId
     */	
	public String getTableId() {
		return this.tableId;
	}
	
	/**
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}
	
    /**
     * @return TableName
     */	
	public String getTableName() {
		return this.tableName;
	}
	
	/**
	 * @param tableChName
	 */
	public void setTableChName(String tableChName) {
		this.tableChName = tableChName == null ? null : tableChName.trim();
	}
	
    /**
     * @return TableChName
     */	
	public String getTableChName() {
		return this.tableChName;
	}
	
	/**
	 * @param tableOthName
	 */
	public void setTableOthName(String tableOthName) {
		this.tableOthName = tableOthName == null ? null : tableOthName.trim();
	}
	
    /**
     * @return TableOthName
     */	
	public String getTableOthName() {
		return this.tableOthName;
	}
	
	/**
	 * @param columnName
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName == null ? null : columnName.trim();
	}
	
    /**
     * @return ColumnName
     */	
	public String getColumnName() {
		return this.columnName;
	}
	
	/**
	 * @param columnOthName
	 */
	public void setColumnOthName(String columnOthName) {
		this.columnOthName = columnOthName == null ? null : columnOthName.trim();
	}
	
    /**
     * @return ColumnOthName
     */	
	public String getColumnOthName() {
		return this.columnOthName;
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
	 * @param alignType
	 */
	public void setAlignType(String alignType) {
		this.alignType = alignType == null ? null : alignType.trim();
	}
	
    /**
     * @return AlignType
     */	
	public String getAlignType() {
		return this.alignType;
	}
	
	/**
	 * @param dicName
	 */
	public void setDicName(String dicName) {
		this.dicName = dicName == null ? null : dicName.trim();
	}
	
    /**
     * @return DicName
     */	
	public String getDicName() {
		return this.dicName;
	}
	
	/**
	 * @param showWidth
	 */
	public void setShowWidth(short showWidth) {
		this.showWidth = showWidth;
	}
	
    /**
     * @return ShowWidth
     */	
	public short getShowWidth() {
		return this.showWidth;
	}
	
	/**
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}
	
    /**
     * @return UpdateUser
     */	
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
    /**
     * @return UpdateDate
     */	
	public Date getUpdateDate() {
		return this.updateDate;
	}


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OcrmFpdProdColumn other = (OcrmFpdProdColumn) that;
		return (this.getColumnId() == null ? other.getColumnId() == null : this.getColumnId().equals(other.getColumnId()))
        	&& (this.getTableId() == null ? other.getTableId() == null : this.getTableId().equals(other.getTableId()))
        	&& (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
        	&& (this.getTableChName() == null ? other.getTableChName() == null : this.getTableChName().equals(other.getTableChName()))
        	&& (this.getTableOthName() == null ? other.getTableOthName() == null : this.getTableOthName().equals(other.getTableOthName()))
        	&& (this.getColumnName() == null ? other.getColumnName() == null : this.getColumnName().equals(other.getColumnName()))
        	&& (this.getColumnOthName() == null ? other.getColumnOthName() == null : this.getColumnOthName().equals(other.getColumnOthName()))
        	&& (this.getColumnType() == null ? other.getColumnType() == null : this.getColumnType().equals(other.getColumnType()))
        	&& (this.getAlignType() == null ? other.getAlignType() == null : this.getAlignType().equals(other.getAlignType()))
        	&& (this.getDicName() == null ? other.getDicName() == null : this.getDicName().equals(other.getDicName()))
                	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getColumnId() == null) ? 0 : getColumnId().hashCode());
        result = prime * result + ((getTableId() == null) ? 0 : getTableId().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getTableChName() == null) ? 0 : getTableChName().hashCode());
        result = prime * result + ((getTableOthName() == null) ? 0 : getTableOthName().hashCode());
        result = prime * result + ((getColumnName() == null) ? 0 : getColumnName().hashCode());
        result = prime * result + ((getColumnOthName() == null) ? 0 : getColumnOthName().hashCode());
        result = prime * result + ((getColumnType() == null) ? 0 : getColumnType().hashCode());
        result = prime * result + ((getAlignType() == null) ? 0 : getAlignType().hashCode());
        result = prime * result + ((getDicName() == null) ? 0 : getDicName().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", columnId=").append(columnId);
		sb.append(", tableId=").append(tableId);
		sb.append(", tableName=").append(tableName);
		sb.append(", tableChName=").append(tableChName);
		sb.append(", tableOthName=").append(tableOthName);
		sb.append(", columnName=").append(columnName);
		sb.append(", columnOthName=").append(columnOthName);
		sb.append(", columnType=").append(columnType);
		sb.append(", alignType=").append(alignType);
		sb.append(", dicName=").append(dicName);
		sb.append(", showWidth=").append(showWidth);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}