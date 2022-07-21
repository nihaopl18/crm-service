package cn.com.yusys.yusp.dycrm.complaintfeedback.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.CustomerInformationDTO;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.OcrmFClComplaintSheet;
import cn.com.yusys.yusp.dycrm.complaintfeedback.service.OcrmFClComplaintSheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/complaintFeedBackResources")
public class OcrmFClComplaintSheetResources {

    private final Logger log = LoggerFactory.getLogger(OcrmFClComplaintSheetResources.class);

    @Autowired
    private OcrmFClComplaintSheetService ocrmFClComplaintSheetService;


    @GetMapping("/queryprepare") //查询投诉反馈
    public ResultDto<List<Map<String,Object>>> queryPrepare(QueryModel queryModel){

        return new ResultDto<>(ocrmFClComplaintSheetService.queryPrepare(queryModel));
    }

    @GetMapping("/queryComplaintSheetInfo") //查询投诉反馈详情
    public ResultDto<CustomerInformationDTO> queryComplaintSheetInfo(QueryModel queryModel){
        return new ResultDto<>(ocrmFClComplaintSheetService.queryComplaintSheetInfo(queryModel));
    }


    @GetMapping("/saveData") //投诉反馈保存
    public ResultDto<Integer> saveData(QueryModel queryModel)  {
        ResultDto<Integer> resultDto = new ResultDto<>();
        int result = ocrmFClComplaintSheetService.saveData(queryModel);
        if(result>0){
            resultDto.setCode(0);
            resultDto.setMessage("保存成功");
            return resultDto;
        }else{
            resultDto.setCode(-1);
            resultDto.setMessage("保存失败！");
            return resultDto;
        }
    }





}
