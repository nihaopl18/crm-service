package cn.com.yusys.yusp.dycrm.complaintfeedback.domain;

public enum LaunchEnum {
        ECIF("ECIF", 1), CRM("CRM", 2), YIP("YIP", 3), EBank("网银", 4), YRL("YRL", 5), MessagingPlatform("短信平台", 6), NDS("NDS", 7);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private LaunchEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static Integer getIndex(String name) {
        for (LaunchEnum le : LaunchEnum.values()) {
            if (le.getName() == name) {
                return le.index;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
