package cn.com.yusys.yscimc.operation.domain.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 对外接口请求返回对象
 * @author zhangchi
 * @date 2021年4月29日 11:18:53
 * @version 1.0.0
 */
@Validated
public class DoRequestDto {
    
    /** 数据内容 json字符串 */
    @NotBlank
    private String data;
    
    /** 签名内容 */
    @NotNull
    private Sign sign;
    
    /** 调试使用签名 */
    private String reqSignValue;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public String getReqSignValue() {
        return reqSignValue;
    }

    public void setReqSignValue(String reqSignValue) {
        this.reqSignValue = reqSignValue;
    }
}
