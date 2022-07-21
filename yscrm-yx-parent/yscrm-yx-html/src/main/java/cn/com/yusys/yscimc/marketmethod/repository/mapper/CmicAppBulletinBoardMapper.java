package cn.com.yusys.yscimc.marketmethod.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleCusts;
import cn.com.yusys.yscimc.marketmethod.domain.CimpCmNodesPresentation;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @项目名称：yscimc-app-mobile
 * @类名称：CmicAppBulletinBoard
 * @类描述：公告板映射类
 * @功能描述:营销方式公告板
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2019-06-11
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2019宇信科技-版权所有
 */
public interface CmicAppBulletinBoardMapper extends CommonMapper<CmicAppAssembleCusts>{

	/**
	 * 
	* @方法名称:bulletinBoardQuery
	* @方法描述:营销方式公告板
	* @参数与返回说明:condition: {"channel":"渠道ID（组件ID）","hurdles":"栏位标识"}
	* @算法描述:
	 */
	List<Map<String,String>> bulletinBoardQuery(QueryModel model);

	/**
	 * 
	* @方法名称:getAssembleActy
	* @方法描述:获取拼团信息
	* @参数与返回说明:nodeId:节点Id
	* @算法描述:
	 */
	List<CimpCmNodesPresentation> getMarketActy(String nodeId);

	/**
	 *
	 * @方法名称:getAssembleActy
	 * @方法描述:获取拼团信息
	 * @参数与返回说明:nodeId:节点Id
	 * @算法描述:
	 */
	String getDetailContentById(@Param("id") String id);
}
