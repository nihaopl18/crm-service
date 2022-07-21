package cn.com.yusys.yusp.rai.engine.data.enums;

import cn.com.yusys.yusp.rai.engine.data.exceptions.CalcTypeErrorException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 动作计算方式枚举
 * @author zhangchi
 * @date 2021年12月10日 10:47:17
 * @version 1.0.0
 */
@Getter
public enum CalcTypeEnum {

    /**
     * EXPR
     */
    EXPR("70050001","EXPR","按公式"),

    /**
     * STATIC_VALUE
     */
    STATIC_VALUE("70050002","STATIC_VALUE","按固定值"),

    /**
     * SECTION
     */
    SECTION("70050003","SECTION","按区间"),

    /**
     * AMOUNT
     */
    AMOUNT("70050004","AMOUNT","按金额");

    /**
     * code value
     */
    private String code;

    /**
     * english name
     */
    private String enName;

    /**
     * chinese name
     */
    private String cnName;

    CalcTypeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }

    public static CalcTypeEnum getByCode (String code) {
        return Arrays.stream(values())
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new CalcTypeErrorException("错误的动作计算类型" + code));
    }
}
