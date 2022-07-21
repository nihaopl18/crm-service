package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyVirtTicketKind
 * @类描述: 虚拟票券类目数据实体类
 * @功能描述: 
 * @创建人: zhanghan3
 * @创建时间: 2019-06-11 14:39:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_VIRT_TICKET_KIND")
public class LoyQyVirtTicketKind extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 虚拟票券类目ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "KIND_ID", unique = false, nullable = false, length = 32)
	private String kindId;
	
	/** 类目顺序 **/
	@Column(name = "KIND_ORDER", unique = false, nullable = true, length = 100)
	private String kindOrder;
	
	/** 类目名称 **/
	@Column(name = "KIND_NAME", unique = false, nullable = true, length = 200)
	private String kindName;
	
	/** 上级类目编号 **/
	@Column(name = "SUP_KIND_ID", unique = false, nullable = true, length = 100)
	private String supKindId;
	
	/** 上级类目名称 **/
	@Column(name = "SUP_KIND_NAME", unique = false, nullable = true, length = 100)
	private String supKindName;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	/** 法人机构 **/
	@Column(name = "CORP_ORG", unique = false, nullable = true, length = 20)
	private String corpOrg;
	
    public String getKindId() {
		return kindId;
	}

	public void setKindId(String kindId) {
		this.kindId = kindId;
	}

	public String getKindOrder() {
		return kindOrder;
	}

	public void setKindOrder(String kindOrder) {
		this.kindOrder = kindOrder;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getSupKindId() {
		return supKindId;
	}

	public void setSupKindId(String supKindId) {
		this.supKindId = supKindId;
	}

	public String getSupKindName() {
		return supKindName;
	}

	public void setSupKindName(String supKindName) {
		this.supKindName = supKindName;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getCorpOrg() {
		return corpOrg;
	}

	public void setCorpOrg(String corpOrg) {
		this.corpOrg = corpOrg;
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
        LoyQyVirtTicketKind other = (LoyQyVirtTicketKind) that;
		return (this.getKindId() == null ? other.getKindId() == null : this.getKindId().equals(other.getKindId()))
        	&& (this.getKindOrder() == null ? other.getKindOrder() == null : this.getKindOrder().equals(other.getKindOrder()))
        	&& (this.getKindName() == null ? other.getKindName() == null : this.getKindName().equals(other.getKindName()))
        	&& (this.getSupKindId() == null ? other.getSupKindId() == null : this.getSupKindId().equals(other.getSupKindId()))
        	&& (this.getSupKindName() == null ? other.getSupKindName() == null : this.getSupKindName().equals(other.getSupKindName()))
        	&& (this.getCorpOrg() == null ? other.getCorpOrg() == null : this.getCorpOrg().equals(other.getCorpOrg()))
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
        result = prime * result + ((getKindId() == null) ? 0 : getKindId().hashCode());
        result = prime * result + ((getKindOrder() == null) ? 0 : getKindOrder().hashCode());
        result = prime * result + ((getKindName() == null) ? 0 : getKindName().hashCode());
        result = prime * result + ((getSupKindId() == null) ? 0 : getSupKindId().hashCode());
        result = prime * result + ((getSupKindName() == null) ? 0 : getSupKindName().hashCode());
        result = prime * result + ((getCorpOrg() == null) ? 0 : getCorpOrg().hashCode());
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
		sb.append(", kindId=").append(kindId);
		sb.append(", kindOrder=").append(kindOrder);
		sb.append(", kindName=").append(kindName);
		sb.append(", supKindId=").append(supKindId);
		sb.append(", supKindName=").append(supKindName);
		sb.append(", corpOrg=").append(corpOrg);
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