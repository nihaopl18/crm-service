package cn.com.yusys.yusp.rai.engine.data.enums;

import cn.com.yusys.yusp.rai.engine.data.exceptions.CountActionStoreTypeErrorException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 连续动作比较符枚举
 * @author zhangchi
 * @date 2021年12月06日 15:23:16
 * @version 1.0.0
 */
@Getter
public enum ContActionStoreTypeEnum {

    /**
     * CONT_OPER_LG
     */
    CONT_OPER_LG("30010003","CONT_OPER_LG","大于"),

    /**
     * CONT_OPER_EG
     */
    CONT_OPER_EG("30010004","CONT_OPER_EG","大于等于");

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

    ContActionStoreTypeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }


    public static ContActionStoreTypeEnum getByCode(String code){
       return Arrays.stream(values())
               .filter(item -> item.getCode().equals(code))
               .findFirst()
               .orElseThrow(() -> new CountActionStoreTypeErrorException("不支持的连续动作比较符" + code));
    }
}
