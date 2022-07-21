package cn.com.yusys.yusp.cm.market.vo;


import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFissionImg;
import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiFissionReward;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;


public class YscimcFMkActiFissionVo {

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String id;

    /**
     * 节点编号
     */
    @ApiModelProperty(value = "节点编号")
    private String nodeId;

    /**
     * 裂变方式
     */
    @ApiModelProperty(value = "裂变方式")
    private String fissionMode;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String fissionTitle;

    /**
     * 开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creatorId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 最新变更用户
     */
    @ApiModelProperty(value = "最新变更用户")
    private String lastChgUsr;

    /**
     * 最新变更时间
     */
    @ApiModelProperty(value = "最新变更时间")
    private Date lastChgDt;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String imageurl;

    /**
     * 图片尺寸
     */
    @ApiModelProperty(value = "图片尺寸")
    private String imageSize;

    /**
     * 活动页面
     */
    @ApiModelProperty(value = "活动页面")
    private String actHtml;

    private List<YscimcFMkActiFissionReward> rewards;

    private List<YscimcFMkActiFissionImg> images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getFissionMode() {
        return fissionMode;
    }

    public void setFissionMode(String fissionMode) {
        this.fissionMode = fissionMode;
    }

    public String getFissionTitle() {
        return fissionTitle;
    }

    public void setFissionTitle(String fissionTitle) {
        this.fissionTitle = fissionTitle;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastChgUsr() {
        return lastChgUsr;
    }

    public void setLastChgUsr(String lastChgUsr) {
        this.lastChgUsr = lastChgUsr;
    }

    public Date getLastChgDt() {
        return lastChgDt;
    }

    public void setLastChgDt(Date lastChgDt) {
        this.lastChgDt = lastChgDt;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getActHtml() {
        return actHtml;
    }

    public void setActHtml(String actHtml) {
        this.actHtml = actHtml;
    }

    public List<YscimcFMkActiFissionReward> getRewards() {
        return rewards;
    }

    public void setRewards(List<YscimcFMkActiFissionReward> rewards) {
        this.rewards = rewards;
    }

    public List<YscimcFMkActiFissionImg> getImages() {
        return images;
    }

    public void setImages(List<YscimcFMkActiFissionImg> images) {
        this.images = images;
    }
}
