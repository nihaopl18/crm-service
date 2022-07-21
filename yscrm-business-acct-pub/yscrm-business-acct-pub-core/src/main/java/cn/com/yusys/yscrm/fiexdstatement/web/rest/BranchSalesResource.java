package cn.com.yusys.yscrm.fiexdstatement.web.rest;

import cn.com.yusys.yscrm.fiexdstatement.service.BranchSalesService;
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
@RequestMapping("/api/branchSalesResource")
public class BranchSalesResource {

    @Autowired
    private BranchSalesService branchSalesService;

    private final Logger log = LoggerFactory.getLogger(BranchSalesResource.class);

    //查询列表
    @GetMapping("/queryBranch")
    public ResultDto<List<Map<String,Object>>> queryList(QueryModel queryModel){
        return new ResultDto<>(branchSalesService.queryList(queryModel));
    }


    @GetMapping("/export")
    public void daochuBranchtotalToExcel(HttpServletResponse response, QueryModel model) {
        try {
            branchSalesService.export(response,model);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }



}
