package cn.com.yusys.yscrm.custmgrgroup.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmMktTeam;
import cn.com.yusys.yscrm.custmgrgroup.service.CustMgrGroupBusiSumService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;


@RestController
@RequestMapping("/api/custmgrgroupbusisum")
public class CustMgrGroupBusiSumResource extends CommonResource<OcrmFcmMktTeam, String> {
	
	@Autowired
	private CustMgrGroupBusiSumService custMgrGroupBusiSumService;
	
	@Override
	protected CommonService getCommonService() {
		return null;
	}
	
	/**
 	 * @方法名称: queryCustAumBal
 	 * @方法描述: 查询管理客户AUM月日均余额数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @SuppressWarnings("rawtypes")
	@GetMapping("/querycustaumbal/{mktTeamId}")
	public ResultDto<Map<String, Object>> queryCustAumBal(@PathVariable String mktTeamId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = this.custMgrGroupBusiSumService.getCustAumBal(mktTeamId);
		return new ResultDto<Map<String, Object>>(map);
	}
    
    /**
 	 * @方法名称: queryCustLoanBal
 	 * @方法描述: 查询管理客户贷款月日均余额数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querycustloanbal/{mktTeamId}")
	public ResultDto<Map<String, Object>> queryCustLoanBal(@PathVariable String mktTeamId) {
    	Map<String, Object> map = new HashMap<String, Object>();
		map = this.custMgrGroupBusiSumService.getCustLoanBal(mktTeamId);
		return new ResultDto<Map<String, Object>>(map);
	}
    
    /**
 	 * @方法名称: queryInfo
 	 * @方法描述: 
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/queryinfo/{mktTeamId}")
	public ResultDto<List<Map<String, Object>>> queryInfo(@PathVariable String mktTeamId) {
    	List<Map<String, Object>> list = custMgrGroupBusiSumService.queryInfo(mktTeamId);
    	return new ResultDto<List<Map<String, Object>>>(list);
    }
	
}
