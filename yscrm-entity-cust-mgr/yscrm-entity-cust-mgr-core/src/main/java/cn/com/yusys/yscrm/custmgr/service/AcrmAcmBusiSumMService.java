package cn.com.yusys.yscrm.custmgr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custmgr.repository.mapper.AcrmAcmBusiSumMMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmBusiSumMService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 14:11:40
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmAcmBusiSumMService extends CommonService {
    @Autowired
    private AcrmAcmBusiSumMMapper acrmAcmBusiSumMMapper;
	private static final String AUM_M_AVG_BAL = "aumMAvgBal";
	private static final String LOAN_M_AVG_BAL = "loanMAvgBal";
	private static final String DATA_DT = "dataDt";
    @Override
    protected CommonMapper<?> getMapper() {
        return acrmAcmBusiSumMMapper;
    }
    
    /**
 	 * @方法名称: getXaxisArray
 	 * @方法描述: 获取X轴数据组
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    public String[] getXaxisArray(String mgrId) {
    	return acrmAcmBusiSumMMapper.getXaxisArray(mgrId);
    }
    
    public String[] getXaxisArrayPer(String mgrId) {
    	return acrmAcmBusiSumMMapper.getXaxisArrayPer(mgrId);
    }
    
    public String[] getXaxisArrayOrg(String mgrId) {
    	return acrmAcmBusiSumMMapper.getXaxisArrayOrg(mgrId);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getPerCustAum(String mgrId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.acrmAcmBusiSumMMapper.getPerCustAum(mgrId);
    	Double[] aum1 = new Double[list.size()];
    	Double[] aum2 = new Double[list.size()];
    	Double[] aum3 = new Double[list.size()];
    	int i = 0;
    	for(Map<String,Object> map : list) {
    		Double perAumBal = Double.valueOf(String.valueOf(map.get("aumBal")));
    		Double perAumMAvgBal = Double.valueOf(String.valueOf(map.get(AUM_M_AVG_BAL)));
    		Double perAumYAvgBal = Double.valueOf(String.valueOf(map.get("aumYAvgBal")));
    		aum1[i] = perAumBal;
    		aum2[i] = perAumMAvgBal;
    		aum3[i] = perAumYAvgBal;
    		i++;
		}
    	result.put("aum1", aum1);
    	result.put("aum2", aum2);
    	result.put("aum3", aum3);
    	return result;
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getOrgCustAum(String mgrId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.acrmAcmBusiSumMMapper.getOrgCustAum(mgrId);
    	Double[] aum1 = new Double[list.size()];
    	Double[] aum2 = new Double[list.size()];
    	Double[] aum3 = new Double[list.size()];
    	int i = 0;
    	for(Map<String,Object> map : list) {
    		Double perAumBal = Double.valueOf(String.valueOf(map.get("aumBal")));
    		Double perAumMAvgBal = Double.valueOf(String.valueOf(map.get(AUM_M_AVG_BAL)));
    		Double perAumYAvgBal = Double.valueOf(String.valueOf(map.get("aumYAvgBal")));
    		aum1[i] = perAumBal;
    		aum2[i] = perAumMAvgBal;
    		aum3[i] = perAumYAvgBal;
    		i++;
		}
    	result.put("aum1", aum1);
    	result.put("aum2", aum2);
    	result.put("aum3", aum3);
    	return result;
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getPerCustLoanBal(String mgrId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.acrmAcmBusiSumMMapper.getPerCustLoanBal(mgrId);
    	Double[] aum1 = new Double[list.size()];
    	Double[] aum2 = new Double[list.size()];
    	Double[] aum3 = new Double[list.size()];
    	int i = 0;
    	for(Map<String,Object> map : list) {
    		Double perAumBal = Double.valueOf(String.valueOf(map.get("loanBal")));
    		Double perAumMAvgBal = Double.valueOf(String.valueOf(map.get(LOAN_M_AVG_BAL)));
    		Double perAumYAvgBal = Double.valueOf(String.valueOf(map.get("loanYAvgBal")));
    		aum1[i] = perAumBal;
    		aum2[i] = perAumMAvgBal;
    		aum3[i] = perAumYAvgBal;
    		i++;
		}
    	result.put("aum1", aum1);
    	result.put("aum2", aum2);
    	result.put("aum3", aum3);
    	return result;
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getOrgCustLoanBal(String mgrId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.acrmAcmBusiSumMMapper.getOrgCustLoanBal(mgrId);
    	Double[] aum1 = new Double[list.size()];
    	Double[] aum2 = new Double[list.size()];
    	Double[] aum3 = new Double[list.size()];
    	int i = 0;
    	for(Map<String,Object> map : list) {
    		Double perAumBal = Double.valueOf(String.valueOf(map.get("loanBal")));
    		Double perAumMAvgBal = Double.valueOf(String.valueOf(map.get(LOAN_M_AVG_BAL)));
    		Double perAumYAvgBal = Double.valueOf(String.valueOf(map.get("loanYAvgBal")));
    		aum1[i] = perAumBal;
    		aum2[i] = perAumMAvgBal;
    		aum3[i] = perAumYAvgBal;
    		i++;
		}
    	result.put("aum1", aum1);
    	result.put("aum2", aum2);
    	result.put("aum3", aum3);
    	return result;
	}
    //AUM月日均
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getCustAumBal(String mgrId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.acrmAcmBusiSumMMapper.getCustAumBal(mgrId);
    	List dateList=new ArrayList<>();
    	List aumList=new ArrayList<>();
    	for(int j=0;j<list.size();j++) {
    		for(int k=0;k<list.size();k++) {
    			if((list.get(j).get(DATA_DT).equals(list.get(k).get(DATA_DT))&&j!=k)) {
    				dateList.add(list.get(j).get(DATA_DT));
    				System.out.println(list.get(k).get(AUM_M_AVG_BAL));
    				double aum1=Double.parseDouble((list.get(j).get(AUM_M_AVG_BAL)+"").equals("")?"0":list.get(j).get(AUM_M_AVG_BAL)+"");
    				double aum2=Double.parseDouble((list.get(k).get(AUM_M_AVG_BAL)+"").equals("")?"0":list.get(k).get(AUM_M_AVG_BAL)+"");
    				aumList.add(aum1+aum2);
    				j++;
    			}
    		}
    		if(!dateList.contains(list.get(j).get(DATA_DT))) {
    			dateList.add(list.get(j).get(DATA_DT));
    			aumList.add(Double.parseDouble((list.get(j).get(AUM_M_AVG_BAL)+"").equals("")?"0":list.get(j).get(AUM_M_AVG_BAL)+""));
    		}
		}
    	result.put("aum", aumList);
    	result.put("xaxis", dateList);
    	return result;
	}
    //贷款12月月日日均余额
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getCustLoanBal(String mgrId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.acrmAcmBusiSumMMapper.getCustLoanBal(mgrId);
    	List dateList=new ArrayList<>();
    	List aumList=new ArrayList<>();
    	for(int j=0;j<list.size();j++) {
    		for(int k=0;k<list.size();k++) {
    			if((list.get(j).get(DATA_DT).equals(list.get(k).get(DATA_DT))&&j!=k)) {
    				dateList.add(list.get(j).get(DATA_DT));
    				System.out.println(list.get(k).get(LOAN_M_AVG_BAL));
    				double aum1=Double.parseDouble((list.get(j).get(LOAN_M_AVG_BAL)+"").equals("")?"0":list.get(j).get(LOAN_M_AVG_BAL)+"");
    				double aum2=Double.parseDouble((list.get(k).get(LOAN_M_AVG_BAL)+"").equals("")?"0":list.get(k).get(LOAN_M_AVG_BAL)+"");
    				aumList.add(aum1+aum2);
    				j++;
    			}
    		}
    		if(!dateList.contains(list.get(j).get(DATA_DT))) {
    			dateList.add(list.get(j).get(DATA_DT));
    			aumList.add(Double.parseDouble((list.get(j).get(LOAN_M_AVG_BAL)+"").equals("")?"0":list.get(j).get(LOAN_M_AVG_BAL)+""));
    		}
		}
    	result.put("bal", aumList);
    	result.put("xaxis", dateList);
    	return result;
	}

}
