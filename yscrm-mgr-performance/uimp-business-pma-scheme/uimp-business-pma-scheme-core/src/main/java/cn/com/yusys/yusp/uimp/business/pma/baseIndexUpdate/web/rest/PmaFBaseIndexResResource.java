package cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.domain.PmaFBaseIndexRes;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.service.PmaFBaseIndexResService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexResResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-06 10:46:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "基础指标调整")
@RequestMapping("/api/pmafbaseindexres")
public class PmaFBaseIndexResResource extends CommonResource<PmaFBaseIndexRes, String> {
    @Autowired
    private PmaFBaseIndexResService pmaFBaseIndexResService;

    @Override
    protected CommonService getCommonService() {
        return pmaFBaseIndexResService;
    }
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) {
		List<Map<String, Object>> list = this.pmaFBaseIndexResService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    @PostMapping("/edit")
	@ApiOperation(value = "修改指标值", notes = "修改指标值")
	public ResultDto<PmaFBaseIndexRes> modify(@RequestBody PmaFBaseIndexRes pmafbaseindexres) throws Exception {
    	return pmaFBaseIndexResService.modify(pmafbaseindexres);
    }
}
