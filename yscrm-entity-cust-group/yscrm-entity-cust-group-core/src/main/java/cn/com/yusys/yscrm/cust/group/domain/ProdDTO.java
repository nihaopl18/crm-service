package cn.com.yusys.yscrm.cust.group.domain;


import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;
import groovy.transform.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
public class ProdDTO implements Serializable {

    private static final long serialVersionUID = 1613148922215118848L;


    private String prodId;

    private String prodName;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
