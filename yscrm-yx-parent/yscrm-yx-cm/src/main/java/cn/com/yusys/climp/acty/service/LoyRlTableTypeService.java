package cn.com.yusys.climp.acty.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.domain.LoyRlTableEcName;
import cn.com.yusys.climp.acty.domain.LoyRlTableType;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlFieldEcNameMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlTableEcNameMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlTableTypeMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableTypeService
 * @类描述: 表类别服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:57
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyRlTableTypeService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyRlTableTypeService.class);
    @Autowired
    private LoyRlTableTypeMapper loyRlTableTypeMapper;
    @Autowired
    private LoyRlTableEcNameMapper loyRlTableEcNameMapper;
    @Autowired
    private LoyRlFieldEcNameMapper loyRlFieldEcNameMapper;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return loyRlTableTypeMapper;
    }
    /**
	 * 
	* @方法名称: getTableType
	* @方法描述: 查询表类别
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<LoyRlTableType> getTableType(QueryModel model) {
		List<LoyRlTableType> list = loyRlTableTypeMapper.getTableType(model);
		return list;
	}
	/**
	 * 新增表类型
	 */
	public int insert(Object record) {
		LoyRlTableType pool = (LoyRlTableType) record;
        String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("表类型新增数据：【新增规则属性：" + pool.getTypeName() + "】 "
				+ df.format(new Date()));
		pool.setCreateDate(new Date());
		pool.setCreateUser(loginCode);
		pool.setUpdateDate(new Date());
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(pool.getCreateOrg());
		return this.insertSelective(pool);
	}

	/**
	 * 修改表类型
	 */
	public int update(Object t) {
		LoyRlTableType pool = (LoyRlTableType) t;
		 //获取当前会话信息  
        String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("表类型修改数据：【修改规则属性：" + pool.getTypeName() + "】的相关数据； "
				+ df.format(new Date()));
		pool.setUpdateDate(new Date());
		pool.setUpdateUser(loginCode);
		return this.updateSelective(pool);
	}
	/***根据表类型查询表是否 被实时事件所引用**/
	public List<LoyRlActivity> getRuleByType(String typeId) {
		List<LoyRlActivity> list = loyRlTableTypeMapper.getRuleByType(typeId);
		return list;
	}
	/**
	 * 表类型删除
	 * @param idStr
	 * @return
	 */
	public int deleteBatch(String[] idStr,String orgCode) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			//获取当前会话信息  
	        String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("typeId", idStr[i]);
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					n = n + loyRlTableTypeMapper.updataTabTypeState(typeMap);
					List<LoyRlTableEcName> tablist = loyRlTableEcNameMapper.queryTableId(idStr[i]);
					for(int j=0;j<tablist.size();j++) {
						Map<String, String> map = new HashMap<>();
						map.put("tableId", tablist.get(j).getTableId());
						map.put("orgCode", orgCode);
						map.put("userCode", loginCode);
						loyRlTableEcNameMapper.updataTabState(map);
						loyRlFieldEcNameMapper.updateFieldState(map);
					}
				}
			}
			logger.info("表类型删除  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}
}
