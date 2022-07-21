package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.domain.CiUserAssetsDTO;
import cn.com.yusys.yscrm.sysview.domain.CrmFCiUserAssetsVO;
import cn.com.yusys.yscrm.sysview.domain.CrmFCiUserInformation;
import cn.com.yusys.yscrm.sysview.service.PcustBaseInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/12 15:29
 */
@RestController
@RequestMapping("/api/pcustbaseinfo")
@Api(value = "pcustbaseinfo", description = "360视图管理")
public class PcustBaseViewIfo {
    @Autowired
    private PcustBaseInfoService PCustBaseInfoService;
    /**
     * 基础信息
     * @param queryModel
     * @return
     */
    @GetMapping("/querylist")
    public ResultDto<Map<String, Object>> getView(QueryModel queryModel) {
        return new ResultDto(PCustBaseInfoService.getBaseInfo(queryModel));
    }

    /**
     * 手工维护基础信息
     * @param queryModel
     * @return
     */
    @GetMapping("/queryCustlist")
    @ApiOperation(value = "手工维护基础信息")
    public ResultDto<CrmFCiUserAssetsVO> queryCustlist(QueryModel queryModel) {
        return new ResultDto(PCustBaseInfoService.queryCustlist(queryModel));
    }

    //修改客户基本信息
    @PostMapping("/updateCust")
    @ApiOperation(value = "修改客户基本信息")
    public ResultDto<Integer> updateCust(@RequestBody CrmFCiUserInformation crmFCiUserInformation) throws Exception {
        ResultDto<Integer> resultDto = null;
        int num = PCustBaseInfoService.checkUpNameId(crmFCiUserInformation.getSeqno());
        if (num == 0) {
            resultDto = new ResultDto<>(PCustBaseInfoService.insertCust(crmFCiUserInformation));
            resultDto.setCode(0);
            resultDto.setMessage("修改成功");
            return resultDto;
        }else if(num == 1){
            resultDto = new ResultDto<>(PCustBaseInfoService.updateCust(crmFCiUserInformation));
            resultDto.setCode(0);
            resultDto.setMessage("修改成功");
            return resultDto;
        }
        resultDto = new ResultDto<>(-1);
        resultDto.setCode(-1);
        resultDto.setMessage("修改失败！");
        return resultDto;
    }


    //删除房产信息
    @PostMapping("/deleteCust")
    @ApiOperation(value = "删除房产信息")
    public ResultDto<Integer> deleteCust(@RequestBody CiUserAssetsDTO ciUserAssetsDTO) {
        ResultDto<Integer> resultDto = null;
        resultDto = new ResultDto<>(PCustBaseInfoService.deleteCust(ciUserAssetsDTO));
        resultDto.setCode(0);
        resultDto.setMessage("删除成功");
        return resultDto;
    }
}
