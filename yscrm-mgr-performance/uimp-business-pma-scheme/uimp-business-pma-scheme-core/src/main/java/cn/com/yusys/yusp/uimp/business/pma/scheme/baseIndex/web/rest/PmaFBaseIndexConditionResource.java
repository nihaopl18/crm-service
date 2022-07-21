package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexCondition;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFIndexCdtInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service.PmaFBaseIndexConditionService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexConditionResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-07 11:29:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafbaseindexcondition")
public class PmaFBaseIndexConditionResource extends CommonResource<PmaFIndexCdtInfo, String> {
    @Autowired
    private PmaFBaseIndexConditionService pmaFBaseIndexConditionService;

    @Override
    protected CommonService getCommonService() {
        return pmaFBaseIndexConditionService;
    }
    /**
	 * @方法名称: querylist
	 * @方法描述: 查询条件列表数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist(@RequestParam String indexId) {
		List<Map<String, Object>> list = this.pmaFBaseIndexConditionService.querylist(indexId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    @ApiOperation(value = "新增筛选条件", notes = "新增筛选条件")
    @PostMapping("/add")
	public ResultDto<PmaFIndexCdtInfo> add(@RequestBody PmaFIndexCdtInfo pmaFIndexCdtInfo) throws Exception {
    	return pmaFBaseIndexConditionService.add(pmaFIndexCdtInfo);
    }
    @ApiOperation(value = "删除筛选条件", notes = "删除筛选条件")
    @PostMapping("/delCondition")
	public ResultDto<Integer> delCondition(@RequestBody String id){
    	return this.pmaFBaseIndexConditionService.delCondition(id);		
    }
   
}
