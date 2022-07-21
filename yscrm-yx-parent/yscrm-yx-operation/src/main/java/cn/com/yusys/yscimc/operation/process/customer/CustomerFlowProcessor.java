package cn.com.yusys.yscimc.operation.process.customer;

import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.process.filter.CustomerDataFilter;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.cm.cust.repository.mapper.AcimFCiCustomerMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 客户信息处理器
 * @author zhangyt12
 * @date 2021/12/17 16:52
 */
@Component("customerDataProcessor")
public class CustomerFlowProcessor extends AbstractCustomerFlowProcessor {

    private final Logger logger = LoggerFactory.getLogger(CustomerFlowProcessor.class);

    private final AcimFCiCustomerMapper customerMapper;

    public CustomerFlowProcessor(AcimFCiCustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public Set<CustomerInfoVo> customerProcess(List<String> customerGroupIdList, String orgId,int page, int size) {

        // 需要实现分页查询功能，查询出客户群中的客户
        PageHelper.startPage(page, size);
        List<AcimFCiCustomer> customerEntityList = customerMapper.getCmpList(customerGroupIdList);
        PageHelper.clearPage();

        // 将 AcimFCiCustomer 类型转换为 CustomerInfoVo 类型
        Set<CustomerInfoVo> voList = new HashSet<>();
        if (!CollectionUtils.isEmpty(customerEntityList)) {
            customerEntityList.forEach(entity -> {
                CustomerInfoVo vo = new CustomerInfoVo();
                BeanUtils.copyProperties(entity, vo);
                // TODO Set 去重, CustomerInfoVo 是不是需要重写 hashCode 和 equals 方法 ?
                voList.add(vo);
            });
        }

        return voList;
    }

    @Override
    public ComponentFlowProcessor getNextFlow(MarketPlanServiceExtend serviceExtend) {
        return serviceExtend.getNextFlowProcessor(CustomerDataFilter.class);
    }
}
