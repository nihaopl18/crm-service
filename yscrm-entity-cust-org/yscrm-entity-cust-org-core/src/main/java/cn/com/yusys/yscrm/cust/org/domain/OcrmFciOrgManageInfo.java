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
 * @类名称: OcrmFciOrgManageInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-02-26 22:40:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_ORG_MANAGE_INFO")
public class OcrmFciOrgManageInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	/** 数据日期 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	/** 最近更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 注册资本币别 **/
	@Column(name = "REG_CURR_CD", unique = false, nullable = true, length = 30)
	private String regCurrCd;
	
	/** 注册资本(万元) **/
	@Column(name = "REG_CAPITAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal regCapital;
	
	/** 净资产(万元) **/
	@Column(name = "NET_ASSET", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal netAsset;
	
	/** 雇员人数 **/
	@Column(name = "EMP_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal empNum;
	
	/** 主营范围 **/
	@Column(name = "MAIN_RANGE", unique = false, nullable = true, length = 500)
	private String mainRange;
	
	/** 经营场地面积(平方米) **/
	@Column(name = "PREMIS_AREA", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal premisArea;
	
	/** 经营场地所有权 **/
	@Column(name = "PREMIS_OWNERSHIP", unique = false, nullable = true, length = 60)
	private String premisOwnership;
	
	/** 经营状况 **/
	@Column(name = "MANAGE_STAT", unique = false, nullable = true, length = 100)
	private String manageStat;
	
	/** 总资产(万元) **/
	@Column(name = "TOTAL_ASSET", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal totalAsset;
	
	/** 负债(万元) **/
	@Column(name = "DEBT_TOTAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal debtTotal;
	
	/** 存货(万元) **/
	@Column(name = "INVEN_TOTAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal invenTotal;
	
	/** 销售总额(万元) **/
	@Column(name = "SALE_TOTAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal saleTotal;
	
	/** 利润规模(万元) **/
	@Column(name = "PROFIT_SCALE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal profitScale;
	
	/** 应收款项(万元) **/
	@Column(name = "RECE_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal receBal;
	
	/** 应付款项(万元) **/
	@Column(name = "PAYAB_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal payabBal;
	
	/** 投资主体 **/
	@Column(name = "INV_TYPE", unique = false, nullable = true, length = 30)
	private String invType;
	
	/** 兼营范围 **/
	@Column(name = "PART_RANGE", unique = false, nullable = true, length = 300)
	private String partRange;
	
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
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
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	/**
     * @return CustId
     */	
	public String getId() {
		return this.id;
	}
	/**
	 * @param regCurrCd
	 */
	public void setRegCurrCd(String regCurrCd) {
		this.regCurrCd = regCurrCd == null ? null : regCurrCd.trim();
	}
	
    /**
     * @return RegCurrCd
     */	
	public String getRegCurrCd() {
		return this.regCurrCd;
	}
	
	/**
	 * @param regCapital
	 */
	public void setRegCapital(java.math.BigDecimal regCapital) {
		this.regCapital = regCapital;
	}
	
    /**
     * @return RegCapital
     */	
	public java.math.BigDecimal getRegCapital() {
		return this.regCapital;
	}
	
	/**
	 * @param netAsset
	 */
	public void setNetAsset(java.math.BigDecimal netAsset) {
		this.netAsset = netAsset;
	}
	
    /**
     * @return NetAsset
     */	
	public java.math.BigDecimal getNetAsset() {
		return this.netAsset;
	}
	
	/**
	 * @param empNum
	 */
	public void setEmpNum(java.math.BigDecimal empNum) {
		this.empNum = empNum;
	}
	
    /**
     * @return EmpNum
     */	
	public java.math.BigDecimal getEmpNum() {
		return this.empNum;
	}
	
	/**
	 * @param mainRange
	 */
	public void setMainRange(String mainRange) {
		this.mainRange = mainRange == null ? null : mainRange.trim();
	}
	
    /**
     * @return MainRange
     */	
	public String getMainRange() {
		return this.mainRange;
	}
	
	/**
	 * @param premisArea
	 */
	public void setPremisArea(java.math.BigDecimal premisArea) {
		this.premisArea = premisArea;
	}
	
    /**
     * @return PremisArea
     */	
	public java.math.BigDecimal getPremisArea() {
		return this.premisArea;
	}
	
	/**
	 * @param premisOwnership
	 */
	public void setPremisOwnership(String premisOwnership) {
		this.premisOwnership = premisOwnership == null ? null : premisOwnership.trim();
	}
	
    /**
     * @return PremisOwnership
     */	
	public String getPremisOwnership() {
		return this.premisOwnership;
	}
	
	/**
	 * @param manageStat
	 */
	public void setManageStat(String manageStat) {
		this.manageStat = manageStat == null ? null : manageStat.trim();
	}
	
    /**
     * @return ManageStat
     */	
	public String getManageStat() {
		return this.manageStat;
	}
	
	/**
	 * @param totalAsset
	 */
	public void setTotalAsset(java.math.BigDecimal totalAsset) {
		this.totalAsset = totalAsset;
	}
	
    /**
     * @return TotalAsset
     */	
	public java.math.BigDecimal getTotalAsset() {
		return this.totalAsset;
	}
	
	/**
	 * @param debtTotal
	 */
	public void setDebtTotal(java.math.BigDecimal debtTotal) {
		this.debtTotal = debtTotal;
	}
	
    /**
     * @return DebtTotal
     */	
	public java.math.BigDecimal getDebtTotal() {
		return this.debtTotal;
	}
	
	/**
	 * @param invenTotal
	 */
	public void setInvenTotal(java.math.BigDecimal invenTotal) {
		this.invenTotal = invenTotal;
	}
	
    /**
     * @return InvenTotal
     */	
	public java.math.BigDecimal getInvenTotal() {
		return this.invenTotal;
	}
	
	/**
	 * @param saleTotal
	 */
	public void setSaleTotal(java.math.BigDecimal saleTotal) {
		this.saleTotal = saleTotal;
	}
	
    /**
     * @return SaleTotal
     */	
	public java.math.BigDecimal getSaleTotal() {
		return this.saleTotal;
	}
	
	/**
	 * @param profitScale
	 */
	public void setProfitScale(java.math.BigDecimal profitScale) {
		this.profitScale = profitScale;
	}
	
    /**
     * @return ProfitScale
     */	
	public java.math.BigDecimal getProfitScale() {
		return this.profitScale;
	}
	
	/**
	 * @param receBal
	 */
	public void setReceBal(java.math.BigDecimal receBal) {
		this.receBal = receBal;
	}
	
    /**
     * @return ReceBal
     */	
	public java.math.BigDecimal getReceBal() {
		return this.receBal;
	}
	
	/**
	 * @param payabBal
	 */
	public void setPayabBal(java.math.BigDecimal payabBal) {
		this.payabBal = payabBal;
	}
	
    /**
     * @return PayabBal
     */	
	public java.math.BigDecimal getPayabBal() {
		return this.payabBal;
	}
	
	/**
	 * @param invType
	 */
	public void setInvType(String invType) {
		this.invType = invType == null ? null : invType.trim();
	}
	
    /**
     * @return InvType
     */	
	public String getInvType() {
		return this.invType;
	}
	
	/**
	 * @param partRange
	 */
	public void setPartRange(String partRange) {
		this.partRange = partRange == null ? null : partRange.trim();
	}
	
    /**
     * @return PartRange
     */	
	public String getPartRange() {
		return this.partRange;
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
        OcrmFciOrgManageInfo other = (OcrmFciOrgManageInfo) that;
        		return (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getRegCurrCd() == null ? other.getRegCurrCd() == null : this.getRegCurrCd().equals(other.getRegCurrCd()))
                                	&& (this.getMainRange() == null ? other.getMainRange() == null : this.getMainRange().equals(other.getMainRange()))
                	&& (this.getPremisOwnership() == null ? other.getPremisOwnership() == null : this.getPremisOwnership().equals(other.getPremisOwnership()))
        	&& (this.getManageStat() == null ? other.getManageStat() == null : this.getManageStat().equals(other.getManageStat()))
                                                                	&& (this.getInvType() == null ? other.getInvType() == null : this.getInvType().equals(other.getInvType()))
        	&& (this.getPartRange() == null ? other.getPartRange() == null : this.getPartRange().equals(other.getPartRange()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRegCurrCd() == null) ? 0 : getRegCurrCd().hashCode());
        result = prime * result + ((getMainRange() == null) ? 0 : getMainRange().hashCode());
        result = prime * result + ((getPremisOwnership() == null) ? 0 : getPremisOwnership().hashCode());
        result = prime * result + ((getManageStat() == null) ? 0 : getManageStat().hashCode());
        result = prime * result + ((getInvType() == null) ? 0 : getInvType().hashCode());
        result = prime * result + ((getPartRange() == null) ? 0 : getPartRange().hashCode());
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
		sb.append(", id=").append(id);
		sb.append(", regCurrCd=").append(regCurrCd);
		sb.append(", regCapital=").append(regCapital);
		sb.append(", netAsset=").append(netAsset);
		sb.append(", empNum=").append(empNum);
		sb.append(", mainRange=").append(mainRange);
		sb.append(", premisArea=").append(premisArea);
		sb.append(", premisOwnership=").append(premisOwnership);
		sb.append(", manageStat=").append(manageStat);
		sb.append(", totalAsset=").append(totalAsset);
		sb.append(", debtTotal=").append(debtTotal);
		sb.append(", invenTotal=").append(invenTotal);
		sb.append(", saleTotal=").append(saleTotal);
		sb.append(", profitScale=").append(profitScale);
		sb.append(", receBal=").append(receBal);
		sb.append(", payabBal=").append(payabBal);
		sb.append(", invType=").append(invType);
		sb.append(", partRange=").append(partRange);
        sb.append("]");
        return sb.toString();
    }
}