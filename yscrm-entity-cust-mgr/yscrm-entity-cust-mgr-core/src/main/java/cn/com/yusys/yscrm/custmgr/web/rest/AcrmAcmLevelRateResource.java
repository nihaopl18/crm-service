package cn.com.yusys.yscrm.custmgr.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custmgr.domain.AcrmAcmLevelRate;
import cn.com.yusys.yscrm.custmgr.service.AcrmAcmLevelRateService;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmLevelRateResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 09:58:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmacmlevelrate")
public class AcrmAcmLevelRateResource extends CommonResource<AcrmAcmLevelRate, String> {
    @Autowired
    private AcrmAcmLevelRateService acrmAcmLevelRateService;

    @Override
    protected CommonService getCommonService() {
        return acrmAcmLevelRateService;
    }
    
    /**
 	 * @方法名称: queryPerCustGradeDist
 	 * @方法描述: 查询零售客户等级分布数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querypercustgradedist/{mgrId}")
	public ResultDto<List<Map<String, Object>>> queryPerCustGradeDist(@PathVariable String mgrId) {
		List<Map<String, Object>> list = acrmAcmLevelRateService.queryPerCustGradeDist(mgrId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    
    /**
 	 * @方法名称: queryOrgCustGradeDist
 	 * @方法描述: 查询对公客户等级分布数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/queryorgcustgradedist/{mgrId}")
	public ResultDto<List<Map<String, Object>>> queryOrgCustGradeDist(@PathVariable String mgrId) {
		List<Map<String, Object>> list = acrmAcmLevelRateService.queryOrgCustGradeDist(mgrId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

}
