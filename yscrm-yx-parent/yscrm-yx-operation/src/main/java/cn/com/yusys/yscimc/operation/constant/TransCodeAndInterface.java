package cn.com.yusys.yscimc.operation.constant;

import java.util.Arrays;
import java.util.Objects;

/**
 * 交易码和接口业务处理类对应关系
 *
 * @author hujun3
 * @date 2021-01-05
 */
public enum TransCodeAndInterface {

    /**
     * 获取手机银行营销栏位的信息
     */
    MOBILE_BANK_WINDOW("99YSCIMC1001", "internetMarketingDataService", "getMobileBankingWindows"),
    /**
     * 获取报名类活动信息
     */
    SIGN_UP_DATA("99YSCIMC1002", "internetMarketingDataService", "getSignUpData"),
    /**
     * 获取分享类活动信息
     */
    SHARE_DATA("99YSCIMC1003", "internetMarketingDataService", "getShareData"),
    /**
     * 获取裂变类活动信息
     */
    FISSION_DATA("99YSCIMC1004", "internetMarketingDataService", "getFissionData"),
    /**
     * 报名活动接口
     */
    SIGN_UP("99YSCIMC1005", "internetMarketingDataService", "getFissionData"),
    /**
     * 实时事件请求类型
     */
    REAL_TIME_EVENT("99YSCIMC1006", "marketEventService", "realTimeEvent"),
    /**
     * 批量事件请求类型
     */
    BATCH_TASK_EVENT("99YSCIMC1007", "marketEventService", "batchTaskEvent");

    private final String transCode;

    private final String interfaceName;

    private final String method;

    TransCodeAndInterface(String transCode, String interfaceName, String method) {
        this.transCode = transCode;
        this.interfaceName = interfaceName;
        this.method = method;
    }

    public String getTransCode() {
        return transCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public String getMethod() {
        return method;
    }

    public static TransCodeAndInterface getTypeByCode(String code) {
        return Arrays.stream(TransCodeAndInterface.values()).filter(item -> Objects.equals(code,
                item.getTransCode())).findFirst().orElseThrow(() -> new IllegalStateException("非法的类型"));
    }
}
