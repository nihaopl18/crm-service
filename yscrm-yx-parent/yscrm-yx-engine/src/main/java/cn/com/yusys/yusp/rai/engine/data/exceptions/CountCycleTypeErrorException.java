package cn.com.yusys.yusp.rai.engine.data.exceptions;

import cn.com.yusys.yusp.rai.engine.data.constants.ExceptionCodeConstant;

/**
 * 连续动作统计周期类型异常
 * @author zhangchi
 * @date 2021年12月06日 13:49:09
 * @version 1.0.0
 */
public class CountCycleTypeErrorException extends SourceDataErrorException {

    public CountCycleTypeErrorException(String message) {
        super(ExceptionCodeConstant.COUNT_CYCLE_TYPE_ERROR, message);
    }
}
