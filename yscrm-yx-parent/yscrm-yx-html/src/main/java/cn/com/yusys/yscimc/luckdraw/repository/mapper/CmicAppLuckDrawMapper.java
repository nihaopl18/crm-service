package cn.com.yusys.yscimc.luckdraw.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleCusts;
import cn.com.yusys.yscimc.luckdraw.domain.CimcAppLuckDrawCusts;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleCustsMapper
 * @类描述: #Dao类
 * @功能描述: 客户拼团信息
 * @创建人: chenl
 * @创建时间: 2019-06-12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CmicAppLuckDrawMapper extends CommonMapper<CmicAppAssembleCusts> {
	/**
	 * 
	* @方法名称:getNodeIdByActyid
	* @方法描述:根据活动id查询抽奖nodeId
	* @参数与返回说明:actyId(活动id)
	* @算法描述:
	 */
	List<Map<String, Object>> getNodeIdByActyid(String nodeId);
	/**
	 * 
	* @方法名称:getLuckDraw
	* @方法描述:根据活动formId查询抽奖信息
	* @参数与返回说明:formId
	* @算法描述:
	 */
	List<Map<String, Object>> getLuckDraw(String formId);
	/**
	 * 
	* @param formId 
	 * @方法名称:custInfo
	* @方法描述:根据活动formId查询抽奖客户信息
	* @参数与返回说明:custId
	* @算法描述:
	 */
	List<Map<String, Object>> custInfo(@Param (value="custId") String custId,@Param (value="formId") String formId);
	/**
	 * 
	* @param id, luckDrawNum
	 * @方法名称:updateCustInfo
	* @方法描述:根据活动id更新客户抽奖次数情况
	* @参数与返回说明:id,luckDrawNum
	* @算法描述:
	 */
	void updateCustInfo(@Param (value="id") String id,@Param (value="luckDrawNum") String luckDrawNum);
	/**
	 * 
	* @param formId 
	 * @方法名称:winInfo
	* @方法描述:根据活动formId中奖情况
	* @参数与返回说明:custId
	* @算法描述:
	 */
	List<Map<String, Object>> winInfo(String formId);
	List<Map<String, Object>> displayList();
}