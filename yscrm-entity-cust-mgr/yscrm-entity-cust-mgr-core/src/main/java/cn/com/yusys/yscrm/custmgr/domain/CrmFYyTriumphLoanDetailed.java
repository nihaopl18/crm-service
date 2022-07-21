package cn.com.yusys.yscrm.custmgr.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_YY_TRIUMPH_LOAN_DETAILED")
public class CrmFYyTriumphLoanDetailed implements Serializable{

  private static final long serialVersionUID = 1274982007239130368L;

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
     * 产品类型（01：按揭贷款 02：车位贷款）
     */
    private String loanType;

    /**
     * 产品名称（01：按揭贷款 02：车位贷款）
     */
    @ExportEntityMap(CnName="产品名称",EnName="loanName")
    private String loanName;

    /**
     * 当月放款金额
     */
    @ExportEntityMap(CnName="当月放款金额",EnName="loanAmountM")
    private String loanAmountM;

    /**
     * 当月放款笔数
     */
    @ExportEntityMap(CnName="当月放款笔数",EnName="loanCountM")
    private String loanCountM;

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


  public String getLoanType() {
    return loanType;
  }

  public void setLoanType(String loanType) {
    this.loanType = loanType;
  }


  public String getLoanName() {
    return loanName;
  }

  public void setLoanName(String loanName) {
    this.loanName = loanName;
  }


  public String getLoanAmountM() {
    return loanAmountM;
  }

  public void setLoanAmountM(String loanAmountM) {
    this.loanAmountM = loanAmountM;
  }


  public String getLoanCountM() {
    return loanCountM;
  }

  public void setLoanCountM(String loanCountM) {
    this.loanCountM = loanCountM;
  }

}
