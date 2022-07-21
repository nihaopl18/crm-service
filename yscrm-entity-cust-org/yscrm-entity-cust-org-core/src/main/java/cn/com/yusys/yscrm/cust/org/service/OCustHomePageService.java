package cn.com.yusys.yscrm.cust.org.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgHoldPro;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OCustHomePageMapper;
/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgHoldProService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-22 14:59:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OCustHomePageService extends CommonService {
    @Autowired
    private OCustHomePageMapper oCustHomePageMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.oCustHomePageMapper;
    }
    /**
     *产品标签
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryOProductTagList(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return oCustHomePageMapper.queryOProductTagList(paramMap);
	}
	
	  /**
 	 * @方法名称: getBussXaxisArray
 	 * @方法描述: 获取X轴数据组
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    public String[] getBussXaxisArray(String custId) {
    	return oCustHomePageMapper.getBussXaxisArray(custId);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getOrgBussSumList(String custId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.oCustHomePageMapper.getOrgBussSumList(custId);
    	Double[] aum1 = new Double[list.size()];//存款时点余额
    	Double[] aum2 = new Double[list.size()];//本年存款日均余额
    	Double[] aum3 = new Double[list.size()];//上年末存款时点余额
    	Double[] aum4 = new Double[list.size()];//上年存款日均余额
    	
    	Double[] aum5 = new Double[list.size()];//贷款时点余额
    	Double[] aum6 = new Double[list.size()];//本年贷款日均余额
    	Double[] aum7 = new Double[list.size()];//上年末贷款时点余额
    	Double[] aum8 = new Double[list.size()];//上年贷款日均余额
    	
    	Double[] aum9 = new Double[list.size()];//上年理财日均余额
    	Double[] aum10 = new Double[list.size()];//本年理财日均余额
    	Double[] aum11 = new Double[list.size()];//本年理财日均余额
    	
    	
	int i = 0;
    	for(Map<String,Object> map : list) {
    		Double dpsBal = Double.valueOf(String.valueOf(map.get("dpsBal")));//存款时点余额
    		Double dpsYAvgBal = Double.valueOf(String.valueOf(map.get("dpsYAvgBal")));//本年存款日均余额
    		Double dpsBalLy = Double.valueOf(String.valueOf(map.get("dpsBalLy")));//上年末存款时点余额
    		Double dpsYAvgBalLy = Double.valueOf(String.valueOf(map.get("dpsYAvgBalLy")));//上年存款日均余额
    		
    		Double loanBal = Double.valueOf(String.valueOf(map.get("loanBal")));//贷款时点余额
    		Double loanYAvgBal = Double.valueOf(String.valueOf(map.get("loanYAvgBal")));//本年贷款日均余额
    		Double loanBalLy = Double.valueOf(String.valueOf(map.get("loanBalLy")));//上年末贷款时点余额
    		Double loanYAvgBalLy = Double.valueOf(String.valueOf(map.get("loanYAvgBalLy")));//上年贷款日均余额
    		
    		Double finYAvgBalLy = Double.valueOf(String.valueOf(map.get("finYAvgBalLy")));//上年理财日均余额
    		Double finYAvgBal = Double.valueOf(String.valueOf(map.get("finYAvgBal")));//本年理财日均余额
    		Double finBal = Double.valueOf(String.valueOf(map.get("finBal")));//本年理财日均余额
    		aum1[i] = dpsBal;
    		aum2[i] = dpsYAvgBal;
    		aum3[i] = dpsBalLy;
    		aum4[i] = dpsYAvgBalLy;
    		
    		aum5[i] = loanBal;
    		aum6[i] = loanYAvgBal;
    		aum7[i] = loanBalLy;
    		aum8[i] = loanYAvgBalLy;
    		
    		aum9[i] = finYAvgBalLy;
    		aum10[i] = finYAvgBal;
    		aum11[i] = finBal;
    		i++;
		}
    	result.put("aum1", aum1);
    	result.put("aum2", aum2);
    	result.put("aum3", aum3);
    	result.put("aum4", aum4);
    	
    	result.put("aum5", aum5);
    	result.put("aum6", aum6);
    	result.put("aum7", aum7);
    	result.put("aum8", aum8);
    	
    	result.put("aum9", aum9);
    	result.put("aum10", aum10);
    	result.put("aum11", aum11);
    	return result;
	}
    /**
   	 * @方法名称: getBussXaxisArray
   	 * @方法描述: 获取X轴数据组
   	 * @参数与返回说明:
   	 * @算法描述:
   	 */
      public String[] getBussMonXaxisArray(String custId) {
      	return oCustHomePageMapper.getBussMonXaxisArray(custId);
      }

      @SuppressWarnings({ "rawtypes", "unchecked" })
  	public Map<String,Object> getOrgBussMonSumList(String custId) {
      	Map result = new HashMap();
      	List<Map<String,Object>> list = this.oCustHomePageMapper.getOrgBussMonSumList(custId);
      	Double[] aum1 = new Double[list.size()];//存款总余额
      	Double[] aum2 = new Double[list.size()];//定期存款余额
      	Double[] aum3 = new Double[list.size()];//活期存款余额
      	Double[] aum4 = new Double[list.size()];//存款月日均余额
      	Double[] aum5 = new Double[list.size()];//外币存款余额
      	
    	Double[] aum6 = new Double[list.size()];//综合贡献度
      	Double[] aum7 = new Double[list.size()];//存款贡献度
      	Double[] aum8 = new Double[list.size()];//贷款贡献度度
      	Double[] aum9 = new Double[list.size()];//中间业务贡献度
      	
     	Double[] aum10 = new Double[list.size()];//总贷款余额
      	Double[] aum11 = new Double[list.size()];//不良贷款余额
      	
    	Double[] aum12 = new Double[list.size()];//总负债月日均
      	Double[] aum13 = new Double[list.size()];//总负债月日均
      	
  	int i = 0;
      	for(Map<String,Object> map : list) {
      		Double dpsBal = Double.valueOf(String.valueOf(map.get("dpsBal")));//存款总余额
      		Double dpsFixBal = Double.valueOf(String.valueOf(map.get("dpsFixBal")));//定期存款余额
      		Double dpsCurBal = Double.valueOf(String.valueOf(map.get("dpsCurBal")));//活期存款余额
      		Double dpsMAvg = Double.valueOf(String.valueOf(map.get("dpsMAvg")));//存款月日均余额
      		Double dpsBalWb = Double.valueOf(String.valueOf(map.get("dpsBalWb")));//外币存款余额
      		
      		Double reportSum = Double.valueOf(String.valueOf(map.get("reportSum")));//综合贡献度
      		Double reportDps = Double.valueOf(String.valueOf(map.get("reportDps")));//存款贡献度
      		Double reportLoan = Double.valueOf(String.valueOf(map.get("reportLoan")));//贷款贡献度度
      		Double reportMid = Double.valueOf(String.valueOf(map.get("reportMid")));//中间业务贡献度
      		
      		Double loanBal = Double.valueOf(String.valueOf(map.get("loanBal")));//总贷款余额
      		Double badLoanBal = Double.valueOf(String.valueOf(map.get("badLoanBal")));//不良贷款余额
      		
      		Double debtMAvgBal = Double.valueOf(String.valueOf(map.get("debtMAvgBal")));//总负债月日均
      		Double aumMAvgBal = Double.valueOf(String.valueOf(map.get("aumMAvgBal")));//总负债月日均
      		aum1[i] = dpsBal;
      		aum2[i] = dpsFixBal;
      		aum3[i] = dpsCurBal;
      		aum4[i] = dpsMAvg;
      		aum5[i] = dpsBalWb;
      		
      		aum6[i] = reportSum;
      		aum7[i] = reportDps;
      		aum8[i] = reportLoan;
      		aum9[i] = reportMid;
      		
      		aum10[i] = loanBal;
      		aum11[i] = badLoanBal;
      		
      		aum12[i] = debtMAvgBal;
      		aum13[i] = aumMAvgBal;
      		
      		i++;
  		}
      	result.put("aum1", aum1);
      	result.put("aum2", aum2);
      	result.put("aum3", aum3);
      	result.put("aum4", aum4);
      	result.put("aum5", aum5);
      	
    	result.put("aum6", aum6);
      	result.put("aum7", aum7);
      	result.put("aum8", aum8);
      	result.put("aum9", aum9);
      	
      	result.put("aum10", aum10);
      	result.put("aum11", aum11);
     
      	result.put("aum12", aum12);
      	result.put("aum13", aum13);
      	return result;
  	}
      /**
       * 贡献度占比信息
       * @param model
       * @param custId
       * @return
       */
  	@Transactional(readOnly = true) 
  	public List<Map<String, Object>> queryOrgReportList(String custId) {
  		Map<String, String> paramMap=new HashMap<String, String>();
  		paramMap.put("custId", custId);
  		// TODO 自动生成的方法存根
  		return oCustHomePageMapper.queryOrgReportList(paramMap);
  	}
  	 /**
     *业务汇总
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryBussList(String custId) {
		
		return oCustHomePageMapper.getOrgBussSumList(custId);
	}
}
