package cn.com.yusys.yscrm.knowledge.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.knowledge.domain.OcrmFwpInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @项目名称: yscrm-mgr-knowledge-base-core模块
 * @类名称: OcrmFwpInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-30 17:48:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpInfoMapper extends CommonMapper<OcrmFwpInfo> {
	
	/**
	 * @方法名称: listByModel
	 * @方法描述: 条件列表查询
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<Map<String, Object>> listByModel(QueryModel model);
	List<Map<String, Object>> listByModel1(QueryModel model);

	/**
	 * @函数名称:queryById
	 * @函数描述:查询知识库数据，公共API接口
	 * @参数与返回说明:
	 * @param bizSeqNo
	 * @算法描述:
	 */
	Map<String, Object> queryById(@Param("bizSeqNo") String bizSeqNo);
	
    /**
     * @方法名称: deleteByMessageIds
     * @方法描述: 删除  - 根据 知识库编号字段 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int deleteByMessageIds(String[] messageIds);
    
    /**
     * @方法名称: deleteFilesByBusno
     * @方法描述: 删除  - 根据业务编号 删除 附件表中数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int deleteFilesByBusno(String[] busno);

	/**
	 * @方法名称: updatePublishData
	 * @方法描述: 更新 知识库数据发布
	 * @参数与返回说明:
	 * @算法描述: 无
	 */
	int updatePublishData(OcrmFwpInfo OcrmFwpInfo);

	/**
	 * @函数名称:sameInfo
	 * @函数描述:校验  - 根据 栏目编号,以及文档名称判断该栏目下是否有相同名称的文档
	 * @参数与返回说明:
	 * @算法描述:
	 */
    int sameInfo(Map<String,String> map);
}