package cn.com.yusys.yscrm.custflexEs.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import cn.com.yusys.yscrm.custflexEs.domain.*;
import cn.com.yusys.yscrm.custflexEs.esconfig.dto.PageInfo;
import cn.com.yusys.yscrm.custflexEs.esconfig.pool.EsPool;
import cn.com.yusys.yscrm.custflexEs.esconfig.service.EsUtilsMethodService;
import cn.com.yusys.yscrm.custflexEs.model.*;
import cn.com.yusys.yscrm.custflexEs.util.CmssFCiFqUtil;
import cn.com.yusys.yscrm.custflexEs.util.UimpBaseTools;
import cn.com.yusys.yscrm.custflexEs.vo.CrmFCiFqObjNodeVo;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.DemoDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.*;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.admin.service.AdminSmLookupItemService;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CmssFCiFqService
 * @类描述: #灵活查询 公共服务类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2020-12-29 12:31:44
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class CmssFCiFqService {

	private static final Logger log = LoggerFactory.getLogger(CmssFCiFqService.class);


	@Autowired
	private CrmFCiFqGroupService crmFCiFqGroupService;

	@Autowired
	private CrmFCiFqDbcolService crmFCiFqDbcolService;

	@Autowired
	private CrmFCiFqSsolutionService crmFCiFqSsolutionService;

	@Autowired
	private CrmFCiFqScolService crmFCiFqScolService;

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private AdminSmLookupItemOutService adminSmLookupItemService;
	@Autowired
	private UaaClient uaaClient;
	@Autowired
	private EsUtilsMethodService esUtilsMethodService;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final String desensitized = "custName,finCustManagerName,LoanCustManagerName,";

	public UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}

	/**
	 * @函数名称:queryFqTreeData
	 * @函数描述:查询灵活查询左侧树数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<CrmFCiFqObjNodeVo> queryFqTreeData(QueryModel model) throws Exception {
		// 目前系统不区分零售/对公，所以此处不查询-数据集对象表数据
		String queryId = model.getCondition().get("queryId") != null ? model.getCondition().get("queryId") + "" : "";
		if (StringUtil.isNotEmpty(queryId)) {
			List<CrmFCiFqObjNodeVo> groupList = crmFCiFqGroupService.queryFqTreeData(queryId);
			//  灵活查询，分行及以上用户查询 自动在标签中隐藏 证件号码，手机号码 两个标签
			String orglevel = null;
			if (userInfoService.getOrgLevel().equals("1") || userInfoService.getOrgLevel().equals("2")) {
				orglevel = "orglevel";
			}
			List<CrmFCiFqObjNodeVo> dbColList = crmFCiFqDbcolService.queryFqTreeData(queryId, orglevel);
			groupList.addAll(dbColList);
			CrmFCiFqObjNodeVo root = new CrmFCiFqObjNodeVo();
			root.setNodeid("1");
			root.setName("根节点");
			root.setParentId("");
			root.setTables("1");
			appendChildren(root, groupList);
			List<CrmFCiFqObjNodeVo> data = new ArrayList<>();
			data.add(root);
			return data;
		} else {
			log.warn("param queryId is null in queryModel-condition");
			return null;
		}
	}

	/**
	 * 组装子节点数据
	 *
	 * @param parent
	 * @param all
	 */
	private void appendChildren(CrmFCiFqObjNodeVo parent, List<CrmFCiFqObjNodeVo> all) {
		List<CrmFCiFqObjNodeVo> children = all.stream().filter((node) -> node.getParentId().equals(parent.getNodeid())).collect(Collectors.toList());
		parent.setChildren(children);
		children.forEach((child) -> appendChildren(child, all));
	}

	/**
	 * @函数名称:queryDbColInfo
	 * @函数描述:查询灵活查询-字段属性信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public CrmFCiFqDbcol queryDbColInfo(QueryModel model) throws Exception {
		String id = model.getCondition().get("id") != null ? model.getCondition().get("id") + "" : "";
		if (StringUtil.isNotEmpty(id)) {
			return crmFCiFqDbcolService.selectByPrimaryKey(id);
		} else {
			log.warn("param id is null in queryModel-condition");
			return null;
		}
	}

	/**
	 * @函数名称:queryResult
	 * @函数描述:灵活查询结果接口
	 * @参数与返回说明:
	 * @算法描述:
	 */
//	@SuppressWarnings("unchecked")
//	public ResultDto<List<Map<String, Object>>> queryResult(QueryModel model) throws Exception {
//		Integer pageNum = model.getPage();
//		Integer pageSize = model.getSize();
//		if (pageNum == null || pageNum <= 0)
//			pageNum = 1;
//		if (pageSize == null || pageSize <= 0)
//			pageSize = 10;
//		Map<String, Object> queryCondition = model.getCondition();
//		List<Map<String, Object>> conditionList = (List<Map<String, Object>>) queryCondition.get("conditionAttrs");	// 查询条件
//		List<Map<String, Object>> resultsList = (List<Map<String, Object>>) queryCondition.get("results");	// 查询项
//
//		// 1、根据查询条件、数据权限构造ES-BoolQueryBuilder
//		BoolQueryBuilder queryBuilder = CmssFCiFqUtil.buildFqQueryBuilder(conditionList, false);
//		// 处理数据权限
//		if(userInfoService.isMgr()) {
//			queryBuilder.must(QueryBuilders.termQuery("mgrId", userInfoService.getUserInfo().getLoginCode()));
//		} else {
//			queryBuilder.must(QueryBuilders.wildcardQuery("orgSeq", "*" + userInfoService.getOrgCode() + "*"));
//		}
//		// 2、根据分页配置、排序字段、boolQueryBuilder构造 ES-NativeSearchQuery
//		NativeSearchQuery searchQuery = null;
//		NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder()
//				.withPageable(PageRequest.of(pageNum - 1, pageSize))	// 分页
//				.withQuery(queryBuilder);	// 查询条件
//		String columnEName  = null;
//		String sortType = null;
//		List<String> columnENameList = new ArrayList<String>();	// 暂存-展示字段名称，用于过滤非查询项字段
//		for(Map<String, Object> item: resultsList) {	// 根据展示项构造排序字段
//			sortType = item.get("sortType") != null ? item.get("sortType") + "" : "";	// 排序值， 1不排序  2正序  3逆序
//			columnEName = item.get("columnEName") != null ? item.get("columnEName") + "" : "";	// 字段名称
//			if(StringUtil.isEmpty(sortType) || StringUtil.isEmpty(columnEName)) {
//				continue;
//			}
//			if("2".equals(sortType)) {
//				searchQueryBuilder.withSort(SortBuilders.fieldSort(columnEName + ".keyword").order(SortOrder.ASC));
//			} else if("3".equals(sortType)) {
//				searchQueryBuilder.withSort(SortBuilders.fieldSort(columnEName + ".keyword").order(SortOrder.DESC));
//			}
//			columnENameList.add(columnEName);
//		}
//		searchQuery = searchQueryBuilder.build();
//		// 3、调用ElasticsearchUtil工具查询数据
//		ResultDto<List<Map<String, Object>>> resultDto = ElasticsearchUtil.getResultDto(searchQuery, CrmCustFlexibleInfoView.class);
//		List<Map<String, Object>> resultDtoList = resultDto.getData();
//		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();	// 目标结果集
//		// 4、根据查询项，过滤结果集中非查询项数据
//		Map<String, Object> resultMap = null;
//		for(Map<String, Object> item: resultDtoList) {
//			resultMap = new HashMap<String, Object>();
//			for(String key: columnENameList) {
//				resultMap.put(key, item.get(key));
//			}
//			resultList.add(resultMap);
//		}
//		resultDto.setData(resultList);
//		return resultDto;
//	}
	@SuppressWarnings("unchecked")
	public ResultDto<List<Map<String, Object>>> queryResult(QueryModel model) throws Exception {
		Map<String, Object> queryCondition = model.getCondition();
		List<Map<String, Object>> conditionList = (List<Map<String, Object>>) queryCondition.get("conditionAttrs");    // 查询条件
		List<Map<String, Object>> resultsList = (List<Map<String, Object>>) queryCondition.get("results");    // 查询项

		GenericObjectPool<TransportClient> clientPool = EsPool.getInstance();
		// 从池中取一个对象
		TransportClient client = clientPool.borrowObject();
		try {
			// 查询
			SearchRequestBuilder searchRequestBuilder = client.prepareSearch("crm_cust_flexible_info_view").setTypes("CRM_CUST_FLEXIBLE_INFO_VIEW");
			//searchRequestBuilder.setFetchSource("mgr_id,bel_cust_aum".split(","), new String[]{});
			// 1、根据查询条件、数据权限构造ES-BoolQueryBuilder
			BoolQueryBuilder queryBuilder = CmssFCiFqUtil.buildFqQueryBuilder(conditionList, false);
			// 处理数据权限
//			if(userInfoService.isMgr()&&queryCondition.get("queryType")==null) {
//				queryBuilder.must(QueryBuilders.termQuery("mgrId", userInfoService.getUserInfo().getLoginCode()));
//			} else {
//				queryBuilder.must(QueryBuilders.wildcardQuery("orgSeq", "*" + userInfoService.getOrgCode() + "*"));
//			}
			searchRequestBuilder.setQuery(queryBuilder);
			// 2、设置 es分页
			PageInfo pagingInfo = esUtilsMethodService.getPagingInfo(model);
			searchRequestBuilder.setFrom(pagingInfo.getSubStart()).setSize(pagingInfo.getPageSize());
			// 3、指定排序
			String columnEName = null;
			String sortType = null;
			String fieldType = null;
			List<String> columnENameList = new ArrayList<String>();    // 暂存-展示字段名称，用于过滤非查询项字段
			for (Map<String, Object> item : resultsList) {    // 根据展示项构造排序字段
				sortType = item.get("sortType") != null ? item.get("sortType") + "" : "";    // 排序值， 1不排序  2正序  3逆序
				columnEName = item.get("columnEName") != null ? item.get("columnEName") + "" : "";    // 字段名称
				fieldType = item.get("fieldType") != null ? item.get("fieldType") + "" : "";
				if (StringUtil.isEmpty(sortType) || StringUtil.isEmpty(columnEName)) {
					continue;
				}
				if ("2".equals(sortType)) {
					if ("2".equals(fieldType)) {
						searchRequestBuilder.addSort(columnEName, SortOrder.ASC);
					} else {
						searchRequestBuilder.addSort(columnEName + ".keyword", SortOrder.ASC);
					}

				} else if ("3".equals(sortType)) {
					if ("2".equals(fieldType)) {
						searchRequestBuilder.addSort(columnEName, SortOrder.DESC);
					} else {
						searchRequestBuilder.addSort(columnEName + ".keyword", SortOrder.DESC);
					}
				}
				columnENameList.add(columnEName);
			}
			// 4、获取结果
			SearchResponse response = searchRequestBuilder.execute().actionGet();
			SearchHits hits = response.getHits();
			Long totalNum = hits.getTotalHits();
			Iterator<SearchHit> iterator = hits.iterator();
			ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
			resultDto.setTotal(totalNum);
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();    // 目标结果集
			// 5、根据查询项，过滤结果集中非查询项数据
			Map<String, Object> resultMap = null;
			while (iterator.hasNext()) {
				SearchHit next = iterator.next();
				resultMap = new HashMap<String, Object>();
				for (String key : columnENameList) {
					resultMap.put(key, next.getSourceAsMap().get(key));
				}
				resultList.add(resultMap);
			}
			resultDto.setData(resultList);
			return resultDto;
		} finally {
			// 当出现错误时需要关闭连接
			clientPool.returnObject(client);
		}
	}

	/**
	 * @函数名称:querySolutionList
	 * @函数描述:查询灵活查询方案列表信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<Map<String, Object>> querySolutionList(QueryModel model) throws Exception {
		return crmFCiFqSsolutionService.querySolutionList(model);
	}

	/**
	 * @函数名称:checkSsNameIsRepeat
	 * @函数描述:判断方案名称是否重复
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public String checkSsNameIsRepeat(String ssName) throws Exception {
		List<CrmFCiFqSsolution> list = crmFCiFqSsolutionService.isRepeatSsName(ssName);
		if (list != null && list.size() > 0) {
			return list.get(0).getId();
		} else {
			return "0";
		}
	}

	/**
	 * @函数名称:queryFqScolBySsid
	 * @函数描述:查询-灵活查询方案-查询条件信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<Map<String, Object>> queryFqScolBySsid(String ssId) throws Exception {
		return crmFCiFqScolService.queryFqScolBySsid(ssId);
	}

	/**
	 * @函数名称: deleteFqSolutionInfo
	 * @函数描述: 删除灵活查询方案信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public Integer deleteFqSolutionInfo(String ids) throws Exception {
		try {
			if (StringUtil.isNotEmpty(ids)) {
				crmFCiFqScolService.deleteBySsIds(ids);
				return crmFCiFqSsolutionService.deleteBySsIds(ids);
			} else {
				log.warn("ids is null, cannot deleteFqSolutionInfo");
				return -1;
			}
		} catch (Exception e) {
			log.error("deleteFqSolutionInfo error ids:{}", ids, e);
			throw e;
		}
	}

	/**
	 * @函数名称: upsertFqSolutionInfo
	 * @函数描述: 维护灵活查询方案信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public String upsertFqSolutionInfo(CrmFCiFqSsolutionModel model) throws Exception {
		try {
			CrmFCiFqSsolution solutionInfo = model.getSolutionInfo();
			List<CrmFCiFqScol> solutionScolInfoList = model.getSolutionScolInfoList();
			if (StringUtil.isNotEmpty(solutionInfo.getId())) {    // 修改-方案信息
				String ssId = solutionInfo.getId();
				crmFCiFqSsolutionService.updateSelective(solutionInfo);
				crmFCiFqScolService.deleteBySsIds(ssId);    // 先根据方案主键，删除查询条件表数据
				if (solutionScolInfoList != null && solutionScolInfoList.size() > 0) {
					for (CrmFCiFqScol scolInfo : solutionScolInfoList) {
						scolInfo.setSsId(ssId);
						scolInfo.setId(null);
						crmFCiFqScolService.insertSelective(scolInfo);
					}
				}
				return ssId;
			} else {    // 新增方案信息
				solutionInfo.setSsDate(new Date());
				solutionInfo.setSsUser(userInfoService.getUserInfo().getLoginCode());
				solutionInfo.setCreateOrg(userInfoService.getOrgCode());
				crmFCiFqSsolutionService.insertSelective(solutionInfo);
				String ssId = solutionInfo.getId();
				if (solutionScolInfoList != null && solutionScolInfoList.size() > 0) {
					for (CrmFCiFqScol scolInfo : solutionScolInfoList) {
						scolInfo.setSsId(ssId);
						scolInfo.setId(null);
						crmFCiFqScolService.insertSelective(scolInfo);
					}
				}
				return ssId;
			}
		} catch (Exception e) {
			log.error("upsertFqSolutionInfo error ", e);
			throw e;
		}
	}

	/**
	 * @函数名称:buildFqMarkParam
	 * @函数描述:根据查询条件，构造营销活动使用的参数
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> buildFqMarkParam(QueryModel model) throws Exception {
		Map<String, Object> queryCondition = model.getCondition();
		List<Map<String, Object>> conditionList = (List<Map<String, Object>>) queryCondition.get("conditionAttrs");    // 查询条件
		String ruleParam = "select CUST_ID from CRM_CUST_FLEXIBLE_INFO_VIEW where 1=1 ";
		String ruleContentCh = "";
		String ssColType = null;
		String ssColEname = null;
		String ssColCname = null;
		String ssColOp = null;
		Object ssColValue = null;
		String ssColValueNotes = null;
		for (Map<String, Object> item : conditionList) {
			ssColType = item.get("ssColType") != null ? item.get("ssColType") + "" : "";    // 组件类型
			ssColEname = item.get("ssColEname") != null ? item.get("ssColEname") + "" : "";    // 字段英文名称
			ssColEname = UimpBaseTools.humpToLine2(ssColEname);    // 驼峰转下划线
			ssColCname = item.get("ssColCname") != null ? item.get("ssColCname") + "" : "";    // 字段中文名称
			ssColOp = item.get("ssColOp") != null ? item.get("ssColOp") + "" : "";    // 操作符值
			ssColValue = item.get("ssColValue") != null ? item.get("ssColValue") : null;    // 属性值，考虑多选框值为数组，此处使用Object接收数据
			ssColValueNotes = item.get("ssColValueNotes") != null ? item.get("ssColValueNotes") + "" : "";    // 字段值数据字典Code
			if ("2".equals(ssColType)) {    // number字段处理
				if (",1,2,3,4".indexOf(ssColOp) > 0) {    // 大于/小于/大于等于/小于等于
					switch (ssColOp) {
						case "1":
							ruleParam += " and " + ssColEname + ">" + ssColValue;
							ruleContentCh += ssColCname + " 大于 " + ssColValue + ";";
							break;
						case "2":
							ruleParam += " and " + ssColEname + "<" + ssColValue;
							ruleContentCh += ssColCname + " 小于 " + ssColValue + ";";
							break;
						case "3":
							ruleParam += " and " + ssColEname + ">=" + ssColValue;
							ruleContentCh += ssColCname + " 大于等于 " + ssColValue + ";";
							break;
						case "4":
							ruleParam += " and " + ssColEname + "<=" + ssColValue;
							ruleContentCh += ssColCname + " 小于等于 " + ssColValue + ";";
							break;
					}
				} else if ("5".equals(ssColOp)) {    // 等于
					ruleParam += " and " + ssColEname + "=" + ssColValue;
					ruleContentCh += ssColCname + " 等于 " + ssColValue + ";";
				} else if ("9".equals(ssColOp)) {    // 区间
					String[] numberValue = (ssColValue + "").split("\\$");
					ruleParam += " and (" + ssColEname + ">=" + numberValue[0] + " and " + ssColEname + "<=" + numberValue[1] + ")";
					ruleContentCh += ssColCname + " 大于等于 " + numberValue[0] + ", 小于等于 " + numberValue[1] + ";";
				}
			} else if ("3".equals(ssColType)) {    // datepicker字段处理
				if (",1,2,3,4".indexOf(ssColOp) > 0) {    // 大于/小于/大于等于/小于等于
					switch (ssColOp) {
						case "1":
							ruleParam += " and to_date(" + ssColEname + ", 'yyyy-MM-dd') > to_date('" + ssColValue + "', 'yyyy-MM-dd')";
							ruleContentCh += ssColCname + " 大于 " + ssColValue + ";";
							break;
						case "2":
							ruleParam += " and to_date(" + ssColEname + ", 'yyyy-MM-dd') < to_date('" + ssColValue + "', 'yyyy-MM-dd')";
							ruleContentCh += ssColCname + " 小于 " + ssColValue + ";";
							break;
						case "3":
							ruleParam += " and to_date(" + ssColEname + ", 'yyyy-MM-dd') >= to_date('" + ssColValue + "', 'yyyy-MM-dd')";
							ruleContentCh += ssColCname + " 大于等于 " + ssColValue + ";";
							break;
						case "4":
							ruleParam += " and to_date(" + ssColEname + ", 'yyyy-MM-dd') <= to_date('" + ssColValue + "', 'yyyy-MM-dd')";
							ruleContentCh += ssColCname + " 小于等于 " + ssColValue + ";";
							break;
					}
				} else if ("5".equals(ssColOp)) {    // 等于
					ruleParam += " and to_date(" + ssColEname + ", 'yyyy-MM-dd') = to_date('" + ssColValue + "', 'yyyy-MM-dd')";
					ruleContentCh += ssColCname + " 等于 " + ssColValue + ";";
				} else if ("9".equals(ssColOp)) {    // 区间
					String[] dateValue = (ssColValue + "").split("\\$");
					ruleParam += " and ( to_date(" + ssColEname + ", 'yyyy-MM-dd') >= to_date('" + dateValue[0] + "', 'yyyy-MM-dd') "
							+ "and to_date(" + ssColEname + ", 'yyyy-MM-dd') <= to_date('" + dateValue[1] + "', 'yyyy-MM-dd') )";
					ruleContentCh += ssColCname + " 大于等于 " + dateValue[0] + ", 小于等于 " + dateValue[1] + ";";
				}
			} else if ("1".equals(ssColType)) {    // 1-2、input字段处理
				if ("1".equals(ssColOp)) {    // 等于
					ruleParam += " and " + ssColEname + "='" + ssColValue + "'";
					ruleContentCh += ssColCname + " 等于 " + ssColValue + ";";
				} else {    // 模糊匹配
					ruleParam += " and " + ssColEname + " like '%" + ssColValue + "%'";
					ruleContentCh += ssColCname + " 模糊匹配 " + ssColValue + ";";
				}
			} else if ("6".equals(ssColType)) {    // 1-3、多选select字段处理
				List<String> ssColValueList = (List<String>) ssColValue;
				ruleParam += " and " + ssColEname + " in (";
				for (String tempColValue : ssColValueList) {
					ruleParam += "'" + tempColValue + "',";
				}
				ruleParam = ruleParam.substring(0, ruleParam.length() - 1);
				ruleParam += ")";
				if (StringUtil.isNotEmpty(ssColValueNotes)) {
					List<String> tempColNameList = adminSmLookupItemService.getLookupItemNameByLookupCodeAndLookupItemCode(ssColValueNotes, ssColValueList);
					ruleContentCh += ssColCname + " 匹配 " + String.join("/", tempColNameList) + ";";
				} else {
					ruleContentCh += ssColCname + " 匹配 " + String.join("/", ssColValueList) + ";";
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ruleParam", ruleParam);
		map.put("ruleContentCh", ruleContentCh);
		return map;
	}

	public int updateEsUserQuery(CrmFEsUserQuery crmFEsUserQuery) throws InvocationTargetException, IllegalAccessException {
		if (StringUtil.isNotEmpty(crmFEsUserQuery.getUserId()) && StringUtil.isNotEmpty(crmFEsUserQuery.getQueryType()) && crmFEsUserQuery.getCrmFEsUserQueryDTOList().size() > 0) {
			Map<String, String> map = new HashMap<>();
			map.put("userId", crmFEsUserQuery.getUserId());
			map.put("queryType", crmFEsUserQuery.getQueryType());
			adminSmLookupItemService.deleteEsUserQuery(map);
			List<CrmFEsUserQueryVO> list = new ArrayList<>();
			String date = simpleDateFormat.format(new Date());
			List<CrmFEsUserQueryDTO> crmFEsUserQueryDTOList = crmFEsUserQuery.getCrmFEsUserQueryDTOList();
			for (CrmFEsUserQueryDTO crmFEsUserQueryDTO : crmFEsUserQueryDTOList) {
				CrmFEsUserQueryVO crmFEsUserQueryVO = new CrmFEsUserQueryVO();
				crmFEsUserQueryVO.setSeqno(UtilsTools.getUUID());
				crmFEsUserQueryVO.setUserId(crmFEsUserQuery.getUserId());
				crmFEsUserQueryVO.setUserName(crmFEsUserQuery.getUserName());
				crmFEsUserQueryVO.setUpdateDate(date);
				crmFEsUserQueryVO.setQueryType(crmFEsUserQuery.getQueryType());
				//BeanUtils.copyProperties(crmFEsUserQueryDTO, crmFEsUserQueryVO);
				BeanUtils.copyProperties(crmFEsUserQueryVO, crmFEsUserQueryDTO);
				list.add(crmFEsUserQueryVO);
			}
			adminSmLookupItemService.insertEsUserQuery(list);
		} else {
			return -1;
		}
		return 0;
	}

	public List<CrmFEsUserQueryVO> getEsUserQueryList(String userId) {
		return adminSmLookupItemService.getEsUserQueryList(userId);
	}

	public String insertEsExportQuery(QueryModel model) throws InvocationTargetException, IllegalAccessException {
		Map<String, Object> queryCondition = model.getCondition();
		List<Map<String, Object>> conditionList = (List<Map<String, Object>>) queryCondition.get("conditionAttrs");    // 查询条件
		List<Map<String, Object>> resultsList = (List<Map<String, Object>>) queryCondition.get("results");    // 查询项
		//conditionList.addAll(resultsList);
		List<CrmFEsExportQuery> list = new ArrayList<>();
		List<CrmFEsExportZhQuery> list2 = new ArrayList<>();
		String date = simpleDateFormat.format(new Date());
		String password = getpassword();
		String seqNo = null;
		for (Map<String, Object> m : conditionList) {
			if (seqNo == null) {
				seqNo = (String) m.get("seqno");
			}
			if (m.get("ssColValue") instanceof List) {
				m.put("ssColValue", String.join(",", (List<String>) m.get("ssColValue")));
			}
			CrmFEsExportQuery crmFEsExportQuery = new CrmFEsExportQuery();
			crmFEsExportQuery.setCreateDate(date);
			crmFEsExportQuery.setCreateUser(getUserInfoDTO().getLoginCode());
			crmFEsExportQuery.setPassword(password);
			BeanUtils.populate(crmFEsExportQuery, m);
			list.add(crmFEsExportQuery);
		}
		for (Map<String, Object> m : resultsList) {
			if (seqNo == null) {
				seqNo = (String) m.get("seqno");
			}
			CrmFEsExportZhQuery crmFEsExportZhQuery = new CrmFEsExportZhQuery();
			crmFEsExportZhQuery.setCreateDate(date);
			crmFEsExportZhQuery.setCreateUser(getUserInfoDTO().getLoginCode());
			BeanUtils.populate(crmFEsExportZhQuery, m);
			list2.add(crmFEsExportZhQuery);
		}
		adminSmLookupItemService.insertEsExportQuery(list);
		adminSmLookupItemService.insertEsExportZhQuery(list2);
		return password;
	}

	//生成随机六位数并base64加密
	private String getpassword() {
		String value = "0123456789";
		Random rand = new Random();
		StringBuffer str = new StringBuffer();
		for (int j = 0; j < 6; j++) {
			str.append(value.charAt(rand.nextInt(9)) + "");
		}
		return Base64.getEncoder().encodeToString(str.toString().getBytes());
	}

	//base64解密
	private String getDecopassword(String password) {
		byte[] decode = Base64.getDecoder().decode(password);
		String value = new String(decode);
		return value;
	}

	public CrmFEsExportQueryVO getEsExportQueryList(QueryModel model) {
		CrmFEsExportQueryVO crmFEsExportQueryVO = new CrmFEsExportQueryVO();
		Map<String, String> map = new HashMap<>();
		map.put("userId", (String) model.getCondition().get("userId"));
		map.put("seqno", (String) model.getCondition().get("seqno"));
		//查询条件
		List<CrmFEsExportQuery> esExportQueryList = adminSmLookupItemService.getEsExportQueryList(map);
		crmFEsExportQueryVO.setCrmFEsExportQueryList(esExportQueryList);
		//展示列
		List<CrmFEsExportZhQuery> esExportZhQueryList = adminSmLookupItemService.getEsExportZhQueryList(map);
		crmFEsExportQueryVO.setCrmFEsExportZhQueryList(esExportZhQueryList);
		return crmFEsExportQueryVO;
	}

	public List exportExportQuery(HttpServletResponse response, String seqno) throws Exception {

	/*	alter table OCRM_F_ES_EXPORT_QUERY add CONDITION_TYPE VARCHAR2(4);
		COMMENT ON COLUMN OCRM_F_ES_EXPORT_QUERY.CONDITION_TYPE IS '查询类型（01：业务模式：02：excel导入模式）';
*/
		Map<String, String> map = new HashMap<>();
		map.put("seqno", seqno);
		List<CrmFEsExportQuery> list = adminSmLookupItemService.getEsExportQueryList(map);
		List<CrmFEsExportZhQuery> esExportZhQueryList = adminSmLookupItemService.getEsExportZhQueryList(map);
		List<Map<String, Object>> conditionList = new ArrayList<>();
		List<Map<String, Object>> resultsList = new ArrayList<>();
		List<EsExportQuerycondition> EsExportQueryconditionList = new ArrayList<>();
		List<EsExportQueryresults> EsExportQueryresultsList = new ArrayList<>();
		String password = "";
		for (CrmFEsExportQuery CrmFEsExportQuery : list) {
			EsExportQuerycondition esExportQuerycondition = new EsExportQuerycondition();
			BeanUtils.copyProperties(esExportQuerycondition, CrmFEsExportQuery);
			password = getDecopassword(CrmFEsExportQuery.getPassword());

			EsExportQueryconditionList.add(esExportQuerycondition);
		}
		for (CrmFEsExportZhQuery crmFEsExportZhQuery : esExportZhQueryList) {
			EsExportQueryresults esExportQueryresults = new EsExportQueryresults();
			BeanUtils.copyProperties(esExportQueryresults, crmFEsExportZhQuery);
			EsExportQueryresultsList.add(esExportQueryresults);
		}

		if (CollectionUtils.isNotEmpty(EsExportQueryconditionList)) {
			for (EsExportQuerycondition listmap : EsExportQueryconditionList) {
				Map<String, Object> mapp = new HashMap<String, Object>();
				mapp = JSONObject.parseObject(JSONObject.toJSONString(listmap), Map.class);
				conditionList.add(mapp);
			}
		}
		if (CollectionUtils.isNotEmpty(EsExportQueryresultsList)) {
			for (EsExportQueryresults listmap : EsExportQueryresultsList) {
				Map<String, Object> mapp = new HashMap<String, Object>();
				mapp = JSONObject.parseObject(JSONObject.toJSONString(listmap), Map.class);
				resultsList.add(mapp);
			}
		}

		GenericObjectPool<TransportClient> clientPool = EsPool.getInstance();
		// 从池中取一个对象
		TransportClient client = clientPool.borrowObject();
		try {
			// 查询
			SearchRequestBuilder searchRequestBuilder = client.prepareSearch("crm_cust_flexible_info_view").setTypes("CRM_CUST_FLEXIBLE_INFO_VIEW");
			BoolQueryBuilder queryBuilder = CmssFCiFqUtil.buildFqQueryBuilder(conditionList, false);
			searchRequestBuilder.setQuery(queryBuilder);
			QueryModel model = new QueryModel();
			model.setPage(1);
			model.setSize(10000);
			// 2、设置 es分页
			PageInfo pagingInfo = esUtilsMethodService.getPagingInfo(model);
			searchRequestBuilder.setFrom(pagingInfo.getSubStart()).setSize(pagingInfo.getPageSize());

			// 3、指定排序
			String columnEName = null;
			String columnName = null;
			String sortType = null;
			String fieldType = null;
			List<String> columnENameList = new ArrayList<String>();    // 暂存-展示字段名称，用于过滤非查询项字段
			List<String> columnNameList = new ArrayList<String>();
			for (Map<String, Object> item : resultsList) {    // 根据展示项构造排序字段
				sortType = item.get("sortType") != null ? item.get("sortType") + "" : "";    // 排序值， 1不排序  2正序  3逆序
				columnEName = item.get("columnEName") != null ? item.get("columnEName") + "" : "";    // 字段名称
				columnName = item.get("columnName") != null ? item.get("columnName") + "" : "";    // 字段名称
				fieldType = item.get("fieldType") != null ? item.get("fieldType") + "" : "";
				if (StringUtil.isEmpty(sortType) || StringUtil.isEmpty(columnEName)) {
					continue;
				}
				if ("2".equals(sortType)) {
					if ("2".equals(fieldType)) {
						searchRequestBuilder.addSort(columnEName, SortOrder.ASC);
					} else {
						searchRequestBuilder.addSort(columnEName + ".keyword", SortOrder.ASC);
					}

				} else if ("3".equals(sortType)) {
					if ("2".equals(fieldType)) {
						searchRequestBuilder.addSort(columnEName, SortOrder.DESC);
					} else {
						searchRequestBuilder.addSort(columnEName + ".keyword", SortOrder.DESC);
					}
				}
				columnENameList.add(columnEName);
				columnNameList.add(columnName);
			}
			//查询码值字典
			Map<String, List<Map<String, Object>>> listMap = adminSmLookupItemService.selectBymZ(columnENameList);
			// 4、获取结果
			SearchResponse responses = searchRequestBuilder.execute().actionGet();
			SearchHits hits = responses.getHits();
			Long totalNum = hits.getTotalHits();
			Iterator<SearchHit> iterator = hits.iterator();
			ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
			resultDto.setTotal(totalNum);
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();    // 目标结果集
			List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();    // 目标结果集
			// 5、根据查询项，过滤结果集中非查询项数据
			Map<String, Object> resultMap = null;
			while (iterator.hasNext()) {
				SearchHit next = iterator.next();
				resultMap = new HashMap<String, Object>();
				for (String key : columnENameList) {
					if (desensitized.contains(key + ",")) {
						//托敏
						resultMap.put(key, desensitizedUtils.desensitizedName(next.getSourceAsMap().get(key)));
					} else {
						//转码
						Set<String> set = listMap.keySet();
						if (set.contains(HumpToUnderlineTtils.humpToUnderline(key))) {
							for (String maps : listMap.keySet()) {
								if (HumpToUnderlineTtils.humpToUnderline(key).equals(maps)) {
									List<Map<String, Object>> list1 = listMap.get(maps);
									for (Map<String, Object> map2 : list1) {
										for (String k : map2.keySet()) {
											if (next.getSourceAsMap().get(key) != null && next.getSourceAsMap().get(key) != "") {
												if (String.valueOf(next.getSourceAsMap().get(key)).equals(k)) {
													resultMap.put(key, map2.get(k));
												}
											}
										}
									}
								}
							}
						} else {
							resultMap.put(key, next.getSourceAsMap().get(key));
						}
					}
					resultList.add(resultMap);
				}
			}
			resultList = resultList.stream().distinct().collect(Collectors.toList());
			//表头数组
			String[] lables = columnNameList.toArray(new String[columnNameList.size()]);
			//查询数据对应的属性数组
			String[] fields = columnENameList.toArray(new String[columnENameList.size()]);
			String title = "灵活查询客户信息表";
			ExportExcel.export(response, resultList, lables, fields, title, password);
		} finally {
			// 当出现错误时需要关闭连接
			clientPool.returnObject(client);
		}
		return null;
	}

	public int deleteExportQuery(String seqno) {
		if (StringUtils.isNotEmpty(seqno)) {
			adminSmLookupItemService.deleteExportQuery(seqno);
		}
		return 0;
	}


	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String, Object> uploadtriumph(MultipartFile file) throws Exception {
		Map<String, Object> reMap = new HashMap<>();
		try {
			InputStream stream = FileUtil.vaildataFile(file);
			ExeclParseUtil execlParseUtil = new ExeclParseUtil();
			List<CustNdsDTO> execlList = execlParseUtil.getEntity(1,stream, CustNdsDTO.class);
			//ecif号集合
			List<String> execlListList=new ArrayList<>();
			//nds号集合
			List<String> execlListList2=new ArrayList<>();
			for(CustNdsDTO custNdsDTO:execlList){
				if(custNdsDTO.getCustNo().length()==10){
					execlListList.add(custNdsDTO.getCustNo());
				}else{
					execlListList2.add(custNdsDTO.getCustNo());
				}
			}
		/*	//去除list中的NULL值
			execlListList.removeAll(Collections.singleton(null));
			execlListList2.removeAll(Collections.singleton(null));*/
			String custNo =execlListList.stream().map(String::valueOf).collect(Collectors.joining(","));
			String ndsCustNo = execlListList2.stream().map(String::valueOf).collect(Collectors.joining(","));
			Map<String, Object> map = new HashMap<>();
			map.put("custNo",custNo);
			map.put("ndsCustNo",ndsCustNo);
			reMap.put("data", map);
			reMap.put("message", "succese");
			return reMap;
		} catch (Exception e) {
			reMap.put("error",e.getMessage());
			reMap.put("message","error");
			return reMap;
		}
	}

	public ResultDto<List<Map<String, Object>>> getExportQuery(QueryModel model) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("seqno", String.valueOf(model.getCondition().get("seqno")));
		List<CrmFEsExportQuery> list = adminSmLookupItemService.getEsExportQueryList(map);
		List<CrmFEsExportZhQuery> esExportZhQueryList = adminSmLookupItemService.getEsExportZhQueryList(map);
		List<Map<String, Object>> conditionList = new ArrayList<>();
		List<Map<String, Object>> resultsList = new ArrayList<>();
		List<EsExportQuerycondition> EsExportQueryconditionList = new ArrayList<>();
		List<EsExportQueryresults> EsExportQueryresultsList = new ArrayList<>();
		String password = "";
		for (CrmFEsExportQuery CrmFEsExportQuery : list) {
			EsExportQuerycondition esExportQuerycondition = new EsExportQuerycondition();
			BeanUtils.copyProperties(esExportQuerycondition, CrmFEsExportQuery);
			password = getDecopassword(CrmFEsExportQuery.getPassword());

			EsExportQueryconditionList.add(esExportQuerycondition);
		}
		for (CrmFEsExportZhQuery crmFEsExportZhQuery : esExportZhQueryList) {
			EsExportQueryresults esExportQueryresults = new EsExportQueryresults();
			BeanUtils.copyProperties(esExportQueryresults, crmFEsExportZhQuery);
			EsExportQueryresultsList.add(esExportQueryresults);
		}
		if (CollectionUtils.isNotEmpty(EsExportQueryconditionList)) {
			for (EsExportQuerycondition listmap : EsExportQueryconditionList) {
				Map<String, Object> mapp = new HashMap<String, Object>();
				mapp = JSONObject.parseObject(JSONObject.toJSONString(listmap), Map.class);
				conditionList.add(mapp);
			}
		}
		if (CollectionUtils.isNotEmpty(EsExportQueryresultsList)) {
			for (EsExportQueryresults listmap : EsExportQueryresultsList) {
				Map<String, Object> mapp = new HashMap<String, Object>();
				mapp = JSONObject.parseObject(JSONObject.toJSONString(listmap), Map.class);
				resultsList.add(mapp);
			}
		}

		GenericObjectPool<TransportClient> clientPool = EsPool.getInstance();
		// 从池中取一个对象
		TransportClient client = clientPool.borrowObject();
		try {
			// 查询
			SearchRequestBuilder searchRequestBuilder = client.prepareSearch("crm_cust_flexible_info_view").setTypes("CRM_CUST_FLEXIBLE_INFO_VIEW");
			BoolQueryBuilder queryBuilder = CmssFCiFqUtil.buildFqQueryBuilder(conditionList, false);
			searchRequestBuilder.setQuery(queryBuilder);
			// 2、设置 es分页
			PageInfo pagingInfo = esUtilsMethodService.getPagingInfo(model);
			searchRequestBuilder.setFrom(pagingInfo.getSubStart()).setSize(pagingInfo.getPageSize());

			// 3、指定排序
			String columnEName = null;
			String columnName = null;
			String sortType = null;
			String fieldType = null;
			List<String> columnENameList = new ArrayList<String>();    // 暂存-展示字段名称，用于过滤非查询项字段
			List<String> columnNameList = new ArrayList<String>();
			for (Map<String, Object> item : resultsList) {    // 根据展示项构造排序字段
				sortType = item.get("sortType") != null ? item.get("sortType") + "" : "";    // 排序值， 1不排序  2正序  3逆序
				columnEName = item.get("columnEName") != null ? item.get("columnEName") + "" : "";    // 字段名称
				columnName = item.get("columnName") != null ? item.get("columnName") + "" : "";    // 字段名称
				fieldType = item.get("fieldType") != null ? item.get("fieldType") + "" : "";
				if (StringUtil.isEmpty(sortType) || StringUtil.isEmpty(columnEName)) {
					continue;
				}
				if ("2".equals(sortType)) {
					if ("2".equals(fieldType)) {
						searchRequestBuilder.addSort(columnEName, SortOrder.ASC);
					} else {
						searchRequestBuilder.addSort(columnEName + ".keyword", SortOrder.ASC);
					}

				} else if ("3".equals(sortType)) {
					if ("2".equals(fieldType)) {
						searchRequestBuilder.addSort(columnEName, SortOrder.DESC);
					} else {
						searchRequestBuilder.addSort(columnEName + ".keyword", SortOrder.DESC);
					}
				}
				columnENameList.add(columnEName);
				columnNameList.add(columnName);
			}
			// 4、获取结果
			SearchResponse responses = searchRequestBuilder.execute().actionGet();
			SearchHits hits = responses.getHits();
			Long totalNum = hits.getTotalHits();
			Iterator<SearchHit> iterator = hits.iterator();
			ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
			resultDto.setTotal(totalNum);
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();    // 目标结果集
			// 5、根据查询项，过滤结果集中非查询项数据
			Map<String, Object> resultMap = null;
			while (iterator.hasNext()) {
				SearchHit next = iterator.next();
				resultMap = new HashMap<String, Object>();
				for (String key : columnENameList) {
					resultMap.put(key, next.getSourceAsMap().get(key));
				}
				resultList.add(resultMap);
			}
			resultDto.setData(resultList);
			return resultDto;
		} finally {
			// 当出现错误时需要关闭连接
			clientPool.returnObject(client);
		}
	}

}