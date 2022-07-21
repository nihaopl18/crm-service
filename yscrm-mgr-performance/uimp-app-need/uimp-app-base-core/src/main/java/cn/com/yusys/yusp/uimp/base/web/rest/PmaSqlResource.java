package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.PmaSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pmasql")
public class PmaSqlResource {
	
	@Autowired
	private PmaSqlService pmaSqlService;
	
	@GetMapping("/querylist/{sqlStatement}")
	public ResultDto<List<Map<String, Object>>> queryList(@PathVariable String sqlStatement,QueryModel queryModel) {
		ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
		try {
			queryModel.getCondition().put("sqlStatement", sqlStatement);
			List<Map<String, Object>> list = pmaSqlService.queryList(queryModel);
			if (list != null && list.size() > 0) {
				return new ResultDto<List<Map<String, Object>>>(list);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
	
	
	@GetMapping("/querycolumnlist/{sqlStatement}")
	public ResultDto<Object> queryColumnList(@PathVariable String sqlStatement){
		return pmaSqlService.queryColumnList(sqlStatement);
	}
}
