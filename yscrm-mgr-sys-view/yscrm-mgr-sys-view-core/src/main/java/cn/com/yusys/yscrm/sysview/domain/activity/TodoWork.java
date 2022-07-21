package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/17 16:40
 */
public class TodoWork implements Serializable {
    private static final long serialVersionUID = -8197475590197154057L;
    /**
     * 状态
     * 1-待跟进
     * 2-已跟进
     */
    private String todoWorkState;
    /**
     * 类别
     * 1-商机
     * 2-外访
     * 3-培训\会议
     * 4-材料整理
     * 5-客户跟进
     */
    private String todoWorkType;
    /**
     * 数量
     */
    private Integer count=0;

    /**
     * 跟进率
     */
    private Integer rate;


    public String getTodoWorkState() {
        return todoWorkState;
    }

    public void setTodoWorkState(String todoWorkState) {
        this.todoWorkState = todoWorkState;
    }

    public String getTodoWorkType() {
        return todoWorkType;
    }

    public void setTodoWorkType(String todoWorkType) {
        this.todoWorkType = todoWorkType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
