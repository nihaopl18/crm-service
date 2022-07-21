package cn.com.yusys.climp.qypool.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.climp.qypool.domain.LoyQyCommodityInfo;
import cn.com.yusys.climp.qypool.service.LoyQyCommodityInfoService;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityInfoResource
 * @类描述: 商品信息资源类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyqycommodityinfo")
public class LoyQyCommodityInfoResource extends CommonResource<LoyQyCommodityInfo, String> {
    @Autowired
    private LoyQyCommodityInfoService loyQyCommodityInfoService;

    @Override
    protected CommonService getCommonService() {
        return loyQyCommodityInfoService;
    }

	/**
	 * @方法名称:getDetail
	 * @方法描述:商品信息查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/detail")
	public ResultDto<Map<String,Object>> getDetail(String id) {
		Map<String,Object> map = loyQyCommodityInfoService.getDetail(id);
		return new ResultDto<Map<String,Object>>(map);
	}
    /**
	* @方法名称:getCommodity
	* @方法描述:商品信息查询
	* @参数与返回说明:
	* @算法描述:
	 */
    @GetMapping("/commlist")
	public ResultDto<List<LoyQyCommodityInfo>> getCommodity(QueryModel queryModel) {
		List<LoyQyCommodityInfo> list = loyQyCommodityInfoService.getCommodity(queryModel);
		return new ResultDto<List<LoyQyCommodityInfo>>(list);
	}
	/**
	 * @方法名称:getAttr
	 * @方法描述:扩展属性查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/attr")
	public ResultDto<List<Map<String,String>>> getAttr(QueryModel queryModel) {
		List<Map<String,String>> list = loyQyCommodityInfoService.getAttr(queryModel);
		return new ResultDto<List<Map<String,String>>>(list);
	}
	/**
	 * @方法名称:addCommAttr
	 * @方法描述:商品扩展属性查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/addcommattr")
	public ResultDto<Integer> addCommAttr(@RequestBody Map<String, String> map) {
		int num = loyQyCommodityInfoService.addCommAttr(map);
		return new ResultDto<>(num);
	}
    /**
 	* @方法名称:getCommodityByIds
 	* @方法描述:根据ID查询商品信息
 	* @参数与返回说明:
 	* @算法描述:
 	 */
     @GetMapping("/comminfobyid")
 	public ResultDto<List<LoyQyCommodityInfo>> getCommodityByIds(String commodityCode) {
 		List<LoyQyCommodityInfo> list = loyQyCommodityInfoService.getCommodityById(commodityCode);
 		return new ResultDto<List<LoyQyCommodityInfo>>(list);
 	}
    /**
    * @方法名称:delCommodity
    * @方法描述:删除商品
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/delcommodity")
    public ResultDto<Integer> delCommodity(@RequestBody String id) {
    	return new ResultDto<Integer>(loyQyCommodityInfoService.delCommodity(id));
    }
    /**
    * @方法名称:doUpdateUpDown
    * @方法描述:商品上下架
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/doupdateupdown")
    public ResultDto<Integer> doUpdateUpDown(@RequestBody Map<?,?> map) {
    	String[] idStr = map.get("ids").toString().split(",");
    	String onShelfBegin;
    	String onShelfEnd;
    	String upDownState = map.get("upDownState").toString();
    	if("U".equals(upDownState)) {
    		onShelfBegin = map.get("onShelfBegin").toString();
    		onShelfEnd = map.get("onShelfEnd").toString();
    	} else {
    		onShelfBegin = "";
    		onShelfEnd = "";
    	}
		ResultDto<Integer> rs = new ResultDto<>();
		try {
			int num = loyQyCommodityInfoService.doUpdateUpDown(idStr,upDownState,onShelfBegin,onShelfEnd);
			rs.setData(num);
		}catch (Exception e){
			rs.setCode(-1);
			rs.setMessage("系统错误");
		}
    	return rs;
    }
    
    /**
	* @方法名称:getOrgByInstuValue
	* @方法描述:通过金融机构查询机构列表
	* @参数与返回说明: instuValue-机构id
	* @算法描述:
	 */
    @GetMapping("/getorgbyinstu")
	public ResultDto<List<Map<String,Object>>>getOrgByInstuValue(@RequestParam("instuValue") String instuValue) {
		return new ResultDto<List<Map<String,Object>>>(loyQyCommodityInfoService.getOrgByInstuValue(instuValue));
	}
}