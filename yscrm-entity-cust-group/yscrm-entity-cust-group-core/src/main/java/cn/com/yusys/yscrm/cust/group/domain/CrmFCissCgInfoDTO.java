package cn.com.yusys.yscrm.cust.group.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

;

@Entity
public class CrmFCissCgInfoDTO implements Serializable{

  private static final long serialVersionUID = 1821798978036440576L;
     //客群基本信息
     @ApiModelProperty(value = "客群基本信息")
    private CrmFCissCgBaseVO fCissCgBase;

  //客户号
  @ApiModelProperty(value = "客户号")
  private List<String> custId;

  //客户号
  @ApiModelProperty(value = "存储编号")
  private String conditionNo;

  public CrmFCissCgBaseVO getfCissCgBase() {
    return fCissCgBase;
  }

  public void setfCissCgBase(CrmFCissCgBaseVO fCissCgBase) {
    this.fCissCgBase = fCissCgBase;
  }

  public List<String> getCustId() {
    return custId;
  }

  public void setCustId(List<String> custId) {
    this.custId = custId;
  }

  public String getConditionNo() {
    return conditionNo;
  }

  public void setConditionNo(String conditionNo) {
    this.conditionNo = conditionNo;
  }
}
