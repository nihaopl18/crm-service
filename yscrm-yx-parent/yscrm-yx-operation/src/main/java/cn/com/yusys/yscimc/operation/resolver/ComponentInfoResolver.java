package cn.com.yusys.yscimc.operation.resolver;

import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;

/**
 * 组件信息类解析器
 * 以下组件解析器继承该组件：
 *      营销成效指标策划
 *      灵活查询、客户群引入、标签客户查询、客户导入
 *      产品选择、营销动作
 *      素材、分享、报名、裂变
 * @author zhangyt12
 * @date 2021/12/14 18:01
 */
public interface ComponentInfoResolver {
    /**
     * 解析出组件的信息，保存到 componentDataBo 中
     * @param nodeInfo
     * @param componentDataBo
     */
    void componentResolver(CimpCmNodeinfo nodeInfo, ComponentDataBo componentDataBo);

    /**
     * 获取当前解析器的组件类型
     * @return
     */
    String getType();
}
