package cn.com.yusys.climp.qypool.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.qypool.domain.LoyQyVirtBatch;
import cn.com.yusys.climp.qypool.domain.LoyQyVirtTicket;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-qypool模块
 * @类名称: LoyQyVirtTicketMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-02-21 15:19:34
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyVirtTicketMapper extends CommonMapper<LoyQyVirtTicket> {
	/**
	 * @方法名称	queryInfoByPage
	 * @方法描述	查询积虚拟票券信息
	 * @算法描述	根据输入查询条件，返回虚拟票券表中的对应的虚拟票券信息(关联了用户，机构表查询)
	 * @return	虚拟票券信息列表
	 */
	List<Map<String,Object>> queryInfoByPage(QueryModel model);
	/**
	 * @方法名称	queryBatchByPage
	 * @方法描述	查询积虚拟票券批次信息
	 * @算法描述	根据票券编号条件，返回虚拟票券的批次信息(关联了用户，机构表查询)
	 * @return	虚拟票券批次信息列表
	 */
	List<Map<String,Object>> queryBatchByPage(QueryModel model);
	
	/**
	 * @方法名称	queryStockByPage
	 * @方法描述	查询积虚拟票券库存明细信息
	 * @算法描述	根据票券批次号条件，返回虚拟票券对应批次的库存信息(关联了用户，机构表查询)
	 * @return	虚拟票券库存信息表
	 */
	List<Map<String,Object>> queryStockByPage(QueryModel model);
	/**
	 * @方法名称	wfQueryTicketInfo
	 * @方法描述	审批页面查询虚拟票券信息
	 * @算法描述	根据票券ID条件，返回虚拟票券对应信息(关联了用户，机构表查询)
	 * @return	虚拟票券信息表
	 */
	List<Map<String,Object>> wfQueryTicketInfo(Map<String,String> param);
	/**
	 * @方法名称	getTicketInfoByNo
	 * @方法描述	查询票券信息
	 * @算法描述	根据票券编号条件，返回虚拟票券对应信息
	 * @return	虚拟票券信息表
	 */
	List<LoyQyVirtTicket> getTicketInfoByNo(@Param("ticketNo")String ticketNo);
	/**
	 * @方法名称	getTicketInfoByNos
	 * @方法描述	查询票券信息
	 * @算法描述	根据多条票券编号条件，返回虚拟票券对应信息
	 * @return	虚拟票券信息表
	 */
	List<LoyQyVirtTicket> getTicketInfoByNos(Map<String,Object> param);
	
	/**
	 * @方法名称	getBatchInfoByNo
	 * @方法描述	查询票券批次信息
	 * @算法描述	根据票券批次编号条件，返回虚拟票券批次对应信息
	 * @return	虚拟票券批次信息表
	 */
	List<LoyQyVirtBatch> getBatchInfoByNo(@Param("batchNo")String batchNo);
	
	/**
	 * @方法名称	wfQueryBatchInfo
	 * @方法描述	查询积虚拟票券批次信息
	 * @算法描述	根据票券批次ID条件，返回虚拟票券的批次信息(关联了用户，机构表查询)
	 * @return	虚拟票券批次信息列表
	 */
	List<Map<String,Object>> wfQueryBatchInfo(Map<String,String> param);
	
	/**
	 * @方法名称	changeBizWfStatus
	 * @方法描述	修改业务表工作流状态信息
	 * @算法描述	根据虚拟票券的ID编号，修改对应记录的状态
     * @param paramMap {id 积分调整记录ID,status 记录状态}
     * @return 返回更新的条数
	 */
	int changeBizWfStatus(Map<String,Object> paramMap);
	/**
	 * @方法名称	updateInfoStsById
	 * @方法描述	更新数据的生效状态
	 * @算法描述	根据虚拟票券的ID编号，修改对应记录的生效状态
     * @param 	paramMap {id 积分调整记录ID,status 记录状态}
     * @return 更新的记录条数
	 */
	 int updateInfoStsById(Map<String,Object> paramMap);
		/**
		 * @方法名称	getNum
		 * @方法描述	统计本批次导入的条数
		 * @算法描述	根据批次号汇总查询
		 * @return	
		 */
	List<Map<String,Object>> getNum(@Param("batchNo")String batchNo);
		/**
		 * @方法名称	insertList
		 * @方法描述	把临时表中的数据插入到正式表中
		 * @算法描述	根据批次号把本批次的数据插入到正式表
		 * @return	
		 */
	void insertList(@Param("batchNo")String batchNo);
		/**
		 * @方法名称	deleteTempInfo
		 * @方法描述	删除临时表中的对应批次的数据
		 * @算法描述	根据批次号删除临时表中的数据
		 * @return	
		 */
	void deleteTempInfo(@Param("batchNo")String batchNo);
	/**
	 * @方法名称	getListTree
	 * @方法描述	查询左侧类目树
	 * @算法描述	根据机构查询类目
	 * @return	
	 */
	List<Map<String, Object>> getListTree(QueryModel model);
	/**
	 * @方法名称	selectSubdirectory
	 * @方法描述	查询目录下的子目录数据量
	 * @算法描述	查询目录下的子目录数据量
	 * @return	
	 */
	int selectSubdirectory(String id);
	/**
	 * @方法名称	selectSubVirtStock
	 * @方法描述	查询目录下的票券数据量
	 * @算法描述	查询目录下的票券数据量
	 * @return	
	 */
	int selectSubVirtStock(String id);
	
}