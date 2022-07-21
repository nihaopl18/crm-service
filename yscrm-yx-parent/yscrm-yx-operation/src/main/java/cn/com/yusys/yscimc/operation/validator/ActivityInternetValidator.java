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
public class ActivityInternetValidator implements ActivityPreValidator{

    @Override
    public boolean support(MarketPlanValidatorBo validatorBo) {
        return MarketPlanInfoEnum.MARKET_PLAN_TYPE_INTERNET.getCode().equals(validatorBo.getMarketPlan().getActivityType());
    }

    @Override
    public void preVerifyActivity(MarketPlanValidatorBo validatorBo) {
        List<CimpCmNodeinfo> nodeList = validatorBo.getNodesList();
        Set<String> assemblyIdList = nodeList.stream().map(CimpCmNodeinfo::getAssemblyId).collect(Collectors.toSet());
        // 互联网营销所需最低限度：手机银行 + 产品组件
        validatorBo.setControl(
            assemblyIdList.contains(ComponentTypeEnum.MOBILE_BANK.getComponentType()) &&
            assemblyIdList.contains(ComponentTypeEnum.PRODUCT_CHOICE.getComponentType())
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
