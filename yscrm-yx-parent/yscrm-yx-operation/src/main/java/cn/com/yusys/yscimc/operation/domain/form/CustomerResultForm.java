package cn.com.yusys.yscimc.operation.domain.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @Author Lenovo
 * @Data 2022/3/11 15:57
 */
public class CustomerResultForm {
    // 客户id
    private String customerId;
    // 客户名称
    private String customerName;
    // 渠道id
    private String channelId;
    // 触发结果
    private String resultType;
    // 触发时间
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalDate startTime;
    // 客户类型
    private String customerType;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}

