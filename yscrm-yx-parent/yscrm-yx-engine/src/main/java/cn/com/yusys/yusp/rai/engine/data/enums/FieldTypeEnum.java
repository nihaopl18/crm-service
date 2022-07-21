package cn.com.yusys.yusp.rai.engine.data.enums;

import cn.com.yusys.yusp.rai.engine.data.exceptions.FiledTypeErrorException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 规则字段类型枚举
 * @author zhangchi
 * @date 2021年12月06日 11:21:19
 * @version 1.0.0
 */
@Getter
public enum FieldTypeEnum {

    /**
     * 字符类型-字符
     */
    VARCHAR("70120001"),

    /**
     *
     * 整数类型-数值
     */
    NUMBER("70120002"),

    /**
     *
     * 日期-日期
     */
    DATE("70120003"),

    /**
     *
     * 下拉-字符
     */
    SELECT("70120004"),

    /**
     * 单选-字符
     */
    RADIO("70120005"),

    /**
     * 放大镜-字符
     */
    MAGNIFIER("70120007")
    ;


    private String code;


    FieldTypeEnum(String code){
        this.code = code;
    }


    public static FieldTypeEnum getFileType(String type){
        return Arrays.stream(values())
                .filter(item -> item.getCode().equals(type))
                .findFirst()
                .orElseThrow(() -> new FiledTypeErrorException("不能识别的字段类型" + type));
    }

}
