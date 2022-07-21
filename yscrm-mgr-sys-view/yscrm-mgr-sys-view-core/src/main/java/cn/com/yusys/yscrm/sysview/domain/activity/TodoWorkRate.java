package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/22 16:45
 */
public class TodoWorkRate implements Serializable,Comparable<TodoWorkRate> {
    private static final long serialVersionUID = 3946779534926531866L;
    /**
     * 名次
     */
    private Integer rank;
    /**
     * 状态
     * 1-待跟进
     * 2-已跟进
     */
    private String todoWorkState;
    /**
     * 数量
     */
    private Integer count = 0;
    /**
     * 机构id
     */
    private String orgId;

    /**
     * 机构层级
     */
    private String orgLevel;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 机构/经理名称
     */
    private String name;
    /**
     * 经理id
     */
    private String creatorId;
    /**
     * 跟进率
     */
    private Integer rate;

    private Integer taskRate;

    private int page=1;
    private int size = 10;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTodoWorkState() {
        return todoWorkState;
    }

    public void setTodoWorkState(String todoWorkState) {
        this.todoWorkState = todoWorkState;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public int compareTo(TodoWorkRate o) {
        return o.getRate().compareTo(this.rate);
    }

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
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

    public Integer getTaskRate() {
        return taskRate;
    }

    public void setTaskRate(Integer taskRate) {
        this.taskRate = taskRate;
    }
}
