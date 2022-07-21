package cn.com.yusys.yscrm.custmgr.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

;

@Entity
public class CrmTriumphVO implements Serializable{

  private static final long serialVersionUID = 1493642054106877440L;

	/**
	 * 分配信息
	 */
    @ApiModelProperty(value = "分配信息")
  private List<CrmFYyTriumphVO> crmFYyTriumphVOList=new ArrayList<>();
    /**
     * 下发信息
     */
    @ApiModelProperty(value = "下发信息")
    private List<CrmTriuVO> CrmTriuVOList=new ArrayList<>();

    public List<CrmFYyTriumphVO> getCrmFYyTriumphVOList() {
        return crmFYyTriumphVOList;
    }

    public void setCrmFYyTriumphVOList(List<CrmFYyTriumphVO> crmFYyTriumphVOList) {
        this.crmFYyTriumphVOList = crmFYyTriumphVOList;
    }

    public List<CrmTriuVO> getCrmTriuVOList() {
        return CrmTriuVOList;
    }

    public void setCrmTriuVOList(List<CrmTriuVO> crmTriuVOList) {
        CrmTriuVOList = crmTriuVOList;
    }
}
