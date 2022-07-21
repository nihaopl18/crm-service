package cn.com.yusys.yusp.cm.cust.web.rest;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqScol;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqSsolution;
import cn.com.yusys.yusp.cm.cust.service.CimpFFqSsolutionService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import net.sf.json.JSONArray;

/**
 * 表单节点信息
 * @author zhangxs4
 *
 */
@RestController
@RequestMapping("/api/cimpffqssolution")
public class CimpFFqSsolutionResource extends CommonResource<CimpFFqSsolution, Serializable>{
	
	@Autowired
	private CimpFFqSsolutionService cimpFFqSsolutionService;

	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.cimpFFqSsolutionService;
	}
	
	/**
	 * 保存方案及条件列
	 * @param parmas
	 * @return
	 * @throws ParseException 
	 */
	@PostMapping("/savescol")
	public ResultDto<Integer> saveScol(@RequestBody  Map<?,?> parmas) throws ParseException {
		JSONArray nodeArray =JSONArray.fromObject(parmas.get("nodeData"));
		JSONArray connArray =JSONArray.fromObject(parmas.get("connData"));
		List<CimpFFqScol> nodeList = nodeArray.toList(nodeArray, CimpFFqScol.class);
		List<CimpFFqSsolution> connList = connArray.toList(connArray, CimpFFqSsolution.class);
		return new ResultDto<Integer>(cimpFFqSsolutionService.saveScol(nodeList,connList));
	}
	@PostMapping("/savescolGroup")
	public ResultDto<Integer> savescolGroup(@RequestBody  Map<?,?> parmas) throws ParseException {
		JSONArray nodeArray =JSONArray.fromObject(parmas.get("nodeData"));
		JSONArray connArray =JSONArray.fromObject(parmas.get("connData"));
		List<CimpFFqScol> nodeList = nodeArray.toList(nodeArray, CimpFFqScol.class);
		List<CimpFFqSsolution> connList = connArray.toList(connArray, CimpFFqSsolution.class);
		return new ResultDto<Integer>(cimpFFqSsolutionService.saveScol(nodeList,connList));
	}
	
	/**
	* @方法名称: getSsresult
	* @方法描述: 查询条件
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getssresult")
	public ResultDto<List<Map<String, Object>>> getSsresult(String id) {
		List<Map<String, Object>> list = cimpFFqSsolutionService.getSsresult(id);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
    /**
	* @方法名称: list
	* @方法描述: 初始化查询
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/list")
	public ResultDto<List<Map<String, Object>>> getList() {
		List<Map<String, Object>> list = cimpFFqSsolutionService.getList();
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
    /**
	* @方法名称: deleteMult
	* @方法描述: 多个删除
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/deletes/{ids}")
	@Timed
	public ResultDto<Integer> deleteByid(@PathVariable String ids) {
		String[] id = ids.toString().split(",");
		int i;
		for(i=0;i<id.length;i++) {
			this.delete(id[i]);
		}
		int result =i;
		return new ResultDto<Integer>(result);
		
	}
	
	/**
	* @方法名称: checkSsolution
	* @方法描述: 校验方案名称是否存在
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/checkssolution")
	public ResultDto<List<CimpFFqSsolution>> checkSsolution(String ssName) {
		List<CimpFFqSsolution> list = cimpFFqSsolutionService.checkSsolution(ssName);
		return new ResultDto<List<CimpFFqSsolution>>(list);
	} 
    
    /**
	 * 更新方案及条件列
	 * @param parmas
	 * @return
	 * @throws ParseException 
	 */
	@PostMapping("/updatescol")
	public ResultDto<Integer> updateScol(@RequestBody  Map<?,?> parmas) throws ParseException {
		JSONArray nodeArray =JSONArray.fromObject(parmas.get("nodeData"));
		JSONArray connArray =JSONArray.fromObject(parmas.get("connData"));
		List<CimpFFqScol> nodeList = nodeArray.toList(nodeArray, CimpFFqScol.class);
		List<CimpFFqSsolution> connList = connArray.toList(connArray, CimpFFqSsolution.class);
		return new ResultDto<Integer>(cimpFFqSsolutionService.updateScol(nodeList,connList));
	}
	// 获取单条记录通过ID
	@GetMapping("/listById")
	public ResultDto<List<Map<String, Object>>> getListById(QueryModel model) {
		List<Map<String, Object>> list = cimpFFqSsolutionService.getListById(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}

