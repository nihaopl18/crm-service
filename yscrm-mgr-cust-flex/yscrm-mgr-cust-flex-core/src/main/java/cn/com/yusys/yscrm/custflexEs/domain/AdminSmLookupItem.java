package cn.com.yusys.yscrm.custflexEs.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The persistent class for the ADMIN_SM_LOOKUP_ITEM database table.
 * 
 */
@Entity
@Table(name = "ADMIN_SM_LOOKUP_ITEM")
public class AdminSmLookupItem extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOOKUP_ITEM_ID")
	@Generated(GenerationType.UUID)
	private String lookupItemId;

	@Column(name = "LAST_CHG_DT")
	private String lastChgDt;

	@Column(name = "LAST_CHG_USR")
	private String lastChgUsr;

	@Column(name = "LOOKUP_CODE")
	private String lookupCode;

	@Column(name = "LOOKUP_ITEM_CODE")
	private String lookupItemCode;

	@Column(name = "LOOKUP_ITEM_COMMENT")
	private String lookupItemComment;

	@Column(name = "LOOKUP_ITEM_NAME")
	private String lookupItemName;

	@Column(name = "UP_LOOKUP_ITEM_ID")
	private String upLookupItemId;
	
	@Column(name = "LOOKUP_ITEM_ORDER")
	private Integer lookupItemOrder;

	public AdminSmLookupItem() {
	}

	public String getLookupItemId() {
		return this.lookupItemId;
	}

	public void setLookupItemId(String lookupItemId) {
		this.lookupItemId = lookupItemId;
	}

	public String getLastChgDt() {
		return this.lastChgDt;
	}

	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt;
	}

	public String getLastChgUsr() {
		return this.lastChgUsr;
	}

	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}

	public String getLookupCode() {
		return this.lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getLookupItemCode() {
		return this.lookupItemCode;
	}

	public void setLookupItemCode(String lookupItemCode) {
		this.lookupItemCode = lookupItemCode;
	}

	public String getLookupItemComment() {
		return this.lookupItemComment;
	}

	public void setLookupItemComment(String lookupItemComment) {
		this.lookupItemComment = lookupItemComment;
	}

	public String getLookupItemName() {
		return this.lookupItemName;
	}

	public void setLookupItemName(String lookupItemName) {
		this.lookupItemName = lookupItemName;
	}

	public String getUpLookupItemId() {
		return this.upLookupItemId;
	}

	public void setUpLookupItemId(String upLookupItemId) {
		this.upLookupItemId = upLookupItemId;
	}

	public Integer getLookupItemOrder() {
		return lookupItemOrder;
	}

	public void setLookupItemOrder(Integer lookupItemOrder) {
		this.lookupItemOrder = lookupItemOrder;
	}

}