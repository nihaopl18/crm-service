package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFAppointSet;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFAppointSetService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFAppointSetResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-29 13:44:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafappointset")
public class PmaFAppointSetResource extends CommonResource<PmaFAppointSet, String> {
    @Autowired
    private PmaFAppointSetService pmaFAppointSetService;

    @Override
    protected CommonService getCommonService() {
        return pmaFAppointSetService;
    }

	@ApiOperation(value = "获取业绩预约设置的数据")
	@GetMapping("/getsetting")
	public ResultDto<List<Map<String,Object>>> getSetting() {
		List<Map<String, Object>> list = this.pmaFAppointSetService.getSetting();
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	@ApiOperation(value = "保存内容")
	@PostMapping("/savedata")
	public ResultDto<Object> saveData(@RequestBody List<PmaFAppointSet> list) throws Exception {
		 return pmaFAppointSetService.saveData(list);
	}
}
