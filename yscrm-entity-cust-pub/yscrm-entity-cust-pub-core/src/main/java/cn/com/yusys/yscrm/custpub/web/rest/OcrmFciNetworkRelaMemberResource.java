package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciNetworkRelaMember;
import cn.com.yusys.yscrm.custpub.service.OcrmFciNetworkRelaMemberService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNetworkRelaMemberResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:23:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcinetworkrelamember")
public class OcrmFciNetworkRelaMemberResource extends CommonResource<OcrmFciNetworkRelaMember, String> {
    @Autowired
    private OcrmFciNetworkRelaMemberService ocrmFciNetworkRelaMemberService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciNetworkRelaMemberService;
    }
    
    @GetMapping("/list")
    public ResultDto<List<Map<String, Object>>> getList(String netId){
    	return new ResultDto<List<Map<String, Object>>>(ocrmFciNetworkRelaMemberService.getList(netId));
    }
   
}
