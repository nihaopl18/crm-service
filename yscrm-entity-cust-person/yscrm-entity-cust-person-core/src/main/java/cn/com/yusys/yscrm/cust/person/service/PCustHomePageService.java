package cn.com.yusys.yscrm.cust.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yscrm.cust.person.repository.mapper.PCustHomePageMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmLevelRateService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 09:58:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PCustHomePageService extends CommonService {
    @Autowired
    private PCustHomePageMapper pCustHomePageMapper;
	private static final String CUST_ID = "custId";
    @Override
    protected CommonMapper<?> getMapper() {
        return this.pCustHomePageMapper;
    }
    /**
     * AUM占比信息
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryPerAumContriList(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put(CUST_ID, custId);
		// TODO 自动生成的方法存根
		return pCustHomePageMapper.queryPerAumContriList(paramMap);
	}
	  /**
     * 贡献度占比信息
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryPerReportList(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put(CUST_ID, custId);
		// TODO 自动生成的方法存根
		return pCustHomePageMapper.queryPerReportList(paramMap);
	}
	  /**
     * 优惠
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryDiscountList(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put(CUST_ID, custId);
		// TODO 自动生成的方法存根
		return pCustHomePageMapper.queryDiscountList(paramMap);
	}
	 /**
     *推荐的产品
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryProductList(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put(CUST_ID, custId);
		// TODO 自动生成的方法存根
		return pCustHomePageMapper.queryProductList(paramMap);
	}
	 /**
     *产品标签
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryProductTagList(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put(CUST_ID, custId);
		// TODO 自动生成的方法存根
		return pCustHomePageMapper.queryProductTagList(paramMap);
	}
	 /**
     *接触
     * @param model
     * @param custId
     * @return
     */
	@Transactional(readOnly = true) 
	public List<Map<String, Object>> queryVisitlist(String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put(CUST_ID, custId);
		// TODO 自动生成的方法存根
		return pCustHomePageMapper.queryVisitlist(paramMap);
	}
	
	 public String[] getXaxisArray(String custId) {
	    	return pCustHomePageMapper.getXaxisArray(custId);
	    }
	    /**
	 	 * @方法名称: getXaxisMonArray
	 	 * @方法描述: 获取X轴数据组
	 	 * @参数与返回说明:
	 	 * @算法描述:
	 	 */
	    public String[] getXaxisMonArray(String custId) {
	    	return pCustHomePageMapper.getXaxisMonArray(custId);
	    }
	    @SuppressWarnings({ "rawtypes", "unchecked" })
		public Map<String,Object> queryPerBussMonSum(String custId) {
	    	Map result = new HashMap();
	    	List<Map<String,Object>> list = this.pCustHomePageMapper.queryPerBussMonSum(custId);
	    	Double[] aum1 = new Double[list.size()];//AUM月日均余额

	    	Double[] aum2 = new Double[list.size()];//存款总余额
	    	Double[] aum3 = new Double[list.size()];//定期存款余额
	    	Double[] aum4 = new Double[list.size()];//活期存款余额
	    	Double[] aum5 = new Double[list.size()];//存款月日均
	    	
	    	Double[] aum6 = new Double[list.size()];//存款贡献度
	    	Double[] aum7 = new Double[list.size()];//贷款贡献度度
	    	Double[] aum8 = new Double[list.size()];//中间业务贡献度
	    	Double[] aum13 = new Double[list.size()];//综合贡献度
	    	
	    	Double[] aum9 = new Double[list.size()];//总贷款余额
	    	Double[] aum10 = new Double[list.size()];//不良贷款余额
	    	
	    	Double[] aum11 = new Double[list.size()];//月总流入
	    	Double[] aum12 = new Double[list.size()];//月总流出
	    	
	    	
    	int i = 0;
	    	for(Map<String,Object> map : list) {
	    		Double aumMAvg = Double.valueOf(String.valueOf(map.get("aumMAvg")));//AUM_日均余额
	    		
	    		Double dpsBal = Double.valueOf(String.valueOf(map.get("dpsBal")));//存款总余额
	    		Double dpsFixBal = Double.valueOf(String.valueOf(map.get("dpsFixBal")));//定期存款余额
	    		Double dpsCurBal = Double.valueOf(String.valueOf(map.get("dpsCurBal")));//活期存款余额
	    		Double dpsMAvg = Double.valueOf(String.valueOf(map.get("dpsMAvg")));//存款月日均
	    		
	    		Double reportDps = Double.valueOf(String.valueOf(map.get("reportDps")));//存款贡献度
	    		Double reportLoan = Double.valueOf(String.valueOf(map.get("reportLoan")));//贷款贡献度度
	    		Double reportMid = Double.valueOf(String.valueOf(map.get("reportMid")));//中间业务贡献度
	    		Double reportSum = Double.valueOf(String.valueOf(map.get("reportSum")));//综合贡献度
	    		
	    		Double loanBal = Double.valueOf(String.valueOf(map.get("loanBal")));//总贷款余额
	    		Double badLoanBal = Double.valueOf(String.valueOf(map.get("badLoanBal")));//不良贷款余额
	    		
	    		Double flowIntoBal = Double.valueOf(String.valueOf(map.get("flowIntoBal")));//月总流入
	    		Double fluencyBal = Double.valueOf(String.valueOf(map.get("fluencyBal")));//月总流出
	    		aum1[i] = aumMAvg;
	    		
	    		aum2[i] = dpsBal;
	    		aum3[i] = dpsFixBal;
	    		aum4[i] = dpsCurBal;
	    		aum5[i] = dpsMAvg;
	    		
	    		aum6[i] = reportDps;
	    		aum7[i] = reportLoan;
	    		aum8[i] = reportMid;
	    		aum13[i] = reportSum;
	    		
	    		aum9[i] = loanBal;
	    		aum10[i] = badLoanBal;
	
	    		aum11[i] = flowIntoBal;
	    		aum12[i] = fluencyBal;
	    		
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
	    	result.put("aum13", aum13);
	    	
	    	result.put("aum9", aum9);
	    	result.put("aum10", aum10);
	    	
	    	
	    	result.put("aum11", aum11);
	    	result.put("aum12", aum12);
	    	
	    	return result;
		}
	  
	    /**
	     * 存款贷款理财信息
	     * @param model
	     * @param custId
	     * @return
	     */
		@Transactional(readOnly = true) 
		public Map<String,Object> queryPerBussSum(String custId) {
		
			Map result = new HashMap();
	    	List<Map<String,Object>> list = this.pCustHomePageMapper.queryPerBussSum(custId);
	    	Double[] aum1 = new Double[list.size()];//存款时点余额
	    	Double[] aum2 = new Double[list.size()];//上年存款日均余额
	    	Double[] aum3 = new Double[list.size()];//本年存款日均余额
	    	
	    	Double[] aum4 = new Double[list.size()];//贷款时点余额
	    	Double[] aum5 = new Double[list.size()];//上年贷款日均余额	
	    	Double[] aum6 = new Double[list.size()];//本年贷款日均余额
	    	
	    	Double[] aum7 = new Double[list.size()];//理财时点余额
	    	Double[] aum8 = new Double[list.size()];//上年理财日均余额
	    	Double[] aum9 = new Double[list.size()];//本年理财日均余额
	    	
	    	
	    	
	    	
    	int i = 0;
	    	for(Map<String,Object> map : list) {
	    		
	    		
	    	
	    		Double dpsBal = Double.valueOf(String.valueOf(map.get("dpsBal")));//存款时点余额
	    		Double dpsYAvgBalLy = Double.valueOf(String.valueOf(map.get("dpsYAvgBalLy")));//上年存款日均余额
	    		Double dpsYAvgBal = Double.valueOf(String.valueOf(map.get("dpsYAvgBal")));//本年存款日均余额
	    		
	    		Double loanBal = Double.valueOf(String.valueOf(map.get("loanBal")));//贷款时点余额
	    		Double loanYAvgBalLy = Double.valueOf(String.valueOf(map.get("loanYAvgBalLy")));//上年贷款日均余额
	    		Double loanYAvgBal = Double.valueOf(String.valueOf(map.get("loanYAvgBal")));//本年贷款日均余额
	    	
	    		Double finBal = Double.valueOf(String.valueOf(map.get("finBal")));//理财时点余额
	    		Double finYAvgBalLy = Double.valueOf(String.valueOf(map.get("finYAvgBalLy")));//上年理财日均余额
	    		Double finYAvgBal = Double.valueOf(String.valueOf(map.get("finYAvgBal")));//本年理财日均余额
	    	
	    		aum1[i] = dpsBal;
	    		aum2[i] = dpsYAvgBalLy;
	    		aum3[i] = dpsYAvgBal;
	    		
	    		aum4[i] = loanBal;
	    		aum5[i] = loanYAvgBalLy;
	    		aum6[i] = loanYAvgBal;
	    		
	    		aum7[i] = finBal;
	    		aum8[i] = finYAvgBalLy;
	    		aum9[i] = finYAvgBal;
	    		
	    	
	    		
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
	    	
	    
	    	
	    	return result;
		}
}
