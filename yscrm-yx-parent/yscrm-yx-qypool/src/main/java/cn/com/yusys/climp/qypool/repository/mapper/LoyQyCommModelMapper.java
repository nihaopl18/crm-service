package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.qypool.domain.LoyQyCommModel;
import org.apache.ibatis.annotations.Param;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommModelMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyCommModelMapper extends CommonMapper<LoyQyCommModel> {
	/**
     * @方法名称:getModel
     * @方法描述:根据商品编号查询商品规格
     * @参数与返回说明:
     * @算法描述:
      */
	List<LoyQyCommModel> getModel(String commodityCode);
	
	/**
	* @方法名称:delCommModel
	* @方法描述:根据商品id删除商品规格 
	* @参数与返回说明:
	* @算法描述:
	 */
	int delCommModel(String commId);
	/**
	* @方法名称:updateCommMLValue
	* @方法描述:修改商品现金价值积分价值
	* @参数与返回说明:
	* @算法描述:
	 */
	int updateCommMLValue(Map<?, ?> map);
	/**
     * @方法名称:modelParamQuery
     * @方法描述:商品规格查询
     * @参数与返回说明:
     * @算法描述:
      */
	List<Map<String,Object>>modelParamQuery(String commodityCode);
	/**
     * @方法名称:getModelInActyNum
     * @方法描述:获取活动中的规格数量
     * @参数与返回说明:
     * @算法描述:
      */
	int getModelInActyNum(String modelId);

	LoyQyCommModel getStgNum(@Param("commodityId")String commodityId, @Param("modelId")String modelId);

	Integer updateCommodityStNum(@Param("commId")String commId, @Param("storgeMgType")String storgeMgType, @Param("mgCount")BigDecimal mgCount);

	Integer updateNum(@Param("modelId")String modelId, @Param("storgeMgType")String storgeMgType, @Param("mgCount")BigDecimal mgCount);

	LoyQyCommModel getSalNum(@Param("modelId")String modelId);
}