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
 * @类名称: OcrmFciOrgStockInfo
 * @类描述: #数据实体类
 * @功能描述: 股票信息
 * @创建人: 15104
 * @创建时间: 2019-02-27 01:48:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_ORG_STOCK_INFO")
public class OcrmFciOrgStockInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期 **/
	
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期 **/
	
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最新更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 股票代码 **/
	@Column(name = "STOCK_NO", unique = false, nullable = true, length = 32)
	private String stockNo;
	
	/** 股票名称 **/
	@Column(name = "STOCK_NAME", unique = false, nullable = true, length = 80)
	private String stockName;
	
	/** 上市日期 **/
	
	@Column(name = "IPO_DATE", unique = false, nullable = true, length = 7)
	private Date ipoDate;
	
	/** 上市地点 **/
	@Column(name = "MARKET_PLACE", unique = false, nullable = true, length = 80)
	private String marketPlace;
	
	/** 上市交易所名称 **/
	@Column(name = "EXCHANGE_NAME", unique = false, nullable = true, length = 80)
	private String exchangeName;
	
	/** 首次发行价 **/
	@Column(name = "ISSUE_PRICE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal issuePrice;
	
	/** 股票当前价 **/
	@Column(name = "CURR_PRICE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal currPrice;
	
	/** 股票评估价 **/
	@Column(name = "EST_PRICE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal estPrice;
	
	/** 当前股本总量 **/
	@Column(name = "TOTAL_STOCK_NUM", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal totalStockNum;
	
	/** 当前流通股数 **/
	@Column(name = "FLOW_STOCK_NUM", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal flowStockNum;
	
	/** 股票类型 **/
	@Column(name = "STOCK_TYPE", unique = false, nullable = true, length = 30)
	private String stockType;
	
	/** 股票状态 **/
	@Column(name = "STOCK_STATUS", unique = false, nullable = true, length = 30)
	private String stockStatus;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	/** 最近更新人机构ID **/
	@Column(name = "LAST_CHG_ORG_ID", unique = false, nullable = true, length = 20)
	private String lastChgOrgId;
	
	
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
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
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
	 * @param stockNo
	 */
	public void setStockNo(String stockNo) {
		this.stockNo = stockNo == null ? null : stockNo.trim();
	}
	
    /**
     * @return StockNo
     */	
	public String getStockNo() {
		return this.stockNo;
	}
	
	/**
	 * @param stockName
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName == null ? null : stockName.trim();
	}
	
    /**
     * @return StockName
     */	
	public String getStockName() {
		return this.stockName;
	}
	
	/**
	 * @param ipoDate
	 */
	public void setIpoDate(Date ipoDate) {
		this.ipoDate = ipoDate;
	}
	
    /**
     * @return IpoDate
     */	
	public Date getIpoDate() {
		return this.ipoDate;
	}
	
	/**
	 * @param marketPlace
	 */
	public void setMarketPlace(String marketPlace) {
		this.marketPlace = marketPlace == null ? null : marketPlace.trim();
	}
	
    /**
     * @return MarketPlace
     */	
	public String getMarketPlace() {
		return this.marketPlace;
	}
	
	/**
	 * @param exchangeName
	 */
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName == null ? null : exchangeName.trim();
	}
	
    /**
     * @return ExchangeName
     */	
	public String getExchangeName() {
		return this.exchangeName;
	}
	
	/**
	 * @param issuePrice
	 */
	public void setIssuePrice(java.math.BigDecimal issuePrice) {
		this.issuePrice = issuePrice;
	}
	
    /**
     * @return IssuePrice
     */	
	public java.math.BigDecimal getIssuePrice() {
		return this.issuePrice;
	}
	
	/**
	 * @param currPrice
	 */
	public void setCurrPrice(java.math.BigDecimal currPrice) {
		this.currPrice = currPrice;
	}
	
    /**
     * @return CurrPrice
     */	
	public java.math.BigDecimal getCurrPrice() {
		return this.currPrice;
	}
	
	/**
	 * @param estPrice
	 */
	public void setEstPrice(java.math.BigDecimal estPrice) {
		this.estPrice = estPrice;
	}
	
    /**
     * @return EstPrice
     */	
	public java.math.BigDecimal getEstPrice() {
		return this.estPrice;
	}
	
	/**
	 * @param totalStockNum
	 */
	public void setTotalStockNum(java.math.BigDecimal totalStockNum) {
		this.totalStockNum = totalStockNum;
	}
	
    /**
     * @return TotalStockNum
     */	
	public java.math.BigDecimal getTotalStockNum() {
		return this.totalStockNum;
	}
	
	/**
	 * @param flowStockNum
	 */
	public void setFlowStockNum(java.math.BigDecimal flowStockNum) {
		this.flowStockNum = flowStockNum;
	}
	
    /**
     * @return FlowStockNum
     */	
	public java.math.BigDecimal getFlowStockNum() {
		return this.flowStockNum;
	}
	
	/**
	 * @param stockType
	 */
	public void setStockType(String stockType) {
		this.stockType = stockType == null ? null : stockType.trim();
	}
	
    /**
     * @return StockType
     */	
	public String getStockType() {
		return this.stockType;
	}
	
	/**
	 * @param stockStatus
	 */
	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus == null ? null : stockStatus.trim();
	}
	
    /**
     * @return StockStatus
     */	
	public String getStockStatus() {
		return this.stockStatus;
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
	 * @param lastChgOrgId
	 */
	public void setLastChgOrgId(String lastChgOrgId) {
		this.lastChgOrgId = lastChgOrgId == null ? null : lastChgOrgId.trim();
	}
	
    /**
     * @return LastChgOrgId
     */	
	public String getLastChgOrgId() {
		return this.lastChgOrgId;
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
        OcrmFciOrgStockInfo other = (OcrmFciOrgStockInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                        	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getStockNo() == null ? other.getStockNo() == null : this.getStockNo().equals(other.getStockNo()))
        	&& (this.getStockName() == null ? other.getStockName() == null : this.getStockName().equals(other.getStockName()))
                	&& (this.getMarketPlace() == null ? other.getMarketPlace() == null : this.getMarketPlace().equals(other.getMarketPlace()))
        	&& (this.getExchangeName() == null ? other.getExchangeName() == null : this.getExchangeName().equals(other.getExchangeName()))
                                                	&& (this.getStockType() == null ? other.getStockType() == null : this.getStockType().equals(other.getStockType()))
        	&& (this.getStockStatus() == null ? other.getStockStatus() == null : this.getStockStatus().equals(other.getStockStatus()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getLastChgOrgId() == null ? other.getLastChgOrgId() == null : this.getLastChgOrgId().equals(other.getLastChgOrgId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getStockNo() == null) ? 0 : getStockNo().hashCode());
        result = prime * result + ((getStockName() == null) ? 0 : getStockName().hashCode());
        result = prime * result + ((getMarketPlace() == null) ? 0 : getMarketPlace().hashCode());
        result = prime * result + ((getExchangeName() == null) ? 0 : getExchangeName().hashCode());
        result = prime * result + ((getStockType() == null) ? 0 : getStockType().hashCode());
        result = prime * result + ((getStockStatus() == null) ? 0 : getStockStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getLastChgOrgId() == null) ? 0 : getLastChgOrgId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", stockNo=").append(stockNo);
		sb.append(", stockName=").append(stockName);
		sb.append(", ipoDate=").append(ipoDate);
		sb.append(", marketPlace=").append(marketPlace);
		sb.append(", exchangeName=").append(exchangeName);
		sb.append(", issuePrice=").append(issuePrice);
		sb.append(", currPrice=").append(currPrice);
		sb.append(", estPrice=").append(estPrice);
		sb.append(", totalStockNum=").append(totalStockNum);
		sb.append(", flowStockNum=").append(flowStockNum);
		sb.append(", stockType=").append(stockType);
		sb.append(", stockStatus=").append(stockStatus);
		sb.append(", remark=").append(remark);
		sb.append(", lastChgOrgId=").append(lastChgOrgId);
        sb.append("]");
        return sb.toString();
    }
}