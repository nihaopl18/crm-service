package cn.com.yusys.yscrm.info.workreport.domain;

/**
 * 
 * 表格内容信息
 * <p>
 * 表格类每个单元格信息
 * </p>
 * @author zhangxs4
 * @since jdk1.7
 * 2017年3月21日
 *
 */

public class CellInfo {
    
    /**
     * 内容:默认为空
     */
    private String content = "";
    /**
     * 跨列:默认跨1列
     */
    private int colSpan = 1;
    /**
     * 跨行:默认跨1行
     */
    private int rowSpan = 1;
    
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public int getColSpan() {
        return colSpan;
    }
    public void setColSpan(int colSpan) {
        this.colSpan = colSpan;
    }
    public int getRowSpan() {
        return rowSpan;
    }
    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }
    public CellInfo() {
    }
    public CellInfo(String content, int rowSpan, int colSpan) {
        super();
        this.content = content;
        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
    }
    public CellInfo(String content) {
        super();
        this.content = content;
    }
}
