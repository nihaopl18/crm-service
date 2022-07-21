package cn.com.yusys.yscimc.cust.group.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: CimpCcustgroupCust
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-06 11:26:02
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_C_CUSTGROUP_CUST")
public class CimpCCustgroupCust extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     **/
    @Id
    @Column(name = "ID")
    @Generated(GenerationType.UUID)
    private String id;

    /**
     * 客户群编号
     **/
    @Column(name = "CUST_GROUP_ID", unique = false, nullable = false, length = 32)
    private String custGroupId;

    /**
     * 客户编号
     **/
    @Column(name = "CUST_ID", unique = false, nullable = false, length = 32)
    private String custId;

    /**
     * 最新变更用户
     **/
    @Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
    private String lastChgUsr;

    /**
     * 最新变更时间
     **/
    @Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
    private Date lastChgDt;

    /**
     * 创建人编号
     **/
    @Column(name = "CREATOR_ID", unique = false, nullable = true, length = 32)
    private String creatorId;

    /**
     * 创建时间
     **/
    @Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
    private Date createDate;

    /**
     * 个人营销产品
     **/
    @Column(name = "MARKE_PRO_PRI", unique = false, nullable = true, length = 200)
    private String markeProPri;


    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return Id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param custGroupId
     */
    public void setCustGroupId(String custGroupId) {
        this.custGroupId = custGroupId == null ? null : custGroupId.trim();
    }

    /**
     * @return CustGroupId
     */
    public String getCustGroupId() {
        return this.custGroupId;
    }

    /**
     * @param custId
     */
    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    /**
     * @return CustId
     */
    public String getCustId() {
        return this.custId;
    }

    /**
     * @param lastChgUsr
     */
    public void setLastChgUsr(String lastChgUsr) {
        this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
    }

    /**
     * @return LastChgUsr
     */
    public String getLastChgUsr() {
        return this.lastChgUsr;
    }

    /**
     * @param lastChgDt
     */
    public void setLastChgDt(Date lastChgDt) {
        this.lastChgDt = lastChgDt;
    }

    /**
     * @return LastChgDt
     */
    public Date getLastChgDt() {
        return this.lastChgDt;
    }

    /**
     * @param creatorId
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * @return CreatorId
     */
    public String getCreatorId() {
        return this.creatorId;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return CreateDate
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * @param markeProPri
     */
    public void setMarkeProPri(String markeProPri) {
        this.markeProPri = markeProPri == null ? null : markeProPri.trim();
    }

    /**
     * @return MarkeProPri
     */
    public String getMarkeProPri() {
        return this.markeProPri;
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
        CimpCCustgroupCust other = (CimpCCustgroupCust) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCustGroupId() == null ? other.getCustGroupId() == null : this.getCustGroupId().equals(other.getCustGroupId()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
                && (this.getMarkeProPri() == null ? other.getMarkeProPri() == null : this.getMarkeProPri().equals(other.getMarkeProPri()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustGroupId() == null) ? 0 : getCustGroupId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getMarkeProPri() == null) ? 0 : getMarkeProPri().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", custGroupId=").append(custGroupId);
        sb.append(", custId=").append(custId);
        sb.append(", lastChgUsr=").append(lastChgUsr);
        sb.append(", lastChgDt=").append(lastChgDt);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", markeProPri=").append(markeProPri);
        sb.append("]");
        return sb.toString();
    }
}