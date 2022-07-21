package cn.com.yusys.climp.acty.domain;

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
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableType
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:57
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_RL_TABLE_TYPE")
public class LoyRlTableType extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 类别ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "TYPE_ID", unique = false, nullable = false, length = 32)
	private String typeId;
	
	/** 类别名称 **/
	@Column(name = "TYPE_NAME", unique = false, nullable = true, length = 50)
	private String typeName;
	
	/** 父类别ID **/
	@Column(name = "TYPE_PARENT_ID", unique = false, nullable = true, length = 32)
	private String typeParentId;
	
	/** 类别层级 **/
	@Column(name = "TYPE_LEVEL", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal typeLevel;
	
	/** 类别序号[同级类别之间的顺序号] **/
	@Column(name = "TYPE_SEQ", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal typeSeq;
	
	/** 删除标志 **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
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
	 * @param typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}
	
    /**
     * @return TypeName
     */	
	public String getTypeName() {
		return this.typeName;
	}
	
	/**
	 * @param typeParentId
	 */
	public void setTypeParentId(String typeParentId) {
		this.typeParentId = typeParentId == null ? null : typeParentId.trim();
	}
	
    /**
     * @return TypeParentId
     */	
	public String getTypeParentId() {
		return this.typeParentId;
	}
	
	/**
	 * @param typeLevel
	 */
	public void setTypeLevel(java.math.BigDecimal typeLevel) {
		this.typeLevel = typeLevel;
	}
	
    /**
     * @return TypeLevel
     */	
	public java.math.BigDecimal getTypeLevel() {
		return this.typeLevel;
	}
	
	/**
	 * @param typeSeq
	 */
	public void setTypeSeq(java.math.BigDecimal typeSeq) {
		this.typeSeq = typeSeq;
	}
	
    /**
     * @return TypeSeq
     */	
	public java.math.BigDecimal getTypeSeq() {
		return this.typeSeq;
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
        LoyRlTableType other = (LoyRlTableType) that;
		return (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
        	&& (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
        	&& (this.getTypeParentId() == null ? other.getTypeParentId() == null : this.getTypeParentId().equals(other.getTypeParentId()))
                        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
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
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getTypeParentId() == null) ? 0 : getTypeParentId().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
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
		sb.append(", typeId=").append(typeId);
		sb.append(", typeName=").append(typeName);
		sb.append(", typeParentId=").append(typeParentId);
		sb.append(", typeLevel=").append(typeLevel);
		sb.append(", typeSeq=").append(typeSeq);
		sb.append(", deleteSign=").append(deleteSign);
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