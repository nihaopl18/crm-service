package cn.com.yusys.climp.score.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.score.domain.LoySrScoreAccuteSum;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-cust模块
 * @类名称: LoySrScoreAccuteSumMapper
 * @类描述: #Dao类
 * @功能描述: 查询客户累积贡献度
 * @创建人: hujun3
 * @创建时间: 2019-01-22 15:04:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoySrScoreAccuteSumMapper extends CommonMapper<LoySrScoreAccuteSum> {
	/**
	 * 
	* @方法名称: queryCustContriByPage
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryCustContriByPage(QueryModel param);

	void insertData(String importCode);
}