package cn.com.yusys.yscrm.cust.person.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciBlackListInfo;
import cn.com.yusys.yscrm.cust.person.service.AcrmFciBlackListInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciBlackListInfoResource
 * @类描述: #资源类
 * @功能描述: 黑名单信息
 * @创建人: 15104
 * @创建时间: 2019-02-12 16:07:29
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciblacklistinfo")
public class AcrmFciBlackListInfoResource extends CommonResource<AcrmFciBlackListInfo, String> {
	@Autowired
	private AcrmFciBlackListInfoService acrmFciBlackListInfoService;

	@Override
	protected CommonService getCommonService() {
		return acrmFciBlackListInfoService;
	}
	
	/**
	 * @方法名称: querylist
	 * @方法描述: 黑名单信息查询
	 * @param
	 * @return
	 */
	@GetMapping("/querylist/{custId}")
	public ResultDto<Object> querylist(QueryModel model, @PathVariable String custId) {
		List<Map<Object, String>> baseInfo = acrmFciBlackListInfoService.querylist(model, custId);

		return new ResultDto<Object>(baseInfo);
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 黑名单信息新增
	 * @param
	 * @return
	 */
	@PostMapping("/ctrate")
	public ResultDto<Object> ctrate(@RequestBody AcrmFciBlackListInfo acrmFciBlackListInfo) {
		int result = acrmFciBlackListInfoService.ctrate(acrmFciBlackListInfo);
		return new ResultDto<Object>(result);
	}

	/**
	 * @方法名称: modify
	 * @方法描述: 黑名单信息修改
	 * @param
	 * @return
	 */
	@PostMapping("/modify")
	public ResultDto<Object> modify(@RequestBody AcrmFciBlackListInfo acrmFciBlackListInfo) {
		int result = acrmFciBlackListInfoService.modify(acrmFciBlackListInfo);
		return new ResultDto<Object>(result);
	}

	/**
	 * @方法名称: delete
	 * @方法描述: 黑名单信息删除
	 * @param
	 * @return
	 */
	// @PostMapping("/delete")
	// public int delete(@RequestBody Map<String, String> map) {
	// String strId = map.get("Id").toString();
	// return acrmFciBlackListInfoService.deleteById(strId);
	// }
	@PostMapping("/delete")
	public ResultDto<Object> delete(@RequestBody Map<String, String> idMap) {
		int n = 0;
		if (idMap != null) {
			String ids = idMap.get("id").toString();
			String[] idStr = ids.toString().split(",");
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					n = n + this.acrmFciBlackListInfoService.delete(idStr[i]);
				}
			}
		}

		return new ResultDto<Object>(n);
	}
}
