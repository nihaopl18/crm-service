package cn.com.yusys.yscrm.custpub.web.rest;

import cn.com.yusys.yscrm.custpub.service.HeadBankInfoService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: HeadBankInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-26 17:24:31
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/headbankinfo")
public class HeadBankInfoResource{

    @Autowired
    private HeadBankInfoService headBankInfoService;

    @GetMapping("/getBusiView")
    public ResultDto<List<Map<String, Object>>> getBusiView(){
        return new ResultDto<List<Map<String, Object>>>(1,headBankInfoService.getBusiView());
    }

    @GetMapping("/getCustView")
    public ResultDto<Map<String, Object>> getCustView(){
        return new ResultDto<Map<String, Object>>(1,headBankInfoService.getCustView());
    }

    @GetMapping("/getEmpView")
    public ResultDto<Map<String, Object>> getEmpView(){
        return new ResultDto<Map<String, Object>>(1,headBankInfoService.getEmpView());
    }
}
