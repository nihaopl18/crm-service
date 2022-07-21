package cn.com.yusys.yscimc.operation.process.channel;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.MarketPlanResultDto;
import cn.com.yusys.yscimc.operation.domain.vo.ChannelInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ShortMessageInfoVo;
import cn.com.yusys.yscimc.operation.service.ActivityCustomerResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;

/**
 * 短信渠道数据处理器
 * @Author zhangyt12
 * @Data 2022/1/7 14:33
 */
@Component
public class ShortMessageProcessor extends AbstractChannelProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MobileBankProcessor.class);

    private static final String FILE_PATH = "D:\\localDisk\\";

    private static final String PREFIX = "ShortMessage-";

    private static final String SUFFIX = ".txt";

    private static final String message = "客户名称：[CustomerName], 手机号：[PhoneNumber], 话术模板：[template], 发送时间段：[time] \n";

    private static final String CUSTOMER_NAME = "CustomerName";
    private static final String PHONE_NUMBER = "PhoneNumber";
    private static final String TEMPLATE = "template";
    private static final String TIME = "time";

    public ShortMessageProcessor(ActivityCustomerResultService resultService) {
        super(resultService);
    }

    @Override
    public MarketPlanResultDto execute(ProcessedDataBo processedDataBo) {
        FileChannel fileChannel = null;
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
            String fileName = processedDataBo.getComponentDataBo().getTaskExecutor().getInitialData().getPlanInfo().getTempId() + "-" + new Date().getTime();
            fileChannel = FileChannel.open(Paths.get(FILE_PATH + PREFIX + fileName + SUFFIX), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
            List<MarketActionInfoVo> marketActionInfoVoList = processedDataBo.getMarketActionInfoVoList();
            ShortMessageInfoVo shortMessageInfoVo = null;
            List<ChannelInfoVo> channelInfoVoList = processedDataBo.getComponentDataBo().getChannelInfoDto().getChannelInfoVoList();
            for (ChannelInfoVo channelInfoVo : channelInfoVoList) {
                if (channelInfoVo instanceof ShortMessageInfoVo) {
                    shortMessageInfoVo = (ShortMessageInfoVo) channelInfoVo;
                }
            }
            if (!CollectionUtils.isEmpty(marketActionInfoVoList)) {
                for (MarketActionInfoVo marketActionInfoVo : marketActionInfoVoList) {
                    CustomerInfoVo customerInfoVo = marketActionInfoVo.getCustomerInfoVo();
                    String replaceMessage = message
                            .replace(CUSTOMER_NAME, customerInfoVo.getCustName() != null ? customerInfoVo.getCustName() : this.errorMessage(CUSTOMER_NAME, customerInfoVo))
                            .replace(PHONE_NUMBER, customerInfoVo.getContactNumber() != null ? customerInfoVo.getContactNumber() : this.errorMessage(PHONE_NUMBER, customerInfoVo))
                            .replace(TEMPLATE, marketActionInfoVo.getModelInfo())
                            .replace(TIME, shortMessageInfoVo != null ? shortMessageInfoVo.getTimeInterval() : this.errorMessage(TIME, customerInfoVo));
                    logger.info("发送的信息：[{}]", replaceMessage);
                    if (byteBuffer.remaining() < replaceMessage.getBytes().length) {
                        byteBuffer.flip();
                        fileChannel.write(byteBuffer);
                        byteBuffer.clear();
                    }
                    byteBuffer.put(replaceMessage.getBytes());
                }
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 这句最后执行，用于异步保存活动执行结果；
        this.saveResultThread(processedDataBo);

        // TODO MarketPlanResultDto 中需要添加属性，现在一个属性都没有
        return new MarketPlanResultDto();
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.SHORT_MESSAGE.getComponentType();
    }

    @Override
    public String getName() {
        return ComponentTypeEnum.SHORT_MESSAGE.getComponentName();
    }
}
