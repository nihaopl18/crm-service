package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunColumn;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseMetaFunColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunColumnResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-27 15:10:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "业务模型属性")
@RequestMapping("/api/adminbasemetafuncolumn")
public class AdminBaseMetaFunColumnResource extends CommonResource<AdminBaseMetaFunColumn, String> {
    @Autowired
    private AdminBaseMetaFunColumnService adminBaseMetaFunColumnService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseMetaFunColumnService;
    }
    
    /**
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据", notes = "查询列表数据")
	@GetMapping("/querylist/{tableCode}")
	public ResultDto<List<Map<String, Object>>> querylist(@PathVariable String tableCode) {
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnService.querylist(tableCode);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

}
