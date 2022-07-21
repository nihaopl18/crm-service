package cn.com.yusys.yscrm.cust.org.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgFinItem;
import cn.com.yusys.yscrm.cust.org.service.AcrmFciOrgFinItemService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgFinItemResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 10:55:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciorgfinitem")
public class AcrmFciOrgFinItemResource extends CommonResource<AcrmFciOrgFinItem, String> {
    @Autowired
    private AcrmFciOrgFinItemService acrmFciOrgFinItemService;

    @Override
    protected CommonService getCommonService() {
        return acrmFciOrgFinItemService;
    }
    
    /**
 	 * @方法名称: queryList
 	 * @方法描述: 财务报表指标列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querylist/{reportId}")
	public ResultDto<List<Map<String, Object>>> queryList(@PathVariable("reportId") String reportId) {
		List<Map<String, Object>> list = acrmFciOrgFinItemService.queryList(reportId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

}
