package cn.com.yusys.yscrm.custmgr.domain;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_YY_TRIUMPH_LOOK_UP")
public class CrmFYyTriumphLookUp implements Serializable{

  private static final long serialVersionUID = 1492150948801412096L;

    /**
   * 数据日期
   */
  @ExportEntityMap(CnName="数据日期",EnName="dataDate")
  private String dataDate;
  /**
   * 数据更新日期
   */
  @ExportEntityMap(CnName="数据更新日期",EnName="dataUpdateDate")
  private String dataUpdateDate;

    /**
     08:存款日均余额 09:AUM余额 10:合格优惠客户数 11：贷款放款笔数 12：按揭放款笔数 13：人均按揭放款笔数 14：车位贷放款笔数 15：人均车位贷放款笔数
     16：利率、汇率挂钩手续费收入 17：人民币基金手续费收入 18：ODII手续费收入 19：境内结构性产品手续费收入)
     */
    private String triumphId;

    /**
     * 指标名称
     */
    @ExportEntityMap(CnName="指标名称",EnName="triumphName")
    private String triumphName;

    /**
     * 对象id （层级为0 对象id 为总行机构编码 层级为1,对象id为总行理财个贷主管角色编码 层级为2 对象id为分行机构编码
     层级为3 对象id为支行机构编码 层级为4 对象id为团队编码 层级为5 对象id为客户经理编码）
     */
    @ExportEntityMap(CnName="对象id",EnName="targetId")
    private String targetId;

    /**
     * 对象名称 （层级为0 对象id 为总行机构名称 层级为1,对象名称为总行理财个贷主管角色名称 层级为2 对象id为分行机构名称
     层级为3 对象id为支行机构名称 层级为4 对象id为团队名称 层级为5 对象id为客户经理名称）
     */
    @ExportEntityMap(CnName="对象名称",EnName="targetName")
    private String targetName;

    /**
     * 分配所属条线（0 总行 1 理财 2 个贷）
     */
    private String triumphLine;

    /**
     * 同比
     */
    @ExportEntityMap(CnName="同比",EnName="yearOnYear")
    private String yearOnYear;

    private String triumphLevel;
    /**
     * 环比
     */
    @ExportEntityMap(CnName="环比",EnName="ringRatio")
    private String ringRatio;

    /**
     * 完成率
     */
    @ExportEntityMap(CnName="完成率",EnName="completionRate")
    private String completionRate;

    /**
     * 余额
     */
    @ExportEntityMap(CnName="余额",EnName="balance")
    private String balance;


    public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
  }


  public String getTriumphId() {
    return triumphId;
  }

  public void setTriumphId(String triumphId) {
    this.triumphId = triumphId;
  }


  public String getTriumphName() {
    return triumphName;
  }

  public void setTriumphName(String triumphName) {
    this.triumphName = triumphName;
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


  public String getYearOnYear() {
    return yearOnYear;
  }

  public void setYearOnYear(String yearOnYear) {
    this.yearOnYear = yearOnYear;
  }


  public String getRingRatio() {
    return ringRatio;
  }

  public void setRingRatio(String ringRatio) {
    this.ringRatio = ringRatio;
  }


  public String getCompletionRate() {
    return completionRate;
  }

  public void setCompletionRate(String completionRate) {
    this.completionRate = completionRate;
  }


  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  public String getDataUpdateDate() {
    return dataUpdateDate;
  }

  public void setDataUpdateDate(String dataUpdateDate) {
    this.dataUpdateDate = dataUpdateDate;
  }
}
