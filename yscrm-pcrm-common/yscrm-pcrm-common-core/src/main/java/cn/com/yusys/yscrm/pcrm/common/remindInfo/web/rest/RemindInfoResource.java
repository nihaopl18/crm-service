package cn.com.yusys.yscrm.pcrm.common.remindInfo.web.rest;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.EchainJoinWorkEndDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.EchainJoinWorkTodoDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.RemindInfo;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.service.RemindInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import static cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.ParamsConst.KEY_SESSION_LOGIN_CDE;

/**
 * @项目名称: yscrm-pcrm-common-core模块
 * @类名称: AcrmFwpRemindResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-11-04 10:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/remindinfo")
public class RemindInfoResource extends CommonResource<RemindInfo, String> {
	@Autowired
	private RemindInfoService acrmFwpRemindInfoService;

	@Override
	protected CommonService getCommonService() {
		return acrmFwpRemindInfoService;
	}

	/**
	 * @param acrmFwpRemindInfo 增加类
	 * @函数名称:addOne
	 * @函数描述: 新增一条消息提醒
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/addOne")
	protected ResultDto<Integer> addOne(@RequestBody RemindInfo acrmFwpRemindInfo) {
		int result = acrmFwpRemindInfoService.addOne(acrmFwpRemindInfo);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @param list 增加类
	 * @函数名称:addlist
	 * @函数描述: 新增一条消息提醒
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/addlist")
	protected ResultDto<Integer> addlist(@RequestBody List<RemindInfo> list) {
		int result = acrmFwpRemindInfoService.addlist(list);
		return new ResultDto<Integer>(result);
	}


	/**
	 * 个人待办列表
	 *
	 * @param
	 * @return
	 */
	@GetMapping("/getUserTodos")
	public ResultDto<List<EchainJoinWorkTodoDTO>> getUserTodos(QueryModel model) {
		model.getCondition().put("loginCode", "" + model.getCondition().get(KEY_SESSION_LOGIN_CDE));
		List<EchainJoinWorkTodoDTO> todos = acrmFwpRemindInfoService.selectUserTodos(model);
		return new ResultDto<List<EchainJoinWorkTodoDTO>>(todos);
	}

	/**
	 * 个人已办列表
	 *
	 * @return
	 */
	@GetMapping("/getUserDones")
	public ResultDto<List<EchainJoinWorkTodoDTO>> getUserDones(QueryModel model) {
		model.getCondition().put("loginCode", "" + model.getCondition().get(KEY_SESSION_LOGIN_CDE));
		List<EchainJoinWorkTodoDTO> todos = acrmFwpRemindInfoService.selectUserDones(model);
		return new ResultDto<List<EchainJoinWorkTodoDTO>>(todos);
	}

	/**
	 * 个人办结列表
	 *
	 * @return
	 */
	@GetMapping("/getUserEnds")
	public ResultDto<List<EchainJoinWorkEndDTO>> getUserEnds(QueryModel model) {
		model.getCondition().put("loginCode", "" + model.getCondition().get(KEY_SESSION_LOGIN_CDE));
		List<EchainJoinWorkEndDTO> todos = acrmFwpRemindInfoService.selectUserEnds(model);
		return new ResultDto<List<EchainJoinWorkEndDTO>>(todos);
	}

	@PostMapping("/uploadFile")
	public ResultDto<Map<String, Object>> uploadFile(MultipartFile file) {
		ResultDto<Map<String, Object>> rs = null;
		Map<String, Object> reMap = this.acrmFwpRemindInfoService.uploadFile(file);
		if (reMap.get("message").equals("succese")) {
			rs = new ResultDto<>(reMap);
			rs.setMessage("导入成功！");
			rs.setCode(0);
			return rs;
		} else if (reMap.get("message").equals("error")) {
			rs = new ResultDto<>();
			rs.setMessage((String) reMap.get("error"));
			rs.setCode(-1);
			return rs;
		}
		return rs ;
	}
}