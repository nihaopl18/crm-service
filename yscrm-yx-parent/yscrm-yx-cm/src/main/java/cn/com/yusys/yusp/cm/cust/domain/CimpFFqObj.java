package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @author 
 */

@Entity
@Table(name = "CIMP_F_FQ_OBJ")

public class CimpFFqObj extends BaseDomain implements Serializable {
	@Id
	@Column(name = "ID")
	private BigDecimal id;

	@Column(name = "OBJ_NAME")
    private String objName;

	@Column(name = "TABLE_NAME")
    private String tableName;

	@Column(name = "PARENT_ID")
    private BigDecimal parentId;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public BigDecimal getParentId() {
        return parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

}