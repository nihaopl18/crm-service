package cn.com.yusys.yscrm.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.product.repository.mapper.AcrmApdBusiSumMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmApdBusiSumService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-13 10:59:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmApdBusiSumService extends CommonService {
    @Autowired
    private AcrmApdBusiSumMapper acrmApdBusiSumMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmApdBusiSumMapper;
    }

	/**
 	 * @方法名称: getXaxisArray
 	 * @方法描述: 获取X轴数据组
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    public String[] getXaxisArray(String prodId) {
    	return acrmApdBusiSumMapper.getXaxisArray(prodId);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String,Object> getPerCustAum(String prodId) {
    	Map result = new HashMap();
    	List<Map<String,Object>> list = this.acrmApdBusiSumMapper.getPerCustAum(prodId);
    	Double[] aum1 = new Double[list.size()];
    	Double[] aum2 = new Double[list.size()];
    	int i = 0;
    	for(Map<String,Object> map : list) {
    		Double custNumBal = Double.valueOf(String.valueOf(map.get("custNum")));
    		Double salesAmtBal = Double.valueOf(String.valueOf(map.get("salesAmt")));
    		aum1[i] = custNumBal;
    		aum2[i] = salesAmtBal;
    		i++;
		}
    	result.put("aum1", aum1);
    	result.put("aum2", aum2);
    	return result;
	}
}
