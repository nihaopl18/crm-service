package cn.com.yusys.yscimc.operation.process.customer;

import cn.com.yusys.yscimc.operation.domain.dto.CustomerGroupInfoDto;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Lenovo
 * @Data 2021/12/20 20:07
 */
public class CustomerProcessHolder {

    private final CustomerGroupInfoDto customerGroupInfoDto;

    private final int page;

    private final int size;

    private final MarketPlanTaskExecutor executor;

    private CountDownLatch countDownLatch;

    public CustomerProcessHolder(CustomerGroupInfoDto customerGroupInfoDto, int page, int size, MarketPlanTaskExecutor executor) {
        this.customerGroupInfoDto = customerGroupInfoDto;
        this.page = page;
        this.size = size;
        this.executor = executor;
    }

    public CustomerProcessHolder(CustomerGroupInfoDto customerGroupInfoDto, int page, int size, MarketPlanTaskExecutor executor, CountDownLatch countDownLatch) {
        this.customerGroupInfoDto = customerGroupInfoDto;
        this.page = page;
        this.size = size;
        this.executor = executor;
        this.countDownLatch = countDownLatch;
    }

    public CustomerGroupInfoDto getCustomerGroupInfoDto() {
        return customerGroupInfoDto;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public MarketPlanTaskExecutor getExecutor() {
        return executor;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
