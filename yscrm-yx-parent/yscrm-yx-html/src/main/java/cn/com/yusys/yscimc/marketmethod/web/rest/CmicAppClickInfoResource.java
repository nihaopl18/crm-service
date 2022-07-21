package cn.com.yusys.yscimc.marketmethod.web.rest;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscimc.marketmethod.domain.CmicAppClickInfo;
import cn.com.yusys.yscimc.marketmethod.service.CmicAppClickInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;

/**
 * @项目名称: yscimc-cust-group模块
 * @类名称: CmicAppClickInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-06-15 16:19:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmicappclickinfo")
public class CmicAppClickInfoResource extends CommonResource<CmicAppClickInfo, String> {
    @Autowired
    private CmicAppClickInfoService cmicAppClickInfoService;

    @Override
    protected CommonService getCommonService() {
        return cmicAppClickInfoService;
    }


    /**
     * @方法名称:clickinfo
     * @param activityId 活动id
     * @param recommenderId 推荐人id
     * @param custId 客户id
     * @param data 推荐页面json数据
     * @return
     */
    @RequestMapping("/clickinfo/{activityId}/{recommenderId}/{custId}/{data}")
    public ResultDto<Integer> clickinfo(@PathVariable String activityId, @PathVariable String recommenderId,
        @PathVariable String custId, @PathVariable String data) {
        int ret = cmicAppClickInfoService.clickinfo(activityId, recommenderId, custId, data);

        return new ResultDto<>(ret);
    }
    
    /**
     * @方法名称:getclickinfonum
     * @param activityId 活动id
     * @param recommenderId 推荐人id
     * @param custId 客户id
     * @param data 推荐页面json数据
     * @return
     */
    @GetMapping("/getclickinfonum")
    public ResultDto<List<Map<String, Object>>> getClickNum(@RequestBody QueryModel model) {
    	List<Map<String, Object>> list = cmicAppClickInfoService.getClickNum(model);
        return new ResultDto<>(list);
    }

}
