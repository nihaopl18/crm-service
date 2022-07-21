package cn.com.yusys.yscrm.product.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yscrm.product.domain.OcrmFsysRicheditInfo;
import cn.com.yusys.yscrm.product.service.OcrmFsysRicheditInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysRicheditInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 17:43:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysricheditinfo")
public class OcrmFsysRicheditInfoResource extends CommonResource<OcrmFsysRicheditInfo, String> {
    @Autowired
    private OcrmFsysRicheditInfoService ocrmFsysRicheditInfoService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFsysRicheditInfoService;
    }
    
    /**
     * @函数名称:richTextInformationQuery
     * @函数描述: 产品视图-富文本信息查询
     * @参数与返回说明:
     * @param QueryModel
     *            分页查询类
     * @算法描述:
     */
    @GetMapping("/richtextinformationquery/{prodId}")
    @Timed
    protected ResultDto<List<OcrmFsysRicheditInfo>> richTextInformationQuery(QueryModel queryModel, @PathVariable String prodId) {
    	List<OcrmFsysRicheditInfo> list = null;
		list = ocrmFsysRicheditInfoService.richTextInformationQuery(queryModel, prodId);
        return new ResultDto<List<OcrmFsysRicheditInfo>>(list);
    }
    
	/**
     * @函数名称:add
     * @函数描述: 产品视图-富文本信息新增
     * @参数与返回说明:
     * @param ocrmFwpShareInfo 
     * @算法描述:
     */
    @PostMapping("/add")
    @Timed
    protected ResultDto<Integer> add(@RequestBody OcrmFsysRicheditInfo ocrmFsysRicheditInfo) throws URISyntaxException {
    	Integer result = ocrmFsysRicheditInfoService.insertData(ocrmFsysRicheditInfo);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:update
     * @函数描述: 产品视图-富文本信息修改
     * @参数与返回说明:
     * @param ocrmFwpShareInfo 
     * @算法描述:
     */
    @PostMapping("/update")
    @Timed
    protected ResultDto<Integer> update(@RequestBody OcrmFsysRicheditInfo ocrmFwpShareInfo) throws URISyntaxException {
    	Integer result = ocrmFsysRicheditInfoService.updateData(ocrmFwpShareInfo);
        return new ResultDto<Integer>(result);
    }

}
