package cn.com.yusys.yscrm.product.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.OcrmFpdDrumbeating;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFpdDrumbeatingMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-19 10:36:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdDrumbeatingMapper extends CommonMapper<OcrmFpdDrumbeating> {
	
	/**
	* @方法名称: publicityMaterialQuery
	* @方法描述: 宣传资料查询
	* @算法描述:
	 */
	List<Map<String, Object>> publicityMaterialQuery(QueryModel param);
	
	/**
	* @方法名称: delertePublicityAaterial
	* @方法描述: 宣传资料删除
	* @算法描述:
	 */
	int deletePublicityAaterial(QueryModel param);
	
	/**
	* @方法名称: delerteAttachmentInformation
	* @方法描述: 宣传资料对应附件删除
	* @算法描述:
	 */
	int deleteAttachmentInformation(QueryModel param);
}