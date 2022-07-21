package cn.com.yusys.yusp.uimp.business.pma.app.web.rest;


import cn.com.yusys.yusp.commons.util.StringUtil;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.app.service.AdminSmUserMobileService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

/**
 * @项目名称: cmss-mobile-core模块
 * @类名称: ApiPubiosfullappstoreResource
 * @类描述: #app壳子对接接口资源类
 * @功能描述:
 * @创建人: weish1
 * @创建时间: 2020-11-24 12:31:44
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
//@Api(tags = "app壳子对接接口")
//@RestController
//@RequestMapping("/10000004/yump")
public class ApiPubandfullfileResource {

	@Autowired
	private AdminSmUserMobileService adminSmUserMobileService;
	private static final Logger logger = LoggerFactory.getLogger(ApiPubandfullfileResource.class);
	@ApiOperation(value = "安卓APP更新判断接口", notes = "APP管理")
	@PostMapping("/T30002")
	protected ResultDto<Object> appAndroidApprove(@RequestHeader(value="appVer") String appVer) {
		String versionBelong = "0";
		/** 版本归属 0-安卓，1-IOS **/
		logger.info("校验安卓 APP版本是否需要更新");
		ResultDto<Object> result = new ResultDto<Object>();
		try {
			if (!StringUtil.isEmpty(appVer)) {
				logger.info("安卓 APP版本为："+appVer);
				Map<String, Object> list = adminSmUserMobileService.checkAppVersion(appVer, versionBelong);
				result.setCode(0);
				result.setMessage("执行成功");
				result.setData(list);
			} else {
				result.setCode(-9);
				result.setMessage("APP版本号必填!");
			}
		} catch (Exception e) {

		}
		return result;
	}
	
	
	
	@ApiOperation(value = "IOSAPP更新判断接口", notes = "APP管理")
	@PostMapping("/T30003")
	protected ResultDto<Object> appIosApprove(@RequestHeader(value="appVer") String appVer) {
		String versionBelong = "1";
		/** 版本归属 0-安卓，1-IOS **/
		logger.info("校验IOS APP版本是否需要更新");
		ResultDto<Object> result = new ResultDto<Object>();
		try {
			if (!StringUtil.isEmpty(appVer)) {
				logger.info("IOS APP版本为："+appVer);
				Map<String, Object> list = adminSmUserMobileService.checkAppVersion(appVer, versionBelong);
				result.setCode(0);
				result.setMessage("执行成功");
				result.setData(list);
			} else {
				result.setCode(-9);
				result.setMessage("APP版本号必填!");
			}
		} catch (Exception e) {

		}
		return result;
	}
}
