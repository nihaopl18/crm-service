package cn.com.yusys.yusp.cm.ruleConfig.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcFieldEcName;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableEcName;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableType;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcFieldEcNameMapper;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRulePropertyMapper;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcTableEcNameMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
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
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRulePropertyService
 * @类描述: 规则属性配置服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-15 14:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcRulePropertyService extends CommonService{

	private Logger logger = LoggerFactory.getLogger(CmFRcRulePropertyService.class);
	@Autowired
	private CmFRcRulePropertyMapper mapper;
	
	@Autowired
	private CmFRcTableEcNameMapper tabMapper;
	
	@Autowired
	private CmFRcFieldEcNameMapper fieldMapper;
	
	@Autowired
	private UserInfoService userInfo; 
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	/**
	 * 
	* @方法名称: getTableType
	* @方法描述: 查询表类别
	* @参数与返回说明: 
	* @算法描述:
	 */
	public List<CmFRcTableType> getTableType(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcTableType> list = mapper.getTableType(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 根据表类型查询表
	 * @param model
	 * @return
	 */
	public List<CmFRcTableEcName> getTableByTypeId(QueryModel model) {
		List<CmFRcTableEcName> list = mapper.getTableByTypeId(model);
		return list;
	}
	/**
	 * 查询所有表
	 * @return
	 */
	public List<CmFRcTableEcName> getAllTab() {
		List<CmFRcTableEcName> list = mapper.getAllTab();
		return list;
	}
	/**
	 * 根据表id查询表字段
	 * @param model
	 * @return
	 */
	public List<CmFRcFieldEcName> getFieldByTableId(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcFieldEcName> list = mapper.getFieldByTableId(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 查询数据库表和视图
	 * @param model
	 * @return
	 */
	public List<Map<String, Object>> searchtable(QueryModel model) {
		return mapper.searchtable(model);
	}
	// 保存表名汉化（先删除再新增）
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int saveTabAndField(List<CmFRcTableEcName> list){
		int count = 0;
		if(list.size()>0){
			 //获取当前会话信息  
	        String orgCode = userInfo.getOrgCode();
	        String loginCode = SecurityUtils.getCurrentUserLogin();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTableId()!=null) {
					list.get(i).setUpdateDate(df.format(new Date()));
					list.get(i).setUpdateUser(loginCode);
					list.get(i).setUpdateOrg(orgCode);
					tabMapper.updateByPrimaryKeySelective(list.get(i));
				}else {
					list.get(i).setCreateDate(df.format(new Date()));
					list.get(i).setCreateUser(loginCode);
					list.get(i).setCreateOrg(orgCode);
					tabMapper.insertSelective(list.get(i));
					List<CmFRcFieldEcName> fieldlist = mapper.searchFieldByTabName(list.get(i).getTableEName(),list.get(i).getTableId());
					for(int j =0;j<fieldlist.size();j++) {
						fieldlist.get(j).setCreateDate(df.format(new Date()));
						fieldlist.get(j).setCreateUser(loginCode);
						fieldlist.get(j).setCreateOrg(orgCode);
						fieldMapper.insertSelective(fieldlist.get(j));
					}
				}
			}
		}
		return count;
	}
	// 保存表字段名汉化
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int saveField(List<CmFRcFieldEcName> list){
		int count = 0;
		if(list.size()>0){
			 //获取当前会话信息  
			 String orgCode = userInfo.getOrgCode();
	        String loginCode = SecurityUtils.getCurrentUserLogin();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			for(int i=0;i<list.size();i++){
//				if(list.get(i).getTableId()!=null) {
//					fieldMapper.deleteByPrimaryKey(list.get(i).getFieldId());
//				}
//				fieldMapper.insertSelective(list.get(i));
				list.get(i).setUpdateDate(df.format(new Date()));
				list.get(i).setUpdateUser(loginCode);
				list.get(i).setUpdateOrg(orgCode);
				fieldMapper.updateByPrimaryKeySelective(list.get(i));
			}
		}
		return count;
	}
	/**
	 * 新增表类型
	 */
	public int insert(Object record) {
		CmFRcTableType pool = (CmFRcTableType) record;
		 //获取当前会话信息  
		 String orgCode = userInfo.getOrgCode();
        String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("表类型新增数据：【新增规则属性：" + pool.getTypeName() + "】 "
				+ df.format(new Date()));
		pool.setCreateDate(df.format(new Date()));
		pool.setCreateUser(loginCode);
		pool.setCreateOrg(orgCode);
		return this.insertSelective(pool);
	}

	/**
	 * 修改表类型
	 */
	public int update(Object t) {
		CmFRcTableType pool = (CmFRcTableType) t;
		 //获取当前会话信息  
		 String orgCode = userInfo.getOrgCode();
        String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		logger.info("表类型修改数据：【修改规则属性：" + pool.getTypeName() + "】的相关数据； "
				+ df.format(new Date()));
		pool.setUpdateDate(df.format(new Date()));
		pool.setUpdateUser(loginCode);
		pool.setUpdateOrg(orgCode);
		return this.updateSelective(pool);
	}
	/**
	 * 表类型删除
	 * @param idStr
	 * @return
	 */
	public int deleteBatch(String[] idStr) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			//获取当前会话信息  
			 String orgCode = userInfo.getOrgCode();
	        String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> typeMap = new HashMap<>();
					typeMap.put("typeId", idStr[i]);
					typeMap.put("orgCode", orgCode);
					typeMap.put("userCode", loginCode);
					typeMap.put("upDate", df.format(new Date()));
					n = n + mapper.updataTabTypeState(typeMap);
					List<CmFRcTableEcName> tablist = mapper.queryTableId(idStr[i]);
					for(int j=0;j<tablist.size();j++) {
						Map<String, String> map = new HashMap<>();
						map.put("tableId", tablist.get(j).getTableId());
						map.put("orgCode", orgCode);
						map.put("userCode", loginCode);
						map.put("upDate", df.format(new Date()));
						mapper.updataTabState(map);
						mapper.updateFieldState(map);
					}
				}
			}
			logger.info("表类型删除  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}
	/**
	 * 删除表汉化
	 * @param idStr
	 * @return
	 */
	public int deletetab(String[] idStr) {
		int n = 0;
		if (idStr != null && !"".equals(idStr.toString())) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			//获取当前会话信息  
			 String orgCode = userInfo.getOrgCode();
	        String loginCode = SecurityUtils.getCurrentUserLogin();
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					Map<String, String> map = new HashMap<>();
					map.put("tableId", idStr[i]);
					map.put("orgCode", orgCode);
					map.put("userCode", loginCode);
					map.put("upDate", df.format(new Date()));
					n = n + mapper.updataTabState(map);
					mapper.updateFieldState(map);
				}
			}
			logger.info("表删除  【主键：" + idStr + "】 " + df.format(new Date()));
		}
		return n;
	}
	
	/**
	 * 查询交易码
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> searchTransCode(String transType) {
		return mapper.searchTransCode(transType);
	}
	/***根据表类型查询表是否 被实时事件所引用**/
	public List<CmFRcEventInfo> getEventByType(String typeId) {
		List<CmFRcEventInfo> list = mapper.getEventByType(typeId);
		return list;
	}
}
