package cn.com.yusys.yusp.cm.ruleConfig.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcEventInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.sequence.domain.SequenceConfig;
import cn.com.yusys.yusp.sequence.exception.SequenceConfigException;
import cn.com.yusys.yusp.sequence.service.SequenceConfigService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcEventInfoService
 * @类描述: 事件信息服务类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-23 14:28
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcEventInfoService extends CommonService {

	private Logger logger = LoggerFactory.getLogger(CmFRcEventInfoService.class);
	
    @Autowired
	SequenceConfigService sequenceConfigService;

	@Autowired
	private CmFRcEventInfoMapper mapper;

	@Autowired
	private UserInfoService userInfo; 

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}

	/**
	 * 
	 * @方法名称: getEventInfo
	 * @方法描述: 查询事件信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<CmFRcEventInfo> getEventInfo(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcEventInfo> list = mapper.getEventInfo(model);
		PageHelper.clearPage();
		return list;
	}

	public List<CmFRcEventInfo> getEventByTrans(String transCode) {
		List<CmFRcEventInfo> list = mapper.getEventByTrans(transCode);
		return list;
	}
	/***
	 * 序列号
	 * @return
	 */
	public String generateNumber() {
		SequenceConfig seqenceConfig = sequenceConfigService.selectBySeqId("EVENT_SEQUENCE");
		String eventId = "";
		try {
			eventId =  sequenceConfigService.getNextSeq("EVENT_SEQUENCE", seqenceConfig);
		} catch (SequenceConfigException e) {
			logger.error(e.getMessage(), e);
		}
		return eventId;
	}
	
	/**
	 * 新增事件信息
	 */
	public int insert(Object record) {
		CmFRcEventInfo pool = (CmFRcEventInfo) record;
		// 获取当前会话信息
		String orgCode = userInfo.getOrgCode();
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("事件信息新增数据：【新增规则属性：" + pool.getEventName() + "】 " + df.format(new Date()));
		pool.setCreateDate(df.format(new Date()));
		pool.setCreateUser(loginCode);
		pool.setCreateOrg(orgCode);
		pool.setWfApprSts("000");// 审批状态默认为未提交
		pool.setUseFlag("0");// 启停用状态 默认为未启用
		pool.setId(Long.parseLong(generateNumber()));// 序列Id
		return this.insertSelective(pool);
	}

	/**
	 * 修改事件信息
	 */
	public int update(Object t) {
		CmFRcEventInfo pool = (CmFRcEventInfo) t;
		// 获取当前会话信息
		String orgCode = userInfo.getOrgCode();
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("事件信息修改数据：【修改规则属性：" + pool.getEventName() + "】的相关数据； " + df.format(new Date()));
		pool.setUpdateDate(df.format(new Date()));
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		return this.updateSelective(pool);
	}

	/**
	 * 事件信息删除
	 * 
	 * @param idStr
	 * @return
	 */
	public int deleteBatch(String[] idStr) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			// 获取当前会话信息
			String orgCode = userInfo.getOrgCode();
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("eventId", idStr[i]);
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					typeMap.put("upDate", df.format(new Date()));
					n = n + mapper.updataEventInfoState(typeMap);
				}
			}
			logger.info("事件信息删除  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}

	/**
	 * 
	 * @方法名称: useIngFn
	 * @方法描述: 批量启用事件
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int useIngFn(String[] idStr) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			// 获取当前会话信息
			String orgCode = userInfo.getOrgCode();
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("eventId", idStr[i]);
					typeMap.put("useflag", "1");
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					typeMap.put("upDate", df.format(new Date()));
					n = n + this.mapper.updateSts(typeMap);
				}
			}
			logger.info("事件批量启用  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}

	/**
	 * 
	 * @方法名称: unUseIngFn
	 * @方法描述: 批量停用事件
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int unUseIngFn(String[] idStr) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			// 获取当前会话信息
			String orgCode = userInfo.getOrgCode();
			String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("eventId", idStr[i]);
					typeMap.put("useflag", "0");
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					typeMap.put("upDate", df.format(new Date()));
					n = n + this.mapper.updateSts(typeMap);
				}
			}
			logger.info("事件批量停用  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}
}
