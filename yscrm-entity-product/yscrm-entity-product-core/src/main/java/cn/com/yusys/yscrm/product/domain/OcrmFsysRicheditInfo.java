package cn.com.yusys.yscrm.product.domain;

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
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysRicheditInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 17:43:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_RICHEDIT_INFO")
public class OcrmFsysRicheditInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 关联应用ID **/
	@Column(name = "REL_ID", unique = false, nullable = true, length = 32)
	private String relId;
	
	/** 关联应用类型 **/
	@Column(name = "REL_TYPE", unique = false, nullable = true, length = 30)
	private String relType;
	
	/** 富文本内容 **/
	@Column(name = "CONTENT", unique = false, nullable = true, length = 4000)
	private String content;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
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
	 * @param relId
	 */
	public void setRelId(String relId) {
		this.relId = relId == null ? null : relId.trim();
	}
	
    /**
     * @return RelId
     */	
	public String getRelId() {
		return this.relId;
	}
	
	/**
	 * @param relType
	 */
	public void setRelType(String relType) {
		this.relType = relType == null ? null : relType.trim();
	}
	
    /**
     * @return RelType
     */	
	public String getRelType() {
		return this.relType;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
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
        OcrmFsysRicheditInfo other = (OcrmFsysRicheditInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getRelId() == null ? other.getRelId() == null : this.getRelId().equals(other.getRelId()))
        	&& (this.getRelType() == null ? other.getRelType() == null : this.getRelType().equals(other.getRelType()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRelId() == null) ? 0 : getRelId().hashCode());
        result = prime * result + ((getRelType() == null) ? 0 : getRelType().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", relId=").append(relId);
		sb.append(", relType=").append(relType);
		sb.append(", content=").append(content);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}