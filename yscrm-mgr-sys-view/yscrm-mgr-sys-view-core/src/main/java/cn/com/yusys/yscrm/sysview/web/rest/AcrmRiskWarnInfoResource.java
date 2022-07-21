package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.service.AcrmFciRiskWarnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/13 10:56
 */
@RestController
@RequestMapping("/api/acrmfciriskwarninfo")
public class AcrmRiskWarnInfoResource {
    @Autowired
    private AcrmFciRiskWarnInfoService acrmFciRiskWarnInfoService;

    /**
     * 风险信息
     *
     * @param queryModel
     * @return
     */
    @GetMapping("/querylist")
    public ResultDto<Map<String, Object>> getView(QueryModel queryModel) {
        return new ResultDto(acrmFciRiskWarnInfoService.getRiskInfo(queryModel));
    }
}
