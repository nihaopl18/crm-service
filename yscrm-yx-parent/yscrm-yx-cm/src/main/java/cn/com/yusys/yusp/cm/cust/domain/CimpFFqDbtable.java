package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name = "CIMP_F_FQ_DBTABLE")
public class CimpFFqDbtable extends BaseDomain implements Serializable {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "APP_ID")
    private String appId;

	@Column(name = "PARENT_ID")
    private String parentId;

	@Column(name = "NAME")
    private String name;

	@Column(name = "TYPE")
    private String type;

	@Column(name = "TYPE_NAME")
    private String typeName;

	@Column(name = "VALUE")
    private String value;

	@Column(name = "RDB_DS_ID")
    private BigDecimal rdbDsId;

	@Column(name = "USE_CACHE_FLAG")
    private BigDecimal useCacheFlag;

	@Column(name = "MAX_CACHE_REG")
    private BigDecimal maxCacheReg;

	@Column(name = "IDX")
    private String idx;

	@Column(name = "NOTES")
    private String notes;

	@Column(name = "TEMP_ID")
    private BigDecimal tempId;

	@Column(name = "TEMP_NAME")
    private String tempName;

	@Column(name = "READER_ID")
    private BigDecimal readerId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigDecimal getRdbDsId() {
        return rdbDsId;
    }

    public void setRdbDsId(BigDecimal rdbDsId) {
        this.rdbDsId = rdbDsId;
    }

    public BigDecimal getUseCacheFlag() {
        return useCacheFlag;
    }

    public void setUseCacheFlag(BigDecimal useCacheFlag) {
        this.useCacheFlag = useCacheFlag;
    }

    public BigDecimal getMaxCacheReg() {
        return maxCacheReg;
    }

    public void setMaxCacheReg(BigDecimal maxCacheReg) {
        this.maxCacheReg = maxCacheReg;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BigDecimal getTempId() {
        return tempId;
    }

    public void setTempId(BigDecimal tempId) {
        this.tempId = tempId;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public BigDecimal getReaderId() {
        return readerId;
    }

    public void setReaderId(BigDecimal readerId) {
        this.readerId = readerId;
    }

}