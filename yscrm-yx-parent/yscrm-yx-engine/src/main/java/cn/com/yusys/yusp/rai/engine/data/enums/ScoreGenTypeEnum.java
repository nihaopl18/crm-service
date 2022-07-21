package cn.com.yusys.yusp.rai.engine.data.enums;

import cn.com.yusys.yusp.rai.engine.data.exceptions.ScoreGenTypeErrorException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 积分区间计算方式
 * @author zhangchi
 * @date 2021年12月10日 13:57:45
 * @version 1.0.0
 */
@Getter
public enum ScoreGenTypeEnum {

    /**
     * STATIC_VAL
     */
    STATIC_VAL("70290001","STATIC_VAL","固定值"),

    /**
     * EVERY
     */
    EVERY("70290002","EVERY","每元"),

    /**
     * SCALE
     */
    SCALE("70290003","SCALE","比例");


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

    ScoreGenTypeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }

    public static ScoreGenTypeEnum getByCode(String code) {
        return Arrays.stream(values())
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new ScoreGenTypeErrorException("错误的区间计算方式" + code));
    }
}
