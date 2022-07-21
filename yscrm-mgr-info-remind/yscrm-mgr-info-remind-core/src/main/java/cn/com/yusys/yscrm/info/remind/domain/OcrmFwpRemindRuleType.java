package cn.com.yusys.yscrm.info.remind.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindRuleType
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-19 09:02:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_REMIND_RULE_TYPE")
public class OcrmFwpRemindRuleType extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 规则类别编号 **/
	@Id
	@Column(name = "TYPE_ID")
	@Generated(GenerationType.UUID)
	private String typeId;
	
	/** 规则类别名称 **/
	@Column(name = "TYPE_NAME", unique = false, nullable = true, length = 100)
	private String typeName;
	
	/** 归属规则类别编号 **/
	@Column(name = "UP_TYPE_ID", unique = false, nullable = true, length = 32)
	private String upTypeId;
	
	
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
	 * @param upTypeId
	 */
	public void setUpTypeId(String upTypeId) {
		this.upTypeId = upTypeId == null ? null : upTypeId.trim();
	}
	
    /**
     * @return UpTypeId
     */	
	public String getUpTypeId() {
		return this.upTypeId;
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
        OcrmFwpRemindRuleType other = (OcrmFwpRemindRuleType) that;
		return (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
        	&& (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
        	&& (this.getUpTypeId() == null ? other.getUpTypeId() == null : this.getUpTypeId().equals(other.getUpTypeId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getUpTypeId() == null) ? 0 : getUpTypeId().hashCode());
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
		sb.append(", upTypeId=").append(upTypeId);
        sb.append("]");
        return sb.toString();
    }
}