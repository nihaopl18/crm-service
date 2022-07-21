package cn.com.yusys.yscrm.infocalculator.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.infocalculator.domain.AcrmFpdInterestRate;
import cn.com.yusys.yscrm.infocalculator.service.AcrmFpdInterestRateService;

/**
 * @项目名称: yscrm-func-info-calculator-core模块
 * @类名称: AcrmFpdInterestRateResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-12 16:07:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfpdinterestrate")
public class AcrmFpdInterestRateResource extends CommonResource<AcrmFpdInterestRate, String> {
    @Autowired
    private AcrmFpdInterestRateService acrmFpdInterestRateService;

    @Override
    protected CommonService getCommonService() {
        return acrmFpdInterestRateService;
    }

    @GetMapping("/querylistdep")
	public ResultDto<List<Map<String, Object>>> getListDep(QueryModel queryModel) {
    	ResultDto<List<Map<Object, String>>> resultDto = null;
//	  		String custId = (String) queryModel.getCondition().get("custId");
//	  		if (custId == null || custId.equals("")) {
//	  			resultDto = new ResultDto<>();
//	  			resultDto.setMessage("查询失败");
//	  			resultDto.setCode(-1);
//	  			return new ResultDto<>(null);
//	  		}
    	List<Map<String, Object>> list = acrmFpdInterestRateService.getListDep(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
    @GetMapping("/querylistloan")
	public ResultDto<List<Map<String, Object>>> getListLoan(QueryModel queryModel) {
    	ResultDto<List<Map<String, Object>>> resultDto = null;
//	  		String custId = (String) queryModel.getCondition().get("custId");
//	  		if (custId == null || custId.equals("")) {
//	  			resultDto = new ResultDto<>();
//	  			resultDto.setMessage("查询失败");
//	  			resultDto.setCode(-1);
//	  			return  resultDto;
//	  		}
    	List<Map<String, Object>> list = acrmFpdInterestRateService.getListLoan(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
}
