package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFDistributionModeDetail;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFDistributionModeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDistributionModeDetailResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-23 10:36:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafdistributionmodedetail")
public class PmaFDistributionModeDetailResource extends CommonResource<PmaFDistributionModeDetail, String> {
    @Autowired
    private PmaFDistributionModeDetailService pmaFDistributionModeDetailService;

    @Override
    protected CommonService getCommonService() {
        return pmaFDistributionModeDetailService;
    }
    
	
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		List<Map<String, Object>> list = pmaFDistributionModeDetailService.queryList(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	@PostMapping("/addinfo")
	public ResultDto<Object> addInfo(@RequestBody List<PmaFDistributionModeDetail> list) {
		return pmaFDistributionModeDetailService.addInfo(list);
	}
}
