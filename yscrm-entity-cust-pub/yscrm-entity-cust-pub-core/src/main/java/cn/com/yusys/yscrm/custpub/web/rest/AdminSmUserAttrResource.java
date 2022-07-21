package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custpub.domain.AdminSmUserAttr;
import cn.com.yusys.yscrm.custpub.service.AdminSmUserAttrService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AdminSmUserAttrResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-02-14 09:45:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/adminsmuserattr")
public class AdminSmUserAttrResource extends CommonResource<AdminSmUserAttr, String> {
    @Autowired
    private AdminSmUserAttrService adminSmUserAttrService;

    @Override
    protected CommonService getCommonService() {
        return adminSmUserAttrService;
    }
    
    /**
	 * @方法名称: addUserAttr
	 * @方法描述: 新增用户属性表信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/adduserattrinfo")
	public ResultDto<AdminSmUserAttr> addUserAttr(@RequestBody AdminSmUserAttr adminSmUserAttr) {
		adminSmUserAttr = this.adminSmUserAttrService.addUserAttr(adminSmUserAttr);
		return new ResultDto<AdminSmUserAttr>(adminSmUserAttr);
	}
	@GetMapping("/querybyrolests")
	public ResultDto<List<Map<String,Object>>> querybyrolests(){
		List<Map<String,Object>> result = adminSmUserAttrService.querybyrolests();
		return new ResultDto<List<Map<String,Object>>>(result);
	}
	/**
	 * @方法名称: editUserAttr
	 * @方法描述: 修改用户属性表信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/edituserattr")
	public ResultDto<Integer> editUserAttr(@RequestBody AdminSmUserAttr adminSmUserAttr) {
		int result  = this.adminSmUserAttrService.editUserAttr(adminSmUserAttr);
		return new ResultDto<Integer>(result);
	}
	@GetMapping("/updatePwdTime")
	public ResultDto<Integer> updatePwdTime(@RequestParam (required = false) String userId) {
		int result  = this.adminSmUserAttrService.updatePwdTime(userId);
		return new ResultDto<Integer>(result);
	}
	
	/**
	 * @方法名称: qryBusiType
	 * @方法描述: 根剧选中数据的登录代码查询业务条线字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/qryuserattrinfo")
	public ResultDto<List<Map<String,Object>>> qryBusiType(@RequestParam(required = false) String loginCode){
		List<Map<String,Object>> result = adminSmUserAttrService.qryBusiType(loginCode);
		return new ResultDto<List<Map<String,Object>>>(result);
	}
	@GetMapping("/getUserByParams")
	public ResultDto<List<Map<String,Object>>> getUserByParams(String orgCode,String size,String page,String loginCode,String userName,String roleId){
		List<Map<String,Object>> result = adminSmUserAttrService.getUserByParams(orgCode,size,page,userName,roleId,loginCode);
		return new ResultDto<List<Map<String,Object>>>(result);
	}
}
