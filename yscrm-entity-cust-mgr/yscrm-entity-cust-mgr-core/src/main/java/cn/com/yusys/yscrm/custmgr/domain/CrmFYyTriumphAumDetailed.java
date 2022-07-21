package cn.com.yusys.yscrm.custmgr.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_YY_TRIUMPH_AUM_DETAILED")
public class CrmFYyTriumphAumDetailed implements Serializable{

  private static final long serialVersionUID = 1047831903484649216L;

	/**
	 * 数据日期
	 */
    @ExportEntityMap(CnName="数据日期",EnName="dataDate")
    private String dataDate;

	/**
	 * 客户经理编号
	 */
    @ExportEntityMap(CnName="客户经理编号",EnName="mgrId")
    private String mgrId;

	/**
	 * 客户经理名称
	 */
    @ExportEntityMap(CnName="客户经理名称",EnName="mgrName")
    private String mgrName;

	/**
	 * 客户号
	 */
    @ExportEntityMap(CnName="客户号",EnName="custId")
    private String custId;

	/**
	 * 客户名称
	 */
    @ExportEntityMap(CnName="客户名称",EnName="custName")
    private String custName;


	/**
	 * 理财aum余额
	 */
    @ExportEntityMap(CnName="理财aum余额",EnName="financialAum")
    private String financialAum;

	/**
	 * 理财aum余额净增
	 */
    @ExportEntityMap(CnName="理财aum余额净增",EnName="financialAumNg")
    private String financialAumNg;

	/**
	 * 保险aum余额
	 */
    @ExportEntityMap(CnName="保险aum余额",EnName="insureAum")
    private String insureAum;

	/**
	 * 保险aum余额净增
	 */
    @ExportEntityMap(CnName="保险aum余额净增",EnName="insureAumNg")
    private String insureAumNg;

	/**
	 * 存款aum余额
	 */
    @ExportEntityMap(CnName="存款aum余额",EnName="depositAum")
    private String depositAum;

	/**
	 * 存款aum余额净增
	 */
    @ExportEntityMap(CnName="存款aum余额净增",EnName="depositAumNg")
    private String depositAumNg;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }


  public String getMgrId() {
    return mgrId;
  }

  public void setMgrId(String mgrId) {
    this.mgrId = mgrId;
  }


  public String getMgrName() {
    return mgrName;
  }

  public void setMgrName(String mgrName) {
    this.mgrName = mgrName;
  }


  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }


  public String getCustName() {
    return custName;
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getFinancialAum() {
    return financialAum;
  }

  public void setFinancialAum(String financialAum) {
    this.financialAum = financialAum;
  }


  public String getFinancialAumNg() {
    return financialAumNg;
  }

  public void setFinancialAumNg(String financialAumNg) {
    this.financialAumNg = financialAumNg;
  }


  public String getInsureAum() {
    return insureAum;
  }

  public void setInsureAum(String insureAum) {
    this.insureAum = insureAum;
  }


  public String getInsureAumNg() {
    return insureAumNg;
  }

  public void setInsureAumNg(String insureAumNg) {
    this.insureAumNg = insureAumNg;
  }


  public String getDepositAum() {
    return depositAum;
  }

  public void setDepositAum(String depositAum) {
    this.depositAum = depositAum;
  }


  public String getDepositAumNg() {
    return depositAumNg;
  }

  public void setDepositAumNg(String depositAumNg) {
    this.depositAumNg = depositAumNg;
  }

}
