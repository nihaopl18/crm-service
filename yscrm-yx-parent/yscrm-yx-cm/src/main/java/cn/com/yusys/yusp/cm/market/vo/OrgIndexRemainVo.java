package cn.com.yusys.yusp.cm.market.vo;

import java.math.BigDecimal;

public class OrgIndexRemainVo {
    private String indexId;
    private String indexName;
    private String sort;
    private String nodeId;
    private BigDecimal indexRemain;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public BigDecimal getIndexRemain() {
        return indexRemain;
    }

    public void setIndexRemain(BigDecimal indexRemain) {
        this.indexRemain = indexRemain;
    }

    public String getIndexId() {
        return indexId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
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
}
