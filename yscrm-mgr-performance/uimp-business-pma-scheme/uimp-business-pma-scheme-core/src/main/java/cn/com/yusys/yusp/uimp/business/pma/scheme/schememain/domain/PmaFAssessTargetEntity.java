package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 考核目标下发表;考核目标下发表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-05-19 17:41:11
 */
@Data
@Table(name = "PMA_F_ASSESS_TARGET")
public class PmaFAssessTargetEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @Generated(GenerationType.UUID)
    private String id;
    /**
     * 年份
     */
    private String years;
    /**
     * 考核方案ID
     */
    private String schemeId;
    /**
     * 考核方案名称
     */
    private String schemeName;
    /**
     * 考核对象ID
     */
    private String evlObjId;
    /**
     * 考核对象名称
     */
    private String evlObjName;
    /**
     * 指标编号
     */
    private String indexId;
    /**
     * 指标名称
     */
    private String indexName;
    /**
     * 考核周期类型
     */
    private String schemeCycleType;
    /**
     * 考核对象类型
     */
    private String evlObjType;
    /**
     * 任务值（年）;任务值（年），考核周期为年时适用
     */
    private BigDecimal yearValue;
    /**
     * 任务值（上半年）
     */
    private BigDecimal fhyValue;
    /**
     * 任务值（下半年）
     */
    private BigDecimal shyValue;
    /**
     * 任务值（第一季度）
     */
    private BigDecimal q1Value;
    /**
     * 任务值（第二季度）
     */
    private BigDecimal q2Value;
    /**
     * 任务值（第三季度）
     */
    private BigDecimal q3Value;
    /**
     * 任务值（第四季度）
     */
    private BigDecimal q4Value;
    /**
     * 任务值（一月）
     */
    private BigDecimal m1Value;
    /**
     * 任务值（二月）
     */
    private BigDecimal m2Value;
    /**
     * 任务值（三月）
     */
    private BigDecimal m3Value;
    /**
     * 任务值（四月）
     */
    private BigDecimal m4Value;
    /**
     * 任务值（五月）
     */
    private BigDecimal m5Value;
    /**
     * 任务值（六月）
     */
    private BigDecimal m6Value;
    /**
     * 任务值（七月）
     */
    private BigDecimal m7Value;
    /**
     * 任务值（八月）
     */
    private BigDecimal m8Value;
    /**
     * 任务值（九月）
     */
    private BigDecimal m9Value;
    /**
     * 任务值（十月）
     */
    private BigDecimal m10Value;
    /**
     * 任务值（十一月）
     */
    private BigDecimal m11Value;
    /**
     * 任务值（十二月）
     */
    private BigDecimal m12Value;
    /**
     * 创建者ID
     */
    private String creator;
    /**
     * 创建日期
     */
    private String createDate;
    /**
     * 创建机构
     */
    private String createOrg;
    /**
     * 修改者ID
     */
    private String updaterId;
    /**
     * 修改日期
     */
    private String updateDate;
    /**
     * 修改机构
     */
    private String updateOrg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getEvlObjId() {
        return evlObjId;
    }

    public void setEvlObjId(String evlObjId) {
        this.evlObjId = evlObjId;
    }

    public String getEvlObjName() {
        return evlObjName;
    }

    public void setEvlObjName(String evlObjName) {
        this.evlObjName = evlObjName;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getSchemeCycleType() {
        return schemeCycleType;
    }

    public void setSchemeCycleType(String schemeCycleType) {
        this.schemeCycleType = schemeCycleType;
    }

    public String getEvlObjType() {
        return evlObjType;
    }

    public void setEvlObjType(String evlObjType) {
        this.evlObjType = evlObjType;
    }

    public BigDecimal getYearValue() {
        return yearValue;
    }

    public void setYearValue(BigDecimal yearValue) {
        this.yearValue = yearValue;
    }

    public BigDecimal getFhyValue() {
        return fhyValue;
    }

    public void setFhyValue(BigDecimal fhyValue) {
        this.fhyValue = fhyValue;
    }

    public BigDecimal getShyValue() {
        return shyValue;
    }

    public void setShyValue(BigDecimal shyValue) {
        this.shyValue = shyValue;
    }

    public BigDecimal getQ1Value() {
        return q1Value;
    }

    public void setQ1Value(BigDecimal q1Value) {
        this.q1Value = q1Value;
    }

    public BigDecimal getQ2Value() {
        return q2Value;
    }

    public void setQ2Value(BigDecimal q2Value) {
        this.q2Value = q2Value;
    }

    public BigDecimal getQ3Value() {
        return q3Value;
    }

    public void setQ3Value(BigDecimal q3Value) {
        this.q3Value = q3Value;
    }

    public BigDecimal getQ4Value() {
        return q4Value;
    }

    public void setQ4Value(BigDecimal q4Value) {
        this.q4Value = q4Value;
    }

    public BigDecimal getM1Value() {
        return m1Value;
    }

    public void setM1Value(BigDecimal m1Value) {
        this.m1Value = m1Value;
    }

    public BigDecimal getM2Value() {
        return m2Value;
    }

    public void setM2Value(BigDecimal m2Value) {
        this.m2Value = m2Value;
    }

    public BigDecimal getM3Value() {
        return m3Value;
    }

    public void setM3Value(BigDecimal m3Value) {
        this.m3Value = m3Value;
    }

    public BigDecimal getM4Value() {
        return m4Value;
    }

    public void setM4Value(BigDecimal m4Value) {
        this.m4Value = m4Value;
    }

    public BigDecimal getM5Value() {
        return m5Value;
    }

    public void setM5Value(BigDecimal m5Value) {
        this.m5Value = m5Value;
    }

    public BigDecimal getM6Value() {
        return m6Value;
    }

    public void setM6Value(BigDecimal m6Value) {
        this.m6Value = m6Value;
    }

    public BigDecimal getM7Value() {
        return m7Value;
    }

    public void setM7Value(BigDecimal m7Value) {
        this.m7Value = m7Value;
    }

    public BigDecimal getM8Value() {
        return m8Value;
    }

    public void setM8Value(BigDecimal m8Value) {
        this.m8Value = m8Value;
    }

    public BigDecimal getM9Value() {
        return m9Value;
    }

    public void setM9Value(BigDecimal m9Value) {
        this.m9Value = m9Value;
    }

    public BigDecimal getM10Value() {
        return m10Value;
    }

    public void setM10Value(BigDecimal m10Value) {
        this.m10Value = m10Value;
    }

    public BigDecimal getM11Value() {
        return m11Value;
    }

    public void setM11Value(BigDecimal m11Value) {
        this.m11Value = m11Value;
    }

    public BigDecimal getM12Value() {
        return m12Value;
    }

    public void setM12Value(BigDecimal m12Value) {
        this.m12Value = m12Value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOrg() {
        return updateOrg;
    }

    public void setUpdateOrg(String updateOrg) {
        this.updateOrg = updateOrg;
    }
}
