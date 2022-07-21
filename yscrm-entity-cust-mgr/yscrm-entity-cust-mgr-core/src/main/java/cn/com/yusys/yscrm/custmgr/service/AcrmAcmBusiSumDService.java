package cn.com.yusys.yscrm.custmgr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custmgr.repository.mapper.AcrmAcmBusiSumDMapper;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmBusiSumDService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-11 16:47:59
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmAcmBusiSumDService extends CommonService {
	@Autowired
	private AcrmAcmBusiSumDMapper acrmAcmBusiSumDMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return acrmAcmBusiSumDMapper;
	}

	public List<Map<String, Object>> queryInfo(String mgrId) {
		List<Map<String, Object>> list = acrmAcmBusiSumDMapper.queryInfo(mgrId);
		List<Map<String, Object>> newList = new ArrayList<>();
		Map<String, Object> maps = new HashMap<>();
		for (Map map : list) {
			String custType = (String) map.get("custType");
			if ("1".equals(custType)) {
				maps.put("perNum", map.get("custNum"));
				maps.put("newEffPerNum", map.get("newEffNum"));
				maps.put("dpsBalPer", map.get("dpsBal"));
				maps.put("dpsMAvgBalPer", map.get("dpsMAvgBal"));
				maps.put("aumBalPer", map.get("aumBal"));
				maps.put("loanBalPer", map.get("loanBal"));
				maps.put("loanMAvgBalPer", map.get("loanMAvgBal"));
				maps.put("finBalPer", map.get("finBal"));
				maps.put("finMAvgBalPer", map.get("finMAvgBal"));
			}else if("2".equals(custType)) {
				maps.put("orgNum", map.get("custNum"));
				maps.put("newEffOrgNum", map.get("newEffNum"));
				maps.put("dpsBalOrg", map.get("dpsBal"));
				maps.put("dpsMAvgBalOrg", map.get("dpsMAvgBal"));
				maps.put("aumBalOrg", map.get("aumBal"));
				maps.put("loanBalOrg", map.get("loanBal"));
				maps.put("loanMAvgBalOrg", map.get("loanMAvgBal"));
				maps.put("finBalOrg", map.get("finBal"));
				maps.put("finMAvgBalOrg", map.get("finMAvgBal"));
			}
		}
		newList.add(maps);
		return newList;
	}
}
