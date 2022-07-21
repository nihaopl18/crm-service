package cn.com.yusys.yscrm.custflexEs.web.rest;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustFoucsInfo;
import cn.com.yusys.yscrm.custflexEs.service.CrmCustFoucsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.util.StringUtil;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustFoucsInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: sawyerwei
 * @创建时间: 2020-12-07 12:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Api(tags = "关注客户信息设置")
@RestController
@RequestMapping("/api/crmcustfoucsinfo")
public class CrmCustFoucsInfoResource extends CommonResource<CrmCustFoucsInfo, String> {
	
	private static final Logger log = LoggerFactory.getLogger(CrmCustFoucsInfoResource.class);
	
    @Autowired
    private CrmCustFoucsInfoService crmCustFoucsInfoService;

    @Override
    protected CommonService getCommonService() {
        return crmCustFoucsInfoService;
    }

    /**
     * @函数名称: updateCustFoucsInfo
     * @函数描述: 维护客户关注信息
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "维护客户关注信息", notes = "如果已关注该客户则设置成不关注，反之亦然")
    @PostMapping("/updatecustfoucsinfo")
    protected ResultDto<String> updateCustFoucsInfo(@RequestBody String custId) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String id = crmCustFoucsInfoService.updateCustFoucsInfo(custId);
    		if("-1".equals(id)) {
    			result.setCode(-1);
    			result.setMessage("客户编号为空，不允许维护客户关注信息");
    		} else if(StringUtil.isNotEmpty(id)) {
    			result.setCode(0);
    			result.setMessage("执行成功");
    			result.setData(id);
    		}
    	} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("执行异常");
			log.error("updateCustFoucs data error", e);
    	}
        return result;
    }
	
    /**
     * @函数名称: batchSetFoucsCusts
     * @函数描述: 批量设置关注客户
     * @参数与返回说明:
     * @算法描述:
     */
	@ApiOperation(value = "批量设置关注客户", notes = "批量设置关注客户，如果关注关系已存在则忽略")
    @PostMapping("/batchsetfoucscusts")
    protected ResultDto<String> batchSetFoucsCusts(@RequestBody String custIds) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String id = crmCustFoucsInfoService.batchSetFoucsCusts(custIds);
    		if("-1".equals(id)) {
    			result.setCode(-1);
    			result.setMessage("客户编号为空，不允许维护客户关注信息");
    		} else {
    			result.setCode(0);
    			result.setMessage("执行成功");
    			result.setData(id);
    		}
    	} catch (Exception e) {
			result.setCode(-9);
			result.setMessage("执行异常");
			log.error("batchSetFoucsCusts data error", e);
    	}
        return result;
    }
}
