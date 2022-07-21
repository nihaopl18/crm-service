package cn.com.yusys.yusp.dycrm.userAcct.web.rest;

import cn.com.yusys.yscrm.cust.group.domain.CrmFCissCgBaseInfoDTO;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWork;
import cn.com.yusys.yusp.dycrm.todowork.service.OcrmFwpTodoWorkService;
import cn.com.yusys.yusp.dycrm.userAcct.domain.BaseInfo;
import cn.com.yusys.yusp.dycrm.userAcct.domain.TeamUserInfo;
import cn.com.yusys.yusp.dycrm.userAcct.service.UserAccountInfoService;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: dycrm-userAcct模块
 * @类名称: UserAccountInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-25 11:18:11
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */

@RestController
@RequestMapping("/api/useraccountinfo")
public class UserAccountInfoResource  extends CommonResource<OcrmFwpTodoWork, String> {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserAccountInfoService userAccountInfoService;

    @Override
    protected CommonService getCommonService() {
        return userAccountInfoService;
    }

    @GetMapping("/baseinfo")
    @Timed
    protected ResultDto<BaseInfo> getBaseInfo(String userId) {
        BaseInfo baseInfo = userAccountInfoService.getBaseInfo(userId);
        return new ResultDto<BaseInfo>(1,baseInfo);
    }

    @GetMapping("/teaminfo")
    @Timed
    protected ResultDto<Map<String,Object>> getTeamInfo(QueryModel model) {
        Map<String,Object> map = userAccountInfoService.getTeamInfo(model);
        int total = ((List<TeamUserInfo>)map.get("teamUser")).size();
        TeamUserInfo teamUserInfo = (TeamUserInfo) map.get("teamLeader");
        if (teamUserInfo != null){
            total += 1;
        }
        return new ResultDto<Map<String,Object>>(total,map);
    }

    @GetMapping("/contactDetails")
    @Timed
    protected ResultDto<Map<String,Object>> contactDetails(@RequestParam("loginCode") String loginCode) {
        return new ResultDto<Map<String,Object>>(userAccountInfoService.contactDetails(loginCode));
    }

    @PostMapping("/saveDetails")
    @Timed
    protected ResultDto<Integer> saveDetails(@RequestBody BaseInfo baseInfo) {
        return new ResultDto<Integer>(userAccountInfoService.saveDetails(baseInfo));
    }

    //修改用户id
    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "修改用户id")
    public ResultDto<Integer> updateUserInfo(@RequestBody Map<String,Object> map) {
        ResultDto<Integer> resultDto = null;
        String loginCode=String.valueOf(map.get("loginCode"));
        int num = userAccountInfoService.checkUpName(loginCode);
       if(num==1){
            resultDto = new ResultDto<>(userAccountInfoService.updateUserInfo(loginCode));
            resultDto.setCode(0);
            resultDto.setMessage("修改成功");
            return resultDto;
        }
        resultDto = new ResultDto<>(-1);
        resultDto.setCode(-1);
        resultDto.setMessage("修改失败，用户不存在");
        return resultDto;
    }
    //修改角色id
    @PostMapping("/updateRoleInfo")
    @ApiOperation(value = "修改角色id")
    public ResultDto<Integer> updateRoleInfo(@RequestBody Map<String,Object> map) {
        ResultDto<Integer> resultDto = null;
        String roleCode=String.valueOf(map.get("roleCode"));
        int num = userAccountInfoService.checkUpNameName(roleCode);
        if(num==1){
            resultDto = new ResultDto<>(userAccountInfoService.updateRoleInfo(roleCode));
            resultDto.setCode(0);
            resultDto.setMessage("修改成功");
            return resultDto;
        }
        resultDto = new ResultDto<>(-1);
        resultDto.setCode(-1);
        resultDto.setMessage("修改失败，角色不存在");
        return resultDto;
    }
    /**
     * @方法名称: getList
     * @方法描述: 分页查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querypage")
    public ResultDto<List<Map<String, Object>>> getList(QueryModel queryModel) {
        List<Map<String, Object>> list = userAccountInfoService.findAllByParam(queryModel);
        return new ResultDto<List<Map<String, Object>>>(list);
    }
}
