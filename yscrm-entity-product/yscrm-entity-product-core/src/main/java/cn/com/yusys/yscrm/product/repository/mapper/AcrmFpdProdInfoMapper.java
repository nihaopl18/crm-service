package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yscrm.product.domain.AcrmFPdProdShortInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdInfo;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-01-29 15:15:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFpdProdInfoMapper extends CommonMapper<AcrmFpdProdInfo> {

	/**
	* @方法名称: productInfoQuery
	* @方法描述: 产品信息查询
	* @算法描述:
	 */
	List<AcrmFPdProdShortInfo> productInfoQuery(QueryModel param);
	
	/**
	* @方法名称: deleteProductTree
	* @方法描述: 产品信息删除
	* @算法描述:
	 */
	int delerteProductInfo(QueryModel param);
	
	/**
	* @方法名称: ProductBasicInfoQuery
	* @方法描述: 产品基本信息
	* @算法描述:
	 */
	List<Map<String, Object>> trustProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> structProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> qdiiProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> agentProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> fundProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> insuranceProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> loanProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> creditcardProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> depositProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> conTrustProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	List<Map<String, Object>> managProductBasicInfoQuery(@Param("prodCode") String prodCode, @Param("prodId") String prodId);
	/**
	 * @方法名称: productNetValueInfoQuery
	 * @方法描述: 产品净值趋势
	 * @算法描述:
	 */
	List<Map<String, Object>> productNetValueInfoQuery(QueryModel queryModel);

	List<Map<String, Object>> createCheckProdId(String productId);
	
	List<Map<String, Object>> editCheckProdId(@Param("productId") String productId,@Param("proId") String proId);

	List<Map<String, Object>> productCustFitInfoQuery(Map<String,Object> map);
}