package cn.com.yusys.yusp.uimp.business.pma.app.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.app.service.AppPerformanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appperformance")
@Api(tags = "移动端业绩模块")
public class AppPerformanceResource {

	@Autowired
	private AppPerformanceService appPerformanceService;
	
	@ApiOperation(value = "查询跑批日期", notes = "查询跑批日期")
	@GetMapping("/queryetldate")
    public ResultDto<Object> queryEtlDate(){
		List<Map<String, Object>> list = this.appPerformanceService.queryEtlDate();
		return new ResultDto<Object>(list);
    }
	
	@ApiOperation(value = "根据指标类型查询指标", notes = "根据指标类型查询指标")
	@GetMapping("/queryindexid/{indexType}")
    public ResultDto<Object> queryIndexId( @PathVariable String indexType, @RequestParam(name="type", required=false) String type){
		List<Map<String, Object>> list = this.appPerformanceService.queryIndexId(indexType, type);
		return new ResultDto<Object>(list);
    }
	
	@ApiOperation(value = "查询所有指标", notes = "查询所有指标")
	@GetMapping("/queryallindex")
    public ResultDto<Object> queryAllIndex(){
		List<Map<String, Object>> list = this.appPerformanceService.queryAllIndex();
		return new ResultDto<Object>(list);
    }
	
	
	
	@ApiOperation(value = "查询近6个月业绩指标", notes = "查询近6个月业绩指标")
	@GetMapping("/queryindexmonth")
    public ResultDto<Object> queryIndexMonth(QueryModel model){
		List<Map<String, Object>> list = this.appPerformanceService.queryIndexMonth(model);
		return new ResultDto<Object>(list);
    }
	
	@ApiOperation(value = "查询考核成绩", notes = "查询考核成绩")
	@GetMapping("/queryscheme")
    public ResultDto<Object> queryScheme(QueryModel model){
		List<Map<String, Object>> list = this.appPerformanceService.queryScheme(model);
		return new ResultDto<Object>(list);
    }
}
