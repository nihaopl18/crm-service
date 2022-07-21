package cn.com.yusys.yusp.uimp.distribution.model;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Id;

public class PmaMidDistribute {

    @Id
    @Generated(GenerationType.UUID)
    private String id;

    private String midInfoId;

    private String allotType;

    private String managerId;

    private String managerName;

    private String distrRate;

    private String startAmt;

    private String endAmt;

    /** 创建者ID **/
    private String creator      ;

    /** 创建日期 **/
    private String createDate  ;

    /** 创建机构 **/
    private String createOrg   ;

    /** 修改者ID **/
    private String updaterId   ;

    /** 修改日期 **/
    private String updateDate  ;

    /** 修改机构 **/
    private String updateOrg   ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAllotType() {
        return allotType;
    }

    public void setAllotType(String allotType) {
        this.allotType = allotType == null ? null : allotType.trim();
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId == null ? null : managerId.trim();
    }

    public String getDistrRate() {
        return distrRate;
    }

    public void setDistrRate(String distrRate) {
        this.distrRate = distrRate == null ? null : distrRate.trim();
    }

    public String getStartAmt() {
        return startAmt;
    }

    public void setStartAmt(String startAmt) {
        this.startAmt = startAmt == null ? null : startAmt.trim();
    }

    public String getEndAmt() {
        return endAmt;
    }

    public void setEndAmt(String endAmt) {
        this.endAmt = endAmt == null ? null : endAmt.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getMidInfoId() {
        return midInfoId;
    }

    public void setMidInfoId(String midInfoId) {
        this.midInfoId = midInfoId;
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