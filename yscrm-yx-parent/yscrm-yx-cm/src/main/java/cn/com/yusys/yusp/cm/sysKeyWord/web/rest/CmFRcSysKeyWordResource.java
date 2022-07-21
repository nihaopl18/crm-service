package cn.com.yusys.yusp.cm.sysKeyWord.web.rest;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysKeyWord;
import cn.com.yusys.yusp.cm.sysKeyWord.service.CmFRcSysKeyWordService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcSysKeyWordResource
 * @类描述: 渠道模型关键字配置接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-10-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcmodelkeyword")
public class CmFRcSysKeyWordResource extends CommonResource<CmFRcSysKeyWord, Serializable>{

	@Autowired
	private CmFRcSysKeyWordService service;
	
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	 * 
	* @方法名称: getModelKeyWordList
	* @方法描述: 查询渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<CmFRcSysKeyWord>> getModelKeyWordList(QueryModel queryModel) {
		List<CmFRcSysKeyWord> list = service.getModelKeyWordList(queryModel);
		return new ResultDto<List<CmFRcSysKeyWord>>(list);
	}
	/**
	 * 
	* @方法名称: insertModelKeyWordList
	* @方法描述: 插入渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/addmodelkeyword")
	@Timed
	public ResultDto<Integer> insertModelKeyWordList(@RequestBody CmFRcSysKeyWord kw){
		return this.service.insertModelKeyWordList(kw);
	}
	/**
	 * 
	* @方法名称: updateModelKeyWordList
	* @方法描述: 更新渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/setmodelkeyword")
	@Timed
	public ResultDto<Integer> updateModelKeyWordList(@RequestBody CmFRcSysKeyWord kw){
		return this.service.updateModelKeyWordList(kw);
	}
	/**
	 * 
	* @方法名称: deleteModelKeyWordList
	* @方法描述: 删除渠道模型关键字
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/delmodelkeyword")
	@Timed
	public ResultDto<Integer> deleteModelKeyWordList(@RequestBody CmFRcSysKeyWord kw) {
		return this.service.deleteModelKeyWordList(kw);
	}
	/**
	 * 
	* @方法名称: getSameAliasName
	* @方法描述: 渠道模型关键字别名重复验证
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getaliasname")
	public ResultDto<List<Map<String, Object>>> getSameAliasName() {
		List<Map<String, Object>> map = service.getSameAliasName();
		return new ResultDto<List<Map<String, Object>>>(map);
	}
	/**
	 * 
	* @方法名称: getTabEName
	* @方法描述: 渠道模型关键字返回表英文名
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/gettabename")
	public ResultDto<List<Map<String, Object>>> getTabEName() {
		List<Map<String, Object>> map = service.getTabEName();
		return new ResultDto<List<Map<String, Object>>>(map); 
	}
	/**
	 * 
	* @方法名称: getTabCName
	* @方法描述: 渠道模型关键字返回表中文名
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/gettabcname")
	public ResultDto<List<Map<String, Object>>> getTabCName() {
		List<Map<String, Object>> map = service.getTabCName();
		return new ResultDto<List<Map<String, Object>>>(map); 
	}
	/**
	 * 
	* @方法名称: getField
	* @方法描述: 渠道模型关键字返回表字段名
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/getfield")
	@Timed
	public ResultDto<List<Map<String, Object>>> getField(@RequestBody CmFRcSysKeyWord kw) throws URISyntaxException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sourceTabEname", kw.getSourceTabEname());
		List<Map<String, Object>> list = service.getField(map);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	@PostMapping("/getmainfield")
	public ResultDto<List<Map<String, Object>>> getmainField(@RequestBody CmFRcSysKeyWord kw) throws URISyntaxException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sourceTabEname", kw.getSourceTabEname());
		List<Map<String, Object>> list = service.getmainField(map);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * 用于解决前端关联关键字与后端所需要不一致问题
	 * @param cmFRcSysKeyWord
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/getkeyword")
	public ResultDto<List<Map<String, Object>>> getKeyword(@RequestBody CmFRcSysKeyWord cmFRcSysKeyWord) throws URISyntaxException {
		return null;
	}
}
