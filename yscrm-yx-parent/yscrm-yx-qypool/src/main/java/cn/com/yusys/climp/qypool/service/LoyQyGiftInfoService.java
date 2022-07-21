package cn.com.yusys.climp.qypool.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.climp.qypool.domain.LoyQyGiftInfo;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyGiftInfoMapper;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyGiftInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: chenlin
 * @创建时间: 2019-02-21 17:29:27
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyQyGiftInfoService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyQyGiftInfoService.class);
	@Autowired
	private LoyQyGiftInfoMapper loyQyGiftInfoMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return loyQyGiftInfoMapper;
	}

	/***
	 * @方法名称:getGift
	 * @方法描述:礼品列表查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<LoyQyGiftInfo> getGift(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<LoyQyGiftInfo> list = loyQyGiftInfoMapper.getGift(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 礼品新增
	 */
	@Override
	public int insert(Object record) {
		LoyQyGiftInfo gift = (LoyQyGiftInfo) record;
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		gift.setGiftStatus("1");// 1草稿
		gift.setSource("1");// 本行手动维护
		gift.setCreateUser(loginCode);
		gift.setCreateDate(df.format(new Date()));
		gift.setUpdateDate(df.format(new Date()));
		gift.setUpdateUser(loginCode);
		gift.setUpdateOrg(gift.getCreateOrg());
		logger.info("礼品管理新增数据：【新增礼品名称：" + gift.getGiftName() + "】 " + df.format(new Date()));
		return super.insert(gift);
	}

	/**
	 * 礼品修改
	 */
	@Override
	public int update(Object record) {
		LoyQyGiftInfo gift = (LoyQyGiftInfo) record;
		// 获取当前会话信息
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("礼品管理修改数据：【修改礼品名称：" + gift.getGiftName() + "】的相关数据； " + df.format(new Date()));
		gift.setUpdateDate(df.format(new Date()));
		gift.setUpdateUser(loginCode);
		return super.update(gift);
	}

	/**
	 * @方法名称:batchDelete
	 * @方法描述:批量刪除
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int batchDelete(String[] idStr, String orgCode) {
		int count = 0;
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		for (int i = 0; i < idStr.length; i++) {
			if (!"".equals(idStr[i])) {
				LoyQyGiftInfo gift = this.loyQyGiftInfoMapper.selectByPrimaryKey(idStr[i]);
				gift.setUpdateDate(df.format(new Date()));
				gift.setUpdateUser(loginCode);
				gift.setUpdateOrg(orgCode);
				count = count + this.deleteByPrimaryKey(idStr[i]);
			}
		}
		logger.info("礼品批量删除  【主键：" + idStr + "】 " + df.format(new Date()));
		return count;
	}
}
