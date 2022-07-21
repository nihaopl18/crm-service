package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.vo;

/** 
 * @ClassName: ExcelObjVo 
 * @Description: Excel基本信息VO
 * @author: chenhx
 * @date 2016年1月14日 上午11:25:32 
 * @version V3.3
 *  
 */ 
public class ExcelObjVo {

    /** fileName: Excel文件名称 **/
    private String fileName;

    /** filePath:Excel文件路径 **/
    private String filePath;

    /** title:Excel表标题 **/
    private String title;

    /** fixedHeader:Excel 固定头部 **/
    private String fixedHeader;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFixedHeader() {
        return fixedHeader;
    }

    public void setFixedHeader(String fixedHeader) {
        this.fixedHeader = fixedHeader;
    }

    public ExcelObjVo() {
      
    }
}
