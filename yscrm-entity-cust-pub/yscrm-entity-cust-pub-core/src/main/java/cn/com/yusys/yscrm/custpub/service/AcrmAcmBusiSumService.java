package cn.com.yusys.yscrm.custpub.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.domain.AcrmAcmBusiSum;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmAcmBusiSumMapper;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmAcmBusiSumService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-04-03 19:14:23
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmAcmBusiSumService extends CommonService {
	@Autowired
	private AcrmAcmBusiSumMapper acrmAcmBusiSumMapper;
	private static final String CUST_TYPE = "custType";
	@Override
	protected CommonMapper<?> getMapper() {
		return acrmAcmBusiSumMapper;
	}

	public List<Map<String, Object>> getRank(QueryModel model) {
		// TODO 自动生成的方法存根 正常客户经理
		if ("1".equals(model.getCondition().get(CUST_TYPE))) {
			return acrmAcmBusiSumMapper.getRankPer(model);
		}else {
			return acrmAcmBusiSumMapper.getRankOrg(model);
		}
	}
	
	public List<Map<String, Object>> getRank2(QueryModel model) {
		//二级支行
		if ("1".equals(model.getCondition().get(CUST_TYPE))) {
			return acrmAcmBusiSumMapper.getRankPer2(model);
		}else {
			return acrmAcmBusiSumMapper.getRankOrg2(model);
		}
	}

	public List<Map<String, Object>> getRank3(QueryModel model) {
		//团队长
		if ("1".equals(model.getCondition().get(CUST_TYPE))) {
			return acrmAcmBusiSumMapper.getRankPer3(model);
		}else {
			return acrmAcmBusiSumMapper.getRankOrg3(model);
		}
	}

}
