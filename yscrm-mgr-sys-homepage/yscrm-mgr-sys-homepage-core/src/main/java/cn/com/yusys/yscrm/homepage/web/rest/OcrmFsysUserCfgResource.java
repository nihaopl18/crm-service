package cn.com.yusys.yscrm.homepage.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.homepage.domain.OcrmFsysUserCfg;
import cn.com.yusys.yscrm.homepage.service.OcrmFsysUserCfgService;

/**
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserCfgResource
 * @类描述: 首页主题
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-17 16:58:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysusercfg")
public class OcrmFsysUserCfgResource extends CommonResource<OcrmFsysUserCfg, String> {
    @Autowired
    private OcrmFsysUserCfgService ocrmFsysUserCfgService;

    @Override
    protected CommonService getCommonService() {
        return this.ocrmFsysUserCfgService;
    }
    
    /**
	* @方法名称: getThemeInfo
	* @方法描述: 获取系统主题信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/getthemeinfo")
    public ResultDto<OcrmFsysUserCfg> getThemeInfo(QueryModel model) {
    	String loginCode = SecurityUtils.getCurrentUserLogin();
    	OcrmFsysUserCfg ocrmFsysUserCfg = ocrmFsysUserCfgService.getThemeInfo(loginCode);
    	return new ResultDto<>(ocrmFsysUserCfg);
	}
    
    /**
   	* @方法名称: updateTheme
   	* @方法描述: 获取系统主题信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/updatetheme")
    public ResultDto<OcrmFsysUserCfg> updateTheme(@RequestBody OcrmFsysUserCfg ocrmFsysUserCfg) {
    	return new ResultDto<>(ocrmFsysUserCfgService.updateTheme(ocrmFsysUserCfg));
	} 

}
