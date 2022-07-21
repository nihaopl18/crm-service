package cn.com.yusys.yscimc.operation.process.channel;

import cn.com.yusys.yscimc.operation.domain.ActivityCustomerResultEntity;
import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;
import cn.com.yusys.yscimc.operation.process.ChannelProcessor;
import cn.com.yusys.yscimc.operation.service.ActivityCustomerResultService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Lenovo
 * @Data 2022/3/8 12:17
 */
public abstract class AbstractChannelProcessor implements ChannelProcessor {

    private final ActivityCustomerResultService resultService;

    public AbstractChannelProcessor(ActivityCustomerResultService resultService) {
        this.resultService = resultService;
    }

    /**
     * 保存渠道发送活动消息的结果
     * @param processedDataBo
     */
    public void saveResultThread(ProcessedDataBo processedDataBo) {
        new Thread(() -> {
            List<ActivityCustomerResultEntity> list = new ArrayList<>();
            List<MarketActionInfoVo> marketActionInfoVoList = processedDataBo.getMarketActionInfoVoList();
            for (MarketActionInfoVo marketActionInfoVo : marketActionInfoVoList) {
                ActivityCustomerResultEntity result = new ActivityCustomerResultEntity();
                result.setResultId(getUUID());
                CimpCmMarketplan planInfo = processedDataBo.getComponentDataBo().getTaskExecutor().getInitialData().getPlanInfo();
                result.setActivityId(planInfo.getTempId());
                result.setCustomerId(marketActionInfoVo.getCustomerInfoVo().getCustId());
                result.setCustomerName(marketActionInfoVo.getCustomerInfoVo().getCustName());
                result.setMarketMessage(marketActionInfoVo.getModelInfo());

                if (marketActionInfoVo.getProductInfoVo() == null) {
                    System.out.println(marketActionInfoVo);
                }

                String productId = marketActionInfoVo.getProductInfoVo() == null ? null : marketActionInfoVo.getProductInfoVo().getProductId();
                result.setProductId(productId == null ? "-" : productId);
                String productName = marketActionInfoVo.getProductInfoVo() == null ? null : marketActionInfoVo.getProductInfoVo().getProdName();
                result.setProductName(productName == null ? "无对应产品" : productName);
                result.setApplyId(marketActionInfoVo.getId());
                result.setApplyName(marketActionInfoVo.getModelName());
                result.setActionType(marketActionInfoVo.getApplyType());
                result.setChannelId(this.getType());
                result.setChannelName(this.getName());
                LocalDateTime time=LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                result.setSendTime(formatter.format(time));
                result.setResultType("send");
                list.add(result);
            }
            resultService.saveBatch(list);
        }).start();
    }

    private String getUUID() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    protected CharSequence errorMessage(String keyword, CustomerInfoVo customerInfoVo) {
        return "[当前客户-" + customerInfoVo.getCustId() + "-生成信息模板出错，没有 " + keyword + " 信息!]";
    }
}
