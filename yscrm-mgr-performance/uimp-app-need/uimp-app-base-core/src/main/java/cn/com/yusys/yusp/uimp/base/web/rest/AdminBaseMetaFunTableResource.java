package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunTable;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseMetaFunTableService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunTableResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-25 10:54:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "业务模型配置")
@RequestMapping("/api/adminbasemetafuntable")
public class AdminBaseMetaFunTableResource extends CommonResource<AdminBaseMetaFunTable, String> {
    @Autowired
    private AdminBaseMetaFunTableService adminBaseMetaFunTableService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseMetaFunTableService;
    }
    
    /**
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist/{funCode}")
	public ResultDto<List<Map<String, Object>>> querylist(@PathVariable String funCode) {
		List<Map<String, Object>> list = this.adminBaseMetaFunTableService.querylist(funCode);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存业务模型配置信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增或保存业务模型配置信息", notes = "新增或保存业务模型配置信息")
	@PostMapping("/saveorupdate")
	public ResultDto<Object> saveorupdate(@RequestBody JSONArray array) throws Exception {
		List<AdminBaseMetaFunTable> list = JSONObject.parseArray(array.toJSONString(), AdminBaseMetaFunTable.class);
        return this.adminBaseMetaFunTableService.saveorupdate(list);
	}

}
