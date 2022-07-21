package cn.com.yusys.climp.qypool.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.qypool.domain.LoyQyMaterialList;
import cn.com.yusys.climp.qypool.service.MerchantCompareService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@RestController
@RequestMapping("/api/merchantcompare")
public class MerchantCompareResource extends CommonResource<LoyQyMaterialList, String>{

	@Autowired
	private MerchantCompareService service;
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	/**
	 * @方法名称:getCompareList
	 * @方法描述:查询商户对账列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getcomparelist")
	public ResultDto<List<Map<String,Object>>> getCompareList(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.getCompareList(model));
	}
	/**
	 * @方法名称:insert
	 * @方法描述:新增素材列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
//	@PostMapping("/insert")
//	public ResultDto<Integer>insert(@RequestBody LoyQyMaterialList record) {
//		return this.service.insert(record); 
//	}
//	/**
//	 * @方法名称:edit
//	 * @方法描述:修改素材列表
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	@PostMapping("/edit")
//	public ResultDto<Integer>edit(@RequestBody LoyQyMaterialList record) {
//		return this.service.edit(record);
//	}
	/**legal_person
	 * @方法名称:merchantDetail
	 * @方法描述:商户对账详情列表
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/merchantdetail")
	public ResultDto<List<Map<String,Object>>> merchantDetail(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(this.service.merchantDetail(model));
	}
}
