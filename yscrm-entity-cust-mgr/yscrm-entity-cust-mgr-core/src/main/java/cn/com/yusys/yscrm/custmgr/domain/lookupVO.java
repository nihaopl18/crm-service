package cn.com.yusys.yscrm.custmgr.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class lookupVO {

    /**
     * ppop排名信息
     */
    @ApiModelProperty(value = "ppop排名信息")
    private List<CrmFYyTriumphLookUp> crmFYyTriumphVOList=new ArrayList<>();
    /**
     * ppop信息
     */
    private analyseVO nalyseVO;

    public List<CrmFYyTriumphLookUp> getCrmFYyTriumphVOList() {
        return crmFYyTriumphVOList;
    }

    public void setCrmFYyTriumphVOList(List<CrmFYyTriumphLookUp> crmFYyTriumphVOList) {
        this.crmFYyTriumphVOList = crmFYyTriumphVOList;
    }

    public analyseVO getNalyseVO() {
        return nalyseVO;
    }

    public void setNalyseVO(analyseVO nalyseVO) {
        this.nalyseVO = nalyseVO;
    }
}
