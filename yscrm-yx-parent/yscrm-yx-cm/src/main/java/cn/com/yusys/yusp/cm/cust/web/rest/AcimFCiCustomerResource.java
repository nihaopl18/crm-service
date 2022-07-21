package cn.com.yusys.yusp.cm.cust.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.cm.cust.service.AcimFCiCustomerService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称：cn.com.yusys.yscimc.cm
 * @类名称：AcimFCiCustomerResource
 * @类描述：客户相关接口
 * @功能描述:
 * @创建人：yangxiao
 * @创建时间：2019-06-20
 */
@RestController
@RequestMapping("/api/acimfcicustomer")
public class AcimFCiCustomerResource extends CommonResource<AcimFCiCustomer, String>{
	@Autowired
	private AcimFCiCustomerService service;
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.service;
	}
	//显示查询列表信息
	@GetMapping("/list")
	public ResultDto<List<AcimFCiCustomer>> getListByModel(QueryModel queryModel) {
		List<AcimFCiCustomer> list = service.getListByModel(queryModel);
		return new ResultDto<List<AcimFCiCustomer>>(list);
	}
	@GetMapping("/listcmp")
	public ResultDto<List<AcimFCiCustomer>> getListCmp(QueryModel queryModel) {
		List<AcimFCiCustomer> list = service.getListCmp(queryModel);
		return new ResultDto<List<AcimFCiCustomer>>(list);
	}
	
	@GetMapping("/getcusttype")
	public ResultDto<List<AcimFCiCustomer>> getCustTypeByid(String custId) {
		List<AcimFCiCustomer> list = service.getCustTypeByid(custId);
		return new ResultDto<List<AcimFCiCustomer>>(list);
	}
	@PostMapping("/insertcust")
	public ResultDto<Integer> insertList(@RequestBody AcimFCiCustomer record) {
		return new ResultDto<Integer> (service.insertSelective(record));
	}
	@PostMapping("/updatecust")
	public ResultDto<Integer> updateList(@RequestBody AcimFCiCustomer record) {
		return new ResultDto<Integer> (service.updateSelective(record));
	}
	@PostMapping("/deletecust")
	public ResultDto<Integer> deleteList(@RequestBody Map<String,Object> param) {
		String ids = param.get("ids").toString();
		return new ResultDto<Integer> (service.deleteByIds(ids));
	}
}
