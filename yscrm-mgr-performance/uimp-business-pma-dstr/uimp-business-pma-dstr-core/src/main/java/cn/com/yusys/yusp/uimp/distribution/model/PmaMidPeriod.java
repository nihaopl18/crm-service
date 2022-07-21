package cn.com.yusys.yusp.uimp.distribution.model;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

public class PmaMidPeriod {

    @Id
    @Generated(GenerationType.UUID)
    private String id;

    private String midInfoId;

    private String acctNo;

    private String subAcctNo;

    private String operTime;

    private String effectDate;

    private String expirateDate;

    private String dataSrc;

    private String operUserId;

    private String operOrgId;

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

    private List<PmaMidDistribute> pmaMidDistributeList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMidInfoId() {
        return midInfoId;
    }

    public void setMidInfoId(String midInfoId) {
        this.midInfoId = midInfoId == null ? null : midInfoId.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getSubAcctNo() {
        return subAcctNo;
    }

    public void setSubAcctNo(String subAcctNo) {
        this.subAcctNo = subAcctNo == null ? null : subAcctNo.trim();
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate == null ? null : effectDate.trim();
    }

    public String getExpirateDate() {
        return expirateDate;
    }

    public void setExpirateDate(String expirateDate) {
        this.expirateDate = expirateDate == null ? null : expirateDate.trim();
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc == null ? null : dataSrc.trim();
    }

    public String getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId == null ? null : operUserId.trim();
    }

    public String getOperOrgId() {
        return operOrgId;
    }

    public void setOperOrgId(String operOrgId) {
        this.operOrgId = operOrgId == null ? null : operOrgId.trim();
    }

    public List<PmaMidDistribute> getPmaMidDistributeList() {
        return pmaMidDistributeList;
    }

    public void setPmaMidDistributeList(List<PmaMidDistribute> pmaMidDistributeList) {
        this.pmaMidDistributeList = pmaMidDistributeList;
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