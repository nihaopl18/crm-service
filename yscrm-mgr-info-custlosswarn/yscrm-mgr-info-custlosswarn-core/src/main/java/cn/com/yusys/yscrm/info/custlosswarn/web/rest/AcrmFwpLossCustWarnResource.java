package cn.com.yusys.yscrm.info.custlosswarn.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.info.custlosswarn.domain.AcrmFwpLossCustWarnO;
import cn.com.yusys.yscrm.info.custlosswarn.domain.AcrmFwpLossCustWarnP;
import cn.com.yusys.yscrm.info.custlosswarn.service.AcrmFwpLossCustWarnService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;

/**
 * @项目名称: yscrm-mgr-info-custlosswarn-core模块
 * @类名称: AcrmFwpLossCustWarnResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-28 16:52:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/infocustlosswarn")
public class AcrmFwpLossCustWarnResource extends CommonResource<AcrmFwpLossCustWarnP, String> {
    @Autowired
    private AcrmFwpLossCustWarnService acrmFwpLossCustWarnService;

    @Override
    protected CommonService getCommonService() {
        return acrmFwpLossCustWarnService;
    }
    

    /**
     * @方法名称: queryList
     * @方法描述: 列表查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querylist")
    public ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
    	List<Map<String, Object>> list = null;
    	if(queryModel.getCondition().containsKey("custType") && !StringTools.isEmpty(queryModel.getCondition().get("custType") + "")) {
    		list = acrmFwpLossCustWarnService.queryList(queryModel);
    	}
        return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * @方法名称: queryDetail
     * @方法描述: 详情查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querydetail")
    public ResultDto<Object> queryDetail(@RequestParam(value = "custType") String custType, @RequestParam(value = "lossId") String lossId) {
    	Object obj = acrmFwpLossCustWarnService.selectByLossId(custType, lossId);
        return new ResultDto<Object>(obj);
    }
    
    /**
     * @方法名称: updatePerResult
     * @方法描述: 修改个人-客户预警信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/updateperresult")
    public ResultDto<Integer> updatePerResult(@RequestBody AcrmFwpLossCustWarnP acrmFwpLossCustWarnP) {
    	int result = acrmFwpLossCustWarnService.updatePerResult(acrmFwpLossCustWarnP);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @方法名称: updateCorResult
     * @方法描述: 修改对公-客户预警信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/updatecorresult")
    public ResultDto<Integer> updateCorResult(@RequestBody AcrmFwpLossCustWarnO acrmFwpLossCustWarnO) {
    	int result = acrmFwpLossCustWarnService.updateCorResult(acrmFwpLossCustWarnO);
        return new ResultDto<Integer>(result);
    }
}
