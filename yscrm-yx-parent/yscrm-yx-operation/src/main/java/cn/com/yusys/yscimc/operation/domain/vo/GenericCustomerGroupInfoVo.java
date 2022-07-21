package cn.com.yusys.yscimc.operation.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 标签组件信息返回类
 * @author zhangyt12
 * @date 2021/12/15 15:26
 */
public class GenericCustomerGroupInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    // 客户群 id
    private final String customerGroupId;

    // 需要添加到客户群的客户数量
    private final int customerCount;

    // 标签 id 集合
    private final List<String> customerIdList;

    public GenericCustomerGroupInfoVo(String customerGroupId, int customerCount, List<String> customerIdList) {
        this.customerGroupId = customerGroupId;
        this.customerCount = customerCount;
        this.customerIdList = customerIdList;
    }

    public String getCustomerGroupId() {
        return customerGroupId;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public List<String> getCustomerIdList() {
        return customerIdList;
    }
}
