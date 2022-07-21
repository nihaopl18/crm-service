package cn.com.yusys.yscimc.operation.resolver;

import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.CustomerGroupInfoDto;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;

/**
 * 客户名单类组件虚构解析器
 * 1、处理需求
 * @author zhangyt12
 * @date 2021/12/15 10:05
 */
public abstract class AbstractCustomerResolver implements ComponentInfoResolver {

    @Override
    public void componentResolver(CimpCmNodeinfo nodeInfo, ComponentDataBo componentDataBo) {
        CustomerGroupInfoDto customerGroupInfoDto = this.preComponentResolver(nodeInfo);
        componentDataBo.addCustomerInfoDto(customerGroupInfoDto);
    }

    public abstract CustomerGroupInfoDto preComponentResolver(CimpCmNodeinfo nodeInfo);
}
