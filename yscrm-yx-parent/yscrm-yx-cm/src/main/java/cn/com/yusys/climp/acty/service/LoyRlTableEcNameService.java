package cn.com.yusys.climp.acty.service;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.domain.LoyRlFieldEcName;
import cn.com.yusys.climp.acty.domain.LoyRlTableEcName;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlFieldEcNameMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlTableEcNameMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableEcNameService
 * @类描述: 表汉化服务类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:46:37
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyRlTableEcNameService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyRlTableEcNameService.class);
	@Autowired
	private LoyRlTableEcNameMapper loyRlTableEcNameMapper;
	@Autowired
	private LoyRlFieldEcNameMapper loyRlFieldEcNameMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return loyRlTableEcNameMapper;
	}

	/**
	 * 根据表类型查询表
	 *
	 * @param model
	 * @return
	 */
	public List<LoyRlTableEcName> getTableByTypeId(String typeId) {
		List<LoyRlTableEcName> list = loyRlTableEcNameMapper.getTableByTypeId(typeId);
		return list;
	}

	// 保存表名汉化（先删除再新增）
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int saveTabAndField(List<LoyRlTableEcName> list) {
		int count = 0;
		if (list.size() > 0) {
			// 获取当前会话信息
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getTableId() != null) {
					list.get(i).setUpdateDate(new Date());
					list.get(i).setUpdateUser(loginCode);
					list.get(i).setUpdateOrg(list.get(i).getCreateOrg());
					loyRlTableEcNameMapper.updateByPrimaryKeySelective(list.get(i));
				} else {
					list.get(i).setCreateDate(new Date());
					list.get(i).setCreateUser(loginCode);
					list.get(i).setUpdateDate(new Date());
					list.get(i).setUpdateUser(loginCode);
					list.get(i).setUpdateOrg(list.get(i).getCreateOrg());
					loyRlTableEcNameMapper.insertSelective(list.get(i));
					List<LoyRlFieldEcName> fieldlist = loyRlFieldEcNameMapper
							.searchFieldByTabName(list.get(i).getTableEName(), list.get(i).getTableId());
					for (int j = 0; j < fieldlist.size(); j++) {
						fieldlist.get(j).setCreateDate(new Date());
						fieldlist.get(j).setCreateUser(loginCode);
						fieldlist.get(j).setCreateOrg(list.get(i).getCreateOrg());
						fieldlist.get(j).setUpdateDate(new Date());
						fieldlist.get(j).setUpdateUser(loginCode);
						fieldlist.get(j).setUpdateOrg(list.get(i).getCreateOrg());
						loyRlFieldEcNameMapper.insertSelective(fieldlist.get(j));
					}
				}
				count++;
			}
		}
		return count;
	}
	/**
	 * @方法名称:getRuleByTrans
	 * @方法描述:根据交易类型查询积分活动
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<LoyRlActivity> getRuleByTrans(String transCode) {
		List<LoyRlActivity> list = loyRlTableEcNameMapper.getRuleByTrans(transCode);
		return list;
	}
	/**
	 * 删除表汉化
	 *
	 * @param idStr
	 * @return
	 */
	public int deletetab(String tableId,String orgCode) {
		int n = 0;
		if (tableId != null && !"".equals(tableId.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			// 获取当前会话信息
			String loginCode = SecurityUtils.getCurrentUserLogin();
			if (!"".equals(tableId)) {
				Map<String, String> map = new HashMap<>();
				map.put("tableId", tableId);
				map.put("orgCode", orgCode);
				map.put("userCode", loginCode);
				n = n + loyRlTableEcNameMapper.updataTabState(map);
				loyRlFieldEcNameMapper.updateFieldState(map);
			}
			logger.info("表删除  【主键：" + tableId + "】 " + df.format(new Date()));
		}
		return n;
	}

	public LoyRlTableEcName selectByTransactionCode(String transactionCode) {
		return loyRlFieldEcNameMapper.selectByTransactionCode(transactionCode);
	}
}
