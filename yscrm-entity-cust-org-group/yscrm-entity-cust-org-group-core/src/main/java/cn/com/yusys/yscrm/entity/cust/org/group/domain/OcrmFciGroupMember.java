package cn.com.yusys.yscrm.entity.cust.org.group.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupMember
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-19 14:23:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_GROUP_MEMBER")
public class OcrmFciGroupMember extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** GROUP_NO **/
	@Column(name = "GROUP_NO", unique = false, nullable = false, length = 20)
	private String groupNo;
	
	/** CUST_ID **/
	@Column(name = "CUST_ID", unique = false, nullable = false, length = 40)
	private String custId;
	
	/** CUST_NAME **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** REMARK **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	/** STOCK_RATE **/
	@Column(name = "STOCK_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal stockRate;
	
	/** MEMBER_TYPE **/
	@Column(name = "MEMBER_TYPE", unique = false, nullable = true, length = 20)
	private String memberType;
	
	/** CROP_CODE **/
	@Column(name = "CROP_CODE", unique = false, nullable = true, length = 40)
	private String cropCode;
	
	/** CORP_NAME_UP **/
	@Column(name = "CORP_NAME_UP", unique = false, nullable = true, length = 80)
	private String corpNameUp;
	
	/** CUST_STAT **/
	@Column(name = "CUST_STAT", unique = false, nullable = true, length = 20)
	private String custStat;
	
	/** INDUSTRY **/
	@Column(name = "INDUSTRY", unique = false, nullable = true, length = 20)
	private String industry;
	
	/** CUST_SCALE **/
	@Column(name = "CUST_SCALE", unique = false, nullable = true, length = 10)
	private long custScale;
	
	/** CUST_SCALE_CHECK **/
	@Column(name = "CUST_SCALE_CHECK", unique = false, nullable = true, length = 10)
	private long custScaleCheck;
	
	/** TAX_CERT_NO **/
	@Column(name = "TAX_CERT_NO", unique = false, nullable = true, length = 40)
	private String taxCertNo;
	
	/** LICENSE_NO **/
	@Column(name = "LICENSE_NO", unique = false, nullable = true, length = 40)
	private String licenseNo;
	
	/** RELATIONSHIP_UP **/
	@Column(name = "RELATIONSHIP_UP", unique = false, nullable = true, length = 20)
	private String relationshipUp;
	
	/** MEMBER_SHIP **/
	@Column(name = "MEMBER_SHIP", unique = false, nullable = true, length = 20)
	private String memberShip;
	
	/** CORE_CUST_NO **/
	@Column(name = "CORE_CUST_NO", unique = false, nullable = true, length = 20)
	private String coreCustNo;
	
	/** MAIN_BR_ID **/
	@Column(name = "MAIN_BR_ID", unique = false, nullable = true, length = 20)
	private String mainBrId;
	
	/** CUS_MANAGER **/
	@Column(name = "CUS_MANAGER", unique = false, nullable = true, length = 20)
	private String cusManager;
	
	/** "集团关联关系类型
" **/
	@Column(name = "GRP_CORRE_TYPE", unique = false, nullable = true, length = 20)
	private String grpCorreType;
	
	/** "集团关联关系描述
" **/
	@Column(name = "GRP_CORRE_DETAIL", unique = false, nullable = true, length = 200)
	private String grpCorreDetail;
	
	/** "登记人
" **/
	@Column(name = "INPUT_USER_ID", unique = false, nullable = true, length = 20)
	private String inputUserId;
	
	/** "登记日期
" **/
	@Transient
	@Column(name = "INPUT_DATE", unique = false, nullable = true, length = 7)
	private Date inputDate;
	
	/** "登记机构
" **/
	@Column(name = "INPUT_BR_ID", unique = false, nullable = true, length = 80)
	private String inputBrId;
	
	/** ETL_DATE **/
	@Transient
	@Column(name = "ETL_DATE", unique = false, nullable = true, length = 7)
	private Date etlDate;
	
	
	/**
	 * @param groupNo
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo == null ? null : groupNo.trim();
	}
	
    /**
     * @return GroupNo
     */	
	public String getGroupNo() {
		return this.groupNo;
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
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}
	
    /**
     * @return CustName
     */	
	public String getCustName() {
		return this.custName;
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
	 * @param stockRate
	 */
	public void setStockRate(java.math.BigDecimal stockRate) {
		this.stockRate = stockRate;
	}
	
    /**
     * @return StockRate
     */	
	public java.math.BigDecimal getStockRate() {
		return this.stockRate;
	}
	
	/**
	 * @param memberType
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType == null ? null : memberType.trim();
	}
	
    /**
     * @return MemberType
     */	
	public String getMemberType() {
		return this.memberType;
	}
	
	/**
	 * @param cropCode
	 */
	public void setCropCode(String cropCode) {
		this.cropCode = cropCode == null ? null : cropCode.trim();
	}
	
    /**
     * @return CropCode
     */	
	public String getCropCode() {
		return this.cropCode;
	}
	
	/**
	 * @param corpNameUp
	 */
	public void setCorpNameUp(String corpNameUp) {
		this.corpNameUp = corpNameUp == null ? null : corpNameUp.trim();
	}
	
    /**
     * @return CorpNameUp
     */	
	public String getCorpNameUp() {
		return this.corpNameUp;
	}
	
	/**
	 * @param custStat
	 */
	public void setCustStat(String custStat) {
		this.custStat = custStat == null ? null : custStat.trim();
	}
	
    /**
     * @return CustStat
     */	
	public String getCustStat() {
		return this.custStat;
	}
	
	/**
	 * @param industry
	 */
	public void setIndustry(String industry) {
		this.industry = industry == null ? null : industry.trim();
	}
	
    /**
     * @return Industry
     */	
	public String getIndustry() {
		return this.industry;
	}
	
	/**
	 * @param custScale
	 */
	public void setCustScale(long custScale) {
		this.custScale = custScale;
	}
	
    /**
     * @return CustScale
     */	
	public long getCustScale() {
		return this.custScale;
	}
	
	/**
	 * @param custScaleCheck
	 */
	public void setCustScaleCheck(long custScaleCheck) {
		this.custScaleCheck = custScaleCheck;
	}
	
    /**
     * @return CustScaleCheck
     */	
	public long getCustScaleCheck() {
		return this.custScaleCheck;
	}
	
	/**
	 * @param taxCertNo
	 */
	public void setTaxCertNo(String taxCertNo) {
		this.taxCertNo = taxCertNo == null ? null : taxCertNo.trim();
	}
	
    /**
     * @return TaxCertNo
     */	
	public String getTaxCertNo() {
		return this.taxCertNo;
	}
	
	/**
	 * @param licenseNo
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo == null ? null : licenseNo.trim();
	}
	
    /**
     * @return LicenseNo
     */	
	public String getLicenseNo() {
		return this.licenseNo;
	}
	
	/**
	 * @param relationshipUp
	 */
	public void setRelationshipUp(String relationshipUp) {
		this.relationshipUp = relationshipUp == null ? null : relationshipUp.trim();
	}
	
    /**
     * @return RelationshipUp
     */	
	public String getRelationshipUp() {
		return this.relationshipUp;
	}
	
	/**
	 * @param memberShip
	 */
	public void setMemberShip(String memberShip) {
		this.memberShip = memberShip == null ? null : memberShip.trim();
	}
	
    /**
     * @return MemberShip
     */	
	public String getMemberShip() {
		return this.memberShip;
	}
	
	/**
	 * @param coreCustNo
	 */
	public void setCoreCustNo(String coreCustNo) {
		this.coreCustNo = coreCustNo == null ? null : coreCustNo.trim();
	}
	
    /**
     * @return CoreCustNo
     */	
	public String getCoreCustNo() {
		return this.coreCustNo;
	}
	
	/**
	 * @param mainBrId
	 */
	public void setMainBrId(String mainBrId) {
		this.mainBrId = mainBrId == null ? null : mainBrId.trim();
	}
	
    /**
     * @return MainBrId
     */	
	public String getMainBrId() {
		return this.mainBrId;
	}
	
	/**
	 * @param cusManager
	 */
	public void setCusManager(String cusManager) {
		this.cusManager = cusManager == null ? null : cusManager.trim();
	}
	
    /**
     * @return CusManager
     */	
	public String getCusManager() {
		return this.cusManager;
	}
	
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
	 * @param grpCorreType
	 */
	public void setGrpCorreType(String grpCorreType) {
		this.grpCorreType = grpCorreType == null ? null : grpCorreType.trim();
	}
	
    /**
     * @return GrpCorreType
     */	
	public String getGrpCorreType() {
		return this.grpCorreType;
	}
	
	/**
	 * @param grpCorreDetail
	 */
	public void setGrpCorreDetail(String grpCorreDetail) {
		this.grpCorreDetail = grpCorreDetail == null ? null : grpCorreDetail.trim();
	}
	
    /**
     * @return GrpCorreDetail
     */	
	public String getGrpCorreDetail() {
		return this.grpCorreDetail;
	}
	
	/**
	 * @param inputUserId
	 */
	public void setInputUserId(String inputUserId) {
		this.inputUserId = inputUserId == null ? null : inputUserId.trim();
	}
	
    /**
     * @return InputUserId
     */	
	public String getInputUserId() {
		return this.inputUserId;
	}
	
	/**
	 * @param inputDate
	 */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	
    /**
     * @return InputDate
     */	
	public Date getInputDate() {
		return this.inputDate;
	}
	
	/**
	 * @param inputBrId
	 */
	public void setInputBrId(String inputBrId) {
		this.inputBrId = inputBrId == null ? null : inputBrId.trim();
	}
	
    /**
     * @return InputBrId
     */	
	public String getInputBrId() {
		return this.inputBrId;
	}
	
	/**
	 * @param etlDate
	 */
	public void setEtlDate(Date etlDate) {
		this.etlDate = etlDate;
	}
	
    /**
     * @return EtlDate
     */	
	public Date getEtlDate() {
		return this.etlDate;
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
        OcrmFciGroupMember other = (OcrmFciGroupMember) that;
		return (this.getGroupNo() == null ? other.getGroupNo() == null : this.getGroupNo().equals(other.getGroupNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                	&& (this.getMemberType() == null ? other.getMemberType() == null : this.getMemberType().equals(other.getMemberType()))
        	&& (this.getCropCode() == null ? other.getCropCode() == null : this.getCropCode().equals(other.getCropCode()))
        	&& (this.getCorpNameUp() == null ? other.getCorpNameUp() == null : this.getCorpNameUp().equals(other.getCorpNameUp()))
        	&& (this.getCustStat() == null ? other.getCustStat() == null : this.getCustStat().equals(other.getCustStat()))
        	&& (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
                        	&& (this.getTaxCertNo() == null ? other.getTaxCertNo() == null : this.getTaxCertNo().equals(other.getTaxCertNo()))
        	&& (this.getLicenseNo() == null ? other.getLicenseNo() == null : this.getLicenseNo().equals(other.getLicenseNo()))
        	&& (this.getRelationshipUp() == null ? other.getRelationshipUp() == null : this.getRelationshipUp().equals(other.getRelationshipUp()))
        	&& (this.getMemberShip() == null ? other.getMemberShip() == null : this.getMemberShip().equals(other.getMemberShip()))
        	&& (this.getCoreCustNo() == null ? other.getCoreCustNo() == null : this.getCoreCustNo().equals(other.getCoreCustNo()))
        	&& (this.getMainBrId() == null ? other.getMainBrId() == null : this.getMainBrId().equals(other.getMainBrId()))
        	&& (this.getCusManager() == null ? other.getCusManager() == null : this.getCusManager().equals(other.getCusManager()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getGrpCorreType() == null ? other.getGrpCorreType() == null : this.getGrpCorreType().equals(other.getGrpCorreType()))
        	&& (this.getGrpCorreDetail() == null ? other.getGrpCorreDetail() == null : this.getGrpCorreDetail().equals(other.getGrpCorreDetail()))
        	&& (this.getInputUserId() == null ? other.getInputUserId() == null : this.getInputUserId().equals(other.getInputUserId()))
                	&& (this.getInputBrId() == null ? other.getInputBrId() == null : this.getInputBrId().equals(other.getInputBrId()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupNo() == null) ? 0 : getGroupNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getMemberType() == null) ? 0 : getMemberType().hashCode());
        result = prime * result + ((getCropCode() == null) ? 0 : getCropCode().hashCode());
        result = prime * result + ((getCorpNameUp() == null) ? 0 : getCorpNameUp().hashCode());
        result = prime * result + ((getCustStat() == null) ? 0 : getCustStat().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getTaxCertNo() == null) ? 0 : getTaxCertNo().hashCode());
        result = prime * result + ((getLicenseNo() == null) ? 0 : getLicenseNo().hashCode());
        result = prime * result + ((getRelationshipUp() == null) ? 0 : getRelationshipUp().hashCode());
        result = prime * result + ((getMemberShip() == null) ? 0 : getMemberShip().hashCode());
        result = prime * result + ((getCoreCustNo() == null) ? 0 : getCoreCustNo().hashCode());
        result = prime * result + ((getMainBrId() == null) ? 0 : getMainBrId().hashCode());
        result = prime * result + ((getCusManager() == null) ? 0 : getCusManager().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGrpCorreType() == null) ? 0 : getGrpCorreType().hashCode());
        result = prime * result + ((getGrpCorreDetail() == null) ? 0 : getGrpCorreDetail().hashCode());
        result = prime * result + ((getInputUserId() == null) ? 0 : getInputUserId().hashCode());
        result = prime * result + ((getInputBrId() == null) ? 0 : getInputBrId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", groupNo=").append(groupNo);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", remark=").append(remark);
		sb.append(", stockRate=").append(stockRate);
		sb.append(", memberType=").append(memberType);
		sb.append(", cropCode=").append(cropCode);
		sb.append(", corpNameUp=").append(corpNameUp);
		sb.append(", custStat=").append(custStat);
		sb.append(", industry=").append(industry);
		sb.append(", custScale=").append(custScale);
		sb.append(", custScaleCheck=").append(custScaleCheck);
		sb.append(", taxCertNo=").append(taxCertNo);
		sb.append(", licenseNo=").append(licenseNo);
		sb.append(", relationshipUp=").append(relationshipUp);
		sb.append(", memberShip=").append(memberShip);
		sb.append(", coreCustNo=").append(coreCustNo);
		sb.append(", mainBrId=").append(mainBrId);
		sb.append(", cusManager=").append(cusManager);
		sb.append(", id=").append(id);
		sb.append(", grpCorreType=").append(grpCorreType);
		sb.append(", grpCorreDetail=").append(grpCorreDetail);
		sb.append(", inputUserId=").append(inputUserId);
		sb.append(", inputDate=").append(inputDate);
		sb.append(", inputBrId=").append(inputBrId);
		sb.append(", etlDate=").append(etlDate);
        sb.append("]");
        return sb.toString();
    }
}