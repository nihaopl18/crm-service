package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplay;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplayInput;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplayOutput;
import cn.com.yusys.yusp.cm.market.service.CimpCmNodesDisplayService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 表单节点信息
 * @author zhangxs4
 *
 */
@RestController
@RequestMapping("/api/cimpcmnodesdisplay")
public class CimpCmNodesDisplayResource extends CommonResource<CimpCmNodesDisplay, Serializable>{
	
	@Autowired
	private CimpCmNodesDisplayService cimpCmNodesDisplayService;

	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.cimpCmNodesDisplayService;
	}
	
	/**
	 * 保存表单节点关系表及保存输出表
	 * @param parmas
	 * @return
	 */
	@PostMapping("/savedisplay")
	public ResultDto<Integer> saveDisplay(@RequestBody  Map<?,?> parmas) {
		JSONArray nodeArray =JSONArray.fromObject(parmas.get("nodeData"));
		JSONArray connArray =JSONArray.fromObject(parmas.get("connData"));
		JSONArray inputArray =JSONArray.fromObject(parmas.get("inputData"));
		List<CimpCmNodesDisplay> nodeList = nodeArray.toList(nodeArray, CimpCmNodesDisplay.class);
		List<CimpCmNodesDisplayOutput> connList = connArray.toList(connArray, CimpCmNodesDisplayOutput.class);
		List<CimpCmNodesDisplayInput> inputList = inputArray.toList(inputArray, CimpCmNodesDisplayInput.class);
		return new ResultDto<Integer>(cimpCmNodesDisplayService.saveDisplay(nodeList,connList,inputList));
	}
	
	/**
	* @方法名称: getTagno
	* @方法描述: 查询输入表的标签号
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/gettagno")
	public ResultDto<List<Map<String, Object>>> getTagno(String nodeId) {
		List<Map<String, Object>> list = cimpCmNodesDisplayService.getTagno(nodeId);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
}

