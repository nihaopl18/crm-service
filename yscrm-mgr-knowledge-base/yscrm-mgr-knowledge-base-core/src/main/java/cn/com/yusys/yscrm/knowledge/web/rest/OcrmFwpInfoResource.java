package cn.com.yusys.yscrm.knowledge.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yscrm.knowledge.domain.OcrmFwpInfo;
import cn.com.yusys.yscrm.knowledge.domain.OcrmFwpInfoSection;
import cn.com.yusys.yscrm.knowledge.service.OcrmFwpInfoSectionService;
import cn.com.yusys.yscrm.knowledge.service.OcrmFwpInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-knowledge-base-core模块
 * @类名称: OcrmFwpInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-30 17:48:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/infoknowledge")
public class OcrmFwpInfoResource extends CommonResource<OcrmFwpInfo, String> {
    @Autowired
    private OcrmFwpInfoService ocrmFwpInfoService;
    
    @Autowired
    private OcrmFwpInfoSectionService ocrmFwpInfoSectionService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFwpInfoService;
    }

    /**
     * @函数名称:queryList
     * @函数描述:查询知识库数据，公共API接口
     * @参数与返回说明:
     * @param queryModel
     *            分页查询类
     * @算法描述:
     */
    @GetMapping("/querylist")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
        List<Map<String, Object>> list = ocrmFwpInfoService.listByModel(queryModel);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     * @函数名称:queryById
     * @函数描述:查询知识库数据，公共API接口
     * @参数与返回说明:
     * @param bizSeqNo
     * @算法描述:
     */
    @GetMapping("/querybyid")
    @Timed
    protected ResultDto<Map<String, Object>> queryById(@RequestParam(value = "bizSeqNo") String bizSeqNo) {
        Map<String, Object> list = ocrmFwpInfoService.queryById(bizSeqNo);
        return new ResultDto<>(list);
    }

    /**
     * @函数名称:add
     * @函数描述: 新增知识库数据
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/add")
    @Timed
    protected ResultDto<String> add(@RequestBody OcrmFwpInfo ocrmFwpInfo) throws URISyntaxException {
        String messageId = ocrmFwpInfoService.add(ocrmFwpInfo);
        return new ResultDto<String>(messageId);
    }
    
    /**
     * @函数名称:update
     * @函数描述:更新 知识库数据
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/update")
    @Timed
    protected ResultDto<Integer> update(@RequestBody OcrmFwpInfo OcrmFwpInfo) throws URISyntaxException {
        int result = ocrmFwpInfoService.updateData(OcrmFwpInfo);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:delete
     * @函数描述:删除  - 根据 报告编号字段 逻辑删除
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/delete")
    @Timed
    protected ResultDto<Integer> delete(@RequestBody String messageIds) {
        int result = ocrmFwpInfoService.deleteByMessageIds(messageIds);
        return new ResultDto<Integer>(result);
    }

    /**
     * @函数名称:sameInfo
     * @函数描述:校验  - 根据 栏目编号,以及文档名称判断该栏目下是否有相同名称的文档
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/sameinfo")
    @Timed
    protected ResultDto<Boolean> sameInfo(OcrmFwpInfo ocrmFwpInfo) {
        boolean result = ocrmFwpInfoService.sameInfo(ocrmFwpInfo);
        return new ResultDto<Boolean>(result);
    }
    
    /**
     * @函数名称:queryList
     * @函数描述:查询知识库栏目数据，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querysection")
    @Timed
    protected ResultDto<List<Map<String, Object>>> querySection() {
        List<Map<String, Object>> list = ocrmFwpInfoSectionService.querySection();
        return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * @函数名称:insertSection
     * @函数描述:新增知识库栏目数据
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/insertsection")
    @Timed
    protected ResultDto<Integer> insertSection(@RequestBody OcrmFwpInfoSection ocrmFwpInfoSection) throws URISyntaxException {
        int result = ocrmFwpInfoSectionService.insertSection(ocrmFwpInfoSection);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:updateSection
     * @函数描述:更新知识库栏目数据
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/updatesection")
    @Timed
    protected ResultDto<Integer> updateSection(@RequestBody OcrmFwpInfoSection ocrmFwpInfoSection) throws URISyntaxException {
        int result = ocrmFwpInfoSectionService.updateSection(ocrmFwpInfoSection);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:deleteSection
     * @函数描述:删除  - 根据 栏目编号字段， 删除该栏目及其下所有栏目数据 逻辑删除
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deletesection")
    @Timed
    protected ResultDto<Integer> deleteSection(@RequestBody String sectionId) {
        int result = ocrmFwpInfoSectionService.deleteSection(sectionId);
        return new ResultDto<Integer>(result);
    }

    /**
     * @函数名称:sameSection
     * @函数描述:校验  - 根据 栏目编号字段， 以及目录名称判断该栏目下是否有相同名称的目录
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/samesection")
    @Timed
    protected ResultDto<Boolean> sameSection(OcrmFwpInfoSection ocrmFwpInfoSection) {
        boolean result = ocrmFwpInfoSectionService.sameSection(ocrmFwpInfoSection);
        return new ResultDto<Boolean>(result);
    }
}
