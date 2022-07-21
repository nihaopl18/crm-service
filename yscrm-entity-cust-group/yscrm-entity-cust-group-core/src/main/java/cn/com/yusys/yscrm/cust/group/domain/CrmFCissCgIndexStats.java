package cn.com.yusys.yscrm.cust.group.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CISS_CG_INDEX_STATS")
public class CrmFCissCgIndexStats implements Serializable{

  private static final long serialVersionUID = 1208742277334334976L;

	/**
	 * 数据日期
	 */
    @ApiModelProperty(value = "数据日期")
  private String dataDate;

	/**
	 * 客户群编号
	 */
    @ApiModelProperty(value = "客户群编号")
  private String custGroupNo;

	/**
	 * 客户数
	 */
    @ApiModelProperty(value = "客户数")
  private String custNumber;

	/**
	 * 客户数环比
	 */
    @ApiModelProperty(value = "客户数环比")
  private String custNumberQoq;

	/**
	 * 客户数同比
	 */
    @ApiModelProperty(value = "客户数同比")
  private String custNumberYoy;

	/**
	 * 客群AUM年日均
	 */
    @ApiModelProperty(value = "客群AUM年日均")
  private String cgAumYearAvgBalance;

	/**
	 * 客群AUM年日均环比
	 */
    @ApiModelProperty(value = "客群AUM年日均环比")
  private String cgAumYearAvgBalanceQoq;

	/**
	 * 客群AUM年日均同比
	 */
    @ApiModelProperty(value = "客群AUM年日均同比")
  private String cgAumYearAvgBalanceYoy;

	/**
	 * 客户存款余额
	 */
    @ApiModelProperty(value = "客户存款余额")
  private String cgDepositBalance;

	/**
	 * 客户存款余额环比
	 */
    @ApiModelProperty(value = "客户存款余额环比")
  private String cgDepositBalanceQoq;

	/**
	 * 客户存款余额同比
	 */
    @ApiModelProperty(value = "客户存款余额同比")
  private String cgDepositBalanceYoy;

	/**
	 * 客群贷款余额
	 */
    @ApiModelProperty(value = "客群贷款余额")
  private String cgLoanBalance;

	/**
	 * 客群贷款余额环比
	 */
    @ApiModelProperty(value = "客群贷款余额环比")
  private String cgLoanBalanceQoq;

	/**
	 * 客群贷款余额同比
	 */
    @ApiModelProperty(value = "客群贷款余额同比")
  private String cgLoanBalanceYoy;

	/**
	 * 一般客户
	 */
    @ApiModelProperty(value = "一般客户")
  private String custGrade1Number;

	/**
	 * 有效客户
	 */
    @ApiModelProperty(value = "有效客户")
  private String custGrade2Number;

	/**
	 * 优惠客户
	 */
    @ApiModelProperty(value = "优惠客户")
  private String custGrade3Number;

	/**
	 * 显卓客户
	 */
    @ApiModelProperty(value = "显卓客户")
  private String custGrade4Number;

	/**
	 * 私行客户
	 */
    @ApiModelProperty(value = "私行客户")
  private String custGrade5Number;

	/**
	 * 显卓钻石客户
	 */
    @ApiModelProperty(value = "显卓钻石客户")
  private String custGrade6Number;

	/**
	 * 客群信托余额
	 */
    @ApiModelProperty(value = "客群信托余额")
  private String cgTrustBalanceRmb;

	/**
	 * 客群结构化理财余额
	 */
    @ApiModelProperty(value = "客群结构化理财余额")
  private String cgStrustFinBalanceRmb;

	/**
	 * 客群QDII余额
	 */
    @ApiModelProperty(value = "客群QDII余额")
  private String cgQdiiBalanceRmb;

	/**
	 * 客群代收付余额
	 */
    @ApiModelProperty(value = "客群代收付余额")
  private String cgCollectPayBalance;

	/**
	 * 客群人民币基金余额
	 */
    @ApiModelProperty(value = "客群人民币基金余额")
  private String cgRmbFundBalance;

	/**
	 * 客群活期存款余额
	 */
    @ApiModelProperty(value = "客群活期存款余额")
  private String cgDemandDepositBalance;

	/**
	 * 客群定期存款余额
	 */
    @ApiModelProperty(value = "客群定期存款余额")
  private String cgTimeDepositBalance;

	/**
	 * 客群保险规模
	 */
    @ApiModelProperty(value = "客群保险规模")
  private String cgInsurranceBalanceRmb;

	/**
	 * 客群AUM余额
	 */
    @ApiModelProperty(value = "客群AUM余额")
  private String cgAumBalance;

	/**
	 * 客群中间业务收入金额
	 */
    @ApiModelProperty(value = "客群中间业务收入金额")
  private String cgMidIncomeAmt;

	/**
	 * 客群理财购买金额
	 */
    @ApiModelProperty(value = "客群理财购买金额")
  private String cgBuyFinAmt;

	/**
	 * 客均AUM年日均
	 */
    @ApiModelProperty(value = "客均AUM年日均")
  private String cgAvgAumYearAvgBalance;

	/**
	 * 客均AUM年日均环比
	 */
    @ApiModelProperty(value = "客均AUM年日均环比")
  private String cgAvgAumYearAvgBalanceQoq;

	/**
	 * 客均AUM年日均同比
	 */
    @ApiModelProperty(value = "客均AUM年日均同比")
  private String cgAvgAumYearAvgBalanceYoy;

	/**
	 * 客均存款余额
	 */
    @ApiModelProperty(value = "客均存款余额")
  private String cgAvgDepositBalance;

	/**
	 * 客均存款余额环比
	 */
    @ApiModelProperty(value = "客均存款余额环比")
  private String cgAvgDepositBalanceQoq;

	/**
	 * 客均存款余额同比
	 */
    @ApiModelProperty(value = "客均存款余额同比")
  private String cgAvgDepositBalanceYoy;

	/**
	 * 客均贷款余额
	 */
    @ApiModelProperty(value = "客均贷款余额")
  private String cgAvgLoanBalance;

	/**
	 * 客均贷款余额环比
	 */
    @ApiModelProperty(value = "客均贷款余额环比")
  private String cgAvgLoanBalanceQoq;

	/**
	 * 客均贷款余额同比
	 */
    @ApiModelProperty(value = "客均贷款余额同比")
  private String cgAvgLoanBalanceYoy;

	/**
	 * 客均AUM余额
	 */
    @ApiModelProperty(value = "客均AUM余额")
  private String cgAvgAumBalance;

	/**
	 * 客均中收金额
	 */
    @ApiModelProperty(value = "客均中收金额")
  private String cgAvgMidIncomeAmt;

	/**
	 * 客均理财产品购买金额
	 */
    @ApiModelProperty(value = "客均理财产品购买金额")
  private String cgAvgBuyFinAmt;

	/**
	 * 客均综合价值
	 */
    @ApiModelProperty(value = "客均综合价值")
  private String cgAvgOverallValue;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }


  public String getCustGroupNo() {
    return custGroupNo;
  }

  public void setCustGroupNo(String custGroupNo) {
    this.custGroupNo = custGroupNo;
  }


  public String getCustNumber() {
    return custNumber;
  }

  public void setCustNumber(String custNumber) {
    this.custNumber = custNumber;
  }


  public String getCustNumberQoq() {
    return custNumberQoq;
  }

  public void setCustNumberQoq(String custNumberQoq) {
    this.custNumberQoq = custNumberQoq;
  }


  public String getCustNumberYoy() {
    return custNumberYoy;
  }

  public void setCustNumberYoy(String custNumberYoy) {
    this.custNumberYoy = custNumberYoy;
  }


  public String getCgAumYearAvgBalance() {
    return cgAumYearAvgBalance;
  }

  public void setCgAumYearAvgBalance(String cgAumYearAvgBalance) {
    this.cgAumYearAvgBalance = cgAumYearAvgBalance;
  }


  public String getCgAumYearAvgBalanceQoq() {
    return cgAumYearAvgBalanceQoq;
  }

  public void setCgAumYearAvgBalanceQoq(String cgAumYearAvgBalanceQoq) {
    this.cgAumYearAvgBalanceQoq = cgAumYearAvgBalanceQoq;
  }


  public String getCgAumYearAvgBalanceYoy() {
    return cgAumYearAvgBalanceYoy;
  }

  public void setCgAumYearAvgBalanceYoy(String cgAumYearAvgBalanceYoy) {
    this.cgAumYearAvgBalanceYoy = cgAumYearAvgBalanceYoy;
  }


  public String getCgDepositBalance() {
    return cgDepositBalance;
  }

  public void setCgDepositBalance(String cgDepositBalance) {
    this.cgDepositBalance = cgDepositBalance;
  }


  public String getCgDepositBalanceQoq() {
    return cgDepositBalanceQoq;
  }

  public void setCgDepositBalanceQoq(String cgDepositBalanceQoq) {
    this.cgDepositBalanceQoq = cgDepositBalanceQoq;
  }


  public String getCgDepositBalanceYoy() {
    return cgDepositBalanceYoy;
  }

  public void setCgDepositBalanceYoy(String cgDepositBalanceYoy) {
    this.cgDepositBalanceYoy = cgDepositBalanceYoy;
  }


  public String getCgLoanBalance() {
    return cgLoanBalance;
  }

  public void setCgLoanBalance(String cgLoanBalance) {
    this.cgLoanBalance = cgLoanBalance;
  }


  public String getCgLoanBalanceQoq() {
    return cgLoanBalanceQoq;
  }

  public void setCgLoanBalanceQoq(String cgLoanBalanceQoq) {
    this.cgLoanBalanceQoq = cgLoanBalanceQoq;
  }


  public String getCgLoanBalanceYoy() {
    return cgLoanBalanceYoy;
  }

  public void setCgLoanBalanceYoy(String cgLoanBalanceYoy) {
    this.cgLoanBalanceYoy = cgLoanBalanceYoy;
  }


  public String getCustGrade1Number() {
    return custGrade1Number;
  }

  public void setCustGrade1Number(String custGrade1Number) {
    this.custGrade1Number = custGrade1Number;
  }


  public String getCustGrade2Number() {
    return custGrade2Number;
  }

  public void setCustGrade2Number(String custGrade2Number) {
    this.custGrade2Number = custGrade2Number;
  }


  public String getCustGrade3Number() {
    return custGrade3Number;
  }

  public void setCustGrade3Number(String custGrade3Number) {
    this.custGrade3Number = custGrade3Number;
  }


  public String getCustGrade4Number() {
    return custGrade4Number;
  }

  public void setCustGrade4Number(String custGrade4Number) {
    this.custGrade4Number = custGrade4Number;
  }


  public String getCustGrade5Number() {
    return custGrade5Number;
  }

  public void setCustGrade5Number(String custGrade5Number) {
    this.custGrade5Number = custGrade5Number;
  }


  public String getCustGrade6Number() {
    return custGrade6Number;
  }

  public void setCustGrade6Number(String custGrade6Number) {
    this.custGrade6Number = custGrade6Number;
  }


  public String getCgTrustBalanceRmb() {
    return cgTrustBalanceRmb;
  }

  public void setCgTrustBalanceRmb(String cgTrustBalanceRmb) {
    this.cgTrustBalanceRmb = cgTrustBalanceRmb;
  }


  public String getCgStrustFinBalanceRmb() {
    return cgStrustFinBalanceRmb;
  }

  public void setCgStrustFinBalanceRmb(String cgStrustFinBalanceRmb) {
    this.cgStrustFinBalanceRmb = cgStrustFinBalanceRmb;
  }


  public String getCgQdiiBalanceRmb() {
    return cgQdiiBalanceRmb;
  }

  public void setCgQdiiBalanceRmb(String cgQdiiBalanceRmb) {
    this.cgQdiiBalanceRmb = cgQdiiBalanceRmb;
  }


  public String getCgCollectPayBalance() {
    return cgCollectPayBalance;
  }

  public void setCgCollectPayBalance(String cgCollectPayBalance) {
    this.cgCollectPayBalance = cgCollectPayBalance;
  }


  public String getCgRmbFundBalance() {
    return cgRmbFundBalance;
  }

  public void setCgRmbFundBalance(String cgRmbFundBalance) {
    this.cgRmbFundBalance = cgRmbFundBalance;
  }


  public String getCgDemandDepositBalance() {
    return cgDemandDepositBalance;
  }

  public void setCgDemandDepositBalance(String cgDemandDepositBalance) {
    this.cgDemandDepositBalance = cgDemandDepositBalance;
  }


  public String getCgTimeDepositBalance() {
    return cgTimeDepositBalance;
  }

  public void setCgTimeDepositBalance(String cgTimeDepositBalance) {
    this.cgTimeDepositBalance = cgTimeDepositBalance;
  }


  public String getCgInsurranceBalanceRmb() {
    return cgInsurranceBalanceRmb;
  }

  public void setCgInsurranceBalanceRmb(String cgInsurranceBalanceRmb) {
    this.cgInsurranceBalanceRmb = cgInsurranceBalanceRmb;
  }


  public String getCgAumBalance() {
    return cgAumBalance;
  }

  public void setCgAumBalance(String cgAumBalance) {
    this.cgAumBalance = cgAumBalance;
  }


  public String getCgMidIncomeAmt() {
    return cgMidIncomeAmt;
  }

  public void setCgMidIncomeAmt(String cgMidIncomeAmt) {
    this.cgMidIncomeAmt = cgMidIncomeAmt;
  }


  public String getCgBuyFinAmt() {
    return cgBuyFinAmt;
  }

  public void setCgBuyFinAmt(String cgBuyFinAmt) {
    this.cgBuyFinAmt = cgBuyFinAmt;
  }


  public String getCgAvgAumYearAvgBalance() {
    return cgAvgAumYearAvgBalance;
  }

  public void setCgAvgAumYearAvgBalance(String cgAvgAumYearAvgBalance) {
    this.cgAvgAumYearAvgBalance = cgAvgAumYearAvgBalance;
  }


  public String getCgAvgAumYearAvgBalanceQoq() {
    return cgAvgAumYearAvgBalanceQoq;
  }

  public void setCgAvgAumYearAvgBalanceQoq(String cgAvgAumYearAvgBalanceQoq) {
    this.cgAvgAumYearAvgBalanceQoq = cgAvgAumYearAvgBalanceQoq;
  }


  public String getCgAvgAumYearAvgBalanceYoy() {
    return cgAvgAumYearAvgBalanceYoy;
  }

  public void setCgAvgAumYearAvgBalanceYoy(String cgAvgAumYearAvgBalanceYoy) {
    this.cgAvgAumYearAvgBalanceYoy = cgAvgAumYearAvgBalanceYoy;
  }


  public String getCgAvgDepositBalance() {
    return cgAvgDepositBalance;
  }

  public void setCgAvgDepositBalance(String cgAvgDepositBalance) {
    this.cgAvgDepositBalance = cgAvgDepositBalance;
  }


  public String getCgAvgDepositBalanceQoq() {
    return cgAvgDepositBalanceQoq;
  }

  public void setCgAvgDepositBalanceQoq(String cgAvgDepositBalanceQoq) {
    this.cgAvgDepositBalanceQoq = cgAvgDepositBalanceQoq;
  }


  public String getCgAvgDepositBalanceYoy() {
    return cgAvgDepositBalanceYoy;
  }

  public void setCgAvgDepositBalanceYoy(String cgAvgDepositBalanceYoy) {
    this.cgAvgDepositBalanceYoy = cgAvgDepositBalanceYoy;
  }


  public String getCgAvgLoanBalance() {
    return cgAvgLoanBalance;
  }

  public void setCgAvgLoanBalance(String cgAvgLoanBalance) {
    this.cgAvgLoanBalance = cgAvgLoanBalance;
  }


  public String getCgAvgLoanBalanceQoq() {
    return cgAvgLoanBalanceQoq;
  }

  public void setCgAvgLoanBalanceQoq(String cgAvgLoanBalanceQoq) {
    this.cgAvgLoanBalanceQoq = cgAvgLoanBalanceQoq;
  }


  public String getCgAvgLoanBalanceYoy() {
    return cgAvgLoanBalanceYoy;
  }

  public void setCgAvgLoanBalanceYoy(String cgAvgLoanBalanceYoy) {
    this.cgAvgLoanBalanceYoy = cgAvgLoanBalanceYoy;
  }


  public String getCgAvgAumBalance() {
    return cgAvgAumBalance;
  }

  public void setCgAvgAumBalance(String cgAvgAumBalance) {
    this.cgAvgAumBalance = cgAvgAumBalance;
  }


  public String getCgAvgMidIncomeAmt() {
    return cgAvgMidIncomeAmt;
  }

  public void setCgAvgMidIncomeAmt(String cgAvgMidIncomeAmt) {
    this.cgAvgMidIncomeAmt = cgAvgMidIncomeAmt;
  }


  public String getCgAvgBuyFinAmt() {
    return cgAvgBuyFinAmt;
  }

  public void setCgAvgBuyFinAmt(String cgAvgBuyFinAmt) {
    this.cgAvgBuyFinAmt = cgAvgBuyFinAmt;
  }


  public String getCgAvgOverallValue() {
    return cgAvgOverallValue;
  }

  public void setCgAvgOverallValue(String cgAvgOverallValue) {
    this.cgAvgOverallValue = cgAvgOverallValue;
  }

}
