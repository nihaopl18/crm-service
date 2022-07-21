package cn.com.yusys.yscrm.user.schedule.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemind;
import cn.com.yusys.yscrm.info.remind.repository.mapper.AcrmFwpRemindMapper;
import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpSchedule;
import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpScheduleOther;
import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpSchedulePlan;
import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpScheduleVisit;
import cn.com.yusys.yscrm.user.schedule.repository.mapper.OcrmFwpScheduleMapper;
import cn.com.yusys.yscrm.user.schedule.repository.mapper.OcrmFwpScheduleOtherMapper;
import cn.com.yusys.yscrm.user.schedule.repository.mapper.OcrmFwpSchedulePlanMapper;
import cn.com.yusys.yscrm.user.schedule.repository.mapper.OcrmFwpScheduleVisitMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-mgr-user-schedule-core模块
 * @类名称: OcrmFwpScheduleService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-12 18:34:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpScheduleService extends CommonService {
	
	private final Logger logger = LoggerFactory.getLogger(OcrmFwpScheduleService.class);
	@Autowired
	private AcrmFwpRemindMapper acrmFwpRemindMapper;
    @Autowired
    private OcrmFwpScheduleMapper ocrmFwpScheduleMapper;
    
    @Autowired
    private OcrmFwpScheduleVisitMapper ocrmFwpScheduleVisitMapper;

    @Autowired
    private OcrmFwpSchedulePlanMapper ocrmFwpSchedulePlanMapper;
    
    @Autowired
    private OcrmFwpScheduleOtherMapper ocrmFwpScheduleOtherMapper;
    
	@Autowired
	private UaaClient uaaClient; 

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpScheduleMapper;
    }
    
    /**
     * 判断OCRM_F_WP_SCHEDULE表中 是否已有对应 客户经理、日程日期的数据
     * @param mgrId 客户经理编号
     * @param schDate 日程日期 yyyy-MM-dd
     * @return 已有true， 没有false
     * @throws Exception 
     */
    public Boolean hasSameData(String mgrId, String schDate) throws Exception {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 设置lenient为false. 严格校验
			format.setLenient(false);
			format.parse(schDate);
		} catch (Exception e) {
			logger.error("the param schDate value is null or not format by yyyy-MM-dd");
			throw e;
		}
    	List<Map<String, Object>> list = ocrmFwpScheduleMapper.hasSameData(mgrId, schDate);
    	return (list.size() > 0 ? true : false);
    }
    
    /**
     * @方法名称: queryList
     * @方法描述: 日程安排 列表查询，公共API接口 - 查询进行分页
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> queryList(QueryModel model) {
    	List<Map<String, Object>> list = null;
    	String type = model.getCondition().get("type") + "";
    	PageHelper.startPage(model.getPage(), model.getSize());
    	if("1".equals(type)) {	// 客户接触
    		list = ocrmFwpScheduleVisitMapper.queryList(model);
    	} else if("2".equals(type)) {	// 工作计划
    		list = ocrmFwpSchedulePlanMapper.queryList(model);
    	} else if("3".equals(type)) {	// 其他日程
    		list = ocrmFwpScheduleOtherMapper.queryList(model);
    	}
    	PageHelper.clearPage();
    	return list;
    }
    
    /**
     * @方法名称: querySchedule
     * @方法描述: 日程安排 日历组件 简要数据查询，公共API接口
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<Map<String, Object>> querySchedule(String reporterId, String startDate, String endDate) {
    	List<Map<String, Object>> list=ocrmFwpScheduleMapper.querySchedule1(reporterId, startDate, endDate);
    	String scheduleIds="''";
    	if(list!=null) {
    		if(list.size()>0) {
    			for (int i=0;i<list.size();i++) {
    				Map<String, Object> map=list.get(i);
    				String mgrId=(String) map.get("mgrId");
    				String scheduleId=(String) map.get("scheduleId");
    				String []mgrIds=mgrId.split(",");
//    				int index=Arrays.binarySearch(mgrIds, reporterId);
    				boolean flag=Arrays.asList(mgrIds).contains(reporterId);
    				if(flag) {
    					//表示这个值存在
    					scheduleIds=scheduleIds+",'"+scheduleId+"'";
    				}
    			}
    		}
    	}else {
    		//如果没有查询到，说明不存在这个日程
    		return null;
    	}
    	return ocrmFwpScheduleMapper.querySchedule(scheduleIds,reporterId);
    }
    
    /**
     * 新增 日程安排 -- 客户接触
     * @param ocrmFwpScheduleVisit
     * @return
     */
    public Integer insertSchedule(OcrmFwpSchedule ocrmFwpSchedule) {
    	// TODO 增加异常处理 
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpSchedule.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	return ocrmFwpScheduleMapper.insertSelective(ocrmFwpSchedule);
    }
    
    /**
     * 新增 日程安排 -- 客户接触
     * @param ocrmFwpScheduleVisit
     * @return
     * @throws ParseException 
     */
    public Integer insertVisit(OcrmFwpScheduleVisit ocrmFwpScheduleVisit) throws ParseException {
    	// TODO 增加异常处理 
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpScheduleVisit.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFwpScheduleVisit.setIsDelete("N");
    	// 如果任务安排人、客户经理一致，接触状态 默认 已安排；否则 接触状态  未下达
    	if(!StringTools.isEmpty(ocrmFwpScheduleVisit.getArangeId()) && 
    			ocrmFwpScheduleVisit.getArangeId().equals(ocrmFwpScheduleVisit.getVisitorId())) {
    		ocrmFwpScheduleVisit.setVisitStat("2");
    		String mgrId=ocrmFwpScheduleVisit.getMgrId();
        	String scheduleId=ocrmFwpScheduleVisit.getScheduleId();
        	ocrmFwpScheduleMapper.updateFun(mgrId, scheduleId);
        	if(ocrmFwpScheduleVisit.getIsRemind()!=null&&ocrmFwpScheduleVisit.getIsRemind().equals("1")) {
	        	AcrmFwpRemind acrmFwpRemind=new AcrmFwpRemind();
	        	//acrmFwpRemind.setCorpOrgCode("001");
	        	acrmFwpRemind.setCustId(ocrmFwpScheduleVisit.getCustId());
	        	//acrmFwpRemind.setCustType(ocrmFwpScheduleVisit.getCustType());
	        	acrmFwpRemind.setCustName(ocrmFwpScheduleVisit.getCustName());
	        	acrmFwpRemind.setTypeId("KHJC");
	        	acrmFwpRemind.setTypeName("客户接触");
	        	acrmFwpRemind.setReceUser(ocrmFwpScheduleVisit.getVisitorId());
	        	//SimpleDateFormat s=new SimpleDateFormat();
	        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        	acrmFwpRemind.setRemindCreateDate(sdf.parse(sdf.format(new Date())));
	        	acrmFwpRemind.setRemindExpireDate(sdf.parse(ocrmFwpScheduleVisit.getRemindDate()));
	        	long days=(acrmFwpRemind.getRemindExpireDate().getTime()-acrmFwpRemind.getRemindCreateDate().getTime())/(3600*24*1000);
	        	//acrmFwpRemind.setRemainDays(new BigDecimal(days));
	        	//acrmFwpRemind.setRemindInfo("客户接触任务");
	        	acrmFwpRemindMapper.insertSelective(acrmFwpRemind);
        	}
    	} else {
    		ocrmFwpScheduleVisit.setVisitStat("1");
    	}
    	return ocrmFwpScheduleVisitMapper.insertSelective(ocrmFwpScheduleVisit);
    }
    
    /**
     * 新增 日程安排 -- 工作计划
     * @param ocrmFwpSchedulePlan
     * @return
     * @throws ParseException 
     */
    public Integer insertPlan(OcrmFwpSchedulePlan ocrmFwpSchedulePlan) throws ParseException {
    	// TODO 增加异常处理 
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpSchedulePlan.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFwpSchedulePlan.setIsDelete("N");
    	// 如果任务安排人、客户经理一致，计划执行状态 默认 已安排；否则 计划执行状态  未下达
    	if(!StringTools.isEmpty(ocrmFwpSchedulePlan.getArangeId()) && 
    			ocrmFwpSchedulePlan.getArangeId().equals(ocrmFwpSchedulePlan.getMgrId())) {
    		ocrmFwpSchedulePlan.setStat("2");
    		if(ocrmFwpSchedulePlan.getIsRemind()!=null&&ocrmFwpSchedulePlan.getIsRemind().equals("1")) {
	        	AcrmFwpRemind acrmFwpRemind=new AcrmFwpRemind();
	        	//acrmFwpRemind.setCorpOrgCode("001");
	        	acrmFwpRemind.setCustId(ocrmFwpSchedulePlan.getCustId());
	        	acrmFwpRemind.setCustName(ocrmFwpSchedulePlan.getCustName());
	        	acrmFwpRemind.setTypeId("GZJH");
	        	acrmFwpRemind.setTypeName("工作计划");
	        	acrmFwpRemind.setReceUser(ocrmFwpSchedulePlan.getArangeId());
	        	//SimpleDateFormat s=new SimpleDateFormat();
	        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        	acrmFwpRemind.setRemindCreateDate(sdf.parse(sdf.format(new Date())));
	        	acrmFwpRemind.setRemindExpireDate(sdf.parse(ocrmFwpSchedulePlan.getRemindDate()));
	        	long days=(acrmFwpRemind.getRemindExpireDate().getTime()-acrmFwpRemind.getRemindCreateDate().getTime())/(3600*24*1000);
	        	//acrmFwpRemind.setRemainDays(new BigDecimal(days));
	        	//acrmFwpRemind.setRemindInfo("工作计划任务");
	        	acrmFwpRemindMapper.insertSelective(acrmFwpRemind);
        	}
    	} else {
    		ocrmFwpSchedulePlan.setStat("1");
    	}
    	return ocrmFwpSchedulePlanMapper.insertSelective(ocrmFwpSchedulePlan);
    }
    
    /**
     * 新增 日程安排 -- 其他日程
     * @param ocrmFwpScheduleOther
     * @return
     * @throws ParseException 
     */
    public Integer insertOther(OcrmFwpScheduleOther ocrmFwpScheduleOther) throws ParseException {
    	// TODO 增加异常处理 
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpScheduleOther.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFwpScheduleOther.setIsDelete("N");
    	// 如果任务安排人、客户经理一致，完成状态 默认 已安排；否则 完成状态  未下达
    	if(!StringTools.isEmpty(ocrmFwpScheduleOther.getArangeId()) && 
    			ocrmFwpScheduleOther.getArangeId().equals(ocrmFwpScheduleOther.getMgrId())) {
    		ocrmFwpScheduleOther.setStat("2");
    		if(ocrmFwpScheduleOther.getIsRemind()!=null&&ocrmFwpScheduleOther.getIsRemind().equals("1")) {
	        	AcrmFwpRemind acrmFwpRemind=new AcrmFwpRemind();
	        	//acrmFwpRemind.setCorpOrgCode("001");
	        	acrmFwpRemind.setCustId(ocrmFwpScheduleOther.getCustId());
	        	acrmFwpRemind.setCustName(ocrmFwpScheduleOther.getCustName());
	        	acrmFwpRemind.setTypeId("QTRC");
	        	acrmFwpRemind.setTypeName("其他日程");
	        	acrmFwpRemind.setReceUser(ocrmFwpScheduleOther.getArangeId());
	        	//SimpleDateFormat s=new SimpleDateFormat();
	        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        	acrmFwpRemind.setRemindCreateDate(sdf.parse(sdf.format(new Date())));
	        	acrmFwpRemind.setRemindExpireDate(sdf.parse(ocrmFwpScheduleOther.getRemindDate()));
	        	long days=(acrmFwpRemind.getRemindExpireDate().getTime()-acrmFwpRemind.getRemindCreateDate().getTime())/(3600*24*1000);
	        	//acrmFwpRemind.setRemainDays(new BigDecimal(days));
	        	//acrmFwpRemind.setRemindInfo("其他日程任务");
	        	acrmFwpRemindMapper.insertSelective(acrmFwpRemind);
        	}
    	} else {
    		ocrmFwpScheduleOther.setStat("1");
    	}
    	return ocrmFwpScheduleOtherMapper.insertSelective(ocrmFwpScheduleOther);
    }
    
    /**
     * @方法名称: delete
     * @方法描述: 删除  - 根据 客户接触、工作计划、其他日程 主键 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int delete(String type, String ids) {
    	// TODO 增加异常处理 
    	int result = 0;
    	String[] arrIds = {};
    	if(!StringTools.isEmpty(ids)) 
    		arrIds = ids.split(",");
    	if("1".equals(type)) {	// 客户接触
    		result = ocrmFwpScheduleVisitMapper.deleteByVids(arrIds);
    	} else if("2".equals(type)) {	// 工作计划
    		result = ocrmFwpSchedulePlanMapper.deleteByPids(arrIds);
    	} else if("3".equals(type)) {	// 其他日程
    		result = ocrmFwpScheduleOtherMapper.deleteByOids(arrIds);
    	}
        return result;
    }

    /**
     * @throws ParseException 
     * @方法名称: scheduleRelease
     * @方法描述: 下达  - 根据 客户接触、工作计划、其他日程 主键 修改状态
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int scheduleRelease(String type, String ids,String mgrId,String scheduleId) throws ParseException {
    	// TODO 增加异常处理 
    	int result = 0;
    	int result1=0;
    	String[] arrIds = {};
    	if(!StringTools.isEmpty(ids)) 
    		arrIds = ids.split(",");
    	if (!"".equals(mgrId)) {
			Map<String, Object> selectMgr = ocrmFwpScheduleMapper.selectMgr(scheduleId);
			String mgrIds=(String) selectMgr.get("mgrId");
			String []mgrIdss=mgrId.split(",");
//			int index=Arrays.binarySearch(mgrIds, reporterId);
			boolean flag=Arrays.asList(mgrIdss).contains(mgrId);
			if(flag) {
				//表示这个值存在，不做任何操作
			}else {
				ocrmFwpScheduleMapper.updateFun(mgrId, scheduleId);//下达之后，日程将会显示在相应的客户经理的日程中
			}
		}
    	if("1".equals(type)) {	// 客户接触 
    		result = ocrmFwpScheduleVisitMapper.scheduleRelease(arrIds);
    		List<Map<String, Object>> list= ocrmFwpScheduleVisitMapper.selectVisits(arrIds);
    		if(list!=null&&list.size()>0) {
    			for (int i=0;i<list.size();i++) {
    				Map<String, Object> map=list.get(i);
    				if(map.get("isRemind")!=null&&map.get("isRemind").equals("1")) {
    		        	AcrmFwpRemind acrmFwpRemind=new AcrmFwpRemind();
    		        	//acrmFwpRemind.setCorpOrgCode("001");
    		        	acrmFwpRemind.setCustId(map.get("custId").toString());
    		        	//acrmFwpRemind.setCustType(map.get("custType").toString());
    		        	acrmFwpRemind.setCustName(map.get("custName").toString());
    		        	acrmFwpRemind.setTypeId("KHJC");
    		        	acrmFwpRemind.setTypeName("客户接触");
    		        	acrmFwpRemind.setReceUser(map.get("visitorId").toString());
    		        	Date remindDate;
    		        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		        	if(map.get("remindDate")!=null&&!map.get("remindDate").equals("")) {
    		        		remindDate=sdf.parse(map.get("remindDate").toString());
    		        	}else {
    		        		remindDate=sdf.parse(sdf.format(new Date()));
    		        	}
    		        	acrmFwpRemind.setRemindCreateDate(sdf.parse(sdf.format(new Date())));
    		        	acrmFwpRemind.setRemindExpireDate(remindDate);
    		        	long days=(acrmFwpRemind.getRemindExpireDate().getTime()-acrmFwpRemind.getRemindCreateDate().getTime())/(3600*24*1000);
    		        	//acrmFwpRemind.setRemainDays(new BigDecimal(days));
    		        	//acrmFwpRemind.setRemindInfo("客户接触任务");
    		        	acrmFwpRemindMapper.insertSelective(acrmFwpRemind);
    	        	}
    			}
    		}
    		//result1=ocrmFwpScheduleVisitMapper.insertSchedules(arrIds);
    	} else if("2".equals(type)) {	// 工作计划
    		result = ocrmFwpSchedulePlanMapper.scheduleRelease(arrIds);
    	} else if("3".equals(type)) {	// 其他日程
    		result = ocrmFwpScheduleOtherMapper.scheduleRelease(arrIds);
    	}
        return result;
    }
    
    /**
     * 新增 日程安排 -- 客户接触
     * @param ocrmFwpScheduleVisit
     * @return
     */
    public Integer feedbackVisit(OcrmFwpScheduleVisit ocrmFwpScheduleVisit) {
    	// TODO 增加异常处理 
//    	ocrmFwpScheduleVisit.setVisitStat("2");
    	return ocrmFwpScheduleVisitMapper.updateByPrimaryKeySelective(ocrmFwpScheduleVisit);
    }
    
    /**
     * 新增 日程安排 -- 工作计划
     * @param ocrmFwpSchedulePlan
     * @return
     */
    public Integer feedbackPlan(OcrmFwpSchedulePlan ocrmFwpSchedulePlan) {
    	// TODO 增加异常处理 
//    	ocrmFwpSchedulePlan.setStat("2");
    	return ocrmFwpSchedulePlanMapper.updateByPrimaryKeySelective(ocrmFwpSchedulePlan);
    }
    
    /**
     * 新增 日程安排 -- 其他日程
     * @param ocrmFwpScheduleOther
     * @return
     */
    public Integer feedbackOther(OcrmFwpScheduleOther ocrmFwpScheduleOther) {
    	// TODO 增加异常处理 
//    	ocrmFwpScheduleOther.setStat("2");
    	return ocrmFwpScheduleOtherMapper.updateByPrimaryKeySelective(ocrmFwpScheduleOther);
    }
}
