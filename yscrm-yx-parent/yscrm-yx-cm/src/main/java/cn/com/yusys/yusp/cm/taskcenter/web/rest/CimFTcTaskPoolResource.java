package cn.com.yusys.yusp.cm.taskcenter.web.rest;

import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTP;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTaskPool;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTaskPoolDto;
import cn.com.yusys.yusp.cm.taskcenter.service.CimFTcTaskPoolService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.HashMap;
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
@RequestMapping("/api/cimftctaskpool")
public class CimFTcTaskPoolResource  extends CommonResource<CimFTcTaskPool,String>{
	 @Autowired
	 private CimFTcTaskPoolService cimFTcTaskPoolService;
	
	 public CimFTcTaskPoolResource(CimFTcTaskPoolService service) {
	        super();
	        this.cimFTcTaskPoolService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimFTcTaskPool.class);
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimFTcTaskPoolService;
	}
	 /*
	  * 查询任务池 
	  * */
	 @GetMapping("/taskpoollist")
	 public ResultDto<List<CimFTcTaskPoolDto>> getTaskPoolList(QueryModel model) {
 		 List<CimFTcTaskPoolDto> list = cimFTcTaskPoolService.getTaskPoolList(model);
		 return new ResultDto<List<CimFTcTaskPoolDto>>(list);
	 }
	 /*
	  * 更新任务状态
	  * */
	 @PostMapping("/updateState")
	 public ResultDto<Integer> updateState(@RequestBody CimFTcTaskPool tp) throws URISyntaxException {
		 ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFTcTaskPoolService.updateTaskState(tp));
		 int num =cimFTcTaskPoolService.updateTaskState(tp);
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
	  * 更新任务状态
	  * */
	 @PostMapping("/updateTaskState")
	 public ResultDto<Integer> updateTaskState(@RequestBody CimFTcTaskPool tp)throws URISyntaxException, ParseException{
		 String taskState = tp.getTaskState();
		 String taskids = tp.getTaskId();
		 String[] taskid = taskids.split(",");
		 int num = 0;
		 for(int i=0;i<taskid.length;i++) {
			 CimFTcTaskPool cimFTcTaskPool = new CimFTcTaskPool();
			 cimFTcTaskPool.setTaskState(taskState);
			 cimFTcTaskPool.setTaskId(taskid[i]);
			 int num1 = this.cimFTcTaskPoolService.updateTaskState(cimFTcTaskPool);
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
	  * 更新分配后任务状态
	  * */
	 @PostMapping("/allotTask")
	 public ResultDto<Integer> allotTask(@RequestBody CimFTcTaskPool tp) throws URISyntaxException {
		 ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFTcTaskPoolService.allotTask(tp));
		 int num =cimFTcTaskPoolService.allotTask(tp);
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
	  * 审批时列出任务信息
	  * */
	 @GetMapping("/getApplyList")
	 public ResultDto<List<CimFTcTaskPool>> getApplyList(QueryModel model) {
 		 List<CimFTcTaskPool> list = cimFTcTaskPoolService.getApplyList(model);
		 return new ResultDto<List<CimFTcTaskPool>>(list);
	 }
	 
	 /*
	  * 查询已完成任务数
	  * */
     @GetMapping("/conmpletedTask")
	 public ResultDto<List<Map<String, Object>>> conmpletedTask(QueryModel model) {
		 List<Map<String, Object>> list = cimFTcTaskPoolService.conmpletedTask(model);
		 //log.info("list.size()="+list.size());
    	 ResultDto<List<Map<String, Object>>> resultDto=new ResultDto<List<Map<String, Object>>>();
    	 resultDto.setTotal(list.size());
    	 resultDto.setData(list);
		 return resultDto;
	 }
     
	 /*
	  * 申领新增流程到中间表
	  * */
	 @PostMapping("/insertTP")
	 public ResultDto<Integer> insertTP(@RequestBody CimFTcTP tp)throws URISyntaxException, ParseException{
		 String bizSeqNo = tp.getBizSeqNo();
		 String taskids = tp.getTaskId();
		 String[] taskid = taskids.split(",");
		 int num = 0;
		 for(int i=0;i<taskid.length;i++) {
			 CimFTcTP cimFTcTP = new CimFTcTP();
			 cimFTcTP.setBizSeqNo(bizSeqNo);
			 cimFTcTP.setTaskId(taskid[i]);
			 int num1 = this.cimFTcTaskPoolService.insertTP(cimFTcTP);
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
	  * 分配查询角色名称
	  * */
	    @GetMapping("/getAllotRoleCode")
		public ResultDto<List<Map<String, Object>>> getAllotRoleCode(QueryModel model) {
			List<Map<String, Object>> list = cimFTcTaskPoolService.getAllotRoleCode(model);
	    	ResultDto<List<Map<String, Object>>> resultDto=new ResultDto<List<Map<String, Object>>>();
	    	resultDto.setTotal(list.size());
	    	resultDto.setData(list);
			return resultDto;
		}
		 
		 /*
		  * 申领查询角色名称
		  * */
	    @GetMapping("/getApplyRoleCode")
		public ResultDto<List<Map<String, Object>>> getApplyRoleCode(QueryModel model) {
			List<Map<String, Object>> list = cimFTcTaskPoolService.getApplyRoleCode(model);
	    	ResultDto<List<Map<String, Object>>> resultDto=new ResultDto<List<Map<String, Object>>>();
	    	resultDto.setTotal(list.size());
	    	resultDto.setData(list);
			return resultDto;
		}
	    
		 /*
		  * 查询客户经理
		  * */
//	    @GetMapping("/getUser")
//		public ResultDto<List<Map<String, Object>>> getUser(QueryModel model) {
//			List<Map<String, Object>> list = cimFTcTaskPoolService.getUser(model);
//	    	ResultDto<List<Map<String, Object>>> resultDto=new ResultDto<List<Map<String, Object>>>();
//	    	resultDto.setTotal(list.size());
//	    	resultDto.setData(list);
//			return resultDto;
//		}
	    
	    @GetMapping("/getUser")
	    public ResultDto<List<Map<String, Object>>> getUser(@RequestParam String orgCode, @RequestParam Integer page,
	                                                               @RequestParam Integer size, String searchType, String
	                                                                       loginCode, String userName, String roleId,
	                                                               String dutyId) {
	        log.debug("获取用户信息--传递参数:orgCode:{},searchType:{},loginCode:{},userName:{},roleId:{},dutyId:{}", orgCode,
	                searchType, loginCode, userName, roleId, dutyId);
	        PageHelper.startPage(page, size);
	        Map<String, Object> params = new HashMap<>();
	        params.put("orgCode", orgCode);
	        params.put("searchType", searchType);
	        params.put("loginCode", loginCode);
	        params.put("userName", userName);
//	        params.put("roleId", roleId);
//	        params.put("dutyId", dutyId);
	        List<Map<String, Object>> result = cimFTcTaskPoolService.getUser(params);
	        PageHelper.clearPage();
	        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(result);
	        resultDto.setMessage("请求数据成功!");
	        resultDto.setCode(200);
	        return resultDto;
	    }
	    
}
