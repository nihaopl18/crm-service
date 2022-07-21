package cn.com.yusys.yscrm.salesoppor.web.rest;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.salesoppor.domain.OcrmFMkMktSalesOpporInfo;
import cn.com.yusys.yscrm.salesoppor.service.OcrmFMkMktSalesOpporService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkMktSalesOpporResource
 * @类描述：商机管理相关Resource
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-14
 */
@RestController
@RequestMapping("/api/salesoppor")
public class OcrmFMkMktSalesOpporResource extends CommonResource<OcrmFMkMktSalesOpporInfo, Serializable>{
	@Autowired
	private OcrmFMkMktSalesOpporService service;
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	* @方法名称: opporListQuery
	* @方法描述: 获取商机池信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/opporlistquery")
	public ResultDto<List<Map<String,Object>>> opporListQuery(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.opporListQuery(model));
	}
	/**
	* @方法名称: opporDel
	* @方法描述: 删除商机
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/oppordel")
	public ResultDto<Integer> opporDel(@RequestBody @Validated OcrmFMkMktSalesOpporInfo record) {
		return this.service.opporDel(record);
	}
	/**
	* @方法名称: myOpporListQuery
	* @方法描述: 获取客户经理商机信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/myopporlistquery")
	public ResultDto<List<Map<String,Object>>> myOpporListQuery(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.myOpporListQuery(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: opporInsert
	* @方法描述: 新增商机
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/opporinsert")
	public ResultDto<Integer> opporInsert(@RequestBody OcrmFMkMktSalesOpporInfo record) throws ParseException {
		return this.service.opporInsert(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: opporEdit
	* @方法描述: 修改商机
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/opporedit")
	public ResultDto<Integer> opporEdit(@RequestBody @Validated OcrmFMkMktSalesOpporInfo record) throws ParseException {
		return this.service.opporEdit(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: opporAssign
	* @方法描述: 商机分配
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/opporassign")
	public ResultDto<Integer> opporAssign(@RequestBody @Validated OcrmFMkMktSalesOpporInfo record) throws ParseException {
		return this.service.opporAssign(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: opporReceive
	* @方法描述: 商机认领
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/opporreceive")
	public ResultDto<Integer> opporReceive(@RequestBody @Validated OcrmFMkMktSalesOpporInfo record) throws ParseException {
		return this.service.opporReceive(record);
	}
	/**
	* @方法名称: opporBack
	* @方法描述: 商机退回
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/opporback")
	public ResultDto<Integer> opporBack(@RequestBody @Validated OcrmFMkMktSalesOpporInfo record) {
		return this.service.opporBack(record);
	}
	/**
	* @方法名称: opporOff
	* @方法描述: 商机关闭
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/opporoff")
	public ResultDto<Integer> opporOff(@RequestBody @Validated OcrmFMkMktSalesOpporInfo record) {
		return this.service.opporOff(record);
	}
	/**
	* @方法名称: getCustData
	* @方法描述: 返回客户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getcustdata/{custId}")
	public ResultDto<List<Map<String,Object>>>getCustData(@PathVariable("custId") @Validated String custId) {
		return new ResultDto<List<Map<String,Object>>>(this.service.getCustData(custId));
	}
}
