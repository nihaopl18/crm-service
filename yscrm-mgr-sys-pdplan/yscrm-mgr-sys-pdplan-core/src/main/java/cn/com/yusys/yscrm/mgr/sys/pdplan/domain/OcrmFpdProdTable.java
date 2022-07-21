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
 * @类名称: OcrmFpdProdTable
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 18:12:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_PD_PROD_TABLE")
public class OcrmFpdProdTable extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 表定义ID **/
	@Id
	@Column(name = "TABLE_ID")
	@Generated(GenerationType.UUID)
	private String tableId;
	
	/** 表名 **/
	@Column(name = "TABLE_NAME", unique = false, nullable = true, length = 40)
	private String tableName;
	
	/** 中文表名 **/
	@Column(name = "TABLE_CH_NAME", unique = false, nullable = true, length = 100)
	private String tableChName;
	
	/** 类型 **/
	@Column(name = "TABLE_TYPE", unique = false, nullable = true, length = 10)
	private String tableType;
	
	/** 表别名 **/
	@Column(name = "TABLE_OTH_NAME", unique = false, nullable = true, length = 10)
	private String tableOthName;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 20)
	private String createUser;
	
	/** 创建日期 **/
	@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构ID **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 20)
	private String createOrg;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 20)
	private String updateUser;
	
	/** 最近更新时间 **/
	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	
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
	 * @param tableType
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType == null ? null : tableType.trim();
	}
	
    /**
     * @return TableType
     */	
	public String getTableType() {
		return this.tableType;
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
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * @return CreateDate
     */	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
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
        OcrmFpdProdTable other = (OcrmFpdProdTable) that;
		return (this.getTableId() == null ? other.getTableId() == null : this.getTableId().equals(other.getTableId()))
        	&& (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
        	&& (this.getTableChName() == null ? other.getTableChName() == null : this.getTableChName().equals(other.getTableChName()))
        	&& (this.getTableType() == null ? other.getTableType() == null : this.getTableType().equals(other.getTableType()))
        	&& (this.getTableOthName() == null ? other.getTableOthName() == null : this.getTableOthName().equals(other.getTableOthName()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTableId() == null) ? 0 : getTableId().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getTableChName() == null) ? 0 : getTableChName().hashCode());
        result = prime * result + ((getTableType() == null) ? 0 : getTableType().hashCode());
        result = prime * result + ((getTableOthName() == null) ? 0 : getTableOthName().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", tableId=").append(tableId);
		sb.append(", tableName=").append(tableName);
		sb.append(", tableChName=").append(tableChName);
		sb.append(", tableType=").append(tableType);
		sb.append(", tableOthName=").append(tableOthName);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}