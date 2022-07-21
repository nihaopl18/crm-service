package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableEcName
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:46:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_RL_TABLE_EC_NAME")
public class LoyRlTableEcName extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 表名ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "TABLE_ID", unique = false, nullable = false, length = 32)
	private String tableId;
	
	/** 表英文名 **/
	@Column(name = "TABLE_E_NAME", unique = false, nullable = true, length = 50)
	private String tableEName;
	
	/** 表中文名 **/
	@Column(name = "TABLE_C_NAME", unique = false, nullable = true, length = 200)
	private String tableCName;
	
	/** 表类别ID **/
	@Column(name = "TYPE_ID", unique = false, nullable = true, length = 32)
	private String typeId;
	
	/** 类型[表、视图等] **/
	@Column(name = "OBJECT_TYPE", unique = false, nullable = true, length = 10)
	private String objectType;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 256)
	private String remark;
	
	/** 删除标识 **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
	/** 交易类型 **/
	@Column(name = "TRANSACTION_CODE", unique = false, nullable = true, length = 20)
	private String transactionCode;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	
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
	 * @param tableEName
	 */
	public void setTableEName(String tableEName) {
		this.tableEName = tableEName == null ? null : tableEName.trim();
	}
	
    /**
     * @return tableEName
     */	
	public String getTableEName() {
		return this.tableEName;
	}
	
	/**
	 * @param tableCName
	 */
	public void setTableCName(String tableCName) {
		this.tableCName = tableCName == null ? null : tableCName.trim();
	}
	
    /**
     * @return TableCName
     */	
	public String getTableCName() {
		return this.tableCName;
	}
	
	/**
	 * @param typeId
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId == null ? null : typeId.trim();
	}
	
    /**
     * @return TypeId
     */	
	public String getTypeId() {
		return this.typeId;
	}
	
	/**
	 * @param objectType
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType == null ? null : objectType.trim();
	}
	
    /**
     * @return ObjectType
     */	
	public String getObjectType() {
		return this.objectType;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * @param deleteSign
	 */
	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign == null ? null : deleteSign.trim();
	}
	
    /**
     * @return DeleteSign
     */	
	public String getDeleteSign() {
		return this.deleteSign;
	}
	
	/**
	 * @param transactionCode
	 */
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode == null ? null : transactionCode.trim();
	}
	
    /**
     * @return TransactionCode
     */	
	public String getTransactionCode() {
		return this.transactionCode;
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
	
	/**
	 * @param updateOrg
	 */
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}
	
    /**
     * @return UpdateOrg
     */	
	public String getUpdateOrg() {
		return this.updateOrg;
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
        LoyRlTableEcName other = (LoyRlTableEcName) that;
		return (this.getTableId() == null ? other.getTableId() == null : this.getTableId().equals(other.getTableId()))
        	&& (this.getTableEName() == null ? other.getTableEName() == null : this.getTableEName().equals(other.getTableEName()))
        	&& (this.getTableCName() == null ? other.getTableCName() == null : this.getTableCName().equals(other.getTableCName()))
        	&& (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
        	&& (this.getObjectType() == null ? other.getObjectType() == null : this.getObjectType().equals(other.getObjectType()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        	&& (this.getTransactionCode() == null ? other.getTransactionCode() == null : this.getTransactionCode().equals(other.getTransactionCode()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTableId() == null) ? 0 : getTableId().hashCode());
        result = prime * result + ((getTableEName() == null) ? 0 : getTableEName().hashCode());
        result = prime * result + ((getTableCName() == null) ? 0 : getTableCName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getObjectType() == null) ? 0 : getObjectType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        result = prime * result + ((getTransactionCode() == null) ? 0 : getTransactionCode().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", tableId=").append(tableId);
		sb.append(", tableEName=").append(tableEName);
		sb.append(", tableCName=").append(tableCName);
		sb.append(", typeId=").append(typeId);
		sb.append(", objectType=").append(objectType);
		sb.append(", remark=").append(remark);
		sb.append(", deleteSign=").append(deleteSign);
		sb.append(", transactionCode=").append(transactionCode);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
        sb.append("]");
        return sb.toString();
    }
}