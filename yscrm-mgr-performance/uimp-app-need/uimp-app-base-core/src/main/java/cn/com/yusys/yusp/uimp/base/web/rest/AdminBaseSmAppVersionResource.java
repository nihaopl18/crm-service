package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseSmAppVersion;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseSmAppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminBaseSmAppVersionResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-01-15 17:30:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/adminbasesmappversion")
public class AdminBaseSmAppVersionResource extends CommonResource<AdminBaseSmAppVersion, String> {
    @Autowired
    private AdminBaseSmAppVersionService adminBaseSmAppVersionService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseSmAppVersionService;
    }
    
    @GetMapping("/querylist")
    protected ResultDto<Object> queryList(QueryModel model){
    	List<Map<String,Object>> list = adminBaseSmAppVersionService.queryList(model);
    	return new ResultDto<Object>(list);
    }
    
    @GetMapping("/queryapk")
    protected ResultDto<Object> queryByApk(){
    	Map<String,Object> map = adminBaseSmAppVersionService.queryByApk();
    	return new ResultDto<Object>(map);
    }
    
    @PostMapping("/insert")
    protected ResultDto<String> insert(@RequestBody AdminBaseSmAppVersion adminBaseSmAppVersion) {
        String id = adminBaseSmAppVersionService.insert(adminBaseSmAppVersion);
        return new ResultDto<String>(id);
    }
    
    @PostMapping("/delete")
    protected ResultDto<Integer> delete(@RequestBody String id) {
    	Integer result = adminBaseSmAppVersionService.delete(id);
    	return new ResultDto<Integer>(result);
    }

}
