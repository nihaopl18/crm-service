package cn.com.yusys.yscrm.mktactivity.repository.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.mktactivity.domain.OcrmFMkActiCustInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActiTargetMapper
 * @类描述：营销活动客户管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-28 
 */
public interface OcrmFMkActiCustMapper extends CommonMapper<OcrmFMkActiCustInfo>{
	/**
	* @方法名称: getSeq
	* @方法描述: 返回自增序列
	* @参数与返回说明: 
	* @算法描述:
	**/
	public BigDecimal getSeq();
	/**
	* @方法名称: lastCustDel
	* @方法描述: 删除上次关联客户
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int lastCustDel(BigDecimal actiId);
	/**
	* @方法名称: prodFitCustInfo
	* @方法描述: 查询关联产品的目标客户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> prodFitCustInfo(Map<String,Object> param);
	/**
	* @方法名称: custGroupCustInfo
	* @方法描述: 查询客户群中的客户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> custGroupCustInfo(Map<String,Object> param);
	/**
	* @方法名称: getCustInfoByObj
	* @方法描述: 查询活动关联客户根据执行对象信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getCustInfoByObj(Map<String,Object> param);
	
	/**
	* @方法名称: userInfoByNo
	* @方法描述: 根据用户ID或者登陆号查询用户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> userInfoByNo(Map<String,Object> param);
	
	/**
	* @方法名称: getIndexInfoByProdId
	* @方法描述: 查询指标信息根据产品编号
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getIndexInfoByProdId(QueryModel model);
	
	
}
