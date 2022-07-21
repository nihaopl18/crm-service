package cn.com.yusys.yusp.cm.taskcenter.service;

import cn.com.yusys.yusp.cm.taskcenter.domain.*;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CimFTcMyTaskMapper;

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
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cim-taskpool
 * @类名称: CimFTcMyTaskService
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
public class CimFTcMyTaskService  extends CommonService{
	@Autowired
	private CimFTcMyTaskMapper mapper;
//	@Autowired
//	FileManagementClientFactory fileManagementCilentFactory;
//	/**
//	 * 自增UUID
//	 */
//	private String getUUID() {
//        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
//    }
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}

	/**
	 * 查询任务池
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getMyTaskList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = mapper.getMyTaskList(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 申领任务
	 */
	public int applyMyTaskState(CimFTcMyTask mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置最近更新日期
		mt.setLastUpdateDt(time);
		return mapper.applyMyTaskState(mt);
	}
	 /*
	  * 商机申领后修改执行人
	  * */
	public int updateNickUser(CimFTcNiche mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		mt.setExecuteUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置最近更新日期
		mt.setLastUpdateDt(time);
		return mapper.updateNickUser(mt);
	}
	
	 /*
	  * 更新分配后任务状态
	  * */
	public int insertNicheback(CimFTcNicheback  mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   mt.setLastUpdateDt(time);
		return mapper.insertNicheback(mt);
	}
	 /*
	  * 风险反馈信息
	  * */
	public int riskBackUpdate(CimFTcRisk mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   mt.setLastUpdateDt(time);
		return mapper.riskBackUpdate(mt);
	}
	 /*
	  * 商机信息修改
	  * */
	public int riskUpdate(CimFTcNiche mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   mt.setLastUpdateDt(time);
		return mapper.riskUpdate(mt);
	}
	 /*
	  * 关怀反馈信息
	  * */
	public int careBackUpdate(CimpTcCareInfo mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   mt.setLastUpdateDt(time);
		return mapper.careBackUpdate(mt);
	}
	 /*
	  * 分配修改商机信息表执行人
	  * */
	public int updateAllotNickUser(CimFTcNiche mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   mt.setLastUpdateDt(time);
		return mapper.updateAllotNickUser(mt);
	}
	
	 /*
	  * 商机信息查询
	  * */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> nicheInfolist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = mapper.nicheInfolist(model);
		PageHelper.clearPage();
		return list;
	}
	
	
	 /*
	  * 新增商机类任务反馈
	  * */
	public int insertMyTask(CimFTcMyTask mt) {
		// 设置最新更新人
		mt.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		Date time=null;
		   try {
			time= df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   mt.setLastUpdateDt(time);
		return mapper.insertMyTask(mt);
	}
	
	 /*
	  * 审批打回后更新商机信息表执行人为空
	  * */
	public void applyUser(String BizSeqNo) {
		CimFTcNiche c = new CimFTcNiche();
		c.setTaskId(BizSeqNo);
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
		   mapper.applyUser(c);
	}
//	
//	public void upd2(String BizSeqNo) {
//		// 设置最新更新人
//		List<CimFTcTP> list = mapper.getlist(BizSeqNo);
//		for(int i=0; i < list.size(); i++) {
//		CimFTcTaskPool c = new CimFTcTaskPool();
//		c.setTaskId(list.get(i).getTaskId());
//		c.setTaskState("UNASSIGNED");
//		c.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
//		// 设置日期格式
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
//		java.util.Date time=null;
//		   try {
//			time= df.parse(df.format(new Date()));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		   c.setLastUpdateDt(time);
//		   mapper.applyUser(c);
//		}
//	}
	
	/**
	 * 查询已完成任务数
	 */
	@Transactional(readOnly = true)
	public List<CimFTcMyTask> completedTotal(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CimFTcMyTask> list = mapper.completedTotal(model);
		PageHelper.clearPage();
		return list;
	}
	/**
	 * 查询总任务数
	 */
	@Transactional(readOnly = true)
	public List<CimFTcMyTask> taskTotal(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CimFTcMyTask> list = mapper.taskTotal(model);
		PageHelper.clearPage();
		return list;
	}
	
	public void upd(String BizSeqNo) {
		// 设置最新更新人
		List<CimFTcTP> list = mapper.getlist(BizSeqNo);
		for(int i=0; i < list.size(); i++) {
			CimFTcMyTask c = new CimFTcMyTask();
		c.setTaskId(list.get(i).getTaskId());
		c.setLastUpdateUser(SecurityUtils.getCurrentUserLogin());
		c.setAllotUser(SecurityUtils.getCurrentUserLogin());
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
		   c.setAllotTime(time);
		   mapper.applyUpdate(c);
		}

	}
	
	public void applyBack(String BizSeqNo) {
		// 设置最新更新人
		List<CimFTcTP> list = mapper.getlist(BizSeqNo);
		for(int i=0; i < list.size(); i++) {
			CimFTcMyTask c = new CimFTcMyTask();
		c.setTaskId(list.get(i).getTaskId());
		mapper.applyBack(c);
		}
	}
	
	 /*
	  * 商机信息查询
	  * */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> updateMarket(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = mapper.updateMarket(model);
		PageHelper.clearPage();
		return list;
	}
	 /*
	  * 新增商机类任务反馈
	  * */
	public int marketBack(CmFRcMarketBack mt) {
		// 设置执行人
		mt.setExecuteUser(SecurityUtils.getCurrentUserLogin());

		return mapper.marketBack(mt);
	}
	public int marketFeedback(CmFRcMarketBack mt) {
		// 设置执行人
		//mt.setExecuteUser(SecurityUtils.getCurrentUserLogin());

		return mapper.marketFeedback(mt);
	}

	public int careBack(CimpTcCareInfo cimpTcCareInfo) {
		return mapper.careBack(cimpTcCareInfo);
	}

	public int riskBack(CimFTcRisk cimFTcRisk) {
		return mapper.riskBack(cimFTcRisk);
	}
}
