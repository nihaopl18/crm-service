package cn.com.yusys.yscimc.operation.resolver.pre;

import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;
import cn.com.yusys.yscimc.operation.resolver.AbstractContentResolver;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysTypeInfo;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 预处理【营销动作】组件的信息
 * 将现有的模板关键字取出来
 * @author zhangyt12
 * @date 2021/12/17 17:11
 */
public abstract class AbstractPreMarketActionResolver extends AbstractContentResolver {

    @Override
    public List<ContentInfoVo> resolver(CimpCmNodeinfo nodeInfo) {

        // 子类获取短信模板
        List<CmFRcSysTypeInfo> messageTemplateList = getMessageTemplate(nodeInfo);

        // 解析出模板中的关键字，组合成 ContentInfoVo 对象
        return this.analysisKeyword(messageTemplateList);
    }

    public List<ContentInfoVo> analysisKeyword(List<CmFRcSysTypeInfo> messageTemplateList) {
        List<ContentInfoVo> marketActionInfoVoList = new ArrayList<>();
        for (CmFRcSysTypeInfo typeInfo : messageTemplateList) {

            // 创建 ContentInfoVo 对象
            MarketActionInfoVo marketActionInfoVo = new MarketActionInfoVo();
            BeanUtils.copyProperties(typeInfo, marketActionInfoVo);

            // 获取模板中的关键字集合
            String modelInfo = typeInfo.getModelInfo();
            String[] split = modelInfo.split("@");
            List<String> keywordList = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                if (i%2 != 0) {
                    keywordList.add("@" + split[i] + "@");
                }
            }
            marketActionInfoVoList.add(marketActionInfoVo.setKeywordList(keywordList));
        }
        return marketActionInfoVoList;
    }

    /**
     * 返回组件存储的所有短信模板
     * @param nodeInfo
     * @return
     */
    public abstract List<CmFRcSysTypeInfo> getMessageTemplate(CimpCmNodeinfo nodeInfo);
}
