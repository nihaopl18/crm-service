package cn.com.yusys.yscimc.operation.resolver.impl;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.vo.ChannelInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.WeChatInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractChannelResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesPresentation;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodesDisplayMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodesPresentationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 渠道类型组件：短信组件解析器
 * @author zhangyt12
 * @date 2021/12/15 18:21
 */
@Component
public class WeChatResolver extends AbstractChannelResolver {

    @Autowired
    private CimpCmNodesDisplayMapper disMapper;
    @Autowired
    private CimpCmNodesPresentationMapper preMapper;
    
    @Override
    public List<ChannelInfoVo> resolver(CimpCmNodeinfo nodeInfo) {

        // TODO 使用 nodeInfo 查询该组件保存的信息，并继承 ChannelInfoVo 类型返回；
        String nodeId = nodeInfo.getNodeId();
        //根据nodeId获取formId
        String formId = disMapper.checkBe(nodeId);
        //根据formId查询数据
        List<CimpCmNodesPresentation> presentation = preMapper.getPresentation(formId);
//        //定义时间格式
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        //返回一个对象集合
        List<ChannelInfoVo> channelInfoVoList =new ArrayList<>();
        WeChatInfoVo weChatInfoVo = new WeChatInfoVo();
        for (CimpCmNodesPresentation cimpCmNodesPresentation:presentation){
            if(cimpCmNodesPresentation.getFormOperationFiled().equals("beginTime")){
//                LocalDateTime beginTime = LocalDateTime.parse(cimpCmNodesPresentation.getFormOperationVal(),df);
                weChatInfoVo.setBeginTime(cimpCmNodesPresentation.getFormOperationVal());
            }
            if (cimpCmNodesPresentation.getFormOperationFiled().equals("endTime")){
//                LocalDateTime endTime = LocalDateTime.parse(cimpCmNodesPresentation.getFormOperationVal(),df);
                weChatInfoVo.setEndTime(cimpCmNodesPresentation.getFormOperationVal());
            }
            if (cimpCmNodesPresentation.getFormOperationFiled().equals("sendType")){
                weChatInfoVo.setSendType(cimpCmNodesPresentation.getFormOperationVal());
            }
        }
        weChatInfoVo.setNodeId(nodeId);
        channelInfoVoList.add(weChatInfoVo);
        return channelInfoVoList;
    }

    @Override
    public String getType() {
        return ComponentTypeEnum.SHORT_MESSAGE.getComponentType();
    }
}
