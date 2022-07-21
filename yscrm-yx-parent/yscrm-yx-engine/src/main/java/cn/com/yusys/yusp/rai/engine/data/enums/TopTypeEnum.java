package cn.com.yusys.yusp.rai.engine.data.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * 封顶类型枚举
 * @author fangqiang
 * @email fangqiang@yusys.com.cn
 * @date 2021-03-23 17:25:48
 */
@Getter
public enum TopTypeEnum {

    /**
     * TOP_DAY
     */
    TOP_DAY("70000001","TOP_DAY","当日"),

    /**
     * TOP_MONTH
     */
    TOP_MONTH("70000002","TOP_MONTH","当月"),

    /**
     * TOP_ONE
     */
    TOP_ONE("70000003","TOP_ONE","单笔"),

    /**
     * TOP_ACTION
     */
    TOP_ACTION("70000004","TOP_ACTION","活动期间");

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

    TopTypeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }

    public static TopTypeEnum getByCode(String code) {
        return Arrays.stream(values()).filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElse(null);

    }
}
