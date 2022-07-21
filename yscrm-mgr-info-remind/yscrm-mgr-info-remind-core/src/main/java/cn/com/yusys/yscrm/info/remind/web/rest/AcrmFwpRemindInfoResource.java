package cn.com.yusys.yscrm.info.remind.web.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemindInfo;
import cn.com.yusys.yscrm.info.remind.service.AcrmFwpRemindInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: AcrmFwpRemindResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-22 11:14:59
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfwpremindinfo")
public class AcrmFwpRemindInfoResource extends CommonResource<AcrmFwpRemindInfo, String> {
	@Autowired
	private AcrmFwpRemindInfoService acrmFwpRemindInfoService;

	@Override
	protected CommonService getCommonService() {
		return acrmFwpRemindInfoService;
	}

	/**
	 * @函数名称:queryList
	 * @函数描述: 提醒查询
	 * @参数与返回说明:
	 * @param queryModel
	 *            分页查询类
	 * @算法描述:
	 */
	@GetMapping("/querylist")
	protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		acrmFwpRemindInfoService.updateStateByIssuDate(s.format(date));
		queryModel.getCondition().put("currentDate",s.format(date));
		int isReadNum = acrmFwpRemindInfoService.getIsReadNum(queryModel);
		ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>();
		List<Map<String, Object>> list = acrmFwpRemindInfoService.queryList(queryModel);
		resultDto = new ResultDto<>(list);
		resultDto.setCode(0);
		resultDto.setMessage(String.valueOf(isReadNum));
		return resultDto;
	}

	/**
	 * @函数名称:updateStat
	 * @函数描述: 提醒状态修改
	 * @参数与返回说明:
	 * @param infoId
	 *            更新类
	 * @算法描述:
	 */
	@GetMapping("/updateStat")
	protected ResultDto<Integer> updateStat(@RequestParam(value = "infoId") String infoId) {
		int result = acrmFwpRemindInfoService.updateState(infoId);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @函数名称:updateStatAll
	 * @函数描述: 提醒状态全部修改
	 * @参数与返回说明:
	 * @param userId
	 *            更新类
	 * @算法描述:
	 */
	@GetMapping("/updateStatAll")
	protected ResultDto<Integer> updateStatAll(@RequestParam(value = "userId") String userId) {
		int result = acrmFwpRemindInfoService.updateStatAll(userId);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @函数名称:addOne
	 * @函数描述: 新增一条消息提醒
	 * @参数与返回说明:
	 * @param acrmFwpRemindInfo
	 *           增加类
	 * @算法描述:
	 */
	@GetMapping("/addOne")
	protected ResultDto<Integer> addOne(@RequestBody AcrmFwpRemindInfo acrmFwpRemindInfo) {
		int result = acrmFwpRemindInfoService.addOne(acrmFwpRemindInfo);
		return new ResultDto<Integer>(result);
	}
	
	/**
	 * @函数名称:addlist
	 * @函数描述: 新增一条消息提醒
	 * @参数与返回说明:
	 * @param list
	 *           增加类
	 * @算法描述:
	 */
	@GetMapping("/addlist")
	protected ResultDto<Integer> addlist(@RequestBody List<AcrmFwpRemindInfo> list) {
		int result = acrmFwpRemindInfoService.addlist(list);
		return new ResultDto<Integer>(result);
	}
}
