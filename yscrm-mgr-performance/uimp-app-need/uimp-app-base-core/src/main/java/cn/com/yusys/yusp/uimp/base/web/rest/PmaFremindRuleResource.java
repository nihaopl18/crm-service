package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.PmaFremindRule;
import cn.com.yusys.yusp.uimp.base.service.PmaFremindRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFremindRuleResource
 * @类描述: #信息提醒规则 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-07-06 10:02:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafremindrule")
public class PmaFremindRuleResource extends CommonResource<PmaFremindRule, String> {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFremindRuleResource.class);
	
    @Autowired
    private PmaFremindRuleService pmaFremindRuleService;

    @Override
    protected CommonService getCommonService() {
        return pmaFremindRuleService;
    }

    /**
     * @函数名称:queryList
     * @函数描述:查询对象列表，公共API接口
     * @参数与返回说明:
     * @param QueryModel
     *            分页查询类
     * @算法描述:
     */
    @GetMapping("/querylist")
	protected ResultDto<List<PmaFremindRule>> queryList(QueryModel queryModel) {
		ResultDto<List<PmaFremindRule>> result = new ResultDto<List<PmaFremindRule>>();
		try {
			List<PmaFremindRule> list = pmaFremindRuleService.queryList(queryModel);
			if (list.size() > 0) {
				return new ResultDto<List<PmaFremindRule>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			logger.warn("resource queryList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
    
    /**
     * @函数名称:add
     * @函数描述: 新增  信息提醒规则
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/add")
    protected ResultDto<String> add(@RequestBody PmaFremindRule rule) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String id = pmaFremindRuleService.add(rule);
    		if(StringUtil.isNotEmpty(id)) {
    			result.setCode(0);
    			result.setMessage("新增成功");
    			result.setData(id);
    		} else {
    			result.setCode(-1);
    			result.setMessage("新增失败");
    		}
    	} catch (Exception e) {
    		logger.error("resource add error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @函数名称:modify
     * @函数描述: 修改 信息提醒规则
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/modify")
    protected ResultDto<String> modify(@RequestBody PmaFremindRule rule) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		String id = pmaFremindRuleService.modify(rule);
    		if(StringUtil.isNotEmpty(id)) {
    			result.setCode(0);
    			result.setMessage("修改成功");
    			result.setData(id);
    		} else {
    			result.setCode(-1);
    			result.setMessage("修改失败");
    		}
    	} catch (Exception e) {
    		logger.error("resource modify error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    
    /**
     * @函数名称:deleteData
     * @函数描述: 删除  信息提醒规则
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deletedata")
    protected ResultDto<String> deleteData(@RequestBody String ids) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = pmaFremindRuleService.deleteData(ids);
    		result.setCode(code);
    		if(code == 0) {
    			result.setMessage("修改成功");
    		} else if(code == -9) {
    			result.setMessage("规则编号不能为空");
    		}
    	} catch (Exception e) {
    		logger.error("resource deleteData error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
    /**
     * @函数名称:deleteData
     * @函数描述: 删除  信息提醒规则
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/ok")
    protected ResultDto<String> okData(@RequestBody String ids) {
    	ResultDto<String> result = new ResultDto<String>();
		pmaFremindRuleService.okData(ids,"0");
		result.setCode(0);
		result.setMessage("启用成功");
		return result;
}
    /**
     * @函数名称:deleteData
     * @函数描述: 删除  信息提醒规则
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/nok")
    protected ResultDto<String> nokData(@RequestBody String ids) {
    	ResultDto<String> result = new ResultDto<String>();
    	pmaFremindRuleService.okData(ids,"1");
		result.setCode(0);
		result.setMessage("停用成功");
		return result;
    }
}
