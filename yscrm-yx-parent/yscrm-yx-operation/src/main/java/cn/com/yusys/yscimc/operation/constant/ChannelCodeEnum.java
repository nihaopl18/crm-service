package cn.com.yusys.yscimc.operation.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * 渠道信息码
 * @author hujun3
 * @date 2021-01-05
 */
public enum ChannelCodeEnum {
    /**
     * 接口错误码
     */
    DEPOSIT_CHANNEL_CODE("101001001","存款核心","",""),
    MOBILE_CHANNEL_CODE("101001011","手机银行","",""),
    ;

    public static ChannelCodeEnum getByCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            Optional<ChannelCodeEnum> codeEnum = Arrays.stream(values()).filter(item -> code.equals(item.getCode())).findFirst();
            if (codeEnum.isPresent()) {
                return codeEnum.get();
            }
        }
        return null;
    }
    /**
     * 错误码
     */
    private final String code;
    /**
     * 中文描述
     */
    private final String zh_desc;
    /**
     * 英文描述
     */
    private final String en_desc;
    /***
     * 印尼语描述
     */
    private final String id_desc;

    ChannelCodeEnum(String value, String zhDesc, String enDesc, String idDesc ) {
        this.code = value;
        this.zh_desc = zhDesc;
        this.en_desc = enDesc;
        this.id_desc = idDesc;

    }

    public String getCode() {
        return code;
    }

    public String getZhDesc() {
        return zh_desc;
    }
    public String getEnDesc() {
        return en_desc;
    }
    public String getIdDesc() {
        return id_desc;
    }

    public static String getTypeByCode(String code, String language) {
        ChannelCodeEnum er=Arrays.stream(ChannelCodeEnum.values()).filter(item -> Objects.equals(code,
                item.getCode())).findFirst().orElseThrow(() -> new IllegalStateException("非法的类型"));
        return er.getZhDesc();
    }
}
