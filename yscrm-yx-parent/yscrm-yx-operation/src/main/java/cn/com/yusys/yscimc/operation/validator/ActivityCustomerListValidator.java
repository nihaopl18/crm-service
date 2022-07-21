package cn.com.yusys.yscimc.operation.validator;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.constant.MarketPlanInfoEnum;
import cn.com.yusys.yscimc.operation.domain.bo.MarketPlanValidatorBo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 客户名单类活动校验器
 */
@Component
public class ActivityCustomerListValidator implements ActivityPreValidator{

    @Override
    public boolean support(MarketPlanValidatorBo validatorBo) {
        return MarketPlanInfoEnum.MARKET_PLAN_TYPE_LIST.getCode().equals(validatorBo.getMarketPlan().getActivityType());
    }

    @Override
    public void preVerifyActivity(MarketPlanValidatorBo validatorBo) {
        List<CimpCmNodeinfo> nodeList = validatorBo.getNodesList();
        Set<String> assemblyIdList = nodeList.stream().map(CimpCmNodeinfo::getAssemblyId).collect(Collectors.toSet());
        // 名单制营销组件所需最低限度：客户查询组件 + 产品组件 + 营销动作 + 渠道类组件
        validatorBo.setControl(
            assemblyIdList.contains(ComponentTypeEnum.PRODUCT_CHOICE.getComponentType()) &&
            assemblyIdList.contains(ComponentTypeEnum.MARKETING_ACTION.getComponentType()) &&
            isChannelType(assemblyIdList) &&
            isCustomerType(assemblyIdList)
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
