package cn.com.yusys.yscrm.custflexEs.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import tk.mybatis.mapper.util.StringUtil;

public class CmssFCiFqUtil {

	@SuppressWarnings("unchecked")
	public static BoolQueryBuilder buildFqQueryBuilder(List<Map<String, Object>> conditionList, boolean isTransHump) {
		if(conditionList == null || conditionList.size() == 0) {
			return null;
		}
		BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
		String ssColType = null;
		String ssColOp = null;
		String ssColEname = null;
		Object finCustManagerN0 = null;
		String finCustManagerName=null;
		String conditionType=null;
		Object loanCustManagerN0 = null;
		String loanCustManagerName=null;
		Object finBelongOrgNo = null;
		String finBelongOrgName=null;
		Object loanBelongOrgNo = null;
		String loanBelongOrgName=null;
		Object ssColValue = null;
		List<String> finCustManagerN0List = null;
		List<String> loanCustManagerN0List = null;
		List<String> finBelongOrgNoList = null;
		List<String> loanBelongOrgNoList = null;
		int i=0;
		for(Map<String, Object> item: conditionList) {
			ssColType = item.get("ssColType") != null ? item.get("ssColType") + "" : "";	// 组件类型
			ssColOp = item.get("ssColOp") != null ? item.get("ssColOp") + "" : "";	// 操作符值
			ssColEname = item.get("ssColEname") != null ? item.get("ssColEname") + "" : "";	// 字段名称
			ssColEname = isTransHump ? UimpBaseTools.lineToHump(ssColEname) : ssColEname;	// 下划线转驼峰
			ssColValue = item.get("ssColValue") != null ? item.get("ssColValue") : null;	// 属性值，考虑多选框值为数组，此处使用Object接收数据
			finCustManagerN0=item.get("finCustManagerN0") != null ? item.get("finCustManagerN0") : null;
			finCustManagerName = item.get("finCustManagerName") != null ? item.get("finCustManagerName") + "" : "";
			finCustManagerName = isTransHump ? UimpBaseTools.lineToHump(finCustManagerName) : finCustManagerName;
			loanCustManagerN0=item.get("loanCustManagerN0") != null ? item.get("loanCustManagerN0") : null;
			loanCustManagerName = item.get("loanCustManagerName") != null ? item.get("loanCustManagerName") + "" : "";
			loanCustManagerName = isTransHump ? UimpBaseTools.lineToHump(loanCustManagerName) : loanCustManagerName;
			finBelongOrgNo=item.get("finBelongOrgNo") != null ? item.get("finBelongOrgNo") : null;
			finBelongOrgName = item.get("finBelongOrgName") != null ? item.get("finBelongOrgName") + "" : "";
			finBelongOrgName = isTransHump ? UimpBaseTools.lineToHump(finBelongOrgName) : finBelongOrgName;
			loanBelongOrgNo=item.get("loanBelongOrgNo") != null ? item.get("loanBelongOrgNo") : null;
			loanBelongOrgName = item.get("loanBelongOrgName") != null ? item.get("loanBelongOrgName") + "" : "";
			loanBelongOrgName = isTransHump ? UimpBaseTools.lineToHump(loanBelongOrgName) : loanBelongOrgName;
			conditionType=item.get("conditionType") != null ? item.get("conditionType") + "" : "";//查询类型 01：业务模式，02：excel导入模式
			// 字段非空
			if(StringUtil.isEmpty(ssColType) || StringUtil.isEmpty(ssColOp) || StringUtil.isEmpty(ssColEname) || ssColValue == null) {
				continue;
			}
			if("2".equals(ssColType) || "3".equals(ssColType)) {	// 1-1、number/datepicker字段处理
				if(",1,2,3,4".indexOf(ssColOp) > 0) {	// 大于/小于/大于等于/小于等于
					QueryBuilder rangeBuilder = null;
					switch(ssColOp) {
					case "1": 
						rangeBuilder = QueryBuilders
							.rangeQuery(ssColEname).gt(ssColValue);
						break;
					case "2":
						rangeBuilder = QueryBuilders
		                	.rangeQuery(ssColEname).lt(ssColValue);
						break;
					case "3":
						rangeBuilder = QueryBuilders
		                	.rangeQuery(ssColEname).gte(ssColValue);
						break;
					case "4":
						rangeBuilder = QueryBuilders
		                	.rangeQuery(ssColEname).lte(ssColValue);
						break;
					}
					queryBuilder.must(rangeBuilder);
				} else if("5".equals(ssColOp)) {	// 等于
					queryBuilder.must(QueryBuilders.termQuery(ssColEname, ssColValue));
				} else if("6".equals(ssColOp)) {	// 区间
					QueryBuilder rangeBuilder = null;
					if("2".equals(ssColType)) {	// number
						String[] numberValue = (ssColValue + "").split("\\$");
						rangeBuilder = QueryBuilders.rangeQuery(ssColEname)
								.gte(Double.parseDouble(numberValue[0]))
								.lte(Double.parseDouble(numberValue[1]));
					} else if("3".equals(ssColType)) {	// date区间
						String[] dateValue = (ssColValue + "").split("\\$");
						rangeBuilder = QueryBuilders.rangeQuery(ssColEname)
								.gte(dateValue[0])
								.lte(dateValue[1]);
					}
					queryBuilder.must(rangeBuilder);
				}
			} else if("1".equals(ssColType)) {	// 1-2、input字段处理
				if("1".equals(ssColOp)) {	// 等于
					queryBuilder.must(QueryBuilders.termQuery(ssColEname + ".keyword", ssColValue));
				} else {	// 模糊匹配
					//es默认是对要查询的字段进行分词查询，使用queryBuilder.must(QueryBuilders.wildcardQuery(ssColEname, "*" + ssColValue + "*"))进行模糊查询，输入多个汉字进行模糊查询时，
					//会产生被分词成多个字，但没有连起来的分词，导致查询不出来的情况。
					queryBuilder.must(QueryBuilders.wildcardQuery(ssColEname + ".keyword", "*" + ssColValue + "*"));
				}
			} else if("4".equals(ssColType)){	//1-3、单选select字段处理
				queryBuilder.must(QueryBuilders.termQuery(ssColEname, ssColValue));
			}else if("6".equals(ssColType)) {	// 1-3、多选select字段处理
				List<String> ssColValueList = null;
				if (ssColValue instanceof String){
					ssColValueList = Arrays.asList(((String) ssColValue).split(","));
				}else {
					ssColValueList = (List<String>) ssColValue;
				}
				if("02".equals(conditionType)){
					if(i==0){
						queryBuilder.must(QueryBuilders.matchQuery(ssColEname, String.join(" ", ssColValueList)));
						i=i+1;
					}else{
						queryBuilder.should(QueryBuilders.matchQuery(ssColEname, String.join(" ", ssColValueList)));
					}
				}else{
					queryBuilder.must(QueryBuilders.matchQuery(ssColEname, String.join(" ", ssColValueList)));
				}
			}
			if(finCustManagerN0 !=null && finCustManagerN0 !=""){
				Object obj=finCustManagerN0;
				finCustManagerN0List=castList(obj,String.class);
			}
			if(loanCustManagerN0 !=null && loanCustManagerN0 !=""){
				Object obj=loanCustManagerN0;
				loanCustManagerN0List=castList(obj,String.class);
			}
		 if(loanCustManagerN0List !=null && finCustManagerN0List !=null){
		 	queryBuilder.must(QueryBuilders.termsQuery("loanCustManagerNo",loanCustManagerN0List)).should(QueryBuilders.termsQuery("finCustManagerNo",finCustManagerN0List));
		 }else if(loanCustManagerN0List !=null){
			 queryBuilder.must(QueryBuilders.termsQuery("loanCustManagerNo",loanCustManagerN0List));
		 }else if(finCustManagerN0List !=null){
			 queryBuilder.must(QueryBuilders.termsQuery("finCustManagerNo",finCustManagerN0List));
		 }

			if(finBelongOrgNo !=null && finBelongOrgNo !=""){
				Object obj=finBelongOrgNo;
				finBelongOrgNoList=castList(obj,String.class);
			}
			if(loanBelongOrgNo !=null && loanBelongOrgNo !=""){
				Object obj=loanBelongOrgNo;
				loanBelongOrgNoList=castList(obj,String.class);
			}
			if(finBelongOrgNoList !=null && loanBelongOrgNoList !=null){
				queryBuilder.must(QueryBuilders.termsQuery("loanBelongOrgNo",loanBelongOrgNoList)).should(QueryBuilders.termsQuery("finBelongOrgNo",finBelongOrgNoList));
			}else if(loanBelongOrgNoList !=null){
				queryBuilder.must(QueryBuilders.termsQuery(loanBelongOrgName,loanBelongOrgNoList));
			}else if(finBelongOrgNoList !=null){
				queryBuilder.must(QueryBuilders.termsQuery(finBelongOrgName,finBelongOrgNoList));
			}

		}
		return queryBuilder;
	}


	public static <T> List<T> castList(Object obj, Class<T> clazz) {
		List<T> result = new ArrayList<T>();
		if(!String.valueOf(obj).contains(",")){
			result.add((T) String.valueOf(obj));
			return result;
		}else{
		if (obj instanceof List<?>) {
			for (Object o : (List<?>) obj) {
				result.add(clazz.cast(o));
			}
			return result;
		}
		}
		return null;
	}
}
