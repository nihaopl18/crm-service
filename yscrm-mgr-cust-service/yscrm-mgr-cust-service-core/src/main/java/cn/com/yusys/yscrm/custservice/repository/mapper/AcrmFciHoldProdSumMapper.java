package cn.com.yusys.yscrm.custservice.repository.mapper;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yscrm.custservice.domain.AcrmFciHoldProdSum;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: ccccc模块
 * @类名称: AcrmFciHoldProdSumMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 18:08:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Mapper
public interface AcrmFciHoldProdSumMapper extends CommonMapper<AcrmFciHoldProdSum> {
	List<AcrmFciHoldProdSum> queryAll(QueryModel model);
}