package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author:Mr.raop
 * @create:2022-05-13
 * 贷款账户分配区间表
 */
@Entity
@Table(name = "PMA_F_COM_DEP_LOANS_PERIOD")
public class PmaFComDepLoansPeriod extends BaseDomain implements Serializable {

    @Id
    @Generated(GenerationType.UUID)
    @Column(name = "ID")
    private String id           ;

    /** 分配信息ID **/
    @Column(name = "loans_info_id", unique = false, nullable = true, length = 32)
    private String loansInfoId;

    /** 分配时间 **/
    @Column(name = "oper_time", unique = false, nullable = true, length = 32)
    private String operTime    ;

    /** 起始日期 **/
    @Column(name = "effect_date", unique = false, nullable = true, length = 32)
    private String effectDate  ;

    /** 结束日期 **/
    @Column(name = "expirate_date", unique = false, nullable = true, length = 32)
    private String expirateDate;

    /** 数据来源 **/
    @Column(name = "data_src", unique = false, nullable = true, length = 32)
    private String dataSrc     ;

    /** 操作用户号 **/
    @Column(name = "oper_user_id", unique = false, nullable = true, length = 32)
    private String operUserId ;

    /** 操作机构号 **/
    @Column(name = "oper_org_id", unique = false, nullable = true, length = 32)
    private String operOrgId  ;

    /** 创建者ID **/
    @Column(name = "creator", unique = false, nullable = true, length = 32)
    private String creator      ;

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

    @NotNull
    private List<PmaFComDepLoansRel> pmaFComDepLoansRel;

    public List<PmaFComDepLoansRel> getPmaFComDepLoansRel() {
        return pmaFComDepLoansRel;
    }

    public void setPmaFComDepLoansRel(List<PmaFComDepLoansRel> pmaFComDepLoansRel) {
        this.pmaFComDepLoansRel = pmaFComDepLoansRel;
    }

    /** 分配人 **/
    @Column(name = "oper_user_name", unique = false, nullable = true, length = 50)
    private String operUserName;

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoansInfoId() {
        return loansInfoId;
    }

    public void setLoansInfoId(String loansInfoId) {
        this.loansInfoId = loansInfoId;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }

    public String getExpirateDate() {
        return expirateDate;
    }

    public void setExpirateDate(String expirateDate) {
        this.expirateDate = expirateDate;
    }

    public String getDataSrc() {
        return dataSrc;
    }

    public void setDataSrc(String dataSrc) {
        this.dataSrc = dataSrc;
    }

    public String getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    public String getOperOrgId() {
        return operOrgId;
    }

    public void setOperOrgId(String operOrgId) {
        this.operOrgId = operOrgId;
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
