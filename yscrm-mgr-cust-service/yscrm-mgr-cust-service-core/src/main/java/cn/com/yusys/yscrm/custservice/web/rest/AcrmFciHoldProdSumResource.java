package cn.com.yusys.yscrm.custservice.web.rest;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custservice.domain.AcrmFciHoldProdSum;
import cn.com.yusys.yscrm.custservice.service.AcrmFciHoldProdSumService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.micrometer.core.annotation.Timed;


/**
 * @项目名称: ccccc模块
 * @类名称: AcrmFciHoldProdSumResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 18:08:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciholdprodsum")
public class AcrmFciHoldProdSumResource extends CommonResource<AcrmFciHoldProdSum, String> {
    @Autowired
    private AcrmFciHoldProdSumService acrmFciHoldProdSumService;

    @Override
    protected CommonService getCommonService() {
        return acrmFciHoldProdSumService;
    }
    @GetMapping("/queryAll")
	@Timed
	protected ResultDto<List<AcrmFciHoldProdSum>> queryAll(QueryModel queryModel) {
		List<AcrmFciHoldProdSum> list = acrmFciHoldProdSumService.queryAll(queryModel);
		System.out.println(list);
		return new ResultDto<List<AcrmFciHoldProdSum>>(list);
	}
}
