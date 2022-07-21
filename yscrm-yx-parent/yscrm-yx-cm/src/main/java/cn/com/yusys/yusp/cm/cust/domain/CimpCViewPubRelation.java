package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name = "CIMP_C_VIEW_PUB_RELATION")
public class CimpCViewPubRelation extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "RELATION_ID")
	private String relationId;
	
	@Column(name = "RELATION_NO")
	private String relationNo;
	
	@Column(name = "RELATION_NAME")
	private String relationName;
	
	@Column(name = "CREATOR_ID")
    private String creatorId;

	@Column(name = "CREATE_DATE")
    private Date createDate;

	@Column(name = "LAST_CHG_USR")
    private String lastChgUsr;

	@Column(name = "LAST_CHG_DT")
    private Date lastChgDt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getRelationNo() {
		return relationNo;
	}

	public void setRelationNo(String relationNo) {
		this.relationNo = relationNo;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastChgUsr() {
		return lastChgUsr;
	}

	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}

	public Date getLastChgDt() {
		return lastChgDt;
	}

	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
}
