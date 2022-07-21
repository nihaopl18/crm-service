package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.factory.SpringJobBeanFactory;
import cn.com.yusys.yusp.uimp.distribution.service.IPmaFComDepCommService;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFComDepAcctInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-20
 */
@Api(tags = "业绩分配接口")
@RestController
@RequestMapping("/api/PmaFComDepCommResource")
public class PmaFComDepCommResource extends CommonResource<PmaFComDepAcctInfo, String> {

    @Autowired
    private PmaFComDepAcctInfoService pmaFComDepAcctInfoService;

    @ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
    @GetMapping("/queryCommList")
    public ResultDto<List<Map<String, Object>>> queryCommList(QueryModel model) {

        Object workType = model.getCondition().get("workType");
        String wtype = getWorkType(workType);

        IPmaFComDepCommService workerService = getService(wtype);
        List<Map<String, Object>> list = workerService.queryCommList(model);

        return new ResultDto<List<Map<String, Object>>>(list);
    }

    @ApiOperation(value = "查询存款业绩分配历史(分页)", notes = "查询存款业绩分配历史(分页)")
    @GetMapping("/queryDepositHis")
    public ResultDto<List<Map<String, Object>>> queryDepositHis(QueryModel model) {

        Object workType = model.getCondition().get("workType");
        String wtype = getWorkType(workType);

        IPmaFComDepCommService workerService = getService(wtype);
        List<Map<String, Object>> list = workerService.queryHisList(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    @ApiOperation(value = "保存区间及详情", notes = "保存区间及详情")
    @PostMapping("/savePeriodAndDistribute")
    public ResultDto<Object>  savePeriodAndDistribute(@RequestBody Map<String, Object> map) throws Exception {

        Object workType = map.get("workType");
        String wtype = getWorkType(workType);

        IPmaFComDepCommService workerService = getService(wtype);
        return  workerService.savezbBean(map);

    }

    @ApiOperation(value = "发起审批", notes = "发起审批")
    @GetMapping("/executeApprove")
    public void executeApprove(Map<String, Object> map) {

        Object workType = map.get("workType");
        String wtype = "";
        if (null != workType && !"".equals(workType)) {
            wtype = workType.toString();
        }else{
            return ;
        }
        IPmaFComDepCommService workerService = getService(wtype);

        workerService.executeApprove(map);
    }

    private IPmaFComDepCommService getService(String wtype) {

        String whoClass = getTypeClass(wtype);
        IPmaFComDepCommService workerService = SpringJobBeanFactory.getBean(whoClass, IPmaFComDepCommService.class);
        return workerService;
    }

    private String getTypeClass(String wtype) {
        String whoClass = "";
        if (wtype.equals("1")) {
            whoClass = "PmaFComDepAcctInfoService";
        } else if (wtype.equals("2")) {
            whoClass = "PmaFComDepLoansInfoService";
        }
        return whoClass;
    }

    private String getWorkType(Object workType){
        String wtype = "";
        if (null != workType && !"".equals(workType)) {
            wtype = workType.toString();
        }else{
            return null;
        }
        return wtype;
    }
    @Override
    protected CommonService getCommonService() {
        return pmaFComDepAcctInfoService;
    }
}
