package cn.com.yusys.yscrm.sysview.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewItem;
import cn.com.yusys.yscrm.sysview.service.OcrmFsysViewItemService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewItemResource
 * @类描述: 视图项
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:47:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysviewitem")
public class OcrmFsysViewItemResource extends CommonResource<OcrmFsysViewItem, String> {
    @Autowired
    private OcrmFsysViewItemService ocrmFsysViewItemService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFsysViewItemService;
    }
    /**
	 * @方法名称: getViewItemlist
	 * @方法描述: 查询视图项信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getviewitemlist")
	public ResultDto<List<Map<String, Object>>> getViewItemlist(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFsysViewItemService.getViewItemlist(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: createViewItem
	 * @方法描述: 新增视图项信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/createviewitem")
	public ResultDto<OcrmFsysViewItem> createViewItem(@RequestBody OcrmFsysViewItem ocrmFsysViewItem) {
		ocrmFsysViewItem = this.ocrmFsysViewItemService.createViewItem(ocrmFsysViewItem);
		return new ResultDto<OcrmFsysViewItem>(ocrmFsysViewItem);
	}

	/**
	 * @方法名称: editViewItem
	 * @方法描述: 修改视图项信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/editviewitem")
	public ResultDto<OcrmFsysViewItem> editViewItem(@RequestBody OcrmFsysViewItem ocrmFsysViewItem) {
		ocrmFsysViewItem = this.ocrmFsysViewItemService.editViewItem(ocrmFsysViewItem);
		return new ResultDto<OcrmFsysViewItem>(ocrmFsysViewItem);
	}

    /**
     * @方法名称: deleteViewItem
     * @方法描述: 删除视图项信息
     * @参数与返回说明:
     * @算法描述:
     */
	@PostMapping("/deleteviewitem/{ids}")
    public ResultDto<Object> deleteViewItem(@PathVariable("ids") String ids){
        Map<String,Object> result=new HashMap<String, Object>();
        result= ocrmFsysViewItemService.deleteViewItem(ids);
        return new ResultDto<Object>(result);
    }

	/**
	 * @方法名称: checkName
	 * @方法描述: 保存数据前查询视图项名称是否已经存在
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/checkname")
	public ResultDto<List<Map<String,Object>>> checkName(@RequestParam(required = false) String viewItemName,@RequestParam(required = false) String id){
		List<Map<String,Object>> result = ocrmFsysViewItemService.checkName(viewItemName,id);
		return new ResultDto<List<Map<String,Object>>>(result);
	}
}
