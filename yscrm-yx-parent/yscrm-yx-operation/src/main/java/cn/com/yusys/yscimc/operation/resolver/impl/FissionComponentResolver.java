package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.SignUpInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractContentResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.service.YscimcFmkActiFissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容类型组件：裂变组件解析器
 * @author zhangyt12
 * @date 2021/12/15 18:21
 */
@Component
public class FissionComponentResolver extends AbstractContentResolver {

    @Autowired
    private YscimcFmkActiFissionService fissionService;

    @Override
    public List<ContentInfoVo> resolver(CimpCmNodeinfo nodeInfo) {

        ContentInfoVo vo = new SignUpInfoVo();
        BeanUtils.copyProperties(fissionService.getInfoByAssemble(nodeInfo.getNodeId()),vo);
        List<ContentInfoVo> list = new ArrayList<>();
        list.add(vo);
        return list;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.FISSION.getComponentType();
    }
}
