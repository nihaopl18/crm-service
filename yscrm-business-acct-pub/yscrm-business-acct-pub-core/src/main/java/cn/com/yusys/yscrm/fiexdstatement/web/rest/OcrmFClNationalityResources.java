package cn.com.yusys.yscrm.fiexdstatement.web.rest;

import cn.com.yusys.yscrm.fiexdstatement.service.OcrmFClNationalityService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/OcrmFClNationality")
public class OcrmFClNationalityResources {

    @Autowired
    private OcrmFClNationalityService ocrmFClNationalityService;

    @GetMapping("/getList")
    public ResultDto<List<Map<String,Object>>> getList(QueryModel queryModel){
        return new ResultDto<List<Map<String,Object>>>(ocrmFClNationalityService.getList(queryModel));
    }

}
