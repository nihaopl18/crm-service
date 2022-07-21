package cn.com.yusys.yusp.cm.productmanager.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CM_F_RC_PROD_INFO")
public class CmFRcProductManagerInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PRODUCT_ID")
	private String productId;
	
	@Column(name="PROD_NAME")
	private String prodName;
	
	@Column(name="CATL_CODE")
	private long catlCode;
	
	@Column(name="TJKJ")
	private String tjkj;
	
	@Column(name="PROD_TYPE_ID")
	private long prodTypeId;
	
	@Column(name="PROD_DESC")
	private String prodDesc;
	
	@Column(name="DISPLAY_FLAG")
	private String displayFlag;

	@Column(name="PROD_START_DATE")
	private Date prodStartDate;

	@Column(name="PROD_END_DATE")
	private Date prodEndDate;

	@Column(name="PROD_STATE")
	private String prodState;
	
	@Column(name="PROD_CREATOR")
	private String prodCreator;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="PROD_SHOW_URL")
	private String prodShowUrl;
	
	@Column(name="PROD_QUERY_URL")
	private String prodQueryUrl;

	
	@Column(name="PROD_SEQ")
	private String prodSeq;

	@Column(name="PROD_DEPT")
	private String prodDept;
	

	@Column(name="RATE")
	private String rate;

	
	@Column(name="COST_RATE")
	private String costRate;
	

	@Column(name="LIMIT_TIME")
	private String limitTime;

	
	@Column(name="PROD_CHARACT")
	private String prodCharact;

	
	@Column(name="OBJ_CUST_DISC")
	private String objCustDisc;
	

	
	@Column(name="DANGER_DISC")
	private String dangerDisc;

	
	@Column(name="CHANNEL_DISC")
	private String channelDisc;

	
	@Column(name="ASSURE_DISC")
	private String assureDisc;

	
	@Column(name="PROD_SWITCH")
	private String prodSwitch;

	
	@Column(name="RISK_LEVEL")
	private String riskLevel;

	
	@Column(name="PROD_BUS_ID")
	private String prodBusId;
	

	
	@Column(name="OTHER_INFO")
	private String otherInfo;
	

	
	@Column(name="SPECIAL_INFO")
	private String specialInfo;

	
	@Column(name="TYPE_FIT_CUST")
	private String typeFitCust;

	
	@Column(name="PROD_MAG")
	private String prodMag;
	

	@Column(name="PROD_LEVEL")
	private String prodLevel;

	
	@Column(name="PROD_ESTMAT")
	private String prodEstmat;

	
	@Column(name="TRADE_CONDI")
	private String tradeCondi;

	@Column(name="TRADE_FLOW")
	private String tradeFlow;
	

	
	@Column(name="TRADE_CHN")
	private String tradeChn;


	@Column(name="DISCNT_INFO")
	private String discntInfo;

	
	@Column(name="MKT_MSG")
	private String mktMsg;

	
	@Column(name="MKT_CASE")
	private String mktCase;

	
	@Column(name="SAME_COMP")
	private String sameComp;

	
	@Column(name="PROD_LINE_CD")
	private String prodLineCd;
	

	
	@Column(name="IS_COMBINATION")
	private String isCombination;

	@Column(name="MONEY")
	private String money;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public long getCatlCode() {
		return catlCode;
	}

	public void setCatlCode(long catlCode) {
		this.catlCode = catlCode;
	}

	public String getTjkj() {
		return tjkj;
	}

	public void setTjkj(String tjkj) {
		this.tjkj = tjkj;
	}

	public long getProdTypeId() {
		return prodTypeId;
	}

	public void setProdTypeId(long prodTypeId) {
		this.prodTypeId = prodTypeId;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getDisplayFlag() {
		return displayFlag;
	}

	public void setDisplayFlag(String displayFlag) {
		this.displayFlag = displayFlag;
	}

	public Date getProdStartDate() {
		return prodStartDate;
	}

	public void setProdStartDate(Date prodStartDate) {
		this.prodStartDate = prodStartDate;
	}

	public Date getProdEndDate() {
		return prodEndDate;
	}

	public void setProdEndDate(Date prodEndDate) {
		this.prodEndDate = prodEndDate;
	}

	public String getProdState() {
		return prodState;
	}

	public void setProdState(String prodState) {
		this.prodState = prodState;
	}

	public String getProdCreator() {
		return prodCreator;
	}

	public void setProdCreator(String prodCreator) {
		this.prodCreator = prodCreator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getProdShowUrl() {
		return prodShowUrl;
	}

	public void setProdShowUrl(String prodShowUrl) {
		this.prodShowUrl = prodShowUrl;
	}

	public String getProdQueryUrl() {
		return prodQueryUrl;
	}

	public void setProdQueryUrl(String prodQueryUrl) {
		this.prodQueryUrl = prodQueryUrl;
	}

	public String getProdSeq() {
		return prodSeq;
	}

	public void setProdSeq(String prodSeq) {
		this.prodSeq = prodSeq;
	}

	public String getProdDept() {
		return prodDept;
	}

	public void setProdDept(String prodDept) {
		this.prodDept = prodDept;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCostRate() {
		return costRate;
	}

	public void setCostRate(String costRate) {
		this.costRate = costRate;
	}

	public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
		this.limitTime = limitTime;
	}

	public String getProdCharact() {
		return prodCharact;
	}

	public void setProdCharact(String prodCharact) {
		this.prodCharact = prodCharact;
	}

	public String getObjCustDisc() {
		return objCustDisc;
	}

	public void setObjCustDisc(String objCustDisc) {
		this.objCustDisc = objCustDisc;
	}

	public String getDangerDisc() {
		return dangerDisc;
	}

	public void setDangerDisc(String dangerDisc) {
		this.dangerDisc = dangerDisc;
	}

	public String getChannelDisc() {
		return channelDisc;
	}

	public void setChannelDisc(String channelDisc) {
		this.channelDisc = channelDisc;
	}

	public String getAssureDisc() {
		return assureDisc;
	}

	public void setAssureDisc(String assureDisc) {
		this.assureDisc = assureDisc;
	}

	public String getProdSwitch() {
		return prodSwitch;
	}

	public void setProdSwitch(String prodSwitch) {
		this.prodSwitch = prodSwitch;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getProdBusId() {
		return prodBusId;
	}

	public void setProdBusId(String prodBusId) {
		this.prodBusId = prodBusId;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getSpecialInfo() {
		return specialInfo;
	}

	public void setSpecialInfo(String specialInfo) {
		this.specialInfo = specialInfo;
	}

	public String getTypeFitCust() {
		return typeFitCust;
	}

	public void setTypeFitCust(String typeFitCust) {
		this.typeFitCust = typeFitCust;
	}

	public String getProdMag() {
		return prodMag;
	}

	public void setProdMag(String prodMag) {
		this.prodMag = prodMag;
	}

	public String getProdLevel() {
		return prodLevel;
	}

	public void setProdLevel(String prodLevel) {
		this.prodLevel = prodLevel;
	}

	public String getProdEstmat() {
		return prodEstmat;
	}

	public void setProdEstmat(String prodEstmat) {
		this.prodEstmat = prodEstmat;
	}

	public String getTradeCondi() {
		return tradeCondi;
	}

	public void setTradeCondi(String tradeCondi) {
		this.tradeCondi = tradeCondi;
	}

	public String getTradeFlow() {
		return tradeFlow;
	}

	public void setTradeFlow(String tradeFlow) {
		this.tradeFlow = tradeFlow;
	}

	public String getTradeChn() {
		return tradeChn;
	}

	public void setTradeChn(String tradeChn) {
		this.tradeChn = tradeChn;
	}

	public String getDiscntInfo() {
		return discntInfo;
	}

	public void setDiscntInfo(String discntInfo) {
		this.discntInfo = discntInfo;
	}

	public String getMktMsg() {
		return mktMsg;
	}

	public void setMktMsg(String mktMsg) {
		this.mktMsg = mktMsg;
	}

	public String getMktCase() {
		return mktCase;
	}

	public void setMktCase(String mktCase) {
		this.mktCase = mktCase;
	}

	public String getSameComp() {
		return sameComp;
	}

	public void setSameComp(String sameComp) {
		this.sameComp = sameComp;
	}

	public String getProdLineCd() {
		return prodLineCd;
	}

	public void setProdLineCd(String prodLineCd) {
		this.prodLineCd = prodLineCd;
	}

	public String getIsCombination() {
		return isCombination;
	}

	public void setIsCombination(String isCombination) {
		this.isCombination = isCombination;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}
}
