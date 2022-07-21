package cn.com.yusys.yscrm.sysview.domain;

/**
 * 行为追踪信息
 * @author: sxm
 * @time: 2021/8/16 17:34
 */
public class BehaviorInfo {
    /**
     * 产品名称
     */
    private String prodName;
    /**
     * 次数
     */
    private String viewsNo;


    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getViewsNo() {
        return viewsNo;
    }

    public void setViewsNo(String viewsNo) {
        this.viewsNo = viewsNo;
    }

}
