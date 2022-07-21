package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeOrgRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeOrgRelService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeOrgRelResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 18:13:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafschemeorgrel")
public class PmaFSchemeOrgRelResource extends CommonResource<PmaFSchemeOrgRel, String> {
    @Autowired
    private PmaFSchemeOrgRelService pmaFSchemeOrgRelService;

    @Override
    protected CommonService getCommonService() {
        return pmaFSchemeOrgRelService;
    }
	/**
	 * @throws Exception 
	 * @方法名称: queryOrg
	 * @方法描述: 查询机构数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询机构数据(分页)", notes = "查询机构数据(分页)")
	@GetMapping("/queryOrg")
	public ResultDto<List<Map<String, Object>>> queryOrg(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeOrgRelService.queryOrg(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	@ApiOperation(value = "查询机构数据(分页)", notes = "查询机构数据(分页)")
	@GetMapping("/queryOrgList")
	public ResultDto<List<Map<String, Object>>> queryOrgList(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeOrgRelService.queryOrgList(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}
