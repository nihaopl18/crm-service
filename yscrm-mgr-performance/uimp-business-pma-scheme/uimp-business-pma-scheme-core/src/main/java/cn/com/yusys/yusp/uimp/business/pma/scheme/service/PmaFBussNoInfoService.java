package cn.com.yusys.yusp.uimp.business.pma.scheme.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.repository.mapper.PmaFBussNoInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBussNoInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-14 15:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFBussNoInfoService extends CommonService {
    @Autowired
    private PmaFBussNoInfoMapper pmaFBussNoInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFBussNoInfoMapper;
    }
    
    /**
	 * 
	* @方法名称: getBusstreeByParam
	* @方法描述: 获取业务品种树控件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getBusstreeByParam(String bussType) {
		Map<String, Object> params = new HashMap<>();
		params.put("bussType", bussType);
		return pmaFBussNoInfoMapper.getBusstreeByParam(params);
	}
	
	@Transactional(readOnly = true)
	public String queryNames(String bussNo) {
    	String result = "";
    	List<String> resultList = new ArrayList<String>();
    	try {
    		if(!StringUtil.isEmpty(bussNo)) {
    			String[] ids = bussNo.split(",");
    			resultList = this.pmaFBussNoInfoMapper.queryNames(ids);
    			if(resultList.size() > 0) {
    				for(String s : resultList) {
    					result += s + ",";
    				}
    				result = result.substring(0, result.length() - 1);
    			}
    		}
    	} catch (Exception e) {
    		result = "-1";
    		e.printStackTrace();
    	}
    	return result;
    }

}
