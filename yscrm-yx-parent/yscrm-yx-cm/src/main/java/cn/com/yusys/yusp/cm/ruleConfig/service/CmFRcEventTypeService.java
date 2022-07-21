package cn.com.yusys.yusp.cm.ruleConfig.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventType;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcEventTypeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
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
 * @类名称: CmFRcEventTypeService
 * @类描述: 事件类型服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-23 14:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcEventTypeService extends CommonService{

	private Logger logger = LoggerFactory.getLogger(CmFRcEventTypeService.class);
	@Autowired
	private CmFRcEventTypeMapper mapper;
	
	@Autowired
	private UserInfoService userInfo; 
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	/**
	 * 
	* @方法名称: getEventType
	* @方法描述: 查询事件类型
	* @参数与返回说明: 返回事件类型列表
	* @算法描述:
	 */
	public List<CmFRcEventType> getEventType(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcEventType> list = mapper.getEventType(model);
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * 新增事件类型
	 */
	public int insert(Object record) {
		CmFRcEventType pool = (CmFRcEventType) record;
		 //获取当前会话信息  
        String orgCode =userInfo.getOrgCode();
        String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("事件类型新增数据：【新增规则属性：" + pool.getEventTypeName() + "】 "
				+ df.format(new Date()));
		pool.setCreateDate(df.format(new Date()));
		pool.setCreateUser(loginCode);
		pool.setCreateOrg(orgCode);
		return this.insertSelective(pool);
	}

	/**
	 * 修改事件类型
	 */
	public int update(Object t) {
		CmFRcEventType pool = (CmFRcEventType) t;
		 //获取当前会话信息  
		String orgCode =userInfo.getOrgCode();
        String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("事件类型修改数据：【修改规则属性：" + pool.getEventTypeName() + "】的相关数据； "
				+ df.format(new Date()));
		pool.setUpdateDate(df.format(new Date()));
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		return this.updateSelective(pool);
	}
	/**
	 * 事件类型删除
	 * @param idStr
	 * @return
	 */
	public int deleteBatch(String[] idStr) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			//获取当前会话信息  
			String orgCode =userInfo.getOrgCode();
	        String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("eventTypeId", idStr[i]);
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					typeMap.put("upDate", df.format(new Date()));
					n = n + mapper.updataEventTypeState(typeMap);
				}
			}
			logger.info("事件类型删除  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}
	
}
