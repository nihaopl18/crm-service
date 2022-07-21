package cn.com.yusys.yusp.rai.engine.data.exceptions;

import lombok.Data;

/**
 * 元数据异常
 * @author zhangchi
 * @date 2021年12月06日 13:37:06
 * @version 1.0.0
 */
@Data
public class SourceDataErrorException extends RuntimeException {

    private String code;

    public SourceDataErrorException(String code, String message) {
        this(code, message, null);
    }

    public SourceDataErrorException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
