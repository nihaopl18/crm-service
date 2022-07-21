package cn.com.yusys.yscimc.operation.domain.vo;

import cn.com.yusys.yscimc.operation.annotation.Keyword;

import java.util.Objects;

/**
 * 处理器查询出的客户信息
 * @author zhangyt12
 * @date 2021/12/17 16:17
 */
public class CustomerInfoVo {

    @Keyword(alias = "@CUST_ID@")//客户编号
    private String custId;

    @Keyword(alias = "@CUST_TYPE@")//客户类型
    private String custType;

//    @Keyword(alias = "IDENT_TYPE")//证件类型
//    private String identType;

    @Keyword(alias = "@IDENT_NO@")//证件号码
    private String identNo;

    @Keyword(alias = "@CUST_NAME@")//客户名称
    private String custName;

    @Keyword(alias = "SHORT_NAME")//客户简称
    private String shortName;
//
//    @Keyword(alias = "EN_NAME")//英文名称
//    private String enName;
//
//    @Keyword(alias = "EN_SHORT_NAME")//英文简称
//    private String enShortName;

    @Keyword(alias = "@CUST_STAT@")//客户状态
    private String custStat;

    @Keyword(alias = "@POTENTIAL_FLAG@")//潜在客户标识
    private String potentialFlag;

    @Keyword(alias = "@MERGE_FLAG@")//客户合并标志
    private String mergeFlag;

    @Keyword(alias = "@CUST_LEVEL@")//客户级别
    private String custLevel;

    @Keyword(alias = "@CORE_NO@")//核心客户号
    private String coreNo;

    @Keyword(alias = "@SOURCE_CHANNEL@")//客户来源渠道
    private String sourceChannel;

//    @Keyword(alias = "CREATE_DATE")//客户创建日期
//    private String createDate;
//
//    @Keyword(alias = "CREATE_TIME")//客户创建时间
//    private String createTime;

    @Keyword(alias = "@CREATE_TELLER_NO@")//客户创建柜员编号
    private String createTellerNo;

//    @Keyword(alias = "LAST_UPDATE_SYS")//最后更新系统
//    private String lastUpdateSys;
//
//    @Keyword(alias = "LAST_UPDATE_USER")//最后更新人
//    private String lastUpdateUser;
//
//    @Keyword(alias = "LAST_UPDATE_TM")//最后更新时间
//    private String lastUpdateTm;

    @Keyword(alias = "@CONTACT_NUMBER@")//联系方式
    private String contactNumber;

    @Keyword(alias = "@BELONG_ORG@")//归属机构
    private String belongOrg;

    @Keyword(alias = "@BELONG_MGR@")//归属客户经理
    private String belongMgr;

    @Keyword(alias = "@RISK_LEVEL@")//客户风险偏好等级
    private String riskLevel;

    @Keyword(alias = "@WORTH_LEVEL@")//客户价值等级
    private String worthLevel;

    @Keyword(alias = "@SERVICE_LEVEL@")//客户服务等级
    private String serviceLevel;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getIdentNo() {
        return identNo;
    }

    public void setIdentNo(String identNo) {
        this.identNo = identNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustStat() {
        return custStat;
    }

    public void setCustStat(String custStat) {
        this.custStat = custStat;
    }

    public String getPotentialFlag() {
        return potentialFlag;
    }

    public void setPotentialFlag(String potentialFlag) {
        this.potentialFlag = potentialFlag;
    }

    public String getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(String mergeFlag) {
        this.mergeFlag = mergeFlag;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCoreNo() {
        return coreNo;
    }

    public void setCoreNo(String coreNo) {
        this.coreNo = coreNo;
    }

    public String getSourceChannel() {
        return sourceChannel;
    }

    public void setSourceChannel(String sourceChannel) {
        this.sourceChannel = sourceChannel;
    }

    public String getCreateTellerNo() {
        return createTellerNo;
    }

    public void setCreateTellerNo(String createTellerNo) {
        this.createTellerNo = createTellerNo;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBelongOrg() {
        return belongOrg;
    }

    public void setBelongOrg(String belongOrg) {
        this.belongOrg = belongOrg;
    }

    public String getBelongMgr() {
        return belongMgr;
    }

    public void setBelongMgr(String belongMgr) {
        this.belongMgr = belongMgr;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getWorthLevel() {
        return worthLevel;
    }

    public void setWorthLevel(String worthLevel) {
        this.worthLevel = worthLevel;
    }

    public String getServiceLevel() {
        return serviceLevel;
    }

    public void setServiceLevel(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfoVo that = (CustomerInfoVo) o;
        return Objects.equals(custId, that.custId) &&
                Objects.equals(custType, that.custType) &&
                Objects.equals(identNo, that.identNo) &&
                Objects.equals(custName, that.custName) &&
                Objects.equals(shortName, that.shortName) &&
                Objects.equals(custStat, that.custStat) &&
                Objects.equals(potentialFlag, that.potentialFlag) &&
                Objects.equals(mergeFlag, that.mergeFlag) &&
                Objects.equals(custLevel, that.custLevel) &&
                Objects.equals(coreNo, that.coreNo) &&
                Objects.equals(sourceChannel, that.sourceChannel) &&
                Objects.equals(createTellerNo, that.createTellerNo) &&
                Objects.equals(contactNumber, that.contactNumber) &&
                Objects.equals(belongOrg, that.belongOrg) &&
                Objects.equals(belongMgr, that.belongMgr) &&
                Objects.equals(riskLevel, that.riskLevel) &&
                Objects.equals(worthLevel, that.worthLevel) &&
                Objects.equals(serviceLevel, that.serviceLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId);
    }
}
