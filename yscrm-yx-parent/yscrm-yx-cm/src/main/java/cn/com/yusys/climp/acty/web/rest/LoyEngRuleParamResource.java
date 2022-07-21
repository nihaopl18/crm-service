package cn.com.yusys.climp.acty.web.rest;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyEngRuleParam;
import cn.com.yusys.climp.acty.service.LoyEngRuleParamService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称：yusp-climp-acty-core
 * @类名称：LoyEngRuleParamResource
 * @类描述：
 * @功能描述:引用参数
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2019-01-08 10:26
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2019宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ruleparam")
public class LoyEngRuleParamResource  extends CommonResource<LoyEngRuleParam, Serializable>{

	@Autowired
	private LoyEngRuleParamService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.service;
	}
	/**
	 * 
	* @方法名称: getParamList
	* @方法描述: 查询引用参数列表
	* @参数与返回说明: 查询参数
	* @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<LoyEngRuleParam>> getParamList(
			QueryModel queryModel) {
		List<LoyEngRuleParam> list = service.getParamList(queryModel);
		return new ResultDto<List<LoyEngRuleParam>>(list);
	}
	/**
	 * 
	* @方法名称: getRuleParamList
	* @方法描述: 判断是否参数编号是否重复
	* @参数与返回说明: 查询参数
	* @算法描述:
	 */
	@GetMapping("/ruleparamlist")
	public ResultDto<List<LoyEngRuleParam>> getRuleParamList(
			QueryModel queryModel) {
		List<LoyEngRuleParam> list = service.getRuleParamList(queryModel);
		return new ResultDto<List<LoyEngRuleParam>>(list);
	}
	/**
	 * 
	* @方法名称:batchDelete
	* @方法描述:引用参数批量删除
	* @参数与返回说明:逗号分隔的多个id
	* @算法描述:
	 */
	@PostMapping("/batchdelete")
    public ResultDto<Integer> batchDelete(@RequestBody Map<?,?> ids) {
    	String[] idStr=ids.get("id").toString().split(",");
        return new ResultDto<Integer>(this.service.batchDelete(idStr));
    }
}
