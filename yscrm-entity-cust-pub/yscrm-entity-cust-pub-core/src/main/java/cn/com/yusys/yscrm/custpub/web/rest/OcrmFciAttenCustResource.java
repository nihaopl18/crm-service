package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.ArrayList;
import java.util.Arrays;
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
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciAttenCust;
import cn.com.yusys.yscrm.custpub.service.OcrmFciAttenCustService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciAttenCustResource
 * @类描述: 关注客户
 * @功能描述: 关注客户查询，设置关注用户，取消关注用户
 * @创建人: hyx
 * @创建时间: 2019-01-28 17:25:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfciattencust")
public class OcrmFciAttenCustResource extends CommonResource<OcrmFciAttenCust, String> {
    @Autowired
    private OcrmFciAttenCustService ocrmFciAttenCustService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciAttenCustService;
    }
    
    /**
	* @方法名称: list
	* @方法描述: 查询当前用户关注的客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/list")
    public ResultDto<List<Map<String, String>>> getListByModel(QueryModel model){
    	
		return new ResultDto<List<Map<String, String>>>(ocrmFciAttenCustService.getListByModel(model));
    	
    }
    /**
	* @方法名称: join
	* @方法描述: 查询当前用户关注的客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/join")
    public ResultDto<Integer> join(@RequestBody QueryModel model){
    	String[] custIds = ((String)model.getCondition().get("custIds")).split(",");
    	String attentType = (String) model.getCondition().get("attentType");
    	String userId = (String) model.getCondition().get("userId");
    	List<String> lists = Arrays.asList(custIds);
    	List<AcrmFciCustAdmitAll> acrmFciCustAdmitAlls = ocrmFciAttenCustService.getCustsById(lists);
    	ResultDto<Integer> resultDto = new ResultDto<Integer>(ocrmFciAttenCustService.join(acrmFciCustAdmitAlls,attentType,userId));
    	resultDto.setCode(0);
    	resultDto.setMessage("操作成功");
		return resultDto;
    	
    }
    
    /**
	* @方法名称: out
	* @方法描述: 查询当前用户关注的客户
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/out")
    public ResultDto<Integer> out(@RequestBody QueryModel model){
    	String ids = (String) model.getCondition().get("attenId");
    	ResultDto<Integer> resultDto = new ResultDto<>(ocrmFciAttenCustService.deleteByIds(ids));
    	resultDto.setCode(0);
    	resultDto.setMessage("移除成功");
    	return resultDto;
    	
    }
    

}
