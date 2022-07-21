package cn.com.yusys.yscrm.custmgr.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custmgr.domain.AcrmAcmBusiSumM;
import cn.com.yusys.yscrm.custmgr.service.AcrmAcmBusiSumMService;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmBusiSumMResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 14:11:40
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmacmbusisumm")
public class AcrmAcmBusiSumMResource extends CommonResource<AcrmAcmBusiSumM, String> {
    @Autowired
    private AcrmAcmBusiSumMService acrmAcmBusiSumMService;
	private static final String XAXIS = "xaxis";
    @Override
    protected CommonService getCommonService() {
        return acrmAcmBusiSumMService;
    }
    
    /**
 	 * @方法名称: queryPerCustAum
 	 * @方法描述: 查询零售客户AUM趋势连续12个月数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @SuppressWarnings("rawtypes")
	@GetMapping("/querypercustaum/{mgrId}")
	public ResultDto<Map<String, Object>> queryPerCustAum(@PathVariable String mgrId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(XAXIS, this.acrmAcmBusiSumMService.getXaxisArrayPer(mgrId));
		Map resultMap = this.acrmAcmBusiSumMService.getPerCustAum(mgrId);
		map.put("aum1", resultMap.get("aum1"));
		map.put("aum2", resultMap.get("aum2"));
		map.put("aum3", resultMap.get("aum3"));
		return new ResultDto<Map<String, Object>>(map);
	}
    
    /**
 	 * @方法名称: queryOrgCustAum
 	 * @方法描述: 查询对公客户AUM趋势连续12个月数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/queryorgcustaum/{mgrId}")
	public ResultDto<Map<String, Object>> queryOrgCustAum(@PathVariable String mgrId) {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put(XAXIS, this.acrmAcmBusiSumMService.getXaxisArrayOrg(mgrId));
		Map resultMap = this.acrmAcmBusiSumMService.getOrgCustAum(mgrId);
		map.put("aum1", resultMap.get("aum1"));
		map.put("aum2", resultMap.get("aum2"));
		map.put("aum3", resultMap.get("aum3"));
		return new ResultDto<Map<String, Object>>(map);
	}
    
    /**
 	 * @方法名称: queryPerCustLoanBal
 	 * @方法描述: 查询零售客户贷款余额趋势连续12个月数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querypercustloanbal/{mgrId}")
	public ResultDto<Map<String, Object>> queryPerCustLoanBal(@PathVariable String mgrId) {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put(XAXIS, this.acrmAcmBusiSumMService.getXaxisArrayPer(mgrId));
		Map resultMap = this.acrmAcmBusiSumMService.getPerCustLoanBal(mgrId);
		map.put("aum1", resultMap.get("aum1"));
		map.put("aum2", resultMap.get("aum2"));
		map.put("aum3", resultMap.get("aum3"));
		return new ResultDto<Map<String, Object>>(map);
	}
    
    /**
 	 * @方法名称: queryOrgCustLoanBal
 	 * @方法描述: 查询对公客户贷款余额趋势12个月数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/queryorgcustloanbal/{mgrId}")
	public ResultDto<Map<String, Object>> queryOrgCustLoanBal(@PathVariable String mgrId) {
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put(XAXIS, this.acrmAcmBusiSumMService.getXaxisArrayOrg(mgrId));
		Map resultMap = this.acrmAcmBusiSumMService.getOrgCustLoanBal(mgrId);
		map.put("aum1", resultMap.get("aum1"));
		map.put("aum2", resultMap.get("aum2"));
		map.put("aum3", resultMap.get("aum3"));
		return new ResultDto<Map<String, Object>>(map);
	}
    
    /**
 	 * @方法名称: queryCustAumBal
 	 * @方法描述: 查询管理客户AUM月日均余额数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @SuppressWarnings("rawtypes")
	@GetMapping("/querycustaumbal/{mgrId}")
	public ResultDto<Map<String, Object>> queryCustAumBal(@PathVariable String mgrId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = this.acrmAcmBusiSumMService.getCustAumBal(mgrId);
		return new ResultDto<Map<String, Object>>(map);
	}
    
    /**
 	 * @方法名称: queryCustLoanBal
 	 * @方法描述: 查询管理客户贷款月日均余额数据
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querycustloanbal/{mgrId}")
	public ResultDto<Map<String, Object>> queryCustLoanBal(@PathVariable String mgrId) {
    	Map<String, Object> map = new HashMap<String, Object>();
		map = this.acrmAcmBusiSumMService.getCustLoanBal(mgrId);
		return new ResultDto<Map<String, Object>>(map);
	}
}
