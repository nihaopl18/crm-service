package cn.com.yusys.yscrm.user.schedule.web.rest;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpSchedule;
import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpScheduleOther;
import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpSchedulePlan;
import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpScheduleVisit;
import cn.com.yusys.yscrm.user.schedule.service.OcrmFwpScheduleService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.micrometer.core.annotation.Timed;

/**
 * @项目名称: yscrm-mgr-user-schedule-core模块
 * @类名称: OcrmFwpScheduleResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-12 18:34:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/userschedule")
public class OcrmFwpScheduleResource extends CommonResource<OcrmFwpSchedule, String> {
	
    @Autowired
    private OcrmFwpScheduleService ocrmFwpScheduleService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFwpScheduleService;
    }
    
    /**
     * @函数名称:queryList
     * @函数描述: 日程安排 列表查询，公共API接口
     * @参数与返回说明:
     * @param QueryModel
     *            分页查询类
     * @算法描述:
     */
    @GetMapping("/querylist")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
    	List<Map<String, Object>> list = null;
    	// 校验必输项
    	if(queryModel.getCondition().containsKey("type") && !StringTools.isEmpty(queryModel.getCondition().get("type") + "")) {
    		list = ocrmFwpScheduleService.queryList(queryModel);
    	}
        return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * @函数名称:querySchedule
     * @函数描述: 日程安排 日历组件 简要数据查询，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/queryschedule")
    @Timed
    protected ResultDto<List<Map<String, Object>>> querySchedule(@RequestParam(value = "reporterId", required = true) String reporterId,
    		@RequestParam(value = "startDate", required = true) String startDate, 
    		@RequestParam(value = "endDate", required = true) String endDate) {
    	List<Map<String, Object>> list = ocrmFwpScheduleService.querySchedule(reporterId, startDate, endDate);
    	return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * @函数名称:insert
     * @函数描述: 新增 日程安排 数据
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/insert")
    @Timed
    protected ResultDto<String> insert(@RequestBody OcrmFwpSchedule ocrmFwpSchedule) throws URISyntaxException {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	ocrmFwpSchedule.setCratDt(df.format(new Date()));
    	ocrmFwpScheduleService.insertSchedule(ocrmFwpSchedule);
    	String result = ocrmFwpSchedule.getScheduleId();
        return new ResultDto<String>(result);
    }
    
    /**
     * @函数名称:insertVisit
     * @函数描述: 新增 日程安排 -- 客户接触
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/insertvisit")
    @Timed
    protected ResultDto<Integer> insertVisit(@RequestBody OcrmFwpScheduleVisit ocrmFwpScheduleVisit) throws URISyntaxException {
    	Integer result = null;
		try {
			result = ocrmFwpScheduleService.insertVisit(ocrmFwpScheduleVisit);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:insertPlan
     * @函数描述: 新增 日程安排 -- 工作计划
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/insertplan")
    @Timed
    protected ResultDto<Integer> insertPlan(@RequestBody OcrmFwpSchedulePlan ocrmFwpSchedulePlan) throws URISyntaxException {
    	Integer result = null;
		try {
			result = ocrmFwpScheduleService.insertPlan(ocrmFwpSchedulePlan);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:insertOther
     * @函数描述: 新增 日程安排 -- 其他日程
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/insertother")
    @Timed
    protected ResultDto<Integer> insertOther(@RequestBody OcrmFwpScheduleOther ocrmFwpScheduleOther) throws URISyntaxException {
    	Integer result = null;
		try {
			result = ocrmFwpScheduleService.insertOther(ocrmFwpScheduleOther);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return new ResultDto<Integer>(result);
    }

    /**
     * @函数名称:delete
     * @函数描述:删除  - 根据 客户接触、工作计划、其他日程 主键 逻辑删除
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/delete")
    @Timed
    protected ResultDto<Integer> delete(@RequestBody Map<?, ?> list) {
    	Integer result = 0;
    	if(list.get("type") == null || list.get("ids") == null ||
			StringTools.isEmpty(list.get("type") + "") || StringTools.isEmpty(list.get("ids") + ""))
    		return new ResultDto<Integer>(result);
    	result = ocrmFwpScheduleService.delete(list.get("type") + "", list.get("ids") + "");
    	return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:scheduleRelease
     * @函数描述:下达  - 根据 客户接触、工作计划、其他日程 主键 修改状态
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/schedulerelease")
    @Timed
    protected ResultDto<Integer> scheduleRelease(@RequestBody Map<?, ?> list) {
    	Integer result = 0;
    	if(list.get("type") == null || list.get("ids") == null ||
			StringTools.isEmpty(list.get("type") + "") || StringTools.isEmpty(list.get("ids") + ""))
    		return new ResultDto<Integer>(result);
    	try {
			result = ocrmFwpScheduleService.scheduleRelease(list.get("type") + "", list.get("ids") + "",list.get("mgrId").toString(),list.get("scheduleId").toString());
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	
    	return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:feedbackVisit
     * @函数描述: 反馈 日程安排 -- 客户接触
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/feedbackvisit")
    @Timed
    protected ResultDto<Integer> feedbackVisit(@RequestBody OcrmFwpScheduleVisit ocrmFwpScheduleVisit) throws URISyntaxException {
    	Integer result = ocrmFwpScheduleService.feedbackVisit(ocrmFwpScheduleVisit);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:feedbackPlan
     * @函数描述: 反馈 日程安排 -- 工作计划
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/feedbackplan")
    @Timed
    protected ResultDto<Integer> feedbackPlan(@RequestBody OcrmFwpSchedulePlan ocrmFwpSchedulePlan) throws URISyntaxException {
    	Integer result = ocrmFwpScheduleService.feedbackPlan(ocrmFwpSchedulePlan);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:feedbackOther
     * @函数描述: 反馈 日程安排 -- 其他日程
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/feedbackother")
    @Timed
    protected ResultDto<Integer> feedbackOther(@RequestBody OcrmFwpScheduleOther ocrmFwpScheduleOther) throws URISyntaxException {
    	Integer result = ocrmFwpScheduleService.feedbackOther(ocrmFwpScheduleOther);
        return new ResultDto<Integer>(result);
    }
}
