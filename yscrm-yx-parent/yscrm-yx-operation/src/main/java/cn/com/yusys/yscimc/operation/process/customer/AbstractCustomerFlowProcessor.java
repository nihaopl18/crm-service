package cn.com.yusys.yscimc.operation.process.customer;

import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.CustomerGroupInfoDto;
import cn.com.yusys.yscimc.operation.domain.dto.MarketPlanResultDto;
import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import constant.TaskResultType;
import core.PendingJobPool;
import dto.TaskResultDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import process.ITaskProcessor;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 组件数据解析器
 * @author zhangyt12
 * @date 2021/12/13 16:10
 */
public abstract class AbstractCustomerFlowProcessor implements ComponentFlowProcessor, ITaskProcessor<CustomerProcessHolder, List<MarketPlanResultDto>> {

    private static final String CLASS_NAME = "_" + AbstractCustomerFlowProcessor.class.getSimpleName();

    @Value("${yscimc.operation.customer.number-Limit}")
    private int numberLimit;

    @Override
    public final void process(MarketPlanTaskExecutor executor, ProcessedDataBo processedDataBo) {

        ComponentDataBo componentDataBo = executor.getComponentDataBo();

        if (componentDataBo == null) {
            throw new RuntimeException("组件解析出的数据为空，无法执行该活动！");
        }
        else {
            CustomerGroupInfoDto groupInfoDto = componentDataBo.getCustomerInfoDto();
            if (groupInfoDto != null) {
                if (groupInfoDto.getCustomerCount() == 0 || CollectionUtils.isEmpty(groupInfoDto.getCustomerGroupIdList())) {
                    throw new RuntimeException("客户群类不为空，但是客户群类中的 CustomerCount 或者 CustomerGroupIdList 为空。原因：客户类组件数据解析不正确。");
                }
                int customerCount = groupInfoDto.getCustomerCount();
                int jobLength = customerCount / this.numberLimit == 0 ? 1 : (customerCount % this.numberLimit == 0 ? customerCount / this.numberLimit : customerCount / this.numberLimit + 1);
                CountDownLatch countDownLatch = jobLength > 1 ? new CountDownLatch(jobLength) : null;
                // 如果 countDownLatch == null，客户数量小，不使用多线程处理；
                if (countDownLatch == null) {
                    this.taskExecute(new CustomerProcessHolder(groupInfoDto, jobLength, customerCount, executor));
                }
                // countDownLatch ！= null，客户数量较大，需要使用多线程处理；
                else {
                    String jobName = executor.getInitialData().getPlanInfo().getActivityName() + CLASS_NAME;
                    PendingJobPool pendingJobPool = PendingJobPool.jobPoolInstance();
                    pendingJobPool.registerJob(jobName, jobLength, this, 5000);
                    int size = this.numberLimit;

                    for(int page = 1; page <= jobLength; ++page) {
                        if (page == jobLength) {
                            size = customerCount - this.numberLimit * (jobLength - 1);
                        }
                        CustomerProcessHolder customerProcessHolder = new CustomerProcessHolder(groupInfoDto, page, size, executor, countDownLatch);
                        pendingJobPool.putTask(jobName, customerProcessHolder);
                    }

                    try {
                        // 使用 countDownLatch 的原因是为了等所有的线程走完，回归主线程，然后提示整个活动运行完成；
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                executor.processAndExecute(this.getNextFlow(executor.getMarketPlanServiceExtend()).getNextFlow(executor.getMarketPlanServiceExtend()), new ProcessedDataBo());
            }
        }
    }

    @Override
    public TaskResultDto<List<MarketPlanResultDto>> taskExecute(CustomerProcessHolder holder) {
        try {
            CimpCmMarketplan planInfo = holder.getExecutor().getInitialData().getPlanInfo();
            Set<CustomerInfoVo> customerInfoVoList = this.customerProcess(holder.getCustomerGroupInfoDto().getCustomerGroupIdList(), planInfo.getActivityOrg(),holder.getPage(), holder.getSize());
            // 使用 customerInfoVoList ，生成需要 processedDataBo 对象所需的数据，执行后续逻辑
            List<MarketPlanResultDto> marketPlanResultDtoList = holder.getExecutor().processAndExecute(
                    getNextFlow(holder.getExecutor().getMarketPlanServiceExtend()),
                    new ProcessedDataBo().setCustomerInfoVoSet(customerInfoVoList));
            return new TaskResultDto<>(TaskResultType.Success, marketPlanResultDtoList, "营销活动执行成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new TaskResultDto<List<MarketPlanResultDto>>(TaskResultType.Exception, null, "活动执行失败，出现异常：" + e.getMessage());
        } finally {
            CountDownLatch countDownLatch = holder.getCountDownLatch();
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    public abstract Set<CustomerInfoVo> customerProcess(List<String> customerGroupIdList, String orgId,int page, int size);
}
