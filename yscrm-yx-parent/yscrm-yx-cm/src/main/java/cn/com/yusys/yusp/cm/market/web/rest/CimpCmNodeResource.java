package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.domain.CimpCmConninfo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.service.CimpCmNodeService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 流程模板——节点信息控制类
 * @author chenlin
 *
 */
@RestController
@RequestMapping("/api/cimpcmnode")
public class CimpCmNodeResource extends CommonResource<CimpCmNodeinfo, Serializable>{
	
	@Autowired
	private CimpCmNodeService nodeService;

	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.nodeService;
	}
	/**
	 * 查询流程节点信息
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/list")
	public ResultDto<List<CimpCmNodeinfo>> getNodeList(
			QueryModel queryModel) {
		List<CimpCmNodeinfo> list = nodeService.getNodeList(queryModel);
		return new ResultDto<List<CimpCmNodeinfo>>(list);
	}
	/**
	 * 保存流程
	 * @param parmas
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "unchecked", "static-access" })
	@PostMapping("/saveflow")
	public ResultDto<Integer> saveFlow(@RequestBody  Map<?,?> parmas) {
		JSONArray nodeArray =JSONArray.fromObject(parmas.get("nodeData"));
		List<CimpCmNodeinfo> nodeList = nodeArray.toList(nodeArray, CimpCmNodeinfo.class);
		JSONArray connArray =JSONArray.fromObject(parmas.get("connData"));
        List<CimpCmConninfo> connList = connArray.toList(connArray, CimpCmConninfo.class);
		return new ResultDto<Integer>(nodeService.saveFlow(nodeList, connList));
	}
	/**
	 * 删除流程
	 * @param tempId
	 * @return
	 */
	@PostMapping("/delflow")
	public ResultDto<Integer> delFlow(@RequestBody String tempId){
		return new ResultDto<Integer>(nodeService.delFlow(tempId));
	}
	/**
	* @方法名称:delNode
	* @方法描述:删除节点
	* @参数与返回说明:
	* @算法描述:
	 */
	@PostMapping("/delnode")
	public ResultDto<Integer> delNode(@RequestBody String nodeId){
		return new ResultDto<Integer>(nodeService.delNode(nodeId));
	}
	
	/**
	 * 获取流程
	 * @param tempId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/getflow")
	@Timed
	public Map<String,List> getFlow(@RequestParam String tempId) {
		return nodeService.getFlow(tempId);
	}
}
