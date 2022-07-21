package cn.com.yusys.yscrm.product.web.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.product.domain.OcrmFsysSsCol;
import cn.com.yusys.yscrm.product.service.OcrmFsysSsColService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import net.sf.json.JSONArray;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysSsColResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: yantianyi
 * @创建时间: 2019-03-06 10:00:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsyssscol")
public class OcrmFsysSsColResource extends CommonResource<OcrmFsysSsCol, String> {
	@Autowired
	private OcrmFsysSsColService ocrmFsysSsColService;

	@Override
	protected CommonService getCommonService() {
		return ocrmFsysSsColService;
	}

	/**
	 * @方法名称: getScol
	 * @方法描述: 产品准入限制条件查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getscol")
	public ResultDto<List<Map<String, Object>>> getScol(String prodId, String ssType) {
		List<Map<String, Object>> list = ocrmFsysSsColService.getScol(prodId, ssType);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * 保存方案及条件列
	 * 
	 * @param parmas
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("/savecol")
	public ResultDto<Integer> saveCol(@RequestBody Map<?, ?> parmas) throws ParseException {
		List<Map<String, Object>> ndata = (List<Map<String, Object>>) parmas.get("nodeData");
		String prodId = (String) parmas.get("pordId");
		return new ResultDto<Integer>(ocrmFsysSsColService.saveScol(ndata, prodId));
	}

	
	@GetMapping("/getcolquery")
	public ResultDto<List<Map<String, Object>>> getColQuery(QueryModel model) {
		List<Map<String, Object>> focusCust = ocrmFsysSsColService.getColQuery(model);
		if (focusCust.size() > 0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		} else {
			return null;
		}
	}

	/**
	 * 产品视图-产品准入限制条件树查询
	 * 
	 * @param 否
	 * @return HashMap
	 */
	@GetMapping("/prepare")
	public ResultDto<List<Map<String, Object>>> prepare() {
		return new ResultDto<List<Map<String, Object>>>(this.ocrmFsysSsColService.prepare());
	}

	/**
	 * 产品视图-产品准入限制拖动类型查询
	 * 
	 * @param
	 * @return HashMap
	 */
	@GetMapping("/showcoltype")
	public ResultDto<List<Map<String, Object>>> showcoltype(QueryModel model) {
		List<Map<String, Object>> list = this.ocrmFsysSsColService.showcoltype(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * 保存方案及条件列
	 * 
	 * @param parmas
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("/savecustcol")
	public ResultDto<Integer> saveCustCol(@RequestBody Map<?, ?> parmas) throws ParseException {
		List<Map<String, Object>> ndata = (List<Map<String, Object>>) parmas.get("nodeData");
		String prodId = (String) parmas.get("pordId");
		return new ResultDto<Integer>(ocrmFsysSsColService.saveCustCol(ndata, prodId));
	}
	
	/**
	 * 产品视图-产品准入限制条件树查询
	 * 
	 * @param 否
	 * @return HashMap
	 */
	@GetMapping("/custprepare")
	public ResultDto<List<Map<String, Object>>> custPrepare() {
		return new ResultDto<List<Map<String, Object>>>(this.ocrmFsysSsColService.custPrepare());
	}
	
	/**
	 * @方法名称: getScol
	 * @方法描述: 产品准入限制条件查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/getcustscol")
	public ResultDto<List<Map<String, Object>>> getCustScol(String prodId, String ssType) {
		List<Map<String, Object>> list = ocrmFsysSsColService.getCustScol(prodId, ssType);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}
