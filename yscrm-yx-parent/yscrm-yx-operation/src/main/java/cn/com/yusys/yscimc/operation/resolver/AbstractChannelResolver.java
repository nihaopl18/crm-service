package cn.com.yusys.yscimc.operation.resolver;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.ChannelInfoVo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;

import java.util.List;

/**
 * 渠道相关组件虚构解析器
 * 1、处理需求
 * @author zhangyt12
 * @date 2021/12/15 10:05
 */
public abstract class AbstractChannelResolver implements ComponentInfoResolver {

    @Override
    public void componentResolver(CimpCmNodeinfo nodeInfo, ComponentDataBo componentDataBo) {
        List<ChannelInfoVo> channelInfoVoList = resolver(nodeInfo);
        if (this.getType().equals(ComponentTypeEnum.MOBILE_BANK.getComponentType())) {
            // TODO 处理手机银行数据需要存储到 content 中的问题
        } else {
            componentDataBo.addChannelInfoDto(channelInfoVoList);
        }
    }

    public abstract List<ChannelInfoVo> resolver(CimpCmNodeinfo nodeInfo);
}
