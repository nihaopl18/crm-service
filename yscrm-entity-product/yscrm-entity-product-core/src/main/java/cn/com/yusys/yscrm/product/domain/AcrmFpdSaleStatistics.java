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
 * @类名称: AcrmFpdSaleStatistics
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-12 19:11:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_PD_SALE_STATISTICS")
public class AcrmFpdSaleStatistics extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 产品编号 **/
	@Id
	@Column(name = "PROD_ID")
	@Generated(GenerationType.UUID)
	private String prodId;
	
	/** 产品名称 **/
	@Column(name = "PROD_NAME", unique = false, nullable = true, length = 128)
	private String prodName;
	
	/** 持有产品客户数量 **/
	@Column(name = "PROD_NUM", unique = false, nullable = true, length = 19)
	private java.math.BigDecimal prodNum;
	
	/** 销售规模 **/
	@Column(name = "SALE_SCALE", unique = false, nullable = true, length = 30)
	private String saleScale;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
	/**
	 * @param prodId
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}
	
    /**
     * @return ProdId
     */	
	public String getProdId() {
		return this.prodId;
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
	 * @param prodNum
	 */
	public void setProdNum(java.math.BigDecimal prodNum) {
		this.prodNum = prodNum;
	}
	
    /**
     * @return ProdNum
     */	
	public java.math.BigDecimal getProdNum() {
		return this.prodNum;
	}
	
	/**
	 * @param saleScale
	 */
	public void setSaleScale(String saleScale) {
		this.saleScale = saleScale == null ? null : saleScale.trim();
	}
	
    /**
     * @return SaleScale
     */	
	public String getSaleScale() {
		return this.saleScale;
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
        AcrmFpdSaleStatistics other = (AcrmFpdSaleStatistics) that;
		return (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
        	&& (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()))
                	&& (this.getSaleScale() == null ? other.getSaleScale() == null : this.getSaleScale().equals(other.getSaleScale()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        result = prime * result + ((getSaleScale() == null) ? 0 : getSaleScale().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", prodId=").append(prodId);
		sb.append(", prodName=").append(prodName);
		sb.append(", prodNum=").append(prodNum);
		sb.append(", saleScale=").append(saleScale);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}