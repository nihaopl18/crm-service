package cn.com.yusys.yscrm.homepage.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yscrm.homepage.domain.OcrmFsysUserCfg;

/**
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserCfgMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-17 16:58:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysUserCfgMapper extends CommonMapper<OcrmFsysUserCfg> {

	OcrmFsysUserCfg getThemeInfo(String loginCode);

	int delByuserId(String currentUserLogin);
	
}