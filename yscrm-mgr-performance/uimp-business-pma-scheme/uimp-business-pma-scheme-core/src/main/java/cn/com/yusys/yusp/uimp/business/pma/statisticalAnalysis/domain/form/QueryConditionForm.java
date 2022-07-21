package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form;

/**
 * @author sandMan
 * @date 2022/5/10 - 16:09
 */
public class QueryConditionForm {
    private int page;

    private int size;

    private String condition;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
