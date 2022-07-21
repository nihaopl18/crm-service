package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.FrParamPool;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;




/**
 * @项目名称：yusp-admin
 * @类名称：FrParamPoolMapper
 * @类描述：系统参数
 * @功能描述:
 * @创建人：zhangxs4@yusys.com.cn
 * @创建时间：2017-12-16 15:06
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface FrParamPoolMapper extends CommonMapper<FrParamPool> {
	
	List<Map<String, String>> getPropListBycodeOrName(QueryModel model);
	List<Map<String, String>> selectList(@Param("tabName") String tabName);
	/**
	 * 
	 * @方法名称: createCheckparamid
	 * @方法描述: 新增检查字段编号是否重复
	 * @参数与返回说明:
	 * @算法描述:
	 */
	int createCheckparamid(@Param("paramId") String paramId);
	
	List<Map<String, Object>> list(@Param("transCode") String transCode);
	List<Map<String, String>> selectByparamid(@Param("paramId") String paramId);
}
