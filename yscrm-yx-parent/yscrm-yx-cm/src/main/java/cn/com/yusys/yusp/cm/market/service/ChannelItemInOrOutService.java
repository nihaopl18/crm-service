package cn.com.yusys.yusp.cm.market.service;


import cn.com.yusys.yusp.cm.market.repository.mapper.ChannelProcessMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @项目名称：yscimc-service
 * @类名称：ChannelItemInOrOutService
 * @类描述：渠道节点相关SERVICE
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2018-11-19
 */
@Service
public class ChannelItemInOrOutService  extends CommonService{
	
	@Autowired
	private ChannelProcessMapper connMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.connMapper;
	}
	
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
	public Map<String, List<Map<String, Object>>> getOutInfoItem(List<Map<String, Object>> itemsInfo) {
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
	public List<Map<String, Object>> getCustsByItem(Map<String, List<Map<String, Object>>> outInfo) {
		List<String> paramMap=new ArrayList<String>();//客户群ID数据集
		List<Map<String, Object>> cust= outInfo.get("cust");
		for(int i=0;i<cust.size();i++) {//获取客户群ID
			Map<String, Object> info=cust.get(i);
			if(info.get("formOutVal").toString().indexOf(",")>-1) {
				String[] str=info.get("formOutVal").toString().split(",");
				for(int s=0;s<str.length;s++) {
					paramMap.add(str[s]);
				}
			}else {
				paramMap.add(info.get("formOutVal").toString());
			}
			
		}
		//获取客户群信息
		List<Map<String, Object>> geoupInfo= connMapper.getItemCustGroupinfo(paramMap);
		for(int i=0;i<geoupInfo.size();i++) {
			Map<String, Object> geoup=geoupInfo.get(i);
			if(geoup.get("custOrigin").equals("4")) {//标签客户筛选的
				List<Map<String, Object>> res= connMapper.getItemCustinfoBySqlBQ(geoup.get("sql").toString());
				geoup.put("custNum", res.size());
			}else if (geoup.get("custOrigin").equals("2")){//灵活查询
				List<Map<String, Object>> res= connMapper.getItemCustinfoBySql(geoup.get("sql").toString());
				geoup.put("custNum", res.size());
			}			
		}
		return geoupInfo;
	}
	/**
	 * 
	* @方法名称: getProdByItem
	* @方法描述: 根据组件获取产品
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getProdByItem(Map<String, List<Map<String, Object>>> outInfo) {
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
		
		List<Map<String, Object>> data= connMapper.getItemProdAndchannelInfo(paramMap);
		return data;
	}
	
	/**
	 * 
	* @方法名称: getChannelItemIn
	* @方法描述: 获取渠道节点的输入信息
	* @参数与返回说明: 
	* @算法描述:type 1:客户数据集  2:产品数据集
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>>  getChannelItemIn(String flowId,String type) {
		List<Map<String, Object>> items=getItemsByFlow(flowId);
		Map<String, List<Map<String, Object>>> out=getOutInfoItem(items);
		List<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		if(type.equals("1")) {
			Map<String,String> params=new HashMap<String,String>();
			params.put("flowId", flowId);
			data=connMapper.getInvetByFlowId(params);
			if(data.isEmpty()) {//先查询清单整合表中的客户信息
				data=getCustsByItem(out);
			}
		}else if(type.equals("2")) {
			data=getProdByItem(out);
		}
		return data;
	}
	/**
	 * 
	* @方法名称: getChannelItemOut
	* @方法描述: 获取渠道节点的输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>>  getChannelItemOut(String nodeId,String type) {
		Map<String,String> params=new HashMap<String,String>();
		params.put("id", nodeId);
		params.put("type", type);
		List<Map<String, Object>> data=connMapper.getChannelItemOutInfo(params);
		return data;
	}
	/**
	 * 
	* @方法名称: getOperaByItem
	* @方法描述: 根据组件ID获取操作信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getOperaByItem(String nodeId) {
			Map<String, String> paramMap=new HashMap<String, String>();
			paramMap.put("id", nodeId);
			List<Map<String, Object>> data= connMapper.getOperaByItem(paramMap);
		return data;
	}
}
