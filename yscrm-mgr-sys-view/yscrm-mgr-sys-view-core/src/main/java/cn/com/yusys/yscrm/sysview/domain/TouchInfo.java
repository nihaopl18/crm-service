package cn.com.yusys.yscrm.sysview.domain;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/14 19:08
 */
public class TouchInfo {

    /**
     * 接触类型
     */
    private String type;
    /**
     * 接触日期
     */

    private String date;
    /**
     * 接触次数
     */
    private Integer count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
