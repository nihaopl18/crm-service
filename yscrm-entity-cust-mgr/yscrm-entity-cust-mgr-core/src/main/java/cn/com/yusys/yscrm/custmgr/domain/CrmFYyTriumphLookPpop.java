package cn.com.yusys.yscrm.custmgr.domain;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_YY_TRIUMPH_LOOK_PPOP")
public class CrmFYyTriumphLookPpop implements Serializable{

  private static final long serialVersionUID = 1410446399358147072L;

	/**
	 * 数据日期
	 */
  private String dataDate;
    /**
     * 数据更新日期
     */
    @ExportEntityMap(CnName="数据更新日期",EnName="dataUpdateDate")
    private String dataUpdateDate;
	/**
	 * 层级(0：总行管理 1:总行理财个贷主管  2：分行 3：支行 4：团队 5：客户经理)
	 */
  private String triumphLevel;

	/**
	 * 对象id （层级为0 对象id 为总行机构编码 层级为1,对象id为总行理财个贷主管角色编码 层级为2 对象id为分行机构编码
 层级为3 对象id为支行机构编码 层级为4 对象id为团队编码 层级为5 对象id为客户经理编码）
	 */
  private String targetId;

	/**
	 * 对象名称 （层级为0 对象id 为总行机构名称 层级为1,对象名称为总行理财个贷主管角色名称 层级为2 对象id为分行机构名称
 层级为3 对象id为支行机构名称 层级为4 对象id为团队名称 层级为5 对象id为客户经理名称）
	 */
  private String targetName;

	/**
	 * 分配所属条线（0 总行 1 理财 2 个贷）
	 */
  private String triumphLine;

	/**
	 * 个人存款净收入
	 */
  private String netIncomeDeposits;

	/**
	 * 个人存款净收入占比
	 */
  private String netIncomeDepositsRatio;

	/**
	 * 零售贷款模拟净收入
	 */
  private String simulatedNetIncome;

	/**
	 * 零售贷款模拟净收入占比
	 */
  private String simulatedNetIncomeRatio;

	/**
	 * 中收模拟收入
	 */
  private String middleIncomeRevenue;

	/**
	 * 中收模拟收入占比
	 */
  private String middleIncomeRevenueRatio;


  public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }


  public String getTriumphLevel() {
    return triumphLevel;
  }

  public void setTriumphLevel(String triumphLevel) {
    this.triumphLevel = triumphLevel;
  }


  public String getTargetId() {
    return targetId;
  }

  public void setTargetId(String targetId) {
    this.targetId = targetId;
  }


  public String getTargetName() {
    return targetName;
  }

  public void setTargetName(String targetName) {
    this.targetName = targetName;
  }


  public String getTriumphLine() {
    return triumphLine;
  }

  public void setTriumphLine(String triumphLine) {
    this.triumphLine = triumphLine;
  }


  public String getNetIncomeDeposits() {
    return netIncomeDeposits;
  }

  public void setNetIncomeDeposits(String netIncomeDeposits) {
    this.netIncomeDeposits = netIncomeDeposits;
  }


  public String getNetIncomeDepositsRatio() {
    return netIncomeDepositsRatio;
  }

  public void setNetIncomeDepositsRatio(String netIncomeDepositsRatio) {
    this.netIncomeDepositsRatio = netIncomeDepositsRatio;
  }


  public String getSimulatedNetIncome() {
    return simulatedNetIncome;
  }

  public void setSimulatedNetIncome(String simulatedNetIncome) {
    this.simulatedNetIncome = simulatedNetIncome;
  }


  public String getSimulatedNetIncomeRatio() {
    return simulatedNetIncomeRatio;
  }

  public void setSimulatedNetIncomeRatio(String simulatedNetIncomeRatio) {
    this.simulatedNetIncomeRatio = simulatedNetIncomeRatio;
  }


  public String getMiddleIncomeRevenue() {
    return middleIncomeRevenue;
  }

  public void setMiddleIncomeRevenue(String middleIncomeRevenue) {
    this.middleIncomeRevenue = middleIncomeRevenue;
  }


  public String getMiddleIncomeRevenueRatio() {
    return middleIncomeRevenueRatio;
  }

  public void setMiddleIncomeRevenueRatio(String middleIncomeRevenueRatio) {
    this.middleIncomeRevenueRatio = middleIncomeRevenueRatio;
  }

    public String getDataUpdateDate() {
        return dataUpdateDate;
    }

    public void setDataUpdateDate(String dataUpdateDate) {
        this.dataUpdateDate = dataUpdateDate;
    }
}
