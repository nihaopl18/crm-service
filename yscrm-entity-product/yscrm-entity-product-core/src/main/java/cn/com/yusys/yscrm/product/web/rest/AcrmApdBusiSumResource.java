package cn.com.yusys.yscrm.product.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.product.domain.AcrmApdBusiSum;
import cn.com.yusys.yscrm.product.service.AcrmApdBusiSumService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmApdBusiSumResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-13 10:59:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmapdbusisum")
public class AcrmApdBusiSumResource extends CommonResource<AcrmApdBusiSum, String> {
    @Autowired
    private AcrmApdBusiSumService acrmApdBusiSumService;

    @Override
    protected CommonService getCommonService() {
        return acrmApdBusiSumService;
    }

    /**
   	 * @方法名称: numberOfCustQuery
   	 * @方法描述: 持有产品客户数量趋势
   	 * @param 
   	 * @return
   	 */
    @SuppressWarnings("rawtypes")
   	@GetMapping("/numberofcustquery/{prodId}")
   	public ResultDto<Map<String, Object>> numberOfCustQuery(@PathVariable String prodId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xaxis", this.acrmApdBusiSumService.getXaxisArray(prodId));
		Map resultMap = this.acrmApdBusiSumService.getPerCustAum(prodId);
		map.put("aum1", resultMap.get("aum1"));
		return new ResultDto<Map<String, Object>>(map);
	}
   	
   	/**
   	 * @方法名称: salesScaleQuery
   	 * @方法描述: 持有产品客户数量趋势
   	 * @param 
   	 * @return
   	 */
    @SuppressWarnings("rawtypes")
   	@GetMapping("/salesscalequery/{prodId}")
   	public ResultDto<Map<String, Object>> salesScaleQuery(@PathVariable String prodId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xaxis", this.acrmApdBusiSumService.getXaxisArray(prodId));
		Map resultMap = this.acrmApdBusiSumService.getPerCustAum(prodId);
		map.put("aum2", resultMap.get("aum2"));
		return new ResultDto<Map<String, Object>>(map);
	}
}
