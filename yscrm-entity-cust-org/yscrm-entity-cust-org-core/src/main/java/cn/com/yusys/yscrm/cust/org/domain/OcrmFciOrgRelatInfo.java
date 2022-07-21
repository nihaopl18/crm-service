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
 * @类名称: OcrmFciOrgRelatInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-02-26 22:40:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_ORG_RELAT_INFO")
public class OcrmFciOrgRelatInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "CUST_ID", unique = false, nullable = false, length = 32)
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
	
	/** 农业产业化标识 **/
	@Column(name = "PRO_COO_INDUS_LOGO", unique = false, nullable = true, length = 20)
	private String proCooIndusLogo;
	
	/** 是否农业科技创新 **/
	@Column(name = "WHE_AGR_SCI_TEC_INN", unique = false, nullable = true, length = 20)
	private String wheAgrSciTecInn;
	
	/** 是否帮扶移民代销企业 **/
	@Column(name = "WHE_HELP_SALE", unique = false, nullable = true, length = 20)
	private String wheHelpSale;
	
	/** 是否帮扶移民就业 **/
	@Column(name = "WHE_HELP_JOB", unique = false, nullable = true, length = 20)
	private String wheHelpJob;
	
	/** 专业合作社标识 **/
	@Column(name = "PRO_COO_LOGO", unique = false, nullable = true, length = 20)
	private String proCooLogo;
	
	/** 是否三农领军人物 **/
	@Column(name = "WHE_THR_FAR_LEA_FIG", unique = false, nullable = true, length = 20)
	private String wheThrFarLeaFig;
	
	/** 是否涉农科技型客户 **/
	@Column(name = "WHE_INDU_TECH", unique = false, nullable = true, length = 20)
	private String wheInduTech;
	
	/** 是否双基双赢客户 **/
	@Column(name = "WHE_DUAL_BASE_WIN_CUS", unique = false, nullable = true, length = 20)
	private String wheDualBaseWinCus;
	
	/** 是否涉农重点客户 **/
	@Column(name = "WHE_INDU_KEY", unique = false, nullable = true, length = 20)
	private String wheInduKey;
	
	/** 是否设施蔬菜项目 **/
	@Column(name = "WHE_INDU_VEGETABLES", unique = false, nullable = true, length = 20)
	private String wheInduVegetables;
	
	/** 是否投向新农村 **/
	@Column(name = "WHE_TO_NEW_COU", unique = false, nullable = true, length = 20)
	private String wheToNewCou;
	
	/** 是否投向城镇化建设 **/
	@Column(name = "WHE_TO_CON_OF_URB", unique = false, nullable = true, length = 20)
	private String wheToConOfUrb;
	
	/** 是否贴息 **/
	@Column(name = "WHE_DIS", unique = false, nullable = true, length = 20)
	private String wheDis;
	
	/** 贴息级别 **/
	@Column(name = "DIS_LEVEL", unique = false, nullable = true, length = 20)
	private String disLevel;
	
	/** 是否新型农业经营主体 **/
	@Column(name = "WHE_NEW_AGR_MAN_SUB", unique = false, nullable = true, length = 20)
	private String wheNewAgrManSub;
	
	/** 主体类型 **/
	@Column(name = "PRI_TYPE", unique = false, nullable = true, length = 20)
	private String priType;
	
	/** 是否涉农客户 **/
	@Column(name = "WHE_AGR_REL_CUS", unique = false, nullable = true, length = 20)
	private String wheAgrRelCus;
	
	/** 保险金额 **/
	@Column(name = "AMO_OF_INS", unique = false, nullable = true, length = 20)
	private String amoOfIns;
	
	/** 保险费 **/
	@Column(name = "INSURANCE", unique = false, nullable = true, length = 20)
	private String insurance;
	
	/** 保险险种 **/
	@Column(name = "INS_TYPE", unique = false, nullable = true, length = 20)
	private String insType;
	
	/** 是否扶贫贷款客户 **/
	@Column(name = "WHE_POV_ALL_LOAN_CUS", unique = false, nullable = true, length = 20)
	private String whePovAllLoanCus;
	
	/** 扶贫客户类型 **/
	@Column(name = "POV_ALL_CUS_TYPE", unique = false, nullable = true, length = 20)
	private String povAllCusType;
	
	/** 扶贫项目 **/
	@Column(name = "POV_ALL_PRO", unique = false, nullable = true, length = 20)
	private String povAllPro;
	
	/** 项目所在地 **/
	@Column(name = "PRO_LOC", unique = false, nullable = true, length = 20)
	private String proLoc;
	
	/** 是否支农再贷款 **/
	@Column(name = "WHE_REF_OF_AGR_LOA", unique = false, nullable = true, length = 20)
	private String wheRefOfAgrLoa;
	
	/** 主营业务村 **/
	@Column(name = "MAIN_BUSI_VILLAGE", unique = false, nullable = true, length = 20)
	private String mainBusiVillage;
	
	/** 主营业务村编号 **/
	@Column(name = "MAIN_BUSI_VILLAGE_NO", unique = false, nullable = true, length = 20)
	private String mainBusiVillageNo;
	
	/** 资金需求 **/
	@Column(name = "CAPITAL_DEMAND", unique = false, nullable = true, length = 20)
	private String capitalDemand;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
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
	 * @param proCooIndusLogo
	 */
	public void setProCooIndusLogo(String proCooIndusLogo) {
		this.proCooIndusLogo = proCooIndusLogo == null ? null : proCooIndusLogo.trim();
	}
	
    /**
     * @return ProCooIndusLogo
     */	
	public String getProCooIndusLogo() {
		return this.proCooIndusLogo;
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
	 * @param wheHelpSale
	 */
	public void setWheHelpSale(String wheHelpSale) {
		this.wheHelpSale = wheHelpSale == null ? null : wheHelpSale.trim();
	}
	
    /**
     * @return WheHelpSale
     */	
	public String getWheHelpSale() {
		return this.wheHelpSale;
	}
	
	/**
	 * @param wheHelpJob
	 */
	public void setWheHelpJob(String wheHelpJob) {
		this.wheHelpJob = wheHelpJob == null ? null : wheHelpJob.trim();
	}
	
    /**
     * @return WheHelpJob
     */	
	public String getWheHelpJob() {
		return this.wheHelpJob;
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
	 * @param wheInduTech
	 */
	public void setWheInduTech(String wheInduTech) {
		this.wheInduTech = wheInduTech == null ? null : wheInduTech.trim();
	}
	
    /**
     * @return WheInduTech
     */	
	public String getWheInduTech() {
		return this.wheInduTech;
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
	 * @param wheInduKey
	 */
	public void setWheInduKey(String wheInduKey) {
		this.wheInduKey = wheInduKey == null ? null : wheInduKey.trim();
	}
	
    /**
     * @return WheInduKey
     */	
	public String getWheInduKey() {
		return this.wheInduKey;
	}
	
	/**
	 * @param wheInduVegetables
	 */
	public void setWheInduVegetables(String wheInduVegetables) {
		this.wheInduVegetables = wheInduVegetables == null ? null : wheInduVegetables.trim();
	}
	
    /**
     * @return WheInduVegetables
     */	
	public String getWheInduVegetables() {
		return this.wheInduVegetables;
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
	 * @param mainBusiVillage
	 */
	public void setMainBusiVillage(String mainBusiVillage) {
		this.mainBusiVillage = mainBusiVillage == null ? null : mainBusiVillage.trim();
	}
	
    /**
     * @return MainBusiVillage
     */	
	public String getMainBusiVillage() {
		return this.mainBusiVillage;
	}
	
	/**
	 * @param mainBusiVillageNo
	 */
	public void setMainBusiVillageNo(String mainBusiVillageNo) {
		this.mainBusiVillageNo = mainBusiVillageNo == null ? null : mainBusiVillageNo.trim();
	}
	
    /**
     * @return MainBusiVillageNo
     */	
	public String getMainBusiVillageNo() {
		return this.mainBusiVillageNo;
	}
	
	/**
	 * @param capitalDemand
	 */
	public void setCapitalDemand(String capitalDemand) {
		this.capitalDemand = capitalDemand == null ? null : capitalDemand.trim();
	}
	
    /**
     * @return CapitalDemand
     */	
	public String getCapitalDemand() {
		return this.capitalDemand;
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
        OcrmFciOrgRelatInfo other = (OcrmFciOrgRelatInfo) that;
		return 
        	(this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getLastOrgId() == null ? other.getLastOrgId() == null : this.getLastOrgId().equals(other.getLastOrgId()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getProCooIndusLogo() == null ? other.getProCooIndusLogo() == null : this.getProCooIndusLogo().equals(other.getProCooIndusLogo()))
        	&& (this.getWheAgrSciTecInn() == null ? other.getWheAgrSciTecInn() == null : this.getWheAgrSciTecInn().equals(other.getWheAgrSciTecInn()))
        	&& (this.getWheHelpSale() == null ? other.getWheHelpSale() == null : this.getWheHelpSale().equals(other.getWheHelpSale()))
        	&& (this.getWheHelpJob() == null ? other.getWheHelpJob() == null : this.getWheHelpJob().equals(other.getWheHelpJob()))
        	&& (this.getProCooLogo() == null ? other.getProCooLogo() == null : this.getProCooLogo().equals(other.getProCooLogo()))
        	&& (this.getWheThrFarLeaFig() == null ? other.getWheThrFarLeaFig() == null : this.getWheThrFarLeaFig().equals(other.getWheThrFarLeaFig()))
        	&& (this.getWheInduTech() == null ? other.getWheInduTech() == null : this.getWheInduTech().equals(other.getWheInduTech()))
        	&& (this.getWheDualBaseWinCus() == null ? other.getWheDualBaseWinCus() == null : this.getWheDualBaseWinCus().equals(other.getWheDualBaseWinCus()))
        	&& (this.getWheInduKey() == null ? other.getWheInduKey() == null : this.getWheInduKey().equals(other.getWheInduKey()))
        	&& (this.getWheInduVegetables() == null ? other.getWheInduVegetables() == null : this.getWheInduVegetables().equals(other.getWheInduVegetables()))
        	&& (this.getWheToNewCou() == null ? other.getWheToNewCou() == null : this.getWheToNewCou().equals(other.getWheToNewCou()))
        	&& (this.getWheToConOfUrb() == null ? other.getWheToConOfUrb() == null : this.getWheToConOfUrb().equals(other.getWheToConOfUrb()))
        	&& (this.getWheDis() == null ? other.getWheDis() == null : this.getWheDis().equals(other.getWheDis()))
        	&& (this.getDisLevel() == null ? other.getDisLevel() == null : this.getDisLevel().equals(other.getDisLevel()))
        	&& (this.getWheNewAgrManSub() == null ? other.getWheNewAgrManSub() == null : this.getWheNewAgrManSub().equals(other.getWheNewAgrManSub()))
        	&& (this.getPriType() == null ? other.getPriType() == null : this.getPriType().equals(other.getPriType()))
        	&& (this.getWheAgrRelCus() == null ? other.getWheAgrRelCus() == null : this.getWheAgrRelCus().equals(other.getWheAgrRelCus()))
        	&& (this.getAmoOfIns() == null ? other.getAmoOfIns() == null : this.getAmoOfIns().equals(other.getAmoOfIns()))
        	&& (this.getInsurance() == null ? other.getInsurance() == null : this.getInsurance().equals(other.getInsurance()))
        	&& (this.getInsType() == null ? other.getInsType() == null : this.getInsType().equals(other.getInsType()))
        	&& (this.getWhePovAllLoanCus() == null ? other.getWhePovAllLoanCus() == null : this.getWhePovAllLoanCus().equals(other.getWhePovAllLoanCus()))
        	&& (this.getPovAllCusType() == null ? other.getPovAllCusType() == null : this.getPovAllCusType().equals(other.getPovAllCusType()))
        	&& (this.getPovAllPro() == null ? other.getPovAllPro() == null : this.getPovAllPro().equals(other.getPovAllPro()))
        	&& (this.getProLoc() == null ? other.getProLoc() == null : this.getProLoc().equals(other.getProLoc()))
        	&& (this.getWheRefOfAgrLoa() == null ? other.getWheRefOfAgrLoa() == null : this.getWheRefOfAgrLoa().equals(other.getWheRefOfAgrLoa()))
        	&& (this.getMainBusiVillage() == null ? other.getMainBusiVillage() == null : this.getMainBusiVillage().equals(other.getMainBusiVillage()))
        	&& (this.getMainBusiVillageNo() == null ? other.getMainBusiVillageNo() == null : this.getMainBusiVillageNo().equals(other.getMainBusiVillageNo()))
        	&& (this.getCapitalDemand() == null ? other.getCapitalDemand() == null : this.getCapitalDemand().equals(other.getCapitalDemand()))
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
        result = prime * result + ((getProCooIndusLogo() == null) ? 0 : getProCooIndusLogo().hashCode());
        result = prime * result + ((getWheAgrSciTecInn() == null) ? 0 : getWheAgrSciTecInn().hashCode());
        result = prime * result + ((getWheHelpSale() == null) ? 0 : getWheHelpSale().hashCode());
        result = prime * result + ((getWheHelpJob() == null) ? 0 : getWheHelpJob().hashCode());
        result = prime * result + ((getProCooLogo() == null) ? 0 : getProCooLogo().hashCode());
        result = prime * result + ((getWheThrFarLeaFig() == null) ? 0 : getWheThrFarLeaFig().hashCode());
        result = prime * result + ((getWheInduTech() == null) ? 0 : getWheInduTech().hashCode());
        result = prime * result + ((getWheDualBaseWinCus() == null) ? 0 : getWheDualBaseWinCus().hashCode());
        result = prime * result + ((getWheInduKey() == null) ? 0 : getWheInduKey().hashCode());
        result = prime * result + ((getWheInduVegetables() == null) ? 0 : getWheInduVegetables().hashCode());
        result = prime * result + ((getWheToNewCou() == null) ? 0 : getWheToNewCou().hashCode());
        result = prime * result + ((getWheToConOfUrb() == null) ? 0 : getWheToConOfUrb().hashCode());
        result = prime * result + ((getWheDis() == null) ? 0 : getWheDis().hashCode());
        result = prime * result + ((getDisLevel() == null) ? 0 : getDisLevel().hashCode());
        result = prime * result + ((getWheNewAgrManSub() == null) ? 0 : getWheNewAgrManSub().hashCode());
        result = prime * result + ((getPriType() == null) ? 0 : getPriType().hashCode());
        result = prime * result + ((getWheAgrRelCus() == null) ? 0 : getWheAgrRelCus().hashCode());
        result = prime * result + ((getAmoOfIns() == null) ? 0 : getAmoOfIns().hashCode());
        result = prime * result + ((getInsurance() == null) ? 0 : getInsurance().hashCode());
        result = prime * result + ((getInsType() == null) ? 0 : getInsType().hashCode());
        result = prime * result + ((getWhePovAllLoanCus() == null) ? 0 : getWhePovAllLoanCus().hashCode());
        result = prime * result + ((getPovAllCusType() == null) ? 0 : getPovAllCusType().hashCode());
        result = prime * result + ((getPovAllPro() == null) ? 0 : getPovAllPro().hashCode());
        result = prime * result + ((getProLoc() == null) ? 0 : getProLoc().hashCode());
        result = prime * result + ((getWheRefOfAgrLoa() == null) ? 0 : getWheRefOfAgrLoa().hashCode());
        result = prime * result + ((getMainBusiVillage() == null) ? 0 : getMainBusiVillage().hashCode());
        result = prime * result + ((getMainBusiVillageNo() == null) ? 0 : getMainBusiVillageNo().hashCode());
        result = prime * result + ((getCapitalDemand() == null) ? 0 : getCapitalDemand().hashCode());
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
		sb.append(", proCooIndusLogo=").append(proCooIndusLogo);
		sb.append(", wheAgrSciTecInn=").append(wheAgrSciTecInn);
		sb.append(", wheHelpSale=").append(wheHelpSale);
		sb.append(", wheHelpJob=").append(wheHelpJob);
		sb.append(", proCooLogo=").append(proCooLogo);
		sb.append(", wheThrFarLeaFig=").append(wheThrFarLeaFig);
		sb.append(", wheInduTech=").append(wheInduTech);
		sb.append(", wheDualBaseWinCus=").append(wheDualBaseWinCus);
		sb.append(", wheInduKey=").append(wheInduKey);
		sb.append(", wheInduVegetables=").append(wheInduVegetables);
		sb.append(", wheToNewCou=").append(wheToNewCou);
		sb.append(", wheToConOfUrb=").append(wheToConOfUrb);
		sb.append(", wheDis=").append(wheDis);
		sb.append(", disLevel=").append(disLevel);
		sb.append(", wheNewAgrManSub=").append(wheNewAgrManSub);
		sb.append(", priType=").append(priType);
		sb.append(", wheAgrRelCus=").append(wheAgrRelCus);
		sb.append(", amoOfIns=").append(amoOfIns);
		sb.append(", insurance=").append(insurance);
		sb.append(", insType=").append(insType);
		sb.append(", whePovAllLoanCus=").append(whePovAllLoanCus);
		sb.append(", povAllCusType=").append(povAllCusType);
		sb.append(", povAllPro=").append(povAllPro);
		sb.append(", proLoc=").append(proLoc);
		sb.append(", wheRefOfAgrLoa=").append(wheRefOfAgrLoa);
		sb.append(", mainBusiVillage=").append(mainBusiVillage);
		sb.append(", mainBusiVillageNo=").append(mainBusiVillageNo);
		sb.append(", capitalDemand=").append(capitalDemand);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}