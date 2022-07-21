package cn.com.yusys.yusp.dycrm.todowork.domain;

public class TodoWorkExcle {
    private String todoWorkId;
    private String isNotice;
    private String todoWorkTitle;
    private String todoWorkType;
    private String todoWorkContent;
    private String creatorId;
    private String creatorName;
    private String createDate;
    private String todoWorkState;
    private String todoDate;
    private String finisher;
    private String finisherId;
    private String finisherName;
    private String relationCust;
    private String relationCustId;
    private String relationCustName;
    private String noticeCycle;
    private String startDate;
    private String endDate;
    private String sonTodoWorkId;

    public String getTodoWorkId() {
        return todoWorkId;
    }

    public void setTodoWorkId(String todoWorkId) {
        this.todoWorkId = todoWorkId;
    }

    public String getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(String isNotice) {
        this.isNotice = isNotice;
    }

    public String getTodoWorkTitle() {
        return todoWorkTitle;
    }

    public void setTodoWorkTitle(String todoWorkTitle) {
        this.todoWorkTitle = todoWorkTitle;
    }

    public String getTodoWorkType() {
        return todoWorkType;
    }

    public void setTodoWorkType(String todoWorkType) {
        this.todoWorkType = todoWorkType;
    }

    public String getTodoWorkContent() {
        return todoWorkContent;
    }

    public void setTodoWorkContent(String todoWorkContent) {
        this.todoWorkContent = todoWorkContent;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTodoWorkState() {
        return todoWorkState;
    }

    public void setTodoWorkState(String todoWorkState) {
        this.todoWorkState = todoWorkState;
    }

    public String getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = finisher;
        String[] finishers = finisher.split("/");
        this.finisherId = finishers[1];
        this.finisherName = finishers[0];
    }

    public String getFinisherId() {
        return finisherId;
    }

    public String getFinisherName() {
        return finisherName;
    }

    public String getRelationCust() {
        return relationCust;
    }

    public void setRelationCust(String relationCust) {
        this.relationCust = relationCust;
        String[] relationCusts = relationCust.split(";");
        String relationCustId = "";
        String relationCustName = "";
        for (int i = 0; i < relationCusts.length; i++){
            String[] items = relationCusts[i].split("-");
            if (items.length == 2){
                relationCustId += items[1];
                relationCustName += items[0];
            }
            if (i != relationCusts.length -1){
                relationCustId += ";";
                relationCustName += ";";
            }
        }
        this.relationCustId = relationCustId;
        this.relationCustName = relationCustName;
    }

    public String getRelationCustId() {
        return relationCustId;
    }

    public String getRelationCustName() {
        return relationCustName;
    }

    public String getNoticeCycle() {
        return noticeCycle;
    }

    public void setNoticeCycle(String noticeCycle) {
        this.noticeCycle = noticeCycle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSonTodoWorkId() {
        return sonTodoWorkId;
    }

    public void setSonTodoWorkId(String sonTodoWorkId) {
        this.sonTodoWorkId = sonTodoWorkId;
    }
}
