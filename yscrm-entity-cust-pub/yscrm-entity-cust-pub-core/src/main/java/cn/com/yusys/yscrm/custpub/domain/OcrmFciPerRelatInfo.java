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
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciPerRelatInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-29 15:47:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_RELAT_INFO")
public class OcrmFciPerRelatInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户号 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 更新机构 **/
	@Column(name = "LAST_ORG_ID", unique = false, nullable = true, length = 32)
	private String lastOrgId;
	
	/** 更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 更新时间 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 是否涉农客户 **/
	@Column(name = "WHE_AGR_REL_CUS", unique = false, nullable = true, length = 2)
	private String wheAgrRelCus;
	
	/** 是否三农领军人物 **/
	@Column(name = "WHE_THR_FAR_LEA_FIG", unique = false, nullable = true, length = 2)
	private String wheThrFarLeaFig;
	
	/** 是否专业大户 **/
	@Column(name = "WHE_PRO_LAR_HOU", unique = false, nullable = true, length = 2)
	private String wheProLarHou;
	
	/** 农村信用青年 **/
	@Column(name = "RURAL_CRE_YOUTH", unique = false, nullable = true, length = 2)
	private String ruralCreYouth;
	
	/** 是否家庭农场 **/
	@Column(name = "WHE_FAM_FARM", unique = false, nullable = true, length = 2)
	private String wheFamFarm;
	
	/** 科技示范户 **/
	@Column(name = "SCI_AND_TEC_DEM_HOU", unique = false, nullable = true, length = 2)
	private String sciAndTecDemHou;
	
	/** 示范户认定时间 **/
	@Column(name = "DEM_HOU_DET_TIME", unique = false, nullable = true, length = 2)
	private String demHouDetTime;
	
	/** 是否双基双赢客户 **/
	@Column(name = "WHE_DUAL_BASE_WIN_CUS", unique = false, nullable = true, length = 2)
	private String wheDualBaseWinCus;
	
	/** 是否移民 **/
	@Column(name = "WHE_IMM", unique = false, nullable = true, length = 2)
	private String wheImm;
	
	/** 是否贴息 **/
	@Column(name = "WHE_DIS", unique = false, nullable = true, length = 2)
	private String wheDis;
	
	/** 贴息级别 **/
	@Column(name = "DIS_LEVEL", unique = false, nullable = true, length = 2)
	private String disLevel;
	
	/** 是否农业科技创新 **/
	@Column(name = "WHE_AGR_SCI_TEC_INN", unique = false, nullable = true, length = 2)
	private String wheAgrSciTecInn;
	
	/** 是否新型农业经营主体 **/
	@Column(name = "WHE_NEW_AGR_MAN_SUB", unique = false, nullable = true, length = 20)
	private String wheNewAgrManSub;
	
	/** 主体类型 **/
	@Column(name = "PRI_TYPE", unique = false, nullable = true, length = 2)
	private String priType;
	
	/** 是否合作社成员 **/
	@Column(name = "WHE_COO_MEM", unique = false, nullable = true, length = 2)
	private String wheCooMem;
	
	/** 保险金额 **/
	@Column(name = "AMO_OF_INS", unique = false, nullable = true, length = 2)
	private String amoOfIns;
	
	/** 保险费 **/
	@Column(name = "INSURANCE", unique = false, nullable = true, length = 2)
	private String insurance;
	
	/** 保险险种 **/
	@Column(name = "INS_TYPE", unique = false, nullable = true, length = 2)
	private String insType;
	
	/** 是否扶贫贷款客户 **/
	@Column(name = "WHE_POV_ALL_LOAN_CUS", unique = false, nullable = true, length = 2)
	private String whePovAllLoanCus;
	
	/** 扶贫客户类型 **/
	@Column(name = "POV_ALL_CUS_TYPE", unique = false, nullable = true, length = 2)
	private String povAllCusType;
	
	/** 扶贫项目 **/
	@Column(name = "POV_ALL_PRO", unique = false, nullable = true, length = 2)
	private String povAllPro;
	
	/** 项目所在地 **/
	@Column(name = "PRO_LOC", unique = false, nullable = true, length = 2)
	private String proLoc;
	
	/** 是否支农再贷款 **/
	@Column(name = "WHE_REF_OF_AGR_LOA", unique = false, nullable = true, length = 2)
	private String wheRefOfAgrLoa;
	
	/** 专业合作社标识 **/
	@Column(name = "PRO_COO_LOGO", unique = false, nullable = true, length = 2)
	private String proCooLogo;
	
	/** 是否投向新农村 **/
	@Column(name = "WHE_TO_NEW_COU", unique = false, nullable = true, length = 2)
	private String wheToNewCou;
	
	/** 是否投向城镇化建设 **/
	@Column(name = "WHE_TO_CON_OF_URB", unique = false, nullable = true, length = 2)
	private String wheToConOfUrb;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	
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
	 * @param lastOrgId
	 */
	public void setLastOrgId(String lastOrgId) {
		this.lastOrgId = lastOrgId == null ? null : lastOrgId.trim();
	}
	
    /**
     * @return LastOrgId
     */	
	public String getLastOrgId() {
		return this.lastOrgId;
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
	 * @param wheAgrRelCus
	 */
	public void setWheAgrRelCus(String wheAgrRelCus) {
		this.wheAgrRelCus = wheAgrRelCus == null ? null : wheAgrRelCus.trim();
	}
	
    /**
     * @return WheAgrRelCus
     */	
	public String getWheAgrRelCus() {
		return this.wheAgrRelCus;
	}
	
	/**
	 * @param wheThrFarLeaFig
	 */
	public void setWheThrFarLeaFig(String wheThrFarLeaFig) {
		this.wheThrFarLeaFig = wheThrFarLeaFig == null ? null : wheThrFarLeaFig.trim();
	}
	
    /**
     * @return WheThrFarLeaFig
     */	
	public String getWheThrFarLeaFig() {
		return this.wheThrFarLeaFig;
	}
	
	/**
	 * @param wheProLarHou
	 */
	public void setWheProLarHou(String wheProLarHou) {
		this.wheProLarHou = wheProLarHou == null ? null : wheProLarHou.trim();
	}
	
    /**
     * @return WheProLarHou
     */	
	public String getWheProLarHou() {
		return this.wheProLarHou;
	}
	
	/**
	 * @param ruralCreYouth
	 */
	public void setRuralCreYouth(String ruralCreYouth) {
		this.ruralCreYouth = ruralCreYouth == null ? null : ruralCreYouth.trim();
	}
	
    /**
     * @return RuralCreYouth
     */	
	public String getRuralCreYouth() {
		return this.ruralCreYouth;
	}
	
	/**
	 * @param wheFamFarm
	 */
	public void setWheFamFarm(String wheFamFarm) {
		this.wheFamFarm = wheFamFarm == null ? null : wheFamFarm.trim();
	}
	
    /**
     * @return WheFamFarm
     */	
	public String getWheFamFarm() {
		return this.wheFamFarm;
	}
	
	/**
	 * @param sciAndTecDemHou
	 */
	public void setSciAndTecDemHou(String sciAndTecDemHou) {
		this.sciAndTecDemHou = sciAndTecDemHou == null ? null : sciAndTecDemHou.trim();
	}
	
    /**
     * @return SciAndTecDemHou
     */	
	public String getSciAndTecDemHou() {
		return this.sciAndTecDemHou;
	}
	
	/**
	 * @param demHouDetTime
	 */
	public void setDemHouDetTime(String demHouDetTime) {
		this.demHouDetTime = demHouDetTime == null ? null : demHouDetTime.trim();
	}
	
    /**
     * @return DemHouDetTime
     */	
	public String getDemHouDetTime() {
		return this.demHouDetTime;
	}
	
	/**
	 * @param wheDualBaseWinCus
	 */
	public void setWheDualBaseWinCus(String wheDualBaseWinCus) {
		this.wheDualBaseWinCus = wheDualBaseWinCus == null ? null : wheDualBaseWinCus.trim();
	}
	
    /**
     * @return WheDualBaseWinCus
     */	
	public String getWheDualBaseWinCus() {
		return this.wheDualBaseWinCus;
	}
	
	/**
	 * @param wheImm
	 */
	public void setWheImm(String wheImm) {
		this.wheImm = wheImm == null ? null : wheImm.trim();
	}
	
    /**
     * @return WheImm
     */	
	public String getWheImm() {
		return this.wheImm;
	}
	
	/**
	 * @param wheDis
	 */
	public void setWheDis(String wheDis) {
		this.wheDis = wheDis == null ? null : wheDis.trim();
	}
	
    /**
     * @return WheDis
     */	
	public String getWheDis() {
		return this.wheDis;
	}
	
	/**
	 * @param disLevel
	 */
	public void setDisLevel(String disLevel) {
		this.disLevel = disLevel == null ? null : disLevel.trim();
	}
	
    /**
     * @return DisLevel
     */	
	public String getDisLevel() {
		return this.disLevel;
	}
	
	/**
	 * @param wheAgrSciTecInn
	 */
	public void setWheAgrSciTecInn(String wheAgrSciTecInn) {
		this.wheAgrSciTecInn = wheAgrSciTecInn == null ? null : wheAgrSciTecInn.trim();
	}
	
    /**
     * @return WheAgrSciTecInn
     */	
	public String getWheAgrSciTecInn() {
		return this.wheAgrSciTecInn;
	}
	
	/**
	 * @param wheNewAgrManSub
	 */
	public void setWheNewAgrManSub(String wheNewAgrManSub) {
		this.wheNewAgrManSub = wheNewAgrManSub == null ? null : wheNewAgrManSub.trim();
	}
	
    /**
     * @return WheNewAgrManSub
     */	
	public String getWheNewAgrManSub() {
		return this.wheNewAgrManSub;
	}
	
	/**
	 * @param priType
	 */
	public void setPriType(String priType) {
		this.priType = priType == null ? null : priType.trim();
	}
	
    /**
     * @return PriType
     */	
	public String getPriType() {
		return this.priType;
	}
	
	/**
	 * @param wheCooMem
	 */
	public void setWheCooMem(String wheCooMem) {
		this.wheCooMem = wheCooMem == null ? null : wheCooMem.trim();
	}
	
    /**
     * @return WheCooMem
     */	
	public String getWheCooMem() {
		return this.wheCooMem;
	}
	
	/**
	 * @param amoOfIns
	 */
	public void setAmoOfIns(String amoOfIns) {
		this.amoOfIns = amoOfIns == null ? null : amoOfIns.trim();
	}
	
    /**
     * @return AmoOfIns
     */	
	public String getAmoOfIns() {
		return this.amoOfIns;
	}
	
	/**
	 * @param insurance
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance == null ? null : insurance.trim();
	}
	
    /**
     * @return Insurance
     */	
	public String getInsurance() {
		return this.insurance;
	}
	
	/**
	 * @param insType
	 */
	public void setInsType(String insType) {
		this.insType = insType == null ? null : insType.trim();
	}
	
    /**
     * @return InsType
     */	
	public String getInsType() {
		return this.insType;
	}
	
	/**
	 * @param whePovAllLoanCus
	 */
	public void setWhePovAllLoanCus(String whePovAllLoanCus) {
		this.whePovAllLoanCus = whePovAllLoanCus == null ? null : whePovAllLoanCus.trim();
	}
	
    /**
     * @return WhePovAllLoanCus
     */	
	public String getWhePovAllLoanCus() {
		return this.whePovAllLoanCus;
	}
	
	/**
	 * @param povAllCusType
	 */
	public void setPovAllCusType(String povAllCusType) {
		this.povAllCusType = povAllCusType == null ? null : povAllCusType.trim();
	}
	
    /**
     * @return PovAllCusType
     */	
	public String getPovAllCusType() {
		return this.povAllCusType;
	}
	
	/**
	 * @param povAllPro
	 */
	public void setPovAllPro(String povAllPro) {
		this.povAllPro = povAllPro == null ? null : povAllPro.trim();
	}
	
    /**
     * @return PovAllPro
     */	
	public String getPovAllPro() {
		return this.povAllPro;
	}
	
	/**
	 * @param proLoc
	 */
	public void setProLoc(String proLoc) {
		this.proLoc = proLoc == null ? null : proLoc.trim();
	}
	
    /**
     * @return ProLoc
     */	
	public String getProLoc() {
		return this.proLoc;
	}
	
	/**
	 * @param wheRefOfAgrLoa
	 */
	public void setWheRefOfAgrLoa(String wheRefOfAgrLoa) {
		this.wheRefOfAgrLoa = wheRefOfAgrLoa == null ? null : wheRefOfAgrLoa.trim();
	}
	
    /**
     * @return WheRefOfAgrLoa
     */	
	public String getWheRefOfAgrLoa() {
		return this.wheRefOfAgrLoa;
	}
	
	/**
	 * @param proCooLogo
	 */
	public void setProCooLogo(String proCooLogo) {
		this.proCooLogo = proCooLogo == null ? null : proCooLogo.trim();
	}
	
    /**
     * @return ProCooLogo
     */	
	public String getProCooLogo() {
		return this.proCooLogo;
	}
	
	/**
	 * @param wheToNewCou
	 */
	public void setWheToNewCou(String wheToNewCou) {
		this.wheToNewCou = wheToNewCou == null ? null : wheToNewCou.trim();
	}
	
    /**
     * @return WheToNewCou
     */	
	public String getWheToNewCou() {
		return this.wheToNewCou;
	}
	
	/**
	 * @param wheToConOfUrb
	 */
	public void setWheToConOfUrb(String wheToConOfUrb) {
		this.wheToConOfUrb = wheToConOfUrb == null ? null : wheToConOfUrb.trim();
	}
	
    /**
     * @return WheToConOfUrb
     */	
	public String getWheToConOfUrb() {
		return this.wheToConOfUrb;
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
        OcrmFciPerRelatInfo other = (OcrmFciPerRelatInfo) that;
		return (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getLastOrgId() == null ? other.getLastOrgId() == null : this.getLastOrgId().equals(other.getLastOrgId()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getWheAgrRelCus() == null ? other.getWheAgrRelCus() == null : this.getWheAgrRelCus().equals(other.getWheAgrRelCus()))
        	&& (this.getWheThrFarLeaFig() == null ? other.getWheThrFarLeaFig() == null : this.getWheThrFarLeaFig().equals(other.getWheThrFarLeaFig()))
        	&& (this.getWheProLarHou() == null ? other.getWheProLarHou() == null : this.getWheProLarHou().equals(other.getWheProLarHou()))
        	&& (this.getRuralCreYouth() == null ? other.getRuralCreYouth() == null : this.getRuralCreYouth().equals(other.getRuralCreYouth()))
        	&& (this.getWheFamFarm() == null ? other.getWheFamFarm() == null : this.getWheFamFarm().equals(other.getWheFamFarm()))
        	&& (this.getSciAndTecDemHou() == null ? other.getSciAndTecDemHou() == null : this.getSciAndTecDemHou().equals(other.getSciAndTecDemHou()))
        	&& (this.getDemHouDetTime() == null ? other.getDemHouDetTime() == null : this.getDemHouDetTime().equals(other.getDemHouDetTime()))
        	&& (this.getWheDualBaseWinCus() == null ? other.getWheDualBaseWinCus() == null : this.getWheDualBaseWinCus().equals(other.getWheDualBaseWinCus()))
        	&& (this.getWheImm() == null ? other.getWheImm() == null : this.getWheImm().equals(other.getWheImm()))
        	&& (this.getWheDis() == null ? other.getWheDis() == null : this.getWheDis().equals(other.getWheDis()))
        	&& (this.getDisLevel() == null ? other.getDisLevel() == null : this.getDisLevel().equals(other.getDisLevel()))
        	&& (this.getWheAgrSciTecInn() == null ? other.getWheAgrSciTecInn() == null : this.getWheAgrSciTecInn().equals(other.getWheAgrSciTecInn()))
        	&& (this.getWheNewAgrManSub() == null ? other.getWheNewAgrManSub() == null : this.getWheNewAgrManSub().equals(other.getWheNewAgrManSub()))
        	&& (this.getPriType() == null ? other.getPriType() == null : this.getPriType().equals(other.getPriType()))
        	&& (this.getWheCooMem() == null ? other.getWheCooMem() == null : this.getWheCooMem().equals(other.getWheCooMem()))
        	&& (this.getAmoOfIns() == null ? other.getAmoOfIns() == null : this.getAmoOfIns().equals(other.getAmoOfIns()))
        	&& (this.getInsurance() == null ? other.getInsurance() == null : this.getInsurance().equals(other.getInsurance()))
        	&& (this.getInsType() == null ? other.getInsType() == null : this.getInsType().equals(other.getInsType()))
        	&& (this.getWhePovAllLoanCus() == null ? other.getWhePovAllLoanCus() == null : this.getWhePovAllLoanCus().equals(other.getWhePovAllLoanCus()))
        	&& (this.getPovAllCusType() == null ? other.getPovAllCusType() == null : this.getPovAllCusType().equals(other.getPovAllCusType()))
        	&& (this.getPovAllPro() == null ? other.getPovAllPro() == null : this.getPovAllPro().equals(other.getPovAllPro()))
        	&& (this.getProLoc() == null ? other.getProLoc() == null : this.getProLoc().equals(other.getProLoc()))
        	&& (this.getWheRefOfAgrLoa() == null ? other.getWheRefOfAgrLoa() == null : this.getWheRefOfAgrLoa().equals(other.getWheRefOfAgrLoa()))
        	&& (this.getProCooLogo() == null ? other.getProCooLogo() == null : this.getProCooLogo().equals(other.getProCooLogo()))
        	&& (this.getWheToNewCou() == null ? other.getWheToNewCou() == null : this.getWheToNewCou().equals(other.getWheToNewCou()))
        	&& (this.getWheToConOfUrb() == null ? other.getWheToConOfUrb() == null : this.getWheToConOfUrb().equals(other.getWheToConOfUrb()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getLastOrgId() == null) ? 0 : getLastOrgId().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getWheAgrRelCus() == null) ? 0 : getWheAgrRelCus().hashCode());
        result = prime * result + ((getWheThrFarLeaFig() == null) ? 0 : getWheThrFarLeaFig().hashCode());
        result = prime * result + ((getWheProLarHou() == null) ? 0 : getWheProLarHou().hashCode());
        result = prime * result + ((getRuralCreYouth() == null) ? 0 : getRuralCreYouth().hashCode());
        result = prime * result + ((getWheFamFarm() == null) ? 0 : getWheFamFarm().hashCode());
        result = prime * result + ((getSciAndTecDemHou() == null) ? 0 : getSciAndTecDemHou().hashCode());
        result = prime * result + ((getDemHouDetTime() == null) ? 0 : getDemHouDetTime().hashCode());
        result = prime * result + ((getWheDualBaseWinCus() == null) ? 0 : getWheDualBaseWinCus().hashCode());
        result = prime * result + ((getWheImm() == null) ? 0 : getWheImm().hashCode());
        result = prime * result + ((getWheDis() == null) ? 0 : getWheDis().hashCode());
        result = prime * result + ((getDisLevel() == null) ? 0 : getDisLevel().hashCode());
        result = prime * result + ((getWheAgrSciTecInn() == null) ? 0 : getWheAgrSciTecInn().hashCode());
        result = prime * result + ((getWheNewAgrManSub() == null) ? 0 : getWheNewAgrManSub().hashCode());
        result = prime * result + ((getPriType() == null) ? 0 : getPriType().hashCode());
        result = prime * result + ((getWheCooMem() == null) ? 0 : getWheCooMem().hashCode());
        result = prime * result + ((getAmoOfIns() == null) ? 0 : getAmoOfIns().hashCode());
        result = prime * result + ((getInsurance() == null) ? 0 : getInsurance().hashCode());
        result = prime * result + ((getInsType() == null) ? 0 : getInsType().hashCode());
        result = prime * result + ((getWhePovAllLoanCus() == null) ? 0 : getWhePovAllLoanCus().hashCode());
        result = prime * result + ((getPovAllCusType() == null) ? 0 : getPovAllCusType().hashCode());
        result = prime * result + ((getPovAllPro() == null) ? 0 : getPovAllPro().hashCode());
        result = prime * result + ((getProLoc() == null) ? 0 : getProLoc().hashCode());
        result = prime * result + ((getWheRefOfAgrLoa() == null) ? 0 : getWheRefOfAgrLoa().hashCode());
        result = prime * result + ((getProCooLogo() == null) ? 0 : getProCooLogo().hashCode());
        result = prime * result + ((getWheToNewCou() == null) ? 0 : getWheToNewCou().hashCode());
        result = prime * result + ((getWheToConOfUrb() == null) ? 0 : getWheToConOfUrb().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custId=").append(custId);
		sb.append(", lastOrgId=").append(lastOrgId);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", wheAgrRelCus=").append(wheAgrRelCus);
		sb.append(", wheThrFarLeaFig=").append(wheThrFarLeaFig);
		sb.append(", wheProLarHou=").append(wheProLarHou);
		sb.append(", ruralCreYouth=").append(ruralCreYouth);
		sb.append(", wheFamFarm=").append(wheFamFarm);
		sb.append(", sciAndTecDemHou=").append(sciAndTecDemHou);
		sb.append(", demHouDetTime=").append(demHouDetTime);
		sb.append(", wheDualBaseWinCus=").append(wheDualBaseWinCus);
		sb.append(", wheImm=").append(wheImm);
		sb.append(", wheDis=").append(wheDis);
		sb.append(", disLevel=").append(disLevel);
		sb.append(", wheAgrSciTecInn=").append(wheAgrSciTecInn);
		sb.append(", wheNewAgrManSub=").append(wheNewAgrManSub);
		sb.append(", priType=").append(priType);
		sb.append(", wheCooMem=").append(wheCooMem);
		sb.append(", amoOfIns=").append(amoOfIns);
		sb.append(", insurance=").append(insurance);
		sb.append(", insType=").append(insType);
		sb.append(", whePovAllLoanCus=").append(whePovAllLoanCus);
		sb.append(", povAllCusType=").append(povAllCusType);
		sb.append(", povAllPro=").append(povAllPro);
		sb.append(", proLoc=").append(proLoc);
		sb.append(", wheRefOfAgrLoa=").append(wheRefOfAgrLoa);
		sb.append(", proCooLogo=").append(proCooLogo);
		sb.append(", wheToNewCou=").append(wheToNewCou);
		sb.append(", wheToConOfUrb=").append(wheToConOfUrb);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}