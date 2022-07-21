package cn.com.yusys.yusp.uimp.business.pma.app.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.PmaAppNews;
import cn.com.yusys.yusp.uimp.business.pma.app.service.PmaAppNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: PmaAppNewsResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-03 10:48:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmaappnews")
public class PmaAppNewsResource extends CommonResource<PmaAppNews, String> {
	
    @Autowired
    private PmaAppNewsService pmaAppNewsService;

    @Override
    protected CommonService getCommonService() {
        return pmaAppNewsService;
    }
    
    @GetMapping("/querylist")
    public ResultDto<Object> queryList(QueryModel model){
		List<Map<String, Object>> list = this.pmaAppNewsService.queryList(model);
		return new ResultDto<Object>(list);
    }
    
    @PostMapping("/saveorupdate")
    public ResultDto<Object> saveOrUpdate(@RequestBody PmaAppNews pmaAppNews) {
    	return pmaAppNewsService.saveOrUpdate(pmaAppNews);
    }
    
    @PostMapping("/remove/{id}")
    public ResultDto<Integer> remove(@PathVariable String id) {
    	int result = pmaAppNewsService.deleteByPrimaryKey(id);
    	return new ResultDto<Integer>(result);
    }

}
