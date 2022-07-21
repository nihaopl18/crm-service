package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunPageCfg;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseMetaFunPageCfgService;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunPageCfgResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-23 15:43:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "业务功能配置")
@RequestMapping("/api/adminbasemetafunpagecfg")
public class AdminBaseMetaFunPageCfgResource extends CommonResource<AdminBaseMetaFunPageCfg, String> {
	
	private Logger logger = LoggerFactory.getLogger(AdminBaseMetaFunPageCfgResource.class);
	
    @Autowired
    private AdminBaseMetaFunPageCfgService adminBaseMetaFunPageCfgService;
    
    @Autowired
	private MetaFunctionManagerService metaFunctionManagerService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseMetaFunPageCfgService;
    }
    
    /**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存业务功能配置信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增或保存业务功能配置信息", notes = "新增或保存业务功能配置信息")
	@PostMapping("/saveorupdate")
	public ResultDto<Object> saveorupdate(@RequestBody JSONArray array) throws Exception {
		List<AdminBaseMetaFunPageCfg> list = JSONObject.parseArray(array.toJSONString(), AdminBaseMetaFunPageCfg.class);
		ResultDto<Object> result = this.adminBaseMetaFunPageCfgService.saveorupdate(list);
		if(list!=null && list.size()>0) {
			logger.info("开始刷新业务功能配置信息缓存...");
			String funCode = list.get(0).getFunCode();
//			adminBaseMetaFunPageCfgService.refreshFunPageCfg(funCode);
			metaFunctionManagerService.refreshMetaFunInfo(funCode);
			logger.info("刷新业务功能配置信息信息缓存结束...");
		}
        
        return result;
	}
	
	/**
	 * @方法名称: queryPageCfg
	 * @方法描述: 查询业务注册信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询业务注册信息", notes = "查询业务注册信息")
	@GetMapping("/queryPageCfg")
	public ResultDto<Map<String, Object>> queryPageCfg(@RequestParam String funCode) {
		Map<String, Object> result = this.adminBaseMetaFunPageCfgService.queryPageCfg(funCode);
		return new ResultDto<Map<String, Object>>(result);
	}

}
