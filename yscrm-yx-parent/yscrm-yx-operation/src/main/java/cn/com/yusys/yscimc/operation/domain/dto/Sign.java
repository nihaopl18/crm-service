package cn.com.yusys.yscimc.operation.domain.dto;

import javax.validation.constraints.NotBlank;

/**
 * 签名数据对象
 * @author zhangchi
 * @date 2021年4月29日 11:20:14
 * @version 1.0.0
 */
public class Sign {

    /** 签名方式 */
    private String signType;

    /** 签名 */
    @NotBlank
    private String signValue;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSignValue() {
        return signValue;
    }

    public void setSignValue(String signValue) {
        this.signValue = signValue;
    }
}
