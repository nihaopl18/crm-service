package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.cust.group.service.CimpCCustgroupCustService;
import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.FqRelationVo;
import cn.com.yusys.yscimc.operation.domain.vo.GenericCustomerGroupInfoVo;
import cn.com.yusys.yscimc.operation.resolver.pre.AbstractGenericCustomerResolver;
import cn.com.yusys.yscimc.operation.service.impl.OcrmFCiFqDbcolService;
import cn.com.yusys.yscimc.operation.service.impl.OcrmFCiFqRelationService;
import cn.com.yusys.yscimc.operation.service.impl.OcrmFCiFqScolService;
import cn.com.yusys.yscimc.operation.util.FlexibleQueryUtils;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.service.CimpCmNodesDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 灵活查询组件解析器
 * TODO 该灵活查询组件查询回的组件信息需要定义类型，将 Object 替换掉
 *
 * @Author Lenovo
 * @Data 2021/12/15 12:09
 */
@Component
public class FlexibleQueryResolver extends AbstractGenericCustomerResolver {

    @Autowired
    private CimpCmNodesDisplayService cmNodesDisplayService;
    @Autowired
    private OcrmFCiFqScolService ciFqScolService;
    @Autowired
    private OcrmFCiFqDbcolService ciFqDbcolService;
    @Autowired
    private OcrmFCiFqRelationService ciFqRelationService;

    public FlexibleQueryResolver(CimpCCustgroupCustService customerGroupService) {
        super(customerGroupService);
    }

    /**
     * 获取表之间关系
     *
     * @param leftTable
     * @param rightTable
     * @param list
     * @return
     */
    private FqRelationVo getTableRelation(String leftTable, String rightTable, List<FqRelationVo> list) {
        for (FqRelationVo vo:list
             ) {
            if (leftTable.equals(vo.getLeftTableName()) && rightTable.equals(vo.getRightTableName())) {
                return vo;
            }
        }
        return null;
    }

    @Override
    public GenericCustomerGroupInfoVo resolver(CimpCmNodeinfo nodeInfo) {
        // TODO 使用 nodeInfo 获取标签信息，存到 GenericCustomerGroupInfoVo 中
        List<Map<String, Object>> tagno = cmNodesDisplayService.getTagno(nodeInfo.getNodeId());
        List<Map<String, Object>> list = ciFqScolService.getScolAndDbcol(nodeInfo.getNodeId());
        Set<String> set = new HashSet<>();

        Map<String, String> maps = new HashMap<>();

        String majorTable = "ACIM_F_CI_CUSTOMER";
        String majorAlias = "allCust";
        String majorField = "cust_id";
        set.add(majorTable);
        maps.put(majorTable, majorAlias);
        list.forEach(vo -> {
            set.add(vo.get("dbtableName").toString());
            maps.put(vo.get("dbtableName").toString(), vo.get("alias").toString());
        });
        set.remove(majorTable);
        StringBuffer sql =
                new StringBuffer("select distinct " + maps.get(majorTable) + "." + majorField + " from "
                        + majorTable + " " + maps.get(majorTable));

        List<FqRelationVo> fqRelationVo = ciFqRelationService.getFqRelationVo();
        ArrayList<String> strings = new ArrayList<>(set);
        for (int i = 0; i < strings.size(); i++) {

            FqRelationVo tableRelation = getTableRelation(majorTable, strings.get(i), fqRelationVo);
            if (null != tableRelation) {
                sql.append(" left join " + strings.get(i) + " " + maps.get(strings.get(i)) + " on "
                        + maps.get(majorTable) + "." + tableRelation.getLeftColName() + " = " + maps.get(strings.get(i)) + "." + tableRelation.getRightColName());
            }
//            sql.append(" left join " + strings.get(i) + " " + maps.get(strings.get(i)) + " on "
//                    + maps.get(strings.get(i)) + "." + majorField + " = " + maps.get(strings.get(i - 1)) + "." + majorField);
        }
        sql.append(" where ");
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            if (i == 0) {
                String conditonString = FlexibleQueryUtils.getConditonString(map.get("ssColOp").toString(), map.get("ssColValue").toString(), map.get("colType").toString());
                sql.append(map.get("alias")+"."+map.get("colNameE") + " " + conditonString);
            } else {
                String conditonString = FlexibleQueryUtils.getConditonString(map.get("ssColOp").toString(), map.get("ssColValue").toString(), map.get("colType").toString());
                sql.append(" " + map.get("ssColGjoin") + " " + map.get("alias")+"."+map.get("colNameE") + " " + conditonString);
            }
        }
        List<String> custIds = ciFqDbcolService.getCustIdBySql(sql.toString());
        GenericCustomerGroupInfoVo vo = new GenericCustomerGroupInfoVo(tagno.get(0)
                .get("condition").toString(), custIds.size(), custIds);
        return vo;
    }


    @Override
    public String getType() {
        return ComponentTypeEnum.FLEXIBLE_QUERY.getComponentType();
    }
}
