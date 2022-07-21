package cn.com.yusys.yscrm.custmgr.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

;

@Entity
public class CrmTriumphlookVO implements Serializable {

    private static final long serialVersionUID = 1493642054106877440L;

    /**
     * 业绩查看
     */
    @ApiModelProperty(value = "业绩查看")
    private List<CrmFYyTriumphLookUp> crmFYyTriumphLookUpList = new ArrayList<>();
    /**
     * ppop信息
     */
    @ApiModelProperty(value = "ppop信息")
    private List<CrmFYyTriumphLookPpop> CrmTriuLookPpopList = new ArrayList<>();

    public List<CrmFYyTriumphLookUp> getCrmFYyTriumphLookUpList() {
        return crmFYyTriumphLookUpList;
    }

    public void setCrmFYyTriumphLookUpList(List<CrmFYyTriumphLookUp> crmFYyTriumphLookUpList) {
        this.crmFYyTriumphLookUpList = crmFYyTriumphLookUpList;
    }

    public List<CrmFYyTriumphLookPpop> getCrmTriuLookPpopList() {
        return CrmTriuLookPpopList;
    }

    public void setCrmTriuLookPpopList(List<CrmFYyTriumphLookPpop> crmTriuLookPpopList) {
        CrmTriuLookPpopList = crmTriuLookPpopList;
    }
}
