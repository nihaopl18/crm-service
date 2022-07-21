package cn.com.yusys.climp.acty.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.service.LoyRlActivityService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlActivityResource
 * @类描述: 积分活动资源类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/activity")
public class LoyRlActivityResource extends CommonResource<LoyRlActivity, String> {
    @Autowired
    private LoyRlActivityService loyRlActivityService;

    @Override
    protected CommonService getCommonService() {
        return loyRlActivityService;
    }
    /**
    * @方法名称:getEventInfo
    * @方法描述:查询积分活动信息
    * @参数与返回说明:
    * @算法描述:
     */
    @GetMapping("/list")
	public ResultDto<List<Map<String,String>>> getEventInfo(QueryModel queryModel) {
		List<Map<String,String>> list = loyRlActivityService.getActivityInfo(queryModel);
		return new ResultDto<List<Map<String,String>>>(list);
	}
    /**
    * @方法名称:getActiveForm
    * @方法描述:根据节点id查询活动
    * @参数与返回说明:
    * @算法描述:
     */
    @GetMapping("/getactiveform")
	public ResultDto<LoyRlActivity> getActiveForm(@RequestParam(required = false) String nodeId) {
		return new ResultDto<LoyRlActivity>(loyRlActivityService.getActiveForm(nodeId));
	}
    
    /**
    * @方法名称:getEventInfo
    * @方法描述:判断优先级是否重复
    * @参数与返回说明:
    * @算法描述:
     */
    @GetMapping("/prioritylist")
	public ResultDto<List<Map<String,String>>> priorityList(QueryModel queryModel) {
		List<Map<String,String>> list = loyRlActivityService.priorityList(queryModel);
		return new ResultDto<List<Map<String,String>>>(list);
	}
    /**
    * @方法名称:deleteBatch
    * @方法描述:根据活动id删除活动信息
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/deletebatch")
    public ResultDto<Integer> deleteBatch(@RequestBody Map<?,?> map) {
    	String[] idStr=map.get("id").toString().split(",");
    	String orgCode = map.get("orgCode").toString();
        return new ResultDto<Integer>(loyRlActivityService.deleteBatch(idStr,orgCode));
    }
    /**
    * @方法名称:deleteBatchRuleInfo
    * @方法描述:根据活动id删除活动信息，同时也删除规则表
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/deletebatchruleinfo")
    public ResultDto<Integer> deleteBatchRuleInfo(@RequestBody Map<?,?> map) {
    	String[] idStr=map.get("id").toString().split(",");
        return new ResultDto<Integer>(loyRlActivityService.deleteBatchRuleInfo(idStr));
    }
    /**
     * 
    * @方法名称: useBatch
    * @方法描述: 批量启用
    * @参数与返回说明: 
    * @算法描述:
     */
    @PostMapping("/usebatch")
    public ResultDto<Integer> useBatch(@RequestBody Map<?,?> parmas) {
    	String[] idStr = parmas.get("id").toString().split(",");
    	String orgCode = parmas.get("orgCode").toString();
        return new ResultDto<Integer>(loyRlActivityService.useIngFn(idStr,orgCode));
    }

    /**
     * 
    * @方法名称: unUseBatch
    * @方法描述: 批量停用
    * @参数与返回说明: 
    * @算法描述:
     */
    @PostMapping("/unusebatch")
    public ResultDto<Integer> unUseBatch(@RequestBody Map<?,?> parmas) {
        String[] idStr = parmas.get("id").toString().split(",");
        String orgCode = parmas.get("orgCode").toString();
        return new ResultDto<Integer>(loyRlActivityService.unUseIngFn(idStr,orgCode));
    }
    /**
    * @方法名称:updateSts
    * @方法描述:提交后的状态
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/updatests")
    public ResultDto<Integer> updateSts(@RequestBody LoyRlActivity lp) {
        return new ResultDto<Integer>(loyRlActivityService.updateSts(lp));
    }
}
