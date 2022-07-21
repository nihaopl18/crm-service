package cn.com.yusys.yusp.rai.engine.data.exceptions;

import cn.com.yusys.yusp.rai.engine.data.constants.ExceptionCodeConstant;

/**
 * 规则表达式错误异常
 * @author zhangchi
 * @date 2021年12月06日 13:49:09
 * @version 1.0.0
 */
public class RuleExprErrorException extends SourceDataErrorException {

    public RuleExprErrorException(String message) {
        super(ExceptionCodeConstant.RULE_EXPR_ERROR, message);
    }
}
