package cn.com.yusys.yscrm.sysview.web.rest;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysView;
import cn.com.yusys.yscrm.sysview.service.OcrmFsysViewService;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewResource
 * @类描述: 视图
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-16 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysview")
public class OcrmFsysViewResource extends CommonResource<OcrmFsysView, String> {
    @Autowired
    private OcrmFsysViewService ocrmFsysViewService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFsysViewService;
    }

    /**
	 * @方法名称: getViewlist
	 * @方法描述: 查询视图信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getviewlist")
	public ResultDto<List<Map<String, Object>>> getViewlist(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFsysViewService.getViewlist(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: createView
	 * @方法描述: 新增视图信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/createview")
	public ResultDto<OcrmFsysView> createView(@RequestBody OcrmFsysView ocrmFsysView) {
		ocrmFsysView = this.ocrmFsysViewService.createView(ocrmFsysView);
		return new ResultDto<OcrmFsysView>(ocrmFsysView);
	}

	/**
	 * @方法名称: editView
	 * @方法描述: 修改视图信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/editview")
	public ResultDto<OcrmFsysView> editView(@RequestBody OcrmFsysView ocrmFsysView) {
		ocrmFsysView = this.ocrmFsysViewService.editView(ocrmFsysView);
		return new ResultDto<OcrmFsysView>(ocrmFsysView);
	}

    /**
     * @方法名称: deleteView
     * @方法描述: 删除视图信息
     * @参数与返回说明:
     * @算法描述:
     */
	@PostMapping("/deleteview")
    public ResultDto<Integer> deleteView(@RequestBody String viewId){
        int n= ocrmFsysViewService.deleteView(viewId);
        return new ResultDto<Integer>(n);
    }

	/**
	 * @方法名称: checkName
	 * @方法描述: 保存数据前查询视图名称是否已经存在
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/checkname")
	public ResultDto<List<Map<String,Object>>> checkName(@RequestParam(required = false) String viewName,@RequestParam(required = false) String viewId){
		List<Map<String,Object>> result = ocrmFsysViewService.checkName(viewName,viewId);
		return new ResultDto<List<Map<String,Object>>>(result);
	}
}
