package cn.com.yusys.yusp.uimp.business.pma.coefficient.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.coefficient.domain.PmaFCoefficientAmtRange;
import cn.com.yusys.yusp.uimp.business.pma.coefficient.service.PmaFCoefficientAmtRangeService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCoefficientAmtRangeResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-07 14:53:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafcoefficientamtrange")
public class PmaFCoefficientAmtRangeResource extends CommonResource<PmaFCoefficientAmtRange, String> {
    @Autowired
    private PmaFCoefficientAmtRangeService pmaFCoefficientAmtRangeService;

    @Override
    protected CommonService getCommonService() {
        return pmaFCoefficientAmtRangeService;
    }
    /**
     * @方法名称: selectList
     * @方法描述: 列表查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querylist")
    public ResultDto<List<Map<String, Object>>> queryList(QueryModel model) {
        List<Map<String, Object>> list = pmaFCoefficientAmtRangeService.queryList(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }
	/**
	 * @throws Exception 
	 * @方法名称: addInfo
	 * @方法描述: 新增方案信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增方案信息", notes = "新增方案信息")
	@PostMapping("/add")
	public ResultDto<PmaFCoefficientAmtRange> add(@RequestBody PmaFCoefficientAmtRange pmaFCoefficientAmtRange) throws Exception {
		return pmaFCoefficientAmtRangeService.add(pmaFCoefficientAmtRange);
	}
	/**
	 * @throws Exception 
	 * @方法名称: addInfo
	 * @方法描述: 新增方案信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增方案信息", notes = "新增方案信息")
	@PostMapping("/edit")
	public ResultDto<PmaFCoefficientAmtRange> edit(@RequestBody PmaFCoefficientAmtRange pmaFCoefficientAmtRange) throws Exception {
		return pmaFCoefficientAmtRangeService.edit(pmaFCoefficientAmtRange);
	}
}
