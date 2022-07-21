package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import javassist.expr.NewArray;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciLatentApply;
import cn.com.yusys.yscrm.custpub.service.OcrmFciLatentApplyService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciLatentApplyResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-14 19:50:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcilatentapply")
public class OcrmFciLatentApplyResource extends CommonResource<OcrmFciLatentApply, String> {
    @Autowired
    private OcrmFciLatentApplyService ocrmFciLatentApplyService;

    @Override
    protected CommonService getCommonService() {
        return this.ocrmFciLatentApplyService;
    }
    /**
	* @方法名称: getListByModel
	* @方法描述: 查询认领客户历史信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/list")
	public ResultDto<List<Map<String, String>>> getListByModel(QueryModel model){
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<>(ocrmFciLatentApplyService.getListByModel(model));
		return resultDto;
		
	}
    /**
	* @方法名称: potNoForList
	* @方法描述: 查询认领潜在行外客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@GetMapping("/potnoforlist")
	public ResultDto<List<Map<String, String>>> potNoForList(QueryModel model){
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<>(ocrmFciLatentApplyService.potNoForList(model));
		return resultDto;
		
	}
	 /**
		* @方法名称: noPotNoforList
		* @方法描述: 查询认领正式行外客户
		* @参数与返回说明: 
		* @算法描述: 
		*/
	@GetMapping("/nopotnoforlist")
	public ResultDto<List<Map<String, String>>> noPotNoForList(QueryModel model){
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<>(ocrmFciLatentApplyService.noPotNoForList(model));
		return resultDto;
	}
	/**
	* @方法名称: potForList
	* @方法描述: 查询认领潜在行内在客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@GetMapping("/potforlist")
	public ResultDto<List<Map<String, String>>> potForList(QueryModel model){
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<>(ocrmFciLatentApplyService.potForList(model));
		return resultDto;
		
	}
	 /**
		* @方法名称: noPotNoforList
		* @方法描述: 查询认领行内正式客户
		* @参数与返回说明: 
		* @算法描述: 
		*/
	@GetMapping("/nopotforlist")
	public ResultDto<List<Map<String, String>>> noPotForList(QueryModel model){
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<>(ocrmFciLatentApplyService.noPotForList(model));
		return resultDto;
	}
	/**
	* @方法名称: addFor
	* @方法描述: 提交认领正式客户信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/addfor")
	public ResultDto<Map<String, String>> addFor(@RequestBody Map<String, String> map){
		
		String uuid = ocrmFciLatentApplyService.addFor(map);
		Map<String, String> mapuuid = new HashMap<>();
		mapuuid.put("uuid", uuid);
		if (!uuid.equals("")) {
			return new ResultDto<>(mapuuid);
		}
		return null;
	}
	/**
	* @方法名称: addAdmit
	* @方法描述: 提交认领准入客户信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/addadmit")
	public ResultDto<Map<String, String>> addAdmit(@RequestBody Map<String, String> map){
		
		String uuid = ocrmFciLatentApplyService.addAdmit(map);
		Map<String, String> mapuuid = new HashMap<>();
		mapuuid.put("uuid", uuid);
		if (!uuid.equals("")) {
			return new ResultDto<>(mapuuid);
		}
		return null;
	}
	/**
	* @方法名称: addNoAdmit
	* @方法描述: 提交认领非准入客户信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/addnoadmit")
	public ResultDto<Map<String, String>> addNoAdmit(@RequestBody Map<String, String> map){
		
		String uuid = ocrmFciLatentApplyService.addNoAdmit(map);
		Map<String, String> mapuuid = new HashMap<>();
		mapuuid.put("uuid", uuid);
		if (!uuid.equals("")) {
			return new ResultDto<>(mapuuid);
		}
		return null;
	}
	/**
	* @方法名称: addNoFor
	* @方法描述: 提交认领非正式客户信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/addnofor")
	public ResultDto<Map<String, String>> addNoFor(@RequestBody Map<String, String> map){
		String uuid = ocrmFciLatentApplyService.addNoFor(map);
		Map<String, String> mapuuid = new HashMap<>();
		mapuuid.put("uuid", uuid);
		if (!uuid.equals("")) {
			return new ResultDto<>(mapuuid);
		}
		return null;
	}
	/**
	* @方法名称: claimInfo
	* @方法描述: 认领信息查询
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/claiminfo")
	public ResultDto<List<Map<String, String>>> getClaimInfo(QueryModel model){
		ResultDto<List<Map<String, String>>> resultDto = new ResultDto<>(ocrmFciLatentApplyService.getClaimInfo(model));
		return resultDto;
		
	}
	/**
	* @方法名称: updClaimApproval
	* @方法描述: 修改认领审批状态
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/claimapproval")
	public ResultDto<Integer> updClaimApproval(@RequestBody QueryModel model){
		ResultDto<Integer> resultDto = new ResultDto<>(ocrmFciLatentApplyService.updClaimApproval(model));
		return resultDto;
		
	}
	
}
