package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
@Entity
@Table(name = "ACRM_F_CI_ORG")
public class AcrmFCiOrg extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CUST_ID")//客户编号
    private String custId;
	
	@Column(name = "REG_FUND_CURRENCY")//注册资金币种
    private String regFundCurrency;

	@Column(name = "REG_FUND_AMT")//注册资金金额
    private String regFundAmt;

	@Column(name = "ORG_CUST_TYPE")//机构客户类型
    private String orgCustType;

	@Column(name = "NATION_CODE")//国家或地区代码
    private String nationCode;

	@Column(name = "AREA_CODE")//行政区划代码
    private String areaCode;

	@Column(name = "MAIN_INDUSTRY")//行业分类（主营）
    private String mainIndustry;

	@Column(name = "MINOR_INDUSTRY")//行业分类（副营）
    private String minorIndustry;

	@Column(name = "INDUSTRY_CHAR")//行业特征
    private String industryChar;

	@Column(name = "ENT_PROPERTY")//企业性质
    private String entProperty;

	@Column(name = "ENT_SCALE")//企业规模（银监）
    private String entScale;

	@Column(name = "ENT_SCALE_RH")//企业规模（人行）
    private String entScaleRh;

	@Column(name = "ENT_SCALE_CK")//企业规模（存款）
    private String entScaleCk;

	@Column(name = "PROD_CAPACITY")//实际生产能力
    private String prodCapacity;

	@Column(name = "COMP_ORG")//上级主管单位
    private String compOrg;

	@Column(name = "ASSETS_SCALE")//资产规模
    private String assetsScale;

	@Column(name = "EMPLOYEE_SCALE")//员工规模
    private String employeeScale;

	@Column(name = "ECONOMIC_TYPE")//经济类型
    private String economicType;

	@Column(name = "COM_HOLD_TYPE")//控股类型
    private String comHoldType;

	@Column(name = "ORG_FORM")//组织形式
    private String orgForm;

	@Column(name = "GOVERN_STRUCTURE")//治理结构
    private String governStructure;

	@Column(name = "INVEST_TYPE")//投资主体
    private String investType;

	@Column(name = "ENT_BELONG")//企业隶属
    private String entBelong;

	@Column(name = "BUILD_DATE")//成立日期
    private String buildDate;

	@Column(name = "SUPER_DEPT")//主管部门
    private String superDept;

	@Column(name = "MAIN_BUSINESS")//主营业务
    private String mainBusiness;

	@Column(name = "MINOR_BUSINESS")//兼营业务
    private String minorBusiness;

	@Column(name = "BUSINESS_MODE")//经营方式
    private String businessMode;

	@Column(name = "BUSI_START_DATE")//开始营业时间
    private String busiStartDate;

	@Column(name = "INDU_DEVE_PROSPECT")//行业发展前景
    private String induDeveProspect;

	@Column(name = "LOAN_CARD_FLAG")//有无贷款卡
    private String loanCardFlag;

	@Column(name = "LOAN_CARD_NO")//贷款卡号码
    private String loanCardNo;

	@Column(name = "LOAN_CARD_STAT")//贷款卡状态
    private String loanCardStat;

	@Column(name = "ANNUAL_INCOME")//年收入
    private String annualIncome;

	@Column(name = "LOAD_CARD_AUDIT_DT")//贷款卡年审日期
    private String loadCardAuditDt;

	@Column(name = "REMARK")//备注
    private String remark;

	@Column(name = "LAST_UPDATE_SYS")//最后更新系统
    private String lastUpdateSys;

	@Column(name = "LAST_UPDATE_USER")//最后更新人
    private String lastUpdateUser;

	@Column(name = "LAST_UPDATE_TM")//最新更新时间（年月日时分秒）
    private String lastUpdateTm;

	@Column(name = "TX_SEQ_NO")//交易流水号
    private String txSeqNo;

	@Column(name = "ETL_DATE")//etl日期
    private String etlDate;

	@Column(name = "LOAD_CARD_PWD")//贷款卡密码
    private String loadCardPwd;

	@Column(name = "TOTAL_ASSETS")//总资产
    private String totalAssets;

	@Column(name = "TOTAL_DEBT")//总负债
    private String totalDebt;

	@Column(name = "ANNUAL_PROFIT")//年利润
    private String annualProfit;

	@Column(name = "INDUSTRY_POSITION")//行业地位
    private String industryPosition;

	@Column(name = "IS_STOCK_HOLDER")//是否我行股东
    private String isStockHolder;

	@Column(name = "HOLD_STOCK_AMT")//拥有我行股份金额
    private String holdStockAmt;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getRegFundCurrency() {
		return regFundCurrency;
	}

	public void setRegFundCurrency(String regFundCurrency) {
		this.regFundCurrency = regFundCurrency;
	}

	public String getRegFundAmt() {
		return regFundAmt;
	}

	public void setRegFundAmt(String regFundAmt) {
		this.regFundAmt = regFundAmt;
	}

	public String getOrgCustType() {
		return orgCustType;
	}

	public void setOrgCustType(String orgCustType) {
		this.orgCustType = orgCustType;
	}

	public String getNationCode() {
		return nationCode;
	}

	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getMainIndustry() {
		return mainIndustry;
	}

	public void setMainIndustry(String mainIndustry) {
		this.mainIndustry = mainIndustry;
	}

	public String getMinorIndustry() {
		return minorIndustry;
	}

	public void setMinorIndustry(String minorIndustry) {
		this.minorIndustry = minorIndustry;
	}

	public String getIndustryChar() {
		return industryChar;
	}

	public void setIndustryChar(String industryChar) {
		this.industryChar = industryChar;
	}

	public String getEntProperty() {
		return entProperty;
	}

	public void setEntProperty(String entProperty) {
		this.entProperty = entProperty;
	}

	public String getEntScale() {
		return entScale;
	}

	public void setEntScale(String entScale) {
		this.entScale = entScale;
	}

	public String getEntScaleRh() {
		return entScaleRh;
	}

	public void setEntScaleRh(String entScaleRh) {
		this.entScaleRh = entScaleRh;
	}

	public String getEntScaleCk() {
		return entScaleCk;
	}

	public void setEntScaleCk(String entScaleCk) {
		this.entScaleCk = entScaleCk;
	}

	public String getProdCapacity() {
		return prodCapacity;
	}

	public void setProdCapacity(String prodCapacity) {
		this.prodCapacity = prodCapacity;
	}

	public String getCompOrg() {
		return compOrg;
	}

	public void setCompOrg(String compOrg) {
		this.compOrg = compOrg;
	}

	public String getAssetsScale() {
		return assetsScale;
	}

	public void setAssetsScale(String assetsScale) {
		this.assetsScale = assetsScale;
	}

	public String getEmployeeScale() {
		return employeeScale;
	}

	public void setEmployeeScale(String employeeScale) {
		this.employeeScale = employeeScale;
	}

	public String getEconomicType() {
		return economicType;
	}

	public void setEconomicType(String economicType) {
		this.economicType = economicType;
	}

	public String getComHoldType() {
		return comHoldType;
	}

	public void setComHoldType(String comHoldType) {
		this.comHoldType = comHoldType;
	}

	public String getOrgForm() {
		return orgForm;
	}

	public void setOrgForm(String orgForm) {
		this.orgForm = orgForm;
	}

	public String getGovernStructure() {
		return governStructure;
	}

	public void setGovernStructure(String governStructure) {
		this.governStructure = governStructure;
	}

	public String getInvestType() {
		return investType;
	}

	public void setInvestType(String investType) {
		this.investType = investType;
	}

	public String getEntBelong() {
		return entBelong;
	}

	public void setEntBelong(String entBelong) {
		this.entBelong = entBelong;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	public String getSuperDept() {
		return superDept;
	}

	public void setSuperDept(String superDept) {
		this.superDept = superDept;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public String getMinorBusiness() {
		return minorBusiness;
	}

	public void setMinorBusiness(String minorBusiness) {
		this.minorBusiness = minorBusiness;
	}

	public String getBusinessMode() {
		return businessMode;
	}

	public void setBusinessMode(String businessMode) {
		this.businessMode = businessMode;
	}

	public String getBusiStartDate() {
		return busiStartDate;
	}

	public void setBusiStartDate(String busiStartDate) {
		this.busiStartDate = busiStartDate;
	}

	public String getInduDeveProspect() {
		return induDeveProspect;
	}

	public void setInduDeveProspect(String induDeveProspect) {
		this.induDeveProspect = induDeveProspect;
	}

	public String getLoanCardFlag() {
		return loanCardFlag;
	}

	public void setLoanCardFlag(String loanCardFlag) {
		this.loanCardFlag = loanCardFlag;
	}

	public String getLoanCardNo() {
		return loanCardNo;
	}

	public void setLoanCardNo(String loanCardNo) {
		this.loanCardNo = loanCardNo;
	}

	public String getLoanCardStat() {
		return loanCardStat;
	}

	public void setLoanCardStat(String loanCardStat) {
		this.loanCardStat = loanCardStat;
	}

	public String getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getLoadCardAuditDt() {
		return loadCardAuditDt;
	}

	public void setLoadCardAuditDt(String loadCardAuditDt) {
		this.loadCardAuditDt = loadCardAuditDt;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLastUpdateSys() {
		return lastUpdateSys;
	}

	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getLastUpdateTm() {
		return lastUpdateTm;
	}

	public void setLastUpdateTm(String lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public String getTxSeqNo() {
		return txSeqNo;
	}

	public void setTxSeqNo(String txSeqNo) {
		this.txSeqNo = txSeqNo;
	}

	public String getEtlDate() {
		return etlDate;
	}

	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate;
	}

	public String getLoadCardPwd() {
		return loadCardPwd;
	}

	public void setLoadCardPwd(String loadCardPwd) {
		this.loadCardPwd = loadCardPwd;
	}

	public String getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(String totalDebt) {
		this.totalDebt = totalDebt;
	}

	public String getAnnualProfit() {
		return annualProfit;
	}

	public void setAnnualProfit(String annualProfit) {
		this.annualProfit = annualProfit;
	}

	public String getIndustryPosition() {
		return industryPosition;
	}

	public void setIndustryPosition(String industryPosition) {
		this.industryPosition = industryPosition;
	}

	public String getIsStockHolder() {
		return isStockHolder;
	}

	public void setIsStockHolder(String isStockHolder) {
		this.isStockHolder = isStockHolder;
	}

	public String getHoldStockAmt() {
		return holdStockAmt;
	}

	public void setHoldStockAmt(String holdStockAmt) {
		this.holdStockAmt = holdStockAmt;
	}
	
	

}
