package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractProductResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.processparam.repository.mapper.CmFRcNodeInputMapper;
import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProductManagerInfo;
import cn.com.yusys.yusp.cm.productmanager.repository.mapper.CmFRcProductManagerMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 产品组件解析器
 * @author zhangyt12
 * @date 2021/12/15 20:26
 */
@Component
public class ProductChoiceResolver extends AbstractProductResolver {
    @Autowired
    private CmFRcNodeInputMapper cmFRcNodeInputMapper;
    @Autowired
    private CmFRcProductManagerMapper cmFRcProductManagerMapper;

    @Override
    public List<ProductInfoVo> resolver(CimpCmNodeinfo nodeInfo) {
        // TODO 查询出产品信息
        String nodeId = nodeInfo.getNodeId();
        //查询出该节点下的产品id,如yyy,yyy002,yyy0022,test_wyy_005,test_wyy_006,test_wyy_007
        List<Map<String, Object>> list = cmFRcNodeInputMapper.getList(nodeId);
        List<ProductInfoVo> productInfoVoList=new ArrayList<>();
        String formOutVal = (String)list.get(0).get("formOutVal");
        String formInVal = (String)list.get(0).get("formInVal");
        //根据,分割成数组
        String[] splitArray = formInVal.split(",");
        //根据productId查询产品信息
        for (String productId:splitArray) {
            ProductInfoVo productInfoVo = new ProductInfoVo();
            CmFRcProductManagerInfo proInfo = cmFRcProductManagerMapper.getProInfo(productId);
            BeanUtils.copyProperties(proInfo,productInfoVo);
            productInfoVoList.add(productInfoVo);
        }
        return productInfoVoList;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.PRODUCT_CHOICE.getComponentType();
    }
}
