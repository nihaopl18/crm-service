package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.service.YscimcFmkActiFissionService;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiFissionVo;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscimc-cust-group模块
 * @类名称: YscimcFmkActiFissionResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-06-12 09:35:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/yscimcfmkactifission")
public class YscimcFmkActiFissionResource {

    @Autowired
    private YscimcFmkActiFissionService yscimcFmkActiFissionService;



    @GetMapping("list")
    public ResultDto<List<Map<String, Object>>> getListByModel(QueryModel model){
    	return new ResultDto<List<Map<String, Object>>>(yscimcFmkActiFissionService.getListByModel(model));
    }

    @GetMapping("getInfoByAssemble")
    public ResultDto<YscimcFMkActiFissionVo> getInfoByAssemble(String nodeId){
        return new ResultDto<YscimcFMkActiFissionVo>(yscimcFmkActiFissionService.getInfoByAssemble(nodeId));
    }

    @PostMapping("save")
    public ResultDto<Integer> add(@RequestBody YscimcFMkActiFissionVo vo){
    	return new ResultDto<Integer>(yscimcFmkActiFissionService.save(vo));
    }

}
