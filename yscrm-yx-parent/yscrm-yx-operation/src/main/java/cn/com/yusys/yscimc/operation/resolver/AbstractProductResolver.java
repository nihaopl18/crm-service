package cn.com.yusys.yscimc.operation.resolver;

import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;

import java.util.List;

/**
 * 产品组件虚构解析器
 * 1、处理需求
 * @author zhangyt12
 * @date 2021/12/15 10:05
 */
public abstract class AbstractProductResolver implements ComponentInfoResolver {

    @Override
    public void componentResolver(CimpCmNodeinfo nodeInfo, ComponentDataBo componentDataBo) {
        List<ProductInfoVo> voList = this.resolver(nodeInfo);
        // 配置产品信息
        componentDataBo.setProductInfoDto(voList);
    }

    public abstract List<ProductInfoVo> resolver(CimpCmNodeinfo nodeInfo);
}
