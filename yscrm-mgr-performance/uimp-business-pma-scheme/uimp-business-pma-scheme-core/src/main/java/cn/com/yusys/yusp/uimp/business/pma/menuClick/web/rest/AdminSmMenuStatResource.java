package cn.com.yusys.yusp.uimp.business.pma.menuClick.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.menuClick.domain.AdminSmMenuStat;
import cn.com.yusys.yusp.uimp.business.pma.menuClick.service.AdminSmMenuStatService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminSmMenuStatResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-04-03 13:57:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/adminsmmenustat")
public class AdminSmMenuStatResource extends CommonResource<AdminSmMenuStat, String> {
    @Autowired
    private AdminSmMenuStatService adminSmMenuStatService;

    @Override
    protected CommonService getCommonService() {
        return adminSmMenuStatService;
    }

    @ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) {
		List<Map<String, Object>> list = this.adminSmMenuStatService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}
