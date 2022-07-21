package cn.com.yusys.yscrm.exchange.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.exchange.domain.OcrmFwpShareInfo;
import cn.com.yusys.yscrm.exchange.domain.OcrmFwpShareReplyInfo;
import cn.com.yusys.yscrm.exchange.repository.mapper.OcrmFwpShareInfoMapper;
import cn.com.yusys.yscrm.exchange.repository.mapper.OcrmFwpShareReplyInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-mgr-exchange-core模块
 * @类名称: OcrmFwpShareInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-26 22:10:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpShareInfoService extends CommonService {
    @Autowired
    private OcrmFwpShareInfoMapper ocrmFwpShareInfoMapper;

    @Autowired
    private OcrmFwpShareReplyInfoMapper ocrmFwpShareReplyInfoMapper;
    
	@Autowired
	private UaaClient uaaClient;
	
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpShareInfoMapper;
    }
    
    /**
     * @方法名称: queryList
     * @方法描述: 交流主题 列表查询，公共API接口 - 查询进行分页
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public List<OcrmFwpShareInfo> queryList(QueryModel model) {
    	List<OcrmFwpShareInfo> list = null;
    	// 主题名称 模糊查询
		if(model.getCondition().get("shareName") != null && !StringTools.isEmpty(model.getCondition().get("shareName") + "")) {
			model.getCondition().put("shareName", "%" + model.getCondition().get("shareName") + "%");
		}
    	model.getCondition().put("isDelete", "N");
    	PageHelper.startPage(model.getPage(), model.getSize());
    	list = ocrmFwpShareInfoMapper.queryList(model);
    	PageHelper.clearPage();
    	return list;
    }
    
    /**
     * @方法名称: insertData
     * @方法描述: 新增 交流主题 数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Integer insertData(OcrmFwpShareInfo ocrmFwpShareInfo) {
    	// TODO 异常处理
    	Integer result = 0;
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpShareInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFwpShareInfo.setCreateTime(new Date());
    	ocrmFwpShareInfo.setIsDelete("N");
    	result = this.insertSelective(ocrmFwpShareInfo);
    	return result;
    }
    
    /**
     * @方法名称: updateData
     * @方法描述: 更新 交流主题 数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Integer updateData(OcrmFwpShareInfo ocrmFwpShareInfo) {
    	// TODO 异常处理
    	Integer result = 0;
    	ocrmFwpShareInfo.setUpdateTime(new Date());
    	result = this.updateSelective(ocrmFwpShareInfo);
    	return result;
    }
    
    /**
     * @方法名称: deleteByShareIds
     * @方法描述: 交流主题 删除  - 根据 主键字段 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public int deleteByShareIds(String shareIds) {
    	// TODO 增加异常处理 
    	int result = 0;
    	if (shareIds != null && !"".equals(shareIds)) {
            String[] ids = shareIds.split(",");
            result = ocrmFwpShareInfoMapper.deleteByShareIds(ids);
    	}
        return result;
    }
    
    /**
     * @方法名称: queryReplyCount
     * @方法描述: 	交流评论 查询评论总数
     * @参数与返回说明: 
     * @param shareId 主题id
     * @算法描述: 无
     */
    public Integer queryReplyCount(String shareId) {
    	Integer result = 0;
    	result = ocrmFwpShareReplyInfoMapper.queryReplyCount(shareId);
    	return result;
    }
    
    /**
     * @方法名称: queryReply
     * @方法描述: 交流评论 列表查询，公共API接口 - 查询进行分页
     * @参数与返回说明: 
     * @param shareId 主题id
     * @param currentPage 当前页数
     * @param pageSize 页容量
     * @算法描述: 无
     */
    public List<OcrmFwpShareReplyInfo> queryReply(String shareId, Integer currentPage, Integer pageSize) {
    	List<OcrmFwpShareReplyInfo> list = null;
    	Integer startNum = 0;
    	Integer endNum = 0;
    	if(currentPage == null || pageSize == null) {
    		startNum = 1;
    		endNum = 6;
    	} else {
    		startNum = (currentPage - 1) * pageSize + 1;
    		endNum = currentPage * pageSize;
    	}
		list = ocrmFwpShareReplyInfoMapper.queryReply(shareId, startNum, endNum);
    	return list;
    }
    
    /**
     * @方法名称: addReply
     * @方法描述: 新增 交流评论/回复 数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
    public Integer addReply(OcrmFwpShareReplyInfo ocrmFwpShareReplyInfo) {
    	// TODO 异常处理
    	Integer result = 0;
    	ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFwpShareReplyInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFwpShareReplyInfo.setCreateTime(new Date());
    	result = ocrmFwpShareReplyInfoMapper.insertSelective(ocrmFwpShareReplyInfo);
    	return result;
    }
    
    /**
     * @方法名称: querySubReply
     * @方法描述: 交流回复 列表查询
     * @参数与返回说明: 
     * @param replyId 回复id
     * @算法描述: 无
     */
    public List<OcrmFwpShareReplyInfo> querySubReply(String replyId) {
    	List<OcrmFwpShareReplyInfo> list = null;
		list = ocrmFwpShareReplyInfoMapper.querySubReply(replyId);
    	return list;
    }
}
