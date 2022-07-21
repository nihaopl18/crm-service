package cn.com.yusys.yscrm.cust.org.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.org.domain.OcrmFciOrgBondInfo;
import cn.com.yusys.yscrm.cust.org.service.OcrmFciOrgBondInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgBondInfoResource
 * @类描述: #资源类
 * @功能描述: 债券信息
 * @创建人: 15104
 * @创建时间: 2019-02-17 00:56:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfciorgbondinfo")
public class OcrmFciOrgBondInfoResource extends CommonResource<OcrmFciOrgBondInfo, String> {
    @Autowired
    private OcrmFciOrgBondInfoService ocrmFciOrgBondInfoService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciOrgBondInfoService;
    }

    /**
   	 * @方法名称: querylist
   	 * @方法描述: 查询
   	 * @param
   	 * @return
   	 */
   	@GetMapping("/querylist/{custId}")
   	public ResultDto<Object> querylist(QueryModel model, @PathVariable String custId) {
   		List<Map<Object, String>> baseInfo = ocrmFciOrgBondInfoService.querylist(model, custId);

   		return new ResultDto<Object>(baseInfo);
   	}

   	/**
   	 * @方法名称: ctrate
   	 * @方法描述: 新增
   	 * @param
   	 * @return
   	 */
   	@PostMapping("/ctrate")
   	public ResultDto<Object> ctrate(@RequestBody OcrmFciOrgBondInfo ocrmFciOrgBondInfo) {
   		int result = ocrmFciOrgBondInfoService.ctrate(ocrmFciOrgBondInfo);
   		return new ResultDto<Object>(result);
   	}

   	/**
   	 * @方法名称: modify
   	 * @方法描述: 修改
   	 * @param
   	 * @return
   	 */
   	@PostMapping("/modify")
   	public ResultDto<Object> modify(@RequestBody OcrmFciOrgBondInfo ocrmFciOrgBondInfo) {
   		int result = ocrmFciOrgBondInfoService.modify(ocrmFciOrgBondInfo);
   		return new ResultDto<Object>(result);
   	}

   	/**
   	 * @方法名称: delete
   	 * @方法描述: 删除
   	 * @param
   	 * @return
   	 */
	@PostMapping("/delete")
	public int delete(@RequestBody Map<String, String> map) {
		String bondId = map.get("bondId").toString();
		return ocrmFciOrgBondInfoService.deleteByBondId(bondId);
 	 }
	
}
