package cn.com.yusys.yusp.uimp.business.pma.scheme.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.domain.PmaFBussNoInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.service.PmaFBussNoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBussNoInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-14 15:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafbussnoinfo")
public class PmaFBussNoInfoResource extends CommonResource<PmaFBussNoInfo, String> {
    @Autowired
    private PmaFBussNoInfoService pmaFBussNoInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFBussNoInfoService;
    }
    
    @GetMapping("/getbusstree")
    public ResultDto<List<Map<String, Object>>> getBusstreeByParam(@RequestParam String bussType) {
        List<Map<String, Object>> list = pmaFBussNoInfoService.getBusstreeByParam(bussType);
        return new ResultDto<>(list);
    }

    /**
	 * @throws Exception 
	 * @方法名称: queryNames
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@GetMapping("/querynames")
	public ResultDto<String> queryNames(@RequestParam("bussNo") String bussNo) throws Exception {
		ResultDto<String> result = new ResultDto<String>();
    	if(StringUtil.isNotEmpty(bussNo)) {
    		String resultStr = pmaFBussNoInfoService.queryNames(bussNo);
    		if("-1".equals(resultStr)) {
    			result.setCode(-2);
       		  	result.setMessage("服务器忙，请稍后重试！");
    		} else if(StringUtil.isEmpty(resultStr)) {
    			result.setCode(-3);
       		  	result.setMessage("无相关数据！");
    		} else {
    			result.setCode(0);
       		  	result.setMessage("操作成功！");
       		  	result.setData(resultStr);
    		}
    	} else {
    		result.setCode(-1);
   		  	result.setMessage("请求参数错误！");
    	}
    	return result;
	}
}
