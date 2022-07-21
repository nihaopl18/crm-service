package cn.com.yusys.yscrm.fiexdstatement.web.rest;

import cn.com.yusys.yscrm.fiexdstatement.service.OcrmFClAumbalanceService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/OcrmFClAumbalance")
public class OcrmFClAumbalanceResources {

    @Autowired
    private OcrmFClAumbalanceService ocrmFClAumbalanceService;

    private final Logger log = LoggerFactory.getLogger(OcrmFClAumbalanceResources.class);


    @GetMapping("/getbalancelist")
    public ResultDto<List<Map<String,Object>>> getBalanceList(QueryModel queryModel){
        List<Map<String,Object>> list=null;
        list=ocrmFClAumbalanceService.getBalanceList(queryModel);
        return new ResultDto<>(list);
    }

    @GetMapping("/export")
    public void daochuBranchtotalToExcel(HttpServletResponse response, QueryModel model) {
        try {
            ocrmFClAumbalanceService.export(response,model);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }

}
