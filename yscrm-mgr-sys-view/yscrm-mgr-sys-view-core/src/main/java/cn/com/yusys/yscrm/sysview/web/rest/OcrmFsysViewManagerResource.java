package cn.com.yusys.yscrm.sysview.web.rest;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewManager;
import cn.com.yusys.yscrm.sysview.service.OcrmFsysViewManagerService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewManagerResource
 * @类描述: 视图树
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysviewmanager")
public class OcrmFsysViewManagerResource extends CommonResource<OcrmFsysViewManager, String> {
    @Autowired
    private OcrmFsysViewManagerService ocrmFsysViewManagerService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFsysViewManagerService;
    }
    /**
	 * @方法名称: getSysViewTree
	 * @方法描述: 查询视图树
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getsysviewTree")
    public ResultDto<List<Map<String, Object>>> getSysViewTree(@RequestParam String sysId) {
        List<Map<String, Object>> list = ocrmFsysViewManagerService.getSysViewTree(sysId);
        return new ResultDto<List<Map<String, Object>>>(list);
    }
	
	/**
     * @方法名称:getViewInfo
     * @方法描述:节点信息查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/viewinfoquery")
    public ResultDto<Map<String, Object>> getViewInfo(@RequestParam String id) {
        return new ResultDto<Map<String, Object>>(ocrmFsysViewManagerService.getViewInfo(id));
    }
    
	/**
     * @方法名称: createView
     * @方法描述: 新增视图树
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/createview")
    public ResultDto<OcrmFsysViewManager> createView(@RequestBody OcrmFsysViewManager ocrmFsysViewManager) {
        ocrmFsysViewManager = this.ocrmFsysViewManagerService.createView(ocrmFsysViewManager);
		return new ResultDto<OcrmFsysViewManager>(ocrmFsysViewManager);
    }

    /**
     * @方法名称: editView
     * @方法描述: 修改视图树
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/editview")
    public ResultDto<OcrmFsysViewManager> editView(@RequestBody OcrmFsysViewManager ocrmFsysViewManager) {
        ocrmFsysViewManager = this.ocrmFsysViewManagerService.editView(ocrmFsysViewManager);
		return new ResultDto<OcrmFsysViewManager>(ocrmFsysViewManager);
    }

    /**
     * @方法名称: deleteView
     * @方法描述: 删除视图树
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deleteview")
    public ResultDto<Integer> deleteView(@RequestBody String id) {
        int result = this.ocrmFsysViewManagerService.deleteView(id);
        return new ResultDto<Integer>(result);
    }

    /**
     * @方法名称: getListInfo
     * @方法描述: 视图项列表查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/listquery")
    public ResultDto<List<Map<String, Object>>> getListInfo(QueryModel queryModel) {
        List<Map<String, Object>> list = ocrmFsysViewManagerService.getListInfo(queryModel);
        return new ResultDto<List<Map<String, Object>>>(list);
    }
}
