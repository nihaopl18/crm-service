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
 * @类名称: AcrmAbrBusiSum
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-28 10:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_A_BR_BUSI_SUM")
public class AcrmAbrBusiSum extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = false, length = 8)
	private String dataDate;
	
	/** 客户主办机构 **/
	@Column(name = "BELONG_BRCH_NO", unique = false, nullable = false, length = 30)
	private String belongBrchNo;
	
	/** 管理客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = false, length = 1)
	private String custType;
	
	/** 管理客户数 **/
	@Column(name = "CUST_NUM", unique = false, nullable = true, length = 10)
	private long custNum;
	/** 服务等级0星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV0", unique = false, nullable = true, length = 10)
	private long custNumServiceLv0;
	/** 服务等级1星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV1", unique = false, nullable = true, length = 10)
	private long custNumServiceLv1;
	
	/** 服务等级2星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV2", unique = false, nullable = true, length = 10)
	private long custNumServiceLv2;
	
	/** 服务等级3星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV3", unique = false, nullable = true, length = 10)
	private long custNumServiceLv3;
	
	/** 服务等级4星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV4", unique = false, nullable = true, length = 10)
	private long custNumServiceLv4;
	
	/** 服务等级5星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV5", unique = false, nullable = true, length = 10)
	private long custNumServiceLv5;
	
	/** 服务等级6星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV6", unique = false, nullable = true, length = 10)
	private long custNumServiceLv6;
	
	/** 服务等级7星客户数 **/
	@Column(name = "CUST_NUM_SERVICE_LV7", unique = false, nullable = true, length = 10)
	private long custNumServiceLv7;
	
	/** 个人价值等级低效客户数\对公价值等级低效级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV0", unique = false, nullable = true, length = 10)
	private long custNumGradeLv0;
	
	/** 个人价值等级大众客户数\对公对公价值等级基础级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV1", unique = false, nullable = true, length = 10)
	private long custNumGradeLv1;
	
	/** 个人价值等级理财客户数\对公价值等级普通级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV2", unique = false, nullable = true, length = 10)
	private long custNumGradeLv2;
	
	/** 个人价值等级金卡客户数\对公价值等级潜力级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV3", unique = false, nullable = true, length = 10)
	private long custNumGradeLv3;
	
	/** 个人价值等级价值客户数\对公价值等级支行重点级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV4", unique = false, nullable = true, length = 10)
	private long custNumGradeLv4;
	
	/** 个人价值等级财富客户数\对公价值等级支行战略级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV5", unique = false, nullable = true, length = 10)
	private long custNumGradeLv5;
	
	/** 个人价值等级准私人银行客户数\对公价值等级总行重点级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV6", unique = false, nullable = true, length = 10)
	private long custNumGradeLv6;
	
	/** 个人价值等级私人银行客户数\对公价值等级总行战略级客户数 **/
	@Column(name = "CUST_NUM_GRADE_LV7", unique = false, nullable = true, length = 10)
	private long custNumGradeLv7;
	
	/** 本月综合贡献度 **/
	@Column(name = "M_SUM_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal msumContribu;
	
	/** 本月存款贡献度 **/
	@Column(name = "M_DEP_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mdepContribu;
	
	/** 本月贷款贡献度 **/
	@Column(name = "M_LOAN_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mloanContribu;
	
	/** 本月中间业务贡献度 **/
	@Column(name = "M_MID_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mmidContribu;
	
	/** AUM时点余额 **/
	@Column(name = "AUM_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumBal;
	
	/** 存款时点余额 **/
	@Column(name = "DPS_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsBal;
	
	/** 理财时点余额 **/
	@Column(name = "FIN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal finBal;
	
	/** 基金时点余额 **/
	@Column(name = "FUND_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal fundBal;
	
	/** 保险时点余额 **/
	@Column(name = "INSU_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal insuBal;
	
	/** 贵金属时点余额 **/
	@Column(name = "GOLD_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal goldBal;
	
	/** 信用卡溢缴款时点余额 **/
	@Column(name = "CCD_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal ccdBal;
	
	/** 贷款时点余额 **/
	@Column(name = "LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanBal;
	
	/** AUM余额月日均 **/
	@Column(name = "AUM_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumMavgBal;
	
	/** 存款余额月日均 **/
	@Column(name = "DPS_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsMavgBal;
	
	/** 理财余额月日均 **/
	@Column(name = "FIN_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal finMavgBal;
	
	/** 基金余额月日均 **/
	@Column(name = "FUND_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal fundMavgBal;
	
	/** 保险余额月日均 **/
	@Column(name = "INSU_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal insuMavgBal;
	
	/** 贵金属余额月日均 **/
	@Column(name = "GOLD_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal goldMavgBal;
	
	/** 信用卡溢缴款余额月日均 **/
	@Column(name = "CCD_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal ccdMavgBal;
	
	/** 贷款余额月日均 **/
	@Column(name = "LOAN_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanMavgBal;
	
	/** AUM余额季日均 **/
	@Column(name = "AUM_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumQavgBal;
	
	/** 存款余额季日均 **/
	@Column(name = "DPS_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsQavgBal;
	
	/** 理财余额季日均 **/
	@Column(name = "FIN_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal finQavgBal;
	
	/** 基金余额季日均 **/
	@Column(name = "FUND_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal fundQavgBal;
	
	/** 保险余额季日均 **/
	@Column(name = "INSU_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal insuQavgBal;
	
	/** 贵金属余额季日均 **/
	@Column(name = "GOLD_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal goldQavgBal;
	
	/** 信用卡溢缴款余额季日均 **/
	@Column(name = "CCD_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal ccdQavgBal;
	
	/** 贷款余额季日均 **/
	@Column(name = "LOAN_Q_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanQavgBal;
	
	/** AUM余额半年日均 **/
	@Column(name = "AUM_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumHyAvgBal;
	
	/** 存款余额半年日均 **/
	@Column(name = "DPS_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsHyAvgBal;
	
	/** 理财余额半年日均 **/
	@Column(name = "FIN_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal finHyAvgBal;
	
	/** 基金余额半年日均 **/
	@Column(name = "FUND_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal fundHyAvgBal;
	
	/** 保险余额半年日均 **/
	@Column(name = "INSU_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal insuHyAvgBal;
	
	/** 贵金属余额半年日均 **/
	@Column(name = "GOLD_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal goldHyAvgBal;
	
	/** 信用卡溢缴款余额半年日均 **/
	@Column(name = "CCD_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal ccdHyAvgBal;
	
	/** 贷款余额半年日均 **/
	@Column(name = "LOAN_HY_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanHyAvgBal;
	
	/** AUM余额年日均 **/
	@Column(name = "AUM_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumYavgBal;
	
	/** 存款余额年日均 **/
	@Column(name = "DPS_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsYavgBal;
	
	/** 理财余额年日均 **/
	@Column(name = "FIN_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal finYavgBal;
	
	/** 基金余额年日均 **/
	@Column(name = "FUND_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal fundYavgBal;
	
	/** 保险余额年日均 **/
	@Column(name = "INSU_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal insuYavgBal;
	
	/** 贵金属余额年日均 **/
	@Column(name = "GOLD_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal goldYavgBal;
	
	/** 信用卡溢缴款余额年日均 **/
	@Column(name = "CCD_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal ccdYavgBal;
	
	/** 贷款余额年日均 **/
	@Column(name = "LOAN_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanYavgBal;
	
	
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
	 * @param belongBrchNo
	 */
	public void setBelongBrchNo(String belongBrchNo) {
		this.belongBrchNo = belongBrchNo == null ? null : belongBrchNo.trim();
	}
	
    /**
     * @return BelongBrchNo
     */	
	public String getBelongBrchNo() {
		return this.belongBrchNo;
	}
	
	/**
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param custNum
	 */
	public void setCustNum(long custNum) {
		this.custNum = custNum;
	}
	
    /**
     * @return CustNum
     */	
	public long getCustNum() {
		return this.custNum;
	}
	
	/**
	 * @param custNumServiceLv1
	 */
	public void setCustNumServiceLv1(long custNumServiceLv1) {
		this.custNumServiceLv1 = custNumServiceLv1;
	}
	/**
	 * @param custNumServiceLv0
	 */
	public void setCustNumServiceLv0(long custNumServiceLv0) {
		this.custNumServiceLv0 = custNumServiceLv0;
	}
	
    /**
     * @return CustNumServiceLv1
     */	
	public long getCustNumServiceLv1() {
		return this.custNumServiceLv1;
	}
	/**
     * @return CustNumServiceLv0
     */	
	public long getCustNumServiceLv0() {
		return this.custNumServiceLv0;
	}
	/**
	 * @param custNumServiceLv2
	 */
	public void setCustNumServiceLv2(long custNumServiceLv2) {
		this.custNumServiceLv2 = custNumServiceLv2;
	}
	
    /**
     * @return CustNumServiceLv2
     */	
	public long getCustNumServiceLv2() {
		return this.custNumServiceLv2;
	}
	
	/**
	 * @param custNumServiceLv3
	 */
	public void setCustNumServiceLv3(long custNumServiceLv3) {
		this.custNumServiceLv3 = custNumServiceLv3;
	}
	
    /**
     * @return CustNumServiceLv3
     */	
	public long getCustNumServiceLv3() {
		return this.custNumServiceLv3;
	}
	
	/**
	 * @param custNumServiceLv4
	 */
	public void setCustNumServiceLv4(long custNumServiceLv4) {
		this.custNumServiceLv4 = custNumServiceLv4;
	}
	
    /**
     * @return CustNumServiceLv4
     */	
	public long getCustNumServiceLv4() {
		return this.custNumServiceLv4;
	}
	
	/**
	 * @param custNumServiceLv5
	 */
	public void setCustNumServiceLv5(long custNumServiceLv5) {
		this.custNumServiceLv5 = custNumServiceLv5;
	}
	
    /**
     * @return CustNumServiceLv5
     */	
	public long getCustNumServiceLv5() {
		return this.custNumServiceLv5;
	}
	
	/**
	 * @param custNumServiceLv6
	 */
	public void setCustNumServiceLv6(long custNumServiceLv6) {
		this.custNumServiceLv6 = custNumServiceLv6;
	}
	
    /**
     * @return CustNumServiceLv6
     */	
	public long getCustNumServiceLv6() {
		return this.custNumServiceLv6;
	}
	
	/**
	 * @param custNumServiceLv7
	 */
	public void setCustNumServiceLv7(long custNumServiceLv7) {
		this.custNumServiceLv7 = custNumServiceLv7;
	}
	
    /**
     * @return CustNumServiceLv7
     */	
	public long getCustNumServiceLv7() {
		return this.custNumServiceLv7;
	}
	
	/**
	 * @param custNumGradeLv1
	 */
	public void setCustNumGradeLv1(long custNumGradeLv1) {
		this.custNumGradeLv1 = custNumGradeLv1;
	}
	
    /**
     * @return CustNumGradeLv1
     */	
	public long getCustNumGradeLv1() {
		return this.custNumGradeLv1;
	}
	
	/**
	 * @param custNumGradeLv2
	 */
	public void setCustNumGradeLv2(long custNumGradeLv2) {
		this.custNumGradeLv2 = custNumGradeLv2;
	}
	
    /**
     * @return CustNumGradeLv2
     */	
	public long getCustNumGradeLv2() {
		return this.custNumGradeLv2;
	}
	
	/**
	 * @param custNumGradeLv3
	 */
	public void setCustNumGradeLv3(long custNumGradeLv3) {
		this.custNumGradeLv3 = custNumGradeLv3;
	}
	
    /**
     * @return CustNumGradeLv3
     */	
	public long getCustNumGradeLv3() {
		return this.custNumGradeLv3;
	}
	
	/**
	 * @param custNumGradeLv4
	 */
	public void setCustNumGradeLv4(long custNumGradeLv4) {
		this.custNumGradeLv4 = custNumGradeLv4;
	}
	
    /**
     * @return CustNumGradeLv4
     */	
	public long getCustNumGradeLv4() {
		return this.custNumGradeLv4;
	}
	
	/**
	 * @param custNumGradeLv5
	 */
	public void setCustNumGradeLv5(long custNumGradeLv5) {
		this.custNumGradeLv5 = custNumGradeLv5;
	}
	
    /**
     * @return CustNumGradeLv5
     */	
	public long getCustNumGradeLv5() {
		return this.custNumGradeLv5;
	}
	
	/**
	 * @param custNumGradeLv6
	 */
	public void setCustNumGradeLv6(long custNumGradeLv6) {
		this.custNumGradeLv6 = custNumGradeLv6;
	}
	
    /**
     * @return CustNumGradeLv6
     */	
	public long getCustNumGradeLv6() {
		return this.custNumGradeLv6;
	}
	
	/**
	 * @param custNumGradeLv7
	 */
	public void setCustNumGradeLv7(long custNumGradeLv7) {
		this.custNumGradeLv7 = custNumGradeLv7;
	}
	
    /**
     * @return CustNumGradeLv7
     */	
	public long getCustNumGradeLv7() {
		return this.custNumGradeLv7;
	}
	
	/**
	 * @param custNumGradeLv0
	 */
	public void setcustNumGradeLv0(long custNumGradeLv0) {
		this.custNumGradeLv0 = custNumGradeLv0;
	}
	
    /**
     * @return custNumGradeLv0
     */	
	public long getcustNumGradeLv0() {
		return this.custNumGradeLv0;
	}
	
	/**
	 * @param msumContribu
	 */
	public void setMsumContribu(java.math.BigDecimal msumContribu) {
		this.msumContribu = msumContribu;
	}
	
    /**
     * @return MsumContribu
     */	
	public java.math.BigDecimal getMsumContribu() {
		return this.msumContribu;
	}
	
	/**
	 * @param mdepContribu
	 */
	public void setMdepContribu(java.math.BigDecimal mdepContribu) {
		this.mdepContribu = mdepContribu;
	}
	
    /**
     * @return MdepContribu
     */	
	public java.math.BigDecimal getMdepContribu() {
		return this.mdepContribu;
	}
	
	/**
	 * @param mloanContribu
	 */
	public void setMloanContribu(java.math.BigDecimal mloanContribu) {
		this.mloanContribu = mloanContribu;
	}
	
    /**
     * @return MloanContribu
     */	
	public java.math.BigDecimal getMloanContribu() {
		return this.mloanContribu;
	}
	
	/**
	 * @param mmidContribu
	 */
	public void setMmidContribu(java.math.BigDecimal mmidContribu) {
		this.mmidContribu = mmidContribu;
	}
	
    /**
     * @return MmidContribu
     */	
	public java.math.BigDecimal getMmidContribu() {
		return this.mmidContribu;
	}
	
	/**
	 * @param aumBal
	 */
	public void setAumBal(java.math.BigDecimal aumBal) {
		this.aumBal = aumBal;
	}
	
    /**
     * @return AumBal
     */	
	public java.math.BigDecimal getAumBal() {
		return this.aumBal;
	}
	
	/**
	 * @param dpsBal
	 */
	public void setDpsBal(java.math.BigDecimal dpsBal) {
		this.dpsBal = dpsBal;
	}
	
    /**
     * @return DpsBal
     */	
	public java.math.BigDecimal getDpsBal() {
		return this.dpsBal;
	}
	
	/**
	 * @param finBal
	 */
	public void setFinBal(java.math.BigDecimal finBal) {
		this.finBal = finBal;
	}
	
    /**
     * @return FinBal
     */	
	public java.math.BigDecimal getFinBal() {
		return this.finBal;
	}
	
	/**
	 * @param fundBal
	 */
	public void setFundBal(java.math.BigDecimal fundBal) {
		this.fundBal = fundBal;
	}
	
    /**
     * @return FundBal
     */	
	public java.math.BigDecimal getFundBal() {
		return this.fundBal;
	}
	
	/**
	 * @param insuBal
	 */
	public void setInsuBal(java.math.BigDecimal insuBal) {
		this.insuBal = insuBal;
	}
	
    /**
     * @return InsuBal
     */	
	public java.math.BigDecimal getInsuBal() {
		return this.insuBal;
	}
	
	/**
	 * @param goldBal
	 */
	public void setGoldBal(java.math.BigDecimal goldBal) {
		this.goldBal = goldBal;
	}
	
    /**
     * @return GoldBal
     */	
	public java.math.BigDecimal getGoldBal() {
		return this.goldBal;
	}
	
	/**
	 * @param ccdBal
	 */
	public void setCcdBal(java.math.BigDecimal ccdBal) {
		this.ccdBal = ccdBal;
	}
	
    /**
     * @return CcdBal
     */	
	public java.math.BigDecimal getCcdBal() {
		return this.ccdBal;
	}
	
	/**
	 * @param loanBal
	 */
	public void setLoanBal(java.math.BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	
    /**
     * @return LoanBal
     */	
	public java.math.BigDecimal getLoanBal() {
		return this.loanBal;
	}
	
	/**
	 * @param aumMavgBal
	 */
	public void setAumMavgBal(java.math.BigDecimal aumMavgBal) {
		this.aumMavgBal = aumMavgBal;
	}
	
    /**
     * @return AumMavgBal
     */	
	public java.math.BigDecimal getAumMavgBal() {
		return this.aumMavgBal;
	}
	
	/**
	 * @param dpsMavgBal
	 */
	public void setDpsMavgBal(java.math.BigDecimal dpsMavgBal) {
		this.dpsMavgBal = dpsMavgBal;
	}
	
    /**
     * @return DpsMavgBal
     */	
	public java.math.BigDecimal getDpsMavgBal() {
		return this.dpsMavgBal;
	}
	
	/**
	 * @param finMavgBal
	 */
	public void setFinMavgBal(java.math.BigDecimal finMavgBal) {
		this.finMavgBal = finMavgBal;
	}
	
    /**
     * @return FinMavgBal
     */	
	public java.math.BigDecimal getFinMavgBal() {
		return this.finMavgBal;
	}
	
	/**
	 * @param fundMavgBal
	 */
	public void setFundMavgBal(java.math.BigDecimal fundMavgBal) {
		this.fundMavgBal = fundMavgBal;
	}
	
    /**
     * @return FundMavgBal
     */	
	public java.math.BigDecimal getFundMavgBal() {
		return this.fundMavgBal;
	}
	
	/**
	 * @param insuMavgBal
	 */
	public void setInsuMavgBal(java.math.BigDecimal insuMavgBal) {
		this.insuMavgBal = insuMavgBal;
	}
	
    /**
     * @return InsuMavgBal
     */	
	public java.math.BigDecimal getInsuMavgBal() {
		return this.insuMavgBal;
	}
	
	/**
	 * @param goldMavgBal
	 */
	public void setGoldMavgBal(java.math.BigDecimal goldMavgBal) {
		this.goldMavgBal = goldMavgBal;
	}
	
    /**
     * @return GoldMavgBal
     */	
	public java.math.BigDecimal getGoldMavgBal() {
		return this.goldMavgBal;
	}
	
	/**
	 * @param ccdMavgBal
	 */
	public void setCcdMavgBal(java.math.BigDecimal ccdMavgBal) {
		this.ccdMavgBal = ccdMavgBal;
	}
	
    /**
     * @return CcdMavgBal
     */	
	public java.math.BigDecimal getCcdMavgBal() {
		return this.ccdMavgBal;
	}
	
	/**
	 * @param loanMavgBal
	 */
	public void setLoanMavgBal(java.math.BigDecimal loanMavgBal) {
		this.loanMavgBal = loanMavgBal;
	}
	
    /**
     * @return LoanMavgBal
     */	
	public java.math.BigDecimal getLoanMavgBal() {
		return this.loanMavgBal;
	}
	
	/**
	 * @param aumQavgBal
	 */
	public void setAumQavgBal(java.math.BigDecimal aumQavgBal) {
		this.aumQavgBal = aumQavgBal;
	}
	
    /**
     * @return AumQavgBal
     */	
	public java.math.BigDecimal getAumQavgBal() {
		return this.aumQavgBal;
	}
	
	/**
	 * @param dpsQavgBal
	 */
	public void setDpsQavgBal(java.math.BigDecimal dpsQavgBal) {
		this.dpsQavgBal = dpsQavgBal;
	}
	
    /**
     * @return DpsQavgBal
     */	
	public java.math.BigDecimal getDpsQavgBal() {
		return this.dpsQavgBal;
	}
	
	/**
	 * @param finQavgBal
	 */
	public void setFinQavgBal(java.math.BigDecimal finQavgBal) {
		this.finQavgBal = finQavgBal;
	}
	
    /**
     * @return FinQavgBal
     */	
	public java.math.BigDecimal getFinQavgBal() {
		return this.finQavgBal;
	}
	
	/**
	 * @param fundQavgBal
	 */
	public void setFundQavgBal(java.math.BigDecimal fundQavgBal) {
		this.fundQavgBal = fundQavgBal;
	}
	
    /**
     * @return FundQavgBal
     */	
	public java.math.BigDecimal getFundQavgBal() {
		return this.fundQavgBal;
	}
	
	/**
	 * @param insuQavgBal
	 */
	public void setInsuQavgBal(java.math.BigDecimal insuQavgBal) {
		this.insuQavgBal = insuQavgBal;
	}
	
    /**
     * @return InsuQavgBal
     */	
	public java.math.BigDecimal getInsuQavgBal() {
		return this.insuQavgBal;
	}
	
	/**
	 * @param goldQavgBal
	 */
	public void setGoldQavgBal(java.math.BigDecimal goldQavgBal) {
		this.goldQavgBal = goldQavgBal;
	}
	
    /**
     * @return GoldQavgBal
     */	
	public java.math.BigDecimal getGoldQavgBal() {
		return this.goldQavgBal;
	}
	
	/**
	 * @param ccdQavgBal
	 */
	public void setCcdQavgBal(java.math.BigDecimal ccdQavgBal) {
		this.ccdQavgBal = ccdQavgBal;
	}
	
    /**
     * @return CcdQavgBal
     */	
	public java.math.BigDecimal getCcdQavgBal() {
		return this.ccdQavgBal;
	}
	
	/**
	 * @param loanQavgBal
	 */
	public void setLoanQavgBal(java.math.BigDecimal loanQavgBal) {
		this.loanQavgBal = loanQavgBal;
	}
	
    /**
     * @return LoanQavgBal
     */	
	public java.math.BigDecimal getLoanQavgBal() {
		return this.loanQavgBal;
	}
	
	/**
	 * @param aumHyAvgBal
	 */
	public void setAumHyAvgBal(java.math.BigDecimal aumHyAvgBal) {
		this.aumHyAvgBal = aumHyAvgBal;
	}
	
    /**
     * @return AumHyAvgBal
     */	
	public java.math.BigDecimal getAumHyAvgBal() {
		return this.aumHyAvgBal;
	}
	
	/**
	 * @param dpsHyAvgBal
	 */
	public void setDpsHyAvgBal(java.math.BigDecimal dpsHyAvgBal) {
		this.dpsHyAvgBal = dpsHyAvgBal;
	}
	
    /**
     * @return DpsHyAvgBal
     */	
	public java.math.BigDecimal getDpsHyAvgBal() {
		return this.dpsHyAvgBal;
	}
	
	/**
	 * @param finHyAvgBal
	 */
	public void setFinHyAvgBal(java.math.BigDecimal finHyAvgBal) {
		this.finHyAvgBal = finHyAvgBal;
	}
	
    /**
     * @return FinHyAvgBal
     */	
	public java.math.BigDecimal getFinHyAvgBal() {
		return this.finHyAvgBal;
	}
	
	/**
	 * @param fundHyAvgBal
	 */
	public void setFundHyAvgBal(java.math.BigDecimal fundHyAvgBal) {
		this.fundHyAvgBal = fundHyAvgBal;
	}
	
    /**
     * @return FundHyAvgBal
     */	
	public java.math.BigDecimal getFundHyAvgBal() {
		return this.fundHyAvgBal;
	}
	
	/**
	 * @param insuHyAvgBal
	 */
	public void setInsuHyAvgBal(java.math.BigDecimal insuHyAvgBal) {
		this.insuHyAvgBal = insuHyAvgBal;
	}
	
    /**
     * @return InsuHyAvgBal
     */	
	public java.math.BigDecimal getInsuHyAvgBal() {
		return this.insuHyAvgBal;
	}
	
	/**
	 * @param goldHyAvgBal
	 */
	public void setGoldHyAvgBal(java.math.BigDecimal goldHyAvgBal) {
		this.goldHyAvgBal = goldHyAvgBal;
	}
	
    /**
     * @return GoldHyAvgBal
     */	
	public java.math.BigDecimal getGoldHyAvgBal() {
		return this.goldHyAvgBal;
	}
	
	/**
	 * @param ccdHyAvgBal
	 */
	public void setCcdHyAvgBal(java.math.BigDecimal ccdHyAvgBal) {
		this.ccdHyAvgBal = ccdHyAvgBal;
	}
	
    /**
     * @return CcdHyAvgBal
     */	
	public java.math.BigDecimal getCcdHyAvgBal() {
		return this.ccdHyAvgBal;
	}
	
	/**
	 * @param loanHyAvgBal
	 */
	public void setLoanHyAvgBal(java.math.BigDecimal loanHyAvgBal) {
		this.loanHyAvgBal = loanHyAvgBal;
	}
	
    /**
     * @return LoanHyAvgBal
     */	
	public java.math.BigDecimal getLoanHyAvgBal() {
		return this.loanHyAvgBal;
	}
	
	/**
	 * @param aumYavgBal
	 */
	public void setAumYavgBal(java.math.BigDecimal aumYavgBal) {
		this.aumYavgBal = aumYavgBal;
	}
	
    /**
     * @return AumYavgBal
     */	
	public java.math.BigDecimal getAumYavgBal() {
		return this.aumYavgBal;
	}
	
	/**
	 * @param dpsYavgBal
	 */
	public void setDpsYavgBal(java.math.BigDecimal dpsYavgBal) {
		this.dpsYavgBal = dpsYavgBal;
	}
	
    /**
     * @return DpsYavgBal
     */	
	public java.math.BigDecimal getDpsYavgBal() {
		return this.dpsYavgBal;
	}
	
	/**
	 * @param finYavgBal
	 */
	public void setFinYavgBal(java.math.BigDecimal finYavgBal) {
		this.finYavgBal = finYavgBal;
	}
	
    /**
     * @return FinYavgBal
     */	
	public java.math.BigDecimal getFinYavgBal() {
		return this.finYavgBal;
	}
	
	/**
	 * @param fundYavgBal
	 */
	public void setFundYavgBal(java.math.BigDecimal fundYavgBal) {
		this.fundYavgBal = fundYavgBal;
	}
	
    /**
     * @return FundYavgBal
     */	
	public java.math.BigDecimal getFundYavgBal() {
		return this.fundYavgBal;
	}
	
	/**
	 * @param insuYavgBal
	 */
	public void setInsuYavgBal(java.math.BigDecimal insuYavgBal) {
		this.insuYavgBal = insuYavgBal;
	}
	
    /**
     * @return InsuYavgBal
     */	
	public java.math.BigDecimal getInsuYavgBal() {
		return this.insuYavgBal;
	}
	
	/**
	 * @param goldYavgBal
	 */
	public void setGoldYavgBal(java.math.BigDecimal goldYavgBal) {
		this.goldYavgBal = goldYavgBal;
	}
	
    /**
     * @return GoldYavgBal
     */	
	public java.math.BigDecimal getGoldYavgBal() {
		return this.goldYavgBal;
	}
	
	/**
	 * @param ccdYavgBal
	 */
	public void setCcdYavgBal(java.math.BigDecimal ccdYavgBal) {
		this.ccdYavgBal = ccdYavgBal;
	}
	
    /**
     * @return CcdYavgBal
     */	
	public java.math.BigDecimal getCcdYavgBal() {
		return this.ccdYavgBal;
	}
	
	/**
	 * @param loanYavgBal
	 */
	public void setLoanYavgBal(java.math.BigDecimal loanYavgBal) {
		this.loanYavgBal = loanYavgBal;
	}
	
    /**
     * @return LoanYavgBal
     */	
	public java.math.BigDecimal getLoanYavgBal() {
		return this.loanYavgBal;
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
        AcrmAbrBusiSum other = (AcrmAbrBusiSum) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getBelongBrchNo() == null ? other.getBelongBrchNo() == null : this.getBelongBrchNo().equals(other.getBelongBrchNo()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getBelongBrchNo() == null) ? 0 : getBelongBrchNo().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", belongBrchNo=").append(belongBrchNo);
		sb.append(", custType=").append(custType);
		sb.append(", custNum=").append(custNum);
		sb.append(", custNumServiceLv1=").append(custNumServiceLv1);
		sb.append(", custNumServiceLv0=").append(custNumServiceLv0);
		sb.append(", custNumServiceLv2=").append(custNumServiceLv2);
		sb.append(", custNumServiceLv3=").append(custNumServiceLv3);
		sb.append(", custNumServiceLv4=").append(custNumServiceLv4);
		sb.append(", custNumServiceLv5=").append(custNumServiceLv5);
		sb.append(", custNumServiceLv6=").append(custNumServiceLv6);
		sb.append(", custNumServiceLv7=").append(custNumServiceLv7);
		sb.append(", custNumGradeLv1=").append(custNumGradeLv1);
		sb.append(", custNumGradeLv2=").append(custNumGradeLv2);
		sb.append(", custNumGradeLv3=").append(custNumGradeLv3);
		sb.append(", custNumGradeLv4=").append(custNumGradeLv4);
		sb.append(", custNumGradeLv5=").append(custNumGradeLv5);
		sb.append(", custNumGradeLv6=").append(custNumGradeLv6);
		sb.append(", custNumGradeLv7=").append(custNumGradeLv7);
		sb.append(", custNumGradeLv0=").append(custNumGradeLv0);
		sb.append(", msumContribu=").append(msumContribu);
		sb.append(", mdepContribu=").append(mdepContribu);
		sb.append(", mloanContribu=").append(mloanContribu);
		sb.append(", mmidContribu=").append(mmidContribu);
		sb.append(", aumBal=").append(aumBal);
		sb.append(", dpsBal=").append(dpsBal);
		sb.append(", finBal=").append(finBal);
		sb.append(", fundBal=").append(fundBal);
		sb.append(", insuBal=").append(insuBal);
		sb.append(", goldBal=").append(goldBal);
		sb.append(", ccdBal=").append(ccdBal);
		sb.append(", loanBal=").append(loanBal);
		sb.append(", aumMavgBal=").append(aumMavgBal);
		sb.append(", dpsMavgBal=").append(dpsMavgBal);
		sb.append(", finMavgBal=").append(finMavgBal);
		sb.append(", fundMavgBal=").append(fundMavgBal);
		sb.append(", insuMavgBal=").append(insuMavgBal);
		sb.append(", goldMavgBal=").append(goldMavgBal);
		sb.append(", ccdMavgBal=").append(ccdMavgBal);
		sb.append(", loanMavgBal=").append(loanMavgBal);
		sb.append(", aumQavgBal=").append(aumQavgBal);
		sb.append(", dpsQavgBal=").append(dpsQavgBal);
		sb.append(", finQavgBal=").append(finQavgBal);
		sb.append(", fundQavgBal=").append(fundQavgBal);
		sb.append(", insuQavgBal=").append(insuQavgBal);
		sb.append(", goldQavgBal=").append(goldQavgBal);
		sb.append(", ccdQavgBal=").append(ccdQavgBal);
		sb.append(", loanQavgBal=").append(loanQavgBal);
		sb.append(", aumHyAvgBal=").append(aumHyAvgBal);
		sb.append(", dpsHyAvgBal=").append(dpsHyAvgBal);
		sb.append(", finHyAvgBal=").append(finHyAvgBal);
		sb.append(", fundHyAvgBal=").append(fundHyAvgBal);
		sb.append(", insuHyAvgBal=").append(insuHyAvgBal);
		sb.append(", goldHyAvgBal=").append(goldHyAvgBal);
		sb.append(", ccdHyAvgBal=").append(ccdHyAvgBal);
		sb.append(", loanHyAvgBal=").append(loanHyAvgBal);
		sb.append(", aumYavgBal=").append(aumYavgBal);
		sb.append(", dpsYavgBal=").append(dpsYavgBal);
		sb.append(", finYavgBal=").append(finYavgBal);
		sb.append(", fundYavgBal=").append(fundYavgBal);
		sb.append(", insuYavgBal=").append(insuYavgBal);
		sb.append(", goldYavgBal=").append(goldYavgBal);
		sb.append(", ccdYavgBal=").append(ccdYavgBal);
		sb.append(", loanYavgBal=").append(loanYavgBal);
        sb.append("]");
        return sb.toString();
    }
}