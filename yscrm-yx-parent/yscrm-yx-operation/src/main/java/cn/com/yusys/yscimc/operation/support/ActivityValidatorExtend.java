package cn.com.yusys.yscimc.operation.support;

import cn.com.yusys.yscimc.operation.domain.bo.MarketPlanValidatorBo;
import cn.com.yusys.yscimc.operation.validator.ActivityPreValidator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @Author Lenovo
 * @Data 2022/3/28 12:04
 */
@Component
public class ActivityValidatorExtend implements ApplicationContextAware {

    private List<ActivityPreValidator> activityPreValidatorList;

    public void preValidate(MarketPlanValidatorBo validatorBo) {
        // activityPreValidatorList初始化了三种类型，分别是：名单制、互联网、事件，判断当前类型是哪种然后校验
        for (ActivityPreValidator activityPreValidator : activityPreValidatorList) {
            if (activityPreValidator.support(validatorBo)) {
                activityPreValidator.preVerifyActivity(validatorBo);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, ActivityPreValidator> beansOfType = applicationContext.getBeansOfType(ActivityPreValidator.class);
        activityPreValidatorList = new ArrayList<>(beansOfType.size());
        activityPreValidatorList.addAll(beansOfType.values());
        activityPreValidatorList.sort(new Comparator<ActivityPreValidator>() {
            @Override
            public int compare(ActivityPreValidator o1, ActivityPreValidator o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
    }
}
