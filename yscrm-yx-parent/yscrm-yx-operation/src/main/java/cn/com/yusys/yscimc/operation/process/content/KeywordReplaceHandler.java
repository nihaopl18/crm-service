package cn.com.yusys.yscimc.operation.process.content;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;

import java.util.List;

/**
 * 关键字替换处理器
 * @author zhangyt12
 * @date 2021/12/23 17:50
 */
public interface KeywordReplaceHandler {

    List<MarketActionInfoVo> keywordHandler(List<String> keywordList, ProcessedDataBo processedDataBo, List<MarketActionInfoVo> marketActionInfoVo);

    Class<?> supportType();
}
