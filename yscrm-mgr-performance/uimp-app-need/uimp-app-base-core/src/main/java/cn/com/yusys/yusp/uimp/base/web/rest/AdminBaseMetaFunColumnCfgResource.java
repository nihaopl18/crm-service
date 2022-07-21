package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunColumnCfg;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseMetaFunColumnCfgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunColumnCfgResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-31 15:14:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "业务模型字段配置")
@RequestMapping("/api/adminbasemetafuncolumncfg")
public class AdminBaseMetaFunColumnCfgResource extends CommonResource<AdminBaseMetaFunColumnCfg, String> {
    @Autowired
    private AdminBaseMetaFunColumnCfgService adminBaseMetaFunColumnCfgService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseMetaFunColumnCfgService;
    }
    
    /**
	 * @方法名称: queryfuncolumncfg
	 * @方法描述: 查询模型字段配置信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询模型字段配置信息", notes = "查询模型字段配置信息")
	@GetMapping("/queryfuncolumncfg")
	public ResultDto<Map<String, Object>> queryfuncolumncfg(@RequestParam String tableCode) {
		Map<String, Object> resultMap = this.adminBaseMetaFunColumnCfgService.queryFunColumnCfg(tableCode);
		return new ResultDto<Map<String, Object>>(resultMap);
	}

}
