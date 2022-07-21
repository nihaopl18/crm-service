package cn.com.yusys.yusp.cm.taskcenter.service;

import cn.com.yusys.yusp.admin.service.SystemUtilService;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTP;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTaskPool;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTaskPoolDto;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CimFTcTaskPoolMapper;
//import cn.com.yusys.yusp.commons.file.FileManagementClientFactory;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm-taskpool
 * @类名称: CimFTcTaskPoolService
 * @类描述: 
 * @功能描述: 模型版本信息
 * @创建人: yangye@yusys.com.cn
 * @创建时间: 2018年11月8日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CimFTcTaskPoolService  extends CommonService{
	@Autowired
	private CimFTcTaskPoolMapper mapper;
//	@Autowired
//	FileManagementClientFactory fileManagementCilentFactory;
	@Autowired
	private SystemUtilService service;
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	/**
	 * 查询任务池
	 */
//	@Transactional(readOnly = true)
//	public List<CimFTcTaskPool> getTaskPoolList(QueryModel model) {
//		Map<String, Object> condition = model.getCondition();
//		if (condition.size() == 0) {
//			condition.put("taskName", null);
//			condition.put("taskType", null);
//		}
//		String admin = (String)condition.get("admin");
//		String orgId = mapper.getOrgId(admin);
//		model.addCondition("orgId",orgId);
//		PageHelper.startPage(model.getPage(), model.getSize());
//		List<CimFTcTaskPool> list = mapper.getTaskPoolList(model);
//		PageHelper.clearPage();
//		return list;
//	}
	@Transactional(readOnly = true)
	public List<CimFTcTaskPoolDto> getTaskPoolList(QueryModel model) {
		Map<String, Object> condition = model.getCondition();
		if (condition.size() == 0) {
			condition.put("taskName", null);
			condition.put("taskType", null);
		}
		String admin = (String)condition.get("admin");
		//获取当当前用户的orgId
		String orgId = mapper.getOrgId(admin);
		//查询出当前用户所在机构的所有子机构
		List<Map<String, Object>> orgList = service.getOrgByParam(orgId,"",false);
		List<String> orgCodeList=new ArrayList<>();
		for (Map<String, Object> stringObjectMap : orgList) {
			orgCodeList.add((String)stringObjectMap.get("orgCode"));
		}
		//model.addCondition("orgCodeList",orgCodeList);
		PageHelper.startPage(model.getPage(), model.getSize());
//		List<CimFTcTaskPool> list = mapper.getTaskPoolList(model);
		List<CimFTcTaskPoolDto> list = mapper.queryTaskPoolList(model,orgCodeList);
		PageHelper.clearPage();
		return list;
	}
	 /*
	  * 更新任务状态
	  * */
	public int updateTaskState(CimFTcTaskPool tp) {
		// 设置最新更新人
		tp.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   tp.setLastUpdateDt(time);
		return mapper.updateTaskState(tp);
	}
	
	 /*
	  * 更新分配后任务状态
	  * */
	public int allotTask(CimFTcTaskPool tp) {
		// 设置最新更新人
		tp.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   tp.setLastUpdateDt(time);
		return mapper.allotTask(tp);
	}
	
	/**
	 * 审批时列出任务信息
	 */
	@Transactional(readOnly = true)
	public List<CimFTcTaskPool> getApplyList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CimFTcTaskPool> list = mapper.getApplyList(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 查询已完成任务数
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> conmpletedTask(QueryModel model) {
		List<Map<String, Object>> list = mapper.conmpletedTask(model);
		return list;
	}
	
	 /*
	  * 新增商机类任务反馈
	  * */
	public int insertTP(CimFTcTP tp) {
		return mapper.insertTP(tp);
	}
	
	
	/**
	 * 查询任务池
	 */
	public void upd(String BizSeqNo) {
		// 设置最新更新人
		List<CimFTcTP> list = mapper.getlist(BizSeqNo);
		for(int i=0; i < list.size(); i++) {
		CimFTcTaskPool c = new CimFTcTaskPool();
		c.setTaskId(list.get(i).getTaskId());
		c.setTaskState("IMPLEMENTING");
		c.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   c.setLastUpdateDt(time);
		   mapper.updateTaskState(c);
		}
	}
	
	public void upd2(String BizSeqNo) {
		// 设置最新更新人
		List<CimFTcTP> list = mapper.getlist(BizSeqNo);
		for(int i=0; i < list.size(); i++) {
		CimFTcTaskPool c = new CimFTcTaskPool();
		c.setTaskId(list.get(i).getTaskId());
		c.setTaskState("UNASSIGNED");
		c.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   c.setLastUpdateDt(time);
		   mapper.updateTaskState(c);
		}
	}
	
	/**
	 * 分配查询角色名称
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getAllotRoleCode(QueryModel model) {
		List<Map<String, Object>> list = mapper.getAllotRoleCode(model);
		return list;
	}
	
	/**
	 * 申领查询角色名称
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getApplyRoleCode(QueryModel model) {
		List<Map<String, Object>> list = mapper.getApplyRoleCode(model);
		return list;
	}
	
	/**
	 * 查询客户经理
	 */
//	@Transactional(readOnly = true)
//	public List<Map<String, Object>> getUser(QueryModel model) {
//		List<Map<String, Object>> list = mapper.getUser(model);
//		return list;
//	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getUser(Map<String, Object> params) {
		return mapper.getUser(params);
	}

}
