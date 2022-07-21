package cn.com.yusys.climp.acty.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.climp.acty.domain.LoyRlFieldEcName;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlFieldEcNameMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlFieldEcNameService
 * @类描述: 字段汉化服务类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:29
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyRlFieldEcNameService extends CommonService {
	@Autowired
	private LoyRlFieldEcNameMapper loyRlFieldEcNameMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return loyRlFieldEcNameMapper;
	}

	/**
	 * 根据表id查询表字段
	 * 
	 * @param model
	 * @return
	 */
	public List<LoyRlFieldEcName> getFieldByTableId(String tableId) {
		List<LoyRlFieldEcName> list = loyRlFieldEcNameMapper.getFieldByTableId(tableId);
		return list;
	}

	// 保存表字段名汉化
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int saveField(List<LoyRlFieldEcName> list) {
		int count = 0;
		if (list.size() > 0) {
			// 获取当前会话信息
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setUpdateDate(new Date());
				list.get(i).setUpdateUser(loginCode);
				loyRlFieldEcNameMapper.updateByPrimaryKeySelective(list.get(i));
			}
		}
		return count;
	}
}
