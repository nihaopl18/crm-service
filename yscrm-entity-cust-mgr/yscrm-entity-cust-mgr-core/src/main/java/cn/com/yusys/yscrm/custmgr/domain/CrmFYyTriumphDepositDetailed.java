package cn.com.yusys.yscrm.custmgr.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_YY_TRIUMPH_DEPOSIT_DETAILED")
public class CrmFYyTriumphDepositDetailed implements Serializable{

  private static final long serialVersionUID = 1198707206642819328L;

    /**
     * 数据日期
     */
    @ExportEntityMap(CnName="数据日期",EnName="dataDate")
    private String dataDate;

    /**
     * 对象编码
     */
    @ExportEntityMap(CnName="对象编码",EnName="targetId")
    private String targetId;

    /**
     * 对象名称
     */
    @ExportEntityMap(CnName="对象名称",EnName="targetName")
    private String targetName;

    /**
     * 明细层级（1客户经理 2客户）
     */
    private String detailedLevel;

    /**
     * 上级编码(客户层级填客户经理码值 客户经理层级可空)
     */
    private String detailedUpId;

    /**
     * 上级名称
     */
    private String detailedUpName;

    /**
     * 汇率存款年日均
     */
    @ExportEntityMap(CnName="汇率存款年日均",EnName="exchangeRateDeposit")
    private String exchangeRateDeposit;

    /**
     * 汇率存款年日均净增
     */
    @ExportEntityMap(CnName="汇率存款年日均净增",EnName="exchangeRateDepositNg")
    private String exchangeRateDepositNg;

    /**
     * 非汇存款年日均
     */
    @ExportEntityMap(CnName="非汇存款年日均",EnName="nonExchangeDeposit")
    private String nonExchangeDeposit;

    /**
     * 非汇存款年日均净增
     */
    @ExportEntityMap(CnName="非汇存款年日均净增",EnName="nonExchangeDepositNg")
    private String nonExchangeDepositNg;

    /**
     * 一般存款当年日均
     */
    @ExportEntityMap(CnName="一般存款当年日均",EnName="commonlyDeposit")
    private String commonlyDeposit;

    /**
     * 一般存款当年日均净增
     */
    @ExportEntityMap(CnName="一般存款当年日均净增",EnName="commonlyDepositNg")
    private String commonlyDepositNg;



    public String getDataDate() {
    return dataDate;
  }

  public void setDataDate(String dataDate) {
    this.dataDate = dataDate;
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


  public String getDetailedLevel() {
    return detailedLevel;
  }

  public void setDetailedLevel(String detailedLevel) {
    this.detailedLevel = detailedLevel;
  }


  public String getDetailedUpId() {
    return detailedUpId;
  }

  public void setDetailedUpId(String detailedUpId) {
    this.detailedUpId = detailedUpId;
  }


  public String getDetailedUpName() {
    return detailedUpName;
  }

  public void setDetailedUpName(String detailedUpName) {
    this.detailedUpName = detailedUpName;
  }


  public String getExchangeRateDeposit() {
    return exchangeRateDeposit;
  }

  public void setExchangeRateDeposit(String exchangeRateDeposit) {
    this.exchangeRateDeposit = exchangeRateDeposit;
  }


  public String getExchangeRateDepositNg() {
    return exchangeRateDepositNg;
  }

  public void setExchangeRateDepositNg(String exchangeRateDepositNg) {
    this.exchangeRateDepositNg = exchangeRateDepositNg;
  }


  public String getNonExchangeDeposit() {
    return nonExchangeDeposit;
  }

  public void setNonExchangeDeposit(String nonExchangeDeposit) {
    this.nonExchangeDeposit = nonExchangeDeposit;
  }


  public String getNonExchangeDepositNg() {
    return nonExchangeDepositNg;
  }

  public void setNonExchangeDepositNg(String nonExchangeDepositNg) {
    this.nonExchangeDepositNg = nonExchangeDepositNg;
  }


  public String getCommonlyDeposit() {
    return commonlyDeposit;
  }

  public void setCommonlyDeposit(String commonlyDeposit) {
    this.commonlyDeposit = commonlyDeposit;
  }


  public String getCommonlyDepositNg() {
    return commonlyDepositNg;
  }

  public void setCommonlyDepositNg(String commonlyDepositNg) {
    this.commonlyDepositNg = commonlyDepositNg;
  }




}
