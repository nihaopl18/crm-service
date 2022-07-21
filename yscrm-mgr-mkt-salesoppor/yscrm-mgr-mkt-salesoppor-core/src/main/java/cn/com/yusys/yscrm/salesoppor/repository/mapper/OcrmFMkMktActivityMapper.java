package cn.com.yusys.yscrm.salesoppor.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.salesoppor.domain.OcrmFMkMktActivityInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkMktActivityMapper
 * @类描述：营销活动明细相关Mapper
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-22
 */
public interface OcrmFMkMktActivityMapper extends CommonMapper<OcrmFMkMktActivityInfo> {
	/**
	* @方法名称: activiListQuery
	* @方法描述: 销售活动查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> activiListQuery(QueryModel model);
	/**
	* @方法名称: activiSame
	* @方法描述: 销售活动名称验重
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int activiSame(OcrmFMkMktActivityInfo record);
	/**
	* @方法名称: activiDel
	* @方法描述: 销售活动删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int activiDel(String activityNo);
	/**
	* @方法名称: setBusinessStage
	* @方法描述: 设置商机阶段
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int setBusinessStage(@Param("actiStage")String actiStage,@Param("businessNo")String businessNo);
}
