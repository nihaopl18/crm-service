package cn.com.yusys.yscrm.custpub.domain;

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
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciCustUpdateHis
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-31 15:48:15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_CUST_UPDATE_HIS")
public class OcrmFciCustUpdateHis extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键
 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 客户号
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 修改机构
 **/
	@Column(name = "CHG_ORG_ID", unique = false, nullable = true, length = 32)
	private String chgOrgId;
	
	/** 修改人
 **/
	@Column(name = "CHG_USR", unique = false, nullable = true, length = 32)
	private String chgUsr;
	
	/** 修改时间
 **/
	@Column(name = "CHG_DT", unique = false, nullable = true, length = 7)
	private Date chgDt;
	
	/** 修改模块
 **/
	@Column(name = "CHG_MOD", unique = false, nullable = true, length = 10)
	private String chgMod;
	
	/** 操作类型
 **/
	@Column(name = "CHG_TYPE", unique = false, nullable = true, length = 30)
	private String chgType;
	
	/** 修改字段英文名称
 **/
	@Column(name = "CHG_ENG_NAME", unique = false, nullable = true, length = 32)
	private String chgEngName;
	
	/** 修改项目
 **/
	@Column(name = "CHG_CHI_NAME", unique = false, nullable = true, length = 100)
	private String chgChiName;
	
	/** 修改前key值
 **/
	@Column(name = "CHG_BEF_KEY_VALUE", unique = false, nullable = true, length = 4)
	private String chgBefKeyValue;
	
	/** 修改前value值
 **/
	@Column(name = "CHG_BEF_VALUE_VALUE", unique = false, nullable = true, length = 30)
	private String chgBefValueValue;
	
	/** 修改后key值
 **/
	@Column(name = "CHG_AFT_KEY_VALUE", unique = false, nullable = true, length = 4)
	private String chgAftKeyValue;
	
	/** 修改后value值
 **/
	@Column(name = "CHG_AFT_VALUE_VALUE", unique = false, nullable = true, length = 30)
	private String chgAftValueValue;
	
	/** 字段对应表名
 **/
	@Column(name = "TABLE_NAME", unique = false, nullable = true, length = 10)
	private String tableName;
	
	
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
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param chgOrgId
	 */
	public void setChgOrgId(String chgOrgId) {
		this.chgOrgId = chgOrgId == null ? null : chgOrgId.trim();
	}
	
    /**
     * @return ChgOrgId
     */	
	public String getChgOrgId() {
		return this.chgOrgId;
	}
	
	/**
	 * @param chgUsr
	 */
	public void setChgUsr(String chgUsr) {
		this.chgUsr = chgUsr == null ? null : chgUsr.trim();
	}
	
    /**
     * @return ChgUsr
     */	
	public String getChgUsr() {
		return this.chgUsr;
	}
	
	/**
	 * @param chgDt
	 */
	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}
	
    /**
     * @return ChgDt
     */	
	public Date getChgDt() {
		return this.chgDt;
	}
	
	/**
	 * @param chgMod
	 */
	public void setChgMod(String chgMod) {
		this.chgMod = chgMod == null ? null : chgMod.trim();
	}
	
    /**
     * @return ChgMod
     */	
	public String getChgMod() {
		return this.chgMod;
	}
	
	/**
	 * @param chgType
	 */
	public void setChgType(String chgType) {
		this.chgType = chgType == null ? null : chgType.trim();
	}
	
    /**
     * @return ChgType
     */	
	public String getChgType() {
		return this.chgType;
	}
	
	/**
	 * @param chgEngName
	 */
	public void setChgEngName(String chgEngName) {
		this.chgEngName = chgEngName == null ? null : chgEngName.trim();
	}
	
    /**
     * @return ChgEngName
     */	
	public String getChgEngName() {
		return this.chgEngName;
	}
	
	/**
	 * @param chgChiName
	 */
	public void setChgChiName(String chgChiName) {
		this.chgChiName = chgChiName == null ? null : chgChiName.trim();
	}
	
    /**
     * @return ChgChiName
     */	
	public String getChgChiName() {
		return this.chgChiName;
	}
	
	/**
	 * @param chgBefKeyValue
	 */
	public void setChgBefKeyValue(String chgBefKeyValue) {
		this.chgBefKeyValue = chgBefKeyValue == null ? null : chgBefKeyValue.trim();
	}
	
    /**
     * @return ChgBefKeyValue
     */	
	public String getChgBefKeyValue() {
		return this.chgBefKeyValue;
	}
	
	/**
	 * @param chgBefValueValue
	 */
	public void setChgBefValueValue(String chgBefValueValue) {
		this.chgBefValueValue = chgBefValueValue == null ? null : chgBefValueValue.trim();
	}
	
    /**
     * @return ChgBefValueValue
     */	
	public String getChgBefValueValue() {
		return this.chgBefValueValue;
	}
	
	/**
	 * @param chgAftKeyValue
	 */
	public void setChgAftKeyValue(String chgAftKeyValue) {
		this.chgAftKeyValue = chgAftKeyValue == null ? null : chgAftKeyValue.trim();
	}
	
    /**
     * @return ChgAftKeyValue
     */	
	public String getChgAftKeyValue() {
		return this.chgAftKeyValue;
	}
	
	/**
	 * @param chgAftValueValue
	 */
	public void setChgAftValueValue(String chgAftValueValue) {
		this.chgAftValueValue = chgAftValueValue == null ? null : chgAftValueValue.trim();
	}
	
    /**
     * @return ChgAftValueValue
     */	
	public String getChgAftValueValue() {
		return this.chgAftValueValue;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getTableName() {
		return this.tableName;
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
        OcrmFciCustUpdateHis other = (OcrmFciCustUpdateHis) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getChgOrgId() == null ? other.getChgOrgId() == null : this.getChgOrgId().equals(other.getChgOrgId()))
        	&& (this.getChgUsr() == null ? other.getChgUsr() == null : this.getChgUsr().equals(other.getChgUsr()))
                	&& (this.getChgMod() == null ? other.getChgMod() == null : this.getChgMod().equals(other.getChgMod()))
        	&& (this.getChgType() == null ? other.getChgType() == null : this.getChgType().equals(other.getChgType()))
        	&& (this.getChgEngName() == null ? other.getChgEngName() == null : this.getChgEngName().equals(other.getChgEngName()))
        	&& (this.getChgChiName() == null ? other.getChgChiName() == null : this.getChgChiName().equals(other.getChgChiName()))
        	&& (this.getChgBefKeyValue() == null ? other.getChgBefKeyValue() == null : this.getChgBefKeyValue().equals(other.getChgBefKeyValue()))
        	&& (this.getChgBefValueValue() == null ? other.getChgBefValueValue() == null : this.getChgBefValueValue().equals(other.getChgBefValueValue()))
        	&& (this.getChgAftKeyValue() == null ? other.getChgAftKeyValue() == null : this.getChgAftKeyValue().equals(other.getChgAftKeyValue()))
        	&& (this.getChgAftValueValue() == null ? other.getChgAftValueValue() == null : this.getChgAftValueValue().equals(other.getChgAftValueValue()))
        	&& (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getChgOrgId() == null) ? 0 : getChgOrgId().hashCode());
        result = prime * result + ((getChgUsr() == null) ? 0 : getChgUsr().hashCode());
        result = prime * result + ((getChgMod() == null) ? 0 : getChgMod().hashCode());
        result = prime * result + ((getChgType() == null) ? 0 : getChgType().hashCode());
        result = prime * result + ((getChgEngName() == null) ? 0 : getChgEngName().hashCode());
        result = prime * result + ((getChgChiName() == null) ? 0 : getChgChiName().hashCode());
        result = prime * result + ((getChgBefKeyValue() == null) ? 0 : getChgBefKeyValue().hashCode());
        result = prime * result + ((getChgBefValueValue() == null) ? 0 : getChgBefValueValue().hashCode());
        result = prime * result + ((getChgAftKeyValue() == null) ? 0 : getChgAftKeyValue().hashCode());
        result = prime * result + ((getChgAftValueValue() == null) ? 0 : getChgAftValueValue().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", custId=").append(custId);
		sb.append(", chgOrgId=").append(chgOrgId);
		sb.append(", chgUsr=").append(chgUsr);
		sb.append(", chgDt=").append(chgDt);
		sb.append(", chgMod=").append(chgMod);
		sb.append(", chgType=").append(chgType);
		sb.append(", chgEngName=").append(chgEngName);
		sb.append(", chgChiName=").append(chgChiName);
		sb.append(", chgBefKeyValue=").append(chgBefKeyValue);
		sb.append(", chgBefValueValue=").append(chgBefValueValue);
		sb.append(", chgAftKeyValue=").append(chgAftKeyValue);
		sb.append(", chgAftValueValue=").append(chgAftValueValue);
		sb.append(", tableName=").append(tableName);
        sb.append("]");
        return sb.toString();
    }
}