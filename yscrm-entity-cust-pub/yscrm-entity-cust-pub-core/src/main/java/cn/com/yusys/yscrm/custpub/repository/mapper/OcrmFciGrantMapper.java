package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciGrantApply;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciGrantList;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFciGrantMapper
 * @类描述：客户授权Mapper
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-16
 */
@Mapper
public interface OcrmFciGrantMapper extends CommonMapper<OcrmFciGrantApply>{
	/**
	* @方法名称: grantList
	* @方法描述: 客户托管历史查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> grantList(QueryModel model);
	/**
	* @方法名称: custList
	* @方法描述: 所辖客户查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> custList(QueryModel model);
	public List<Map<String,String>> getRoleCode(QueryModel model);
	/**
	* @方法名称: grantRecover
	* @方法描述: 客户授权回收
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int grantRecover(OcrmFciGrantApply record);
	/**
	* @方法名称: insertCustList
	* @方法描述: 新增授权清单客户
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int insertCustList(OcrmFciGrantList record);
	/**
	* @方法名称: getId
	* @方法描述: 获取记录编号
	* @参数与返回说明: 
	* @算法描述:
	**/
	public BigDecimal getId();
	public BigDecimal getListId();
	/**
	* @方法名称: getCM
	* @方法描述: 客户经理放大镜
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> getCM(QueryModel model);
	public List<Map<String,Object>> custGrantList(QueryModel model);
	public String getUserId(String loginCode);
	public List<Map<String, String>> myCustListByModel(QueryModel model);
	public List<Map<String, String>> getGrantCust(QueryModel model);
	public List<Map<String, String>> getGrantList(QueryModel model);
	public int checkIs(Map<String, Object> cust);
	/**
	* @方法名称: grantRecover
	* @方法描述: 客户授权回收
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int grantRecover(BigDecimal applyId);
	public List<Map<String, Object>> getCM1(QueryModel model);
	
}
