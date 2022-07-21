package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseAutoSearch;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseAutoSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearchResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "通用查询信息")
@RequestMapping("/api/adminbaseautosearch")
public class AdminBaseAutoSearchResource extends CommonResource<AdminBaseAutoSearch, String> {
	
    @Autowired
    private AdminBaseAutoSearchService adminBaseAutoSearchService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseAutoSearchService;
    }
    
    /**
     * @方法名称: querylist
     * @方法描述: 查询列表数据(分页)
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "查询自动配置列表分页", notes = "查询自动配置列表分页")
    @GetMapping("/querylist")
    public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) {
        List<Map<String, Object>> list = this.adminBaseAutoSearchService.querylist(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     * @方法名称: queryconflist
     * @方法描述: 查询表配置信息
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "查询表配置数据", notes = "查询表配置数据")
    @GetMapping("/queryconflist")
    public ResultDto<List<Map<String, Object>>> queryConflist(QueryModel model) {
        String tableName = model.getCondition().get("tableName").toString();
        String id = model.getCondition().get("id").toString();
        List<Map<String, Object>> list = this.adminBaseAutoSearchService.queryConflist(tableName, id);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     * @方法名称: queryTablelist
     * @方法描述: 查询当前用户下的表
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "查询当前用户下的表名备注名称", notes = "查询当前用户下的表名备注名称 去除了以 WF 和 ADMIN 开头的表")
    @GetMapping("/queryTablelist")
    public ResultDto<List<Map<String, Object>>> queryTablelist(QueryModel model) {
        List<Map<String, Object>> list = this.adminBaseAutoSearchService.queryTablelist(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     * @方法名称: queryDataCodelist
     * @方法描述: 查询数据字典
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "查询数据字典", notes = "查询数据字典")
    @GetMapping("/queryDataCodelist")
    public ResultDto<List<Map<String, Object>>> queryDataCodelist(QueryModel model) {
        List<Map<String, Object>> list = this.adminBaseAutoSearchService.queryDataCodeList(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     * @方法名称: saveorupdate
     * @方法描述: 新增或保存业务表自动查询信息
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "新增或保存表自动查询信息", notes = "新增或保存业务表自动查询信息,新增时主键字段id设置为null")
    @PostMapping("/saveorupdate")
    public ResultDto<Object> saveorupdate(@RequestBody AdminBaseAutoSearch adminBaseAutoSearch) throws Exception {
        return this.adminBaseAutoSearchService.saveorupdate(adminBaseAutoSearch);
    }

    /**
     * @方法名称: remove
     * @方法描述: 删除表自动生成查询信息
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "删除表自动生成查询信息", notes = "删除表自动生成查询信息")
    @PostMapping("/remove/{ids}")
    public ResultDto<Object> remove(@PathVariable String ids) throws Exception {
        return this.adminBaseAutoSearchService.remove(ids);
    }

    /**
     * @方法名称: updateFun
     * @方法描述: 生成功能点
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "生成功能点", notes = "生成功能点")
    @PostMapping("/updatefun")
    public ResultDto<Object> updateFun(@RequestParam(name = "id", defaultValue = "0") String id, @RequestParam(name = "confUrl", defaultValue = "0")String confUrl
            , @RequestParam(name = "funcName", defaultValue = "0") String funcName, @RequestParam(name = "funcDesc", defaultValue = "0") String funcDesc) throws Exception {
        return this.adminBaseAutoSearchService.updateFun(id, confUrl,funcName,funcDesc);
    }

}
