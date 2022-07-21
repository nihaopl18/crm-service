package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.web.rest;

import java.util.List;
import java.util.Map;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamMenu;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.service.PmaFParamMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamMenuResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 09:56:57
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "机构参数管理")
@RequestMapping("/api/pmafparammenu")
public class PmaFParamMenuResource extends CommonResource<PmaFParamMenu, String> {
    @Autowired
    private PmaFParamMenuService pmaFParamMenuService;

    @Override
    protected CommonService getCommonService() {
        return pmaFParamMenuService;
    }
    /**
  	 * @方法名称: querymenulist
  	 * @方法描述: 查询目录树数据
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "查询机构参数目录", notes = "查询机构参数目录")
  	@GetMapping("/querymenulist")
  	public ResultDto<List<Map<String, Object>>> querymenulist() {
  		List<Map<String, Object>> list = this.pmaFParamMenuService.querymenulist();
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
  	@ApiOperation(value = "新增参数目录", notes = "新增参数目录")
    @PostMapping("/add")
	public ResultDto<PmaFParamMenu> add(@RequestBody PmaFParamMenu pmaFParamMenu) throws Exception {
    	return pmaFParamMenuService.add(pmaFParamMenu);
    }
	@ApiOperation(value = "修改参数目录", notes = "修改参数目录")
    @PostMapping("/modify")
	public ResultDto<PmaFParamMenu> modify(@RequestBody PmaFParamMenu pmaFParamMenu) throws Exception {
    	return pmaFParamMenuService.modify(pmaFParamMenu);
    }
	@ApiOperation(value = "删除参数目录", notes = "删除参数目录")
    @PostMapping("/delete")
	public ResultDto<Integer> del(@RequestBody String id) {
    	return pmaFParamMenuService.delete(id);
    }
	/**
  	 * @方法名称: queryIsMenuCode
  	 * @方法描述: 查询当前节点是否子节点
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "查询当前节点是否子节点", notes = "查询当前节点是否子节点")
  	@GetMapping("/queryIsMenuCode")
  	public ResultDto<Map<String, Object>> queryIsMenuCode(@RequestParam String dirId) {
  		Map<String, Object> list = this.pmaFParamMenuService.queryIsMenuCode(dirId);
  		return new ResultDto<Map<String, Object>>(list);
  	}
}
