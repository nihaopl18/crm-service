package cn.com.yusys.climp.score.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class FileVO implements Serializable {

    private static final long serialVersionUID = 1493642054106877440L;

    /**
     * 文件id
     */
    @ApiModelProperty(value = "文件id")
    private String fileId;
    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    /**
     * 流水号
     */
    @ApiModelProperty(value = "流水号")
    private String busNo;

    private String isCover;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

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

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getIsCover() {
        return isCover;
    }

    public void setIsCover(String isCover) {
        this.isCover = isCover;
    }
}
