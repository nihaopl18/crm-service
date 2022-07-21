package cn.com.yusys.yusp.uimp.business.pma.app.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.app.service.AppGuessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appguess")
@Api(tags = "移动端业绩测算模块")
public class AppGuessResource {

	@Autowired
	private AppGuessService appGuessService;
	
	@ApiOperation(value = "查询业务子类", notes = "查询业务子类")
	@GetMapping("/querybustypesub")
    public ResultDto<Object> queryBusTypeSub(QueryModel model){
		List<Map<String, Object>> list = this.appGuessService.queryBusTypeSub(model);
		return new ResultDto<Object>(list);
    }
	
	@ApiOperation(value = "查询资金成本参数", notes = "查询资金成本参数")
	@GetMapping("/queryparam")
	public ResultDto<Object> queryParam(QueryModel model){
		List<Map<String, Object>> list = this.appGuessService.queryParam(model);
		return new ResultDto<Object>(list);
	}
	
	@ApiOperation(value = "计算公式", notes = "计算公式")
	@PostMapping("/calculate")
	public ResultDto<Object> calculate(@RequestBody Map<String,Object> map){
		return new ResultDto<Object>(appGuessService.calculate(map));
	}
	
	@ApiOperation(value = "查询移动端字段", notes = "查询移动端字段")
	@GetMapping("/queryfuncfg")
	public ResultDto<Object> queryFunCfg(QueryModel model) throws Exception{
		Map<String, Object> map = this.appGuessService.queryFunCfg(model);
		return new ResultDto<Object>(map);
	}
	
	@ApiOperation(value = "查询移动端展示功能", notes = "查询移动端展示功能")
	@GetMapping("/queryfun")
	public ResultDto<Object> queryFun() throws Exception{
		List<Map<String, Object>> list = this.appGuessService.queryFun();
		return new ResultDto<Object>(list);
	}
	
	@ApiOperation(value = "查询审批详情", notes = "查询审批详情")
	@GetMapping("/queryperiod")
	public ResultDto<Object> queryPeriod(QueryModel model) throws Exception{
		List<Map<String, Object>> list = this.appGuessService.queryPeriod(model);
		return new ResultDto<Object>(list);
	}
}
