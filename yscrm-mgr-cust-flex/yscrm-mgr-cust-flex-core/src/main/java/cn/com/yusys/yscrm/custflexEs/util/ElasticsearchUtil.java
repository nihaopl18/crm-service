package cn.com.yusys.yscrm.custflexEs.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.mapper.HighlightResultMapper;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * es工具类
 * @author zhangzq
 *
 */
@Component
public class ElasticsearchUtil {

	private static final Logger logger = LoggerFactory.getLogger(ElasticsearchUtil.class);
	
	private static ElasticsearchTemplate elasticsearchTemplate;
	
	@Autowired
	public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
		ElasticsearchUtil.elasticsearchTemplate = elasticsearchTemplate;
	}
	
	
	/**
	 * 根据多个ID查询es的结果
	 * @param ids
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	public static <T> List<T> getListByIds(List<String> ids,Class<T> clazz) throws IOException {
		String indexName = getIndexName(clazz);
//		BoolQueryBuilder bb = QueryBuilders.boolQuery();
//		bb.must(QueryBuilders.termsQuery(indexName+".keyword", ids));
		TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery(indexName+".keyword", ids);
		NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(PageRequest.of(0, ids.size()))	// 分页
				                            .withQuery(termsQueryBuilder).build();
		List<T> list = elasticsearchTemplate.queryForList(searchQuery, clazz);
	    return list;
	}
	
	/**
	 * 查询分页List
	 * @param searchQuery
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> queryForPageList(SearchQuery searchQuery,Class<T> clazz){
		Page<T> queryInfoList = elasticsearchTemplate.queryForPage(searchQuery, clazz, new HighlightResultMapper());
		List<T> list = queryInfoList.getContent();
		return list;
	}
	
	/**
	 * 获取前端查询结果
	 * @param searchQuery
	 * @param clazz
	 * @return
	 */
	public static <T> ResultDto<List<Map<String, Object>>> getResultDto(SearchQuery searchQuery,Class<T> clazz){
		Page<T> queryInfoList = elasticsearchTemplate.queryForPage(searchQuery, clazz, new HighlightResultMapper());
		List<T> list = queryInfoList.getContent();
		List<Map<String, Object>> list_map = ListConvertUtil.listConvert(list);
		ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
		resultDto.setTotal(queryInfoList.getTotalElements());
		resultDto.setData(list_map);
		return resultDto;
	}
	
	
	/**
	 * 根据主键对es中的数据添加或修改
	 * @param list
	 * @return
	 */
    public static <T> int saveOrUpdate(List<T> list,Class<T> clazz) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        
        Document document = getDocument(clazz);
        String indexName = document.indexName();
        List<IndexQuery> bulkIndex = new ArrayList<>();
        int counter = 0;

        for (T t : list) {
        	Object id = getId(t,clazz);
        	IndexQuery indexQuery = new IndexQuery();
            indexQuery.setId(id.toString());
            indexQuery.setSource(JSONObject.toJSONString(t, SerializerFeature.WriteMapNullValue));
            indexQuery.setIndexName(indexName);
            indexQuery.setType(document.type());
            bulkIndex.add(indexQuery);
            counter++;
            //分批提交索引
            if (counter % 500 == 0) {
            	elasticsearchTemplate.bulkIndex(bulkIndex);
            	bulkIndex.clear();
            }
        }
        
        //不足批的索引最后不要忘记提交
        if (bulkIndex.size() > 0) {
        	elasticsearchTemplate.bulkIndex(bulkIndex);
        }
        elasticsearchTemplate.refresh(indexName);
        return counter;
    }
	

	/**
	 * 删除
	 * @return
	 * 
	 */
	public static <T> boolean delete(String id,Class<T> clazz) throws IOException {
		try {
			elasticsearchTemplate.delete(clazz, id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
		return true;

	}

	/**
	 * 获取document注解
	 * @param t
	 * @return
	 */
    protected static <T> Document getDocument(Class<T> clazz) {
        Document annotation = clazz.getAnnotation(Document.class);
        if (annotation == null) {
        	logger.error("Can't find annotation @Document on " + clazz.getName());
        }
        return annotation;
    }

    
    /**
     * 获取字段值
     *
     * @param field
     * @param obj
     * @return
     */
    protected static Object getFieldValue(Field field, Object obj) {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage());
            return e;
        } finally {
            field.setAccessible(isAccessible);
        }
    }
	
    /**
     * 获取Id的值
     * @param t
     * @return
     */
	public static <T> Object getId(T t,Class<T> clazz) {
		try {
			// 得到所有属性
			Field[] field = clazz.getDeclaredFields();
			Field idField = null;
	        for (Field f : field) {
	        	f.setAccessible(true);
	        	org.springframework.data.annotation.Id businessID = f.getAnnotation(org.springframework.data.annotation.Id.class);
	            if (businessID != null) {
	            	idField = f;
	                break;
	            }
	        }
	        if (idField == null) {
	        	logger.error("Can't find @Id on " + clazz.getName());
	        	return false;
	        }
	        
			// 调用这个整合出来的get方法，强转成自己需要的类型
			return getFieldValue(idField, t);

		} catch (Exception e)

		{

			return null;

		}

	}
	
    /**
     * 获取Id属性名称
     * @param t
     * @return
     */
	public static <T> String getIndexName(Class<T> clazz) {
		try {
			// 得到所有属性
			Field[] field = clazz.getDeclaredFields();
			Field idField = null;
	        for (Field f : field) {
	        	f.setAccessible(true);
	        	org.springframework.data.annotation.Id businessID = f.getAnnotation(org.springframework.data.annotation.Id.class);
	            if (businessID != null) {
	            	idField = f;
	                break;
	            }
	        }
	        if (idField == null) {
	        	logger.error("Can't find @Id on " + clazz.getName());
	        }
			// 调用这个整合出来的get方法，强转成自己需要的类型
			return idField.getName();
		} catch (Exception e){
			return null;

		}

	}	
	
}