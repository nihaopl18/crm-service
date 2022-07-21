package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.domain.FrParamPool;
import cn.com.yusys.yusp.cm.market.service.FrParamPoolService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;





/**
 * @项目名称: yusp-admin
 * @类名称: FrParamPoolResource
 * @类描述: 基础字段池
 * @功能描述: 
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018-3-7 10:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/frparampool")
public class FrParamPoolResource extends CommonResource<FrParamPool,String>{
	@Autowired
	private FrParamPoolService frParamPoolService;
	
	private final Logger log = LoggerFactory.getLogger(FrParamPoolResource.class);
	
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.frParamPoolService;
	}
	
	/**
	 * 
	 * @方法名称: createCheckparamid
	 * @方法描述: 新增检查角色编号是否重复
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/createcheckparamid")
	public int createCheckparamid(@RequestParam(required = false) String paramId) {
		log.info("createCheckparamidsonger="+paramId);
		return this.frParamPoolService.createCheckparamid(paramId);
	}
	
	/**
	* @方法名称: deleteMult
	* @方法描述: 多个删除
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/deletes/{ids}")
	@Timed
	public ResultDto<Integer> deleteMult(@PathVariable String ids) {
		log.debug("REST request to delete Object : {}", ids);
		String[] id = ids.toString().split(",");
		int i;
		for(i=0;i<id.length;i++) {
			this.delete(id[i]);
		}
		int result =i;
		return new ResultDto<Integer>(result);
		
	}
	
	/**
	* @方法名称: updateSelective
	* @方法描述: 修改接口
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/updates")
	@Timed
	public ResultDto<Integer>  updateSelective(@RequestBody FrParamPool t) throws URISyntaxException {
		log.debug("REST request to update Object : {}", t);

		int result = getCommonService().updateSelective(t);
		
		return new ResultDto<Integer>(result);
	}
	
	/**
	* @方法名称: list
	* @方法描述: 查询字段池全量字段
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@GetMapping("/list")
	public ResultDto<List<Map<String, Object>>> list(@RequestParam String transCode) {
    	log.info("list="+transCode);
    	return new ResultDto<List<Map<String, Object>>>(frParamPoolService.list(transCode));
	} 
	
	/**
	* @方法名称: list
	* @方法描述: 查询字段池全量字段
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@GetMapping("/selectlist")
	public ResultDto<List<Map<String, Object>>> selectList(@RequestParam String transCode) {
    	log.info("selectList="+transCode);
    	String tabName="%"+transCode+"%";
    	log.info("selectList again="+tabName);
    	return new ResultDto<List<Map<String, Object>>>(frParamPoolService.selectList(tabName));
	} 
	
	/**
	* @方法名称: selectByparamid
	* @方法描述: 查询字段类型和字段长度
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@GetMapping("/selectbyparamid")
	public ResultDto<List<Map<String, Object>>> selectByparamid(@RequestParam String paramId) {
    	log.info("selectByparamid="+paramId);
    	return new ResultDto<List<Map<String, Object>>>(frParamPoolService.selectByparamid(paramId));
	} 
	
	
}
