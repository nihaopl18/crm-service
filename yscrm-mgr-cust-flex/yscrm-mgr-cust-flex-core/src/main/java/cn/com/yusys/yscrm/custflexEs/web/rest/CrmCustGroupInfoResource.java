package cn.com.yusys.yscrm.custflexEs.web.rest;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustGroupInfo;
import cn.com.yusys.yscrm.custflexEs.service.CrmCustGroupInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustGroupInfoResource
 * @类描述: #客户群信息表 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-08 11:13:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Api(tags = "客户群信息")
@RestController
@RequestMapping("/api/crmcustgroupinfo")
public class CrmCustGroupInfoResource extends CommonResource<CrmCustGroupInfo, String> {
	
	private static final Logger log = LoggerFactory.getLogger(CrmCustGroupInfoResource.class);
	
    @Autowired
    private CrmCustGroupInfoService crmCustGroupInfoService;

    @Override
    protected CommonService getCommonService() {
        return crmCustGroupInfoService;
    }

    /**
     * @函数名称:queryList
     * @函数描述:客户群列表查询
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "客户群列表查询", notes = "查询本人创建的客户群信息，用于客户群查询页面")
    @GetMapping("/querylist")
	protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = crmCustGroupInfoService.queryList(queryModel);
			if (list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("查询异常");
			log.error("query custGroupInfo data error", e);
		}
		return result;
	}
	
//	/**
//     * @函数名称: upsertCustGroupInfo
//     * @函数描述: 维护客户群信息
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	@ApiOperation(value = "维护客户群信息", notes = "维护客户群基础信息，用于客户群查询页面")
//    @PostMapping("/upsertcustgroupinfo")
//    protected ResultDto<String> upsertCustGroupInfo(@RequestBody CrmCustGroupInfo obj) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	try {
//    		String id = crmCustGroupInfoService.upsertCustGroupInfo(obj);
//			result.setCode(0);
//			result.setMessage("执行成功");
//			result.setData(id);
//    	} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("执行异常");
//			log.error("upsertCustGroupInfo data error", e);
//    	}
//        return result;
//    }
	
	/**
     * @函数名称: deleteCustGroupInfo
     * @函数描述: 删除客户群
     * @参数与返回说明:
     * @算法描述:
     */
//	@ApiOperation(value = "删除客户群", notes = "单个删除本人创建的客户群，当前日期早于活动引入终止日期不允许删除")
//    @PostMapping("/deletecustgroupinfo")
//    protected ResultDto<String> deleteCustGroupInfo(@RequestBody String groupId) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	try {
//    		String id = crmCustGroupInfoService.deleteCustGroupInfo(groupId);
//    		if("-1".equals(id)) {
//    			result.setCode(-1);
//    			result.setMessage("客户群编号为空或不存在，不能删除");
//    		} else if("-2".equals(id)) {
//    			result.setCode(-2);
//    			result.setMessage("不能删除非本人创建的客户群");
//    		} else if("-3".equals(id)) {
//    			result.setCode(-3);
//    			result.setMessage("不能删除活动引入终止日期前的客户群");
//    		} else if(StringUtil.isNotEmpty(id)) {
//    			result.setCode(0);
//    			result.setMessage("执行成功");
//    			result.setData(id);
//    		}
//    	} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("执行异常");
//			log.error("deleteCustGroupInfo data error", e);
//    	}
//        return result;
//    }
	
    /**
     * @函数名称:queryGroupMember
     * @函数描述:客户群成员列表查询
     * @参数与返回说明:
     * @算法描述:
     */
//	@ApiOperation(value = "客户群成员列表查询", notes = "分页查询客户群成员信息")
//    @GetMapping("/querygroupmember")
//	protected ResultDto<List<Map<String, Object>>> queryGroupMember(QueryModel queryModel) {
//		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
//		try {
//			List<Map<String, Object>> list = crmCustGroupInfoService.queryGroupMember(queryModel);
//			if (list.size() > 0) {
//				return new ResultDto<List<Map<String, Object>>>(list);
//			} else {
//				result.setCode(-1);
//				result.setMessage("未查到数据！");
//			}
//		} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("查询异常");
//			log.error("query custGroupMember data error", e);
//		}
//		return result;
//	}
	
//	/**
//     * @函数名称: addCustsToGroup
//     * @函数描述: 添加客户到自定义客户群
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	@ApiOperation(value = "添加客户到自定义客户群", notes = "添加客户到自定义客户群，支持多客户操作")
//    @PostMapping("/addcuststogroup")
//    protected ResultDto<String> addCustsToGroup(@RequestBody CustGroupInfoModel model) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	try {
//    		String id = crmCustGroupInfoService.addCustsToGroup(model);
//    		if("-1".equals(id)) {
//    			result.setCode(-1);
//    			result.setMessage("参数为空或客户群编号不存在，不允许操作");
//    		} else if("-2".equals(id)) {
//    			result.setCode(-2);
//    			result.setMessage("非自定义客户群不允许添加客户");
//    		} else if(StringUtil.isNotEmpty(id)) {
//    			result.setCode(0);
//    			result.setMessage("执行成功");
//    			result.setData(id);
//    		}
//    	} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("执行异常");
//			log.error("addCustsToGroup data error", e);
//    	}
//        return result;
//    }
	
//	/**
//     * @函数名称: removeCustsFromGroup
//     * @函数描述: 从客户群成员中删除客户
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	@ApiOperation(value = "从客户群成员中删除客户", notes = "从客户群成员中删除客户，支持多客户操作")
//    @PostMapping("/removecustsfromgroup")
//    protected ResultDto<String> removeCustsFromGroup(@RequestBody CustGroupInfoModel model) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	try {
//    		String id = crmCustGroupInfoService.removeCustsFromGroup(model);
//    		if("-1".equals(id)) {
//    			result.setCode(-1);
//    			result.setMessage("参数为空或客户群编号不存在，不允许操作");
//    		} else if("-2".equals(id)) {
//    			result.setCode(-2);
//    			result.setMessage("非自定义客户群不允许删除客户");
//    		} else if(StringUtil.isNotEmpty(id)) {
//    			result.setCode(0);
//    			result.setMessage("执行成功");
//    			result.setData(id);
//    		}
//    	} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("执行异常");
//			log.error("removeCustsFromGroup data error", e);
//    	}
//        return result;
//    }
	
//	/**
//     * @函数名称:queryGroupRuleInfoByGroupId
//     * @函数描述:查询规则客户群-查询规则信息
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	@ApiOperation(value = "查询规则客户群-查询规则信息", notes = "查询规则客户群-查询规则信息")
//	@GetMapping("/querygroupruleinfobygroupid")
//	public ResultDto<List<Map<String, Object>>> queryGroupRuleInfoByGroupId(@RequestParam("groupId") String groupId) {
//		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
//		try {
//			List<Map<String, Object>> list = crmCustGroupInfoService.queryGroupRuleInfoByGroupId(groupId);
//			if (list != null && list.size() > 0) {
//				return new ResultDto<List<Map<String, Object>>>(list);
//			} else {
//				result.setCode(-1);
//				result.setMessage("未查到数据");
//			}
//		} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("查询异常");
//			log.error("query group-rule info error", e);
//		}
//		return result;
//	}
	
//	/**
//     * @函数名称: upsertGroupRuleInfo
//     * @函数描述: 维护规则客户群-查询规则信息
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	@ApiOperation(value = "维护规则客户群-查询规则信息", notes = "维护规则客户群-查询规则信息")
//    @PostMapping("/upsertgroupruleinfo")
//    protected ResultDto<String> upsertGroupRuleInfo(@RequestBody CustGroupInfoModel model) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	try {
//    		String id = crmCustGroupInfoService.upsertGroupRuleInfo(model);
//    		if("-1".equals(id)) {
//    			result.setCode(-1);
//    			result.setMessage("参数为空或客户群编号不存在，不允许操作");
//    		} else if("-2".equals(id)) {
//    			result.setCode(-2);
//    			result.setMessage("非规则客户群不允许维护查询规则信息");
//    		} else if(StringUtil.isNotEmpty(id)) {
//    			result.setCode(0);
//    			result.setMessage("执行成功");
//    			result.setData(id);
//    		}
//    	} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("执行异常");
//			log.error("upsertGroupRuleInfo data error", e);
//    	}
//        return result;
//    }
	
//    /**
//     * @函数名称:queryToJoinCustGroupList
//     * @函数描述:待加入客户群列表查询
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	@ApiOperation(value = "待加入客户群列表查询", notes = "客户群放大镜-分页查询待加入客户群信息")
//    @GetMapping("/querytojoincustgrouplist")
//	protected ResultDto<List<Map<String, Object>>> queryToJoinCustGroupList(QueryModel queryModel) {
//		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
//		try {
//			List<Map<String, Object>> list = crmCustGroupInfoService.queryToJoinCustGroupList(queryModel);
//			if (list != null && list.size() > 0) {
//				return new ResultDto<List<Map<String, Object>>>(list);
//			} else {
//				result.setCode(-1);
//				result.setMessage("未查到数据！");
//			}
//		} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("查询异常");
//			log.error("query toJoinCustGroup data error", e);
//		}
//		return result;
//	}
	
//	/**
//     * @函数名称: addCustsToGroupApply
//     * @函数描述: 客户加入客户群申请
//     * @参数与返回说明:
//     * @算法描述:
//     */
//	@ApiOperation(value = "客户加入客户群申请", notes = "根据是否入群审批，处理多客户入群申请信息")
//    @PostMapping("/addcuststogroupapply")
//    protected ResultDto<String> addCustsToGroupApply(@RequestBody CustGroupInfoModel model) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	try {
//    		String id = crmCustGroupInfoService.addCustsToGroupApply(model);
//    		if("-1".equals(id)) {
//    			result.setCode(-1);
//    			result.setMessage("参数为空，不允许操作");
//    		} else if("-2".equals(id)) {
//    			result.setCode(-2);
//    			result.setMessage("客户群编号不存在或非自定义客户群，不允许操作");
//    		} else if("-3".equals(id)) {
//    			result.setCode(-3);
//    			result.setMessage("非共享型客户群，不允许操作");
//    		} else if("1".equals(id)) {
//    			result.setCode(0);
//    			result.setMessage("已将客户加入到客户群中");
//    		} else if("2".equals(id)) {
//    			result.setCode(0);
//    			result.setMessage("已增加客户入群数据，待审批");
//    		}
//    	} catch (Exception e) {
//			result.setCode(-9);
//			result.setMessage("执行异常");
//			log.error("addCustsToGroupApply error", e);
//    	}
//        return result;
//    }
}
