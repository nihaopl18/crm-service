package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author:Mr.raop
 * @create:2022-05-13
 * 贷款账户分配关系表
 */
@Entity
@Table(name = "PMA_F_COM_DEP_LOANS_REL")
public class PmaFComDepLoansRel extends BaseDomain implements Serializable {

    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    private String id;

    /** 区间主键 **/
    @Column(name = "period_id", unique = false, nullable = true, length = 32)
    private String periodId;

    /** 分配类型 **/
    @Column(name = "allot_type", unique = false, nullable = true, length = 2)
    private String allotType ;

    /** 客户经理编号 **/
    @Column(name = "manager_id", unique = false, nullable = true, length = 2)
    private String managerId ;

    /** 业绩比例 **/
    @Column(name = "distr_rate", unique = false, nullable = true, length = 20)
    private String distrRate;

    /** 分配信息ID **/
    @Column(name = "start_amt", unique = false, nullable = true, length = 20)
    private String startAmt ;

    /** 起始金额 **/
    @Column(name = "end_amt", unique = false, nullable = true, length = 20)
    private String endAmt ;

    /** 结束金额 **/
    @Column(name = "creator", unique = false, nullable = true, length = 32)
    private String creator ;

    /** 创建日期 **/
    @Column(name = "create_date", unique = false, nullable = true, length = 32)
    private String createDate  ;

    /** 创建机构 **/
    @Column(name = "create_org", unique = false, nullable = true, length = 32)
    private String createOrg   ;

    /** 修改者ID **/
    @Column(name = "updater_id", unique = false, nullable = true, length = 32)
    private String updaterId   ;

    /** 修改日期 **/
    @Column(name = "update_date", unique = false, nullable = true, length = 32)
    private String updateDate  ;

    /** 修改机构 **/
    @Column(name = "update_org", unique = false, nullable = true, length = 32)
    private String updateOrg   ;

    /** 客户经理名称 **/
    @Column(name = "manager_name", unique = false, nullable = true, length = 50)
    private String managerName   ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getAllotType() {
        return allotType;
    }

    public void setAllotType(String allotType) {
        this.allotType = allotType;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDistrRate() {
        return distrRate;
    }

    public void setDistrRate(String distrRate) {
        this.distrRate = distrRate;
    }

    public String getStartAmt() {
        return startAmt;
    }

    public void setStartAmt(String startAmt) {
        this.startAmt = startAmt;
    }

    public String getEndAmt() {
        return endAmt;
    }

    public void setEndAmt(String endAmt) {
        this.endAmt = endAmt;
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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
