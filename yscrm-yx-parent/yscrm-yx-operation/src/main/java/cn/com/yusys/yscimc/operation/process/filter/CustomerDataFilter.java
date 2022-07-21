package cn.com.yusys.yscimc.operation.process.filter;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.process.product.ProductFlowProcessor;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.cm.cust.domain.AcimBlackListCustomer;
import cn.com.yusys.yusp.cm.cust.repository.mapper.AcimFCiCustomerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 客户信息过滤器
 * @author zhangyt12
 * @date 2021/12/22 18:36
 */
@Component("customerDataFilter")
public class CustomerDataFilter implements ComponentFlowProcessor {

    private final AcimFCiCustomerMapper mapper;

    public CustomerDataFilter(AcimFCiCustomerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(MarketPlanTaskExecutor executor, ProcessedDataBo processedDataBo) {

        Set<CustomerInfoVo> customerInfoVoSet = processedDataBo.getCustomerInfoVoSet();
        List<CustomerInfoVo> customerInfoVoList = new ArrayList<>(customerInfoVoSet);

        //查询黑名单客户集合
        List<AcimBlackListCustomer> blackListCustomerList = mapper.getBlackListCustomer();
        //将黑名单客户列表转为 Map
        Map<String, AcimBlackListCustomer> blackListCustomerMap = blackListCustomerList.stream().collect(Collectors.toMap(AcimBlackListCustomer::getCustId, Function.identity()));

        for (CustomerInfoVo customerInfoVo : customerInfoVoList) {
            if (blackListCustomerMap.containsKey(customerInfoVo.getCustId())) {
                customerInfoVoSet.remove(customerInfoVo);
            }
        }

        processedDataBo.setCustomerInfoVoRemoveBlackList(customerInfoVoSet);
        executor.processAndExecute(this.getNextFlow(executor.getMarketPlanServiceExtend()), processedDataBo);
    }

    @Override
    public ComponentFlowProcessor getNextFlow(MarketPlanServiceExtend serviceExtend) {
        return serviceExtend.getNextFlowProcessor(ProductFlowProcessor.class);
    }
}