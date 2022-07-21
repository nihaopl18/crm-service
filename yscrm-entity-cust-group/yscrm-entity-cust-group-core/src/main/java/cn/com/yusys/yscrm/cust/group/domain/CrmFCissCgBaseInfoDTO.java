package cn.com.yusys.yscrm.cust.group.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

;

@Entity
public class CrmFCissCgBaseInfoDTO implements Serializable{

  private static final long serialVersionUID = 1821798978036440576L;
     //客群基本信息
     @ApiModelProperty(value = "客群基本信息")
    private CrmFCissCgBaseVO fCissCgBase;
    //客户群客户信息
    @ApiModelProperty(value = "客户群客户信息")
    private List<CrmFCgPreparationVO> fCgPreparationList=new ArrayList<>();
    //删选条件
    @ApiModelProperty(value = "筛选条件")
   private CrmCustomerDTO crmCustomerDTO;

  public CrmFCissCgBaseVO getfCissCgBase() {
    return fCissCgBase;
  }

  public void setfCissCgBase(CrmFCissCgBaseVO fCissCgBase) {
    this.fCissCgBase = fCissCgBase;
  }

  public List<CrmFCgPreparationVO> getfCgPreparationList() {
    return fCgPreparationList;
  }

  public void setfCgPreparationList(List<CrmFCgPreparationVO> fCgPreparationList) {
    this.fCgPreparationList = fCgPreparationList;
  }

  public CrmCustomerDTO getCrmCustomerDTO() {
    return crmCustomerDTO;
  }

  public void setCrmCustomerDTO(CrmCustomerDTO crmCustomerDTO) {
    this.crmCustomerDTO = crmCustomerDTO;
  }

}
