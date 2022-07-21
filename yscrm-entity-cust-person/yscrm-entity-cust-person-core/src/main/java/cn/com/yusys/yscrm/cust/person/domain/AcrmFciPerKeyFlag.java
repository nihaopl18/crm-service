package cn.com.yusys.yscrm.cust.person.domain;

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
 * @类名称: AcrmFciPerKeyFlag
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-13 23:12:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_PER_KEY_FLAG")
public class AcrmFciPerKeyFlag extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
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
	@Transient
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 11)
	private Date lastUpdateTm;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 是否农户 **/
	@Column(name = "PEASANT_FLG", unique = false, nullable = true, length = 20)
	private String peasantFlg;
	
	/** 是否理财客户 **/
	@Column(name = "FINACE_FLAG", unique = false, nullable = true, length = 20)
	private String finaceFlag;
	
	/** 是否储蓄客户 **/
	@Column(name = "DEPOSIT_FLAG", unique = false, nullable = true, length = 20)
	private String depositFlag;
	
	/** 是否第三方存管客户 **/
	@Column(name = "THIRD_DEP_FLAG", unique = false, nullable = true, length = 20)
	private String thirdDepFlag;
	
	/** 是否有本行贷款 **/
	@Column(name = "STAFF_LOAN_FLAG", unique = false, nullable = true, length = 20)
	private String staffLoanFlag;
	
	/** 是否开通手机银行 **/
	@Column(name = "MOBILE_BANK_FLAG", unique = false, nullable = true, length = 20)
	private String mobileBankFlag;
	
	/** 是否存在不良贷款 **/
	@Column(name = "BADLOAN_FLAG", unique = false, nullable = true, length = 20)
	private String badloanFlag;
	
	/** 是否信用卡客户 **/
	@Column(name = "CREDITCARD_FLAG", unique = false, nullable = true, length = 20)
	private String creditcardFlag;
	
	/** 是否网银签约客户 **/
	@Column(name = "INTERNET_BANK_FLAG", unique = false, nullable = true, length = 20)
	private String internetBankFlag;
	
	/** 是否POS客户 **/
	@Column(name = "POS_FLAG", unique = false, nullable = true, length = 20)
	private String posFlag;
	
	/** 是否问题贷款 **/
	@Column(name = "QUEST_LOAN_FLAG", unique = false, nullable = true, length = 20)
	private String questLoanFlag;
	
	/** 是否国际业务客户 **/
	@Column(name = "INTER_BUSI_FLG", unique = false, nullable = true, length = 20)
	private String interBusiFlg;
	
	/** 是否假借冒名 **/
	@Column(name = "ERRORNAME_FLAG", unique = false, nullable = true, length = 20)
	private String errornameFlag;
	
	/** 是否正式在职员工 **/
	@Column(name = "STAFF_FLG", unique = false, nullable = true, length = 20)
	private String staffFlg;
	
	/** 是否代发工资客户 **/
	@Column(name = "PAYROLL_FLG", unique = false, nullable = true, length = 20)
	private String payrollFlg;
	
	/** 是否留存照片 **/
	@Column(name = "KEEP_PHO_FLG", unique = false, nullable = true, length = 20)
	private String keepPhoFlg;
	
	/** 客户是否愿意接收短信 **/
	@Column(name = "REC_SMS_FLG", unique = false, nullable = true, length = 20)
	private String recSmsFlg;
	
	/** 是否本行/社VIP客户 **/
	@Column(name = "VIP_FLG", unique = false, nullable = true, length = 20)
	private String vipFlg;
	
	/** 是否小微贷客户 **/
	@Column(name = "XWD_FLG", unique = false, nullable = true, length = 20)
	private String xwdFlg;
	
	/** 是否公积金贷款户 **/
	@Column(name = "HOUSEFUND_LN_FLG", unique = false, nullable = true, length = 20)
	private String housefundLnFlg;
	
	/** 是否按揭户 **/
	@Column(name = "MORTGAGE_FLG", unique = false, nullable = true, length = 20)
	private String mortgageFlg;
	
	/** 是否公积金缴存户 **/
	@Column(name = "HOUSEFUND_FLG", unique = false, nullable = true, length = 20)
	private String housefundFlg;
	
	/** 是否事业编客户 **/
	@Column(name = "GOVER_FLG", unique = false, nullable = true, length = 20)
	private String goverFlg;
	
	/** 是否本行/社股东 **/
	@Column(name = "STOCKHOLDER_FLG", unique = false, nullable = true, length = 20)
	private String stockholderFlg;
	
	/** 是否村/居委会成员 **/
	@Column(name = "NEIGHB_FLG", unique = false, nullable = true, length = 20)
	private String neighbFlg;
	
	/** 是否企业实际控制人 **/
	@Column(name = "CNTR_FLG", unique = false, nullable = true, length = 20)
	private String cntrFlg;
	
	/** 是否企业股东 **/
	@Column(name = "ENT_STOCKHOLDER_FLG", unique = false, nullable = true, length = 20)
	private String entStockholderFlg;
	
	/** 是否担保人 **/
	@Column(name = "GUAR_FLG", unique = false, nullable = true, length = 20)
	private String guarFlg;
	
	/** 是否核心客户 **/
	@Column(name = "COR_CUST_FLG", unique = false, nullable = true, length = 20)
	private String corCustFlg;
	
	/** 是否他行VIP **/
	@Column(name = "OTHERB_VIP_FLG", unique = false, nullable = true, length = 20)
	private String otherbVipFlg;
	
	/** 是否员工家属 **/
	@Column(name = "STAFF_REL_FLG", unique = false, nullable = true, length = 20)
	private String staffRelFlg;
	
	/** 是否公务员 **/
	@Column(name = "CIVILSVER_FLG", unique = false, nullable = true, length = 20)
	private String civilsverFlg;
	
	/** 是否教师 **/
	@Column(name = "TEACHER_FLG", unique = false, nullable = true, length = 20)
	private String teacherFlg;
	
	/** 是否医生 **/
	@Column(name = "DOCTOR_FLG", unique = false, nullable = true, length = 20)
	private String doctorFlg;
	
	/** 自定义标签 **/
	@Column(name = "SELF_TAB", unique = false, nullable = true, length = 1000)
	private String selfTab;
	
	/** ID主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	/** 是否正式在职员工 **/
	@Column(name = "WORKER_FLG", unique = false, nullable = true, length = 20)
	private String workerFlg;
	
	
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
	 * @param peasantFlg
	 */
	public void setPeasantFlg(String peasantFlg) {
		this.peasantFlg = peasantFlg == null ? null : peasantFlg.trim();
	}
	
    /**
     * @return PeasantFlg
     */	
	public String getPeasantFlg() {
		return this.peasantFlg;
	}
	
	/**
	 * @param finaceFlag
	 */
	public void setFinaceFlag(String finaceFlag) {
		this.finaceFlag = finaceFlag == null ? null : finaceFlag.trim();
	}
	
    /**
     * @return FinaceFlag
     */	
	public String getFinaceFlag() {
		return this.finaceFlag;
	}
	
	/**
	 * @param depositFlag
	 */
	public void setDepositFlag(String depositFlag) {
		this.depositFlag = depositFlag == null ? null : depositFlag.trim();
	}
	
    /**
     * @return DepositFlag
     */	
	public String getDepositFlag() {
		return this.depositFlag;
	}
	
	/**
	 * @param thirdDepFlag
	 */
	public void setThirdDepFlag(String thirdDepFlag) {
		this.thirdDepFlag = thirdDepFlag == null ? null : thirdDepFlag.trim();
	}
	
    /**
     * @return ThirdDepFlag
     */	
	public String getThirdDepFlag() {
		return this.thirdDepFlag;
	}
	
	/**
	 * @param staffLoanFlag
	 */
	public void setStaffLoanFlag(String staffLoanFlag) {
		this.staffLoanFlag = staffLoanFlag == null ? null : staffLoanFlag.trim();
	}
	
    /**
     * @return StaffLoanFlag
     */	
	public String getStaffLoanFlag() {
		return this.staffLoanFlag;
	}
	
	/**
	 * @param mobileBankFlag
	 */
	public void setMobileBankFlag(String mobileBankFlag) {
		this.mobileBankFlag = mobileBankFlag == null ? null : mobileBankFlag.trim();
	}
	
    /**
     * @return MobileBankFlag
     */	
	public String getMobileBankFlag() {
		return this.mobileBankFlag;
	}
	
	/**
	 * @param badloanFlag
	 */
	public void setBadloanFlag(String badloanFlag) {
		this.badloanFlag = badloanFlag == null ? null : badloanFlag.trim();
	}
	
    /**
     * @return BadloanFlag
     */	
	public String getBadloanFlag() {
		return this.badloanFlag;
	}
	
	/**
	 * @param creditcardFlag
	 */
	public void setCreditcardFlag(String creditcardFlag) {
		this.creditcardFlag = creditcardFlag == null ? null : creditcardFlag.trim();
	}
	
    /**
     * @return CreditcardFlag
     */	
	public String getCreditcardFlag() {
		return this.creditcardFlag;
	}
	
	/**
	 * @param internetBankFlag
	 */
	public void setInternetBankFlag(String internetBankFlag) {
		this.internetBankFlag = internetBankFlag == null ? null : internetBankFlag.trim();
	}
	
    /**
     * @return InternetBankFlag
     */	
	public String getInternetBankFlag() {
		return this.internetBankFlag;
	}
	
	/**
	 * @param posFlag
	 */
	public void setPosFlag(String posFlag) {
		this.posFlag = posFlag == null ? null : posFlag.trim();
	}
	
    /**
     * @return PosFlag
     */	
	public String getPosFlag() {
		return this.posFlag;
	}
	
	/**
	 * @param questLoanFlag
	 */
	public void setQuestLoanFlag(String questLoanFlag) {
		this.questLoanFlag = questLoanFlag == null ? null : questLoanFlag.trim();
	}
	
    /**
     * @return QuestLoanFlag
     */	
	public String getQuestLoanFlag() {
		return this.questLoanFlag;
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
	 * @param errornameFlag
	 */
	public void setErrornameFlag(String errornameFlag) {
		this.errornameFlag = errornameFlag == null ? null : errornameFlag.trim();
	}
	
    /**
     * @return ErrornameFlag
     */	
	public String getErrornameFlag() {
		return this.errornameFlag;
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
	 * @param payrollFlg
	 */
	public void setPayrollFlg(String payrollFlg) {
		this.payrollFlg = payrollFlg == null ? null : payrollFlg.trim();
	}
	
    /**
     * @return PayrollFlg
     */	
	public String getPayrollFlg() {
		return this.payrollFlg;
	}
	
	/**
	 * @param keepPhoFlg
	 */
	public void setKeepPhoFlg(String keepPhoFlg) {
		this.keepPhoFlg = keepPhoFlg == null ? null : keepPhoFlg.trim();
	}
	
    /**
     * @return KeepPhoFlg
     */	
	public String getKeepPhoFlg() {
		return this.keepPhoFlg;
	}
	
	/**
	 * @param recSmsFlg
	 */
	public void setRecSmsFlg(String recSmsFlg) {
		this.recSmsFlg = recSmsFlg == null ? null : recSmsFlg.trim();
	}
	
    /**
     * @return RecSmsFlg
     */	
	public String getRecSmsFlg() {
		return this.recSmsFlg;
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
	 * @param xwdFlg
	 */
	public void setXwdFlg(String xwdFlg) {
		this.xwdFlg = xwdFlg == null ? null : xwdFlg.trim();
	}
	
    /**
     * @return XwdFlg
     */	
	public String getXwdFlg() {
		return this.xwdFlg;
	}
	
	/**
	 * @param housefundLnFlg
	 */
	public void setHousefundLnFlg(String housefundLnFlg) {
		this.housefundLnFlg = housefundLnFlg == null ? null : housefundLnFlg.trim();
	}
	
    /**
     * @return HousefundLnFlg
     */	
	public String getHousefundLnFlg() {
		return this.housefundLnFlg;
	}
	
	/**
	 * @param mortgageFlg
	 */
	public void setMortgageFlg(String mortgageFlg) {
		this.mortgageFlg = mortgageFlg == null ? null : mortgageFlg.trim();
	}
	
    /**
     * @return MortgageFlg
     */	
	public String getMortgageFlg() {
		return this.mortgageFlg;
	}
	
	/**
	 * @param housefundFlg
	 */
	public void setHousefundFlg(String housefundFlg) {
		this.housefundFlg = housefundFlg == null ? null : housefundFlg.trim();
	}
	
    /**
     * @return HousefundFlg
     */	
	public String getHousefundFlg() {
		return this.housefundFlg;
	}
	
	/**
	 * @param goverFlg
	 */
	public void setGoverFlg(String goverFlg) {
		this.goverFlg = goverFlg == null ? null : goverFlg.trim();
	}
	
    /**
     * @return GoverFlg
     */	
	public String getGoverFlg() {
		return this.goverFlg;
	}
	
	/**
	 * @param stockholderFlg
	 */
	public void setStockholderFlg(String stockholderFlg) {
		this.stockholderFlg = stockholderFlg == null ? null : stockholderFlg.trim();
	}
	
    /**
     * @return StockholderFlg
     */	
	public String getStockholderFlg() {
		return this.stockholderFlg;
	}
	
	/**
	 * @param neighbFlg
	 */
	public void setNeighbFlg(String neighbFlg) {
		this.neighbFlg = neighbFlg == null ? null : neighbFlg.trim();
	}
	
    /**
     * @return NeighbFlg
     */	
	public String getNeighbFlg() {
		return this.neighbFlg;
	}
	
	/**
	 * @param cntrFlg
	 */
	public void setCntrFlg(String cntrFlg) {
		this.cntrFlg = cntrFlg == null ? null : cntrFlg.trim();
	}
	
    /**
     * @return CntrFlg
     */	
	public String getCntrFlg() {
		return this.cntrFlg;
	}
	
	/**
	 * @param entStockholderFlg
	 */
	public void setEntStockholderFlg(String entStockholderFlg) {
		this.entStockholderFlg = entStockholderFlg == null ? null : entStockholderFlg.trim();
	}
	
    /**
     * @return EntStockholderFlg
     */	
	public String getEntStockholderFlg() {
		return this.entStockholderFlg;
	}
	
	/**
	 * @param guarFlg
	 */
	public void setGuarFlg(String guarFlg) {
		this.guarFlg = guarFlg == null ? null : guarFlg.trim();
	}
	
    /**
     * @return GuarFlg
     */	
	public String getGuarFlg() {
		return this.guarFlg;
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
	 * @param otherbVipFlg
	 */
	public void setOtherbVipFlg(String otherbVipFlg) {
		this.otherbVipFlg = otherbVipFlg == null ? null : otherbVipFlg.trim();
	}
	
    /**
     * @return OtherbVipFlg
     */	
	public String getOtherbVipFlg() {
		return this.otherbVipFlg;
	}
	
	/**
	 * @param staffRelFlg
	 */
	public void setStaffRelFlg(String staffRelFlg) {
		this.staffRelFlg = staffRelFlg == null ? null : staffRelFlg.trim();
	}
	
    /**
     * @return StaffRelFlg
     */	
	public String getStaffRelFlg() {
		return this.staffRelFlg;
	}
	
	/**
	 * @param civilsverFlg
	 */
	public void setCivilsverFlg(String civilsverFlg) {
		this.civilsverFlg = civilsverFlg == null ? null : civilsverFlg.trim();
	}
	
    /**
     * @return CivilsverFlg
     */	
	public String getCivilsverFlg() {
		return this.civilsverFlg;
	}
	
	/**
	 * @param teacherFlg
	 */
	public void setTeacherFlg(String teacherFlg) {
		this.teacherFlg = teacherFlg == null ? null : teacherFlg.trim();
	}
	
    /**
     * @return TeacherFlg
     */	
	public String getTeacherFlg() {
		return this.teacherFlg;
	}
	
	/**
	 * @param doctorFlg
	 */
	public void setDoctorFlg(String doctorFlg) {
		this.doctorFlg = doctorFlg == null ? null : doctorFlg.trim();
	}
	
    /**
     * @return DoctorFlg
     */	
	public String getDoctorFlg() {
		return this.doctorFlg;
	}
	
	/**
	 * @param selfTab
	 */
	public void setSelfTab(String selfTab) {
		this.selfTab = selfTab == null ? null : selfTab.trim();
	}
	
    /**
     * @return SelfTab
     */	
	public String getSelfTab() {
		return this.selfTab;
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
	 * @param workerFlg
	 */
	public void setWorkerFlg(String workerFlg) {
		this.workerFlg = workerFlg == null ? null : workerFlg.trim();
	}
	
    /**
     * @return WorkerFlg
     */	
	public String getWorkerFlg() {
		return this.workerFlg;
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
        AcrmFciPerKeyFlag other = (AcrmFciPerKeyFlag) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getPeasantFlg() == null ? other.getPeasantFlg() == null : this.getPeasantFlg().equals(other.getPeasantFlg()))
        	&& (this.getFinaceFlag() == null ? other.getFinaceFlag() == null : this.getFinaceFlag().equals(other.getFinaceFlag()))
        	&& (this.getDepositFlag() == null ? other.getDepositFlag() == null : this.getDepositFlag().equals(other.getDepositFlag()))
        	&& (this.getThirdDepFlag() == null ? other.getThirdDepFlag() == null : this.getThirdDepFlag().equals(other.getThirdDepFlag()))
        	&& (this.getStaffLoanFlag() == null ? other.getStaffLoanFlag() == null : this.getStaffLoanFlag().equals(other.getStaffLoanFlag()))
        	&& (this.getMobileBankFlag() == null ? other.getMobileBankFlag() == null : this.getMobileBankFlag().equals(other.getMobileBankFlag()))
        	&& (this.getBadloanFlag() == null ? other.getBadloanFlag() == null : this.getBadloanFlag().equals(other.getBadloanFlag()))
        	&& (this.getCreditcardFlag() == null ? other.getCreditcardFlag() == null : this.getCreditcardFlag().equals(other.getCreditcardFlag()))
        	&& (this.getInternetBankFlag() == null ? other.getInternetBankFlag() == null : this.getInternetBankFlag().equals(other.getInternetBankFlag()))
        	&& (this.getPosFlag() == null ? other.getPosFlag() == null : this.getPosFlag().equals(other.getPosFlag()))
        	&& (this.getQuestLoanFlag() == null ? other.getQuestLoanFlag() == null : this.getQuestLoanFlag().equals(other.getQuestLoanFlag()))
        	&& (this.getInterBusiFlg() == null ? other.getInterBusiFlg() == null : this.getInterBusiFlg().equals(other.getInterBusiFlg()))
        	&& (this.getErrornameFlag() == null ? other.getErrornameFlag() == null : this.getErrornameFlag().equals(other.getErrornameFlag()))
        	&& (this.getStaffFlg() == null ? other.getStaffFlg() == null : this.getStaffFlg().equals(other.getStaffFlg()))
        	&& (this.getPayrollFlg() == null ? other.getPayrollFlg() == null : this.getPayrollFlg().equals(other.getPayrollFlg()))
        	&& (this.getKeepPhoFlg() == null ? other.getKeepPhoFlg() == null : this.getKeepPhoFlg().equals(other.getKeepPhoFlg()))
        	&& (this.getRecSmsFlg() == null ? other.getRecSmsFlg() == null : this.getRecSmsFlg().equals(other.getRecSmsFlg()))
        	&& (this.getVipFlg() == null ? other.getVipFlg() == null : this.getVipFlg().equals(other.getVipFlg()))
        	&& (this.getXwdFlg() == null ? other.getXwdFlg() == null : this.getXwdFlg().equals(other.getXwdFlg()))
        	&& (this.getHousefundLnFlg() == null ? other.getHousefundLnFlg() == null : this.getHousefundLnFlg().equals(other.getHousefundLnFlg()))
        	&& (this.getMortgageFlg() == null ? other.getMortgageFlg() == null : this.getMortgageFlg().equals(other.getMortgageFlg()))
        	&& (this.getHousefundFlg() == null ? other.getHousefundFlg() == null : this.getHousefundFlg().equals(other.getHousefundFlg()))
        	&& (this.getGoverFlg() == null ? other.getGoverFlg() == null : this.getGoverFlg().equals(other.getGoverFlg()))
        	&& (this.getStockholderFlg() == null ? other.getStockholderFlg() == null : this.getStockholderFlg().equals(other.getStockholderFlg()))
        	&& (this.getNeighbFlg() == null ? other.getNeighbFlg() == null : this.getNeighbFlg().equals(other.getNeighbFlg()))
        	&& (this.getCntrFlg() == null ? other.getCntrFlg() == null : this.getCntrFlg().equals(other.getCntrFlg()))
        	&& (this.getEntStockholderFlg() == null ? other.getEntStockholderFlg() == null : this.getEntStockholderFlg().equals(other.getEntStockholderFlg()))
        	&& (this.getGuarFlg() == null ? other.getGuarFlg() == null : this.getGuarFlg().equals(other.getGuarFlg()))
        	&& (this.getCorCustFlg() == null ? other.getCorCustFlg() == null : this.getCorCustFlg().equals(other.getCorCustFlg()))
        	&& (this.getOtherbVipFlg() == null ? other.getOtherbVipFlg() == null : this.getOtherbVipFlg().equals(other.getOtherbVipFlg()))
        	&& (this.getStaffRelFlg() == null ? other.getStaffRelFlg() == null : this.getStaffRelFlg().equals(other.getStaffRelFlg()))
        	&& (this.getCivilsverFlg() == null ? other.getCivilsverFlg() == null : this.getCivilsverFlg().equals(other.getCivilsverFlg()))
        	&& (this.getTeacherFlg() == null ? other.getTeacherFlg() == null : this.getTeacherFlg().equals(other.getTeacherFlg()))
        	&& (this.getDoctorFlg() == null ? other.getDoctorFlg() == null : this.getDoctorFlg().equals(other.getDoctorFlg()))
        	&& (this.getSelfTab() == null ? other.getSelfTab() == null : this.getSelfTab().equals(other.getSelfTab()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getWorkerFlg() == null ? other.getWorkerFlg() == null : this.getWorkerFlg().equals(other.getWorkerFlg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastUpdateSys() == null) ? 0 : getLastUpdateSys().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getPeasantFlg() == null) ? 0 : getPeasantFlg().hashCode());
        result = prime * result + ((getFinaceFlag() == null) ? 0 : getFinaceFlag().hashCode());
        result = prime * result + ((getDepositFlag() == null) ? 0 : getDepositFlag().hashCode());
        result = prime * result + ((getThirdDepFlag() == null) ? 0 : getThirdDepFlag().hashCode());
        result = prime * result + ((getStaffLoanFlag() == null) ? 0 : getStaffLoanFlag().hashCode());
        result = prime * result + ((getMobileBankFlag() == null) ? 0 : getMobileBankFlag().hashCode());
        result = prime * result + ((getBadloanFlag() == null) ? 0 : getBadloanFlag().hashCode());
        result = prime * result + ((getCreditcardFlag() == null) ? 0 : getCreditcardFlag().hashCode());
        result = prime * result + ((getInternetBankFlag() == null) ? 0 : getInternetBankFlag().hashCode());
        result = prime * result + ((getPosFlag() == null) ? 0 : getPosFlag().hashCode());
        result = prime * result + ((getQuestLoanFlag() == null) ? 0 : getQuestLoanFlag().hashCode());
        result = prime * result + ((getInterBusiFlg() == null) ? 0 : getInterBusiFlg().hashCode());
        result = prime * result + ((getErrornameFlag() == null) ? 0 : getErrornameFlag().hashCode());
        result = prime * result + ((getStaffFlg() == null) ? 0 : getStaffFlg().hashCode());
        result = prime * result + ((getPayrollFlg() == null) ? 0 : getPayrollFlg().hashCode());
        result = prime * result + ((getKeepPhoFlg() == null) ? 0 : getKeepPhoFlg().hashCode());
        result = prime * result + ((getRecSmsFlg() == null) ? 0 : getRecSmsFlg().hashCode());
        result = prime * result + ((getVipFlg() == null) ? 0 : getVipFlg().hashCode());
        result = prime * result + ((getXwdFlg() == null) ? 0 : getXwdFlg().hashCode());
        result = prime * result + ((getHousefundLnFlg() == null) ? 0 : getHousefundLnFlg().hashCode());
        result = prime * result + ((getMortgageFlg() == null) ? 0 : getMortgageFlg().hashCode());
        result = prime * result + ((getHousefundFlg() == null) ? 0 : getHousefundFlg().hashCode());
        result = prime * result + ((getGoverFlg() == null) ? 0 : getGoverFlg().hashCode());
        result = prime * result + ((getStockholderFlg() == null) ? 0 : getStockholderFlg().hashCode());
        result = prime * result + ((getNeighbFlg() == null) ? 0 : getNeighbFlg().hashCode());
        result = prime * result + ((getCntrFlg() == null) ? 0 : getCntrFlg().hashCode());
        result = prime * result + ((getEntStockholderFlg() == null) ? 0 : getEntStockholderFlg().hashCode());
        result = prime * result + ((getGuarFlg() == null) ? 0 : getGuarFlg().hashCode());
        result = prime * result + ((getCorCustFlg() == null) ? 0 : getCorCustFlg().hashCode());
        result = prime * result + ((getOtherbVipFlg() == null) ? 0 : getOtherbVipFlg().hashCode());
        result = prime * result + ((getStaffRelFlg() == null) ? 0 : getStaffRelFlg().hashCode());
        result = prime * result + ((getCivilsverFlg() == null) ? 0 : getCivilsverFlg().hashCode());
        result = prime * result + ((getTeacherFlg() == null) ? 0 : getTeacherFlg().hashCode());
        result = prime * result + ((getDoctorFlg() == null) ? 0 : getDoctorFlg().hashCode());
        result = prime * result + ((getSelfTab() == null) ? 0 : getSelfTab().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWorkerFlg() == null) ? 0 : getWorkerFlg().hashCode());
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
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", peasantFlg=").append(peasantFlg);
		sb.append(", finaceFlag=").append(finaceFlag);
		sb.append(", depositFlag=").append(depositFlag);
		sb.append(", thirdDepFlag=").append(thirdDepFlag);
		sb.append(", staffLoanFlag=").append(staffLoanFlag);
		sb.append(", mobileBankFlag=").append(mobileBankFlag);
		sb.append(", badloanFlag=").append(badloanFlag);
		sb.append(", creditcardFlag=").append(creditcardFlag);
		sb.append(", internetBankFlag=").append(internetBankFlag);
		sb.append(", posFlag=").append(posFlag);
		sb.append(", questLoanFlag=").append(questLoanFlag);
		sb.append(", interBusiFlg=").append(interBusiFlg);
		sb.append(", errornameFlag=").append(errornameFlag);
		sb.append(", staffFlg=").append(staffFlg);
		sb.append(", payrollFlg=").append(payrollFlg);
		sb.append(", keepPhoFlg=").append(keepPhoFlg);
		sb.append(", recSmsFlg=").append(recSmsFlg);
		sb.append(", vipFlg=").append(vipFlg);
		sb.append(", xwdFlg=").append(xwdFlg);
		sb.append(", housefundLnFlg=").append(housefundLnFlg);
		sb.append(", mortgageFlg=").append(mortgageFlg);
		sb.append(", housefundFlg=").append(housefundFlg);
		sb.append(", goverFlg=").append(goverFlg);
		sb.append(", stockholderFlg=").append(stockholderFlg);
		sb.append(", neighbFlg=").append(neighbFlg);
		sb.append(", cntrFlg=").append(cntrFlg);
		sb.append(", entStockholderFlg=").append(entStockholderFlg);
		sb.append(", guarFlg=").append(guarFlg);
		sb.append(", corCustFlg=").append(corCustFlg);
		sb.append(", otherbVipFlg=").append(otherbVipFlg);
		sb.append(", staffRelFlg=").append(staffRelFlg);
		sb.append(", civilsverFlg=").append(civilsverFlg);
		sb.append(", teacherFlg=").append(teacherFlg);
		sb.append(", doctorFlg=").append(doctorFlg);
		sb.append(", selfTab=").append(selfTab);
		sb.append(", id=").append(id);
		sb.append(", workerFlg=").append(workerFlg);
        sb.append("]");
        return sb.toString();
    }
}