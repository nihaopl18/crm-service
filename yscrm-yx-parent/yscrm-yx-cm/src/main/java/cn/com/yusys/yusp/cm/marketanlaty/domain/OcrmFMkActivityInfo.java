package cn.com.yusys.yusp.cm.marketanlaty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "OCRM_F_MK_ACTIVITY")
public class OcrmFMkActivityInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 营销活动编号
 **/
	@Id
	@Column(name = "ACTI_ID", unique = false, nullable = false, length = 0)
	private java.math.BigDecimal actiId;
	
	/** 父营销活动编号
 **/
	@Column(name = "PARENT_ACTI_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal parentActiId;
	
	/** 营销活动名称
 **/
	@Column(name = "ACTI_NAME", unique = false, nullable = true, length = 200)
	private String actiName;
	
	/** 营销活动类型
 **/
	@Column(name = "ACTI_TYPE", unique = false, nullable = true, length = 30)
	private String actiType;
	
	/** 营销活动方式
 **/
	@Column(name = "ACTI_MODE", unique = false, nullable = true, length = 30)
	private String actiMode;
	
	/** 营销活动状态
 **/
	@Column(name = "ACTI_STAT", unique = false, nullable = true, length = 30)
	private String actiStat;
	
	/** 营销活动审批状态
 **/
	@Column(name = "MKT_APP_STATE", unique = false, nullable = true, length = 30)
	private String mktAppState;
	
	/** 营销活动目的
 **/
	@Column(name = "ACTI_AIM", unique = false, nullable = true, length = 800)
	private String actiAim;
	
	/** 营销活动内容
 **/
	@Column(name = "ACTI_CONT", unique = false, nullable = true, length = 800)
	private String actiCont;
	
	/** 计划开始时间
 **/
	@Column(name = "PSTART_DATE", unique = false, nullable = true, length = 7)
	private Date pstartDate;
	
	/** 计划结束时间
 **/
	@Column(name = "PEND_DATE", unique = false, nullable = true, length = 7)
	private Date pendDate;
	
	/** 营销渠道
 **/
	@Column(name = "MKT_CHANEL", unique = false, nullable = true, length = 30)
	private String mktChanel;
	
	/** 营销活动地点
 **/
	@Column(name = "ACTI_ADDR", unique = false, nullable = true, length = 800)
	private String actiAddr;
	
	/** 费用预算
 **/
	@Column(name = "ACTI_COST", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal actiCost;
	
	/** 涉及客户群描述
 **/
	@Column(name = "ACTI_CUST_DESC", unique = false, nullable = true, length = 800)
	private String actiCustDesc;
	
	/** 涉及执行人描述
 **/
	@Column(name = "ACTI_OPER_DESC", unique = false, nullable = true, length = 800)
	private String actiOperDesc;
	
	/** 涉及产品描述
 **/
	@Column(name = "ACTI_PROD_DESC", unique = false, nullable = true, length = 800)
	private String actiProdDesc;
	
	/** 实际开始时间
 **/
	//@Transient
	@Column(name = "ASTART_DATE", unique = false, nullable = true, length = 7)
	private Date astartDate;
	
	/** 实际结束时间
 **/
	//@Transient
	@Column(name = "AEND_DATE", unique = false, nullable = true, length = 7)
	private Date aendDate;
	
	/** 活动负责人
 **/
	@Column(name = "MKT_RESP_PERSON", unique = false, nullable = true, length = 20)
	private String mktRespPerson;
	
	/** 活动负责人机构
 **/
	@Column(name = "MKT_RESP_PERSON_ORG", unique = false, nullable = true, length = 50)
	private String mktRespPersonOrg;
	
	/** 合作第三方
 **/
	@Column(name = "CPRT_THREE_PART", unique = false, nullable = true, length = 200)
	private String cprtThreePart;
	
	/** 实际费用支出
 **/
	@Column(name = "PRACTICE_COST", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal practiceCost;
	
	/** 具体费用分配
 **/
	@Column(name = "SPECIFIC_COST_DISTR", unique = false, nullable = true, length = 20)
	private String specificCostDistr;
	
	/** 备注
 **/
	@Column(name = "ACTI_REMARK", unique = false, nullable = true, length = 800)
	private String actiRemark;
	
	/** 创建人
 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 20)
	private String createUser;
	
	/** 创建日期
 **/
	//@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构
 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 30)
	private String createOrg;
	
	/** 最新更新人
 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 20)
	private String lastUpdateUser;
	
	/** 最新更新时间
 **/
	//@Transient
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 7)
	private Date lastUpdateTm;
	
	/** 最新更新机构
 **/
	@Column(name = "LAST_UPDATE_ORG", unique = false, nullable = true, length = 20)
	private String lastUpdateOrg;
	
	/** 是否指定客户（0-否1-是） **/
	@Column(name = "CONTACT_CUST", unique = false, nullable = true, length = 20)
	private String contactCust;
	
	
	/**
	 * @param actiId
	 */
	public void setActiId(java.math.BigDecimal actiId) {
		this.actiId = actiId;
	}
	
    /**
     * @return ActiId
     */	
	public java.math.BigDecimal getActiId() {
		return this.actiId;
	}
	
	/**
	 * @param parentActiId
	 */
	public void setParentActiId(java.math.BigDecimal parentActiId) {
		this.parentActiId = parentActiId;
	}
	
    /**
     * @return ParentActiId
     */	
	public java.math.BigDecimal getParentActiId() {
		return this.parentActiId;
	}
	
	/**
	 * @param actiName
	 */
	public void setActiName(String actiName) {
		this.actiName = actiName == null ? null : actiName.trim();
	}
	
    /**
     * @return ActiName
     */	
	public String getActiName() {
		return this.actiName;
	}
	
	/**
	 * @param actiType
	 */
	public void setActiType(String actiType) {
		this.actiType = actiType == null ? null : actiType.trim();
	}
	
    /**
     * @return ActiType
     */	
	public String getActiType() {
		return this.actiType;
	}
	
	/**
	 * @param actiMode
	 */
	public void setActiMode(String actiMode) {
		this.actiMode = actiMode == null ? null : actiMode.trim();
	}
	
    /**
     * @return ActiMode
     */	
	public String getActiMode() {
		return this.actiMode;
	}
	
	/**
	 * @param actiStat
	 */
	public void setActiStat(String actiStat) {
		this.actiStat = actiStat == null ? null : actiStat.trim();
	}
	
    /**
     * @return ActiStat
     */	
	public String getActiStat() {
		return this.actiStat;
	}
	
	/**
	 * @param mktAppState
	 */
	public void setMktAppState(String mktAppState) {
		this.mktAppState = mktAppState == null ? null : mktAppState.trim();
	}
	
    /**
     * @return MktAppState
     */	
	public String getMktAppState() {
		return this.mktAppState;
	}
	
	/**
	 * @param actiAim
	 */
	public void setActiAim(String actiAim) {
		this.actiAim = actiAim == null ? null : actiAim.trim();
	}
	
    /**
     * @return ActiAim
     */	
	public String getActiAim() {
		return this.actiAim;
	}
	
	/**
	 * @param actiCont
	 */
	public void setActiCont(String actiCont) {
		this.actiCont = actiCont == null ? null : actiCont.trim();
	}
	
    /**
     * @return ActiCont
     */	
	public String getActiCont() {
		return this.actiCont;
	}
	
	/**
	 * @param pstartDate
	 */
	public void setPstartDate(Date pstartDate) {
		this.pstartDate = pstartDate;
	}
	
    /**
     * @return PstartDate
     */	
	public Date getPstartDate() {
		return this.pstartDate;
	}
	
	/**
	 * @param pendDate
	 */
	public void setPendDate(Date pendDate) {
		this.pendDate = pendDate;
	}
	
    /**
     * @return PendDate
     */	
	public Date getPendDate() {
		return this.pendDate;
	}
	
	/**
	 * @param mktChanel
	 */
	public void setMktChanel(String mktChanel) {
		this.mktChanel = mktChanel == null ? null : mktChanel.trim();
	}
	
    /**
     * @return MktChanel
     */	
	public String getMktChanel() {
		return this.mktChanel;
	}
	
	/**
	 * @param actiAddr
	 */
	public void setActiAddr(String actiAddr) {
		this.actiAddr = actiAddr == null ? null : actiAddr.trim();
	}
	
    /**
     * @return ActiAddr
     */	
	public String getActiAddr() {
		return this.actiAddr;
	}
	
	/**
	 * @param actiCost
	 */
	public void setActiCost(java.math.BigDecimal actiCost) {
		this.actiCost = actiCost;
	}
	
    /**
     * @return ActiCost
     */	
	public java.math.BigDecimal getActiCost() {
		return this.actiCost;
	}
	
	/**
	 * @param actiCustDesc
	 */
	public void setActiCustDesc(String actiCustDesc) {
		this.actiCustDesc = actiCustDesc == null ? null : actiCustDesc.trim();
	}
	
    /**
     * @return ActiCustDesc
     */	
	public String getActiCustDesc() {
		return this.actiCustDesc;
	}
	
	/**
	 * @param actiOperDesc
	 */
	public void setActiOperDesc(String actiOperDesc) {
		this.actiOperDesc = actiOperDesc == null ? null : actiOperDesc.trim();
	}
	
    /**
     * @return ActiOperDesc
     */	
	public String getActiOperDesc() {
		return this.actiOperDesc;
	}
	
	/**
	 * @param actiProdDesc
	 */
	public void setActiProdDesc(String actiProdDesc) {
		this.actiProdDesc = actiProdDesc == null ? null : actiProdDesc.trim();
	}
	
    /**
     * @return ActiProdDesc
     */	
	public String getActiProdDesc() {
		return this.actiProdDesc;
	}
	
	/**
	 * @param astartDate
	 */
	public void setAstartDate(Date astartDate) {
		this.astartDate = astartDate;
	}
	
    /**
     * @return AstartDate
     */	
	public Date getAstartDate() {
		return this.astartDate;
	}
	
	/**
	 * @param aendDate
	 */
	public void setAendDate(Date aendDate) {
		this.aendDate = aendDate;
	}
	
    /**
     * @return AendDate
     */	
	public Date getAendDate() {
		return this.aendDate;
	}
	
	/**
	 * @param mktRespPerson
	 */
	public void setMktRespPerson(String mktRespPerson) {
		this.mktRespPerson = mktRespPerson == null ? null : mktRespPerson.trim();
	}
	
    /**
     * @return MktRespPerson
     */	
	public String getMktRespPerson() {
		return this.mktRespPerson;
	}
	
	/**
	 * @param mktRespPersonOrg
	 */
	public void setMktRespPersonOrg(String mktRespPersonOrg) {
		this.mktRespPersonOrg = mktRespPersonOrg == null ? null : mktRespPersonOrg.trim();
	}
	
    /**
     * @return MktRespPersonOrg
     */	
	public String getMktRespPersonOrg() {
		return this.mktRespPersonOrg;
	}
	
	/**
	 * @param cprtThreePart
	 */
	public void setCprtThreePart(String cprtThreePart) {
		this.cprtThreePart = cprtThreePart == null ? null : cprtThreePart.trim();
	}
	
    /**
     * @return CprtThreePart
     */	
	public String getCprtThreePart() {
		return this.cprtThreePart;
	}
	
	/**
	 * @param practiceCost
	 */
	public void setPracticeCost(java.math.BigDecimal practiceCost) {
		this.practiceCost = practiceCost;
	}
	
    /**
     * @return PracticeCost
     */	
	public java.math.BigDecimal getPracticeCost() {
		return this.practiceCost;
	}
	
	/**
	 * @param specificCostDistr
	 */
	public void setSpecificCostDistr(String specificCostDistr) {
		this.specificCostDistr = specificCostDistr;
	}
	
    /**
     * @return SpecificCostDistr
     */	
	public String getSpecificCostDistr() {
		return this.specificCostDistr;
	}
	
	/**
	 * @param actiRemark
	 */
	public void setActiRemark(String actiRemark) {
		this.actiRemark = actiRemark == null ? null : actiRemark.trim();
	}
	
    /**
     * @return ActiRemark
     */	
	public String getActiRemark() {
		return this.actiRemark;
	}
	
	/**
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
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
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param lastUpdateUser
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
	}
	
    /**
     * @return LastUpdateUser
     */	
	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}
	
	/**
	 * @param lastUpdateTm
	 */
	public void setLastUpdateTm(Date lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}
	
    /**
     * @return LastUpdateTm
     */	
	public Date getLastUpdateTm() {
		return this.lastUpdateTm;
	}
	
	/**
	 * @param lastUpdateOrg
	 */
	public void setLastUpdateOrg(String lastUpdateOrg) {
		this.lastUpdateOrg = lastUpdateOrg == null ? null : lastUpdateOrg.trim();
	}
	
    /**
     * @return LastUpdateOrg
     */	
	public String getLastUpdateOrg() {
		return this.lastUpdateOrg;
	}
	
	/**
	 * @param contactCust
	 */
	public void setContactCust(String contactCust) {
		this.contactCust = contactCust == null ? null : contactCust.trim();
	}
	
    /**
     * @return ContactCust
     */	
	public String getContactCust() {
		return this.contactCust;
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
        OcrmFMkActivityInfo other = (OcrmFMkActivityInfo) that;
                		return (this.getActiName() == null ? other.getActiName() == null : this.getActiName().equals(other.getActiName()))
        	&& (this.getActiType() == null ? other.getActiType() == null : this.getActiType().equals(other.getActiType()))
        	&& (this.getActiMode() == null ? other.getActiMode() == null : this.getActiMode().equals(other.getActiMode()))
        	&& (this.getActiStat() == null ? other.getActiStat() == null : this.getActiStat().equals(other.getActiStat()))
        	&& (this.getMktAppState() == null ? other.getMktAppState() == null : this.getMktAppState().equals(other.getMktAppState()))
        	&& (this.getActiAim() == null ? other.getActiAim() == null : this.getActiAim().equals(other.getActiAim()))
        	&& (this.getActiCont() == null ? other.getActiCont() == null : this.getActiCont().equals(other.getActiCont()))
                        	&& (this.getMktChanel() == null ? other.getMktChanel() == null : this.getMktChanel().equals(other.getMktChanel()))
        	&& (this.getActiAddr() == null ? other.getActiAddr() == null : this.getActiAddr().equals(other.getActiAddr()))
                	&& (this.getActiCustDesc() == null ? other.getActiCustDesc() == null : this.getActiCustDesc().equals(other.getActiCustDesc()))
        	&& (this.getActiOperDesc() == null ? other.getActiOperDesc() == null : this.getActiOperDesc().equals(other.getActiOperDesc()))
        	&& (this.getActiProdDesc() == null ? other.getActiProdDesc() == null : this.getActiProdDesc().equals(other.getActiProdDesc()))
                        	&& (this.getMktRespPerson() == null ? other.getMktRespPerson() == null : this.getMktRespPerson().equals(other.getMktRespPerson()))
        	&& (this.getMktRespPersonOrg() == null ? other.getMktRespPersonOrg() == null : this.getMktRespPersonOrg().equals(other.getMktRespPersonOrg()))
        	&& (this.getCprtThreePart() == null ? other.getCprtThreePart() == null : this.getCprtThreePart().equals(other.getCprtThreePart()))
                        	&& (this.getActiRemark() == null ? other.getActiRemark() == null : this.getActiRemark().equals(other.getActiRemark()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getLastUpdateOrg() == null ? other.getLastUpdateOrg() == null : this.getLastUpdateOrg().equals(other.getLastUpdateOrg()))
        	&& (this.getContactCust() == null ? other.getContactCust() == null : this.getContactCust().equals(other.getContactCust()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActiName() == null) ? 0 : getActiName().hashCode());
        result = prime * result + ((getActiType() == null) ? 0 : getActiType().hashCode());
        result = prime * result + ((getActiMode() == null) ? 0 : getActiMode().hashCode());
        result = prime * result + ((getActiStat() == null) ? 0 : getActiStat().hashCode());
        result = prime * result + ((getMktAppState() == null) ? 0 : getMktAppState().hashCode());
        result = prime * result + ((getActiAim() == null) ? 0 : getActiAim().hashCode());
        result = prime * result + ((getActiCont() == null) ? 0 : getActiCont().hashCode());
        result = prime * result + ((getMktChanel() == null) ? 0 : getMktChanel().hashCode());
        result = prime * result + ((getActiAddr() == null) ? 0 : getActiAddr().hashCode());
        result = prime * result + ((getActiCustDesc() == null) ? 0 : getActiCustDesc().hashCode());
        result = prime * result + ((getActiOperDesc() == null) ? 0 : getActiOperDesc().hashCode());
        result = prime * result + ((getActiProdDesc() == null) ? 0 : getActiProdDesc().hashCode());
        result = prime * result + ((getMktRespPerson() == null) ? 0 : getMktRespPerson().hashCode());
        result = prime * result + ((getMktRespPersonOrg() == null) ? 0 : getMktRespPersonOrg().hashCode());
        result = prime * result + ((getCprtThreePart() == null) ? 0 : getCprtThreePart().hashCode());
        result = prime * result + ((getActiRemark() == null) ? 0 : getActiRemark().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateOrg() == null) ? 0 : getLastUpdateOrg().hashCode());
        result = prime * result + ((getContactCust() == null) ? 0 : getContactCust().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", actiId=").append(actiId);
		sb.append(", parentActiId=").append(parentActiId);
		sb.append(", actiName=").append(actiName);
		sb.append(", actiType=").append(actiType);
		sb.append(", actiMode=").append(actiMode);
		sb.append(", actiStat=").append(actiStat);
		sb.append(", mktAppState=").append(mktAppState);
		sb.append(", actiAim=").append(actiAim);
		sb.append(", actiCont=").append(actiCont);
		sb.append(", pstartDate=").append(pstartDate);
		sb.append(", pendDate=").append(pendDate);
		sb.append(", mktChanel=").append(mktChanel);
		sb.append(", actiAddr=").append(actiAddr);
		sb.append(", actiCost=").append(actiCost);
		sb.append(", actiCustDesc=").append(actiCustDesc);
		sb.append(", actiOperDesc=").append(actiOperDesc);
		sb.append(", actiProdDesc=").append(actiProdDesc);
		sb.append(", astartDate=").append(astartDate);
		sb.append(", aendDate=").append(aendDate);
		sb.append(", mktRespPerson=").append(mktRespPerson);
		sb.append(", mktRespPersonOrg=").append(mktRespPersonOrg);
		sb.append(", cprtThreePart=").append(cprtThreePart);
		sb.append(", practiceCost=").append(practiceCost);
		sb.append(", specificCostDistr=").append(specificCostDistr);
		sb.append(", actiRemark=").append(actiRemark);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", lastUpdateOrg=").append(lastUpdateOrg);
		sb.append(", contactCust=").append(contactCust);
        sb.append("]");
        return sb.toString();
    }
}