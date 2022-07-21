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
import cn.com.yusys.yscrm.custpub.domain.AcrmAcmBusiSum;
import cn.com.yusys.yscrm.custpub.service.AcrmAcmBusiSumService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmAcmBusiSumResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-03 19:14:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmacmbusisum")
public class AcrmAcmBusiSumResource extends CommonResource<AcrmAcmBusiSum, String> {
    @Autowired
    private AcrmAcmBusiSumService acrmAcmBusiSumService;

    @Override
    protected CommonService getCommonService() {
        return acrmAcmBusiSumService;
    }
    @GetMapping("/rank")
    public ResultDto<List<Map<String, Object>>> getRank(QueryModel model){
		return new ResultDto<List<Map<String, Object>>>(acrmAcmBusiSumService.getRank(model));
    }
    
    @GetMapping("/rank2")
    public ResultDto<List<Map<String, Object>>> getRank2(QueryModel model){
		return new ResultDto<List<Map<String, Object>>>(acrmAcmBusiSumService.getRank2(model));
    }
    @GetMapping("/rank3")
    public ResultDto<List<Map<String, Object>>> getRank3(QueryModel model){
		return new ResultDto<List<Map<String, Object>>>(acrmAcmBusiSumService.getRank3(model));
    }
}
