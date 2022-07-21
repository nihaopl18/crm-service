package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.uimp.base.service.UimpCommonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: UimpCommonResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: 
 * @创建时间: 2020-01-02 16:29:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "UIMP通用Resource")
@RequestMapping("/api/uimpCommonResource")
public class UimpCommonResource {
	
	@Autowired
	private UimpCommonService uimpCommonService;
	
	// 该接口作废
//	@ApiOperation(value = "下载文件", notes = "根据filePath下载文件")
//	@GetMapping("/download")
//	public void download(String filePath, HttpServletResponse response, HttpServletRequest request) {
//		uimpCommonService.download(filePath, response, request);
//	}
}
