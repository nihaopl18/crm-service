package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseAutoSearchConf;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseAutoSearchConfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearchConfResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Api(tags = "通用查询配置")
@RestController
@RequestMapping("/api/adminbaseautosearchconf")
public class AdminBaseAutoSearchConfResource extends CommonResource<AdminBaseAutoSearchConf, String> {
	
    @Autowired
    private AdminBaseAutoSearchConfService adminBaseAutoSearchConfService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseAutoSearchConfService;
    }
    
    /**
     * 自动配置拼装SQL,查询项,列表
     * @param seacherId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "自动配置拼装SQL,查询项,列表", notes = "自动配置拼装SQL,查询项,列表")
    @GetMapping("/autoconf/{seacherId}")
    public ResultDto<Object> autoconf(@PathVariable String seacherId) throws Exception {
        return new ResultDto<>(this.adminBaseAutoSearchConfService.autoconfig(seacherId));
    }

    /**
     * @方法名称: querylist
     * @方法描述: 查询列表数据(分页)
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "公共查询列表分页", notes = "公共查询列表分页")
    @GetMapping("/querylist1/{seacherId}")
    public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) {
        List<Map<String, Object>> list = this.adminBaseAutoSearchConfService.querylist(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     *
     * @param queryModel
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping({"/export"})
    public void export(QueryModel queryModel, HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.adminBaseAutoSearchConfService.export(queryModel, request, response);
    }

    /**
     * @方法名称: saveorupdate
     * @方法描述: 新增配置信息
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "新增自动查询配置信息", notes = "新增自动查询配置信息,新增时主键字段id设置为null")
    @PostMapping("/saveorupdate")
    public ResultDto<Object> saveorupdate(@RequestBody List<AdminBaseAutoSearchConf> list) throws Exception {
        return this.adminBaseAutoSearchConfService.saveorupdate(list);
    }

    

    /**
     * @方法名称: quertLastOrg
     * @方法描述:查询当前机构是否是最后一个机构
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "查询当前机构是否是最后一个机构", notes = "查询当前机构是否是最后一个机构")
    @GetMapping("/quertLastOrg/{orgCode}")
    public ResultDto<Object> quertLastOrg(@PathVariable String orgCode) throws Exception {
        return this.adminBaseAutoSearchConfService.queryLastOrg(orgCode);
    }
    
    /**
     * @方法名称: syncField
     * @方法描述: 同步字段
     * @参数与返回说明:
     * @算法描述:
     */
    @ApiOperation(value = "同步字段", notes = "同步字段")
    @PostMapping("/syncfield")
    public ResultDto<Object> syncField(@RequestParam(name = "tableName", defaultValue = "0") String tableName, @RequestParam(name = "seacherId", defaultValue = "0")String seacherId){
    	return this.adminBaseAutoSearchConfService.syncField(tableName,seacherId);
    }
}
