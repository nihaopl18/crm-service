package cn.com.yusys.yscimc.operation.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @zhangxs4 数据集属性表
 */

@Entity
@Table(name = "CIMP_F_CI_FQ_DBCOL")
public class OcrmFCiFqDbcol extends BaseDomain implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "COL_NAME_E")
    private String colNameE;

    @Column(name = "COL_NAME_C")
    private String colNameC;

    @Column(name = "COL_SIZE")
    private long colSize;

    @Column(name = "COL_TYPE")
    private String colType;

    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    @Column(name = "IS_NULL")
    private String isNull;

    @Column(name = "PRIMARY_KEY_FLAG")
    private String primaryKeyFlag;

    @Column(name = "DBTABLE_ID")
    private long dbtableId;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "IS_ENABLE")
    private String isEnable;

    @Column(name = "COL_SORT")
    private long colSort;

    @Column(name = "DBTABLE_NAME")
    private String dbtableName;

    @Column(name = "GROUP_ID")
    private long groupId;

    @Column(name = "FIELD_TYPE")
    private String fieldType;

    @Column(name = "F_NAME")
    private String fName;

    @Column(name = "OBJ_ID")
    private long objId;

    @Column(name = "ALIAS")
    private String alias;

    @Column(name = "NO_SENSI")
    private String noSensi;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColNameE() {
        return colNameE;
    }

    public void setColNameE(String colNameE) {
        this.colNameE = colNameE;
    }

    public String getColNameC() {
        return colNameC;
    }

    public void setColNameC(String colNameC) {
        this.colNameC = colNameC;
    }

    public long getColSize() {
        return colSize;
    }

    public void setColSize(long colSize) {
        this.colSize = colSize;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getPrimaryKeyFlag() {
        return primaryKeyFlag;
    }

    public void setPrimaryKeyFlag(String primaryKeyFlag) {
        this.primaryKeyFlag = primaryKeyFlag;
    }

    public long getDbtableId() {
        return dbtableId;
    }

    public void setDbtableId(long dbtableId) {
        this.dbtableId = dbtableId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public long getColSort() {
        return colSort;
    }

    public void setColSort(long colSort) {
        this.colSort = colSort;
    }

    public String getDbtableName() {
        return dbtableName;
    }

    public void setDbtableName(String dbtableName) {
        this.dbtableName = dbtableName;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public long getObjId() {
        return objId;
    }

    public void setObjId(long objId) {
        this.objId = objId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNoSensi() {
        return noSensi;
    }

    public void setNoSensi(String noSensi) {
        this.noSensi = noSensi;
    }

}
