package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.PmaFetlDate;
import cn.com.yusys.yusp.uimp.base.model.EtlDateModel;
import cn.com.yusys.yusp.uimp.base.service.PmaFetlDateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFetlDateResource
 * @类描述: #数据日期表 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-09-21 16:49:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafetldate")
public class PmaFetlDateResource extends CommonResource<PmaFetlDate, String> {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFetlDateResource.class);
    
	@Autowired
    private PmaFetlDateService pmaFetlDateService;

    @Override
    protected CommonService getCommonService() {
        return pmaFetlDateService;
    }

    /**
     * @函数名称:queryList
     * @函数描述:列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
    @GetMapping("/querylist")
	protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = pmaFetlDateService.queryList(queryModel);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			logger.error("resource queryList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
    
    /**
     * @函数名称:updateMess
     * @函数描述:根据etlType，更新etlDate/etlState字段值
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/updatemess")
	public ResultDto<String> updateMess(@RequestBody EtlDateModel etlDateModel) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = pmaFetlDateService.updateMess(etlDateModel.getEtlType(), etlDateModel.getEtlDate(), etlDateModel.getEtlState());
    		result.setCode(code > 0 ? 0 : code);
    		if(code == -9) {
    			result.setMessage("参数错误");
    		} else {
    			result.setMessage("保存成功");
    		}
    	} catch (Exception e) {
    		logger.error("resource updateMess error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
        return result;
    }
}
