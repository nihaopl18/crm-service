package cn.com.yusys.yusp.rai.engine.data.enums;

import cn.com.yusys.yusp.rai.engine.data.exceptions.CountTypeErrorException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 连续动作统计类型枚举
 * @author zhangchi
 * @date 2021年12月06日 15:04:27
 * @version 1.0.0
 */
@Getter
public enum CountTypeEnum {

    /**
     * COUNT_CNT
     */
    COUNT_CNT("70070001","COUNT_CNT","次数"),

    /**
     * COUNT_ADD
     */
    COUNT_ADD("70070002","COUNT_ADD","累积");

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

    CountTypeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }

    public static CountTypeEnum getByCode(String code){
        return Arrays.stream(values())
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new CountTypeErrorException("不支持的连续动作支持类型" + code));
    }
}
