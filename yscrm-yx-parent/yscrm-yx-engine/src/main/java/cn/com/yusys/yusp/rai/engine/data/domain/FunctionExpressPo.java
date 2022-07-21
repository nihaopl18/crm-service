package cn.com.yusys.yusp.rai.engine.data.domain;

import lombok.Data;

import java.util.List;

/**
 * 函数表达式
 * @author zhangchi
 * @date 2021年12月06日 15:02:16
 * @version 1.0.0
 */
@Data
public class FunctionExpressPo {

    /** 函数名称 */
    private String functionName;

    /** 函数表达式 */
    private String functionBody;

    /** 函数变量 */
    private List<String> variableNames;

    /** 函数变量 */
    private List<String> quoteParamNames;
}
