package cn.com.yusys.yscimc.operation.process.content;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.ContentInfoDto;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.process.ContentDataProcessor;
import cn.com.yusys.yscimc.operation.process.index.IndexPlanFlowProcessor;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 活动内容类组件数据解析器
 *      营销动作（短信模板）、素材、报名、分享、裂变
 * @author zhangyt12
 * @date 2021/12/13 16:10
 */
@Component
public class ContentFlowProcessor implements ComponentFlowProcessor {

    @Override
    public void process(MarketPlanTaskExecutor executor, ProcessedDataBo processedDataBo) {

        List<ContentDataProcessor> contentDataProcessorList = executor.getMarketPlanServiceExtend().getContentDataProcessorList();
        ContentInfoDto contentInfoDto = executor.getComponentDataBo().getContentInfoDto();
        List<ContentInfoVo> contentInfoVoList = contentInfoDto.getContentInfoVoList();

        /**
         * TODO 这里需要做如下判断：
         * 1、contentInfoVoList != null && contentDataProcessorList == null: content 组件信息无法处理，缺少 ContentDataProcessor
         * 2、contentInfoVoList == null：直接进入下个流程
         */

        // for 循环处理 contentInfoVoList 中所有内容相关的组件信息
        if (!CollectionUtils.isEmpty(contentInfoVoList)) {
            for (ContentDataProcessor contentDataProcessor : contentDataProcessorList) {
                contentDataProcessor.contentProcess(contentInfoVoList, processedDataBo);
            }
        }

        executor.processAndExecute(getNextFlow(executor.getMarketPlanServiceExtend()), processedDataBo);
    }

    @Override
    public ComponentFlowProcessor getNextFlow(MarketPlanServiceExtend serviceExtend) {
        return serviceExtend.getNextFlowProcessor(IndexPlanFlowProcessor.class);
    }
}
