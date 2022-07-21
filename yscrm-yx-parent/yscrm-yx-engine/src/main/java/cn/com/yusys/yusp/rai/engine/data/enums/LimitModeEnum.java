package cn.com.yusys.yusp.rai.engine.data.enums;

import lombok.Getter;

/**
 * 卡券库存类型枚举
 * @author fangqiang
 * @email fangqiang@yusys.com.cn
 * @date 2021-03-23 17:25:48
 */
@Getter
public enum LimitModeEnum {

    /**
     * LIMIT_SUB
     */
    LIMIT_SUB("20020001","LIMIT_SUB","活动子库存"),

    /**
     * LIMIT_TOTAL
     */
    LIMIT_TOTAL("20020002","LIMIT_TOTAL","同总库存");

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

    LimitModeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }
}
