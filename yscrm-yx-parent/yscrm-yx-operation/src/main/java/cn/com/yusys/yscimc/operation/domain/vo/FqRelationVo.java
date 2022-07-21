package cn.com.yusys.yscimc.operation.domain.vo;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2021/12/30 13:38
 */
public class FqRelationVo {
    private String joinLeftTable;
    private String joinLeftCol;
    private String leftColName;
    private String leftTableName;
    private String joinRightTable;
    private String joinRightCol;
    private String rightColName;
    private String rightTableName;

    public String getJoinLeftTable() {
        return joinLeftTable;
    }

    public void setJoinLeftTable(String joinLeftTable) {
        this.joinLeftTable = joinLeftTable;
    }

    public String getJoinLeftCol() {
        return joinLeftCol;
    }

    public void setJoinLeftCol(String joinLeftCol) {
        this.joinLeftCol = joinLeftCol;
    }

    public String getLeftColName() {
        return leftColName;
    }

    public void setLeftColName(String leftColName) {
        this.leftColName = leftColName;
    }

    public String getLeftTableName() {
        return leftTableName;
    }

    public void setLeftTableName(String leftTableName) {
        this.leftTableName = leftTableName;
    }

    public String getJoinRightTable() {
        return joinRightTable;
    }

    public void setJoinRightTable(String joinRightTable) {
        this.joinRightTable = joinRightTable;
    }

    public String getJoinRightCol() {
        return joinRightCol;
    }

    public void setJoinRightCol(String joinRightCol) {
        this.joinRightCol = joinRightCol;
    }

    public String getRightColName() {
        return rightColName;
    }

    public void setRightColName(String rightColName) {
        this.rightColName = rightColName;
    }

    public String getRightTableName() {
        return rightTableName;
    }

    public void setRightTableName(String rightTableName) {
        this.rightTableName = rightTableName;
    }
}
