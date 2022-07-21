package cn.com.yusys.yusp.cm.indexplan.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 营销成效策划组件表
 * 
 */
@Entity
@Table(name="CIMP_CM_ASSEMBLY_ANALYSIS")
public class CimpCmAssemblyAnalysis extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="ASSEMBLY_ID")
	private String assemblyId;

	@Column(name="PRODUCT_ID")
	private String productId;

	@Column(name="INDEX_ID")
	private String indexId;

	@Column(name="OBJ_TYPE")
	private String objType;

	@Column(name="OBJ_ID")
	private String objId;

	@Column(name="INITIAL_VALUE")
	private BigDecimal initialValue;

	@Column(name="TARGET_VALUE")
	private BigDecimal targetValue;

	@Column(name="LAST_CHG_USR")
	private String lastChgUsr;

	@Column(name="LAST_CHG_DT")
	private Date lastChgDt;

	@Column(name="CRAT_USR")
	private String cratUsr;

	@Column(name="CRAT_DT")
	private Date cratDt;
	
	@Column(name="NOD_ID")
	private String nodId;

	@Column(name="COMPLETION_VALUE")
	private String completionValue;

	@Column(name="COMPLETION_RATE")
	private String completionRate;

	@Column(name="SORT")
	private String sort;

	@Column(name="INDEX_NAME")
	private String indexName;

	@Column(name="MARK_FLAG")
	private String markFlag;

	public String getNodId() {
		return nodId;
	}

	public void setNodId(String nodId) {
		this.nodId = nodId;
	}

	public String getAssemblyId() {
		return assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public BigDecimal getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(BigDecimal initialValue) {
		this.initialValue = initialValue;
	}

	public BigDecimal getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(BigDecimal targetValue) {
		this.targetValue = targetValue;
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

	public String getCompletionValue() {
		return completionValue;
	}

	public void setCompletionValue(String completionValue) {
		this.completionValue = completionValue;
	}

	public String getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(String completionRate) {
		this.completionRate = completionRate;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getCratUsr() {
		return cratUsr;
	}

	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr;
	}

	public Date getCratDt() {
		return cratDt;
	}

	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}

	public String getMarkFlag() {
		return markFlag;
	}

	public void setMarkFlag(String markFlag) {
		this.markFlag = markFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}