package cn.com.yusys.yscrm.product.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.product.domain.AcrmFpdSaleStatistics;
import cn.com.yusys.yscrm.product.service.AcrmFpdSaleStatisticsService;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdSaleStatisticsResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-12 19:11:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfpdsalestatistics")
public class AcrmFpdSaleStatisticsResource extends CommonResource<AcrmFpdSaleStatistics, String> {
    @Autowired
    private AcrmFpdSaleStatisticsService acrmFpdSaleStatisticsService;

    @Override
    protected CommonService getCommonService() {
        return acrmFpdSaleStatisticsService;
    }

    /**
   	 * @方法名称: questionsAnswersQuery
   	 * @方法描述: 产品销售情况查询
   	 * @param 
   	 * @return
   	 */
   	@GetMapping("/salessituationquery/{prodId}")
   	public ResultDto<List<Map<String, Object>>> salesSituationQuery(QueryModel model, @PathVariable String prodId){
   		List<Map<String, Object>> focusCust = acrmFpdSaleStatisticsService.salesSituationQuery(model, prodId);
   		if(focusCust.size()>0) {
   			return new ResultDto<List<Map<String, Object>>>(focusCust);
   		}else {
   			return null;
   		}
   	}
    
}
