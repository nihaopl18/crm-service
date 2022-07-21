package cn.com.yusys.yusp.rai.engine.data.exceptions;

import cn.com.yusys.yusp.rai.engine.data.constants.ExceptionCodeConstant;

/**
 * 权益类型错误异常
 * @author zhangchi
 * @date 2021年12月06日 13:49:09
 * @version 1.0.0
 */
public class RaiTypeErrorException extends SourceDataErrorException {

    public RaiTypeErrorException(String message) {
        super(ExceptionCodeConstant.RAI_TYPE_ERROR, message);
    }
}
