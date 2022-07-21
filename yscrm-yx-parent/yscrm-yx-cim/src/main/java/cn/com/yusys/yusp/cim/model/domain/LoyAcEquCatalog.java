package cn.com.yusys.yusp.cim.model.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcEquAccount
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-06-04 15:05:21
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_AC_EQU_CATALOG")
public class LoyAcEquCatalog extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 目录编号
     **/
    @Column(name = "CATALOG_ID", unique = false, nullable = true, length = 32)
    private String catalogId;

    /**
     * 法人机构
     **/
    @Column(name = "CORP_ORG", unique = false, nullable = true, length = 32)
    private String corpOrg;

    /**
     * 目录名称
     **/
    @Column(name = "CATALOG_NAME", unique = false, nullable = true, length = 200)
    private String catalogName;

    /**
     * 目录顺序
     **/
    @Column(name = "CATALOG_ORDER", unique = false, nullable = true, length = 32)
    private String catalogOrder;

    /**
     * 上级目录编号
     **/
    @Column(name = "SUP_CATALOG_ID", unique = false, nullable = true, length = 32)
    private String supCatalogId;

    /**
     * 上级目录名称
     **/
    @Column(name = "SUP_CATALOG_NAME", unique = false, nullable = true, length = 200)
    private String supCatalogName;

    /**
     * 创建人
     **/
    @Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
    private String createUser;

    /**
     * 创建日期
     **/
    @Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
    private Date createDate;

    /**
     * 创建机构
     **/
    @Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
    private String createOrg;

    /**
     * 最近修改人
     **/
    @Column(name = "UPDATE_USER", unique = false, nullable = true, length = 32)
    private String updateUser;

    /**
     * 最近修改时间
     **/
    @Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
    private Date updateDate;

    /**
     * 最近修改机构
     **/
    @Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 32)
    private String updateOrg;

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCorpOrg() {
        return corpOrg;
    }

    public void setCorpOrg(String corpOrg) {
        this.corpOrg = corpOrg;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogOrder() {
        return catalogOrder;
    }

    public void setCatalogOrder(String catalogOrder) {
        this.catalogOrder = catalogOrder;
    }

    public String getSupCatalogId() {
        return supCatalogId;
    }

    public void setSupCatalogId(String supCatalogId) {
        this.supCatalogId = supCatalogId;
    }

    public String getSupCatalogName() {
        return supCatalogName;
    }

    public void setSupCatalogName(String supCatalogName) {
        this.supCatalogName = supCatalogName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateOrg() {
        return updateOrg;
    }

    public void setUpdateOrg(String updateOrg) {
        this.updateOrg = updateOrg;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LoyAcEquCatalog other = (LoyAcEquCatalog) that;
        return (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
                && (this.getCatalogName() == null ? other.getCatalogName() == null : this.getCatalogName().equals(other.getCatalogName()))
                && (this.getCatalogOrder() == null ? other.getCatalogOrder() == null : this.getCatalogOrder().equals(other.getCatalogOrder()))
                && (this.getCorpOrg() == null ? other.getCorpOrg() == null : this.getCorpOrg().equals(other.getCorpOrg()))
                && (this.getSupCatalogId() == null ? other.getSupCatalogId() == null : this.getSupCatalogId().equals(other.getSupCatalogId()))
                && (this.getSupCatalogName() == null ? other.getSupCatalogName() == null : this.getSupCatalogName().equals(other.getSupCatalogName()))
                && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                && (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
                && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                && (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getSupCatalogName() == null) ? 0 : getSupCatalogName().hashCode());
        result = prime * result + ((getSupCatalogId() == null) ? 0 : getSupCatalogId().hashCode());
        result = prime * result + ((getCatalogName() == null) ? 0 : getCatalogName().hashCode());
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", createOrg=").append(createOrg);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateOrg=").append(updateOrg);
        sb.append(", catalogId=").append(catalogId);
        sb.append(", catalogName=").append(catalogName);
        sb.append(", supCatalogId=").append(supCatalogId);
        sb.append(", supCatalogName=").append(supCatalogName);
        sb.append("]");
        return sb.toString();
    }
}
