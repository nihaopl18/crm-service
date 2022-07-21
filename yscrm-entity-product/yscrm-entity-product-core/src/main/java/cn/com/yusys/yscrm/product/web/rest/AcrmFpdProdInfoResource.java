package cn.com.yusys.yscrm.product.web.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.AcrmFPdProdShortInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdInfo;
import cn.com.yusys.yscrm.product.service.AcrmFpdProdInfoService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-01-29 15:15:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfpdprodinfo")
public class AcrmFpdProdInfoResource extends CommonResource<AcrmFpdProdInfo, String> {
    @Autowired
    private AcrmFpdProdInfoService acrmFpdProdInfoService;
    
    @Autowired
   	private UaaClient uaaClient;
    
    @Override
    protected CommonService getCommonService() {
        return acrmFpdProdInfoService;
    }
    
    /**
	 * @方法名称: productInfoQuery
	 * @方法描述: 产品信息查询
	 * @param 
	 * @return
	 */
	@GetMapping("/productinfoquery")
	public ResultDto<List<AcrmFPdProdShortInfo>> productInfoQuery(QueryModel model){
		List<AcrmFPdProdShortInfo> focusCust = acrmFpdProdInfoService.productInfoQuery(model);
		if(focusCust.size()>0) {
			return new ResultDto<>(focusCust);
		}else {
			return null;
		}
	}
	
	/**
	 * @方法名称: ctrateProductInfo
	 * @方法描述: 产品信息新增
	 * @param 
	 * @return
	 */
	@PostMapping("/ctrateproductinfo")
	public ResultDto<Object> ctrateProductInfo(@RequestBody Map<String, Object> map) {
		int result = 0;
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		map.put("lastChgSys", "CRM");
		map.put("lastChgUsr", dto.getBody().getLoginCode());
		map.put("lastChgTm", new Date());
		map.put("corpOrgCode", dto.getBody().getInstu().getCode());
		map.put("pdSource", "CRM");
		if(map.get("proId")==null || map.get("proId").equals("")) {
			map.put("dataDate", sdf.format(new Date()));
			result = acrmFpdProdInfoService.ctrateProductInfo(map);
		} else {
			String proId = (String) map.get("proId");
			result = acrmFpdProdInfoService.editProductInfo(map);
		}
		return new ResultDto<Object>(result);
	}
	
	/**
	 * @方法名称: delerteProductInfo
	 * @方法描述: 产品信息删除
	 * @param 
	 * @return
	 */
	@PostMapping("/delerteproductinfo")
	public int delerteProductInfo(@RequestBody Map<String, String> map) {
		String productId = map.get("productId").toString();
		return acrmFpdProdInfoService.delerteProductInfo(productId);
	}
	
	/**
	 * 产品基本信息
	 * 
	 * @param prodCode
	 * @return
	 */
	@GetMapping("/productbasicinfoquery")
	public ResultDto<List<Map<String, Object>>> productBasicInfoQuery(@RequestParam(value="prodCode")String prodCode, @RequestParam(value="prodId") String prodId) {
		List<Map<String, Object>> list = acrmFpdProdInfoService.productBasicInfoQuery(prodCode,prodId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * @方法名称: productNetValueInfoQuery
	 * @方法描述: 产品净值趋势
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/productnetvalueinfoquery")
	public ResultDto<List<Map<String, Object>>> productNetValueInfoQuery(QueryModel queryModel) {
		List<Map<String, Object>> list = acrmFpdProdInfoService.productNetValueInfoQuery(queryModel);
		return new ResultDto<>(list);
	}

	/**
	 * @方法名称: productNetValueInfoQuery
	 * @方法描述: 客户收益
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/productcustfitinfoquery")
	public ResultDto<List<Map<String, Object>>> productCustFitInfoQuery(QueryModel queryModel) {
		List<Map<String, Object>> list = acrmFpdProdInfoService.productCustFitInfoQuery(queryModel);
		return new ResultDto<>(list);
	}

}
