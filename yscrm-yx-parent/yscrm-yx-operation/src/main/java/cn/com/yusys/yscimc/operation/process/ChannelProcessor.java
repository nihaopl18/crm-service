package cn.com.yusys.yscimc.operation.process;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.MarketPlanResultDto;

/**
 * 渠道组件执行器接口
 * 所有渠道组件实现该接口
 *      短信、手机银行、呼叫中心
 *      ... ...
 * @author zhangyt12
 * @date 2021/12/14 18:13
 */
public interface ChannelProcessor {

    MarketPlanResultDto execute(ProcessedDataBo processedDataBo);

    /**
     * 获取当前渠道处理器的组件类型
     * @return
     */
    String getType();

    /**
     * 获取当前渠道处理器的组件名称
     * @return
     */
    String getName();
}
