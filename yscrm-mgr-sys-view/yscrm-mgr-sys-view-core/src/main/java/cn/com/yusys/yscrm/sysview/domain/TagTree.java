package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

public class TagTree {
    private String tagNo;
    private String groupNo;
    private String tagName;
    private String availableDate;
    private String disableDate;
    private List<TagTree> children;

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public String getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(String disableDate) {
        this.disableDate = disableDate;
    }

    public List<TagTree> getChildren() {
        return children;
    }

    public void setChildren(List<TagTree> children) {
        this.children = children;
    }
}
