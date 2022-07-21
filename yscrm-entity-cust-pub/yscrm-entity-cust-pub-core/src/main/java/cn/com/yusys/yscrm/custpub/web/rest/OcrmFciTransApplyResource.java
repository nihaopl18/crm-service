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
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTransApply;
import cn.com.yusys.yscrm.custpub.service.OcrmFciTransApplyService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciTransApplyResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-15 10:38:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcitransapply")
public class OcrmFciTransApplyResource extends CommonResource<OcrmFciTransApply, String> {
    @Autowired
    private OcrmFciTransApplyService ocrmFciTransApplyService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciTransApplyService;
    }
    /**
	* @方法名称: getListByModel
	* @方法描述: 查询移交客户历史信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/list")
    public ResultDto<List<Map<String, String>>> getListByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFciTransApplyService.getListByModel(model));
    	
    }
    /**
	* @方法名称: myCustListByModel
	* @方法描述: 查询管户客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/mycustlist")
    public ResultDto<List<Map<String, String>>> myCustListByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFciTransApplyService.myCustListByModel(model));
    	
    }
    @PostMapping("/getUsersNode")
    public ResultDto<List<Map<String, String>>> getUsersNode(@RequestBody Map<String, String> map){
		return new ResultDto<List<Map<String, String>>>(ocrmFciTransApplyService.getUsersNode(map.get("applyNo")));
    	
    }
    @GetMapping("/mycustmgr")
    public ResultDto<List<Map<String, String>>> mycustmgrByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFciTransApplyService.mycustmgrByModel(model));
    	
    }
    /**
	* @方法名称: CustListByModel
	* @方法描述: 查询行内非管户客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/innercustlist")
    public ResultDto<List<Map<String, String>>> InnerCustListByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFciTransApplyService.InnerCustListByModel(model));
    	
    }
    /**
	* @方法名称: CustListByModel
	* @方法描述: 查询行外非管户客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/outercustlist")
    public ResultDto<List<Map<String, String>>> OuterCustListByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFciTransApplyService.OuterCustListByModel(model));
    	
    }
    /**
	* @方法名称: addActive
	* @方法描述: 主动移交
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/addactive")
    public ResultDto<Map<String, String>> addActive(@RequestBody Map<String, String> map){
    	String uuid = ocrmFciTransApplyService.addActive(map);
    	Map<String, String> mapuuid = new HashMap<>();
		mapuuid.put("uuid", uuid);
		if (!uuid.equals("")) {
			return new ResultDto<>(mapuuid);
		}
		return null;
    }
    @PostMapping("/getUuid")
    public ResultDto<Map<String, String>> getUuid(@RequestBody Map<String, String> map){
//    	String uuid = ocrmFciTransApplyService.addActive(map);
    	Map<String, String> mapuuid = new HashMap<>();
		mapuuid.put("uuid", UtilTools.getUUID());
		return new ResultDto<>(mapuuid);
    }
    /**
	* @方法名称: addPassive
	* @方法描述: 被动移交
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/addpassive")
    public ResultDto<Map<String, String>> addPassive(@RequestBody Map<String, String> map){
    	String uuid = ocrmFciTransApplyService.addPassive(map);
    	Map<String, String> mapuuid = new HashMap<>();
		mapuuid.put("uuid", uuid);
		if (!uuid.equals("")) {
			return new ResultDto<>(mapuuid);
		}
		return null;
    }
    /**
	* @方法名称: transferInfo
	* @方法描述: 查询移交信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/transferinfo")
    public ResultDto<List<Map<String, String>>> transferInfo(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFciTransApplyService.transferInfo(model));
    	
    }
    /**
	* @方法名称: updTransferApproval
	* @方法描述: 修改移交审批状态
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/transferapproval")
    public ResultDto<Integer> updTransferApproval(@RequestBody QueryModel model){
		return new ResultDto<Integer>(ocrmFciTransApplyService.updTransferApproval(model));
    	
    }
    
    /**
	* @方法名称: isLevel
	* @方法描述: 判断是否同一机构
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/islevel")
    public ResultDto<Integer> isLevel(@RequestBody Map<String, String> map){
		return new ResultDto<Integer>(ocrmFciTransApplyService.isLevel(map));
    }
    @PostMapping("/belongOrgId")
    public ResultDto<Map<String,String>> belongOrgId(@RequestBody Map<String, String> map){
		return new ResultDto<Map<String,String>>(ocrmFciTransApplyService.belongOrgId(map));
    }
    @PostMapping("/getbelongOrgId")
    public ResultDto<Map<String,String>> getbelongOrgId(@RequestBody Map<String, String> map){
		return new ResultDto<Map<String,String>>(ocrmFciTransApplyService.getbelongOrgId(map));
    }
}
