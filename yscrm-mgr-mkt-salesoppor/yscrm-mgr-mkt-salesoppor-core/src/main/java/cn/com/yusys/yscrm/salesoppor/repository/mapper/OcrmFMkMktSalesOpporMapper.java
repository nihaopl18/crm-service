package cn.com.yusys.yscrm.salesoppor.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.salesoppor.domain.OcrmFMkMktSalesOpporInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkMktSalesOpporMapper
 * @类描述：商机管理相关Mapper
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-14
 */
public interface OcrmFMkMktSalesOpporMapper extends CommonMapper<OcrmFMkMktSalesOpporInfo> {
	/**
	* @方法名称: opporListQuery
	* @方法描述: 获取商机池信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> opporListQuery(QueryModel model);
	/**
	* @方法名称: opporDel
	* @方法描述: 删除商机
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int opporDel(String id);
	/**
	* @方法名称: opporDel
	* @方法描述: 删除商机关联营销活动
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int opporActiDel(String id);
	/**
	* @方法名称: myOpporListQuery
	* @方法描述: 获取客户经理商机信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> myOpporListQuery(QueryModel model);
	/**
	* @方法名称: sameBusinessNo
	* @方法描述: 商机编号验重
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int sameBusinessNo(OcrmFMkMktSalesOpporInfo record);
	/**
	* @方法名称: sameBusinessName
	* @方法描述: 商机名称验重
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int sameBusinessName(OcrmFMkMktSalesOpporInfo record);
	/**
	* @方法名称: getBusiStat
	* @方法描述: 查询商机状态
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String getBusiStat(String businessNo);
	/**
	* @方法名称: opporAssign
	* @方法描述: 商机分配
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int opporAssign(OcrmFMkMktSalesOpporInfo record);
	/**
	* @方法名称: opporAssign
	* @方法描述: 商机认领
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int opporReceive(OcrmFMkMktSalesOpporInfo record);
	/**
	* @方法名称: opporBack
	* @方法描述: 商机退回
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int opporBack(OcrmFMkMktSalesOpporInfo record);
	/**
	* @方法名称: opporOff
	* @方法描述: 商机关闭
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int opporOff(OcrmFMkMktSalesOpporInfo record);
	/**
	* @方法名称: custType
	* @方法描述: 客户类型
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String custType(String custId);
	/**
	* @方法名称: custState
	* @方法描述: 返回客户状态
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String custState(String custId);
	/**
	* @方法名称: getUserType
	* @方法描述: 返回登录人角色信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String getUserType(String userId);
	/**
	* @方法名称: getOpporById
	* @方法描述: 根据编号返回商机信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public OcrmFMkMktSalesOpporInfo getOpporById(String businessNo);
	/**
	* @方法名称: getCustData
	* @方法描述: 返回客户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>getCustData(String custId);
	/**
	* @方法名称: getOrgId
	* @方法描述: 返回执行人机构
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String getOrgId(String userId);
	/**
	* @方法名称: getGroupCustList
	* @方法描述: 返回客户群客户信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>getGroupCustList(String custGroupId);
	/**
	* @方法名称: addCustBelong
	* @方法描述: 新增客户经理归属信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int addCustBelong(Map<String,Object> map);
	/**
	* @方法名称: delCustBelong
	* @方法描述: 删除客户经理归属信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int delCustBelong(Map<String,Object> map);
	/**
	* @方法名称: getUserId
	* @方法描述: 返回userId
	* @参数与返回说明: 
	* @算法描述:
	**/
	public String getUserId (String loginCode);
}
