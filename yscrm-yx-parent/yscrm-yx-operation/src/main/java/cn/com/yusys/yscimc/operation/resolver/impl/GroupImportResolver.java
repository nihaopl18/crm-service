package cn.com.yusys.yscimc.operation.resolver.impl;


import cn.com.yusys.yscimc.cust.group.service.CimpCCustgroupCustService;
import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.GenericCustomerGroupInfoVo;
import cn.com.yusys.yscimc.operation.resolver.pre.AbstractGenericCustomerResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodeInputInfo;
import cn.com.yusys.yusp.cm.processparam.service.CmFRcNodeInputService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 客户群导入组件解析器
 * 泛型：客户群 id 集合
 * @author zhangyt12
 * @date 2021/12/15 18:22
 */
@Component
public class GroupImportResolver extends AbstractGenericCustomerResolver {

    @Autowired
    private CmFRcNodeInputService rcNodeInputService;

    @Autowired
    private CimpCCustgroupCustService custgroupCustService;
    public GroupImportResolver(CimpCCustgroupCustService customerGroupService) {
        super(customerGroupService);
    }

    @Override
    public GenericCustomerGroupInfoVo resolver(CimpCmNodeinfo nodeInfo) {

        QueryModel queryModel = new QueryModel();
        queryModel.addCondition("nodeId",nodeInfo.getNodeId());
        CmFRcNodeInputInfo inputInfo = rcNodeInputService.checknodeid(queryModel);
        if (null == inputInfo){
            return null;
        }
        String custGroupId = inputInfo.getFormInVal();
        List<String> custIds = custgroupCustService.getCustIdsByGroupId(custGroupId);

        GenericCustomerGroupInfoVo vo = new GenericCustomerGroupInfoVo(custGroupId,custIds.size(),custIds);
        return vo;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.GROUP_IMPORT.getComponentType();
    }
}
