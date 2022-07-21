package cn.com.yusys.yscimc.operation.resolver;

import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;

import java.util.List;

/**
 * 营销内容类组件虚构解析器
 * 1、处理需求
 * @author zhangyt12
 * @date 2021/12/15 10:05
 */
public abstract class AbstractContentResolver implements ComponentInfoResolver {

    @Override
    public void componentResolver(CimpCmNodeinfo nodeInfo, ComponentDataBo componentDataBo) {
        List<ContentInfoVo> contentInfoVoList = this.resolver(nodeInfo);
        componentDataBo.addContentInfoList(contentInfoVoList);
    }

    public abstract List<ContentInfoVo> resolver(CimpCmNodeinfo nodeInfo);
}
