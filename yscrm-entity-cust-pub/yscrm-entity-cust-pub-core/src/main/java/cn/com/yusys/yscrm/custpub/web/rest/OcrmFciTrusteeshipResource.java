package cn.com.yusys.yscrm.custpub.web.rest;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipApply;
import cn.com.yusys.yscrm.custpub.service.OcrmFciTrusteeshipService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFciTrusteeshipResource
 * @类描述：客户托管Resource
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-16
 */
@RestController
@RequestMapping("/api/trusteeship")
@Api(value = "trusteeship", description = "托管管理")
public class OcrmFciTrusteeshipResource extends CommonResource<OcrmFciTrusteeshipApply, Serializable>{

	
	@Autowired
	private OcrmFciTrusteeshipService service;
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}

	/**
	* @方法名称: trustList
	* @方法描述: 客户托管历史查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<Map<String,Object>>> trustList(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.trustList(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: trustInsert
	* @方法描述: 客户托管
	* @参数与返回说明: 
	* @算法描述:
	**/
//	@PostMapping("/insert")
//	public ResultDto<Integer>trustInsert(@RequestBody @Validated OcrmFciTrusteeshipApply record) throws ParseException {
//		return this.service.trustInsert(record);
//	}
	/**
	* @throws ParseException 
	* @方法名称: trustInsert
	* @方法描述: 客户托管
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/add")
	public ResultDto<Integer> add(@RequestBody Map<String, Object> map) {
		return new ResultDto<>(service.add(map));
	}
//	/**
//	* @方法名称: trustRecover
//	* @方法描述: 客户托管回收
//	* @参数与返回说明: 
//	* @算法描述:
//	**/
//	@PostMapping("/recover/{applyId}")
//	public ResultDto<Integer>trustRecover(@PathVariable("applyId") @Validated String applyId) {
//		return this.service.trustRecover(applyId);
//	}
	/**
	* @方法名称: trustRecover
	* @方法描述: 客户托管回收
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/recover")
	public ResultDto<Integer> trustRecover(@RequestBody Map<String, String> map) {
		return service.trustRecover(map);
	}
	/**
	* @方法名称: custTrustList
	* @方法描述: 客户托管清单
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/custtrustlist")
	public ResultDto<List<Map<String,Object>>>custTrustList(@Validated QueryModel model){
		return new ResultDto<List<Map<String,Object>>>(this.service.custTrustList(model));
	}
	 /**
		* @方法名称: myCustListByModel
		* @方法描述: 查询管户客户
		* @参数与返回说明: 
		* @算法描述: 
		*/
	    @GetMapping("/mycustlist")
	    public ResultDto<List<Map<String, String>>> myCustListByModel(QueryModel model){
			return new ResultDto<List<Map<String, String>>>(service.myCustListByModel(model));
	    }
	    /**
		* @方法名称: getTrustCust
		* @方法描述: 查询托管中客户
		* @参数与返回说明: 
		* @算法描述: 
		*/
	    @GetMapping("/trustcust")
	    public ResultDto<List<Map<String, String>>> getTrustCust(QueryModel model){
			return new ResultDto<List<Map<String, String>>>(service.getTrustCust(model));
	    }
	    /**
		* @方法名称: getTrustList
		* @方法描述: 查询托管中的列表信息
		* @参数与返回说明: 
		* @算法描述: 
		*/
	    @GetMapping("/trustlist")
	    public ResultDto<List<Map<String, String>>> getTrustList(QueryModel model){
			return new ResultDto<List<Map<String, String>>>(service.getTrustList(model));
	    }

	/**
	 * @方法名称: getTrustList
	 * @方法描述: 详情列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/detailelist")
	public ResultDto<Map<String, Object>> detailelist(String applyId){
		return new ResultDto<Map<String, Object>>(service.detailelist(applyId));
	}


}
