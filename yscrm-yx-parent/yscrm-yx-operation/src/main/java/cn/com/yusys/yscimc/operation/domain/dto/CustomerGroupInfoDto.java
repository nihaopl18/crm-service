package cn.com.yusys.yscimc.operation.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户组件 service 返回的客户信息
 * @author zhangyt12
 * @date 2021/12/11 21:50
 */
public class CustomerGroupInfoDto {

    // 所有标签组合查询出的客户总数量
    private int customerCount;

    // 客户群 id
    private final List<String> customerGroupIdList;

    public CustomerGroupInfoDto() {
        this.customerGroupIdList = new ArrayList<>(8);
    }

    public CustomerGroupInfoDto(int customerCount) {
        this.customerCount = customerCount;
        this.customerGroupIdList = new ArrayList<>(8);
    }

    public CustomerGroupInfoDto(int customerCount, String customerGroupId) {
        this.customerCount = customerCount;
        this.customerGroupIdList = new ArrayList<>(8);
        this.customerGroupIdList.add(customerGroupId);
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void addCustomerCount(int count) {
        this.customerCount += count;
    }

    public List<String> getCustomerGroupIdList() {
        return customerGroupIdList;
    }

    public void addCustomerGroupIdList(String customerGroupId) {
        this.customerGroupIdList.add(customerGroupId);
    }

    public void addCustomerGroupIdList(List<String> customerGroupIdList) {
        this.customerGroupIdList.addAll(customerGroupIdList);
    }
}