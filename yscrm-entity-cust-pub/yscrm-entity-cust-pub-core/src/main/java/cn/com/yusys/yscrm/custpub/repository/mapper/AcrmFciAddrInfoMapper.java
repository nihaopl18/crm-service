package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciAddrInfo;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciAddrInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 15:23:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciAddrInfoMapper extends CommonMapper<AcrmFciAddrInfo> {
	   List<Map<String, Object>> queryAddrList(Map<?, ?> param);
	   int updateMainAddrFlag(Map c);
		int removeById(Map<String, String> paramMap);
		int updatePoten(AcrmFciAddrInfo acrmFciAddrInfo);
}