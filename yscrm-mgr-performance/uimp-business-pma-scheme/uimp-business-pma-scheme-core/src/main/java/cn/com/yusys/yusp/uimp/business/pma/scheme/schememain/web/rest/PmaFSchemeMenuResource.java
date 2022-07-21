package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeMenu;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeMenuResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: xujiawei
 * @创建时间: 2020-02-19 09:56:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Api(tags = "考核方案目录接口")
@RestController
@RequestMapping("/api/pmafschememenu")
public class PmaFSchemeMenuResource extends CommonResource<PmaFSchemeMenu, String> {
    @Autowired
    private PmaFSchemeMenuService pmaFSchemeMenuService;

    @Override
    protected CommonService getCommonService() {
        return pmaFSchemeMenuService;
    }
	/**
	 * @throws Exception 
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) throws Exception {
		List<Map<String, Object>> list = pmaFSchemeMenuService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: add
	 * @方法描述: 新增目录
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增目录", notes = "新增目录")
	@PostMapping("/add")
	public ResultDto<PmaFSchemeMenu> add(@RequestBody PmaFSchemeMenu pmaFSchemeMenu) throws Exception {
		return pmaFSchemeMenuService.add(pmaFSchemeMenu);
	}
	/**
	 * @throws Exception 
	 * @方法名称: edit
	 * @方法描述: 修改目录
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @PostMapping("/edit")
	@ApiOperation(value = "修改目录", notes = "修改目录")
	public ResultDto<PmaFSchemeMenu> modify(@RequestBody PmaFSchemeMenu pmaFSchemeMenu) throws Exception {
    	return pmaFSchemeMenuService.modify(pmaFSchemeMenu);
    }
	/**
	 * @throws Exception 
	 * @方法名称: delete
	 * @方法描述: 删除目录
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @ApiOperation(value = "删除目录", notes = "删除目录")
    @PostMapping("/delete")
	public ResultDto<Integer> del(@RequestBody String ids) {
    	return pmaFSchemeMenuService.delete(ids);
    }
}
