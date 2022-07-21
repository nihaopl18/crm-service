package cn.com.yusys.yusp.rai.engine.data.enums;

import lombok.Getter;

/**
 * 动作类型枚举
 * @author fangqiang
 * @email fangqiang@yusys.com.cn
 * @date 2021-03-23 17:25:48
 */
@Getter
public enum ActionTypeEnum {

    /**
     * ACTION_COND
     */
    ACTION_COND("70150001","ACTION_COND","单次动作"),

    /**
     * ACTION_CONT_COND
     */
    ACTION_CONT_COND("70150002","ACTION_CONT_COND","连续动作");

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

    ActionTypeEnum(String code, String enName, String cnName){
        this.code = code;
        this.enName =enName;
        this.cnName = cnName;
    }
}
