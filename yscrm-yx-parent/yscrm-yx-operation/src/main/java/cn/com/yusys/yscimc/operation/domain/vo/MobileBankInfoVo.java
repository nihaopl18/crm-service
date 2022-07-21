package cn.com.yusys.yscimc.operation.domain.vo;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;

import java.time.LocalDateTime;

/**
 * 手机银行组件返回数据
 * @author zhangyt12
 *
 * @date 2021/12/24 15:48
 */
public class MobileBankInfoVo implements ContentInfoVo{
    /**
     * 素材类型
     * 1. 图片
     * 2. 文案
     * 4. 视频
     */
    private String displayType;
    /**
     * 素材 id
     */
    private String ctNodeId;
    /**
     * 组件 id
     */
    private String assamlyId;
    /**
     * 起始时间
     */
    private LocalDateTime vsStartDate;
    /**
     * 结束时间
     */
    private LocalDateTime vsEndDate;
    /**
     * 渠道栏位
     */
    private String mktPositCode;

    /**
     * 文档内容
     * 如果是 4, 从这里获取数据
     */
    private String detailContent;

    /**
     * 图片地址
     * 如果是 1 或者 4, 使用这个字段
     */
    private String activityStartPic;

    /**
     * 营销方式组件的nodeId
     */
    private String marketTypeId;

    public String getMarketTypeId() {
        return marketTypeId;
    }

    public void setMarketTypeId(String marketTypeId) {
        this.marketTypeId = marketTypeId;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getCtNodeId() {
        return ctNodeId;
    }

    public void setCtNodeId(String ctNodeId) {
        this.ctNodeId = ctNodeId;
    }

    public String getAssamlyId() {
        return assamlyId;
    }

    public void setAssamlyId(String assamlyId) {
        this.assamlyId = assamlyId;
    }

    public LocalDateTime getVsStartDate() {
        return vsStartDate;
    }

    public void setVsStartDate(LocalDateTime vsStartDate) {
        this.vsStartDate = vsStartDate;
    }

    public LocalDateTime getVsEndDate() {
        return vsEndDate;
    }

    public void setVsEndDate(LocalDateTime vsEndDate) {
        this.vsEndDate = vsEndDate;
    }

    public String getMktPositCode() {
        return mktPositCode;
    }

    public void setMktPositCode(String mktPositCode) {
        this.mktPositCode = mktPositCode;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public String getActivityStartPic() {
        return activityStartPic;
    }

    public void setActivityStartPic(String activityStartPic) {
        this.activityStartPic = activityStartPic;
    }

    @Override
    public String getName() {
        return ComponentTypeEnum.MOBILE_BANK.getComponentName();
    }
}
