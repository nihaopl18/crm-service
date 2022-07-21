package cn.com.yusys.yscrm.custmgr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custmgr.repository.mapper.AcrmAcmLevelRateMapper;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmLevelRateService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-11 09:58:41
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmAcmLevelRateService extends CommonService {
	@Autowired
	private AcrmAcmLevelRateMapper acrmAcmLevelRateMapper;
	private static final String DATA_DT = "dataDt";
	@Override
	protected CommonMapper<?> getMapper() {
		return acrmAcmLevelRateMapper;
	}
	private static final String CUSTNUMSERVICELV = "custNumServiceLv";
	/**
	 * @方法名称: queryPerCustGradeDist
	 * @方法描述: 查询零售客户等级分布数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<Map<String, Object>> queryPerCustGradeDist(String mgrId) {
		List<Map<String, Object>> list = acrmAcmLevelRateMapper.queryPerCustGradeDist(mgrId);
		List<Map<String, Object>> newList = new ArrayList<>();
		if (list.size() >= 1) {
			for (int i = 0; i < 8; i++) {
				Map<String, Object> map = new HashMap<>();
				if (list.get(0).get(CUSTNUMSERVICELV + i) != null
						&& !(list.get(0).get(CUSTNUMSERVICELV + i) + "").equals("0")) {
					map.put("name", i + "星");
					map.put("value", list.get(0).get(CUSTNUMSERVICELV + i));
					newList.add(map);
				}
			}
		}
		return newList;
	}

	/**
	 * @方法名称: queryOrgCustGradeDist
	 * @方法描述: 查询对公客户等级分布数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<Map<String, Object>> queryOrgCustGradeDist(String mgrId) {
		List<Map<String, Object>> list = acrmAcmLevelRateMapper.queryOrgCustGradeDist(mgrId);
		List<Map<String, Object>> newList = new ArrayList<>();
		if (list.size() >= 1) {
			for (int i = 0; i < 8; i++) {
				Map<String, Object> map = new HashMap<>();
				if (list.get(0).get(CUSTNUMSERVICELV + i) != null
						&& !(list.get(0).get(CUSTNUMSERVICELV + i) + "").equals("0")) {
					map.put("name", i + "星");
					map.put("value", list.get(0).get(CUSTNUMSERVICELV + i));
					newList.add(map);
				}
			}
		}
		return newList;
	}

}
