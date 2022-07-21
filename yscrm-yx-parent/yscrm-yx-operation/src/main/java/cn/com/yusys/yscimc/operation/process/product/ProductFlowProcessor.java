package cn.com.yusys.yscimc.operation.process.product;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.ProductInfoDto;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.process.content.ContentFlowProcessor;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 产品数据流程处理器
 * @author zhangyt12
 * @date 2021/12/24 11:29
 */
@Component("productFlowProcessor")
public class ProductFlowProcessor implements ComponentFlowProcessor {

    @Override
    public void process(MarketPlanTaskExecutor executor, ProcessedDataBo processedDataBo) {

        ProductInfoDto productInfoDto = executor.getComponentDataBo().getProductInfoDto();
        List<ProductInfoVo> productInfoVoList = productInfoDto.getProductInfoVoList();

        // TODO 对产品组件查询的信息进行处理，并保存到 processedDataBo 当中
        processedDataBo.setProductInfoVoList(productInfoVoList);
        // 执行下一个流程
        executor.processAndExecute(getNextFlow(executor.getMarketPlanServiceExtend()), processedDataBo);
    }

    @Override
    public ComponentFlowProcessor getNextFlow(MarketPlanServiceExtend serviceExtend) {
        return serviceExtend.getNextFlowProcessor(ContentFlowProcessor.class);
    }
}
