package cn.com.yusys.yscrm.mktactivity.repository.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiExcRecordInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiExcRecordMapper
 * @类描述：营销活动明细
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-29
 */
public interface OcrmFMkActiExcRecordMapper extends CommonMapper<OcrmFMkActiExcRecordInfo>{
	/** 
	* @方法名称: actiExeDetailListQuery
	* @方法描述: 营销活动执行明细查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> actiExeDetailListQuery(QueryModel model);
	/** 
	* @方法名称: actiDetailListQuery
	* @方法描述: 营销活动明细查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> actiDetailListQuery(QueryModel model);
	/** 
	* @方法名称: actiExeDetailDel
	* @方法描述: 营销活动执行明细删除
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int actiExeDetailDel(BigDecimal recordId);
	/** 
	* @方法名称: updateCustStep
	* @方法描述: 修改关联客户的阶段信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int updateCustStep(Map<String,Object> param);
	/** 
	* @方法名称: countActiExeDetailList
	* @方法描述: 统计执行明细总数
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> countActiExeDetailList(Map<String,Object> param);	
	
}
