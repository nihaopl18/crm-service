package cn.com.yusys.yscrm.product.domain;

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
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-01-29 15:15:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_PD_PROD_INFO")
public class AcrmFpdProdInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** CRM产品标识 **/
	@Id
	@Column(name = "PRODUCT_ID")
	@Generated(GenerationType.UUID)
	private String productId;
	
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
	@Column(name = "LAST_CHG_TM", unique = false, nullable = true, length = 7)
	private Date lastChgTm;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 源系统产品编号 **/
	@Column(name = "SOURCE_PRD_NO", unique = false, nullable = true, length = 30)
	private String sourcePrdNo;
	
	/** 产品名称 **/
	@Column(name = "PROD_NAME", unique = false, nullable = true, length = 128)
	private String prodName;
	
	/** 产品类型代码 **/
	@Column(name = "CATL_CODE", unique = false, nullable = true, length = 30)
	private String catlCode;
	
	/** 产品发布日期 **/
	@Column(name = "PROD_START_DATE", unique = false, nullable = true, length = 10)
	private Date prodStartDate;
	
	/** 产品截止日期 **/
	@Column(name = "PROD_END_DATE", unique = false, nullable = true, length = 10)
	private Date prodEndDate;
	
	/** 是否在售 **/
	@Column(name = "PROD_STATE", unique = false, nullable = true, length = 30)
	private String prodState;
	
	/** 风险等级 **/
	@Column(name = "RISK_LEVEL", unique = false, nullable = true, length = 30)
	private String riskLevel;
	
	/** 简介 **/
	@Column(name = "PROD_DESC", unique = false, nullable = true, length = 4000)
	private String prodDesc;
	
	/** 执行利率 **/
	@Column(name = "RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal rate;
	
	/** 费率 **/
	@Column(name = "FREE_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal freeRate;
	
	/** 产品期限 **/
	@Column(name = "PROD_TERM", unique = false, nullable = true, length = 10)
	private String prodTerm;
	
	/** 币种 **/
	@Column(name = "CUYYEN_TYPE", unique = false, nullable = true, length = 30)
	private String cuyyenType;
	
	/** 认购起点金额 **/
	@Column(name = "SUBSCRIBE_START_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal subscribeStartAmt;
	
	/** 特点 **/
	@Column(name = "PROD_CHARACT", unique = false, nullable = true, length = 2000)
	private String prodCharact;
	
	/** 目标客户描述 **/
	@Column(name = "OBJ_CUST_DESC", unique = false, nullable = true, length = 2000)
	private String objCustDesc;
	
	/** 优惠信息 **/
	@Column(name = "DISCNT_INFO", unique = false, nullable = true, length = 2000)
	private String discntInfo;
	
	/** 一句话营销话术 **/
	@Column(name = "MKT_MSG", unique = false, nullable = true, length = 2000)
	private String mktMsg;
	
	/** 适用对象 **/
	@Column(name = "APP_OBJ", unique = false, nullable = true, length = 30)
	private String appObj;
	
	/** 办理渠道 **/
	@Column(name = "HAND_CHANNLE", unique = false, nullable = true, length = 30)
	private String handChannle;
	
	/** 办理流程 **/
	@Column(name = "HAND_PROCESS", unique = false, nullable = true, length = 50)
	private String handProcess;
	
	/** 产品来源 **/
	@Column(name = "PD_SOURCE", unique = false, nullable = true, length = 20)
	private String pdSource;
	
	/** 产品经理 **/
	@Column(name = "PD_MAGAGER", unique = false, nullable = true, length = 30)
	private String pdMagager;
	
	/** 管理部门 **/
	@Column(name = "MANAGER_DEPT", unique = false, nullable = true, length = 30)
	private String managerDept;
	
	/** 办理条件 **/
	@Column(name = "BUY_CONDITION", unique = false, nullable = true, length = 1000)
	private String buyCondition;
	
	/** 保本要求 **/
	@Column(name = "IS_BANLACE", unique = false, nullable = true, length = 30)
	private String isBanlace;
	
	/** 收益率 **/
	@Column(name = "INCOME_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal incomeRate;
	
	/** 是否需要双录 **/
	@Column(name = "IS_MULTI_RECORD", unique = false, nullable = true, length = 30)
	private String isMultiRecord;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 1000)
	private String remark;
	
	/** 产品扩展信息展示ID **/
	@Column(name = "EXT_TABLE_ID", unique = false, nullable = true, length = 100)
	private String extTableId;
	
	/** 客户持有产品展示ID **/
	@Column(name = "VIEW_SHOW_ID", unique = false, nullable = true, length = 100)
	private String viewShowId;
	
	
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
	 * @param lastChgTm
	 */
	public void setLastChgTm(Date lastChgTm) {
		this.lastChgTm = lastChgTm;
	}
	
    /**
     * @return LastChgTm
     */	
	public Date getLastChgTm() {
		return this.lastChgTm;
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
	 * @param sourcePrdNo
	 */
	public void setSourcePrdNo(String sourcePrdNo) {
		this.sourcePrdNo = sourcePrdNo == null ? null : sourcePrdNo.trim();
	}
	
    /**
     * @return SourcePrdNo
     */	
	public String getSourcePrdNo() {
		return this.sourcePrdNo;
	}
	
	/**
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId == null ? null : productId.trim();
	}
	
    /**
     * @return ProductId
     */	
	public String getProductId() {
		return this.productId;
	}
	
	/**
	 * @param prodName
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName == null ? null : prodName.trim();
	}
	
    /**
     * @return ProdName
     */	
	public String getProdName() {
		return this.prodName;
	}
	
	/**
	 * @param catlCode
	 */
	public void setCatlCode(String catlCode) {
		this.catlCode = catlCode == null ? null : catlCode.trim();
	}
	
    /**
     * @return CatlCode
     */	
	public String getCatlCode() {
		return this.catlCode;
	}
	
	/**
	 * @param prodStartDate
	 */
	public void setProdStartDate(Date prodStartDate) {
		this.prodStartDate = prodStartDate;
	}
	
    /**
     * @return ProdStartDate
     */	
	public Date getProdStartDate() {
		return this.prodStartDate;
	}
	
	/**
	 * @param prodEndDate
	 */
	public void setProdEndDate(Date prodEndDate) {
		this.prodEndDate = prodEndDate;
	}
	
    /**
     * @return ProdEndDate
     */	
	public Date getProdEndDate() {
		return this.prodEndDate;
	}
	
	/**
	 * @param prodState
	 */
	public void setProdState(String prodState) {
		this.prodState = prodState == null ? null : prodState.trim();
	}
	
    /**
     * @return ProdState
     */	
	public String getProdState() {
		return this.prodState;
	}
	
	/**
	 * @param riskLevel
	 */
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel == null ? null : riskLevel.trim();
	}
	
    /**
     * @return RiskLevel
     */	
	public String getRiskLevel() {
		return this.riskLevel;
	}
	
	/**
	 * @param prodDesc
	 */
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc == null ? null : prodDesc.trim();
	}
	
    /**
     * @return ProdDesc
     */	
	public String getProdDesc() {
		return this.prodDesc;
	}
	
	/**
	 * @param rate
	 */
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}
	
    /**
     * @return Rate
     */	
	public java.math.BigDecimal getRate() {
		return this.rate;
	}
	
	/**
	 * @param freeRate
	 */
	public void setFreeRate(java.math.BigDecimal freeRate) {
		this.freeRate = freeRate;
	}
	
    /**
     * @return FreeRate
     */	
	public java.math.BigDecimal getFreeRate() {
		return this.freeRate;
	}
	
	/**
	 * @param prodTerm
	 */
	public void setProdTerm(String prodTerm) {
		this.prodTerm = prodTerm == null ? null : prodTerm.trim();
	}
	
    /**
     * @return ProdTerm
     */	
	public String getProdTerm() {
		return this.prodTerm;
	}
	
	/**
	 * @param cuyyenType
	 */
	public void setCuyyenType(String cuyyenType) {
		this.cuyyenType = cuyyenType == null ? null : cuyyenType.trim();
	}
	
    /**
     * @return CuyyenType
     */	
	public String getCuyyenType() {
		return this.cuyyenType;
	}
	
	/**
	 * @param subscribeStartAmt
	 */
	public void setSubscribeStartAmt(java.math.BigDecimal subscribeStartAmt) {
		this.subscribeStartAmt = subscribeStartAmt;
	}
	
    /**
     * @return SubscribeStartAmt
     */	
	public java.math.BigDecimal getSubscribeStartAmt() {
		return this.subscribeStartAmt;
	}
	
	/**
	 * @param prodCharact
	 */
	public void setProdCharact(String prodCharact) {
		this.prodCharact = prodCharact == null ? null : prodCharact.trim();
	}
	
    /**
     * @return ProdCharact
     */	
	public String getProdCharact() {
		return this.prodCharact;
	}
	
	/**
	 * @param objCustDesc
	 */
	public void setObjCustDesc(String objCustDesc) {
		this.objCustDesc = objCustDesc == null ? null : objCustDesc.trim();
	}
	
    /**
     * @return ObjCustDesc
     */	
	public String getObjCustDesc() {
		return this.objCustDesc;
	}
	
	/**
	 * @param discntInfo
	 */
	public void setDiscntInfo(String discntInfo) {
		this.discntInfo = discntInfo == null ? null : discntInfo.trim();
	}
	
    /**
     * @return DiscntInfo
     */	
	public String getDiscntInfo() {
		return this.discntInfo;
	}
	
	/**
	 * @param mktMsg
	 */
	public void setMktMsg(String mktMsg) {
		this.mktMsg = mktMsg == null ? null : mktMsg.trim();
	}
	
    /**
     * @return MktMsg
     */	
	public String getMktMsg() {
		return this.mktMsg;
	}
	
	/**
	 * @param appObj
	 */
	public void setAppObj(String appObj) {
		this.appObj = appObj == null ? null : appObj.trim();
	}
	
    /**
     * @return AppObj
     */	
	public String getAppObj() {
		return this.appObj;
	}
	
	/**
	 * @param handChannle
	 */
	public void setHandChannle(String handChannle) {
		this.handChannle = handChannle == null ? null : handChannle.trim();
	}
	
    /**
     * @return HandChannle
     */	
	public String getHandChannle() {
		return this.handChannle;
	}
	
	/**
	 * @param handProcess
	 */
	public void setHandProcess(String handProcess) {
		this.handProcess = handProcess == null ? null : handProcess.trim();
	}
	
    /**
     * @return HandProcess
     */	
	public String getHandProcess() {
		return this.handProcess;
	}
	
	/**
	 * @param pdSource
	 */
	public void setPdSource(String pdSource) {
		this.pdSource = pdSource == null ? null : pdSource.trim();
	}
	
    /**
     * @return PdSource
     */	
	public String getPdSource() {
		return this.pdSource;
	}
	
	/**
	 * @param pdMagager
	 */
	public void setPdMagager(String pdMagager) {
		this.pdMagager = pdMagager == null ? null : pdMagager.trim();
	}
	
    /**
     * @return PdMagager
     */	
	public String getPdMagager() {
		return this.pdMagager;
	}
	
	/**
	 * @param managerDept
	 */
	public void setManagerDept(String managerDept) {
		this.managerDept = managerDept == null ? null : managerDept.trim();
	}
	
    /**
     * @return ManagerDept
     */	
	public String getManagerDept() {
		return this.managerDept;
	}
	
	/**
	 * @param buyCondition
	 */
	public void setBuyCondition(String buyCondition) {
		this.buyCondition = buyCondition == null ? null : buyCondition.trim();
	}
	
    /**
     * @return BuyCondition
     */	
	public String getBuyCondition() {
		return this.buyCondition;
	}
	
	/**
	 * @param isBanlace
	 */
	public void setIsBanlace(String isBanlace) {
		this.isBanlace = isBanlace == null ? null : isBanlace.trim();
	}
	
    /**
     * @return IsBanlace
     */	
	public String getIsBanlace() {
		return this.isBanlace;
	}
	
	/**
	 * @param incomeRate
	 */
	public void setIncomeRate(java.math.BigDecimal incomeRate) {
		this.incomeRate = incomeRate;
	}
	
    /**
     * @return IncomeRate
     */	
	public java.math.BigDecimal getIncomeRate() {
		return this.incomeRate;
	}
	
	/**
	 * @param isMultiRecord
	 */
	public void setIsMultiRecord(String isMultiRecord) {
		this.isMultiRecord = isMultiRecord == null ? null : isMultiRecord.trim();
	}
	
    /**
     * @return IsMultiRecord
     */	
	public String getIsMultiRecord() {
		return this.isMultiRecord;
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
	 * @param extTableId
	 */
	public void setExtTableId(String extTableId) {
		this.extTableId = extTableId == null ? null : extTableId.trim();
	}
	
    /**
     * @return ExtTableId
     */	
	public String getExtTableId() {
		return this.extTableId;
	}
	
	/**
	 * @param viewShowId
	 */
	public void setViewShowId(String viewShowId) {
		this.viewShowId = viewShowId == null ? null : viewShowId.trim();
	}
	
    /**
     * @return ViewShowId
     */	
	public String getViewShowId() {
		return this.viewShowId;
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
        AcrmFpdProdInfo other = (AcrmFpdProdInfo) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getSourcePrdNo() == null ? other.getSourcePrdNo() == null : this.getSourcePrdNo().equals(other.getSourcePrdNo()))
        	&& (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
        	&& (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()))
        	&& (this.getCatlCode() == null ? other.getCatlCode() == null : this.getCatlCode().equals(other.getCatlCode()))
                        	&& (this.getProdState() == null ? other.getProdState() == null : this.getProdState().equals(other.getProdState()))
        	&& (this.getRiskLevel() == null ? other.getRiskLevel() == null : this.getRiskLevel().equals(other.getRiskLevel()))
        	&& (this.getProdDesc() == null ? other.getProdDesc() == null : this.getProdDesc().equals(other.getProdDesc()))
                        	&& (this.getProdTerm() == null ? other.getProdTerm() == null : this.getProdTerm().equals(other.getProdTerm()))
        	&& (this.getCuyyenType() == null ? other.getCuyyenType() == null : this.getCuyyenType().equals(other.getCuyyenType()))
                	&& (this.getProdCharact() == null ? other.getProdCharact() == null : this.getProdCharact().equals(other.getProdCharact()))
        	&& (this.getObjCustDesc() == null ? other.getObjCustDesc() == null : this.getObjCustDesc().equals(other.getObjCustDesc()))
        	&& (this.getDiscntInfo() == null ? other.getDiscntInfo() == null : this.getDiscntInfo().equals(other.getDiscntInfo()))
        	&& (this.getMktMsg() == null ? other.getMktMsg() == null : this.getMktMsg().equals(other.getMktMsg()))
        	&& (this.getAppObj() == null ? other.getAppObj() == null : this.getAppObj().equals(other.getAppObj()))
        	&& (this.getHandChannle() == null ? other.getHandChannle() == null : this.getHandChannle().equals(other.getHandChannle()))
        	&& (this.getHandProcess() == null ? other.getHandProcess() == null : this.getHandProcess().equals(other.getHandProcess()))
        	&& (this.getPdSource() == null ? other.getPdSource() == null : this.getPdSource().equals(other.getPdSource()))
        	&& (this.getPdMagager() == null ? other.getPdMagager() == null : this.getPdMagager().equals(other.getPdMagager()))
        	&& (this.getManagerDept() == null ? other.getManagerDept() == null : this.getManagerDept().equals(other.getManagerDept()))
        	&& (this.getBuyCondition() == null ? other.getBuyCondition() == null : this.getBuyCondition().equals(other.getBuyCondition()))
        	&& (this.getIsBanlace() == null ? other.getIsBanlace() == null : this.getIsBanlace().equals(other.getIsBanlace()))
                	&& (this.getIsMultiRecord() == null ? other.getIsMultiRecord() == null : this.getIsMultiRecord().equals(other.getIsMultiRecord()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getExtTableId() == null ? other.getExtTableId() == null : this.getExtTableId().equals(other.getExtTableId()))
        	&& (this.getViewShowId() == null ? other.getViewShowId() == null : this.getViewShowId().equals(other.getViewShowId()))
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
        result = prime * result + ((getSourcePrdNo() == null) ? 0 : getSourcePrdNo().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        result = prime * result + ((getCatlCode() == null) ? 0 : getCatlCode().hashCode());
        result = prime * result + ((getProdState() == null) ? 0 : getProdState().hashCode());
        result = prime * result + ((getRiskLevel() == null) ? 0 : getRiskLevel().hashCode());
        result = prime * result + ((getProdDesc() == null) ? 0 : getProdDesc().hashCode());
        result = prime * result + ((getProdTerm() == null) ? 0 : getProdTerm().hashCode());
        result = prime * result + ((getCuyyenType() == null) ? 0 : getCuyyenType().hashCode());
        result = prime * result + ((getProdCharact() == null) ? 0 : getProdCharact().hashCode());
        result = prime * result + ((getObjCustDesc() == null) ? 0 : getObjCustDesc().hashCode());
        result = prime * result + ((getDiscntInfo() == null) ? 0 : getDiscntInfo().hashCode());
        result = prime * result + ((getMktMsg() == null) ? 0 : getMktMsg().hashCode());
        result = prime * result + ((getAppObj() == null) ? 0 : getAppObj().hashCode());
        result = prime * result + ((getHandChannle() == null) ? 0 : getHandChannle().hashCode());
        result = prime * result + ((getHandProcess() == null) ? 0 : getHandProcess().hashCode());
        result = prime * result + ((getPdSource() == null) ? 0 : getPdSource().hashCode());
        result = prime * result + ((getPdMagager() == null) ? 0 : getPdMagager().hashCode());
        result = prime * result + ((getManagerDept() == null) ? 0 : getManagerDept().hashCode());
        result = prime * result + ((getBuyCondition() == null) ? 0 : getBuyCondition().hashCode());
        result = prime * result + ((getIsBanlace() == null) ? 0 : getIsBanlace().hashCode());
        result = prime * result + ((getIsMultiRecord() == null) ? 0 : getIsMultiRecord().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getExtTableId() == null) ? 0 : getExtTableId().hashCode());
        result = prime * result + ((getViewShowId() == null) ? 0 : getViewShowId().hashCode());
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
		sb.append(", lastChgTm=").append(lastChgTm);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", sourcePrdNo=").append(sourcePrdNo);
		sb.append(", productId=").append(productId);
		sb.append(", prodName=").append(prodName);
		sb.append(", catlCode=").append(catlCode);
		sb.append(", prodStartDate=").append(prodStartDate);
		sb.append(", prodEndDate=").append(prodEndDate);
		sb.append(", prodState=").append(prodState);
		sb.append(", riskLevel=").append(riskLevel);
		sb.append(", prodDesc=").append(prodDesc);
		sb.append(", rate=").append(rate);
		sb.append(", freeRate=").append(freeRate);
		sb.append(", prodTerm=").append(prodTerm);
		sb.append(", cuyyenType=").append(cuyyenType);
		sb.append(", subscribeStartAmt=").append(subscribeStartAmt);
		sb.append(", prodCharact=").append(prodCharact);
		sb.append(", objCustDesc=").append(objCustDesc);
		sb.append(", discntInfo=").append(discntInfo);
		sb.append(", mktMsg=").append(mktMsg);
		sb.append(", appObj=").append(appObj);
		sb.append(", handChannle=").append(handChannle);
		sb.append(", handProcess=").append(handProcess);
		sb.append(", pdSource=").append(pdSource);
		sb.append(", pdMagager=").append(pdMagager);
		sb.append(", managerDept=").append(managerDept);
		sb.append(", buyCondition=").append(buyCondition);
		sb.append(", isBanlace=").append(isBanlace);
		sb.append(", incomeRate=").append(incomeRate);
		sb.append(", isMultiRecord=").append(isMultiRecord);
		sb.append(", remark=").append(remark);
		sb.append(", extTableId=").append(extTableId);
		sb.append(", viewShowId=").append(viewShowId);
        sb.append("]");
        return sb.toString();
    }
}