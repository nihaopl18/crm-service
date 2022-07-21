package cn.com.yusys.yscimc.operation.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @zhangxs4 数据集对象表
 */

@Entity
@Table(name = "CIMP_F_CI_FQ_OBJ")

public class OcrmFCiFqObj extends BaseDomain implements Serializable {
    @Id
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "OBJ_NAME")
    private String objName;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "PARENT_ID")
    private BigDecimal parentId;

    @Column(name = "ALIAS")
    private String alias;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
