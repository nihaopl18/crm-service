package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/16 16:21
 */
public class TouchInfoDate {


    private String type;

    private List<String> date;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }
}
