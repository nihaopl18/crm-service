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
 * @类名称: LoyRlFieldEcName
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_RL_FIELD_EC_NAME")
public class LoyRlFieldEcName extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 字段ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "FIELD_ID", unique = false, nullable = false, length = 32)
	private String fieldId;
	
	/** 表名ID **/
	@Column(name = "TABLE_ID", unique = false, nullable = true, length = 32)
	private String tableId;
	
	/** 字段英文名 **/
	@Column(name = "FIELD_E_NAME", unique = false, nullable = true, length = 50)
	private String fieldEName;
	
	/** 字段中文名 **/
	@Column(name = "FIELD_C_NAME", unique = false, nullable = true, length = 200)
	private String fieldCName;
	
	/** 字段类型[文本框、下拉框等 ，数据字典定义] **/
	@Column(name = "FIELD_TYPE", unique = false, nullable = true, length = 10)
	private String fieldType;
	
	/** 字段长度 **/
	@Column(name = "FIELD_LENGTH", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal fieldLength;
	
	/** 是否规则化[在配置积分规则时，是否显示这个字段，数据字典定义] **/
	@Column(name = "IS_DISPLAY", unique = false, nullable = true, length = 10)
	private String isDisplay;
	
	/** 下拉框选项[如果字段是下拉框类型，其下拉选项引用数据字典(名称)] **/
	@Column(name = "FNAME", unique = false, nullable = true, length = 100)
	private String fname;
	
	/** 放大镜值 **/
	@Column(name = "MAGNIFIER", unique = false, nullable = true, length = 100)
	private String magnifier;
	
	/** 删除标志 **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 256)
	private String remark;
	
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
	 * @param fieldId
	 */
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId == null ? null : fieldId.trim();
	}
	
    /**
     * @return FieldId
     */	
	public String getFieldId() {
		return this.fieldId;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname == null ? null : fname.trim();
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
	 * @param fieldEName
	 */
	public void setFieldEName(String fieldEName) {
		this.fieldEName = fieldEName == null ? null : fieldEName.trim();
	}
	
    /**
     * @return FieldEName
     */	
	public String getFieldEName() {
		return this.fieldEName;
	}
	
	/**
	 * @param fieldCName
	 */
	public void setFieldCName(String fieldCName) {
		this.fieldCName = fieldCName == null ? null : fieldCName.trim();
	}
	
    /**
     * @return FieldCName
     */	
	public String getFieldCName() {
		return this.fieldCName;
	}
	
	/**
	 * @param fieldType
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType == null ? null : fieldType.trim();
	}
	
    /**
     * @return FieldType
     */	
	public String getFieldType() {
		return this.fieldType;
	}
	
	/**
	 * @param fieldLength
	 */
	public void setFieldLength(java.math.BigDecimal fieldLength) {
		this.fieldLength = fieldLength;
	}
	
    /**
     * @return FieldLength
     */	
	public java.math.BigDecimal getFieldLength() {
		return this.fieldLength;
	}
	
	/**
	 * @param isDisplay
	 */
	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay == null ? null : isDisplay.trim();
	}
	
    /**
     * @return IsDisplay
     */	
	public String getIsDisplay() {
		return this.isDisplay;
	}
	
	
	 /**
     * @return magnifier
     */	
	public String getMagnifier() {
		return magnifier;
	}
	/**
	 * @param magnifier
	 */
	public void setMagnifier(String magnifier) {
		this.magnifier = magnifier;
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
        LoyRlFieldEcName other = (LoyRlFieldEcName) that;
		return (this.getFieldId() == null ? other.getFieldId() == null : this.getFieldId().equals(other.getFieldId()))
        	&& (this.getTableId() == null ? other.getTableId() == null : this.getTableId().equals(other.getTableId()))
        	&& (this.getFieldEName() == null ? other.getFieldEName() == null : this.getFieldEName().equals(other.getFieldEName()))
        	&& (this.getFieldCName() == null ? other.getFieldCName() == null : this.getFieldCName().equals(other.getFieldCName()))
        	&& (this.getFieldType() == null ? other.getFieldType() == null : this.getFieldType().equals(other.getFieldType()))
                	&& (this.getIsDisplay() == null ? other.getIsDisplay() == null : this.getIsDisplay().equals(other.getIsDisplay()))
        	&& (this.getFname() == null ? other.getFname() == null : this.getFname().equals(other.getFname()))
        	&& (this.getMagnifier() == null ? other.getMagnifier() == null : this.getMagnifier().equals(other.getMagnifier()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getFieldId() == null) ? 0 : getFieldId().hashCode());
        result = prime * result + ((getTableId() == null) ? 0 : getTableId().hashCode());
        result = prime * result + ((getFieldEName() == null) ? 0 : getFieldEName().hashCode());
        result = prime * result + ((getFieldCName() == null) ? 0 : getFieldCName().hashCode());
        result = prime * result + ((getFieldType() == null) ? 0 : getFieldType().hashCode());
        result = prime * result + ((getIsDisplay() == null) ? 0 : getIsDisplay().hashCode());
        result = prime * result + ((getFname() == null) ? 0 : getFname().hashCode());
        result = prime * result + ((getMagnifier() == null) ? 0 : getMagnifier().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", fieldId=").append(fieldId);
		sb.append(", tableId=").append(tableId);
		sb.append(", fieldEName=").append(fieldEName);
		sb.append(", fieldCName=").append(fieldCName);
		sb.append(", fieldType=").append(fieldType);
		sb.append(", fieldLength=").append(fieldLength);
		sb.append(", isDisplay=").append(isDisplay);
		sb.append(", fname=").append(fname);
		sb.append(", magnifier=").append(magnifier);
		sb.append(", deleteSign=").append(deleteSign);
		sb.append(", remark=").append(remark);
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