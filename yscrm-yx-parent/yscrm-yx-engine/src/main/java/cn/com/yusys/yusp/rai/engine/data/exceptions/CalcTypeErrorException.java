package cn.com.yusys.yusp.rai.engine.data.exceptions;

import cn.com.yusys.yusp.rai.engine.data.constants.ExceptionCodeConstant;

/**
 * 动作计算类型错误异常
 * @author zhangchi
 * @date 2021年12月06日 13:49:09
 * @version 1.0.0
 */
public class CalcTypeErrorException extends SourceDataErrorException {

    public CalcTypeErrorException(String message) {
        super(ExceptionCodeConstant.CALC_TYPE_ERROR, message);
    }
}
