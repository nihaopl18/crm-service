package cn.com.yusys.yscrm.custpub.web.rest;

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
import cn.com.yusys.yscrm.custpub.domain.AcrmAbrBusiSum;
import cn.com.yusys.yscrm.custpub.service.AcrmAbrBusiSumService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmAbrBusiSumResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-28 10:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmabrbusisum")
public class AcrmAbrBusiSumResource extends CommonResource<AcrmAbrBusiSum, String> {
    @Autowired
    private AcrmAbrBusiSumService acrmAbrBusiSumService;

    @Override
    protected CommonService getCommonService() {
        return acrmAbrBusiSumService;
    }
    @GetMapping("/list")
    public ResultDto<List<Map<String, Object>>> getListByModel(QueryModel model){
		return new ResultDto<List<Map<String, Object>>>(acrmAbrBusiSumService.getListByModel(model));
    	
    }
    @GetMapping("/rank")
    public ResultDto<List<Map<String, Object>>> getRank(QueryModel model){
		return new ResultDto<List<Map<String, Object>>>(acrmAbrBusiSumService.getRank(model));
    }
    @GetMapping("/property")
    public ResultDto<List<Map<String, Object>>> getPropertyInfo(QueryModel model){
        return new ResultDto<List<Map<String, Object>>>(acrmAbrBusiSumService.getPropertyInfo(model));
    }
}
