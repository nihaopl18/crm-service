package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/24 16:25
 */
public class TodoWorkInfo implements Serializable {
    /**
     * 编号
     */
    private String todoWorkId;
    /**
     * 待办类型
     */
    private String  todoWorkType;
    /**
     * 创建日期
     */
    private String createDate;
    /**
     * 截止日期
     */
    private String startDate;
    /**
     * 状态
     */
    private String todoWorkState;
    /**
     * 详情
     */
    private String todoWorkContent;
    /**
     * 客户经理
     */
    private String creatorName;

    public String getTodoWorkId() {
        return todoWorkId;
    }

    public void setTodoWorkId(String todoWorkId) {
        this.todoWorkId = todoWorkId;
    }

    public String getTodoWorkType() {
        return todoWorkType;
    }

    public void setTodoWorkType(String todoWorkType) {
        this.todoWorkType = todoWorkType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTodoWorkState() {
        return todoWorkState;
    }

    public void setTodoWorkState(String todoWorkState) {
        this.todoWorkState = todoWorkState;
    }

    public String getTodoWorkContent() {
        return todoWorkContent;
    }

    public void setTodoWorkContent(String todoWorkContent) {
        this.todoWorkContent = todoWorkContent;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
