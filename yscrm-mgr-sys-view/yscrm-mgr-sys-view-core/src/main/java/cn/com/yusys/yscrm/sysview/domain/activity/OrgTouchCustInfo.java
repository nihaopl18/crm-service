package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/16 16:36
 */
public class OrgTouchCustInfo implements Serializable {
    private static final long serialVersionUID = -2890472888605945083L;
    /**
     * 数量
     */
    private Integer count;

    /**
     * 名称
     */
    private String name;

    /**
     * id
     */
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
