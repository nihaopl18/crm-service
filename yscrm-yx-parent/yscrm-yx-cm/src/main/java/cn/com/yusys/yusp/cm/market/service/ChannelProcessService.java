package cn.com.yusys.yusp.cm.market.service;


import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlActivityMapper;
import cn.com.yusys.climp.acty.service.LoyRlActivityService;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmChannelResultInfo;
import cn.com.yusys.yusp.cm.market.repository.mapper.ChannelProcessMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.EngProcessMapper;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleResultLog;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleResultLogMapper;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcMyTask;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcNiche;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTaskPool;
import cn.com.yusys.yusp.cm.taskcenter.domain.CmFRcMarketBack;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CimFTcMyTaskMapper;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CimFTcNicheMapper;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CimFTcTaskPoolMapper;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CmFRcMarketBackMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @项目名称：yscimc-service
 * @类名称：ChannelProcessService
 * @类描述：挖掘类流程处理相关SERVICE
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2018-11-19
 */
@Service
public class ChannelProcessService  extends CommonService{
	
	private static Logger logger = Logger.getLogger(ChannelProcessService.class ) ;
	@Autowired
	private UserInfoService userInfo; 
	@Autowired
	private ChannelProcessMapper connMapper;
	@Autowired
	private CimFTcTaskPoolMapper taskMapper;
	@Autowired
	private CimFTcNicheMapper nicheMapper;
	@Autowired
	private CimFTcMyTaskMapper mytaskMapper;
	@Autowired
	private CmFRcRuleResultLogMapper logMapper;
	@Autowired
	private CmFRcMarketBackMapper backMapper;
	@Autowired
	private LoyRlActivityMapper actyMapper;
	@Autowired
	private LoyRlActivityService actyService;
	@Autowired
	private EngProcessMapper engPro;
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.connMapper;
	}
	private static Pattern linePattern = Pattern.compile("_(\\w)");
	 /**组件信息**/
	 List<Map<String, Object>> itemsInfo =new ArrayList<Map<String, Object>>();
	 /**组件客户信息**/
	 List<Map<String, Object>> custInfo =new ArrayList<Map<String, Object>>();
	 /**组件产品信息**/
	 List<Map<String, Object>> prodInfo=new ArrayList<Map<String, Object>>();
	 /**组件操作信息**/
	 Map<String, List<Map<String, Object>>> operaInfo=new HashMap<String, List<Map<String, Object>>>();
	 /**组件输出需不需**/
	 Map<String, List<Map<String, Object>>> outInfo=new HashMap<String, List<Map<String, Object>>>();
	 /**产品适用模板**/
	 Map<String, List<Map<String, Object>>> prodModelInfo=new HashMap<String, List<Map<String, Object>>>();
	 /**模板关键字**/
	 List<Map<String, Object>> modelKeyInfo=new ArrayList<Map<String, Object>>();
	 /**模营销动作组件中的模板信息**/
	 List<Map<String, Object>> makertmodelInfo=new ArrayList<Map<String, Object>>();
	 
	 /** 下划线转驼峰 */
	  public static String lineToHump(String str) {
	        str = str.toLowerCase();
	     Matcher matcher = linePattern.matcher(str);
	      StringBuffer sb = new StringBuffer();
	      while (matcher.find()) {
	          matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
	     }
	       matcher.appendTail(sb);
	     return sb.toString();
	 }

	/**
	 * 
	* @方法名称: getItemsByFlow
	* @方法描述: 根据流程实例ID获取渠道组件
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getItemsByFlow(String flowId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("flowId", flowId);
		List<Map<String, Object>> result= connMapper.getItemsByFlowId(paramMap);
		return result;
	}
	/**
	 * 
	* @方法名称: getOutInfoItem
	* @方法描述: 获取组件的输出项
	* @参数与返回说明: 
	* @算法描述:目前组要是获取产品和客户类组件的
	 */
	@Transactional(readOnly = true)
	public Map<String, List<Map<String, Object>>> getOutInfoItem() {
		List<String> param1=new ArrayList<String>();//产品类组件
		List<String> param2=new ArrayList<String>();//客户类组件
		Map<String, List<Map<String, Object>>> result= new HashMap<String, List<Map<String, Object>>>();
		for(int i=0;i<itemsInfo.size();i++) {
			Map<String,Object> info=itemsInfo.get(i);
			if(info.get("classId").equals("2")) {//客户类
				param2.add(info.get("nodeId").toString());
			}else if(info.get("classId").equals("3")) {//产品
				param1.add(info.get("nodeId").toString());
			}
		}
		
		List<Map<String, Object>> prod= connMapper.getItemOutInfo(param1);
		List<Map<String, Object>> cust= connMapper.getItemOutInfo(param2);
		result.put("prod", prod);
		result.put("cust", cust);
		return result;
	}
	/**
	 * 
	* @方法名称: getCustsByItem
	* @方法描述: 根据组件获取客户
	* @参数与返回说明: 
	* @算法描述:主要包含客户
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getCustsByItem() {
		List<String> paramMap=new ArrayList<String>();//客户群ID数据集
		List<String> paramMap1=new ArrayList<String>();
		List<Map<String, Object>> paramMap2=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> cust= outInfo.get("cust");
		for(int i=0;i<cust.size();i++) {//获取客户群ID
			Map<String, Object> info=cust.get(i);
			if(null!=info.get("formOutVal")) {
				if(info.get("formOutVal").toString().indexOf(",")>-1) {
					String[] str=info.get("formOutVal").toString().split(",");
					for(int s=0;s<str.length;s++) {
						paramMap.add(str[s]);
					}
				}else {
					paramMap.add(info.get("formOutVal").toString());
				}
			}
			
		}
		//获取客户群信息
		List<Map<String, Object>> geoupInfo= connMapper.getItemCustGroupinfo(paramMap);
		for(int i=0;i<geoupInfo.size();i++) {
			Map<String, Object> geoup=geoupInfo.get(i);
			if(geoup.get("custOrigin").equals("4")||geoup.get("custOrigin").equals("2")) {//标签客户筛选的
				paramMap2.add(geoup);
			}else {//灵活查询
				paramMap1.add(geoup.get("custGroupId").toString());
			}
			
		}
		List<Map<String, Object>> data1=new ArrayList<Map<String, Object>>();
		if(!paramMap1.isEmpty()) {
			data1= connMapper.getItemCustinfoByGroupId(paramMap1);
		}
		List<Map<String, Object>> data2=new ArrayList<Map<String, Object>>();
		for(int t=0;t<paramMap2.size();t++) {//根据sql循环查询客户信息
			Map<String, Object> geoup=paramMap2.get(t);
			if(geoup.get("custOrigin").equals("4")) {//标签客户筛选的
				List<Map<String, Object>> res= connMapper.getItemCustinfoBySqlBQ(geoup.get("sql").toString());
				data2.addAll(res);
			}else if (geoup.get("custOrigin").equals("2")){//灵活查询
				List<Map<String, Object>> res= connMapper.getItemCustinfoBySql(geoup.get("sql").toString());
				data2.addAll(res);
			}
		}
		data.addAll(data1);
		data.addAll(data2);
		return data;
	}
	/**
	 * 
	* @方法名称: getProdByItem
	* @方法描述: 根据组件获取产品
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getProdByItem() {
		List<String> paramMap=new ArrayList<String>();
		List<Map<String, Object>> prod= outInfo.get("prod");
		for(int i=0;i<prod.size();i++) {
			Map<String, Object> info=prod.get(i);
			if(info.get("formOutVal").toString().indexOf(",")>-1) {
				String[] str=info.get("formOutVal").toString().split(",");
				for(int s=0;s<str.length;s++) {
					paramMap.add(str[s]);
				}
			}else {
				paramMap.add(info.get("formOutVal").toString());
			}
		}
		List<Map<String, Object>> data= connMapper.getItemProdInfo(paramMap);
		return data;
	}
	/**
	 * 
	* @方法名称: getModelByPord
	* @方法描述: 获取产品适用模板信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public Map<String, List<Map<String, Object>>> getModelByPord() {
		Map<String, List<Map<String, Object>>> restult=new HashMap<String, List<Map<String, Object>>>();
		for(int i=0;i<prodInfo.size();i++) {
			Map<String, Object> info=prodInfo.get(i);
				Map<String, String> paramMap=new HashMap<String, String>();
				paramMap.put("id", info.get("productId").toString());
				List<Map<String, Object>> data= connMapper.getModelByProd(paramMap);
				restult.put(info.get("productId").toString(), data);
		}
		return restult;
	}
	/**
	 * 
	* @方法名称: getModelKey
	* @方法描述: 获取模板关键字信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getModelKey() {
		return connMapper.getModelKey();
	}
	/**
	 * 
	* @方法名称: getOperaByItem
	* @方法描述: 根据组件ID获取操作信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public Map<String, List<Map<String, Object>>> getOperaByItem() {
		Map<String, List<Map<String, Object>>> restult=new HashMap<String, List<Map<String, Object>>>();
		for(int i=0;i<itemsInfo.size();i++) {
			Map<String, Object> info=itemsInfo.get(i);
			if(info.get("classId").equals("4")) {
				Map<String, String> paramMap=new HashMap<String, String>();
				paramMap.put("id", info.get("nodeId").toString());
				List<Map<String, Object>> data= connMapper.getOperaByItem(paramMap);
				restult.put(info.get("nodeId").toString(), data);
			}
			
		}
		return restult;
	}
	/**
	 * 
	* @方法名称: getMakertModelInfo
	* @方法描述: 根据流程ID获取营销动作组件中选中的模板信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public  List<Map<String, Object>> getMakertModelInfo(String flowId) {
		List<Map<String, Object>> restult=new ArrayList<Map<String, Object>>();
		for(int i=0;i<itemsInfo.size();i++) {
			Map<String, Object> info=itemsInfo.get(i);
			if(info.get("classId").equals("7")) {//判断是否是营销类
				if(info.get("assemblyId").equals("47")) {//判断是否是营销动作组件
					// 1 获取操作信息
					Map<String, String> paramMap=new HashMap<String, String>();
					paramMap.put("id", info.get("nodeId").toString());
					List<Map<String, Object>> data= connMapper.getOperaByItem(paramMap);
					for(int s=0;s<data.size();s++) {
						Map<String, Object> opt=data.get(s);
						if(opt.get("formOperationFiled").equals("modelInfos")&&opt.get("formOperationVal")!=null) {
							String[] modelId=opt.get("formOperationVal").toString().split(",");
							List<String> param=new ArrayList<String>();
							for(int j=0;j<modelId.length;j++) {
								param.add(modelId[j]);
							}
							restult=connMapper.getModelListByNodeId(param);
							break;
						}
						
					}
					
				}
			}
		}
		return restult;
	}
	
	/**
	 * 
	* @方法名称: initData
	* @方法描述: 根据流程ID初始化基础数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	public void initData(String flowId ) {
		itemsInfo=getItemsByFlow(flowId);
		outInfo=getOutInfoItem();
		Map<String,String> params=new HashMap<String,String>();
		params.put("flowId", flowId);
	//	custInfo=connMapper.getInvetByFlowId(params);
		//if(custInfo.isEmpty()) {//先查询清单整合表中的客户信息
		custInfo=getCustsByItem();
		//}
		makertmodelInfo=getMakertModelInfo(flowId);
		prodInfo=getProdByItem();
		operaInfo=getOperaByItem();
		prodModelInfo=getModelByPord();
		modelKeyInfo=getModelKey();
	}
	/**
	 * 
	* @方法名称: tempAnalysis
	* @方法描述: 解析模板内容
	* @参数与返回说明: 
	* @算法描述:
	 */
	public String tempAnalysis(String temp,List<Map<String,String>> key,Map<String, Object> data) {
		String result=temp;
		for(int i=0;i<key.size();i++) {
			Map<String,String> map=key.get(i);
			String label="\\Q"+map.get("label").toString()+ "\\E";
			String value=lineToHump(map.get("value").toString());
			if(data.get(value) ==null) {
				result=result.replaceAll(label, "null");
			}else {
				result=result.replaceAll(label, data.get(value).toString());
			}
			
		}
		return result;
	}
	
	/**
	 * 
	* @方法名称: replaceTempParam
	* @方法描述:根据模板生成对应的营销话术
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String, Object>> replaceTempParam(Map<String, Object> prod,Map<String, Object> sendTime
			,Map<String, Object> modelinfo,Map<String, Object> node) {
			List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
			String tempInfo =modelinfo.get("modelInfo").toString();
			List<Map<String,String>> key=new ArrayList<Map<String,String>>();//模板中的关键字
			for(int i=0;i<modelKeyInfo.size();i++) {
				Map<String,Object> info=modelKeyInfo.get(i);
				if(tempInfo.indexOf(info.get("aliasName").toString())!=-1) {
					Map<String,String> map=new HashMap<String,String>();
					map.put("label", info.get("aliasName").toString());
					map.put("value", info.get("sourceFieldEname").toString());
					key.add(map);
				}
			}
			for(int s=0;s<custInfo.size();s++) { 
				Map<String, Object> cust=custInfo.get(s);
				if(prod.get("typeFitCust")!=null&&node.get("customerType")!=null) {
					String fitCustType=prod.get("typeFitCust").toString();
					String customerType=node.get("customerType").toString();
					//判断产品使用对象类型和客户的类型，活动客户类型是否匹配
					boolean flag=false;
					if(fitCustType.equals("COMPANY")&&cust.get("custType").equals("2")&&"02".equals(customerType)) {//企业客户
						flag=true;
					}else if(fitCustType.equals("PERSON")&&cust.get("custType").equals("1")&&"01".equals(customerType)) {//个人
						flag=true;
					}else if(fitCustType.equals("ALL")&&cust.get("custType").equals("1")&&"01".equals(customerType)) {//企业和个人
						flag=true;
					}else if(fitCustType.equals("ALL")&&cust.get("custType").equals("2")&&"02".equals(customerType)) {//企业和个人
						flag=true;
					}
					cust.putAll(prod);
					if(flag) {
						
						Map<String, Object> info=new HashMap<String, Object>();
						String msg=tempAnalysis(tempInfo,key,cust);
						info.put("custName", cust.get("custName").toString());
						info.put("prodName", cust.get("prodName").toString());
						info.put("beginTime", sendTime.get("beginTime").toString());
						info.put("endTime", sendTime.get("endTime").toString());
						if(cust.get("contactNumber")!=null) {
							info.put("phoneNum", cust.get("contactNumber").toString());
						}else {
							info.put("phoneNum", "");
						}
						if(cust.get("catlCode")!=null) {
							info.put("catlCode", cust.get("catlCode").toString());
						}else {
							info.put("catlCode", "");
						}
						info.put("Email", "");
						info.put("weChat", "");
						info.put("type", "1");
						info.put("msg", msg);
						if(cust.get("belongMgr")!=null) {
							info.put("belongMgr", cust.get("belongMgr").toString());
						}else {
							info.put("belongMgr", null);
						}
						if(cust.get("belongOrg")!=null) {
							info.put("belongOrg", cust.get("belongOrg").toString());
						}else {
							info.put("belongOrg", null);
						}
						info.put("custId", cust.get("custId").toString());
						info.put("prodId", cust.get("productId").toString());
						result.add(info);
					}else{
						logger.info("[客户："+cust.get("custName")+"|产品："+cust.get("prodName").toString()+"|活动："+node.get("activityName").toString()+"]活动的适用客户类型和客户类型，产品的适用客户类型不匹配！");
					}
				}else {
					logger.info("数据中的参数缺少");
				}
			
				
			}
		return result;
	}
	/**
	 * 
	* @方法名称: replaceTempParam
	* @方法描述:根据模板生成对应的营销话术
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String, Object>> replaceTempParam2(Map<String, Object> sendTime
			,Map<String, Object> modelinfo,Map<String, Object> node) {
			List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
			String tempInfo =modelinfo.get("modelInfo").toString();
			List<Map<String,String>> key=new ArrayList<Map<String,String>>();//模板中的关键字
			for(int i=0;i<modelKeyInfo.size();i++) {
				Map<String,Object> info=modelKeyInfo.get(i);
				if(tempInfo.indexOf(info.get("aliasName").toString())!=-1) {
					Map<String,String> map=new HashMap<String,String>();
					map.put("label", info.get("aliasName").toString());
					map.put("value", info.get("sourceFieldEname").toString());
					key.add(map);
				}
			}
			for(int s=0;s<custInfo.size();s++) { 
				Map<String, Object> cust=custInfo.get(s);
				boolean flag=true;
				if(flag) {
					Map<String, Object> info=new HashMap<String, Object>();
					String msg=tempAnalysis(tempInfo,key,cust);
					info.put("custName", cust.get("custName").toString());
					info.put("beginTime", sendTime.get("beginTime").toString());
					info.put("endTime", sendTime.get("endTime").toString());
					if(cust.get("contactNumber")!=null) {
						info.put("phoneNum", cust.get("contactNumber").toString());
					}else {
						info.put("phoneNum", "");
					}
					if(cust.get("catlCode")!=null) {
						info.put("catlCode", cust.get("catlCode").toString());
					}else {
						info.put("catlCode", "");
					}
					if(modelinfo.get("applyType").equals("RISK")) {//风险
						info.put("type", "3");
					}else if(modelinfo.get("applyType").equals("CARE")){//关怀
						info.put("type", "2");
					}else {
						info.put("type", "1");
					}
					info.put("Email", "");
					info.put("weChat", "");
					info.put("msg", msg);
					if(cust.get("belongMgr")!=null) {
						info.put("belongMgr", cust.get("belongMgr").toString());
					}else {
						info.put("belongMgr", null);
					}
					if(cust.get("belongOrg")!=null) {
						info.put("belongOrg", cust.get("belongOrg").toString());
					}else {
						info.put("belongOrg", null);
					}
					info.put("custId", cust.get("custId").toString());
					info.put("prodId", "");
					info.put("prodName", "");
					result.add(info);
				}
				
			}
		return result;
	}
	/**
	 * 
	* @方法名称: tempProcess
	* @方法描述:处理模板信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<Map<String, Object>> tempProcess(Map<String, Object> node) {
		List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> op=operaInfo.get(node.get("nodeId").toString());//获取对应的操作信息
		Map<String, Object> sendTime=new HashMap<String, Object>();
		int num=0;
		for(int f=0;f<op.size();f++) {
			Map<String, Object> map=op.get(f);
			if(map.get("formOperationVal")!=null&&map.get("formOperationFiled").equals("beginTime")) {
				sendTime.put("beginTime", map.get("formOperationVal"));
				num++;
			}else if(map.get("formOperationVal")!=null&&map.get("formOperationFiled").equals("endTime")) {
				sendTime.put("endTime", map.get("formOperationVal"));
				num++;
			}
		}
		if(num==2) {//渠道组件没有设置时间区间，就不生成营销话术
			for(int i=0;i<prodInfo.size();i++) {
				Map<String, Object> info=prodInfo.get(i);
				if(!makertmodelInfo.isEmpty()) {//如果有营销动作设置的模板，就已营销动作中的模板优先
					logger.info("优先启用营销动作中的模板");
					for(int s=0;s<makertmodelInfo.size();s++) {
						Map<String, Object> modelinfo=makertmodelInfo.get(s);
						if(modelinfo.get("isEnable").equals("Y")) {
							result.addAll(replaceTempParam(info,sendTime,modelinfo,node ));
						}else {
							logger.info("["+modelinfo.get("modelName")+"]模板是无效的");
						}
//						result.addAll(replaceTempParam2(sendTime,modelinfo,node ));
						
					}
				}else {
					logger.info("启用产品关联的模板");
					List<Map<String, Object>> model=prodModelInfo.get(info.get("productId"));
					for(int s=0;s<model.size();s++) { 
						Map<String, Object> modelinfo=model.get(s);
						if(modelinfo.get("channelName")!=null&&modelinfo.get("channelName").equals(node.get("assemblyName"))) {
							result.addAll(replaceTempParam(info,sendTime,modelinfo,node ));
						}else {
							logger.info("["+modelinfo.get("modelName")+"]模板是不适用当前["+node.get("assemblyName")+"]渠道");
						}
						
					}
				}
				
			}
			
		}else {
			logger.info("["+node.get("assemblyName")+"]渠道没有设置具体的操作信息,不产生营销话术信息");
		}
		return result;
	}
	/**
	 * 
	* @方法名称: specialNode
	* @方法描述: 特殊渠道节点具体业务逻辑
	* @参数与返回说明: 
	* @算法描述:主要是营销平台节点需要生成商机信息
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public Map<String, Object> specialNode(Map<String, Object> node,String activityId) {
		List<Map<String, Object>> info=tempProcess(node);
		Map<String, Object> result=new HashMap<String,Object>();
		int desNum=0;//已分配的数量
		int noNum=0;//未分配的数量
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = formatter2.parse(node.get("startDate").toString());
			Date endDate=formatter2.parse(node.get("endDate").toString());
			if(!info.isEmpty()) {
				//保存任务和商机信息
			    for(int i=0;i<info.size();i++) {
					Map<String, Object> map=info.get(i);
					if(map.get("type").equals("1")) {//只有产品类的需要生成商机任务
						CimFTcTaskPool task = new CimFTcTaskPool();//任务池 
						String uuid = UUID.randomUUID().toString().replaceAll("-", "");
						task.setTaskName(node.get("activityName").toString()+"_"+map.get("custName").toString()
								+"_"+map.get("prodName").toString());//任务名称（活动名称+客户名称+产品名称）
						task.setTaskType("BO");//任务类型（BO商机）
						if(map.get("belongMgr")!=null) {
							task.setTaskState("IMPLEMENTING");//任务状态
							 desNum=desNum+1;
						}else {
							task.setTaskState("UNASSIGNED");//任务状态
							noNum=noNum+1;
						}
						task.setStartTime(startDate);
						task.setTaskId(uuid);
						task.setActivityId(activityId);
						task.setEndTime(endDate);
						task.setLastUpdateDt(new Date());
						task.setCreateTime(new Date());
						task.setLastUpdateUser(loginCode);
						taskMapper.insertSelective(task);
						if(map.get("belongMgr")!=null) {
							/**保存我的任务*/
							CimFTcMyTask mytask = new CimFTcMyTask();
							mytask.setTaskId(task.getTaskId());
							mytask.setAllotUser(loginCode);
							mytask.setDutyUser(map.get("belongMgr").toString());
							mytask.setLastUpdateDt(new Date());
							mytask.setAllotTime(new Date());
							mytask.setLastUpdateUser(loginCode);
							mytaskMapper.insertSelective(mytask);
							
						}
						/**人物反馈信息表**/
						CmFRcMarketBack back=new CmFRcMarketBack();
						back.setCatlCode(Long.parseLong(map.get("catlCode").toString()));
						back.setChannelId(node.get("assemblyId").toString());
						back.setCustId(map.get("custId").toString());
						//back.setMarketAmount(marketAmount);
						back.setMarketDate(new Date());
						back.setProductId(map.get("prodId").toString());
						back.setPushDate(new Date());
						back.setTaskId(task.getTaskId());
						backMapper.insertSelective(back);
						/**保存商机*/
						CimFTcNiche niche = new CimFTcNiche();
						niche.setTaskId(task.getTaskId());
						niche.setNicheName(node.get("activityName").toString()+"_"+map.get("custName").toString()+"_"+map.get("prodName").toString());
						niche.setNicheState("0");
						niche.setNicheStage("1");
						niche.setNicheType("0");
						niche.setNicheStartDt(startDate);
						niche.setNicheEndDt(endDate);
						niche.setNicheContent(map.get("msg").toString());
						niche.setCustomerName(map.get("custName").toString());
						niche.setNicheRiseDt(new Date());
						niche.setLastUpdateDt(new Date());
						niche.setLastUpdateUser(loginCode);
						if(map.get("belongMgr")!=null) {
							niche.setExecuteUser(map.get("belongMgr").toString());
							
						}
						if(map.get("belongOrg") !=null) {
							niche.setExecuteAgency(map.get("belongOrg").toString());
						}
						nicheMapper.insertSelective(niche);
					}
					
					
				}
			    connMapper.deleteInfoByNode(node.get("nodeId").toString());//删除节点下以后的结果信息
			    for(int i=0;i<info.size();i++) {//保存结果信息
					Map<String, Object> map=info.get(i);
					CimpCmChannelResultInfo pool=new CimpCmChannelResultInfo();
					pool.setCustId(map.get("custId").toString());
					pool.setCustName(map.get("custName").toString());
					pool.setFormId(node.get("nodeId").toString());
					pool.setIfSuccess("N");//Y-是；N-否
					pool.setMarketType(map.get("type").toString());//1-产品类型营销，2-关怀类，3-风险类
					pool.setMessage(map.get("msg").toString());
					pool.setPhoneNum(map.get("phoneNum").toString());//联系内容
					pool.setProductId(map.get("prodId").toString());
					pool.setProductName(map.get("prodName").toString());
					connMapper.insertSelective(pool);
				}
			    //记录报文日志
			    if(info.size()>0) {
			    	ObjectMapper mapper = new ObjectMapper();
			    	String jsonRiskStr = mapper.writeValueAsString(info);
					CmFRcRuleResultLog log = new CmFRcRuleResultLog();
					String message=node.get("tempId").toString()+"_"+node.get("activityName").toString()+
							node.get("nodeName").toString();
					log.setInMessage(message);
					log.setOutMessage(jsonRiskStr);
					log.setMessageDate(formatter2.format(new Date()));
					logMapper.insertSelective(log);
					
				}
			}
		    result.put("des", desNum);
		    result.put("no", noNum);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	* @方法名称: batchExe
	* @方法描述: 批量处理
	* @参数与返回说明: 
	* @算法描述:
	 */
	@SuppressWarnings("resource")
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public String  batchExe(Map<String, Object> node) {
		List<Map<String, Object>> info=tempProcess(node);
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
 		String formatStr2 =formatter2.format(new Date().getTime());
 		String fileName="";
 		if(!info.isEmpty()) {
 			Long time=new Date().getTime();
 			List<Map<String, Object>>pas=connMapper.getConfigByName("FILE_PATCH");
 			String filePatch="D:";//文件地址
 			if(!pas.isEmpty()) {
 				filePatch=pas.get(0).get("propValue").toString();
 			}
 			 fileName=filePatch+node.get("nodeName").toString()+"_"+formatStr2+time+".xls";
 			//创建HSSFWorkbook对象(excel的文档对象)
 		     HSSFWorkbook wb = new HSSFWorkbook();
 			//建立新的sheet对象（excel的表单）
 			HSSFSheet sheet=wb.createSheet(node.get("nodeName").toString());
 			//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
 			HSSFRow row0=sheet.createRow(0);  //标题  
 	        // 设置字体
 	        HSSFFont font = wb.createFont();
 	        //设置字体大小
 	        font.setFontHeightInPoints((short)11);
 	        //字体加粗
 	        font.setBold(true);
 	        //设置字体名字 
 	        font.setFontName("Courier New");
 	        //设置样式; 
 	        HSSFCellStyle style = wb.createCellStyle();
 	        //在样式用应用设置的字体;  
 	        style.setFont(font);
 	        //设置自动换行; 
 	        style.setWrapText(false);
 	        //设置水平对齐的样式为居中对齐;  
 	        style.setAlignment(HorizontalAlignment.CENTER);
 	        //设置垂直对齐的样式为居中对齐; 
 	        style.setVerticalAlignment(VerticalAlignment.CENTER);
 		      //创建单元格并设置单元格内容
 	        String[] title={"客户名称","产品名称","发送开始时间","发送结束时间","电话号码","邮箱号","微信号","信息内容"};
 	        for(int t=0;t<title.length;t++) {
 	        	HSSFCell cell = row0.createCell(t);
 				cell.setCellValue(title[t]);
 				cell.setCellStyle(style);
 	        }
 			  // 设置字体
 	        HSSFFont font1 = wb.createFont();
 	        //设置字体大小
 	        //font.setFontHeightInPoints((short)10);
 	        //字体加粗
 	        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
 	        //设置字体名字 
 	        font.setFontName("Courier New");
 	        //设置样式; 
 	        HSSFCellStyle style1 = wb.createCellStyle();
 	        //在样式用应用设置的字体;  
 	        style1.setFont(font1);
 	        //设置自动换行; 
 	        style1.setWrapText(false);
 	        //设置水平对齐的样式为居中对齐;  
 	        style1.setAlignment(HorizontalAlignment.CENTER);
 	        //设置垂直对齐的样式为居中对齐; 
 	        style1.setVerticalAlignment(VerticalAlignment.CENTER);

 		      for(int i=0;i<info.size();i++) {
 		    	  Map<String, Object> map=info.get(i);
 		    	  HSSFRow row=sheet.createRow(i+1);
 		    	  if(map.get("custName")!=null) {
 		    		  	HSSFCell cell0 = row.createCell(0);
 			  			cell0.setCellValue(map.get("custName").toString());
 			  			cell0.setCellStyle(style1);
 		    	  }else {
 		    		  row.createCell(0).setCellValue(""); 
 		    	  }
 		    	  if(map.get("prodName")!=null) {
 		    		  HSSFCell cell1 = row.createCell(1);
 			  		  cell1.setCellValue(map.get("prodName").toString());
 			  		  cell1.setCellStyle(style1);
 		    	  }else {
 		    		  row.createCell(1).setCellValue("");
 		    	  }
 		    	  if(map.get("beginTime")!=null) {
 		    		  HSSFCell cell2 = row.createCell(2);
 			  		  cell2.setCellValue(map.get("beginTime").toString());
 			  		  cell2.setCellStyle(style1);
 		    	  }else {
 		    		  row.createCell(2).setCellValue("");
 		    	  }
 		    	  if(map.get("endTime")!=null) {
 		    		  HSSFCell cell3 = row.createCell(3);
 			  		  cell3.setCellValue(map.get("endTime").toString());
 			  		  cell3.setCellStyle(style1);
 		    	  }else {
 		    		  row.createCell(3).setCellValue("");
 		    	  }
 				  if(map.get("phoneNum")!=null) {
 					  HSSFCell cell4 = row.createCell(4);
 			  		  cell4.setCellValue(map.get("phoneNum").toString());
 			  		  cell4.setCellStyle(style1);
 				  }else {
 					  row.createCell(4).setCellValue("");    
 		    	  }
 				  if(map.get("Email")!=null) {
 					  HSSFCell cell5 = row.createCell(5);
 			  		  cell5.setCellValue(map.get("Email").toString());
 			  		  cell5.setCellStyle(style1);
 				  }else {
 					  row.createCell(5).setCellValue("");
 		    	  }
 				  if(map.get("weChat")!=null) {
 					  HSSFCell cell6 = row.createCell(6);
 			  		  cell6.setCellValue(map.get("weChat").toString());
 			  		  cell6.setCellStyle(style1);
 				  }else {
 					  row.createCell(6).setCellValue(""); 
 		    	  }
 				  if(map.get("msg")!=null) {
 					  HSSFCell cell7 = row.createCell(7);
 			  		  cell7.setCellValue(map.get("msg").toString());
 			  		  cell7.setCellStyle(style1);
 				  }else {
 					  row.createCell(7).setCellValue("");
 		    	  }
 			      
 		      }
 		      //将文件存到指定位置
 	          try {
 	              FileOutputStream fout = new FileOutputStream(fileName);
 	              wb.write(fout);
 	              fout.close();
 	              connMapper.deleteInfoByNode(node.get("nodeId").toString());//删除节点下以后的结果信息
 	              for(int i=0;i<info.size();i++) {//保存结果信息
 	      			Map<String, Object> map=info.get(i);
 	      			CimpCmChannelResultInfo pool=new CimpCmChannelResultInfo();
 	      			pool.setCustId(map.get("custId").toString());
 	      			pool.setCustName(map.get("custName").toString());
 	      			pool.setFormId(node.get("nodeId").toString());
 	      			pool.setIfSuccess("N");//Y-是；N-否
 	      			pool.setMarketType(map.get("type").toString());//1-产品类型营销，2-关怀类，3-风险类
 	      			pool.setMessage(map.get("msg").toString());
 	      			pool.setPhoneNum(map.get("phoneNum").toString());//联系内容
 	      			pool.setProductId(map.get("prodId").toString());
 	      			pool.setProductName(map.get("prodName").toString());
 	      			connMapper.insertSelective(pool);
 	      		}
 	  		    //记录报文日志
 	  		    if(info.size()>0) {
 	  		    	ObjectMapper mapper = new ObjectMapper();
 	  		    	String jsonRiskStr = mapper.writeValueAsString(info);
 	  				CmFRcRuleResultLog log = new CmFRcRuleResultLog();
 	  				String message=node.get("tempId").toString()+"_"+node.get("activityName").toString()+
 	  						node.get("nodeName").toString();
 	  				log.setInMessage(message);
 	  				log.setOutMessage(jsonRiskStr);
 	  				log.setMessageDate(formatter2.format(new Date()));
 	  				logMapper.insertSelective(log);
 	  			}
 	          } catch (Exception e) {
 	              e.printStackTrace();
 	          }
 		}

		return fileName;
	}
	/**
	 * 
	* @方法名称: realTimeExe
	* @方法描述: 实时处理
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public String realTimeExe(Map<String, Object> node) {
		List<Map<String, Object>> info=tempProcess(node);
		String result="";
		if(!info.isEmpty()) {//如果能生成对应的营销话术
			SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			connMapper.deleteInfoByNode(node.get("nodeId").toString());//删除节点以前的结果信息
			for(int i=0;i<info.size();i++) {//保存结果信息
				Map<String, Object> map=info.get(i);
				CimpCmChannelResultInfo pool=new CimpCmChannelResultInfo();
				pool.setCustId(map.get("custId").toString());
				pool.setCustName(map.get("custName").toString());
				pool.setFormId(node.get("nodeId").toString());
				pool.setIfSuccess("N");//Y-是；N-否
				pool.setMarketType(map.get("type").toString());//1-产品类型营销，2-关怀类，3-风险类
				pool.setMessage(map.get("msg").toString());
				pool.setPhoneNum(map.get("phoneNum").toString());//联系内容
				pool.setProductId(map.get("prodId").toString());
				pool.setProductName(map.get("prodName").toString());
				connMapper.insertSelective(pool);
			}
		    //记录报文日志
		    if(info.size()>0) {
		    	ObjectMapper mapper = new ObjectMapper();
				try {
			    	String jsonRiskStr = mapper.writeValueAsString(info);
			    	result=jsonRiskStr;
					CmFRcRuleResultLog log = new CmFRcRuleResultLog();
					String message=node.get("tempId").toString()+"_"+node.get("activityName").toString()+
							node.get("nodeName").toString();
					log.setInMessage(message);
					log.setOutMessage(jsonRiskStr);
					log.setMessageDate(formatter2.format(new Date()));
					logMapper.insertSelective(log);
				} catch (JsonProcessingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
		return result;
	}
	/**
	 * 
	* @方法名称: executeNode
	* @方法描述: 执行渠道节点的具体业务逻辑
	* @参数与返回说明: 
	* @算法描述:
	 */
	public Map<String, Object> executeNode(Map<String, Object> node) {
		Map<String, Object> result=new HashMap<String,Object>();
		String nodeId=node.get("nodeId").toString();
		String fileName="";
		String content="";
		int num=0;//技术器-主要用来判断是不是包含有操作类型，同时有设置了操作时间
		List<Map<String, Object>> op=operaInfo.get(nodeId);//获取对应的操作信息
		for(int i=0;i<op.size();i++) {
			Map<String, Object> info=op.get(i);
			if(info.get("formOperationFiled").toString().equals("sendType")&&info.get("formOperationVal")!=null) {
				String type=info.get("formOperationVal").toString();
				if(type.equals("ALL")) {//全部
					 fileName=batchExe(node);
					 content=realTimeExe(node);
				}else if(type.equals("FILE")) {//批量
					fileName=batchExe(node);
				}else if(type.equals("DEAL")) {//实时交易
					content=realTimeExe(node);
				}
			}else {
				if(info.get("formOperationVal")!=null&&(info.get("formOperationFiled").equals("beginTime")||info.get("formOperationFiled").equals("endTime"))) {
					num++;
				}
			}
		}
		if(num==op.size()) {//设置了时间区间但是没有操作类型的，默认走实时交易
			content=realTimeExe(node);
			
		}
		result.put(node.get("nodeName").toString(), "批量生成的文件:"+fileName+";实时报文内容:"+content);
		return result;
	}
	
	/**
	 * 
	* @方法名称: executeFlow
	* @方法描述: 执行流程
	* @参数与返回说明: 
	* @算法描述:
	 */
	public Map<String, Object>  executeFlow(String flowId) {
		Map<String, Object> result=new HashMap<String, Object>();
		Map<String, Object> content=new HashMap<String, Object>();//渠道节点产生的结果
		//初始化数据
		initData(flowId);
		boolean climpFlag=true;
		boolean eventFlag=true;
		result.put("ifEvent", "false");
		result.put("ifClimp", "false");
		//执行节点逻辑-目前主要执行渠道类型节点
		for(int i=0;i<itemsInfo.size();i++) {
			Map<String, Object> info=itemsInfo.get(i);
			if(info.get("classId").equals("4")) {//判断是否是渠道类节点
				if(info.get("assemblyId").equals("46")) {//判断是否是营销平台节点
					Map<String, Object> map=specialNode(info,flowId);
					content.put(info.get("nodeName").toString(), "生成分配的任务和商机"+map.get("des")+"条|未分配的任务商机"+map.get("no")+"条");
				}else if (info.get("assemblyId").equals("28")){//手机银行组件-需要把广告活动发布出去
					Map<String, String> param=new HashMap<String, String>();
					param.put("sts", "1");
					param.put("nodeId", info.get("nodeId").toString());
					connMapper.updateStsByNodeId(param);
				}else {
					Map<String, Object> map=executeNode(info);
					content.putAll(map);
				}
			}else if(info.get("classId").equals("7")) {//判断是否有营销组建：主要是需要去执行实时引擎，事件的和权益的
				//当流程中有实时事件节点的时候，需要手动发起节点测试页面-主要是测试的时候用到，真实情况是不用的，到时候外部数据来了直接条用外部接口
				if("39".equals(info.get("assemblyId"))) {
					result.put("ifEvent", "true");
				}
				if(climpFlag&&(info.get("assemblyId").equals("36")||info.get("assemblyId").equals("37"))) {//权益组件-写规则路由表和规则集表数据
					result.put("ifClimp", "true");
					//根据营销活动id查询积分权益活动
					List<LoyRlActivity> actyList = actyMapper.getActivityByTempId(flowId);
					if(!actyList.isEmpty()) {
						String activityId = "";
						for(int s= 0;s<actyList.size();s++) {
							activityId += actyList.get(s).getActivityId()+",";
						}
					    //启动活动
					    actyService.useIngFn(activityId.split(","), userInfo.getOrgCode());
						
					}
					climpFlag=false;
				}else if(eventFlag&&(info.get("assemblyId").equals("38")||info.get("assemblyId").equals("39"))) {//事件组件-把事件信息状态改为启用
					Map<String, String> params=new HashMap<String, String>();
					params.put("activityId", flowId);
					params.put("sts", "1");
					engPro.updateEventSts(params);
					eventFlag=false;
				}
				
			}
		}
		if(content.isEmpty()) {
			result.put("ifChannel", "false");
		}else {
			result.put("ifChannel", "true");
			result.put("content", content);
		}
		
		return result;
	}

}
