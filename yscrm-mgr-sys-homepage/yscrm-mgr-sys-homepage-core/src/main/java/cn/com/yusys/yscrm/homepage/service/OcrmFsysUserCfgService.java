package cn.com.yusys.yscrm.homepage.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.homepage.domain.OcrmFsysUserCfg;
import cn.com.yusys.yscrm.homepage.repository.mapper.OcrmFsysUserCfgMapper;
/**
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserCfgService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-17 16:58:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFsysUserCfgService extends CommonService {
    @Autowired
    private OcrmFsysUserCfgMapper ocrmFsysUserCfgMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFsysUserCfgMapper;
    }
    @Transactional(readOnly = true)
	public OcrmFsysUserCfg getThemeInfo(String loginCode) {
		// TODO 自动生成的方法存根
		return ocrmFsysUserCfgMapper.getThemeInfo(loginCode);
	}
	/*
	 * 删除当前主题再新增
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public OcrmFsysUserCfg updateTheme(OcrmFsysUserCfg ocrmFsysUserCfg) {
		// TODO 自动生成的方法存根
		String userId = SecurityUtils.getCurrentUserLogin();
		ocrmFsysUserCfgMapper.delByuserId(userId);
		ocrmFsysUserCfg.setUserId(userId);
		ocrmFsysUserCfg.setId(UUID.randomUUID().toString().replaceAll("-", ""));;
		int num = insertSelective(getMapper(), ocrmFsysUserCfg);
		if (num > 0) {
			return ocrmFsysUserCfg;
		}
		return null;
	}

}
