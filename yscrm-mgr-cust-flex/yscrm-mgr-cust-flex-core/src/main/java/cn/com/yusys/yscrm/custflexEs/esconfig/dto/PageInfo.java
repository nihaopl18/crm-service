package cn.com.yusys.yscrm.custflexEs.esconfig.dto;

/**
 * @ClassName: PageInfo
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/8/29 11:27
 * @Version: 1.0
 **/
public class PageInfo {
    // es分页开始
    private int start;
    // 分页结束
    private int end;
    // list截取开始
    private int subStart;
    // list截取结束
    private int subEnd;
    // 每页条数
    private int pageSize;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getSubStart() {
        return subStart;
    }

    public void setSubStart(int subStart) {
        this.subStart = subStart;
    }

    public int getSubEnd() {
        return subEnd;
    }

    public void setSubEnd(int subEnd) {
        this.subEnd = subEnd;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
