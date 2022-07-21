package cn.com.yusys.yusp.uimp.business.pma.app.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.PmaAppMarketActivityInfo;
import cn.com.yusys.yusp.uimp.business.pma.app.service.PmaAppMarketActivityInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: PmaFMarketActivityInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-07-08 14:20:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmaappmarketactivityinfo")
@Api(tags = "营销活动")
public class PmaAppMarketActivityInfoResource extends CommonResource<PmaAppMarketActivityInfo, String> {
    @Autowired
    private PmaAppMarketActivityInfoService pmaFMarketActivityInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFMarketActivityInfoService;
    }

    @GetMapping("/querylist")
    public ResultDto<Object> queryList(QueryModel model){
		List<Map<String, Object>> list = this.pmaFMarketActivityInfoService.queryList(model);
		return new ResultDto<Object>(list);
    }
    
    @PostMapping("/saveorupdate")
    public ResultDto<Object> saveOrUpdate(@RequestBody PmaAppMarketActivityInfo pmaFMarketActivityInfo) {
    	return pmaFMarketActivityInfoService.saveOrUpdate(pmaFMarketActivityInfo);
    }
    
    @PostMapping("/remove/{infoId}")
    public ResultDto<Integer> remove(@PathVariable String infoId) {
    	int result = pmaFMarketActivityInfoService.deleteByPrimaryKey(infoId);
    	return new ResultDto<Integer>(result);
    }
    
    @GetMapping("/queryschemeindex")
    public ResultDto<Object> querySchemeIndex(QueryModel model) {
    	List<Map<String, Object>> list = pmaFMarketActivityInfoService.querySchemeIndex(model);
    	return new ResultDto<Object>(list);
    }
}
