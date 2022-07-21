package cn.com.yusys.yusp.dycrm.transferInfo.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.AcrmFCustAcctInfo;
import cn.com.yusys.yusp.dycrm.transferInfo.service.AcrmFCustAcctInfoService;
import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: dycrm-transferInfo模块
 * @类名称: AcrmFCustAcctInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-09-02 16:47:01
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfcustacctinfo")
public class AcrmFCustAcctInfoResource extends CommonResource<AcrmFCustAcctInfo, String> {
    @Autowired
    private AcrmFCustAcctInfoService acrmFCustAcctInfoService;

    @Override
    protected CommonService getCommonService() {
        return acrmFCustAcctInfoService;
    }

    @GetMapping("/querySubAcctNo")
    @Timed
    protected ResultDto<List<String>> querySubAcctNo(QueryModel queryModel) {
        List<String> list = acrmFCustAcctInfoService.querySubAcctNo(queryModel);
        return new ResultDto<List<String>>(list);
    }

}
