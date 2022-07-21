package cn.com.yusys.yusp.rai.engine.data.exceptions;

import lombok.Data;

/**
 * 规则匹配异常
 * @author zhangchi
 * @date 2021年12月08日 18:45:25
 * @version 1.0.0
 */
@Data
public class RuleMatchException extends RuntimeException {

    private String code;

    public RuleMatchException(String code, String message) {
        this(code, message, null);
    }

    public RuleMatchException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
