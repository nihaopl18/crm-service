package cn.com.yusys.yscrm.cust.group.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;

;

@Entity
public class CrmFCgPreparationVO implements Serializable{

  private static final long serialVersionUID = 1350382040939802624L;

	/**
	 * 数据日期
	 */
    @ApiModelProperty(value = "数据日期")
    private String dataDate;


	/**
	 * 客户号
	 */
    @ApiModelProperty(value = "客户号")
    @ExportEntityMap(CnName="客户号",EnName="custId")
    private String custId;

	/**
	 * 客户中文姓名
	 */
    @ApiModelProperty(value = "客户中文姓名")
    @ExportEntityMap(CnName="客户中文姓名",EnName="custName")
    private String custName;

	/**
	 * 客户英文姓名
	 */
    @ApiModelProperty(value = "客户英文姓名")
    @ExportEntityMap(CnName="客户英文姓名",EnName="custEngName")
    private String custEngName;

	/**
	 * NDS号
	 */
    @ApiModelProperty(value = "NDS号")
    @ExportEntityMap(CnName="NDS号",EnName="ndsCustNo")
    private String ndsCustNo;

	/**
	 * 地区
	 */
    @ApiModelProperty(value = "地区")
    @ExportEntityMap(CnName="地区",EnName="nationality")
    private String nationality;

	/**
	 * AUM余额
	 */
    @ApiModelProperty(value = "AUM余额")
    @ExportEntityMap(CnName="AUM余额",EnName="aumBalance")
    private String aumBalance;

	/**
	 * AUM月日均
	 */
    @ApiModelProperty(value = "AUM月日均")
    @ExportEntityMap(CnName="AUM月日均",EnName="aumBalanceAvgRmb")
    private String aumBalanceAvgRmb;

	/**
	 * 非汇理财余额
	 */
    @ApiModelProperty(value = "非汇理财余额")
    @ExportEntityMap(CnName="非汇理财余额",EnName="nonExchangeFinBalance")
    private String nonExchangeFinBalance;

	/**
	 * 汇率理财余额
	 */
    @ApiModelProperty(value = "汇率理财余额")
    @ExportEntityMap(CnName="汇率理财余额",EnName="exchangeFinBalance")
    private String exchangeFinBalance;

	/**
	 * 信托余额
	 */
    @ApiModelProperty(value = "信托余额")
    @ExportEntityMap(CnName="信托余额",EnName="trustBalanceRmb")
    private String trustBalanceRmb;

	/**
	 * 人民币基金余额
	 */
    @ApiModelProperty(value = "人民币基金余额")
    @ExportEntityMap(CnName="人民币基金余额",EnName="rmbFundBalance")
    private String rmbFundBalance;

	/**
	 * QDII净值余额
	 */
    @ApiModelProperty(value = "QDII净值余额")
    @ExportEntityMap(CnName="QDII净值余额",EnName="qdiiBalanceRmb")
    private String qdiiBalanceRmb;

	/**
	 * 资管余额
	 */
    @ApiModelProperty(value = "资管余额")
    @ExportEntityMap(CnName="资管余额",EnName="assestManageBalance")
    private String assestManageBalance;

	/**
	 * 保险余额
	 */
    @ApiModelProperty(value = "保险余额")
    @ExportEntityMap(CnName="保险余额",EnName="insurranceBalance")
    private String insurranceBalance;

	/**
	 * 存款余额
	 */
    @ApiModelProperty(value = "存款余额")
    @ExportEntityMap(CnName="存款余额",EnName="depositBalanceRmb")
    private String depositBalanceRmb;



    /**
     * 主办机构
     */
    @ApiModelProperty(value = "主办机构")
    @ExportEntityMap(CnName="主办机构",EnName="belongBrch")
    private String belongBrch;

    /**
     * 主办分行
     */
    @ApiModelProperty(value = "主办分行")
    @ExportEntityMap(CnName="主办分行",EnName="belongBranch")
    private String belongBranch;

    @ApiModelProperty(value = "最新接触时间")
    @ExportEntityMap(CnName="最新接触时间",EnName="contactDate")
    private String contactDate;

    @ApiModelProperty(value = "理财客户经理")
    @ExportEntityMap(CnName="理财客户经理",EnName="mgrNameOne")
    private String mgrNameOne;
    @ApiModelProperty(value = "个贷客户经理")
    @ExportEntityMap(CnName="个贷客户经理",EnName="mgrNameTwo")
    private String mgrNameTwo;


    public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
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


  public String getCustEngName() {
    return custEngName;
  }

  public void setCustEngName(String custEngName) {
    this.custEngName = custEngName;
  }


  public String getNdsCustNo() {
    return ndsCustNo;
  }

  public void setNdsCustNo(String ndsCustNo) {
    this.ndsCustNo = ndsCustNo;
  }


  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }


  public String getAumBalance() {
    return aumBalance;
  }

  public void setAumBalance(String aumBalance) {
    this.aumBalance = aumBalance;
  }


  public String getAumBalanceAvgRmb() {
    return aumBalanceAvgRmb;
  }

  public void setAumBalanceAvgRmb(String aumBalanceAvgRmb) {
    this.aumBalanceAvgRmb = aumBalanceAvgRmb;
  }


  public String getNonExchangeFinBalance() {
    return nonExchangeFinBalance;
  }

  public void setNonExchangeFinBalance(String nonExchangeFinBalance) {
    this.nonExchangeFinBalance = nonExchangeFinBalance;
  }


  public String getExchangeFinBalance() {
    return exchangeFinBalance;
  }

  public void setExchangeFinBalance(String exchangeFinBalance) {
    this.exchangeFinBalance = exchangeFinBalance;
  }


  public String getTrustBalanceRmb() {
    return trustBalanceRmb;
  }

  public void setTrustBalanceRmb(String trustBalanceRmb) {
    this.trustBalanceRmb = trustBalanceRmb;
  }


  public String getRmbFundBalance() {
    return rmbFundBalance;
  }

  public void setRmbFundBalance(String rmbFundBalance) {
    this.rmbFundBalance = rmbFundBalance;
  }


  public String getQdiiBalanceRmb() {
    return qdiiBalanceRmb;
  }

  public void setQdiiBalanceRmb(String qdiiBalanceRmb) {
    this.qdiiBalanceRmb = qdiiBalanceRmb;
  }


  public String getAssestManageBalance() {
    return assestManageBalance;
  }

  public void setAssestManageBalance(String assestManageBalance) {
    this.assestManageBalance = assestManageBalance;
  }


  public String getInsurranceBalance() {
    return insurranceBalance;
  }

  public void setInsurranceBalance(String insurranceBalance) {
    this.insurranceBalance = insurranceBalance;
  }


  public String getDepositBalanceRmb() {
    return depositBalanceRmb;
  }

  public void setDepositBalanceRmb(String depositBalanceRmb) {
    this.depositBalanceRmb = depositBalanceRmb;
  }

    public String getBelongBrch() {
        return belongBrch;
    }

    public void setBelongBrch(String belongBrch) {
        this.belongBrch = belongBrch;
    }

    public String getBelongBranch() {
        return belongBranch;
    }

    public void setBelongBranch(String belongBranch) {
        this.belongBranch = belongBranch;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getMgrNameOne() {
        return mgrNameOne;
    }

    public void setMgrNameOne(String mgrNameOne) {
        this.mgrNameOne = mgrNameOne;
    }

    public String getMgrNameTwo() {
        return mgrNameTwo;
    }

    public void setMgrNameTwo(String mgrNameTwo) {
        this.mgrNameTwo = mgrNameTwo;
    }
}
