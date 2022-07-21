package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.qypool.domain.LoyQyCommodityInfo;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityInfoMapper
 * @类描述: 商品信息Dao类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyCommodityInfoMapper extends CommonMapper<LoyQyCommodityInfo> {
	/**
	* @方法名称:getCommodity
	* @方法描述:商品信息查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyQyCommodityInfo> getCommodity(QueryModel model);
	/**
	* @方法名称:getCommodity
	* @方法描述:商品信息查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyQyCommodityInfo> getCommodityById(Map<String,Object> param);
	
	/**
	* @方法名称:getCommByCategoryCode
	* @方法描述:根据类别编号查询商品信息
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyQyCommodityInfo> getCommByCategoryCode(String categoryCode);
	/**
	* @方法名称:getPropByName
	* @方法描述:根据公共参数名查询公共参数
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> getPropByName(String propName);
	/**
	* @方法名称:updateCommStatus
	* @方法描述:根据商品编号修改商品的上下架状态、审批状态
	* @参数与返回说明:
	* @算法描述:
	 */
	int updateCommStatus(String commodityCode);
	/**
	* @方法名称:delFlag
	* @方法描述:逻辑删除商品
	* @参数与返回说明:
	* @算法描述:
	 */
	int delFlagEdit(String id);
	/**
	* @方法名称:getOrgByInstuValue
	* @方法描述:通过金融机构查询机构列表
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String,Object>>getOrgByInstuValue(@Param("instuValue") String instuValue);
	/**
	* @方法名称:editGiftWorkflow
	* @方法描述:更新商品审批状态
	* @参数与返回说明:id-商品id sts-审批状态（000待发起，111审批中，997通过，998否决）
	* @算法描述:
	 */
	int editGiftWorkflow(Map<String,String> params);

    List<Map<String,String>> getPic(@Param("id")String id);

	List<Map<String,String>> getAttr(String id);

    List<Map<String, String>> getExAttr(QueryModel queryModel);

    void deleteExAttr(@Param("commodityId")String commId);

	int addCommAttr(List<Map<String, String>> list);

	LoyQyCommodityInfo getOneCommodityById(@Param("commodityId")String id);
}