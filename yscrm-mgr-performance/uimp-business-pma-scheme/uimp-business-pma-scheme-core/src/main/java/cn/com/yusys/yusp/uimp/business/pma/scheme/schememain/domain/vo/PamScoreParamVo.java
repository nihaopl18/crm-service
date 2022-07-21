package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo;

import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: Zhan YongQiang
 * @date: 2022/4/7 16:22
 */
public class PamScoreParamVo {

    @NotBlank
    private String cnName;

    @NotBlank
    private String enName;

    @NotBlank
    private String paramValue;


    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}
