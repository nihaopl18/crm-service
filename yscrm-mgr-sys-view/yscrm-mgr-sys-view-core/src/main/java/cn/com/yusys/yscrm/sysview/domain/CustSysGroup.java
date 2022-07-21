package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/9/6 16:30
 */
public class CustSysGroup {
    private String groupName;
    List<CustSysTag> custSysTagList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public List<CustSysTag> getCustSysTagList() {
        return custSysTagList;
    }

    public void setCustSysTagList(List<CustSysTag> custSysTagList) {
        this.custSysTagList = custSysTagList;
    }
}
