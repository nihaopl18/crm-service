package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.service.CommonClaimService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceImpResource
 * @类描述: # 业绩批量导入接口 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-09 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Api(tags = "业绩批量导入接口")
@RestController
@RequestMapping("/api/commonclaimresource")
public class CommonClaimResource {
	
	private static final Logger log = LoggerFactory.getLogger(CommonClaimResource.class);
	
	@Autowired
	private CommonClaimService commonClaimService;
	
	/**
     * @函数名称:queryList
     * @函数描述:列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	@ApiOperation(value = "列表查询接口")
    @GetMapping("/querylist")
	protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = commonClaimService.queryList(queryModel);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			log.error("resource queryList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
    @PostMapping("/claim")
	@ApiOperation(value = "新增预约", notes = "新增预约")
	public ResultDto<String> claim(@RequestBody Map<String,Object> map) throws Exception {
    	return commonClaimService.claim(map);
    }
}