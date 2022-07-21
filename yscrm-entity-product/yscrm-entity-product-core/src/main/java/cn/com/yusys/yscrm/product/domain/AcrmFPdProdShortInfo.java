package cn.com.yusys.yscrm.product.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: AcrmFPdProdShortInfo
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2022-02-16 10:21:55
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_PD_PROD_SHORT_INFO")
public class AcrmFPdProdShortInfo extends BaseDomain implements Serializable {
  private static final long serialVersionUID = 1L;

  /** 数据日期 **/
  @Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
  private String dataDate;

  /** 产品代码 **/
  @Column(name = "PROD_COED", unique = false, nullable = true, length = 8)
  private String prodCode;

  /** 源产品代码 **/
  @Column(name = "SRC_PROD_CODE", unique = false, nullable = true, length = 8)
  private String srcProdCode;

  /** 产品名称 **/
  @Column(name = "PROD_NAME", unique = false, nullable = true, length = 8)
  private String prodName;

  /** 风险等级 **/
  @Column(name = "RISK_LEVEL", unique = false, nullable = true, length = 8)
  private String riskLevel;

  /** 产品状态 **/
  @Column(name = "PROD_STATUS", unique = false, nullable = true, length = 8)
  private String prodStatus;

  /** 认购开始日期 **/
  @Column(name = "SUBSCRIBE_START_DATE", unique = false, nullable = true, length = 7)
  private Date subscribeStartDate;

  /** 认购结束日期 **/
  @Column(name = "SUBSCRIBE_END_DATE", unique = false, nullable = true, length = 7)
  private Date subscribeEndDate;

  /** 期限 **/
  @Column(name = "TERM", unique = false, nullable = true, length = 10)
  private String term;

  /** 利率 **/
  @Column(name = "RATE", unique = false, nullable = true, length = 26)
  private String rate;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }


  public String getProdCode() {
    return prodCode;
  }

  public void setProdCode(String prodCode) {
    this.prodCode = prodCode;
  }


  public String getSrcProdCode() {
    return srcProdCode;
  }

  public void setSrcProdCode(String srcProdCode) {
    this.srcProdCode = srcProdCode;
  }


  public String getProdName() {
    return prodName;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName;
  }


  public String getRiskLevel() {
    return riskLevel;
  }

  public void setRiskLevel(String riskLevel) {
    this.riskLevel = riskLevel;
  }


  public String getProdStatus() {
    return prodStatus;
  }

  public void setProdStatus(String prodStatus) {
    this.prodStatus = prodStatus;
  }


  public Date getSubscribeStartDate() {
    return subscribeStartDate;
  }

  public void setSubscribeStartDate(java.sql.Date subscribeStartDate) {
    this.subscribeStartDate = subscribeStartDate;
  }


  public Date getSubscribeEndDate() {
    return subscribeEndDate;
  }

  public void setSubscribeEndDate(java.sql.Date subscribeEndDate) {
    this.subscribeEndDate = subscribeEndDate;
  }


  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }


  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

}
