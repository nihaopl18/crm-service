package cn.com.yusys.yscrm.sysview.domain;

/**
 * 个人标签信息
 * @author: sxm
 * @time: 2021/8/16 14:39
 */
public class PerLabelInfo {

    private String tagName;
    /**
     * 是否是系统标签，0否，1是
     */
    private String systemTag;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getSystemTag() {
        return systemTag;
    }

    public void setSystemTag(String systemTag) {
        this.systemTag = systemTag;
    }
}
