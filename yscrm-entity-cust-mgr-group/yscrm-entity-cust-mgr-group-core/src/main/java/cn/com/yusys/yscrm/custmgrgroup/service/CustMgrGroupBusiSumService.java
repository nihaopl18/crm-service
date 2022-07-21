package cn.com.yusys.yscrm.custmgrgroup.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custmgrgroup.repository.mapper.CustMgrGroupBusiSumMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;

@Service
public class CustMgrGroupBusiSumService extends CommonService {

	@Autowired
	private CustMgrGroupBusiSumMapper custMgrGroupBusiSumMapper;
	private static final String AUM_M_AVG_BAL = "aumMAvgBal";
	private static final String LOAN_M_AVG_BAL = "loanMAvgBal";
	private static final String DATA_DT = "dataDt";
	
	@Override
	protected CommonMapper getMapper() {
		return null;
	}

	/**
	 * @方法名称: getXaxisArray
	 * @方法描述: 获取X轴数据组
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public String[] getXaxisArray(String mgrId) {
		return custMgrGroupBusiSumMapper.getXaxisArray(mgrId);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getCustAumBal(String mgrId) {
		Map result = new HashMap();
		List<Map<String, Object>> list = this.custMgrGroupBusiSumMapper.getCustAumBal(mgrId);
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getCustLoanBal(String mgrId) {
		Map result = new HashMap();
		List<Map<String, Object>> list = this.custMgrGroupBusiSumMapper.getCustLoanBal(mgrId);
    	List dateList=new ArrayList<>();
    	List aumList=new ArrayList<>();
    	for(int j=0;j<list.size();j++) {
    		for(int k=0;k<list.size();k++) {
    			if(list.get(j).get(DATA_DT).equals(list.get(k).get(DATA_DT))&&j!=k) {
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

	public List<Map<String, Object>> queryInfo(String mktTeamId) {
		List<Map<String, Object>> list = custMgrGroupBusiSumMapper.queryInfo(mktTeamId);
		List<Map<String, Object>> newList = new ArrayList<>();
		Map<String, Object> maps = new HashMap<>();
		if (list.size() > 0) {
			maps.put("mktTeamName", list.get(0).get("mktTeamName"));
			maps.put("orgName", list.get(0).get("orgName"));
		}
		for (Map map : list) {
			String custType = (String) map.get("custType");
			if ("1".equals(custType)) {
				maps.put("perNum", map.get("custNum"));
				maps.put("newEffPerNum", map.get("newEffNum"));
				maps.put("dpsBalPer", map.get("dpsBal"));
				maps.put("dpsMAvgBalPer", map.get("dpsMAvgBal"));
				maps.put("aumBalPer", map.get("aumBal"));
				maps.put("loanBalPer", map.get("loanBal"));
				maps.put("loanMAvgBalPer", map.get(LOAN_M_AVG_BAL));
				maps.put("finBalPer", map.get("finBal"));
				maps.put("finMAvgBalPer", map.get("finMAvgBal"));
			} else if ("2".equals(custType)) {
				maps.put("orgNum", map.get("custNum"));
				maps.put("newEffOrgNum", map.get("newEffNum"));
				maps.put("dpsBalOrg", map.get("dpsBal"));
				maps.put("dpsMAvgBalOrg", map.get("dpsMAvgBal"));
				maps.put("aumBalOrg", map.get("aumBal"));
				maps.put("loanBalOrg", map.get("loanBal"));
				maps.put("loanMAvgBalOrg", map.get(LOAN_M_AVG_BAL));
				maps.put("finBalOrg", map.get("finBal"));
				maps.put("finMAvgBalOrg", map.get("finMAvgBal"));
			}
		}
		newList.add(maps);
		return newList;
	}

}
