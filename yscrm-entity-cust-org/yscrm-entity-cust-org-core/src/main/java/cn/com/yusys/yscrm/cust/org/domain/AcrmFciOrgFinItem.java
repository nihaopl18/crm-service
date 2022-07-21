package cn.com.yusys.yscrm.cust.org.domain;

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
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgFinItem
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 10:55:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_ORG_FIN_ITEM")
public class AcrmFciOrgFinItem extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** ITEM_ID **/
	@Column(name = "ITEM_ID", unique = false, nullable = true, length = 20)
	private String itemId;
	
	/** ITEM_NAME **/
	@Column(name = "ITEM_NAME", unique = false, nullable = true, length = 80)
	private String itemName;
	
	/** ITEM_TYPE **/
	@Column(name = "ITEM_TYPE", unique = false, nullable = true, length = 20)
	private String itemType;
	
	/** CREATE_PERSON **/
	@Column(name = "CREATE_PERSON", unique = false, nullable = true, length = 20)
	private String createPerson;
	
	/** CREATE_DT **/
	@Transient
	@Column(name = "CREATE_DT", unique = false, nullable = true, length = 7)
	private Date createDt;
	
	/** ITEM_ATTR **/
	@Column(name = "ITEM_ATTR", unique = false, nullable = true, length = 20)
	private String itemAttr;
	
	/** ITEM_SEQ **/
	@Column(name = "ITEM_SEQ", unique = false, nullable = true, length = 20)
	private String itemSeq;
	
	
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
	 * @param itemId
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}
	
    /**
     * @return ItemId
     */	
	public String getItemId() {
		return this.itemId;
	}
	
	/**
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}
	
    /**
     * @return ItemName
     */	
	public String getItemName() {
		return this.itemName;
	}
	
	/**
	 * @param itemType
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType == null ? null : itemType.trim();
	}
	
    /**
     * @return ItemType
     */	
	public String getItemType() {
		return this.itemType;
	}
	
	/**
	 * @param createPerson
	 */
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson == null ? null : createPerson.trim();
	}
	
    /**
     * @return CreatePerson
     */	
	public String getCreatePerson() {
		return this.createPerson;
	}
	
	/**
	 * @param createDt
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
    /**
     * @return CreateDt
     */	
	public Date getCreateDt() {
		return this.createDt;
	}
	
	/**
	 * @param itemAttr
	 */
	public void setItemAttr(String itemAttr) {
		this.itemAttr = itemAttr == null ? null : itemAttr.trim();
	}
	
    /**
     * @return ItemAttr
     */	
	public String getItemAttr() {
		return this.itemAttr;
	}
	
	/**
	 * @param itemSeq
	 */
	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq == null ? null : itemSeq.trim();
	}
	
    /**
     * @return ItemSeq
     */	
	public String getItemSeq() {
		return this.itemSeq;
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
        AcrmFciOrgFinItem other = (AcrmFciOrgFinItem) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
        	&& (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
        	&& (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
        	&& (this.getCreatePerson() == null ? other.getCreatePerson() == null : this.getCreatePerson().equals(other.getCreatePerson()))
                	&& (this.getItemAttr() == null ? other.getItemAttr() == null : this.getItemAttr().equals(other.getItemAttr()))
        	&& (this.getItemSeq() == null ? other.getItemSeq() == null : this.getItemSeq().equals(other.getItemSeq()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getCreatePerson() == null) ? 0 : getCreatePerson().hashCode());
        result = prime * result + ((getItemAttr() == null) ? 0 : getItemAttr().hashCode());
        result = prime * result + ((getItemSeq() == null) ? 0 : getItemSeq().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", itemId=").append(itemId);
		sb.append(", itemName=").append(itemName);
		sb.append(", itemType=").append(itemType);
		sb.append(", createPerson=").append(createPerson);
		sb.append(", createDt=").append(createDt);
		sb.append(", itemAttr=").append(itemAttr);
		sb.append(", itemSeq=").append(itemSeq);
        sb.append("]");
        return sb.toString();
    }
}