package cn.com.yusys.yusp.uimp.business.pma.app.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper.AppGuessMapper;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.FUN_SUB_TYPE;
import cn.com.yusys.yusp.uimp.distribution.service.CommonDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AppGuessService extends CommonService{
	 @Autowired
	 private AppGuessMapper appGuessMapper;
	 private static Pattern linePattern = Pattern.compile("_(\\w)");
	 @Autowired
	 private UserInfoService userInfoService;
	 
	 @Autowired
	 private MetaFunctionManagerService metaFunctionManagerService;
	 
	 @Autowired
	 private CommonDistributionService commonDistributionService;
	 
	 @Override
	 protected CommonMapper<?> getMapper() {
	     return appGuessMapper;
	 }
	 
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryBusTypeSub(QueryModel model) {
		List<Map<String, Object>> list = this.appGuessMapper.queryBusTypeSub(model);
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryParam(QueryModel model) {
		List<Map<String, Object>> list = null;
		model.getCondition().put("orgId", userInfoService.getGrantOrgCode());
		// 针对贷款特别处理，各种靠档、按揭，乱七八糟一大堆
		if("PERLN".equals(model.getCondition().get("busType")) || "COMLN".equals(model.getCondition().get("busType"))) {
			String paramId = model.getCondition().get("paramId") + "";
			String bussSeq = model.getCondition().get("bussSeq") + "";
			Integer term = Integer.parseInt(model.getCondition().get("term") + "");
			if("PERLN".equals(model.getCondition().get("busType")) && bussSeq.indexOf("按揭") >= 0) {
				paramId += "AJ";
			} else if (term < 6) {
				paramId += "3";
			} else if (term < 12) {
				paramId += "6";
			} else if (term < 24) {
				paramId += "12";
			} else if (term < 36) {
				paramId += "24";
			} else if (term < 60) {
				paramId += "36";
			} else if (term == 60) {
				paramId += "60";
			} else {
				paramId += "MAX";
			}
			model.getCondition().put("paramId", paramId);
			list = this.appGuessMapper.queryParamByInfo(model);
		} else {
			list = this.appGuessMapper.queryParamByList(model);
			if(list.size() <= 0) {
				list = this.appGuessMapper.queryParamByInfo(model);
			}
		}
		return list;
	}
	
	public Map<String,Object> calculate(Map<String,Object> map){
		//获取金额、业务种类、业务子类、资金成本、执行利率
		String amt = map.get("amt").toString();//金额
		String busType = map.get("busType").toString();//业务种类
		String fundCost = map.get("fundCost").toString();//资金成本
		String rate = map.get("rate").toString();//执行利率
		String profit = null;//利润
		String performance = null;//绩效
		//业绩测算公式
		BigDecimal bigmid = null;
		if("RDP".equals(busType) || "CDP".equals(busType)) {
			//利润=金额*（资金-利率）
			bigmid = new BigDecimal(fundCost).subtract(new BigDecimal(rate)); 
		} else {
			//利润=金额*（利率 -资金）
			bigmid = new BigDecimal(rate).subtract(new BigDecimal(fundCost)); 
		}
		profit = (bigmid.multiply(new BigDecimal(amt)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString();
		//获取一次兑现系数
		QueryModel model = new QueryModel();
		model.getCondition().put("paramId", "PONCE");
		List<Map<String, Object>> list = queryParam(model);
		if(list.size() == 1) {
			String param = list.get(0).get("paramValue").toString();
			performance = (new BigDecimal(param).multiply(new BigDecimal(profit)).setScale(2, BigDecimal.ROUND_HALF_UP)).toString();
		} else {
			performance = "0";
		}
		map.put("profit", profit);
		map.put("performance", performance);
		return map;
	}
	
	public Map<String, Object> queryFunCfg(QueryModel queryModel) throws Exception{
		Map<String, Object> result = new HashMap<String,Object>();
		List<Map<String, Object>> listCfg = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> listPk = new ArrayList<Map<String,Object>>();
		String funCode = queryModel.getCondition().get("funCode").toString();
		/** 获取功能信息缓存 */
		Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
		Map<String, String> tableMap = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
		String infoTableCode = tableMap.get("tableCode");
		Map<String, Object> columnInfoMap = (Map<String, Object>) funInfoMap.get("columnInfo");
		Map<String, Object> columnCfgInfoMap = (Map<String, Object>) funInfoMap.get("columnCfgInfo");
		Map<String, Map<String, Object>> columnMap = (Map<String, Map<String, Object>>) columnInfoMap.get(infoTableCode);
		Set<String> columnSet = columnMap.keySet();
		for (String columnCode : columnSet) {
			Map<String, Object> cfgMap = (Map<String, Object>) columnCfgInfoMap.get(columnCode);
			if (cfgMap != null && "1".equals(cfgMap.get("APP_GRID_FIELD"))) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("name",lineToHump(columnMap.get(columnCode).get("columnName").toString()));
				map.put("ename",columnMap.get(columnCode).get("columnCnName").toString());
				map.put("sort",columnMap.get(columnCode).get("sort").toString());
				if(cfgMap.get("APP_LOOKUP_ID")!=null) {
					map.put("dataCode",cfgMap.get("APP_LOOKUP_ID").toString());
				}
				listCfg.add(map);
			}
			if (cfgMap != null && "1".equals(cfgMap.get("IS_PK"))) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("name",lineToHump(columnMap.get(columnCode).get("columnName").toString()));
				map.put("ename",columnMap.get(columnCode).get("columnCnName").toString());
				listPk.add(map);
			}
		}
		result.put("columnCfg", listCfg);
		result.put("pkCfg", listPk);
		return result;
	}
	/**
	 * 下划线转驼峰
	 * @param str
	 * @return
	 */
    public  String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
	public List<Map<String, Object>> queryFun(){
		List<Map<String, Object>> list = this.appGuessMapper.queryFun();
		return list;
	}
	
	public List<Map<String, Object>> queryPeriod(QueryModel model) throws Exception{
		List<Map<String, Object>> list = this.commonDistributionService.queryPeriodHisTableForVet(model);
		if(list.size() > 0) {
			for (int i=0;i<list.size();i++) {
				QueryModel modelTwo = new QueryModel();
				modelTwo.getCondition().put("periodId", list.get(i).get("id").toString());
				modelTwo.getCondition().put("funCode", model.getCondition().get("funCode").toString());
				List<Map<String,Object>> detailList = commonDistributionService.queryDistributeHisTable(modelTwo);
				list.get(i).put("list", detailList);
			}
		}
		return list;
	}
}
