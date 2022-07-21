package cn.com.yusys.yscrm.mktactivity.repository.mapper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiFedbackInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiFedbackMapper
 * @类描述：营销活动反馈
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-30 
 */
public interface OcrmFMkActiFedbackMapper extends CommonMapper<OcrmFMkActiFedbackInfo>{
	/**
	* @throws ParseException 
	* @方法名称: getActUser
	* @方法描述: 营销活动反馈查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> actiFedBackList (QueryModel model);
	/**
	* @throws ParseException 
	* @方法名称: getActUser
	* @方法描述: 获取活动创建人
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String getActUser(BigDecimal actiId);
	/**
	* @方法名称: getActiStat
	* @方法描述: 返回活动状态
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String getActiStat (BigDecimal actiId);
	/**
	* @throws ParseException 
	* @方法名称: getSeq
	* @方法描述: 获取自增序列
	* @参数与返回说明: 
	* @算法描述:
	**/
	public BigDecimal getSeq();
}
