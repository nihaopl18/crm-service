package cn.com.yusys.yscimc.operation.domain.vo;

import java.math.BigDecimal;

/**
 * @Author Lenovo
 * @Data 2021/12/16 17:02
 */
public class IndexPlanInfoVo {
    private String assemblyId;
    private String productId;
    private String indexId;
    private String indexName;
    private String objType;
    private String objId;
    private BigDecimal initialValue;
    private BigDecimal targetValue;
    private String completionValue;
    private String completionRate;

    public IndexPlanInfoVo() {
    }

    public String getAssemblyId() {
        return this.assemblyId;
    }

    public void setAssemblyId(String assemblyId) {
        this.assemblyId = assemblyId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getIndexId() {
        return this.indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getObjType() {
        return this.objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjId() {
        return this.objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public BigDecimal getInitialValue() {
        return this.initialValue;
    }

    public void setInitialValue(BigDecimal initialValue) {
        this.initialValue = initialValue;
    }

    public BigDecimal getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(BigDecimal targetValue) {
        this.targetValue = targetValue;
    }

    public String getCompletionValue() {
        return this.completionValue;
    }

    public void setCompletionValue(String completionValue) {
        this.completionValue = completionValue;
    }

    public String getCompletionRate() {
        return this.completionRate;
    }

    public void setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}
