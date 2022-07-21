package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain.PmaFEvlIndexExcelInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.service.PmaFEvlIndexExcelInfoService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFEvlIndexExcelInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-04-21 15:02:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafevlindexexcelinfo")
public class PmaFEvlIndexExcelInfoResource extends CommonResource<PmaFEvlIndexExcelInfo, String> {
    @Autowired
    private PmaFEvlIndexExcelInfoService pmaFEvlIndexExcelInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFEvlIndexExcelInfoService;
    }
    /**
     * @方法名称: querylist
     * @方法描述: 查询订单列表数据(分页)
     * @参数与返回说明: 
     * @算法描述: 
     */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) {
		List<Map<String, Object>> list = this.pmaFEvlIndexExcelInfoService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
    /**
     * @方法名称: addorupdate
     * @方法描述: 新增
     * @参数与返回说明: @RequestBody OrderInfo orderInfo
     * @算法描述: 
     */
    @PostMapping("/addorupdate")
	@ApiOperation(value = "新增", notes = "新增")
	public ResultDto<PmaFEvlIndexExcelInfo> addorupdate(@RequestBody PmaFEvlIndexExcelInfo productInfo) throws Exception {
    	return pmaFEvlIndexExcelInfoService.addorupdate(productInfo);
    }
    /**
     * @方法名称: del
     * @方法描述: 删除
     * @参数与返回说明: @RequestBody String ids  
     * @算法描述: 
     */
	@ApiOperation(value = "删除", notes = "删除")
    @PostMapping("/del")
	public ResultDto<Integer> del(@RequestBody String ids) {
    	return pmaFEvlIndexExcelInfoService.del(ids);
    }
}
