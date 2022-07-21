package cn.com.yusys.climp.acty.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyEngTransactionCategory;
import cn.com.yusys.climp.acty.service.LoyEngTransactionCategoryService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngTransactionCategoryResource
 * @类描述: 交易类型资源类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:56
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/transactioncategory")
public class LoyEngTransactionCategoryResource extends CommonResource<LoyEngTransactionCategory, String> {
	@Autowired
	private LoyEngTransactionCategoryService loyEngTransactionCategoryService;

	@Override
	protected CommonService getCommonService() {
		return loyEngTransactionCategoryService;
	}

	/**
	 * 查询交易码
	 * 
	 * @return
	 */
	@GetMapping("/searchtranscode")
	public ResultDto<List<Map<String, Object>>> searchTransCode(@RequestParam(required = false) String transType) {
		return new ResultDto<List<Map<String, Object>>>(loyEngTransactionCategoryService.searchTransCode(transType));
	}

	/**
	 * 查询所有码值
	 * 
	 * @return
	 */
	@GetMapping("/searchlookupcode")
	public ResultDto<List<Map<String, Object>>> searchLookupCode() {
		return new ResultDto<List<Map<String, Object>>>(loyEngTransactionCategoryService.searchLookupCode());
	}
}
