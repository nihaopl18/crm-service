package cn.com.yusys.yusp.cm.taskcenter.web.rest;

import cn.com.yusys.yusp.cm.taskcenter.domain.*;
import cn.com.yusys.yusp.cm.taskcenter.service.CimFTcMyTaskService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cim-cust
 * @类名称: CimFMmTagDataSourceResource
 * @类描述: 
 * @功能描述: 模型版本信息
 * @创建人: yangye@yusys.com.cn
 * @创建时间: 2018年09月27日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimftcmytask")
public class CimFTcMyTaskResource  extends CommonResource<CimFTcMyTask,String>{
	 @Autowired
	 private CimFTcMyTaskService cimFTcMyTaskService;
	
	 public CimFTcMyTaskResource(CimFTcMyTaskService service) {
	        super();
	        this.cimFTcMyTaskService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimFTcTaskPool.class);
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimFTcMyTaskService;
	}
	 /*
	  * 查询任务池
	  * */
	 @GetMapping("/mytasklist")
	 public ResultDto<List<Map<String, Object>>> getMyTaskList(QueryModel model) {
		 List<Map<String, Object>> list = cimFTcMyTaskService.getMyTaskList(model);
		 return new ResultDto<List<Map<String, Object>>>(list);
	 }
	 /*
	  * 申领后新增我的任务
	  * */
		 @PostMapping("/applyMyTaskState")
		 public ResultDto<Integer> applyMyTaskState(@RequestBody CimFTcMyTask mt)throws URISyntaxException, ParseException{
			 String dutyUser = mt.getDutyUser();
			 String taskids = mt.getTaskId();
			 String[] taskid = taskids.split(",");
			 int num = 0;
			 for(int i=0;i<taskid.length;i++) {
				 CimFTcMyTask cimFTcMyTask = new CimFTcMyTask();
				 cimFTcMyTask.setDutyUser(dutyUser);
				 cimFTcMyTask.setTaskId(taskid[i]);
				 int num1 = this.cimFTcMyTaskService.applyMyTaskState(cimFTcMyTask);
				 if(num1 == 1) {
					 num++;
				 }
			 };
			 ResultDto<Integer> resultDto = new ResultDto<Integer>();
		     log.info("num="+num);
		     if(num==0){
		    	 resultDto.setMessage("新增失败！");
		    	 resultDto.setCode(-1);
		     }else {
		    	 resultDto.setMessage("成功");
		    	 resultDto.setCode(0);
		     }
		     return resultDto;
		 }
		 /*
		  * 商机申领后修改执行人
		  * */
		 @PostMapping("/updateNickUser")
		 public ResultDto<Integer> updateNickUser(@RequestBody CimFTcNiche mt)throws URISyntaxException, ParseException{
			 String nickTaskId = mt.getTaskId();
			 String[] taskid = nickTaskId.split(",");
			 int num = 0;
			 for(int i=0;i<taskid.length;i++) {
				 CimFTcNiche cimFTcNiche = new CimFTcNiche();
				 cimFTcNiche.setTaskId(taskid[i]);
				 int num1 = this.cimFTcMyTaskService.updateNickUser(cimFTcNiche);
				 if(num1 == 1) {
					 num++;
				 }
			 };
			 ResultDto<Integer> resultDto = new ResultDto<Integer>();
		     log.info("num="+num);
		     if(num==0){
		    	 resultDto.setMessage("新增失败！");
		    	 resultDto.setCode(-1);
		     }else {
		    	 resultDto.setMessage("成功");
		    	 resultDto.setCode(0);
		     }
		     return resultDto;
		 }
	 /*
	  * 分配后新增我的任务
	  * */
	    @PostMapping("/insertMyTask")
		  public ResultDto<List<CimFTcMyTask>> insertMyTask(@RequestBody CimFTcMyTask record)throws URISyntaxException, ParseException{
	    	ResultDto<List<CimFTcMyTask>> resultDto=new ResultDto<List<CimFTcMyTask>>();
	    	int num =cimFTcMyTaskService.insertMyTask(record);
	    	log.info("num="+num);
	    	if(num==0){
	    		resultDto.setMessage("新增失败！");
	    		resultDto.setCode(-1);
	    	}else {
	    		resultDto.setMessage("成功");
	    		resultDto.setCode(0);
	    	}
	    	return resultDto;
		 }
	 /*
	  * 更新风险反馈信息
	  * */
	 @PostMapping("/riskBackUpdate")
	 public ResultDto<Integer> riskBackUpdate(@RequestBody CimFTcRisk mt) throws URISyntaxException {
		 ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFTcMyTaskService.riskBackUpdate(mt));
		 int num =cimFTcMyTaskService.riskBackUpdate(mt);
		 log.info("num="+num);
		 if(num==0){
		 	dto.setMessage("失败！");
		 	dto.setCode(-1);
		 }else {
		 	dto.setMessage("成功");
		 	dto.setCode(0);
		 }
		 return dto;
	 }
	@PostMapping("/riskBack")
	public ResultDto<Integer> riskBack(@RequestBody CimFTcRisk cimFTcRisk) throws URISyntaxException {
		ResultDto<Integer> dto = new ResultDto<>();
		cimFTcRisk.setRiskId(cimFTcRisk.getTaskId());
		int num =cimFTcMyTaskService.riskBack(cimFTcRisk);
		if(num==0){
			dto.setMessage("失败！");
			dto.setCode(-1);
		}else {
			dto.setMessage("成功");
			dto.setCode(0);
		}
		return dto;
	}
	 /*
	  * 关怀反馈信息
	  * */
	 @PostMapping("/careBackUpdate")
	 public ResultDto<Integer> careBackUpdate(@RequestBody CimpTcCareInfo mt) throws URISyntaxException {
		 ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFTcMyTaskService.careBackUpdate(mt));
		 int num =cimFTcMyTaskService.careBackUpdate(mt);
		 log.info("num="+num);
		 if(num==0){
		 	dto.setMessage("失败！");
		 	dto.setCode(-1);
		 }else {
		 	dto.setMessage("成功");
		 	dto.setCode(0);
		 }
		 return dto;
	 }
	@PostMapping("/careBack")
	public ResultDto<Integer> careBack(@RequestBody CimpTcCareInfo cimpTcCareInfo) throws URISyntaxException {
		ResultDto<Integer> dto = new ResultDto<>();
		cimpTcCareInfo.setCareId(cimpTcCareInfo.getTaskId());
		int num =cimFTcMyTaskService.careBack(cimpTcCareInfo);
		if(num==0){
			dto.setMessage("失败！");
			dto.setCode(-1);
		}else {
			dto.setMessage("成功");
			dto.setCode(0);
		}
		return dto;
	}
	 
	 /*
	  * 分配修改商机信息表执行人
	  * */
	 @PostMapping("/updateAllotNickUser")
	 public ResultDto<Integer> updateAllotNickUser(@RequestBody CimFTcNiche mt) throws URISyntaxException {
		 ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFTcMyTaskService.updateAllotNickUser(mt));
		 int num =cimFTcMyTaskService.updateAllotNickUser(mt);
		 log.info("num="+num);
		 if(num==0){
		 	dto.setMessage("失败！");
		 	dto.setCode(-1);
		 }else {
		 	dto.setMessage("成功");
		 	dto.setCode(0);
		 }
		 return dto;
	 }
	 /*
	  * 查询商机信息
	  * */
	 @GetMapping("/nicheInfolist")
	 public ResultDto<List<Map<String, Object>>> nicheInfolist(QueryModel model) {
		 List<Map<String, Object>> list = cimFTcMyTaskService.nicheInfolist(model);
		 return new ResultDto<List<Map<String, Object>>>(list);
	 }
	 
	 /*
	  * 商机类任务反馈
	  * */
	 @PostMapping("/nicheback")
	 public ResultDto<Integer> insertNicheback(@RequestBody CimFTcNicheback mt) throws URISyntaxException {
		 String taskid = mt.getTaskId();
		 String nicheStages = mt.getNicheStage();
		 String yesnos = mt.getYesNo();
		 String situations = mt.getSituation();
		 String feedbacktimes = mt.getFeedbackTime();
		 String[] nicheStage = nicheStages.split(",");
		 String[] yesno = yesnos.split(",");
		 String[] situation = situations.split(",");
		 String[] feedbacktime = feedbacktimes.split(",");
		 int num = 0;
		 for(int i=0;i<nicheStage.length;i++) {
			 CimFTcNicheback cimFTcNicheback = new CimFTcNicheback();
			 cimFTcNicheback.setTaskId(taskid);
			 cimFTcNicheback.setNicheStage(nicheStage[i]);
			 cimFTcNicheback.setYesNo(yesno[i]);
			 cimFTcNicheback.setSituation(situation[i]);
			 cimFTcNicheback.setFeedbackTime(feedbacktime[i]);
			 int num1 = this.cimFTcMyTaskService.insertNicheback(cimFTcNicheback);
			 if(num1 == 1) {
				 num++;
			 }
		 };
		 ResultDto<Integer> dto = new ResultDto<Integer>();
		 if(num == 5) {
			 dto.setCode(0);
			 dto.setMessage("成功");
			 return dto;
		 }
		 dto.setCode(-1);
		 dto.setMessage("失败");
		return dto;

	 }	

	 /*
	  * 查询已完成任务数
	  * */
	 @GetMapping("/completedTotal")
	 public ResultDto<List<CimFTcMyTask>> completedTotal(QueryModel model) {
		 List<CimFTcMyTask> list = cimFTcMyTaskService.completedTotal(model);
		 return new ResultDto<List<CimFTcMyTask>>(list);
	 }
	 
	 /*
	  * 查询总任务数
	  * */
	 @GetMapping("/taskTotal")
	 public ResultDto<List<CimFTcMyTask>> taskTotal(QueryModel model) {
		 List<CimFTcMyTask> list = cimFTcMyTaskService.taskTotal(model);
		 return new ResultDto<List<CimFTcMyTask>>(list);
	 }
	 

	 @PostMapping("/nicheMarket")
	 public ResultDto<Integer> careBackUpdate(@RequestBody CmFRcMarketBack mt) throws URISyntaxException {
		 ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFTcMyTaskService.marketBack(mt));
		 int num =cimFTcMyTaskService.marketBack(mt);
		 log.info("num="+num);
		 if(num==0){
		 	dto.setMessage("失败！");
		 	dto.setCode(-1);
		 }else {
		 	dto.setMessage("成功");
		 	dto.setCode(0);
		 }
		 return dto;
	 }
	@PostMapping("/marketback")
	public ResultDto<Integer> marketFeedback(@RequestBody CmFRcMarketBack mt) throws URISyntaxException {
		ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFTcMyTaskService.marketFeedback(mt));
		int num =cimFTcMyTaskService.marketFeedback(mt);
		if(num==0){
			dto.setMessage("失败！");
			dto.setCode(-1);
		}else {
			dto.setMessage("成功");
			dto.setCode(0);
		}
		return dto;
	}

   }
