package cn.com.yusys.yscimc.assemble.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.marketmethod.service.CmicAppClickInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleCusts;
import cn.com.yusys.yscimc.assemble.service.CmicAppAssembleCustsService;

/**
 * @version 1.0.0
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleCustsResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: chenl
 * @创建时间: 2019-06-10 20:24:36
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmicappassemblecusts")
public class CmicAppAssembleCustsResource extends CommonResource<CmicAppAssembleCusts, String> {
    @Autowired
    private CmicAppAssembleCustsService cmicAppAssembleCustsService;

    @Autowired
    private CmicAppClickInfoService cmicAppClickInfoService;

    @Override
    protected CommonService getCommonService() {
        return cmicAppAssembleCustsService;
    }

    /**
     * @方法名称:create
     * @方法描述:自定义返回信息
     * @参数与返回说明:t：创建拼团所需的参数
     * @算法描述:重写CommonResource中的create方法
     */
    @Override
    protected ResultDto<CmicAppAssembleCusts> create(@RequestBody CmicAppAssembleCusts t) {
        ResultDto<CmicAppAssembleCusts> resultDto = new ResultDto<>();
        int flag = this.getCommonService().insert(t);
        if (flag == -1) {
            resultDto.setCode(-1);
            resultDto.setMessage("您已经参加过该活动！");
            return resultDto;
        }
        resultDto.setData(t);
        return resultDto;
    }

    /**
     * @方法名称:joinAssemble
     * @方法描述:加入拼团
     * @参数与返回说明:data：加入团队所需的信息
     * @算法描述:
     */
    @PostMapping("/joinassemble")
    public ResultDto<CmicAppAssembleCusts> joinAssemble(@RequestBody Map<String, String> data) {
        return cmicAppAssembleCustsService.joinAssemble(data);
    }

    /**
     * @方法名称:getAssembleByCusId
     * @方法描述:根据用户Id和actyId查询团信息
     * @参数与返回说明:custId:用户Id
     * @算法描述:
     */
    @GetMapping("/myassemble")
    public ResultDto<CmicAppAssembleCusts> getAssembleByCustId(@RequestParam("custId") String custId, @RequestParam("actyId") String actyId) {
        return new ResultDto<>(cmicAppAssembleCustsService.getAssembleByCustId(custId, actyId));
    }

    /**
     * @方法名称:getCustByActyid
     * @方法描述:根据活动id查询参与拼团客户信息
     * @参数与返回说明:actyId(活动id)
     * @算法描述:
     */
    @GetMapping("/actycusts")
    public ResultDto<List<Map<String, Object>>> getCustByActyid(@RequestParam(name = "actyId") String actyId) {
        return new ResultDto<List<Map<String, Object>>>(cmicAppAssembleCustsService.getCustByActyid(actyId));
    }

    /**
     * @方法名称:getAssembleNum
     * @方法描述:获取未满团信息
     * @参数与返回说明:活动id、拼团人数
     * @算法描述:
     */
    @GetMapping("/getassemblenum")
    public ResultDto<List<Map<String, Object>>> getAssembleNum(QueryModel queryModel) {
        Map<String, String> param = new HashMap<>();
        param.put("actyId", queryModel.getCondition().get("actyId").toString());
        param.put("assembleNum", queryModel.getCondition().get("assembleNum").toString());
        return new ResultDto<List<Map<String, Object>>>(cmicAppAssembleCustsService.getAssembleNum(param));
    }

    /**
     * @方法名称:addReward
     * @方法描述:被分享人点击链接后为分享人增加奖励
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping(value = "/addreward")
    public ResultDto<String> addReward(@RequestBody Map<String, Object> map) {
        //  String nodeId,String activityId, String recommenderId,String custId,String data

        // 调用裂变接口插入一条记录
        if (map.containsKey("activityId") && map.containsKey("recommenderId") && map.containsKey("custId")){
            cmicAppClickInfoService
                .clickinfo(map.get("activityId").toString(), map.get("recommenderId").toString(),
                    map.get("custId").toString(),
                    map.get("data").toString());
        } else {
            new ResultDto(-1, "参数错误！");
        }

        // TODO 调用拼团接口为分享人增加奖励（具体增加什么奖励需要读取配置)
        cmicAppAssembleCustsService.addReward(map);
        return new ResultDto<>();
    }
}
