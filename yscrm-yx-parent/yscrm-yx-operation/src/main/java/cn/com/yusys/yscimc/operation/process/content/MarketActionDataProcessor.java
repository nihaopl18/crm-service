package cn.com.yusys.yscimc.operation.process.content;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;
import cn.com.yusys.yscimc.operation.process.ContentDataProcessor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 组件数据解析器
 * @author zhangyt12
 * @date 2021/12/13 16:10
 */
@Component
public class MarketActionDataProcessor implements ContentDataProcessor, ApplicationContextAware {

    private List<KeywordReplaceHandler> replaceHandlerList;

    @PostConstruct
    public void init() {
        if (replaceHandlerList == null) {
            replaceHandlerList = new ArrayList<>();
        }
        replaceHandlerList.add(new CustomerKeywordHandler());
        replaceHandlerList.add(new ProductKeywordHandler());
    }

    @Override
    public void contentProcess(List<ContentInfoVo> contentInfoVoList, ProcessedDataBo processedDataBo) {

        if (processedDataBo == null) {
            throw new RuntimeException("MarketActionDataProcessor 处理器出现错误，没有 ProcessedDataBo 类型的参数信息");
        }

        List<MarketActionInfoVo> marketActionInfoVoList = new ArrayList<>();

        for (ContentInfoVo contentInfoVo : contentInfoVoList) {
            if (this.support(contentInfoVo)) {
                MarketActionInfoVo marketActionInfoVo = (MarketActionInfoVo)contentInfoVo;
                if (!CollectionUtils.isEmpty(marketActionInfoVo.getKeywordList())){
                    List<String> keywordList = marketActionInfoVo.getKeywordList();
                    // 使用 keywordList 从 processedDataBo 中找出替换的属性值
                    marketActionInfoVoList.addAll(matchKeyword(keywordList, processedDataBo, marketActionInfoVo));
                }
            }
        }
        processedDataBo.setMarketActionInfoVoList(marketActionInfoVoList);
    }

    /**
     * 责任链模式，使用关键字解析器处理模板
     * @param keywordList
     * @param processedDataBo
     */
    private List<MarketActionInfoVo> matchKeyword(List<String> keywordList, ProcessedDataBo processedDataBo, MarketActionInfoVo marketActionInfoVo) {
        List<MarketActionInfoVo> actionInfoVoList = new ArrayList<>();
        actionInfoVoList.add(marketActionInfoVo);
        for (KeywordReplaceHandler keywordReplaceHandler : replaceHandlerList) {
            keywordReplaceHandler.keywordHandler(keywordList, processedDataBo, actionInfoVoList);
        }
        return actionInfoVoList;
    }

    @Override
    public boolean support(ContentInfoVo contentInfoVo) {
        return contentInfoVo instanceof MarketActionInfoVo;
    }

    /**
     * 添加关键字替换处理器
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, KeywordReplaceHandler> beansOfType = applicationContext.getBeansOfType(KeywordReplaceHandler.class);
        if (!CollectionUtils.isEmpty(beansOfType)) {
            replaceHandlerList = new ArrayList<>();
            replaceHandlerList.addAll(beansOfType.values());
        }
    }

    /**
     * 客户信息关键字替换实现类
     */
    private static class CustomerKeywordHandler extends AbstractKeywordReplaceHandler{

        @Override
        public List<MarketActionInfoVo> replace(Set<Field> fields, ProcessedDataBo processedDataBo, MarketActionInfoVo marketActionInfoVo) {
            Set<CustomerInfoVo> customerInfoVoSet = processedDataBo.getCustomerInfoVoSet();
            List<MarketActionInfoVo> resultInfoList = null;
            if (customerInfoVoSet == null) {
                throw new RuntimeException("营销话术关键字匹配客户属性成功，但是客户信息为空，无法进行关键字替换。");
            } else {
                // 直接使用现有的客户信息替换关键子
                resultInfoList = replaceKeyword(fields, customerInfoVoSet, marketActionInfoVo);
                // 如果 replacedTemplateList 为 null，说明需要使用客户信息作为关键字查询对应的信息；
                if (CollectionUtils.isEmpty(resultInfoList )) {
                    // TODO 使用客户信息作为关键字查询对应的信息
                }
            }
            return resultInfoList;
        }

        @Override
        public Class<?> supportType() {
            return CustomerInfoVo.class;
        }

        @Override
        public <T> void setInfo(MarketActionInfoVo resultVo, T infoVo) {
            resultVo.setCustomerInfoVo((CustomerInfoVo) infoVo);
        }
    }

    /**
     * 产品信息关键字替换实现类
     */
    private static class ProductKeywordHandler extends AbstractKeywordReplaceHandler{

        @Override
        public <T> void setInfo(MarketActionInfoVo resultVo, T infoVo) {
            resultVo.setProductInfoVo((ProductInfoVo) infoVo);
        }

        @Override
        public List<MarketActionInfoVo> replace(Set<Field> fields, ProcessedDataBo processedDataBo, MarketActionInfoVo marketActionInfoVo) {
            List<ProductInfoVo> productInfoVoList = processedDataBo.getProductInfoVoList();
            List<MarketActionInfoVo> resultInfoList = null;
            if (productInfoVoList == null) {
                throw new RuntimeException("营销话术关键字匹配产品属性成功，但是产品信息为空，无法进行关键字替换。");
            } else {
                // 直接使用现有的客户信息替换关键子
                resultInfoList = replaceKeyword(fields, productInfoVoList, marketActionInfoVo);
                // 如果 replacedTemplateList 为 null，说明需要使用客户信息作为关键字查询对应的信息；
                if (CollectionUtils.isEmpty(resultInfoList )) {
                    // TODO 使用客户信息作为关键字查询对应的信息
                }
            }
            return resultInfoList;
        }

        @Override
        public Class<?> supportType() {
            return ProductInfoVo.class;
        }
    }
}
