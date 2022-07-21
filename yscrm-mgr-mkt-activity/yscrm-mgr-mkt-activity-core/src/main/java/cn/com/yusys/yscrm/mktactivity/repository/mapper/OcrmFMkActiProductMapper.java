package cn.com.yusys.yscrm.mktactivity.repository.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiProductInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiTargetMapper
 * @类描述：营销活动产品管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-28 
 */
public interface OcrmFMkActiProductMapper extends CommonMapper<OcrmFMkActiProductInfo>{
	/**
	* @方法名称: getSeq
	* @方法描述: 返回自增序列
	* @参数与返回说明: 
	* @算法描述:
	**/
	public BigDecimal getSeq();
	/**
	* @方法名称: lastProdDel
	* @方法描述: 删除上次关联的产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int lastProdDel(BigDecimal actiId);
	/**
	* @方法名称: getProdInfoByAct
	* @方法描述: 查询活动关联产品信息根据活动id
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getProdInfoByAct(Map<String,Object> param);
}
