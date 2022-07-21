package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/9/1 13:52
 */
public class TagAnalysis {
    private String tagName;

    private Integer count=0;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
