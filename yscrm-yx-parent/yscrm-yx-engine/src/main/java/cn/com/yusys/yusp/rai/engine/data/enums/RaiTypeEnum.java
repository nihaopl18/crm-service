package cn.com.yusys.yusp.rai.engine.data.enums;

import cn.com.yusys.yusp.rai.engine.data.exceptions.RaiTypeErrorException;
import lombok.Getter;

import java.util.Arrays;

/**
 * 权益类型
 * @author zhangchi
 * @date 2021年12月10日 15:57:17
 * @version 1.0.0
 */
@Getter
public enum RaiTypeEnum {

    /**
     * 积分
     */
    SCORE("70020001", "积分"),
    /**
     * 卡券
     */
    COUPON("70020002", "卡券"),

    /***
     * 小游戏
     */
    GAME("70020003", "小游戏"),

    /**
     * 礼品
     */
    GIFT("70020006", "礼品"),
    ;

    /**
     * 编码
     */
    private final String code;

    /**
     * 值
     */
    private final String value;

    RaiTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static RaiTypeEnum getByCode(String code) {
        return Arrays.stream(values())
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RaiTypeErrorException("错误的权益编码" + code));
    }
}
