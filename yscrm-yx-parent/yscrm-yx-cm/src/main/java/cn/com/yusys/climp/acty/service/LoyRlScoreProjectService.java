package cn.com.yusys.climp.acty.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.acty.domain.LoyRlScoreProject;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlActivityMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlScoreProjectMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlScoreProjectService
 * @类描述: 积分活动分类服务类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:41
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyRlScoreProjectService extends CommonService {
	
	/**日志*/
	private Logger logger = LoggerFactory.getLogger(LoyRlScoreProjectService.class);
	@Autowired
	private LoyRlScoreProjectMapper loyRlScoreProjectMapper;
	
	@Autowired
	private LoyRlActivityMapper LoyRlActivityMapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return loyRlScoreProjectMapper;
	}

	/**
	 * 
	 * @方法名称: getScoreProject
	 * @方法描述: 查询积分活动分类
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<LoyRlScoreProject> getScoreProject(QueryModel model) {
		List<LoyRlScoreProject> list = loyRlScoreProjectMapper.getScoreProject(model);
		logger.info("查询积分活动分类");
		return list;
	}

	/**
	 * 新增积分活动分类
	 */
	public int insert(Object record) {
		LoyRlScoreProject pool = (LoyRlScoreProject) record;
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		pool.setCreateDate(new Date());
		pool.setCreateUser(loginCode);
		logger.info("新增积分活动分类");
		return this.insertSelective(pool);
	}

	/**
	 * 修改积分活动分类
	 */
	public int update(Object t) {
		LoyRlScoreProject pool = (LoyRlScoreProject) t;
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		pool.setUpdateDate(new Date());
		pool.setUpdateUser(loginCode);
		logger.info("修改积分活动分类");
		return this.updateSelective(pool);
	}

	/**
	 * 积分活动分类删除
	 * 
	 * @param idStr
	 * @return
	 */
	public int deleteBatch(String[] idStr, String orgCode) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			// 获取当前会话信息
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("projectId", idStr[i]);
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					n = n + loyRlScoreProjectMapper.updataScoreProjectState(typeMap);
					LoyRlActivityMapper.updataActyState(typeMap);
				}
			}
			logger.info("积分活动分类删除");
		}
		return n;
	}
}
