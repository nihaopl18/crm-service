package cn.com.yusys.yscrm.info.remind.web.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemind;
import cn.com.yusys.yscrm.info.remind.service.AcrmFwpRemindService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import javax.servlet.http.HttpServletResponse;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: AcrmFwpRemindResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-02-20 14:09:15
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/inforeminder")
public class AcrmFwpRemindResource extends CommonResource<AcrmFwpRemind, String> {
	@Autowired
	private AcrmFwpRemindService acrmFwpRemindService;

	@Override
	protected CommonService getCommonService() {
		return acrmFwpRemindService;
	}

	private final Logger log = LoggerFactory.getLogger(AcrmFwpRemindResource.class);
	/**
	 * @函数名称:queryList
	 * @函数描述: 异动查询
	 * @参数与返回说明:
	 * @param queryModel
	 *            分页查询类
	 * @算法描述:
	 */
	@GetMapping("/querylist")
	protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		List<Map<String, Object>> list = null;
		list = acrmFwpRemindService.queryList(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @函数名称:updateStat
	 * @函数描述: 异动查询
	 * @参数与返回说明:
	 * @param infoId
	 *            分页查询类
	 * @算法描述:
	 */
	@GetMapping("/updateStat")
	protected ResultDto<Integer> updateStat(@RequestParam(value="infoId")String infoId,@RequestParam(value="operation")String operation) {
		int result = acrmFwpRemindService.updateStat(infoId,operation);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @方法名称: export
	 * @方法描述: 查询结果导出
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/export")
	public void export(HttpServletResponse response, QueryModel model) throws IOException {
		try {
			acrmFwpRemindService.export(model, response);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}
}
