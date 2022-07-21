package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplay;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesPresentation;
import cn.com.yusys.yusp.cm.market.service.ChannelItemInOrOutService;
import cn.com.yusys.yusp.cm.market.service.CustValGradeInOrOutService;
import cn.com.yusys.yusp.cm.market.service.PresentationFormService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 展现表单
 * @author chenlin
 *
 */
@RestController
@RequestMapping("/api/presentationform")
public class PresentationFormResource extends CommonResource<CimpCmNodesDisplay, Serializable>{
	
	@Autowired
	private PresentationFormService service;
	@Autowired
	private ChannelItemInOrOutService inOutService;
	@Autowired
	private CustValGradeInOrOutService custValService;

	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.service;
	}
	
	/**
	 * 保存表单操作
	 * @return
	 */
	@PostMapping("/savepre")
	public ResultDto<Integer> savePre(@RequestBody  Map<?,?> parmas){
//		JSON.parseObject(parmas.get("preData").toString(), CimpCmNodesPresentation.class);
//		JSONArray preArray =JSONArray.fromObject(parmas.get("preData"));
 		List<CimpCmNodesPresentation> preList = JSON.parseArray(parmas.get("preData").toString(), CimpCmNodesPresentation.class);
		String nodeId = (String) parmas.get("nodeId");
		return new ResultDto<Integer>(service.savePre(preList, nodeId));
	}
	/**
	* @方法名称:delPre
	* @方法描述:根据节点ID删除表单信息及表单操作信息
	* @参数与返回说明:节点id
	* @算法描述:
	 */
	@PostMapping("/delpre")
	public ResultDto<Integer> delPre(@RequestBody Map<?,?> map){
		String nodeId = map.get("nodeId").toString();
		return new ResultDto<Integer>(service.delPre(nodeId));
	}
	
	@GetMapping("/getpre")
	public ResultDto<List<CimpCmNodesPresentation>> getpre(@RequestParam String nodeId){
		List<CimpCmNodesPresentation> preList = service.getPre(nodeId);
		return  new ResultDto<List<CimpCmNodesPresentation>>(preList);
	}
	
	@GetMapping("/getplan")
	public ResultDto<CimpCmMarketplan> getPlan(@RequestParam String flowId){
		return new ResultDto<CimpCmMarketplan>(service.getPlan(flowId));
	}
	/**
	 * 
	* @方法名称: getMarketTypeByFlowId
	* @方法描述: 获取流程中的营销方式节点
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getmarkettype")
	public ResultDto<List<Map<String,Object>>> getMarketTypeByFlowId(@RequestParam String flowId){
		return new ResultDto<List<Map<String,Object>>>(service.getMarketTypeByFlowId(flowId));
	}

	/**
	 *
	 * @方法名称: getMarketTypeByFlowId
	 * @方法描述: 获取流程中的营销方式节点
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getmarkettypeall")
	public ResultDto<List<Map<String,Object>>> getMarketTypeAllByFlowId(@RequestParam String flowId){
		return new ResultDto<List<Map<String,Object>>>(service.getMarketTypeAllByFlowId(flowId));
	}


	/**
	 * 
	* @方法名称: getChannelItemInAndOut
	* @方法描述: 获取渠道节点的输入输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getchanneliteminandout")
	public ResultDto<Map<String,List<Map<String,Object>>>> getChannelItemInAndOut(@RequestParam("flowId") String flowId,@RequestParam("nodeId") String nodeId){
			Map<String,List<Map<String,Object>>> result=new HashMap<String,List<Map<String,Object>>>();
			result.put("cust", inOutService.getChannelItemIn(flowId, "1"));
			result.put("prod", inOutService.getChannelItemIn(flowId, "2"));
			result.put("prodOut", inOutService.getChannelItemOut(nodeId, "1"));//产品
			result.put("careOut", inOutService.getChannelItemOut(nodeId, "2"));//关怀
			result.put("riskOut", inOutService.getChannelItemOut(nodeId, "3"));//风险
		return new ResultDto<Map<String,List<Map<String,Object>>>>(result);
	}
	/**
	 * 
	* @方法名称: getChannelInfo
	* @方法描述: 获取渠道信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getchannelinfo")
	public ResultDto<List<Map<String,Object>>> getChannelInfo(){
		return new ResultDto<List<Map<String,Object>>>(service.getChannelInfo());
	}
	/**
	 * 
	* @方法名称: getCustValItemInOut
	* @方法描述: 获取客户价值组件节点的输入和操作信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getcustvaliteminout")
	public ResultDto<Map<String,List<Map<String,Object>>>> getCustValItemInOut(@RequestParam("flowId") String flowId,@RequestParam("nodeId") String nodeId){
			Map<String,List<Map<String,Object>>> result=new HashMap<String,List<Map<String,Object>>>();
			result.put("cust", custValService.getChannelItemIn(flowId));//输入信息
			result.put("opera", custValService.getOperaByItem(nodeId));//操作信息
		return new ResultDto<Map<String,List<Map<String,Object>>>>(result);
	}
	/**
	 * 
	* @方法名称: getCustValItemInOut
	* @方法描述: 获取客户价值组件节点的输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getcustvalout")
	public ResultDto<List<Map<String,Object>>> getCustValOut(@RequestParam("flowId") String flowId,@RequestParam("nodeId") String nodeId){
			List<Map<String,Object>> result=custValService.getChannelItemOut(flowId,nodeId);
		return new ResultDto<List<Map<String,Object>>>(result);
	}
	/**
	 * 
	* @方法名称: getCustValItemInOut
	* @方法描述: 获取客户价值组件节点的输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/getcustvaloutother")
	public ResultDto<List<Map<String,Object>>> getCustValOutOther(@RequestParam("flowId") String flowId,@RequestParam("nodeId") String nodeId,
			@RequestParam("preData") String preData){
	 	    Map<String,String> preList =JSON.parseObject(preData, Map.class);
			List<Map<String,Object>> result=custValService.getChannelItemOut2(flowId,nodeId,preList);
		return new ResultDto<List<Map<String,Object>>>(result);
	}
	/**
	 * 
	* @方法名称: getCustChennelPerItemInOut
	* @方法描述: 获取客户渠道偏好输入输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getcustchennlperiteminout")
	public ResultDto<Map<String,List<Map<String,Object>>>> getCustChennelPerItemInOut(@RequestParam("flowId") String flowId,@RequestParam("nodeId") String nodeId){
			Map<String,List<Map<String,Object>>> result=new HashMap<String,List<Map<String,Object>>>();
			result.put("inCust", custValService.getChannelItemIn(flowId));//输入信息
			result.put("outCust", custValService.getCustChPerItemOut(flowId,nodeId));//操作信息
		return new ResultDto<Map<String,List<Map<String,Object>>>>(result);
	}
}

