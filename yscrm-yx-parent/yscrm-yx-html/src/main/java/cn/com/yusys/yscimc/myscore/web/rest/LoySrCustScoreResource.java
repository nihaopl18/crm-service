package cn.com.yusys.yscimc.myscore.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscimc.myscore.domain.LoySrCustScore;
import cn.com.yusys.yscimc.myscore.service.LoySrCustScoreService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: LoySrCustScoreService
 * @类描述: #用户积分明细查询
 * @功能描述: 查询用户积分明细
 * @创建人: yangxiao2
 * @创建时间: 2019-05-31 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loysrcustscore")
public class LoySrCustScoreResource extends CommonResource<LoySrCustScore, String>{
	
	@Autowired
	private LoySrCustScoreService service;
	
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	
	/**
	 * @功能名称：getCustScore
	 * @功能描述：用户积分明细查询
	 * */
	@GetMapping("/getcustscore")
	public ResultDto<Map<String,Object>>getCustScore(@RequestParam(required = false) String custId){
		return new ResultDto<Map<String,Object>>(service.getCustScore(custId));
	}
	
	/**
	 * @功能名称：getCustScoreInfo
	 * @功能描述：用户积分明细查询
	 * */
	@GetMapping("/getcustscoreinfo")
	public ResultDto<List<Map<String,Object>>>getCustScoreInfo(@RequestParam(required = false) String custId){
		return new ResultDto<List<Map<String,Object>>>(service.getCustScoreInfo(custId));
	}
}
