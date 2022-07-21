package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipApply;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipList;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称：crm-service
 * @类名称：OcrmFciTrusteeshipMapper
 * @类描述：客户托管Mapper
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-16
 */
@Mapper
public interface OcrmFciTrusteeshipMapper extends CommonMapper<OcrmFciTrusteeshipApply>{
	/**
	* @方法名称: trustList
	* @方法描述: 客户托管历史查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>> trustList(QueryModel model);
	/**
	* @方法名称: trustInsert
	* @方法描述: 客户托管
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int trustInsert(OcrmFciTrusteeshipApply record);
	/**
	* @方法名称: trustInsertCust
	* @方法描述: 客户清单托管
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int trustInsertCust(OcrmFciTrusteeshipList record);
	/**
	* @方法名称: trustRecover
	* @方法描述: 客户托管回收
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int trustRecover(BigDecimal applyId);
	/**
	* @方法名称: getId
	* @方法描述: 获取历史托管记录编号
	* @参数与返回说明: 
	* @算法描述:
	**/
	public BigDecimal getId();
	/**
	* @方法名称: getListId
	* @方法描述: 获取托管清单记录编号
	* @参数与返回说明: 
	* @算法描述:
	**/
	public BigDecimal getListId();
	/**
	* @方法名称: getTrustCustId
	* @方法描述: 获取托管清单客户编号
	* @参数与返回说明: 
	* @算法描述:
	**/
	public int getTrustCustId(String custId);
	/**
	* @方法名称: custTrustList
	* @方法描述: 客户托管清单列表
	* @参数与返回说明: 
	* @算法描述:
	**/
	public List<Map<String,Object>>custTrustList(QueryModel model);
	public int checkIs(Map<String, Object> cust);
	public List<Map<String, String>> myCustListByModel(QueryModel model);
	public List<Map<String, String>> getTrustCust(QueryModel model);
	public List<Map<String, String>> getTrustList(QueryModel model);

	public  Map<String, Object> detailelist(Map<String, Object> mapp);

	void deleteapp(Map<String, Object> cust);

	void deleteappp(Map<String, Object> mapp);


	public List<Map<String,String>>  selectName(Map<String, String> mapp);


	public List<Map<String, Object>> selectById(Map<String, Object> mapp);

    void deleteByCustById(Map<String, Object> mapp);

	public int selectCount(Map<String, Object> mapp);

	List<Map<String, String>> myCustListByModelM(QueryModel model);

	List<Map<String, String>> myCustListByModelMS(QueryModel model);

	List<Map<String, Object>> selectcust(Map<String, Object> mapp);

	List<Map<String, Object>> selectcustmap(Map<String, Object> mapp);

	List<Map<String, Object>> selectcustma(Map<String, Object> mapp);

    void deleteByCustByIdl(Map<String, Object> mapp);

	void insertList(List<OcrmFciTrusteeshipList> subList);
}