package cn.com.yusys.yscrm.cust.group.domain;


import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;
import groovy.transform.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
public class CustomererDTO implements Serializable {

    private static final long serialVersionUID = 1613148922215118848L;
    private int page;
    private int size = 10;
    private String sort;
    /**
     * 证件类型
     **/
    @ApiModelProperty(value = "证件类型")
    private String custType;
    /**
     * 证件号
     **/
    @ApiModelProperty(value = "证件号")
    private String certNo;


    /**
     * 客户号
     */
    @ApiModelProperty(value = "客户号")
    @ExportEntityMap(CnName="客户号",EnName="custId")
    private String custId;

    /**
     * NDS号
     */
    @ApiModelProperty(value = "NDS号")
    @ExportEntityMap(CnName="NDS号",EnName="ndsCustNo")
    private String ndsCustNo;
    /**
     * 客户中文姓名
     */
    @ApiModelProperty(value = "客户中文姓名")
    @ExportEntityMap(CnName="客户中文姓名",EnName="custName")
    private String custName;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNdsCustNo() {
        return ndsCustNo;
    }

    public void setNdsCustNo(String ndsCustNo) {
        this.ndsCustNo = ndsCustNo;
    }
}
