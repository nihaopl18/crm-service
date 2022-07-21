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
public class ActivityEventValidator implements ActivityPreValidator {

    @Override
    public boolean support(MarketPlanValidatorBo validatorBo) {
        return MarketPlanInfoEnum.MARKET_PLAN_TYPE_EVENT.getCode().equals(validatorBo.getMarketPlan().getActivityType());
    }

    @Override
    public void preVerifyActivity(MarketPlanValidatorBo validatorBo) {
        List<CimpCmNodeinfo> nodeList = validatorBo.getNodesList();
        Set<String> assemblyIdList = nodeList.stream().map(CimpCmNodeinfo::getAssemblyId).collect(Collectors.toSet());
        // 事件类营销所需最低限度：事件组件 + 渠道组件
        validatorBo.setControl(
            assemblyIdList.contains(ComponentTypeEnum.MOBILE_BANK.getComponentType()) &&
            assemblyIdList.contains(ComponentTypeEnum.PRODUCT_CHOICE.getComponentType()) &&
            isChannelType(assemblyIdList)
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
