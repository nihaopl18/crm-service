package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciPerCust
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-28 10:18:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_PER_ADMIT_INFO")
public class AcrmFciPerCust extends BaseDomain implements Serializable{
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
	@Column(name = "LAST_UPDATE_SYS", unique = false, nullable = true, length = 20)
	private String lastUpdateSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 20)
	private String lastUpdateUser;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 7)
	private Date lastUpdateTm;
	
	/** 最新更新机构 **/
	@Column(name = "LAST_UPDATE_ORG", unique = false, nullable = true, length = 20)
	private String lastUpdateOrg;
	
	@Column(name = "IS_ADMIT_ENTER", unique = false, nullable = true, length = 30)
	private String isAdmitEnter;
	public String getIsAdmitEnter() {
		return isAdmitEnter;
	}

	public void setIsAdmitEnter(String isAdmitEnter) {
		this.isAdmitEnter = isAdmitEnter;
	}
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** ECIF客户标识 **/
	@Column(name = "ECIF_CUST_ID", unique = false, nullable = true, length = 40)
	private String ecifCustId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 证件类型 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = true, length = 30)
	private String certType;
	
	/** 证件号码 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 50)
	private String certNo;
	
	/** 拼音名 **/
	@Column(name = "PINYIN_NAME", unique = false, nullable = true, length = 60)
	private String pinyinName;
	
	/** 曾用名 **/
	@Column(name = "OTHER_NAME", unique = false, nullable = true, length = 60)
	private String otherName;
	
	/** 客户称谓 **/
	@Column(name = "TITLE_CD", unique = false, nullable = true, length = 40)
	private String titleCd;
	
	/** 英文名 **/
	@Column(name = "ENGLISH_NAME", unique = false, nullable = true, length = 60)
	private String englishName;
	
	/** 性别 **/
	@Column(name = "SEX", unique = false, nullable = true, length = 20)
	private String sex;
	
	/** 民族 **/
	@Column(name = "NATION", unique = false, nullable = true, length = 4)
	private String nation;
	
	/** 出生日期 **/
	@Column(name = "BIRTH_DT", unique = false, nullable = true, length = 10)
	private String birthDt;
	
	/** 年龄 **/
	@Column(name = "AGE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal age;
	
	/** 籍贯 **/
	@Column(name = "BRN_PLACE", unique = false, nullable = true, length = 60)
	private String brnPlace;
	
	/** 职业 **/
	@Column(name = "INDIV_OCC", unique = false, nullable = true, length = 5)
	private String indivOcc;
	
	/** 政治面貌 **/
	@Column(name = "POL_STAT", unique = false, nullable = true, length = 4)
	private String polStat;
	
	/** 户口所在地 **/
	@Column(name = "REG_PLACE", unique = false, nullable = true, length = 120)
	private String regPlace;
	
	/** 健康状况 **/
	@Column(name = "HLT_STAT", unique = false, nullable = true, length = 2)
	private String hltStat;
	
	/** 婚姻状况 **/
	@Column(name = "MARRI_STAT", unique = false, nullable = true, length = 2)
	private String marriStat;
	
	/** 宗教信仰 **/
	@Column(name = "FAITH_STAT", unique = false, nullable = true, length = 80)
	private String faithStat;
	
	/** 地区 **/
	@Column(name = "COUNTRY_CD", unique = false, nullable = true, length = 6)
	private String countryCd;
	
	/** 语言习惯 **/
	@Column(name = "LANG_CD", unique = false, nullable = true, length = 30)
	private String langCd;
	
	/** 最高学历 **/
	@Column(name = "HIG_EDU_REC", unique = false, nullable = true, length = 2)
	private String higEduRec;
	
	/** 最高学位 **/
	@Column(name = "HIG_EDU_DGR", unique = false, nullable = true, length = 1)
	private String higEduDgr;
	
	/** 居民/非居民 1是 0否 **/
	@Column(name = "RESIDENT_STAT", unique = false, nullable = true, length = 1)
	private String residentStat;
	
	/** 是否拥有外国护照或居住权 **/
	@Column(name = "PASSPORT_FLG", unique = false, nullable = true, length = 1)
	private String passportFlg;
	
	/** 是否农户 **/
	@Column(name = "AGRI_FLG", unique = false, nullable = true, length = 1)
	private String agriFlg;
	
	/** 是否本行员工 **/
	@Column(name = "STAFF_FLG", unique = false, nullable = true, length = 1)
	private String staffFlg;
	
	/** 股东标志 **/
	@Column(name = "HOLDER_FLG", unique = false, nullable = true, length = 20)
	private String holderFlg;
	
	/** 客户核实结果 **/
	@Column(name = "INSP_IND", unique = false, nullable = true, length = 10)
	private String inspInd;
	
	/** 客户与我行关系 **/
	@Column(name = "CUST_BANK_REL", unique = false, nullable = true, length = 10)
	private String custBankRel;
	
	/** 建立信贷关系时间 **/
	@Column(name = "COM_INIT_LOAN_DATE", unique = false, nullable = true, length = 10)
	private String comInitLoanDate;
	
	/** 信贷客户类型 **/
	@Column(name = "LOAN_CUST_TYPE", unique = false, nullable = true, length = 10)
	private String loanCustType;
	
	/** 个人年收入 **/
	@Column(name = "PER_INCOME_Y", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perIncomeY;
	
	/** 家庭年收入 **/
	@Column(name = "FAM_INCOME_Y", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal famIncomeY;
	
	/** 工作单位 **/
	@Column(name = "WORK_UNIT", unique = false, nullable = true, length = 200)
	private String workUnit;
	
	/** 社会保障情况 **/
	@Column(name = "SOC_SECUR_STAT", unique = false, nullable = true, length = 100)
	private String socSecurStat;
	
	/** 成为我行客户时间 **/
	@Column(name = "BE_CUST_DATE", unique = false, nullable = true, length = 10)
	private String beCustDate;
	
	/** 在我行职务 **/
	@Column(name = "BANK_DUTY", unique = false, nullable = true, length = 2)
	private String bankDuty;
	
	/** 拥有我行股份金额 **/
	@Column(name = "HOLD_STOCK_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal holdStockAmt;
	
	/** 持股数量 **/
	@Column(name = "HOLD_STOCK_TOT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal holdStockTot;
	
	/** 理财风险评级 **/
	@Column(name = "FIN_RISK_LEV", unique = false, nullable = true, length = 10)
	private String finRiskLev;
	
	/** 信贷风险等级 **/
	@Column(name = "RISK_LEV", unique = false, nullable = true, length = 10)
	private String riskLev;
	
	/** 风险等级有效期 **/
	@Column(name = "RISK_LEV_VALID_DT", unique = false, nullable = true, length = 8)
	private String riskLevValidDt;
	
	/** 联系手机(首选) **/
	@Column(name = "PHONE_NO", unique = false, nullable = true, length = 30)
	private String phoneNo;
	
	/** 联系地址(首选) **/
	@Column(name = "CONT_ADDR", unique = false, nullable = true, length = 200)
	private String contAddr;
	
	/** 客户服务等级 **/
	@Column(name = "SERV_LEV", unique = false, nullable = true, length = 20)
	private String servLev;
	
	/** 客户价值等级 **/
	@Column(name = "VALUE_LEV", unique = false, nullable = true, length = 20)
	private String valueLev;
	
	/** 主办客户经理编号 **/
	@Column(name = "BELONG_MGR", unique = false, nullable = true, length = 40)
	private String belongMgr;
	
	/** 主办客户机构编号 **/
	@Column(name = "BELONG_BRCH", unique = false, nullable = true, length = 30)
	private String belongBrch;
	
	/** 客户照片 **/
	@Column(name = "CUST_PHOTO", unique = false, nullable = true, length = 500)
	private String custPhoto;
	
	/** 客户分配状态 1已分配归属 2未分配归属 **/
	@Column(name = "CUST_ASSIGN_STAT", unique = false, nullable = true, length = 20)
	private String custAssignStat;
	
	/** 客户状态 1正式客户 2潜在转正式客户 **/
	@Column(name = "CUST_STATUS", unique = false, nullable = true, length = 30)
	private String custStatus;
	
	/** 原系统客户状态 **/
	@Column(name = "SRC_CUST_STATUS", unique = false, nullable = true, length = 30)
	private String srcCustStatus;
	
	/** 是否贷款户 1是 0否 **/
	@Column(name = "IS_LOAN_CUST", unique = false, nullable = true, length = 20)
	private String isLoanCust;
	
	/** 是否股金户 1是 0否 **/
	@Column(name = "IS_STOCK_CUST", unique = false, nullable = true, length = 20)
	private String isStockCust;
	
	/** 是否VIP卡客户 1是 0否 **/
	@Column(name = "IS_CARD_VIP", unique = false, nullable = true, length = 20)
	private String isCardVip;
	
	/** 是否有效户 1是 0否 **/
	@Column(name = "EFFECT_FLG", unique = false, nullable = true, length = 10)
	private String effectFlg;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 300)
	private String remark;
	
	
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
	 * @param lastUpdateSys
	 */
	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys == null ? null : lastUpdateSys.trim();
	}
	
    /**
     * @return LastUpdateSys
     */	
	public String getLastUpdateSys() {
		return this.lastUpdateSys;
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
	 * @param ecifCustId
	 */
	public void setEcifCustId(String ecifCustId) {
		this.ecifCustId = ecifCustId == null ? null : ecifCustId.trim();
	}
	
    /**
     * @return EcifCustId
     */	
	public String getEcifCustId() {
		return this.ecifCustId;
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
	 * @param certType
	 */
	public void setCertType(String certType) {
		this.certType = certType == null ? null : certType.trim();
	}
	
    /**
     * @return CertType
     */	
	public String getCertType() {
		return this.certType;
	}
	
	/**
	 * @param certNo
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo == null ? null : certNo.trim();
	}
	
    /**
     * @return CertNo
     */	
	public String getCertNo() {
		return this.certNo;
	}
	
	/**
	 * @param pinyinName
	 */
	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName == null ? null : pinyinName.trim();
	}
	
    /**
     * @return PinyinName
     */	
	public String getPinyinName() {
		return this.pinyinName;
	}
	
	/**
	 * @param otherName
	 */
	public void setOtherName(String otherName) {
		this.otherName = otherName == null ? null : otherName.trim();
	}
	
    /**
     * @return OtherName
     */	
	public String getOtherName() {
		return this.otherName;
	}
	
	/**
	 * @param titleCd
	 */
	public void setTitleCd(String titleCd) {
		this.titleCd = titleCd == null ? null : titleCd.trim();
	}
	
    /**
     * @return TitleCd
     */	
	public String getTitleCd() {
		return this.titleCd;
	}
	
	/**
	 * @param englishName
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName == null ? null : englishName.trim();
	}
	
    /**
     * @return EnglishName
     */	
	public String getEnglishName() {
		return this.englishName;
	}
	
	/**
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}
	
    /**
     * @return Sex
     */	
	public String getSex() {
		return this.sex;
	}
	
	/**
	 * @param nation
	 */
	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}
	
    /**
     * @return Nation
     */	
	public String getNation() {
		return this.nation;
	}
	
	/**
	 * @param birthDt
	 */
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt == null ? null : birthDt.trim();
	}
	
    /**
     * @return BirthDt
     */	
	public String getBirthDt() {
		return this.birthDt;
	}
	
	/**
	 * @param age
	 */
	public void setAge(java.math.BigDecimal age) {
		this.age = age;
	}
	
    /**
     * @return Age
     */	
	public java.math.BigDecimal getAge() {
		return this.age;
	}
	
	/**
	 * @param brnPlace
	 */
	public void setBrnPlace(String brnPlace) {
		this.brnPlace = brnPlace == null ? null : brnPlace.trim();
	}
	
    /**
     * @return BrnPlace
     */	
	public String getBrnPlace() {
		return this.brnPlace;
	}
	
	/**
	 * @param indivOcc
	 */
	public void setIndivOcc(String indivOcc) {
		this.indivOcc = indivOcc == null ? null : indivOcc.trim();
	}
	
    /**
     * @return IndivOcc
     */	
	public String getIndivOcc() {
		return this.indivOcc;
	}
	
	/**
	 * @param polStat
	 */
	public void setPolStat(String polStat) {
		this.polStat = polStat == null ? null : polStat.trim();
	}
	
    /**
     * @return PolStat
     */	
	public String getPolStat() {
		return this.polStat;
	}
	
	/**
	 * @param regPlace
	 */
	public void setRegPlace(String regPlace) {
		this.regPlace = regPlace == null ? null : regPlace.trim();
	}
	
    /**
     * @return RegPlace
     */	
	public String getRegPlace() {
		return this.regPlace;
	}
	
	/**
	 * @param hltStat
	 */
	public void setHltStat(String hltStat) {
		this.hltStat = hltStat == null ? null : hltStat.trim();
	}
	
    /**
     * @return HltStat
     */	
	public String getHltStat() {
		return this.hltStat;
	}
	
	/**
	 * @param marriStat
	 */
	public void setMarriStat(String marriStat) {
		this.marriStat = marriStat == null ? null : marriStat.trim();
	}
	
    /**
     * @return MarriStat
     */	
	public String getMarriStat() {
		return this.marriStat;
	}
	
	/**
	 * @param faithStat
	 */
	public void setFaithStat(String faithStat) {
		this.faithStat = faithStat == null ? null : faithStat.trim();
	}
	
    /**
     * @return FaithStat
     */	
	public String getFaithStat() {
		return this.faithStat;
	}
	
	/**
	 * @param countryCd
	 */
	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd == null ? null : countryCd.trim();
	}
	
    /**
     * @return CountryCd
     */	
	public String getCountryCd() {
		return this.countryCd;
	}
	
	/**
	 * @param langCd
	 */
	public void setLangCd(String langCd) {
		this.langCd = langCd == null ? null : langCd.trim();
	}
	
    /**
     * @return LangCd
     */	
	public String getLangCd() {
		return this.langCd;
	}
	
	/**
	 * @param higEduRec
	 */
	public void setHigEduRec(String higEduRec) {
		this.higEduRec = higEduRec == null ? null : higEduRec.trim();
	}
	
    /**
     * @return HigEduRec
     */	
	public String getHigEduRec() {
		return this.higEduRec;
	}
	
	/**
	 * @param higEduDgr
	 */
	public void setHigEduDgr(String higEduDgr) {
		this.higEduDgr = higEduDgr == null ? null : higEduDgr.trim();
	}
	
    /**
     * @return HigEduDgr
     */	
	public String getHigEduDgr() {
		return this.higEduDgr;
	}
	
	/**
	 * @param residentStat
	 */
	public void setResidentStat(String residentStat) {
		this.residentStat = residentStat == null ? null : residentStat.trim();
	}
	
    /**
     * @return ResidentStat
     */	
	public String getResidentStat() {
		return this.residentStat;
	}
	
	/**
	 * @param passportFlg
	 */
	public void setPassportFlg(String passportFlg) {
		this.passportFlg = passportFlg == null ? null : passportFlg.trim();
	}
	
    /**
     * @return PassportFlg
     */	
	public String getPassportFlg() {
		return this.passportFlg;
	}
	
	/**
	 * @param agriFlg
	 */
	public void setAgriFlg(String agriFlg) {
		this.agriFlg = agriFlg == null ? null : agriFlg.trim();
	}
	
    /**
     * @return AgriFlg
     */	
	public String getAgriFlg() {
		return this.agriFlg;
	}
	
	/**
	 * @param staffFlg
	 */
	public void setStaffFlg(String staffFlg) {
		this.staffFlg = staffFlg == null ? null : staffFlg.trim();
	}
	
    /**
     * @return StaffFlg
     */	
	public String getStaffFlg() {
		return this.staffFlg;
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
	 * @param inspInd
	 */
	public void setInspInd(String inspInd) {
		this.inspInd = inspInd == null ? null : inspInd.trim();
	}
	
    /**
     * @return InspInd
     */	
	public String getInspInd() {
		return this.inspInd;
	}
	
	/**
	 * @param custBankRel
	 */
	public void setCustBankRel(String custBankRel) {
		this.custBankRel = custBankRel == null ? null : custBankRel.trim();
	}
	
    /**
     * @return CustBankRel
     */	
	public String getCustBankRel() {
		return this.custBankRel;
	}
	
	/**
	 * @param comInitLoanDate
	 */
	public void setComInitLoanDate(String comInitLoanDate) {
		this.comInitLoanDate = comInitLoanDate == null ? null : comInitLoanDate.trim();
	}
	
    /**
     * @return ComInitLoanDate
     */	
	public String getComInitLoanDate() {
		return this.comInitLoanDate;
	}
	
	/**
	 * @param loanCustType
	 */
	public void setLoanCustType(String loanCustType) {
		this.loanCustType = loanCustType == null ? null : loanCustType.trim();
	}
	
    /**
     * @return LoanCustType
     */	
	public String getLoanCustType() {
		return this.loanCustType;
	}
	
	/**
	 * @param perIncomeY
	 */
	public void setPerIncomeY(java.math.BigDecimal perIncomeY) {
		this.perIncomeY = perIncomeY;
	}
	
    /**
     * @return PerIncomeY
     */	
	public java.math.BigDecimal getPerIncomeY() {
		return this.perIncomeY;
	}
	
	/**
	 * @param famIncomeY
	 */
	public void setFamIncomeY(java.math.BigDecimal famIncomeY) {
		this.famIncomeY = famIncomeY;
	}
	
    /**
     * @return FamIncomeY
     */	
	public java.math.BigDecimal getFamIncomeY() {
		return this.famIncomeY;
	}
	
	/**
	 * @param workUnit
	 */
	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit == null ? null : workUnit.trim();
	}
	
    /**
     * @return WorkUnit
     */	
	public String getWorkUnit() {
		return this.workUnit;
	}
	
	/**
	 * @param socSecurStat
	 */
	public void setSocSecurStat(String socSecurStat) {
		this.socSecurStat = socSecurStat == null ? null : socSecurStat.trim();
	}
	
    /**
     * @return SocSecurStat
     */	
	public String getSocSecurStat() {
		return this.socSecurStat;
	}
	
	/**
	 * @param beCustDate
	 */
	public void setBeCustDate(String beCustDate) {
		this.beCustDate = beCustDate == null ? null : beCustDate.trim();
	}
	
    /**
     * @return BeCustDate
     */	
	public String getBeCustDate() {
		return this.beCustDate;
	}
	
	/**
	 * @param bankDuty
	 */
	public void setBankDuty(String bankDuty) {
		this.bankDuty = bankDuty == null ? null : bankDuty.trim();
	}
	
    /**
     * @return BankDuty
     */	
	public String getBankDuty() {
		return this.bankDuty;
	}
	
	/**
	 * @param holdStockAmt
	 */
	public void setHoldStockAmt(java.math.BigDecimal holdStockAmt) {
		this.holdStockAmt = holdStockAmt;
	}
	
    /**
     * @return HoldStockAmt
     */	
	public java.math.BigDecimal getHoldStockAmt() {
		return this.holdStockAmt;
	}
	
	/**
	 * @param holdStockTot
	 */
	public void setHoldStockTot(java.math.BigDecimal holdStockTot) {
		this.holdStockTot = holdStockTot;
	}
	
    /**
     * @return HoldStockTot
     */	
	public java.math.BigDecimal getHoldStockTot() {
		return this.holdStockTot;
	}
	
	/**
	 * @param finRiskLev
	 */
	public void setFinRiskLev(String finRiskLev) {
		this.finRiskLev = finRiskLev == null ? null : finRiskLev.trim();
	}
	
    /**
     * @return FinRiskLev
     */	
	public String getFinRiskLev() {
		return this.finRiskLev;
	}
	
	/**
	 * @param riskLev
	 */
	public void setRiskLev(String riskLev) {
		this.riskLev = riskLev == null ? null : riskLev.trim();
	}
	
    /**
     * @return RiskLev
     */	
	public String getRiskLev() {
		return this.riskLev;
	}
	
	/**
	 * @param riskLevValidDt
	 */
	public void setRiskLevValidDt(String riskLevValidDt) {
		this.riskLevValidDt = riskLevValidDt == null ? null : riskLevValidDt.trim();
	}
	
    /**
     * @return RiskLevValidDt
     */	
	public String getRiskLevValidDt() {
		return this.riskLevValidDt;
	}
	
	/**
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo == null ? null : phoneNo.trim();
	}
	
    /**
     * @return PhoneNo
     */	
	public String getPhoneNo() {
		return this.phoneNo;
	}
	
	/**
	 * @param contAddr
	 */
	public void setContAddr(String contAddr) {
		this.contAddr = contAddr == null ? null : contAddr.trim();
	}
	
    /**
     * @return ContAddr
     */	
	public String getContAddr() {
		return this.contAddr;
	}
	
	/**
	 * @param servLev
	 */
	public void setServLev(String servLev) {
		this.servLev = servLev == null ? null : servLev.trim();
	}
	
    /**
     * @return ServLev
     */	
	public String getServLev() {
		return this.servLev;
	}
	
	/**
	 * @param valueLev
	 */
	public void setValueLev(String valueLev) {
		this.valueLev = valueLev == null ? null : valueLev.trim();
	}
	
    /**
     * @return ValueLev
     */	
	public String getValueLev() {
		return this.valueLev;
	}
	
	/**
	 * @param belongMgr
	 */
	public void setBelongMgr(String belongMgr) {
		this.belongMgr = belongMgr == null ? null : belongMgr.trim();
	}
	
    /**
     * @return BelongMgr
     */	
	public String getBelongMgr() {
		return this.belongMgr;
	}
	
	/**
	 * @param belongBrch
	 */
	public void setBelongBrch(String belongBrch) {
		this.belongBrch = belongBrch == null ? null : belongBrch.trim();
	}
	
    /**
     * @return BelongBrch
     */	
	public String getBelongBrch() {
		return this.belongBrch;
	}
	
	/**
	 * @param custPhoto
	 */
	public void setCustPhoto(String custPhoto) {
		this.custPhoto = custPhoto == null ? null : custPhoto.trim();
	}
	
    /**
     * @return CustPhoto
     */	
	public String getCustPhoto() {
		return this.custPhoto;
	}
	
	/**
	 * @param custAssignStat
	 */
	public void setCustAssignStat(String custAssignStat) {
		this.custAssignStat = custAssignStat == null ? null : custAssignStat.trim();
	}
	
    /**
     * @return CustAssignStat
     */	
	public String getCustAssignStat() {
		return this.custAssignStat;
	}
	
	/**
	 * @param custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus == null ? null : custStatus.trim();
	}
	
    /**
     * @return CustStatus
     */	
	public String getCustStatus() {
		return this.custStatus;
	}
	
	/**
	 * @param srcCustStatus
	 */
	public void setSrcCustStatus(String srcCustStatus) {
		this.srcCustStatus = srcCustStatus == null ? null : srcCustStatus.trim();
	}
	
    /**
     * @return SrcCustStatus
     */	
	public String getSrcCustStatus() {
		return this.srcCustStatus;
	}
	
	/**
	 * @param isLoanCust
	 */
	public void setIsLoanCust(String isLoanCust) {
		this.isLoanCust = isLoanCust == null ? null : isLoanCust.trim();
	}
	
    /**
     * @return IsLoanCust
     */	
	public String getIsLoanCust() {
		return this.isLoanCust;
	}
	
	/**
	 * @param isStockCust
	 */
	public void setIsStockCust(String isStockCust) {
		this.isStockCust = isStockCust == null ? null : isStockCust.trim();
	}
	
    /**
     * @return IsStockCust
     */	
	public String getIsStockCust() {
		return this.isStockCust;
	}
	
	/**
	 * @param isCardVip
	 */
	public void setIsCardVip(String isCardVip) {
		this.isCardVip = isCardVip == null ? null : isCardVip.trim();
	}
	
    /**
     * @return IsCardVip
     */	
	public String getIsCardVip() {
		return this.isCardVip;
	}
	
	/**
	 * @param effectFlg
	 */
	public void setEffectFlg(String effectFlg) {
		this.effectFlg = effectFlg == null ? null : effectFlg.trim();
	}
	
    /**
     * @return EffectFlg
     */	
	public String getEffectFlg() {
		return this.effectFlg;
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
        AcrmFciPerCust other = (AcrmFciPerCust) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getLastUpdateOrg() == null ? other.getLastUpdateOrg() == null : this.getLastUpdateOrg().equals(other.getLastUpdateOrg()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getEcifCustId() == null ? other.getEcifCustId() == null : this.getEcifCustId().equals(other.getEcifCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getPinyinName() == null ? other.getPinyinName() == null : this.getPinyinName().equals(other.getPinyinName()))
        	&& (this.getOtherName() == null ? other.getOtherName() == null : this.getOtherName().equals(other.getOtherName()))
        	&& (this.getTitleCd() == null ? other.getTitleCd() == null : this.getTitleCd().equals(other.getTitleCd()))
        	&& (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
        	&& (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
        	&& (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
        	&& (this.getBirthDt() == null ? other.getBirthDt() == null : this.getBirthDt().equals(other.getBirthDt()))
                	&& (this.getBrnPlace() == null ? other.getBrnPlace() == null : this.getBrnPlace().equals(other.getBrnPlace()))
        	&& (this.getIndivOcc() == null ? other.getIndivOcc() == null : this.getIndivOcc().equals(other.getIndivOcc()))
        	&& (this.getPolStat() == null ? other.getPolStat() == null : this.getPolStat().equals(other.getPolStat()))
        	&& (this.getRegPlace() == null ? other.getRegPlace() == null : this.getRegPlace().equals(other.getRegPlace()))
        	&& (this.getHltStat() == null ? other.getHltStat() == null : this.getHltStat().equals(other.getHltStat()))
        	&& (this.getMarriStat() == null ? other.getMarriStat() == null : this.getMarriStat().equals(other.getMarriStat()))
        	&& (this.getFaithStat() == null ? other.getFaithStat() == null : this.getFaithStat().equals(other.getFaithStat()))
        	&& (this.getCountryCd() == null ? other.getCountryCd() == null : this.getCountryCd().equals(other.getCountryCd()))
        	&& (this.getLangCd() == null ? other.getLangCd() == null : this.getLangCd().equals(other.getLangCd()))
        	&& (this.getHigEduRec() == null ? other.getHigEduRec() == null : this.getHigEduRec().equals(other.getHigEduRec()))
        	&& (this.getHigEduDgr() == null ? other.getHigEduDgr() == null : this.getHigEduDgr().equals(other.getHigEduDgr()))
        	&& (this.getResidentStat() == null ? other.getResidentStat() == null : this.getResidentStat().equals(other.getResidentStat()))
        	&& (this.getPassportFlg() == null ? other.getPassportFlg() == null : this.getPassportFlg().equals(other.getPassportFlg()))
        	&& (this.getAgriFlg() == null ? other.getAgriFlg() == null : this.getAgriFlg().equals(other.getAgriFlg()))
        	&& (this.getStaffFlg() == null ? other.getStaffFlg() == null : this.getStaffFlg().equals(other.getStaffFlg()))
        	&& (this.getHolderFlg() == null ? other.getHolderFlg() == null : this.getHolderFlg().equals(other.getHolderFlg()))
        	&& (this.getInspInd() == null ? other.getInspInd() == null : this.getInspInd().equals(other.getInspInd()))
        	&& (this.getCustBankRel() == null ? other.getCustBankRel() == null : this.getCustBankRel().equals(other.getCustBankRel()))
        	&& (this.getComInitLoanDate() == null ? other.getComInitLoanDate() == null : this.getComInitLoanDate().equals(other.getComInitLoanDate()))
        	&& (this.getLoanCustType() == null ? other.getLoanCustType() == null : this.getLoanCustType().equals(other.getLoanCustType()))
                        	&& (this.getWorkUnit() == null ? other.getWorkUnit() == null : this.getWorkUnit().equals(other.getWorkUnit()))
        	&& (this.getSocSecurStat() == null ? other.getSocSecurStat() == null : this.getSocSecurStat().equals(other.getSocSecurStat()))
        	&& (this.getBeCustDate() == null ? other.getBeCustDate() == null : this.getBeCustDate().equals(other.getBeCustDate()))
        	&& (this.getBankDuty() == null ? other.getBankDuty() == null : this.getBankDuty().equals(other.getBankDuty()))
                        	&& (this.getFinRiskLev() == null ? other.getFinRiskLev() == null : this.getFinRiskLev().equals(other.getFinRiskLev()))
        	&& (this.getRiskLev() == null ? other.getRiskLev() == null : this.getRiskLev().equals(other.getRiskLev()))
        	&& (this.getRiskLevValidDt() == null ? other.getRiskLevValidDt() == null : this.getRiskLevValidDt().equals(other.getRiskLevValidDt()))
        	&& (this.getPhoneNo() == null ? other.getPhoneNo() == null : this.getPhoneNo().equals(other.getPhoneNo()))
        	&& (this.getContAddr() == null ? other.getContAddr() == null : this.getContAddr().equals(other.getContAddr()))
        	&& (this.getServLev() == null ? other.getServLev() == null : this.getServLev().equals(other.getServLev()))
        	&& (this.getValueLev() == null ? other.getValueLev() == null : this.getValueLev().equals(other.getValueLev()))
        	&& (this.getBelongMgr() == null ? other.getBelongMgr() == null : this.getBelongMgr().equals(other.getBelongMgr()))
        	&& (this.getBelongBrch() == null ? other.getBelongBrch() == null : this.getBelongBrch().equals(other.getBelongBrch()))
        	&& (this.getCustPhoto() == null ? other.getCustPhoto() == null : this.getCustPhoto().equals(other.getCustPhoto()))
        	&& (this.getCustAssignStat() == null ? other.getCustAssignStat() == null : this.getCustAssignStat().equals(other.getCustAssignStat()))
        	&& (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
        	&& (this.getSrcCustStatus() == null ? other.getSrcCustStatus() == null : this.getSrcCustStatus().equals(other.getSrcCustStatus()))
        	&& (this.getIsLoanCust() == null ? other.getIsLoanCust() == null : this.getIsLoanCust().equals(other.getIsLoanCust()))
        	&& (this.getIsStockCust() == null ? other.getIsStockCust() == null : this.getIsStockCust().equals(other.getIsStockCust()))
        	&& (this.getIsCardVip() == null ? other.getIsCardVip() == null : this.getIsCardVip().equals(other.getIsCardVip()))
        	&& (this.getEffectFlg() == null ? other.getEffectFlg() == null : this.getEffectFlg().equals(other.getEffectFlg()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastUpdateSys() == null) ? 0 : getLastUpdateSys().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateOrg() == null) ? 0 : getLastUpdateOrg().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getEcifCustId() == null) ? 0 : getEcifCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getPinyinName() == null) ? 0 : getPinyinName().hashCode());
        result = prime * result + ((getOtherName() == null) ? 0 : getOtherName().hashCode());
        result = prime * result + ((getTitleCd() == null) ? 0 : getTitleCd().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getBirthDt() == null) ? 0 : getBirthDt().hashCode());
        result = prime * result + ((getBrnPlace() == null) ? 0 : getBrnPlace().hashCode());
        result = prime * result + ((getIndivOcc() == null) ? 0 : getIndivOcc().hashCode());
        result = prime * result + ((getPolStat() == null) ? 0 : getPolStat().hashCode());
        result = prime * result + ((getRegPlace() == null) ? 0 : getRegPlace().hashCode());
        result = prime * result + ((getHltStat() == null) ? 0 : getHltStat().hashCode());
        result = prime * result + ((getMarriStat() == null) ? 0 : getMarriStat().hashCode());
        result = prime * result + ((getFaithStat() == null) ? 0 : getFaithStat().hashCode());
        result = prime * result + ((getCountryCd() == null) ? 0 : getCountryCd().hashCode());
        result = prime * result + ((getLangCd() == null) ? 0 : getLangCd().hashCode());
        result = prime * result + ((getHigEduRec() == null) ? 0 : getHigEduRec().hashCode());
        result = prime * result + ((getHigEduDgr() == null) ? 0 : getHigEduDgr().hashCode());
        result = prime * result + ((getResidentStat() == null) ? 0 : getResidentStat().hashCode());
        result = prime * result + ((getPassportFlg() == null) ? 0 : getPassportFlg().hashCode());
        result = prime * result + ((getAgriFlg() == null) ? 0 : getAgriFlg().hashCode());
        result = prime * result + ((getStaffFlg() == null) ? 0 : getStaffFlg().hashCode());
        result = prime * result + ((getHolderFlg() == null) ? 0 : getHolderFlg().hashCode());
        result = prime * result + ((getInspInd() == null) ? 0 : getInspInd().hashCode());
        result = prime * result + ((getCustBankRel() == null) ? 0 : getCustBankRel().hashCode());
        result = prime * result + ((getComInitLoanDate() == null) ? 0 : getComInitLoanDate().hashCode());
        result = prime * result + ((getLoanCustType() == null) ? 0 : getLoanCustType().hashCode());
        result = prime * result + ((getWorkUnit() == null) ? 0 : getWorkUnit().hashCode());
        result = prime * result + ((getSocSecurStat() == null) ? 0 : getSocSecurStat().hashCode());
        result = prime * result + ((getBeCustDate() == null) ? 0 : getBeCustDate().hashCode());
        result = prime * result + ((getBankDuty() == null) ? 0 : getBankDuty().hashCode());
        result = prime * result + ((getFinRiskLev() == null) ? 0 : getFinRiskLev().hashCode());
        result = prime * result + ((getRiskLev() == null) ? 0 : getRiskLev().hashCode());
        result = prime * result + ((getRiskLevValidDt() == null) ? 0 : getRiskLevValidDt().hashCode());
        result = prime * result + ((getPhoneNo() == null) ? 0 : getPhoneNo().hashCode());
        result = prime * result + ((getContAddr() == null) ? 0 : getContAddr().hashCode());
        result = prime * result + ((getServLev() == null) ? 0 : getServLev().hashCode());
        result = prime * result + ((getValueLev() == null) ? 0 : getValueLev().hashCode());
        result = prime * result + ((getBelongMgr() == null) ? 0 : getBelongMgr().hashCode());
        result = prime * result + ((getBelongBrch() == null) ? 0 : getBelongBrch().hashCode());
        result = prime * result + ((getCustPhoto() == null) ? 0 : getCustPhoto().hashCode());
        result = prime * result + ((getCustAssignStat() == null) ? 0 : getCustAssignStat().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
        result = prime * result + ((getSrcCustStatus() == null) ? 0 : getSrcCustStatus().hashCode());
        result = prime * result + ((getIsLoanCust() == null) ? 0 : getIsLoanCust().hashCode());
        result = prime * result + ((getIsStockCust() == null) ? 0 : getIsStockCust().hashCode());
        result = prime * result + ((getIsCardVip() == null) ? 0 : getIsCardVip().hashCode());
        result = prime * result + ((getEffectFlg() == null) ? 0 : getEffectFlg().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastUpdateSys=").append(lastUpdateSys);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", lastUpdateOrg=").append(lastUpdateOrg);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", ecifCustId=").append(ecifCustId);
		sb.append(", custName=").append(custName);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", pinyinName=").append(pinyinName);
		sb.append(", otherName=").append(otherName);
		sb.append(", titleCd=").append(titleCd);
		sb.append(", englishName=").append(englishName);
		sb.append(", sex=").append(sex);
		sb.append(", nation=").append(nation);
		sb.append(", birthDt=").append(birthDt);
		sb.append(", age=").append(age);
		sb.append(", brnPlace=").append(brnPlace);
		sb.append(", indivOcc=").append(indivOcc);
		sb.append(", polStat=").append(polStat);
		sb.append(", regPlace=").append(regPlace);
		sb.append(", hltStat=").append(hltStat);
		sb.append(", marriStat=").append(marriStat);
		sb.append(", faithStat=").append(faithStat);
		sb.append(", countryCd=").append(countryCd);
		sb.append(", langCd=").append(langCd);
		sb.append(", higEduRec=").append(higEduRec);
		sb.append(", higEduDgr=").append(higEduDgr);
		sb.append(", residentStat=").append(residentStat);
		sb.append(", passportFlg=").append(passportFlg);
		sb.append(", agriFlg=").append(agriFlg);
		sb.append(", staffFlg=").append(staffFlg);
		sb.append(", holderFlg=").append(holderFlg);
		sb.append(", inspInd=").append(inspInd);
		sb.append(", custBankRel=").append(custBankRel);
		sb.append(", comInitLoanDate=").append(comInitLoanDate);
		sb.append(", loanCustType=").append(loanCustType);
		sb.append(", perIncomeY=").append(perIncomeY);
		sb.append(", famIncomeY=").append(famIncomeY);
		sb.append(", workUnit=").append(workUnit);
		sb.append(", socSecurStat=").append(socSecurStat);
		sb.append(", beCustDate=").append(beCustDate);
		sb.append(", bankDuty=").append(bankDuty);
		sb.append(", holdStockAmt=").append(holdStockAmt);
		sb.append(", holdStockTot=").append(holdStockTot);
		sb.append(", finRiskLev=").append(finRiskLev);
		sb.append(", riskLev=").append(riskLev);
		sb.append(", riskLevValidDt=").append(riskLevValidDt);
		sb.append(", phoneNo=").append(phoneNo);
		sb.append(", contAddr=").append(contAddr);
		sb.append(", servLev=").append(servLev);
		sb.append(", valueLev=").append(valueLev);
		sb.append(", belongMgr=").append(belongMgr);
		sb.append(", belongBrch=").append(belongBrch);
		sb.append(", custPhoto=").append(custPhoto);
		sb.append(", custAssignStat=").append(custAssignStat);
		sb.append(", custStatus=").append(custStatus);
		sb.append(", srcCustStatus=").append(srcCustStatus);
		sb.append(", isLoanCust=").append(isLoanCust);
		sb.append(", isStockCust=").append(isStockCust);
		sb.append(", isCardVip=").append(isCardVip);
		sb.append(", effectFlg=").append(effectFlg);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}