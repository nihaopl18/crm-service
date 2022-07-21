package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.resolver.pre.AbstractPreMarketActionResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesPresentation;
import cn.com.yusys.yusp.cm.market.service.PresentationFormService;
import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysTypeInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.service.CmFRcSysTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 营销动作组件解析器
 * @author zhangyt12
 * @date 2021/12/15 18:21
 */
@Component
public class MarketActionResolver extends AbstractPreMarketActionResolver {
    @Autowired
    private PresentationFormService presentationFormService;
    @Autowired
    private CmFRcSysTypeService cmFRcSysTypeService;

    @Override
    public List<CmFRcSysTypeInfo> getMessageTemplate(CimpCmNodeinfo nodeInfo) {
        List<CmFRcSysTypeInfo> cmFRcSysTypeInfoList=new ArrayList<>();
        String nodeId = nodeInfo.getNodeId();
        List<CimpCmNodesPresentation> preList = presentationFormService.getPre(nodeId);
        for (CimpCmNodesPresentation cimpCmNodesPresentation : preList) {
            String formOperationVal = cimpCmNodesPresentation.getFormOperationVal();
            String[] split = formOperationVal.split(",");
            for (String modelId : split) {
                List<CmFRcSysTypeInfo> listCmFRcSysTypeInfo = cmFRcSysTypeService.getListByNodeId(modelId);
                cmFRcSysTypeInfoList.addAll(listCmFRcSysTypeInfo);
            }
        }
        return cmFRcSysTypeInfoList;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.MARKETING_ACTION.getComponentType();
    }
}
