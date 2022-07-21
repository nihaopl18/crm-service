package cn.com.yusys.yscimc.operation.constant;

public enum ComponentTypeEnum {
    /**
     * 灵活查询
     */
    FLEXIBLE_QUERY("7", "灵活查询"),
    /**
     * 标签查询
     */
    TAG_QUERY("8", "标签查询"),
    /**
     * 客户群引入
     */
    GROUP_IMPORT("9", "客户群引入"),
    /**
     * 客户导入
     */
    CONSUMER_IMPORT("10", "客户导入"),
    /**
     * 短信
     */
    SHORT_MESSAGE("18", "短信"),
    /**
     * 短信
     */
    WE_CHAT("41", "微信"),
    /**
     * 手机银行
     */
    MOBILE_BANK("28", "手机银行"),
    /**
     * 营销成效指标策划
     */
    INDEX_PLAN("35", "营销成效指标策划"),
    /**
     * 批量事件活动
     */
    BATCH_EVENT_ACTIVITY("38", "批量事件活动"),
    /**
     * 实时事件活动
     */
    ANYTIME_EVENT_ACTIVITY("39", "实时事件活动"),
    /**
     * 营销动作
     */
    MARKETING_ACTION("47", "营销动作"),
    /**
     * 产品选择
     */
    PRODUCT_CHOICE("13", "产品选择"),
    /**
     * 裂变
     */
    FISSION("55", "裂变"),
    /**
     * 素材
     */
    MEDIA("56", "素材"),
    /**
     * 分享
     */
    SHARE("71", "分享"),
    /**
     * 报名
     */
    SIGN_UP("58", "报名");

    /**
     * 组件表 id
     */
    private final String componentType;

    private final String componentName;

    ComponentTypeEnum(String componentType, String componentName) {
        this.componentType = componentType;
        this.componentName = componentName;
    }

    public String getComponentType() {
        return componentType;
    }

    public String getComponentName() {
        return componentName;
    }

    public static String selectComponentName(String componentType) {
        ComponentTypeEnum[] values = ComponentTypeEnum.values();
        String name = null;
        for (int i = 0; i < values.length; i++) {
            if (values[i].getComponentType().equals(componentType)) {
                name = values[i].getComponentName();
                break;
            }
        }
        return name;
    }
}
