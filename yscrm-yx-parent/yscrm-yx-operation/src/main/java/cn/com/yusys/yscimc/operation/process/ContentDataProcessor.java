package cn.com.yusys.yscimc.operation.process;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;

import java.util.List;

public interface ContentDataProcessor {
    /**
     *
     * @param contentInfoVoList 当前处理器需要处理的数据
     * @param processedDataBo 之前的流程已经处理好的数据
     */
    void contentProcess(List<ContentInfoVo> contentInfoVoList, ProcessedDataBo processedDataBo);

    boolean support(ContentInfoVo contentInfoVo);
}
