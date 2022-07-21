package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.service.AcrmAbrBusiSumInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/15 20:37
 */
@RestController
@RequestMapping("/api/acrmabrbusisuminfo")
public class AcrmAbrBusiSumInfoResource {
    @Autowired
    private AcrmAbrBusiSumInfoService acrmAbrBusiSumInfoService;

    private final Logger log = LoggerFactory.getLogger(AcrmAbrBusiSumInfoResource.class);

    /**
     * 产品信息
     *
     * @param queryModel
     * @return
     */
    @GetMapping("/rank")
    public ResultDto<Map<String, Object>> getRank(QueryModel queryModel) {
        return new ResultDto(acrmAbrBusiSumInfoService.getProdHoldDeInfo(queryModel));
    }

    /**
     * 产品配置比例
     *
     * @param queryModel
     * @return
     */
    @GetMapping("/ratio")
    public ResultDto<Map<String, Object>> getRatio(QueryModel queryModel) {
        return new ResultDto(acrmAbrBusiSumInfoService.getProdConfRaInfo(queryModel));
    }


    /**
     * 导出
     *
     * @param
     */
    @GetMapping("/export")
    @ResponseBody
    public void daochuStatisticToExcel(HttpServletResponse response, QueryModel queryModel) {
        try {
            acrmAbrBusiSumInfoService.export(response,queryModel);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }


}
