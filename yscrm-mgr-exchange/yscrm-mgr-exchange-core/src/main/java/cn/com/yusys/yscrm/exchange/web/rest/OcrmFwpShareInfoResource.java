package cn.com.yusys.yscrm.exchange.web.rest;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yscrm.exchange.domain.OcrmFwpShareInfo;
import cn.com.yusys.yscrm.exchange.domain.OcrmFwpShareReplyInfo;
import cn.com.yusys.yscrm.exchange.service.OcrmFwpShareInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-exchange-core模块
 * @类名称: OcrmFwpShareInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-26 22:10:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/infoexchange")
public class OcrmFwpShareInfoResource extends CommonResource<OcrmFwpShareInfo, String> {
    @Autowired
    private OcrmFwpShareInfoService ocrmFwpShareInfoService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFwpShareInfoService;
    }

    /**
     * @函数名称:queryList
     * @函数描述: 交流主题 列表查询，公共API接口
     * @参数与返回说明:
     * @param QueryModel
     *            分页查询类
     * @算法描述:
     */
    @GetMapping("/querylist")
    @Timed
    protected ResultDto<List<OcrmFwpShareInfo>> queryList(QueryModel queryModel) {
    	List<OcrmFwpShareInfo> list = null;
		list = ocrmFwpShareInfoService.queryList(queryModel);
        return new ResultDto<List<OcrmFwpShareInfo>>(list);
    }
    
    /**
     * @函数名称:add
     * @函数描述: 新增 交流主题 数据
     * @参数与返回说明:
     * @param ocrmFwpShareInfo 
     * @算法描述:
     */
    @PostMapping("/add")
    @Timed
    protected ResultDto<Integer> add(@RequestBody OcrmFwpShareInfo ocrmFwpShareInfo) throws URISyntaxException {
    	Integer result = ocrmFwpShareInfoService.insertData(ocrmFwpShareInfo);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:update
     * @函数描述: 修改 交流主题 数据
     * @参数与返回说明:
     * @param ocrmFwpShareInfo 
     * @算法描述:
     */
    @PostMapping("/update")
    @Timed
    protected ResultDto<Integer> update(@RequestBody OcrmFwpShareInfo ocrmFwpShareInfo) throws URISyntaxException {
    	Integer result = ocrmFwpShareInfoService.updateData(ocrmFwpShareInfo);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:delete
     * @函数描述:交流主题 删除  - 根据 主键 逻辑删除
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/delete")
    @Timed
    protected ResultDto<Integer> delete(@RequestBody String shareIds) {
        int result = ocrmFwpShareInfoService.deleteByShareIds(shareIds);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:queryReplyCount
     * @函数描述: 交流评论 查询评论总数
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/queryReplyCount")
    @Timed
    protected ResultDto<Integer> queryReplyCount(@RequestParam(value = "shareId", required = true) String shareId) {
    	Integer result = 0;
    	// 校验必输项
    	if(!StringTools.isEmpty(shareId)) {
    		result = ocrmFwpShareInfoService.queryReplyCount(shareId);
    	}
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:queryReply
     * @函数描述: 交流评论 列表查询，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/queryreply")
    @Timed
    protected ResultDto<List<OcrmFwpShareReplyInfo>> queryReply(@RequestParam(value = "shareId", required = true) String shareId,
    		@RequestParam(value="currentPage") Integer currentPage, @RequestParam(value="pageSize") Integer pageSize) {
    	List<OcrmFwpShareReplyInfo> list = null;
    	// 校验必输项
    	if(!StringTools.isEmpty(shareId)) {
    		list = ocrmFwpShareInfoService.queryReply(shareId, currentPage, pageSize);
    	}
        return new ResultDto<List<OcrmFwpShareReplyInfo>>(list);
    }
    
    /**
     * @函数名称:addReply
     * @函数描述: 新增 交流评论/回复 数据
     * @参数与返回说明:
     * @param ocrmFwpShareReplyInfo 
     * @算法描述:
     */
    @PostMapping("/addreply")
    @Timed
    protected ResultDto<Integer> addReply(@RequestBody OcrmFwpShareReplyInfo ocrmFwpShareReplyInfo) throws URISyntaxException {
    	Integer result = ocrmFwpShareInfoService.addReply(ocrmFwpShareReplyInfo);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:querySubReply
     * @函数描述: 交流回复 列表查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querysubreply")
    @Timed
    protected ResultDto<List<OcrmFwpShareReplyInfo>> querySubReply(@RequestParam(value = "replyId", required = true) String replyId) {
    	List<OcrmFwpShareReplyInfo> list = null;
    	// 校验必输项
    	if(!StringTools.isEmpty(replyId)) {
    		list = ocrmFwpShareInfoService.querySubReply(replyId);
    	}
        return new ResultDto<List<OcrmFwpShareReplyInfo>>(list);
    }
}
