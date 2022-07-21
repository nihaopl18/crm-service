package cn.com.yusys.yusp.cm.cust.web.rest;

import cn.com.yusys.yusp.cm.cust.domain.CimpCmMkTplBasicinfo;
import cn.com.yusys.yusp.cm.cust.service.CimpCmMkTplBasicinfoService;
import cn.com.yusys.yusp.cm.cust.service.Util;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cimpcmmktplbasicinfo")
public class CimpCmMkTplBasicinfoResource extends CommonResource<CimpCmMkTplBasicinfo, String>{
	
	@Autowired
	private CimpCmMkTplBasicinfoService service;
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.service;
	}
@GetMapping("/list")
	public ResultDto<List<CimpCmMkTplBasicinfo>> getListByModel(QueryModel queryModel){
	List<CimpCmMkTplBasicinfo> list = service.getListByModel(queryModel);
	return new ResultDto<List<CimpCmMkTplBasicinfo>>(list);
}
@PostMapping("/add")
public ResultDto<CimpCmMkTplBasicinfo> add(@RequestBody CimpCmMkTplBasicinfo c){
	ResultDto<CimpCmMkTplBasicinfo> resultDto = null;
	String name=c.getTempName();
	if (service.checkName(name) == 0) {
		Util.addUtl(c);
		return service.add(c);
	}
	resultDto = new ResultDto<>();
	resultDto.setCode(-1);
	resultDto.setMessage("名称已存在");
	return resultDto;
}
//修改
		@PostMapping("/updateFun")
		public ResultDto<Integer> updateFun(@RequestBody CimpCmMkTplBasicinfo c) {
			ResultDto<Integer> resultDto = null;
			int num = service.checkUpName(c.getTempId(), c.getTempName());
			if (num == 1) {
				resultDto = new ResultDto<>(service.updateFun(c));
				resultDto.setCode(0);
				resultDto.setMessage("修改成功");
				return resultDto;
			}
			resultDto = new ResultDto<>(-1);
			resultDto.setCode(-1);
			resultDto.setMessage("修改失败，名称已存在");
			return resultDto;
		}
		//删除
				@PostMapping("/del/{ids}")
				public ResultDto<Integer> del(@PathVariable String ids) {
					return new ResultDto<Integer>(getCommonService().deleteByIds(ids));
				}
		//修改检查用户名是否重复
				@GetMapping("/checkUpName")
				public ResultDto<Integer> checkUpName(QueryModel queryModel) {
					return new ResultDto<Integer>(service.checkUpName((String) queryModel.getCondition().get("tempId"),
							(String) queryModel.getCondition().get("tempName")));
				}
 //新增检查模板名称是否存在
		@GetMapping("/checkName")
		public ResultDto<Integer> checkName(QueryModel queryModel) {
			return new ResultDto<Integer>(service.checkName((String) queryModel.getCondition().get("tempName")));
		}
}
