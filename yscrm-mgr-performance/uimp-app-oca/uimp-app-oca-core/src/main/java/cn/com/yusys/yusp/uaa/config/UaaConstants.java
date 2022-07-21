package cn.com.yusys.yusp.uaa.config;

/**
 * Application constants.
 */
public final class UaaConstants {

    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";


    /**
     * 可用的
     */
    public static final String USER_STATUS_ENABLED = "A";
    /**
     * 不可用的
     */
    public static final String USER_STATUS_DISABLED = "I";
    /**
     * 未激活的
     */
    public static final String USER_STATUS_UNACTIVATED = "W";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 逻辑系统id
     */
    public static final String SYS_ID = "sysId";

    /**
     * 逻辑系统id
     */
    public static final String CLIENT_ID = "clientId";

    /**
     * 登录用户名
     */
    public static final String USER_NAME = "user_name";

    /**
     * 请求头中的accessToken属性名
     */
    public static final String AUTHORIZATION_KEY = "Authorization";

    /**
     * Authorization 信息：Basic 开头
     */
    public static final String BASIC_TOKEN_TYPE = "Basic";

    /**
     * Authorization 信息：Bearer 开头
     */
    public static final String BEARER_TOKEN_TYPE = "Bearer";

    /**
     * 解析后的token
     */
    public static final String PARSED_TOKEN = "PARSE_TOKEN";


    /**
     * 策略启用
     */
    public static final String ENABLE_FLAG_TRUE = "1";

    /**
     * 策略未启用
     */
    public static final String ENABLE_FLAG_FALSE = "2";

    /**
     * UTF-8编码
     */
    public static final String CHARSET_TYPE_UTF8 = "UTF-8";

    private UaaConstants() {
    }
}
