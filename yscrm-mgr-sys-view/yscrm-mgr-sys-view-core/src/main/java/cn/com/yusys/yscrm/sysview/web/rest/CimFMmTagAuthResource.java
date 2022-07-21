package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.domain.CimFMmTagAuthInfo;
import cn.com.yusys.yscrm.sysview.service.CimFMmTagAuthService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cim
 * @类名称: CimFMmTagAuthResource
 * @类描述: 
 * @功能描述: 标签授权管理
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018年10月26日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimfmmtagauth")
public class CimFMmTagAuthResource extends CommonResource<CimFMmTagAuthInfo,String> {
	 @Autowired
	 private CimFMmTagAuthService cimFMmTagAuthService;
	 public CimFMmTagAuthResource(CimFMmTagAuthService service) {
	        super();
	        this.cimFMmTagAuthService=service;
	        // TODO Auto-generated constructor stub
	    }
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimFMmTagAuthService;
	}
	 /*
	  * 查询标签列表
	  * @param model
	  * @return hashmap
	  * */
	 @GetMapping("/list")
	 public ResultDto<List<CimFMmTagAuthInfo>> getList(QueryModel model) {
		 List<CimFMmTagAuthInfo> list = cimFMmTagAuthService.getList(model);
		 return new ResultDto<List<CimFMmTagAuthInfo>>(list);
	 }
	 /*
	  * 更新授权信息
	  * @param au
	  * @return Integer
	  * */
	 @PostMapping("/updatelist")
	 @Timed
	 public ResultDto<Integer> updateAuthList(@RequestBody CimFMmTagAuthInfo au) throws Exception{
		 ResultDto<Integer> resultDto = null;
		 int num = 0;
			 num = this.cimFMmTagAuthService.updateAuthList(au);
			 resultDto = new ResultDto<Integer>(num) ;
		 if (num == 0) {
			 resultDto.setCode(-1);
			 resultDto.setMessage("修改失败");
		}else{
			resultDto.setCode(0);
			resultDto.setMessage("修改成功");
		}
		 return resultDto;
	 }
	 /*
	  * 删除标签内容
	  * @param id
	  * @return Integer
	  * */
	 @PostMapping("/deletelist")
	 @Timed
	 public ResultDto<Integer> deleteAuthList(@RequestBody CimFMmTagAuthInfo au) throws URISyntaxException {
		 return this.cimFMmTagAuthService.deleteAuthList(au);
	 }
	 /*
	  * 新增标签
	  * @param tag
	  * @return int
	  * */
	 @PostMapping("/insertlist")
	 @Timed
	 public ResultDto<Integer> insertAuthList(@RequestBody CimFMmTagAuthInfo au) throws URISyntaxException, ParseException {
		 return this.cimFMmTagAuthService.insertAuthList(au);
	 }
	 /*
	  * 查询角色表
	  * @param 
	  * @return HashMap
	  * */
	 @GetMapping("/getrolelist")
	 public ResultDto<List<Map<String, Object>>> getRoleList() {
		 List<Map<String, Object>> list = this.cimFMmTagAuthService.getRoleList();
		 ResultDto<List<Map<String, Object>>> dto = new ResultDto<List<Map<String, Object>>>(list);
		 return dto;
	 }
	 /*
	  * 查询人员表
	  * @param 
	  * @return HashMap
	  * */
	 @GetMapping("/getuserlist")
	 public ResultDto<List<Map<String, Object>>> getUserList() {
		 List<Map<String, Object>> list = this.cimFMmTagAuthService.getUserList();
		 return new ResultDto<List<Map<String, Object>>>(list);
	 }
	 /*
	  * 查询组织机构表
	  * @param 
	  * @return HashMap
	  * */
	 @GetMapping("/getorglist")
	 public ResultDto<List<Map<String, Object>>> getOrgList() {
		 List<Map<String, Object>> list = this.cimFMmTagAuthService.getOrgList();
		 return new ResultDto<List<Map<String, Object>>>(list);
	 }
	 /*
	  * 查询金融机构表
	  * @param 
	  * @return HashMap
	  * */
	 @GetMapping("/getinstulist")
	 public ResultDto<List<Map<String, Object>>> getInstuList() {
		 List<Map<String, Object>> list = this.cimFMmTagAuthService.getInstuList();
		 return new ResultDto<List<Map<String, Object>>>(list);
	 }
}
