package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.service.YscimcFmkActiShareService;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiShareVo;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @项目名称: yscimc-cust-cm模块
 * @类名称: YscimcFmkActiShareResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2022-01-13 09:35:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/yscimcfmkactishare")
public class YscimcFmkActiShareResource {

    @Autowired
    private YscimcFmkActiShareService yscimcFmkActiShareService;




    @GetMapping("getInfoByAssemble")
    public ResultDto<YscimcFMkActiShareVo> getInfoByAssemble(String nodeId){
        return new ResultDto<>(yscimcFmkActiShareService.getInfoByAssemble(nodeId));
    }

    @PostMapping("save")
    public ResultDto<Integer> add(@RequestBody YscimcFMkActiShareVo vo){
    	return new ResultDto<>(yscimcFmkActiShareService.save(vo));
    }
}
