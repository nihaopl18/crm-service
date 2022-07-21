package cn.com.yusys.yusp.rai.engine.data.enums;

import cn.com.yusys.yusp.rai.engine.data.exceptions.CountCycleTypeErrorException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 连续动作统计周期枚举
 * @author zhangchi
 * @date 2021年12月06日 15:09:19
 * @version 1.0.0
 */
@Getter
public enum CountCycleTypeEnum {

    /**
     * COUNT_CYCLE_DAY
     */
    COUNT_CYCLE_DAY("70080001","COUNT_CYCLE_DAY","X天"),

    /**
     * COUNT_CYCLE_ACT
     */
    COUNT_CYCLE_ACT("70080002","COUNT_CYCLE_ACT","活动期间"),

    /**
     * COUNT_CYCLE_STATIC
     */
    COUNT_CYCLE_STATIC("70080003","COUNT_CYCLE_STATIC","指定期间");

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

    CountCycleTypeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }

    public static CountCycleTypeEnum getByCode(String code){
        return Arrays.stream(values())
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new CountCycleTypeErrorException("不支持的连续动作统计周期类型" + code));

    }
}
