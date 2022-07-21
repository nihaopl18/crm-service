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
import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroupMember;
import cn.com.yusys.yscrm.entity.cust.org.group.service.OcrmFciGroupMemberService;

/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupMemberResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:12:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcigroupmember")
public class OcrmFciGroupMemberResource extends CommonResource<OcrmFciGroupMember, String> {
    @Autowired
    private OcrmFciGroupMemberService ocrmFciGroupMemberService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciGroupMemberService;
    }
    @GetMapping("/list")
    public ResultDto<List<Map<String, String>>> getListByModel(QueryModel model){
    	return new ResultDto<List<Map<String, String>>>(ocrmFciGroupMemberService.getListByModel(model));
    }
    @GetMapping("/groupinfo")
    public ResultDto<Map<String, String>> getGroupInfoByGroupNo(QueryModel model){
    	return new ResultDto<Map<String, String>>(ocrmFciGroupMemberService.getGroupInfoByGroupNo(model));
    }
}
