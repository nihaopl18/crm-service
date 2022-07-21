package cn.com.yusys.climp.qypool.domain;

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

@Entity
@Table(name = "LOY_QY_COMM_MODEL_STORAGE")
public class LoyQyCommModelStorage  extends BaseDomain implements Serializable {
    /** 主键 **/
    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID", unique = true, nullable = false, length = 50)
    private String id;

    /** 商品Id **/
    @Column(name = "COMM_ID", unique = false, nullable = false, length = 50)
    private String commId;

    /** 规格ID **/
    @Column(name = "MODEL_ID", unique = false, nullable = false, length = 50)
    private String modelId;

    /** 备注 **/
    @Column(name = "REMARK", unique = false, nullable = true, length = 3000)
    private String remark;

    /** 变化值 **/
    @Column(name = "MG_COUNT", unique = false, nullable = true, length = 20)
    private java.math.BigDecimal mgCount;

    /** 变化方向 **/
    @Column(name = "STORAGE_MG_TYPE", unique = false, nullable = true, length = 4)
    private String storageMgType;

    /** 修改人 **/
    @Column(name = "UPDATE_USER", unique = false, nullable = true, length = 50)
    private String updateUser;

    /** 修改时间 **/
    @Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
    private Date updateDate;

    /** 修改机构 **/
    @Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 50)
    private String updateOrg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getMgCount() {
        return mgCount;
    }

    public void setMgCount(BigDecimal mgCount) {
        this.mgCount = mgCount;
    }

    public String getStorageMgType() {
        return storageMgType;
    }

    public void setStorageMgType(String storageMgType) {
        this.storageMgType = storageMgType;
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
}
