package cn.com.yusys.climp.qypool.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantAddress;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantContact;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantInfo;
import cn.com.yusys.climp.qypool.service.LoyQyMerchantInfoService;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMerchantInfoResource
 * @类描述: #资源类
 * @功能描述: 商户管理的相关API接口实现
 * @创建人: hujun3
 * @创建时间: 2019-02-27 14:28:32
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyqymerchantinfo")
public class LoyQyMerchantInfoResource extends CommonResource<LoyQyMerchantInfo, String> {
	private Logger logger = LoggerFactory.getLogger(LoyQyMerchantInfoResource.class);
    @Autowired
    private LoyQyMerchantInfoService loyQyMerchantInfoService;

    @Override
    protected CommonService getCommonService() {
        return loyQyMerchantInfoService;
    }
    /**
	 * 
	* @方法名称: getListByPage
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/query")
	public ResultDto<List<Map<String,Object>>> getListByPage(QueryModel queryModel) {
		
		ResultDto<List<Map<String,Object>>> reuslt=new ResultDto<List<Map<String,Object>>>();
		try {
			List<Map<String,Object>> list = loyQyMerchantInfoService.findAllByParam(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String,Object>>>(list);
			}
			logger.info("商户信息分页查询");
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
    /**
	 * 
	* @方法名称: getList
	* @方法描述: 商户组件分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getlist")
	public ResultDto<List<Map<String,Object>>> getList(QueryModel queryModel) {
		
		ResultDto<List<Map<String,Object>>> reuslt=new ResultDto<List<Map<String,Object>>>();
		try {
			List<Map<String,Object>> list = loyQyMerchantInfoService.getInfoByParam(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String,Object>>>(list);
			}
			logger.info("商户信息分页查询");
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getMerchantDetail
	* @方法描述: 审批页面查询商户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/detail")
	public ResultDto<Map<String,Object>> getMerchantDetail(String id) {
		
		ResultDto<Map<String,Object>> reuslt=new ResultDto<Map<String,Object>>();
		try {
			List<Map<String,Object>> list = loyQyMerchantInfoService.getInfoById(id);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<Map<String,Object>>(list.get(0));
			}
			logger.info("审批页面查询商户信息");
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getContactByMerId
	* @方法描述: 查询商户联系信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/querycontactinfo")
	public ResultDto<List<Map<String,Object>>> getContactByMerId(QueryModel queryMode) {
		
		ResultDto<List<Map<String,Object>>> reuslt=new ResultDto<List<Map<String,Object>>>();
		try {
			List<Map<String,Object>> list = loyQyMerchantInfoService.getContactByMerId(queryMode);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String,Object>>>(list);
			}
			logger.info("商户联系信息分页查询");
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getAddressByMerId
	* @方法描述: 查询商户地址信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/queryaddressinfo")
	public ResultDto<List<Map<String,Object>>> getAddressByMerId(QueryModel queryMode) {
		
		ResultDto<List<Map<String,Object>>> reuslt=new ResultDto<List<Map<String,Object>>>();
		try {
			List<Map<String,Object>> list = loyQyMerchantInfoService.getAddressByMerId(queryMode);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String,Object>>>(list);
			}
			logger.info("查询商户地址信息");
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: editContactInfo
	* @方法描述:维护商户联系信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/editcontactinfo")
	public void editContactInfo(@RequestBody LoyQyMerchantContact data) {
		loyQyMerchantInfoService.editContactInfo(data);
	
	}	
	/**
	 * 
	* @方法名称: editAddressInfo
	* @方法描述:维护商户地址信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/editaddressinfo")
	public void editAddressInfo(@RequestBody LoyQyMerchantAddress data) {
		loyQyMerchantInfoService.editAddressByMerId(data);
	
	}	
	
	/**
	 * 
	* @方法名称: getMerchantDetailList
	* @方法描述: 查询商户详情信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/detailList")
	public ResultDto<List<Map<String,Object>>> getMerchantDetailList(String ids) {
		
		ResultDto<List<Map<String,Object>>> reuslt=new ResultDto<List<Map<String,Object>>>();
		try {
			List<Map<String,Object>> list = loyQyMerchantInfoService.getInfoByIds(ids);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String,Object>>>(list);
			}
			logger.info("审批页面查询商户信息");
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: addMerchantInfo
	* @方法描述: 新增商户信息数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/addmerchantinfo")
	public ResultDto<Object> addMerchantInfo(@RequestBody LoyQyMerchantInfo pool) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			String id=loyQyMerchantInfoService.addMerchantInfo(pool);
			reuslt.setData(id);
			reuslt.setMessage("success");
			logger.info("新增商户信息数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: updateMerchantInfo
	* @方法描述: 更新商户信息数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updatemerchantinfo")
	public ResultDto<Object> updateMerchantInfo(@RequestBody LoyQyMerchantInfo pool) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			loyQyMerchantInfoService.updateMerchantInfo(pool);
			reuslt.setMessage("success");
			logger.info("更新商户信息数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: uploadMerchantlist
	* @方法描述: 批量导入商户信息数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	 @PostMapping("/uploadmerchantlist")
	public ResultDto<Object> uploadMerchantlist(@RequestParam(required = false) String flag,MultipartFile file) {
		ResultDto<Object> rs = new ResultDto<Object>();
		try {
			String magges = this.loyQyMerchantInfoService.dataImport(flag, file);
			if (magges.equals("")) {
				rs.setMessage("导入失败");
				rs.setCode(-1);
				return rs;
			}
			rs.setMessage(magges);
			rs.setCode(0);
			return rs;
		}catch (Exception e) {
			rs.setCode(-1);
		    rs.setMessage("导入失败："+e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} // UTF-8
		return rs ;
	}
	/**
	 * 
	* @方法名称: updateMerchantSts
	* @方法描述: 更新商户数据的生效状态
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updatests")
	public ResultDto<Object> updateMerchantSts(@RequestBody Map<?,?>param) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			if(param!=null) {
				loyQyMerchantInfoService.updateDataStsInfo(param.get("ids").toString(), param.get("status").toString());
				reuslt.setMessage("success");
				logger.info("更新商户数据的生效状态");
			}else {
				reuslt.setCode(100001);
				reuslt.setMessage("fail:参数为空");
			}
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: deleteMerchant
	* @方法描述: 删除相关数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/deleteinfo")
	public ResultDto<Object> deleteMerchant(String ids) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			loyQyMerchantInfoService.deleteByIds(ids);
			reuslt.setMessage("success");
			logger.info("删除商户数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: deleteContact
	* @方法描述: 删除商户联系数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/deletecontactinfo")
	public ResultDto<Object> deleteContact(String ids) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			loyQyMerchantInfoService.deleteContactInfo(ids);
			reuslt.setMessage("success");
			logger.info("删除商户联系数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: deleteAddressInfo
	* @方法描述: 删除商户地址数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/deleteaddressinfo")
	public ResultDto<Object> deleteAddressInfo(String ids) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			loyQyMerchantInfoService.deleteAddressInfo(ids);
			reuslt.setMessage("success");
			logger.info("删除商户地址数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getAddressProvince
	* @方法描述: 获取省份
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/province")
	public ResultDto<List<Map<String, Object>>> getAddressProvince() {
		
		return new ResultDto<>(loyQyMerchantInfoService.getAddressProvince());
	}
	/**
	 * 
	* @方法名称: getAddressCity
	* @方法描述: 获取城市
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/city")
	public ResultDto<List<Map<String, Object>>> getAddressCity(QueryModel model) {
		
		return new ResultDto<>(loyQyMerchantInfoService.getAddressCity(model));
	}
	/**
	 * 
	* @方法名称: getAddressArea
	* @方法描述: 获取县区
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/area")
	public ResultDto<List<Map<String, Object>>> getAddressArea(QueryModel model) {
		
		return new ResultDto<>(loyQyMerchantInfoService.getAddressArea(model));
	}
}
