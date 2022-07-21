package cn.com.yusys.yusp.cm.market.constant;

public enum MarketPlanInfoEnum {
    
    MARKET_PLAN_TYPE_LIST("客户名单制营销类型", "01"),
    MARKET_PLAN_TYPE_INTERNET("互联网场景营销类型", "02"),
    MARKET_PLAN_TYPE_EVENT("实时事件/批量事件营销类型", "03");

    private final String name;

    private final String code;

    MarketPlanInfoEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
