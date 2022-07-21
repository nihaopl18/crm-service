package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.vo;

/**
 * @author sandMan
 * @date 2022/4/7 - 10:27
 */
public class PmaFBaseIndexInfoVO {
        /** ID **/
    private String id;

    /** 基础指标名称 **/
    private String indexName;

    /** 指标归属机构 **/
    private String createOrg;


    /** 业务类型 **/
    private String indexBusinessType;

    /** 创建者ID **/
    private String creator;

    /** 创建时间 **/
    private String createDate;

    /** 修改者ID **/
    private String updaterId;

    /** 修改时间 **/
    private String updateDate;

    /** 基础指标编号 **/
    private String indexId;

    /** 指标类型 **/
    private String indexType;

    /** 修改者机构 **/
    private String updateOrg;

    /** 指标状态(0停用 1启用) **/
    private String indexState;

    /** 指标所属目录ID **/
    private String indexCatalogId;
    /**币种**/
    private String currency;
    /**考核对象类型**/
    private String obj ;

    /**应用类型**/
    private String applyTypeId ;

    /**余额类型**/
    private String yeType ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public String getIndexState() {
        return indexState;
    }

    public void setIndexState(String indexState) {
        this.indexState = indexState;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getApplyTypeId() {
        return applyTypeId;
    }

    public void setApplyTypeId(String applyTypeId) {
        this.applyTypeId = applyTypeId;
    }

    public String getYeType() {
        return yeType;
    }

    public void setYeType(String yeType) {
        this.yeType = yeType;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getIndexBusinessType() {
        return indexBusinessType;
    }

    public void setIndexBusinessType(String indexBusinessType) {
        this.indexBusinessType = indexBusinessType;
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

    public String getIndexCatalogId() {
        return indexCatalogId;
    }

    public void setIndexCatalogId(String indexCatalogId) {
        this.indexCatalogId = indexCatalogId;
    }
}
