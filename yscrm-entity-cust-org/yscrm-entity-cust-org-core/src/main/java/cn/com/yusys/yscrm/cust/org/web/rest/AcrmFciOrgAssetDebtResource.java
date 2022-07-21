package cn.com.yusys.yscrm.cust.org.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgAssetDebt;
import cn.com.yusys.yscrm.cust.org.service.AcrmFciOrgAssetDebtService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgAssetDebtResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 10:54:47
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciorgassetdebt")
public class AcrmFciOrgAssetDebtResource extends CommonResource<AcrmFciOrgAssetDebt, String> {
	
	private Logger logger = LoggerFactory.getLogger(AcrmFciOrgAssetDebtResource.class);
    @Autowired
    private AcrmFciOrgAssetDebtService acrmFciOrgAssetDebtService;

    @Override
    protected CommonService getCommonService() {
        return acrmFciOrgAssetDebtService;
    }
    
    /**
 	 * @方法名称: queryList
 	 * @方法描述: 财务报表列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querylist/{custId}")
	public ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel,@PathVariable("custId") String custId) {
    	logger.debug("查询财务报表列表,客户编号{}",custId);
		List<Map<String, Object>> list = acrmFciOrgAssetDebtService.queryList(queryModel,custId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

}
