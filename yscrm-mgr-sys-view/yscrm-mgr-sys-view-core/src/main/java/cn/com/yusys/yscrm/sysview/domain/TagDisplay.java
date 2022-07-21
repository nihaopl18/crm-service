package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/9/6 14:29
 */
public class TagDisplay {
    List<CustomTag> customTags;
    private String custId;

    public List<CustomTag> getCustomTags() {
        return customTags;
    }

    public void setCustomTags(List<CustomTag> customTags) {
        this.customTags = customTags;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
