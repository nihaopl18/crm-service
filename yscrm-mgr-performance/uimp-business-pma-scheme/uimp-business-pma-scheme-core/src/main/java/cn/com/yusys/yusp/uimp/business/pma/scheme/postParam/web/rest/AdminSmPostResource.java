package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.AdminSmPost;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service.AdminSmPostService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminSmPostResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-13 17:39:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/adminsmpost")
public class AdminSmPostResource extends CommonResource<AdminSmPost, String> {
    @Autowired
    private AdminSmPostService adminSmPostService;

    @Override
    protected CommonService getCommonService() {
        return adminSmPostService;
    }
    /**
  	 * @方法名称: querylist
  	 * @方法描述: 查询岗位info信息
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "查询岗位info信息", notes = "查询岗位info信息")
  	@GetMapping("/querylist")
  	public ResultDto<List<Map<String, Object>>> querylist() {
  		List<Map<String, Object>> list = this.adminSmPostService.querylist();
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
  	 /**
  	 * @方法名称: querylistbyid
  	 * @方法描述: 根据岗位编号查询岗位信息
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "根据岗位编号查询岗位信息", notes = "根据岗位编号查询岗位信息")
  	@GetMapping("/querylistbyid")
  	public ResultDto<List<Map<String, Object>>> querylistbyid(@RequestParam String postId) {
  		List<Map<String, Object>> list = this.adminSmPostService.querylistbyid(postId);
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
}
