package cn.com.yusys.yscimc.operation.resolver.pre;

import cn.com.yusys.yscimc.cust.group.service.CimpCCustgroupCustService;
import cn.com.yusys.yscimc.operation.domain.dto.CustomerGroupInfoDto;
import cn.com.yusys.yscimc.operation.domain.vo.GenericCustomerGroupInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractCustomerResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * 处理组件查询用户添加到客户群中
 * 满足以下组件：
 *      灵活查询、标签查询、客户群导入
 * @author zhangyt12
 * @date 2021/12/15 10:05
 */
public abstract class AbstractGenericCustomerResolver extends AbstractCustomerResolver {

    private final CimpCCustgroupCustService customerGroupService;

    private static final String SQL_START = "INSERT ALL ";

    private static final String INTO_TEMPLATE = " into cimp_c_custgroup_cust(ID, CUST_GROUP_ID, CUST_ID) values('@id@','@groupId@','@customerId@') ";

    private static final String SQL_END = " select 1 from dual ";

    public AbstractGenericCustomerResolver(CimpCCustgroupCustService customerGroupService) {
        this.customerGroupService = customerGroupService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CustomerGroupInfoDto preComponentResolver(CimpCmNodeinfo nodeInfo) {
        // 获取信息
        GenericCustomerGroupInfoVo customerGroupInfo = resolver(nodeInfo);

        if (this.getType().equals("9") || this.getType().equals("10")) {

        } else {
            // 删除客户群中原有的数据
            customerGroupService.deleteByGroupId(customerGroupInfo.getCustomerGroupId());

            // 多条数据保存操作，使用自己拼装 sql 语句的方式，一次性完成
            List<String> customerIdList = customerGroupInfo.getCustomerIdList();

            // 开始拼装 sql
            StringBuffer stringBuffer = new StringBuffer(SQL_START);
            String template = INTO_TEMPLATE;
            template = template.replace("@groupId@", customerGroupInfo.getCustomerGroupId());
            for (String id : customerIdList) {
                String replaceSql = template;
                replaceSql = replaceSql.replace("@id@", getUUID()).replace("@customerId@", id);
                stringBuffer.append(replaceSql);
            }
            stringBuffer.append(SQL_END);
            // 保存客户关联客户群数据
            customerGroupService.insertAll(stringBuffer.toString());
        }

        return new CustomerGroupInfoDto(customerGroupInfo.getCustomerCount(), customerGroupInfo.getCustomerGroupId());
    }

    /**
     * 获取组件中的信息，存到 TagsInfoVo 中
     * @param nodeInfo
     * @return
     */
    public abstract GenericCustomerGroupInfoVo resolver(CimpCmNodeinfo nodeInfo);


    public CimpCCustgroupCustService getCustomerGroupService() {
        return customerGroupService;
    }

    /**
     * 自增UUID
     */
    private String getUUID() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
}
