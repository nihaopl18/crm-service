package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPostParamListInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPostParamPerInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service.PmaFPostParamPerInfoService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPostParamPerInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-13 09:50:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafpostparamperinfo")
public class PmaFPostParamPerInfoResource extends CommonResource<PmaFPostParamPerInfo, String> {
    @Autowired
    private PmaFPostParamPerInfoService pmaFPostParamPerInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFPostParamPerInfoService;
    }
    /**
  	 * @方法名称: querylist
  	 * @方法描述: 查询人员岗位参数明细info信息
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "查询人员岗位参数明细info信息", notes = "查询人员岗位参数明细info信息")
  	@GetMapping("/querylist")
  	public ResultDto<List<Map<String, Object>>> querylist(@RequestParam String paramId,String effectPost) {
  		List<Map<String, Object>> list = this.pmaFPostParamPerInfoService.querylist(paramId,effectPost);
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
  	@ApiOperation(value = "新增人员岗位参数明细信息", notes = "新增人员岗位参数明细信息")
    @PostMapping("/add")
	public ResultDto<PmaFPostParamPerInfo> add(@RequestBody List<PmaFPostParamPerInfo> list) throws Exception {
    	return pmaFPostParamPerInfoService.add(list);
    }
}
