package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @author 
 */
@Entity
@Table(name = "CIMP_F_FQ_GROUP")

public class CimpFFqGroup extends BaseDomain implements Serializable {
	@Id
	@Column(name = "ID")  
	private Long id;
	
	@Column(name = "OBJ_ID") 
    private Long objId;

	@Column(name = "GROUP_NAME") 
    private String groupName;

	@Column(name = "PARENT_ID") 
    private String parentId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjId() {
        return objId;
    }

    public void setObjId(Long objId) {
        this.objId = objId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

}