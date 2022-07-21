package cn.com.yusys.yscrm.fiexdstatement.web.rest;

import cn.com.yusys.yscrm.fiexdstatement.service.OcrmFClPersonalDetailService;
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
@RequestMapping("/api/OcrmFClPersonalDetail")
public class OcrmFClPersonalDetailResource {


    private final Logger log = LoggerFactory.getLogger(OcrmFClPersonalDetailResource.class);


    @Autowired
    private OcrmFClPersonalDetailService ocrmFClPersonalDetailService;

    @GetMapping("/querydetaillist")
    public ResultDto<List<Map<String, Object>>> queryDetailList(QueryModel queryModel){
        //权限判断
        ResultDto<List<Map<Object, String>>> resultDto = null;

        List<Map<String, Object>> list = ocrmFClPersonalDetailService.queryDetailList(queryModel);
        return new ResultDto<>(list);

    }

    @GetMapping("/export")
    public void daochuBranchtotalToExcel(HttpServletResponse response, QueryModel model) {
        try {
            ocrmFClPersonalDetailService.export(response,model);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }


}
