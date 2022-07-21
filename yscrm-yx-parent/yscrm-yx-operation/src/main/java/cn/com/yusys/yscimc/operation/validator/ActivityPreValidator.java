package cn.com.yusys.yscimc.operation.validator;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.bo.MarketPlanValidatorBo;
import org.springframework.core.Ordered;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 活动执行前置校验器
 */
public interface ActivityPreValidator extends Ordered {

    /**
     * 当前活动是否执行该校验器
     */
    boolean support(MarketPlanValidatorBo validatorBo);

    /**
     * 校验活动配置是否合理的方法
     * 名单制场景：客户查询组件 + 产品组件 + 营销动作组件 + 渠道
     * 互联网场景：营销方式 + 渠道
     * 事件类场景：事件组件 + 渠道
     */
    void preVerifyActivity(MarketPlanValidatorBo validatorBo);

    /**
     * 校验传入类型是否存在渠道组件
     * @param typeList
     * @return
     */
    default boolean isChannelType(Set<String> typeList) {
        List<ComponentTypeEnum> channelTypeList = new ArrayList<>();
        channelTypeList.add(ComponentTypeEnum.MOBILE_BANK);
        channelTypeList.add(ComponentTypeEnum.SHORT_MESSAGE);
        channelTypeList.add(ComponentTypeEnum.WE_CHAT);

        for (ComponentTypeEnum componentTypeEnum : channelTypeList) {
            if (typeList.contains(componentTypeEnum.getComponentType())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验传入类型是否存在客户筛选组件
     * @param typeList
     * @return
     */
    default boolean isCustomerType(Set<String> typeList) {
        List<ComponentTypeEnum> customerTypeList = new ArrayList<>();
        customerTypeList.add(ComponentTypeEnum.FLEXIBLE_QUERY);
        customerTypeList.add(ComponentTypeEnum.TAG_QUERY);
        customerTypeList.add(ComponentTypeEnum.GROUP_IMPORT);
        customerTypeList.add(ComponentTypeEnum.CONSUMER_IMPORT);

        for (ComponentTypeEnum componentTypeEnum : customerTypeList) {
            if (typeList.contains(componentTypeEnum.getComponentType())) {
                return true;
            }
        }
        return false;
    }
}
