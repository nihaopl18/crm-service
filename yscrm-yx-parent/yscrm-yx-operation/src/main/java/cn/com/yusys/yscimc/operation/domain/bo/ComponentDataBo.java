package cn.com.yusys.yscimc.operation.domain.bo;

import cn.com.yusys.yscimc.operation.domain.dto.*;
import cn.com.yusys.yscimc.operation.domain.vo.ChannelInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.rai.engine.data.domain.ActivityPo;

import java.util.List;

/**
 * 营销任务执行所需的所有数据
 * @author zhangyt12
 * @date 2021/12/7 19:44
 */
public class ComponentDataBo {

    private MarketPlanTaskExecutor taskExecutor;

    /**
     * 客户相关信息
     */
    private CustomerGroupInfoDto customerGroupInfoDto;
    /**
     * 产品相关信息
     */
    private ProductInfoDto productInfoDto;
    /**
     * 营销动作、素材、分享、报名、分裂 相关信息
     */
    private ContentInfoDto contentInfoDto;
    /**
     * 营销成效指标相关信息
     */
    private IndexPlanInfoDto indexPlanInfoDto;
    /**
     * 渠道类相关组件信息
     */
    private ChannelInfoDto channelInfoDto;
    /**
     *事件活动相关组件信息
     */
    private ActivityPo activityPo;

    public ComponentDataBo() {
    }

    public ComponentDataBo(MarketPlanTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public ActivityPo getActivityPo() {
        return activityPo;
    }

    public void setActivityPo(ActivityPo activityPo) {
        this.activityPo = activityPo;
    }

    public CustomerGroupInfoDto getCustomerInfoDto() {
        return customerGroupInfoDto;
    }

    public void setCustomerInfoDto(CustomerGroupInfoDto customerGroupInfoDto) {
        this.customerGroupInfoDto = customerGroupInfoDto;
    }

    public void addCustomerInfoDto(CustomerGroupInfoDto newInfoDto) {
        if (customerGroupInfoDto == null) {
            this.customerGroupInfoDto = newInfoDto;
        } else {
            customerGroupInfoDto.addCustomerCount(newInfoDto.getCustomerCount());
            customerGroupInfoDto.addCustomerGroupIdList(newInfoDto.getCustomerGroupIdList());
        }
    }

    public ProductInfoDto getProductInfoDto() {
        return productInfoDto;
    }

    public void setProductInfoDto(ProductInfoDto productInfoDto) {
        this.productInfoDto = productInfoDto;
    }

    public void setProductInfoDto(List<ProductInfoVo> voList) {
        if (productInfoDto == null) {
            productInfoDto = new ProductInfoDto();
        }
        productInfoDto.setProductInfoVoList(voList);
    }

    public ContentInfoDto getContentInfoDto() {
        return contentInfoDto;
    }

    public void addContentInfo(ContentInfoVo contentInfoVo) {
        if (contentInfoDto == null) {
            contentInfoDto = new ContentInfoDto();
        }
        contentInfoDto.addContentInfoVo(contentInfoVo);
    }

    public void addContentInfoList(List<ContentInfoVo> contentInfoVoList) {
        if (contentInfoDto == null) {
            contentInfoDto = new ContentInfoDto();
        }
        contentInfoDto.addContentInfoVoList(contentInfoVoList);
    }

    public void addContentInfoList(ContentInfoVo vo) {
        if (contentInfoDto == null) {
            contentInfoDto = new ContentInfoDto();
        }
        contentInfoDto.addContentInfoVo(vo);
    }

    public IndexPlanInfoDto getIndexPlanInfoDto() {
        return indexPlanInfoDto;
    }

    public void setIndexPlanInfoDto(IndexPlanInfoDto indexPlanInfoDto) {
        this.indexPlanInfoDto = indexPlanInfoDto;
    }

    public ChannelInfoDto getChannelInfoDto() {
        return channelInfoDto;
    }

    public void addChannelInfoDto(List<ChannelInfoVo> channelInfoVoList) {
        if (this.channelInfoDto == null) {
            this.channelInfoDto = new ChannelInfoDto();
        }
        channelInfoDto.addChannelInfoVoList(channelInfoVoList);
    }

    public MarketPlanTaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    @Override
    public String toString() {
        return "ComponentDataBo{" +
                "taskExecutor= 该值就不打印了" +
                ", customerGroupInfoDto=" + customerGroupInfoDto +
                ", productInfoDto=" + productInfoDto +
                ", contentInfoDto=" + contentInfoDto +
                ", indexPlanInfoDto=" + indexPlanInfoDto +
                ", channelInfoDto=" + channelInfoDto +
                ", activityPo=" + activityPo +
                '}';
    }
}
