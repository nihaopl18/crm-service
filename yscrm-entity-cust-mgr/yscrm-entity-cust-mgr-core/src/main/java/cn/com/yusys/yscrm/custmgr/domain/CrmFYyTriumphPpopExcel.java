package cn.com.yusys.yscrm.custmgr.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_YY_TRIUMPH_PPOP_EXCEL")
public class CrmFYyTriumphPpopExcel implements Serializable{

  private static final long serialVersionUID = 1674357200919094784L;

	/**
	 * id
	 */
  private String seqno;

	/**
	 * 分行
	 */
  private String branch;

	/**
	 * 分行编码
	 */
  private String branchCode;

	/**
	 * 客户经理id
	 */
  private String customerId;

	/**
	 * 客户经理名称
	 */
  private String customerName;


	/**
	 * 职级
	 */
  private String customerRank;

	/**
	 * 岗位
	 */
  private String customerPost;

	/**
	 * 个人存款净收入
	 */
  private String netIncomeDeposits;

	/**
	 * 模拟净收入(含抵押贷款）
	 */
  private String simulatedNetIncome;

	/**
	 * 中收模拟合计
	 */
  private String middleIncomeRevenue;



	/**
	 * 月份
	 */
  private String ppopMonth;

	/**
	 * 创建人
	 */
  private String createUser;

	/**
	 * 创建日期
	 */
  private java.util.Date createDate;

    /**
     * 流水号
     */
    @ApiModelProperty(value = "流水号")
    private String busNo;

  public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }


  public String getBranchCode() {
    return branchCode;
  }

  public void setBranchCode(String branchCode) {
    this.branchCode = branchCode;
  }


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerRank() {
    return customerRank;
  }

  public void setCustomerRank(String customerRank) {
    this.customerRank = customerRank;
  }


  public String getCustomerPost() {
    return customerPost;
  }

  public void setCustomerPost(String customerPost) {
    this.customerPost = customerPost;
  }


  public String getNetIncomeDeposits() {
    return netIncomeDeposits;
  }

  public void setNetIncomeDeposits(String netIncomeDeposits) {
    this.netIncomeDeposits = netIncomeDeposits;
  }


  public String getSimulatedNetIncome() {
    return simulatedNetIncome;
  }

  public void setSimulatedNetIncome(String simulatedNetIncome) {
    this.simulatedNetIncome = simulatedNetIncome;
  }


  public String getMiddleIncomeRevenue() {
    return middleIncomeRevenue;
  }

  public void setMiddleIncomeRevenue(String middleIncomeRevenue) {
    this.middleIncomeRevenue = middleIncomeRevenue;
  }


  public String getPpopMonth() {
    return ppopMonth;
  }

  public void setPpopMonth(String ppopMonth) {
    this.ppopMonth = ppopMonth;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.util.Date createDate) {
    this.createDate = createDate;
  }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }
}
