package cn.com.yusys.yscimc.operation.process.channel;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.MarketPlanResultDto;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MobileBankInfoVo;
import cn.com.yusys.yscimc.operation.service.ActivityCustomerResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 短信渠道数据处理器
 * @Author zhangyt12
 * @Data 2022/1/7 14:33
 */
@Component
public class MobileBankProcessor extends AbstractChannelProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MobileBankProcessor.class);

    public MobileBankProcessor(ActivityCustomerResultService resultService) {
        super(resultService);
    }

    @Override
    public MarketPlanResultDto execute(ProcessedDataBo processedDataBo) {
        //手机银行组件解析栏位内容
        List<ContentInfoVo> contentInfoVoList = processedDataBo.getComponentDataBo().getContentInfoDto().getContentInfoVoList();
        List<MobileBankInfoVo> mobileBankInfoVoList = new ArrayList<>(contentInfoVoList.size());
        for (ContentInfoVo contentInfoVo : contentInfoVoList) {
            if (this.support(contentInfoVo)) {
                MobileBankInfoVo mobileBankInfoVo = (MobileBankInfoVo) contentInfoVo;
                mobileBankInfoVoList.add(mobileBankInfoVo);
            }
        }
        this.process(mobileBankInfoVoList);
        // TODO MarketPlanResultDto 中需要添加属性，现在一个属性都没有
        return new MarketPlanResultDto();
    }

    public void process(List<MobileBankInfoVo> mobileBankInfoVoList) {
        for (MobileBankInfoVo mobileBankInfoVo : mobileBankInfoVoList) {
            if ("2".equals(mobileBankInfoVo.getDisplayType())) {
                logger.info("渠道：【手机银行】，素材类型：【文案】，栏位：【{}】", mobileBankInfoVo.getMktPositCode());
            } else {
                logger.info("渠道：【手机银行】，素材类型：【图片 / 视频】，栏位：【{}】，保存 url 地址：【{}】", mobileBankInfoVo.getMktPositCode(), mobileBankInfoVo.getActivityStartPic());

            }
        }
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.MOBILE_BANK.getComponentType();
    }

    @Override
    public String getName() {
        return ComponentTypeEnum.MOBILE_BANK.getComponentName();
    }

    public boolean support(ContentInfoVo contentInfoVo) {
        return contentInfoVo instanceof MobileBankInfoVo;
    }
}
