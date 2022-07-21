package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamListInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.service.PmaFParamListInfoService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamListInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 17:02:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafparamlistinfo")
public class PmaFParamListInfoResource extends CommonResource<PmaFParamListInfo, String> {
    @Autowired
    private PmaFParamListInfoService pmaFParamListInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFParamListInfoService;
    }
    /**
  	 * @方法名称: querylist
  	 * @方法描述: 查询机构参数info信息
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "查询机构参数明细信息", notes = "查询机构参数明细信息")
  	@GetMapping("/querylist")
  	public ResultDto<List<Map<String, Object>>> querylist(@RequestParam String paramId) {
  		List<Map<String, Object>> list = this.pmaFParamListInfoService.querylist(paramId);
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
  	@ApiOperation(value = "新增机构参数明细信息", notes = "新增机构参数明细信息")
    @PostMapping("/add")
	public ResultDto<PmaFParamListInfo> add(@RequestBody List<PmaFParamListInfo> list) throws Exception {
    	return pmaFParamListInfoService.add(list);
    }
}
