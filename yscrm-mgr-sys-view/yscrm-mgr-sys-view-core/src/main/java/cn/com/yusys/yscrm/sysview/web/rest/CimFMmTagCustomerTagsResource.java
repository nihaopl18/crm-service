package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yscrm.sysview.service.CimFMmTagCustomerTagsService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 客户标签
 *
 * @author: sxm
 * @time: 2021/9/6 11:30
 */
@RestController
@RequestMapping("/api/cimfmmtagcusttag")
public class CimFMmTagCustomerTagsResource {
    @Autowired
    private CimFMmTagCustomerTagsService cimFMmTagCustomerTagsService;

    @PostMapping("/settagdisplay")
    public ResultDto<Integer> setTagDisplay(@RequestBody TagDisplay tagDisplay){
        return new ResultDto<Integer>(cimFMmTagCustomerTagsService.setTagDisplay(tagDisplay));
    }
    @GetMapping("/custsystag")
    public ResultDto<List<CustSysGroup>> custSysTag(QueryModel queryModel){
        return new ResultDto(cimFMmTagCustomerTagsService.custSysTag(queryModel));
    }

    @PostMapping("/inserttag")
    public ResultDto<CimFMmTagTagsInfo> insertTagList(@Valid @RequestBody CimFMmTagTagsInfo tag) throws ParseException{
        return this.cimFMmTagCustomerTagsService.insertTagList(tag);
    }

    @PostMapping("/addcusttag")
    public ResultDto<Integer> addcusttag(@Valid @RequestBody CimFMmTagTagsInfo tag) throws ParseException{
        Integer result = this.cimFMmTagCustomerTagsService.addcusttag(tag);
        return new ResultDto<>(result);
    }

    @GetMapping("/removecusttag")
    public ResultDto<Integer> removecusttag(@RequestParam("tagNo") String tagNo, @RequestParam("custId") String custId) throws ParseException{
        Integer result = this.cimFMmTagCustomerTagsService.removecusttag(tagNo, custId);
        return new ResultDto<>(result);
    }
}
