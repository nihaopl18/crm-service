package cn.com.yusys.yscrm.custpub.web.rest;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciGrantApply;
import cn.com.yusys.yscrm.custpub.service.OcrmFciGrantService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFciGrantResource
 * @类描述：客户授权Resource
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-16
 */
@RestController
@RequestMapping("/api/grantapply")
public class OcrmFciGrantResource extends CommonResource<OcrmFciGrantApply, Serializable>{

	@Autowired
	private OcrmFciGrantService service;
	@Override
	protected CommonService getCommonService() {
		return this.service ;
	}
	
	/**
	* @方法名称: grantList
	* @方法描述: 客户授权历史查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<Map<String,Object>>>grantList(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.grantList(model));
	}
	/**
	* @方法名称: custList
	* @方法描述: 所辖客户查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/custlist")
	public ResultDto<List<Map<String,Object>>>custList(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.custList(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: grantInsert
	* @方法描述: 客户授权
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/insert")
	public ResultDto<Integer>grantInsert(@RequestBody @Validated OcrmFciGrantApply record) throws ParseException {
		return this.service.grantInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: trustInsert
	* @方法描述: 客户授权
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/add")
	public ResultDto<Integer> add(@RequestBody Map<String, Object> map) {
		return new ResultDto<>(service.add(map));
	}
	/**
	* @方法名称: grantRecover
	* @方法描述: 客户授权回收
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/recover")
	public ResultDto<Integer> grantRecover(@RequestBody Map<String, String> map) {
		return this.service.grantRecover(map);
	}
	/**
	* @方法名称: getCM
	* @方法描述: 客户经理放大镜
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getcm")
	public ResultDto<List<Map<String,Object>>> getCM(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.getCM(model));
	}
	/**
	* @方法名称: custGrantList
	* @方法描述: 客户授权清单
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/custgrantlist")
	public ResultDto<List<Map<String,Object>>> custGrantList(@Validated QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.custGrantList(model));
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
    @GetMapping("/grantcust")
    public ResultDto<List<Map<String, String>>> getTrustCust(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(service.getGrantCust(model));
    }
    /**
	* @方法名称: getTrustList
	* @方法描述: 查询托管中的列表信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/grantlist")
    public ResultDto<List<Map<String, String>>> getTrustList(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(service.getGrantList(model));
    }
}
