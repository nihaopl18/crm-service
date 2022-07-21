package cn.com.yusys.yscrm.entity.cust.org.group.web.rest;

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
import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroup;
import cn.com.yusys.yscrm.entity.cust.org.group.service.OcrmFciGroupService;

/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:12:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcigroup")
public class OcrmFciGroupResource extends CommonResource<OcrmFciGroup, String> {
    @Autowired
    private OcrmFciGroupService ocrmFciGroupService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciGroupService;
    }
    @GetMapping("/list")
    public ResultDto<List<Map<String, String>>> getListByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFciGroupService.getListByModel(model));
    	
    }
    @GetMapping("/groupinfo")
    public ResultDto<OcrmFciGroup> getGroupInfoByGroupNo(String groupNo){
		return new ResultDto<OcrmFciGroup>(ocrmFciGroupService.getGroupInfoByGroupNo(groupNo));
    	
    }

}
