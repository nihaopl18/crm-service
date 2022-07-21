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
 * @类名称: CimpCcgBaseinfo
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-06 11:25:18
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_C_CG_BASEINFO")
public class CimpCCgBaseinfo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 客户群编号
     **/
    @Id
    @Column(name = "CUST_GROUP_ID")
    @Generated(GenerationType.UUID)
    private String custGroupId;

    /**
     * 客户群名称
     **/
    @Column(name = "CUST_GROUP_NAME", unique = false, nullable = false, length = 50)
    private String custGroupName;

    /**
     * 客户来源
     **/
    @Column(name = "CUST_ORIGIN", unique = false, nullable = false, length = 32)
    private String custOrigin;

    /**
     * 客户群类型
     **/
    @Column(name = "CUST_GROUP_TYPE", unique = false, nullable = true, length = 32)
    private String custGroupType;

    /**
     * 成员数
     **/
    @Column(name = "CUST_NUM", unique = false, nullable = true, length = 20)
    private String custNum;

    /**
     * 创建机构
     **/
    @Column(name = "CREATE_ORGAN", unique = false, nullable = true, length = 50)
    private String createOrgan;

    /**
     * 创建人
     **/
    @Column(name = "CREATOR_ID", unique = false, nullable = true, length = 32)
    private String creatorId;

    /**
     * 创建时间
     **/
    @Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
    private Date createDate;

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
     * 客户群描述
     **/
    @Column(name = "REMARK", unique = false, nullable = true, length = 200)
    private String remark;

    /**
     * 表格名称
     **/
    @Column(name = "FORM_NAME", unique = false, nullable = true, length = 200)
    private String formName;

    /**
     * SQL
     **/
    @Column(name = "SQL", unique = false, nullable = true, length = 4000)
    private String sql;

    /**
     * 营销产品
     **/
    @Column(name = "MARKE_PRO", unique = false, nullable = true, length = 200)
    private String markePro;

    /**
     * 群成员类型
     **/
    @Column(name = "GROUP_MEMBER_TYPE", unique = false, nullable = true, length = 32)
    private String groupMemberType;

    /**
     * 保存方案ID
     **/
    @Column(name = "SS_ID", unique = false, nullable = true, length = 32)
    private String ssId;


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
     * @param custGroupName
     */
    public void setCustGroupName(String custGroupName) {
        this.custGroupName = custGroupName == null ? null : custGroupName.trim();
    }

    /**
     * @return CustGroupName
     */
    public String getCustGroupName() {
        return this.custGroupName;
    }

    /**
     * @param custOrigin
     */
    public void setCustOrigin(String custOrigin) {
        this.custOrigin = custOrigin == null ? null : custOrigin.trim();
    }

    /**
     * @return CustOrigin
     */
    public String getCustOrigin() {
        return this.custOrigin;
    }

    /**
     * @param custGroupType
     */
    public void setCustGroupType(String custGroupType) {
        this.custGroupType = custGroupType == null ? null : custGroupType.trim();
    }

    /**
     * @return CustGroupType
     */
    public String getCustGroupType() {
        return this.custGroupType;
    }

    /**
     * @param custNum
     */
    public void setCustNum(String custNum) {
        this.custNum = custNum == null ? null : custNum.trim();
    }

    /**
     * @return CustNum
     */
    public String getCustNum() {
        return this.custNum;
    }

    /**
     * @param createOrgan
     */
    public void setCreateOrgan(String createOrgan) {
        this.createOrgan = createOrgan == null ? null : createOrgan.trim();
    }

    /**
     * @return CreateOrgan
     */
    public String getCreateOrgan() {
        return this.createOrgan;
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
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return Remark
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * @param formName
     */
    public void setFormName(String formName) {
        this.formName = formName == null ? null : formName.trim();
    }

    /**
     * @return FormName
     */
    public String getFormName() {
        return this.formName;
    }

    /**
     * @param sql
     */
    public void setSql(String sql) {
        this.sql = sql == null ? null : sql.trim();
    }

    /**
     * @return Sql
     */
    public String getSql() {
        return this.sql;
    }

    /**
     * @param markePro
     */
    public void setMarkePro(String markePro) {
        this.markePro = markePro == null ? null : markePro.trim();
    }

    /**
     * @return MarkePro
     */
    public String getMarkePro() {
        return this.markePro;
    }

    /**
     * @param groupMemberType
     */
    public void setGroupMemberType(String groupMemberType) {
        this.groupMemberType = groupMemberType == null ? null : groupMemberType.trim();
    }

    /**
     * @return GroupMemberType
     */
    public String getGroupMemberType() {
        return this.groupMemberType;
    }

    /**
     * @param ssId
     */
    public void setSsId(String ssId) {
        this.ssId = ssId == null ? null : ssId.trim();
    }

    /**
     * @return SsId
     */
    public String getSsId() {
        return this.ssId;
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
        CimpCCgBaseinfo other = (CimpCCgBaseinfo) that;
        return (this.getCustGroupId() == null ? other.getCustGroupId() == null : this.getCustGroupId().equals(other.getCustGroupId()))
                && (this.getCustGroupName() == null ? other.getCustGroupName() == null : this.getCustGroupName().equals(other.getCustGroupName()))
                && (this.getCustOrigin() == null ? other.getCustOrigin() == null : this.getCustOrigin().equals(other.getCustOrigin()))
                && (this.getCustGroupType() == null ? other.getCustGroupType() == null : this.getCustGroupType().equals(other.getCustGroupType()))
                && (this.getCustNum() == null ? other.getCustNum() == null : this.getCustNum().equals(other.getCustNum()))
                && (this.getCreateOrgan() == null ? other.getCreateOrgan() == null : this.getCreateOrgan().equals(other.getCreateOrgan()))
                && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
                && (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getFormName() == null ? other.getFormName() == null : this.getFormName().equals(other.getFormName()))
                && (this.getSql() == null ? other.getSql() == null : this.getSql().equals(other.getSql()))
                && (this.getMarkePro() == null ? other.getMarkePro() == null : this.getMarkePro().equals(other.getMarkePro()))
                && (this.getGroupMemberType() == null ? other.getGroupMemberType() == null : this.getGroupMemberType().equals(other.getGroupMemberType()))
                && (this.getSsId() == null ? other.getSsId() == null : this.getSsId().equals(other.getSsId()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustGroupId() == null) ? 0 : getCustGroupId().hashCode());
        result = prime * result + ((getCustGroupName() == null) ? 0 : getCustGroupName().hashCode());
        result = prime * result + ((getCustOrigin() == null) ? 0 : getCustOrigin().hashCode());
        result = prime * result + ((getCustGroupType() == null) ? 0 : getCustGroupType().hashCode());
        result = prime * result + ((getCustNum() == null) ? 0 : getCustNum().hashCode());
        result = prime * result + ((getCreateOrgan() == null) ? 0 : getCreateOrgan().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getFormName() == null) ? 0 : getFormName().hashCode());
        result = prime * result + ((getSql() == null) ? 0 : getSql().hashCode());
        result = prime * result + ((getMarkePro() == null) ? 0 : getMarkePro().hashCode());
        result = prime * result + ((getGroupMemberType() == null) ? 0 : getGroupMemberType().hashCode());
        result = prime * result + ((getSsId() == null) ? 0 : getSsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", custGroupId=").append(custGroupId);
        sb.append(", custGroupName=").append(custGroupName);
        sb.append(", custOrigin=").append(custOrigin);
        sb.append(", custGroupType=").append(custGroupType);
        sb.append(", custNum=").append(custNum);
        sb.append(", createOrgan=").append(createOrgan);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastChgUsr=").append(lastChgUsr);
        sb.append(", lastChgDt=").append(lastChgDt);
        sb.append(", remark=").append(remark);
        sb.append(", formName=").append(formName);
        sb.append(", sql=").append(sql);
        sb.append(", markePro=").append(markePro);
        sb.append(", groupMemberType=").append(groupMemberType);
        sb.append(", ssId=").append(ssId);
        sb.append("]");
        return sb.toString();
    }
}