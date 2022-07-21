package cn.com.yusys.yscimc.operation.domain.form;

/**
 * @Author Lenovo
 * @Data 2022/3/10 20:29
 */
public class ActivityResultForm {

    private String tempId;

    private int page;

    private int size;

    private String condition;

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

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
