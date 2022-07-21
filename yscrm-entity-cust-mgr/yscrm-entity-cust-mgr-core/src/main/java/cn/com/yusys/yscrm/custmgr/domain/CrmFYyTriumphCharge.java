package cn.com.yusys.yscrm.custmgr.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_YY_TRIUMPH_CHARGE")
public class CrmFYyTriumphCharge implements Serializable{

  private static final long serialVersionUID = 1936054295091395072L;

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
     * 产品类型(01：利率、汇率挂钩手续费收入 02：人民币基金手续费收入 03：ODII手续费收入 04：境内结构性产品手续费收入)
     */
    private String chargeType;

    /**
     * 产品名称(01：利率、汇率挂钩手续费收入 02：人民币基金手续费收入 03：ODII手续费收入 04：境内结构性产品手续费收入)
     */
    @ExportEntityMap(CnName="产品名称",EnName="chargeName")
    private String chargeName;

    /**
     * 当月手续费
     */
    @ExportEntityMap(CnName="当月手续费",EnName="commissionChargeM")
    private String commissionChargeM;

    /**
     * 当季手续费
     */
    @ExportEntityMap(CnName="当季手续费",EnName="commissionChargeS")
    private String commissionChargeS;

    /**
     * 当年手续费
     */
    @ExportEntityMap(CnName="当年手续费",EnName="commissionChargeY")
    private String commissionChargeY;


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


  public String getChargeType() {
    return chargeType;
  }

  public void setChargeType(String chargeType) {
    this.chargeType = chargeType;
  }


  public String getChargeName() {
    return chargeName;
  }

  public void setChargeName(String chargeName) {
    this.chargeName = chargeName;
  }


  public String getCommissionChargeM() {
    return commissionChargeM;
  }

  public void setCommissionChargeM(String commissionChargeM) {
    this.commissionChargeM = commissionChargeM;
  }


  public String getCommissionChargeS() {
    return commissionChargeS;
  }

  public void setCommissionChargeS(String commissionChargeS) {
    this.commissionChargeS = commissionChargeS;
  }


  public String getCommissionChargeY() {
    return commissionChargeY;
  }

  public void setCommissionChargeY(String commissionChargeY) {
    this.commissionChargeY = commissionChargeY;
  }

}
