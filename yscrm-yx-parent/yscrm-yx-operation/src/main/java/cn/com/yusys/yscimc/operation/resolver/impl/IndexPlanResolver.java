package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.IndexPlanInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractIndexPlanResolver;
import cn.com.yusys.yusp.cm.indexplan.domain.CimpCmAssemblyAnalysis;
import cn.com.yusys.yusp.cm.indexplan.repository.mapper.CimpCmIndexPlanMapper;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 营销成效指标组件解析器
 * @author zhangyt12
 * @date 2021/12/15 18:21
 */
@Component
public class IndexPlanResolver extends AbstractIndexPlanResolver {
//    @Autowired
//    CimpCmIndexPlanService cimpCmIndexPlanService;
    @Autowired
    private CimpCmIndexPlanMapper indexPlanMapper;

    @Override
    public List<IndexPlanInfoVo> resolver(CimpCmNodeinfo nodeInfo) {
        // TODO 使用 nodeInfo 查询出该组件的信息并返回
        String nodeId = nodeInfo.getNodeId();
        List<IndexPlanInfoVo> indexPlanInfoVoList=new ArrayList<>();
        List<CimpCmAssemblyAnalysis> cimpCmAssemblyAnalyses = indexPlanMapper.targetQuery(nodeId);
        for (CimpCmAssemblyAnalysis cimpCmAssemblyAnalysi:cimpCmAssemblyAnalyses) {
            IndexPlanInfoVo indexPlanInfoVo = new IndexPlanInfoVo();
            indexPlanInfoVo.setAssemblyId(cimpCmAssemblyAnalysi.getAssemblyId());
            indexPlanInfoVo.setProductId(cimpCmAssemblyAnalysi.getProductId());
            indexPlanInfoVo.setIndexId(cimpCmAssemblyAnalysi.getIndexId());
            indexPlanInfoVo.setIndexName(cimpCmAssemblyAnalysi.getIndexName());
            indexPlanInfoVo.setObjType(cimpCmAssemblyAnalysi.getObjType());
            indexPlanInfoVo.setObjId(cimpCmAssemblyAnalysi.getObjId());
            if(cimpCmAssemblyAnalysi.getInitialValue()==null){
                indexPlanInfoVo.setInitialValue(new BigDecimal(0));
            }else {
                indexPlanInfoVo.setInitialValue(cimpCmAssemblyAnalysi.getInitialValue());
            }
            if (cimpCmAssemblyAnalysi.getTargetValue()==null){
                indexPlanInfoVo.setTargetValue(new BigDecimal(0));
            }else {
                indexPlanInfoVo.setTargetValue(cimpCmAssemblyAnalysi.getTargetValue());
            }
            indexPlanInfoVoList.add(indexPlanInfoVo);
        }
        return indexPlanInfoVoList;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.INDEX_PLAN.getComponentType();
    }
}
