package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MobileBankInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractContentResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 渠道类型组件：手机银行组件解析器
 * @author zhangyt12
 * @date 2021/12/15 18:21
 */
@Component
public class MobileBankResolver extends AbstractContentResolver {

    @Autowired
    private CimpCmMarketPlanService cmMarketPlanService;

    @Override
    public List<ContentInfoVo> resolver(CimpCmNodeinfo nodeInfo) {
        List<ContentInfoVo> vos = new ArrayList<>();

        List<Map<String, Object>> maps = cmMarketPlanService.getmktPositContent(nodeInfo.getNodeId());
        maps.forEach(vo -> {
            MobileBankInfoVo mobileBankInfoVo = JSONObject.parseObject(JSONObject.toJSONString(vo), MobileBankInfoVo.class);
            vos.add(mobileBankInfoVo);
        });
        return vos;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.MOBILE_BANK.getComponentType();
    }
}
