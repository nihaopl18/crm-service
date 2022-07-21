package cn.com.yusys.yscrm.exchange.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.exchange.domain.OcrmFwpShareReplyInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yscrm-mgr-exchange-core模块
 * @类名称: OcrmFwpShareReplyInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-26 22:11:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpShareReplyInfoMapper extends CommonMapper<OcrmFwpShareReplyInfo> {
	
	/**
	 * @方法名称: queryReplyCount
	 * @方法描述: 交流评论 查询评论总数
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	Integer queryReplyCount(@Param("shareId") String shareId);
	
	/**
	 * @方法名称: queryReply
	 * @方法描述: 交流评论 列表查询 -- 分页
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<OcrmFwpShareReplyInfo> queryReply(@Param("shareId") String shareId, 
			@Param("startNum") Integer startNum, @Param("endNum") Integer endNum);
	
	/**
	 * @方法名称: querySubReply
	 * @方法描述: 交流回复 列表查询
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<OcrmFwpShareReplyInfo> querySubReply(@Param("replyId") String replyId);
}