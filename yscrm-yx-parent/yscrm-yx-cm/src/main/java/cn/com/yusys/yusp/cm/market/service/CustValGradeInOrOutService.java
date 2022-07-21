package cn.com.yusys.yusp.cm.market.service;


import cn.com.yusys.yusp.cm.market.repository.mapper.ChannelProcessMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.CustValGradeMapper;
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
 * @类描述：渠道智能分发-客户价值等级SERVICE
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2018-11-19
 */
@Service
public class CustValGradeInOrOutService  extends CommonService{
	
	@Autowired
	private ChannelProcessMapper connMapper;
	@Autowired
	private CustValGradeMapper custvalMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.connMapper;
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
	public Map<String, List<Map<String, Object>>> getOutInfoItem(List<Map<String, Object>> itemsInfo) {
		List<String> param2=new ArrayList<String>();//客户类组件
		Map<String, List<Map<String, Object>>> result= new HashMap<String, List<Map<String, Object>>>();
		for(int i=0;i<itemsInfo.size();i++) {
			Map<String,Object> info=itemsInfo.get(i);
			if(info.get("classId").equals("2")) {//客户类
				param2.add(info.get("nodeId").toString());
			}
		}
		List<Map<String, Object>> cust= connMapper.getItemOutInfo(param2);
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
		List<String> paramMap1=new ArrayList<String>();
		List<Map<String, Object>> paramMap2=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
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
			if(geoup.get("custOrigin").equals("2")||geoup.get("custOrigin").equals("4")) {//灵活查询和标签客户筛选的
				paramMap2.add(geoup);
			}else  {
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
	* @方法名称: getCustsByItem
	* @方法描述: 根据组件获取客户
	* @参数与返回说明: 
	* @算法描述:主要包含客户
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getCustsByItem2(Map<String, List<Map<String, Object>>> outInfo) {
		List<String> paramMap=new ArrayList<String>();//客户群ID数据集
		List<String> paramMap1=new ArrayList<String>();
		List<Map<String, Object>> paramMap2=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
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
				paramMap2.add(geoup);
			}else if(geoup.get("custOrigin").equals("2")) {//灵活查询
				paramMap1.add(geoup.get("custGroupId").toString());
			}
			
		}
		List<Map<String, Object>> data1=new ArrayList<Map<String, Object>>();
		if(!paramMap1.isEmpty()) {
			data1= connMapper.getCustChPerinfoByGroupId(paramMap1);
		}
		List<Map<String, Object>> data2=new ArrayList<Map<String, Object>>();
		for(int t=0;t<paramMap2.size();t++) {//根据sql循环查询客户信息
			Map<String, Object> geoup=paramMap2.get(t);
			if(geoup.get("custOrigin").equals("4")) {//标签客户筛选的
				List<Map<String, Object>> res= connMapper.getCustChPerinfoBySqlBQ(geoup.get("sql").toString());
				data2.addAll(res);
			}else if (geoup.get("custOrigin").equals("2")){//灵活查询
				List<Map<String, Object>> res= connMapper.getCustChPerinfoBySql(geoup.get("sql").toString());
				data2.addAll(res);
			}
		}
		data.addAll(data1);
		data.addAll(data2);
		return data;
	}
	
	/**
	 * 
	* @方法名称: getChannelItemIn
	* @方法描述: 获取渠道节点的输入信息
	* @参数与返回说明: 
	* @算法描述: 客户数据集
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>>  getChannelItemIn(String flowId) {
		List<Map<String, Object>> items=getItemsByFlow(flowId);
		Map<String, List<Map<String, Object>>> out=getOutInfoItem(items);
		List<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		Map<String,String> params=new HashMap<String,String>();
		params.put("flowId", flowId);
		data=connMapper.getInvetByFlowId(params);
		if(data.isEmpty()) {//先查询清单整合表中的客户信息
			data=getCustsByItem(out);
		}
		return data;
	}
	/**
	 * 
	* @方法名称: getChannelItemIn
	* @方法描述: 获取客户渠道偏好节点的输出信息
	* @参数与返回说明: 
	* @算法描述: 客户数据集
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>>  getCustChPerItemIn(String flowId) {
		List<Map<String, Object>> items=getItemsByFlow(flowId);
		Map<String, List<Map<String, Object>>> out=getOutInfoItem(items);
		List<Map<String, Object>> data=new ArrayList<Map<String, Object>>();
		Map<String,String> params=new HashMap<String,String>();
		params.put("flowId", flowId);
		data=connMapper.getInvetPerinfoByFlowId(params);
		if(data.isEmpty()) {//先查询清单整合表中的客户信息
			data=getCustsByItem2(out);
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
	public List<Map<String, Object>>  getChannelItemOut(String flowId,String nodeId) {
		Map<String,String> params=new HashMap<String,String>();
		params.put("nodeId", nodeId);
		List<Map<String, Object>> info=custvalMapper.getChannelByGrade(params);//转码后的操作和渠道信息
		List<Map<String, Object>> data=getChannelItemIn(flowId);//获取客户数据
		List<Map<String, Object>> op=getOperaByItem(nodeId);//操作信息
		String channelHvalue="";//高价值渠道
		String channelLvalue="";//低价值渠道
		String gradeHvalue="";//高价值等级
		String gradeLvalue="";//低价值等级
		for(int s=0;s<info.size();s++) {
			Map<String, Object> st=info.get(s);
			if(st.get("formOperationFiled").equals("channelHvalue")) {
				channelHvalue=st.get("channelValue").toString();
			}else if(st.get("formOperationFiled").equals("channelLvalue")) {
				channelLvalue=st.get("channelValue").toString();
			}
		}
		for(int s=0;s<op.size();s++) {
			Map<String, Object> st=op.get(s);
			if(st.get("formOperationFiled").equals("gradeLvalue")) {
				gradeLvalue=st.get("formOperationVal").toString();
			}else if(st.get("formOperationFiled").equals("gradeHvalue")) {
				gradeHvalue=st.get("formOperationVal").toString();
			}
		}
		//List<Map<String, Object>>channel=custvalMapper.getChannelInfo();//渠道数据
		
		for(int i=0;i<data.size();i++) {
			Map<String, Object> map=data.get(i);
			if(map.get("custLevel")!=null&&gradeHvalue.indexOf(map.get("custLevel").toString()) !=-1) {
				map.put("channelValue", channelHvalue);
			}else if( map.get("custLevel")!=null&&gradeLvalue.indexOf(map.get("custLevel").toString()) !=-1) {
				map.put("channelValue", channelLvalue);
			}
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
	public List<Map<String, Object>>  getChannelItemOut2(String flowId,String nodeId,Map<String,String> other) {
		Map<String,String> params=new HashMap<String,String>();
		params.put("nodeId", nodeId);
		List<Map<String, Object>> data=getChannelItemIn(flowId);//获取客户数据
		String channelHvalue=other.get("channelHvalue").toString();//高价值渠道
		String channelLvalue=other.get("channelLvalue").toString();//低价值渠道
		String gradeHvalue=other.get("gradeHvalue").toString();//高价值等级
		String gradeLvalue=other.get("gradeLvalue").toString();//低价值等级
		for(int i=0;i<data.size();i++) {
			Map<String, Object> map=data.get(i);
			if(map.get("custLevel")!=null&&gradeHvalue.indexOf(map.get("custLevel").toString()) !=-1) {
				map.put("channelValue", channelHvalue);
			}else if( map.get("custLevel")!=null&&gradeLvalue.indexOf(map.get("custLevel").toString()) !=-1) {
				map.put("channelValue", channelLvalue);
			}
		}
		return data;
	}
	/**
	 * 
	* @方法名称: getCustChPerItemOut
	* @方法描述: 获取客户渠道偏好节点的输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>>  getCustChPerItemOut(String flowId,String nodeId) {
		Map<String,String> params=new HashMap<String,String>();
		params.put("nodeId", nodeId);
		List<Map<String, Object>> data=getCustChPerItemIn(flowId);//获取客户数据
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
