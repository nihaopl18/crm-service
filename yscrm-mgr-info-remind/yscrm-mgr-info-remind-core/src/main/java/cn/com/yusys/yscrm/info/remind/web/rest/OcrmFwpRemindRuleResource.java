package cn.com.yusys.yscrm.info.remind.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yscrm.info.remind.domain.OcrmFwpRemindRule;
import cn.com.yusys.yscrm.info.remind.service.OcrmFwpRemindRuleService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindRuleResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-19 09:00:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/inforeminderrule")
public class OcrmFwpRemindRuleResource extends CommonResource<OcrmFwpRemindRule, String> {
    @Autowired
    private OcrmFwpRemindRuleService ocrmFwpRemindRuleService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFwpRemindRuleService;
    }

    /**
     * @函数名称:queryTree
     * @函数描述: 查询提醒规则树，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querytree")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryTree() {
        List<Map<String, Object>> list = ocrmFwpRemindRuleService.queryTree();
        return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * @函数名称:queryList
     * @函数描述: 提醒规则 列表查询，公共API接口
     * @参数与返回说明:
     * @param QueryModel
     *            分页查询类
     * @算法描述:
     */
    @GetMapping("/querylist")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
    	List<Map<String, Object>> list = null;
    	// 校验必输项
    	if(queryModel.getCondition().containsKey("typeId") && !StringTools.isEmpty(queryModel.getCondition().get("typeId") + "")) {
    		list = ocrmFwpRemindRuleService.queryList(queryModel);
    	}
        return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * @函数名称:queryChl
     * @函数描述: 提醒渠道查询，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querychl")
    @Timed
    protected ResultDto<List<Map<String, Object>>> queryChl() {
    	List<Map<String, Object>> list = null;
		list = ocrmFwpRemindRuleService.queryChl();
        return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * @函数名称:insert
     * @函数描述: 新增 提醒规则 数据
     * @参数与返回说明:
     * @param ocrmFwpSchedule 
     * @算法描述:
     */
    @PostMapping("/insert")
    @Timed
    protected ResultDto<Integer> insert(@RequestBody OcrmFwpRemindRule ocrmFwpRemindRule) throws URISyntaxException {
    	Integer result = ocrmFwpRemindRuleService.insertData(ocrmFwpRemindRule);
        return new ResultDto<Integer>(result);
    }
    
    /**
     * @函数名称:update
     * @函数描述: 修改 提醒规则 数据
     * @参数与返回说明:
     * @param ocrmFwpSchedule 
     * @算法描述:
     */
    @PostMapping("/update")
    @Timed
    protected ResultDto<Integer> update(@RequestBody OcrmFwpRemindRule ocrmFwpRemindRule) throws URISyntaxException {
    	Integer result = ocrmFwpRemindRuleService.updateData(ocrmFwpRemindRule);
        return new ResultDto<Integer>(result);
    }
}
