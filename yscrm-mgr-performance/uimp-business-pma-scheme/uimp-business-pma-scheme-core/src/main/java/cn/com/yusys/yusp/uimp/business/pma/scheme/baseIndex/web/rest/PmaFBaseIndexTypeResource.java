package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.web.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexType;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service.PmaFBaseIndexTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexTypeResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-02 16:29:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "基础指标目录管理")
@RequestMapping("/api/pmafbaseindextype")
public class PmaFBaseIndexTypeResource extends CommonResource<PmaFBaseIndexType, String> {
    @Autowired
    private PmaFBaseIndexTypeService pmaFBaseIndexTypeService;

    @Override
    protected CommonService getCommonService() {
        return pmaFBaseIndexTypeService;
    }
    /**
	 * @方法名称: querymenulist
	 * @方法描述: 查询目录树数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询基础指标目录", notes = "查询基础指标目录")
	@GetMapping("/querymenulist")
	public ResultDto<List<Map<String, Object>>> querymenulist() {
		List<Map<String, Object>> list = this.pmaFBaseIndexTypeService.querymenulist();
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	@ApiOperation(value = "新增基础指标目录", notes = "新增基础指标目录")
    @PostMapping("/add")
	public ResultDto<PmaFBaseIndexType> add(@RequestBody PmaFBaseIndexType pmaFBaseIndexType) throws Exception {
    	return pmaFBaseIndexTypeService.add(pmaFBaseIndexType);
    }
	@ApiOperation(value = "修改基础指标目录", notes = "修改基础指标目录")
    @PostMapping("/modify")
	public ResultDto<PmaFBaseIndexType> modify(@RequestBody PmaFBaseIndexType pmaFBaseIndexType) throws Exception {
    	return pmaFBaseIndexTypeService.modify(pmaFBaseIndexType);
    }
	@ApiOperation(value = "删除基础指标目录", notes = "删除基础指标目录")
    @PostMapping("/delete")
	public ResultDto<Integer> del(@RequestBody PmaFBaseIndexType pmaFBaseIndexType) {
    	return pmaFBaseIndexTypeService.delete(pmaFBaseIndexType);
    }
	@ApiOperation(value = "删除目录校验", notes = "删除目录校验")
	@GetMapping("/deletevaldate")
	public ResultDto<List<Map<String, Object>>> delval(@RequestParam String dirId) { 
		List<Map<String, Object>> list=	pmaFBaseIndexTypeService.delval(dirId);
		return new ResultDto<List<Map<String, Object>>>(list);
    }
}
