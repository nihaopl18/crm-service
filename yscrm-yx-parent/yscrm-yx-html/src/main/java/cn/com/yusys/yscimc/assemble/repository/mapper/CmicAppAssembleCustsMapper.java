package cn.com.yusys.yscimc.assemble.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleCusts;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0.0
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleCustsMapper
 * @类描述: #Dao类
 * @功能描述: 客户拼团信息
 * @创建人: chenl
 * @创建时间: 2019-06-12
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CmicAppAssembleCustsMapper extends CommonMapper<CmicAppAssembleCusts> {
    /**
     * @方法名称:getAssembleNum
     * @方法描述: 获取未满团的团id
     * @参数与返回说明:actyId(活动id),assembleNum(成团数)
     * @算法描述:
     */
    List<Map<String, Object>> getAssembleNum(Map<?, ?> param);

    /**
     * @方法名称:getCustByActyid
     * @方法描述:根据活动id查询参与拼团客户信息
     * @参数与返回说明:actyId(活动id)
     * @算法描述:
     */
    List<Map<String, Object>> getCustByActyid(String actyId);

    /**
     * @方法名称:getVirtStock
     * @方法描述:查询虚拟票券库存信息
     * @参数与返回说明:
     * @算法描述:
     */
    List<Map<String, Object>> getVirtStock();

    /**
     * @方法名称:insertVirtOut
     * @方法描述:新增虚拟票券发货表
     * @参数与返回说明:虚拟票券发货信息
     * @算法描述:
     */
    int insertVirtOut(Map<?, ?> param);

    /**
     * @方法名称:updateVirtStock
     * @方法描述: 修改虚拟票券库存信息
     * @参数与返回说明:
     * @算法描述:
     */
    int updateVirtStock(Map<?, ?> param);

    /**
     * @方法名称:getAssembleInfoByAssId
     * @方法描述: 根据团号获取团信息
     * @参数与返回说明:
     * @算法描述:
     */
    List<Map<String, String>> getAssembleInfoByAssId(@Param("assembleId") String assembleId);

    /**
     * @方法名称:joinAssemble
     * @方法描述: 加入拼团
     * @参数与返回说明:
     * @算法描述:
     */
    int joinAssemble(CmicAppAssembleCusts cmicAppAssembleCusts);

    /**
     * @方法名称:getCustNumByAssembleId
     * @方法描述: 根据团号查询团人数
     * @参数与返回说明:
     * @算法描述:
     */
    int getCustNumByAssembleId(@Param("assembleId") String assembleId);

    /**
     * @方法名称:getAssembleByCusId
     * @方法描述: 根据客户ID和actyId查询拼团信息
     * @参数与返回说明:
     * @算法描述:
     */
    CmicAppAssembleCusts getAssembleByCustId(@Param("custId") String custId, @Param("actyId") String actyId);

    /**
     * @方法名称:updateOrderState
     * @方法描述: 团满时修改订单的状态
     * @参数与返回说明:
     * @算法描述:
     */
    int updateOrderState(@Param("orderState") String orderState, @Param("custId") String custId, @Param("actyId") String actyId);
}