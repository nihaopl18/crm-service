package cn.com.yusys.yscrm.cust.org.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciOrgKeyFlag
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-02-26 22:40:25
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_ORG_KEY_FLAG")
public class AcrmFciOrgKeyFlag extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 最新更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 是否上市企业 **/
	@Column(name = "LIST_FLG", unique = false, nullable = true, length = 10)
	private String listFlg;
	
	/** 是否涉农客户 **/
	@Column(name = "FAM_FLG", unique = false, nullable = true, length = 10)
	private String famFlg;
	
	/** 是否集团客户 **/
	@Column(name = "GROUP_CUST_FLG", unique = false, nullable = true, length = 10)
	private String groupCustFlg;
	
	/** 是否限制行业 **/
	@Column(name = "LIMIT_INDUS_FLG", unique = false, nullable = true, length = 10)
	private String limitIndusFlg;
	
	/** 是否统一授信客户 **/
	@Column(name = "CREDIT_CUST_FLG", unique = false, nullable = true, length = 10)
	private String creditCustFlg;
	
	/** 是否我行关联方 **/
	@Column(name = "ASSOC_PARTY_FLG", unique = false, nullable = true, length = 10)
	private String assocPartyFlg;
	
	/** 有无进出口经营权 **/
	@Column(name = "IR_RIGHT_FLG", unique = false, nullable = true, length = 10)
	private String irRightFlg;
	
	/** 是否本行/社股东 **/
	@Column(name = "HOLDER_FLG", unique = false, nullable = true, length = 10)
	private String holderFlg;
	
	/** 是否小微企业 **/
	@Column(name = "MINI_COM_FLG", unique = false, nullable = true, length = 10)
	private String miniComFlg;
	
	/** 是否两高一剩企业 **/
	@Column(name = "DHGH_FLG", unique = false, nullable = true, length = 10)
	private String dhghFlg;
	
	/** 外汇许可证号码 **/
	@Column(name = "FEXC_PRM_NO", unique = false, nullable = true, length = 50)
	private String fexcPrmNo;
	
	/** 是否国际业务客户 **/
	@Column(name = "INTER_BUSI_FLG", unique = false, nullable = true, length = 10)
	private String interBusiFlg;
	
	/** 是否贷款客户 **/
	@Column(name = "LOAN_FLG", unique = false, nullable = true, length = 10)
	private String loanFlg;
	
	/** 是否港澳台合资企业 **/
	@Column(name = "GAT_FLG", unique = false, nullable = true, length = 10)
	private String gatFlg;
	
	/** 是否本行/社VIP客户 **/
	@Column(name = "VIP_FLG", unique = false, nullable = true, length = 10)
	private String vipFlg;
	
	/** 行业地位 **/
	@Column(name = "INDUS_LEV", unique = false, nullable = true, length = 100)
	private String indusLev;
	
	/** 是否核心客户 **/
	@Column(name = "COR_CUST_FLG", unique = false, nullable = true, length = 10)
	private String corCustFlg;
	
	/** 是否重点扶持企业 **/
	@Column(name = "KEY_SUPPORT_FLG", unique = false, nullable = true, length = 10)
	private String keySupportFlg;
	
	/** 是否政府所属企业 **/
	@Column(name = "GOV_COR_FLG", unique = false, nullable = true, length = 10)
	private String govCorFlg;
	
	/** 是否商户联盟客户 **/
	@Column(name = "SHLM_FLG", unique = false, nullable = true, length = 10)
	private String shlmFlg;
	
	/** 是否鲜特汇合作客户 **/
	@Column(name = "XTH_FLG", unique = false, nullable = true, length = 10)
	private String xthFlg;
	
	/** 是否特色业务合作客户 **/
	@Column(name = "TSYW_FLG", unique = false, nullable = true, length = 10)
	private String tsywFlg;
	
	/** 特色业务描述 **/
	@Column(name = "TSYW_DESC", unique = false, nullable = true, length = 500)
	private String tsywDesc;
	
	/** 是否活动合作商户 **/
	@Column(name = "ACT_COR_FLG", unique = false, nullable = true, length = 10)
	private String actCorFlg;
	
	/** 合作活动描述 **/
	@Column(name = "ACT_DESC", unique = false, nullable = true, length = 1000)
	private String actDesc;
	
	/** 是否科技型企业 **/
	@Column(name = "TECH_COR_FLG", unique = false, nullable = true, length = 10)
	private String techCorFlg;
	
	/** 是否属于协(商)会 **/
	@Column(name = "ASSOC_FLG", unique = false, nullable = true, length = 10)
	private String assocFlg;
	
	/** 协(商)会名称 **/
	@Column(name = "ASSOC_NAME", unique = false, nullable = true, length = 200)
	private String assocName;
	
	/** 自定义标签 **/
	@Column(name = "SELT_TAB", unique = false, nullable = true, length = 1000)
	private String seltTab;
	
	/** ID主键 **/
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
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
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
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
	 * @param listFlg
	 */
	public void setListFlg(String listFlg) {
		this.listFlg = listFlg == null ? null : listFlg.trim();
	}
	
    /**
     * @return ListFlg
     */	
	public String getListFlg() {
		return this.listFlg;
	}
	
	/**
	 * @param famFlg
	 */
	public void setFamFlg(String famFlg) {
		this.famFlg = famFlg == null ? null : famFlg.trim();
	}
	
    /**
     * @return FamFlg
     */	
	public String getFamFlg() {
		return this.famFlg;
	}
	
	/**
	 * @param groupCustFlg
	 */
	public void setGroupCustFlg(String groupCustFlg) {
		this.groupCustFlg = groupCustFlg == null ? null : groupCustFlg.trim();
	}
	
    /**
     * @return GroupCustFlg
     */	
	public String getGroupCustFlg() {
		return this.groupCustFlg;
	}
	
	/**
	 * @param limitIndusFlg
	 */
	public void setLimitIndusFlg(String limitIndusFlg) {
		this.limitIndusFlg = limitIndusFlg == null ? null : limitIndusFlg.trim();
	}
	
    /**
     * @return LimitIndusFlg
     */	
	public String getLimitIndusFlg() {
		return this.limitIndusFlg;
	}
	
	/**
	 * @param creditCustFlg
	 */
	public void setCreditCustFlg(String creditCustFlg) {
		this.creditCustFlg = creditCustFlg == null ? null : creditCustFlg.trim();
	}
	
    /**
     * @return CreditCustFlg
     */	
	public String getCreditCustFlg() {
		return this.creditCustFlg;
	}
	
	/**
	 * @param assocPartyFlg
	 */
	public void setAssocPartyFlg(String assocPartyFlg) {
		this.assocPartyFlg = assocPartyFlg == null ? null : assocPartyFlg.trim();
	}
	
    /**
     * @return AssocPartyFlg
     */	
	public String getAssocPartyFlg() {
		return this.assocPartyFlg;
	}
	
	/**
	 * @param irRightFlg
	 */
	public void setIrRightFlg(String irRightFlg) {
		this.irRightFlg = irRightFlg == null ? null : irRightFlg.trim();
	}
	
    /**
     * @return IrRightFlg
     */	
	public String getIrRightFlg() {
		return this.irRightFlg;
	}
	
	/**
	 * @param holderFlg
	 */
	public void setHolderFlg(String holderFlg) {
		this.holderFlg = holderFlg == null ? null : holderFlg.trim();
	}
	
    /**
     * @return HolderFlg
     */	
	public String getHolderFlg() {
		return this.holderFlg;
	}
	
	/**
	 * @param miniComFlg
	 */
	public void setMiniComFlg(String miniComFlg) {
		this.miniComFlg = miniComFlg == null ? null : miniComFlg.trim();
	}
	
    /**
     * @return MiniComFlg
     */	
	public String getMiniComFlg() {
		return this.miniComFlg;
	}
	
	/**
	 * @param dhghFlg
	 */
	public void setDhghFlg(String dhghFlg) {
		this.dhghFlg = dhghFlg == null ? null : dhghFlg.trim();
	}
	
    /**
     * @return DhghFlg
     */	
	public String getDhghFlg() {
		return this.dhghFlg;
	}
	
	/**
	 * @param fexcPrmNo
	 */
	public void setFexcPrmNo(String fexcPrmNo) {
		this.fexcPrmNo = fexcPrmNo == null ? null : fexcPrmNo.trim();
	}
	
    /**
     * @return FexcPrmNo
     */	
	public String getFexcPrmNo() {
		return this.fexcPrmNo;
	}
	
	/**
	 * @param interBusiFlg
	 */
	public void setInterBusiFlg(String interBusiFlg) {
		this.interBusiFlg = interBusiFlg == null ? null : interBusiFlg.trim();
	}
	
    /**
     * @return InterBusiFlg
     */	
	public String getInterBusiFlg() {
		return this.interBusiFlg;
	}
	
	/**
	 * @param loanFlg
	 */
	public void setLoanFlg(String loanFlg) {
		this.loanFlg = loanFlg == null ? null : loanFlg.trim();
	}
	
    /**
     * @return LoanFlg
     */	
	public String getLoanFlg() {
		return this.loanFlg;
	}
	
	/**
	 * @param gatFlg
	 */
	public void setGatFlg(String gatFlg) {
		this.gatFlg = gatFlg == null ? null : gatFlg.trim();
	}
	
    /**
     * @return GatFlg
     */	
	public String getGatFlg() {
		return this.gatFlg;
	}
	
	/**
	 * @param vipFlg
	 */
	public void setVipFlg(String vipFlg) {
		this.vipFlg = vipFlg == null ? null : vipFlg.trim();
	}
	
    /**
     * @return VipFlg
     */	
	public String getVipFlg() {
		return this.vipFlg;
	}
	
	/**
	 * @param indusLev
	 */
	public void setIndusLev(String indusLev) {
		this.indusLev = indusLev == null ? null : indusLev.trim();
	}
	
    /**
     * @return IndusLev
     */	
	public String getIndusLev() {
		return this.indusLev;
	}
	
	/**
	 * @param corCustFlg
	 */
	public void setCorCustFlg(String corCustFlg) {
		this.corCustFlg = corCustFlg == null ? null : corCustFlg.trim();
	}
	
    /**
     * @return CorCustFlg
     */	
	public String getCorCustFlg() {
		return this.corCustFlg;
	}
	
	/**
	 * @param keySupportFlg
	 */
	public void setKeySupportFlg(String keySupportFlg) {
		this.keySupportFlg = keySupportFlg == null ? null : keySupportFlg.trim();
	}
	
    /**
     * @return KeySupportFlg
     */	
	public String getKeySupportFlg() {
		return this.keySupportFlg;
	}
	
	/**
	 * @param govCorFlg
	 */
	public void setGovCorFlg(String govCorFlg) {
		this.govCorFlg = govCorFlg == null ? null : govCorFlg.trim();
	}
	
    /**
     * @return GovCorFlg
     */	
	public String getGovCorFlg() {
		return this.govCorFlg;
	}
	
	/**
	 * @param shlmFlg
	 */
	public void setShlmFlg(String shlmFlg) {
		this.shlmFlg = shlmFlg == null ? null : shlmFlg.trim();
	}
	
    /**
     * @return ShlmFlg
     */	
	public String getShlmFlg() {
		return this.shlmFlg;
	}
	
	/**
	 * @param xthFlg
	 */
	public void setXthFlg(String xthFlg) {
		this.xthFlg = xthFlg == null ? null : xthFlg.trim();
	}
	
    /**
     * @return XthFlg
     */	
	public String getXthFlg() {
		return this.xthFlg;
	}
	
	/**
	 * @param tsywFlg
	 */
	public void setTsywFlg(String tsywFlg) {
		this.tsywFlg = tsywFlg == null ? null : tsywFlg.trim();
	}
	
    /**
     * @return TsywFlg
     */	
	public String getTsywFlg() {
		return this.tsywFlg;
	}
	
	/**
	 * @param tsywDesc
	 */
	public void setTsywDesc(String tsywDesc) {
		this.tsywDesc = tsywDesc == null ? null : tsywDesc.trim();
	}
	
    /**
     * @return TsywDesc
     */	
	public String getTsywDesc() {
		return this.tsywDesc;
	}
	
	/**
	 * @param actCorFlg
	 */
	public void setActCorFlg(String actCorFlg) {
		this.actCorFlg = actCorFlg == null ? null : actCorFlg.trim();
	}
	
    /**
     * @return ActCorFlg
     */	
	public String getActCorFlg() {
		return this.actCorFlg;
	}
	
	/**
	 * @param actDesc
	 */
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc == null ? null : actDesc.trim();
	}
	
    /**
     * @return ActDesc
     */	
	public String getActDesc() {
		return this.actDesc;
	}
	
	/**
	 * @param techCorFlg
	 */
	public void setTechCorFlg(String techCorFlg) {
		this.techCorFlg = techCorFlg == null ? null : techCorFlg.trim();
	}
	
    /**
     * @return TechCorFlg
     */	
	public String getTechCorFlg() {
		return this.techCorFlg;
	}
	
	/**
	 * @param assocFlg
	 */
	public void setAssocFlg(String assocFlg) {
		this.assocFlg = assocFlg == null ? null : assocFlg.trim();
	}
	
    /**
     * @return AssocFlg
     */	
	public String getAssocFlg() {
		return this.assocFlg;
	}
	
	/**
	 * @param assocName
	 */
	public void setAssocName(String assocName) {
		this.assocName = assocName == null ? null : assocName.trim();
	}
	
    /**
     * @return AssocName
     */	
	public String getAssocName() {
		return this.assocName;
	}
	
	/**
	 * @param seltTab
	 */
	public void setSeltTab(String seltTab) {
		this.seltTab = seltTab == null ? null : seltTab.trim();
	}
	
    /**
     * @return SeltTab
     */	
	public String getSeltTab() {
		return this.seltTab;
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
        AcrmFciOrgKeyFlag other = (AcrmFciOrgKeyFlag) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getListFlg() == null ? other.getListFlg() == null : this.getListFlg().equals(other.getListFlg()))
        	&& (this.getFamFlg() == null ? other.getFamFlg() == null : this.getFamFlg().equals(other.getFamFlg()))
        	&& (this.getGroupCustFlg() == null ? other.getGroupCustFlg() == null : this.getGroupCustFlg().equals(other.getGroupCustFlg()))
        	&& (this.getLimitIndusFlg() == null ? other.getLimitIndusFlg() == null : this.getLimitIndusFlg().equals(other.getLimitIndusFlg()))
        	&& (this.getCreditCustFlg() == null ? other.getCreditCustFlg() == null : this.getCreditCustFlg().equals(other.getCreditCustFlg()))
        	&& (this.getAssocPartyFlg() == null ? other.getAssocPartyFlg() == null : this.getAssocPartyFlg().equals(other.getAssocPartyFlg()))
        	&& (this.getIrRightFlg() == null ? other.getIrRightFlg() == null : this.getIrRightFlg().equals(other.getIrRightFlg()))
        	&& (this.getHolderFlg() == null ? other.getHolderFlg() == null : this.getHolderFlg().equals(other.getHolderFlg()))
        	&& (this.getMiniComFlg() == null ? other.getMiniComFlg() == null : this.getMiniComFlg().equals(other.getMiniComFlg()))
        	&& (this.getDhghFlg() == null ? other.getDhghFlg() == null : this.getDhghFlg().equals(other.getDhghFlg()))
        	&& (this.getFexcPrmNo() == null ? other.getFexcPrmNo() == null : this.getFexcPrmNo().equals(other.getFexcPrmNo()))
        	&& (this.getInterBusiFlg() == null ? other.getInterBusiFlg() == null : this.getInterBusiFlg().equals(other.getInterBusiFlg()))
        	&& (this.getLoanFlg() == null ? other.getLoanFlg() == null : this.getLoanFlg().equals(other.getLoanFlg()))
        	&& (this.getGatFlg() == null ? other.getGatFlg() == null : this.getGatFlg().equals(other.getGatFlg()))
        	&& (this.getVipFlg() == null ? other.getVipFlg() == null : this.getVipFlg().equals(other.getVipFlg()))
        	&& (this.getIndusLev() == null ? other.getIndusLev() == null : this.getIndusLev().equals(other.getIndusLev()))
        	&& (this.getCorCustFlg() == null ? other.getCorCustFlg() == null : this.getCorCustFlg().equals(other.getCorCustFlg()))
        	&& (this.getKeySupportFlg() == null ? other.getKeySupportFlg() == null : this.getKeySupportFlg().equals(other.getKeySupportFlg()))
        	&& (this.getGovCorFlg() == null ? other.getGovCorFlg() == null : this.getGovCorFlg().equals(other.getGovCorFlg()))
        	&& (this.getShlmFlg() == null ? other.getShlmFlg() == null : this.getShlmFlg().equals(other.getShlmFlg()))
        	&& (this.getXthFlg() == null ? other.getXthFlg() == null : this.getXthFlg().equals(other.getXthFlg()))
        	&& (this.getTsywFlg() == null ? other.getTsywFlg() == null : this.getTsywFlg().equals(other.getTsywFlg()))
        	&& (this.getTsywDesc() == null ? other.getTsywDesc() == null : this.getTsywDesc().equals(other.getTsywDesc()))
        	&& (this.getActCorFlg() == null ? other.getActCorFlg() == null : this.getActCorFlg().equals(other.getActCorFlg()))
        	&& (this.getActDesc() == null ? other.getActDesc() == null : this.getActDesc().equals(other.getActDesc()))
        	&& (this.getTechCorFlg() == null ? other.getTechCorFlg() == null : this.getTechCorFlg().equals(other.getTechCorFlg()))
        	&& (this.getAssocFlg() == null ? other.getAssocFlg() == null : this.getAssocFlg().equals(other.getAssocFlg()))
        	&& (this.getAssocName() == null ? other.getAssocName() == null : this.getAssocName().equals(other.getAssocName()))
        	&& (this.getSeltTab() == null ? other.getSeltTab() == null : this.getSeltTab().equals(other.getSeltTab()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getListFlg() == null) ? 0 : getListFlg().hashCode());
        result = prime * result + ((getFamFlg() == null) ? 0 : getFamFlg().hashCode());
        result = prime * result + ((getGroupCustFlg() == null) ? 0 : getGroupCustFlg().hashCode());
        result = prime * result + ((getLimitIndusFlg() == null) ? 0 : getLimitIndusFlg().hashCode());
        result = prime * result + ((getCreditCustFlg() == null) ? 0 : getCreditCustFlg().hashCode());
        result = prime * result + ((getAssocPartyFlg() == null) ? 0 : getAssocPartyFlg().hashCode());
        result = prime * result + ((getIrRightFlg() == null) ? 0 : getIrRightFlg().hashCode());
        result = prime * result + ((getHolderFlg() == null) ? 0 : getHolderFlg().hashCode());
        result = prime * result + ((getMiniComFlg() == null) ? 0 : getMiniComFlg().hashCode());
        result = prime * result + ((getDhghFlg() == null) ? 0 : getDhghFlg().hashCode());
        result = prime * result + ((getFexcPrmNo() == null) ? 0 : getFexcPrmNo().hashCode());
        result = prime * result + ((getInterBusiFlg() == null) ? 0 : getInterBusiFlg().hashCode());
        result = prime * result + ((getLoanFlg() == null) ? 0 : getLoanFlg().hashCode());
        result = prime * result + ((getGatFlg() == null) ? 0 : getGatFlg().hashCode());
        result = prime * result + ((getVipFlg() == null) ? 0 : getVipFlg().hashCode());
        result = prime * result + ((getIndusLev() == null) ? 0 : getIndusLev().hashCode());
        result = prime * result + ((getCorCustFlg() == null) ? 0 : getCorCustFlg().hashCode());
        result = prime * result + ((getKeySupportFlg() == null) ? 0 : getKeySupportFlg().hashCode());
        result = prime * result + ((getGovCorFlg() == null) ? 0 : getGovCorFlg().hashCode());
        result = prime * result + ((getShlmFlg() == null) ? 0 : getShlmFlg().hashCode());
        result = prime * result + ((getXthFlg() == null) ? 0 : getXthFlg().hashCode());
        result = prime * result + ((getTsywFlg() == null) ? 0 : getTsywFlg().hashCode());
        result = prime * result + ((getTsywDesc() == null) ? 0 : getTsywDesc().hashCode());
        result = prime * result + ((getActCorFlg() == null) ? 0 : getActCorFlg().hashCode());
        result = prime * result + ((getActDesc() == null) ? 0 : getActDesc().hashCode());
        result = prime * result + ((getTechCorFlg() == null) ? 0 : getTechCorFlg().hashCode());
        result = prime * result + ((getAssocFlg() == null) ? 0 : getAssocFlg().hashCode());
        result = prime * result + ((getAssocName() == null) ? 0 : getAssocName().hashCode());
        result = prime * result + ((getSeltTab() == null) ? 0 : getSeltTab().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", listFlg=").append(listFlg);
		sb.append(", famFlg=").append(famFlg);
		sb.append(", groupCustFlg=").append(groupCustFlg);
		sb.append(", limitIndusFlg=").append(limitIndusFlg);
		sb.append(", creditCustFlg=").append(creditCustFlg);
		sb.append(", assocPartyFlg=").append(assocPartyFlg);
		sb.append(", irRightFlg=").append(irRightFlg);
		sb.append(", holderFlg=").append(holderFlg);
		sb.append(", miniComFlg=").append(miniComFlg);
		sb.append(", dhghFlg=").append(dhghFlg);
		sb.append(", fexcPrmNo=").append(fexcPrmNo);
		sb.append(", interBusiFlg=").append(interBusiFlg);
		sb.append(", loanFlg=").append(loanFlg);
		sb.append(", gatFlg=").append(gatFlg);
		sb.append(", vipFlg=").append(vipFlg);
		sb.append(", indusLev=").append(indusLev);
		sb.append(", corCustFlg=").append(corCustFlg);
		sb.append(", keySupportFlg=").append(keySupportFlg);
		sb.append(", govCorFlg=").append(govCorFlg);
		sb.append(", shlmFlg=").append(shlmFlg);
		sb.append(", xthFlg=").append(xthFlg);
		sb.append(", tsywFlg=").append(tsywFlg);
		sb.append(", tsywDesc=").append(tsywDesc);
		sb.append(", actCorFlg=").append(actCorFlg);
		sb.append(", actDesc=").append(actDesc);
		sb.append(", techCorFlg=").append(techCorFlg);
		sb.append(", assocFlg=").append(assocFlg);
		sb.append(", assocName=").append(assocName);
		sb.append(", seltTab=").append(seltTab);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}