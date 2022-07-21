package cn.com.yusys.yscimc.operation.resolver;

import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.IndexPlanInfoDto;
import cn.com.yusys.yscimc.operation.domain.vo.IndexPlanInfoVo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;

import java.util.List;

/**
 * 营销成效指标虚构解析器
 * @author zhangyt12
 * @date 2021/12/15 10:05
 */
public abstract class AbstractIndexPlanResolver implements ComponentInfoResolver {

    @Override
    public void componentResolver(CimpCmNodeinfo nodeInfo, ComponentDataBo componentDataBo) {
        componentDataBo.setIndexPlanInfoDto(new IndexPlanInfoDto().setIndexPlanInfoVoList(this.resolver(nodeInfo)));
    }

    public abstract List<IndexPlanInfoVo> resolver(CimpCmNodeinfo nodeInfo);
}
