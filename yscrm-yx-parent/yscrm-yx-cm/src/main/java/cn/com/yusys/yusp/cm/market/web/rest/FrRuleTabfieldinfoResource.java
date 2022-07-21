package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.domain.FrRuleTabfieldinfo;
import cn.com.yusys.yusp.cm.market.service.FrRuleTabfieldinfoService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

	/**
	 * @项目名称: yusp-admin
	 * @类名称: FrRuleTabfieldinfoResource
	 * @类描述: 表字段维护
	 * @功能描述: 
	 * @创建人: zhangxs4@yusys.com.cn
	 * @创建时间: 2018-4-17 10:00
	 * @修改备注: 
	 * @修改记录: 修改时间    修改人员    修改原因
	 * -------------------------------------------------------------
	 * @version 1.0.0
	 * @Copyright (c) 2017宇信科技-版权所有
	 */
	@RestController
	@RequestMapping("/api/frruletabfieldinfo")
	public class FrRuleTabfieldinfoResource extends CommonResource<FrRuleTabfieldinfo,String>{
		@Autowired
		private FrRuleTabfieldinfoService frRuleTabfieldinfoService;
		
		private final Logger log = LoggerFactory.getLogger(FrRuleTabfieldinfoResource.class);
		
		
		@Override
		protected CommonService getCommonService() {
			// TODO Auto-generated method stub
			return this.frRuleTabfieldinfoService;
		}
			
	/**
	* @方法名称: updatesField
	* @方法描述: 表字段维护提交
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/updatesfield")
	@Timed
	public ResultDto<Object> updatesField(@RequestBody ArrayList<FrRuleTabfieldinfo> t) 
			throws URISyntaxException {
		
		 List<FrRuleTabfieldinfo> list = t;
		 frRuleTabfieldinfoService.updatesField(list);
         return new ResultDto<Object>();
		
	}
	
	/**
	* @方法名称: list
	* @方法描述: 查询字段表字段
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@GetMapping("/list")
	public ResultDto<List<Map<String, Object>>> list(@RequestParam String tabName) {
    	log.info("list="+tabName);
    	return new ResultDto<List<Map<String, Object>>>(frRuleTabfieldinfoService.list(tabName));
	} 

	/**
	* @方法名称: createTable
	* @方法描述: 表创建
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/createtable")
	@Timed
	public ResultDto<Object> createTable(@RequestBody ArrayList<FrRuleTabfieldinfo> t) 
			throws URISyntaxException {
		 log.info("createtable=");
		 List<FrRuleTabfieldinfo> list = t;
		 frRuleTabfieldinfoService.createTable(list);
         return new ResultDto<Object>();
		
	}
	
	/**
	* @方法名称: dropTable
	* @方法描述: 删除表
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/droptable")
	public int dropTable(@RequestBody FrRuleTabfieldinfo record) {
    	log.info("droptable="+record.getTabName());
    	return frRuleTabfieldinfoService.dropTable(record.getTabName());
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
	* @方法名称: selectByfield
	* @方法描述: 删除前校验
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/selectbyfield/{ids}")
	@Timed
	public int selectByfield(@PathVariable String ids) {
		log.info("selectByfield"+ids);
		String[] id = ids.toString().split(",");
		int i;
		int result = 0;
		int count = 0;
		int transcount = 0;
		for(i=0;i<id.length;i++) {
			count=frRuleTabfieldinfoService.selectByfield(id[i]);
			transcount=frRuleTabfieldinfoService.selecttransByfield(id[i]);
			if(transcount!=0 ||count!=0 ){
				log.info("transcount="+transcount);
				log.info("count="+count);
				result=1;
			}
		}
		
		return result;
		
	}
	
	/**
	* @方法名称: deleteField
	* @方法描述: 提交时表数据为空
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/deletefield")
	public int deleteField(@RequestBody FrRuleTabfieldinfo record) {
    	log.info("deleteField="+record.getTabName());
    	return frRuleTabfieldinfoService.deleteField(record.getTabName());
	} 
			
}

