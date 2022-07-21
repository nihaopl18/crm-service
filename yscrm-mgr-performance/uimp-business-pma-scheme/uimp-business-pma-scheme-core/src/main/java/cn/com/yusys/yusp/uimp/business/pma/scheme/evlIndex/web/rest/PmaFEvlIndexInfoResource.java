package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain.PmaFEvlIndexInfoEntity;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain.PmaFEvlIndexInfoVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.service.PmaFEvlIndexInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFEvlIndexInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-12-31 14:11:41
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "派生指标管理")
@RequestMapping("/api/pmafevlindexinfo")
public class PmaFEvlIndexInfoResource extends CommonResource<PmaFEvlIndexInfoVo, String> {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private PmaFEvlIndexInfoService pmaFEvlIndexInfoService;

	@Override
	protected CommonService getCommonService() {
		return pmaFEvlIndexInfoService;
	}

	/**
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@ApiOperation(value = "查询下级机构及本级机构数据(分页)", notes = "查询下级机构及本级机构数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<PmaFEvlIndexInfoEntity>> querylist(QueryModel model) {

		List<PmaFEvlIndexInfoEntity> list = this.pmaFEvlIndexInfoService.querylist(model);
		return new ResultDto<>(list);
	}

	@ApiOperation(value = "查询上级机构及本级机构数据(分页)", notes = "查询上级机构及本级机构数据(分页)")
	@GetMapping("/queryUpOrglist")
	public ResultDto<List<PmaFEvlIndexInfoEntity>> queryUpOrglist(QueryModel model) {

		List<PmaFEvlIndexInfoEntity> list = this.pmaFEvlIndexInfoService.queryUpOrglist(model);
		return new ResultDto<>(list);
	}

	/**
	 * @函数名称:show
	 * @函数描述:查询单个对象，公共API接口
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/{id}")
	@Transactional(readOnly = true)
	protected ResultDto show(@PathVariable String id) {
		PmaFEvlIndexInfoVo entity = pmaFEvlIndexInfoService.selectByPrimaryKey(id);
		return new ResultDto<PmaFEvlIndexInfoVo>(entity);
	}

	/**
	 * @函数名称:update
	 * @函数描述:对象修改，公共API接口
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/saveOrUpdate")
	protected ResultDto<Object> saveOrUpdate(@RequestBody PmaFEvlIndexInfoVo entity) throws URISyntaxException {
		return pmaFEvlIndexInfoService.saveOrUpdate(entity);
	}

	/**
	 * @函数名称:delete
	 * @函数描述:单个对象删除，公共API接口
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/delete/{id}")
	protected ResultDto<Integer> delete(@PathVariable String limitId) {
		int result = pmaFEvlIndexInfoService.deleteByPrimaryKey(limitId);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @函数名称:batchdelete
	 * @函数描述:批量对象删除，公共API接口
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/batchdelete/{ids}")
	protected ResultDto<Integer> deletes(@PathVariable String ids) {
		int result = pmaFEvlIndexInfoService.deleteByIds(ids);
		return new ResultDto<Integer>(result);
	}
	/**
	 * @函数名称:batchdelete
	 * @函数描述:批量对象删除，公共API接口
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/batchdelete")
	protected ResultDto<Integer> batchdelete(@RequestBody List<PmaFEvlIndexInfoVo> list) {
		String ids = "";
		for(PmaFEvlIndexInfoVo entity:list) {
			ids+=entity.getId()+",";
		}
		ids=ids.length()>0?ids.substring(0,ids.length()-1):"";
		int result = pmaFEvlIndexInfoService.deleteByIds(ids);
		return new ResultDto<Integer>(result);
	}

//	private User getUser(Object loginCode) {
//		User user = userInfoService.getUserInfo(loginCode.toString());
//		return user;
//	}

	/**
	 * @函数名称:convertToChinese
	 * @函数描述:转中文
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/convertToChinese")
	protected ResultDto<String> convertToChinese(@RequestBody(required=false) Map map) {
		String param = map.get("param").toString();
		String indexId = "";
		if(map.get("indexId")!=null) {
			indexId = map.get("indexId").toString();
		}
		
		if(StringUtils.isBlank(param)) {
			return new ResultDto<String>();
		}
		return new ResultDto<String>(pmaFEvlIndexInfoService.convertToChinese(indexId,param));
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryNames
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询数据名称", notes = "查询数据名称")
	@GetMapping("/querynames")
	public ResultDto<String> queryNames(@RequestParam("objId") String objId) throws Exception {
		ResultDto<String> result = new ResultDto<String>();
    	if(StringUtils.isNotEmpty(objId)) {
    		String resultStr = pmaFEvlIndexInfoService.queryNames(objId);
    		if("-1".equals(resultStr)) {
    			result.setCode(-2);
       		  	result.setMessage("服务器忙，请稍后重试！");
    		} else if(StringUtils.isEmpty(resultStr)) {
    			result.setCode(-3);
       		  	result.setMessage("无相关数据！");
    		} else {
    			result.setCode(0);
       		  	result.setMessage("操作成功！");
       		  	result.setData(resultStr);
    		}
    	} else {
    		result.setCode(-1);
   		  	result.setMessage("请求参数错误！");
    	}
    	return result;
	}

	@ApiOperation(value = "派生指标启用停用", notes = "派生指标启用停用")
	@PostMapping("/startOrStopState")
	public ResultDto<String> startOrStopState(@RequestBody Map<String,Object> map) throws Exception {
		return pmaFEvlIndexInfoService.startOrStopState(map);
	}

	@ApiOperation(value = "根据index获取基础指标管理选择的值", notes = "根据index获取基础指标管理选择的值")
	@GetMapping("/getTypesByPkid")
	public ResultDto<Map<String, Object>> getTypesByPkid(@RequestParam String indexId) throws Exception {
		Map<String, Object> result = pmaFEvlIndexInfoService.getTypesByPkid(indexId);
		return new ResultDto<Map<String, Object>> (result);
	}

}
