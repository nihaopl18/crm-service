package cn.com.yusys.yscimc.operation.process.content;

import cn.com.yusys.yscimc.operation.annotation.Keyword;
import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 关键字替换处理器
 * @author zhangyt12
 * @date 2021/12/23 17:50
 */
public abstract class AbstractKeywordReplaceHandler implements KeywordReplaceHandler{

    @Override
    public List<MarketActionInfoVo> keywordHandler(List<String> keywordList, ProcessedDataBo processedDataBo, List<MarketActionInfoVo> marketActionInfoVoList) {
        Set<Field> fields = this.matchField(keywordList, supportType());
        if (!CollectionUtils.isEmpty(fields)) {
            List<MarketActionInfoVo> copyList = new ArrayList<>(marketActionInfoVoList);
            marketActionInfoVoList.clear();
            for (MarketActionInfoVo marketActionInfoVo : copyList) {
                List<MarketActionInfoVo> voList = replace(fields, processedDataBo, marketActionInfoVo);
                if (voList != null) {
                    marketActionInfoVoList.addAll(voList);
                }
            }
            if (CollectionUtils.isEmpty(marketActionInfoVoList)) {
                marketActionInfoVoList = copyList;
            }
        }
        return marketActionInfoVoList;
    }



    /**
     * 生成模板的方法
     * @param fieldSet
     * @param infoVoCollection
     * @param marketActionInfoVo
     * @param <T>
     * @return
     */
    public <T> List<MarketActionInfoVo> replaceKeyword(Set<Field> fieldSet, Collection<T> infoVoCollection, MarketActionInfoVo marketActionInfoVo) {
        // 不做任何校验，校验由方法上游处理
        List<MarketActionInfoVo> resultList = new ArrayList<>(infoVoCollection.size());
        for (T infoVo : infoVoCollection) {
            String replaceTemplate = marketActionInfoVo.getModelInfo();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            for (Field field : fieldSet) {
                ReflectionUtils.makeAccessible(field);
                try {
                    String fieldString = null;
                    Object fieldObject = field.get(infoVo);
                    if (fieldObject != null) {
                        if (fieldObject instanceof Date) {
                            fieldString = dateFormat.format(fieldObject);
                        } else {
                            fieldString = (String) fieldObject;
                        }
                    } else {
                        fieldString = "*【" + field.getName() + "】属性值为 null *";
                    }
                    replaceTemplate = replaceTemplate.replace(field.getAnnotation(Keyword.class).alias().toUpperCase(), fieldString);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException("营销话术关键字 " + field.getAnnotation(Keyword.class).alias() + " 替换报错；");
                }
            }
            MarketActionInfoVo resultVo = (MarketActionInfoVo) marketActionInfoVo.clone();
            resultVo.setModelInfo(replaceTemplate);
            this.setInfo(resultVo, infoVo);
            resultList.add(resultVo);
        }
        return resultList;
    }

    public abstract <T> void setInfo(MarketActionInfoVo resultVo, T infoVo);

    public abstract List<MarketActionInfoVo> replace(Set<Field> fields, ProcessedDataBo processedDataBo, MarketActionInfoVo marketActionInfoVo);

    private final Set<Field> matchField(List<String> keywordList, Class<?> clazz) {
        Set<Field> fieldSet = new HashSet<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String alias = field.getAnnotation(Keyword.class).alias();
            if (keywordList.contains(alias)) {
                // 获取客户信息匹配的属性对象
                fieldSet.add(field);
//                keywordList.remove(alias);
//                if (keywordList.size() == 0) {
//                    break;
//                }
            }
        }
        return fieldSet;
    }
}