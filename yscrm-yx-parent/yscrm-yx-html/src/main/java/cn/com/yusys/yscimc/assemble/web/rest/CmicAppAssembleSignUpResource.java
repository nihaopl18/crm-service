package cn.com.yusys.yscimc.assemble.web.rest;

import cn.com.yusys.yscimc.assemble.service.CmicAppAssembleSignUpService;
import cn.com.yusys.yscimc.assemble.vo.CmicAppAssembleSignUpVo;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0.0
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleSignUpResource
 * @类描述: #资源类
 * @功能描述: 客户报名信息服务类
 * @创建人: houyx3
 * @创建时间: 2021-12-30
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmicappassemblesignup")
public class CmicAppAssembleSignUpResource {

    @Autowired
    private CmicAppAssembleSignUpService service;

    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody CmicAppAssembleSignUpVo entity){

        return new ResultDto<>(service.save(entity));
    }

    @GetMapping("/getInfoById")
    public ResultDto<CmicAppAssembleSignUpVo> getInfoById(String id){

        return new ResultDto<>(service.getInfoById(id));
    }

}
