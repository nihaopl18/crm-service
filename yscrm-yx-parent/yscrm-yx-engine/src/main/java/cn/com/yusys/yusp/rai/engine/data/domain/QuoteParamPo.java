package cn.com.yusys.yusp.rai.engine.data.domain;

import lombok.Data;

/**
 * 引用参数
 * @author fangqiang
 * @email fangqiang@yusys.com.cn
 * @date 2021-03-23 17:25:48
 */
@Data
public class QuoteParamPo implements Comparable<QuoteParamPo> {

    /**
     * 参数码值
     */
    private String paramAttr;
    /**
     * 参数代码
     */
    private String paramCode;
    /**
     * 参数映射值
     */
    private String paramMapp;
    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 参数类型
     */
    private String paramType;
    /**
     * 引用类型
     */
    private String quoteType;
    
    /** VARCHAR|NUMBER */
    private String dataType;

    /** REDIS|FEIGN|HTTP */
    private String dataSourceType;

    /** redis key hash格式存放，支持包含变量 */
    private String redisKey;
    
    /** feign或者http调用地址，post请求，参数体为完整的请求数据对象，返回数据体为String */
    private String dataUrl;

    @Override
    public int compareTo(QuoteParamPo o) {
        return paramCode.compareTo(o.getParamCode());
    }
}
