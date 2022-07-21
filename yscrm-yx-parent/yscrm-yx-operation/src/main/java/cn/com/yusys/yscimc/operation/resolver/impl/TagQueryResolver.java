package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.cust.group.service.CimpCCustgroupCustService;
import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.GenericCustomerGroupInfoVo;
import cn.com.yusys.yscimc.operation.resolver.pre.AbstractGenericCustomerResolver;
import cn.com.yusys.yusp.cm.cust.service.CimFTagCustTagsService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.service.CimpCmNodesDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 标签查询组件解析器
 * 泛型：所选标签 id 集合
 * @author zhangyt12
 * @date 2021/12/15 18:21
 */
@Component
public class TagQueryResolver extends AbstractGenericCustomerResolver {

    @Autowired
    private CimFTagCustTagsService tagCustTagsService;
    @Autowired
    private CimpCmNodesDisplayService nodesDisplayService;
    public TagQueryResolver(CimpCCustgroupCustService customerGroupService) {
        super(customerGroupService);
    }

    @Override
    public GenericCustomerGroupInfoVo resolver(CimpCmNodeinfo nodeInfo) {
        // TODO 使用 nodeInfo 获取标签信息，存到 GenericCustomerGroupInfoVo 中
        List<Map<String, Object>> tagno = nodesDisplayService.getTagno(nodeInfo.getNodeId());
        if (null == tagno || 0 == tagno.size()){
            return null;
        }
        List<String> list = new ArrayList<>();
        tagno.forEach(vo -> {
            list.add(vo.get("formInVal").toString());
        });
        List<String> custIds = tagCustTagsService.getListByTags(list);
        GenericCustomerGroupInfoVo vo = new GenericCustomerGroupInfoVo(tagno.get(0).get("condition").toString(),custIds.size(),custIds);
        return vo;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.TAG_QUERY.getComponentType();
    }
}
