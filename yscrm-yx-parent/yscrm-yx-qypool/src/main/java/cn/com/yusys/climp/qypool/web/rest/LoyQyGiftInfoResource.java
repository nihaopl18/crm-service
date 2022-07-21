package cn.com.yusys.climp.qypool.web.rest;

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
import cn.com.yusys.climp.qypool.domain.LoyQyGiftInfo;
import cn.com.yusys.climp.qypool.service.LoyQyGiftInfoService;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyGiftInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-21 17:29:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyqygiftinfo")
public class LoyQyGiftInfoResource extends CommonResource<LoyQyGiftInfo, String> {
    @Autowired
    private LoyQyGiftInfoService loyQyGiftInfoService;

    @Override
    protected CommonService getCommonService() {
        return loyQyGiftInfoService;
    }
    /**
    * @方法名称:getGift
    * @方法描述:礼品列表查询
    * @参数与返回说明:
    * @算法描述:
     */
    @GetMapping("/giftlist")
	public ResultDto<List<LoyQyGiftInfo>> getGift(QueryModel queryModel) {
		List<LoyQyGiftInfo> list = loyQyGiftInfoService.getGift(queryModel);
		return new ResultDto<List<LoyQyGiftInfo>>(list);
	}
    /**
    * @方法名称:batchDelete
    * @方法描述:批量刪除
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/batchdelete")
    public ResultDto<Integer> batchDelete(@RequestBody Map<?,?> map) {
    	String[] idStr = map.get("id").toString().split(",");
    	String orgCode = map.get("orgCode").toString();
        return new ResultDto<Integer>(loyQyGiftInfoService.batchDelete(idStr,orgCode));
    }
}
