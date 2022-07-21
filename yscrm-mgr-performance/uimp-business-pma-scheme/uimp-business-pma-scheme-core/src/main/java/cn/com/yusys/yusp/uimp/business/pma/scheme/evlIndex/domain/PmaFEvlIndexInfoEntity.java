package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain;


import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 派生指标信息表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-05-06 14:47:49
 */
@Table(name = "PMA_F_EVL_INDEX_INFO")
public class PmaFEvlIndexInfoEntity extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @Generated()
    private String id;
    /**
     * 派生指标编号
     */
    private String indexId;
    /**
     * 派生指标名称
     */
    private String indexName;
    /**
     * 指标归属机构
     */
    private String orgId;
    /**
     * 描述
     */
    private String remark;
    /**
     * 考核对象类型
     */
    private String objType;
    /**
     * 评价指标计算公式
     */
    private String formula;
    /**
     * 评价指标计算公式描述
     */
    private String formulaNotes;
    /**
     * 度量类型
     */
    private String metricType;
    /**
     * 作用域机构
     */
    private String scopeOrgId;
    /**
     * 数据删除标志
     */
    private String statFlag;
    /**
     * 业务条线编号
     */
    private String bussSysNo;
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

    /*
     * 启停用标志
     * */
    private String indexState;

    public String getIndexState() {
        return indexState;
    }

    public void setIndexState(String indexState) {
        this.indexState = indexState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getFormulaNotes() {
        return formulaNotes;
    }

    public void setFormulaNotes(String formulaNotes) {
        this.formulaNotes = formulaNotes;
    }

    public String getMetricType() {
        return metricType;
    }

    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public String getScopeOrgId() {
        return scopeOrgId;
    }

    public void setScopeOrgId(String scopeOrgId) {
        this.scopeOrgId = scopeOrgId;
    }

    public String getStatFlag() {
        return statFlag;
    }

    public void setStatFlag(String statFlag) {
        this.statFlag = statFlag;
    }

    public String getBussSysNo() {
        return bussSysNo;
    }

    public void setBussSysNo(String bussSysNo) {
        this.bussSysNo = bussSysNo;
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
