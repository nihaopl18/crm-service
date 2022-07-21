package cn.com.yusys.yusp.dycrm.transferInfo.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper.AcrmFCustAcctInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: dycrm-transferInfo模块
 * @类名称: AcrmFCustAcctInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-09-02 16:47:01
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFCustAcctInfoService extends CommonService {
	@Autowired
	private AcrmFCustAcctInfoMapper acrmFCustAcctInfoMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return acrmFCustAcctInfoMapper;
	}

	public List<String> querySubAcctNo(QueryModel queryModel) {
		// TODO 自动生成的方法存根
		String acctType = (String) queryModel.getCondition().get("acctType");
		List<String> list = null;
		if ("1".contains(acctType)){
			list = acrmFCustAcctInfoMapper.queryMainAcctNo(queryModel);
		}else if ("0,4".contains(acctType)){
			list = acrmFCustAcctInfoMapper.querySubAcctNo(queryModel);
		}
		return list;
	}

}
