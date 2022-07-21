package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeAuth;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeAuthService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelgrantInf;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeAuthResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-26 15:05:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafschemeauth")
public class PmaFSchemeAuthResource extends CommonResource<PmaFSchemeAuth, String> {
	private static final Logger logger = LoggerFactory.getLogger(PmaFSchemeAuthResource.class);
    @Autowired
    private PmaFSchemeAuthService pmaFSchemeAuthService;

    @Override
    protected CommonService getCommonService() {
        return pmaFSchemeAuthService;
    }
    
    /**
	 * @throws Exception 
	 * @方法名称: addInfo
	 * @方法描述: 新增信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增信息", notes = "新增信息")
	@PostMapping("/addInfo")
	public ResultDto<String> addInfo(@RequestBody List<PmaFSchemeAuth> list) throws Exception {
		return pmaFSchemeAuthService.addInfo(list);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(不分页)", notes = "查询列表数据(不分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> queryList(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeAuthService.queryList(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylistbymodel")
	public ResultDto<List<Map<String, Object>>> queryListByModel(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeAuthService.queryListByModel(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    /**
     * @函数名称: addGrantInf
     * @函数描述: 新增  考核方案授权信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/addgrantinf")
    protected ResultDto<String> addGrantInf(@RequestBody PmaFSchemeAuth record) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String res = pmaFSchemeAuthService.addGrantInf(record);
    		if("-9".equals(res)) {
    			result.setCode(-9);
    			result.setMessage("参数为空");
    		} else if("-3".equals(res)) {
    			result.setCode(-3);
    			result.setMessage("授权信息重复");
    		} else {
    			result.setCode(0);
    			result.setMessage("新增成功");
    			result.setData(res);
    		}
    	} catch (Exception e) {
    		logger.error("resource addGrantInf error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    /**
     * @函数名称: deleteGrantInf
     * @函数描述: 批量删除授权信息 
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deletegrantinf")
    protected ResultDto<String> deleteGrantInf(@RequestBody String ids) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = pmaFSchemeAuthService.deleteGrantInf(ids);
    		if(code == -9) {
    			result.setCode(code);
    			result.setMessage("参数为空");
    		} else {
    			result.setCode(0);
    			result.setMessage("删除成功");
    		}
    	} catch (Exception e) {
    		logger.error("resource deleteGrantInf error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
}
