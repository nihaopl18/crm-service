package cn.com.yusys.climp.qypool.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.climp.qypool.domain.LoyQyCommodityCategory;
import cn.com.yusys.climp.qypool.domain.LoyQyCommodityInfo;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommodityInfoMapper;
import cn.com.yusys.climp.qypool.service.LoyQyCommodityCategoryService;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityCategoryResource
 * @类描述: 商品类别资源类
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
@RequestMapping("/api/loyqycommoditycategory")
public class LoyQyCommodityCategoryResource extends CommonResource<LoyQyCommodityCategory, String> {
    @Autowired
    private LoyQyCommodityCategoryService loyQyCommodityCategoryService;
    @Autowired
    private LoyQyCommodityInfoMapper commMapper;
    
    @Override
    protected CommonService getCommonService() {
        return loyQyCommodityCategoryService;
    }
    /**
	* @方法名称:getCategory
	* @方法描述:商品类别树查询
	* @参数与返回说明:
	* @算法描述:
	 */
    @GetMapping("/categorytree")
	public ResultDto<List<LoyQyCommodityCategory>> getCategoryTree() {
		List<LoyQyCommodityCategory> list = loyQyCommodityCategoryService.getCategoryTree();
		return new ResultDto<List<LoyQyCommodityCategory>>(list);
	}
	/**
	* @方法名称:getCategory
	* @方法描述:商品类别查询
	* @参数与返回说明:
	* @算法描述:
	 */
    @GetMapping("/categorylist")
	public ResultDto<List<LoyQyCommodityCategory>> getCategory(QueryModel queryModel) {
		List<LoyQyCommodityCategory> list = loyQyCommodityCategoryService.getCategory(queryModel);
		return new ResultDto<List<LoyQyCommodityCategory>>(list);
	}
    
    /**
     * @方法名称:delCategory
     * @方法描述:刪除
     * @参数与返回说明:
     * @算法描述:
      */
     @PostMapping("/delcategory")
     public ResultDto<Map<String, Object>> delCategory(@RequestBody String categoryCode) {
        ResultDto<Map<String, Object>> reuslt=new ResultDto<Map<String, Object>>();
 		try {
 			List<LoyQyCommodityInfo> data = commMapper.getCommByCategoryCode(categoryCode);
 	    	if(data.size()>0) {
 	    		reuslt.setCode(200001);
 				reuslt.setMessage("该商品类别已被商品使用不能删除！");
 	    	}else {
 	    		loyQyCommodityCategoryService.delCategory(categoryCode);
 	    		reuslt.setCode(0);
 	    		reuslt.setMessage("商品类别删除成功！");
 	    	}
 		}catch (Exception e) {
 			reuslt.setCode(100001);
 			reuslt.setMessage("fail");
 		}
 		return reuslt;
     }
     
     @GetMapping("/getinstus")
     public ResultDto<List<Map<String,Object>>>getInstus() {
    	 return new ResultDto<List<Map<String,Object>>>(loyQyCommodityCategoryService.getInstus());
     }
}
